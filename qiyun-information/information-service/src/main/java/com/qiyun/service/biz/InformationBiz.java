package com.qiyun.service.biz;

import com.qiyun.api.InformationApi;
import com.qiyun.common.Result;
import com.qiyun.dto.*;
import com.qiyun.httpUtil.RedisUtil;
import com.qiyun.mapper2.MailMapper;
import com.qiyun.mapper2.Member2Mapper;
import com.qiyun.model2.*;
import com.qiyun.service.*;
//import com.qiyun.util.HttpUtil;
import com.qiyun.httpUtil.HttpUtil;
import com.qiyun.serviceImpl.BasketballLeagueServiceImpl;
import com.qiyun.serviceImpl.BasketballTeamServiceImpl;
import com.qiyun.serviceImpl.FootballLeagueServiceImpl;
import com.qiyun.serviceImpl.FootballTeamServiceImpl;
import com.qiyun.util.NumberTools;
import com.qiyun.util.DateUtil;
import com.qiyun.util.StringUtil;
import com.qiyun.util.XmlDom4jUtil;
import javafx.scene.chart.PieChart;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.qiyun.util.Constants;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;


import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("informationApi")
public class InformationBiz implements InformationApi {

    @Resource
    private SZ2C1Service sz2C1Service;

    @Resource
    private DayOneDanService dayOneDanService;

    @Resource
    private CmsService cmsService;

    @Resource
    private LotteryTermService lotteryTermService;

    @Resource
    private BasketBallService basketBallService;

    @Resource
    private FootBallService footBallService;

    @Resource
    private CelebrityService celebrityService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private Member2Mapper member2Mapper;

    @Autowired
    private MailMapper mailMapper;

    @Autowired
    private ScoreLiveService scoreLiveService;
    
    @Autowired
    private BasketballTeamServiceImpl basketballTeamService;

    @Autowired
    private FootballTeamServiceImpl footballTeamService;

    @Autowired
    private BasketballLeagueServiceImpl basketballLeagueService;


    public String delZRHtml(String html){
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式
        String str2="";
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(html);
        html=m_html.replaceAll(" "); //过滤html标签
        String[] split = html.split("    ");
        for (String str:split
                ) {
            String replace = str.replace("  ", ",");
            str2 = str2+replace+";";
        }
//        for(int i=0;i<html.length();i++){
//            if(html.charAt(i)>=48 && html.charAt(i)<=57){
//                if(i!=0){
//                    if(html.charAt(i-1)>=48 && html.charAt(i-1)<=57){
//                        str2+=html.charAt(i);
//                    }else {
//                        str2=str2+ ","+html.charAt(i);
//                    }
//                }else {
//                    str2=str2+ ","+html.charAt(i);
//                }
//            }else {
//                str2+=html.charAt(i);
//            }
//        }
        String replace = str2.replace(" ", "");
        return replace.substring(1,replace.length()-2);
    }


    public String delSTHtml(String html){
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式
        String str2="";
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(html);
        html=m_html.replaceAll(" "); //过滤html标签
        String[] split = html.split("    ");
        for (String str:split
                ) {
            String replace = str.replace("  ", ",");
            str2 = str2+replace+";";
        }
        System.out.println(str2);
        return(str2.substring(1,str2.length()-2));
    }

    public String delWJHtml(String html){
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式
        String str2="";
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(html);
        html=m_html.replaceAll(""); //过滤html标签
        for(int i=0;i<html.length();i++){
            if(html.charAt(i)>=48 && html.charAt(i)<=57){
                if(i!=0){
                    if(html.charAt(i-1)>=48 && html.charAt(i-1)<=57){
                        str2+=html.charAt(i);
                    }else {
                        str2=str2+ ","+html.charAt(i);
                    }
                }else {
                    str2=str2+ ","+html.charAt(i);
                }
            }else {
                str2+=html.charAt(i);
            }
        }
//        String replace = html.replace(" ", ",");
        String replace = str2.replace(" ", "");
        return replace;
    }

