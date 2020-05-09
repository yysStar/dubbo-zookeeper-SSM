package com.qiyun.mapper;

import com.qiyun.model.MemberFollowMapping;
import com.qiyun.model.MemberFollowMappingExample;
import java.util.List;

public interface MemberFollowMappingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberFollowMapping record);

    int insertSelective(MemberFollowMapping record);

    List<MemberFollowMapping> selectByExample(MemberFollowMappingExample example);

    MemberFollowMapping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberFollowMapping record);

    int updateByPrimaryKey(MemberFollowMapping record);
}