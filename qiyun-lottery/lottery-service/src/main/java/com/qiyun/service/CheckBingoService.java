package com.qiyun.service;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.model2.LotteryTerm2;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface CheckBingoService {
    HashMap<String, String> getOpenInfoMapForCheckBingo(LotteryTerm2 term, LotteryType type);

    List<LotteryPlan2WithBLOBs> checkBingo(HashMap<String, String> openInfoMap);

    List<LotteryPlan2WithBLOBs> checkBingoForNoPay(HashMap<String, String> openInfoMap);
}
