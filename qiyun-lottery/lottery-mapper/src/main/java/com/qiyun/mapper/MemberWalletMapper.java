package com.qiyun.mapper;

import com.qiyun.model.MemberWallet;
import com.qiyun.model.MemberWalletQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberWalletMapper {
    int countByExample(MemberWalletQuery example);

    int deleteByExample(MemberWalletQuery example);

    int deleteByPrimaryKey(Integer memberId);

    int insert(MemberWallet record);

    int insertSelective(MemberWallet record);

    List<MemberWallet> selectByExample(MemberWalletQuery example);

    MemberWallet selectByPrimaryKey(Integer memberId);

    int updateByExampleSelective(@Param("record") MemberWallet record, @Param("example") MemberWalletQuery example);

    int updateByExample(@Param("record") MemberWallet record, @Param("example") MemberWalletQuery example);

    int updateByPrimaryKeySelective(MemberWallet record);

    int updateByPrimaryKey(MemberWallet record);
}