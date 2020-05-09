package com.qiyun.mapper2;

import com.qiyun.model2.CreditLimitLine2;
import com.qiyun.model2.CreditLimitLine2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditLimitLine2Mapper {
    int countByExample(CreditLimitLine2Query example);

    int deleteByExample(CreditLimitLine2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(CreditLimitLine2 record);

    int insertSelective(CreditLimitLine2 record);

    List<CreditLimitLine2> selectByExample(CreditLimitLine2Query example);

    CreditLimitLine2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CreditLimitLine2 record, @Param("example") CreditLimitLine2Query example);

    int updateByExample(@Param("record") CreditLimitLine2 record, @Param("example") CreditLimitLine2Query example);

    int updateByPrimaryKeySelective(CreditLimitLine2 record);

    int updateByPrimaryKey(CreditLimitLine2 record);

    List<CreditLimitLine2> selectLimtLine(@Param("list") List<String> dlList);
}