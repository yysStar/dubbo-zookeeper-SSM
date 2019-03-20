package com.qiyun.task;


import com.qiyun.httpUtil.HttpUtil;
import com.qiyun.model2.BasketballLineup;
import com.qiyun.model2.BasketballScheduleResult;
import com.qiyun.model2.BasketballTeamRank;
import com.qiyun.serviceImpl.BasketballLeagueServiceImpl;
import com.qiyun.serviceImpl.ScheduleResultServiceImpl;
import com.qiyun.util.LogUtil;
import com.qiyun.util.StringUtil;
import com.qiyun.util.XmlDom4jUtil;
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
public class BasketballScheduleResultTask {

    @Autowired
    private ScheduleResultServiceImpl scheduleResultService;

    @Autowired
    private BasketballLeagueServiceImpl basketballLeagueService;


    @Scheduled(cron = "0 0/2 * * * ?")//每隔2分钟处理一次
    public void getBasketballLineup() {      //每天获取一次篮球球队阵容信息
        try{
                String s = HttpUtil.get("http://interface.win007.com/lq/Lineup.aspx", "");
                List<Map<String, String>> maps = XmlDom4jUtil.iterateWholeXML(s);
                for (Map<String, String> map :maps) {
                    String ID = map.get("ID");
                    String home_lineup = map.get("home_lineup");
                    String home_backup = map.get("home_backup");
                    String away_lineup = map.get("away_lineup");
                    String away_backup = map.get("away_backup");
                    String analyzes = map.get("analyzes");
                    String INJURY = map.get("INJURY");
                    String home_Near6 = map.get("home_Near6");
                    String home_odds = map.get("home_odds");
                    String home_OU = map.get("home_OU");
                    String away_Near6 = map.get("away_Near6");
                    String away_odds = map.get("away_odds");
                    String away_OU = map.get("away_OU");
                    String Confidence = map.get("Confidence");
                    String VS = map.get("VS");
                    String Explain = map.get("Explain");
                    String home_lineup_gb = map.get("home_lineup_gb");
                    String home_backup_gb = map.get("home_backup_gb");
                    String away_lineup_gb = map.get("away_lineup_gb");
                    String away_backup_gb = map.get("away_backup_gb");
                    String analyzes_gb = map.get("analyzes_gb");
                    String INJURY_gb = map.get("INJURY_gb");
                    String Confidence_gb = map.get("Confidence_gb");
                    String VS_gb = map.get("VS_gb");
                    String Explain_gb = map.get("Explain_gb");
                    BasketballLineup basketballLineup = BasketballLineup.builder().id(StringUtil.String2Integer(ID)).homeLineup(home_lineup).homeBackup(home_backup).awayLineup(away_lineup)
                            .awayBackup(away_backup).analyzes(analyzes).injury(INJURY).homeNear6(home_Near6).homeOdds(home_odds).homeOu(home_OU).awayNear6(away_Near6).awayOdds(away_odds).awayOu(away_OU)
                            .confidence(Confidence).vs(VS).explain(Explain).homeLineupGb(home_lineup_gb).homeBackupGb(home_backup_gb).awayLineupGb(away_lineup_gb).awayBackupGb(away_backup_gb)
                            .analyzesGb(analyzes_gb).injuryGb(INJURY_gb).confidenceGb(Confidence_gb).vsGb(VS_gb).explainGb(Explain_gb).build();
                    if(basketballLeagueService.getById2(StringUtil.String2Integer(ID))==null){
                        basketballLeagueService.insert2(basketballLineup);
                    }else {
                        basketballLeagueService.update2(basketballLineup);
                    }
                }
        }catch (Exception e){
            LogUtil.error(e);
        }
    }


