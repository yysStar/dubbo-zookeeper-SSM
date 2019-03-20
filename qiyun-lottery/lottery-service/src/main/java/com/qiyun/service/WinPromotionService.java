package com.qiyun.service;

import com.qiyun.model2.WinPromotion2;

import java.util.Map;

public interface WinPromotionService {
    Map<String,Object> addWinPromotion(WinPromotion2 winPromotion2);

    Map<String,Object> updateWinPromotionStatus(WinPromotion2 winPromotion2);

    Map<String,Object> getWinPromotion(Integer status,int page,int pageSize);
}
