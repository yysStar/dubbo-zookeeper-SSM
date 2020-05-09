package com.qiyun.foctory;

import com.qiyun.chaiPiao.SetTicket;
import com.qiyun.chaiPiao.SetTicketModel;
import com.qiyun.checkBingo.FootballTicketModel;
import com.qiyun.checkBingo.SportteryTicketModel;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.model.*;
import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.model2.Ticket2WithBLOBs;
import com.qiyun.utils.CommonUtils;
import net.sf.json.JSONObject;

import java.util.*;

public class SportteryFootballDgtzChaiPiao {

    public List<Ticket2WithBLOBs> chaiPiao(final LotteryPlan2WithBLOBs lotteryPlan) throws Exception {
        List<Ticket2WithBLOBs> ticketList = new ArrayList<Ticket2WithBLOBs>();
        List<Ticket2WithBLOBs> tempTicketList = null;
        tempTicketList = getZqDgtzTicketList(lotteryPlan);

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

    public List<Ticket2WithBLOBs> getZqDgtzTicketList(final LotteryPlan2WithBLOBs lotteryPlan) throws Exception {
        final FootBallBetContent model = CommonUtils.Object4Json(lotteryPlan.getContent(), getModelClass(), getMatchItemClass());
        final List<FootBallMatchItem> matchItems = (List<FootBallMatchItem>) model.getMatchItems();
        List<Ticket2WithBLOBs> ticketList = new ArrayList<Ticket2WithBLOBs>();
        for (FootBallMatchItem x : matchItems) {// 找出设胆和非设胆的
            List<SportteryOption> sportteryOptionList = new ArrayList<SportteryOption>();
            for(SportteryOption sportteryOption : x.getOptions()){
                sportteryOptionList.add(sportteryOption);
            }

            for(SportteryOption opt : sportteryOptionList){
                List<SportteryOption> list = new ArrayList<SportteryOption>();
                list.add(opt);
                //每个选项一张票
                int multiple=opt.getBetMoney()/opt.getEach()*lotteryPlan.getMultiple(); //把投注金额拆成实际倍数
                SportteryTicketModel<FootBallMatchItem> ticketModel = new SportteryTicketModel<FootBallMatchItem>();
                ticketModel.setPassMode(PassMode.SINGLE.ordinal());
                ticketModel.setMultiple(multiple);
                ticketModel.setPassType(SportteryPassType.P1);
                List<FootBallMatchItem> tmpList=new ArrayList<FootBallMatchItem>();
                FootBallMatchItem fb = new FootBallMatchItem();
                fb.setIntTime(x.getIntTime());
                fb.setLineId(x.getLineId());
                fb.setOptions(list);

                tmpList.add(fb);
                ticketModel.setMatchItems(tmpList);
                SetTicketModel sm = new SetTicketModel(ticketModel, lotteryPlan);
                Ticket2WithBLOBs ticket = sm.getDgtzTicket();
                if(ticket != null){
                    ticketList.add(ticket);
                }
            }
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
