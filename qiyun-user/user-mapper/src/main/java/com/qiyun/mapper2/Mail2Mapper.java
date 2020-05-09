package com.qiyun.mapper2;

import com.qiyun.model2.Mail2;
import com.qiyun.model2.Mail2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Mail2Mapper {
    int countByExample(Mail2Query example);

    int deleteByExample(Mail2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mail2 record);

    int insertSelective(Mail2 record);

    List<Mail2> selectByExampleWithBLOBs(Mail2Query example);

    List<Mail2> selectByExample(Mail2Query example);

    Mail2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mail2 record, @Param("example") Mail2Query example);

    int updateByExampleWithBLOBs(@Param("record") Mail2 record, @Param("example") Mail2Query example);

    int updateByExample(@Param("record") Mail2 record, @Param("example") Mail2Query example);

    int updateByPrimaryKeySelective(Mail2 record);

    int updateByPrimaryKeyWithBLOBs(Mail2 record);

    int updateByPrimaryKey(Mail2 record);
}