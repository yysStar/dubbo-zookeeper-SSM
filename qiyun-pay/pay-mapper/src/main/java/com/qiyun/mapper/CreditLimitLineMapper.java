package com.qiyun.mapper;

import com.qiyun.model.CreditLimitLine;
import com.qiyun.model.CreditLimitLineQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditLimitLineMapper {
    int countByExample(CreditLimitLineQuery example);

    int deleteByExample(CreditLimitLineQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(CreditLimitLine record);

    int insertSelective(CreditLimitLine record);

    List<CreditLimitLine> selectByExample(CreditLimitLineQuery example);

    CreditLimitLine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CreditLimitLine record, @Param("example") CreditLimitLineQuery example);

    int updateByExample(@Param("record") CreditLimitLine record, @Param("example") CreditLimitLineQuery example);

    int updateByPrimaryKeySelective(CreditLimitLine record);

    int updateByPrimaryKey(CreditLimitLine record);
}