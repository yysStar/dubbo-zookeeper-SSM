package com.qiyun.service.biz;

import com.qiyun.api.TicketNotifyApi;
import com.qiyun.httpUtil.JsonUtil;
import com.qiyun.model.MatchResult;
import com.qiyun.model.PlanTicketMapping;
import com.qiyun.model.TicketNotify;
import com.qiyun.model.TicketNotifySp;
import com.qiyun.model2.LotteryPlanWithBLOBs;
import com.qiyun.model2.Ticket2WithBLOBs;
import com.qiyun.service.LotteryPlanService;
import com.qiyun.service.PlanTicketMappingService;
import com.qiyun.service.TicketNotifyService;
import com.qiyun.service.TicketNotifySpService;
import com.qiyun.service2.Ticket2Service;
import com.qiyun.util.MD5;
import com.qiyun.util.TicketUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service("ticketNotifyApi")
public class TicketNotifyBiz implements TicketNotifyApi{
    private static Logger logger = LoggerFactory.getLogger(TicketNotifyBiz.class);

    @Autowired
    private TicketNotifyService ticketNotifyService;
    @Autowired
    private PlanTicketMappingService planTicketMappingService;
    @Autowired
    private TicketNotifySpService ticketNotifySpService;
    @Autowired
    private LotteryPlanService lotteryPlanService;
    @Autowired
    private Ticket2Service ticket2Service;

    public Map<String, Object> matchTicketNotify(Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        String wMessage = (String) reqMap.get("wMessage");
        JSONObject obj = JSONObject.fromObject(wMessage);
        JSONObject body = obj.optJSONObject("body");
        JSONObject matchTicketNotify = body.optJSONObject("matchTicketNotify");
        JSONArray ticket = matchTicketNotify.getJSONArray("ticket");
        for(Object oj : ticket) {
            JSONObject jot = (JSONObject) oj;
            String orderId = jot.optString("@OrderID");
            JSONObject codeLossRatio = jot.optJSONObject("codeLossRatio");
            PlanTicketMapping mapping = planTicketMappingService.getByOrderId(orderId);
            if(mapping.getTicketStatus() != (short) 0){ //防止多次修改
                continue;
            }
            LotteryPlanWithBLOBs lotteryPlan = lotteryPlanService.getByPlanNo(mapping.getPlanNo());
            List<Ticket2WithBLOBs> ticketList = ticket2Service.getByPlanNo(mapping.getPlanNo());
            if("0000".equals(jot.optString("@status"))){
                mapping.setTicketStatus((short) 1);
                mapping.setNotifyDatetime(new Date());
                if(lotteryPlan.getPlanTicketStatus() == 2){
                    lotteryPlan.setPlanTicketStatus(4);
                }
                for(Ticket2WithBLOBs ticket2 : ticketList){
                    ticket2.setStatus(4);
                    ticket2Service.update(ticket2);
                }
            } else {
                mapping.setTicketStatus((short) 2);
                mapping.setNotifyDatetime(new Date());
                if(lotteryPlan.getPlanTicketStatus() == 2){
                    lotteryPlan.setPlanTicketStatus(5);
                }
                for(Ticket2WithBLOBs ticket2 : ticketList){
                    ticket2.setStatus(5);
                    ticket2Service.update(ticket2);
                }
            }
            planTicketMappingService.updateByPrimaryKeySelective(mapping);
            lotteryPlanService.updatePlanTicketStatus(lotteryPlan);
            TicketNotify ticketNotify = ticketNotifyService.getByOrderId(orderId);
            if(ticketNotify == null) {
                ticketNotify = TicketNotify.builder().lotId(jot.optString("@LotId"))
                        .orderId(orderId).ticketSerialNo(jot.optString("@ticketSerialNo"))
                        .printSerialNo(jot.optString("@printSerialNo"))
                        .stationId(jot.optString("@stationId"))
                        .fixedBonus(new BigDecimal(codeLossRatio.optString("@fixedBonus"))).build();
                ticketNotifyService.insertSelective(ticketNotify);
            }
            JSONArray matchLossRatio = codeLossRatio.optJSONArray("matchLossRatio");
            List<TicketNotifySp> list = ticketNotifySpService.getByOrderId(orderId);
            if(list.size() == 0) {
                for (Object o : matchLossRatio) {
                    JSONObject jo = (JSONObject) o;
                    List<String> keys = JsonUtil.getKey(jo);
                    String vsType = keys.get(1);
                    //获取投注类型
                    JSONObject vs = jo.optJSONObject(vsType);
                    String sp = "0";
                    String key = "";
                    String letPoint = "";
                    List<String> vsKeys = JsonUtil.getKey(vs);
                    if("@letPoint".equals(vsKeys.get(0))){
                        letPoint = vs.optString("@letPoint");
                        key = vsKeys.get(1);
                        sp = vs.optString(key);
                    } else {
                        key = vsKeys.get(0);
                        sp = vs.optString(key);
                    }
                    TicketNotifySp ticketNotifySp = TicketNotifySp.builder().matchId(jo.optString("@id"))
                            .score(key).sp(new BigDecimal(sp)).orderId(orderId).vsType(vsType)
                            .letPoint(letPoint).build();
                    ticketNotifySpService.insertSelective(ticketNotifySp);
                }
            }
        }
        JSONObject jo = TicketUtil.getHeadRequest(575);
        JSONObject resBody = new JSONObject();
        JSONObject ActionResult = new JSONObject();
        ActionResult.put("@wCode", "0000");
        ActionResult.put("@wRltMsg", "成功,系统处理正常");
        resBody.put("ActionResult", ActionResult);
        JSONObject header = jo.optJSONObject("header");
        String timestamp = header.getString("timestamp");
        String wSign = MD5.encode(jo.getString("@wMsgID") + timestamp
                + TicketUtil.getTcymAgentPwd() + body.toString());
        header.put("wSign", wSign);
        jo.put("body", resBody);
        map.put("res",jo);
        logger.info("----------------通彩易麦请求参数：" + jo.toString());
        return map;
    }

