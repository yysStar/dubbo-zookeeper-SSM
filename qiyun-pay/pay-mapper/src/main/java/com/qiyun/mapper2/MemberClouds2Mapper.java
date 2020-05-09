package com.qiyun.mapper2;

import com.qiyun.model2.MemberClouds2;
import com.qiyun.model2.MemberClouds2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberClouds2Mapper {
    int countByExample(MemberClouds2Query example);

    int deleteByExample(MemberClouds2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberClouds2 record);

    int insertSelective(MemberClouds2 record);

    List<MemberClouds2> selectByExample(MemberClouds2Query example);

    MemberClouds2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberClouds2 record, @Param("example") MemberClouds2Query example);

    int updateByExample(@Param("record") MemberClouds2 record, @Param("example") MemberClouds2Query example);

    int updateByPrimaryKeySelective(MemberClouds2 record);

    int updateByPrimaryKey(MemberClouds2 record);
}