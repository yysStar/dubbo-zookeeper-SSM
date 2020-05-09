package com.qiyun.service;

import com.qiyun.model2.AddPrize2;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface AddPrizeService {
    Map<String,Object> addOrUpdate(AddPrize2 addPrize2);

    Map<String,Object> getAddPirzeConfigList(int page, int pageSize);

    Map<String,Object> updateAddPirzeConfig(Integer lotteryType, double rate, double minAmount, int[] playTypes);
}
