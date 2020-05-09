package com.qiyun.mapper;

import com.qiyun.model.Member;
import com.qiyun.model.MemberQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
    int countByExample(MemberQuery example);

    int deleteByExample(MemberQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(Member record);

    int insertSelective(Member record);

    List<Member> selectByExample(MemberQuery example);

    Member selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberQuery example);

    int updateByExample(@Param("record") Member record, @Param("example") MemberQuery example);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    Member selectByAccount(String account);
}