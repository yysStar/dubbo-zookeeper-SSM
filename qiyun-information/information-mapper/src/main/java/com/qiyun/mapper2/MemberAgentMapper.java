package com.qiyun.mapper2;

import com.qiyun.model2.MemberAgent;
import com.qiyun.model2.MemberAgentExample;
import java.util.List;

public interface MemberAgentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberAgent record);

    int insertSelective(MemberAgent record);

    List<MemberAgent> selectByExampleWithBLOBs(MemberAgentExample example);

    List<MemberAgent> selectByExample(MemberAgentExample example);

    MemberAgent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberAgent record);

    int updateByPrimaryKeyWithBLOBs(MemberAgent record);

    int updateByPrimaryKey(MemberAgent record);
}