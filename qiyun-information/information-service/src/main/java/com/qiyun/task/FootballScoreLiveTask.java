package com.qiyun.task;

import com.qiyun.httpUtil.HttpUtil;
import com.qiyun.model2.BasketballTeam2;
import com.qiyun.model2.FootballTeam2;
import com.qiyun.service.ScoreLiveFootballNowDayService;
import com.qiyun.serviceImpl.BasketballTeamServiceImpl;
import com.qiyun.serviceImpl.FootballTeamServiceImpl;
import com.qiyun.util.LogUtil;
import com.qiyun.util.StringUtil;
import com.qiyun.util.XmlDom4jUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
@Lazy(value=false)
public class FootballScoreLiveTask {

    @Autowired
    private ScoreLiveFootballNowDayService scoreLiveFootballNowDayService;

    @Autowired
    private FootballTeamServiceImpl footballTeamService;

    @Autowired
    private BasketballTeamServiceImpl  basketballTeamService;


//    @Scheduled(cron = "0 0 0 0/1 * ?")//每隔一天处理一次
//    @Scheduled(cron = "0 0 0/1 * * ?")//每隔一小时处理一次
    public void getBasketballTeam(){      //每天获取一次篮球球队信息
        try{
            String s = HttpUtil.get("http://interface.win007.com/lq/LqTeam_Xml.aspx", "");
//            String s = HttpUtil.sendGet("https://www.baidu.com", "");
            List<Map<String, String>> maps = XmlDom4jUtil.iterateWholeXML(s);
            for (Map<String, String> map :maps) {
                String id = map.get("id");
                if(id.equals(1866)){
                    continue;
                }
                String lsID = map.get("lsID");
                String aShort = map.get("short");
                String gb = map.get("gb");
                String big5 = map.get("big5");
                String en = map.get("en");
                String logo = map.get("logo");
                if(logo!=null&&logo!=""){
                    logo = "http://nba.win007.com/"+logo;
                }
                String url = map.get("url");
                String locationID = map.get("LocationID");
                String matchAddrID = map.get("MatchAddrID");
                String city = map.get("City");
                String gymnasium = map.get("Gymnasium");
                String capacity = map.get("Capacity");
                String joinYear = map.get("JoinYear");
                String firstTime = map.get("FirstTime");
                String drillmaster = map.get("Drillmaster");
                BasketballTeam2 basketballTeam2 = BasketballTeam2.builder().id(StringUtil.String2Integer(id)).lsId(StringUtil.String2Integer(lsID)).ashort(aShort)
                        .gb(gb).big5(big5).en(en).logo(logo).url(url).locationId(StringUtil.String2Integer(locationID)).matchAddrId(StringUtil.String2Integer(matchAddrID)).city(city).gymnasium(gymnasium).capacity(StringUtil.String2Integer(capacity)).joinYear(StringUtil.String2Integer(joinYear))
                        .firstTime(StringUtil.String2Integer(firstTime)).drillmaster(drillmaster).build();
                if(basketballTeamService.getById(StringUtil.String2Integer(id))!=null){
                    basketballTeamService.update(basketballTeam2);
                }else{
                    basketballTeamService.insert(basketballTeam2);
                }
            }
        }catch (Exception e){
            LogUtil.error(e);
        }
    }

//    @Test
//    @Scheduled(cron = "0 0 0 0/1 * ?")//每隔一天处理一次
//    @Scheduled(cron = "0 0 0/1 * * ?")//每隔一天处理一次
    public void getFootballTeam(){      //每天获取一次足球球队信息
        try{
            String s = HttpUtil.get("http://interface.win007.com/zq/Team_XML.aspx", "");
//            String s = HttpUtil.sendGet("https://www.baidu.com", "");
//        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
//                "\n" +
//                "<list>\n" +
//                "  <i>\n" +
//                "    <id>7</id>\n" +
//                "    <lsID>1426</lsID>\n" +
//                "    <g>格拉茨AK</g>\n" +
//                "    <b>格拉茨AK</b>\n" +
//                "    <e>Grazer AK</e>\n" +
//                "    <Found>1902-8-18</Found>\n" +
//                "    <Area>奥地利</Area>\n" +
//                "    <gym>阿诺德·施瓦泽内格球场</gym>\n" +
//                "    <Capacity/>\n" +
//                "    <Flag>images/20130422073127.png</Flag>\n" +
//                "    <addr>Stadionplatz 18041Graz</addr>\n" +
//                "    <URL>http://www.gak.at/</URL>\n" +
//                "    <master/>\n" +
//                "  </i>\n" +
//                "  <i>\n" +
//                "    <id>8</id>\n" +
//                "    <lsID>3</lsID>\n" +
//                "    <g>奥地利维也纳</g>\n" +
//                "    <b>奧地利維也納</b>\n" +
//                "    <e>Austria Wien</e>\n" +
//                "    <Found>1911</Found>\n" +
//                "    <Area>维也纳</Area>\n" +
//                "    <gym>弗拉兹霍尔球场</gym>\n" +
//                "    <Capacity>12200</Capacity>\n" +
//                "    <Flag>images/20130404135642.png</Flag>\n" +
//                "    <addr>Fischhofgasse 14 1100 Wien</addr>\n" +
//                "    <URL>http://www.fk-austria.at</URL>\n" +
//                "    <master>托马斯里斯</master>\n" +
//                "  </i>\n" +
//                "  <i>\n" +
//                "    <id>9</id>\n" +
//                "    <lsID>3</lsID>\n" +
//                "    <g>萨尔茨堡</g>\n" +
//                "    <b>薩爾斯堡</b>\n" +
//                "    <e>Red Bull Salzburg</e>\n" +
//                "    <Found>1933-1-1</Found>\n" +
//                "    <Area>奥地利</Area>\n" +
//                "    <gym>萨尔茨堡红牛竞技场</gym>\n" +
//                "    <Capacity>30000</Capacity>\n" +
//                "    <Flag>images/20130404153002.png</Flag>\n" +
//                "    <addr>Stadionstrasse1Stiege35071Wals-Siezenheim</addr>\n" +
//                "    <URL>http://www.austria-salzburg.at/</URL>\n" +
//                "    <master>马可·罗斯</master>\n" +
//                "  </i>\n" +
//                "  <i>\n" +
//                "    <id>10</id>\n" +
//                "    <lsID>3</lsID>\n" +
//                "    <g>阿德米拉</g>\n" +
//                "    <b>艾特米拿</b>\n" +
//                "    <e>Trenkwalder Admira Wacker</e>\n" +
//                "    <Found>1905</Found>\n" +
//                "    <Area>奥地利</Area>\n" +
//                "    <gym>坦恩沃尔得球场</gym>\n" +
//                "    <Capacity>12000</Capacity>\n" +
//                "    <Flag>images/20130404153336.png</Flag>\n" +
//                "    <addr>Verein fur Ball Herold Admira Wacker Modling Franz HOCHLEUTNER Sportanlage Duursmagasse A-2340 MODLING Austria</addr>\n" +
//                "    <URL>http://www.admira-wacker-moedling.at/</URL>\n" +
//                "    <master>迈斯特</master>\n" +
//                "  </i>\n" +
//                "  <i>\n" +
//                "    <id>11</id>\n" +
//                "    <lsID>96</lsID>\n" +
//                "    <g>奥地利卡尔腾</g>\n" +
//                "    <b>奥地利卡尔腾</b>\n" +
//                "    <e>Austria Karnten</e>\n" +
//                "    <Found>2007</Found>\n" +
//                "    <Area>奥地利</Area>\n" +
//                "    <gym>瓦尔德球场</gym>\n" +
//                "    <Capacity>32000</Capacity>\n" +
//                "    <Flag>images/20071271212516190.gif</Flag>\n" +
//                "    <addr>Pluskaufstrasse114061Pasching</addr>\n" +
//                "    <URL>http://www.svpasching.at/</URL>\n" +
//                "    <master>弗伦基·申凯尔斯</master>\n" +
//                "  </i>\n" +
//                "  <i>\n" +
//                "    <id>12</id>\n" +
//                "    <lsID>3</lsID>\n" +
//                "    <g>维也纳快速</g>\n" +
//                "    <b>維也納迅速</b>\n" +
//                "    <e>Rapid Wien</e>\n" +
//                "    <Found>1899-1-1</Found>\n" +
//                "    <Area>维也纳</Area>\n" +
//                "    <gym>格尔哈德哈纳皮球场</gym>\n" +
//                "    <Capacity>17500</Capacity>\n" +
//                "    <Flag>images/20130406101237.png</Flag>\n" +
//                "    <addr>Keisslergasse61140Wien</addr>\n" +
//                "    <URL>http://www.skrapid.at/</URL>\n" +
//                "    <master>戈兰·古里金</master>\n" +
//                "  </i>\n" +
//                "  <i>\n" +
//                "    <id>13</id>\n" +
//                "    <lsID>3</lsID>\n" +
//                "    <g>马特斯堡</g>\n" +
//                "    <b>馬特斯堡</b>\n" +
//                "    <e>Mattersburg</e>\n" +
//                "    <Found>1922-6-10</Found>\n" +
//                "    <Area>马特斯堡</Area>\n" +
//                "    <gym>帕佩尔球场</gym>\n" +
//                "    <Capacity>15700</Capacity>\n" +
//                "    <Flag>images/20130406101859.png</Flag>\n" +
//                "    <addr>Michael-Koch-Strasse50Postfach417210Mattersburg</addr>\n" +
//                "    <URL>http://www.sv-mattersburg.at/</URL>\n" +
//                "    <master>杰拉尔·鲍姆加特纳</master>\n" +
//                "  </i>\n" +
//                "  <i>\n" +
//                "    <id>14</id>\n" +
//                "    <lsID>3</lsID>\n" +
//                "    <g>格拉茨风暴</g>\n" +
//                "    <b>格拉茨</b>\n" +
//                "    <e>Sturm Graz</e>\n" +
//                "    <Found>1909-5-10</Found>\n" +
//                "    <Area>格拉茨</Area>\n" +
//                "    <gym>UPC球场</gym>\n" +
//                "    <Capacity>15322</Capacity>\n" +
//                "    <Flag>images/20130406102542.png</Flag>\n" +
//                "    <addr>EggenbergerGurtel98020Graz</addr>\n" +
//                "    <URL>http://www.sksturm.at/</URL>\n" +
//                "    <master>福格尔</master>\n" +
//                "  </i>\n" +
//                "  <i>\n" +
//                "    <id>15</id>\n" +
//                "    <lsID>1514</lsID>\n" +
//                "    <g>布雷根茨</g>\n" +
//                "    <b>布雷根茨</b>\n" +
//                "    <e>SC Bregenz</e>\n" +
//                "    <Found>1919</Found>\n" +
//                "    <Area>布雷根茨</Area>\n" +
//                "    <gym>卡西诺球场</gym>\n" +
//                "    <Capacity/>\n" +
//                "    <Flag>images/20130425195408.png</Flag>\n" +
//                "    <addr>Sagerstrasse16900Bregenz</addr>\n" +
//                "    <URL>http://www.swbregenz.at/</URL>\n" +
//                "    <master/>\n" +
//                "  </i>\n" +
//                "  <i>\n" +
//                "    <id>16</id>\n" +
//                "    <lsID>3</lsID>\n" +
//                "    <g>瓦克蒂罗尔</g>\n" +
//                "    <b>恩斯布魯克</b>\n" +
//                "    <e>FC Wacker Innsbruck</e>\n" +
//                "    <Found>1913</Found>\n" +
//                "    <Area>因斯布鲁克</Area>\n" +
//                "    <gym>蒂沃里纽乌球场</gym>\n" +
//                "    <Capacity>31000</Capacity>\n" +
//                "    <Flag>images/20130406111402.png</Flag>\n" +
//                "    <addr>Feldstra&amp;szlig;e 9 6020 Innsbruck</addr>\n" +
//                "    <URL>http://www.fc-wacker-tirol.com/</URL>\n" +
//                "    <master>卡尔·达克斯巴赫尔</master>\n" +
//                "  </i>" +
//                "</list>";
            List<Map<String, String>> maps = XmlDom4jUtil.iterateWholeXML(s);
            for (Map<String, String> map :maps) {
                String id = map.get("id");
                String lsID = map.get("lsID");
                String g = map.get("g");
                String b = map.get("b");
                String e = map.get("e");
                String found = map.get("Found");
                String area = map.get("Area");
                String gym = map.get("gym");
                String capacity = map.get("Capacity");
                String flag = map.get("Flag");
                if(flag!=null&&flag!=""){
                    flag = "http://zq.win007.com/Image/team/"+flag;
                }
                String addr = map.get("addr");
                String url = map.get("URL");
                String master = map.get("master");
                FootballTeam2 footballTeam2 = FootballTeam2.builder().id(StringUtil.String2Integer(id)).lsId(StringUtil.String2Integer(lsID)).g(g).b(b).e(e).found(found).area(area)
                        .gym(gym).capacity(capacity).flag(flag).addr(addr).url(url).master(master).build();
                if(footballTeamService.getById(StringUtil.String2Integer(id))!=null){
                    footballTeamService.update(footballTeam2);
                }else{
                    footballTeamService.insert(footballTeam2);
                }
            }
        }catch (Exception e){
            LogUtil.error(e);
        }
    }

//    @Scheduled(cron = "0 */1 * * * ?")//每隔一分钟处理一次
//    @Test
//    public void getNowDayScore() throws Exception {
////        String s = HttpUtil.sendGet("http://interface.feijing88.com/zq/today.aspx", "language=sb");
//        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
//                "\n" +
//                "<list>\n" +
//                "  <match>\n" +
//                "    <ID>1592730</ID>\n" +
//                "    <color>#669955</color>\n" +
//                "    <leagueID>1817</leagueID>\n" +
//                "    <kind>1</kind>\n" +
//                "    <level>0</level>\n" +
//                "    <league>墨女超,墨女超,Mex MFW</league>\n" +
//                "    <subLeague/>\n" +
//                "    <subLeagueID/>\n" +
//                "    <time>2018/8/7 8:00:00</time>\n" +
//                "    <time2>2018/8/7 9:03:45</time2>\n" +
//                "    <home>帕丘卡女足,帕丘卡女足,Pachuca Women,34305</home>\n" +
//                "    <away>普马斯女足,普馬斯女足,Unam Pumas Women,34159</away>\n" +
//                "    <state>3</state>\n" +
//                "    <homeScore>1</homeScore>\n" +
//                "    <awayScore>0</awayScore>\n" +
//                "    <bc1>1</bc1>\n" +
//                "    <bc2>0</bc2>\n" +
//                "    <red1>0</red1>\n" +
//                "    <red2>0</red2>\n" +
//                "    <yellow1>1</yellow1>\n" +
//                "    <yellow2>1</yellow2>\n" +
//                "    <order1/>\n" +
//                "    <order2/>\n" +
//                "    <explain><![CDATA[]]></explain>\n" +
//                "    <zl>False</zl>\n" +
//                "    <tv><![CDATA[]]></tv>\n" +
//                "    <lineup/>\n" +
//                "    <explain2><![CDATA[]]></explain2>\n" +
//                "    <corner1>1</corner1>\n" +
//                "    <corner2>8</corner2>\n" +
//                "  </match> <match>\n" +
//                "    <ID>1592729</ID>\n" +
//                "    <color>#669955</color>\n" +
//                "    <leagueID>1817</leagueID>\n" +
//                "    <kind>1</kind>\n" +
//                "    <level>0</level>\n" +
//                "    <league>墨女超,墨女超,Mex MFW</league>\n" +
//                "    <subLeague/>\n" +
//                "    <subLeagueID/>\n" +
//                "    <time>2018/8/7 7:00:00</time>\n" +
//                "    <time2>2018/8/7 8:02:19</time2>\n" +
//                "    <home>托卢卡女足,托盧卡女足,Toluca Women,34160</home>\n" +
//                "    <away>克鲁兹女足,克鲁兹女足,Cruz Azul Women,34141</away>\n" +
//                "    <state>-1</state>\n" +
//                "    <homeScore>5</homeScore>\n" +
//                "    <awayScore>0</awayScore>\n" +
//                "    <bc1>3</bc1>\n" +
//                "    <bc2>0</bc2>\n" +
//                "    <red1>0</red1>\n" +
//                "    <red2>1</red2>\n" +
//                "    <yellow1>1</yellow1>\n" +
//                "    <yellow2>2</yellow2>\n" +
//                "    <order1/>\n" +
//                "    <order2/>\n" +
//                "    <explain><![CDATA[]]></explain>\n" +
//                "    <zl>False</zl>\n" +
//                "    <tv><![CDATA[]]></tv>\n" +
//                "    <lineup/>\n" +
//                "    <explain2><![CDATA[]]></explain2>\n" +
//                "    <corner1>6</corner1>\n" +
//                "    <corner2>6</corner2>\n" +
//                "  </match>\n" +
//                "</list>";
////        Map<String, String> stringStringMap = XmlDom4jUtil.xml2Map(xml);
////        for (String key : stringStringMap.keySet()) {
////            System.out.println(key + ":" + stringStringMap.get(key));
////        }
//        JSONObject jsonObject = XmlDom4jUtil.xmltoJson(xml);
//        System.out.println(jsonObject);
//        List<Map<String, String>> maps = XmlDom4jUtil.iterateWholeXML(xml);
//        for (Map<String, String> map :maps) {
//            String ID = map.get("ID");
//            String color = map.get("color");
//            String leagueID = map.get("leagueID");
//            String kind = map.get("kind");
//            String level = map.get("level");
//            String league = map.get("league");
//            String subLeague = map.get("subLeague");
//            String subLeagueID = map.get("subLeagueID");
//            String time = map.get("time");
//            String time2 = map.get("time2");
//            String home = map.get("home");
//            String away = map.get("away");
//            String state = map.get("state");
//            String homeScore = map.get("homeScore");
//            String awayScore = map.get("awayScore");
//            String bc1 = map.get("bc1");
//            String bc2 = map.get("bc2");
//            String red1 = map.get("red1");
//            String red2 = map.get("red2");
//            String yellow1 = map.get("yellow1");
//            String yellow2 = map.get("yellow2");
//            String order1 = map.get("order1");
//            String order2 = map.get("order2");
//            String explain = map.get("explain");
//            String zl = map.get("zl");
//            String tv = map.get("tv");
//            String lineup = map.get("lineup");
//            String explain2 = map.get("explain2");
//            String corner1 = map.get("corner1");
//            String corner2 = map.get("corner2");
////            for (String key : map.keySet()) {
////            System.out.println(key + ":" + map.get(key));
////          }
//            ScoreliveFootballNowday scoreliveFootballNowday =
//                    ScoreliveFootballNowday.builder().id(StringUtil.String2Integer(ID)).color(color).leagueId(StringUtil.String2Integer(leagueID))
//                    .kind(StringUtil.String2Integer(kind)).level(StringUtil.String2Integer(level)).league(league).subLeague(subLeague).subLeagueId(StringUtil.String2Integer(subLeagueID))
//                    .time(DateUtil.StringToDate3(time)).time2(DateUtil.StringToDate3(time2)).home(home).away(away).state(StringUtil.String2Integer(state))
//                    .homeScore(StringUtil.String2Integer(homeScore)).awayScore(StringUtil.String2Integer(awayScore)).bc1(StringUtil.String2Integer(bc1)).bc2(StringUtil.String2Integer(bc2))
//                    .red1(StringUtil.String2Integer(red1)).red2(StringUtil.String2Integer(red2)).yellow1(StringUtil.String2Integer(yellow1)).yellow2(StringUtil.String2Integer(yellow2))
//                    .order1(order1).order2(order2).explain(explain).explain2(explain2).zl(zl).tv(tv).lineup(lineup).corner1(StringUtil.String2Integer(corner1)).corner2(StringUtil.String2Integer(corner2))
//                    .build();
//            ScoreliveFootballNowday scoreLiveFootballNowDayServiceById = scoreLiveFootballNowDayService.getById(StringUtil.String2Integer(ID));
//            if(scoreLiveFootballNowDayServiceById == null){
//                scoreLiveFootballNowDayService.insert(scoreliveFootballNowday);
//            }else {
//                scoreLiveFootballNowDayService.update(scoreliveFootballNowday);
//            }
//        }
//    }

//    @Test
    public  void test(){
        String result = "318408^2^1^WNBA,WNBA^4^#446DAB^2018/8/10 7:00:00^-1^^2013^亚特兰大梦想,阿特蘭大夢想^71^洛杉矶火花,洛杉磯火花^1^^2^79^73^13^17^23^16^27^22^16^18^0^" +
                "True^^梦想-得分:J.比兰特(19) 篮板:J.比兰特(9) 助攻:宾利(8)<br>火花-得分:帕克(20) 篮板:帕克(12) 助攻:帕克(4)^0^18   赛季^常规赛^^^^^^^^^^^^";
        String[] split = result.split("\\^");
        for (String str:split
             ) {
            System.out.println(str);
        }
//        Date date = DateUtil.StringToDate3(result);
//        System.out.println(date);
//        String s = DateUtil.dateToString2(date);
//        System.out.println(s);
    }



//    @Scheduled(cron = "*/10 * * * * ?")//每隔10秒处理一次
    @Test
    public void getNowTimeScore() throws Exception {
//        String s = HttpUtil.sendGet("http://interface.feijing88.com/zq/change.xml","");
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "\n" +
                "<c refresh=\"0\">\n" +
                "  <h><![CDATA[1570622^3^2^0^2^0^0^0^08:30^2018,7,8,09,37,55^<a href=http://www.310tv.com/zhibo/saishizhibo7_1570622.html  target=_blank><font color=blue>310TV</font></a>&nbsp;&nbsp;<a href=http://www.310tv.com/zhibo/cctv5_1570622.html  target=_blank><font color=blue>CCTV5</font></a>^1^1^0^8-8^^3^4^1]]></h>\n" +
                "  <h><![CDATA[1586717^3^2^1^2^1^0^0^08:45^2018,7,8,09,48,27^<a href=http://www.310tv.com/zhibo/saishizhibo8_1586717.html  target=_blank><font color=blue>310TV</font></a>^1^2^2^8-8^^2^2^1]]></h>\n" +
                "</c>\n";
//        JSONObject jsonObject = XmlDom4jUtil.xmltoJson(xml);
//        System.out.println(jsonObject);
//        Map<String, String> stringStringMap = XmlDom4jUtil.xml2Map(xml);
        List<Map<String, String>> maps = XmlDom4jUtil.iterateWholeXML1(xml);
                for (Map<String, String> map:maps) {
                    for (String key : map.keySet()) {
                        System.out.println(key + ":" + map.get(key));
                        String s = map.get(key);
                        String[] split = s.split("\\^");
                        if(split.length==18){

                        }
                    }
                }

//        for (Map<String, String> map:maps) {
//          for (String key : map.keySet()) {
////            System.out.println(key + ":" + map.get(key));
//              String s = map.get(key);
//              String[] split = s.split("\\^");
//              for (String str:split) {
//                  System.out.print(str+" - ");
//              }
//              Integer ID = StringUtil.String2Integer(split[0]); //比赛ID
//              Integer state = StringUtil.String2Integer(split[1]); //比赛状态
//              Integer homeScore = StringUtil.String2Integer(split[2]); //主队比分
//              Integer awayScore = StringUtil.String2Integer(split[3]); //主队比分
//              Integer bc1 = StringUtil.String2Integer(split[4]); //主队上半场比分
//              Integer bc2 = StringUtil.String2Integer(split[5]); //主队上半场比分
//              Integer red1 = StringUtil.String2Integer(split[6]); //主队红牌
//              Integer red2 = StringUtil.String2Integer(split[7]); //客队红牌
//              System.out.println();
//          }
//        }

    }

}
