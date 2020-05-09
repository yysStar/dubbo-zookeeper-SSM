package com.qiyun.mapper2;

import com.qiyun.model2.CmsNews2;
import com.qiyun.model2.CmsNews2Query;
import com.qiyun.model2.CmsNews2WithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CmsNews2Mapper {
    int countByExample(CmsNews2Query example);

    int deleteByExample(CmsNews2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(CmsNews2WithBLOBs record);

    int insertSelective(CmsNews2WithBLOBs record);

    List<CmsNews2WithBLOBs> selectByExampleWithBLOBs(CmsNews2Query example);

    List<CmsNews2> selectByExample(CmsNews2Query example);

    CmsNews2WithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CmsNews2WithBLOBs record, @Param("example") CmsNews2Query example);

    int updateByExampleWithBLOBs(@Param("record") CmsNews2WithBLOBs record, @Param("example") CmsNews2Query example);

    int updateByExample(@Param("record") CmsNews2 record, @Param("example") CmsNews2Query example);

    int updateByPrimaryKeySelective(CmsNews2WithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CmsNews2WithBLOBs record);

    int updateByPrimaryKey(CmsNews2 record);

    int addMail(Map<String,Object> map);
}