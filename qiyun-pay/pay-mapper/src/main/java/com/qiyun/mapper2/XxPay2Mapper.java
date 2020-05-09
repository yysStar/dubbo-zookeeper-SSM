package com.qiyun.mapper2;

import com.qiyun.model2.XxPay2;
import com.qiyun.model2.XxPay2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XxPay2Mapper {
    int countByExample(XxPay2Query example);

    int deleteByExample(XxPay2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(XxPay2 record);

    int insertSelective(XxPay2 record);

    List<XxPay2> selectByExample(XxPay2Query example);

    XxPay2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XxPay2 record, @Param("example") XxPay2Query example);

    int updateByExample(@Param("record") XxPay2 record, @Param("example") XxPay2Query example);

    int updateByPrimaryKeySelective(XxPay2 record);

    int updateByPrimaryKey(XxPay2 record);
}