package com.qiyun.controller;

import com.github.pagehelper.Page;
import com.qiyun.api.UserManageApi;
import com.qiyun.common.GoldCard2;
import com.qiyun.controller.base.BaseController;
import com.qiyun.model2.Gift;
import com.qiyun.model2.MemberRate2;
import com.qiyun.util.Constants;
import com.qiyun.util.Draw;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.nio.DoubleBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/userManage")
public class UserManageController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(UserManageController.class);

    @Resource
    private UserManageApi userManageApi;

    @RequestMapping(value = "/getHistoryClient", method = RequestMethod.GET)
    public Map<String, Object> getHistoryClient() {
        Map<String, Object> map = new HashMap<String, Object>();
        int page = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        map = userManageApi.getHistoryClient(page, pageSize);
        return map;
    }


    @RequestMapping(value = "/addRobot", method = RequestMethod.GET)
    public Map<String, Object> addRobot() {
        Map<String, Object> map = new HashMap<String, Object>();
        String mobile = getStr("mobile");
        String userName = request.getParameter("userName");
        String certNo = getStr("certNo");
        if (mobile == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_1_5);
            return map;
        }
        if (certNo == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_1);
            return map;
        }
        if (userName == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_1);
            return map;
        }
        map = userManageApi.addRobot(userName, mobile, certNo);
        return map;
    }

    @RequestMapping(value = "/getRobotList", method = RequestMethod.GET)
    public Map<String, Object> getRobotList() {
        Map<String, Object> map = new HashMap<String, Object>();
        int page = getInt("offset", 1);
        int pageSize = getInt("pageSize", 10);
        map = userManageApi.getRobotList(page, pageSize);
        return map;
    }

    /**
     * 查询抽奖的次数
     */
    @RequestMapping(value = "/findDrawsNums", method = RequestMethod.GET)
    public Map<String, Object> findDrawsNums(@RequestParam String account) {
        Map<String, Object> map = userManageApi.findDrawsNums(account);
        return map;
    }

    /**
     * 点击抽奖
     */
    @RequestMapping(value = "/drawGift", method = RequestMethod.GET)
    public Map drawGift(@RequestParam String account) {
        Gift gift1 = new Gift(1, "888元彩金卡", 0.02, 888);
        Gift gift2 = new Gift(2, "288元彩金卡", 0.02, 288);
        Gift gift3 = new Gift(3, "128元彩金卡", 0.11, 128);
        Gift gift4 = new Gift(4, "68元彩金卡", 0.11, 28);
        Gift gift5 = new Gift(5, "28元彩金卡", 0.25, 28);
        Gift gift6 = new Gift(6, "8元彩金卡", 0.25, 8);
        Gift gift7 = new Gift(7, "5元彩金卡", 0.02, 5);
        Gift gift8 = new Gift(8, "2元彩金卡", 0.02, 2);
        Gift gift9 = new Gift(9, "不要灰心", 0.1, -1);
        Gift gift10 = new Gift(10, "谢谢参与", 0.1, -1);
        Gift gift11 = new Gift(11, "苹果×", 0, -1);
        Gift gift12 = new Gift(12, "2018年世界杯纪念品", 0, -1);
        List<Gift> giftList = new ArrayList<Gift>();
        giftList.add(gift1);
        giftList.add(gift2);
        giftList.add(gift3);
        giftList.add(gift4);
        giftList.add(gift5);
        giftList.add(gift6);
        giftList.add(gift7);
        giftList.add(gift8);
        giftList.add(gift9);
        giftList.add(gift10);
        giftList.add(gift11);
        giftList.add(gift12);
        if (null != giftList && giftList.size() > 0) {
            List<Double> orgProbList = new ArrayList<Double>(giftList.size());
            for (Gift gift : giftList) {
                //按顺序将概率添加到集合中
                orgProbList.add(gift.getProb());
            }
            int i = Draw.draw(orgProbList);
            //修改数据库的抽奖次数
            Map map = userManageApi.updateDrawsNum(account);
            if (map.get("message").equals("今日次数已用完")) {
                return map;
            } else {
                if (1 == Integer.parseInt(map.get("data").toString())) {
                    map.put(Constants.DATA, giftList.get(i));
                }
            }
            return map;
        }
        return null;
    }

    /**
     * 每天重新设置抽奖时间
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void resetDrawsNum() {
        int num = userManageApi.resetDrawsNum();
        if (num > 0) {
            logger.info("抽奖次数已重置");
        } else {
            logger.error("抽奖次数重置失败");
        }
    }

    /**
     * 单个代购方案包含跟单金额满500元（可以设置）及以上即可再获一次抽奖机会；
     */

    @RequestMapping(value = "/incrementDrawsNum")
    @ResponseBody
    public Map incrementDrawsNum(@RequestParam String account, @RequestParam BigDecimal amount) {

        Map<String, Object> map = userManageApi.incrementDrawsNum(account, amount);
        return map;
    }

    /**
     * 保存 彩金卡
     * [{"account":value,"money":value,"require_type":value},{"account":value,"money":value,"require_type":value}]
     */
    @RequestMapping(value = "/addGoldCard", method = RequestMethod.GET)
    public Map<String, Object> addGoldCard(@RequestParam String params,String loginAccount) throws ParseException {
        List list = com.alibaba.fastjson.JSONObject.parseObject(params, List.class);
        Map maps = null;
        for (Object map : list
                ) {
            Map mapParams = (Map) map;
            String account = mapParams.get("account").toString();
            BigDecimal money = new BigDecimal(mapParams.get("money").toString());
            Integer require_type = Integer.parseInt(mapParams.get("require_type").toString());
            String cardName;
            BigDecimal full_amount;
            GoldCard2 goldCard2 = new GoldCard2();
            goldCard2.setAccount(account);
            goldCard2.setMoney(money);
            goldCard2.setRequire_type(require_type);
            goldCard2.setRequire_type(require_type);
            goldCard2.setSend_name(loginAccount);
            Date date = new Date();

            goldCard2.setCreate_time(date);
            //设置过期时间
            Calendar ca = Calendar.getInstance();
            SimpleDateFormat sfm = new SimpleDateFormat("yyyy-MM-dd");
            String format = sfm.format(date);
            Date parse = sfm.parse(format);
            ca.setTime(parse);
            ca.add(Calendar.DATE, 7);
            goldCard2.setDeadline_time(ca.getTime());
            goldCard2.setStatus(0);
            switch (Integer.valueOf(money + "")) {
                case 2:
                    cardName = "2元彩金卡";
                    full_amount = BigDecimal.valueOf(2);
                    goldCard2.setCard_name(cardName);
                    goldCard2.setFull_amount(full_amount);
                    break;
                case 5:
                    cardName = "5元彩金卡";
                    full_amount = BigDecimal.valueOf(100);
                    goldCard2.setCard_name(cardName);
                    goldCard2.setFull_amount(full_amount);
                    break;
                case 8:
                    cardName = "8元彩金卡";
                    full_amount = BigDecimal.valueOf(1000);
                    goldCard2.setCard_name(cardName);
                    goldCard2.setFull_amount(full_amount);
                    break;
                case 28:
                    cardName = "28元彩金卡";
                    full_amount = BigDecimal.valueOf(3000);
                    goldCard2.setCard_name(cardName);
                    goldCard2.setFull_amount(full_amount);
                    break;
                case 68:
                    cardName = "68元彩金卡";
                    full_amount = BigDecimal.valueOf(6000);
                    goldCard2.setCard_name(cardName);
                    goldCard2.setFull_amount(full_amount);
                    break;
                case 128:
                    cardName = "128元彩金卡";
                    full_amount = BigDecimal.valueOf(10000);
                    goldCard2.setCard_name(cardName);
                    goldCard2.setFull_amount(full_amount);
                    break;
                case 288:
                    cardName = "288元彩金卡";
                    full_amount = BigDecimal.valueOf(20000);
                    goldCard2.setCard_name(cardName);
                    goldCard2.setFull_amount(full_amount);
                    break;
                case 888:
                    cardName = "888元彩金卡";
                    full_amount = BigDecimal.valueOf(50000);
                    goldCard2.setCard_name(cardName);
                    goldCard2.setFull_amount(full_amount);
                    break;
                case -1:
                    maps.put(Constants.CODE, Constants.SUCCESS_CODE);
                    maps.put(Constants.MSG, "未中奖");
                    return maps;
                    default:
                        maps.put(Constants.CODE, Constants.SUCCESS_CODE);
                        maps.put(Constants.MSG, "输入正确的金额");
                        return maps;
            }

            maps = userManageApi.addGoldCard(goldCard2);
        }
        return maps;
    }

    /**
     * 查询彩金卡
     */
    @RequestMapping(value = "/findGoldCard", method = RequestMethod.GET)
    public Map<String, Object> findGoldCard(@RequestParam String account,String startTime,String endTime) {
        Map<String, Object> map = userManageApi.findGoldCard(account,startTime,endTime);
        return map;
    }

    /**
     * 定时判断彩金卡是否过期
     */
    @Scheduled(cron = "0 5 0 * * ?")
    public void checkGoldCardTime() {
        String account = null;
        String startTime = null;
        String endTime = null;
        Map<String, Object> map = userManageApi.findGoldCard(account, startTime, endTime);
        List<GoldCard2> list = (List<GoldCard2>) map.get("data");
        try {
            for (GoldCard2 goldCard2 : list) {
                if (goldCard2.getDeadline_time().getTime() < new Date().getTime()) {
                    //修改彩金卡状态
                    if (goldCard2.getStatus() == 0) {
                        int num = userManageApi.updateGoldCard(goldCard2);
                        if (num > 0) {
                            logger.info("彩金卡过期修改成功");
                        }
                    }
                }
            }
        } catch (Exception ex) {
            logger.error("彩金卡过期修改失败");
        }

    }

    /**
     * 添加活动
     * is_eduit 0:添加 1修改
     */
    @RequestMapping(value = "/addActivity", method = RequestMethod.GET)
    public Map<String, Object> addActivity(@RequestParam Integer activity_id,
                                           @RequestParam String activity_name, @RequestParam String is_switch, @RequestParam String start_time,
                                           @RequestParam String end_time, @RequestParam String description, @RequestParam String content, @RequestParam Integer is_edit) {
        Map<String, Object> mapParams = new HashMap<String, Object>();
        mapParams.put("activity_name", activity_name);
        mapParams.put("is_switch", is_switch);
        mapParams.put("start_time", start_time);
        mapParams.put("end_time", end_time);
        mapParams.put("description", description);
        mapParams.put("content", content);
        mapParams.put("is_edit", is_edit);
        mapParams.put("activity_id", activity_id);
        Map<String, Object> map = userManageApi.addActivity(mapParams);
        return map;
    }

    /**
     * 查找所有活动
     */
    @RequestMapping(value = "/findAllActivity", method = RequestMethod.GET)
    public Map<String, Object> findAllActivity() {
        Map<String, Object> map = userManageApi.findAllActivity();
        return map;
    }
