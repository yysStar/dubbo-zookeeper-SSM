package com.qiyun.service.Impl;

import com.qiyun.mapper.MatchResultMapper;
import com.qiyun.model.MatchResult;
import com.qiyun.service.MatchResultService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("matchResultService")
public class MatchResultServiceImpl implements MatchResultService {
    @Resource
    private MatchResultMapper matchResultMapper;

    public int insertSelective(MatchResult record) {
        return matchResultMapper.insertSelective(record);
    }
}
