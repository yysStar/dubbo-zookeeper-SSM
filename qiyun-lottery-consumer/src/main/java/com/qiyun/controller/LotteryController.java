package com.qiyun.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.qiyun.api.LotteryApi;
import com.qiyun.bonus.Sporttery3GMatchItem;
import com.qiyun.checkBingo.SportteryTicketModel;
import com.qiyun.common.MyPageInfo;
import com.qiyun.common.Result;
import com.qiyun.commonModel.LotteryType;

import com.qiyun.controller.base.BaseController;
import com.qiyun.dto.*;
import com.qiyun.grabber.model.SportteryFileUploadContentModel;
import com.qiyun.httpUtil.RedisUtil;

import com.qiyun.lottery.LotteryPlan;
import com.qiyun.model.*;
import com.qiyun.model.basketball.BasketBallBetContent;
import com.qiyun.model.basketball.BasketBallMatchItem;
import com.qiyun.model2.*;
import com.qiyun.tools.DateTools;
import com.qiyun.tools.FileTools;
import com.qiyun.type.PassMode;

import com.qiyun.util.Constants;
import com.qiyun.util.LogUtil;
import com.qiyun.utils.CommonUtils;
import com.qiyun.utils.MathUtils;
import com.qiyun.utils.StringTools;
import com.qiyun.utils.StringUtils;

