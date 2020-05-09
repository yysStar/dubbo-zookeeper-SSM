package com.qiyun.service;

import com.qiyun.model.MatchResult;
import org.springframework.stereotype.Service;

@Service
public interface MatchResultService {
    int insertSelective(MatchResult record);
}