/**
 * 客户赠送彩金
 * ["key":value,"key":value,"账号":"金额"]
 */
@RequestMapping(value = "/presentes",method = RequestMethod.GET)
 public Map presentes(@RequestParam String params,@RequestParam String username){
    Map<String, Object> map = userManageApi.presentes(params,username);
    return map;
 }
    /**
     *
     * @param account 账号
     * @param  rateParams: [{"lotteryType":value ,"dg_rate":value,"hm_rate":value,"startDate":value,"endDate":value,"remark":value},{"lotteryType":value ,"dg_rate":value,"hm_rate":value,startDate":value,"endDate":value",remark":value}]
     * lotteryType 38竞彩足球 39竞彩篮球
     *  gd_rate 代购点位
     * hn_rate 合买点位
     * @return
     */
    @RequestMapping(value="/setRate",method = RequestMethod.GET)
    @ResponseBody
public Map setRate(@RequestParam String account, @RequestParam String rateParams){
    Map<String, Object> map = userManageApi.setRate(account,rateParams);
    return map;
}
    /**
     * 账号返点
     * @param page
     * @param pageSize
     * @param account 账号
     * @return
     */
    @RequestMapping(value="/findAllRate",method = RequestMethod.GET)
    @ResponseBody
        public Map findAllRate(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize,@RequestParam String account){
        Map<String, Object> map = userManageApi.findAllRate(account,page,pageSize);
        return map;
    }

