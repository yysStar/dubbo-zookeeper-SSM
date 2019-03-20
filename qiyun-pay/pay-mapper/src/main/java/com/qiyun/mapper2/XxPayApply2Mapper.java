package com.qiyun.mapper2;

import com.qiyun.model2.XxPayApply2;
import com.qiyun.model2.XxPayApply2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XxPayApply2Mapper {
    int countByExample(XxPayApply2Query example);

    int deleteByExample(XxPayApply2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(XxPayApply2 record);

    int insertSelective(XxPayApply2 record);

    List<XxPayApply2> selectByExample(XxPayApply2Query example);

    XxPayApply2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XxPayApply2 record, @Param("example") XxPayApply2Query example);

    int updateByExample(@Param("record") XxPayApply2 record, @Param("example") XxPayApply2Query example);

    int updateByPrimaryKeySelective(XxPayApply2 record);

    int updateByPrimaryKey(XxPayApply2 record);
}