package com.qiyun.mapper2;

import com.qiyun.model2.LotteryLimit2;
import com.qiyun.model2.LotteryLimit2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LotteryLimit2Mapper {
    int countByExample(LotteryLimit2Query example);

    int deleteByExample(LotteryLimit2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(LotteryLimit2 record);

    int insertSelective(LotteryLimit2 record);

    List<LotteryLimit2> selectByExample(LotteryLimit2Query example);

    LotteryLimit2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LotteryLimit2 record, @Param("example") LotteryLimit2Query example);

    int updateByExample(@Param("record") LotteryLimit2 record, @Param("example") LotteryLimit2Query example);

    int updateByPrimaryKeySelective(LotteryLimit2 record);

    int updateByPrimaryKey(LotteryLimit2 record);
}