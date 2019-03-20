package com.qiyun.mapper2;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryChase2;
import com.qiyun.model2.LotteryChase2Example;
import java.util.List;

public interface LotteryChase2Mapper {
    int deleteByPrimaryKey(Integer chaseNo);

    int insert(LotteryChase2 record);

    int insertSelective(LotteryChase2 record);

    List<LotteryChase2> selectByExampleWithBLOBs(LotteryChase2Example example);

    List<LotteryChase2> selectByExample(LotteryChase2Example example);

    LotteryChase2 selectByPrimaryKey(Integer chaseNo);

    int updateByPrimaryKeySelective(LotteryChase2 record);

    int updateByPrimaryKeyWithBLOBs(LotteryChase2 record);

    int updateByPrimaryKey(LotteryChase2 record);

    List findChasePackageList(LotteryType lotteryType);
}