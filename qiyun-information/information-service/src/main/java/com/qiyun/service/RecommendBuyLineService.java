package com.qiyun.service;

import com.qiyun.dto.RecommendPlanDTO;
import com.qiyun.model2.RecommendBuyLine;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface RecommendBuyLineService {


    List<RecommendPlanDTO> getBuyList(String account, Integer type, int offset, int pageSize);

    RecommendBuyLine getByAccountAndPlanId(String account, int id);

    int insertSelective(RecommendBuyLine recommendBuyLine);

    List<RecommendBuyLine> getByPlanId(Integer id);
}
