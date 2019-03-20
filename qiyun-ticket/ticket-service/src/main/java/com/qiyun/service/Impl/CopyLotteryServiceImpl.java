package com.qiyun.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.mapper2.CopyLotteryPlanMapper;
import com.qiyun.model2.CopyLotteryPlan;
import com.qiyun.model2.CopyLotteryPlanExample;
import com.qiyun.service.CopyLotteryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("copyLotteryService")
public class CopyLotteryServiceImpl  implements CopyLotteryService {
    @Resource
    private CopyLotteryPlanMapper copyLotteryPlanMapper;

    //查询跟单详情
    public PageInfo<CopyLotteryPlan> getPageCopyLotterPlanList(int offset, int pageSize, int planNo){
        PageHelper.startPage(offset+1,pageSize);
        CopyLotteryPlanExample copyLotteryPlanExample = new CopyLotteryPlanExample();
        CopyLotteryPlanExample.Criteria criteria = copyLotteryPlanExample.createCriteria();
        criteria.andCopyLotteryplanNoEqualTo(planNo);
//        List<CopyLotteryPlan> list = copyLotteryPlanMapper.getCopyLotteryPlanList();
        List<CopyLotteryPlan> list = copyLotteryPlanMapper.selectByExample(copyLotteryPlanExample);
        PageInfo page = new PageInfo(list);
        return page;
    }

}

