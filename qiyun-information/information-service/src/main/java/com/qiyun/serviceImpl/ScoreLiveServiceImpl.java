package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.qiyun.dto.*;
import com.qiyun.dto.FootballEventDTO;
import com.qiyun.mapper2.*;
import com.qiyun.model2.*;
import com.qiyun.model2.FootballTechnic;
import com.qiyun.service.ScoreLiveFootballNowDayService;
import com.qiyun.service.ScoreLiveService;
import com.qiyun.util.Constants;
import com.qiyun.util.DateUtil;
import com.qiyun.util.StringUtil;
import com.qiyun.util.XmlDom4jUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ScoreLiveServiceImpl implements ScoreLiveService {


    @Autowired
    private FootballTeam2Mapper footballTeam2Mapper;

    @Autowired
    private BasketballTeam2Mapper basketballTeam2Mapper;

    @Autowired
    private FootballLeagueMapper footballLeagueMapper;

    @Autowired
    private BasketballLeagueMapper basketballLeagueMapper;

    @Autowired
    private FootballEventMapper footballEventMapper;

    @Autowired
    private FootballTechnicMapper footballTechnicMapper;

    @Autowired
    private MatchBetMappingMapper matchBetMappingMapper;

    @Autowired
    private ScoreliveFootballNowdayMapper scoreliveFootballNowdayMapper;



    @Test
    public void test() throws Exception {
//        Map<String, String> stringStringMap = XmlDom4jUtil.xml2Map(xml);
        String str = "0,,*";
        String[] split = str.split(",");
        for (String strr:split
             ) {
            System.out.println(strr);
            System.out.println(split.length);
        }
    }



    public List<BasketballLiveExplain0> getBasketballLive(String xml) {
        String[] split = xml.split("\\$");  //篮球小节数组
        List<BasketballLiveExplain0> basketballLiveExplain0s = new ArrayList<BasketballLiveExplain0>();
        int js = 1;
        for (String str:split) {
            List<BasketballLiveExplain1> basketballLiveExplain1s = new ArrayList<BasketballLiveExplain1>();
            String[] split1 = str.split("\\!");   //篮球记录数组
            for (String strr:split1) {
                BasketballLiveExplain1 basketballLiveExplain1 = new BasketballLiveExplain1();
                List<BasketballLiveExplain2>basketballLiveExplain2s = new ArrayList<BasketballLiveExplain2>();
                String[] split2 = strr.split("\\^");//每个字段数组
                BasketballLiveExplain2 basketballLiveExplain2 = BasketballLiveExplain2.builder().remainTime(split2[0]).Sign(split2[1]).homeScore(split2[2]).awayScore(split2[3]).content(split2[4]).js(js+"节").build();
                basketballLiveExplain2s.add(basketballLiveExplain2);
                basketballLiveExplain1.setBasketballExplain2(basketballLiveExplain2s);
                basketballLiveExplain1s.add(basketballLiveExplain1);
            }
            BasketballLiveExplain0 basketballLiveExplain0 = new BasketballLiveExplain0();
            Collections.reverse(basketballLiveExplain1s);
            basketballLiveExplain0.setBasketballExplain1(basketballLiveExplain1s);
            basketballLiveExplain0s.add(basketballLiveExplain0);
            js++;
        }
        Collections.reverse(basketballLiveExplain0s);
        return basketballLiveExplain0s;
    }

    public Map<String, Object> getFootballLive(String id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Integer integer = StringUtil.String2Integer(id);
//            Integer maxVersion = footballEventMapper.getMaxVersion(integer);
            List<FootballEvent> footballEvents = footballEventMapper.selectById(integer);
            if(footballEvents==null||footballEvents.size()==0){
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, "暂无直播数据");
                return map;
            }
//            List<FootballEvent> footballEvents = footballEventMapper.selectByIdAndVersion(integer, maxVersion);
            FootballTechnic footballTechnic = footballTechnicMapper.selectByPrimaryKey(integer);
            if(footballTechnic!=null){
                String connect = footballTechnic.getConnect();
                String[] split = connect.split(";");
                StringBuffer stringBuffer = new StringBuffer();
                for (String str:split) {
                    String[] split1 = str.split(",");
                    String s = split1[0];
                    if(s.equals("11")||s.equals("12")||s.equals("13")||s.equals("15")||s.equals("16")||s.equals("18")||s.equals("23")||s.equals("29")||s.equals("34")||s.equals("35")||s.equals("40")||s.equals("42")){
                        String type = getType(StringUtil.String2Integer(s));
                        String strr = split1[1]+","+type+","+split1[2];
                        stringBuffer.append(strr+"^");
                    }
                    if(s.equals("0")||s.equals("1")||s.equals("2")||s.equals("25")||s.equals("26")||s.equals("27")||s.equals("28")||s.equals("30")||s.equals("31")){
                        String strr = "";
                        if(split1.length==2){
                            String type = getType(StringUtil.String2Integer(s));
                            strr = "1,"+type+",0";
                        }else if(split1.length==3){
                            String type = getType(StringUtil.String2Integer(s));
                            strr = "0,"+type+",1";
                        }
                        stringBuffer.append(strr+"^");
                    }
                }
                if(stringBuffer.length()>=3){
                    map.put("footballTechnic",stringBuffer.substring(0,stringBuffer.length()-1));
                }else {
                    map.put("footballTechnic",stringBuffer);
                }
            }else{
                map.put("footballTechnic",footballTechnic);
            }
            if(footballEvents.size()==0||footballEvents==null){
                map.put("footballEvents","暂无直播数据");
            }else {
                map.put("footballEvents",footballEvents);
            }
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取足球直播出错");
            return map;
        }

    }

    public List<ScoreliveFootballNowTimeDTO> getFootballNowTime(String xml) {
        List<ScoreliveFootballNowTimeDTO> ScoreliveFootballNowTimeDTOs = new ArrayList<ScoreliveFootballNowTimeDTO>();
        List<Map<String, String>> maps = XmlDom4jUtil.iterateWholeXML1(xml);
        for (Map<String, String> map:maps) {
            for (String key : map.keySet()) {
                System.out.println(key + ":" + map.get(key));
                String s = map.get(key);
                String[] split = s.split("\\^");
//                if(split.length!=18){
//                    return null;
//                }
                Date date = DateUtil.StringToDate4(split[9]);
                String s1 = DateUtil.dateToString2(date);
                ScoreliveFootballNowTimeDTO scoreliveFootballNowTimeDTO = ScoreliveFootballNowTimeDTO.builder().id(split[0]).state(split[1]).homeScore(split[2]).awayScore(split[3]).bc1(split[4]).bc2(split[5]).red1(split[6]).red2(split[7])
                        .time(split[8]).time2(s1).explain(split[10]).lineup(split[11]).yellow1(split[12]).yellow2(split[13]).time3(split[14]).explain2(split[15]).corner1(split[16]).corner2(split[17]).build();
                ScoreliveFootballNowTimeDTOs.add(scoreliveFootballNowTimeDTO);
            }
        }
        return ScoreliveFootballNowTimeDTOs;
    }

    public Map<String, Object> getBasketballballNowDay(String xml,int offset,int pageSize) {
        try {
            Map<String, Object> mapp = new HashMap<String, Object>();
            List<ScoreliveBasketBallNowDayDTO> scoreliveBasketBallNowDayDTOS = new ArrayList<ScoreliveBasketBallNowDayDTO>();
            List<Map<String, String>> maps = XmlDom4jUtil.iterateWholeXML1(xml);
            List<Map<String, String>>mapss= new ArrayList<Map<String, String>>();
            for (Map<String, String> map:maps) {
                for (String key : map.keySet()) {
                    String s = map.get(key);
                    String[] split = s.split("\\^");
                    if(split[1].equals("2")||split[1].equals("1")){   //筛选NBA和WNBA的赛事
                        mapss.add(map);
                    }

                }
            }
            int size = mapss.size();
            List<Map<String, String>>maps2= new ArrayList<Map<String, String>>();
            if(offset*pageSize>size){   //最后一页
                offset -= 1;
                for (int i=0;i<size-(offset*pageSize);i++){
                    maps2.add(mapss.get((pageSize*offset)+i));
                }
            }else{      //不是最后一页
                offset -= 1;
                for (int i=0;i<pageSize;i++){
                    maps2.add(mapss.get((pageSize*offset)+i));
                }
            }
            for (Map<String, String> map:maps2) {
                for (String key : map.keySet()) {
                    System.out.println(key + ":" + map.get(key));
                    String s = map.get(key);
                    String[] split = s.split("\\^");
                    Date date = DateUtil.StringToDate3(split[6]);
                    Calendar calendar = Calendar.getInstance();
                    String time = null ;
                    if(date != null){
                        calendar.setTime(date);
                        int Hhour = calendar.get(Calendar.HOUR_OF_DAY);
                        int i = calendar.get(Calendar.MINUTE);
                        String i1 = i+"";
                        if(i<10){
                            i1="0"+i;
                        }
                        time = Hhour+":"+i1;
                    }
                    BasketballLeague basketballLeague = basketballLeagueMapper.selectByPrimaryKey(StringUtil.String2Integer(split[1]));
//                    String league = split[3];
//                    String[] split1 = league.split(",");
//                    String league2 = split1[0];
////                    String home = split[10];
////                    String[] split2 = home.split(",");
//                    String home2 = split2[0];
//                    String away = split[12];
//                    String[] split3 = away.split(",");
//                    String away2 = split3[0];
                    String homeid = split[9];
                    BasketballTeam2 home = basketballTeam2Mapper.selectByPrimaryKey(StringUtil.String2Integer(homeid));
                    String awayid = split[11];
                    BasketballTeam2 away = basketballTeam2Mapper.selectByPrimaryKey(StringUtil.String2Integer(awayid));
                    //36
                    String s1 = DateUtil.dateToString2(date);
                    ScoreliveBasketBallNowDayDTO scoreliveBasketBallNowDayDTO = ScoreliveBasketBallNowDayDTO.builder().id(split[0]).leagueId(split[1]).type(split[2]).league(basketballLeague).sectionCount(split[4]).color(split[5]).time(time).state(split[7])
                            .remainTime(split[8]).homeId(split[9]).home(home).awayId(split[11]).away(away).order1(split[13]).order2(split[14]).homeScore(split[15]).awayScore(split[16]).zd1(split[17]).kd1(split[18]).zd2(split[19]).kd2(split[20])
                            .zd3(split[21]).kd3(split[22]).zd4(split[23]).kd4(split[24]).addTime(split[25]).zd1ot(split[26]).kd1ot(split[27]).zd2ot(split[28]).kd2ot(split[29]).zd3ot(split[30]).kd3ot(split[31]).haveTechnical(split[32]).tv(split[33]).mark(split[34]).zl(split[35]).build();
                    scoreliveBasketBallNowDayDTOS.add(scoreliveBasketBallNowDayDTO);
                }
            }
            mapp.put("data",scoreliveBasketBallNowDayDTOS);
            mapp.put("size",size);
            return mapp;
        }catch (Exception e){
            return null;
        }
    }

    public Map<String, Object> getFootballMatch(int offset, int pageSize,int type) {
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            //先根据球探中间表获取当天的赛事id
            offset = (offset-1)*pageSize;
            Calendar calendar = Calendar.getInstance();
//            calendar.set(Calendar.DAY_OF_MONTH, 22);    //暂无数据 只用22号的  开通后注释掉
            calendar.set(Calendar.HOUR_OF_DAY, 0);// 时
            calendar.set(Calendar.MINUTE, 0);// 分
            calendar.set(Calendar.SECOND, 0);// 秒
            calendar.set(Calendar.MILLISECOND, 0);// 毫秒
            String homeScore = "";
            String awayScore = "";
            String state = 0+"";
            Date startDate = calendar.getTime();
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = format2.format(startDate);
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            Date endDate = calendar.getTime();
            String format1 = format2.format(endDate);
            List<MatchBetMapping> nowDayMacth = new ArrayList<MatchBetMapping>();
            if(type == 0){
                nowDayMacth = matchBetMappingMapper.getNowDayMacth(offset, pageSize, format, format1);
            }else if(type == 1){
                nowDayMacth = matchBetMappingMapper.getNowDayMacth1(offset, pageSize, format, format1);
            }else if(type == 2){
                nowDayMacth = matchBetMappingMapper.getNowDayMacth2(offset, pageSize, format, format1);
            }else if(type == 3){
                nowDayMacth = matchBetMappingMapper.getNowDayMacth3(offset, pageSize, format, format1);
            }else {
                map.put(Constants.CODE, Constants.ERROR_CODE_626);
                map.put(Constants.MSG, Constants.ERROR_MSG_626);
                return map;
            }
            int nowDayCount = matchBetMappingMapper.getNowDayCount(format, format1);    //当天比赛场次
            List<FootballMatchNowDayDTO> footballMatchNowDayDTOS = new ArrayList<FootballMatchNowDayDTO>();
            //根据赛事id列表去获取比赛的数据、球队信息、联赛信息
            for (MatchBetMapping matchBetMapping:nowDayMacth) { //遍历当天的竞彩比赛id
                    String idBet = matchBetMapping.getIdBet();
                    Integer integer = StringUtil.String2Integer(idBet); //竞足的id
                    String Session = matchBetMapping.getId();//场次
                    String homeId = matchBetMapping.getHomeId();
                    Integer homeId1 = StringUtil.String2Integer(homeId);    //主队id
                    String awayId = matchBetMapping.getAwayId();
                    Integer awayId1 = StringUtil.String2Integer(awayId);    //客队id
                    Date time = matchBetMapping.getTime();
                    String time2 = DateUtil.dateToString5(time);
                    String league = matchBetMapping.getLeague();
                    ScoreliveFootballNowday scoreliveFootballNowday = scoreliveFootballNowdayMapper.selectByPrimaryKey(integer);
                    if(scoreliveFootballNowday==null){
                        homeScore = 0+"";
                        awayScore = 0+"";
                        state = 0+"";
                    }else{
                        homeScore = scoreliveFootballNowday.getHomeScore();  //主队分数
                        awayScore = scoreliveFootballNowday.getAwayScore();  //客队分数
                        state = scoreliveFootballNowday.getState();
                    }
                    FootballTeam2 homeTeam = footballTeam2Mapper.selectByPrimaryKey(homeId1);   //主队信息
                    FootballTeam2 awayTeam = footballTeam2Mapper.selectByPrimaryKey(awayId1);   //客队信息
                    FootballMatchNowDayDTO footballMatchNowDayDTO = FootballMatchNowDayDTO.builder().id(integer).session(Session).time(time2).home(homeTeam).away(awayTeam)
                            .homeScore(homeScore).awayScore(awayScore).footballLeague(league).state(state).build();
                    footballMatchNowDayDTOS.add(footballMatchNowDayDTO);
            }
            String week = getWeek();
            String time2 =DateUtil.dateToString6(new Date());
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,footballMatchNowDayDTOS);
            map.put("week",week);
            map.put("date",time2);
            map.put("total",nowDayCount);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取足球比分直播出错");
            return map;
        }
    }

    public Map<String, Object> getFootballNowDay(String xml,int offset,int pageSize) {
//        try {
            Map<String, Object> mapp = new HashMap<String, Object>();
            List<ScoreliveFootballNowDayDTO> scoreliveFootballNowDayDTOS = new ArrayList<ScoreliveFootballNowDayDTO>();
            List<Map<String, String>> maps = XmlDom4jUtil.iterateWholeXML(xml);
            List<Map<String, String>>mapss= new ArrayList<Map<String, String>>();
        String s3 = DateUtil.dateToString6(new Date());
        List<Integer> nowDayLeague = footballLeagueMapper.getNowDayLeague(s3);
            for (Map<String, String> map : maps) {
                String leagueID = map.get("leagueID");
                Integer integer = StringUtil.String2Integer(leagueID);
                boolean contains = nowDayLeague.contains(integer);
                if(contains){
                    mapss.add(map);
                }
            }
            int size = mapss.size();
            List<Map<String, String>>maps2= new ArrayList<Map<String, String>>();
            if(offset*pageSize>size){   //最后一页
                offset -= 1;
                for (int i=0;i<size-(offset*pageSize);i++){
                    maps2.add(mapss.get((pageSize*offset)+i));
                }
            }else{      //不是最后一页
                offset -= 1;
                for (int i=0;i<pageSize;i++){
                    maps2.add(mapss.get((pageSize*offset)+i));
                }
            }
            for (Map<String, String> map : maps2) {
                String ID = map.get("ID");
                String color = map.get("color");
                String leagueID = map.get("leagueID");
                FootballLeague footballLeague = footballLeagueMapper.selectByPrimaryKey(StringUtil.String2Integer(leagueID));
                String kind = map.get("kind");
                String level = map.get("level");
//                String league = map.get("league");
//                String[] split1 = league.split(",");
//                String s3 = split1[0];
                String subLeague = map.get("subLeague");
                String subLeagueID = map.get("subLeagueID");
                String time = map.get("time");
                Date date = DateUtil.StringToDate3(time);
                Calendar calendar = Calendar.getInstance();
                String s = null ;
                if(date != null){
                    calendar.setTime(date);
                    int Hhour = calendar.get(Calendar.HOUR_OF_DAY);
                    int i = calendar.get(Calendar.MINUTE);
                    String i1 = i+"";
                    if(i<10){
                        i1="0"+i;
                    }
                    s = Hhour+":"+i1;
                }
                String time2 = map.get("time2");
                String home = map.get("home");
                String[] split = home.split(",");
                String s1 = split[split.length - 1];
                FootballTeam2 footballTeam1 = footballTeam2Mapper.selectByPrimaryKey(StringUtil.String2Integer(s1));
                String away = map.get("away");
                String[] split2 = away.split(",");
                String s2 = split2[split2.length - 1];
                FootballTeam2 footballTeam2 = footballTeam2Mapper.selectByPrimaryKey(StringUtil.String2Integer(s2));
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
                ScoreliveFootballNowDayDTO scoreliveFootballNowDayDTO =
                        ScoreliveFootballNowDayDTO.builder().id(StringUtil.String2Integer(ID)).color(color).leagueId(StringUtil.String2Integer(leagueID))
                                .kind(StringUtil.String2Integer(kind)).level(StringUtil.String2Integer(level)).league(footballLeague).subLeague(subLeague).subLeagueId(StringUtil.String2Integer(subLeagueID))
                                .time(s).time2(time2).home(footballTeam1).away(footballTeam2).state(StringUtil.String2Integer(state))
                                .homeScore(StringUtil.String2Integer(homeScore)).awayScore(StringUtil.String2Integer(awayScore)).bc1(StringUtil.String2Integer(bc1)).bc2(StringUtil.String2Integer(bc2))
                                .red1(StringUtil.String2Integer(red1)).red2(StringUtil.String2Integer(red2)).yellow1(StringUtil.String2Integer(yellow1)).yellow2(StringUtil.String2Integer(yellow2))
                                .order1(order1).order2(order2).explain(explain).explain2(explain2).zl(zl).tv(tv).lineup(lineup).corner1(StringUtil.String2Integer(corner1)).corner2(StringUtil.String2Integer(corner2))
                                .build();
                scoreliveFootballNowDayDTOS.add(scoreliveFootballNowDayDTO);
            }
            mapp.put("data",scoreliveFootballNowDayDTOS);
            mapp.put("size",size);
            return mapp;
//        }catch (Exception e){
//            return null;
//        }
    }

    public List<ScoreliveBasketBallNowTimeDTO> getBasketballballNowTime(String xml) {
        List<ScoreliveBasketBallNowTimeDTO> ScoreliveFootballNowTimeDTOs = new ArrayList<ScoreliveBasketBallNowTimeDTO>();
        List<Map<String, String>> maps = XmlDom4jUtil.iterateWholeXML1(xml);
        for (Map<String, String> map:maps) {
            for (String key : map.keySet()) {
                System.out.println(key + ":" + map.get(key));
                String s = map.get(key);
                String[] split = s.split("\\^");
//                if(split.length!=18){
//                    return null;
//                }
//                Date date = DateUtil.StringToDate4(split[9]);
//                String s1 = DateUtil.dateToString2(date);
                ScoreliveBasketBallNowTimeDTO scoreliveBasketBallNowTimeDTO = ScoreliveBasketBallNowTimeDTO.builder().id(split[0]).state(split[1]).remainTime(split[2]).homeScore(split[3]).awayScore(split[4]).zd1(split[5]).kd1(split[6]).zd2(split[7])
                        .kd2(split[8]).zd3(split[9]).kd3(split[10]).zd4(split[11]).kd4(split[12]).addTime(split[13]).mark1(split[14]).sectionCount(split[15]).zd1ot(split[16]).kd1ot(split[17]).zd2ot(split[18]).kd2ot(split[19]).zd3ot(split[20]).kd3ot(split[21]).
                                mark2(split[22]).haveTechnical(split[23]).pl(split[24]).build();
                ScoreliveFootballNowTimeDTOs.add(scoreliveBasketBallNowTimeDTO);
            }
        }
        return ScoreliveFootballNowTimeDTOs;
    }


    public String getType(int type){
        switch (type){
            case 0:
                return "先开球";
            case 1:
                return "第一个角球";
            case 2:
                return "第一张黄牌";
            case 3:
                return "射门次数";
            case 4:
                return "射正次数";
            case 5:
                return "犯规次数";
            case 6:
                return "角球次数";
            case 7:
                return "角球次数(加时)";
            case 8:
                return "任意球次数";
            case 9:
                return "越位次数";
            case 10:
                return "乌龙球数";
            case 11:
                return "黄牌数";
            case 12:
                return "黄牌数(加时)";
            case 13:
                return "红牌数";
            case 14:
                return "控球时间";
            case 15:
                return "头球";
            case 16:
                return "救球";
            case 17:
                return "守门员出击";
            case 18:
                return "丟球";
            case 19:
                return "成功抢断";
            case 20:
                return "阻截";
            case 21:
                return "长传";
            case 22:
                return "短传";
            case 23:
                return "助攻";
            case 24:
                return "成功传中";
            case 25:
                return "第一个换人";
            case 26:
                return "最后换人";
            case 27:
                return "第一个越位";
            case 28:
                return "最后越位";
            case 29:
                return "换人数";
            case 30:
                return "最后角球";
            case 31:
                return "最后黄牌";
            case 32:
                return "换人数(加时)";
            case 33:
                return "越位次数(加时)";
            case 34:
                return "射门不中";
            case 35:
                return "中柱";
            case 36:
                return "头球成功次数";
            case 37:
                return "射门被挡";
            case 38:
                return "铲球";
            case 39:
                return "过人次数";
            case 40:
                return "界外球";
            case 41:
                return "传球次数";
            case 42:
                return "传球成功率";
            case 43:
                return "进攻次数";
            case 44:
                return "危险进攻次数";
            case 45:
                return "半场角球";
            case 46:
                return "半场控球";
            default:
                return "-----";
        }
    }

    public String getWeek(){
        Date date = new Date();
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
        return week;
    }

}
