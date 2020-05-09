package com.qiyun.mapper2;

import com.qiyun.model2.FastMapping;
import com.qiyun.model2.FastMappingExample;
import java.util.List;

public interface FastMappingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FastMapping record);

    int insertSelective(FastMapping record);

    List<FastMapping> selectByExampleWithBLOBs(FastMappingExample example);

    List<FastMapping> selectByExample(FastMappingExample example);

    FastMapping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FastMapping record);

    int updateByPrimaryKeyWithBLOBs(FastMapping record);

    int updateByPrimaryKey(FastMapping record);

    String getPhone();
}