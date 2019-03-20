package com.qiyun.service;

import com.qiyun.common.Result;
import com.qiyun.dto.*;
import com.qiyun.model.PayOrder;
import com.qiyun.model2.MemberWalletLine2;
import com.qiyun.model2.PayOrder2;

import java.util.List;
import java.util.Map;

public interface PayOrderService {
    Result insert(PayOrderDTO payOrderDTO);

     int update(PayOrderDTO payOrderDTO);

    Result getPayOrder(String id);

    PayOrder2DTO getPayOrderById(String prdOrdNo);

    List<MemberDrawing> findMemberDrawingByAccount(String account);

    int addMemberOperTrack(MemberOperTrack requestInfo);

    int addWithdrawalOrder(MemberDrawing drawing);

    int updateWalltInfo(MemberWallet2DTO memberWallet);

    int addwalltLineInfo(MemberWalletLine2 walletLine);

    PayOrder2 findById(Map paramsMap);

    List<Map> getAllFailPayOrder(Map paramsMap);

    Result findMemberDrawingList(String loginAccount, String account, String start_time, String end_time, String flow_num, String is_drawing_time, Integer page, Integer pageSize,Integer status);

    MemberDrawing findDrawingById(String drawingId);

    void updateDrawing(MemberDrawing memberDrawing);
}