/**
 * 修改 返点
 */
@RequestMapping(value="/updateRateByAccount",method = RequestMethod.GET)
@ResponseBody
public Map updateRateByAccount(@RequestParam Integer rate_id,@RequestParam String account,@RequestParam Integer lottery_type,@RequestParam double gd_rate,@RequestParam double hm_rate,@RequestParam String startDate,@RequestParam String  endDate){

    Map mapParams = new HashMap();
    mapParams.put("rate_id",rate_id);
    mapParams.put("account",account);
    mapParams.put("dg_rate",gd_rate);
    mapParams.put("hm_rate",hm_rate);
    mapParams.put("startDate",startDate);
    mapParams.put("endDate",endDate);
    mapParams.put("lotteryType",lottery_type);
    Map<String, Object> map = userManageApi.updateRateByAccount(mapParams);
    return map;
}

/**
 * 删除所有返点
 */
@RequestMapping(value="/delRateByAccount",method = RequestMethod.GET)
@ResponseBody
public Map updateRateByAccount(@RequestParam String account, @RequestParam Integer lottery_type){
    Map<String, Object> map = userManageApi.delRateByAccount(account,lottery_type);
    return map;
}
/**
 *客户批量转移
 * 1.将渠道的客户 转给渠道
 * 2.将代理的客户转给代理
 * 3.将代理的客户转给渠道
 * 4.将渠道的客户转给代理
// *
 */
