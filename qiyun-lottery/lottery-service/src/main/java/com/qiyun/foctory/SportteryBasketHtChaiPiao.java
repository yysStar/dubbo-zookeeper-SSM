package com.qiyun.foctory;

import com.qiyun.chaiPiao.AwardListEnum;
import com.qiyun.chaiPiao.SetTicket;
import com.qiyun.chaiPiao.SetTicketModel;
import com.qiyun.checkBingo.BasketBallTicketModel;
import com.qiyun.checkBingo.SportteryTicketModel;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.model.*;
import com.qiyun.model.basketball.BasketBallBetContent;
import com.qiyun.model.basketball.BasketBallMatchItem;
import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.model2.Ticket2WithBLOBs;
import com.qiyun.utils.CommonUtils;
import com.qiyun.utils.ExtensionMathUtils;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SportteryBasketHtChaiPiao {



    public List<Ticket2WithBLOBs> chaiPiao(final LotteryPlan2WithBLOBs lotteryPlan) throws Exception {
        List<Ticket2WithBLOBs> ticketList = new ArrayList<Ticket2WithBLOBs>();
        List<Ticket2WithBLOBs> tempTicketList = getLqHtTicketList(lotteryPlan);
        // 处理倍数
        for (Ticket2WithBLOBs ticket : tempTicketList) {
            // 找到最接近2万元的倍数
            int tempMaxBeishu = 20000 / (ticket.getAmount() / ticket.getMultiple());
            if (tempMaxBeishu > 99)// 如果倍数大于99
                tempMaxBeishu = 99;
            // 实际的倍数与最接近2万元的倍数比较
            if (tempMaxBeishu > ticket.getMultiple())
                ticketList.add(ticket);
            else {
                List<Ticket2WithBLOBs> tT = new ArrayList<Ticket2WithBLOBs>();
                tT.add(ticket);
                tT = SetTicket.processBeishu(tT, ticket.getMultiple(), tempMaxBeishu);
                ticketList.addAll(tT);
            }
        }

        //缓存，减少重复查询数据库
        Map<String, AbstractAward> cacheAwardMap = new HashMap<String, AbstractAward>();
        List<Ticket2WithBLOBs> tempList = new ArrayList<Ticket2WithBLOBs>();
        for (Ticket2WithBLOBs t : ticketList) {
            String content = t.getContent();
            BasketBallTicketModel btm = CommonUtils.Object4TikectJson(content, BasketBallTicketModel.class, BasketBallMatchItem.class);

            btm.setMultiple(t.getMultiple());
            JSONObject jsonObject = JSONObject.fromObject(btm);
            t.setContent(jsonObject.toString());
            tempList.add(t);
        }
        return tempList;

    }

    private List<Ticket2WithBLOBs> getLqHtTicketList(LotteryPlan2WithBLOBs lotteryPlan) {
        final BasketBallBetContent model = CommonUtils.Object4Json(lotteryPlan.getContent(), getModelClass(), getMatchItemClass());
        final List<BasketBallMatchItem> matchItems = model.getMatchItems();
        List<Ticket2WithBLOBs> ticketList = new ArrayList<Ticket2WithBLOBs>();
        List<SportteryPassType> passTypes = model.getPassTypes();
        final List<BasketBallMatchItem> unDanList = new ArrayList<BasketBallMatchItem>();
        final List<BasketBallMatchItem> sheDanList = new ArrayList<BasketBallMatchItem>();
        final List<Integer> sheDanMatch = new ArrayList<Integer>();
        int sheDanTotal = 0;
        for (BasketBallMatchItem x : matchItems) {// 找出设胆和非设胆的
            List<SportteryOption> sportteryOptionList = new ArrayList<SportteryOption>();
            for(SportteryOption sportteryOption : x.getOptions()){
                sportteryOptionList.add(sportteryOption);
            }

            for(SportteryOption sportteryOption : sportteryOptionList){
                List<SportteryOption> list = new ArrayList<SportteryOption>();
                list.add(sportteryOption);
                BasketBallMatchItem fb = new BasketBallMatchItem();

                fb.setIntTime(x.getIntTime());
                fb.setLineId(x.getLineId());
                fb.setOptions(list);
                fb.setShedan(x.isShedan());
                fb.setDXF(x.getDXF());
                fb.setRF(x.getRF());
                if(x.isShedan()){
                    sheDanList.add(fb);
                }else{
                    unDanList.add(fb);
                }
            }

            if(x.isShedan()){
                sheDanMatch.add(sportteryOptionList.size());
                sheDanTotal += sportteryOptionList.size();
            }
        }

        if(sheDanMatch.size()>0){
            ticketList = this.getSheDanTicketList(passTypes,sheDanMatch.size(),unDanList.size(),sheDanList,unDanList,lotteryPlan,model,ticketList,sheDanTotal);
        }else{
            ticketList = this.getUnDanTicketList(passTypes,0,unDanList.size(),unDanList,lotteryPlan,model,ticketList);
        }

        return ticketList;
    }


    private List<Ticket2WithBLOBs> getSheDanTicketList(List<SportteryPassType> passTypes, final int sheDanSize, final int unDanSize, final List<BasketBallMatchItem> sheDanList,
                                                       final List<BasketBallMatchItem> unDanList, final LotteryPlan2WithBLOBs lotteryPlan, final BasketBallBetContent model, final List<Ticket2WithBLOBs> ticketList, final int sheDanTotal){
        // 遍历过关方式
        for (final SportteryPassType type : passTypes) {
            final int needMatchCount = type.getMatchCount();// 拿到过关的场次数目
            final Map<Integer,List<BasketBallMatchItem>> danMatchs = new HashMap<Integer,List<BasketBallMatchItem>>();
            ExtensionMathUtils.efficientCombExtension(sheDanSize, 0, sheDanTotal, new ExtensionCombCallBack() {
                public void run(boolean[] comb1, int m1, boolean[] comb2, int m2) {
                    List<String> list = new ArrayList<String>();
                    List<BasketBallMatchItem> danList = new ArrayList<BasketBallMatchItem>();
                    for (int i = 0; i < comb2.length; i++) {
                        String intTime = String.valueOf(sheDanList.get(i).getIntTime());
                        String lineId = String.valueOf(sheDanList.get(i).getLineId());
                        String key = intTime+""+lineId;
                        if (comb2[i] && !list.contains(key)){
                            list.add(key);
                            danList.add(sheDanList.get(i));
                        }
                    }
                    if(danList.size() == sheDanSize){
                        danMatchs.put(danMatchs.size()+1, danList);
                    }
                }
            });

            ExtensionMathUtils.efficientCombExtension(needMatchCount, sheDanSize, unDanSize, new ExtensionCombCallBack() {
                public void run(boolean[] comb1, int m1, boolean[] comb2, int m2) {

                    for(Integer danKey : danMatchs.keySet()){
                        List<String> list = new ArrayList<String>();

                        List<BasketBallMatchItem> tempMatchs = new ArrayList<BasketBallMatchItem>();

                        tempMatchs.addAll(danMatchs.get(danKey));

                        for (int i = 0; i < comb2.length; i++) {
                            //因为会存在一场比赛选择了多种玩法的情况，所以这边要添加场次判断
                            String intTime = String.valueOf(unDanList.get(i).getIntTime());
                            String lineId = String.valueOf(unDanList.get(i).getLineId());
                            String key = intTime+""+lineId;
                            if (comb2[i] && !list.contains(key)){
                                list.add(key);
                                tempMatchs.add(unDanList.get(i));
                            }
                        }

                        if (tempMatchs.size() > type.getMatchCount() - 1) {
                            SportteryTicketModel<BasketBallMatchItem> tiketModel = new SportteryTicketModel<BasketBallMatchItem>();
                            tiketModel.setPassMode(PassMode.PASS.ordinal());
                            tiketModel.setMultiple(lotteryPlan.getMultiple());
                            tiketModel.setPassType(type);
                            tiketModel.setOnlyPlay(model.getIsOnlyPlay());

                            tiketModel.setMatchItems(tempMatchs);
                            SetTicketModel sm = new SetTicketModel(tiketModel, lotteryPlan);
                            Ticket2WithBLOBs ticket = sm.getHtTicket();
                            if(ticket != null){
                                ticketList.add(sm.getHtTicket());
                            }
                        }
                    }
                }
            });
        }
        return ticketList;
    }

    private List<Ticket2WithBLOBs> getUnDanTicketList(List<SportteryPassType> passTypes,int sheDanSize,int unDanSize,final List<BasketBallMatchItem> unDanList,
                                            final LotteryPlan2WithBLOBs lotteryPlan,final BasketBallBetContent model,final List<Ticket2WithBLOBs> ticketList){
        // 遍历过关方式
        for (final SportteryPassType type : passTypes) {
            int needMatchCount = type.getMatchCount();// 拿到过关的场次数目
            ExtensionMathUtils.efficientCombExtension(needMatchCount, sheDanSize, unDanSize, new ExtensionCombCallBack() {
                public void run(boolean[] comb1, int m1, boolean[] comb2, int m2) {
                    List<BasketBallMatchItem> tempMatchs = new ArrayList<BasketBallMatchItem>();
                    List<String> list = new ArrayList<String>();
                    for (int i = 0; i < comb2.length; i++) {
                        String intTime = String.valueOf(unDanList.get(i).getIntTime());
                        String lineId = String.valueOf(unDanList.get(i).getLineId());
                        String key = intTime+""+lineId;
                        if (comb2[i] && !list.contains(key)){
                            list.add(key);
                            tempMatchs.add(unDanList.get(i));
                        }
                    }

                    if (tempMatchs.size() > type.getMatchCount()-1) {
                        SportteryTicketModel<BasketBallMatchItem> tiketModel = new SportteryTicketModel<BasketBallMatchItem>();
                        tiketModel.setPassMode(PassMode.PASS.ordinal());
                        tiketModel.setMultiple(lotteryPlan.getMultiple());
                        tiketModel.setPassType(type);
                        tiketModel.setOnlyPlay(model.getIsOnlyPlay());

                        tiketModel.setMatchItems(tempMatchs);
                        SetTicketModel sm = new SetTicketModel(tiketModel, lotteryPlan);
                        Ticket2WithBLOBs ticket = sm.getHtTicket();
                        if(ticket != null){
                            ticketList.add(sm.getHtTicket());
                        }
                    }
                }
            });
        }
        return ticketList;
    }

    public Class<BasketBallMatchItem> getMatchItemClass() {
        return BasketBallMatchItem.class;
    }

    public Class<BasketBallBetContent> getModelClass() {
        return BasketBallBetContent.class;
    }
}
