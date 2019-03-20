package com.qiyun.mapper;

import com.qiyun.model.SZ2C1;
import com.qiyun.model.SZ2C1Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SZ2C1Mapper {
    int countByExample(SZ2C1Query example);

    int deleteByExample(SZ2C1Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(SZ2C1 record);

    int insertSelective(SZ2C1 record);

    List<SZ2C1> selectByExample(SZ2C1Query example);

    SZ2C1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SZ2C1 record, @Param("example") SZ2C1Query example);

    int updateByExample(@Param("record") SZ2C1 record, @Param("example") SZ2C1Query example);

    int updateByPrimaryKeySelective(SZ2C1 record);

    int updateByPrimaryKey(SZ2C1 record);
}