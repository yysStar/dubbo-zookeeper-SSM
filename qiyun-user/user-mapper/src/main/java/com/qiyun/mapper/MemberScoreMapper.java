package com.qiyun.mapper;

import com.qiyun.model.MemberScore;
import java.util.List;

public interface MemberScoreMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_score
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer memberId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_score
     *
     * @mbg.generated
     */
    int insert(MemberScore record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_score
     *
     * @mbg.generated
     */
    MemberScore selectByPrimaryKey(Integer memberId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_score
     *
     * @mbg.generated
     */
    List<MemberScore> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_score
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MemberScore record);
}