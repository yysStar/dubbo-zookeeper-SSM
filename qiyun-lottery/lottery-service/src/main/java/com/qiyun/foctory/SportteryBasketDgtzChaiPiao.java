package com.qiyun.foctory;

import com.qiyun.chaiPiao.SetTicket;
import com.qiyun.chaiPiao.SetTicketModel;
import com.qiyun.checkBingo.BasketBallTicketModel;
import com.qiyun.checkBingo.SportteryTicketModel;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.model.PassMode;
import com.qiyun.model.SportteryOption;
import com.qiyun.model.SportteryPassType;
import com.qiyun.model.basketball.BasketBallBetContent;
import com.qiyun.model.basketball.BasketBallMatchItem;
import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.model2.Ticket2WithBLOBs;
import com.qiyun.utils.CommonUtils;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SportteryBasketDgtzChaiPiao {


    public List<Ticket2WithBLOBs> chaiPiao(final LotteryPlan2WithBLOBs lotteryPlan) throws Exception {
        List<Ticket2WithBLOBs> ticketList = new ArrayList<Ticket2WithBLOBs>();
        List<Ticket2WithBLOBs> tempTicketList = null;
        tempTicketList = getLqDgtzTicketList(lotteryPlan);
        // 处理倍数
        for (Ticket2WithBLOBs t : tempTicketList) {
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
            String content = t.getContent();
            BasketBallTicketModel btm = CommonUtils.Object4TikectJson(content, BasketBallTicketModel.class, BasketBallMatchItem.class);

            btm.setMultiple(t.getMultiple());
            JSONObject jsonObject = JSONObject.fromObject(btm);
            t.setContent(jsonObject.toString());
            tempList.add(t);
        }
        return tempList;

    }

    public List<Ticket2WithBLOBs> getLqDgtzTicketList(final LotteryPlan2WithBLOBs lotteryPlan) throws Exception {
        final BasketBallBetContent model = CommonUtils.Object4Json(lotteryPlan.getContent(), getModelClass(), getMatchItemClass());
        final List<BasketBallMatchItem> matchItems = (List<BasketBallMatchItem>) model.getMatchItems();
        List<Ticket2WithBLOBs> ticketList = new ArrayList<Ticket2WithBLOBs>();
        for (BasketBallMatchItem x : matchItems) {
            List<SportteryOption> sportteryOptionList = new ArrayList<SportteryOption>();
            for(SportteryOption sportteryOption : x.getOptions()){
                sportteryOptionList.add(sportteryOption);
            }

            for(SportteryOption opt : sportteryOptionList){
                List<SportteryOption> list = new ArrayList<SportteryOption>();
                list.add(opt);

                //每个选项一张票
                int multiple=opt.getBetMoney()/opt.getEach()*lotteryPlan.getMultiple(); //把投注金额拆成实际倍数

                SportteryTicketModel<BasketBallMatchItem> ticketModel = new SportteryTicketModel<BasketBallMatchItem>();
                ticketModel.setPassMode(PassMode.SINGLE.ordinal());
                ticketModel.setMultiple(multiple);
                ticketModel.setPassType(SportteryPassType.P1);
                List<BasketBallMatchItem> tmpList=new ArrayList<BasketBallMatchItem>();
                BasketBallMatchItem bb = new BasketBallMatchItem();
                bb.setIntTime(x.getIntTime());
                bb.setLineId(x.getLineId());
                bb.setOptions(list);
                bb.setShedan(x.isShedan());
                bb.setDXF(x.getDXF());
                bb.setRF(x.getRF());
                bb.setOptions(list);

                tmpList.add(bb);
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

    public Class<BasketBallBetContent> getModelClass() {
        return BasketBallBetContent.class;
    }
    public Class<BasketBallMatchItem> getMatchItemClass() {
        return BasketBallMatchItem.class;
    }
}
