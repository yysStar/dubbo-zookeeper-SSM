package com.qiyun.task;


import com.qiyun.dto.ScoreliveFootballNowDayDTO;
import com.qiyun.httpUtil.HttpUtil;
import com.qiyun.model2.*;
import com.qiyun.service.ScoreLiveFootballNowDayService;
import com.qiyun.serviceImpl.*;
import com.qiyun.util.*;
import org.dom4j.Document;
import org.jaxen.*;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Lazy(value=false)
public class LeagueTask {


    @Autowired
    private BasketballLeagueServiceImpl basketballLeagueService;

    @Autowired
    private BasketballTeamServiceImpl basketballTeamService;

    @Autowired
    private FootballLeagueServiceImpl footballLeagueService;

    @Autowired
    private FootballSpServiceImpl footballSpService;

    @Autowired
    private ScoreLiveFootballNowDayService scoreLiveFootballNowDayService;

    @Test
    public void test() throws ParseException, DocumentException {

        String xml = "1614312^1^3^90^^^^5728800^";
        String xml2 = "1612500^1^3^90^Diaz A.^^Diaz A.^5728728^";
        String[] split = xml2.split("\\^");
        System.out.println(split.length);
    }


    /**
     * 获取竞彩足球SP值
     */
    @Scheduled(cron = "0 0/3 * * * ?")//每隔2分钟处理一次
//    @Test
    public void getFootballSP() throws DocumentException {
        try{
            Config configById = footballSpService.getConfigById(1);
            Integer spSource = configById.getSpSource();
            if(spSource == 2){
                String s = HttpUtil.get("http://interface.win007.com/zq/JcZqOdds.aspx", "");
                Document doc = DocumentHelper.parseText(s);
                List<Element> urls = doc.selectNodes("//list/match");
//                Element root = doc.getRootElement();
                if(urls!=null&&urls.size()>0){
                    for(Iterator it = urls.iterator();it.hasNext();){
                        Element match = (Element)it.next();
    //                    System.out.println(url.getText());//打印原值
    //                    url.setText("https://forum.csdn.net/");//修改
    //                    Element match = root.element("match");
    //                Element bqc = match.element("bqc");
    //                String ht33 = bqc.element("ht33").getText();
    //                List<Map<String, String>> maps = XmlDom4jUtil.iterateWholeXML(xml);
    //                for (Map<String, String> map : maps) {
    //                    String ID = map.get("ID");
                        String ID = match.element("ID").getText();
                        String MatchTime = match.element("MatchTime").getText();
    //                    String MatchTime = map.get("MatchTime");
    //                    String League = map.get("League");
    //                    String Home = map.get("Home");
    //                    String Away = map.get("Away");
    //                    String dan_rq = map.get("dan_rq");
    //                    String dan_bf = map.get("dan_bf");
    //                    String dan_jq = map.get("dan_jq");
    //                    String dan_bqc = map.get("dan_bqc");
    //                    String dan_sf = map.get("dan_sf");
    //                    String rq = map.get("rq");
    //                    rq = "<rq>" + rq + "</rq>";
    //                    Map<String, String> rqMap = XmlDom4jUtil.xml2Map(rq);
                        Element rq = match.element("rq");
                        String goal = rq.element("goal").getText();
                        String rq3 = rq.element("rq3").getText();
                        String rq1 = rq.element("rq1").getText();
                        String rq0 = rq.element("rq0").getText();
    //                    String goal = rqMap.get("goal");    //让球数
    //                    String rq3 = rqMap.get("rq3");  //让球胜赔率
    //                    String rq1 = rqMap.get("rq1");  //让球平赔率
    //                    String rq0 = rqMap.get("rq0");  //让球负赔率
                        Map<String, Object> rqMap2 = footballSpService.setSportteryFootballRqSp(ID, MatchTime, goal, rq3, rq1, rq0);
    //                    if(rqMap2.get(Constants.CODE).equals(Constants.SUCCESS_CODE)){
    //                        LogUtil.info("抓取竞彩足球让球胜平负SP成功-飞鲸");
    //                    }else if(rqMap2.get(Constants.CODE).equals(Constants.ERROR_CODE_637)){
    //                        LogUtil.info("竞彩足球让球胜平负SP已最新-飞鲸");
    //                    }else if(rqMap2.get(Constants.CODE).equals(Constants.ERROR_CODE_638)){
    //                        LogUtil.error(ID+"场次比赛不存在-飞鲸");
    //                    } else{
    //                        LogUtil.error(ID+"竞彩足球让球胜平负SP更新失败-飞鲸");
    //                    }
                        if(rqMap2.get(Constants.CODE).equals(Constants.ERROR_CODE_619)){
                            LogUtil.error(ID+"竞彩足球进球SP更新失败-飞鲸");
                        }
    //                    String bf = map.get("bf");
    //                    bf = "<bf>" + bf + "</bf>";
    //                    Map<String, String> bfMap = XmlDom4jUtil.xml2Map(bf);
                        Element bf = match.element("bf");
                        String sd00 = bf.element("sd00").getText();
                        String sl01 = bf.element("sl01").getText();
                        String sl02 = bf.element("sl02").getText();
                        String sl03 = bf.element("sl03").getText();
                        String sw10 = bf.element("sw10").getText();
                        String sd11 = bf.element("sd11").getText();
                        String sl12 = bf.element("sl12").getText();
                        String sl13 = bf.element("sl13").getText();
                        String sw20 = bf.element("sw20").getText();
                        String sw21 = bf.element("sw21").getText();
                        String sd22 = bf.element("sd22").getText();
                        String sl23 = bf.element("sl23").getText();
                        String sw30 = bf.element("sw30").getText();
                        String sw31 = bf.element("sw31").getText();
                        String sw32 = bf.element("sw32").getText();
                        String sd33 = bf.element("sd33").getText();
                        String sw40 = bf.element("sw40").getText();
                        String sw41 = bf.element("sw41").getText();
                        String sw42 = bf.element("sw42").getText();
                        String sl04 = bf.element("sl04").getText();
                        String sl14 = bf.element("sl14").getText();
                        String sl24 = bf.element("sl24").getText();
                        String sw50 = bf.element("sw50").getText();
                        String sw51 = bf.element("sw51").getText();
                        String sw52 = bf.element("sw52").getText();
                        String sl05 = bf.element("sl05").getText();
                        String sl15 = bf.element("sl15").getText();
                        String sl25 = bf.element("sl25").getText();
                        String sw5 = bf.element("sw5").getText();
                        String sd4 = bf.element("sd4").getText();
                        String sl5 = bf.element("sl5").getText();
    //                    String sd00 = bfMap.get("sd00");    //00平
    //                    String sl01 = bfMap.get("sl01");    //01负
    //                    String sl02 = bfMap.get("sl02");    //02负
    //                    String sl03 = bfMap.get("sl03");    //03负
    //                    String sw10 = bfMap.get("sw10");    //10胜
    //                    String sd11 = bfMap.get("sd11");    //11平
    //                    String sl12 = bfMap.get("sl12");    //12负
    //                    String sl13 = bfMap.get("sl13");    //13负
    //                    String sw20 = bfMap.get("sw20");    //20胜
    //                    String sw21 = bfMap.get("sw21");    //21胜
    //                    String sd22 = bfMap.get("sd22");    //22平
    //                    String sl23 = bfMap.get("sl23");    //23负
    //                    String sw30 = bfMap.get("sw30");
    //                    String sw31 = bfMap.get("sw31");
    //                    String sw32 = bfMap.get("sw32");
    //                    String sd33 = bfMap.get("sd33");
    //                    String sw40 = bfMap.get("sw40");
    //                    String sw41 = bfMap.get("sw41");
    //                    String sw42 = bfMap.get("sw42");
    //                    String sl04 = bfMap.get("sl04");
    //                    String sl14 = bfMap.get("sl14");
    //                    String sl24 = bfMap.get("sl24");
    //                    String sw50 = bfMap.get("sw50");
    //                    String sw51 = bfMap.get("sw51");
    //                    String sw52 = bfMap.get("sw52");
    //                    String sl05 = bfMap.get("sl05");
    //                    String sl15 = bfMap.get("sl15");
    //                    String sl25 = bfMap.get("sl25");
    //                    String sw5 = bfMap.get("sw5");  //主胜其他
    //                    String sd4 = bfMap.get("sd4");  //主平其他
    //                    String sl5 = bfMap.get("sl5");  //主负其他
                        Map<String, Object> bfMap2 = footballSpService.setSportteryFootballBfSp(ID, MatchTime, sd00, sl01, sl02, sl03, sw10, sd11, sl12, sl13, sw20, sw21, sd22, sl23, sw30, sw31, sw32, sd33, sw40, sw41, sw42, sl04, sl14, sl24, sw50, sw51, sw52, sl05, sl15, sl25, sw5, sd4, sl5);
    //                    if(bfMap2.get(Constants.CODE).equals(Constants.SUCCESS_CODE)){
    //                        LogUtil.info("抓取竞彩足球比分SP成功-飞鲸");
    //                    }else if(bfMap2.get(Constants.CODE).equals(Constants.ERROR_CODE_637)){
    //                        LogUtil.info("竞彩足球比分SP已最新-飞鲸");
    //                    }else if(bfMap2.get(Constants.CODE).equals(Constants.ERROR_CODE_638)){
    //                        LogUtil.error(ID+"场次比赛不存在-飞鲸");
    //                    } else{
    //                        LogUtil.error(ID+"竞彩足球比分SP更新失败-飞鲸");
    //                    }
                        if(bfMap2.get(Constants.CODE).equals(Constants.ERROR_CODE_619)){
                            LogUtil.error(ID+"竞彩足球进球SP更新失败-飞鲸");
                        }
    //                    String jq = map.get("jq");
    //                    jq = "<jq>" + jq + "</jq>";
    //                    Map<String, String> jqMap = XmlDom4jUtil.xml2Map(jq);//进球数赔率
                        Element jq = match.element("jq");
                        String t0 = jq.element("t0").getText();
                        String t1 = jq.element("t1").getText();
                        String t2 = jq.element("t2").getText();
                        String t3 = jq.element("t3").getText();
                        String t4 = jq.element("t4").getText();
                        String t5 = jq.element("t5").getText();
                        String t6 = jq.element("t6").getText();
                        String t7 = jq.element("t7").getText();
    //                    String t0 = jqMap.get("t0");    //进球数为0
    //                    String t1 = jqMap.get("t1");    //进球数为1
    //                    String t2 = jqMap.get("t2");    //进球数为2
    //                    String t3 = jqMap.get("t3");    //进球数为3
    //                    String t4 = jqMap.get("t4");    //进球数为4
    //                    String t5 = jqMap.get("t5");    //进球数为5
    //                    String t6 = jqMap.get("t6");    //进球数为6
    //                    String t7 = jqMap.get("t7");    //进球数为7
                        Map<String, Object> jqMap2 = footballSpService.setSportteryFootballJqSp(ID, MatchTime, t0, t1, t2, t3, t4, t5, t6, t7);
    //                    if(jqMap2.get(Constants.CODE).equals(Constants.SUCCESS_CODE)){
    //                        LogUtil.info("抓取竞彩足球进球SP成功-飞鲸");
    //                    }else if(jqMap2.get(Constants.CODE).equals(Constants.ERROR_CODE_637)){
    //                        LogUtil.info("竞彩足球进球SP已最新-飞鲸");
    //                    }else if(jqMap2.get(Constants.CODE).equals(Constants.ERROR_CODE_638)){
    //                        LogUtil.error(ID+"场次比赛不存在-飞鲸");
    //                    } else{
    //                        LogUtil.error(ID+"竞彩足球进球SP更新失败-飞鲸");
    //                    }
                        if(jqMap2.get(Constants.CODE).equals(Constants.ERROR_CODE_619)){
                            LogUtil.error(ID+"竞彩足球进球SP更新失败-飞鲸");
                        }
    //                    String bqc = map.get("bqc");
    //                    bqc = "<bqc>" + bqc + "</bqc>";
    //                    Map<String, String> bqcMap = XmlDom4jUtil.xml2Map(bqc);//半全场赔率
                        Element bqc = match.element("bqc");
                        String ht33 = bqc.element("ht33").getText();
                        String ht31 = bqc.element("ht31").getText();
                        String ht30 = bqc.element("ht30").getText();
                        String ht13 = bqc.element("ht13").getText();
                        String ht11 = bqc.element("ht11").getText();
                        String ht10 = bqc.element("ht10").getText();
                        String ht03 = bqc.element("ht03").getText();
                        String ht01 = bqc.element("ht01").getText();
                        String ht00 = bqc.element("ht00").getText();

    //                    String ht33 = bqcMap.get("ht33");   //主胜胜
    //                    String ht31 = bqcMap.get("ht31");   //主胜平
    //                    String ht30 = bqcMap.get("ht30");   //主胜负
    //                    String ht13 = bqcMap.get("ht13");   //主平胜
    //                    String ht11 = bqcMap.get("ht11");   //主平平
    //                    String ht10 = bqcMap.get("ht10");   //主平负
    //                    String ht03 = bqcMap.get("ht03");   //主负胜
    //                    String ht01 = bqcMap.get("ht01");   //主负平
    //                    String ht00 = bqcMap.get("ht00");   //主负负
                        Map<String, Object> bqcMap2 = footballSpService.setSportteryFootballBqcSp(ID, MatchTime, ht33, ht31, ht30, ht13, ht11, ht10, ht03, ht01, ht00);
    //                    if(jqMap2.get(Constants.CODE).equals(Constants.SUCCESS_CODE)){
    //                        LogUtil.info("抓取竞彩足球进球SP成功-飞鲸");
    //                    }else if(jqMap2.get(Constants.CODE).equals(Constants.ERROR_CODE_637)){
    //                        LogUtil.info("竞彩足球进球SP已最新-飞鲸");
    //                    }else if(jqMap2.get(Constants.CODE).equals(Constants.ERROR_CODE_638)){
    //                        LogUtil.error(ID+"场次比赛不存在-飞鲸");
    //                    } else{
    //                        LogUtil.error(ID+"竞彩足球进球SP更新失败-飞鲸");
    //                    }
                        if(bqcMap2.get(Constants.CODE).equals(Constants.ERROR_CODE_619)){
                            LogUtil.error(ID+"竞彩足球进球SP更新失败-飞鲸");
                        }
    //                    String sf = map.get("sf");
    //                    sf = "<sf>" + sf + "</sf>";
    //                    Map<String, String> sfMap = XmlDom4jUtil.xml2Map(sf);   //胜负赔率
                        Element sf = match.element("sf");
                        String sf3 = sf.element("sf3").getText();
                        String sf1 = sf.element("sf1").getText();
                        String sf0 = sf.element("sf0").getText();
    //                    String sf3 = sfMap.get("sf3");  //主胜
    //                    String sf1 = sfMap.get("sf1");  //平
    //                    String sf0 = sfMap.get("sf0");  //主负
                        Map<String, Object> sfMap2 = footballSpService.setSportteryFootballSpfSp(ID, MatchTime, sf3, sf1, sf0);
    //                    if(jqMap2.get(Constants.CODE).equals(Constants.SUCCESS_CODE)){
    //                        LogUtil.info("抓取竞彩足球进球SP成功-飞鲸");
    //                    }else if(jqMap2.get(Constants.CODE).equals(Constants.ERROR_CODE_637)){
    //                        LogUtil.info("竞彩足球进球SP已最新-飞鲸");
    //                    }else if(jqMap2.get(Constants.CODE).equals(Constants.ERROR_CODE_638)){
    //                        LogUtil.error(ID+"场次比赛不存在-飞鲸");
    //                    } else{
    //                        LogUtil.error(ID+"竞彩足球进球SP更新失败-飞鲸");
    //                    }
                        if(sfMap2.get(Constants.CODE).equals(Constants.ERROR_CODE_619)){
                            LogUtil.error(ID+"竞彩足球进球SP更新失败-飞鲸");
                        }
                    }
                    }
                }
//            }
        }catch (Exception e){
            LogUtil.error(e);
        }
    }



