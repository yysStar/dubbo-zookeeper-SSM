package com.qiyun.mapper;

import com.qiyun.model.PayOrder;
import com.qiyun.model.PayOrderQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayOrderMapper {
    int countByExample(PayOrderQuery example);

    int deleteByExample(PayOrderQuery example);

    int deleteByPrimaryKey(String id);

    int insert(PayOrder record);

    int insertSelective(PayOrder record);

    List<PayOrder> selectByExample(PayOrderQuery example);

    PayOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PayOrder record, @Param("example") PayOrderQuery example);

    int updateByExample(@Param("record") PayOrder record, @Param("example") PayOrderQuery example);

    int updateByPrimaryKeySelective(PayOrder record);

    int updateByPrimaryKey(PayOrder record);
}