package com.qiyun.task;


import com.qiyun.httpUtil.HttpUtil;
import com.qiyun.model2.FootballScheduleResult;
import com.qiyun.serviceImpl.ScheduleResultServiceImpl;
import com.qiyun.util.LogUtil;
import com.qiyun.util.StringUtil;
import com.qiyun.util.XmlDom4jUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@Lazy(value=false)
public class FootballScheduleResultTask {

    @Autowired
    private ScheduleResultServiceImpl scheduleResultService;

//        @Scheduled(cron = "0 30 4 0/1 * ?")//每天的3.30执行
//            @Scheduled(cron = "0/10 * * * ?")//每隔10秒处理一次
//    @Scheduled(cron = "0 0 0/2 * * ?")//每天的13.00执行
    public void getFootballSchedule(){      //每天获取一次足球球队赛程信息
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            for (int i =0 ;i<8;i++) {   //查询今天和七天后的赛程
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DAY_OF_YEAR, i);
                Date time = cal.getTime();
                String format = sf.format(time);
                String s = HttpUtil.get("http://interface.win007.com/zq/BF_XML.aspx", "date="+format);
//                String s = HttpUtil.sendGet("https://www.baidu.com", "date="+format);
//                String xml = "第"+i+"次执行"+"  "+format;
//                String xml1 = xml +"";
                List<Map<String, String>> maps = XmlDom4jUtil.iterateWholeXML(s);
                for (Map<String, String> map :maps) {       //将一天的赛程注入数据库
                    String id = map.get("a");
                    Integer nid = StringUtil.String2Integer(id);
                    String color = map.get("b");
                    String league = map.get("c");
                    String time1 = map.get("d");
                    String subLeague = map.get("e");
                    String state = map.get("f");
                    String home = map.get("h");
                    String away = map.get("i");
                    String homeScore = map.get("j");
                    String awayScore = map.get("k");
                    String bc1 = map.get("l");
                    String bc2 = map.get("m");
                    String red1 = map.get("n");
                    String red2 = map.get("o");
                    String order1 = map.get("p");
                    String order2 = map.get("q");
                    String explain = map.get("r");
                    String groupName = map.get("s");
                    String area = map.get("t");
                    String weatherIco = map.get("u");
                    String weather = map.get("v");
                    String temperature = map.get("w");
                    String season = map.get("x");
                    String group = map.get("y");
                    String zl = map.get("z");
                    String subLeagueId = map.get("subID");
                    String yellow = map.get("yellow");
                    String explain2 = map.get("explain2");
                    FootballScheduleResult footballScheduleResult = FootballScheduleResult.builder().id(nid).color(color).league(league).time(time1).subLeague(subLeague).state(state).home(home).away(away).homeScore(homeScore).awayScore(awayScore).bc1(bc1).bc2(bc2).red1(red1).red2(red2)
                            .order1(order1).order2(order2).explain(explain).groupName(groupName).area(area).weatherIco(weatherIco).weather(weather).temperature(temperature).season(season).group(group).zl(zl).subLeagueId(subLeagueId).yellow(yellow).explain2(explain2).build();
                    if(scheduleResultService.getFootballById(nid)!=null){
                        scheduleResultService.updateFootball(footballScheduleResult);
                    }else{
                        scheduleResultService.insertFootball(footballScheduleResult);
                    }
                }
                    Thread.sleep(120000);// 睡眠2分钟
    //                Thread.sleep(60000);// 睡眠1分钟
                }
        }catch (Exception e){
            LogUtil.error(e);
        }
    }

//    @Scheduled(cron = "0 45 13 0/1 * ?")//每天的13.00执行
    @Test
    public void test(){
//        System.out.println("13:45被执行");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i =0 ;i<8;i++) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_YEAR, i * -1);
            Date time = cal.getTime();
            String format = sf.format(time);
            String ss ="http://interface.win007.com/zq/BF_XML.aspx?"+format;
//            String s = HttpUtil.sendGet("http://interface.win007.com/zq/BF_XML.aspx", "date="+format);
            System.out.println(ss);
        }
    }



//    @Scheduled(cron = "0 35 4 0/1 * ?")//每天的13.00执行
//    @Scheduled(cron = "0 00 17 * * ?")//每天的13.00执行
    public void getFootballResult(){      //每天获取一次足球球队赛程信息
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            for (int i =0 ;i<3;i++) {   //查询今天和七天后的赛程
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DAY_OF_YEAR, i*-1);
                Date time = cal.getTime();
                String format = sf.format(time);
                String s = HttpUtil.get("http://interface.win007.com/zq/BF_XML.aspx", "date="+format);
//                String s = HttpUtil.sendGet("https://www.baidu.com", "date="+format);
//                String xml = "第"+i+"次执行"+"  "+format;
//                String xml1 = xml +"";
                List<Map<String, String>> maps = XmlDom4jUtil.iterateWholeXML(s);
                for (Map<String, String> map :maps) {       //将一天的赛程注入数据库
                    String id = map.get("a");
                    Integer nid = StringUtil.String2Integer(id);
                    String color = map.get("b");
                    String league = map.get("c");
                    String time1 = map.get("d");
                    String subLeague = map.get("e");
                    String state = map.get("f");
                    String home = map.get("h");
                    String away = map.get("i");
                    String homeScore = map.get("j");
                    String awayScore = map.get("k");
                    String bc1 = map.get("l");
                    String bc2 = map.get("m");
                    String red1 = map.get("n");
                    String red2 = map.get("o");
                    String order1 = map.get("p");
                    String order2 = map.get("q");
                    String explain = map.get("r");
                    String groupName = map.get("s");
                    String area = map.get("t");
                    String weatherIco = map.get("u");
                    String weather = map.get("v");
                    String temperature = map.get("w");
                    String season = map.get("x");
                    String group = map.get("y");
                    String zl = map.get("z");
                    String subLeagueId = map.get("subID");
                    String yellow = map.get("yellow");
                    String explain2 = map.get("explain2");
                    FootballScheduleResult footballScheduleResult = FootballScheduleResult.builder().id(nid).color(color).league(league).time(time1).subLeague(subLeague).state(state).home(home).away(away).homeScore(homeScore).awayScore(awayScore).bc1(bc1).bc2(bc2).red1(red1).red2(red2)
                            .order1(order1).order2(order2).explain(explain).groupName(groupName).area(area).weatherIco(weatherIco).weather(weather).temperature(temperature).season(season).group(group).zl(zl).subLeagueId(subLeagueId).yellow(yellow).explain2(explain2).build();
                    if(scheduleResultService.getFootballById(nid)!=null){
                        scheduleResultService.updateFootball(footballScheduleResult);
                    }else{
                        scheduleResultService.insertFootball(footballScheduleResult);
                    }
                }
                Thread.sleep(120000);// 睡眠2分钟
                //                Thread.sleep(60000);// 睡眠1分钟
            }
        }catch (Exception e){
            LogUtil.error(e);
        }
    }



}