          @Scheduled(cron = "0 30 3 0/1 * ?")//每天的3.30执行
//        @Scheduled(cron = "0 30 15 * * ?")//每天的13.00执行
//        @Scheduled(cron = "0 0 0/4 * * ?")//每隔10秒处理一次
    public void getBasketballSchedule(){      //每天获取一次篮球球队赛程信息
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            for (int i =-3;i<8;i++) {   //查询今天和七天后的赛程
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DAY_OF_YEAR, i);
                Date time = cal.getTime();
                String format = sf.format(time);
                String s = HttpUtil.get("http://interface.win007.com/lq/LqSchedule.aspx", "time="+format);
//                String s = HttpUtil.sendGet("https://www.baidu.com", "time="+format);
//                String xml = "第"+i+"次执行"+"  "+format;
//                System.out.println(xml);
                List<Map<String, String>> maps = XmlDom4jUtil.iterateWholeXML1(s);
                for (Map<String, String> map :maps) {       //将一天的赛程注入数据库
                    for (String key : map.keySet()) {
                        String value = map.get(key);
                        String[] split = value.split("\\^");
                        if(split.length<41){
                            for (int m = split.length;m<=41;m++) {
//                                split[i]="";
                                value+=" ";
                            }
                            String[] split1 = value.split("\\^");
                            BasketballScheduleResult basketballScheduleResult = BasketballScheduleResult.builder().id(StringUtil.String2Integer(split1[0])).leagueId(split1[1]).leagueType(split1[2]).league(split1[3]).sectionCount(split1[4]).color(split1[5]).time(split1[6]).state(split1[7]).remainTime(split1[8]).homeId(split1[9]).home(split1[10]).awayId(split1[11]).away(split1[12]).order1(split1[13]).order2(split1[14]).homeScore(split1[15]).awayScore(split1[16]).zd1(split1[17]).kd1(split1[18]).zd2(split1[19]).kd2(split1[20]).zd3(split1[21]).kd3(split1[22]).zd4(split1[23]).kd4(split1[24]).addTime(split1[25])
                                    .zd1ot(split1[26]).kd1ot(split1[27]).zd2ot(split1[28]).kd2ot(split1[29]).zd3ot(split1[30]).kd3ot(split1[31]).haveTechnical(split1[32]).tv(split1[33]).mark(split1[34]).zl(split1[35]).season(split1[36]).type(split1[37]).place(split1[38]).gameType(split1[39]).gameSubType(split1[40]).build();
                            if(scheduleResultService.getBasketballById(StringUtil.String2Integer(split[0]))!=null){
                                scheduleResultService.updateBasketball(basketballScheduleResult);
                            }else{
                                scheduleResultService.insertBasketball(basketballScheduleResult);
                            }
                        }else{
                            BasketballScheduleResult basketballScheduleResult = BasketballScheduleResult.builder().id(StringUtil.String2Integer(split[0])).leagueId(split[1]).leagueType(split[2]).league(split[3]).sectionCount(split[4]).color(split[5]).time(split[6]).state(split[7]).remainTime(split[8]).homeId(split[9]).home(split[10]).awayId(split[11]).away(split[12]).order1(split[13]).order2(split[14]).homeScore(split[15]).awayScore(split[16]).zd1(split[17]).kd1(split[18]).zd2(split[19]).kd2(split[20]).zd3(split[21]).kd3(split[22]).zd4(split[23]).kd4(split[24]).addTime(split[25])
                                    .zd1ot(split[26]).kd1ot(split[27]).zd2ot(split[28]).kd2ot(split[29]).zd3ot(split[30]).kd3ot(split[31]).haveTechnical(split[32]).tv(split[33]).mark(split[34]).zl(split[35]).season(split[36]).type(split[37]).place(split[38]).gameType(split[39]).gameSubType(split[40]).build();
                            if(scheduleResultService.getBasketballById(StringUtil.String2Integer(split[0]))!=null){
                                scheduleResultService.updateBasketball(basketballScheduleResult);
                            }else{
                                scheduleResultService.insertBasketball(basketballScheduleResult);
                        }
                    }
                    }
                }
                Thread.sleep(120000);// 睡眠2分钟
//                Thread.sleep(60000);// 睡眠1分钟
            }
        }catch (Exception e){
            LogUtil.error(e);
        }
    }

