package com.qiyun.mapper2;

import com.qiyun.model2.WinPromotion2;
import com.qiyun.model2.WinPromotion2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WinPromotion2Mapper {
    int countByExample(WinPromotion2Query example);

    int deleteByExample(WinPromotion2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(WinPromotion2 record);

    int insertSelective(WinPromotion2 record);

    List<WinPromotion2> selectByExampleWithBLOBs(WinPromotion2Query example);

    List<WinPromotion2> selectByExample(WinPromotion2Query example);

    WinPromotion2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WinPromotion2 record, @Param("example") WinPromotion2Query example);

    int updateByExampleWithBLOBs(@Param("record") WinPromotion2 record, @Param("example") WinPromotion2Query example);

    int updateByExample(@Param("record") WinPromotion2 record, @Param("example") WinPromotion2Query example);

    int updateByPrimaryKeySelective(WinPromotion2 record);

    int updateByPrimaryKeyWithBLOBs(WinPromotion2 record);

    int updateByPrimaryKey(WinPromotion2 record);
}