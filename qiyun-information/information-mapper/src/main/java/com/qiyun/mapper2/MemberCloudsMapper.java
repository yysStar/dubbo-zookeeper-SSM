package com.qiyun.mapper2;

import com.qiyun.dto.WithdrawCashDTO;
import com.qiyun.model2.MemberClouds;
import com.qiyun.model2.MemberCloudsExample;
import java.util.List;

public interface MemberCloudsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberClouds record);

    int insertSelective(MemberClouds record);

    List<MemberClouds> selectByExample(MemberCloudsExample example);

    MemberClouds selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberClouds record);

    int updateByPrimaryKey(MemberClouds record);

    MemberClouds selectByAccount(String account);

    List<WithdrawCashDTO> selectCashList();

    String selectFAST(String account);

    Integer getClounds(String account);


}