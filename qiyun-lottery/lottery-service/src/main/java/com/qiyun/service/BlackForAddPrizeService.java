package com.qiyun.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface BlackForAddPrizeService {
    Map<String,Object> setAddPrizeBlackOrWhite(Integer[] ids, Integer type);

    Map<String,Object> getAddPrizeBlack(String account, int page, int pageSize);
}
