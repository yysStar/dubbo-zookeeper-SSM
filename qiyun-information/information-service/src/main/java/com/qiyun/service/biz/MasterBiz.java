package com.qiyun.service.biz;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.api.MasterApi;
import com.qiyun.dto.*;
import com.qiyun.httpUtil.RedisUtil;
import com.qiyun.model2.*;
import com.qiyun.service.*;
import com.qiyun.tools.CLSmsSend;
import com.qiyun.type.TransType;
import com.qiyun.util.Constants;
import com.qiyun.util.DateUtil;
//import com.qiyun.util.TransType;
import com.qiyun.util.NumberTools;

import net.sf.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("masterApi")
public class MasterBiz implements MasterApi {

    @Autowired
    private MasterService masterService;
    @Autowired
    private SportteryMatchService sportteryMatchService;
    @Autowired
    private RecommendPlanService recommendPlanService;
    @Autowired
    private RecommendMatchMappingService recommendMatchMappingService;
    @Autowired
    private MemberMasterMappingService memberMasterMappingService;
    @Autowired
    private MemberTaskBeginService memberTaskBeginService;
    @Autowired
    private RewardService rewardService;
    @Autowired
    private RecommendBuyLineService recommendBuyLineService;
    @Autowired
    private MemberCloudsService memberCloudsService;
    @Autowired
    private MemberCloudsLineService memberCloudsLineService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberFollowMappingService memberFollowMappingService;

    private final String TEL_NUM = "4000807758";

    @Test
    public void test(){
        Calendar calendar = Calendar.getInstance();
        Date startDate = calendar.getTime();
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        String format = format2.format(startDate);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date h1 = calendar.getTime();
        String format1 = format2.format(h1);
        System.out.println(format);
        System.out.println(format1);

    }

    public Map<String, Object> getSgMatch(String date) {
        return masterService.getSgMatch(date);
    }

