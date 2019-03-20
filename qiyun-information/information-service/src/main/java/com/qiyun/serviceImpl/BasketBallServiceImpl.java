package com.qiyun.serviceImpl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.common.Result;
import com.qiyun.dto.BasketBallMatch2DTO;
import com.qiyun.mapper2.*;
import com.qiyun.model2.*;
import com.qiyun.model2.BasketBallMatch2Query.Criteria;
import com.qiyun.service.BasketBallService;
import com.qiyun.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BasketBallServiceImpl implements BasketBallService {

    private static Logger logger = LoggerFactory.getLogger(BasketBallServiceImpl.class);

    @Resource
    private BasketBallMatch2Mapper basketBallMatch2Mapper;

    @Autowired
    private SportteryBasketMatchMapper basketMatchMapper;

    @Autowired
    private FootballTeam2Mapper footballTeam2Mapper;

    @Autowired
    private BasketballTeam2Mapper basketballTeam2Mapper;

    @Autowired
    private BasketballScheduleResultMapper basketballScheduleResultMapper;

    @Autowired
    private FootballLeagueMapper footballLeagueMapper;

    @Autowired
    private BasketballLeagueMapper basketballLeagueMapper;

    public Result getBasketBallOpenResult(String pageSize) {
        try {

            Result result = new Result();

            BasketBallMatch2Query basketBallMatch2Query = new BasketBallMatch2Query();
            Criteria criteria = basketBallMatch2Query.createCriteria();
            criteria.andBfWholeIsNotNull();
            basketBallMatch2Query.setOrderByClause("match_time DESC");
            PageHelper.startPage(1,Integer.parseInt(pageSize));

            List<BasketBallMatch2> basketBallMatch2s = basketBallMatch2Mapper.selectByExample(basketBallMatch2Query);
            List<BasketBallMatch2DTO> basketBallMatch2DTOs = new ArrayList<BasketBallMatch2DTO>();

            if (basketBallMatch2s==null){
                result.setSuccess(true);
                return result;
            }
            for (BasketBallMatch2 basketBallMatch2 : basketBallMatch2s) {
                BasketBallMatch2DTO basketBallMatch2DTO = new BasketBallMatch2DTO();
                CopyUtils.Copy(basketBallMatch2DTO,basketBallMatch2,true);
                basketBallMatch2DTO.setWeekStr(DateUtils.week[basketBallMatch2DTO.getMatchTime().getDay()]);
                basketBallMatch2DTOs.add(basketBallMatch2DTO);
            }


            result.setSuccess(true);
            result.setData(basketBallMatch2DTOs);

            return result;
        }catch (Exception e){
            logger.error("获取篮球最新开奖出错",e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("获取篮球最新开奖出错");
            return result;
        }
    }

    public Map<String, Object> getOneBasketBallColor(int intTime) {
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            int date = 0;
            List<SportteryBasketMatch> sportteryBasketBallMatchs = new ArrayList<SportteryBasketMatch>();
            if(intTime==0) {
                date = DateUtil.getIntTime();
                sportteryBasketBallMatchs =  basketMatchMapper.getOneBasketBallColor(date);
            } else {
                date = intTime;
                sportteryBasketBallMatchs =  basketMatchMapper.getOneBasketBallColor2(date);
            }
            for (SportteryBasketMatch sportteryBasketMatch:sportteryBasketBallMatchs) {
                Integer ZF = sportteryBasketMatch.getHomescore();
                Integer KF = sportteryBasketMatch.getGuestscore();
                Double DXF = sportteryBasketMatch.getBasebigorsmall();
                Double RF = sportteryBasketMatch.getHandicap();
                boolean ZS =true; //标记：默认主胜
                boolean IS =false; //是否有数据
                Integer FC = 0; //分差
                String XQ = sportteryBasketMatch.getInttime()+"";
                if(ZF!=null&&KF!=null){
                    IS = true;
                    if(ZF>KF){
                        sportteryBasketMatch.setSF("主胜");
                    }else if(ZF<KF){
                        sportteryBasketMatch.setSF("客胜");
                        ZS = false;
                    }
                }
                if(ZF!=null&&KF!=null&&DXF!=null){
                    if(ZF+KF>DXF){
                        sportteryBasketMatch.setDXF("大分");
                    }else{
                        sportteryBasketMatch.setDXF("小分");
                    }
                    if(ZF+RF>KF){
                        sportteryBasketMatch.setRFSF("让分主胜");
                    }else{
                        sportteryBasketMatch.setRFSF("让分客胜");
                    }
                }
                if(IS){
                    if(ZS){
                        FC = ZF-KF;
                        if(FC>=1&&FC<=5){
                            sportteryBasketMatch.setSFC("主胜1-5");
                        }else if(FC>=6&&FC<=10){
                            sportteryBasketMatch.setSFC("主胜6-10");
                        }else if(FC>=11&&FC<=15){
                            sportteryBasketMatch.setSFC("主胜11-15");
                        }else if(FC>=16&&FC<=20){
                            sportteryBasketMatch.setSFC("主胜16-20");
                        }else if(FC>=21&&FC<=25){
                            sportteryBasketMatch.setSFC("主胜21-25");
                        }else if(FC>=26){
                            sportteryBasketMatch.setSFC("主胜26+");
                        }
                    }else{
                        FC = KF-ZF;
                        if(FC>=1&&FC<=5){
                            sportteryBasketMatch.setSFC("客胜1-5");
                        }else if(FC>=6&&FC<=10){
                            sportteryBasketMatch.setSFC("客胜6-10");
                        }else if(FC>=11&&FC<=15){
                            sportteryBasketMatch.setSFC("客胜11-15");
                        }else if(FC>=16&&FC<=20){
                            sportteryBasketMatch.setSFC("客胜16-20");
                        }else if(FC>=21&&FC<=25){
                            sportteryBasketMatch.setSFC("客胜21-25");
                        }else if(FC>=26){
                            sportteryBasketMatch.setSFC("客胜26+");
                        }
                    }
                }

                Date date1 = DateUtil.StringToDate(XQ);
                int weekOfDate = DateUtil.getWeekOfDate(date1);
                switch (weekOfDate){
                    case 1:
                        sportteryBasketMatch.setXQ("周一");
                        break;
                    case 2:
                        sportteryBasketMatch.setXQ("周二");
                        break;
                    case 3:
                        sportteryBasketMatch.setXQ("周三");
                        break;
                    case 4:
                        sportteryBasketMatch.setXQ("周四");
                        break;
                    case 5:
                        sportteryBasketMatch.setXQ("周五");
                        break;
                    case 6:
                        sportteryBasketMatch.setXQ("周六");
                        break;
                    case 7:
                        sportteryBasketMatch.setXQ("周日");
                        break;
                }
            }
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,sportteryBasketBallMatchs);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取竞彩足球出错");
            return map;
        }

    }

    public Map<String, Object> getBaskballScheduleResult(String date,int offset,int pageSize) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            PageHelper.startPage(offset,pageSize);
            Date date1 = DateUtil.StringToDate6(date);
            String s1 = DateUtil.dateToString7(date1);
            String s = DateUtil.simplify3(s1);
            List<BasketballScheduleResult> basketballScheduleResults = basketballScheduleResultMapper.getScheduleResultByDate(s);
            for (BasketballScheduleResult basketballScheduleResult:basketballScheduleResults) {
                String leagueId = basketballScheduleResult.getLeagueId();
                BasketballLeague basketballLeague = basketballLeagueMapper.selectByPrimaryKey(StringUtil.String2Integer(leagueId));
                basketballScheduleResult.setLeague2(basketballLeague);
                String homeId = basketballScheduleResult.getHomeId();
                BasketballTeam2 home2 = basketballTeam2Mapper.selectByPrimaryKey(StringUtil.String2Integer(homeId));
                basketballScheduleResult.setHome2(home2);
                String awayId = basketballScheduleResult.getAwayId();
                BasketballTeam2 away2 = basketballTeam2Mapper.selectByPrimaryKey(StringUtil.String2Integer(awayId));
                basketballScheduleResult.setAway2(away2);
                String time = basketballScheduleResult.getTime();
                Date date2 = DateUtil.StringToDate3(time);
                String s2 = DateUtil.dateToString5(date2);
                basketballScheduleResult.setTime2(s2);
                basketballScheduleResult.setState2(StringUtil.String2Integer(basketballScheduleResult.getState()));
            }
            PageInfo pageInfo=new PageInfo(basketballScheduleResults);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,pageInfo);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取篮球赛程赛果出错");
            return map;
        }
    }
}
