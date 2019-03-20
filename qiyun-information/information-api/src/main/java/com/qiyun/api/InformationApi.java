package com.qiyun.api;

import com.qiyun.common.Result;
import com.qiyun.dto.Member2DTO;

import java.util.Map;


public interface InformationApi {

    Map<String, Object> getBasketballLineup(String id);

    Map<String, Object> getInformation();

    Map<String, Object> getFootballMatch(int offset,int pageSize,int type);

    Map<String, Object> getBaskballScheduleResult(String date,int offset,int pageSize);

    Map<String, Object> getFootballScheduleResult(String date,int offset,int pageSize);

    Map<String, Object> getBasketballRank(String id);

    Map<String, Object> getBasketballLiveCount(String id);

    Map<String, Object> getBasketballLive(String id);

    Map<String, Object> getFootballLive(String id);

    Map<String, Object> getFootballTeam(String id);

    Map<String, Object> getBasketballTeam(String id);

    Map<String, Object> getNowTimeFootaballScore();

    Map<String, Object> getNowTimeBasketballScore();

    Map<String, Object> getNowDayBasketballScore(int offset,int pageSize);

    Map<String, Object> getNowDayFootaballScore(String language,int offset,int pageSize);

    Map<String, Object> getPromotionCommentList(Integer planNo, String account,int offset, int pageSize,int sort);

    Map<String, Object> likePromotionComment(Integer commentId,String account);

    Map<String, Object> promotionComment(Integer planNo,String account,String connect);

    Map<String, Object> getUnread(String account);

    Map<String, Object> getLikeWIinCount(String account,Integer planNo);

    Map<String, Object> likeWinPromotion(String account, Integer planNo);

    Map<String, Object> getLikePlanCount(String account,Integer planNo);

    Map<String, Object> likeLotteryPlan(String account,Integer planNo);

    Map<String, Object> likeComment(Integer commentId,String account);

    Map<String, Object> replyComment(Integer commentId, String account,String connect);

    Map<String, Object> getCommentList(Integer planNo, String account,int offset, int pageSize,int sort);

    Map<String, Object> comment(Integer planNo,String account,String connect);

    Result getOpenResult();

    Result getBasketBallOpenResult(String pageSize);

    Result getFootBallOpenResult(String pageSize);

    Result getNewsDetailById(String id);

    Result getLatestNews();

    Result getBasketBallAndFootBallNews();

    Result getNewsByTypeId(int typeId, int pageSize);

    Map<String, Object> getDayOneDanByNumber(int number);

    Result getSZ2C1ByNumber(int number);

    Result  getMemberInfoForCelebrity();

    Map<String, Object> like(String hostHolder,String account);

    Map<String, Object> disLike(String hostHolder,String account);

    Map<String, Object> getIsLike(String hostHolder,String account);

    Map<String, Object> getDigitalColor(int type);

    Map<String, Object> getFrequencyColor(int type);

    Map<String, Object> getSportsColor();

    Map<String, Object> getOneFootBallColor(int intTime);

    Map<String, Object> getOneBasketBallColor(int intTime);

    Map<String, Object> getTen(int intTime);

    Map<String, Object> getOneDigitalColor(int type,String term);

    Map<String,Object> addMail(String title,String content,int type,String target,String author,int status);

    Map<String,Object> getNewMail(Member2DTO member2DTO);

}