    /**
     * 获取足球赛事
     */
//    @Scheduled(cron = "0 0/1 * * * ?")//每隔1分钟处理一次
    @Scheduled(cron = "0 0/2 * * * ?")//每隔1分钟处理一次
    public void getFootballScore(){
        try {
            String xml = "";
            String s = HttpUtil.get("http://interface.win007.com/zq/cp/CP_BF.aspx", "");
            List<Map<String, String>> maps = XmlDom4jUtil.iterateWholeXML(s);
            SimpleDateFormat format3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            for (Map<String, String> map : maps) {
                String ID = map.get("ID");
                String color = map.get("color");
                String leagueID = map.get("leagueID");
                String kind = map.get("kind");
                String level = map.get("level");
                String league = map.get("league");
                String subLeague = map.get("subLeague");
                String subLeagueID = map.get("subLeagueID");
                String time = map.get("time");
                Date parse = format3.parse(time);
                String time2 = map.get("time2");
                String home = map.get("home");
                String away = map.get("away");
                String state = map.get("state");
                String homeScore = map.get("homeScore");
                String awayScore = map.get("awayScore");
                String bc1 = map.get("bc1");
                String bc2 = map.get("bc2");
                String red1 = map.get("red1");
                String red2 = map.get("red2");
                String yellow1 = map.get("yellow1");
                String yellow2 = map.get("yellow2");
                String order1 = map.get("order1");
                String order2 = map.get("order2");
                String explain = map.get("explain");
                String zl = map.get("zl");
                String tv = map.get("tv");
                String lineup = map.get("lineup");
                String explain2 = map.get("explain2");
                String corner1 = map.get("corner1");
                String corner2 = map.get("corner2");
                ScoreliveFootballNowday scoreliveFootballNowDay =
                        ScoreliveFootballNowday.builder().id(StringUtil.String2Integer(ID)).color(color).leagueId(leagueID)
                                .kind(kind).level(level).league(league).subLeague(subLeague).subLeagueId(subLeagueID)
                                .time(parse).time2(time2).home(home).away(away).state(state)
                                .homeScore(homeScore).awayScore(awayScore).bc1(bc1).bc2(bc2)
                                .red1(red1).red2(red2).yellow1(yellow1).yellow2(yellow2)
                                .order1(order1).order2(order2).explain(explain).explain2(explain2).zl(zl).tv(tv).lineup(lineup).corner1(corner1).corner2(corner2)
                                .build();
                if(scoreLiveFootballNowDayService.getById(StringUtil.String2Integer(ID))!=null){
                    scoreLiveFootballNowDayService.update(scoreliveFootballNowDay);
                }else {
                    scoreLiveFootballNowDayService.insert(scoreliveFootballNowDay);
                }
            }
        }catch (Exception e){
            LogUtil.error(e);
        }
    }



