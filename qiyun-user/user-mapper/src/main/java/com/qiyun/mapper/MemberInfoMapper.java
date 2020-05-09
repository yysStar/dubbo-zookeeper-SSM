package com.qiyun.mapper;

import com.qiyun.model.MemberInfo;
import com.qiyun.model.MemberInfoQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberInfoMapper {
    int countByExample(MemberInfoQuery example);

    int deleteByExample(MemberInfoQuery example);

    int deleteByPrimaryKey(Integer memberId);

    int insert(MemberInfo record);

    int insertSelective(MemberInfo record);

    List<MemberInfo> selectByExample(MemberInfoQuery example);

    MemberInfo selectByPrimaryKey(Integer memberId);

    int updateByExampleSelective(@Param("record") MemberInfo record, @Param("example") MemberInfoQuery example);

    int updateByExample(@Param("record") MemberInfo record, @Param("example") MemberInfoQuery example);

    int updateByPrimaryKeySelective(MemberInfo record);

    int updateByPrimaryKey(MemberInfo record);
}