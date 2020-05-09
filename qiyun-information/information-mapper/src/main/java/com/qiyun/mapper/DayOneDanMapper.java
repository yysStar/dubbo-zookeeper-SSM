package com.qiyun.mapper;

import com.qiyun.model.DayOneDan;
import com.qiyun.model.DayOneDanQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DayOneDanMapper {
    int countByExample(DayOneDanQuery example);

    int deleteByExample(DayOneDanQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(DayOneDan record);

    int insertSelective(DayOneDan record);

    List<DayOneDan> selectByExampleWithBLOBs(DayOneDanQuery example);

    List<DayOneDan> selectByExample(DayOneDanQuery example);

    DayOneDan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DayOneDan record, @Param("example") DayOneDanQuery example);

    int updateByExampleWithBLOBs(@Param("record") DayOneDan record, @Param("example") DayOneDanQuery example);

    int updateByExample(@Param("record") DayOneDan record, @Param("example") DayOneDanQuery example);

    int updateByPrimaryKeySelective(DayOneDan record);

    int updateByPrimaryKeyWithBLOBs(DayOneDan record);

    int updateByPrimaryKey(DayOneDan record);
}