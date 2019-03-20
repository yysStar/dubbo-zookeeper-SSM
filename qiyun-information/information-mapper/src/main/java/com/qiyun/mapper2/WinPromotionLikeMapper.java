package com.qiyun.mapper2;

import com.qiyun.model2.WinPromotionLike;
import com.qiyun.model2.WinPromotionLikeExample;
import java.util.List;

public interface WinPromotionLikeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WinPromotionLike record);

    int insertSelective(WinPromotionLike record);

    List<WinPromotionLike> selectByExample(WinPromotionLikeExample example);

    WinPromotionLike selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WinPromotionLike record);

    int updateByPrimaryKey(WinPromotionLike record);

    int likeCommentCount(Integer planNo);
}