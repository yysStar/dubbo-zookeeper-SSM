package com.qiyun.mapper2;

import com.qiyun.model2.BasketBallMatch2;
import com.qiyun.model2.BasketBallMatch2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BasketBallMatch2Mapper {
    int countByExample(BasketBallMatch2Query example);

    int deleteByExample(BasketBallMatch2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(BasketBallMatch2 record);

    int insertSelective(BasketBallMatch2 record);

    List<BasketBallMatch2> selectByExample(BasketBallMatch2Query example);

    BasketBallMatch2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BasketBallMatch2 record, @Param("example") BasketBallMatch2Query example);

    int updateByExample(@Param("record") BasketBallMatch2 record, @Param("example") BasketBallMatch2Query example);

    int updateByPrimaryKeySelective(BasketBallMatch2 record);

    int updateByPrimaryKey(BasketBallMatch2 record);
}