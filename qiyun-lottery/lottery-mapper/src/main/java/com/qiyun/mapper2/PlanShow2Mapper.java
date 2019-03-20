package com.qiyun.mapper2;

import com.qiyun.model2.PlanShow2;
import com.qiyun.model2.PlanShow2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlanShow2Mapper {
    int countByExample(PlanShow2Query example);

    int deleteByExample(PlanShow2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(PlanShow2 record);

    int insertSelective(PlanShow2 record);

    List<PlanShow2> selectByExampleWithBLOBs(PlanShow2Query example);

    List<PlanShow2> selectByExample(PlanShow2Query example);

    PlanShow2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PlanShow2 record, @Param("example") PlanShow2Query example);

    int updateByExampleWithBLOBs(@Param("record") PlanShow2 record, @Param("example") PlanShow2Query example);

    int updateByExample(@Param("record") PlanShow2 record, @Param("example") PlanShow2Query example);

    int updateByPrimaryKeySelective(PlanShow2 record);

    int updateByPrimaryKeyWithBLOBs(PlanShow2 record);

    int updateByPrimaryKey(PlanShow2 record);
}