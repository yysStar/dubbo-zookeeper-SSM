package com.qiyun.mapper2;

import com.qiyun.dto.MemberTaskBeginDTO;
import com.qiyun.model2.MemberTaskBegin;
import com.qiyun.model2.MemberTaskBeginExample;
import java.util.List;

public interface MemberTaskBeginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberTaskBegin record);

    int insertSelective(MemberTaskBegin record);

    List<MemberTaskBegin> selectByExample(MemberTaskBeginExample example);

    MemberTaskBegin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberTaskBegin record);

    int updateByPrimaryKey(MemberTaskBegin record);

    MemberTaskBegin selectNowTask(String account);

    List<MemberTaskBeginDTO> selectAll(String account);

    MemberTaskBeginDTO selectNowTaskAndPlan(String account);

   int setFast(String phone,String account);
}