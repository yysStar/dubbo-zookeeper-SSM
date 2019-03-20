package com.qiyun.mapper2;

import com.qiyun.model2.AddPrize2;
import com.qiyun.model2.AddPrize2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddPrize2Mapper {
    int countByExample(AddPrize2Query example);

    int deleteByExample(AddPrize2Query example);

    int deleteByPrimaryKey(Integer lotteryType);

    int insert(AddPrize2 record);

    int insertSelective(AddPrize2 record);

    List<AddPrize2> selectByExample(AddPrize2Query example);

    AddPrize2 selectByPrimaryKey(Integer lotteryType);

    int updateByExampleSelective(@Param("record") AddPrize2 record, @Param("example") AddPrize2Query example);

    int updateByExample(@Param("record") AddPrize2 record, @Param("example") AddPrize2Query example);

    int updateByPrimaryKeySelective(AddPrize2 record);

    int updateByPrimaryKey(AddPrize2 record);
}