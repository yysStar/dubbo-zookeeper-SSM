package com.qiyun.controller;

import com.alibaba.fastjson.JSONObject;
import com.qiyun.api.InformationApi;
import com.qiyun.common.Result;
import com.qiyun.controller.base.BaseController;

import com.qiyun.dto.DayOneDan2DTO;
import com.qiyun.dto.Member2DTO;
import com.qiyun.model2.Mail;
import com.qiyun.util.Constants;
import com.qiyun.util.FileUpload;
import com.qiyun.util.StringUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/information")
public class InformationController extends BaseController{

    @Resource
    private InformationApi informationApi;

    @RequestMapping(value = "/getBasketballLineup", method = RequestMethod.GET)
    public Map<String, Object> getBasketballLineup() {
        Map<String, Object> map = new HashMap<String, Object>();
        String id = getStr("id");
        if(id==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationApi.getBasketballLineup(id);
    }

    @RequestMapping(value = "/getInformation", method = RequestMethod.GET)
    public Map<String, Object> getInformation() {
        return informationApi.getInformation();
    }

    @RequestMapping(value = "/getFootballMatch", method = RequestMethod.GET)
    public Map<String, Object> getFootballMatch() {
        Map<String, Object> map = new HashMap<String, Object>();
        int offset = getInt("offset", 1);
        int pageSize = getInt("pageSize", 10);
        int type = getInt("type",0);
        return informationApi.getFootballMatch(offset,pageSize,type);
    }

    @RequestMapping(value = "/getBasketballLiveCount", method = RequestMethod.GET)
    public Map<String, Object> getBasketballLiveCount() {
        Map<String, Object> map = new HashMap<String, Object>();
        String id = getStr("id");
        if(id==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationApi.getBasketballLiveCount(id);
    }


    @RequestMapping(value = "/getFootballLive", method = RequestMethod.GET)
    public Map<String, Object> getFootballLive() {
        Map<String, Object> map = new HashMap<String, Object>();
        String id = getStr("id");
        if(id==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationApi.getFootballLive(id);
    }

    @RequestMapping(value = "/getBasketballRank", method = RequestMethod.GET)
    public Map<String, Object> getBasketballRank() {
        Map<String, Object> map = new HashMap<String, Object>();
        String id = getStr("ids");
        if(id==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationApi.getBasketballRank(id);
    }

    @RequestMapping(value = "/getBaskballScheduleResult",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getBaskballScheduleResult() {
        Map<String, Object> map = new HashMap<String, Object>();
        String date = getStr("date");
        int offset = getInt("offset", 1);
        int pageSize = getInt("pageSize", 10);
        return informationApi.getBaskballScheduleResult(date,offset,pageSize);
    }

    @RequestMapping(value = "/getFootballScheduleResult",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getFootballScheduleResult() {
        Map<String, Object> map = new HashMap<String, Object>();
        String date = getStr("date");
        int offset = getInt("offset", 1);
        int pageSize = getInt("pageSize", 10);
        return informationApi.getFootballScheduleResult(date,offset,pageSize);
    }
    
    
    @RequestMapping(value = "/getBasketballLive",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getBasketballLive() {
        Map<String, Object> map = new HashMap<String, Object>();
        String id = getStr("id");
        if(id==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationApi.getBasketballLive(id);
    }

    @RequestMapping(value = "/getFootballTeam",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getFootballTeam() {
        Map<String, Object> map = new HashMap<String, Object>();
        String ids = getStr("ids");
        if(ids==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationApi.getFootballTeam(ids);
    }

    @RequestMapping(value = "/getBasketballTeam",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getBasketballTeam() {
        Map<String, Object> map = new HashMap<String, Object>();
        String ids = getStr("ids");
        if(ids==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationApi.getBasketballTeam(ids);
    }

    @RequestMapping(value = "/getNowDayBasketballScore",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getNowDayBasketballScore() {
        Map<String, Object> map = new HashMap<String, Object>();
        int offset = getInt("offset", 1);
        int pageSize = getInt("pageSize", 10);
        return informationApi.getNowDayBasketballScore(offset,pageSize);
    }

    @RequestMapping(value = "/getNowTimeBasketballScore",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getNowTimeBasketballScore() {
        Map<String, Object> map = new HashMap<String, Object>();
        return informationApi.getNowTimeBasketballScore();
    }

    @RequestMapping(value = "/getNowTimeFootaballScore",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getNowTimeFootaballScore() {
        Map<String, Object> map = new HashMap<String, Object>();
        return informationApi.getNowTimeFootaballScore();
    }

    @RequestMapping(value = "/getNowDayFootaballScore",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getNowDayFootaballScore() {
        Map<String, Object> map = new HashMap<String, Object>();
        String language = getStr("language");
        int offset = getInt("offset", 1);
        int pageSize = getInt("pageSize", 10);
        return informationApi.getNowDayFootaballScore(language,offset,pageSize);
    }

    //上传图片  "info"
    @RequestMapping(value = "/uploadImage",method = RequestMethod.POST)
    @ResponseBody
    public String uploadImage(MultipartFile file) {
        Map<String, Object> map = new HashMap<String, Object>();
        String folder = getStr("folder");
        String s = FileUpload.upLoad(file,folder+"/");
        if(folder!=null){
            return "https://qyun88.oss-cn-hangzhou.aliyuncs.com/"+folder+"/"+s;
        }else{
            return "https://qyun88.oss-cn-hangzhou.aliyuncs.com/"+s;
        }
    }

    /**
     * 获取未读消息
     * @return
     */
    @RequestMapping(value = "/getUnread",method = RequestMethod.GET)
    public Map<String, Object> getUnread(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        String account = member2DTO.getAccount();
        return informationApi.getUnread(account);
    }

    @RequestMapping(value = "/getLikeWIinCount",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getLikeWIinCount() {
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        Integer planNo = getInteger("planNo");
        if(planNo==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        String account = member2DTO.getAccount();
        return informationApi.getLikeWIinCount(account,planNo);
    }

    @RequestMapping(value = "/getLikePlanCount",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getLikePlanCount() {
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        Integer planNo = getInteger("planNo");
        if(planNo==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        String account = member2DTO.getAccount();
        return informationApi.getLikePlanCount(account,planNo);
    }

    /**
     * 方案点赞
     * @return
     */
    @RequestMapping(value = "/likeWinPromotion",method = RequestMethod.GET)
    public Map<String, Object> likeWinPromotion(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        Integer planNo = getInteger("planNo");
        if(planNo==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        String account = member2DTO.getAccount();
        return informationApi.likeWinPromotion(account,planNo);
    }

    /**
     * 方案点赞
     * @return
     */
    @RequestMapping(value = "/likeLotteryPlan",method = RequestMethod.GET)
    public Map<String, Object> likeLotteryPlan(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        Integer planNo = getInteger("planNo");
        if(planNo==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        String account = member2DTO.getAccount();
        return informationApi.likeLotteryPlan(account,planNo);
    }

    /**
     * 中奖宣传评论点赞
     * @return
     */
    @RequestMapping(value = "/likePromotionComment",method = RequestMethod.GET)
    public Map<String, Object> likePromotionComment(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        Integer commentId = getInteger("commentId");
        if(commentId==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationApi.likePromotionComment(commentId,member2DTO.getAccount());
    }

    /**
     * 评论点赞
     * @return
     */
    @RequestMapping(value = "/likeComment",method = RequestMethod.GET)
    public Map<String, Object> likeComment(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        Integer commentId = getInteger("commentId");
        if(commentId==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationApi.likeComment(commentId,member2DTO.getAccount());
    }

    /**
     * 回复评论
     * @return
     */
    @RequestMapping(value = "/replyComment",method = RequestMethod.POST)
    public Map<String, Object> replyComment(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        Integer commentId = getInteger("commentId");
        String account = member2DTO.getAccount();
//        String connect = getStr("connect");
        String connect = request.getParameter("connect");
        if(commentId==null||account==null||connect==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationApi.replyComment(commentId,account,connect);
    }

    /**
     * 获取评论列表
     * @return
     */
    @RequestMapping(value = "/getPromotionCommentList",method = RequestMethod.GET)
    public Map<String, Object> getPromotionCommentList(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        Integer planNo = getInteger("planNo");
        if (planNo==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        String account = member2DTO.getAccount();
        int page = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        int sort = getInt("sort",1);
        return informationApi.getPromotionCommentList(planNo,account,page,pageSize,sort);
    }

    /**
     * 获取评论列表
     * @return
     */
    @RequestMapping(value = "/getCommentList",method = RequestMethod.GET)
    public Map<String, Object> getCommentList(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        Integer planNo = getInteger("planNo");
        if (planNo==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        String account = member2DTO.getAccount();
        int page = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        int sort = getInt("sort",1);
        return informationApi.getCommentList(planNo,account,page,pageSize,sort);
    }

    /**
     * 发表中奖宣传评论
     * @return
     */
    @RequestMapping(value = "/promotionComment",method = RequestMethod.POST)
    public Map<String, Object> promotionComment(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        Integer planNo = getInteger("planNo");
        if (planNo==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        String account = member2DTO.getAccount();
        String connect = request.getParameter("connect");
        return informationApi.promotionComment(planNo,account,connect);
    }

    /**
     * 发表评论
     * @return
     */
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public Map<String, Object> comment(){
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        Integer planNo = getInteger("planNo");
        if (planNo==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        String account = member2DTO.getAccount();
//        String connect = getStr("connect");
        String connect = request.getParameter("connect");
        String s = StringUtil.replaceEmoji(connect);
        if(s==""||s==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationApi.comment(planNo,account,s);
    }



    @RequestMapping(value = "/getSZ2C1ByNumber",method = RequestMethod.GET)
//    @ResponseBody
    public Result getSZ2C1ByNumber(){
        int number = getInt("number");
        Result result = informationApi.getSZ2C1ByNumber(number);
        return result;
    }

    /**
     * 获取最新每日两胆
     * @return
     */
    @RequestMapping(value = "/getDayOneDanByNumber",method = RequestMethod.GET)
//    @ResponseBody
    public Map<String, Object> getDayOneDanByNumber(){
        int number = getInt("number",0);
        Map<String, Object> map  = informationApi.getDayOneDanByNumber(number);
        return map;
    }

    /**
     * 点赞
     * @return
     */
    @RequestMapping(path = {"/like"}, method =RequestMethod.GET)
//    @ResponseBody
    public Map<String, Object> like(){
        Map<String, Object> map = new HashMap<String, Object>();
        String newId = getStr("newId");
        if (newId==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_606);
            map.put(Constants.MSG, Constants.ERROR_MSG_606);
            return map;
        }
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        String account = member2DTO.getAccount();
        //在likeKey对应的集合中加入当前用户的id
        return informationApi.like(newId,account);
    }

    /**
     * 取消点赞
     * @return
     */
    @RequestMapping(path = {"/disLike"}, method =RequestMethod.GET)
//    @ResponseBody
    public Map<String, Object> disLike(){
        Map<String, Object> map = new HashMap<String, Object>();
        String newId = getStr("newId");
        if (newId==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_606);
            map.put(Constants.MSG, Constants.ERROR_MSG_606);
            return map;
        }
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        String account = member2DTO.getAccount();
        //在likeKey对应的集合中加入当前用户的id
        return informationApi.disLike(newId,account);

    }

    /**
     * 获得点赞总数和是否已经点赞
     * @return
     */
    @RequestMapping(path = {"/getIsLike"}, method =RequestMethod.GET)
//    @ResponseBody
    public Map<String, Object> getIsLike(){
        Map<String, Object> map = new HashMap<String, Object>();
        String newId = getStr("newId");
        if (newId==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_606);
            map.put(Constants.MSG, Constants.ERROR_MSG_606);
            return map;
        }
        String account =null;
        Member2DTO member2DTO = checkLogin();
        if(member2DTO!=null){
            account = member2DTO.getAccount();
        }
        return informationApi.getIsLike(newId,account);
    }






    /**
     * 根据typeId获取资讯
     * @return
     */
    @RequestMapping(value = "/getNewsByTypeId",method = RequestMethod.GET)
    @ResponseBody
    public Result getNewsByTypeId(){
        int pageSize = getInt("pageSize", 6);
        int typeId = getInt("typeId");
        Result result = informationApi.getNewsByTypeId(typeId,pageSize);
        return result;
    }

    /**
     * 最新公告
     * @return
     */
    @RequestMapping(path = "/getLastestNews", method = RequestMethod.GET)
    @ResponseBody
    public Result getLastestNews(){
        Result result = informationApi.getLatestNews();
        return result;
    }

    /**
     * 篮球足球资讯
     * @return
     */
    @RequestMapping(path = "/getBasketBallAndFootBallNews", method = RequestMethod.GET)
    @ResponseBody
    public Result getBasketBallAndFootBallNews(){
        Result result = informationApi.getBasketBallAndFootBallNews();
        return result;
    }

    /**
     * 资讯详情
     * @return
     */
    @RequestMapping(path = "/getNewsDetailById", method = RequestMethod.GET)
    @ResponseBody
    public Result getNewsDetailById(){
        String id = getStr("id");
        Result result = informationApi.getNewsDetailById(id);
        return result;
    }

    /**
     * 找出双色球、大乐透、排列3、排列5最后开奖彩期
     * @return
     */
    @RequestMapping(path = "/getOpenResultByLotteryType", method = RequestMethod.GET)
    @ResponseBody
    public Result getOpenResult(){
        Result result = informationApi.getOpenResult();
        return result;
    }


    /**
     * 获取最新篮球开奖
     * @return
     */
    @RequestMapping(path = "/getBasketBallOpenResult", method = RequestMethod.GET)
    @ResponseBody
    public Result getBasketBallOpenResult(){
        String pageSize = getStr("pageSize");
        Result result = informationApi.getBasketBallOpenResult(pageSize);
        return result;
    }

    /**
     * 获取最新足球开奖
     * @return
     */
    @RequestMapping(path = "/getFootBallOpenResult",method = RequestMethod.GET)
    @ResponseBody
    public Result getFootBallOpenResult(){
        String pageSize = getStr("pageSize");
        Result result = informationApi.getFootBallOpenResult(pageSize);
        return result;
    }

    /**
     * 获取数字彩开奖信息
     * @return
     */
    @RequestMapping(path = "/getDigitalColor", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getDigitalColor(){
        Integer type = getInt("type", 0);
        Map<String, Object> lottery = informationApi.getDigitalColor(type);
        return lottery;
    }

    /**
     * 获取某个类型某一期的开奖
     * @return
     */
    @RequestMapping(path = "/getOneDigitalColor", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getOneDigitalColor(){
        Map<String, Object> map = new HashMap<String, Object>();
        int type = getInt("type",0);
        if(type==0){
            map.put(Constants.CODE, Constants.ERROR_CODE_612);
            map.put(Constants.MSG, Constants.ERROR_MSG_612);
            return map;
        }
        String term = getStr("term");
        if(term==""||term.length()==0){
            map.put(Constants.CODE, Constants.ERROR_CODE_613);
            map.put(Constants.MSG, Constants.ERROR_MSG_613);
            return map;
        }
        map = informationApi.getOneDigitalColor(type,term);
        return map;
    }


    /**
     * 获取高频彩开奖信息
     * @return
     */
    @RequestMapping(path = "/getFrequencyColor", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getFrequencyColor(){
        Integer type = getInt("type", 0);
        Map<String, Object> lottery = informationApi.getFrequencyColor(type);
        return lottery;
    }

    /**
     * 获取竞技彩开奖信息
     * @return
     */
    @RequestMapping(path = "/getSportsColor",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getSportsColor(){
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> sportsColor = informationApi.getSportsColor();
        return sportsColor;
    }

    /**
     * 获取某一期竞彩足球开奖
     * @return
     */
    @RequestMapping(path = "/getOneFootBallColor",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getOneFootBallColor(){
        int intTime = getInt("intTime", 0);
        Map<String, Object> footBallColor = informationApi.getOneFootBallColor(intTime);
        return footBallColor;
    }

    /**
     * 获取某一期竞彩篮球开奖
     * @return
     */
    @RequestMapping(path = "/getOneBasketBallColor",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getOneBasketBallColor(){
        int intTime = getInt("intTime", 0);
        Map<String, Object> basketBallColor = informationApi.getOneBasketBallColor(intTime);
        return basketBallColor;
    }

    /**
     * 获取最新十期的期数
     * @return
     */
    @RequestMapping(path = "/getTen",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getTen(){
        Map<String, Object> map = new HashMap<String, Object>();
        int Type = getInt("type", 0);
        if(Type==0){
            map.put(Constants.CODE, Constants.ERROR_CODE_612);
            map.put(Constants.MSG, Constants.ERROR_MSG_612);
            return map;
        }
        map = informationApi.getTen(Type);
        return map;
    }


    /**
     * 获得超级大神信息
     * @return
     */
    @RequestMapping(value = "/getMember2InfoForCelebrity",method = RequestMethod.GET)
    @ResponseBody
    public Result  getMemberInfoForCelebrity(){
//        Result result = informationApi.getMember2InfoForCelebrity();

//        return  result;
        return null;
    }
    
    @RequestMapping(value = "/addMail",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object>  addMail() {
        Map<String, Object> map = new HashMap<String, Object>();
//        Mail mail = JSONObject.parseObject(maill, new Mail().getClass());
//        String title = request.getParameter("title");
//        String title = getStr("title");
        String title = request.getParameter("title");
//        String content = request.getParameter("content");
//        String content = getStr("content");
        String content = request.getParameter("content");
        Integer type = getInteger("type");
//        String target = getStr("target");
        String target = request.getParameter("target");
//        Integer type = mail.getType();
//        String target = mail.getTarget();
        String author = request.getParameter("author");
//        String author = mail.getAuthor();
//        Integer status = mail.getStatus();
        Integer status = getInteger("status");
        Map<String,Object> mapParams= informationApi.addMail(title,content,type,target,author,status);
        return mapParams;
    }

    @RequestMapping(value = "/getNewMail",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object>  getNewMail() {
        Map<String, Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        return informationApi.getNewMail(member2DTO);
    }
}
