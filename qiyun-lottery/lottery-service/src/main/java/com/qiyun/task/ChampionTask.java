package com.qiyun.task;

import com.google.common.base.Joiner;
import com.qiyun.httpUtil.HttpUtil;
import com.qiyun.model2.ChampionMatch;
import com.qiyun.model2.ChampionMatchUp;
import com.qiyun.model2.ChampionPlan;
import com.qiyun.model2.ChampionPlanMatch;
import com.qiyun.service.ChampionMatchService;
import com.qiyun.service.ChampionMatchUpService;
import com.qiyun.service.ChampionPlanMatchService;
import com.qiyun.service.ChampionPlanService;
import com.qiyun.tools.TicketTools;
import com.qiyun.util.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Lazy(value=false)
public class ChampionTask {
//    @Autowired
//    private ChampionMatchService championMatchService;
//    @Autowired
//    private ChampionMatchUpService championMatchUpService;
    @Autowired
    private ChampionPlanService championPlanService;
//    @Autowired
//    private ChampionPlanMatchService championPlanMatchService;
//
////    /**
////     * 处理出票状态（一场一票）
////     * @throws Exception
////     */
////    @Scheduled(cron = "0/30 * * * * ?")//每隔30秒处理一次
////    public void changeTicketStatus() throws Exception {
////        List<ChampionPlan> planList = championPlanService.getTicketIngList();//获取出票中的订单列表
//////        List<String> orderIdList = new ArrayList<String>();
////        JSONObject reqJo = new JSONObject();
////        JSONObject resJo = null;
////        for(ChampionPlan plan : planList){
////            if(StringUtils.isNullOrBlank(plan.getOrderNo()) &&
////                    (System.currentTimeMillis() - plan.getCreateTime().getTime()) > 180000){//自动成功为三分钟
////                plan.setTicketStatus(2);
////                championPlanService.update(plan);
////            } else if(!StringUtils.isNullOrBlank(plan.getOrderNo())){ //票务出票
////                List<ChampionPlanMatch> list = championPlanMatchService.getByPlanId(plan.getId());
////                for(ChampionPlanMatch planMatch : list) {
////                    reqJo.put("orderIdList", planMatch.getOrderNo());
////                    String s = TicketUtil.getTcymRes(reqJo, TicketTools.matchTicketResult);//接口编号
////                    resJo = JSONObject.fromObject(s);
////                    if (resJo == null) {
////                        return;
////                    } else {
////                        JSONObject body =
////                                resJo.optJSONObject("body");
////                        JSONObject ActionResult =
////                                body.optJSONObject("ActionResult");
////                        if ("0000".equals(ActionResult.optString("@wCode"))) {
////                            JSONObject matchTicketQueryResult =
////                                    ActionResult.optJSONObject("matchTicketQueryResult");
////                            JSONArray tickets = matchTicketQueryResult.optJSONArray("ticket");
////                            int j = 0;
////                            for (Object object : tickets) {
////                                JSONObject ticket = (JSONObject) object;
////                                String orderId = ticket.optString("@OrderID");
////                                ChampionPlan cPlan = championPlanService.getByOrderNo(orderId);
////                                if ("0000".equals(ticket.optString("@status"))) {
////                                    cPlan.setTicketStatus(2);//出票成功
////                                    championPlanService.update(cPlan);
////                                    continue;
////                                } else if ("2052".equals(ticket.optString("@status"))) {//出票中
////                                    continue;
////                                } else {
////                                    cPlan.setTicketStatus(3);//出票失败
////                                    championPlanService.update(cPlan);
////                                    continue;
////                                }
////                            }
////                        }
////                    }
////                }
////            }
////        }
////    }
//
//    /**
//     * 处理出票状态
//     * @throws Exception
//     */
//    @Scheduled(cron = "0/30 * * * * ?")//每隔30秒处理一次
//    public void changeTicketStatus() throws Exception {
//        List<ChampionPlan> planList = championPlanService.getTicketIngList();//获取出票中的订单列表
////        List<String> orderIdList = new ArrayList<String>();
//        JSONObject reqJo = new JSONObject();
//        JSONObject resJo = null;
//        for(ChampionPlan plan : planList){
//            if(StringUtils.isNullOrBlank(plan.getOrderNo()) &&
//                    (System.currentTimeMillis() - plan.getCreateTime().getTime()) > 180000){//自动成功为三分钟
//                plan.setTicketStatus(2);
//                championPlanService.update(plan);
//            } else if(!StringUtils.isNullOrBlank(plan.getOrderNo())){
////                orderIdList.add(plan.getOrderNo());
//                reqJo.put("orderIdList", plan.getOrderNo());
//                String s = TicketUtil.getTcymRes(reqJo, TicketTools.matchTicketResult);//接口编号
//                resJo = JSONObject.fromObject(s);
//            }
//            if(resJo == null){
//                return;
//            } else {
//                JSONObject body =
//                        resJo.optJSONObject("body");
//                JSONObject ActionResult =
//                        body.optJSONObject("ActionResult");
//                if("0000".equals(ActionResult.optString("@wCode"))) {
//                    JSONObject matchTicketQueryResult =
//                            ActionResult.optJSONObject("matchTicketQueryResult");
//                    JSONArray tickets = matchTicketQueryResult.optJSONArray("ticket");
//                    int j = 0;
//                    for (Object object : tickets) {
//                        JSONObject ticket = (JSONObject) object;
//                        String orderId = ticket.optString("@OrderID");
//                        ChampionPlan sPlan = championPlanService.getByOrderNo(orderId);
//                        if ("0000".equals(ticket.optString("@status"))) {
//                            sPlan.setTicketStatus(2);//出票成功
//                            championPlanService.update(sPlan);
//                            continue;
//                        } else if ("2052".equals(ticket.optString("@status"))) {//出票中
//                            continue;
//                        } else {
//                            sPlan.setTicketStatus(3);//出票失败
//                            championPlanService.update(sPlan);
//                            continue;
//                        }
//                    }
//                }
//            }
//        }
//    }

//
//    /**
//     * 冠军赛事抓取
//     * @throws Exception
//     */
//    @Scheduled(cron = "0 0/3 * * * ?")//每隔三分钟处理一次
//    public void getChampionMatch() throws Exception {
//        String s = HttpUtil.sendGet(Constants.CHAMPION_URL,
//                "tid[]=104895&pcode[]=chp&i_callback=cphData");
//        s = Ascii2NativeUtil.ascii2Native(s);
//        List<String> list = JsonUtil.getList(s);
//        for(String s1 : list){
//            boolean isChange = false;
//            String[] strings = s1.split("-");
//            int id = Integer.parseInt(strings[0]);
//            ChampionMatch championMatch = championMatchService.getById(id);
//            if(championMatch == null) {
//                championMatch = ChampionMatch.builder().id(id).teamName(strings[1])
//                        .sellStatus(strings[2]).nationalFlag(strings[11]).sp(new BigDecimal(strings[3]))
//                        .teamId(Integer.parseInt(strings[6])).supportRate(strings[5]).build();
//                championMatchService.insertSelective(championMatch);
//            }
//            if(championMatch.getSp().compareTo(new BigDecimal(strings[3])) != 0){
//                championMatch.setSp(new BigDecimal(strings[3]));
//                isChange = true;
//            }
//            if(!championMatch.getSellStatus().equals(strings[2])){
//                championMatch.setSellStatus(strings[2]);
//                isChange = true;
//            }
//            if(!championMatch.getSupportRate().equals(strings[5])){
//                championMatch.setSupportRate(strings[5]);
//                isChange = true;
//            }
//            if(isChange) {
//                championMatchService.update(championMatch);
//            }
//        }
//    }
//
//    /**
//     * 冠亚军赛事抓取
//     * @throws Exception
//     */
//    @Scheduled(cron = "0 0/3 * * * ?")//每隔三分钟处理一次
//    public void getChampionUpMatch() throws Exception {
//        String s = HttpUtil.sendGet(Constants.CHAMPION_URL,
//                "tid[]=104895&&pcode[]=fnl&i_callback=getList");
//        s = Ascii2NativeUtil.ascii2Native(s);
//        List<String> list = JsonUtil.getList(s);
//        for(String s1 : list){
//            boolean isChange = false;
//            String[] strings = s1.split("-");
//            int id = Integer.parseInt(strings[0]);
//            ChampionMatchUp championMatch = championMatchUpService.getById(id);
//            if(championMatch == null) {
//                championMatch = ChampionMatchUp.builder().id(id).teamName(strings[1])
//                        .sellStatus(strings[2]).nationalFlag(strings[11]).sp(new BigDecimal(strings[3]))
//                        .teamId(Integer.parseInt(strings[6])).supportRate(strings[5]).build();
//                championMatchUpService.insertSelective(championMatch);
//            }
//            if(championMatch.getSp().compareTo(new BigDecimal(strings[3])) != 0){
//                championMatch.setSp(new BigDecimal(strings[3]));
//                isChange = true;
//            }
//            if(!championMatch.getSellStatus().equals(strings[2])){
//                championMatch.setSellStatus(strings[2]);
//                isChange = true;
//            }
//            if(!championMatch.getSupportRate().equals(strings[5])){
//                championMatch.setSupportRate(strings[5]);
//                isChange = true;
//            }
//            if(isChange) {
//                championMatchUpService.update(championMatch);
//            }
//        }
//    }
//}

