package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.common.Result;
import com.qiyun.dto.FootBallMatch2DTO;
import com.qiyun.mapper2.*;
import com.qiyun.model2.*;
import com.qiyun.model2.FootBallMatch2Query.Criteria;
import com.qiyun.service.FootBallService;
import com.qiyun.util.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class FootBallServiceImpl implements FootBallService {

    private static Logger logger = LoggerFactory.getLogger(FootBallServiceImpl.class);

    @Resource
    private FootBallMatch2Mapper footBallMatch2Mapper;

    @Autowired
    private SportteryFootballMatchMapper sportteryFootballMatchMapper;

    @Autowired
    private FootballScheduleResultMapper footballScheduleResultMapper;

    @Autowired
    private FootballTeam2Mapper footballTeam2Mapper;

    @Autowired
    private BasketballTeam2Mapper basketballTeam2Mapper;

    @Autowired
    private FootballLeagueMapper footballLeagueMapper;

    @Autowired
    private BasketballLeagueMapper basketballLeagueMapper;

    public Map<String, Object> getOneFootBallColor(int intTime) {
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            int date = 0;
            List<SportteryFootballMatch> sportteryFootballMatchs = new ArrayList<SportteryFootballMatch>();
            if(intTime==0) {
                date = DateUtil.getIntTime();
                sportteryFootballMatchs =  sportteryFootballMatchMapper.getOneFootBallColor(date);
            } else {
                date = intTime;
                sportteryFootballMatchs =  sportteryFootballMatchMapper.getOneFootBallColor2(date);
            }
            String mark = "";
            String hmark = "";
            String XQ ="";
            for (SportteryFootballMatch sportteryFootballMatch:sportteryFootballMatchs) {
                Integer ZF = sportteryFootballMatch.getHomescore(); //主队分数
                Integer KF = sportteryFootballMatch.getGuestscore(); //客队分数
                Integer hZF = sportteryFootballMatch.getHalfhomescore(); //半场主队分数
                Integer hKF = sportteryFootballMatch.getHalfguestscore(); //半场客队分数
                Integer RQ = sportteryFootballMatch.getConcede(); //让球数
                mark = "";
                hmark = "";
                XQ = sportteryFootballMatch.getInttime()+"";
                if(ZF!=null&&KF!=null){
                    if(ZF>KF){
                        sportteryFootballMatch.setSPF("主胜");
                        mark="胜";
                        if(ZF>=5||KF>=3) {
                            sportteryFootballMatch.setBF("胜其他");
                        }else
                            sportteryFootballMatch.setBF(ZF+":"+KF);
                    }else if(ZF==KF){
                        sportteryFootballMatch.setSPF("平");
                        mark="平";
                        if(ZF>=3) {
                            sportteryFootballMatch.setBF("平其他");
                        }else
                            sportteryFootballMatch.setBF(ZF+":"+KF);
                    }else if(ZF<KF){
                        sportteryFootballMatch.setSPF("客胜");
                        mark="负";
                        if(KF>=5||ZF>=3) {
                            sportteryFootballMatch.setBF("负其他");
                        } else
                            sportteryFootballMatch.setBF(ZF+":"+KF);
                    }
                }

                if(ZF!=null&&RQ!=null&&KF!=null){
                    if(ZF+RQ>KF){
                        sportteryFootballMatch.setRQSPF("主胜");
                    }else if(ZF+RQ==KF){
                        sportteryFootballMatch.setRQSPF("平");
                    }else if(ZF+RQ<KF){
                        sportteryFootballMatch.setRQSPF("客胜");
                    }
                    sportteryFootballMatch.setZJQ(ZF+KF+"球");
                }
                if(hZF!=null&&hKF!=null){
                    if(hZF>hKF){
                        hmark="胜";
                    }else if(hZF==hKF){
                        hmark="平";
                    }else if(hZF<hKF){
                        hmark="负";
                    }
                    sportteryFootballMatch.setBQC(mark+"-"+hmark);
                }
                if(XQ!=null){
                    Date date1 = DateUtil.StringToDate(XQ);
                    int weekOfDate = DateUtil.getWeekOfDate(date1);
                    switch (weekOfDate){
                        case 1:
                            sportteryFootballMatch.setXQ("周一");
                            break;
                        case 2:
                            sportteryFootballMatch.setXQ("周二");
                            break;
                        case 3:
                            sportteryFootballMatch.setXQ("周三");
                            break;
                        case 4:
                            sportteryFootballMatch.setXQ("周四");
                            break;
                        case 5:
                            sportteryFootballMatch.setXQ("周五");
                            break;
                        case 6:
                            sportteryFootballMatch.setXQ("周六");
                            break;
                        case 7:
                            sportteryFootballMatch.setXQ("周日");
                            break;
                        default:
                            sportteryFootballMatch.setXQ("未知");
                    }
                }
            }
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,sportteryFootballMatchs);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取竞彩足球出错");
            return map;
        }
    }


    @Test
    public void test(){
        List<String> strs = new ArrayList<String>();
        strs.add("哈哈"); strs.add("嘿嘿"); strs.add("嘻嘻");
        for (String s:strs
             ) {
            System.out.print(s+" ");
        }
        strs.remove("嘿嘿");
        strs.remove("没有");
        System.out.println();
        for (String s:strs
                ) {
            System.out.print(s+" ");
        }
    }


    public Map<String, Object> getFootballScheduleResult(String date,int offset,int pageSize) {
//        footballScheduleResultMapper
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            PageHelper.startPage(offset,pageSize);
            Date date1 = DateUtil.StringToDate6(date);
            String s1 = DateUtil.dateToString7(date1);
            String s = DateUtil.simplify3(s1);
//            Date date3 = DateUtil.StringToDate6(date);
//            String s3 = DateUtil.dateToStringg(date3);
//            Integer integer = StringUtil.String2Integer(s3);
            String ss = DateUtil.dateToString6(new Date());
            List<Integer> list = footballLeagueMapper.getNowDayLeague(ss);
            List<FootballScheduleResult> footballScheduleResults = footballScheduleResultMapper.getScheduleResultByDate(s);
            List<FootballScheduleResult> footballScheduleResults2 = new ArrayList<FootballScheduleResult>();
            for (FootballScheduleResult footballScheduleResult:footballScheduleResults) {
                String league = footballScheduleResult.getLeague();
                String[] split = league.split(",");
                String s4 = split[split.length - 2];
                if((list.contains(StringUtil.String2Integer(s4)))){
                    footballScheduleResults2.add(footballScheduleResult);
                }
            }
            int size = footballScheduleResults2.size();
            for (FootballScheduleResult footballScheduleResult:footballScheduleResults2) {
                String league = footballScheduleResult.getLeague();
                String[] split = league.split(",");
                FootballLeague footballLeague = footballLeagueMapper.selectByPrimaryKey(StringUtil.String2Integer(split[split.length - 2]));
                String home = footballScheduleResult.getHome();
                String[] split1 = home.split(",");
                FootballTeam2 home2 = footballTeam2Mapper.selectByPrimaryKey(StringUtil.String2Integer(split1[split1.length-1]));
                String away = footballScheduleResult.getAway();
                String[] split2 = away.split(",");
                FootballTeam2 away2 = footballTeam2Mapper.selectByPrimaryKey(StringUtil.String2Integer(split2[split2.length-1]));
                footballScheduleResult.setLeague2(footballLeague);
                footballScheduleResult.setHome2(home2);
                footballScheduleResult.setAway2(away2);
                String time = footballScheduleResult.getTime();
                Date date2 = DateUtil.StringToDate3(time);
                String s2 = DateUtil.dateToString5(date2);
                footballScheduleResult.setTime2(s2);
                footballScheduleResult.setState2(StringUtil.String2Integer(footballScheduleResult.getState()));
            }
            List<FootballScheduleResult> footballScheduleResults3 = new ArrayList<FootballScheduleResult>();
            if(offset*pageSize>size){   //最后一页
                offset -= 1;
                for (int i=0;i<size-(offset*pageSize);i++){
                    footballScheduleResults3.add(footballScheduleResults2.get((pageSize*offset)+i));
                }
            }else{      //不是最后一页
                offset -= 1;
                for (int i=0;i<pageSize;i++){
                    footballScheduleResults3.add(footballScheduleResults2.get((pageSize*offset)+i));
                }
            }
//            PageInfo pageInfo = new PageInfo(footballScheduleResults2);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,footballScheduleResults3);
            map.put("total",size);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取足球赛程赛果出错");
            return map;
        }
    }


    public Result getFootBallOpenResult(String pageSize) {
        try {
            Result result = new Result();
            FootBallMatch2Query footBallMatch2Query = new FootBallMatch2Query();
            Criteria criteria = footBallMatch2Query.createCriteria();
            criteria.andFinalHomeScoreIsNotNull();
            criteria.andFinalGuestScoreIsNotNull();
            PageHelper.startPage(1,Integer.parseInt(pageSize));
            footBallMatch2Query.setOrderByClause("match_time DESC");
            List<FootBallMatch2> footBallMatch2s = footBallMatch2Mapper.selectByExample(footBallMatch2Query);
            List<FootBallMatch2DTO> footBallMatch2DTOs = new ArrayList<FootBallMatch2DTO>();
            if (footBallMatch2s==null){
                result.setSuccess(true);
                return result;
            }

            for (FootBallMatch2 footBallMatch2 : footBallMatch2s) {
                FootBallMatch2DTO footBallMatch2DTO = new FootBallMatch2DTO();
                CopyUtils.Copy(footBallMatch2DTO,footBallMatch2,true);
                footBallMatch2DTO.setWeekStr(DateUtils.week[footBallMatch2DTO.getMatchTime().getDay()]);
                footBallMatch2DTOs.add(footBallMatch2DTO);
            }

            result.setData(footBallMatch2DTOs);
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            logger.error("获取足球最新开奖出错",e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("获取足球最新开奖出错");
            return result;
        }
    }

}
