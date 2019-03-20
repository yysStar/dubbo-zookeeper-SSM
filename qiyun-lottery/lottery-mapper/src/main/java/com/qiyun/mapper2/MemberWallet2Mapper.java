package com.qiyun.mapper2;

import com.qiyun.model2.MemberWallet2;
import com.qiyun.model2.MemberWallet2Query;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberWallet2Mapper {
    int countByExample(MemberWallet2Query example);

    int deleteByExample(MemberWallet2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberWallet2 record);

    int insertSelective(MemberWallet2 record);

    List<MemberWallet2> selectByExample(MemberWallet2Query example);

    MemberWallet2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberWallet2 record, @Param("example") MemberWallet2Query example);

    int updateByExample(@Param("record") MemberWallet2 record, @Param("example") MemberWallet2Query example);

    int updateByPrimaryKeySelective(MemberWallet2 record);

    int updateByPrimaryKey(MemberWallet2 record);

    MemberWallet2 selectByMemberId(int memberId);

    MemberWallet2 getByAccount(String account);
}