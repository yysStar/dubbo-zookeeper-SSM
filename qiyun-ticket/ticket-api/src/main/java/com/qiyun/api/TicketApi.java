package com.qiyun.api;

import com.qiyun.commonModel.LotteryTerm;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.commonModel.Platform;
import com.qiyun.model2.LotteryPlan;

import java.util.List;
import java.util.Map;

public interface TicketApi {



    /**
     * 竞彩赛事列表（接口）
     * @param reqMap
     * @return
     */
    public Map<String,Object> getCompetitiveLotteryList(Map<String,Object> reqMap);

    /**
     * 竞彩赛果查询
     * @param reqMap
     * @return
     */
    public Map<String,Object> getCompetitiveLotteryResult(Map<String,Object> reqMap);

    /**
     * 竞彩赔率查询
     * @param reqMap
     * @return
     */
    public Map<String,Object> getCompetitiveLotteryOdds(Map<String,Object> reqMap);

    /**
     * 竞彩中奖文件查询
     * @param reqMap
     * @return
     */
    public Map<String,Object> getCompetitiveLotteryFile(Map<String,Object> reqMap);

    /**
     * 竞彩投注接口（出票）
     * @param reqMap
     * @return
     */
    public Map<String,Object> putMatchTicket(Map<String,Object> reqMap);

    /**
     * 接口出错是更改方案出票状态
     * @param reqMap
     * @return
     */
    public Map<String,Object> updatePlanTicketStatus(Map<String,Object> reqMap);

    /**
     * 获取出票结果
     * @param reqMap
     * @return
     */
    public Map<String,Object> getTicketResult(Map<String,Object> reqMap);

    /**
     * 票务限制接口
     * @param reqMap
     * @return
     */
    public Map<String,Object> ticketRestrict(Map<String,Object> reqMap);

    /**
     * 上传方案最大SP值
     * @param reqMap
     * @return
     */
    public Map<String,Object> putMaxSp(Map<String,Object> reqMap);

    Map<String,Object> ticketRestrict2(int planNo);

    LotteryTerm findPrintingTermByLotteryType(Integer lotType);

    List<LotteryPlan> findByLotteryTypeAndTermsAndPlanTicketStatus(LotteryType lotType, int i, String term);

    void updateLotteryPlan(LotteryPlan lotteryPlan);

    void jianPiao(LotteryPlan lotteryPlan, Platform www);

    Map<String,Object> test();
}
