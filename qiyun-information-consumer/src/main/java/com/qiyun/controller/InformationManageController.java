package com.qiyun.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.qiyun.api.InformationApi;
import com.qiyun.api.InformationManageApi;
import com.qiyun.common.Result;
import com.qiyun.controller.base.BaseController;
import com.qiyun.dto.*;
import com.qiyun.model2.News;
import com.qiyun.model2.Permission;
import com.qiyun.util.DateUtil;
import com.qiyun.util.FileUpload;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import com.qiyun.util.Constants;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/information")
public class InformationManageController extends BaseController {

    @Resource
    private InformationApi informationApi;

    @Resource
    private InformationManageApi informationManageApi;

    @RequestMapping(value = "/getSpSourse", method = RequestMethod.GET)
    public Map<String, Object> getSpSourse() {
        Map<String, Object> map = new HashMap<String, Object>();
        return informationManageApi.getSpSourse();
    }

    @RequestMapping(value = "/reviseSpSourse", method = RequestMethod.GET)
    public Map<String, Object> reviseSpSourse() {
        Map<String, Object> map = new HashMap<String, Object>();
        int sourse = getInt("sourse", 0);
        if(sourse == 0){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationManageApi.reviseSpSourse(sourse);
    }


    @RequestMapping(value = "/getMailList", method = RequestMethod.GET)
    public Map<String, Object> getMailList() {
        int type = getInt("type", -1);
        int status = getInt("status", -1);
        return informationManageApi.getMailList(type,status);
    }


    @RequestMapping(value = "/getUnreviewedWinCommentList", method = RequestMethod.GET)
    public Map<String, Object> getUnreviewedWinCommentList() {
        int offset = getInt("offset", 1);
        int pageSize = getInt("pageSize", 10);
        int id = getInt("id", 0);
        int type = getInt("type",-1);
        return informationManageApi.getUnreviewedWinCommentList(offset,pageSize,id,type);
    }

    @RequestMapping(value = "/shWinComment", method = RequestMethod.GET)
    public Map<String, Object> shWinComment() {
        Map<String, Object> map = new HashMap<String, Object>();
//        Integer cid = getInteger("cid");
        String cid = getStr("cid");
        Integer type = getInteger("type");
        if(cid == null||type == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationManageApi.shWinComment(cid,type);
    }

    @RequestMapping(value = "/getUnreviewedCommentList", method = RequestMethod.GET)
    public Map<String, Object> getUnreviewedCommentList() {
        int offset = getInt("offset", 1);
        int pageSize = getInt("pageSize", 10);
        int id = getInt("id", 0);
        int type = getInt("type", -1);
        return informationManageApi.getUnreviewedCommentList(offset,pageSize,id,type);
    }

    @RequestMapping(value = "/shComment", method = RequestMethod.GET)
    public Map<String, Object> shComment() {
        Map<String, Object> map = new HashMap<String, Object>();
//        Integer cid = getInteger("cid");
        String cid = getStr("cid");
        Integer type = getInteger("type");
        if(cid == null||type == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationManageApi.shComment(cid,type);
    }

    @RequestMapping(value = "/shSZ2C1", method = RequestMethod.GET)
    public Map<String, Object> shSZ2C1() {
        Map<String, Object> map = new HashMap<String, Object>();
        String sid = getStr("sid");
        if (sid == null||sid.equals("")) {
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationManageApi.shSZ2C1(sid);
    }

    @RequestMapping(value = "/bhSZ2C1", method = RequestMethod.GET)
    public Map<String, Object> bhSZ2C1() {
        Map<String, Object> map = new HashMap<String, Object>();
        String sid = getStr("sid");
        if (sid == null||sid.equals("")) {
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationManageApi.bhSZ2C1(sid);
    }

    @RequestMapping(value = "/shDOD", method = RequestMethod.GET)
    public Map<String, Object> shDOD() {
        Map<String, Object> map = new HashMap<String, Object>();
        String sid = getStr("sid");
        if (sid == null||sid.equals("")) {
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationManageApi.shDOD(sid);
    }

    @RequestMapping(value = "/bhDOD", method = RequestMethod.GET)
    public Map<String, Object> bhDOD() {
        Map<String, Object> map = new HashMap<String, Object>();
        String sid = getStr("sid");
        if (sid == null||sid.equals("")) {
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationManageApi.bhDOD(sid);
    }

    @RequestMapping(value = "/setPL", method = RequestMethod.GET)
    public Map<String, Object> setPL() {
        Map<String, Object> map = new HashMap<String, Object>();
        int type = getInt("type", 0);
        if (type == 0) {
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        String result = getStr("result");
        String term = getStr("term");
        return informationManageApi.setPL(type,result,term);
    }

    @RequestMapping(value = "/getTypes", method = RequestMethod.GET)
    public Map<String, Object> getTypes() {
        Map<String, Object> map = new HashMap<String, Object>();
        int type = getInt("type", 0);
        if (type == 0) {
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationManageApi.getTypes(type);
    }

    /**
     * 根据id获取资讯
     * @return
     */
    @RequestMapping(value = "/getNew", method = RequestMethod.GET)
    public Map<String, Object> getNew() {
        Map<String, Object> map = new HashMap<String, Object>();
        int id = getInt("id",0);
        if(id==0){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationManageApi.getNew(id);
    }

    /**
     * 获取资讯列表
     * @return
     */
    @RequestMapping(value = "/getNewsList", method = RequestMethod.GET)
    public Map<String, Object> getNewsList() {
        int page = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        String type = getStr("type");
        String label = getStr("label");
        String startTime = getStr("startTime");
        String endTime = getStr("endTime");
        String title = getStr("title");
        return informationManageApi.getNewsList(page,pageSize,type,label,startTime,endTime,title);
    }

    //为新闻资讯设置图片
    @RequestMapping(value = "/setNewsPicetur",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> setNewsPicetur(MultipartFile file) {
        Map<String, Object> map = new HashMap<String, Object>();
        int id = getInt("id", 1);
        if(file == null||id==0){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        String s = FileUpload.upLoad(file,"info/");
        return informationManageApi.setNewsPicetur(s,id);
    }

    /**
     * 修改咨询
     * @return
     */
    @RequestMapping(value = "/reviseNews", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> reviseNews(@RequestBody News params) {
        Map<String, Object> map = new HashMap<String, Object>();
        String type = params.getType();
        Integer click = params.getClick();
        Integer isShow = params.getIsShow();
        String title = params.getTitle();
        String shortTitle = params.getShortTitle();
        String keyword = params.getKeyword();
        Integer contentType = params.getContentType();
        String link = params.getLink();
        String content = params.getContent();
        Integer sort = params.getSort();
        String summary = params.getSummary();
        String label = params.getLabel();
        String editor = params.getEditor();
        Integer iid = params.getId();
        String id = iid+"";
        String picture = params.getPicture();
        if (id==null||type==null||title==null||keyword==null||contentType==null||summary==null||editor==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationManageApi.createNews(type,click,isShow,title,shortTitle,keyword,contentType,link,content,sort,summary,label,editor,2,id,picture);
    }

    /**
     * 发布咨询
     * @return
     */
    @RequestMapping(value = "/createNews", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createNews(@RequestBody News params) {
        System.out.println(params);
        Map<String, Object> map = new HashMap<String, Object>();
        String type = params.getType();
        Integer click = params.getClick();
        Integer isShow = params.getIsShow();
        String title = params.getTitle();
        String shortTitle = params.getShortTitle();
        String keyword = params.getKeyword();
        Integer contentType = params.getContentType();
        String link = params.getLink();
        String content = params.getContent();
        Integer sort = params.getSort();
        String summary = params.getSummary();
        String label = params.getLabel();
        String editor = params.getEditor();
        Integer iid = params.getId();
        String id = iid+"";
        String picture = getStr("picture");
        params.getPicture();
        if (type==null||title==null||keyword==null||contentType==null||summary==null||editor==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
//        if(cz == 2){  //当操作为修改时
//            if(id == null || id .equals("")){
//                map.put(Constants.CODE, Constants.ERROR_CODE_625);
//                map.put(Constants.MSG, Constants.ERROR_MSG_625);
//                return map;
//            }
//        }
        return informationManageApi.createNews(type,click,isShow,title,shortTitle,keyword,contentType,link,content,sort,summary,label,editor,1,id,picture);
    }


    /**
     * 修改资讯显示
     * @return
     */
    @RequestMapping(value = "/updateShow", method = RequestMethod.GET)
    public Map<String, Object> updateShow(){
        Map<String, Object> map = new HashMap<String, Object>();
        Integer id = getInteger("id");
        Integer type = getInteger("type");
        if(id==null||type==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_624);
            map.put(Constants.MSG, Constants.ERROR_MSG_624);
            return map;
        }
        return informationManageApi.updateShow(id,type);
    }

    /**
     * 新增实战二串一1
     * @return
     */
    @RequestMapping(value = "/createSZ2C11",method = RequestMethod.POST)
    public Map<String, Object> createSZ2C11() {
        Map<String, Object> map = new HashMap<String, Object>();
        //String matchId1 = sz2C1DTO.getMatchId1();
        String matchId1 = getStr("matchId1");
//        String homeTeam1 = sz2C1DTO.getHomeTeam1();
        String homeTeam1 = getStr("homeTeam1");
//        String guestTeam1 = sz2C1DTO.getGuestTeam1();
        String guestTeam1 = getStr("guestTeam1");
//        String recommend1 = sz2C1DTO.getRecommend1();
        String recommend1 = getStr("recommend1");
//        String matchId2 = sz2C1DTO.getMatchId2();
        String matchId2 = getStr("matchId2");
//        String homeTeam2 = sz2C1DTO.getHomeTeam2();
        String homeTeam2 = getStr("homeTeam2");
//        String guestTeam2 = sz2C1DTO.getGuestTeam2();
        String guestTeam2 = getStr("guestTeam2");
//        String recommend2 = sz2C1DTO.getRecommend2();
        String recommend2 = getStr("recommend2");
//        Integer multiple = sz2C1DTO.getMultiple();
        Integer multiple = getInteger("multiple");
//        Double amount = sz2C1DTO.getAmount();
        Double amount = getDouble("amount");
//        String bonus = sz2C1DTO.getBonus();
        String bonus = getStr("bonus");
//        String author = sz2C1DTO.getAuthor();
        String author = getStr("author");
        return informationManageApi.createSZ2C11(matchId1,homeTeam1,guestTeam1,recommend1,matchId2,
                homeTeam2,guestTeam2,recommend2,multiple,amount,bonus,author);
    }

    /**
     * 新增实战二串一2
     * @return
     */
    @RequestMapping(value = "/createSZ2C12",method = RequestMethod.POST)
    public Map<String, Object> createSZ2C12() {
        Map<String, Object> map = new HashMap<String, Object>();
//        SZ2C1DTO sz2C1DTO = JSONObject.parseObject(SZ2C1, new SZ2C1DTO().getClass());
//        String matchId1 = sz2C1DTO.getMatchId1();
        String matchId1 = getStr("matchId1");
//        String homeTeam1 = sz2C1DTO.getHomeTeam1();
        String homeTeam1 = getStr("homeTeam1");
//        String guestTeam1 = sz2C1DTO.getGuestTeam1();
        String guestTeam1 = getStr("guestTeam1");
//        String recommend1 = sz2C1DTO.getRecommend1();
        String recommend1 = getStr("recommend1");
//        String matchId2 = sz2C1DTO.getMatchId2();
        String matchId2 = getStr("matchId2");
//        String homeTeam2 = sz2C1DTO.getHomeTeam2();
        String homeTeam2 = getStr("homeTeam2");
//        String guestTeam2 = sz2C1DTO.getGuestTeam2();
        String guestTeam2 = getStr("guestTeam2");
//        String recommend2 = sz2C1DTO.getRecommend2();
        String recommend2 = getStr("recommend2");
//        Integer multiple = sz2C1DTO.getMultiple();
        Integer multiple = getInteger("multiple");
//        Double amount = sz2C1DTO.getAmount();
        Double amount = getDouble("amount");
//        String bonus = sz2C1DTO.getBonus();
        String bonus = getStr("bonus");
//        String author = sz2C1DTO.getAuthor();
        String author = getStr("author");
        return informationManageApi.createSZ2C12(matchId1,homeTeam1,guestTeam1,recommend1,matchId2,
                homeTeam2,guestTeam2,recommend2,multiple,amount,bonus,author);
    }
    /**
     * 新增每日俩单1
     * @return
     */
    @RequestMapping(value = "/createDayOneDan1",method = RequestMethod.POST)
    public Map<String, Object> createDayOneDan1() {
        Map<String, Object> map = new HashMap<String, Object>();
//        DayOneDan2DTO dayOneDan2DTO1 = JSONObject.parseObject(dayOneDan2DTO, new DayOneDan2DTO().getClass());
        String playType = getStr("playType");
//        String matchId = dayOneDan2DTO1.getMatchId();
        String matchId = getStr("matchId");
//        String homeTeam = dayOneDan2DTO1.getHomeTeam();
        String homeTeam = getStr("homeTeam");
//        String guestTeam = dayOneDan2DTO1.getGuestTeam();
        String guestTeam = getStr("guestTeam");
//        String recommend = dayOneDan2DTO1.getRecommend();
        String recommend = getStr("recommend");
//        Double sp = dayOneDan2DTO1.getSp();
        Double sp = getDouble("sp");
//        String analyze = dayOneDan2DTO1.getAnalyze();
        String analyze = getStr("analyze");
//        String author = dayOneDan2DTO1.getAuthor();
        String author = getStr("author");
//        String playType = (String) dayOneDan2DTO.get("playType");
//        String matchId = (String) dayOneDan2DTO.get("matchId");
//        String homeTeam = (String) dayOneDan2DTO.get("homeTeam");
//        String guestTeam = (String) dayOneDan2DTO.get("guestTeam");
//        String recommend = (String) dayOneDan2DTO.get("recommend");
//        Double sp = (Double) dayOneDan2DTO.get("sp");
//        String analyze = (String) dayOneDan2DTO.get("analyze");
//        String author = (String) dayOneDan2DTO.get("author");
        return informationManageApi.createDayOneDan1(playType,matchId,homeTeam,guestTeam,recommend,sp,analyze,author);
    }

    /**
     * 新增每日俩单2
     * @return
     */
    @RequestMapping(value = "/createDayOneDan2",method = RequestMethod.POST)
    public Map<String, Object> createDayOneDan2() {
        Map<String, Object> map = new HashMap<String, Object>();
//        DayOneDan2DTO dayOneDan2DTO1 = JSONObject.parseObject(dayOneDan2DTO, new DayOneDan2DTO().getClass());
//        String playType = dayOneDan2DTO1.getPlayType();
        String playType = getStr("playType");
//        String matchId = dayOneDan2DTO1.getMatchId();
        String matchId = getStr("matchId");
//        String homeTeam = dayOneDan2DTO1.getHomeTeam();
        String homeTeam = getStr("homeTeam");
//        String guestTeam = dayOneDan2DTO1.getGuestTeam();
        String guestTeam = getStr("guestTeam");
//        String recommend = dayOneDan2DTO1.getRecommend();
        String recommend = getStr("recommend");
//        Double sp = dayOneDan2DTO1.getSp();
        Double sp = getDouble("sp");
//        String analyze = dayOneDan2DTO1.getAnalyze();
        String analyze = getStr("analyze");
//        String author = dayOneDan2DTO1.getAuthor();
        String author = getStr("author");
        return informationManageApi.createDayOneDan2(playType,matchId,homeTeam,guestTeam,recommend,sp,analyze,author);
    }
}

