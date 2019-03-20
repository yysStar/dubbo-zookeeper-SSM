package com.qiyun.mapper2;

import com.qiyun.model2.LotteryPlanLike;
import com.qiyun.model2.LotteryPlanLikeExample;
import java.util.List;

public interface LotteryPlanLikeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LotteryPlanLike record);

    int insertSelective(LotteryPlanLike record);

    List<LotteryPlanLike> selectByExample(LotteryPlanLikeExample example);

    LotteryPlanLike selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LotteryPlanLike record);

    int updateByPrimaryKey(LotteryPlanLike record);

    int likeCommentCount(Integer planNo);
}