package com.qiyun.service;

import com.qiyun.common.Result;
import com.qiyun.dto.Member2DTO;
import com.qiyun.model2.PlanShow2;

import java.util.List;
import java.util.Map;

public interface PlanShowService {
    Map<String,Object> showPlan(int planNo, String title, Member2DTO member2DTO);

    List<PlanShow2> getByPlanNoAndType(int planNo, int type);

    Map<String,Object> passShowPlanApply(int id, int type);

    Map<String,Object> updatePlanShowStatus(int id, int status);

    Map<String,Object> getPlanShow(String account, Integer planNo, Integer type, Integer status, int page, int pageSize);

    Map<String,Object> getPlanShow2(int page, int pageSize,String account);
}
