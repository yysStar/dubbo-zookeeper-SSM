package com.qiyun.service;

import com.qiyun.common.Result;
import com.qiyun.model2.MemberClouds2;

public interface MemberCloudsLineService {
    Result insert(MemberClouds2 memberClouds2, double clouds,String remark,int transType);
}
