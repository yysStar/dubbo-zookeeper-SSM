package com.qiyun.mapper2;

import com.qiyun.dto.MasterInfoDTO;
import com.qiyun.model2.Member2;
import com.qiyun.model2.Member2Example;
import java.util.List;

public interface Member2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Member2 record);

    int insertSelective(Member2 record);

    List<Member2> selectByExample(Member2Example example);

    Member2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Member2 record);

    int updateByPrimaryKey(Member2 record);

    List<Member2> getMemberInfoForCelebrity();

    Member2 selectByAccount(String account);

    MasterInfoDTO selectMasterInfo(String account);
}