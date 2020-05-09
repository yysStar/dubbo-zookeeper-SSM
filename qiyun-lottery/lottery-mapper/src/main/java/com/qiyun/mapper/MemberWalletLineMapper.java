package com.qiyun.mapper;

import com.qiyun.model.MemberWalletLine;
import com.qiyun.model.MemberWalletLineQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberWalletLineMapper {
    int countByExample(MemberWalletLineQuery example);

    int deleteByExample(MemberWalletLineQuery example);

    int deleteByPrimaryKey(Integer walletLineNo);

    int insert(MemberWalletLine record);

    int insertSelective(MemberWalletLine record);

    List<MemberWalletLine> selectByExampleWithBLOBs(MemberWalletLineQuery example);

    List<MemberWalletLine> selectByExample(MemberWalletLineQuery example);

    MemberWalletLine selectByPrimaryKey(Integer walletLineNo);

    int updateByExampleSelective(@Param("record") MemberWalletLine record, @Param("example") MemberWalletLineQuery example);

    int updateByExampleWithBLOBs(@Param("record") MemberWalletLine record, @Param("example") MemberWalletLineQuery example);

    int updateByExample(@Param("record") MemberWalletLine record, @Param("example") MemberWalletLineQuery example);

    int updateByPrimaryKeySelective(MemberWalletLine record);

    int updateByPrimaryKeyWithBLOBs(MemberWalletLine record);

    int updateByPrimaryKey(MemberWalletLine record);
}