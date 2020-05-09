package com.qiyun.service.Impl;

import com.qiyun.mapper2.ConfigMapper;
import com.qiyun.service.ConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Resource
    private ConfigMapper configMapper;


    public Integer getLess5Auto() {
        return configMapper.getLess5Auto();
    }

    public Integer getMore5Auto() {
        return configMapper.getMore5Auto();
    }

    @Override
    public Integer getChaiPiaoCount() {
        return configMapper.getChaiPiaoCount();
    }

    @Override
    public void updateChaiPiaoCount(int count) {
        configMapper.updateChaiPiaoCount(count);
    }
}
