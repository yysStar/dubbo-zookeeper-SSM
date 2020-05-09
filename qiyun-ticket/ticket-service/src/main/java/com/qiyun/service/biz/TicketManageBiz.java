package com.qiyun.service.biz;

import com.github.pagehelper.PageInfo;
import com.google.common.base.Joiner;
import com.qiyun.DTO.*;
import com.qiyun.api.TicketManageApi;
import com.qiyun.dto.MemberDTO;
import com.qiyun.httpUtil.JsonUtil;
import com.qiyun.httpUtil.ZipHttpUtil;
import com.qiyun.model.*;
import com.qiyun.model.LotteryType;
import com.qiyun.model2.*;
import com.qiyun.service.*;
import com.qiyun.service2.Ticket2Service;
import com.qiyun.tools.DateTools;
import com.qiyun.tools.NumberTools;
import com.qiyun.tools.TicketTools;
import com.qiyun.type.TicketStatus;
import com.qiyun.util.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

@Service("ticketManageApi")
public class TicketManageBiz implements TicketManageApi{
    private static Logger logger = LoggerFactory.getLogger(TicketManageBiz.class);

    @Resource
    private ConfigService configService;

    @Resource
    private TicketRestrictConfigService ticketRestrictConfigService;

    @Autowired
    private TicketBusinessService ticketbusinessService;

    @Autowired
    private LotteryTypeService lotteryTypeService;

    @Autowired
    private TicketRestrictService ticketRestrictService;

    @Autowired
    private LotteryPlanService lotteryPlanService;

    @Autowired
    private PlanTicketMappingService planTicketMappingService;

    @Autowired
    private TicketFindService ticketFindService;

    @Autowired
    private Ticket2Service ticket2Service;

    @Autowired
    private MemberService memberService;

    @Autowired
    private TicketNotifyService ticketNotifyService;

    /**
     * 票查询
     * @param
     * @return
     */
    public Map<String, Object> searchTicket(Integer type,Integer provider,String term,String startTerm,String endTerm,Integer id,Integer planNo,Integer playType,Integer isBingo,Integer status,String createDateTimeStart,String createDateTimeEnd,String printDateTimeStart,String printDateTimeEnd,String sendTicketDateTimeStart,String sendTicketDateTimeEnd,Integer offset,Integer pageSize) {
        return ticket2Service.searchTicket(type,provider,term,startTerm,endTerm,id,planNo,playType,isBingo,status,createDateTimeStart,createDateTimeEnd,printDateTimeStart,printDateTimeEnd,sendTicketDateTimeStart,sendTicketDateTimeEnd,offset,pageSize);
    }

