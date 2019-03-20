package com.qiyun.task;

import com.qiyun.DTO.PlanTicketDetail;
import com.qiyun.bonus.AwardDetailYc;
import com.qiyun.api.LotteryApi;
import com.qiyun.common.CommonStatus;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.commonModel.TradeType;
import com.qiyun.dto.Member2DTO;
import com.qiyun.foctory.SportteryBasketDgtzChaiPiao;
import com.qiyun.foctory.SportteryBasketHtChaiPiao;
import com.qiyun.foctory.SportteryFootballDgtzChaiPiao;
import com.qiyun.foctory.SportteryFootballHtChaiPiao;
import com.qiyun.model.PlanTicketStatus;
import com.qiyun.model.TicketStatus;
import com.qiyun.model.WinStatus;
import com.qiyun.model2.*;
import com.qiyun.service.*;
import com.qiyun.serviceImpl.TicketRestrictConfigServiceImpl;
import com.qiyun.ticket.TicketProvider;
import com.qiyun.util.BigDecimalUtil;
import com.qiyun.util.Constants;
import com.qiyun.util.LogUtil;
import com.qiyun.utils.DbDataVerify;
import com.qiyun.utils.NumberTools;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Lazy(value=false)
public class ChaiPiaoTask {

    private static Logger logger = LoggerFactory.getLogger(ChaiPiaoTask.class);

    @Autowired
    private SportteryFootballDgtzChaiPiao sportteryFootballDgtzChaiPiao;
    @Autowired
    private SportteryFootballHtChaiPiao sportteryFootballHtChaiPiao;
    @Autowired
    private SportteryBasketHtChaiPiao sportteryBasketHtChaiPiao;
    @Autowired
    private SportteryBasketDgtzChaiPiao sportteryBasketDgtzChaiPiao;
    @Resource
    private TicketRestrictConfigServiceImpl ticketRestrictConfigService;
    @Resource
    private MemberGrade2Service memberGrade2Service;
    @Resource
    private MemberService memberService;
    @Resource
    private LotteryPlanService lotteryPlanService;
    @Resource
    private TicketService ticketService;
    @Resource
    private TicketPrintService ticketPrintService;
    @Autowired
    private DGService dgService;
    @Autowired
    private LotteryApi lotteryApi;

    private List<Integer> lotteryTypes;

    public void setLotteryTypes(List<Integer> lotteryTypes) {
        this.lotteryTypes = lotteryTypes;
    }

    /**
     * 拆票
     */
//    @Scheduled(cron = "0/10 * * * * ? ") //10秒执行一次
    public void chaiPiao(){
        LogUtil.info("执行拆票");
        for (Integer type : lotteryTypes) {
            List<LotteryPlan2WithBLOBs> list = lotteryPlanService.getByIsAbleTicketingAndPlanTicketStatus(type, CommonStatus.YES.getValue(), PlanTicketStatus.NO_PROCESS.getValue());
            if (list==null || list.size()<=0 ){
                continue;
            }
            for (LotteryPlan2WithBLOBs lotteryPlan : list) {
                chaipiao(lotteryPlan);
            }
        }
    }

