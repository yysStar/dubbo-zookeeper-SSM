package com.qiyun.serviceImpl;

import com.qiyun.mapper2.Commision2Mapper;
import com.qiyun.model2.Commision2;
import com.qiyun.model2.Commision2Query;
import com.qiyun.service.CommisionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("commisionService")
public class CommisionServiceImpl implements CommisionService {

    @Resource
    private Commision2Mapper commision2Mapper;

    public void insert(Commision2 commision2) {
        commision2Mapper.insertSelective(commision2);
    }

    public List<Commision2> getByPlanNo(Integer planNo) {
        Commision2Query commision2Query = new Commision2Query();
        Commision2Query.Criteria criteria = commision2Query.createCriteria();
        criteria.andPlanNoEqualTo(planNo);
        List<Commision2> commision2s = commision2Mapper.selectByExample(commision2Query);
        return commision2s;
    }
}
