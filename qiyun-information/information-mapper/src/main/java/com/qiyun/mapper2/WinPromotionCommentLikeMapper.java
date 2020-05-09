package com.qiyun.mapper2;

import com.qiyun.model2.WinPromotionCommentLike;
import com.qiyun.model2.WinPromotionCommentLikeExample;
import java.util.List;

public interface WinPromotionCommentLikeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WinPromotionCommentLike record);

    int insertSelective(WinPromotionCommentLike record);

    List<WinPromotionCommentLike> selectByExample(WinPromotionCommentLikeExample example);

    WinPromotionCommentLike selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WinPromotionCommentLike record);

    int updateByPrimaryKey(WinPromotionCommentLike record);

    int likeCommentCount(Integer planNo);
}