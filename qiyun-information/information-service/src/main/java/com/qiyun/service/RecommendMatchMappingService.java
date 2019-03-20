package com.qiyun.service;

import com.qiyun.model2.RecommendMatchMapping;
import org.springframework.stereotype.Service;

@Service
public interface RecommendMatchMappingService {
    int insertSelective(RecommendMatchMapping recommendMatchMapping);
}
