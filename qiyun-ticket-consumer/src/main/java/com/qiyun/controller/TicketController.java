package com.qiyun.controller;

import com.qiyun.api.TicketApi;
import com.qiyun.controller.base.BaseController;
import com.qiyun.tools.StringTools;
import com.qiyun.util.Constants;
import com.qiyun.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ticket")
public class TicketController extends BaseController{
    private static Logger logger = LoggerFactory.getLogger(TicketController.class);

    @Resource
    private TicketApi ticketApi;

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public Map<String,Object> test(){
        return ticketApi.test();
    }

    /**
     * 竞彩赛事查询
     * @return
     */
    @RequestMapping(path = "/getCompLotteryList", method = RequestMethod.GET)
    public Map<String,Object> getCompLotteryList() {
        int type = getInt("type",0);
        int businessType = getInt("businessType",0);
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> reqMap = new HashMap<String, Object>();
        reqMap.put("type", type);
        reqMap.put("businessType", businessType);
        map = ticketApi.getCompetitiveLotteryList(reqMap);
        if(Constants.SUCCESS_CODE != Integer.parseInt(map.get(Constants.CODE).toString())){
            return map;
        }
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 竞彩赛果查询
     * @return
     */
    @RequestMapping(path = "/getCompLotteryResult", method = RequestMethod.GET)
    public Map<String,Object> getCompLotteryResult() {
        Map<String,Object> map = new HashMap<String, Object>();
        int type = getInt("type",0);
        int businessType = getInt("businessType",0);
        String id = getStr("id");
        if(StringTools.isNullOrBlank(id)){
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_6);
            return map;
        }
        Map<String,Object> reqMap = new HashMap<String, Object>();
        reqMap.put("type", type);
        reqMap.put("businessType", businessType);
        reqMap.put("id", id);
        map = ticketApi.getCompetitiveLotteryResult(reqMap);
        if(Constants.SUCCESS_CODE != Integer.parseInt(map.get(Constants.CODE).toString())){
            return map;
        }
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 竞彩赔率查询
     * @return
     */
    @RequestMapping(path = "/getCompLotteryOdds", method = RequestMethod.GET)
    public Map<String,Object> getCompLotteryOdds() {
        Map<String,Object> map = new HashMap<String, Object>();
        int type = getInt("type",0);
        int businessType = getInt("businessType",0);
        // 0单关/1多关
        int valueType = getInt("valueType",0);
        String id = getStr("id");
        if(StringTools.isNullOrBlank(id)){
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_6);
            return map;
        }
        Map<String,Object> reqMap = new HashMap<String, Object>();
        reqMap.put("type", type);
        reqMap.put("businessType", businessType);
        reqMap.put("id", id);
        reqMap.put("valueType", valueType);
        map = ticketApi.getCompetitiveLotteryOdds(reqMap);
        if(Constants.SUCCESS_CODE != Integer.parseInt(map.get(Constants.CODE).toString())){
            return map;
        }
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 中奖文件查询
     * @return
     */
    @RequestMapping(path = "/getCompLotteryFile", method = RequestMethod.GET)
    public Map<String,Object> getCompLotteryFile() {
        Map<String,Object> map = new HashMap<String, Object>();
        String id = getStr("id");
        int type = getInt("type",0);
        int businessType = getInt("businessType",0);
        Map<String,Object> reqMap = new HashMap<String, Object>();
        reqMap.put("type", type);
        reqMap.put("businessType", businessType);
        reqMap.put("id", id);
        map = ticketApi.getCompetitiveLotteryFile(reqMap);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 竞彩投注接口
     * @return
     */
    @RequestMapping(path = "/putMatchTicket", method = RequestMethod.GET)
    public Map<String,Object> putMatchTicket(String[] ticketIds) {
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> reqMap = new HashMap<String, Object>();
        int planNo = getInt("planNo");
        if(ticketIds==null || ticketIds.length<=0){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_1);
            return map;
        }
        if(planNo == -100){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_1);
            return map;
        }
        reqMap.put("planNo", planNo);
        reqMap.put("ticketIds", ticketIds);
        map = ticketApi.putMatchTicket(reqMap);
        if(Constants.SUCCESS_CODE != Integer.parseInt(map.get(Constants.CODE).toString())){
            return map;
        }
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 获取出票结果
     * @return
     */
    @RequestMapping(path = "/getTicketResult", method = RequestMethod.GET)
    public Map<String, Object> getTicketResult(String[] ticketIdList){
        int businessType = getInt("businessType",0);
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> reqMap = new HashMap<String, Object>();
        List<String> list = Arrays.asList(ticketIdList);
        reqMap.put("ticketIdList", list);
        map = ticketApi.getTicketResult(reqMap);

        return map;
    }

    /**
     * 送票校验
     * @return
     */
    @RequestMapping(path = "/ticketRestrict", method = RequestMethod.GET)
    public Map<String, Object> ticketRestrict(){
        int lotteryType = getInt("lotteryType");
        int planNo = getInt("planNo");
        String account = getStr("account");
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> reqMap = new HashMap<String, Object>();
        reqMap.put("lotteryType", lotteryType);
        reqMap.put("planNo", planNo);
        reqMap.put("account", account);
        map = ticketApi.ticketRestrict(reqMap);
        if(Constants.SUCCESS_CODE != Integer.parseInt(map.get(Constants.CODE).toString())){
            return map;
        }
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 送票校验2
     * @return
     */
    @RequestMapping(path = "/ticketRestrict2", method = RequestMethod.GET)
    public Map<String, Object> ticketRestrict2(){
        int planNo = getInt("planNo");
        Map<String,Object> map = new HashMap<String, Object>();
        map = ticketApi.ticketRestrict2(planNo);
        if(Constants.SUCCESS_CODE != Integer.parseInt(map.get(Constants.CODE).toString())){
            return map;
        }
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     *
     * @return
     */
    @RequestMapping(path = "/putMaxSp", method = RequestMethod.GET)
    public Map<String, Object> putMaxSp(){
        double maxSp = getDouble("maxSp");
        int planNo = getInt("planNo");
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> reqMap = new HashMap<String, Object>();
        reqMap.put("planNo", planNo);
        reqMap.put("maxSp", maxSp);
        map = ticketApi.putMaxSp(reqMap);
        if(Constants.SUCCESS_CODE != Integer.parseInt(map.get(Constants.CODE).toString())){
            return map;
        }
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }


}