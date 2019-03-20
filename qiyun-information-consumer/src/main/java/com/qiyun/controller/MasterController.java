package com.qiyun.controller;

import com.alibaba.fastjson.JSONArray;
import com.qiyun.api.MasterApi;
import com.qiyun.controller.base.BaseController;
import com.qiyun.dto.Member2DTO;
import com.qiyun.dto.RecommendMatchDTO;
import com.qiyun.util.Constants;
import com.qiyun.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/master")
public class MasterController extends BaseController {

    @Resource
    private MasterApi masterApi;


    @RequestMapping(value = "/getSgTime",method = RequestMethod.GET)
    public Map<String, Object> getSxTime(){
        return masterApi.getSgTime();
    }

    @RequestMapping(value = "/getScTime",method = RequestMethod.GET)
    public Map<String, Object> getScTime(){
        return masterApi.getScTime();
    }

    /**
     * 获取打赏人列表
     * 传入被打赏人的账户account
     * @return
     */
    @RequestMapping(value = "/getRewarderList",method = RequestMethod.GET)
    public Map<String, Object> getRewarderList(){
        Map<String, Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        map = masterApi.getRewarderList(account);
        return map;
    }

    /**
     * 打赏
     * 传入打赏的云朵(cloud),被打赏人的ID(beRewarder),打赏人的ID(Rewarder)
     * @return
     */
    @RequestMapping(value = "/Reward",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> Rewarder(){
        Map<String, Object> map = new HashMap<String, Object>();
        int cloud = getInt("cloud");
        String beRewarderId = getStr("beRewarder");
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        String RewarderId = member2DTO.getAccount();
        if(RewarderId.equals(beRewarderId)){
            map.put(Constants.CODE, Constants.ERROR_CODE_610);
            map.put(Constants.MSG, Constants.ERROR_MSG_610);
            return map;
        }
        Map<String, Object> reward = masterApi.Reward(cloud, beRewarderId, RewarderId);
        return reward;
    }

     /**
     * 申请名人
     * 返回一个电话号码
      */
     @RequestMapping(value = "/applyForCelebrity",method = RequestMethod.GET)
     public Map<String, Object> applyForCelebrity(){
         Map<String, Object> map = masterApi.applyForCelebrity();
         return map;
     }

    /**
     * 搜索竞彩大师
     * @return
     */
    @RequestMapping(value = "/getSearchList",method = RequestMethod.GET)
    public Map<String, Object> getSearchList(@RequestParam String keywords){
        Map<String, Object> map = new HashMap<String, Object>();
//        String keywords = (String) request.getParameter("keywords");
        int page = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        map = masterApi.Search(keywords,page, pageSize);
        return map;
    }

    /**
     * 获取认证名人列表
     * @return
     */
    @RequestMapping(value = "/getMasterList",method = RequestMethod.GET)
    public Map<String, Object> getMasterList(){
        Map<String, Object> map = new HashMap<String, Object>();
        int page = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        map = masterApi.getMasterList(page, pageSize);
        return map;
    }

    /**
     * 获取实战大神列表
     * @return
     */
    @RequestMapping(value = "/getHighGradeList",method = RequestMethod.GET)
    public Map<String, Object> getHighGradeList(){
        Map<String, Object> map = new HashMap<String, Object>();
        int page = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        map = masterApi.getHighGradeList(page, pageSize);
        return map;
	}
	
    /**
     * 首页显示云朵数量和是否是名人或者优质客户
     *
     * IsCelebrity 0为普通用户 1为优质用户或者名人
     */

    @RequestMapping(value = "/findIndexInfo")
    public Map<String, Object> findIndexInfo(@RequestParam String token){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        map = masterApi.findIndexInfo(member2DTO);
        return map;
    }

    /**
     * 比赛列表
     * @return
     */
    @RequestMapping(value = "/getMatchList",method = RequestMethod.GET)
    public Map<String, Object> getMatchList(){
        Map<String, Object> map = new HashMap<String, Object>();
        int page = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        int type = getInt("type",1);
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        map = masterApi.matchList(member2DTO.getAccount(), type, page, pageSize);
        return map;
    }

    /**
     * 获取篮球比赛详情
     * @param matchIds
     * @return
     */
    @RequestMapping(value = "/getBasketballMatchDetails",method = RequestMethod.GET)
    public Map<String, Object> getBasketballMatchDetails(Integer[] matchIds){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Integer> list = Arrays.asList(matchIds);
        if(list.size() == 0){
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_5);
            return map;
        }
        if(list.size() > 2){
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_6);
            return map;
        }
        map = masterApi.basketballMatchDetails(list);
        return map;
    }

    /**
     * 获取足球比赛详情
     * @param matchIds
     * @return
     */
    @RequestMapping(value = "/getFootballMatchDetails",method = RequestMethod.GET)
    public Map<String, Object> getFootballMatchDetails(Integer[] matchIds){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Integer> list = Arrays.asList(matchIds);
        if(list.size() == 0){
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_5);
            return map;
        }
        if(list.size() > 2){
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_6);
            return map;
        }
        map = masterApi.footballMatchDetails(list);
        return map;
    }

    /**
     * 发起推荐
     * @return
     */
    @RequestMapping(value = "/issueRecommendation",method = RequestMethod.GET)
    public Map<String, Object> issueRecommendation(){
        Map<String, Object> map = new HashMap<String, Object>();
        String listMatchs = request.getParameter("matchList");
        String content = request.getParameter("content");
        String fee = getStr("fee");
        int type = getInt("type");
        int isFast = getInt("isFast",0);
        if(type != 1 && type != 0){ //发布推荐方式有误
            map.put(Constants.CODE, Constants.ERROR_CODE_1);
            map.put(Constants.MSG, Constants.ERROR_MSG_1);
            return map;
        }
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){  //用户未登录
            map.put(Constants.CODE,  Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
//        if(isFast == 1){    //判断是否具有快速审核的资格
//            int fast = masterApi.isFast(member2DTO.getAccount());
//            if(fast==0){
//                map.put(Constants.CODE, Constants.ERROR_CODE_2);
//                map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
//                return map;
//            }else if(fast==1){
//                map.put(Constants.CODE, Constants.ERROR_CODE_2);
//                map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
//                return map;
//            }
//        }
        List<RecommendMatchDTO> matchList = JSONArray.parseArray(listMatchs, RecommendMatchDTO.class);
        if(matchList.size() == 0){  //传入的推荐列表为空
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_5);
            return map;
        }
        if(matchList.size() > 2){   //所选赛事只支持2穿1或单场,不能超过俩场
            map.put(Constants.CODE, Constants.ERROR_CODE_10);
            map.put(Constants.MSG, Constants.ERROR_MSG_10_6);
            return map;
        }
        map = masterApi.issueRecommendation(member2DTO.getAccount(), content, new BigDecimal(fee), type, matchList,isFast);
        return map;
    }

    /**
     * 获取云朵明细
     * @return
     */
    @RequestMapping(value = "/getCloudList",method = RequestMethod.GET)
    public Map<String, Object> getCloudList(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        String account = member2DTO.getAccount();
        int num = getInt("num",0);
        int page = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        map = masterApi.getCloudList(account,num,page, pageSize);
        return map;
    }

    /**
     * 获取购买详情列表
     * @return
     */
    @RequestMapping(value = "/getBuyList",method = RequestMethod.GET)
    public Map<String, Object> getBuyList(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        String account = member2DTO.getAccount();
        int num = getInt("type",-1);
        Integer type=new Integer(num);
        if(num==-1){
            type=null;
        }
        int page = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        map = masterApi.getBuyList(account,type,page, pageSize);
        return map;
    }

    /**
     * 获取推荐列表
     * @return
     */
    @RequestMapping(value = "/getRecommendationList",method = RequestMethod.GET)
    public Map<String, Object> getRecommendationList(){
        Map<String, Object> map = new HashMap<String, Object>();
        int page = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        map = masterApi.getRecommendationList(page, pageSize);
        return map;
    }

    /**
     * 获取推荐详情
     * @return
     */
    @RequestMapping(value = "/getRecommendationDetails",method = RequestMethod.GET)
    public Map<String, Object> getRecommendationDetails(){
        Map<String, Object> map = new HashMap<String, Object>();
        int id = getInt("id");
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        map = masterApi.getRecommendationDetails(member2DTO.getAccount(), id);
        return map;
    }

    /**
     * 获取竞彩大师个人信息
     * @return
     */
    @RequestMapping(value = "/getMasterInfo",method = RequestMethod.GET)
    public Map<String, Object> getMasterInfo(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        String account = request.getParameter("account");
        boolean isSelf = false;
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        if(account == null) {
            account = member2DTO.getAccount();
            isSelf = true;
        } else if(account.equals(member2DTO.getAccount())){
            isSelf = true;
        }
        if(StringUtils.isNullOrBlank(account)){
            map.put(Constants.CODE,Constants.ERROR_CODE_1);
            map.put(Constants.MSG,Constants.ERROR_MSG_1_6);
            return map;
        }
        map = masterApi.getMasterInfo(account, member2DTO.getAccount());
        return map;
    }

    /**
     * 设置快速审核的手机号
     * @return
     */
    @RequestMapping(value = "/setFast",method = RequestMethod.GET)
    public Map<String, Object> setFast(){
        Map<String, Object> map = new HashMap<String, Object>();

        Member2DTO member2DTO = checkLogin();
        String phone = getStr("phone");
        String username = getStr("username");
        map = masterApi.setFast(phone,username);
        return map;
    }

    /**
     * 获取某人的推荐列表
     * @return
     */
    @RequestMapping(value = "/getRecommendationListByOne",method = RequestMethod.GET)
    public Map<String, Object> getRecommendationListByOne(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        String account = request.getParameter("account");
        if(account == null) {
            if (member2DTO==null){
                map.put(Constants.CODE, Constants.ERROR_CODE_2);
                map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
                return map;
            } else {
                account = member2DTO.getAccount();
            }
        }
        int page = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        map = masterApi.getRecommendationListByOne(account, page, pageSize);
        return map;
    }

    /**
     * 任务列表
     * @return
     */
    @RequestMapping(value = "/getTaskList",method = RequestMethod.GET)
    public Map<String, Object> getTaskList(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        String account = request.getParameter("account");
        if(account == null ||account.length() <= 0){
            account = member2DTO.getAccount();
        }
        int page = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        map = masterApi.getTaskList(account, page, pageSize);
        return map;
    }

    /**
     * 购买推荐
     * @return
     */
    @RequestMapping(value = "/buyRecommendation",method = RequestMethod.GET)
    public Map<String, Object> buyRecommendation(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        int id = getInt("id");
        map = masterApi.buyRecommendation(member2DTO, id);
        return map;
    }

    /**
     * 发起提现
     * @return
     */
    @RequestMapping(value = "/withdrawCash",method = RequestMethod.GET)
    public Map<String, Object> withdrawCash(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        int clouds = getInt("clouds");
        map = masterApi.withdrawCash(member2DTO.getAccount(), clouds);
        return map;
    }

    /**
     * 获取可提现金额
     * @return
     */
    @RequestMapping(value = "/getWithdrawCash",method = RequestMethod.GET)
    public Map<String, Object> getWithdrawCash(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        map = masterApi.getWithdrawCash(member2DTO.getAccount());
        return map;
    }

    /**
     * 发起任务
     */
    @RequestMapping(value = "/celebrityBeginTask")
    public Map<String, Object> celebrityBeginTask(@RequestParam String token){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        map = masterApi.celebrityBeginTask(member2DTO);
        return map;
    }

    
}
