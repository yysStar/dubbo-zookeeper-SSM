package com.qiyun.service;


import java.util.Map;


public interface CommentService {

    Map<String, Object> getUnreviewedWinCommentList(int offset, int pageSize,int id,int type);

    Map<String, Object> shWinComment(String cid,Integer type);

    Map<String, Object> getUnreviewedCommentList(int offset, int pageSize,int id,int type);

    Map<String, Object> shComment(String cid,Integer type);

    Map<String, Object> getPromotionCommentList(Integer planNo, String account,int offset, int pageSize,int sort);

    Map<String, Object> likePromotionComment(Integer commentId,String account);

    Map<String, Object> promotionComment(Integer planNo, String account, String connect);

    Map<String, Object> getUnread(String account);

    Map<String, Object> getLikeWIinCount(String account,Integer planNo);

    Map<String, Object> likeWinPromotion(String account, Integer planNo);

    Map<String, Object> getLikePlanCount(String account,Integer planNo);

    Map<String, Object> likeLotteryPlan(String account, Integer planNo);



    Map<String, Object> likeComment(Integer commentId,String account);

    Map<String, Object> replyComment(Integer commentId, String account, String connect);

    Map<String, Object> getCommentList(Integer planNo, String account,int offset, int pageSize,int sort);

    Map<String, Object> comment(Integer planNo, String account, String connect);

}
