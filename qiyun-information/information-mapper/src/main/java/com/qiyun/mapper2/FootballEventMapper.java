package com.qiyun.mapper2;

import com.qiyun.model2.FootballEvent;
import com.qiyun.model2.FootballEventExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FootballEventMapper {
    int insert(FootballEvent record);

    int insertSelective(FootballEvent record);

    List<FootballEvent> selectByExample(FootballEventExample example);

    List<FootballEvent> selectById(Integer id);

    List<FootballEvent> selectById2(String id);

    Integer getMaxVersion(Integer scheduleId);

    List<FootballEvent> selectByIdAndVersion(@Param("id") Integer id, @Param("version")Integer version);

    Integer getMaxVersionCount(@Param("scheduleId")Integer scheduleId,@Param("version")Integer version);
}