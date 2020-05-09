package com.qiyun.mapper2;

import com.qiyun.model2.News;
import com.qiyun.model2.NewsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    List<News> selectByExampleWithBLOBs(NewsExample example);

    List<News> selectByExample(NewsExample example);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);

    List<News> getNewsList(@Param("type")String type, @Param("label")String label, @Param("startTime")String startTime, @Param("endTime")String endTime, @Param("title")String title);

    News getNew(int id);

    List<String>getTypes();

    List<String>getLabels();
}