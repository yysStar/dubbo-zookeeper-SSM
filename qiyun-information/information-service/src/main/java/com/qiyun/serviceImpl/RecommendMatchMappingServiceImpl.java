package com.qiyun.serviceImpl;

import com.qiyun.mapper2.RecommendMatchMappingMapper;
import com.qiyun.model2.RecommendMatchMapping;
import com.qiyun.service.RecommendMatchMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("recommendMatchMappingService")
public class RecommendMatchMappingServiceImpl implements RecommendMatchMappingService {
    @Resource
    RecommendMatchMappingMapper recommendMatchMappingMapper;

    public int insertSelective(RecommendMatchMapping recommendMatchMapping) {
        return recommendMatchMappingMapper.insertSelective(recommendMatchMapping);
    }
}