//        @Scheduled(cron = "0 30 4 0/1 * ?")//每天的3.30执行
//        @Scheduled(cron = "0 20 15 * * ?")//每天的12.00执行
    public void getBasketballResult(){      //每天获取一次篮球球队赛果信息
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            for (int i =1 ;i<3;i++) {   //查询今天和七天前的赛果
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DAY_OF_YEAR, i*-1);
                Date time = cal.getTime();
                String format = sf.format(time);
                String s = HttpUtil.get("http://interface.win007.com/lq/LqSchedule.aspx", "time="+format);
//                String s = HttpUtil.sendGet("https://www.baidu.com", "time="+format);
                List<Map<String, String>> maps = XmlDom4jUtil.iterateWholeXML1(s);
                for (Map<String, String> map :maps) {       //将一天的赛程注入数据库
                    for (String key : map.keySet()) {
                        String value = map.get(key);
                        String[] split = value.split("\\^");
                        if(split.length<41){
                            for (int m = split.length;m<=41;m++) {
//                                split[i]="";
                                value+=" ";
                            }
                            String[] split1 = value.split("\\^");
                            BasketballScheduleResult basketballScheduleResult = BasketballScheduleResult.builder().id(StringUtil.String2Integer(split1[0])).leagueId(split1[1]).leagueType(split1[2]).league(split1[3]).sectionCount(split1[4]).color(split1[5]).time(split1[6]).state(split1[7]).remainTime(split1[8]).homeId(split1[9]).home(split1[10]).awayId(split1[11]).away(split1[12]).order1(split1[13]).order2(split1[14]).homeScore(split1[15]).awayScore(split1[16]).zd1(split1[17]).kd1(split1[18]).zd2(split1[19]).kd2(split1[20]).zd3(split1[21]).kd3(split1[22]).zd4(split1[23]).kd4(split1[24]).addTime(split1[25])
                                    .zd1ot(split1[26]).kd1ot(split1[27]).zd2ot(split1[28]).kd2ot(split1[29]).zd3ot(split1[30]).kd3ot(split1[31]).haveTechnical(split1[32]).tv(split1[33]).mark(split1[34]).zl(split1[35]).season(split1[36]).type(split1[37]).place(split1[38]).gameType(split1[39]).gameSubType(split1[40]).build();
                            if(scheduleResultService.getBasketballById(StringUtil.String2Integer(split[0]))!=null){
                                scheduleResultService.updateBasketball(basketballScheduleResult);
                            }else{
                                scheduleResultService.insertBasketball(basketballScheduleResult);
                            }
                        }else{
                            BasketballScheduleResult basketballScheduleResult = BasketballScheduleResult.builder().id(StringUtil.String2Integer(split[0])).leagueId(split[1]).leagueType(split[2]).league(split[3]).sectionCount(split[4]).color(split[5]).time(split[6]).state(split[7]).remainTime(split[8]).homeId(split[9]).home(split[10]).awayId(split[11]).away(split[12]).order1(split[13]).order2(split[14]).homeScore(split[15]).awayScore(split[16]).zd1(split[17]).kd1(split[18]).zd2(split[19]).kd2(split[20]).zd3(split[21]).kd3(split[22]).zd4(split[23]).kd4(split[24]).addTime(split[25])
                                    .zd1ot(split[26]).kd1ot(split[27]).zd2ot(split[28]).kd2ot(split[29]).zd3ot(split[30]).kd3ot(split[31]).haveTechnical(split[32]).tv(split[33]).mark(split[34]).zl(split[35]).season(split[36]).type(split[37]).place(split[38]).gameType(split[39]).gameSubType(split[40]).build();
                            if(scheduleResultService.getBasketballById(StringUtil.String2Integer(split[0]))!=null){
                                scheduleResultService.updateBasketball(basketballScheduleResult);
                            }else{
                                scheduleResultService.insertBasketball(basketballScheduleResult);
                            }
                        }
                    }
                }
                Thread.sleep(120000);// 睡眠2分钟
            }
        }catch (Exception e){
            LogUtil.error(e);
        }
    }



}
