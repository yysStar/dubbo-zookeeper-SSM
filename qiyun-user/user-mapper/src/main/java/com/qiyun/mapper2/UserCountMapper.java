package com.qiyun.mapper2;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserCountMapper {
    List<String> findAgentByQD(List<String> list);

    List<Map> findAccountWall(@Param("list") List<String> dlList, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<Map> findAgentByQDAccount(String qdAccount);

    int setAgentToGroup(Map mapParams);

    List<Map> findAccountActiveWall(@Param("list") List<String> dlList, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<Map> findRechargeAndConsumerWall(@Param("list") List<String> dlList, @Param("isConsumer") String is, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<String> findMemAccountByupAccount(@Param("list")List<String> dlList);

    int updatePaySwitch(Integer id, String pay_name, String pay_picture, Integer is_open, Date date);

    int addPaySwitch(String pay_name, String pay_picture, Integer is_open, Date date);

    List<Map> findPaySwitch();

    List<Map> findFocusMember(@Param("agentAccount") String agentAccount);

    List<Map> findAllBanner(@Param("is_use") Integer is_user);

    int insertBanner(Map<String,Object> map);

    int updateBanner(Map<String,Object> map);

    void updateWeight(Map<String,Object> map);
}
