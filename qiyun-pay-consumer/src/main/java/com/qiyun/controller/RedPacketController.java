package com.qiyun.controller;

import com.qiyun.api.RedPacketApi;
import com.qiyun.controller.base.BaseController;
import com.qiyun.dto.Member2DTO;
import com.qiyun.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/redPacket")
public class RedPacketController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(RedPacketController.class);

    @Resource
    private RedPacketApi redPacketApi;

    @RequestMapping(value = "/lyRedPackage",method = RequestMethod.GET)
    public Map<String, Object> lyRedPackage(){
        Map<String, Object> map = new HashMap<String, Object>();
        String id = getStr("id");
//        String content = getStr("content");
        String content = request.getParameter("content");
        if(content != null) {
            try {
                content = new String(content.getBytes("ISO-8859-1"), "utf-8");
            } catch (IOException e) {
                logger.info("---------------------接口入参编码问题",e);
            }
        }
        Member2DTO member2DTO = checkLogin();
        if(member2DTO == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        if(id == null || content == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        String account = member2DTO.getAccount();
        return redPacketApi.lyRedPackage(id,account,content);
    }

    @RequestMapping(value = "/isRedPacket",method = RequestMethod.GET)
    public Map<String, Object> isRedPacket(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if(member2DTO == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        String account = member2DTO.getAccount();
        map = redPacketApi.isRedPacket(account);
        return map;
    }

    /**
     * 发红包时查询是否有进行中的单或红单
     * @return
     */
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public Map<String, Object> search(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if(member2DTO == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        String account = member2DTO.getAccount();
        map = redPacketApi.search(account);
        return map;
    }

    /**
     * 新建红包
     * @return
     */
    @RequestMapping(value = "/addRedRacket",method = RequestMethod.GET)
    public Map<String, Object> addRedRacket(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if(member2DTO == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        String account = member2DTO.getAccount();
        String name = request.getParameter("name");
        BigDecimal money = new BigDecimal(getStr("money"));
        int number = getInt("number");
        int mark = getInt("mark",1);
        BigDecimal unitMonry = money.divide(new BigDecimal(number), 2,BigDecimal.ROUND_HALF_UP);
        if(unitMonry.compareTo(new BigDecimal("0.01")) < 0){
            map.put(Constants.CODE, Constants.ERROR_CODE_9);
            map.put(Constants.MSG, Constants.ERROR_MSG_9_2);
            return map;
        }
        int apply = getInt("apply");
        int type = getInt("type");
        map = redPacketApi.addRedRacket(account, money, name, type, number, apply,mark);
        return  map;
    }

    /**
     * 红包列表
     * @return
     */
    @RequestMapping(value = "/redRacketList",method = RequestMethod.GET)
    public Map<String, Object> redRacketList(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if(member2DTO == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        String account = member2DTO.getAccount();
        int offset = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        map = redPacketApi.redRacketList(offset, pageSize,account);
        return map;
    }

    /**
     * 红包详情
     * @return
     */
    @RequestMapping(value = "/getRedPacketDetails",method = RequestMethod.GET)
    public Map<String, Object> getRedPacketDetails(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if(member2DTO == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        int redPacketId = getInt("redPacketId");
        map = redPacketApi.getRedPacketDetails(member2DTO.getAccount(), redPacketId);
        return map;
    }

    /**
     * 我抢到的红包
     * @return
     */
    @RequestMapping(value = "/MygrabRedRacketList",method = RequestMethod.GET)
    public Map<String, Object> MygrabRedRacketList(){
        Map<String, Object> map = new HashMap<String, Object>();
        int offset = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        Member2DTO member2DTO = checkLogin();
        if(member2DTO == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        String account = member2DTO.getAccount();
        map = redPacketApi.MygrabRedRacketList(account, offset, pageSize);
        return map;
    }

    /**
     * 发出的红包列表
     * @return
     */
    @RequestMapping(value = "/awardRedPacketList",method = RequestMethod.GET)
    public Map<String, Object> awardRedPacketList(){
        Map<String, Object> map = new HashMap<String, Object>();
        int offset = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        Member2DTO member2DTO = checkLogin();
        String account = getStr("account");
        if(account == null){
            if(member2DTO == null){
                map.put(Constants.CODE, Constants.ERROR_CODE_2);
                map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
                return map;
            }
            account = member2DTO.getAccount();
        }
        map = redPacketApi.awardRedPacketList(account, offset, pageSize);
        return map;
    }

    /**
     * 红包校验
     * @return
     */
    @RequestMapping(value = "/checkRedRacket",method = RequestMethod.GET)
    public Map<String, Object> checkRedRacket(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if(member2DTO == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        int id = getInt("id");
        map = redPacketApi.checkRedRacket(id, member2DTO.getAccount());
        return map;
    }

    /**
     * 获取抢红包需要跳转的页面
     * @return
     */
    @RequestMapping(value = "/getJump",method = RequestMethod.GET)
    public Map<String, Object> getJump(){
        Map<String, Object> map = new HashMap<String, Object>();
        int id = getInt("id");
        Map<String, Object> jump = redPacketApi.getJump(id);
        return jump;
    }


    /**
     * 抢红包接口
     * @return
     */
    @RequestMapping(value = "/grabRedRacket",method = RequestMethod.GET)
    public Map<String, Object> grabRedRacket(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if(member2DTO == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        int id = getInt("id");
        map = redPacketApi.grabRedRacket(id, member2DTO.getAccount());
        return map;
    }

    /**
     * 抢红包记录列表
     * @return
     */
    @RequestMapping(value = "/grabRedRacketList",method = RequestMethod.GET)
    public Map<String, Object> grabRedRacketList(){
        Map<String, Object> map = new HashMap<String, Object>();
        int offset = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        map = redPacketApi.grabRedRacketList(offset, pageSize);
        return map;
    }

    /**
     * 获取用户当前红包
     * @return
     */
    @RequestMapping(value = "/getRedPacketNow",method = RequestMethod.GET)
    public Map<String, Object> getRedPacketNow(){
        Map<String, Object> map = new HashMap<String, Object>();
        String account = getStr("account");
        map = redPacketApi.getRedPacketNow(account);
        return map;
    }

}
