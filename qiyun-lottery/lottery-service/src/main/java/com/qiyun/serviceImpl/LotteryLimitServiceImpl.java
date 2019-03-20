package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.qiyun.mapper2.LotteryLimit2Mapper;
import com.qiyun.model2.LotteryLimit2;
import com.qiyun.model2.LotteryLimit2Query;
import com.qiyun.model2.LotteryTerm2Query;
import com.qiyun.service.LotteryLimitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("lotteryLimitService")
public class LotteryLimitServiceImpl implements LotteryLimitService {

    @Resource
    private LotteryLimit2Mapper lotteryLimit2Mapper;

    public void addLotteryLimit(LotteryLimit2 lotteryLimit2) {
        lotteryLimit2Mapper.insertSelective(lotteryLimit2);
    }

    public List<LotteryLimit2> getValidLimitByType(int lotteryType) {
        LotteryLimit2Query lotteryLimit2Query = new LotteryLimit2Query();
        LotteryLimit2Query.Criteria criteria = lotteryLimit2Query.createCriteria();
        criteria.andStatusEqualTo(1);
        criteria.andDealTimeGreaterThan(new Date());
        criteria.andLotteryTypeEqualTo(lotteryType);
        List<LotteryLimit2> lotteryLimit2s = lotteryLimit2Mapper.selectByExample(lotteryLimit2Query);
        return lotteryLimit2s;
    }


    public  List<LotteryLimit2>  getLotteryLimit(int page, int pageSize) {
        LotteryLimit2Query lotteryLimit2Query = new LotteryLimit2Query();
        LotteryLimit2Query.Criteria criteria = lotteryLimit2Query.createCriteria();
        criteria.andDealTimeGreaterThan(new Date());
        PageHelper.startPage(page,pageSize);
        List<LotteryLimit2> lotteryLimit2s = lotteryLimit2Mapper.selectByExample(lotteryLimit2Query);
        return lotteryLimit2s;
    }

    public LotteryLimit2 getById(Integer id) {
        return lotteryLimit2Mapper.selectByPrimaryKey(id);
    }

    public void update(LotteryLimit2 lotteryLimit2) {
        lotteryLimit2Mapper.updateByPrimaryKeySelective(lotteryLimit2);
    }
}
