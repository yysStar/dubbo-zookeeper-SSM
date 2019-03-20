package com.qiyun.service.impl;

import com.qiyun.mapper2.Celebrity2Mapper;
import com.qiyun.model2.Celebrity2;
import com.qiyun.model2.Celebrity2Query;
import com.qiyun.model2.Member2;
import com.qiyun.model2.Member2Query;
import com.qiyun.service.CelebrityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CelebrityServiceImpl implements CelebrityService {

    @Resource
    private Celebrity2Mapper celebrity2Mapper;

    public List<Celebrity2> getCeleBrity() {
        Celebrity2Query celebrity2Query = new Celebrity2Query();
        List<Celebrity2> celebrity2s = celebrity2Mapper.selectByExample(celebrity2Query);
        return celebrity2s;
    }

    public void delete() {
        celebrity2Mapper.delete();
    }

    public void add(Celebrity2 celebrity2) {
        celebrity2Mapper.insertSelective(celebrity2);
    }

}
