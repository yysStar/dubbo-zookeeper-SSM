package com.qiyun.mapper2;

import com.qiyun.dto.RecommendPlanDTO;
import com.qiyun.model2.RecommendPlan;
import com.qiyun.model2.RecommendPlanExample;
import java.util.List;

public interface RecommendPlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecommendPlan record);

    int insertSelective(RecommendPlan record);

    List<RecommendPlan> selectByExample(RecommendPlanExample example);

    RecommendPlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecommendPlan record);

    int updateByPrimaryKey(RecommendPlan record);

    List<RecommendPlanDTO> selectRecommendationList();

    List<RecommendPlanDTO> selectRecommendationListByAccount(String account);

    List<RecommendPlanDTO> selectExamineList();

    RecommendPlanDTO selectRecommendationById(int id);

    List<RecommendPlanDTO> selectRecommendationByTaskId(Integer taskId);

    List<RecommendPlanDTO> getRecomList(String account);
}