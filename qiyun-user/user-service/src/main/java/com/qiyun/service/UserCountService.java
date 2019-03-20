package com.qiyun.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserCountService {
    List<String> findQDByLoginAccount(String loginAccount);

    List<String> findDLByQD(List<String> list);

    List<Map> findAccountWall(List<String> dlList, String startTime, String endTime);

    List<Map> findAgentByQDAccount(String qdAccount);

    int setAgentToGroup(List mapParams);

    List<Map> findAccountActiveWall(List<String> dlList, String startTime, String endTime);

    List<Map> findRechargeAndConsumerWall(List<String> dlList, String is, String startTime, String endTime);

    List<String> findMemAccountByupAccount(List<String> dlList);

    int updatePaySwitch(Integer id, String pay_name, String pay_picture, Integer is_open, Date date);

    int addPaySwitch(String pay_name, String pay_picture, Integer is_open, Date date);

    List<Map> findPaySwitch();

    List<Map> findFocusMember(String a);

    List<Map> findAllBanner(Integer is_user);

    int addBanner(Map<String,Object> map);
}
