package com.qiyun.service;

import com.qiyun.model2.MemberCloudsLine;
import org.springframework.stereotype.Service;

@Service
public interface MemberCloudsLineService {
    int insertSelective(MemberCloudsLine line);
}
