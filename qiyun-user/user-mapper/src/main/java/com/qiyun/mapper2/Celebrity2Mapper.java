package com.qiyun.mapper2;

import com.qiyun.model2.Celebrity2;
import com.qiyun.model2.Celebrity2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface Celebrity2Mapper {
    int countByExample(Celebrity2Query example);

    int deleteByExample(Celebrity2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(Celebrity2 record);

    int insertSelective(Celebrity2 record);

    List<Celebrity2> selectByExample(Celebrity2Query example);

    Celebrity2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Celebrity2 record, @Param("example") Celebrity2Query example);

    int updateByExample(@Param("record") Celebrity2 record, @Param("example") Celebrity2Query example);

    int updateByPrimaryKeySelective(Celebrity2 record);

    int updateByPrimaryKey(Celebrity2 record);

    @Update("delete from celebrity ")
    void delete();
}