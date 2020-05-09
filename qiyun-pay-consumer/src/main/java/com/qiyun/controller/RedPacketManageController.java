package com.qiyun.controller;

import com.qiyun.api.RedPacketApi;
import com.qiyun.api.RedPacketManageApi;
import com.qiyun.controller.base.BaseController;
import com.qiyun.util.Constants;
import com.qiyun.util.DateUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/redPacket")
public class RedPacketManageController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(RedPacketManageController.class);

    @Resource
    private RedPacketManageApi redPacketManageApi;

    @RequestMapping(value = "/grabRedRacketList2",method = RequestMethod.GET)
    public Map<String, Object> grabRedRacketList(){
        Map<String,Object> map = new HashMap<String, Object>();
        int offset = getInt("offset", 1);
        int pageSize = getInt("pageSize", 10);
        String account = getStr("account");
        String startTime = getStr("startTime");
        String endTime = getStr("endTime");
        return redPacketManageApi.grabRedRacketList(offset,pageSize,account,startTime,endTime);
    }

    @RequestMapping(value = "/putRedRacketList2",method = RequestMethod.GET)
    public Map<String, Object> putRedRacketList(){
        Map<String,Object> map = new HashMap<String, Object>();
        int offset = getInt("offset", 1);
        int pageSize = getInt("pageSize", 10);
        String account = getStr("account");
        String startTime = getStr("startTime");
        String endTime = getStr("endTime");
        return redPacketManageApi.putRedRacketList(offset,pageSize,account,startTime,endTime);
    }


    @RequestMapping(value = "/addRedRacketForPlatform",method = RequestMethod.GET)
    public Map<String, Object> addRedRacketForPlatform(Integer[] robotIdList){
        Map<String,Object> map = new HashMap<String, Object>();
        List<Integer> list = Arrays.asList(robotIdList);
        int timeType = getInt("timeType", 1);
        Date date = null;
        if(timeType == 1) {
            date = DateUtil.StringToDate2(getStr("startTime"));
            if (date.before(new Date())) {
                map.put(Constants.CODE, Constants.ERROR_CODE_9);
                map.put(Constants.MSG, Constants.ERROR_MSG_9_9);
                return map;
            }
        }
        BigDecimal money = new BigDecimal(request.getParameter("money"));
        String name = (String) request.getParameter("name");
        int type = getInt("type", 1);
        int number = getInt("number");
        BigDecimal robotMoney = new BigDecimal(request.getParameter("robotMoney"));
        map = redPacketManageApi.addRedRacketForPlatform(list ,
                date, money, name, type, number, robotMoney);
        return map;
    }
}
