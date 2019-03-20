package com.qiyun.mapper2;

import com.qiyun.model2.FocusMatchBb2;
import com.qiyun.model2.FocusMatchBb2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FocusMatchBb2Mapper {
    int countByExample(FocusMatchBb2Query example);

    int deleteByExample(FocusMatchBb2Query example);

    int deleteByPrimaryKey(Integer matchId);

    int insert(FocusMatchBb2 record);

    int insertSelective(FocusMatchBb2 record);

    List<FocusMatchBb2> selectByExample(FocusMatchBb2Query example);

    FocusMatchBb2 selectByPrimaryKey(Integer matchId);

    int updateByExampleSelective(@Param("record") FocusMatchBb2 record, @Param("example") FocusMatchBb2Query example);

    int updateByExample(@Param("record") FocusMatchBb2 record, @Param("example") FocusMatchBb2Query example);

    int updateByPrimaryKeySelective(FocusMatchBb2 record);

    int updateByPrimaryKey(FocusMatchBb2 record);
}