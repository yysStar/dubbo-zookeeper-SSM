package com.qiyun.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.qiyun.commonModel.PlayType;
import com.qiyun.dto.Member2DTO;
import com.qiyun.mapper2.LotteryPlan2Mapper;
import com.qiyun.mapper2.SportteryBasketMatch2Mapper;
import com.qiyun.mapper2.SportteryFootballMatch2Mapper;
import com.qiyun.mapper2.Ticket2Mapper;
import com.qiyun.model.*;
import com.qiyun.model.basketball.BasketBallBetContent;
import com.qiyun.model.basketball.BasketBallMatchItem;
import com.qiyun.model2.*;
import com.qiyun.service.TicketService;
import com.qiyun.util.Constants;
import com.qiyun.util.DateUtil;
import com.qiyun.utils.DateUtils;
import com.qiyun.commonModel.LotteryType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("ticketService")
public class TicketServiceImpl implements TicketService {

    @Resource
    private Ticket2Mapper ticket2Mapper;

    @Resource
    private LotteryPlan2Mapper lotteryPlan2Mapper;

    @Resource
    private SportteryFootballMatch2Mapper sportteryFootballMatch2Mapper;

    @Resource
    private SportteryBasketMatch2Mapper sportteryBasketMatch2Mapper;

    public Map<String, Object> getTicketDetail(Integer planNo, Member2DTO member2DTO) {
        Map<String,Object> map = new HashMap<String,Object>();
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        Ticket2Query ticket2Query = new Ticket2Query();
        Ticket2Query.Criteria criteria = ticket2Query.createCriteria();
        criteria.andPlanNoEqualTo(planNo);
        List<Ticket2WithBLOBs> ticket2WithBLOBs = ticket2Mapper.selectByExampleWithBLOBs(ticket2Query);
        LotteryPlan2WithBLOBs lotteryPlan2WithBLOBs = lotteryPlan2Mapper.selectByPlanNo(planNo);

        if (!lotteryPlan2WithBLOBs.getAccount().equals(member2DTO.getAccount())){
            map.put(Constants.CODE,Constants.ERROR_CODE_438);
            map.put(Constants.MSG,Constants.ERROR_MSG_438);
            return map;
        }
        if (ticket2WithBLOBs==null || ticket2WithBLOBs.size()<=0){
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            map.put(Constants.DATA,list);
            return map;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMMdd");
        for (Ticket2WithBLOBs ticket2WithBLOB : ticket2WithBLOBs) {
            Map<String,Object> respMap = new HashMap<String,Object>();
            respMap.put("playType", PlayType.getItem(ticket2WithBLOB.getPlayType()).getName());
            respMap.put("multiple", ticket2WithBLOB.getMultiple());
            respMap.put("amount", ticket2WithBLOB.getAmount());
            respMap.put("bingoAmount", ticket2WithBLOB.getBingoAmount());
            respMap.put("time", sdf.format(lotteryPlan2WithBLOBs.getPrintTicketDateTime()));
            respMap.put("status", TicketStatus.getItem(ticket2WithBLOB.getStatus()).getName());
            respMap.put("few", ticket2WithBLOB.getAmount()/ticket2WithBLOB.getMultiple()/2);
            String content = ticket2WithBLOB.getContent();
            if (LotteryType.JCLQList.contains(LotteryType.getItem(lotteryPlan2WithBLOBs.getLotteryType()))) {
                respMap.put("type","篮球");
                BasketBallBetContent matchItem = JSONObject.parseObject(content, BasketBallBetContent.class);
                List<BasketBallMatchItem> matchItems = matchItem.getMatchItems();
                List<Map<String,Object>> optList = new ArrayList<Map<String, Object>>();
                List<Date> dates = new ArrayList<Date>();
                for (BasketBallMatchItem item : matchItems) {
                    Integer lineId = item.getLineId();
                    Integer intTime = item.getIntTime();
                    SportteryBasketMatch2 basketMatch2 = sportteryBasketMatch2Mapper.getByIntTimeAndLineId(intTime,lineId);
                    dates.add(basketMatch2.getMatchtime());
                    Date parse = null;
                    String matchId = null;
                    try {
                        parse = dateFormater.parse(intTime + "");
                        String weekOfDate = DateUtil.getWeekForDate(parse);
                        String lineIdStr = "";
                        if (lineId<10){
                            lineIdStr = "00"+lineId;
                        }else if (lineId<100){
                            lineIdStr = "0"+lineId;
                        }else{
                            lineIdStr = ""+lineId;
                        }
                        matchId = weekOfDate+" "+lineIdStr;
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    for (SportteryOption option : item.getOptions()) {
                        Map<String,Object> optMap = new HashMap<String,Object>();
                        optMap.put("matchId",matchId);
                        optMap.put("lotteryType", LotteryType.getItem(Integer.parseInt(option.getType())).getName());
                        optMap.put("award",option.getAward());
                        optMap.put("opt",option.getTypeValueStr());
                        optMap.put("rf",item.getRF());
                        optMap.put("dxf",item.getDXF());
                        optList.add(optMap);
                    }
                }
                Date dealTime = new Date();
                for (int i = 0; i < dates.size(); i++) {
                     if (i==0){
                         dealTime = dates.get(i);
                     }else{
                        if (dealTime.before(dates.get(i))){
                            dealTime = dates.get(i);
                        }
                     }
                }
                if (lotteryPlan2WithBLOBs.getIsSuperMan()==0) {
                    if (new Date().before(dealTime)) {
                        respMap.put("isShow", false);
                    } else {
                        respMap.put("isShow", true);
                    }
                }else {
                    respMap.put("isShow", true);
                }
                respMap.put("options",optList);
                list.add(respMap);
            }else if (LotteryType.JCZQList.contains(LotteryType.getItem(lotteryPlan2WithBLOBs.getLotteryType()))){
                respMap.put("type","足球");
                FootBallBetContent ftmatchItem = JSONObject.parseObject(content, FootBallBetContent.class);
                List<FootBallMatchItem> matchItems = ftmatchItem.getMatchItems();
                List<Map<String,Object>> optList = new ArrayList<Map<String, Object>>();
                List<Date> dates = new ArrayList<Date>();
                for (FootBallMatchItem item : matchItems) {
                    Integer lineId = item.getLineId();
                    Integer intTime = item.getIntTime();
                    SportteryFootballMatch2 footballMatch2 = sportteryFootballMatch2Mapper.getByIntTimeAndLineId(intTime,lineId);
                    dates.add(footballMatch2.getMatchtime());
                    Date parse = null;
                    String matchId = null;
                    try {
                        parse = dateFormater.parse(intTime + "");
                        String weekOfDate = DateUtil.getWeekForDate(parse);
                        String lineIdStr = "";
                        if (lineId<10){
                            lineIdStr = "00"+lineId;
                        }else if (lineId<100){
                            lineIdStr = "0"+lineId;
                        }else{
                            lineIdStr = ""+lineId;
                        }
                        matchId = weekOfDate+" "+lineIdStr;
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    for (SportteryOption option : item.getOptions()) {
                        Map<String,Object> optMap = new HashMap<String,Object>();
                        optMap.put("matchId",matchId);
                        optMap.put("lotteryType", LotteryType.getItem(Integer.parseInt(option.getType())).getName());
                        optMap.put("award",option.getAward());
                        optMap.put("opt",option.getTypeValueStr());
                        optMap.put("rqs",option.getRqs());
                        optList.add(optMap);
                    }
                }
                Date dealTime = new Date();
                for (int i = 0; i < dates.size(); i++) {
                    if (i==0){
                        dealTime = dates.get(i);
                    }else{
                        if (dealTime.before(dates.get(i))){
                            dealTime = dates.get(i);
                        }
                    }
                }
                if (lotteryPlan2WithBLOBs.getIsSuperMan()==0) {
                    if (new Date().before(dealTime)) {
                        respMap.put("isShow", false);
                    } else {
                        respMap.put("isShow", true);
                    }
                } else {
                    respMap.put("isShow", true);
                }
                respMap.put("options",optList);
                list.add(respMap);

            }
        }

        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,list);
        map.put(Constants.DATA,list);
        return map;
    }

    public List<Ticket2WithBLOBs> getByPlanNo(Integer planNo) {
        Ticket2Query ticket2Query = new Ticket2Query();
        Ticket2Query.Criteria criteria = ticket2Query.createCriteria();
        criteria.andPlanNoEqualTo(planNo);
        List<Ticket2WithBLOBs> ticket2WithBLOBs = ticket2Mapper.selectByExampleWithBLOBs(ticket2Query);
        return ticket2WithBLOBs;
    }

    public void updateTicketByPlanBack(Integer planNo) {
        ticket2Mapper.updateTicketByPlanBack(planNo);
    }

    public void updateStatusByPlanNo(Integer planNo, int status) {
        ticket2Mapper.updateStatusByPlanNo(planNo,status);
    }

    public void update(Ticket2WithBLOBs ticket) {
        ticket2Mapper.updateByPrimaryKeySelective(ticket);
    }

    public void insert(Ticket2WithBLOBs ticket) {
        ticket2Mapper.insertSelective(ticket);
    }

    public void updateForSongPiaoSuccess(Integer planNo) {
        ticket2Mapper.updateForSongPiaoSuccess(planNo);
    }

    public void updateForSongPiaoFail(Integer planNo) {
        ticket2Mapper.updateForSongPiaoFail(planNo);
    }

}