@RequestMapping(value="/moveMember",method = RequestMethod.GET)
@ResponseBody
public Map moveMember(@RequestParam String oldAccount, @RequestParam String newAccount,@RequestParam String moveMemberId ){
    Map<String, Object> map = userManageApi.moveMember(oldAccount,newAccount,moveMemberId);
    return map;
}

/**
 * 查询下级人员
 */
@RequestMapping(value="/getSubordinateMember",method = RequestMethod.GET)
@ResponseBody
public Map getSubordinateMember(@RequestParam String account, @RequestParam Integer page,@RequestParam Integer pageSize){
    Map<String, Object> map = userManageApi.getSubordinateMember(account,page,pageSize);
    return map;
}
/**
 * 将会员设置成代理
 */
@RequestMapping(value="/setMemberToAgent",method = RequestMethod.GET)
@ResponseBody
public Map setMemberToAgent(@RequestParam String account,String QDAccount){
    Map<String, Object> map = userManageApi.setMemberToAgent(account,QDAccount);
    return map;
}
/**
 * 代理降级为普通会员
 */
@RequestMapping(value="/setAgentToMember",method = RequestMethod.GET)
@ResponseBody
public Map setAgentToMember(@RequestParam String account){
    Map<String, Object> map = userManageApi.setAgentToMember(account);
    return map;
}
/**
 * 会员加白
 */
@RequestMapping(value="memberToWrite",method = RequestMethod.GET)
    @ResponseBody
    public  Map memberToWrite(@RequestParam String account,@RequestParam Integer type){
    Map<String, Object> map = userManageApi.memberToWrite(account,type);
    return map;
}



}