    public Map<String, Object> getList(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            int offset = Integer.parseInt(reqMap.get("offset").toString());
            int pageSize = Integer.parseInt(reqMap.get("pageSize").toString());
            List<TicketBusiness> businessList = ticketbusinessService.getPreList();
//            List<LotteryBusinessDTO> lotteryBusinessList =
//                    lotteryTypeService.getLotteryBusinessList(offset, pageSize);
            PageInfo<LotteryBusinessDTO> lotteryBusinessList =
                    lotteryTypeService.getPageLotteryBusinessList(offset, pageSize);
            map.put("businessList", businessList);
            map.put("lotteryBusinessList", lotteryBusinessList);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
        } catch (Exception e){
            logger.error("----------查询失败",e);
            map.put(Constants.CODE, Constants.ERROR_CODE_5);
            map.put(Constants.MSG, Constants.ERROR_MSG_5_2);
        }
        return map;
    }

    /**
     * 更换票务接口服务商
     * @param reqMap
     * @return
     */
    public Map<String, Object> updateBusiness(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        int businessId = Integer.parseInt(reqMap.get("businessId").toString());
        int typeId = Integer.parseInt(reqMap.get("typeId").toString());
        LotteryType lotteryType = lotteryTypeService.getById(typeId);
        if(lotteryType == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_3);
            return map;
        }
        lotteryType.setTicketId(businessId);
        lotteryTypeService.updateByPrimaryKeySelective(lotteryType);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        return map;
    }

    /**
     * 获取出票校验参数
     * @return
     */
    public Map<String, Object> getRestrict() {
        Map<String, Object> map = new HashMap<String, Object>();
        TicketRestrict ticketRestrict = ticketRestrictService.getByEffective();
        if(ticketRestrict == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_5);
            map.put(Constants.MSG, Constants.ERROR_MSG_5_2);
            return map;
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put("ticketRestrict", ticketRestrict);
        return map;
    }

    /**
     * 修改校验信息
     * @param reqMap
     * @return
     */
    public Map<String, Object> updateRestrict(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        int id = Integer.parseInt(reqMap.get("id").toString());
        String lotIds = (String) reqMap.get("lotIds");
        String credit = (String) reqMap.get("credit");
        String sp = (String) reqMap.get("sp");
        TicketRestrict ticketRestrict = ticketRestrictService.getById(id);
        if(ticketRestrict == null){
            logger.error("------------ticketRestrict：" + ticketRestrict);
            map.put(Constants.CODE, Constants.ERROR_CODE_5);
            map.put(Constants.MSG, Constants.ERROR_MSG_5_2);
            return map;
        }
        TicketRestrict restrict = TicketRestrict.builder()
                .lotIds(StringUtils.isNullOrBlank(lotIds) ? ticketRestrict.getLotIds() : lotIds)
                .credit(StringUtils.isNullOrBlank(credit) ? ticketRestrict.getCredit() : new BigDecimal(credit))
                .sp(StringUtils.isNullOrBlank(sp) ? ticketRestrict.getSp() : new BigDecimal(sp))
                .build();
        ticketRestrict.setIsEffective(false);
        //老的校验失效
        ticketRestrictService.updateByPrimaryKeySelective(ticketRestrict);
        //创建新的校验
        ticketRestrictService.insertSelective(restrict);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        return map;
    }

    /**
     * 设置方案状态
     * @param reqMap
     * @return
     */
    public Map<String, Object> updatePlanStatus(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        int planNo = Integer.parseInt(reqMap.get("planNo").toString());
        int status = Integer.parseInt(reqMap.get("status").toString());
        LotteryPlanWithBLOBs lotteryPlan = lotteryPlanService.getByPlanNo(planNo);
        if(lotteryPlan == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_5);
            map.put(Constants.MSG, Constants.ERROR_MSG_5_3);
            return map;
        }
        lotteryPlan.setPlanStatus(status);
        lotteryPlanService.updatePlanTicketStatus(lotteryPlan);
        return null;
    }

    /**
     * 寻票
     * @param planNo
     * @param account
     * @return
     */
    public Map<String, Object> putMatchTicketBySys(int planNo, String account) {
        Map<String, Object> map = new HashMap<String, Object>();
        LotteryPlanWithBLOBs lotteryPlan = lotteryPlanService.getByPlanNo(planNo);
        if(lotteryPlan == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_5);
            map.put(Constants.MSG, Constants.ERROR_MSG_5_3);
            return map;
        }
        MemberDTO memberDTO = memberService.getByAccount(account);
        MemberDTO memberDTO2 = memberService.getByAccount(lotteryPlan.getAccount());
        if(memberDTO2.getSourceId() != memberDTO.getId()){
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_12);
            return map;
        }
        List<Ticket2WithBLOBs> tickets = ticket2Service.getByPlanNo(planNo);
        if(tickets.size() == 0){
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_8);
            return map;
        }
        TicketFind ticket= ticketFindService.getByPlanNo(planNo);
        if(ticket != null){
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_9);
            return map;
        }
        if(DateUtil.isFindTime(lotteryPlan.getCreateDateTime(), lotteryPlan.getDealDateTime())){
            //是否符合寻票要求
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            List<PlanTicketMapping> ticketMappings = planTicketMappingService.getByPlanNo(planNo);
            TicketFind ticketFind = TicketFind.builder().findTime(new Date()).isFind(true).planNo(planNo).build();
            ticketFindService.insertSelective(ticketFind);
            if(ticketMappings.size() > 0){ //已送票的直接返回成功
                return map;
            }
            MemberDTO member = memberService.getByAccount(lotteryPlan.getAccount());
            if(member == null){
                map.put(Constants.CODE, Constants.ERROR_CODE_2);
                map.put(Constants.MSG, Constants.ERROR_MSG_6_8);
                return map;
            }
            UserProfileDTO userProfileDTO = TicketBiz.getUserProfile(member);
            //如果为系统自动出票则送票
            JSONObject resJo = songPiao(lotteryPlan, userProfileDTO);
            if(!isSuccess(resJo)){
                map.put(Constants.CODE, Constants.ERROR_CODE_6);
                map.put(Constants.MSG, Constants.ERROR_MSG_6_8);
                return map;
            }
            //方案置为送票状态
            lotteryPlan.setPlanTicketStatus(2);
            lotteryPlanService.updatePlanTicketStatus(lotteryPlan);
            for(Ticket2WithBLOBs t : tickets){ //把票改为出票中
                t.setStatus(3);
                t.setSendDateTime(new Date());//处理时间
                ticket2Service.update(t);
            }
            return map;
        }
        TicketFind ticketFind = TicketFind.builder().findTime(new Date()).isFind(false).planNo(planNo).build();
        ticketFindService.insertSelective(ticketFind);
        map.put(Constants.CODE, Constants.ERROR_CODE_6);
        map.put(Constants.MSG, Constants.ERROR_MSG_6_8);
        return map;
    }

    /**
     * 送票
     * @param reqMap
     * @return
     */
    public Map<String, Object> deliverTicket(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        int planNo = Integer.parseInt(reqMap.get("planNo").toString());
        TicketFind ticket= ticketFindService.getByPlanNo(planNo);
        if(ticket.getIsFind()){
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_9);
            return map;
        }
        List<PlanTicketMapping> ticketMappings = planTicketMappingService.getByPlanNo(planNo);
        if(ticketMappings.size() > 0){
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_9);
            return map;
        }
        List<Ticket2WithBLOBs> tickets = ticket2Service.getByPlanNo(planNo);
        if(tickets.size() == 0){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_7);
            return map;
        }
        LotteryPlanWithBLOBs lotteryPlan = lotteryPlanService.getByPlanNo(planNo);
        if(lotteryPlan == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_5);
            map.put(Constants.MSG, Constants.ERROR_MSG_5_3);
            return map;
        }
        MemberDTO member = memberService.getByAccount(lotteryPlan.getAccount());
        if(member == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_3);
            return map;
        }
        UserProfileDTO userProfileDTO = TicketBiz.getUserProfile(member);
        //送票
        JSONObject resJo = songPiao(lotteryPlan, userProfileDTO);
        if(!isSuccess(resJo)){
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_7);
            return map;
        }
        //改为寻票成功
        ticket.setIsFind(true);
        ticketFindService.update(ticket);
        //方案置为送票状态
        lotteryPlan.setPlanTicketStatus(2);
        lotteryPlanService.updatePlanTicketStatus(lotteryPlan);
        for(Ticket2WithBLOBs t : tickets){ //把票改为出票中
            t.setStatus(3);
            t.setSendDateTime(new Date());//处理时间
            ticket2Service.update(t);
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        return map;
    }

    private boolean isSuccess(JSONObject resJo) {
        if(resJo == null){
            return false;
        }
        JSONObject body =
                resJo.optJSONObject("body");
        JSONObject ActionResult =
                body.optJSONObject("ActionResult");
        if("0000".equals(ActionResult.optString("@wCode"))) {
            return true;
        }
        logger.debug("-----------错误原因：" + ActionResult.optString("@wRltMsg"));
        return false;
    }

    /**
     * 查询寻票列表
     * @param reqMap
     * @return
     */
    public Map<String, Object> findTicketList(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        int offset = Integer.parseInt(reqMap.get("offset").toString());
        int pageSize = Integer.parseInt(reqMap.get("pageSize").toString());
        PageInfo<TicketFindDTO> list = ticketFindService.getAll(offset, pageSize);
        map.put("findTicketList", list);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        return map;
    }

    /**
     * 查询票务出票情况
     * @param planNo
     * @param businessType
     * @return
     */
    public Map<String, Object> getTicketResultByPlanNo(int planNo, int businessType) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<String> orderIdList = new ArrayList<String>();
        List<Ticket2WithBLOBs> tickets = ticket2Service.getByPlanNo(planNo);
        if(tickets.size() == 0){
            map.put(Constants.CODE, Constants.ERROR_CODE_5);
            map.put(Constants.MSG, Constants.ERROR_MSG_5_3);
            return map;
        }
        for(Ticket2WithBLOBs ticket : tickets){
            PlanTicketMapping mapping = planTicketMappingService.getByTicketId(ticket.getId());
            if(mapping != null) {
                orderIdList.add(mapping.getOrderId());
                Ticket2WithBLOBs ticket2 = ticket2Service.getById(ticket.getId());
                ticket2.setOutId(mapping.getOrderId());
                ticket2Service.update(ticket2);
            }
        }
        if(orderIdList.size() == 0){
            map.put(Constants.CODE, Constants.ERROR_CODE_5);
            map.put(Constants.MSG, Constants.ERROR_MSG_5_3);
            return map;
        }
        JSONObject reqJo = new JSONObject();
        JSONObject resJo = null;
        String string = Joiner.on(",").join(orderIdList);
        switch (businessType){
            case 0:
                reqJo.put("orderIdList", string);
                //请求通彩易麦接口
                String s = TicketUtil.getTcymRes(reqJo, TicketTools.matchTicketResult);//接口编号
                resJo = JSONObject.fromObject(s);
                break;
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.DATA, resJo);
        //如果通知没到的话就把查到的数据插入数据库
        ticketNotifyService.builderNotify(resJo);
        return map;
    }

    /**
     * 修改方案中票为出票状态
     * @param planNo
     * @return
     */
    public Map<String, Object> updateTicketStatus(int planNo) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Ticket2WithBLOBs> tickets = ticket2Service.getByPlanNo(planNo);
        LotteryPlan lotteryPlan = lotteryPlanService.getByPlanNo(planNo);
        if(tickets.size() == 0){
            map.put(Constants.CODE, Constants.ERROR_CODE_5);
            map.put(Constants.MSG, Constants.ERROR_MSG_5_3);
            return map;
        }
        for(Ticket2WithBLOBs ticket : tickets){
            if(lotteryPlan.getPlanStatus() == 3 && lotteryPlan.getPlanTicketStatus() == 2) {
                ticket.setStatus(3);
                ticket2Service.update(ticket);
            }
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> addTicketConfig(double amount, double bonus, int isSuper, int status) {
        Map<String,Object> map = new HashMap<String,Object>();
        TicketRestrictConfig2 ticketRestrictConfig2 = new TicketRestrictConfig2();
        ticketRestrictConfig2.setIsSuper(isSuper);
        ticketRestrictConfig2.setAmount(amount);
        ticketRestrictConfig2.setBonus(bonus);
        ticketRestrictConfig2.setStatus(status);
        ticketRestrictConfigService.update(ticketRestrictConfig2);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> getTicketConfig(int isSuper) {
        TicketRestrictConfig2 ticketRestrictConfig2 = ticketRestrictConfigService.getByIsSuper(isSuper);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,ticketRestrictConfig2);
        return map;
    }


    public Map<String, Object> findTicket(int planNo, String account, int type) {
        Map<String,Object> map = new HashMap<String,Object>();
        LotteryPlanWithBLOBs plan = lotteryPlanService.getByPlanNo(planNo);
        if (plan==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,Constants.ERROR_MSG_400);
            return map;
        }

        MemberDTO YHMember = memberService.getByAccount(plan.getAccount());
        if (type==1) {
            //代理寻票
            MemberDTO DLMember = memberService.getByAccount(account);
            if (YHMember == null || DLMember == null) {
                map.put(Constants.CODE, Constants.ERROR_CODE_400);
                map.put(Constants.MSG, Constants.ERROR_MSG_400);
                return map;
            }
            if (YHMember.getSourceId().intValue()!=DLMember.getId().intValue() && !plan.getAccount().equals(account)){
                map.put(Constants.CODE, Constants.ERROR_CODE_6);
                map.put(Constants.MSG, Constants.ERROR_MSG_6_12);
                return map;
            }
        }
        //运营或高级权限寻票
        TicketFindNew2 ticketFindNew2 = ticketFindService.getByPlanNoNew(planNo);
        if (ticketFindNew2!=null){
            //已经寻票
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_9);
            return map;
        }
        //第一次寻票
        ticketFindNew2 = new TicketFindNew2();
        ticketFindNew2.setKhAccount(plan.getAccount());
        ticketFindNew2.setXpAccount(account);
        ticketFindNew2.setFindTime(new Date());
        ticketFindNew2.setPlanNo(planNo);
        ticketFindNew2.setType(type);

        //是否在寻票时间内
        if (DateUtil.isFindTime(plan.getCreateDateTime(), plan.getDealDateTime())){
            ticketFindNew2.setStatus(true);
        }else{
            ticketFindNew2.setStatus(false);
        }
        List<PlanTicketMapping> byPlanNo = planTicketMappingService.getByPlanNo(planNo);
        if (byPlanNo==null || byPlanNo.size()<=0){
            //自动  可以抄单
            ticketFindNew2.setCopyStatus(1);
        }else{
            //渠道 不能抄单
            ticketFindNew2.setCopyStatus(0);
            ticketFindNew2.setTicketStatus(plan.getPlanStatus());
        }
        ticketFindService.insertSelectiveNew(ticketFindNew2);

        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);

        Integer getLess5Auto = configService.getLess5Auto();
        Integer getMore5Auto = configService.getMore5Auto();
        Boolean autoCopy = false;
        if (ticketFindNew2.getFindTime().getTime()-new Date().getTime()<300000){
            //5分钟内
            if (getLess5Auto==1){
                //自动抄单
                autoCopy = true;
            }
        }else{
            //5分钟外
            if (getMore5Auto==1){
                //自动抄单
                autoCopy = true;
            }
        }

        if (autoCopy){
            //抄单
            JSONObject jo = new JSONObject();
            jo.put("planNo", plan.getPlanNo());
            String result = ZipHttpUtil.sendGetHttp("http://lottery.api.qiyun88.cn/lottery/copyPlan", jo);
//            String result = ZipHttpUtil.sendGetHttp("lottery.api.qyun88.com/lottery/copyPlan", jo);
            JSONObject resObj = JSONObject.fromObject(result);
            if(resObj == null || resObj.optInt("error_code") != 200) {
                map.put(Constants.CODE, Constants.ERROR_CODE_425);
                map.put(Constants.MSG, Constants.ERROR_MSG_425);
            } else {
                ticketFindNew2.setCopyStatus(0);
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
            }
        }
        if (!ticketFindNew2.getStatus()){
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_8);
        }
        return map;
    }

    public Map<String, Object> findTicketList2(int type, String account, int planNo,int page,int pageSize) {
        return ticketFindService.findTicketList2(type,account,planNo,page,pageSize);
    }

    public Map<String, Object> getPlanTicketDetail(int planNo) {
        Map<String,Object> map = new HashMap<String,Object>();
        List<Ticket2WithBLOBs> tickets = ticket2Service.getByPlanNo(planNo);
        List<PlanTicketDetail> planTicketDetails = ticketToDetail(tickets);
        Map<String, PlanTicketDetail> voMap = new LinkedHashMap<String, PlanTicketDetail>();
        for (PlanTicketDetail planTicketDetail : planTicketDetails) {
            String key = planTicketDetail.getOption().toString()+planTicketDetail.getStatus()+planTicketDetail.getMultiple();
            if (voMap.containsKey(key)) {
                PlanTicketDetail oldPlanTicketDetail = voMap.get(key);
                oldPlanTicketDetail.setAmount(oldPlanTicketDetail.getAmount()+planTicketDetail.getAmount());
                oldPlanTicketDetail.setBonus(NumberTools.round(oldPlanTicketDetail.getBonus()+planTicketDetail.getBonus(),2));
                oldPlanTicketDetail.setCount(oldPlanTicketDetail.getCount()+planTicketDetail.getCount());
            } else {
                voMap.put(key, planTicketDetail);
            }
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,voMap.values());
        return map;
    }

    public List<PlanTicketDetail> ticketToDetail(List<Ticket2WithBLOBs> tickets){
        if (tickets==null || tickets.size()<=0){
            return null;
        }
        List<PlanTicketDetail> list = new ArrayList<PlanTicketDetail>();
        for (Ticket2WithBLOBs ticket : tickets) {
            JSONObject content = JSONObject.fromObject(ticket.getContent());
            JSONArray matchItems = content.optJSONArray("matchItems");
            String multiple = content.optString("multiple");
            String passType = content.optString("passType");
            Map<String,Object> optionStr = getTicketOption(matchItems);
            List<String> option = (List<String>) optionStr.get("content");
            Double award = (Double) optionStr.get("award");

            Integer amount = ticket.getAmount();
            PlanTicketDetail planTicketDetail = new PlanTicketDetail();
            planTicketDetail.setOption(option);
            planTicketDetail.setAmount(amount);
            planTicketDetail.setBonus(NumberTools.round(amount*award,2));
            planTicketDetail.setMultiple(Integer.parseInt(multiple));
            planTicketDetail.setPassType(LotteryUtils.getPassType(passType));
            planTicketDetail.setStatus(TicketStatus.getItem(ticket.getStatus()).getName());
            planTicketDetail.setCount(1);
            list.add(planTicketDetail);
        }
        return list;
    }

    public Map<String,Object> getTicketOption(JSONArray matchItems) {
        Map<String,Object> map = new HashMap<String,Object>();
        List<String> list = new ArrayList<String>();
        double award = 1;

        for (Object matchItemObj : matchItems) {
            StringBuffer sb = new StringBuffer();
            JSONObject matchItem = JSONObject.fromObject(matchItemObj);
            JSONObject fbValueStrMap = matchItem.optJSONObject("fbValueStrMap");
            String intTime = matchItem.optString("intTime");
            String lineId = matchItem.optString("lineId");
            String weekStr = DateTools.getWeekStrByIntTime(intTime);
            lineId = com.qiyun.tools.NumberTools.getLineId(lineId);
            sb.append(weekStr+lineId+" ");
            Iterator iterator = fbValueStrMap.keys();

            String play = (String) iterator.next(); //玩法
            String value = fbValueStrMap.getString(play); //选项+sp
            JSONArray jsonArray = (JSONArray) JSONArray.fromObject(value).get(0);
            String key = (String) jsonArray.get(0);
            String sp = (String) jsonArray.get(1);

            JSONArray options = matchItem.optJSONArray("options");
            JSONObject o = (JSONObject) options.get(0);
            int type = o.optInt("type");
            String substring = com.qiyun.commonModel.LotteryType.getItem(type).getName().substring(4);

            sb.append(substring).append(":");
            sb.append(key).append("[").append(sp).append("]");
            award = award * Double.parseDouble(sp);

            list.add(sb.toString());
        }
        map.put("content",list);
        map.put("award",award);
        return map;
    }


    /**
     * 送票
     * @param lotteryPlan
     * @param userProfileDTO
     * @return
     */
    private JSONObject songPiao(LotteryPlan lotteryPlan, UserProfileDTO userProfileDTO) {
        List<Ticket2WithBLOBs> ticketList = ticket2Service.getByPlanNo(lotteryPlan.getPlanNo());
        List<MatchTicketDTO> matchTicketDTOS = new ArrayList<MatchTicketDTO>();
        JSONObject reqJo = new JSONObject();
        JSONObject resJo = null;
        for(Ticket2WithBLOBs ticket : ticketList){
            if(ticket != null) {
                String lotId = TicketTools.getLotIdByLotteryType(ticket.getLotteryType());
                MatchTicketDTO matchTicketDTO = TicketTools.ticketToBusiness(ticket, lotId, ticket.getAmount());
                //按通彩易麦要求生成内部票号
                String orderId = JsonUtil.getTcymId(TicketUtil.getTcymAgentID(), JsonUtil.OrderID);
                matchTicketDTO.setOrderId(orderId);PlanTicketMapping mapping = PlanTicketMapping.builder()
                        .planNo(lotteryPlan.getPlanNo()).orderId(orderId).createDatetime(new Date())
                        .ticketId(ticket.getId()).build();
                planTicketMappingService.insertSelective(mapping);
                matchTicketDTO.setUserProfilel(userProfileDTO);
                matchTicketDTOS.add(matchTicketDTO);
            }
        }
        reqJo.put("matchTicketList", matchTicketDTOS);
        //请求通彩易麦接口
        String s = TicketUtil.getTcymRes(reqJo, TicketTools.matchTicket);//接口编号
        resJo = JSONObject.fromObject(s);
        return resJo;
    }


    /**
     * 添加票务商需要的用户信息
     * @param member
     * @return
     */
    public static UserProfileDTO getUserProfile(MemberDTO member) {
        UserProfileDTO userProfile = new UserProfileDTO();
        userProfile.setUserName(TicketUtil.getTcymAgentID());
//        userProfile.setBonusPhone(member.getMobile());
        userProfile.setCardNumber(member.getCertNo());
        userProfile.setCardType(member.getCertType().toString());
//        userProfile.setMail(member.getEmail());
//        userProfile.setMobile(member.getMobile());
//        userProfile.setRealName(member.getName());
        return userProfile;
    }


}
