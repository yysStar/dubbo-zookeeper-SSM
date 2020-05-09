package com.qiyun.serviceImpl;

import com.qiyun.mapper2.MemberCloudsLineMapper;
import com.qiyun.model2.MemberCloudsLine;
import com.qiyun.service.MemberCloudsLineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("memberCloudsLineService")
public class MemberCloudsLineServiceImpl implements MemberCloudsLineService {
    @Resource
    private MemberCloudsLineMapper memberCloudsLineMapper;

    public int insertSelective(MemberCloudsLine line) {
        return memberCloudsLineMapper.insertSelective(line);
    }
}
