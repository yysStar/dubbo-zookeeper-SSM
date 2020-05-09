package com.qiyun.service.biz;

import com.google.common.base.Joiner;
import com.qiyun.DTO.*;
import com.qiyun.api.TicketApi;
import com.qiyun.common.DbDataVerify;
import com.qiyun.commonModel.LotteryTerm;
import com.qiyun.commonModel.Platform;
import com.qiyun.dto.MemberDTO;
import com.qiyun.dto.MemberWallet2DTO;
import com.qiyun.httpUtil.JsonUtil;
import com.qiyun.httpUtil.ZipHttpUtil;
import com.qiyun.jimi.IprotocolPortType;
import com.qiyun.jimi.IprotocolPortTypeProxy;
import com.qiyun.jimi.IprotocolSoapBindingStub;
import com.qiyun.model.*;
import com.qiyun.model.LotteryType;
import com.qiyun.model2.*;
import com.qiyun.service.*;
import com.qiyun.service2.MemberGrade2Service;
import com.qiyun.service2.Ticket2Service;
import com.qiyun.status.PlanStatus;
import com.qiyun.status.PlanTicketStatus;
import com.qiyun.tools.TicketTools;
import com.qiyun.type.TicketStatus;
import com.qiyun.type.WalletTransType;
import com.qiyun.util.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qiyun.model2.MemberWalletLine2;
import sun.security.krb5.internal.Ticket;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.*;

@Service("ticketApi")
public class TicketBiz implements TicketApi {
    private static Logger logger = LoggerFactory.getLogger(TicketBiz.class);
    private static String url = "http://ticket.api.qiyun88.cn/";
    @Resource
    private TicketFindService ticketFindService;

    @Resource
    private TicketLotteryMappingService ticketLotteryMappingService;

    @Resource
    private TicketRestrictConfigService ticketRestrictConfigService;

    @Resource
    private LotteryPlanAddPrizeService lotteryPlanAddPrizeService;

    @Autowired
    private LotteryTypeService lotteryTypeService;


    @Autowired
    private PlanTicketMappingService planTicketMappingService;

    @Autowired
    private LotteryPlanService lotteryPlanService;

    @Autowired
    private Ticket2Service ticket2Service;

    @Autowired
    private MemberService memberService;

    @Autowired
    private TicketRestrictService ticketRestrictService;

    @Autowired
    private MemberGrade2Service memberGrade2Service;

    @Autowired
    private TicketNotifyService ticketNotifyService;

    @Autowired
    private TicketNotifySpService ticketNotifySpService;

    /**
     * 竞彩赛事查询
     *
     * @param reqMap
     * @return
     */
    public Map<String, Object> getCompetitiveLotteryList(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        int type = Integer.parseInt(reqMap.get("type").toString());
        int businessType = Integer.parseInt(reqMap.get("businessType").toString());
        JSONObject reqJo = new JSONObject();
        reqJo.put("type", type);
        JSONObject resJo = null;
        switch (businessType) {
            case 0:
                //请求通彩易麦接口
                String s = TicketUtil.getTcymRes(reqJo, TicketTools.match);//接口编号
                resJo = JSONObject.fromObject(s);
                break;
        }
        if (resJo == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_4);
            return map;
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put("jcGameList", resJo);
        return map;
    }

    /**
     * 竞彩赛果查询
     *
     * @param reqMap
     * @return
     */
    public Map<String, Object> getCompetitiveLotteryResult(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        int type = Integer.parseInt(reqMap.get("type").toString());
        String id = (String) reqMap.get("id");
        int businessType = Integer.parseInt(reqMap.get("businessType").toString());
        JSONObject reqJo = new JSONObject();
        reqJo.put("type", type);
        reqJo.put("id", id);
        JSONObject resJo = null;
        switch (businessType) {
            case 0:
                //请求通彩易麦接口
                String s = TicketUtil.getTcymRes(reqJo, TicketTools.matchResult);//接口编号
                resJo = JSONObject.fromObject(s);
                break;
        }
        if (resJo == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_4);
            return map;
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put("jcResultList", resJo);
        return map;
    }

    /**
     * 竞彩赔率查询
     *
     * @param reqMap
     * @return
     */
    public Map<String, Object> getCompetitiveLotteryOdds(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        int type = Integer.parseInt(reqMap.get("type").toString());
        String id = (String) reqMap.get("id");
        // 0单关/1多关
        int valueType = Integer.parseInt(reqMap.get("valueType").toString());
        int businessType = Integer.parseInt(reqMap.get("businessType").toString());
        JSONObject reqJo = new JSONObject();
        reqJo.put("type", type);
        reqJo.put("id", id);
        reqJo.put("valueType", valueType);
        JSONObject resJo = null;
        switch (businessType) {
            case 0:
                //请求通彩易麦接口
                String s = TicketUtil.getTcymRes(reqJo, TicketTools.matchLossRatio);//接口编号
                resJo = JSONObject.fromObject(s);
                break;
        }
        if (resJo == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_4);
            return map;
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put("jcGameOdds", resJo);
        return map;
    }

    /**
     * 中奖文件查询
     *
     * @param reqMap
     * @return
     */
    public Map<String, Object> getCompetitiveLotteryFile(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        int type = Integer.parseInt(reqMap.get("type").toString());
        String id = (String) reqMap.get("id");
        int businessType = Integer.parseInt(reqMap.get("businessType").toString());
        JSONObject reqJo = new JSONObject();
        reqJo.put("type", type);
        reqJo.put("id", id);
        JSONObject resJo = null;
        switch (businessType) {
            case 0:
                //请求通彩易麦接口
                String s = TicketUtil.getTcymRes(reqJo, TicketTools.matchWinfile);//接口编号
                resJo = JSONObject.fromObject(s);
                break;
        }
        if (resJo == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_4);
            return map;
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put("jcGameFile", resJo);
        return map;
    }

    /**
     * 竞彩投注接口
     *
     * @param reqMap
     * @return
     */
    public Map<String, Object> putMatchTicket(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        String[] ticketIds = (String[]) reqMap.get("ticketIds");
        Integer planNo = (Integer) reqMap.get("planNo");

        LotteryPlanWithBLOBs lotteryPlan = lotteryPlanService.getByPlanNo(planNo);
        Integer lotteryType = lotteryPlan.getLotteryType();

        String account = lotteryPlan.getAccount();
        if (lotteryPlan == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_5);
            map.put(Constants.MSG, Constants.ERROR_MSG_5_3);
            return map;
        }