    /**
     * 获取彩票赛事与球探网比分数据关联定时任务
     */
    @Scheduled(cron = "0 0/10 * * * ?")//每隔10分钟处理一次
//    @Scheduled(cron = "0 0/5 * * * ?")//每隔5分钟处理一次
    public void getBetMapping(){
        try {
//            String xml = "";
            String s = HttpUtil.get("http://interface.win007.com/zq/MatchidInterface.aspx", "");
            List<Map<String, String>> maps = XmlDom4jUtil.iterateWholeXML(s);
            SimpleDateFormat format3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            for (Map<String, String> map : maps) {
                String lotteryName = map.get("LotteryName");
                String issueNum = map.get("IssueNum");
                String id = map.get("ID");
                String id_bet007 = map.get("ID_bet007");
                String time = map.get("time");
                Date parse = format3.parse(time);
                String home = map.get("Home");
                String away = map.get("Away");
                String homeID = map.get("HomeID");
                String awayID = map.get("AwayID");
                String turn = map.get("Turn");
                String league = map.get("league");
                MatchBetMapping matchBetMapping = MatchBetMapping.builder().lotteryName(lotteryName).isSueNum(issueNum).id(id).idBet(id_bet007).time(parse)
                        .home(home).away(away).homeId(homeID).awayId(awayID).turn(turn).league(league).build();
                if(footballLeagueService.getById2(id)!=null){
                    footballLeagueService.update2(matchBetMapping);
                }else{
                    footballLeagueService.insert2(matchBetMapping);
                }
            }
        }catch (Exception e){
            LogUtil.error(e);
        }
    }

