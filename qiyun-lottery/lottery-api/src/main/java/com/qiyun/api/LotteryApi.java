package com.qiyun.api;

import com.qiyun.common.Result;
import com.qiyun.dto.*;
import com.qiyun.model.FootBallMatchItem;
import com.qiyun.model.SportteryBetContentModel;
import com.qiyun.model.basketball.BasketBallMatchItem;
import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.model2.SportteryBasketMatch2;
import com.qiyun.model2.SportteryFootballMatch2;
import com.qiyun.model2.WinPromotion2;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface LotteryApi {
    MemberWallet2DTO getMemberWallet(Member2DTO member2DTO);

    Result copyLotteryPlan(String account,Integer planNo, Integer multiple, Integer amount,Integer cardId,Double cardMoney);

    Map<String,Object> querySuperLotteryPlan(int page, int pageSize, String type,String username,Member2DTO member2DTO,int sortType,Integer c);

    Result getPlanForUserCenter(int planType,Integer lotteryType, Integer planStatus, Integer winStatus, int page, int pageSize,Member2DTO member2DTO);

    Result getTRAmount(int planType,int lotteryType, int planStatus, int winStatus, Member2DTO member2DTO);

    Result getZJAmount(int planType,int lotteryType, int planStatus, int winStatus, Member2DTO member2DTO);

    Result getPlanDetail(Integer planNo,Member2DTO member2DTO);

    Result hisIndex(String account);

    Result getCopyPlanList(Integer planNo);

    Result getPlanMatchDetail(int planNo, String account);

    Map<String,Object> showPlan(int planNo, String title, Member2DTO member2DTO);

    Map<String,Object> passShowPlanApply(int id, int type);

    Map<String,Object> updatePlanShowStatus(int id, int status);

    Map<String,Object> getPlanShow(String account, Integer planNo, Integer type, Integer status, Integer page, Integer pageSize);

    Map<String,Object> getPlanShow2(int page, int pageSize,String account);

    List<Member2ForSumprize> xyHall(int page, int pageSize, int day);

    Map<String,Object> addWinPromotion(String account,String title, String content);

    Map<String,Object> updateWinPromotionStatus(WinPromotion2 winPromotion2);

    Map<String,Object> getWinPromotion(Integer status,int page,int pageSize);

    Map<String,Object> getMostPopular(int page, int pageSize);

    List<EvenTheRedMemberDTO> getEvenTheRedList(int page, int pageSize, int day);

    Map<String,Object> getBetList(int page, int pageSize, int day);

    Map<String,Object> getAShortRed(int page, int pageSize, int day);

    Map<String,Object> addNewStar(String[] accounts);

    Map<String,Object> getNewStar(int dan);

    Map<String,Object> autoCopyPlan(Integer planNo, Integer time, Integer count);

    List<BasketBallMatchDTO> getBasketBallMatch(int isFocus);

    List<Map<String,Object>> findFootballMixureInfo(int isFocus);

    Map<String,Object> findFootballMixureMoreInfo(String matchId);

    Map<String,Object> dg(Map<String, Object> reqMap);

    Map<String,Object> getTicketDetail(Integer planNo,Member2DTO member2DTO);

    Map<String,Object> setBbFocusMatch(Integer[] ids);

    Map<String,Object> setFbFocusMatch(Integer[] ids);

    Map<String,Object> setAddPrize(Integer lotteryType, double rate, double minAmount, Integer[] playTypes);

    Map<String,Object> setAddPrizeBlackOrWhite(Integer[] ids, Integer type);

    Map<String,Object> getAddPrizeBlack(String account, int page, int pageSize);

    Map<String,Object> getMatchDealTime();

    Map<String,Object> updateMatchDealTime(Integer dealTime);

    Map<String,Object> getMaxAddPrize();

    Map<String,Object> updateMaxAddPrize(double v);

    Map<String,Object> getAddPirzeConfigList(int page, int pageSize);

    Map<String,Object> updateAddPirzeConfig(Integer lotteryType, double v, double v1, int[] playTypes);

    Map<String,Object> updateBbFocusMatchStatus(Integer id);

    Map<String,Object> updateFbFocusMatchStatus(Integer id);

    Map<String,Object> copyPlan(Integer planNo);

    Map<String,Object> getIsFocusPlan(Integer planNo);

    Map<String,Object> setMemberTicket(String account, int status);

    Map<String,Object> getMemberTicket(int page, int pageSize);

    void openDG(int status);

    Map<String,Object> updateDGByStatus(Date time, int status);

    Map<String,Object> superLottoDG(Map<String, Object> reqMap);

    Map<String,Object> getPlanByNoPay(String account,int page,int pageSize);

    Map<String,Object> dgForNoPay(Member2DTO member2DTO, Double amount, Integer planNo, Integer cardId, double cardMoney);

    Map<String,Object> getNumberTerm();

    Map<String,Object> getAutoCopyPlanStatus(int type);

    Map<String,Object> setAutoCopyPlanStatus(int type, int status);

    Map<String,Object> updatePlanDesc(Integer planNo, String desc);

    Map<String,Object> addLotteryLimit(String content, Integer lotteryType, String passType);

    Map<String,Object> getLotteryLimit(int page, int pageSize);

    Map<String,Object> updateLotteryLimitStatus(Integer id, Integer status);

    Map<String,Object> selectLotteryPlan(Map<String, Object> map);

    Map<String,Object> planBack(Integer planNo);

    Map<String,Object> updatePlanStatus(Integer planNo);

    Map<String,Object> openResult(String lotteryTypes);

    Map<String,Object> getWinPlanByType(String lotteryTypes);

    Map<String,Object> returnPrize(String plans);

    Map<String,Object> getBasketBallAdmin(Integer intTime);

    Map<String,Object> getFootBallAdmin(Integer intTime);

    Map<String,Object> updateFootBallAdmin(SportteryFootballMatch2 footballMatch2);

    Map<String,Object> updateBasketBallAdmin(SportteryBasketMatch2 basketMatch2);

    Map<String,Object> getLotteryTypeIsSale();

    void setCommision (LotteryPlan2WithBLOBs lotteryPlan2WithBLOBs);

    Map<String,Object> updateLotteryTypeIsSale(String lotteryType, Integer status);

    Map<String,Object> bonusPrediction(Map<String,Object> map);

    Map<String,Object> getPlanByMatch(Integer intTime, Integer lineId);

    void updateFootBallMatch();

    void updateBasketBallMatch();

    Map<String,Object> getPlanDetailForManager(int planNo);

    List<String> getPlanTicketDetail(int planNo);

    Map<String,Object> checkMatch(int lotteryType, String[] passType, List<BasketBallMatchItem> matchItems, List<FootBallMatchItem> ftmatchItems, SportteryBetContentModel bc, Integer betCount);

    Integer getLotteryTerm(Integer lotteryType);

    void addSalesCount(LotteryPlan2WithBLOBs lotteryPlan);

    Map<String,Object>  getDlAndQdAccount(Member2DTO member2DTO);

}
