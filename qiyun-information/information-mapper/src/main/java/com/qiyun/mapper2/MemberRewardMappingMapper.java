package com.qiyun.mapper2;

import com.qiyun.model2.MemberRewardMapping;
import com.qiyun.model2.MemberRewardMappingExample;
import java.util.List;

public interface MemberRewardMappingMapper {

    List<MemberRewardMapping> selectByBeRewarderAccount(String beRewarderId);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberRewardMapping record);

    int insertSelective(MemberRewardMapping record);

    List<MemberRewardMapping> selectByExampleWithBLOBs(MemberRewardMappingExample example);

    List<MemberRewardMapping> selectByExample(MemberRewardMappingExample example);

    MemberRewardMapping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberRewardMapping record);

    int updateByPrimaryKeyWithBLOBs(MemberRewardMapping record);

    int updateByPrimaryKey(MemberRewardMapping record);
}