    /**
     * 获取彩票比赛的事件与技术统计2
     */
    @Scheduled(cron = "0 0/3 * * * ?")//每隔1分钟处理一次
//    @Test
    public void getFootballEvent2(){
        try {
            String s = HttpUtil.get("http://interface.win007.com/zq/cp/Cp_EventDetail.aspx", "");
            Document document = DocumentHelper.parseText(s);//将xml转为dom对象
//            Document document = DocumentHelper.parseText(xml);//将xml转为dom对象
            Element root = document.getRootElement();
            List nodes = root.elements("event");
            List nodes2 = root.elements("technic");
            List<FootballEvent>footballEvents = new ArrayList<FootballEvent>();
            for (Iterator it = nodes.iterator(); it.hasNext();) {
                Element elm = (Element) it.next();
                String text1 = elm.getText();
                if (text1==null||text1=="") break;  //判断如果当前没有数据
                for(Iterator it2=elm.elementIterator();it2.hasNext();){
                    Element elel=(Element)it2.next();
//                    System.out.println(elel.getName()+":"+elel.getText()+":");
                    String text = elel.getText();
                    String[] split = text.split("\\^");
                    Integer id = StringUtil.String2Integer(split[0]);
                    List<FootballEvent> byId3 = footballLeagueService.getById33(split[7]);
                    if(byId3.size()==0||byId3==null) {
                        FootballEvent footballEvent = FootballEvent.builder().scheduleId(id).mark(split[1]).type(split[2]).time(split[3]+"′").name(split[4]).qId(split[5]).gName(split[6])
                                .version(split[7]).build();
                        footballEvents.add(footballEvent);
                    }
                    FootballEvent footballEvent = new FootballEvent();
                    if(split.length==4){
                        footballEvent = FootballEvent.builder().scheduleId(id).mark(split[1]).type(split[2]).time(split[3]+"′")
                                .version(version).build();
                    }else if(split.length==5){
                        footballEvent = FootballEvent.builder().scheduleId(id).mark(split[1]).type(split[2]).time(split[3]+"′").name(split[4])
                                .version(version).build();
                    }else if(split.length==6){
                        footballEvent = FootballEvent.builder().scheduleId(id).mark(split[1]).type(split[2]).time(split[3]+"′").name(split[4]).gName(split[5])
                                .version(version).build();
                    }else if(split.length==7){
                        footballEvent = FootballEvent.builder().scheduleId(id).mark(split[1]).type(split[2]).time(split[3]+"′").name(split[4]).qId(split[5]).gName(split[6])
                                .version(version).build();
                    }
                    footballEvent = FootballEvent.builder().scheduleId(id).mark(split[1]).type(split[2]).time(split[3]+"′").name(split[4]).qId(split[5]).gName(split[6])
                            .version(version).build();
                    footballEvents.add(footballEvent);
                }
            }
            if(footballEvents.size()!=0){
                    for (FootballEvent footballEvent:footballEvents) {
                        footballLeagueService.insert3(footballEvent);
                    }
            }
            for (Iterator it = nodes2.iterator(); it.hasNext();) {
                Element elm = (Element) it.next();
                String text1 = elm.getText();
                if(text1 ==null||text1=="") break;  //判断如果当前没有数据
                for(Iterator it2=elm.elementIterator();it2.hasNext();){
                    Element elel=(Element)it2.next();
//                    System.out.println(elel.getName()+":"+elel.getText()+":");
                    String text = elel.getText();
                    String[] split = text.split("\\^");
                    FootballTechnic footballTechnic = FootballTechnic.builder().id(StringUtil.String2Integer(split[0])).connect(split[1]).build();
                    if(footballLeagueService.getById4(StringUtil.String2Integer(split[0]))!=null){
                        footballLeagueService.update4(footballTechnic);
                    }else{
                        footballLeagueService.insert4(footballTechnic);
                    }
                }
            }
        }catch (Exception e){
            LogUtil.error(e);
        }
    }

