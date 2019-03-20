package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.qiyun.dto.RecommendPlanDTO;
import com.qiyun.mapper2.RecommendPlanMapper;
import com.qiyun.model2.RecommendPlan;
import com.qiyun.service.RecommendPlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("recommendPlanService")
public class RecommendPlanServiceImpl implements RecommendPlanService {
    @Resource
    private RecommendPlanMapper recommendPlanMapper;

    public int insertSelective(RecommendPlan recommendPlan) {
        recommendPlanMapper.insertSelective(recommendPlan);
        return recommendPlan.getId();
    }

    public List<RecommendPlanDTO> getRecommendationList(int offset, int pageSize) {
        PageHelper.startPage(offset, pageSize);
        return recommendPlanMapper.selectRecommendationList();
    }

    public List<RecommendPlanDTO> getRecommendationListByAccount(String account, int offset, int pageSize) {
        PageHelper.startPage(offset, pageSize);
        return recommendPlanMapper.selectRecommendationListByAccount(account);
    }

    public List<RecommendPlanDTO> getExamineList(int offset, int pageSize) {
        PageHelper.startPage(offset, pageSize);
        return recommendPlanMapper.selectExamineList();
    }

    public RecommendPlan getRecommendPlanById(int id) {
        return recommendPlanMapper.selectByPrimaryKey(id);
    }

    public int updateRecommendPlan(RecommendPlan recommendPlan) {
        return recommendPlanMapper.updateByPrimaryKeySelective(recommendPlan);
    }

    public RecommendPlanDTO getRecommendationById(int id) {
        return recommendPlanMapper.selectRecommendationById(id);
    }

    public List<RecommendPlanDTO> getRecommendationByTaskId(Integer taskId) {
        return recommendPlanMapper.selectRecommendationByTaskId(taskId);
    }

    /**
     * 获取两周推荐列表
     * @return
     * @param account
     */
    public List<RecommendPlanDTO> getRecomList(String account) {
        return recommendPlanMapper.getRecomList(account);
    }
}
