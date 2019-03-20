package com.qiyun.serviceImpl;

import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.model.*;
import com.qiyun.model.basketball.BasketBallMatch;
import com.qiyun.service.BasketBetService;
import com.qiyun.support.SportteryFootBallPlayType;
import com.qiyun.tools.DateTools;
import com.qiyun.commonModel.LotteryType;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("basketBetService")
public class BasketBetServiceImpl implements BasketBetService {

    public List<BasketBallMatch> findMatchListByToday(
            LotteryType lotteryType,Object playType, PassMode passMode) {
        int i=-1;
        boolean isFb=true;
        int timeOffset=10;
        if (playType instanceof SportteryFootBallPlayType) {
            i= ((SportteryFootBallPlayType) playType).ordinal();
            isFb=true;
            timeOffset=10;
        }else {
            isFb=false;
            i=((BasketBallPlayType) playType).ordinal();
            timeOffset=11;
        }
        Calendar c = Calendar.getInstance();
        int hour=c.get(Calendar.HOUR_OF_DAY);
        if(hour<timeOffset){
            c.add(Calendar.DAY_OF_MONTH, -1);//小于早上10点..取前一天早上10点开始的数据
        }
        c.set(Calendar.HOUR_OF_DAY, timeOffset);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        Date date=c.getTime();
//        DetachedCriteria criteria = DetachedCriteria.forClass(matchClass);
//        criteria.add(Restrictions.ge("matchTime", date));
        if(lotteryType==LotteryType.JC_ZQ_ALTERNATIVE){
//            criteria.add(Restrictions.or(Restrictions.eq("concede", 1), Restrictions.eq("concede", -1)));
            String sfText = FootBallPlayType.SF.ordinal()+ "" + passMode.ordinal();//胜平负
            String rqspfText = FootBallPlayType.RFSF.ordinal()+ "" + passMode.ordinal();//让球胜平负
            MatchShowStatusFb statusFb = MatchShowStatusFb.getMatchShowStatusByppText(sfText);
            MatchShowStatusFb statusFb2 = MatchShowStatusFb.getMatchShowStatusByppText(rqspfText);
//            Criterion c1=Restrictions.sqlRestriction("CAST(({alias}.showNum & " + (1 << statusFb.getValue()) + ") AS SIGNED INTEGER)>0 ");
//            Criterion c2=Restrictions.sqlRestriction("CAST(({alias}.showNum &" + (1 << statusFb2.getValue()) + ") AS SIGNED INTEGER)>0 ");
//            criteria.add(c1);
//            criteria.add(c2);
        }else if(!LotteryType.JC_HT_LIST.contains(lotteryType)){
            String pptext = i+ "" + passMode.ordinal();
            if(isFb){
                MatchShowStatusFb statusFb = MatchShowStatusFb.getMatchShowStatusByppText(pptext);
//                criteria.add(Restrictions.sqlRestriction("CAST(({alias}.showNum &" + (1 << statusFb.getValue()) + ") AS SIGNED INTEGER)>0 "));
            }else{
                MatchShowStatus statusLq=MatchShowStatus.getMatchShowStatusByppText(pptext);
//                criteria.add(Restrictions.sqlRestriction("CAST(({alias}.showNum &" + (1 << statusLq.getValue()) + ") AS SIGNED INTEGER)>0 "));
            }
        }else if(LotteryType.JC_ZQ_DGTZ==lotteryType || LotteryType.JC_LQ_DGTZ==lotteryType){
//            criteria=DetachedCriteria.forClass(matchClass);
            //回查前3天的记录
            Calendar today=Calendar.getInstance();
            today.add(Calendar.DATE, -3);
            Integer intTime= Integer.parseInt(DateTools.dateToString(today.getTime(),"yyyyMMdd"));
//            criteria.add(Restrictions.ge("intTime", intTime));
        }
//        criteria.addOrder(Order.asc("intTime"));
//        criteria.addOrder(Order.asc("lineId"));
//        String dd =criteria.toString();
        return null;
    }

    public Map<Integer, AbstractAward> findMatchAwardMap(List<Integer> matchIdList, PassMode pass, LotteryType lotteryType) {
        return null;
    }

    public List<AbstractAward> findForBbHTAwardByIntTime(List<String> intTimeList, int ordinal) {
        return null;
    }

    public List<AbstractAward> findForBbAwardByIntTime(String s, Integer pType, int ordinal) {
        return null;
    }

    public List<BasketBallMatch> findMatchListBetweenIntTimes(Integer bgintTime, Integer edintTime) {
        return null;
    }
}
