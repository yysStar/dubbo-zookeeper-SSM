package com.qiyun.mapper2;

import com.qiyun.model2.SZ2C12;
import com.qiyun.model2.SZ2C12Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SZ2C12Mapper {
    int countByExample(SZ2C12Query example);

    int deleteByExample(SZ2C12Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(SZ2C12 record);

    int insertSelective(SZ2C12 record);

    List<SZ2C12> selectByExample(SZ2C12Query example);

    SZ2C12 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SZ2C12 record, @Param("example") SZ2C12Query example);

    int updateByExample(@Param("record") SZ2C12 record, @Param("example") SZ2C12Query example);

    int updateByPrimaryKeySelective(SZ2C12 record);

    int updateByPrimaryKey(SZ2C12 record);

}