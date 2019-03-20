package com.qiyun.api;

import java.util.List;
import java.util.Map;

public interface UserCountApi {
    Map<String,Object> findAccountWall(String loginAccount, Integer page, Integer pageSzie, String startTime, String endTime);

    Map<String,Object> findQDByLoginAccount(String loginAccount);

    Map<String,Object> findAgentByQDAccount(String qdAccount);

    Map setAgentToGroup(List mapParams);

    Map<String,Object> findAccountActiveWall(String loginAccount, String startTime, String endTime, Integer page, Integer pageSzie);

    Map<String,Object> findRechargeAndConsumerWall(String account, String loginAccount, Integer page, Integer pageSize, String startTime, String endTime);

    Map<String,Object> addPaySwitch(Integer id, String pay_name, String pay_picture, Integer is_open, Integer is_update);

    Map<String,Object> findPaySwitch();

    Map<String, Object> findFocusMember(String agentAccount);

    Map findAllBanner(Integer is_user, Integer page, Integer pageSize);

    Map addBanner(Map<String,Object> map);
}
