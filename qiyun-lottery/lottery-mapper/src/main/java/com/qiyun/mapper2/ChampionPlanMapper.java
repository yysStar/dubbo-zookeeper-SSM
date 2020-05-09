package com.qiyun.mapper2;

import com.qiyun.dto.ChampionPlanDTO;
import com.qiyun.dto.ChampionPlanDetailsDTO;
import com.qiyun.model2.ChampionPlan;
import com.qiyun.model2.ChampionPlanExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ChampionPlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChampionPlan record);

    int insertSelective(ChampionPlan record);

    List<ChampionPlan> selectByExample(ChampionPlanExample example);

    ChampionPlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChampionPlan record);

    int updateByPrimaryKey(ChampionPlan record);

    List<ChampionPlan> selectTicketIngList();

    ChampionPlan selectByOrderNo(String orderNo);

    List<ChampionPlanDTO> selectByAccount(String account);

    ChampionPlanDetailsDTO selectDetailsById(int id);

    List<ChampionPlanDTO> selectBingoByAccount(String account);

    List<ChampionPlanDetailsDTO> selectAllList(@Param("account") String account,@Param("planId") Integer planId,
                               @Param("startTime") Date startTime,@Param("endTime") Date endTime);
}