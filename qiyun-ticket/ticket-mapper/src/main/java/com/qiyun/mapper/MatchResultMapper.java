package com.qiyun.mapper;

import com.qiyun.model.MatchResult;
import com.qiyun.model.MatchResultExample;
import java.util.List;

public interface MatchResultMapper {
    int deleteByPrimaryKey(String id);

    int insert(MatchResult record);

    int insertSelective(MatchResult record);

    List<MatchResult> selectByExample(MatchResultExample example);

    MatchResult selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MatchResult record);

    int updateByPrimaryKey(MatchResult record);
}