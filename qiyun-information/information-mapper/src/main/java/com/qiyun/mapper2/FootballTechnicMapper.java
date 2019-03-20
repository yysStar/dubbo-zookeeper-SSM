package com.qiyun.mapper2;

import com.qiyun.model2.FootballTechnic;
import com.qiyun.model2.FootballTechnicExample;
import java.util.List;

public interface FootballTechnicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FootballTechnic record);

    int insertSelective(FootballTechnic record);

    List<FootballTechnic> selectByExample(FootballTechnicExample example);

    FootballTechnic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FootballTechnic record);

    int updateByPrimaryKey(FootballTechnic record);
}