    /**
     * 获取今天及前俩天的日期
     *
     * @return
     */
    public Map<String, Object> getSgTime() {
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            List<String> arr = new ArrayList<String>();
            Calendar calendar = Calendar.getInstance();
            Date startDate = calendar.getTime();
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
            String format = format2.format(startDate);
            calendar.add(Calendar.DAY_OF_YEAR, -2);
            Date q2 = calendar.getTime();
            String fq2 = format2.format(q2);
            calendar.add(Calendar.DAY_OF_YEAR, -1);
            Date q1 = calendar.getTime();
            String fq1 = format2.format(q1);
            arr.add(fq2); arr.add(fq1); arr.add(format);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,arr);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取足球赛果日期出错");
            return map;
        }
    }

    public Map<String, Object> getScTime() {
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            List<String> arr = new ArrayList<String>();
            Calendar calendar = Calendar.getInstance();
            Date startDate = calendar.getTime();
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
            String format = format2.format(startDate);
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            Date h1 = calendar.getTime();
            String fh1 = format2.format(h1);
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            Date h2 = calendar.getTime();
            String fh2 = format2.format(h2);
            arr.add(format); arr.add(fh1); arr.add(fh2);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,arr);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取足球赛程日期出错");
            return map;
        }
    }

    /**
     * 获取打赏列表
     *
     * @param beRewarderId 被打赏人的账户
     * @return
     */
    public Map<String, Object> getRewarderList(String beRewarderId) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            List<MemberRewardMapping> rewarderList = rewardService.getRewarder(beRewarderId);
            //PageInfo<MemberRewardMapping> pageInfo = new PageInfo<MemberRewardMapping>(rewarderList);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA, rewarderList);
            map.put("count", rewarderList.size());
            return map;
        } catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(Constants.CODE, Constants.ERROR_CODE_609);
            map.put(Constants.MSG, "获取打赏列表出错");
            return map;
        }
    }

    /**
     * 打赏
     * @param cloud        打赏云朵数
     * @param beRewarderId 被打赏人的ID
     * @param RewarderId   打赏人的ID
     * @return
     */
    public Map<String, Object> Reward(int cloud, String beRewarderId, String RewarderId) {
        Map<String, Object> map = new HashMap<String, Object>();
        Integer reward = rewardService.Reward(cloud, beRewarderId, RewarderId);

        if (cloud <= 0) {//打赏金额不对
            map.put(Constants.CODE, Constants.ERROR_CODE_602);
            map.put(Constants.MSG, Constants.ERROR_MSG_602);
            return map;
        }
        if (reward == 1) {//打赏成功
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        }
        if (reward == -1) {//余额不足
            map.put(Constants.CODE, Constants.ERROR_CODE_601);
            map.put(Constants.MSG, Constants.ERROR_MSG_601);
            return map;
        }
        if (reward == -2) {//打赏未知错误
            map.put(Constants.CODE, Constants.ERROR_CODE_609);
            map.put(Constants.MSG, "打赏错误");
            return map;
        }
        return map;
    }

    /**
     * 申请名人
     * 返回一个电话号码
     */
    public Map<String, Object> applyForCelebrity() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA, TEL_NUM);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return map;
    }

    /**
     * 发起提现
     *
     * @return
     */
    public Map<String, Object> withdrawCash(String account, int clouds) {
        Map<String, Object> map = new HashMap<String, Object>();
        MemberClouds memberClouds = memberCloudsService.getByAccount(account);  //获取提现账户的用户云朵实体类
        if (memberClouds == null || memberClouds.getTakeCashQuota().intValue() == 0 ||
                memberClouds.getTakeCashQuota().intValue() < clouds) {
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_15);
            return map;
        }
        memberClouds.setCloudsAbleBalance(memberClouds.getCloudsAbleBalance() - clouds);
        memberClouds.setFreezeBalance(memberClouds.getFreezeBalance() + clouds);
        memberClouds.setTakeCashQuota((double) memberClouds.getTakeCashQuota().intValue() - clouds);
        memberCloudsService.update(memberClouds);
        //添加流水
        Member2 member = memberService.getByAccount(account);
        MemberCloudsLine memberCloudsLine = MemberCloudsLine.builder()
                .heapBalance(memberClouds.getHeapBalance())
                .freezeBalance(memberClouds.getFreezeBalance())
                .ableBalance(memberClouds.getCloudsAbleBalance())
                .account(account).clouds(clouds).createDateTime(new Date())
                .transType(TransType.WITHDRAW_CASH).memberId(member.getId()).remark("提现").build();
        memberCloudsLineService.insertSelective(memberCloudsLine);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 获取可提现金额
     */
    public Map<String, Object> getWithdrawCash(String account) {
        Map<String, Object> map = new HashMap<String, Object>();
        JSONObject jo = new JSONObject();
        MemberClouds memberClouds = memberCloudsService.getByAccount(account);
        BigDecimal scale = new BigDecimal(TransType.SCALE);
        jo.put("takeCashQuota", new BigDecimal(memberClouds.getTakeCashQuota())
                .divide(scale, 2, BigDecimal.ROUND_DOWN));
        jo.put("takeCashClouds", memberClouds.getTakeCashQuota());
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, jo);
        return map;
    }

    /**
     * 获取云朵数量 和是否名人
     *
     * @param member2DTO
     * @return
     */
    public Map<String, Object> findIndexInfo(Member2DTO member2DTO) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            Map<String, Object> map = masterService.findIndexInfo(member2DTO);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            resMap.put(Constants.DATA, map);
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);
        }
        return resMap;
    }

    /**
     * 发布任务
     *
     * @param member2DTO
     * @return
     */
    public Map<String, Object> celebrityBeginTask(Member2DTO member2DTO) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        try {
            Map<String, Object> map = masterService.celebrityBeginTask(member2DTO);
            resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
            resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            if (map.size() > 0) {
                return map;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);
        }
        return resMap;
    }


    /**
     * 搜索竞彩大师
     *
     * @param keywords
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> Search(String keywords, int offset, int pageSize) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            List<MemberDTO> searchList = masterService.Search(keywords, offset, pageSize);
            if (searchList == null || searchList.size() == 0) {
                if (offset == 1) {
                    map.put(Constants.CODE, Constants.ERROR_CODE_603);
                    map.put(Constants.MSG, Constants.ERROR_MSG_603);
                    return map;
                } else {
                    map.put(Constants.CODE, Constants.ERROR_CODE_604);
                    map.put(Constants.MSG, Constants.ERROR_MSG_604);
                    return map;
                }
            } else {
                PageInfo<MemberDTO> pageInfo = new PageInfo<MemberDTO>(searchList);
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put(Constants.DATA, pageInfo);
                return map;
            }
        } catch (Exception e) {
            System.out.println(e);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(Constants.CODE, Constants.ERROR_CODE_609);
            map.put(Constants.MSG, "搜索请求出错");
            return map;
        }

    }


    /**
     * 获取认证名人列表
     *
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> getMasterList(int offset, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<MemberDTO> matterList = masterService.getMasterList(offset, pageSize);
        PageInfo<MemberDTO> pageInfo = new PageInfo<MemberDTO>(matterList);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, pageInfo);
        return map;
    }

    /**
     * 获取实战大神列表
     *
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> getHighGradeList(int offset, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<MemberDTO> highGradeList = masterService.getHighGradeList(offset, pageSize);
        PageInfo<MemberDTO> pageInfo = new PageInfo<MemberDTO>(highGradeList);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, pageInfo);
        return map;
    }


    /**
     * 可选赛事列表
     *
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> matchList(String account, int type, int offset, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (isNotIn(account)) {
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_7);
            return map;
        }
        MemberTaskBegin memberTaskBegin = memberTaskBeginService.getNowTask(account);
        if (memberTaskBegin == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_8);
            return map;
        }
        if (memberTaskBegin.getIsFinish() == 0) {
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_9);
            return map;
        }
        //获取当前日期int型
        int date = DateUtil.getIntTime();
        List<SportteryMatchDTO> matchList = sportteryMatchService.getMatchList(date, type, offset, pageSize);
        PageInfo<SportteryMatchDTO> pageInfo = new PageInfo<SportteryMatchDTO>(matchList);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, pageInfo);
        return map;
    }

    /**
     * 获取篮球比赛详情
     *
     * @param matchIds
     * @return
     */
    public Map<String, Object> basketballMatchDetails(List<Integer> matchIds) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<BasketballMatchDetailsDTO> matchDetailsList = sportteryMatchService.getBasketballMatchDetails(matchIds);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, matchDetailsList);
        return map;
    }

    /**
     * 获取足球比赛详情
     *
     * @param matchIds
     * @return
     */
    public Map<String, Object> footballMatchDetails(List<Integer> matchIds) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<FootballMatchDetailsDTO> matchDetailsList = sportteryMatchService.getFootballMatchDetails(matchIds);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, matchDetailsList);
        return map;
    }

    /**
     * 判断该账户是否具有快速审核的功能
     * @param account
     * @return
     */
    public int isFast (String account){
        return memberCloudsService.isFast(account);
    }

    /**
     * 设置快速审核手机号
     * @param phone
     * @return
     */
    public Map<String, Object> setFast(String phone,String account){
        Map<String, Object> map = new HashMap<String, Object>();
//        使用Redis存储
//        try {
//            Jedis jedis = RedisUtil.getJedis();
//            jedis.set("fast",phone);
//            jedis.close();
//            map.put(Constants.CODE, Constants.SUCCESS_CODE);
//            map.put(Constants.MSG, Constants.SUCCESS_MSG);
//        }catch (Exception e){
//            map.put(Constants.CODE, Constants.ERROR_CODE_619);
//            map.put(Constants.MSG, "设置快速审核手机号错误");
//        }
//        使用数据库存储
        int i = memberTaskBeginService.setFast(phone, account);
        if(i>0){
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
        }else{
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "设置快速审核手机号错误");
        }
        return map;
    }

    /**
     * 发布推荐
     *
     * @param account
     * @param content
     * @param fee
     * @param type
     * @param matchList
     * @return
     */
    public Map<String, Object> issueRecommendation(String account, String content, BigDecimal fee,
                                                   int type, List<RecommendMatchDTO> matchList,int isFast) {
        Map<String, Object> map = new HashMap<String, Object>();
        MemberTaskBegin memberTaskBegin = memberTaskBeginService.getNowTask(account);
        if (memberTaskBegin == null) {    //还未创建本期任务
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_8);
            return map;
        }
        if (memberTaskBegin.getTaskNum() == 10) {
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_9);
            return map;
        }
        if(isFast==1){  //快速审核
            Integer clounds = memberCloudsService.getClounds(account);

            if(clounds==null||clounds.equals(null)||clounds.equals("")||clounds<1){  //云朵不足1朵
                map.put(Constants.CODE, Constants.ERROR_CODE_10);
                map.put(Constants.MSG, Constants.ERROR_MSG_10_13);
                return map;
            }
            int i = memberCloudsService.QuickReview(account);
            if(i!=1){
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG,"快速审核失败");
                return map;
            }
            try {//15267185000肖森
                //将信息存入redis
//              Jedis jedis = RedisUtil.getJedis();
//              String fast = jedis.get("fast");
                String phone = memberTaskBeginService.getPhone();
                CLSmsSend.send(phone,"快速审核提示：请尽快处理"+account+"账户的推荐");
//              jedis.close();
            }catch (Exception e){
                map.put(Constants.CODE, Constants.SMS_ERROR_CODE);
                map.put(Constants.MSG, Constants.SMS_ERROR_CODE_2);
                return map;
            }
        }
        //快速审核
        RecommendPlan recommendPlan = RecommendPlan.builder().account(account).content(content)
                .createTime(new Date()).fee(fee).playType(matchList.size()).type(type)
                .taskId(memberTaskBegin.getId()).build();
        int id = recommendPlanService.insertSelective(recommendPlan);
        for (RecommendMatchDTO recommendMatchDTO : matchList) {
            RecommendMatchMapping recommendMatchMapping = RecommendMatchMapping.builder()
                    .baseBigSmall(recommendMatchDTO.getBaseBigSmall())
                    .guestTeam(recommendMatchDTO.getGuestName())
                    .homeTeam(recommendMatchDTO.getHomeName())
                    .intTime(recommendMatchDTO.getIntTime())
                    .lineid(recommendMatchDTO.getLineId())
                    .matchId(recommendMatchDTO.getMatchId())
                    .matchTime(recommendMatchDTO.getMatchTime())
                    .gameName(recommendMatchDTO.getGameName())
                    .recomPlanId(id)
                    .result(recommendMatchDTO.getResult())
                    .score(recommendMatchDTO.getScore())
                    .sp(recommendMatchDTO.getSp())
                    .type(recommendMatchDTO.getType()).build();
            recommendMatchMappingService.insertSelective(recommendMatchMapping);
        }
        int taskNum = memberTaskBegin.getTaskNum() + 1; //完成任务数+1
        memberTaskBegin.setTaskNum(taskNum);    //重新设置完成任务数
        if (taskNum == 10) {  //当完成任务为10的时候,本期任务完成
            memberTaskBegin.setIsFinish(0);
        }
        memberTaskBeginService.update(memberTaskBegin);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put("id", id);
        return map;
    }


    /**
     * 获取我的云朵明细
     * @param account
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> getCloudList(String account, int num, int offset, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<MemberCloudsLine> CloudList = memberService.getCloudList(account,num,offset, pageSize);
        if (num == 0) { //读取全部云朵明细
            for (MemberCloudsLine memberCloudsLine : CloudList) {
                Integer transType = memberCloudsLine.getTransType();
                if(transType==51||transType==404||transType==401){
                    Integer clouds = memberCloudsLine.getClouds();
                    memberCloudsLine.setClouds(clouds *= -1);
                }
            }
            if (CloudList == null || CloudList.size() == 0) {
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "暂无云朵明细");
            }
        } else if (num == 1) { //读取收入云朵明细
            if (CloudList == null || CloudList.size() == 0) {
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "暂无收入明细");
            }
        } else if (num == 2) {//读取支出云朵明细
            for (MemberCloudsLine memberCloudsLine : CloudList) {
                Integer clouds = memberCloudsLine.getClouds();
                memberCloudsLine.setClouds(clouds *= -1);
            }
            if (CloudList == null || CloudList.size() == 0) {
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "暂无支出明细");
            }
        } else if (num == 3) {//获取云朵提现明细列表
            if (CloudList == null || CloudList.size() == 0) {
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "暂无提现记录");
            }
        }
        PageInfo<MemberCloudsLine> pageInfo = new PageInfo<MemberCloudsLine>(CloudList);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, pageInfo);
        return map;
    }


    /**
     * 获取购买详情列表
     *
     * @param account
     * @param type
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> getBuyList(String account, Integer type, int offset, int pageSize) {
        try {

            Map<String, Object> map = new HashMap<String, Object>();
            List<RecommendPlanDTO> buyList = recommendBuyLineService.getBuyList(account, type, offset, pageSize);


            for (RecommendPlanDTO recommendPlanDTO : buyList) {
                AddWeek(recommendPlanDTO);
                String account1 = recommendPlanDTO.getAccount();
                Member2 account2 = memberService.getByAccount(account1);
                //获取被购买人近俩周战绩
                List<RecommendPlanDTO> list = recommendPlanService.getRecomList(account1);
                for (RecommendPlanDTO recommendPlanDTO2 : list) {
                    AddWeek(recommendPlanDTO2);
                }
                int i = 0;
                for (RecommendPlanDTO recommendPlanDTO3 : list) {
                    if (recommendPlanDTO3.getBingoStatus() == 1) {
                        i++;
                    }
                }
                recommendPlanDTO.setRecord(list.size() + "中" + i);
                recommendPlanDTO.setUserName(account2.getUsername());
                recommendPlanDTO.setPicture(account2.getPicture());
            }

//            List<Object> buyList2 = new ArrayList<Object>();
//            buyList2.add(buyList);
//            buyList2.add(",Record");
            PageInfo<RecommendPlanDTO> pageInfo = new PageInfo<RecommendPlanDTO>(buyList);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA, pageInfo);
            return map;
        } catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(Constants.CODE, Constants.ERROR_CODE_609);
            map.put(Constants.MSG, "获取购买详情出错");
            return map;
        }
    }


    /**
     * 获取推荐列表
     *
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> getRecommendationList(int offset, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<RecommendPlanDTO> list = recommendPlanService.getRecommendationList(offset, pageSize);
        for (RecommendPlanDTO recommendPlanDTO : list) {
            AddWeek(recommendPlanDTO);
        }
        for (RecommendPlanDTO recommendPlanDTO : list) {
            String account = recommendPlanDTO.getAccount();
            //获取近两周推荐列表
            List<RecommendPlanDTO> list2 = recommendPlanService.getRecomList(account);
            for (RecommendPlanDTO recommendPlanDTO2 : list2) {
                AddWeek(recommendPlanDTO2);
            }
                int i = 0;
                for (RecommendPlanDTO recommendPlanDTO3 : list2) {
                    if (recommendPlanDTO3.getBingoStatus() == 1) {
                        i++;
                    }
                }
                recommendPlanDTO.setRecord(list2.size() + "中" + i);

                BigDecimal bigDecimal = new BigDecimal(0);
                if(list2.size()!=0){
                    bigDecimal=new BigDecimal(i)
                            .divide(new BigDecimal(list2.size()), 2, BigDecimal.ROUND_HALF_UP);
                }
                recommendPlanDTO.setRateOfReturn(bigDecimal);
        }



        PageInfo<RecommendPlanDTO> pageInfo = new PageInfo<RecommendPlanDTO>(list);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, pageInfo);
        return map;
    }

    /**
     * 获取推荐详情
     *
     * @param id
     * @return
     */
    public Map<String, Object> getRecommendationDetails(String account, int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        boolean isSee = false;
        RecommendPlanDTO recommendPlanDTO = recommendPlanService.getRecommendationById(id);
        if (recommendPlanDTO == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_10);
            return map;
        }
        AddWeek(recommendPlanDTO);
        if (recommendPlanDTO.getFee().compareTo(new BigDecimal(0)) == 0) { //免费
            isSee = true;
        } else {//是否购买
            RecommendBuyLine recommendBuyLine = recommendBuyLineService.getByAccountAndPlanId(account, id);
            if (recommendBuyLine != null) {
                isSee = true;
            }
        }
        if (account.equals(recommendPlanDTO.getAccount())) {//自己可以看到自己发的推荐
            isSee = true;
        }
        //添加阅读量
        recommendPlanDTO.setReadNum(recommendPlanDTO.getReadNum() + 1);
        recommendPlanService.updateRecommendPlan(recommendPlanDTO);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, recommendPlanDTO);
        map.put("isSee", isSee);
        return map;
    }

    /**
     * 购买推荐
     *
     * @param member2DTO
     * @param id
     * @return
     */
    public Map<String, Object> buyRecommendation(Member2DTO member2DTO, int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        String account = member2DTO.getAccount();
        RecommendPlanDTO recommendPlanDTO = recommendPlanService.getRecommendationById(id);
        if (account.equals(recommendPlanDTO.getAccount())) {
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_14);
            return map;
        }
        if (recommendPlanDTO == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_10);
            return map;
        }
        if (recommendPlanDTO.getFee().compareTo(new BigDecimal(0)) == 0) {
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_11);
            return map;
        }
        RecommendBuyLine recommendBuyLine = recommendBuyLineService.getByAccountAndPlanId(account, id);
        if (recommendBuyLine != null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_12);
            return map;
        }
        //推荐价格
        int clouds = recommendPlanDTO.getFee().intValue();
        MemberClouds memberClouds = memberCloudsService.getByAccount(account);
        if (memberClouds == null || memberClouds.getCloudsAbleBalance() < clouds) {
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_13);
            return map;
        }
        recommendBuyLine = RecommendBuyLine.builder().account(account).clouds(clouds)
                .createTime(new Date()).recomPlanId(id).build();
        recommendBuyLineService.insertSelective(recommendBuyLine);
        //扣除费用
        memberClouds.setCloudsAbleBalance(memberClouds.getCloudsAbleBalance() - clouds);
        if (memberClouds.getCloudsAbleBalance() < memberClouds.getTakeCashQuota().intValue()) {
            memberClouds.setTakeCashQuota((double) memberClouds.getCloudsAbleBalance());
        }
        memberClouds.setHeapBalance(memberClouds.getHeapBalance() + clouds);
        memberCloudsService.update(memberClouds);
        //添加流水
        MemberCloudsLine line = MemberCloudsLine.builder().ableBalance(memberClouds.getCloudsAbleBalance())
                .account(account).clouds(clouds).createDateTime(new Date()).planNo(id)
                .heapBalance(memberClouds.getHeapBalance())
                .freezeBalance(memberClouds.getFreezeBalance())
                .heapBalance(memberClouds.getHeapBalance())
                .transType(TransType.BUY).remark("购买推荐").memberId(member2DTO.getId()).build();
        memberCloudsLineService.insertSelective(line);
        if (recommendPlanDTO.getType() == 0) { //不中不退，直接加款
            addClouds(recommendPlanDTO, clouds);
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 获取竞彩大师个人信息
     *
     * @return
     */
    public Map<String, Object> getMasterInfo(String account, String fansAccount) {
        Map<String, Object> map = new HashMap<String, Object>();
        MasterInfoDTO masterInfoDTO = memberService.getMasterInfo(account);
        //获取近两周推荐列表
        List<RecommendPlanDTO> list = recommendPlanService.getRecomList(account);
        for (RecommendPlanDTO recommendPlanDTO : list) {
            AddWeek(recommendPlanDTO);
        }
        boolean isSelf = false;
        if(account.equals(fansAccount)){
            isSelf = true;
        }
        int i = 0;
        for (RecommendPlanDTO recommendPlanDTO : list) {
            if (recommendPlanDTO.getBingoStatus() == 1) {
                i++;
            }
        }
        masterInfoDTO.setMilitaryExploits(list.size() + "中" + i);

        if(list.size() == 0){
            masterInfoDTO.setRateOfReturn(new BigDecimal(0));
        }else {
            masterInfoDTO.setRateOfReturn(new BigDecimal(i)
                    .divide(new BigDecimal(list.size()), 2, BigDecimal.ROUND_HALF_UP));
        }

        MemberTaskBeginDTO memberTaskBeginDTO = memberTaskBeginService.getNowTaskAndPlan(account);
        if (memberTaskBeginDTO != null) {
            List<RecommendPlanDTO> planList =
                    recommendPlanService.getRecommendationByTaskId(memberTaskBeginDTO.getId());
            memberTaskBeginDTO.setPlanList(planList);
        }
        if(!isSelf){
            MemberFollowMapping2 mapping = memberFollowMappingService.getByFansAccount(account, fansAccount);
            if(mapping == null || mapping.getIsCancel()){
                map.put("isFollow", false);
            } else {
                map.put("isFollow", true);
            }
        }
        masterInfoDTO.setMemberTaskBeginDTO(memberTaskBeginDTO);
        map.put(Constants.DATA, masterInfoDTO);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put("isSelf", isSelf);
        return map;
    }

    /**
     * 获取个人推荐列表
     *
     * @param account
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> getRecommendationListByOne(String account, int offset, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<RecommendPlanDTO> list = recommendPlanService.getRecommendationListByAccount(account, offset, pageSize);
        for (RecommendPlanDTO recommendPlanDTO : list) {
            AddWeek(recommendPlanDTO);
        }
        PageInfo<RecommendPlanDTO> pageInfo = new PageInfo<RecommendPlanDTO>(list);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, pageInfo);
        return map;
    }

    /**
     * 获取任务完成情况
     *
     * @param account
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> getTaskList(String account, int offset, int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<MemberTaskBeginDTO> list = memberTaskBeginService.getAll(account, offset, pageSize);
        for (MemberTaskBeginDTO memberTaskBegin : list) {
            if (memberTaskBegin.getEndDate().before(new Date())) {    //如果任务已经结束
                if (memberTaskBegin.getIsFinish() == 1 && memberTaskBegin.getTaskNum() < 10) {//如果任务正在进行或完成任务数不足10
                    memberTaskBegin.setIsFinish(2); //将任务设为完成失败
                }
            }
            List<RecommendPlanDTO> planList =
                    recommendPlanService.getRecommendationByTaskId(memberTaskBegin.getId());
            for (RecommendPlanDTO recommendPlanDTO : planList) {
                AddWeek(recommendPlanDTO);
            }
            memberTaskBegin.setPlanList(planList);
        }
        PageInfo<MemberTaskBeginDTO> pageInfo = new PageInfo(list);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, pageInfo);
        return map;
    }

    /**
     * 是否在出单人列表中
     *
     * @param account
     * @return
     */
    private boolean isNotIn(String account) {
        boolean b = false;
        MemberMasterMapping mapping = memberMasterMappingService.getByAccount(account);
        if (mapping == null) {
            b = true;
        } else if (!mapping.getIsHighgrade() && !mapping.getIsMaster()) {
            b = true;
        }
        return b;
    }

    /**
     * 得到周几，比分及开奖状态
     *
     * @param recommendPlan
     */

    private void AddWeek(RecommendPlanDTO recommendPlan) {
        int clouds = recommendPlan.getFee().intValue();
        List<RecommendBuyLine> lineList = recommendBuyLineService.getByPlanId(recommendPlan.getId());
        for (RecommendMatchMappingDTO mappingDTO : recommendPlan.getMatchList()) {
            int week =
                    DateUtil.getWeekOfDate(DateUtil.StringToDate(mappingDTO.getIntTime() + ""));
            mappingDTO.setWeek(week);
            if (mappingDTO.getType() == 1) {
                SportteryFootballMatch match = sportteryMatchService.getFootballMatchById(mappingDTO.getMatchId());
                if (match.getHomescore() != null && match.getGuestscore() != null) {
                    mappingDTO.setBingoStatus(bingoCheck(recommendPlan, mappingDTO,
                            match.getHomescore(), match.getGuestscore()));
                    mappingDTO.setHomeScore(match.getHomescore());
                    mappingDTO.setGuestScore(match.getGuestscore());
                }
            } else {
                SportteryBasketMatch match = sportteryMatchService.getBasketballMatchById(mappingDTO.getMatchId());
                if (match.getHomescore() != null && match.getGuestscore() != null) {
                    mappingDTO.setBingoStatus(bingoCheck(recommendPlan, mappingDTO,
                            match.getHomescore(), match.getGuestscore()));
                    mappingDTO.setHomeScore(match.getHomescore());
                    mappingDTO.setGuestScore(match.getGuestscore());
                }
            }
            if (recommendPlan.getBingoStatus() == 0 && mappingDTO.getBingoStatus() == 1) { //中奖
                recommendPlan.setBingoStatus(1);
            }
            if (recommendPlan.getBingoStatus() == 1 && mappingDTO.getBingoStatus() == 0) { //还有未开奖
                recommendPlan.setBingoStatus(0);
            }
            //只要有一场失败即为失败
            if (recommendPlan.getBingoStatus() != 2 && mappingDTO.getBingoStatus() == 2) { //未中奖
                recommendPlan.setBingoStatus(2);
                if (recommendPlan.getType() == 1) { //不中退款
                    for (RecommendBuyLine recommendBuyLine : lineList) {
                        String account = recommendBuyLine.getAccount();
                        MemberClouds memberClouds = memberCloudsService.getByAccount(account);
                        //退回费用
                        memberClouds.setCloudsAbleBalance(memberClouds.getCloudsAbleBalance() + clouds);
                        memberCloudsService.update(memberClouds);
                        //添加流水
                        Member2 member = memberService.getByAccount(account);
                        MemberCloudsLine memberCloudsLine = MemberCloudsLine.builder().planNo(recommendPlan.getId())
                                .ableBalance(memberClouds.getCloudsAbleBalance())
                                .freezeBalance(memberClouds.getFreezeBalance())
                                .heapBalance(memberClouds.getHeapBalance())
                                .account(account).clouds(clouds).createDateTime(new Date())
                                .transType(TransType.REFUND).memberId(member.getId()).remark("不中退款").build();
                        memberCloudsLineService.insertSelective(memberCloudsLine);
                    }
                }
            }
        }
        if (recommendPlan.getType() == 1) { //中加款
            for (RecommendBuyLine recommendBuyLine : lineList) {
                //加款
                addClouds(recommendPlan, clouds);
            }
        }
    }

    /**
     * 中奖校验
     *
     * @param recommendPlan
     * @param mappingDTO
     * @param homescore
     * @param guestscore
     * @return
     */
    private Integer bingoCheck(RecommendPlanDTO recommendPlan, RecommendMatchMappingDTO mappingDTO,
                               Integer homescore, Integer guestscore) {
        if (mappingDTO.getBaseBigSmall().compareTo(new BigDecimal(0)) > 0) { //篮球大小分
            if (mappingDTO.getBaseBigSmall().compareTo(new BigDecimal(homescore + guestscore)) > 0) { //大分
                if (mappingDTO.getResult() == 3) {
                    return 1; //中奖
                } else {
                    return 2; //未中奖
                }
            } else { //小分
                if (mappingDTO.getResult() == 0) {
                    return 1; //中奖
                } else {
                    return 2; //未中奖
                }
            }
        } else if (mappingDTO.getScore().compareTo(new BigDecimal(0)) != 0) { //让球或让分
            if (new BigDecimal(homescore).add(mappingDTO.getScore())
                    .compareTo(new BigDecimal(guestscore)) > 0) { //主胜
                if (mappingDTO.getResult() == 3) {
                    return 1; //中奖
                } else {
                    return 2; //未中奖
                }
            } else if (new BigDecimal(homescore).add(mappingDTO.getScore())
                    .compareTo(new BigDecimal(guestscore)) == 0) {//平
                if (mappingDTO.getResult() == 1) {
                    return 1; //中奖
                } else {
                    return 2; //未中奖
                }
            } else if (new BigDecimal(homescore).add(mappingDTO.getScore())
                    .compareTo(new BigDecimal(guestscore)) < 0) {//主负
                if (mappingDTO.getResult() == 0) {
                    return 1; //中奖
                } else {
                    return 2; //未中奖
                }
            }
        } else { // 普通胜平负
            if (new BigDecimal(homescore).compareTo(new BigDecimal(guestscore)) > 0) { //主胜
                if (mappingDTO.getResult() == 3) {
                    return 1; //中奖
                } else {
                    return 2; //未中奖
                }
            } else if (new BigDecimal(homescore).compareTo(new BigDecimal(guestscore)) == 0) {//平
                if (mappingDTO.getResult() == 1) {
                    return 1; //中奖
                } else {
                    return 2; //未中奖
                }
            } else if (new BigDecimal(homescore).compareTo(new BigDecimal(guestscore)) < 0) {//主负
                if (mappingDTO.getResult() == 0) {
                    return 1; //中奖
                } else {
                    return 2; //未中奖
                }
            }
        }
        return 0;//未开奖
    }

    /**
     * 被购加款
     *
     * @param recommendPlanDTO
     * @param clouds
     */
    private void addClouds(RecommendPlanDTO recommendPlanDTO, int clouds) {
        String account = recommendPlanDTO.getAccount();
        MemberClouds memberClouds = memberCloudsService.getByAccount(account);
        if (memberClouds == null) {
            memberClouds = MemberClouds.builder().account(recommendPlanDTO.getAccount())
                    .cloudsAbleBalance(clouds).freezeBalance(0).heapBalance(0).takeCashQuota((double) clouds).build();
            memberCloudsService.insertSelective(memberClouds);
        } else {
            memberClouds.setCloudsAbleBalance(memberClouds.getCloudsAbleBalance() + clouds);
            //被购金额可提现
            memberClouds.setTakeCashQuota((double) (memberClouds.getTakeCashQuota().intValue() + clouds));
            memberCloudsService.update(memberClouds);
        }
        //添加流水
        Member2 member = memberService.getByAccount(account);
        MemberCloudsLine memberCloudsLine = MemberCloudsLine.builder().planNo(recommendPlanDTO.getId())
                .ableBalance(memberClouds.getCloudsAbleBalance())
                .account(account).clouds(clouds).createDateTime(new Date())
                .freezeBalance(memberClouds.getFreezeBalance())
                .heapBalance(memberClouds.getHeapBalance())
                .transType(TransType.ADD).memberId(member.getId()).remark("被购加款").build();
        memberCloudsLineService.insertSelective(memberCloudsLine);
    }
}