        MemberDTO member = memberService.getByAccount(account);
        if (member == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_3);
            return map;
        }
        //抄单转换身份证
        TicketFindNew2 ticketFindNew2 = ticketFindService.getByCopyPlanNo(planNo);
        if (ticketFindNew2 != null) {
            LotteryPlanWithBLOBs byPlanNo = lotteryPlanService.getByPlanNo(ticketFindNew2.getPlanNo());
            if (byPlanNo == null) {
                map.put(Constants.CODE, Constants.ERROR_CODE_400);
                map.put(Constants.MSG, Constants.ERROR_MSG_400);
                return map;
            }
            MemberDTO byAccount = memberService.getByAccount(byPlanNo.getAccount());
            if (byAccount == null) {
                map.put(Constants.CODE, Constants.ERROR_CODE_2);
                map.put(Constants.MSG, Constants.ERROR_MSG_2_3);
                return map;
            }
            member.setCertNo(byAccount.getCertNo());
        }


        List<PlanTicketMapping> list = planTicketMappingService.getByPlanNo(planNo);
        if (list.size() > 0) {
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_5);
            return map;
        }

        //获取票务商
        TicketLottreyMapping2 ticketLottreyMapping2 = ticketLotteryMappingService.getByLotteryType(lotteryType);
        int businessType = ticketLottreyMapping2==null?1:ticketLottreyMapping2.getTicketId();

        switch (businessType) {
            case 1: //通彩易麦
                tcymPutTicket(lotteryPlan, ticketIds, member, planNo);
                break;
            case 2: //云南吉米
                ynjmPutTicket(lotteryPlan, ticketIds, member, planNo);
                break;
        }

        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        return map;
    }

    private void ynjmPutTicket(LotteryPlanWithBLOBs lotteryPlan, String[] ticketIds, MemberDTO member, Integer planNo) {
        IprotocolPortType iprotocolPortType = new IprotocolPortTypeProxy();
        String agentIDagentID = "800162";
        String lotteryID = TicketUtil.getYnjmLotteryID(lotteryPlan.getLotteryType())+"";
        String msgs = "";
        for (String ticketId : ticketIds) {
            String msg = "";
            Ticket2WithBLOBs ticket = ticket2Service.getById(Integer.parseInt(ticketId));

            String ynjmTicketId = TicketUtil.getYnjmTicketId();

            JSONObject content = JSONObject.fromObject(ticket.getContent());
            int passType = Integer.parseInt(content.optString("passType").substring(1, 2));
            Integer amount = ticket.getAmount();
            Integer multiple = ticket.getMultiple();
            int zhushu = amount/multiple/2;

            String lotteryMsg = "";
            if (passType==1){
                lotteryMsg += "0";
            }else{
                lotteryMsg += passType + "*1^";
            }

            JSONArray matchItems = content.optJSONArray("matchItems");
            for (Object matchItem : matchItems) {
                String intTime = JSONObject.fromObject(matchItem).optString("intTime");
                String lineId = JSONObject.fromObject(matchItem).optString("lineId");

                if (Integer.parseInt(lineId)<10){
                    lineId = "00"+lineId;
                }else if (Integer.parseInt(lineId)<100){
                    lineId = "0"+lineId;
                }

                JSONArray options = JSONObject.fromObject(matchItem).optJSONArray("options");
                String option = "";
                for (int i = 0; i < options.size(); i++) {
                    if (com.qiyun.commonModel.LotteryType.JCZQList.contains(com.qiyun.commonModel.LotteryType.getItem(lotteryPlan.getLotteryType()))){
                        option += "F"+intTime+lineId+",";
                    }else if (com.qiyun.commonModel.LotteryType.JCLQList.contains(com.qiyun.commonModel.LotteryType.getItem(lotteryPlan.getLotteryType()))){
                        option += "B"+intTime+lineId+",";
                    }
                    String type = JSONObject.fromObject(options.get(i)).optString("type");
                    String value = TicketUtil.getYnjmOption(Integer.parseInt(type),JSONObject.fromObject(options.get(i)).optString("value"));
                    int ynjmLotteryID = TicketUtil.getYnjmLotteryID(Integer.parseInt(type));

                    if (i==0){
                        option += value;
                    }else{
                        option += "/";
                        option += value;
                    }
                    if (lotteryPlan.getLotteryType()==42 || lotteryPlan.getLotteryType()==43){
                        option += "-"+ynjmLotteryID;
                    }
                }
                lotteryMsg += option + "//";
            }
            lotteryMsg = lotteryMsg.substring(0,lotteryMsg.length()-2);

            msg = ynjmTicketId+"#"+lotteryMsg+"#"+zhushu+"#"+multiple+"#"+amount;
            msgs += msg +"|";

            PlanTicketMapping mapping = PlanTicketMapping.builder()
                    .planNo(planNo).orderId(ynjmTicketId).createDatetime(new Date())
                    .ticketId(Integer.parseInt(ticketId)).provider("云南吉米").build();
            planTicketMappingService.insertSelective(mapping);
        }
        msgs = msgs.substring(0,msgs.length()-1);

        String issue  = "";
        String sign = MD5.getMD5(agentIDagentID+lotteryID+issue+msgs+"ketaitest");
        String resp = "";

        try {
            resp = iprotocolPortType.betTicket(agentIDagentID, lotteryID, issue, msgs, sign);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (StringUtils.isNullOrBlank(resp)){
            return;
        }
        Document dom= null;
        try {
            dom = DocumentHelper.parseText(resp);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root=dom.getRootElement();
        Element header = root.element("header");
        if (!header.elementTextTrim("errorCode").equals("0")){
            //送票失败
            return;
        }

        Iterator iter = root.element("body").element("tickets").elementIterator();
        while(iter .hasNext()){
            Element recordEle  = (Element) iter.next();
            String ordersID = recordEle.elementTextTrim("ordersID");
            String errorCode = recordEle.elementTextTrim("errorCode");
            if (!errorCode.equals("0")) {
                continue;
            }
            //送票成功 修改票状态为未确认
            ticket2Service.updateTicketStatusForSongPiao(ordersID, TicketStatus.WDP.getValue());
        }
    }

    public void tcymPutTicket(LotteryPlanWithBLOBs lotteryPlan,String[] ticketIds,MemberDTO member,int planNo){
        UserProfileDTO userProfileDTO = getUserProfile(member);
        JSONObject reqJo = new JSONObject();
        JSONObject resJo = null;
        if (lotteryPlan.getLotteryType() == 1) {
            //大乐透
            List<TicketForNumberGameDTO> TicketForNumberGameDTOs = new ArrayList<TicketForNumberGameDTO>();
            IssueForNumberGameDTO issueForNumberGameDTO = new IssueForNumberGameDTO();
            for (String ticketId: ticketIds) {
                Ticket2WithBLOBs ticket = ticket2Service.getById(Integer.parseInt(ticketId));
                String lotId = TicketTools.getLotIdByLotteryType(lotteryPlan.getLotteryType());
                TicketForNumberGameDTO ticketForNumberGameDTO = TicketTools.getTicketForNumberGame(ticket, lotId);
                ticketForNumberGameDTO.setUserProfile(userProfileDTO);
                TicketForNumberGameDTOs.add(ticketForNumberGameDTO);
                issueForNumberGameDTO.setLotId(lotId);
                issueForNumberGameDTO.setNumber(ticket.getTerm());
            }
            NumberGameDTO numberGameDTO = new NumberGameDTO();
            numberGameDTO.setIssue(issueForNumberGameDTO);
            numberGameDTO.setTicket(TicketForNumberGameDTOs.toArray(new TicketForNumberGameDTO[TicketForNumberGameDTOs.size()]));
            reqJo.put("lotteryRequest", numberGameDTO);
            String s = TicketUtil.getTcymRes(reqJo, TicketTools.ticket);//接口编号
            resJo = JSONObject.fromObject(s);
        } else {
            //竞彩
            List<MatchTicketDTO> matchTicketDTOS = new ArrayList<MatchTicketDTO>();
            for (String ticketId: ticketIds) {
                Ticket2WithBLOBs ticket = ticket2Service.getById(Integer.parseInt(ticketId));
                if (ticket != null) {
                    String lotId = TicketTools.getLotIdByLotteryType(ticket.getLotteryType());
                    MatchTicketDTO matchTicketDTO = TicketTools.ticketToBusiness(ticket, lotId, ticket.getAmount());
                    //按通彩易麦要求生成内部票号
                    String a = TicketUtil.getTcymAgentID();
                    String b = JsonUtil.OrderID;
                    String orderId = JsonUtil.getTcymId(a, b);
                    matchTicketDTO.setOrderId(orderId);
                    PlanTicketMapping mapping = PlanTicketMapping.builder()
                            .planNo(planNo).orderId(orderId).createDatetime(new Date())
                            .ticketId(Integer.parseInt(ticketId)).provider("通彩易麦").build();
                    planTicketMappingService.insertSelective(mapping);
                    matchTicketDTO.setUserProfilel(userProfileDTO);
                    matchTicketDTOS.add(matchTicketDTO);
                }
            }
            reqJo.put("matchTicketList", matchTicketDTOS);
            //请求通彩易麦接口
            String s = TicketUtil.getTcymRes(reqJo, TicketTools.matchTicket);//接口编号
            resJo = JSONObject.fromObject(s);
        }
        if (resJo == null) {
            return ;
        }
        JSONObject body = resJo.optJSONObject("body");
        JSONObject ActionResult = body.optJSONObject("ActionResult");
        if ("0000".equals(ActionResult.optString("@wCode"))) {
            updateForTicketSuccess(lotteryPlan);
        }else{
            updateForTicketFail(lotteryPlan);
        }

    }

    public void updateForTicketSuccess(LotteryPlanWithBLOBs lotteryPlan){
        if (lotteryPlan.getPlanTicketStatus() == 1) {//防止多次修改
            lotteryPlan.setPlanTicketStatus(2);//出票中
            lotteryPlanService.updatePlanTicketStatus(lotteryPlan);
        }
        ticket2Service.updateForSongPiaoSuccess(lotteryPlan.getPlanNo());
    }

    public void updateForTicketFail(LotteryPlanWithBLOBs lotteryPlan){
        if (lotteryPlan.getPlanTicketStatus() != 5) {//防止多次修改
            lotteryPlan.setPlanTicketStatus(5);//出票失败
            lotteryPlanService.updatePlanTicketStatus(lotteryPlan);
        }
        ticket2Service.updateForSongPiaoFail(lotteryPlan.getPlanNo());
    }

    /**
     * 更改方案出票状态
     *
     * @param reqMap
     * @return
     */
    public Map<String, Object> updatePlanTicketStatus(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        int planNo = Integer.parseInt(reqMap.get("planNo").toString());
        LotteryPlanWithBLOBs lotteryPlan = lotteryPlanService.getByPlanNo(planNo);
        if (lotteryPlan == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_5);
            map.put(Constants.MSG, Constants.ERROR_MSG_5_3);
            return map;
        }
        //状态是1.未处理,2.出票中时可修改
        if (lotteryPlan.getPlanTicketStatus() == 1 || lotteryPlan.getPlanTicketStatus() == 2) {
            lotteryPlan.setPlanTicketStatus(5);
            lotteryPlanService.updatePlanTicketStatus(lotteryPlan);
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        return map;
    }

    /**
     * 获取出票结果
     *
     * @param reqMap
     * @return
     */
    public Map<String, Object> getTicketResult(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<String> list = (List<String>) reqMap.get("ticketIdList");

        List<String> tcymOrderIdList = new ArrayList<String>();
        List<String> ynjmOrderIdList = new ArrayList<String>();
        for (String ticketId : list) {
            PlanTicketMapping mapping = planTicketMappingService.getByTicketId(Integer.parseInt(ticketId));
            if (mapping != null) {
                if (mapping.getProvider().equals("通彩易麦")){
                    tcymOrderIdList.add(mapping.getOrderId());
                }else if (mapping.getProvider().equals("云南吉米")){
                    ynjmOrderIdList.add(mapping.getOrderId());
                }
                Ticket2WithBLOBs ticket2 = ticket2Service.getById(Integer.parseInt(ticketId));
                ticket2.setOutId(mapping.getOrderId());
                ticket2Service.update(ticket2);
            }
        }

        if (tcymOrderIdList.size()>0){
            chaPiaoForTcym(tcymOrderIdList);
        }
        if (ynjmOrderIdList.size()>0){
            chaPiaoForYnjm(ynjmOrderIdList);
        }
        return map;
    }

    private void chaPiaoForYnjm(List<String> ynjmOrderIdList) {
        String ordersID = Joiner.on(",").join(ynjmOrderIdList);
        IprotocolPortType iprotocolPortType = new IprotocolPortTypeProxy();
        String agentIDagentID = "800162";
        String sign = MD5.getMD5(agentIDagentID+ordersID+"ketaitest");
        String resp = null;
        try {
            resp = iprotocolPortType.queryTicket(agentIDagentID, ordersID, sign);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        Document dom= null;
        try {
            dom = DocumentHelper.parseText(resp);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root=dom.getRootElement();
        Element header = root.element("header");
        if (!header.elementTextTrim("errorCode").equals("0")){
            //查票失败
            return;
        }
        Iterator iter = root.element("body").element("tickets").elementIterator();
        while(iter .hasNext()){
            Element recordEle  = (Element) iter.next();
            String orderID = recordEle.elementTextTrim("ordersID");
            String status = recordEle.elementTextTrim("status");
            if (status.equals("2")){
                //出票成功
                ticket2Service.updateTicketStatusForSongPiao(orderID, TicketStatus.CPCG.getValue());
                planTicketMappingService.updateForStatusByOrderId(orderID,1);
            }else if (status.equals("-2")){
                //退票
                ticket2Service.updateTicketStatusForSongPiao(orderID, TicketStatus.CPSB.getValue());
                planTicketMappingService.updateForStatusByOrderId(orderID,2);
            }

        }



    }

    public void chaPiaoForTcym(List<String> tcymOrderIdList){
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject reqJo = new JSONObject();
        JSONObject resJo = null;
        String string = Joiner.on(",").join(tcymOrderIdList);
        reqJo.put("orderIdList", string);
        //请求通彩易麦接口
        String s = TicketUtil.getTcymRes(reqJo, TicketTools.matchTicketResult);//接口编号
        resJo = JSONObject.fromObject(s);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put("ticketResultList", resJo);
        //如果通知没到的话就把查到的数据插入数据库
        ticketNotifyService.builderNotify(resJo);
        JSONObject body = resJo.optJSONObject("body");
        JSONObject ActionResult = body.optJSONObject("ActionResult");
        if ("0000".equals(ActionResult.optString("@wCode"))) {
            JSONObject matchTicketQueryResult =
                    ActionResult.optJSONObject("matchTicketQueryResult");
            JSONArray tickets = matchTicketQueryResult.optJSONArray("ticket");
            int j = 0;
            for (Object object : tickets) {
                JSONObject ticket = (JSONObject) object;
                String orderId = ticket.optString("@OrderID");
                @SuppressWarnings("unchecked")
                List<Ticket2> mTicket = ticket2Service.findByOutId(orderId);
                if (mTicket.size() == 0) {
                    continue;
                }
                if ("0000".equals(ticket.optString("@status"))) {
                    Ticket2 t = mTicket.get(0);
                    t.setStatus(4);
                    ticket2Service.updateSuccess(t);
                } else if ("2052".equals(ticket.optString("@status"))) {
                    //投注中（出票中）
                } else {
                    Ticket2 t = mTicket.get(0);
                    t.setStatus(5);
                    ticket2Service.updateSuccess(t);
                }
            }
        }
    }

    /**
     * 插入通知表
     *
     * @param resJo
     */
    private void builderNotify(JSONObject resJo) {
    }

    /**
     * 送票检验
     *
     * @param reqMap
     * @return
     */
    public Map<String, Object> ticketRestrict(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        int lotteryType = Integer.parseInt(reqMap.get("lotteryType").toString());
        int planNo = Integer.parseInt(reqMap.get("planNo").toString());
        LotteryType lotteryType1 = lotteryTypeService.getById(lotteryType);
        /**
         * 判断该玩法是否设置出票商
         */
        if (lotteryType1.getTicketId() == 0) {
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_10);
            return map;
        }
        String account = (String) reqMap.get("account");
        MemberDTO member2 = memberService.getByAccount(account);
        if (member2.getType() == 2) {
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_11);
            return map;
        }
        MemberGrade2 memberGrade2 = memberGrade2Service.getByAccount(account);
        /**
         * VIP直接出票不用校验
         */
        if (memberGrade2 != null && memberGrade2.getIsVip() == 1) {
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        }
        LotteryPlanWithBLOBs lotteryPlanWithBLOBs = lotteryPlanService.getByPlanNo(planNo);
        TicketRestrict ticketRestrict = ticketRestrictService.getByEffective();
        /**
         * 校验出票参数
         */
        if (ticketRestrict.getCredit().compareTo(new BigDecimal(lotteryPlanWithBLOBs.getAmount())) > 0) {
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_7);
            return map;
        }
        /**
         * 校验SP值
         */
        if (ticketRestrict.getSp().compareTo(new BigDecimal(lotteryPlanWithBLOBs.getMaxSp())) > 0) {
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_7);
            return map;
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 写入最大SP
     *
     * @param reqMap
     * @return
     */
    public Map<String, Object> putMaxSp(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        int planNo = Integer.parseInt(reqMap.get("planNo").toString());
        double maxSp = Double.parseDouble(reqMap.get("maxSp").toString());
        LotteryPlanWithBLOBs lotteryPlanWithBLOBs = lotteryPlanService.getByPlanNo(planNo);
        lotteryPlanWithBLOBs.setMaxSp(maxSp);
        lotteryPlanService.updatePlanTicketStatus(lotteryPlanWithBLOBs);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> ticketRestrict2(int planNo) {
        Map<String, Object> map = new HashMap<String, Object>();
        LotteryPlanWithBLOBs plan = lotteryPlanService.getByPlanNo(planNo);
        String account = plan.getAccount();
        Integer lotteryType = plan.getLotteryType();
        Integer isSuperMan = plan.getIsSuperMan();
        MemberGrade2 byAccount = memberGrade2Service.getByAccount(account);
        if (byAccount == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_400);
            map.put(Constants.MSG, Constants.ERROR_MSG_400);
            return map;
        }

        //判断机器人
        MemberDTO member2 = memberService.getByAccount(account);
        if (member2.getType() == 2) {
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_11);
            return map;
        }

        if (!com.qiyun.DTO.LotteryType.JCLQList.contains(com.qiyun.DTO.LotteryType.getItem(lotteryType))
                && !com.qiyun.DTO.LotteryType.JCZQList.contains(com.qiyun.DTO.LotteryType.getItem(lotteryType))
                && lotteryType != 46 && lotteryType != 47) {
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        }

        if (byAccount.getIsProviderTicket() == 1) {
            //直接出票
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        }


        TicketRestrictConfig2 byIsSuper = ticketRestrictConfigService.getByIsSuper(isSuperMan);
        if (byIsSuper.getStatus() == 2) {
            //自动出票
            map.put(Constants.CODE, Constants.ERROR_CODE_424);
            map.put(Constants.MSG, Constants.ERROR_MSG_424);
            return map;
        }
        if (byIsSuper.getStatus() == 3) {
            //渠道
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        }
        if (byIsSuper.getStatus() == 1) {
            //判断
            if (plan.getAmount() > byIsSuper.getAmount()) {
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                return map;
            } else {
                map.put(Constants.CODE, Constants.ERROR_CODE_6);
                map.put(Constants.MSG, Constants.ERROR_MSG_6_7);
                return map;
            }
        }

        return map;
    }

    /**
     * 添加票务商需要的用户信息
     *
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

    public LotteryTerm findPrintingTermByLotteryType(Integer lotType) {

        return ticket2Service.findPrintingTermByLotteryType(lotType);
    }

    public List<LotteryPlan> findByLotteryTypeAndTermsAndPlanTicketStatus(com.qiyun.commonModel.LotteryType lotType, int i, String term) {
        return lotteryPlanService.selectLotteryPlans(lotType.getValue(), i, term);
    }

    public void updateLotteryPlan(LotteryPlan lotteryPlan) {
        lotteryPlanService.updateLotteryPlan(lotteryPlan);
    }

    public void jianPiao(LotteryPlan lotteryPlan, Platform platform) {
        LogUtil.info("方案：" + lotteryPlan.getPlanNo() + "  检票开始...");
        // 检票用，统计方案总票数
        int allTicketNum = ticket2Service.getTicketCount(lotteryPlan);
        if (0 == allTicketNum) {
            return;
        }
        //查找送票中的方案列表
        List<Ticket2> list = ticket2Service.findTicketByPlanNo(lotteryPlan.getPlanNo());
        //统计非成功状态的票数
        int noSuccessTicketNum = ticket2Service.countTicketNotSuccess(lotteryPlan.getPlanNo());
        //如果失败的票数为0
        if (noSuccessTicketNum == 0) {
            lotteryPlan = lotteryPlanService.selectByPrimaryKey(lotteryPlan.getPlanNo());
            //!!!防止重复检票，如果已经是出票状态，则退出
            if (lotteryPlan.getPlanTicketStatus() == 4) {
                return;
            }
            // 如果方案已经满员就将方案状态设置为已出票状态
            if (lotteryPlan.getPlanStatus() == 3) {
                lotteryPlan.setPlanStatus(4);
                lotteryPlan.setPlanTicketStatus(4);
                lotteryPlan.setPrintTicketDateTime(new Date());
                lotteryPlanService.updateLotteryPlan(lotteryPlan);
                LogUtil.info("方案：" + lotteryPlan.getPlanNo() + "  检票处理为成功。");
                /*********寻票状态更新**********/
                updateTicketFindticketStatus(lotteryPlan);
                //查询返点 返回佣金
                boolean lean = setCommision(lotteryPlan);
                LogUtil.info(lotteryPlan.getAccount() + "购彩方案编号:" + lotteryPlan.getPlanNo() + "赠送返点: " + lean);
            }
        }else if (noSuccessTicketNum > 0 && noSuccessTicketNum < allTicketNum) {// 如果成功的票加上失败的票等于方案的票则设置该方案为部分出票
            // TODO:部份出票暂不处理
            if (list.size() > 0) {
                // 查询是否送票是否成功
                chaPiao(list, lotteryPlan, platform);
            }
        } else {
            if (list.size() > 0) {
                chaPiao(list, lotteryPlan, platform);
            }
            //整个方案都是失败的票则进行以下逻辑处理
            int failTicketNum = ticket2Service.getFailCount(lotteryPlan);
            if (allTicketNum == failTicketNum) {
                LogUtil.info("方案：" + lotteryPlan.getPlanNo() + "  检票：出票失败！");
                //退票处理
                planBack(lotteryPlan.getPlanNo());
            }
        }
    }

    public Map<String, Object> test() {
        try {
            IprotocolPortType iprotocolPortType = new IprotocolPortTypeProxy();
            String agentIDagentID = "800162";
            String lotteryID  = "11";
            String issue  = "";
            String msg = "0^F20180804001,3";
            String source = agentIDagentID+lotteryID+issue+msg;
            String sign = com.qiyun.util.MD5.getMD5(source);
            String resp = iprotocolPortType.betTicket(agentIDagentID, lotteryID, issue, msg, sign);
            System.out.println(resp);
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("data",resp);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, Object> planBack(Integer planNo) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            LotteryPlanWithBLOBs plan = lotteryPlanService.getByPlanNo(planNo);
            if (plan == null) {
                map.put(Constants.CODE, Constants.ERROR_CODE_400);
                map.put(Constants.MSG, Constants.ERROR_MSG_400);
                return map;
            }
            if (plan.getPlanStatus() != 3 && plan.getPlanStatus() != 4) {
                map.put(Constants.CODE, Constants.ERROR_CODE_444);
                map.put(Constants.MSG, Constants.ERROR_MSG_444);
                return map;
            }
            //修改方案状态
            plan.setPlanStatus(PlanStatus.TICKET_GQ.getValue());
            plan.setPlanTicketStatus(PlanTicketStatus.TICKET_FAIL.getValue());
            plan.setJoinCount(0);
            plan.setPrintTicketDateTime(new Date());
            plan.setArrivalTime(new Date());//退款到帐时间
            lotteryPlanService.update(plan);

            //修改票状态
            ticket2Service.updateTicketByPlanBack(planNo);

            //寻票状态更新
            TicketFindNew2 ticketFindNew = ticketFindService.getTicketFindNewByPlanNo(planNo);
            if (ticketFindNew != null) {
                ticketFindNew.setTicketStatus(plan.getPlanStatus());
                ticketFindService.updateTicketFindNew(ticketFindNew);
            }

            //彩金卡
            MemberWalletLine2 cardLine = memberService.getByPlanNoAndRemark(planNo, "彩金卡抵扣");

            //全额退款
            MemberWallet2DTO memberWallet2 = memberService.getMemberWalletByAccount(plan.getAccount());
            if (memberWallet2 == null) {
                map.put(Constants.CODE, Constants.ERROR_CODE_400);
                map.put(Constants.MSG, Constants.ERROR_MSG_400);
                return map;
            }
            if (cardLine == null) {
                memberWallet2.setAbleBalance(memberWallet2.getAbleBalance() + plan.getAmount());
            } else {
                memberWallet2.setAbleBalance(memberWallet2.getAbleBalance() + plan.getAmount() - cardLine.getAmount());
            }
            memberWallet2.setHeapBalance(memberWallet2.getHeapBalance() - plan.getAmount());
            memberService.updateMemberWallet(memberWallet2);

            MemberDTO member = memberService.getByAccount(plan.getAccount());

            //退款流水
            MemberWalletLine2 memberWalletLine2 = new MemberWalletLine2();
            memberWalletLine2.setPlanNo(planNo);
            memberWalletLine2.setAccount(plan.getAccount());
            memberWalletLine2.setMemberId(member.getId());
            memberWalletLine2.setTransType(WalletTransType.RETURN.getValue());
            memberWalletLine2.setWalletType(1);
            if (cardLine == null) {
                memberWalletLine2.setAmount((double) plan.getAmount());
            } else {
                memberWalletLine2.setAmount((double) plan.getAmount() - cardLine.getAmount());
            }

            memberWalletLine2.setLotteryType(plan.getLotteryType());
            memberWalletLine2.setCreateDateTime(new Date());
            memberWalletLine2.setStatus(0);
            memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine2));
            memberWalletLine2.setSourceId(member.getSourceId());
            memberWalletLine2.setAbleBalance(memberWallet2.getAbleBalance());
            memberWalletLine2.setFreezeBalance(memberWallet2.getFreezeBalance());
            memberWalletLine2.setHeapBalance(memberWallet2.getHeapBalance());
            memberWalletLine2.setRemark("退单退款:" + planNo);
            memberService.insertSelective(memberWalletLine2);

            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        } catch (Exception e) {
            map.put(Constants.CODE, Constants.ERROR_CODE_445);
            map.put(Constants.MSG, Constants.ERROR_MSG_445);
            return map;
        }
    }

    //查询票务商是否出票
    private void chaPiao(List<Ticket2> list, LotteryPlan lotteryPlan, Platform platform) {
        int i = 1;
        StringBuffer sb = new StringBuffer();
        for (Ticket2 ticket : list) {
            if (i == list.size()) {
                sb.append(ticket.getId());
            } else {
                sb.append(ticket.getId() + ",");
                i++;
            }
        }
        JSONObject jo = new JSONObject();
        jo.put("ticketIdList", sb.toString());
        String result = ZipHttpUtil.sendGetHttp(url + "ticket/getTicketResult", jo);
        JSONObject resObj = JSONObject.fromObject(result);
        if (resObj == null || resObj.optInt("error_code") != 200) {
            return;
        }
        JSONObject ticketResultList =
                resObj.optJSONObject("ticketResultList");
        JSONObject body =
                ticketResultList.optJSONObject("body");
        JSONObject ActionResult =
                body.optJSONObject("ActionResult");
        if ("0000".equals(ActionResult.optString("@wCode"))) {
            JSONObject matchTicketQueryResult =
                    ActionResult.optJSONObject("matchTicketQueryResult");
            JSONArray tickets = matchTicketQueryResult.optJSONArray("ticket");
            int j = 0;
            for (Object object : tickets) {
                JSONObject ticket = (JSONObject) object;
                String orderId = ticket.optString("@OrderID");
                @SuppressWarnings("unchecked")
                List<Ticket2> mTicket = ticket2Service.findByOutId(orderId);
                if (mTicket.size() == 0) {
                    continue;
                }
                if ("0000".equals(ticket.optString("@status"))) {
                    Ticket2 t = mTicket.get(0);
                    t.setStatus(4);
                    ticket2Service.updateSuccess(t);
                    switch (j) {
                        case 0:
                            j = 2; //出票成功为2
                            break;
                        case 1:
                            j = 3; //出票部分成功为3
                            break;
                    }
                } else if ("2052".equals(ticket.optString("@status"))) {
                    //投注中（出票中）
                    return;
                } else {
                    Ticket2 t = mTicket.get(0);
                    t.setStatus(5);
                    ticket2Service.updateSuccess(t);
                    switch (j) {
                        case 0:
                            j = 1; //出票失败为1
                            break;
                        case 2:
                            j = 3;
                            break;
                    }
                }
            }
            switch (j) {
                case 1:
                    //该方案状态为出票失败
                    lotteryPlan.setPlanTicketStatus(PlanTicketStatus.TICKET_FAIL.getValue());
                    break;
                case 2:
                    //改方案状态为出票成功 及已出票

                    lotteryPlan.setPlanTicketStatus(PlanTicketStatus.TICKET_FINISH.getValue());
                    lotteryPlan.setPlanStatus(PlanStatus.TICKET_OUT.getValue());
                    lotteryPlan.setPrintTicketDateTime(new Date());

                    /*********寻票状态更新**********/
                    updateTicketFindticketStatus(lotteryPlan);
                    /*********购彩返点**********/
                    Boolean isQuanBao = false;
                  /*  try {
                        isQuanBao=checkHmPlanIsQuanBao(lotteryPlan);
                        boolean lean = memberRateService.userRebates(lotteryPlan,ReturnPointType.RETURN_POINT,isQuanBao, platform);
                        LogUtil.info(lotteryPlan.getAccount()+"购彩方案编号:"+ lotteryPlan.getPlanNo() +"赠送返点: " + lean);
                    } catch (Exception e) {
                        LogUtil.info(lotteryPlan.getAccount()+"购彩方案编号:"+ lotteryPlan.getPlanNo() +"赠送返点方法异常！");
                    }*/
                    break;
                case 3:
                    //该方案状态为部分成功
                    lotteryPlan.setPlanTicketStatus(PlanTicketStatus.TICKET_SOME_FAIL.getValue());
                    break;
            }
            lotteryPlanService.updateLotteryPlan(lotteryPlan);
        }
    }

    private boolean setCommision(LotteryPlan lotteryPlan) {
        Double rate = 0.0;//返点
        String remark = "消费赠送"; //返点
        double presentAmount = 0.0;
        double amount = 0.0;

        Integer lotType;
        if(com.qiyun.commonModel.LotteryType.JCLQList.contains(com.qiyun.commonModel.LotteryType.getItem(lotteryPlan.getLotteryType()))){//竞彩篮球
            lotType = com.qiyun.commonModel.LotteryType.JC_LQ.getValue();
        }else if(com.qiyun.commonModel.LotteryType.JCZQList.contains(com.qiyun.commonModel.LotteryType.getItem(lotteryPlan.getLotteryType()))){//竞彩足球
            lotType = com.qiyun.commonModel.LotteryType.JC_ZQ.getValue();
        }else{
            lotType = lotteryPlan.getLotteryType();
        }

        lotteryPlan.setLotteryType(lotType);
        Member2 member = memberService.getById(lotteryPlan.getMemberId());
        if (member == null) {
            logger.info("ID为" + lotteryPlan.getMemberId() + "的用户不存在");
            return false;
        }
        //判断这个方案是不是焦点赛事
        LotteryPlanAddPrize2 lotteryPlanAddPrize = lotteryPlanAddPrizeService.findLotteryPlanAddPrize(lotteryPlan.getPlanNo());
        if (lotteryPlanAddPrize != null && lotteryPlanAddPrize.getPlanNo() != null && lotteryPlanAddPrize.getPlanNo() != 0) {
            logger.info("ID为" + lotteryPlan.getMemberId() + "的用户+购买的焦点赛事" + lotteryPlanAddPrize.getPlanNo() + ",焦点赛事没有返点");
            return false;
        }
        //判断这个人是否返点

        MemberRate2 memberRate2 = memberService.findMemberRate2ByAccount(member.getId(), lotteryPlan.getLotteryType());
        //判断这的上级是不是代理或者渠道
        if (member.getProvider().equals("QD")) {
            //这个人上级为渠道
            //判断渠道是否存在返点
            if (qdCommision(lotteryPlan, rate, amount, member, memberRate2)) return false;
        } else if (member.getProvider().equals("DL")) {
            if (dlCommision(lotteryPlan, rate, amount, member, memberRate2)) return false;
        } else {
            if (memberRate2 == null) {
                logger.debug("ID为" + member.getId() + "的用户不存在返点");
            } else {
                //获取用户返点 和金额
                rate = memberRate2.getFdDgRate();
                //计算用户返点金额
                amount = lotteryPlan.getAmount() * rate / 100;
                //添加到钱包 和钱包流水
                addMemberWalletAndWalletLine(lotteryPlan, member, amount,remark);
            }
        }

        return true;
    }

    private boolean dlCommision(LotteryPlan lotteryPlan, Double rate, double amount, Member2 member, MemberRate2 memberRate2) {
        //代理信息
        Member2 memberDL = memberService.getById(member.getSourceId());
        //这个人上级为渠道
        //判断渠道是否存在返点
        MemberRate2 memberRateUpDL = memberService.findMemberRate2ByAccount(memberDL.getSourceId(), lotteryPlan.getLotteryType());
        MemberAgent2 AgentDL = memberService.findIsAgentOrQd(member.getSourceId());
        //渠道信息
        Member2 memberQD = memberService.getById(memberDL.getSourceId());
        MemberRate2 memberRateUpQD = memberService.findMemberRate2ByAccount(memberQD.getId(),lotteryPlan.getLotteryType());
        MemberAgent2 agentQD = memberService.findIsAgentOrQd(memberDL.getSourceId());
        if (agentQD == null || 1!=agentQD.getStatus()) {
            LogUtil.debug("下线:" + memberDL.getAccount() + "的上级渠道 memberId:" + memberDL.getSourceId() + "为无效渠道");
            return true;
        }
        if (AgentDL == null || 1!=AgentDL.getStatus()) {
            LogUtil.debug("下线:" + member.getAccount() + "的上级代理 memberId:" + memberDL.getSourceId() + "为无效代理");
            return true;
        }
        if (memberRateUpQD == null) {
            logger.debug("ID为" + memberDL.getSourceId() + "的渠道不存在返点");
            return true;
        }
        if (memberRateUpDL == null) {
            logger.debug("ID为" + memberDL.getSourceId() + "的代理不存在返点");
            return true;
        }
        //如果存在返点

        if (memberRate2 == null) {
            logger.debug("ID为" + member.getId() + "的用户不存在返点");
        } else {
            //获取用户返点 和金额
            rate = memberRate2.getFdDgRate();
            //计算用户返点金额
            amount = lotteryPlan.getAmount() * rate / 100;
            //添加到钱包 和钱包流水
            addMemberWalletAndWalletLine(lotteryPlan, member, amount,"收取佣金");
        }
        //添加代理返点数据
        Double DLrate = memberRateUpDL.getFdDgRate() - rate;
        if (DLrate < 0) {
            logger.debug("ID为" + member.getSourceId() + "的代理返点分配不合理");
            return false;
        }
        double DLamount = lotteryPlan.getAmount() * DLrate / 100;

        //保存到钱包
        addMemberWalletAndWalletLine(lotteryPlan, memberDL, amount,"收取佣金");
        //保存到收佣表
        addCommision(memberDL.getId(), member.getId(), DLamount, amount, lotteryPlan.getPlanNo(), rate, DLrate, memberDL.getUsername() + "代理收取id为"+member.getId()+member.getUsername()+"的佣金");
        LogUtil.info("ID为" + memberDL.getId() + "的代理收取" + amount + "成功");
        //添加渠道的返点
        Double qdrate = memberRateUpQD.getFdDgRate() - memberRateUpDL.getFdDgRate() - rate;
        if (qdrate < 0) {
            logger.debug("ID为" + memberDL.getSourceId() + "的渠道返点分配不合理");
            return true;

        }
        double qdamount = lotteryPlan.getAmount() * qdrate / 100;
        //保存到钱包
        addMemberWalletAndWalletLine(lotteryPlan, memberDL, amount,"收取佣金");
        //保存到收佣表
        addCommision(memberQD.getId(), member.getId(), qdamount, amount, lotteryPlan.getPlanNo(), rate, qdrate, memberQD.getUsername() + "渠道收取id为"+member.getId()+member.getUsername()+"的佣金");
        LogUtil.info("ID为" + memberDL.getId() + "的渠道收取" + amount + "成功");
        return false;
    }

    private boolean qdCommision(LotteryPlan lotteryPlan, Double rate, double amount, Member2 member, MemberRate2 memberRate2) {
        MemberRate2 memberRateUp = memberService.findMemberRate2ByAccount(member.getSourceId(), lotteryPlan.getLotteryType());
        MemberAgent2 qdAgent = memberService.findIsAgentOrQd(member.getSourceId());


        if (qdAgent == null || 1!=qdAgent.getStatus()) {
            LogUtil.info("下线:" + member.getAccount() + "的上级代理 memberId:" + member.getSourceId() + "为无效渠道");
            return true;
        }
        if (memberRateUp == null) {
            logger.debug("ID为" + member.getSourceId() + "的渠道不存在返点");
            return true;
        }
        //如果存在返点

        if (memberRate2 == null) {
            logger.debug("ID为" + member.getId() + "的用户不存在返点");
        } else {
            //获取用户返点 和金额
            rate = memberRate2.getFdDgRate();
            //计算用户返点金额
            amount = lotteryPlan.getAmount() * rate / 100;
            //添加到钱包 和钱包流水
            addMemberWalletAndWalletLine(lotteryPlan, member, amount,"消费赠送");
        }
        //添加渠道返点数据
        Double qdrate = memberRateUp.getFdDgRate() - memberRate2.getFdDgRate();
        Member2 memberQD = memberService.getById(member.getSourceId());
        double qdamount = lotteryPlan.getAmount() * qdrate / 100;

        //保存到钱包
        addMemberWalletAndWalletLine(lotteryPlan, memberQD, amount,"收取佣金");
        //保存到收佣表
        addCommision(memberQD.getId(), member.getId(), qdamount, amount, lotteryPlan.getPlanNo(), rate, qdrate, memberQD.getUsername() + "渠道收取佣金");
        LogUtil.info("ID为" + memberQD.getId() + "的渠道收取" + amount + "成功");
        return false;
    }

    private void addCommision(Integer agentId, Integer lowerId, double qdamount, double amount, Integer planNo, Double rate, Double qdrate, String remark) {
        MemberAgentCommision memberAgentCommision = new MemberAgentCommision();
        memberAgentCommision.setMemberAgentId(agentId);
        memberAgentCommision.setMemberLowerId(lowerId);
        memberAgentCommision.setAgentCommision(qdamount);
        memberAgentCommision.setLowerCommision(amount);
        memberAgentCommision.setPlanId(planNo);
        memberAgentCommision.setAgentRate(qdrate);
        memberAgentCommision.setLowerRate(rate);
        memberAgentCommision.setCreateDateTime(new Date());
        memberAgentCommision.setRemark(remark);
        memberService.insert(memberAgentCommision);
    }

    private void addMemberWalletAndWalletLine(LotteryPlan lotteryPlan, Member2 member, double amount,String remark) {
        try {


            //获取钱包
            MemberWallet2DTO memberWalletByAccount = memberService.getMemberWalletByAccount(member.getAccount());
            //添加佣金
            memberWalletByAccount.setTakeCashQuota(memberWalletByAccount.getTakeCashQuota() + amount);
            //添加总金额
            memberWalletByAccount.setAbleBalance(memberWalletByAccount.getAbleBalance() + amount);

             memberService.updateMemberWallet(memberWalletByAccount);
            //生成钱包流水

            MemberWalletLine2 memberWalletLine2 = new MemberWalletLine2();
            memberWalletLine2.setAbleBalance(memberWalletByAccount.getAbleBalance() + amount);
            memberWalletLine2.setAccount(memberWalletByAccount.getAccount());
            memberWalletLine2.setAmount(amount);
            memberWalletLine2.setCreateDateTime(new Date());
            memberWalletLine2.setFreezeBalance(memberWalletByAccount.getFreezeBalance());
            memberWalletLine2.setHeapBalance(memberWalletByAccount.getHeapBalance());
            memberWalletLine2.setLotteryType(lotteryPlan.getLotteryType());
            memberWalletLine2.setMemberId(memberWalletByAccount.getMemberId());
            memberWalletLine2.setOperLineNo(0);
            memberWalletLine2.setOrderNo(0);
            memberWalletLine2.setPlanNo(lotteryPlan.getPlanNo());
            memberWalletLine2.setPlatform(1);
            memberWalletLine2.setPrizeBalance(memberWalletByAccount.getPrizeBalance());
            memberWalletLine2.setRemark(remark);
            memberWalletLine2.setSourceId(member.getSourceId());
            memberWalletLine2.setStatus(0);
            memberWalletLine2.setTransType(1056);
            memberWalletLine2.setWalletType(1);
            memberWalletLine2.setVerifyMd5(DbDataVerify.getMemberWalletLineVerify(memberWalletLine2));
            //保存钱包流水
            memberService.insertSelective(memberWalletLine2);
            //修改订单状态
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateTicketFindticketStatus(LotteryPlan lotteryPlan) {

        TicketFindNew2 findNew = ticket2Service.getByCopyPlanNo(lotteryPlan.getPlanNo());
        if (findNew != null) {
            findNew.setTicketStatus(lotteryPlan.getPlanStatus());
            ticketFindService.updateTicketStatus(findNew);
        }
    }
}