    public Map<String, Object> getBasketballLineup(String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BasketballLineup byId2 = basketballLeagueService.getById2(StringUtil.String2Integer(id));
            if(byId2==null){
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "该比赛暂无简报");
                return map;
            }
            String homeLineupGb = byId2.getHomeLineupGb();
            String homeLineupGb2 = delZRHtml(homeLineupGb);
            byId2.setHomeLineupGb2(homeLineupGb2);   //主队主选阵容
            String awayLineupGb = byId2.getAwayLineupGb();
            String awayLineupGb2 = delZRHtml(awayLineupGb);
            byId2.setAwayLineupGb2(awayLineupGb2);   //客队备选阵容
            String homeBackupGb = byId2.getHomeBackupGb();
            String homeBackupGb2 = delZRHtml(homeBackupGb);
            byId2.setHomeBackupGb2(homeBackupGb2);   //主队备选阵容
            String awayBackupGb = byId2.getAwayBackupGb();
            String awayBackupGb2 = delZRHtml(awayBackupGb);
            byId2.setAwayBackupGb2(awayBackupGb2);   //客队备选阵容
            String injuryGb = byId2.getInjuryGb();
            String injuryGb2 = delSTHtml(injuryGb);
            byId2.setInjuryGb2(injuryGb2);
            String vsGb = byId2.getVsGb();
            String vsGb2 = delWJHtml(vsGb);
            byId2.setVsGb2(vsGb2);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,byId2);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取篮球比赛简报出错");
            return map;
        }
    }

    public Map<String, Object> getInformation() {
        return cmsService.getInformation();
    }

    public Map<String, Object> getFootballMatch(int offset, int pageSize,int type){
        return scoreLiveService.getFootballMatch(offset,pageSize,type);
    }

    public Map<String, Object> getNowTimeBasketballScore() {
        Map<String, Object> map = new HashMap<String, Object>();
        Jedis jedis = RedisUtil.getJedis();
        try {
            String s1 = jedis.get("NowTimeBasketballScoreTime");
            String s2 = jedis.get("NowTimeBasketballScore");
            long nd = 1000 * 24 * 60 * 60;
            long nh = 1000 * 60 * 60;
            long nm = 1000 * 60;
            long ns = 1000;
            if(s1!=null){
                long diff = new Date().getTime() - DateUtil.StringToDate1(s1).getTime();
                long sec = diff % nd % nh % nm / ns;
                if(sec>10){
                    String s = HttpUtil.get("http://interface.win007.com/lq/change.xml","");
                    jedis.set("NowTimeBasketballScoreTime",DateUtil.dateToString(new Date()));
                    jedis.set("NowTimeBasketballScore",s);
                    List<ScoreliveBasketBallNowTimeDTO> basketballballNowTime = scoreLiveService.getBasketballballNowTime(s);
                    if(basketballballNowTime==null){
                        map.put(Constants.CODE, Constants.ERROR_CODE_634);
                        map.put(Constants.MSG, Constants.ERROR_MSG_634);
                        return map;
                    }
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    map.put(Constants.DATA,basketballballNowTime);
                    return map;
                }else{
                    List<ScoreliveBasketBallNowTimeDTO> basketballballNowTime = scoreLiveService.getBasketballballNowTime(s2);
                    if(basketballballNowTime==null){
                        map.put(Constants.CODE, Constants.ERROR_CODE_634);
                        map.put(Constants.MSG, Constants.ERROR_MSG_634);
                        return map;
                    }
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    map.put(Constants.DATA,basketballballNowTime);
                    return map;
                }
            }else{
                String s = HttpUtil.get("http://interface.win007.com/lq/change.xml","");
                jedis.set("NowTimeBasketballScoreTime",DateUtil.dateToString(new Date()));
                jedis.set("NowTimeBasketballScore",s);
                List<ScoreliveBasketBallNowTimeDTO> basketballballNowTime = scoreLiveService.getBasketballballNowTime(s);
                if(basketballballNowTime==null){
                    map.put(Constants.CODE, Constants.ERROR_CODE_634);
                    map.put(Constants.MSG, Constants.ERROR_MSG_634);
                    return map;
                }
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put(Constants.DATA,basketballballNowTime);
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取即时篮球比赛比分数据出错");
            return map;
        }finally {
            jedis.close();
        }
    }

    public Map<String, Object> getBasketballTeam(String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        String[] split = id.split(",");
        List<BasketballTeam2> basketballTeam2s = new ArrayList<BasketballTeam2>();
        for (String str:split
             ) {
            Integer integer = StringUtil.String2Integer(str);
            BasketballTeam2 byId = basketballTeamService.getById(integer);
            basketballTeam2s.add(byId);
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA,basketballTeam2s);
        return map;
    }

    public Map<String, Object> getFootballTeam(String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        String[] split = id.split(",");
        List<FootballTeam2> footballTeam2s = new ArrayList<FootballTeam2>();
        for (String str:split
                ) {
            Integer integer = StringUtil.String2Integer(str);
            FootballTeam2 byId = footballTeamService.getById(integer);
            footballTeam2s.add(byId);
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA,footballTeam2s);
        return map;
    }

    public Map<String, Object> getBaskballScheduleResult(String date,int offset,int pageSize) {
        return basketBallService.getBaskballScheduleResult(date,offset,pageSize);
    }

    public Map<String, Object> getFootballScheduleResult(String date,int offset,int pageSize) {
        return footBallService.getFootballScheduleResult(date,offset,pageSize);
    }

    @Test
    public void test() throws ParseException {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
//        Collections.reverse(list);
        for (String i:list) {
            System.out.println(i);
        }
    }

    public Map<String, Object> getBasketballRank(String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        String[] split = id.split(",");
        List<BasketballTeamRank>basketballTeamRanks = new ArrayList<BasketballTeamRank>();
        for (String str:split) {
            BasketballTeamRank basketballRankById = basketballTeamService.getBasketballRankById(str);
            basketballTeamRanks.add(basketballRankById);
        }
        for (BasketballTeamRank basketballTeamRank:basketballTeamRanks) {
            String homeLoss = basketballTeamRank.getHomeLoss();
            String homeWin = basketballTeamRank.getHomeWin();
            Integer ihomeLoss = StringUtil.String2Integer(homeLoss);
            Integer ihomeWin = StringUtil.String2Integer(homeWin);
            int num = ihomeLoss + ihomeWin;
            if(num!=0){
                double v = ihomeWin / (num * 1.0);
                BigDecimal b = new BigDecimal(v);
                double v1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                String s = v1 + "";

                String substring = s.substring(2);
                if(substring.length()==1){
                    substring= substring+"0";
                }

                basketballTeamRank.setZsl(substring +"%");
            }else{
                basketballTeamRank.setZsl("0%");
            }
            basketballTeamRank.setZcc(num);  //主队场次
            basketballTeamRank.setZsf(homeWin+"-"+homeLoss);
            String awayLoss = basketballTeamRank.getAwayLoss();
            String awayWin = basketballTeamRank.getAwayWin();
            Integer iawayLoss = StringUtil.String2Integer(awayLoss);
            Integer iawayWin = StringUtil.String2Integer(awayWin);
            int num2 = iawayLoss + iawayWin;
            if(num!=0) {
                double vv = iawayWin / (num2 * 1.0);
                BigDecimal b = new BigDecimal(vv);
                double vv1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                double vv2 = vv1 * 100;
                String s = vv1 + "";
                String substring = s.substring(2);
                if(substring.length()==1){
                    substring= substring+"0";
                }
                basketballTeamRank.setKsl(substring + "%");
            }else {
                basketballTeamRank.setKsl("0%");
            }
            basketballTeamRank.setKcc(num2);  //客队场次
            basketballTeamRank.setKsf(awayWin+"-"+awayLoss);
            String homeOrder = basketballTeamRank.getHomeOrder();
            basketballTeamRank.setZpm(StringUtil.String2Integer(homeOrder));
            String awayOrder = basketballTeamRank.getAwayOrder();
            basketballTeamRank.setKpm(StringUtil.String2Integer(awayOrder));
            String homeScore = basketballTeamRank.getHomeScore();
            String homeLossScore = basketballTeamRank.getHomeLossScore();
            basketballTeamRank.setZds(homeScore+"/"+homeLossScore); //主队得失
            String awayScore = basketballTeamRank.getAwayScore();
            String awayLossScore = basketballTeamRank.getAwayLossScore();
            basketballTeamRank.setKds(awayScore+"/"+awayLossScore); //客队得失
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA,basketballTeamRanks);
        return map;
    }


    public Map<String, Object> getBasketballLiveCount(String id){
        Map<String, Object> map = new HashMap<String, Object>();
        Jedis jedis = RedisUtil.getJedis();
        int count =0;
        int count2 =0;
        try {
            String s = jedis.get("BasketballLiveScore"+id);
            if(s.equals("")||s==null){
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "暂无数据");
                return map;
            }
            String[] split = s.split("\\$");  //篮球小节数组s
            for (String str:split) {
                String[] split1 = str.split("\\!");   //篮球记录数组
                for (String strr:split1) {
                    String[] split2 = strr.split("\\^");//每个字段数组
                    for (String strrr:split2
                         ) {
                        count++;
                    }
                }
            }
            String ss= HttpUtil.get("http://interface.win007.com/lq/TextLive.aspx","ID="+id);
            if(ss.equals("")||ss==null){
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "暂无数据");
                return map;
            }
            String[] splitt = ss.split("\\$");  //篮球小节数组s
            for (String str:splitt) {
                String[] splitt1 = str.split("\\!");   //篮球记录数组
                for (String strr:splitt1) {
                    String[] splitt2 = strr.split("\\^");//每个字段数组
                    for (String strrr:splitt2
                            ) {
                        count2++;
                    }
                }
            }
            if(count2>count){
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, 1);  //有新消息
                return map;
            }else {
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, 0);  //没有新消息
                return map;
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取即时篮球直播条数出错");
            return map;
        }finally {
            jedis.close();
        }
    }

    public Map<String, Object> getBasketballLive(String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        Jedis jedis = RedisUtil.getJedis();
        try {
            String s1 = jedis.get("BasketballLiveTime"+id);
            String s2 = jedis.get("BasketballLiveScore"+id);
            long nd = 1000 * 24 * 60 * 60;
            long nh = 1000 * 60 * 60;
            long nm = 1000 * 60;
            long ns = 1000;
            if(s1!=null){
                long diff = new Date().getTime() - DateUtil.StringToDate1(s1).getTime();
                long sec = diff/1000;
                if(sec>1){
                    String s = HttpUtil.get("http://interface.win007.com/lq/TextLive.aspx","ID="+id);
                    if(s.equals("暂无数据")){
                        map.put(Constants.CODE, Constants.SUCCESS_CODE);
                        map.put(Constants.MSG, Constants.SUCCESS_MSG);
                        map.put(Constants.DATA,s);
                        return map;
                    }
                    jedis.set("BasketballLiveTime"+id,DateUtil.dateToString(new Date()));
                    jedis.set("BasketballLiveScore"+id,s);
                    List<BasketballLiveExplain0> footballNowTime = scoreLiveService.getBasketballLive(s);
//                    List<BasketballLiveExplain0> footballNowTime = scoreLiveService.getBasketballLive(xml);
                    if(footballNowTime==null){
                        map.put(Constants.CODE, Constants.ERROR_CODE_634);
                        map.put(Constants.MSG, Constants.ERROR_MSG_634);
                        return map;
                    }
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    map.put(Constants.DATA,footballNowTime);
                    return map;
                }else{
                    List<BasketballLiveExplain0> footballNowTime = scoreLiveService.getBasketballLive(s2);
//                    List<BasketballLiveExplain0> footballNowTime = scoreLiveService.getBasketballLive(xml);
                    if(footballNowTime==null){
                        map.put(Constants.CODE, Constants.ERROR_CODE_634);
                        map.put(Constants.MSG, Constants.ERROR_MSG_634);
                        return map;
                    }
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    map.put(Constants.DATA,footballNowTime);
                    return map;
                }
            }else{
                String s = HttpUtil.get("http://interface.win007.com/lq/TextLive.aspx","ID="+id);
                if(s.equals("暂无数据")){
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    map.put(Constants.DATA,s);
                    return map;
                }
                jedis.set("BasketballLiveTime"+id,DateUtil.dateToString(new Date()));
                jedis.set("BasketballLiveScore"+id,s);
                List<BasketballLiveExplain0> footballNowTime = scoreLiveService.getBasketballLive(s);
                if(footballNowTime==null){
                    map.put(Constants.CODE, Constants.ERROR_CODE_634);
                    map.put(Constants.MSG, Constants.ERROR_MSG_634);
                    return map;
                }
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put(Constants.DATA,footballNowTime);
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取即时足球比赛比分数据出错");
            return map;
        }finally {
            jedis.close();
        }
    }

    public Map<String, Object> getFootballLive(String id) {
        return scoreLiveService.getFootballLive(id);
    }

    public Map<String, Object> getNowTimeFootaballScore() {
        Map<String, Object> map = new HashMap<String, Object>();
        Jedis jedis = RedisUtil.getJedis();
        try {
            String s1 = jedis.get("NowTimeFootaballScoreTime");
            String s2 = jedis.get("NowTimeFootaballScore");
            long nd = 1000 * 24 * 60 * 60;
            long nh = 1000 * 60 * 60;
            long nm = 1000 * 60;
            long ns = 1000;
            if(s1!=null){
                long diff = new Date().getTime() - DateUtil.StringToDate1(s1).getTime();
                long sec = diff / 1000;
                if(sec>10){
                    String s = HttpUtil.get("http://interface.win007.com/zq/change.xml","");
                    jedis.set("NowTimeFootaballScoreTime",DateUtil.dateToString(new Date()));
                    jedis.set("NowTimeFootaballScore",s);
                    List<ScoreliveFootballNowTimeDTO> footballNowTime = scoreLiveService.getFootballNowTime(s);
                    if(footballNowTime==null){
                        map.put(Constants.CODE, Constants.ERROR_CODE_634);
                        map.put(Constants.MSG, Constants.ERROR_MSG_634);
                        return map;
                    }
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    map.put(Constants.DATA,footballNowTime);
                    return map;
                }else{
                    List<ScoreliveFootballNowTimeDTO> footballNowTime = scoreLiveService.getFootballNowTime(s2);
                    if(footballNowTime==null){
                        map.put(Constants.CODE, Constants.ERROR_CODE_634);
                        map.put(Constants.MSG, Constants.ERROR_MSG_634);
                        return map;
                    }
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    map.put(Constants.DATA,footballNowTime);
                    return map;
                }
            }else{
                String s = HttpUtil.get("http://interface.win007.com/zq/change.xml","");
                jedis.set("NowTimeFootaballScoreTime",DateUtil.dateToString(new Date()));
                jedis.set("NowTimeFootaballScore",s);
                List<ScoreliveFootballNowTimeDTO> footballNowTime = scoreLiveService.getFootballNowTime(s);
                if(footballNowTime==null){
                    map.put(Constants.CODE, Constants.ERROR_CODE_634);
                    map.put(Constants.MSG, Constants.ERROR_MSG_634);
                    return map;
                }
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put(Constants.DATA,footballNowTime);
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取即时足球比赛比分数据出错");
            return map;
        }finally {
            jedis.close();
        }
    }

    public Map<String, Object> getNowDayBasketballScore(int offset,int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        Jedis jedis = RedisUtil.getJedis();
        try {
            String s1 = jedis.get("NowDayBasketballScoreTime");
            String s2 = jedis.get("NowDayBasketballScore");
            List<ScoreliveBasketBallNowDayDTO> basketballballNowDays =new ArrayList<ScoreliveBasketBallNowDayDTO>();
            long nd = 1000 * 24 * 60 * 60;
            long nh = 1000 * 60 * 60;
            long nm = 1000 * 60;
            long ns = 1000;
            Date date = new Date();
            String time2 = DateUtil.dateToString6(date);
            String time = DateUtil.dateToString5(date);
            int weekOfDate = DateUtil.getWeekOfDate(date);
            String week = null;
            switch (weekOfDate) {
                case 1:
                    week = "周一";
                    break;
                case 2:
                    week = "周二";
                    break;
                case 3:
                    week = "周三";
                    break;
                case 4:
                    week = "周四";
                    break;
                case 5:
                    week = "周五";
                    break;
                case 6:
                    week = "周六";
                    break;
                case 7:
                    week = "周日";
                    break;
            }
                if (s1 != null) {
                    long diff = new Date().getTime() - DateUtil.StringToDate1(s1).getTime();
                    long sec = diff/1000;
                    if (sec > 60) {
                    String s = HttpUtil.get("http://interface.win007.com/lq/today.aspx","");
                    jedis.set("NowDayBasketballScoreTime",DateUtil.dateToString(new Date()));
                    jedis.set("NowDayBasketballScore",s);
//                        List<ScoreliveBasketBallNowDayDTO> basketballballNowDays = scoreLiveService.getBasketballballNowDay(s,offset,pageSize);
                        Map<String, Object> basketballballNowDay = scoreLiveService.getBasketballballNowDay(s, offset, pageSize);
                        Object data = basketballballNowDay.get("data");
                        Object size = basketballballNowDay.get("size");
//                        for (int i=0;i<pageSize;i++){
//                            basketballballNowDays.add(basketballballNowDay.get((pageSize*offset)+i));
//                        }
                        map.put(Constants.CODE, Constants.SUCCESS_CODE);
                        map.put(Constants.MSG, Constants.SUCCESS_MSG);
                        map.put(Constants.DATA, data);
                        map.put("week", week);
                        map.put("time", time2);
                        map.put("total",size);
                        return map;
                    } else {
//                        List<ScoreliveBasketBallNowDayDTO> basketballballNowDay = scoreLiveService.getBasketballballNowDay(s2);
                        Map<String, Object> basketballballNowDay = scoreLiveService.getBasketballballNowDay(s2, offset, pageSize);
                        Object data = basketballballNowDay.get("data");
                        Object size = basketballballNowDay.get("size");
                        map.put(Constants.CODE, Constants.SUCCESS_CODE);
                        map.put(Constants.MSG, Constants.SUCCESS_MSG);
                        map.put(Constants.DATA, data);
                        map.put("week", week);
                        map.put("time", time2);
                        map.put("total",size);
                        return map;
                    }
                } else {
                    String s = HttpUtil.get("http://interface.win007.com/lq/today.aspx", "");
                    jedis.set("NowDayBasketballScoreTime", DateUtil.dateToString(new Date()));
                    jedis.set("NowDayBasketballScore", s);
//                    List<ScoreliveBasketBallNowDayDTO> basketballballNowDay = scoreLiveService.getBasketballballNowDay(s);
                    Map<String, Object> basketballballNowDay = scoreLiveService.getBasketballballNowDay(s, offset, pageSize);
                    Object data = basketballballNowDay.get("data");
                    Object size = basketballballNowDay.get("size");
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    map.put(Constants.DATA, data);
                    map.put("week", week);
                    map.put("time", time2);
                    map.put("total",size);
                    return map;
                }
            } catch(Exception e){
                e.printStackTrace();
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "获取当天篮球比赛比分数据出错");
                return map;
            }finally {
                jedis.close();
            }
        }

    public Map<String, Object> getNowDayFootaballScore(String language,int offset,int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        Jedis jedis = RedisUtil.getJedis();
        List<ScoreliveFootballNowDayDTO> footballNowDays = new ArrayList<ScoreliveFootballNowDayDTO>();
        try {
            if(language!=""){
                language = "language="+ language;
            }
            String s1 = jedis.get("NowDayFootaballScoreTime");
            String s2 = jedis.get("NowDayFootaballScore");
            long nd = 1000 * 24 * 60 * 60;
            long nh = 1000 * 60 * 60;
            long nm = 1000 * 60;
            long ns = 1000;
            Date date = new Date();
            long time1 = date.getTime();
            String time2 =DateUtil.dateToString6(date);
            String time = DateUtil.dateToString5(date);
            int weekOfDate = DateUtil.getWeekOfDate(date);
            String week = null;
            switch (weekOfDate){
                case 1:
                    week = "周一";
                    break;
                case 2:
                    week = "周二";
                    break;
                case 3:
                    week = "周三";
                    break;
                case 4:
                    week = "周四";
                    break;
                case 5:
                    week = "周五";
                    break;
                case 6:
                    week = "周六";
                    break;
                case 7:
                    week = "周日";
                    break;
            }
            if(s1!=null){
                long diff = new Date().getTime() - DateUtil.StringToDate1(s1).getTime();
//                long sec = diff % nd % nh % nm / ns;
                long sec = diff / 1000;
                if(sec>60){
                    String s = HttpUtil.get("http://interface.win007.com/zq/today.aspx", language);
                    jedis.set("NowDayFootaballScoreTime",DateUtil.dateToString(new Date()));
                    jedis.set("NowDayFootaballScore",s);
//                    List<ScoreliveFootballNowDayDTO> footballNowDay = scoreLiveService.getFootballNowDay(s);
                    Map<String, Object> footballNowDay1 = scoreLiveService.getFootballNowDay(s, offset, pageSize);
                    Object data = footballNowDay1.get("data");
                    Object size = footballNowDay1.get("size");
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    map.put(Constants.DATA,data);
                    map.put("week",week);
                    map.put("time",time2);
                    map.put("total",size);
                    return map;
                }else{
//                    List<ScoreliveFootballNowDayDTO> footballNowDay = scoreLiveService.getFootballNowDay(s2);
                    Map<String, Object> footballNowDay1 = scoreLiveService.getFootballNowDay(s2, offset, pageSize);
                    Object data = footballNowDay1.get("data");
                    Object size = footballNowDay1.get("size");
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    map.put(Constants.DATA,data);
                    map.put("week",week);
                    map.put("time",time2);
                    map.put("total",size);
                    return map;
                }
            }else{
                String s = HttpUtil.get("http://interface.win007.com/zq/today.aspx", language);
                jedis.set("NowDayFootaballScoreTime",DateUtil.dateToString(new Date()));
                jedis.set("NowDayFootaballScore",s);
//                List<ScoreliveFootballNowDayDTO> footballNowDay = scoreLiveService.getFootballNowDay(s);
                Map<String, Object> footballNowDay1 = scoreLiveService.getFootballNowDay(s, offset, pageSize);
                Object data = footballNowDay1.get("data");
                Object size = footballNowDay1.get("size");
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put(Constants.DATA,data);
                map.put("week",week);
                map.put("time",time2);
                map.put("total",size);
                return map;
            }
        } catch (Exception e) {
                e.printStackTrace();
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "获取当天足球比赛比分数据出错");
                return map;
        }finally {
            jedis.close();
        }
    }

    public Map<String, Object> getPromotionCommentList(Integer planNo, String account, int offset, int pageSize, int sort) {
        return commentService.getPromotionCommentList(planNo,account,offset,pageSize,sort);
    }

    public Map<String, Object> likePromotionComment(Integer commentId,String account) {
        return commentService.likePromotionComment(commentId,account);
    }

    public Map<String, Object> promotionComment(Integer planNo, String account, String connect) {
        return commentService.promotionComment(planNo,account,connect);
    }

    public Map<String, Object> getUnread(String account) {
        return commentService.getUnread(account);
    }

    public Map<String, Object> getLikeWIinCount(String account,Integer planNo){
        return commentService.getLikeWIinCount(account,planNo);
    }

    public Map<String, Object> likeWinPromotion(String account, Integer planNo){
        return commentService.likeWinPromotion(account,planNo);
    }

    public Map<String, Object> getLikePlanCount(String account,Integer planNo){
        return commentService.getLikePlanCount(account,planNo);
    }

    public Map<String, Object> likeLotteryPlan(String account, Integer planNo) {
        return commentService.likeLotteryPlan(account,planNo);
    }

    /**
     * 评论点赞
     * @param commentId
     * @return
     */
    public Map<String, Object> likeComment(Integer commentId,String account) {
        return commentService.likeComment(commentId,account);
    }

    /**
     * 回复评论
     * @param commentId
     * @param account
     * @param connect
     * @return
     */
    public Map<String, Object> replyComment(Integer commentId, String account, String connect) {
        return commentService.replyComment(commentId,account,connect);
    }

    /**
     * 获取评论列表
     * @param planNo
     * @param account
     * @return
     */
    public Map<String, Object> getCommentList(Integer planNo, String account,int offset, int pageSize,int sort) {
        return commentService.getCommentList(planNo,account,offset,pageSize,sort);
    }

    /**
     * 发表评论
     * @param planNo
     * @param account
     * @param connect
     * @return
     */
    public Map<String, Object> comment(Integer planNo, String account, String connect) {
        return commentService.comment(planNo,account,connect);
    }

    /**
     * 按照彩种找出最后开奖彩期
     * @return
     */
    public Result getOpenResult() {
        return lotteryTermService.getOpenResult();
    }

    public Result getBasketBallOpenResult(String pageSize) {
        return basketBallService.getBasketBallOpenResult(pageSize);
    }

    public Result getFootBallOpenResult(String pageSize) {
        return footBallService.getFootBallOpenResult(pageSize);
    }

    public Result getNewsDetailById(String id) {
        return cmsService.getNewsDetailById(id);
    }

    public Result getLatestNews() {
        return cmsService.getLatestNews();
    }

    public Result getBasketBallAndFootBallNews() {
        return cmsService.getBasketBallAndFootBallNews();
    }

    public Result getNewsByTypeId(int typeId, int pageSize) {
        return cmsService.getNewsByTypeId(typeId,pageSize);
    }

    public Map<String, Object> getDayOneDanByNumber(int number) {
        return dayOneDanService.getDayOneDanByNumber(number);
    }



    public Result getSZ2C1ByNumber(int number) {
        return sz2C1Service.getSZ2C1ByNumber(number);
    }

    public Result  getMemberInfoForCelebrity() { return celebrityService.getMemberInfoForCelebrity(); }

    public Map<String, Object> like(String hostHolder, String account) {

        return dayOneDanService.like(hostHolder,account);
    }

    public Map<String, Object> disLike(String hostHolder, String account) {

        return dayOneDanService.disLike(hostHolder,account);
    }

    public Map<String, Object> getIsLike(String hostHolder, String account) {

        return dayOneDanService.getIsLike(hostHolder,account);
    }

    public Map<String, Object> getDigitalColor(int type){
        return lotteryTermService.getDigitalColor(type);
    }
    public Map<String, Object> getFrequencyColor(int type){
        return lotteryTermService.getFrequencyColor(type);
    }

    public Map<String, Object> getSportsColor(){
        return lotteryTermService.getSportsColor();
    }

    public Map<String, Object> getOneFootBallColor(int intTime){
        return footBallService.getOneFootBallColor(intTime);
    }

    public Map<String, Object> getOneBasketBallColor(int intTime){
        return basketBallService.getOneBasketBallColor(intTime);
    }

    public Map<String, Object> getTen(int intTime){
        return lotteryTermService.getTen(intTime);
    }

    public Map<String, Object> getOneDigitalColor(int type,String term){
        return lotteryTermService.getOneDigitalColor(type,term);
    }


    public Map<String,Object> getNewMail(Member2DTO member2DTO){
        Map<String, Object> map = new HashMap<String, Object>();
        Jedis jedis = RedisUtil.getJedis();
        try {
            String account = member2DTO.getAccount();
            Integer isWhitelist = member2DTO.getIsWhitelist();
            Boolean newmail1 = true;
            Boolean newmail2 = true;
            Boolean newmail3 = false;
            Boolean exists1 = jedis.exists("newmail1"); //判断所有人看过集合是否存在
            if(exists1){ //存在针对所有人看过的集合
                newmail1 = jedis.sismember("newmail1", account);    //判断这个人是否看过针对所有人的新消息
                    if(!newmail1){   //如果没有看过消息
                        map.put(Constants.CODE, Constants.SUCCESS_CODE);
                        map.put(Constants.MSG, Constants.SUCCESS_MSG);
                        map.put("newMail",1);
                        return map;
                    }
            }else{
                MailExample mailExample = new MailExample();
                mailExample.createCriteria().andStatusEqualTo(1).andTypeEqualTo(1);
                List<Mail> mail = mailMapper.selectByExample(mailExample);
                if(mail.size()!=0){
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    map.put("newMail",1);
                    return map;
                }
            }
            if(isWhitelist==0){
                Boolean exists2 = jedis.exists("newmail2"); //判断白名单看过集合是否存在
                if(exists2){
                    newmail2 = jedis.sismember("newmail2", account);    //判断这个人是否看过针对白名单的新消息
                    if(!newmail2){
                        map.put(Constants.CODE, Constants.SUCCESS_CODE);
                        map.put(Constants.MSG, Constants.SUCCESS_MSG);
                        map.put("newMail",1);
                        return map;
                    }
                }else {
                    MailExample mailExample = new MailExample();
                    mailExample.createCriteria().andStatusEqualTo(1).andTypeEqualTo(2);
                    List<Mail> mail = mailMapper.selectByExample(mailExample);
                    if(mail.size()!=0){
                        map.put(Constants.CODE, Constants.SUCCESS_CODE);
                        map.put(Constants.MSG, Constants.SUCCESS_MSG);
                        map.put("newMail",1);
                        return map;
                    }
                }
            }
            Boolean exists3 = jedis.exists("newmail3"); //判断指定人看过集合是否存在
            if(exists3){
                newmail3 = jedis.sismember("newmail3", account);    //判断这个人是否有针对指定人的新消息
                if(newmail3){   //和前俩个不一样，如果存在指定人
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    map.put("newMail",1);
                    return map;
                }
            }
            if(newmail1&&newmail2&&!newmail3){
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put("newMail",0);
                return map;
            }else {
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put("newMail",0);
                return map;
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取最新消息出错");
            return map;
        }finally {
            jedis.close();
        }
    }

    public Map<String, Object> addMail(String title,String content,int type,String target,String author,int status) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        Jedis jedis = RedisUtil.getJedis();
        try {
            switch (type){
                case 1:
                    jedis.del("newmail1");  //删除已读人的名单
                    break;
                case 2:
                    jedis.del("newmail2");  //删除已读人的名单
                    break;
                case 3:
                    String[] split = target.split(",");
                    //将指定的人设置到redis中的未读名单
                    for (String str:split) {
                        jedis.sadd("newmail3",str);
                    }
                    break;
                default:
                    resMap.put(Constants.CODE, Constants.ERROR_CODE_626);
                    resMap.put(Constants.MSG, Constants.ERROR_MSG_626);
            }
            int i = cmsService.addMail(title,content,type,target,author,status);
            if (i > 0) {
                resMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                resMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            } else {
                resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                resMap.put(Constants.MSG, "添加失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            resMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);
        }finally {
            jedis.close();
            return resMap;
        }
    }


}
