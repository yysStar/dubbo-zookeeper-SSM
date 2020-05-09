package com.qiyun.mapper2;

import com.qiyun.model.FootballGame;
import com.qiyun.model2.FootballGameName;
import com.qiyun.model2.FootballGameNameExample;
import java.util.List;

public interface FootballGameNameMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FootballGameName record);

    int insertSelective(FootballGameName record);

    List<FootballGameName> selectByExampleWithBLOBs(FootballGameNameExample example);

    List<FootballGameName> selectByExample(FootballGameNameExample example);

    FootballGameName selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FootballGameName record);

    int updateByPrimaryKeyWithBLOBs(FootballGameName record);

    int updateByPrimaryKey(FootballGameName record);

    List<FootballGame> findByStandardName(String name);
}