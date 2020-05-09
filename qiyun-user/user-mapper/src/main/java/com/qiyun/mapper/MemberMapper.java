package com.qiyun.mapper;

import com.qiyun.dto.SuperGodDTO;
import com.qiyun.model.Member;
import com.qiyun.model.MemberQuery;

import java.util.Date;
import java.util.List;

import com.qiyun.model.PayMember;
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

    Member selectByMobileOrAccount(String account);

    Member selectByAccount(String account);

    Member selectByMobile(String mobile);

    List<PayMember> getPayMember();
}