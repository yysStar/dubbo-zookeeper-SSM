package com.qiyun.mapper2;

import com.qiyun.model2.Commision2;
import com.qiyun.model2.Commision2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Commision2Mapper {
    int countByExample(Commision2Query example);

    int deleteByExample(Commision2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(Commision2 record);

    int insertSelective(Commision2 record);

    List<Commision2> selectByExample(Commision2Query example);

    Commision2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Commision2 record, @Param("example") Commision2Query example);

    int updateByExample(@Param("record") Commision2 record, @Param("example") Commision2Query example);

    int updateByPrimaryKeySelective(Commision2 record);

    int updateByPrimaryKey(Commision2 record);
}