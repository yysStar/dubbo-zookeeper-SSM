package com.qiyun.mapper2;

import com.qiyun.dto.MemberDrawing;
import com.qiyun.dto.MemberOperTrack;
import com.qiyun.dto.MemberWallet2DTO;
import com.qiyun.model2.MemberWalletLine2;
import com.qiyun.model2.PayOrder2;
import com.qiyun.model2.PayOrder2Query;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PayOrder2Mapper {
    int countByExample(PayOrder2Query example);

    int deleteByExample(PayOrder2Query example);

    int deleteByPrimaryKey(String id);

    int insert(PayOrder2 record);

    int insertSelective(PayOrder2 record);

    List<PayOrder2> selectByExample(PayOrder2Query example);

    PayOrder2 selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PayOrder2 record, @Param("example") PayOrder2Query example);

    int updateByExample(@Param("record") PayOrder2 record, @Param("example") PayOrder2Query example);

    int updateByPrimaryKeySelective(PayOrder2 record);

    int updateByPrimaryKey(PayOrder2 record);

    List<MemberDrawing> findMemberDrawingByAccount(String account);

    int addMemberOperTrack(MemberOperTrack requestInfo);

    int addWithdrawalOrder(MemberDrawing drawing);

    int updateWalltInfo(MemberWallet2DTO memberWallet);

    int addwalltLineInfo(MemberWalletLine2 walletLine);

    List<Map> getAllFailPayOrder(Map paramsMap);

    List<Map> findMemberDrawingList(Map<String,Object> map);

    MemberDrawing findDrawingById(String drawingId);

    void updateDrawingStatus(MemberDrawing memberDrawing);
}