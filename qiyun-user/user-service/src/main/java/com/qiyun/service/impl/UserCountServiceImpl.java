package com.qiyun.service.impl;

import com.qiyun.mapper2.Member2Mapper;
import com.qiyun.mapper2.UserCountMapper;
import com.qiyun.service.UserCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserCountServiceImpl implements UserCountService {
    @Autowired
    private Member2Mapper member2Mapper;
    @Autowired
    private UserCountMapper userCountMapper;

    public List<String> findQDByLoginAccount(String loginAccount) {
        return member2Mapper.findQDByLoginAccount(loginAccount);
    }

    public List<String> findDLByQD(List<String> list) {
        return userCountMapper.findAgentByQD(list);
    }

    public List<Map> findAccountWall(List<String> dlList, String startTime, String endTime) {
        return userCountMapper.findAccountWall(dlList,startTime,endTime);
    }

    public List<Map> findAgentByQDAccount(String qdAccount) {
        return userCountMapper.findAgentByQDAccount(qdAccount);
    }

    public int setAgentToGroup(List mapParams) {
        for (Object o : mapParams
                ) {
            Map map = new HashMap();
            Map<String, Object> mapInfo = (Map) o;
            for (Map.Entry<String, Object> entry : mapInfo.entrySet()) {
                map.put("groupName", entry.getValue());
                map.put("dlAccount", entry.getKey());
            }
            int i = userCountMapper.setAgentToGroup(map);
            if (i == 0) {
                return 0;
            }
        }
        return 1;
    }

    public List<Map> findAccountActiveWall(List<String> dlList, String startTime, String endTime) {
        return userCountMapper.findAccountActiveWall(dlList,startTime,endTime);
    }

    public List<Map> findRechargeAndConsumerWall(List<String> dlList, String is, String startTime, String endTime) {
        return userCountMapper.findRechargeAndConsumerWall(dlList,is,startTime, endTime);
    }

    public List<String> findMemAccountByupAccount(List<String> dlList) {
        return userCountMapper.findMemAccountByupAccount(dlList);
    }

    public int updatePaySwitch(Integer id, String pay_name, String pay_picture, Integer is_open, Date date) {

        return userCountMapper.updatePaySwitch(id, pay_name, pay_picture, is_open, date);
    }

    public int addPaySwitch(String pay_name, String pay_picture, Integer is_open, Date date) {
        return userCountMapper.addPaySwitch(pay_name, pay_picture, is_open, date);
    }

    public List<Map> findPaySwitch() {
        return userCountMapper.findPaySwitch();
    }

    public List<Map> findFocusMember(String agentAccount) {
        return userCountMapper.findFocusMember(agentAccount);
    }

    public List<Map> findAllBanner(Integer is_user) {
        return userCountMapper.findAllBanner(is_user);
    }

    public int addBanner(Map<String, Object> map) {
        int i = 0;
        List<Map> allBanner = userCountMapper.findAllBanner(null);
        //判断有没有位置比这张图片位置更靠后的
        for (Map mapBnner: allBanner
                ) {
            if (Integer.parseInt(mapBnner.get("weights")+"")>=Integer.parseInt(map.get("weights")+"")){
                //把图片往后挤
                userCountMapper.updateWeight(mapBnner);
            }
        }
        if (map.get("id").equals("")) {
            map.put("create_time", new Date());
            map.put("update_time", new Date());
            i = userCountMapper.insertBanner(map);

        } else {
            map.put("update_time", new Date());
            i = userCountMapper.updateBanner(map);

        }

        return i;
    }
}
