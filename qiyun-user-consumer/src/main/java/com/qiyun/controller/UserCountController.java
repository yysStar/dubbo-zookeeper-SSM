package com.qiyun.controller;

import com.alibaba.fastjson.JSONObject;
import com.qiyun.api.UserCountApi;

import com.qiyun.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
后台数据展示
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/userCount")
public class UserCountController {

@Autowired
private UserCountApi userCountApi;

    @RequestMapping("/findAccountWall")
    @ResponseBody
    public Map findAccountWall(@RequestParam String loginAccount,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "20") Integer pageSzie,@RequestParam String startTime,@RequestParam String endTime){

       Map<String,Object> map  =  userCountApi.findAccountWall(loginAccount,page,pageSzie,startTime,endTime);
       return map;

    }
    /**
     * 后台代理分组功能实现
     * [{"dlAccount":"groupName"},{"dlAccount":"groupName"}]
     */
    @RequestMapping(value="/setAgentToGroup")
    @ResponseBody
    public  Map setAgentToGroup(@RequestParam String params){

        List list = new ArrayList();
        List mapParams = JSONObject.parseObject(params, list.getClass());
        Map<String, Object> resMap = userCountApi.setAgentToGroup(mapParams);
        return resMap;
    }
    /**
     * 查询后台账号关联的渠道
     */
    @RequestMapping(value="findQDByLoginAccount",method = RequestMethod.GET)
    @ResponseBody
    public Map findQDByLoginAccount(@RequestParam String loginAccount){
        Map<String, Object> map = userCountApi.findQDByLoginAccount(loginAccount);
        return map;
    }
    /**
     * 查询代理账号通过渠道
     */
    @RequestMapping(value = "findAgentByQDAccount",method = RequestMethod.GET)
    @ResponseBody
    public Map  findAgentByQDAccount(@RequestParam String  QDAccount){
        Map<String, Object> map = userCountApi.findAgentByQDAccount(QDAccount);
        return map;
    }

    /**
     * 激活墙查询
     */

    @RequestMapping("/findAccountActiveWall")
    @ResponseBody
    public Map findAccountActiveWall(@RequestParam String loginAccount,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "20") Integer pageSzie,@RequestParam String startTime,@RequestParam String endTime ){

        Map<String,Object> map  =  userCountApi.findAccountActiveWall(loginAccount,startTime,endTime,page,pageSzie);

        return map;

    }
    /**
     * 后台
     查找充值墙he消费墙
     isConsumer 0消费墙 1为充值墙
     */

    @RequestMapping("/findRechargeAndConsumerWall")
    @ResponseBody
    public Map findRechargeAndConsumerWall(@RequestParam String loginAccount,@RequestParam(defaultValue = "1")String isConsumer,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "20") Integer pageSize,@RequestParam String startTime,@RequestParam String endTime){

        Map<String,Object> map  =  userCountApi.findRechargeAndConsumerWall(loginAccount,isConsumer,page,pageSize,startTime,endTime);

        return map;

    }

    /**
     * 后台开启支付列表
     * @param id id保存传空
     * @param pay_name 致富名字
     * @param pay_picture 图片
     * @param is_open 0 关闭1 开启 是否开启
     * @param is_update 1 修改 0添加
     * @return
     */

    @RequestMapping("/addPaySwitch")
    @ResponseBody
    public Map addPaySwitch(@RequestParam Integer id,@RequestParam String pay_name,@RequestParam String pay_picture,@RequestParam Integer is_open,@RequestParam Integer is_update) {

        Map<String, Object> map = userCountApi.addPaySwitch(id, pay_name, pay_picture, is_open, is_update);

        return map;
    }
    //查询所有支付
    @RequestMapping("/findPaySwitch")
    @ResponseBody
    public Map findPaySwitch() {

        Map<String, Object> map = userCountApi.findPaySwitch();
        return map;
    }
    //图片上传
    @RequestMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(MultipartFile file) {
        String s = FileUpload.upLoad(file);
        return s;
    }

/**
 * 查询重点客户
 */
@RequestMapping("/findFocusMember")
@ResponseBody
public Map findFocusMember(String agentAccount) {
    Map<String,Object> map =userCountApi.findFocusMember(agentAccount);
    return map;
}

    /**
     *
     * @param is_user 0 当前未使用,1当前使用
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAllBanner")
    @ResponseBody
    public  Map findAllBanner(@RequestParam Integer is_user,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10")Integer pageSize){

    Map map = userCountApi.findAllBanner(is_user,page,pageSize);
    return map;
}

    /**
     *
     * @param is_user 是否可用
     * @param picture 图片地址
     * @param render_url 图片点击跳转地址
     * @param id 修改的时候传值
     * @return
     */
    @RequestMapping("/addBanner")
    @ResponseBody
    public  Map addBanner(@RequestParam String is_user,@RequestParam String picture,@RequestParam String render_url,@RequestParam String id,@RequestParam String weights){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("is_use",is_user);
            map.put("picture",picture);
            map.put("render_url",render_url);
            map.put("id",id);
            map.put("weights",weights);
        Map resMap = userCountApi.addBanner(map);
        return resMap;
    }

    }
