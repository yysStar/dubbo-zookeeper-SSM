package com.qiyun.mapper;

import com.qiyun.model.XxPayApply;
import com.qiyun.model.XxPayApplyQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XxPayApplyMapper {
    int countByExample(XxPayApplyQuery example);

    int deleteByExample(XxPayApplyQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(XxPayApply record);

    int insertSelective(XxPayApply record);

    List<XxPayApply> selectByExample(XxPayApplyQuery example);

    XxPayApply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XxPayApply record, @Param("example") XxPayApplyQuery example);

    int updateByExample(@Param("record") XxPayApply record, @Param("example") XxPayApplyQuery example);

    int updateByPrimaryKeySelective(XxPayApply record);

    int updateByPrimaryKey(XxPayApply record);
}