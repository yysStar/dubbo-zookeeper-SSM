package com.qiyun.mapper2;

import com.qiyun.model2.WinPromotionComment;
import com.qiyun.model2.WinPromotionCommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WinPromotionCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WinPromotionComment record);

    int insertSelective(WinPromotionComment record);

    List<WinPromotionComment> selectByExampleWithBLOBs(WinPromotionCommentExample example);

    List<WinPromotionComment> selectByExample(WinPromotionCommentExample example);

    WinPromotionComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WinPromotionComment record);

    int updateByPrimaryKeyWithBLOBs(WinPromotionComment record);

    int updateByPrimaryKey(WinPromotionComment record);

    Integer getFloor(Integer planNo);

    int likePromotionComment(Integer commentId);

    List<WinPromotionComment> getCommentListByTime(@Param("planNo")Integer planNo, @Param("account")String account);

    List<WinPromotionComment> getCommentListByLike(@Param("planNo")Integer planNo,@Param("account")String account);

    int likeComment(Integer commentId);

    int nolikeComment(Integer commentId);
}