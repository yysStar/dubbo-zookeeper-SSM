package com.qiyun.chaiPiao;

import com.qiyun.checkBingo.SportteryTicketModel;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.model.MatchItem;
import com.qiyun.model.SportteryBetContentModel;
import com.qiyun.model.SportteryOption;
import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.model2.Ticket2WithBLOBs;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SetTicketModel <T extends SportteryBetContentModel<X>, X extends MatchItem> {

    private static final int AMOUNT = 2; // 一注的价钱

    private static final long serialVersionUID = 1L;
    private SportteryTicketModel<X> tiketModel;
    private LotteryPlan2WithBLOBs lotteryPlan;

    public SetTicketModel(SportteryTicketModel tiketModel, LotteryPlan2WithBLOBs lotteryPlan) {
        this.tiketModel = tiketModel;
        this.lotteryPlan = lotteryPlan;
    }

    public Ticket2WithBLOBs getTicket() {
        Ticket2WithBLOBs ticket = new Ticket2WithBLOBs();
        int amount = tiketModel.countUnit() * AMOUNT;
        amount *= tiketModel.getMultiple();
        ticket.setAmount(amount);
        ticket.setContent(JSONObject.fromObject(tiketModel).toString());
        ticket.setPlayType(tiketModel.getPassType().getType().getValue());
        ticket = SetTicket.setTicket(ticket, lotteryPlan);
        return ticket;
    }

    public Ticket2WithBLOBs getHtTicket() {
        //如果是去除单一,有是单一的票返回null
        if(tiketModel.isOnlyPlay()){
            boolean onlyPlay = isOnlyPlay();
            if(onlyPlay){
                return null;
            }
        }
        Ticket2WithBLOBs ticket = new Ticket2WithBLOBs();
        int amount = tiketModel.countHtUnit() * AMOUNT;
        amount *= tiketModel.getMultiple();
        ticket.setAmount(amount);
        ticket.setContent(JSONObject.fromObject(tiketModel).toString());
        ticket.setPlayType(tiketModel.getPassType().getType().getValue());
        ticket = SetTicket.setTicket(ticket, lotteryPlan);

        /********混投拆票判断********/
        getHtTicketLotteryType(ticket);

        return ticket;
    }
    public Ticket2WithBLOBs getDgtzTicket() {
        Ticket2WithBLOBs ticket = new Ticket2WithBLOBs();
        int amount =  AMOUNT * tiketModel.getMultiple();
        ticket.setMultiple(tiketModel.getMultiple());
        ticket.setAmount(amount);
        ticket.setContent(JSONObject.fromObject(tiketModel).toString());
        ticket.setPlayType(tiketModel.getPassType().getType().getValue());
        ticket = SetTicket.setTicket(ticket, lotteryPlan);

        /********混投拆票判断********/
        getHtTicketLotteryType(ticket);

        return ticket;
    }

    public Ticket2WithBLOBs getHtTicketLotteryType(Ticket2WithBLOBs ticket){
        Map<String, Integer> lotteryTypeMap = getLotteryTypeMap();
        for (String key : lotteryTypeMap.keySet()) {
            if (tiketModel.getPassType().getMatchCount() <= lotteryTypeMap.get(key)) {
                ticket.setLotteryType(LotteryType.getItem(Integer.valueOf(key)).getValue());
            }
        }
        return ticket;
    }

    public boolean isOnlyPlay(){
        Map<String, Integer> lotteryTypeMap = getLotteryTypeMap();
        boolean isOnly = false;
        for (String key : lotteryTypeMap.keySet()) {
            if (tiketModel.getPassType().getMatchCount() <= lotteryTypeMap.get(key)) {
                isOnly = true;
            }
        }
        return isOnly;
    }

    public Map<String, Integer> getLotteryTypeMap(){
        Map<String, Integer> lotteryTypeMap = new HashMap<String, Integer>();
        List<X> matchItems = tiketModel.getMatchItems();
        for (X x : matchItems) {
            for (SportteryOption sportteryOption : x.getOptions()) {
                if (lotteryTypeMap.containsKey(sportteryOption.getType())) {
                    Integer typeNum = lotteryTypeMap.get(sportteryOption.getType()) + 1;
                    lotteryTypeMap.put(sportteryOption.getType(), typeNum);
                } else {
                    lotteryTypeMap.put(sportteryOption.getType(), 1);
                }
            }
        }
        return lotteryTypeMap;
    }
}
