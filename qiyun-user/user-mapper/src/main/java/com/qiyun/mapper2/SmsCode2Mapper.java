package com.qiyun.mapper2;

import com.qiyun.model2.SmsCode2;
import com.qiyun.model2.SmsCode2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsCode2Mapper {
    int countByExample(SmsCode2Query example);

    int deleteByExample(SmsCode2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(SmsCode2 record);

    int insertSelective(SmsCode2 record);

    List<SmsCode2> selectByExample(SmsCode2Query example);

    SmsCode2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SmsCode2 record, @Param("example") SmsCode2Query example);

    int updateByExample(@Param("record") SmsCode2 record, @Param("example") SmsCode2Query example);

    int updateByPrimaryKeySelective(SmsCode2 record);

    int updateByPrimaryKey(SmsCode2 record);
}