package com.qiyun.serviceImpl;

import com.qiyun.mapper2.*;
import com.qiyun.model2.*;
import com.qiyun.util.BigDecimalUtil;
import com.qiyun.util.Constants;
import com.qiyun.util.DateUtil;
import com.qiyun.util.StringUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FootballSpServiceImpl {

    @Autowired
    private FootballLeagueMapper footballLeagueMapper;

    @Autowired
    private ConfigMapper configMapper;

    @Autowired
    private SportteryFootballBfawardMapper sportteryFootballBfawardMapper;  //比分

    @Autowired
    private SportteryFootballRqspfawardMapper sportteryFootballRqspfawardMapper;    //让球胜平负

    @Autowired
    private SportteryFootballBqcawardMapper sportteryFootballBqcawardMapper;   //半全场

    @Autowired
    private SportteryFootlballJqsawardMapper sportteryFootlballJqsawardMapper;  //进球

    @Autowired
    private SportteryFootballSpfawardMapper sportteryFootballSpfawardMapper;    //胜平负

    @Autowired
    private SportteryFootballMatchMapper sportteryFootballMatchMapper;


    @Test
    public void test() throws ParseException {
        String d = "9.25";
        Double dd = StringUtil.String2Double(d);
        System.out.println(dd==9.2);
    }


    public Map<String, Object> setSportteryFootballSpfSp(String ID,String MatchTime,String sf3,String sf1,String sf0){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            int passMode = 1;
            Date intTime = getIntTime(MatchTime);
            Integer lineid = getLineid(ID);
            SportteryFootballMatch matchByTime = sportteryFootballMatchMapper.getMatchByTime(intTime, lineid);
            if(matchByTime == null ){
                map.put(Constants.CODE, Constants.ERROR_CODE_638);
                map.put(Constants.MSG, Constants.ERROR_MSG_638);
                return map;
            }
            List<SportteryFootballSpfaward> sportteryFootballSpfawards = sportteryFootballSpfawardMapper.selectByMatchId(matchByTime.getId());
            Double sf3d = StringUtil.String2Double(sf3); Double sf1d = StringUtil.String2Double(sf1); Double sf0d = StringUtil.String2Double(sf0);
            SportteryFootballSpfaward sportteryFootballSpfaward = SportteryFootballSpfaward.builder().homewinaward(sf3d).guestwinaward(sf0d).drawaward(sf1d).matchid(matchByTime.getId()).inttime(matchByTime.getInttime()).lineid(lineid).matchtime(matchByTime.getMatchtime()).passmode(passMode).lastupdatetime(new Date()).build();
            if(sportteryFootballSpfawards == null || sportteryFootballSpfawards.size() == 0){
                sportteryFootballSpfaward.setCreateDate(new Date());
                sportteryFootballSpfaward.setHomechange(0);
                sportteryFootballSpfaward.setDrawchange(0);
                sportteryFootballSpfaward.setGuestchange(0);
                sportteryFootballSpfawardMapper.insertSelective(sportteryFootballSpfaward);
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                return map;
            }else{
                BigDecimal.valueOf(sf3d);
                SportteryFootballSpfaward sportteryFootballSpfaward1 = sportteryFootballSpfawardMapper.selectByLastUpdate(matchByTime.getId());
                if(!thanDouble(sportteryFootballSpfaward1.getHomewinaward(),sf3d)||!thanDouble(sportteryFootballSpfaward1.getGuestwinaward(),sf0d)||!thanDouble(sportteryFootballSpfaward1.getDrawaward(),sf1d)){
                    sportteryFootballSpfaward.setCreateDate(sportteryFootballSpfaward1.getCreateDate());
                    if(sportteryFootballSpfaward1.getHomewinaward()>sf3d){
                        sportteryFootballSpfaward.setHomechange(-1);
                    }else if(sportteryFootballSpfaward1.getHomewinaward()<sf3d){
                        sportteryFootballSpfaward.setHomechange(1);
                    }else {
                        sportteryFootballSpfaward.setHomechange(0);
                    }
                    if(sportteryFootballSpfaward1.getGuestwinaward()>sf0d){
                        sportteryFootballSpfaward.setGuestchange(-1);
                    }else if(sportteryFootballSpfaward1.getGuestwinaward()<sf0d){
                        sportteryFootballSpfaward.setGuestchange(1);
                    }else {
                        sportteryFootballSpfaward.setGuestchange(0);
                    }
                    if(sportteryFootballSpfaward1.getDrawaward()>sf1d){
                        sportteryFootballSpfaward.setDrawchange(-1);
                    }else if(sportteryFootballSpfaward1.getDrawaward()<sf1d){
                        sportteryFootballSpfaward.setDrawchange(1);
                    }else {
                        sportteryFootballSpfaward.setDrawchange(0);
                    }
                    sportteryFootballSpfawardMapper.insertSelective(sportteryFootballSpfaward);
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    return map;
                }else { //未更新SP
                    map.put(Constants.CODE, Constants.ERROR_CODE_637);
                    map.put(Constants.MSG, Constants.ERROR_MSG_637);
                    return map;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "更新竞彩足球进球SP出错");
            return map;
        }
    }

    public Map<String, Object> setSportteryFootballBqcSp(String ID,String MatchTime,String ht33,String ht31,String ht30,String ht13, String ht11,String ht10,String ht03,String ht01,String ht00){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            int passMode = 1;
            Date intTime = getIntTime(MatchTime);
            Integer lineid = getLineid(ID);
            SportteryFootballMatch matchByTime = sportteryFootballMatchMapper.getMatchByTime(intTime, lineid);
            if(matchByTime == null ){
                map.put(Constants.CODE, Constants.ERROR_CODE_638);
                map.put(Constants.MSG, Constants.ERROR_MSG_638);
                return map;
            }
            List<SportteryFootballBqcaward> sportteryFootballBqcawards = sportteryFootballBqcawardMapper.selectByMatchId(matchByTime.getId());
            Double ht33d = StringUtil.String2Double(ht33); Double ht31d = StringUtil.String2Double(ht31); Double ht30d = StringUtil.String2Double(ht30); Double ht13d = StringUtil.String2Double(ht13);
            Double ht11d = StringUtil.String2Double(ht11); Double ht10d = StringUtil.String2Double(ht10); Double ht03d = StringUtil.String2Double(ht03); Double ht01d = StringUtil.String2Double(ht01); Double ht00d = StringUtil.String2Double(ht00);
            SportteryFootballBqcaward sportteryFootballBqcaward = SportteryFootballBqcaward.builder().matchid(matchByTime.getId()).inttime(matchByTime.getInttime()).lineid(lineid).matchtime(matchByTime.getMatchtime()).passmode(passMode).lastupdatetime(new Date()).winWinAward(ht33d).winDrawAward(ht31d).winLoseAward(ht30d).drawWinAward(ht13d).drawDrawAward(ht11d).drawLoseAward(ht10d).loseWinAward(ht03d).loseDrawAward(ht01d).loseLoseAward(ht00d).build();
            if(sportteryFootballBqcawards == null || sportteryFootballBqcawards.size() == 0){
                sportteryFootballBqcaward.setCreateDate(new Date());
                sportteryFootballBqcawardMapper.insertSelective(sportteryFootballBqcaward);
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                return map;
            }else{
                SportteryFootballBqcaward  sportteryFootballBqcaward1= sportteryFootballBqcawardMapper.selectByLastUpdate(matchByTime.getId());
                if(!thanDouble(sportteryFootballBqcaward1.getWinWinAward(),ht33d)||!thanDouble(sportteryFootballBqcaward1.getWinDrawAward(),ht31d)||!thanDouble(sportteryFootballBqcaward1.getWinLoseAward(),ht30d)||!thanDouble(sportteryFootballBqcaward1.getDrawWinAward(),ht13d)||!thanDouble(sportteryFootballBqcaward1.getDrawDrawAward(),ht11d)||!thanDouble(sportteryFootballBqcaward1.getDrawLoseAward(),ht10d)||!thanDouble(sportteryFootballBqcaward1.getLoseWinAward(),ht03d)||!thanDouble(sportteryFootballBqcaward1.getLoseDrawAward(),ht01d)||!thanDouble(sportteryFootballBqcaward1.getLoseLoseAward(),ht00d)){
                    sportteryFootballBqcaward.setCreateDate(sportteryFootballBqcaward1.getCreateDate());
                    sportteryFootballBqcawardMapper.insertSelective(sportteryFootballBqcaward);
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    return map;
                }else { //未更新SP
                    map.put(Constants.CODE, Constants.ERROR_CODE_637);
                    map.put(Constants.MSG, Constants.ERROR_MSG_637);
                    return map;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "更新竞彩足球进球SP出错");
            return map;
        }
    }

    public Map<String, Object> setSportteryFootballJqSp(String ID,String MatchTime,String t0,String t1,String t2,String t3, String t4,String t5,String t6,String t7){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            int passMode = 1;
            Date intTime = getIntTime(MatchTime);
            Integer lineid = getLineid(ID);
            SportteryFootballMatch matchByTime = sportteryFootballMatchMapper.getMatchByTime(intTime, lineid);
            if(matchByTime == null ){
                map.put(Constants.CODE, Constants.ERROR_CODE_638);
                map.put(Constants.MSG, Constants.ERROR_MSG_638);
                return map;
            }
            List<SportteryFootlballJqsaward> sportteryFootlballJqsawards = sportteryFootlballJqsawardMapper.selectByMatchId(matchByTime.getId());
            Double t0d = StringUtil.String2Double(t0); Double t1d = StringUtil.String2Double(t1); Double t2d = StringUtil.String2Double(t2);
            Double t3d = StringUtil.String2Double(t3); Double t4d = StringUtil.String2Double(t4); Double t5d = StringUtil.String2Double(t5);
            Double t6d = StringUtil.String2Double(t6); Double t7d = StringUtil.String2Double(t7);
            SportteryFootlballJqsaward sportteryFootlballJqsaward = SportteryFootlballJqsaward.builder().matchid(matchByTime.getId()).inttime(matchByTime.getInttime()).lineid(lineid).matchtime(matchByTime.getMatchtime()).passmode(passMode).lastupdatetime(new Date())
                    .s0Award(t0d).s1Award(t1d).s2Award(t2d).s3Award(t3d).s4Award(t4d).s5Award(t5d).s6Award(t6d).s7Award(t7d).build();
            if(sportteryFootlballJqsawards == null || sportteryFootlballJqsawards.size() == 0){
                sportteryFootlballJqsaward.setCreateDate(new Date());
                sportteryFootlballJqsawardMapper.insertSelective(sportteryFootlballJqsaward);
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                return map;
            }else{
                SportteryFootlballJqsaward  sportteryFootlballJqsaward1= sportteryFootlballJqsawardMapper.selectByLastUpdate(matchByTime.getId());
                if(!thanDouble(sportteryFootlballJqsaward1.getS0Award(),t0d)||!thanDouble(sportteryFootlballJqsaward1.getS1Award(),t1d)||!thanDouble(sportteryFootlballJqsaward1.getS2Award(),t2d)||!thanDouble(sportteryFootlballJqsaward1.getS3Award(),t3d)||!thanDouble(sportteryFootlballJqsaward1.getS4Award(),t4d)||!thanDouble(sportteryFootlballJqsaward1.getS5Award(),t5d)||!thanDouble(sportteryFootlballJqsaward1.getS6Award(),t6d)||!thanDouble(sportteryFootlballJqsaward1.getS7Award(),t7d)){
                    sportteryFootlballJqsaward.setCreateDate(sportteryFootlballJqsaward1.getCreateDate());
                    sportteryFootlballJqsawardMapper.insertSelective(sportteryFootlballJqsaward);
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    return map;
                }else { //未更新SP
                    map.put(Constants.CODE, Constants.ERROR_CODE_637);
                    map.put(Constants.MSG, Constants.ERROR_MSG_637);
                    return map;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "更新竞彩足球进球SP出错");
            return map;
        }
    }

    public Map<String, Object> setSportteryFootballRqSp(String ID,String MatchTime,String goal,String rq3,String rq1,String rq0){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            int passMode = 1;
            Date intTime = getIntTime(MatchTime);
            Integer lineid = getLineid(ID);
            SportteryFootballMatch matchByTime = sportteryFootballMatchMapper.getMatchByTime(intTime, lineid);
            if(matchByTime == null ){
                map.put(Constants.CODE, Constants.ERROR_CODE_638);
                map.put(Constants.MSG, Constants.ERROR_MSG_638);
                return map;
            }
            Integer concede = matchByTime.getConcede();
            if(concede!=StringUtil.String2Integer(goal)){
                sportteryFootballMatchMapper.setConcede(matchByTime.getId(),concede);
            }
            List<SportteryFootballRqspfaward> sportteryFootballRqspfawards = sportteryFootballRqspfawardMapper.selectByMatchId(matchByTime.getId());
            Double rq3d = StringUtil.String2Double(rq3); Double rq1d = StringUtil.String2Double(rq1); Double rq0d = StringUtil.String2Double(rq0);
            SportteryFootballRqspfaward sportteryFootballRqspfaward = SportteryFootballRqspfaward.builder().homewinaward(rq3d).guestwinaward(rq0d).drawaward(rq1d).matchid(matchByTime.getId()).inttime(matchByTime.getInttime()).lineid(lineid).matchtime(matchByTime.getMatchtime()).passmode(passMode).lastupdatetime(new Date()).build();
            if(sportteryFootballRqspfawards == null || sportteryFootballRqspfawards.size() == 0){
                sportteryFootballRqspfaward.setCreateDate(new Date());
//                sportteryFootballRqspfaward.setLastupdatetime(new Date());
                sportteryFootballRqspfaward.setHomechange(0);
                sportteryFootballRqspfaward.setDrawchange(0);
                sportteryFootballRqspfaward.setGuestchange(0);
                sportteryFootballRqspfawardMapper.insertSelective(sportteryFootballRqspfaward);
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                return map;
            }else{
                SportteryFootballRqspfaward sportteryFootballRqspfaward1 = sportteryFootballRqspfawardMapper.selectByLastUpdate(matchByTime.getId());
//                if(sportteryFootballRqspfaward1.getHomewinaward()>h)
                if(!thanDouble(sportteryFootballRqspfaward1.getHomewinaward(),rq3d)||!thanDouble(sportteryFootballRqspfaward1.getGuestwinaward(),rq0d)||!thanDouble(sportteryFootballRqspfaward1.getDrawaward(),rq1d)){
                    sportteryFootballRqspfaward.setCreateDate(sportteryFootballRqspfaward1.getCreateDate());
                    if(sportteryFootballRqspfaward1.getHomewinaward()>rq3d){
                        sportteryFootballRqspfaward.setHomechange(-1);
                    }else if(sportteryFootballRqspfaward1.getHomewinaward()<rq3d){
                        sportteryFootballRqspfaward.setHomechange(1);
                    }else {
                        sportteryFootballRqspfaward.setHomechange(0);
                    }
                    if(sportteryFootballRqspfaward1.getGuestwinaward()>rq0d){
                        sportteryFootballRqspfaward.setGuestchange(-1);
                    }else if(sportteryFootballRqspfaward1.getGuestwinaward()<rq0d){
                        sportteryFootballRqspfaward.setGuestchange(1);
                    }else {
                        sportteryFootballRqspfaward.setGuestchange(0);
                    }
                    if(sportteryFootballRqspfaward1.getDrawaward()>rq1d){
                        sportteryFootballRqspfaward.setDrawchange(-1);
                    }else if(sportteryFootballRqspfaward1.getDrawaward()<rq1d){
                        sportteryFootballRqspfaward.setDrawchange(1);
                    }else {
                        sportteryFootballRqspfaward.setDrawchange(0);
                    }
                    sportteryFootballRqspfawardMapper.insertSelective(sportteryFootballRqspfaward);
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    return map;
                }else { //未更新SP
                    map.put(Constants.CODE, Constants.ERROR_CODE_637);
                    map.put(Constants.MSG, Constants.ERROR_MSG_637);
                    return map;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "更新竞彩足球让球SP出错");
            return map;
        }
    }

    public Map<String, Object> setSportteryFootballBfSp(String ID,String MatchTime,String sd00,String sl01,String sl02,String sl03,String sw10,String sd11,String sl12,String sl13,String sw20,String sw21,String sd22,String sl23,
                                                        String sw30,String sw31,String sw32,String sd33,String sw40,String sw41,String sw42,String sl04,String sl14,String sl24,String sw50,String sw51,String sw52,String sl05,
                                                        String sl15,String sl25,String sw5,String sd4,String sl5){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            int passMode = 1;
//            Date date = DateUtil.StringToDate3(MatchTime);
//            int intTime = DateUtil.getIntTime2(date);   //将比赛时间转化为int类型时间格式 eg:2018/9/5 18:00:00—> 20180905
            Date intTime = getIntTime(MatchTime);
//            String substring = ID.substring(2);
//            if(substring.substring(0,2).equals("00")){  //获取场次号 eg:周三001—>1
//                substring = substring.substring(2);
//            }else if(substring.substring(0,1).equals("0")){
//                substring = substring.substring(1);
//            }
//            Integer lineid = StringUtil.String2Integer(substring);
            Integer lineid = getLineid(ID);
            SportteryFootballMatch matchByTime = sportteryFootballMatchMapper.getMatchByTime(intTime, lineid);
            if(matchByTime == null ){
                map.put(Constants.CODE, Constants.ERROR_CODE_638);
                map.put(Constants.MSG, Constants.ERROR_MSG_638);
                return map;
            }
            List<SportteryFootballBfaward> sportteryFootballBfawards = sportteryFootballBfawardMapper.selectByMatchId(matchByTime.getId());
            Double sd00d = StringUtil.String2Double(sd00); Double sl01d = StringUtil.String2Double(sl01); Double sl02d = StringUtil.String2Double(sl02); Double sl03d = StringUtil.String2Double(sl03); Double sw10d = StringUtil.String2Double(sw10); Double sd11d = StringUtil.String2Double(sd11); Double sl12d = StringUtil.String2Double(sl12); Double sl13d = StringUtil.String2Double(sl13); Double sw20d = StringUtil.String2Double(sw20); Double sw21d = StringUtil.String2Double(sw21); Double sd22d = StringUtil.String2Double(sd22); Double sl23d = StringUtil.String2Double(sl23);
            Double sw30d = StringUtil.String2Double(sw30); Double sw31d = StringUtil.String2Double(sw31); Double sw32d = StringUtil.String2Double(sw32); Double sd33d = StringUtil.String2Double(sd33); Double sw40d = StringUtil.String2Double(sw40); Double sw41d = StringUtil.String2Double(sw41); Double sw42d = StringUtil.String2Double(sw42); Double sl04d = StringUtil.String2Double(sl04); Double sl14d = StringUtil.String2Double(sl14); Double sl24d = StringUtil.String2Double(sl24); Double sw50d = StringUtil.String2Double(sw50); Double sw51d = StringUtil.String2Double(sw51); Double sw52d = StringUtil.String2Double(sw52); Double sl05d = StringUtil.String2Double(sl05);
            Double sl15d = StringUtil.String2Double(sl15); Double sl25d = StringUtil.String2Double(sl25); Double sw5d = StringUtil.String2Double(sw5); Double sd4d = StringUtil.String2Double(sd4); Double sl5d = StringUtil.String2Double(sl5);
            SportteryFootballBfaward sportteryFootballBfaward = SportteryFootballBfaward.builder().matchid(matchByTime.getId()).inttime(matchByTime.getInttime()).lineid(lineid).matchtime(matchByTime.getMatchtime())
                    .passmode(passMode).lastupdatetime(new Date()).s00award(sd00d).s01award(sl01d).s02award(sl02d).s03award(sl03d).s10award(sw10d).s11award(sd11d).s12award(sl12d).s13award(sl13d).s20award(sw20d).s21award(sw21d).s22award(sd22d).s23award(sl23d)
                    .s30award(sw30d).s31award(sw31d).s32award(sw32d).s33award(sd33d).s40award(sw40d).s41award(sw41d).s42award(sw42d).s04award(sl04d).s14award(sl14d).s24award(sl24d).s50award(sw50d).s51award(sw51d).s52award(sw52d).s05award(sl05d)
                    .s15award(sl15d).s25award(sl25d).sWinAward(sw5d).sDrawAward(sd4d).sLoseAward(sl5d).build();
            if(sportteryFootballBfawards == null || sportteryFootballBfawards.size() == 0){
                sportteryFootballBfaward.setCreateDate(new Date());
//                sportteryFootballBfaward.setLastupdatetime(new Date());
                sportteryFootballBfawardMapper.insertSelective(sportteryFootballBfaward);
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                return map;
            }else{
                SportteryFootballBfaward sportteryFootballBfaward1 = sportteryFootballBfawardMapper.selectByLastUpdate(matchByTime.getId());
                if(!thanDouble(sportteryFootballBfaward1.getS00award(),sd00d)||!thanDouble(sportteryFootballBfaward1.getS01award(),sl01d)||!thanDouble(sportteryFootballBfaward1.getS02award(),sl02d)||!thanDouble(sportteryFootballBfaward1.getS03award(),sl03d)||!thanDouble(sportteryFootballBfaward1.getS10award(),sw10d)||!thanDouble(sportteryFootballBfaward1.getS11award(),sd11d)||!thanDouble(sportteryFootballBfaward1.getS12award(),sl12d)||!thanDouble(sportteryFootballBfaward1.getS13award(),sl13d)||!thanDouble(sportteryFootballBfaward1.getS20award(),sw20d)||!thanDouble(sportteryFootballBfaward1.getS21award(),sw21d)||!thanDouble(sportteryFootballBfaward1.getS22award(),sd22d)||!thanDouble(sportteryFootballBfaward1.getS23award(),sl23d)
                        ||!thanDouble(sportteryFootballBfaward1.getS30award(),sw30d)||!thanDouble(sportteryFootballBfaward1.getS31award(),sw31d)||!thanDouble(sportteryFootballBfaward1.getS32award(),sw32d)||!thanDouble(sportteryFootballBfaward1.getS33award(),sd33d)||!thanDouble(sportteryFootballBfaward1.getS40award(),sw40d)||!thanDouble(sportteryFootballBfaward1.getS41award(),sw41d)||!thanDouble(sportteryFootballBfaward1.getS42award(),sw42d)||!thanDouble(sportteryFootballBfaward1.getS04award(),sl04d)||!thanDouble(sportteryFootballBfaward1.getS14award(),sl14d)||!thanDouble(sportteryFootballBfaward1.getS24award(),sl24d)||!thanDouble(sportteryFootballBfaward1.getS50award(),sw50d)||!thanDouble(sportteryFootballBfaward1.getS51award(),sw51d)||!thanDouble(sportteryFootballBfaward1.getS52award(),sw52d)||!thanDouble(sportteryFootballBfaward1.getS05award(),sl05d)
                        ||!thanDouble(sportteryFootballBfaward1.getS15award(),sl15d)||!thanDouble(sportteryFootballBfaward1.getS25award(),sl25d)||!thanDouble(sportteryFootballBfaward1.getSWinAward(),sw5d)||!thanDouble(sportteryFootballBfaward1.getSDrawAward(),sd4d)||!thanDouble(sportteryFootballBfaward1.getSLoseAward(),sl5d)){
//                    sportteryFootballBfaward.setLastupdatetime(new Date());
                    sportteryFootballBfaward.setCreateDate(sportteryFootballBfaward1.getCreateDate());
                    sportteryFootballBfawardMapper.insertSelective(sportteryFootballBfaward);
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    return map;
                }else { //未更新SP
                    map.put(Constants.CODE, Constants.ERROR_CODE_637);
                    map.put(Constants.MSG, Constants.ERROR_MSG_637);
                    return map;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "更新竞彩足球比分SP出错");
            return map;
        }
    }

    public Config getConfigById(int id) {
        return configMapper.selectByPrimaryKey(id);
    }

    public int getSpSourse(){
        return configMapper.getSpSourse();
    }

    public int reviseSpSourse(int id){
        return configMapper.reviseSpSourse(id);
    }

//    @Test
    public Date getIntTime(String time) throws ParseException {//将比赛时间转化为int类型时间格式 eg:2018/9/5 18:00:00—> 20180905
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date parse = format.parse(time);
        return parse;
    }

    public Integer getLineid(String slineid){//获取场次号 eg:周三001—>1
        String substring = slineid.substring(2);
        if(substring.substring(0,2).equals("00")){
            substring = substring.substring(2);
        }else if(substring.substring(0,1).equals("0")){
            substring = substring.substring(1);
        }
        Integer lineid = StringUtil.String2Integer(substring);
        return lineid;
    }

    //判断俩个double类型的数是否相同
    public boolean thanDouble(Double a, Double b){
        BigDecimal ad = BigDecimal.valueOf(a);
        BigDecimal bd = BigDecimal.valueOf(b);
        int i = ad.compareTo(bd);
        if(i==0){
            return true;
        }else {
            return false;
        }
    }
}
