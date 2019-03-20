package com.qiyun.mapper2;

import com.qiyun.model2.MemberGrade2;
import com.qiyun.model2.MemberGrade2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberGrade2Mapper {
    int countByExample(MemberGrade2Example example);

    int deleteByExample(MemberGrade2Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberGrade2 record);

    int insertSelective(MemberGrade2 record);

    List<MemberGrade2> selectByExample(MemberGrade2Example example);

    MemberGrade2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberGrade2 record, @Param("example") MemberGrade2Example example);

    int updateByExample(@Param("record") MemberGrade2 record, @Param("example") MemberGrade2Example example);

    int updateByPrimaryKeySelective(MemberGrade2 record);

    int updateByPrimaryKey(MemberGrade2 record);

    MemberGrade2 selectByAccount(String account);
}