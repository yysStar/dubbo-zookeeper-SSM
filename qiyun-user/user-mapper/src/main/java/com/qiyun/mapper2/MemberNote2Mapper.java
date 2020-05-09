package com.qiyun.mapper2;

import com.qiyun.model2.MemberNote2;
import com.qiyun.model2.MemberNote2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberNote2Mapper {
    int countByExample(MemberNote2Query example);

    int deleteByExample(MemberNote2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberNote2 record);

    int insertSelective(MemberNote2 record);

    List<MemberNote2> selectByExample(MemberNote2Query example);

    MemberNote2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberNote2 record, @Param("example") MemberNote2Query example);

    int updateByExample(@Param("record") MemberNote2 record, @Param("example") MemberNote2Query example);

    int updateByPrimaryKeySelective(MemberNote2 record);

    int updateByPrimaryKey(MemberNote2 record);
}