    private void chaipiao(LotteryPlan2WithBLOBs lotteryPlan) {
        if(lotteryPlan==null||lotteryPlan.getPlanTicketStatus() == PlanTicketStatus.TICKETING.getValue()) {
            return;
        }
        if(lotteryPlan.getTradeType() == TradeType.TRADE_BALANCE.getValue()) {//余额购买

            List<Ticket2WithBLOBs> ticketList = getTickeByLotteryPlan(lotteryPlan);
            Boolean flag = isSongPiao(lotteryPlan);
            for (Ticket2WithBLOBs ticket : ticketList) {
                if(flag) {
                    // 未送票 推到渠道
                    ticket.setStatus(TicketStatus.WSP.getValue());
                } else {
                    // 出票成功  自动
                    ticket.setStatus(TicketStatus.CPCG.getValue());
                }
                ticket.setProvider(TicketProvider.ALL.getValue());
                ticket.setWinStatus(WinStatus.NOT_RESULT.getValue());
                ticketService.insert(ticket);
            }
            // 修改方案状态
            lotteryPlan.setPlanTicketStatus(PlanTicketStatus.TICKETING.getValue());
            //增加方案受理时间
            lotteryPlan.setAcceptTime(new Date());
            lotteryPlan.setVerifyMd5(DbDataVerify.getLotteryPlan2Verify(lotteryPlan));
            lotteryPlanService.update(lotteryPlan);
            if (!flag){
                //添加打票表
                int dealTime = dgService.getDealTime();
                List<TicketPrint> list = ticketToPrint(ticketList);
                for (TicketPrint ticketPrint : list) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(lotteryPlan.getDealDateTime());
                    calendar.add(Calendar.MINUTE,dealTime);
                    ticketPrint.setCreateTime(new Date());
                    ticketPrint.setAccount(lotteryPlan.getAccount());
                    ticketPrint.setDealTime(calendar.getTime());
                    ticketPrint.setResidueCount(ticketPrint.getCount());
                    ticketPrintService.insert(ticketPrint);
                }
            }
        }
    }

    private List<TicketPrint> ticketToPrint(List<Ticket2WithBLOBs> ticketList) {
        int count = dgService.getChaiPiaoCount();
        Map<String, TicketPrint> voMap = new LinkedHashMap<String, TicketPrint>();
        for (Ticket2WithBLOBs ticket : ticketList) {
            TicketPrint ticketPrint = getTicketPrint(ticket);
            String key = ticketPrint.getContent()+ticketPrint.getAmount()+ticketPrint.getMultiple()+ticketPrint.getPasstype()+ticketPrint.getLotteryType();
            if (voMap.containsKey(key)){
                TicketPrint oldTicketPrint = voMap.get(key);
                oldTicketPrint.setAmount(oldTicketPrint.getAmount()+ticketPrint.getAmount());
                oldTicketPrint.setBonus(BigDecimalUtil.add(oldTicketPrint.getBonus(),ticketPrint.getBonus()));
                oldTicketPrint.setCount(oldTicketPrint.getCount()+1);
            }else {
                voMap.put(key, ticketPrint);
            }
        }
        List<TicketPrint> list = new ArrayList<TicketPrint>(voMap.values());
        List<TicketPrint> arr = new ArrayList<TicketPrint>();
        for (TicketPrint ticketPrint : list) {
            if (ticketPrint.getCount()>count){
                int i = ticketPrint.getCount() / count;
                int j = ticketPrint.getCount() - count * i;
                TicketPrint a = toNewTicketPrint(ticketPrint,count);
                for (int k = 0; k < i; k++) {
                     arr.add(a);
                }
                if (j>0){
                    TicketPrint b = toNewTicketPrint(ticketPrint,j);
                    arr.add(b);
                }
            }else{
                arr.add(ticketPrint);
            }
        }
        return arr;
    }

    private TicketPrint toNewTicketPrint(TicketPrint ticketPrint, int count) {
        TicketPrint a = new TicketPrint();
        a.setAccount(ticketPrint.getAccount());
        a.setPlanNo(ticketPrint.getPlanNo());
        a.setContent(ticketPrint.getContent());
        a.setPasstype(ticketPrint.getPasstype());
        a.setAmount(ticketPrint.getAmount()/ticketPrint.getCount()*count);
        a.setMultiple(ticketPrint.getMultiple());
        a.setBonus(BigDecimalUtil.round(ticketPrint.getBonus().doubleValue()/ticketPrint.getCount()*count));
        a.setCount(count);
        a.setStatus(ticketPrint.getStatus());
        a.setResidueCount(count);
        a.setCreateTime(ticketPrint.getCreateTime());
        return a;
    }

    private TicketPrint getTicketPrint(Ticket2WithBLOBs ticket) {
        TicketPrint ticketPrint = new TicketPrint();
        String content = ticket.getContent();
        JSONArray jsonArray = new JSONArray();
        JSONObject contentObj = JSONObject.fromObject(content);
        JSONArray matchItems = contentObj.optJSONArray("matchItems");
        String passType = contentObj.optString("passType");
        ticketPrint.setAmount(ticket.getAmount());
        ticketPrint.setCount(1);
        ticketPrint.setMultiple(ticket.getMultiple());
        ticketPrint.setPlanNo(ticket.getPlanNo());
        ticketPrint.setPasstype(passType);
        ticketPrint.setCount(1);
        double sp = 1;
        for (Object matchItem : matchItems) {
            JSONObject option = new JSONObject();
            JSONObject matchItemObj = JSONObject.fromObject(matchItem);
            String intTime = matchItemObj.optString("intTime");
            String lineId = matchItemObj.optString("lineId");
            JSONArray options = matchItemObj.optJSONArray("options");
            int type = JSONObject.fromObject(options.get(0)).optInt("type");
            String typeValueStr = JSONObject.fromObject(options.get(0)).optString("typeValueStr");
            String value = JSONObject.fromObject(options.get(0)).optString("value");
            String award = JSONObject.fromObject(options.get(0)).optString("award");
            option.put("intTime",intTime);
            option.put("lineId",lineId);
            option.put("type",type);
            option.put("typeValueStr",typeValueStr);
            option.put("value",value);
            option.put("award",award);
            jsonArray.add(option);
            sp = sp * Double.parseDouble(award);
        }
        ticketPrint.setBonus(BigDecimalUtil.round(sp * ticketPrint.getAmount()));
        ticketPrint.setContent(jsonArray.toString());
        ticketPrint.setStatus(0);
        ticketPrint.setLotteryType(ticket.getLotteryType());
        Member2DTO member = memberService.getByAccount(ticket.getAccount());
        Map<String, Object> accountMap = lotteryApi.getDlAndQdAccount(member);
        if ((Integer)accountMap.get(Constants.CODE)==200){
            ticketPrint.setDlAccount(accountMap.get("dlAccount")==null?"":accountMap.get("dlAccount").toString());
            ticketPrint.setQdAccount(accountMap.get("qdAccount")==null?"":accountMap.get("qdAccount").toString());
        }
        return ticketPrint;
    }

    private List<Ticket2WithBLOBs> getTickeByLotteryPlan(LotteryPlan2WithBLOBs lotteryPlan) {
        List<Ticket2WithBLOBs> ticketList = null;
        switch (lotteryPlan.getLotteryType()){
            case 43: //篮球混投
                try {
                    ticketList = sportteryBasketHtChaiPiao.chaiPiao(lotteryPlan);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 304: //篮球单关
                try {
                    ticketList = sportteryBasketDgtzChaiPiao.chaiPiao(lotteryPlan);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 42: //足球混投
//            case 49: //足球胜平负/让球
                try {
                    ticketList = sportteryFootballHtChaiPiao.chaiPiao(lotteryPlan);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 303: //足球单关
                try {
                    ticketList = sportteryFootballDgtzChaiPiao.chaiPiao(lotteryPlan);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
           /* case  35: //足球比分
            case  36: //足球进球数
            case  37: //足球半全场
                try {
                    ticketList = sportteryBasketHtChaiPiao.chaiPiao(lotteryPlan);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;*/
        }
        return ticketList;
    }

    private Boolean isSongPiao(LotteryPlan2WithBLOBs plan) {
        String account = plan.getAccount();
        Integer lotteryType = plan.getLotteryType();
        Integer isSuperMan = plan.getIsSuperMan();
        MemberGrade2 byAccount = memberGrade2Service.getByAccount(account);
        if (byAccount == null) {
            return false;
        }

        //判断机器人
        Member2DTO member2 = memberService.getByAccount(account);
        if (member2.getType() == 2) {
            return false;
        }

        if (!LotteryType.JCLQList.contains(LotteryType.getItem(lotteryType))
                && !LotteryType.JCZQList.contains(LotteryType.getItem(lotteryType))) {
            return true;
        }

        if (byAccount.getIsProviderTicket() == 1) {
            //直接出票
           return true;
        }

        TicketRestrictConfig2 byIsSuper = ticketRestrictConfigService.getByIsSuper(isSuperMan);
        if (byIsSuper.getStatus() == 2) {
            //自动出票
            return false;
        }
        if (byIsSuper.getStatus() == 3) {
            //渠道
            return true;
        }
        if (byIsSuper.getStatus() == 1) {
            //判断
            if (plan.getAmount() > byIsSuper.getAmount()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }


    public void setSportteryBasketHtChaiPiao(SportteryBasketHtChaiPiao sportteryBasketHtChaiPiao) {
        this.sportteryBasketHtChaiPiao = sportteryBasketHtChaiPiao;
    }

    public void setSportteryBasketDgtzChaiPiao(SportteryBasketDgtzChaiPiao sportteryBasketDgtzChaiPiao) {
        this.sportteryBasketDgtzChaiPiao = sportteryBasketDgtzChaiPiao;
    }

    public void setSportteryFootballDgtzChaiPiao(SportteryFootballDgtzChaiPiao sportteryFootballDgtzChaiPiao) {
        this.sportteryFootballDgtzChaiPiao = sportteryFootballDgtzChaiPiao;
    }

    public void setSportteryFootballHtChaiPiao(SportteryFootballHtChaiPiao sportteryFootballHtChaiPiao) {
        this.sportteryFootballHtChaiPiao = sportteryFootballHtChaiPiao;
    }
}