import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.xml.transform.dom.DOMLocator;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/lottery")
public class LotteryController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(LotteryController.class);

    @Resource
    private LotteryApi lotteryApi;



    /**
     * 更新赛事信息
     *
     * @return
     */
    @RequestMapping(path = "/updateMatch", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updateMatch(int planNo) {
        lotteryApi.updateBasketBallMatch();
        lotteryApi.updateFootBallMatch();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 后台方案明细
     *
     * @return
     */
    @RequestMapping(path = "/getPlanDetailForManager", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getPlanDetailForManager(int planNo) {
        return lotteryApi.getPlanDetailForManager(planNo);
    }

    /**
     * 根据比赛搜索方案
     *
     * @return
     */
    @RequestMapping(path = "/getPlanByMatch", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getPlanByMatch() {
        Integer intTime = getInt("intTime");
        Integer lineId = getInt("lineId");
        return lotteryApi.getPlanByMatch(intTime, lineId);
    }

    /**
     * 奖金预测
     *
     * @return
     */
    @RequestMapping(path = "/bonusPrediction", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> bonusPrediction(String[] passTypes) {
        Map<String, Object> map = new HashMap<String, Object>();
        String itemsStr = request.getParameter("items");
        List<Sporttery3GMatchItem> items = JSONArray.parseArray(itemsStr, Sporttery3GMatchItem.class);
        map.put("lotType", getInt("lotType"));
        map.put("multiple", getInt("multiple"));
        map.put("amount", getInt("amount"));
        map.put("passTypes", passTypes);
        map.put("items", items);
        return lotteryApi.bonusPrediction(map);
    }

    /**
     * 修改彩种停开售
     *
     * @return
     */
    @RequestMapping(path = "/updateLotteryTypeIsSale", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updateLotteryTypeIsSale() {
        String lotteryType = request.getParameter("lotteryType");
        Integer status = getInt("status");
        return lotteryApi.updateLotteryTypeIsSale(lotteryType, status);
    }

    /**
     * 获取彩种停开售11
     *
     * @return
     */
    @RequestMapping(path = "/getLotteryTypeIsSale", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getLotteryTypeIsSale() {
        return lotteryApi.getLotteryTypeIsSale();
    }

    /**
     * 后台竞彩篮球修改信息
     *
     * @return
     */
    @RequestMapping(path = "/updateBasketBallAdmin", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updateBasketBallAdmin() {
        Integer id = getInt("id");
        Double rf = getDouble("rf");
        Integer homeScore = getInt("homeScore");
        Integer guestScore = getInt("guestScore");
        Double baseBigOrSmall = getDouble("baseBigOrSmall");
        Integer status = getInt("status");
        SportteryBasketMatch2 basketMatch2 = new SportteryBasketMatch2();
        basketMatch2.setId(id);
        basketMatch2.setHandicap(rf);
        basketMatch2.setHomescore(homeScore);
        basketMatch2.setGuestscore(guestScore);
        basketMatch2.setBasebigorsmall(baseBigOrSmall);
        basketMatch2.setStatus(status);
        return lotteryApi.updateBasketBallAdmin(basketMatch2);
    }

    /**
     * 后台竞彩足球修改信息
     *
     * @return
     */
    @RequestMapping(path = "/updateFootBallAdmin", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updateFootBallAdmin() {
        Integer id = getInt("id");
        Integer rq = getInt("rq");
        Integer homeScore = getInt("homeScore");
        Integer guestScore = getInt("guestScore");
        Integer halfHomeScore = getInt("halfHomeScore");
        Integer halfGuestScore = getInt("halfGuestScore");
        Integer status = getInt("status");
        SportteryFootballMatch2 footballMatch2 = new SportteryFootballMatch2();
        footballMatch2.setId(id);
        footballMatch2.setConcede(rq);
        footballMatch2.setHomescore(homeScore);
        footballMatch2.setGuestscore(guestScore);
        footballMatch2.setHalfhomescore(halfHomeScore);
        footballMatch2.setHalfguestscore(halfGuestScore);
        footballMatch2.setStatus(status);
        return lotteryApi.updateFootBallAdmin(footballMatch2);
    }

    /**
     * 后台竞彩足球
     *
     * @return
     */
    @RequestMapping(path = "/getFootBallAdmin", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getFootBallAdmin() {
        String time = request.getParameter("time");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Integer intTime;
        if (StringUtils.isNullOrBlank(time)) {
            intTime = Integer.parseInt(sdf.format(new Date()));
        } else {
            intTime = Integer.parseInt(time);
        }
        return lotteryApi.getFootBallAdmin(intTime);
    }

    /**
     * 后台竞彩篮球
     *
     * @return
     */
    @RequestMapping(path = "/getBasketBallAdmin", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getBasketBallAdmin() {
        String time = request.getParameter("time");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Integer intTime;
        if (StringUtils.isNullOrBlank(time)) {
            intTime = Integer.parseInt(sdf.format(new Date()));
        } else {
            intTime = Integer.parseInt(time);
        }
        return lotteryApi.getBasketBallAdmin(intTime);
    }

    /**
     * 手动派奖
     *
     * @return
     */
    @RequestMapping(path = "/returnPrize", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> returnPrize() {
        String plans = request.getParameter("plans");
        return lotteryApi.returnPrize(plans);
    }

    /**
     * 查询中奖方案
     *
     * @return
     */
    @RequestMapping(path = "/getWinPlanByType", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getWinPlanByType() {
        String lotteryTypes = request.getParameter("lotteryTypes");
        return lotteryApi.getWinPlanByType(lotteryTypes);
    }

    /**
     * 手动开奖
     *
     * @return
     */
    @RequestMapping(path = "/openResult", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> openResult() {
        String lotteryTypes = request.getParameter("lotteryTypes");
        return lotteryApi.openResult(lotteryTypes);
    }

    /**
     * 修改方案状态为成功
     *
     * @return
     */
    @RequestMapping(path = "/updatePlanStatus", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updatePlanStatus() {
        Integer planNo = getInt("planNo");
        return lotteryApi.updatePlanStatus(planNo);
    }

    /**
     * 退单
     *
     * @return
     */
    @RequestMapping(path = "/planBack", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> planBack() {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer planNo = getInt("planNo");
        return lotteryApi.planBack(planNo);
    }

    /**
     * 查询方案
     *
     * @return
     */
    @RequestMapping(path = "/selectLotteryPlan", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> selectLotteryPlan() {
        Map<String, Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String dlAccount = request.getParameter("dlAccount");
        String qdAccount = request.getParameter("qdAccount");
        Integer planNo = getInt("planNo");
        Integer planStatus = getInt("planStatus");
        Integer winStatus = getInt("winStatus");
        Integer startAmount = getInt("startAmount");
        Integer endAmount = getInt("endAmount");
        Integer playType = getInt("playType");
        Double startReturnAmount = getDouble("startReturnAmount");
        Double endReturnAmount = getDouble("endReturnAmount");
        Double minBonus = getDouble("minBonus");
        Double maxBonus = getDouble("maxBonus");
        Integer page = getInt("page", 1);
        Integer pageSize = getInt("pageSize", 10);
        map.put("account", account);
        map.put("startTime", startTime);
        map.put("endTime", endTime);
        map.put("planNo", planNo);
        map.put("planStatus", planStatus);
        map.put("winStatus", winStatus);
        map.put("startAmount", startAmount);
        map.put("endAmount", endAmount);
        map.put("startReturnAmount", startReturnAmount);
        map.put("endReturnAmount", endReturnAmount);
        map.put("playType", playType);
        map.put("page", page);
        map.put("pageSize", pageSize);
        map.put("minBonus", minBonus);
        map.put("maxBonus", maxBonus);
        map.put("dlAccount", dlAccount);
        map.put("qdAccount", qdAccount);
        return lotteryApi.selectLotteryPlan(map);
    }

    /**
     * 修改限售列表状态
     *
     * @return
     */
    @RequestMapping(path = "/updateLotteryLimitStatus", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updateLotteryLimitStatus() {
        Integer id = getInt("id");
        Integer status = getInt("status");
        return lotteryApi.updateLotteryLimitStatus(id, status);
    }

    /**
     * 组合限售列表
     *
     * @return
     */
    @RequestMapping(path = "/getLotteryLimit", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getLotteryLimit() {
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        return lotteryApi.getLotteryLimit(page, pageSize);
    }

    /**
     * 增加组合限售
     *
     * @return
     */
    @RequestMapping(path = "/addLotteryLimit", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> addLotteryLimit() {
        String content = request.getParameter("content").replace(" ", "+").replace("他", "它");
        Integer lotteryType = getInt("lotteryType");
        String passType = request.getParameter("passType");
        return lotteryApi.addLotteryLimit(content, lotteryType, passType);
    }

    /**
     * 修改发单宣言
     *
     * @return
     */
    @RequestMapping(path = "/updatePlanDesc", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updatePlanDesc() {
        Integer planNo = getInt("planNo");
        String desc = request.getParameter("desc");
        return lotteryApi.updatePlanDesc(planNo, desc);
    }

    /**
     * 设置自动抄单状态
     *
     * @return
     */
    @RequestMapping(path = "/setAutoCopyPlanStatus", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> setAutoCopyPlanStatus() {
        int type = getInt("type", 1);//1小与5分钟 2大于5分钟
        int status = getInt("status", 0);
        return lotteryApi.setAutoCopyPlanStatus(type, status);
    }

    /**
     * 获取自动抄单状态
     *
     * @return
     */
    @RequestMapping(path = "/getAutoCopyPlanStatus", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAutoCopyPlanStatus() {
        int type = getInt("type", 1); //1小与5分钟 2大于5分钟
        return lotteryApi.getAutoCopyPlanStatus(type);
    }

    /**
     * 支付未支付方案
     *
     * @return
     */
    @RequestMapping(path = "/dgForNoPay", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> dgForNoPay() {
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        Double amount = getDouble("amount");
        Integer planNo = getInt("planNo");
        Integer cardId = getInt("cardId", 0);//彩金卡id 没有彩金卡传0
        double cardMoney = getDouble("cardMoney", 0);
        return lotteryApi.dgForNoPay(member2DTO, amount, planNo, cardId, cardMoney);
    }

    /**
     * 获取未支付方案
     *
     * @return
     */
    @RequestMapping(path = "/getPlanByNoPay", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getPlanByNoPay() {
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        return lotteryApi.getPlanByNoPay(member2DTO.getAccount(), page, pageSize);
    }

    /**
     * 定时开关代购
     *
     * @return
     */
    @RequestMapping(path = "/updateDGByStatus", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updateDGByStatus() {
        Map<String, Object> map = new HashMap<String, Object>();
        String timeStr = request.getParameter("time");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date time;
        try {
            time = sdf.parse(timeStr);
            if (time.before(new Date())) {
                map.put(Constants.CODE, Constants.ERROR_CODE_430);
                map.put(Constants.MSG, Constants.ERROR_MSG_430);
                return map;
            }
        } catch (ParseException e) {
            map.put(Constants.CODE, Constants.ERROR_CODE_429);
            map.put(Constants.MSG, Constants.ERROR_MSG_429);
            return map;
        }
        int status = getInt("status", 1);
        return lotteryApi.updateDGByStatus(time, status);
    }

    /**
     * 每天早上9点恢复代购
     */
    @Scheduled(cron = "0 0 9 * * ?")
    public void openDG() {
        lotteryApi.openDG(1);
    }

    /**
     * 获取直接出票会员
     *
     * @return
     */
    @RequestMapping(path = "/getMemberTicket", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getMemberTicket() {
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        return lotteryApi.getMemberTicket(page, pageSize);
    }

    /**
     * 设置会员出票
     *
     * @return
     */
    @RequestMapping(path = "/setMemberTicket", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> setMemberTicket() {
        String account = request.getParameter("account");
        int status = getInt("status");
        return lotteryApi.setMemberTicket(account, status);
    }

    /**
     * 是否是加奖方案
     *
     * @return
     */
    @RequestMapping(value = "/getIsFocusPlan", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getIsFocusPlan() {
        Integer planNo = getInt("planNo");
        return lotteryApi.getIsFocusPlan(planNo);
    }

    /**
     * 抄单
     *
     * @return
     */
    @RequestMapping(value = "/copyPlan", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> copyPlan() {
        Integer planNo = getInt("planNo");
        return lotteryApi.copyPlan(planNo);
    }

    /**
     * 修改加奖设置
     *
     * @return
     */
    @RequestMapping(value = "/updateAddPirzeConfig", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updateAddPirzeConfig(int[] playTypes) {
        Integer lotteryType = getInt("lotteryType");
        String rate = request.getParameter("rate");
        String minAmount = request.getParameter("minAmount");
        return lotteryApi.updateAddPirzeConfig(lotteryType, Double.parseDouble(rate), Double.parseDouble(minAmount), playTypes);
    }

    /**
     * 获取加奖设置列表
     *
     * @return
     */
    @RequestMapping(value = "/getAddPirzeConfigList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAddPirzeConfigList() {
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        return lotteryApi.getAddPirzeConfigList(page, pageSize);
    }

    /**
     * 修改当前每日最大加奖
     *
     * @return
     */
    @RequestMapping(value = "/updateMaxAddPrize", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updateMaxAddPrize() {
        String maxAddPrize = request.getParameter("maxAddPrize");
        return lotteryApi.updateMaxAddPrize(Double.parseDouble(maxAddPrize));
    }

    /**
     * 获取当前每日最大加奖
     *
     * @return
     */
    @RequestMapping(value = "/getMaxAddPrize", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getMaxAddPrize() {
        return lotteryApi.getMaxAddPrize();
    }

    /**
     * 修改赛事截止时间
     *
     * @return
     */
    @RequestMapping(value = "/updateMatchDealTime", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updateMatchDealTime() {
        Integer dealTime = getInt("dealTime");
        return lotteryApi.updateMatchDealTime(dealTime);
    }

    /**
     * 获取赛事截止时间
     *
     * @return
     */
    @RequestMapping(value = "/getMatchDealTime", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getMatchDealTime() {
        return lotteryApi.getMatchDealTime();
    }

    /**
     * 获取加奖黑名单列表
     *
     * @return
     */
    @RequestMapping(value = "/getAddPrizeBlack", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAddPrizeBlack() {
        String account = request.getParameter("account");
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        return lotteryApi.getAddPrizeBlack(account, page, pageSize);
    }

    /**
     * 设置加奖黑白名单
     *
     * @return
     */
    @RequestMapping(value = "/setAddPrizeBlackOrWhite", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> setAddPrizeBlackOrWhite(Integer[] ids) {
        Integer type = getInt("type"); //1代理黑名单 2代理及会员黑名单  3代理白名单 4代理及会员白名单
        return lotteryApi.setAddPrizeBlackOrWhite(ids, type);
    }

    /**
     * 设置加奖
     *
     * @return
     */
    @RequestMapping(value = "/setAddPrize", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> setAddPrize(Integer[] playTypes) {
        Integer lotteryType = getInt("lotteryType");
        String rate = request.getParameter("rate");
        String minAmount = request.getParameter("minAmount");
        return lotteryApi.setAddPrize(lotteryType, Double.parseDouble(rate), Double.parseDouble(minAmount), playTypes);
    }

    /**
     * 取消篮球焦点赛事
     *
     * @return
     */
    @RequestMapping(value = "/updateBbFocusMatchStatus", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updateBbFocusMatchStatus() {
        Integer id = getInt("id");
        return lotteryApi.updateBbFocusMatchStatus(id);
    }

    /**
     * 取消足球焦点赛事
     *
     * @return
     */
    @RequestMapping(value = "/updateFbFocusMatchStatus", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updateFbFocusMatchStatus() {
        Integer id = getInt("id");
        return lotteryApi.updateFbFocusMatchStatus(id);
    }

    /**
     * 设置足球焦点赛事
     *
     * @return
     */
    @RequestMapping(value = "/setFbFocusMatch", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> setFbFocusMatch(Integer[] ids) {
        return lotteryApi.setFbFocusMatch(ids);
    }

    /**
     * 设置篮球焦点赛事
     *
     * @return
     */
    @RequestMapping(value = "/setBbFocusMatch", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> setBbFocusMatch(Integer[] ids) {
        return lotteryApi.setBbFocusMatch(ids);
    }

    /**
     * 出票详情
     *
     * @return
     */
    @RequestMapping(value = "/getTicketDetail", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getTicketDetail() {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer planNo = getInt("planNo");
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        return lotteryApi.getTicketDetail(planNo, member2DTO);
    }

    /**
     * 代购
     *
     * @return
     */
    @RequestMapping(value = "/dg", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> dg(String[] passType) {
        Map<String, Object> map = new HashMap<String, Object>();
        String matchItemsStr = request.getParameter("matchItemsStr");
        List<BasketBallMatchItem> matchItems = JSONArray.parseArray(matchItemsStr, BasketBallMatchItem.class);
        String ftmatchItemsStr = request.getParameter("ftmatchItemsStr");
        List<FootBallMatchItem> ftmatchItems = JSONArray.parseArray(ftmatchItemsStr, FootBallMatchItem.class);
        int publicStatus = getInt("publicStatus", 3); //是否公开 默认截止公开
        Integer amount = getInt("amount"); //金额
        Integer multiple = getInt("multiple"); //倍数
        Integer lotteryType = getInt("lotteryType"); //彩种
        Integer betCount = getInt("betCount");//注数
        String passMode = request.getParameter("passMode"); //过关方式
        Integer tradeType = getInt("tradeType"); //购买方式
//        Integer dealTime = getInt("dealTime"); //截止时间
        String isOnlyPlay = request.getParameter("isOnlyPlay"); //混投单一玩法
        String isDs = request.getParameter("isDs");
        String maxSp = request.getParameter("maxSp");
        Integer isFocus = getInt("isFocus", 0);
        //获得彩金卡信息
        Integer cardId = getInt("card_id", 0);//彩金卡id 没有彩金卡传0
        String card_money = request.getParameter("card_money");
        String planDesc = request.getParameter("planDesc");
        Double minBonus = getDouble("minBonus",0);
        Double maxBonus = getDouble("maxBonus",0);
        if (amount <= 0) {
            map.put(Constants.CODE, Constants.ERROR_CODE_437);
            map.put(Constants.MSG, Constants.ERROR_MSG_437);
            return map;
        }
        BigDecimal cardMoney;
        if (StringUtils.isNullOrBlank(planDesc)) {
            planDesc = "理性跟单，必红!";
        }
        if (StringUtils.isNullOrBlank(card_money)) {
            cardMoney = BigDecimal.valueOf(0);
        } else {
            cardMoney = new BigDecimal(request.getParameter("card_money"));//彩金卡金额 没有彩金卡传0
        }
        if (amount > 200000) {
            map.put(Constants.CODE, Constants.ERROR_CODE_431);
            map.put(Constants.MSG, Constants.ERROR_MSG_431);
            return map;
        }
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        if (member2DTO.getIsWhitelist() != 0) {
            map.put(Constants.CODE, Constants.ERROR_CODE_415);
            map.put(Constants.MSG, Constants.ERROR_MSG_415);
            return map;
        }
        if (StringUtils.isNullOrBlank(member2DTO.getCertNo())) {
            map.put(Constants.CODE, Constants.ERROR_CODE_419);
            map.put(Constants.MSG, Constants.ERROR_MSG_419);
            return map;
        }

        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("passType", passType);
        reqMap.put("matchItems", matchItems);
        reqMap.put("ftmatchItems", ftmatchItems);
        reqMap.put("publicStatus", publicStatus);
//        reqMap.put("term",term);
        reqMap.put("amount", amount);
        reqMap.put("multiple", multiple);
        reqMap.put("lotteryType", lotteryType);
        reqMap.put("betCount", betCount);
        reqMap.put("passMode", passMode);
        reqMap.put("tradeType", tradeType);
        reqMap.put("isOnlyPlay", isOnlyPlay);
        reqMap.put("isDs", isDs);
        reqMap.put("isFocus", isFocus);
//        reqMap.put("dealTime",dealTime);
        reqMap.put("member2DTO", member2DTO);
        reqMap.put("maxSp", Double.parseDouble(maxSp));
        reqMap.put("cardId", cardId);
        reqMap.put("cardMoney", cardMoney);
        reqMap.put("planDesc", planDesc);
        reqMap.put("minBonus", minBonus);
        reqMap.put("maxBonus", maxBonus);
        return lotteryApi.dg(reqMap);
    }

    /**
     * 篮球混投数据
     *
     * @return
     */
    @RequestMapping(value = "/getBasketBallMatch", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getBasketBallMatch() {
        int type = getInt("type", 1);  //类型  1前台  2后台
        if (type == 1) {
            Member2DTO member2DTO = checkLogin();
            if (member2DTO == null) {
                Map map = new HashMap();
                map.put(Constants.CODE, "400");
                map.put(Constants.MSG, "请先登录");
                return map;
            }
        }
        int isFocus = getInt("isFocus", 0);
        Jedis jedis = RedisUtil.getJedis();
        String s = jedis.get(isFocus == 0 ? Constants.BASKETBALL_MATCH : Constants.BASKETBALL_MATCH_FOCUS);
        jedis.close();
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isNullOrBlank(s)) {
            //redis里为空
            List<BasketBallMatchDTO> maps = lotteryApi.getBasketBallMatch(isFocus);
            map.put(Constants.DATA, maps);
            Jedis jedis2 = RedisUtil.getJedis();
            net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(maps);
            jedis2.set(isFocus == 0 ? Constants.BASKETBALL_MATCH : Constants.BASKETBALL_MATCH_FOCUS, jsonArray.toString());
            jedis2.close();
        } else {
            map.put(Constants.DATA, JSONArray.parse(s));
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }


    /**
     * 自动跟单
     *
     * @return
     */
    @RequestMapping(value = "/autoCopyPlan", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> autoCopyPlan() {
        Integer planNo = getInt("planNo");
        Integer time = getInt("time", 0);
        Integer count = getInt("count");

        return lotteryApi.autoCopyPlan(planNo, time, count);
    }

    /**
     * 新星榜
     *
     * @return
     */
    @RequestMapping(value = "/getNewStar", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getNewStar() {
        int dan = getInt("dan", 5);
        return lotteryApi.getNewStar(dan);
    }

    /**
     * 添加新星榜
     *
     * @return
     */
    @RequestMapping(value = "/addNewStar", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> addNewStar(String[] accounts) {
        return lotteryApi.addNewStar(accounts);
    }

    /**
     * 一炮而红榜
     *
     * @return
     */
    @RequestMapping(value = "/getAShortRed", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAShortRed() {
        Map<String, Object> map = new HashMap<String, Object>();
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        int day = getInt("day", 7);
        return lotteryApi.getAShortRed(page, pageSize, day);
    }

    /**
     * 七天投注榜
     *
     * @return
     */
    @RequestMapping(value = "/getBetList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getBetList() {
        Map<String, Object> map = new HashMap<String, Object>();
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        int day = getInt("day", 7);
        return lotteryApi.getBetList(page, pageSize, day);
    }

    /**
     * 连红榜
     *
     * @return
     */
    @RequestMapping(value = "/getEvenTheRedList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEvenTheRedList() {
        Jedis jedis = RedisUtil.getJedis();
        String s = jedis.get(Constants.EVEN_RED);
        jedis.close();
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isNullOrBlank(s)) {
            //redis里为空
            List<EvenTheRedMemberDTO> list = lotteryApi.getEvenTheRedList(1, 20, 7);
            map.put(Constants.DATA, list);
            Jedis jedis2 = RedisUtil.getJedis();
            net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(list);
            jedis2.set(Constants.EVEN_RED, jsonArray.toString());
            jedis2.close();
        } else {
            map.put(Constants.DATA, JSONArray.parse(s));
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 最受欢迎榜
     *
     * @return
     */
    @RequestMapping(value = "/getMostPopular", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getMostPopular() {
        Map<String, Object> map = new HashMap<String, Object>();
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        return lotteryApi.getMostPopular(page, pageSize);
    }

    /**
     * 查询中奖宣传
     *
     * @return
     */
    @RequestMapping(value = "/getWinPromotion", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getWinPromotion() {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer status = getInt("status");
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        map = lotteryApi.getWinPromotion(status, page, pageSize);
        return map;
    }

    /**
     * 修改中奖宣传状态
     *
     * @return
     */
    @RequestMapping(value = "/updateWinPromotionStatus", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updateWinPromotionStatus() {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer id = getInt("id");
        Integer status = getInt("status");
        WinPromotion2 winPromotion2 = new WinPromotion2();
        winPromotion2.setStatus(status);
        winPromotion2.setId(id);
        map = lotteryApi.updateWinPromotionStatus(winPromotion2);
        return map;
    }

    /**
     * 发起中奖宣传
     *
     * @return
     */
    @RequestMapping(value = "/addWinPromotion", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> addWinPromotion() {
        Map<String, Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        map = lotteryApi.addWinPromotion(account, title, content);
        return map;
    }

    /**
     * 晒单广场战绩一栏
     *
     * @return
     */
    @RequestMapping(value = "/xyHall", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> xyHall() {
        Jedis jedis = RedisUtil.getJedis();
        String s = jedis.get(Constants.XYHALL);
        jedis.close();
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isNullOrBlank(s)) {
            //redis里为空
            List<Member2ForSumprize> list = lotteryApi.xyHall(1, 20, 7);
            map.put(Constants.DATA, list);
            Jedis jedis2 = RedisUtil.getJedis();
            net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(list);
            jedis2.set(Constants.XYHALL, jsonArray.toString());
            jedis2.close();
        } else {
            map.put(Constants.DATA, JSONArray.parse(s));
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 查询晒单
     *
     * @return
     */
    @RequestMapping(value = "/getPlanShow2", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getPlanShow2() {
        Map<String, Object> map = new HashMap<String, Object>();
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        Member2DTO member2DTO = checkLogin();
        String account = null;
        if (member2DTO != null) {
            account = member2DTO.getAccount();
        }
        map = lotteryApi.getPlanShow2(page, pageSize, account);
        return map;
    }

    /**
     * 后台查询晒单
     *
     * @return
     */
    @RequestMapping(value = "/getPlanShow", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getPlanShow() {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer planNo = getInt("planNo");
        Integer type = getInt("type");
        Integer status = getInt("status");
        Integer page = getInt("page", 1);
        Integer pageSize = getInt("pageSize", 10);
        String account = request.getParameter("account");

        map = lotteryApi.getPlanShow(account, planNo, type, status, page, pageSize);
        return map;
    }

    /**
     * 修改晒单状态
     *
     * @return
     */
    @RequestMapping(value = "/updatePlanShowStatus", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updatePlanShowStatus() {
        Map<String, Object> map = new HashMap<String, Object>();
        int id = getInt("id");
        int status = getInt("status");

        map = lotteryApi.updatePlanShowStatus(id, status);
        return map;
    }

    /**
     * 通过/驳回晒单申请
     *
     * @return
     */
    @RequestMapping(value = "/passShowPlanApply", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> passShowPlanApply() {
        Map<String, Object> map = new HashMap<String, Object>();
        int id = getInt("id");
        int type = getInt("type");

        map = lotteryApi.passShowPlanApply(id, type);
        return map;
    }

    /**
     * 晒单
     *
     * @return
     */
    @RequestMapping(value = "/showPlan", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> showPlan() {
        Result result = new Result();
        int planNo = getInt("planNo");
        String title = request.getParameter("title");
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_401);
            map.put(Constants.MSG, Constants.ERROR_MSG_401);
            return map;
        }
        map = lotteryApi.showPlan(planNo, title, member2DTO);
        return map;
    }

    /**
     * 方案比赛详情
     *
     * @return
     */
    @RequestMapping(value = "/getPlanMatchDetail", method = RequestMethod.GET)
    @ResponseBody
    public Result getPlanMatchDetail() {
        Result result = new Result();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        }
        int planNo = getInt("planNo");
        result = lotteryApi.getPlanMatchDetail(planNo, member2DTO.getAccount());
        return result;
    }

    /**
     * 他的主页
     *
     * @return
     */
    @RequestMapping(value = "/hisIndex", method = RequestMethod.GET)
    @ResponseBody
    public Result hisIndex() {
        Result result = new Result();
        String account = request.getParameter("account");
        result = lotteryApi.hisIndex(account);
        return result;
    }

    /**
     * 跟单列表
     *
     * @return
     */
    @RequestMapping(value = "/getCopyPlanList", method = RequestMethod.GET)
    @ResponseBody
    public Result getCopyPlanList() {
        Result result = new Result();
        Integer planNo = getInt("planNo", 0);
        if (planNo == null || planNo == 0) {
            result.setSuccess(false);
            result.setMsg("非法参数");
            return result;
        }
        result = lotteryApi.getCopyPlanList(planNo);
        return result;
    }

    /**
     * 方案详情页
     *
     * @return
     */
    @RequestMapping(value = "/getPlanDetail", method = RequestMethod.GET)
    @ResponseBody
    public Result getPlanDetail() {
        Result result = new Result();
        Integer planNo = getInt("planNo");
        if (planNo == null || planNo == 0) {
            result.setSuccess(false);
            result.setMsg("非法参数");
            return result;
        }
        System.out.println("getPlanDetail planNo:" + planNo);
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        }
        result = lotteryApi.getPlanDetail(planNo, member2DTO);
        return result;
    }

    /**
     * 中奖金额
     *
     * @return
     */
    @RequestMapping(value = "/getZJAmount", method = RequestMethod.GET)
    @ResponseBody
    public Result getZJAmount() {
        Result result = new Result();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        }
        int planType = getInt("planType", -1);
        int lotteryType = getInt("lotteryType", -1);
        int planStatus = getInt("planStatus", -1);
        int winStatus = getInt("winStatus", -1);
        result = lotteryApi.getZJAmount(planType, lotteryType, planStatus, winStatus, member2DTO);
        return result;
    }

    /**
     * 投入金额
     *
     * @return
     */
    @RequestMapping(value = "/getTRAmount", method = RequestMethod.GET)
    @ResponseBody
    public Result getTRAmount() {
        Result result = new Result();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        }
        int planType = getInt("planType", -1);
        int lotteryType = getInt("lotteryType", -1);
        int planStatus = getInt("planStatus", -1);
        int winStatus = getInt("winStatus", -1);
        result = lotteryApi.getTRAmount(planType, lotteryType, planStatus, winStatus, member2DTO);
        return result;
    }

    /**
     * 购彩记录
     *
     * @return
     */
    @RequestMapping(value = "/getPlanForUserCenter", method = RequestMethod.GET)
    @ResponseBody
    public Result getPlanForUserCenter() {
        Result result = new Result();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        }
        int planType = getInt("planType", -1);
        int lotteryType = getInt("lotteryType", -1);
        int planStatus = getInt("planStatus", -1);
        int winStatus = getInt("winStatus", -1);
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 15);
        result = lotteryApi.getPlanForUserCenter(planType, lotteryType, planStatus, winStatus, page, pageSize, member2DTO);
        return result;
    }

    /**
     * 查询发单人
     *
     * @return
     */
    @RequestMapping(value = "/querySuperLotteryPlan", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> querySuperLotteryPlan() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        long time = new Date().getTime();
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_401);
            map.put(Constants.MSG, Constants.ERROR_MSG_401);
            return map;
        }
        String username = request.getParameter("username");
        String type = request.getParameter("type");
        int sortType = getInt("sortType", 1); //排序方式  1金额   2跟单人
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        int isFocus = getInt("isFocus", 0);//0 非关注大神 1,查询关注大神的订单
        map = lotteryApi.querySuperLotteryPlan(page, pageSize, type, username, member2DTO, sortType, isFocus);
        System.out.println((new Date().getTime() - time) / 1000d);
        return map;
    }

    /**
     * 复制跟单
     *
     * @return
     */
    @RequestMapping(value = "/copyLotteryPlan", method = RequestMethod.POST)
    @ResponseBody
    public Result copyLotteryPlan() {
        Result result = new Result();

        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        }
        if (member2DTO.getIsWhitelist() == 1) {
            result.setSuccess(false);
            result.setMsg("非白名单用户不能跟单！");
            return result;
        }
        if (member2DTO.getStatus() != 0) {
            result.setSuccess(false);
            result.setMsg("该账号已被锁定！");
            return result;
        }
        if (StringUtils.isNullOrBlank(member2DTO.getCertNo())) {
            result.setSuccess(false);
            result.setMsg("请先实名认证！");
            return result;
        }
        Integer planNo = getInt("planNo");
        Integer multiple = getInt("multiple");
        Integer amount = getInt("amount");
        if (amount > 200000) {
            result.setSuccess(false);
            result.setMsg("请理性投注!");
            return result;
        }
        if (amount <= 0) {
            result.setSuccess(false);
            result.setMsg("金额错误!");
            return result;
        }
        Integer cardId = getInt("card_id", 0);
        String card_money = request.getParameter("card_Money");
        Double cardMoney;
        if (StringUtils.isNullOrBlank(card_money)) {
            cardMoney = Double.valueOf(0);
        } else {
            cardMoney = new Double(card_money);//彩金卡金额 没有彩金卡传0
        }
        result = lotteryApi.copyLotteryPlan(member2DTO.getAccount(), planNo, multiple, amount, cardId, cardMoney);
        return result;
    }

    /**
     * 竞彩足球首页混合数据
     */
    @RequestMapping(value = "/findFootballMixureInfo", method = RequestMethod.GET)
    @ResponseBody
    public Map findFootballMixureInfo() {
        int type = getInt("type", 1);  //类型  1前台  2后台
        if (type == 1) {
            Member2DTO member2DTO = checkLogin();
            if (member2DTO == null) {
                Map map = new HashMap();
                map.put(Constants.CODE, "400");
                map.put(Constants.MSG, "请先登录");
                return map;
            }
        }
        int isFocus = getInt("isFocus", 0);
        Jedis jedis = RedisUtil.getJedis();
        String s = jedis.get(isFocus == 0 ? Constants.FOOTBALL_MATCH : Constants.FOOTBALL_MATCH_FOCUS);
        jedis.close();
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isNullOrBlank(s)) {
            //redis里为空
            List<Map<String, Object>> maps = lotteryApi.findFootballMixureInfo(isFocus);
            map.put(Constants.DATA, maps);
            Jedis jedis2 = RedisUtil.getJedis();
            net.sf.json.JSONArray jsonArray = net.sf.json.JSONArray.fromObject(maps);
            jedis2.set(isFocus == 0 ? Constants.FOOTBALL_MATCH : Constants.FOOTBALL_MATCH_FOCUS, jsonArray.toString());
            jedis2.close();
        } else {
            map.put(Constants.DATA, JSONArray.parse(s));
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 竞彩足球更多混合数据
     */
    @RequestMapping(value = "/findFootballMixureMoreInfo", method = RequestMethod.GET)
    @ResponseBody
    public Map findFootballMixureMoreInfo(@RequestParam String token, @RequestParam String matchId) {
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            Map map = new HashMap();
            map.put(Constants.CODE, "400");
            map.put(Constants.MSG, "请先登录");
            return map;
        }
        Map<String, Object> map = lotteryApi.findFootballMixureMoreInfo(matchId);

        return map;
    }

    @RequestMapping(value = "/updateFootBallMatch", method = RequestMethod.GET)
    @ResponseBody
    public Map updateFootBallMatch() {
        Map<String, Object> map = new HashMap<String, Object>();
        lotteryApi.updateFootBallMatch();
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    @RequestMapping(value = "/updateBasketBallMatch", method = RequestMethod.GET)
    @ResponseBody
    public Map updateBasketBallMatch() {
        Map<String, Object> map = new HashMap<String, Object>();
        lotteryApi.updateBasketBallMatch();
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 奖金优化
     * passType:[P2_1,P3_1,P4_1]
     * ftmatchItems:[{"intTime":"20180801","lineId":26,"shedan":"false","home":"蒙特雷","guest":"普埃布拉","rqs":"-1","options":[{"value":1,"award":"3.2","type":"34","rqs":-1}]},
     * {"intTime":"20180801","lineId":27,"shedan":"false","home":"托卢卡","guest":"华雷斯","rqs":"-1","options":[{"value":1,"award":"3.3","type":"34","rqs":-1}]},
     * {"intTime":"20180802","lineId":1,"shedan":"false","home":"索尔纳","guest":"北西兰","rqs":"-1","options":[{"value":1,"award":"3.4","type":"41","rqs":0}]},
     * {"intTime":"20180802","lineId":3,"shedan":"false","home":"阿尔克马","guest":"阿拉木图","rqs":"-1","options":[{"value":1,"award":"3.45","type":"34","rqs":-1}]}
     * ]
     */
    @RequestMapping(value="/JcAwardOptimize",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public   List<Map<String,Object>> jcToAwardOptimize(@RequestParam String passType, @RequestParam String ftmatchItems,
                                    @RequestParam String passMode, /*@RequestParam boolean isDs,*/ @RequestParam Integer betCount, @RequestParam Integer multiple, @RequestParam Integer amount
            , @RequestParam Integer publicStatus, @RequestParam Integer lotType, @RequestParam boolean isOnlyPlay/*, @RequestParam boolean isGroup*/) throws IOException {
        LotteryPlan lotteryPlan = new LotteryPlan();
        try {
        SportteryAwardOptimizeModel<MatchItemAwardOptimize> bc = new FootBallAwardOptimizeContent();
        List<MatchItemAwardOptimize> ftmatchItemsList = com.alibaba.fastjson.JSONObject.parseObject(ftmatchItems ,List.class);
        bc.setMatchItems(ftmatchItemsList);
        bc.setIsOnlyPlay("true".equals(isOnlyPlay) ? true : false);
        bc.setPassMode(PassMode.valueOf(passMode).ordinal());
        List<SportteryPassType> tempPt = new ArrayList<SportteryPassType>();
        List<String> passTypeList = Arrays.asList(passType.split(","));
        for (String p : passTypeList) {// 转化
            if (p != null && !"".equals(p)) {
                SportteryPassType temp = SportteryPassType.valueOf(p);
                tempPt.add(temp);
            }
        }

        bc.setPassTypes(tempPt);
        bc.setMultiple(multiple);
        JSONObject jsonObject = JSONObject.fromObject(bc);
        String content = jsonObject.toString();
        lotteryPlan.setLotteryType(LotteryType.getItem(lotType));
        lotteryPlan.setContent(content);
        // 调用拆票

            List<SportteryTicketVO> baseList = MathUtils.combinResultToVO(lotteryPlan.getLotteryType(), false, content, null, SportteryBetContentModel.class,
                    MatchItemAwardOptimize.class,null);
            Collections.sort(baseList, new Comparator<SportteryTicketVO>() {
                public int compare(SportteryTicketVO o1, SportteryTicketVO o2) {
                    if (o1.getTotalPrice() > o2.getTotalPrice()) {
                        return 1;
                    } else if (o1.getTotalPrice() < o2.getTotalPrice()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
            List<Map<String,Object>> mapList =new ArrayList<Map<String, Object>>();
            for (SportteryTicketVO st:baseList
                 ) {
                Map<String,Object> map  = new HashMap<String, Object>();
                map.put("amount",st.getAmount());
                map.put("betCount",st.getBetCount());
                map.put("isBingo",st.getIsBingo());
                map.put("isOpenPrize",st.getIsOpenPrize());
                map.put("matchItemList",st.getMatchItemList());
                map.put("passType",st.getPassType());
                map.put("singlePrice",st.getSinglePrice());
                map.put("totalPrice",st.getTotalPrice());
                map.put("voKeys",st.getVoKeys());
                mapList.add(map);
                System.out.println(st.getMatchItemList().toString());
            }

            amount = baseList.size() * 2 * multiple;
            return mapList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
    @RequestMapping(value = "/buy" ,method = RequestMethod.POST)
    @ResponseBody
    public Map buy(@RequestBody List<MatchModelInfo> matchModelInfos){
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String,Object> resMap = new HashMap<String, Object>();
        try {


        Jedis jedis = RedisUtil.getJedis();
        String token = matchModelInfos.get(0).getToken();
        System.out.println(token);
        if (StringUtils.isNullOrBlank(token)){
            return null;
        }
        String json = jedis.get(token);
        if (StringUtils.isNullOrBlank(json)){
            return null;
        }
        jedis.setex(token,604800,json);
        jedis.close();
        Member2DTO member2DTO = JSON.parseObject(json,Member2DTO.class);
        //查找客户钱包
            MemberWallet2DTO wallet2DTO = lotteryApi.getMemberWallet(member2DTO);
        if (member2DTO == null) {
            resMap.put(Constants.CODE, Constants.ERROR_CODE_2);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return resMap;
        }
        if (member2DTO.getIsWhitelist() != 0) {
            resMap.put(Constants.CODE, Constants.ERROR_CODE_415);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_415);
            return resMap;
        }
        if (StringUtils.isNullOrBlank(member2DTO.getCertNo())) {
            resMap.put(Constants.CODE, Constants.ERROR_CODE_419);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_419);
            return resMap;
        }
            Double ableBalance = wallet2DTO.getAbleBalance();
            Double lotteryMoner =0.0;
            for (MatchModelInfo matchModelInfo:matchModelInfos
                 ) {
                lotteryMoner +=matchModelInfo.getAmount();
                String matchItemsStr = matchModelInfo.getMatchItemsStr();
                List<BasketBallMatchItem> matchItems = JSONArray.parseArray(matchItemsStr, BasketBallMatchItem.class);
                String ftmatchItemsStr = matchModelInfo.getFtmatchItemsStr();
                List<FootBallMatchItem> ftmatchItems = JSONArray.parseArray(ftmatchItemsStr, FootBallMatchItem.class);
                Integer term  =   lotteryApi.getLotteryTerm(matchModelInfo.getLotteryType());
                SportteryBetContentModel bc = null;
                if (LotteryType.JCLQList.contains(LotteryType.getItem(matchModelInfo.getLotteryType()))){
                    bc = new BasketBallBetContent();
                    bc.setMatchItems(matchItems);
                }else if(LotteryType.JCZQList.contains(LotteryType.getItem(matchModelInfo.getLotteryType()))) {
                    bc = new FootBallBetContent();
                    bc.setMatchItems(ftmatchItems);
                }
                bc.setIsOnlyPlay("true".equals(matchModelInfo.getIsOnlyPlay())?true:false);
                bc.setPassMode(com.qiyun.model.PassMode.valueOf(matchModelInfo.getPassMode()).ordinal());

                List<SportteryPassType> tempPt = new ArrayList<SportteryPassType>();
                for (String p : matchModelInfo.getPassType().split(",")) {// 转化
                    if (p != null && !"".equals(p)) {
                        SportteryPassType temp = SportteryPassType.valueOf(p);
                        tempPt.add(temp);
                    }
                }
                bc.setPassTypes(tempPt);
                bc.setMultiple(matchModelInfo.getMultiple());
                Map<String, Object> map1 = lotteryApi.checkMatch(matchModelInfo.getLotteryType(), matchModelInfo.getPassType().split(","), matchItems, ftmatchItems, bc, matchModelInfo.getBetCount());
                    if (Integer.parseInt(map1.get("error_code")+"")!=200){
                        return map1;
                    }
            }
            //判断可用余额
            if (ableBalance<lotteryMoner){
                resMap.put(Constants.CODE, Constants.ERROR_CODE_419);
                resMap.put(Constants.MSG, "可用余额不足");
                return resMap;
            }
            Map maps;
            for (MatchModelInfo matchModelInfo:matchModelInfos
             ) {
            String matchItemsStr = matchModelInfo.getMatchItemsStr();
            List<BasketBallMatchItem> matchItems = JSONArray.parseArray(matchItemsStr, BasketBallMatchItem.class);
            String ftmatchItemsStr = matchModelInfo.getFtmatchItemsStr();
            List<FootBallMatchItem> ftmatchItems = JSONArray.parseArray(ftmatchItemsStr, FootBallMatchItem.class);
            if (matchModelInfo.getAmount() <= 0) {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_437);
                resMap.put(Constants.MSG, Constants.ERROR_MSG_437);
                return map;
            }
            if (StringUtils.isNullOrBlank(matchModelInfo.getPlanDesc())) {
                matchModelInfo.setPlanDesc("理性跟单，必红!");
            }
            if (matchModelInfo.getAmount() > 200000) {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_431);
                resMap.put(Constants.MSG, Constants.ERROR_MSG_431);
                return map;
            }

            Map<String, Object> reqMap = new HashMap<String, Object>();
            reqMap.put("passType", matchModelInfo.getPassType().split(","));
            reqMap.put("matchItems", matchItems);
            reqMap.put("ftmatchItems", ftmatchItems);
            reqMap.put("publicStatus", matchModelInfo.getPublicStatus());
//        reqMap.put("term",term);
            reqMap.put("amount", matchModelInfo.getAmount());
            reqMap.put("multiple", matchModelInfo.getMultiple());
            reqMap.put("lotteryType", matchModelInfo.getLotteryType());
            reqMap.put("betCount", matchModelInfo.getBetCount());
            reqMap.put("passMode", matchModelInfo.getPassMode());
            reqMap.put("tradeType", matchModelInfo.getTradeType());
            reqMap.put("isOnlyPlay",matchModelInfo.getIsOnlyPlay());
            reqMap.put("isDs", matchModelInfo.getIsDs());
            reqMap.put("isFocus", matchModelInfo.getIsFocus());
//        reqMap.put("dealTime",dealTime);
            reqMap.put("member2DTO", member2DTO);
            reqMap.put("maxSp", Double.parseDouble(matchModelInfo.getMaxSp()));
            reqMap.put("cardId", 0);
            reqMap.put("cardMoney", 0);
            reqMap.put("planDesc", matchModelInfo.getPlanDesc());
            maps  =  lotteryApi.dg(reqMap);
                System.out.println(maps.toString());
        }
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, "方案生成成功");
        }catch (Exception ex){
            ex.printStackTrace();
            resMap.put(Constants.CODE,Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG,"方案生失败");
        }
        resMap.put(Constants.CODE,Constants.SUCCESS_CODE);
        resMap.put(Constants.MSG,Constants.SUCCESS_MSG);
      return resMap;
    }
   /* public String saveContextFile(String strContext) {
        String times = StringTools.randomString(18);

        // 根据当前时间创建文件名
        String newFileName = ServletActionContext.getServletContext().getRealPath(File.separator + "dsUpFile") + File.separator
                + DateTools.getNowDateYYMMDD() + File.separator + times + ".txt";

        // 创建文件
        File dirFile = new File(ServletActionContext.getServletContext().getRealPath(
                File.separator + "dsUpFile" + File.separator + DateTools.getNowDateYYMMDD()));
        if (!dirFile.exists()) {
            if (!dirFile.mkdir()) {
                logger.info("文件创建异常");
                return null;
            }
        }
        try {
            ByteArrayInputStream stream = new ByteArrayInputStream(strContext.getBytes());
            InputStream is=stream;
            FileTools.uploadFile(is, newFileName);
        } catch (Exception e) {
            LogUtil.error(e);
            logger.info("文件创建失败");
            return null;
        }
        return "/dsUpFile/" + DateTools.getNowDateYYMMDD() + "/" + times + ".txt";
    }*/

}
