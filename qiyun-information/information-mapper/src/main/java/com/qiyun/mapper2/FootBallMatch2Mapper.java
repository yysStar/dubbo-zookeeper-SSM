package com.qiyun.mapper2;

import com.qiyun.model2.FootBallMatch2;
import com.qiyun.model2.FootBallMatch2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FootBallMatch2Mapper {
    int countByExample(FootBallMatch2Query example);

    int deleteByExample(FootBallMatch2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(FootBallMatch2 record);

    int insertSelective(FootBallMatch2 record);

    List<FootBallMatch2> selectByExample(FootBallMatch2Query example);

    FootBallMatch2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FootBallMatch2 record, @Param("example") FootBallMatch2Query example);

    int updateByExample(@Param("record") FootBallMatch2 record, @Param("example") FootBallMatch2Query example);

    int updateByPrimaryKeySelective(FootBallMatch2 record);

    int updateByPrimaryKey(FootBallMatch2 record);
}