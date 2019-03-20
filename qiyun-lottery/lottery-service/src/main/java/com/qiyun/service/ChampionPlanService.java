package com.qiyun.service;

import com.qiyun.dto.ChampionPlanDTO;
import com.qiyun.dto.ChampionPlanDetailsDTO;
import com.qiyun.model2.ChampionPlan;
import com.qiyun.model2.ChampionPlanMatch;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ChampionPlanService {
    int insertSelective(ChampionPlan championPlan);

    int update(ChampionPlan plan);

    /**
     * 获取所有出票中的订单
     * @return
     */
    List<ChampionPlan> getTicketIngList();

    ChampionPlan getByOrderNo(String orderNo);

    List<ChampionPlanDTO> getListByAccount(String account, int offset, int pageSize);

    ChampionPlanDetailsDTO getDetailsById(int id);

    List<ChampionPlanDTO> getBingoListByAccount(String account, int offset, int pageSize);

    int updateFailByTeamId(Integer planId);

    int updateSuccessByTeamId(ChampionPlanMatch planId);

    List<ChampionPlanDetailsDTO> getAllList(int offset, int pageSize, String account, Integer planId, Date startTime, Date endTime);
}
