package com.qiyun.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.dto.PlanDTO;
import com.qiyun.mapper2.LotteryPlanOrderMapper;
import com.qiyun.model2.LotteryPlanOrder;
import com.qiyun.service.LotteryPlanOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("lotteryPlanOrderService")
public class LotteryPlanOrderServiceImpl implements LotteryPlanOrderService{
    @Resource
    private LotteryPlanOrderMapper lotteryPlanOrderMapper;

    public List<LotteryPlanOrder> getTenByAccount(String account) {
        return lotteryPlanOrderMapper.selectTenByAccount(account);
    }

    public List<PlanDTO> getPlayingPlan(String account, boolean isSelf, int offset, int pageSize) {
        List<PlanDTO> list = new ArrayList<PlanDTO>();
//        if(isSelf) {
            PageHelper.startPage(offset, pageSize);
            list = lotteryPlanOrderMapper.selectPlayingPlan(account, "1");
//        } else {
//            list = lotteryPlanOrderMapper.selectPlayingPlan(account, null);
//        }
//        PageInfo<PlanDTO> page = new PageInfo(list);
        return list;
    }

    public List<PlanDTO> getBingoPlan(String account, boolean isSelf, int offset, int pageSize) {
        List<PlanDTO> list = new ArrayList<PlanDTO>();
        PageHelper.startPage(offset, pageSize);
//        if(isSelf) {
            list = lotteryPlanOrderMapper.selectBingoPlan(account, "1");
//        } else {
//            list = lotteryPlanOrderMapper.selectBingoPlan(account, null);
//        }
//        PageInfo<PlanDTO> page = new PageInfo(list);
        return list;
    }

    public List<PlanDTO> getFinishPlan(String account, boolean isSelf, int offset, int pageSize) {
        List<PlanDTO> list = new ArrayList<PlanDTO>();
        PageHelper.startPage(offset, pageSize);
//        if(isSelf){
            list =  lotteryPlanOrderMapper.selectFinishPlan(account, "1");
//        } else {
//            list =  lotteryPlanOrderMapper.selectFinishPlan(account, null);
//        }
//        PageInfo<PlanDTO> page = new PageInfo(list);
        return list;
    }

    public List<PlanDTO> getShowPlan(String account, boolean isSelf, int offset, int pageSize) {
        List<PlanDTO> list = new ArrayList<PlanDTO>();
        PageHelper.startPage(offset, pageSize);
//        if(isSelf){
            list =  lotteryPlanOrderMapper.selectShowPlan(account, "1");
//        } else {
//            list =  lotteryPlanOrderMapper.selectShowPlan(account, null);
//        }
//        PageInfo<PlanDTO> page = new PageInfo(list);
        return list;
    }
}
