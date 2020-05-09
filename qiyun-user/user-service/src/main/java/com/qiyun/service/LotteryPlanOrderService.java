package com.qiyun.service;

import com.github.pagehelper.PageInfo;
import com.qiyun.dto.PlanDTO;
import com.qiyun.model2.LotteryPlanOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LotteryPlanOrderService {

    List<LotteryPlanOrder> getTenByAccount(String account);

    List<PlanDTO> getPlayingPlan(String account, boolean isSelf, int offset, int pageSize);

    List<PlanDTO> getBingoPlan(String account, boolean isSelf, int offset, int pageSize);

    List<PlanDTO> getFinishPlan(String account, boolean isSelf, int offset, int pageSize);

    List<PlanDTO> getShowPlan(String account, boolean isSelf, int offset, int pageSize);
}
