package com.qiyun.service.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.api.UserCountApi;
import com.qiyun.service.UserCountService;
import com.qiyun.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("userCountApi")
public class UserCountBiz implements UserCountApi {
    @Autowired
    private UserCountService userCountService;
    private final  String  PIC_URL="qyun88.oss-cn-hangzhou.aliyuncs.com/pay/";

    public Map<String, Object> findAccountWall(String loginAccount, Integer page, Integer pageSzie, String startTime, String endTime) {

        //通过传入渠道代理的id 去查找渠道或者代理的开户数
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            //查找这个登录账号下面所有渠道
            List<String> list = userCountService.findQDByLoginAccount(loginAccount);
            if (list.size()==0){
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG,"该账号没有查询信息权限");
                return resMap;
            }
            //查询这个账号下所有渠道下面的代理
            List<String> dlList  = userCountService.findDLByQD(list);
                //将渠道account 放入代理account集合中
            dlList.addAll(list);
                //1查询渠道和代理的开户数
            PageHelper.startPage(page,pageSzie);
            List<Map> resList  =  userCountService.findAccountWall(dlList,startTime,endTime);
            PageInfo pageInfo = new PageInfo(resList);
                //2.查询渠道代理的开户数
            if (resList.size()>0){
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                resMap.put(Constants.DATA,pageInfo);
            }else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "当天没有开户数");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> findQDByLoginAccount(String loginAccount) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
        List<String> list = userCountService.findQDByLoginAccount(loginAccount);
            if (list.size()>0){
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                resMap.put(Constants.DATA,list);
            }else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "当天没有开户数");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> findAgentByQDAccount(String qdAccount) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            List<Map> list = userCountService.findAgentByQDAccount(qdAccount);
            if (list.size()>0){
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                resMap.put(Constants.DATA,list);
            }else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "查询失败");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> setAgentToGroup(List mapParams) {

        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
           int resNum = userCountService.setAgentToGroup(mapParams);
            if (resNum>0){
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);

            }else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "设置失败");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> findAccountActiveWall(String loginAccount, String startTime, String endTime, Integer page, Integer pageSize) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            //查找这个登录账号下面所有渠道
            List<String> list = userCountService.findQDByLoginAccount(loginAccount);
            if (list.size()==0){
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG,"该账号没有查询信息权限");
                return resMap;
            }
            //查询这个账号下所有渠道下面的代理
            List<String> dlList  = userCountService.findDLByQD(list);
            //将渠道account 放入代理account集合中
            dlList.addAll(list);
            //1查询渠道和代理的开户数
            PageHelper.startPage(page,pageSize );
            List<Map> resList  =  userCountService.findAccountActiveWall(dlList,startTime,endTime);

            //2.查询渠道代理的开户数
            if (resList.size()>0){
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                resMap.put(Constants.DATA,resList);
            }else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "当天没有激活数");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> findRechargeAndConsumerWall(String loginAccount, String is, Integer page, Integer pageSize, String startTime, String endTime) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            //查找这个登录账号下面所有渠道
            List<String> list = userCountService.findQDByLoginAccount(loginAccount);
            if (list.size()==0){
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG,"该账号没有查询信息权限");
                return resMap;
            }
            //查询这个账号下所有渠道下面的代理
            List<String> dlList  = userCountService.findDLByQD(list);
            //将渠道account 放入代理account集合中
            dlList.addAll(list);
            //1查询渠道和代理的
            PageHelper.startPage(page,pageSize);
            List<Map> resList  =  userCountService.findRechargeAndConsumerWall(dlList,is,startTime,endTime);
            PageInfo pageInfo = new PageInfo(resList);
            //2.查询渠道代理的开户数
            if (resList.size()>0){
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                resMap.put(Constants.DATA,pageInfo);
            }else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "当天没有充值 或者消费");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> addPaySwitch(Integer id, String pay_name, String pay_picture, Integer is_open, Integer is_update) {


        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            Date date = new Date();
            int resNum =0;
            //判断是添加还是修改 0 添加 1修改
            if (is_update==0){

                resNum = userCountService.addPaySwitch(pay_name,pay_picture,is_open,date);
            }else if (is_update==1){
              resNum =  userCountService.updatePaySwitch(id,pay_name,pay_picture,is_open,date);
            }

            if (resNum>0){
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);

            }else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "设置失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> findPaySwitch() {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            List<Map> list = userCountService.findPaySwitch();
            for (Map map: list
                 ) {
                map.put("pay_picture",PIC_URL+ map.get("pay_picture"));
            }
            if (list.size()>0){
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                resMap.put(Constants.DATA,list);
            }else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "当天没有开户数");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map<String, Object> findFocusMember(String agentAccount) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            List<Map> list = userCountService.findFocusMember(agentAccount);
            if (list.size()>0){
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                resMap.put(Constants.DATA,list);
            }else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "当天没有开户数");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map findAllBanner(Integer is_user, Integer page, Integer pageSize) {


        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            PageHelper.startPage(page,pageSize);
            List<Map> list = userCountService.findAllBanner(is_user);
            for (Map ne:list) {
                Date create_time = (Date)ne.get("create_time");
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String create_time2= format2.format(create_time);
                ne.put("create_time2",create_time2);
                Date update_time = (Date)ne.get("update_time");
                String update_time2= format2.format(update_time);
                ne.put("update_time2",update_time2);
            }
            PageInfo pageInfo = new PageInfo(list);
             if (list.size()>0){
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
                resMap.put(Constants.DATA,pageInfo);
            }else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "查询结果为空");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }

    public Map addBanner(Map<String, Object> map) {

        Map<String, Object> resMap = new HashMap<String, Object>();
        try {

           int i = userCountService.addBanner(map);
            if (i>0){
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            }else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "添加或修改失败");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);

        }
        return resMap;
    }
}
