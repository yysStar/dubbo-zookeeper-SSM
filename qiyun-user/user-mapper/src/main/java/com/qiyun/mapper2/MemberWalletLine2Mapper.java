package com.qiyun.mapper2;

import com.qiyun.commonModel.MemberChargeLine;
import com.qiyun.model2.MemberWalletLine2;
import com.qiyun.model2.MemberWalletLine2Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MemberWalletLine2Mapper {
    int countByExample(MemberWalletLine2Query example);

    int deleteByExample(MemberWalletLine2Query example);

    int deleteByPrimaryKey(Integer walletLineNo);

    int insert(MemberWalletLine2 record);

    int insertSelective(MemberWalletLine2 record);

    List<MemberWalletLine2> selectByExampleWithBLOBs(MemberWalletLine2Query example);

    List<MemberWalletLine2> selectByExample(MemberWalletLine2Query example);

    MemberWalletLine2 selectByPrimaryKey(Integer walletLineNo);

    int updateByExampleSelective(@Param("record") MemberWalletLine2 record, @Param("example") MemberWalletLine2Query example);

    int updateByExampleWithBLOBs(@Param("record") MemberWalletLine2 record, @Param("example") MemberWalletLine2Query example);

    int updateByExample(@Param("record") MemberWalletLine2 record, @Param("example") MemberWalletLine2Query example);

    int updateByPrimaryKeySelective(MemberWalletLine2 record);

    int updateByPrimaryKeyWithBLOBs(MemberWalletLine2 record);

    int updateByPrimaryKey(MemberWalletLine2 record);


}