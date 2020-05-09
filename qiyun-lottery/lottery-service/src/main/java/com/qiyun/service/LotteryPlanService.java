package com.qiyun.service;

import com.qiyun.common.Result;
import com.qiyun.commonModel.LotteryTerm;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.commonModel.Platform;
import com.qiyun.dto.*;
import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.model2.*;
import com.qiyun.lottery.LotteryPlan;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface LotteryPlanService {
    LotteryPlan2WithBLOBs getByPlanNo(Integer planNo);

    Result insert(LotteryPlan2WithBLOBs lotteryPlan2WithBLOBs);

    List<Map> querySuperLotteryPlan(int page,int pageSize,String type,String username,int sortType,Integer isFocus,String account);

    Result getPlanDetail(Integer planNo, Member2DTO member2DTO);

    Result getCopyPlanList(Integer planNo);

    void update(LotteryPlan2WithBLOBs byPlanNo);

    List<Member2ForSumprize> xyHall(int page, int pageSize, int day);

    Map<String,Object> getIsFocusPlan(Integer planNo);

    Map<String,Object> getPlanByNoPay(String account,int page,int pageSize);

    List<LotteryPlan> findMuchTicketList(Date date, List<Integer> ltypeList);
	
    Map<String, Object> selectLotteryPlanByMap(Map<String, Object> map);

    List<LotteryPlan2WithBLOBs> getByTypeAndTermAndTimeForReturnPrize(int value, String term, Date time);

    List<LotteryPlan2WithBLOBs> getWinPlanByType(int i);

    LotteryTerm findPrintingTermByLotteryType(Integer lotType);

    List<LotteryPlan2WithBLOBs> findByLotteryTypeAndTermsAndPlanTicketStatus(LotteryType lotType, int i, String term);

    void updateLotteryPlan(LotteryPlan2 lotteryPlan);

    int getTicketCount(LotteryPlan2 lotteryPlan);
	
    List<Ticket2> findTicketByPlanNo(Integer planNo);

    int countTicketNotSuccess(Integer planNo);

    int getFailCount(LotteryPlan2 lotteryPlan);

    void updateSuccess(Ticket2 ticket2);

    List<Ticket2> findByOutId(String orderId);

    TicketFindNew2 getByCopyPlanNo(Integer planNo);

    void updateTicketStatus(TicketFindNew2 findNew);

    List<String> getSuperManAccount(String account);

    void buildTodayPrizeInfo(LotteryType lotteryType, String s);

    List<LotteryPlan2WithBLOBs> getByIsAbleTicketingAndPlanTicketStatus(Integer type, int value, int value1);

    List<LotteryPlan2WithBLOBs> getByTypeAndPlanTicketStatus(Integer type, int value);

    List<EvenTheRedMemberDTO> getEvenTheRedList(int i, int i1, int i2);

    List<LotteryPlan2WithBLOBs> getByPlanStatus(int value);

    Integer getEvenRedByAccount(String account);
}
