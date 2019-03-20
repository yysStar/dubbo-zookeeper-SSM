package com.qiyun.mapper2;

import com.qiyun.model2.DayOneDan2;
import com.qiyun.model2.DayOneDan2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DayOneDan2Mapper {
    int countByExample(DayOneDan2Query example);

    int deleteByExample(DayOneDan2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(DayOneDan2 record);

    int insertSelective(DayOneDan2 record);

    List<DayOneDan2> selectByExampleWithBLOBs(DayOneDan2Query example);

    List<DayOneDan2> selectByExample(DayOneDan2Query example);

    DayOneDan2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DayOneDan2 record, @Param("example") DayOneDan2Query example);

    int updateByExampleWithBLOBs(@Param("record") DayOneDan2 record, @Param("example") DayOneDan2Query example);

    int updateByExample(@Param("record") DayOneDan2 record, @Param("example") DayOneDan2Query example);

    int updateByPrimaryKeySelective(DayOneDan2 record);

    int updateByPrimaryKeyWithBLOBs(DayOneDan2 record);

    int updateByPrimaryKey(DayOneDan2 record);

    List<DayOneDan2> getByNumber(int number);

    DayOneDan2 selectOne();

    DayOneDan2 selectTwo();

}