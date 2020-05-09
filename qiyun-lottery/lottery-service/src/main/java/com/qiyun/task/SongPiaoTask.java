package com.qiyun.task;

import com.qiyun.httpUtil.ZipHttpUtil;
import com.qiyun.model.PlanTicketStatus;
import com.qiyun.model.TicketStatus;
import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.model2.Ticket2WithBLOBs;
import com.qiyun.service.LotteryPlanService;
import com.qiyun.service.TicketService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
@Lazy(value=false)
public class SongPiaoTask {

    @Resource
    private LotteryPlanService lotteryPlanService;

    @Resource
    private TicketService ticketService;

    private List<Integer> lotteryTypes;

    public void setLotteryTypes(List<Integer> lotteryTypes) {
        this.lotteryTypes = lotteryTypes;
    }

//    	private static String url = "https://ticket.api.qyun88.com/";
    private static String url = "https://ticket.api.qiyun88.cn/";


    /**
     * 送票
     */
    @Scheduled(cron = "0/10 * * * * ? ") //10秒执行一次
    public void songPiao(){
        for (Integer type : lotteryTypes) {
            List<LotteryPlan2WithBLOBs> list = lotteryPlanService.getByTypeAndPlanTicketStatus(type, PlanTicketStatus.TICKETING.getValue());
            if (list==null || list.size()<=0 ){
                continue;
            }
            for (LotteryPlan2WithBLOBs lotteryPlan : list) {
                songpiao(lotteryPlan);
            }
        }
    }

    private void songpiao(LotteryPlan2WithBLOBs lotteryPlan) {
        JSONObject jo = new JSONObject();
        List<Ticket2WithBLOBs> list = ticketService.getByPlanNo(lotteryPlan.getPlanNo());
        List<Integer> tickets = new ArrayList<Integer>();
        for(Ticket2WithBLOBs ticket : list) { //防止多次出票
            if(ticket.getStatus() == TicketStatus.CPCG.getValue()) {
                continue;
            }
            if(ticket.getStatus() == TicketStatus.WDP.getValue()) {
                continue;
            }
            tickets.add(ticket.getId());
        }
        if(tickets.size() == 0) {
            return;
        }
        String ticketsStr = "";
        for (int i = 0; i < tickets.size(); i++) {
             if (i==0){
                 ticketsStr += tickets.get(i);
             }else{
                 ticketsStr += ",";
                 ticketsStr += tickets.get(i);
             }
        }
        jo.put("ticketIds", ticketsStr);
        jo.put("planNo", lotteryPlan.getPlanNo());
        String result = ZipHttpUtil.sendGetHttp(url + "ticket/putMatchTicket", jo);
        /*JSONObject resObj = JSONObject.fromObject(result);
        if(resObj == null || resObj.optInt("error_code") != 200) {
            return;
        }
        JSONObject matchTicketResult =
                resObj.optJSONObject("matchTicketResult");
        JSONObject body =
                matchTicketResult.optJSONObject("body");
        JSONObject ActionResult =
                body.optJSONObject("ActionResult");
        if("0000".equals(ActionResult.optString("@wCode"))) {
            ticketService.updateForSongPiaoSuccess(lotteryPlan.getPlanNo());
        } else {
            ticketService.updateForSongPiaoFail(lotteryPlan.getPlanNo());
        }*/
    }
}
