package com.qiyun.mapper2;

import com.qiyun.model2.BlackForAddPrize2;
import com.qiyun.model2.BlackForAddPrize2Query;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface BlackForAddPrize2Mapper {
    int countByExample(BlackForAddPrize2Query example);

    int deleteByExample(BlackForAddPrize2Query example);

    int deleteByPrimaryKey(Integer memberId);

    int insert(BlackForAddPrize2 record);

    int insertSelective(BlackForAddPrize2 record);

    List<BlackForAddPrize2> selectByExample(BlackForAddPrize2Query example);

    BlackForAddPrize2 selectByPrimaryKey(Integer memberId);

    int updateByExampleSelective(@Param("record") BlackForAddPrize2 record, @Param("example") BlackForAddPrize2Query example);

    int updateByExample(@Param("record") BlackForAddPrize2 record, @Param("example") BlackForAddPrize2Query example);

    int updateByPrimaryKeySelective(BlackForAddPrize2 record);

    int updateByPrimaryKey(BlackForAddPrize2 record);

    List<Map> getAddPrizeBlack(Map<String, Object> reqMap);

    List<String> selectAllAccount();
}