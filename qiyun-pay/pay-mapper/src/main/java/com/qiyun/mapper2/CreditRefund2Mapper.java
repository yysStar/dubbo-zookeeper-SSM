package com.qiyun.mapper2;

import com.qiyun.model2.CreditRefund2;
import com.qiyun.model2.CreditRefund2Query;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CreditRefund2Mapper {
    int countByExample(CreditRefund2Query example);

    int deleteByExample(CreditRefund2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(CreditRefund2 record);

    int insertSelective(CreditRefund2 record);

    List<CreditRefund2> selectByExample(CreditRefund2Query example);

    CreditRefund2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CreditRefund2 record, @Param("example") CreditRefund2Query example);

    int updateByExample(@Param("record") CreditRefund2 record, @Param("example") CreditRefund2Query example);

    int updateByPrimaryKeySelective(CreditRefund2 record);

    int updateByPrimaryKey(CreditRefund2 record);

    List<CreditRefund2> getCreditRefund(@Param("paramMap") Map<String,Object> paramMap,@Param("list") List<String> dlList);
}