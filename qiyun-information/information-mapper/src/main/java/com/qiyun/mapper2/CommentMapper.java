package com.qiyun.mapper2;

import com.qiyun.model2.Comment;
import com.qiyun.model2.CommentExample;
import com.qiyun.model2.CommentWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommentWithBLOBs record);

    int insertSelective(CommentWithBLOBs record);

    List<CommentWithBLOBs> selectByExampleWithBLOBs(CommentExample example);

    List<Comment> selectByExample(CommentExample example);

    CommentWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CommentWithBLOBs record);

    int updateByPrimaryKey(Comment record);

    Integer getConsumptionCount(@Param("account")String account, @Param("list")List<Integer>list);

    String getPlanAccount(Integer planNo);

    String getPicture(String account);

    Integer getFloor(Integer planNo);

    List<CommentWithBLOBs> getCommentListByTime(@Param("planNo")Integer planNo, @Param("account")String account);

    List<CommentWithBLOBs> getCommentListByLike(@Param("planNo")Integer planNo,@Param("account")String account);

    int likeComment(Integer commentId);

    int nolikeComment(Integer commentId);

    int getUnread(String account);

    int getLikeCount(Integer planNo);

    String getUsernameByAccount(String account);
}