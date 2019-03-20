package com.qiyun.mapper2;

import com.qiyun.model2.FocusMatchFb2;
import com.qiyun.model2.FocusMatchFb2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FocusMatchFb2Mapper {
    int countByExample(FocusMatchFb2Query example);

    int deleteByExample(FocusMatchFb2Query example);

    int deleteByPrimaryKey(Integer matchId);

    int insert(FocusMatchFb2 record);

    int insertSelective(FocusMatchFb2 record);

    List<FocusMatchFb2> selectByExample(FocusMatchFb2Query example);

    FocusMatchFb2 selectByPrimaryKey(Integer matchId);

    int updateByExampleSelective(@Param("record") FocusMatchFb2 record, @Param("example") FocusMatchFb2Query example);

    int updateByExample(@Param("record") FocusMatchFb2 record, @Param("example") FocusMatchFb2Query example);

    int updateByPrimaryKeySelective(FocusMatchFb2 record);

    int updateByPrimaryKey(FocusMatchFb2 record);
}