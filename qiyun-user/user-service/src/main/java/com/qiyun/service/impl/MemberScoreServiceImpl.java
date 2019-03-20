package com.qiyun.service.impl;

import com.qiyun.mapper.MemberScoreMapper;
import com.qiyun.mapper2.MemberScoreMapper2;
import com.qiyun.service.MemberScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberScoreServiceImpl implements MemberScoreService {

    @Resource
    private MemberScoreMapper memberScoreMapper;

    @Resource
    private MemberScoreMapper2 memberScore2Mapper;


}
