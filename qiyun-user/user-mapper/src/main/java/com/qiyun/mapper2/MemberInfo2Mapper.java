package com.qiyun.mapper2;

import com.qiyun.model2.MemberInfo2;
import com.qiyun.model2.MemberInfo2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberInfo2Mapper {
    int countByExample(MemberInfo2Query example);

    int deleteByExample(MemberInfo2Query example);

    int deleteByPrimaryKey(Integer memberId);

    int insert(MemberInfo2 record);

    int insertSelective(MemberInfo2 record);

    List<MemberInfo2> selectByExample(MemberInfo2Query example);

    MemberInfo2 selectByPrimaryKey(Integer memberId);

    int updateByExampleSelective(@Param("record") MemberInfo2 record, @Param("example") MemberInfo2Query example);

    int updateByExample(@Param("record") MemberInfo2 record, @Param("example") MemberInfo2Query example);

    int updateByPrimaryKeySelective(MemberInfo2 record);

    int updateByPrimaryKey(MemberInfo2 record);
}