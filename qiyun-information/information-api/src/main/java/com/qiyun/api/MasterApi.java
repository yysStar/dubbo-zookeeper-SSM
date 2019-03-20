package com.qiyun.api;

import com.qiyun.dto.Member2DTO;
import com.qiyun.dto.RecommendMatchDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 前端调用
 */
public interface MasterApi {


    Map<String, Object>  getSgMatch(String date);

    /**
     *
     * 获取今天及前俩天的日期
     * @return
     */
    Map<String, Object>  getSgTime();

    /**
     *
     * 获取今天及后俩天的日期
     * @return
     */
    Map<String, Object>  getScTime();

    /********************************新旗云大师分割线*************************************/

    /**
     * 获取打赏列表
     * @param beRewarderId  传入被打赏人的账户
     * @return
     */
    Map<String, Object>  getRewarderList(String beRewarderId);

    /**
     * 打赏
     * @param cloud 打赏云朵数
     * @param beRewarderId  被打赏人的ID
     * @param RewarderId 打赏人的ID
     * @return
     */
    Map<String,Object> Reward(int cloud,String beRewarderId, String RewarderId);


    /**
     * 搜索竞彩大师
     * @param keywords
     * @param offset
     * @param pageSize
     * @return
     */
    Map<String, Object> Search(String keywords ,int offset, int pageSize);

    /**
     * 获取购买详情列表
     * @param account
     * @param type
     * @param offset
     * @param pageSize
     * @return
     */
    Map<String, Object> getBuyList(String account,Integer type,int offset, int pageSize);

    /**
     * 获取我的云朵详情列表
     * @param account
     * @param num
     * @param offset
     * @param pageSize
     * @return
     */
    Map<String, Object> getCloudList(String account,int num,int offset, int pageSize);

    /**
     * 获取认证名人列表
     * @return
     */
    Map<String, Object> getMasterList(int offset, int pageSize);

    /**
     * 获取实战大神列表
     * @return
     */
    Map<String, Object> getHighGradeList(int offset, int pageSize);

    /**
     * 可选赛事列表
     * @param offset
     * @param pageSize
     * @return
     */
    Map<String, Object> matchList(String account, int type, int offset, int pageSize);

    /**
     * 篮球赛事详情
     * @param matchIds
     * @return
     */
    Map<String, Object> basketballMatchDetails(List<Integer> matchIds);

    /**
     * 足球赛事详
     * @param matchIds
     * @return
     */
    Map<String, Object> footballMatchDetails(List<Integer> matchIds);

    /**
     * 判断该账户是否具有快速审核的功能
     * @param account
     * @return
     */
    public int isFast (String account);

    /**
     * 发布推荐
     * @return
     */
    Map<String, Object> issueRecommendation(String account, String content, BigDecimal fee,
                    int type ,List<RecommendMatchDTO> matchList,int isFast);


    /**
     * 获取推荐列表
     * @param offset
     * @param pageSize
     * @return
     */
    Map<String, Object> getRecommendationList(int offset, int pageSize);

    /**
     * 获取推荐详情
     * @param account
     * @param id
     * @return
     */
    Map<String, Object> getRecommendationDetails(String account, int id);

    /**
     * 购买推荐
     * @param member2DTO
     * @param id
     * @return
     */
    Map<String, Object> buyRecommendation(Member2DTO member2DTO, int id);

    /**
     * 获取竞彩大师个人信息
     * @param account
     * @return
     */
    Map<String, Object> getMasterInfo(String account, String fansAccount);


    /**
     * 设置快速审核手机号
     * @param phone
     * @return
     */
    public Map<String, Object> setFast(String phone,String account);

    /**
     * 获取个人推荐列表
     * @param account
     * @param offset
     * @param pageSize
     * @return
     */
    Map<String, Object> getRecommendationListByOne(String account, int offset, int pageSize);

    /**
     * 名人任务完成情况
     * @param account
     * @param offset
     * @param pageSize
     * @return
     */
    Map<String, Object> getTaskList(String account, int offset, int pageSize);

    /**
     * 申请名人
     * 返回一个电话号码
     */
    Map<String, Object> applyForCelebrity();

    /**
     * 发起提现
     * @param account
     * @param clouds
     * @return
     */
    Map<String, Object> withdrawCash(String account, int clouds);

    /**
     * 获取可提现金额
     * @param account
     * @return
     */
    Map<String, Object> getWithdrawCash(String account);

    Map<String,Object> findIndexInfo(Member2DTO member2DTO);

    Map<String,Object> celebrityBeginTask(Member2DTO member2DTO);
}