    /**
     * 处理出票状态
     * @throws Exception
     */
//    @Scheduled(cron = "0/30 * * * * ?")//每隔30秒处理一次
    public void changeTicketStatus() throws Exception {
        List<ChampionPlan> planList = championPlanService.getTicketIngList();//获取出票中的订单列表
//        List<String> orderIdList = new ArrayList<String>();
        JSONObject reqJo = new JSONObject();
        JSONObject resJo = null;
        for(ChampionPlan plan : planList){
            if(StringUtils.isNullOrBlank(plan.getOrderNo()) &&
                    (System.currentTimeMillis() - plan.getCreateTime().getTime()) > 180000){//自动成功为三分钟
                plan.setTicketStatus(2);
                championPlanService.update(plan);
            } else if(!StringUtils.isNullOrBlank(plan.getOrderNo())){
//                orderIdList.add(plan.getOrderNo());
                reqJo.put("orderIdList", plan.getOrderNo());
                String s = TicketUtil.getTcymRes(reqJo, TicketTools.matchTicketResult);//接口编号
                resJo = JSONObject.fromObject(s);
            }
            if(resJo == null){
                return;
            } else {
                JSONObject body =
                        resJo.optJSONObject("body");
                JSONObject ActionResult =
                        body.optJSONObject("ActionResult");
                if("0000".equals(ActionResult.optString("@wCode"))) {
                    JSONObject matchTicketQueryResult =
                            ActionResult.optJSONObject("matchTicketQueryResult");
                    JSONArray tickets = matchTicketQueryResult.optJSONArray("ticket");
                    int j = 0;
                    for (Object object : tickets) {
                        JSONObject ticket = (JSONObject) object;
                        String orderId = ticket.optString("@OrderID");
                        ChampionPlan sPlan = championPlanService.getByOrderNo(orderId);
                        if ("0000".equals(ticket.optString("@status"))) {
                            sPlan.setTicketStatus(2);//出票成功
                            championPlanService.update(sPlan);
                            continue;
                        } else if ("2052".equals(ticket.optString("@status"))) {//出票中
                            continue;
                        } else {
                            sPlan.setTicketStatus(3);//出票失败
                            championPlanService.update(sPlan);
                            continue;
                        }
                    }
                }
            }
        }
    }

}
