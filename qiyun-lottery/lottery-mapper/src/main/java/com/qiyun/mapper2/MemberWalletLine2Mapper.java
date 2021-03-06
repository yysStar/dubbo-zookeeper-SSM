package com.qiyun.mapper2;

import com.qiyun.model2.MemberWalletLine2;
import com.qiyun.model2.MemberWalletLine2Query;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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

    int updateCard(Object cardId, Date date);

    BigDecimal findCardFullMoneyById(Object cardMoney);

    MemberWalletLine2 getByPlanNoAndRemark(Integer planNo, String remark);
}