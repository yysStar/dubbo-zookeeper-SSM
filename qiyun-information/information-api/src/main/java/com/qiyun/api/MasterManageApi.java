package com.qiyun.api;

import java.util.Map;

public interface MasterManageApi {





    /********************************新旗云大师分割线*************************************/

//    /**
//     * 手动修改
//     * @return
//     */
//    Map<String, Object> getCloundSummaryList(String account,String startTime,String endTime, int offset, int pageSize);

    /**
     * 获取云朵汇总列表
     * @return
     */
    Map<String, Object> getCloundSummaryList(String account,String startTime,String endTime, int offset, int pageSize);

    /**
     * 获取快速审核扣款列表
     * @return
     */
    Map<String, Object> getQuickReviwList(String account,String startTime,String endTime, int offset, int pageSize);

    /**
     * 获取打赏收入列表
     * @return
     */
    Map<String, Object> getRewardIncomeList(String account,String startTime,String endTime, int offset, int pageSize);

    /**
     * 获取推荐收入列表
     * @return
     */
    Map<String, Object> getRecommendIncomeList(String account,String startTime,String endTime, int offset, int pageSize);

    /**
     * 获取打赏列表
     * @return
     */
    Map<String, Object> getRewardList(String account,String startTime,String endTime, int offset, int pageSize);

    /**
     * 获取推荐退款列表
     * @return
     */
    Map<String, Object> getRecommendRefundList(String account,String startTime,String endTime, int offset, int pageSize);

    /**
     * 获取购买推荐列表
     * @return
     */
    Map<String, Object> getBuyRecommendList(String account,String startTime,String endTime, int offset, int pageSize);

    /**
     * 获取提款云朵列表
     * @return
     */
    Map<String, Object> getWithdrawList(String account,String startTime,String endTime, int offset, int pageSize);

    /**
     * 获取充值云朵列表
     * @return
     */
    Map<String, Object> getRechargeList(String account,String startTime,String endTime, int offset, int pageSize);

    /**
     * 添加竞彩大师
     * @param account
     * @param sort
     * @return
     */
    Map<String, Object> addMaster(String account, int sort);

    /**
     * 添加实战名人
     * @param account
     * @param sort
     * @return
     */
    Map<String, Object> addHighGrade(String account, int sort);

    /**
     * 取消竞彩大师
     * @param account
     * @return
     */
    Map<String, Object> cancelMaster(String account);

    /**
     * 取消实战名人
     * @param account
     * @return
     */
    Map<String, Object> cancelHighGrade(String account);

    /**
     * 修改排序权重
     * @param account
     * @param sort
     * @return
     */
    Map<String, Object> changeSort(String account, int sort);

    /**
     * 待审核列表
     * @return
     */
    Map<String, Object> examineList(int offset, int pageSize);

    /**
     * 审核
     * @param id
     * @param type
     * @return
     */
    Map<String, Object> examine(int id, int type);

    /**
     * 提现列表
     * @param offset
     * @param pageSize
     * @return
     */
    Map<String, Object> withdrawCashList(int offset, int pageSize);

    /**
     * 提现确认
     * @param account
     * @return
     */
    Map<String, Object> withdrawCashConfirm(String account);
}
