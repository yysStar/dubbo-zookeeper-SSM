package com.qiyun.mapper2;

import com.qiyun.dto.PlanDTO;
import com.qiyun.model2.LotteryPlanOrder;
import com.qiyun.model2.LotteryPlanOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LotteryPlanOrderMapper {
    int deleteByPrimaryKey(Integer orderNo);

    int insert(LotteryPlanOrder record);

    int insertSelective(LotteryPlanOrder record);

    List<LotteryPlanOrder> selectByExample(LotteryPlanOrderExample example);

    LotteryPlanOrder selectByPrimaryKey(Integer orderNo);

    int updateByPrimaryKeySelective(LotteryPlanOrder record);

    int updateByPrimaryKey(LotteryPlanOrder record);

    /**
     * 近10场订单
     * @param account
     * @return
     */
    List<LotteryPlanOrder> selectTenByAccount(String account);

    /**
     * 进行中订单
     * @param account
     * @param s
     * @return
     */
    List<PlanDTO> selectPlayingPlan(@Param("account")String account, @Param("s") String s);

    /**
     * 中奖订单
     * @param account
     * @param s
     * @return
     */
    List<PlanDTO> selectBingoPlan(@Param("account")String account, @Param("s") String s);

    /**
     * 历史订单
     * @param account
     * @param s
     * @return
     */
    List<PlanDTO> selectFinishPlan(@Param("account") String account, @Param("s") String s);

    /**
     * 晒单
     * @param account
     * @param s
     * @return
     */
    List<PlanDTO> selectShowPlan(@Param("account") String account, @Param("s") String s);
}