    public Map<String, Object> matchResultNotify(Map<String, Object> reqMap){
        Map<String, Object> map = new HashMap<String, Object>();
        String wMessage = (String) reqMap.get("wMessage");
        JSONObject obj = JSONObject.fromObject(wMessage);
        JSONObject body = obj.optJSONObject("body");
        JSONObject matchResultNotify = body.optJSONObject("matchResultNotify");
        JSONObject matchResult = matchResultNotify.optJSONObject("matchResult");
        MatchResult result = MatchResult.builder().id(matchResult.getString("@id"))
                .type(Integer.parseInt(matchResult.getString("@wType")))
                .cancel(Integer.parseInt(matchResult.getString("@cancel")))
                .day(matchResult.getString("@day"))
                .weekId(Integer.parseInt(matchResult.getString("@@weekId")))
                .teamId(matchResult.getString("@teamId"))
                .letPoint(Integer.parseInt(matchResult.getString("@letPoint")))
                .basePoint(Integer.parseInt(matchResult.getString("@basePoint")))
                .result(matchResult.getString("@result"))
                .halfResult(matchResult.getString("@firstHalfResult"))
                .b0(new BigDecimal(matchResult.getString("@b0")))
                .b1(new BigDecimal(matchResult.getString("@b1")))
                .b2(new BigDecimal(matchResult.getString("@b2")))
                .b3(new BigDecimal(matchResult.getString("@b3")))
                .b4(new BigDecimal(matchResult.getString("@b4")))
                .b5(new BigDecimal(matchResult.getString("@b5")))
                .b6(new BigDecimal(matchResult.getString("@b6")))
                .b7(new BigDecimal(matchResult.getString("@b7"))).build();
        return map;
    }
}