    /**
     * 获取彩票比赛的事件与技术统计
     */
//    @Scheduled(cron = "0 0/1 * * * ?")//每隔1分钟处理一次
//    public void getFootballEvent(){
//        try {
//            String s = HttpUtil.get("http://interface.win007.com/zq/cp/Cp_EventDetail.aspx", "");
//            Document document = DocumentHelper.parseText(s);//将xml转为dom对象
////            Document document = DocumentHelper.parseText(xml);//将xml转为dom对象
//            Element root = document.getRootElement();
//            List nodes = root.elements("event");
//            List nodes2 = root.elements("technic");
//            List<FootballEvent>footballEvents = new ArrayList<FootballEvent>();
//            int versionCount = 0;
//            for (Iterator it = nodes.iterator(); it.hasNext();) {
//                Element elm = (Element) it.next();
//                String text1 = elm.getText();
//                if (text1==null||text1=="") break;  //判断如果当前没有数据
//                for(Iterator it2=elm.elementIterator();it2.hasNext();){
//                    Element elel=(Element)it2.next();
//                    System.out.println(elel.getName()+":"+elel.getText()+":");
//                    String text = elel.getText();
//                    String[] split = text.split("\\^");
//                    Integer id = StringUtil.String2Integer(split[0]);
//                    int version = 0;
//                    List<FootballEvent> byId3 = footballLeagueService.getById3(id);
//                    if(byId3.size()==0||byId3==null) {
//                        version = 1;
//                    }else{
//                        int maxVersion = footballLeagueService.getMaxVersion(id);
//                        versionCount = footballLeagueService.getMaxVersionCount(id, maxVersion);
//                        version = maxVersion+1;
//                    }
//                    FootballEvent footballEvent = new FootballEvent();
//                    if(split.length==4){
//                        footballEvent = FootballEvent.builder().scheduleId(id).mark(split[1]).type(split[2]).time(split[3]+"′")
//                                .version(version).build();
//                    }else if(split.length==5){
//                        footballEvent = FootballEvent.builder().scheduleId(id).mark(split[1]).type(split[2]).time(split[3]+"′").name(split[4])
//                                .version(version).build();
//                    }else if(split.length==6){
//                        footballEvent = FootballEvent.builder().scheduleId(id).mark(split[1]).type(split[2]).time(split[3]+"′").name(split[4]).gName(split[5])
//                                .version(version).build();
//                    }else if(split.length==7){
//                        footballEvent = FootballEvent.builder().scheduleId(id).mark(split[1]).type(split[2]).time(split[3]+"′").name(split[4]).qId(split[5]).gName(split[6])
//                                .version(version).build();
//                    }else if(split.length==8){
//                        footballEvent = FootballEvent.builder().scheduleId(id).mark(split[1]).type(split[2]).time(split[3]+"′").name(split[4]).qId(split[5]).gName(split[6])
//                                .version(version).build();
//                    }
//                    footballEvents.add(footballEvent);
//                }
//            }
//            if(footballEvents.size()!=0){
//                if(footballEvents.size()>versionCount){
//                    for (FootballEvent footballEvent:footballEvents) {
//                        footballLeagueService.insert3(footballEvent);
//                    }
//                }
//            }
//            for (Iterator it = nodes2.iterator(); it.hasNext();) {
//                Element elm = (Element) it.next();
//                String text1 = elm.getText();
//                if(text1 ==null||text1=="") break;  //判断如果当前没有数据
//                for(Iterator it2=elm.elementIterator();it2.hasNext();){
//                    Element elel=(Element)it2.next();
////                    System.out.println(elel.getName()+":"+elel.getText()+":");
//                    String text = elel.getText();
//                    String[] split = text.split("\\^");
//                    FootballTechnic footballTechnic = FootballTechnic.builder().id(StringUtil.String2Integer(split[0])).connect(split[1]).build();
//                    if(footballLeagueService.getById4(StringUtil.String2Integer(split[0]))!=null){
//                        footballLeagueService.update4(footballTechnic);
//                    }else{
//                        footballLeagueService.insert4(footballTechnic);
//                    }
//                }
//            }
//        }catch (Exception e){
//            LogUtil.error(e);
//        }
//    }

//    @Scheduled(cron = "0 0 0 0/1 * ?")//每隔1天处理一次
//    @Scheduled(cron = "0/60 * * * * ?")//每隔1小时处理一次
    public void getBasketballTeamRank(){
        try{
//            for(int a=2;a<=183;a++){
//                if(a==102||a==103||a==104||a==108||a==111||a==116||a==117||a==118||a==120||a==121||a==123||a==129
//                        ||a==132||a==157||a==158||a==159||a==164||a==165||a==166||a==169){
//                    continue;
//                }
            for(int a=1;a<=2;a++){
                String sid = a+"";
//            String s = HttpUtil.get("http://interface.win007.com/lq/LqRankings.aspx", "sclassid=1&season=18-19");
            String s = HttpUtil.get("http://interface.win007.com/lq/LqRankings.aspx", "sclassid="+sid);
//            String s = HttpUtil.sendGet("https://www.baidu.com", "sclassid=1&season=18-19");
            List<Map<String, String>> maps = XmlDom4jUtil.iterateWholeXML(s);
            for (Map<String, String> map :maps) {
                String league = map.get("league");
                String teamID = map.get("TeamID");
                String name = map.get("Name");
                String matchSeason = map.get("matchSeason");
                String homewin = map.get("homewin");
                String homeloss = map.get("homeloss");
                String awaywin = map.get("awaywin");
                String awayloss = map.get("awayloss");
                String winScale = map.get("WinScale");
                String state = map.get("state");
                String homeOrder = map.get("homeOrder");
                String awayOrder = map.get("awayOrder");
                String totalOrder = map.get("TotalOrder");
                String homeScore = map.get("HomeScore");
                String homeLossScore = map.get("HomeLossScore");
                String awayScore = map.get("awayScore");
                String awayLossScore = map.get("awayLossScore");
                String near10Win = map.get("Near10Win");
                String near10loss = map.get("Near10loss");
                BasketballTeamRank basketballTeamRank = BasketballTeamRank.builder().league(league).teamId(teamID).name(name).matchSeason(matchSeason).homeWin(homewin).homeLoss(homeloss)
                        .awayWin(awaywin).awayLoss(awayloss).winScale(winScale).state(state).homeOrder(homeOrder).awayOrder(awayOrder).totalOrder(totalOrder).homeScore(homeScore).homeLossScore(homeLossScore)
                        .awayScore(awayScore).awayLossScore(awayLossScore).near10Win(near10Win).near10Loss(near10loss).build();
                if(basketballTeamService.getBasketballRankById(teamID)!=null){
                    basketballTeamService.update(basketballTeamRank);
                }else{
                    basketballTeamService.insert(basketballTeamRank);
                }
                Thread.sleep(20000);// 睡眠20秒
            }
            }
        }catch (Exception e){
            LogUtil.error(e);
        }
    }

//        @Scheduled(cron = "0 0 0 0/1 * ?")//每隔一天处理一次
//    @Scheduled(cron = "0/60 * * * * ?")//每隔10秒处理一次
    public void getFootballLeagueTeam(){      //每天获取一次足球联赛信息
        try{
            String s = HttpUtil.get("http://interface.win007.com/zq/League_XML.aspx", "");
//            String s = HttpUtil.sendGet("https://www.baidu.com", "");
            List<Map<String, String>> maps = XmlDom4jUtil.iterateWholeXML(s);
            for (Map<String, String> map :maps) {
                String id = map.get("id");
                String color = map.get("color");
                String gb_short = map.get("gb_short");
                if(id.equals(625)){
                    gb_short="瑞超";
                }else if(id.equals(1350)){
                    gb_short="墨超";
                }else if(id.equals(4)){
                    gb_short="巴甲";
                }else if(id.equals(284)){
                    gb_short="日乙";
                }else if(id.equals(21)){
                    gb_short="美职足";
                }else if(id.equals(77)){
                    gb_short="苏联赛杯";
                }else if(id.equals(25)){
                    gb_short="日职";
                }
                String big_short = map.get("big_short");
                String en_short = map.get("en_short");
                String gb = map.get("gb");
                String big = map.get("big");
                String en = map.get("en");
                String type = map.get("type");
                String subSclass = map.get("subSclass");
                String sum_round = map.get("sum_round");
                String curr_round = map.get("curr_round");
                String Curr_matchSeason = map.get("Curr_matchSeason");
                String countryID = map.get("countryID");
                String country = map.get("country");
                String areaID = map.get("areaID");
                String countryEn = map.get("countryEn");
                String logo = map.get("logo");
                String countryLogo = map.get("countryLogo");
                FootballLeague footballLeague = FootballLeague.builder().id(StringUtil.String2Integer(id)).color(color).gbShort(gb_short).bigShort(big_short).enShort(en_short)
                        .gb(gb).big(big).en(en).type(type).subsclass(subSclass).sumRound(sum_round).currRound(curr_round).currMatchSeason(Curr_matchSeason).countryId(countryID).country(country)
                        .areaId(StringUtil.String2Integer(areaID)).countryEn(countryEn).logo(logo).countrLogo(countryLogo).build();
                if(footballLeagueService.getById(StringUtil.String2Integer(id))!=null){
                    footballLeagueService.update(footballLeague);
                }else{
                    footballLeagueService.insert(footballLeague);
                }
            }
        }catch (Exception e){
            LogUtil.error(e);
        }
    }

//    @Scheduled(cron = "0 0 0 0/1 * ?")//每隔一天处理一次
//    @Scheduled(cron = "0/10 * * * * ?")//每隔10秒处理一次
    public void getBasketballLeagueTeam(){      //每天获取一次篮球联赛信息
        try{
            String s = HttpUtil.get("http://interface.win007.com/lq/LqLeague_Xml.aspx", "");
//            String s = HttpUtil.sendGet("https://www.baidu.com", "");
            List<Map<String, String>> maps = XmlDom4jUtil.iterateWholeXML(s);
            for (Map<String, String> map :maps) {
                String id = map.get("id");
                String color = map.get("color");
                String ashort = map.get("short");
                String gb = map.get("gb");
                String big = map.get("big");
                String en = map.get("en");
                String type = map.get("type");
                String Curr_matchSeason = map.get("Curr_matchSeason");
                String countryID = map.get("countryID");
                String country = map.get("country");
                String curr_year = map.get("curr_year");
                String curr_month = map.get("curr_month");
                String sclass_kind = map.get("sclass_kind");
                String sclass_time = map.get("sclass_time");
                BasketballLeague basketballLeague = BasketballLeague.builder().id(StringUtil.String2Integer(id)).color(color).ashort(ashort).gb(gb).big(big)
                        .en(en).type(type).currMatchseason(Curr_matchSeason).countryId(countryID).country(country).currYear(curr_year).currMonth(curr_month).sclassKind(sclass_kind).sclassTime(sclass_time).build();
                if(basketballLeagueService.getById(StringUtil.String2Integer(id))!=null){
                    basketballLeagueService.update(basketballLeague);
                }else{
                    basketballLeagueService.insert(basketballLeague);
                }
            }
        }catch (Exception e){
            LogUtil.error(e);
        }
    }

}
