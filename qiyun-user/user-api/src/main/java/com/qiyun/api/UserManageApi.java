package com.qiyun.api;

import com.qiyun.common.GoldCard2;

import java.math.BigDecimal;
import java.util.Map;

public interface UserManageApi {

    /**
     * 获取一个月未登录客户列表
     * @param offset
     * @param pageSize
     * @return
     */
    Map<String, Object> getHistoryClient(int offset,int pageSize);

    /**
     * 添加机器人
     * @param userName
     * @param mobile
     * @param certNo
     * @return
     */
    public Map<String, Object> addRobot(String userName, String mobile, String certNo);

    /**
     * 获取机器人列表
     * @param offset
     * @param pageSize
     * @return
     */
    Map<String, Object> getRobotList(int offset,int pageSize);

    Map<String,Object> findDrawsNums(String account);

    Map updateDrawsNum(String account);

    Map addGoldCard(GoldCard2 goldCard2);

    Map<String,Object> findGoldCard(String s, String startTime, String account);

    Map<String,Object> addActivity(Map<String,Object> mapParams);

    Map<String,Object> findAllActivity();

    int resetDrawsNum();

    int updateGoldCard(GoldCard2 goldCard2);

    Map<String,Object> incrementDrawsNum(String account, BigDecimal amount);

    Map<String,Object> presentes(String params,String username);


    Map<String,Object> setRate(String account, String rateParams);

    Map<String,Object> findAllRate(String account, Integer page, Integer pageSize);

    Map<String,Object> updateRateByAccount(Map memberRate2);

    Map<String,Object> delRateByAccount(String account, Integer lottery_type);

    Map<String,Object> getSubordinateMember(String account, Integer page, Integer pageSize);

    Map<String,Object> moveMember(String oldAccount, String newAccount, String moveMemberId);

    Map<String,Object> setMemberToAgent(String account,String QDAccount);

    Map<String,Object> setAgentToMember(String account);

    Map<String,Object> memberToWrite(String account,Integer type);
}
