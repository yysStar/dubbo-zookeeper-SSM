package com.qiyun.service.impl;

import com.github.pagehelper.PageHelper;
import com.qiyun.mapper2.WhiteForCert2Mapper;
import com.qiyun.model2.WhiteForCert2;
import com.qiyun.model2.WhiteForCert2Query;
import com.qiyun.service.WhiteForCertService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WhiteForCertServiceImpl implements WhiteForCertService {

    @Resource
    private WhiteForCert2Mapper whiteForCert2Mapper;

    public WhiteForCert2 getByCert(String certNo) {
        return whiteForCert2Mapper.selectByPrimaryKey(certNo);
    }

    public void update(WhiteForCert2 byCert) {
        whiteForCert2Mapper.updateByPrimaryKeySelective(byCert);
    }

    public List<WhiteForCert2> getWhiteCertByStatus(int page, int pageSize, int i) {
        PageHelper.startPage(page,pageSize);
        WhiteForCert2Query whiteForCert2Query = new WhiteForCert2Query();
        WhiteForCert2Query.Criteria criteria = whiteForCert2Query.createCriteria();
        criteria.andStatusEqualTo(1);
        List<WhiteForCert2> whiteForCert2s = whiteForCert2Mapper.selectByExample(whiteForCert2Query);
        return whiteForCert2s;
    }

    public void add(WhiteForCert2 byCert) {
        whiteForCert2Mapper.insertSelective(byCert);
    }
}
