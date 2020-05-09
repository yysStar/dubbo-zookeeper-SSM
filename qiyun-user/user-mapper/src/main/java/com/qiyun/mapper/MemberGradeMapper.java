package com.qiyun.mapper;

import com.qiyun.model.MemberGrade;
import com.qiyun.model.MemberGradeQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberGradeMapper {
    int countByExample(MemberGradeQuery example);

    int deleteByExample(MemberGradeQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberGrade record);

    int insertSelective(MemberGrade record);

    List<MemberGrade> selectByExample(MemberGradeQuery example);

    MemberGrade selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberGrade record, @Param("example") MemberGradeQuery example);

    int updateByExample(@Param("record") MemberGrade record, @Param("example") MemberGradeQuery example);

    int updateByPrimaryKeySelective(MemberGrade record);

    int updateByPrimaryKey(MemberGrade record);
}