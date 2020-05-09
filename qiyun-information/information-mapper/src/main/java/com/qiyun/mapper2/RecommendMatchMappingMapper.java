package com.qiyun.mapper2;

import com.qiyun.model2.RecommendMatchMapping;
import com.qiyun.model2.RecommendMatchMappingExample;
import java.util.List;

public interface RecommendMatchMappingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecommendMatchMapping record);

    int insertSelective(RecommendMatchMapping record);

    List<RecommendMatchMapping> selectByExample(RecommendMatchMappingExample example);

    RecommendMatchMapping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecommendMatchMapping record);

    int updateByPrimaryKey(RecommendMatchMapping record);
}