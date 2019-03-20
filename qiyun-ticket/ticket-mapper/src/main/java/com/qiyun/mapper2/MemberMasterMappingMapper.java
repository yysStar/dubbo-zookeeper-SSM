package com.qiyun.mapper2;

import com.qiyun.model2.MemberMasterMapping;
import com.qiyun.model2.MemberMasterMappingExample;
import java.util.List;

public interface MemberMasterMappingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberMasterMapping record);

    int insertSelective(MemberMasterMapping record);

    List<MemberMasterMapping> selectByExample(MemberMasterMappingExample example);

    MemberMasterMapping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberMasterMapping record);

    int updateByPrimaryKey(MemberMasterMapping record);
}