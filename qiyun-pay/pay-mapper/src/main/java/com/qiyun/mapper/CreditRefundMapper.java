package com.qiyun.mapper;

import com.qiyun.model.CreditRefund;
import com.qiyun.model.CreditRefundQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreditRefundMapper {
    int countByExample(CreditRefundQuery example);

    int deleteByExample(CreditRefundQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(CreditRefund record);

    int insertSelective(CreditRefund record);

    List<CreditRefund> selectByExample(CreditRefundQuery example);

    CreditRefund selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CreditRefund record, @Param("example") CreditRefundQuery example);

    int updateByExample(@Param("record") CreditRefund record, @Param("example") CreditRefundQuery example);

    int updateByPrimaryKeySelective(CreditRefund record);

    int updateByPrimaryKey(CreditRefund record);
}