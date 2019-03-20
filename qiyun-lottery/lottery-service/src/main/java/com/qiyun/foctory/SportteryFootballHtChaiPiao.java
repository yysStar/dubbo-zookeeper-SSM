package com.qiyun.foctory;

import com.qiyun.chaiPiao.SetTicket;
import com.qiyun.chaiPiao.SetTicketModel;
import com.qiyun.checkBingo.FootballTicketModel;
import com.qiyun.checkBingo.SportteryTicketModel;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.model.*;
import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.model2.Ticket2WithBLOBs;
import com.qiyun.utils.CommonUtils;
import com.qiyun.utils.ExtensionMathUtils;
import net.sf.json.JSONObject;

import java.util.*;

public class SportteryFootballHtChaiPiao {


    public List<Ticket2WithBLOBs> chaiPiao(final LotteryPlan2WithBLOBs lotteryPlan) throws Exception {
        List<Ticket2WithBLOBs> ticketList = new ArrayList<Ticket2WithBLOBs>();
        List<Ticket2WithBLOBs> tempTicketList = null;
        tempTicketList = getZqHtTicketList(lotteryPlan);


        //重复票归集
        Map<String,Ticket2WithBLOBs> ticketMap = new HashMap<String,Ticket2WithBLOBs>();
        List<Ticket2WithBLOBs> noRepeatList = new ArrayList<Ticket2WithBLOBs>();
        for (Ticket2WithBLOBs t : tempTicketList) {
            String key = t.getContent();
            Ticket2WithBLOBs mt = ticketMap.get(key);
            if(mt == null ){//新票
                ticketMap.put(key, t);
            }else{//重复票，累加倍数
                int mult = t.getMultiple() + mt.getMultiple();
                int amount = t.getAmount() + mt.getAmount();
                mt.setMultiple(mult);
                mt.setAmount(amount);
            }
        }
        Iterator<Ticket2WithBLOBs> it = ticketMap.values().iterator();
        while(it.hasNext()){
            noRepeatList.add(it.next());
        }

        // 处理倍数
        for (Ticket2WithBLOBs t : noRepeatList) {
            // 找到最接近2万元的倍数
            int tempMaxBeishu = 20000 / (t.getAmount() / t.getMultiple());
            if (tempMaxBeishu > 99)// 如果倍数大于99
                tempMaxBeishu = 99;
            // 实际的倍数与最接近2万元的倍数比较
            if (tempMaxBeishu > t.getMultiple())
                ticketList.add(t);
            else {
                List<Ticket2WithBLOBs> tT = new ArrayList<Ticket2WithBLOBs>();
                tT.add(t);
                tT = SetTicket.processBeishu(tT, t.getMultiple(), tempMaxBeishu);
                ticketList.addAll(tT);
            }
        }

        //缓存，减少重复查询数据库
        Map<String, AbstractAward> cacheAwardMap = new HashMap<String, AbstractAward>();
        List<Ticket2WithBLOBs> tempList = new ArrayList<Ticket2WithBLOBs>();
        for (Ticket2WithBLOBs t : ticketList) {
            String contents = t.getContent();
            FootballTicketModel btm = CommonUtils.Object4TikectJson(contents, FootballTicketModel.class, FootBallMatchItem.class);

            btm.setMultiple(t.getMultiple());
            JSONObject jsonObject = JSONObject.fromObject(btm);
            t.setContent(jsonObject.toString());
            tempList.add(t);
        }
        return tempList;
    }

    public List<Ticket2WithBLOBs> getZqHtTicketList(final LotteryPlan2WithBLOBs lotteryPlan) throws Exception {
        final FootBallBetContent model = CommonUtils.Object4Json(lotteryPlan.getContent(), getModelClass(), getMatchItemClass());
        final List<FootBallMatchItem> matchItems = (List<FootBallMatchItem>) model.getMatchItems();
        List<Ticket2WithBLOBs> ticketList = new ArrayList<Ticket2WithBLOBs>();
        List<SportteryPassType> passTypes = model.getPassTypes();
        final List<FootBallMatchItem> unDanList = new ArrayList<FootBallMatchItem>();
        final List<FootBallMatchItem> sheDanList = new ArrayList<FootBallMatchItem>();
        final List<Integer> sheDanMatch = new ArrayList<Integer>();
        int sheDanTotal = 0;
        for (FootBallMatchItem x : matchItems) {// 找出设胆和非设胆的
            List<SportteryOption> sportteryOptionList = new ArrayList<SportteryOption>();
            for(SportteryOption sportteryOption : x.getOptions()){
                sportteryOptionList.add(sportteryOption);
            }

            for(SportteryOption sportteryOption : sportteryOptionList){
                List<SportteryOption> list = new ArrayList<SportteryOption>();
                list.add(sportteryOption);
                FootBallMatchItem fb = new FootBallMatchItem();

                fb.setIntTime(x.getIntTime());
                fb.setLineId(x.getLineId());
                fb.setOptions(list);
                fb.setShedan(x.isShedan());
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

        ticketList = this.getUnDanTicketList(passTypes,0,unDanList.size(),unDanList,lotteryPlan,model,ticketList);

        return ticketList;
    }

    private List<Ticket2WithBLOBs> getUnDanTicketList(List<SportteryPassType> passTypes,int sheDanSize,int unDanSize,final List<FootBallMatchItem> unDanList,
                                            final LotteryPlan2WithBLOBs lotteryPlan,final FootBallBetContent model,final List<Ticket2WithBLOBs> ticketList){
        // 遍历过关方式
        for (final SportteryPassType type : passTypes) {
            int needMatchCount = type.getMatchCount();// 拿到过关的场次数目
            ExtensionMathUtils.efficientCombExtension(needMatchCount, sheDanSize, unDanSize, new ExtensionCombCallBack() {
                public void run(boolean[] comb1, int m1, boolean[] comb2, int m2) {
                    List<FootBallMatchItem> tempMatchs = new ArrayList<FootBallMatchItem>();
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
                        SportteryTicketModel<FootBallMatchItem> tiketModel = new SportteryTicketModel<FootBallMatchItem>();
                        tiketModel.setPassMode(model.getPassMode());
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

    public Class<FootBallBetContent> getModelClass() {
        return FootBallBetContent.class;
    }
    public Class<FootBallMatchItem> getMatchItemClass() {
        return FootBallMatchItem.class;
    }
}
