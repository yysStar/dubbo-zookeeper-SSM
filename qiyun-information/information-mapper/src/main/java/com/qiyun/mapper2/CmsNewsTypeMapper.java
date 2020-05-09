package com.qiyun.mapper2;

import com.qiyun.model2.CmsNewsType;
import com.qiyun.model2.CmsNewsTypeExample;
import java.util.List;

public interface CmsNewsTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CmsNewsType record);

    int insertSelective(CmsNewsType record);

    List<CmsNewsType> selectByExample(CmsNewsTypeExample example);

    CmsNewsType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CmsNewsType record);

    int updateByPrimaryKey(CmsNewsType record);
}