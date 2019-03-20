package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.qiyun.dto.RecommendPlanDTO;
import com.qiyun.mapper2.RecommendBuyLineMapper;
import com.qiyun.model2.RecommendBuyLine;
import com.qiyun.service.RecommendBuyLineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("recommendBuyLineService")
public class RecommendBuyLineServiceImpl implements RecommendBuyLineService {
    @Resource
    private RecommendBuyLineMapper recommendBuyLineMapper;

    public List<RecommendPlanDTO> getBuyList(String account, Integer type, int offset, int pageSize){
        PageHelper.startPage(offset, pageSize);
        return recommendBuyLineMapper.getBuyList(account,type);
    };


    public RecommendBuyLine getByAccountAndPlanId(String account, int planId) {
        return recommendBuyLineMapper.selectByAccountAndPlanId(account, planId);
    }

    public int insertSelective(RecommendBuyLine recommendBuyLine) {
        return recommendBuyLineMapper.insertSelective(recommendBuyLine);
    }

    public List<RecommendBuyLine> getByPlanId(Integer planId) {
        return recommendBuyLineMapper.selectByPlanId(planId);
    }
}
