package com.qiyun.service;

import com.qiyun.dto.RecommendPlanDTO;
import com.qiyun.model2.RecommendPlan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecommendPlanService {
    int insertSelective(RecommendPlan recommendPlan);

    List<RecommendPlanDTO> getRecommendationList(int offset, int pageSize);

    List<RecommendPlanDTO> getRecommendationListByAccount(String account, int offset, int pageSize);

    List<RecommendPlanDTO> getExamineList(int offset, int pageSize);

    RecommendPlan getRecommendPlanById(int id);

    int updateRecommendPlan(RecommendPlan recommendPlan);

    RecommendPlanDTO getRecommendationById(int id);

    List<RecommendPlanDTO> getRecommendationByTaskId(Integer id);

    List<RecommendPlanDTO> getRecomList(String account);
}
