package com.qiyun.task;

import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.grabber.model.AwardListEnum;
import com.qiyun.grabber.model.PlatformEnum;
import com.qiyun.httpUtil.HttpUtil;
import com.qiyun.model.*;
import com.qiyun.model.football.FootBallMatch;
import com.qiyun.model.football.MatchAwardOfRQSPF;
import com.qiyun.model.football.MatchAwardOfSPF;
import com.qiyun.model2.SportteryFootballMatch2;
import com.qiyun.service.FootBallService;
import com.qiyun.service.FootballDataService;
import com.qiyun.service.SportteryFootballMatchService;
import com.qiyun.tools.DateTools;
import com.qiyun.util.*;
import com.qiyun.utils.StringTools;
import com.qiyun.utils.basketball.SportteryGrabberUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.qiyun.commonModel.LotteryType;

import java.util.*;

@Component
@Lazy(value=false)
public class  MatchTask {
    @Autowired
    private SportteryFootballMatchService sportteryFootballMatch2Service;
    @Autowired
    private FootballDataService footballDataService;

    /**
     * 竞彩足球赛事抓取（500w）
     * @throws Exception
     */
    @Scheduled(cron = "0 0/3 * * * ?")//每隔三分钟处理一次
    public void getFootMatch() throws Exception {
        List<FootballMatchBean> allMatchList=new ArrayList<FootballMatchBean>();
        for (int i = 0; i < Constants.dateOffsetLimit; i++) {
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_YEAR, +i);
            String date = DateTools.dateToString(cal.getTime(), "yyyy-MM-dd");
            List<FootballMatchBean> jcMatchList = FbDcArrangeUtil.get500wMatch(FbDcArrangeUtil.jcPmUrl + "?e=" + date);
            allMatchList.addAll(jcMatchList);
        }
        buildFootBallMatch(allMatchList,"jc");
        LogUtil.info("-----更新竞彩足球赛事资料库成功,场次数"+allMatchList.size()+"-------");
    }

    /**
     * 1. 抓取500w的全称 fullName
     * 2. fullName 查找数据库
     * 3. 抓来的投注页缩写 更新 game
     * @param type="jc/dc/ctzq"
     * @param footballMatchList
     */
    private void buildFootBallMatch(List<FootballMatchBean> footballMatchList,String type) {
        for (FootballMatchBean match : footballMatchList) {
            try {
                LogUtil.info("match[matchName:" + match.getMatchName() + ",homeId:" + match.getHomeId()
                        + ",guestId:" + match.getGuestId() + ",oddId:" + match.getOddId()
                        + ",matchTime:" + match.getMatchTime());

                if ("-1".equals(match.getOddId())) {
                    LogUtil.info(match.getHome());
                    continue;
                }
                FootballMatch fm = new FootballMatch();

                FootballMatch oddMatch = FootballDataUtil.getWuBaiWanFootballMatch(Integer.valueOf(match.getOddId()));//500w全称
                if(oddMatch==null || StringTools.isNullOrBlank(oddMatch.getMatchName())){
                    continue;
                }

                FootballGame game = footballDataService.findGameByStandardName(oddMatch.getMatchName());
                if (game == null) {
                    game = new FootballGame();
                    game.setStandardName(oddMatch.getMatchName());
                }
                if(type.equals("jc")){
                    if(StringTools.isNullOrBlank(game.getJc())){
                        game.setJc(match.getMatchName());
                    }
                }else if(type.equals("dc")){
                    if(StringTools.isNullOrBlank(game.getDc())){
                        game.setDc(match.getMatchName());
                    }
                }else if(type.equals("ctzq")){
                    if(StringTools.isNullOrBlank(game.getShortName())){
                        game.setShortName(match.getMatchName());
                    }
                }
                game.setGameColor(match.getGameColor());
                footballDataService.attachDirty(game);

                FootballTeam homeTeam = footballDataService.findByStandardName(match.getHome());
                FootballTeam guestTeam = footballDataService.findByStandardName(match.getGuest());
                if (homeTeam == null) {
                    homeTeam = new FootballTeam();
                    homeTeam.setStandardName(match.getHome());
                    footballDataService.attachDirty(homeTeam);
                }

                if (guestTeam == null) {
                    guestTeam = new FootballTeam();
                    guestTeam.setStandardName(match.getHome());
                    footballDataService.attachDirty(guestTeam);
                }
                fm.setHomeId(match.getHomeId());
                fm.setGuestId(match.getGuestId());

                fm.setMatchName(match.getMatchName());
                fm.setGameId(game.getId());
                fm.setHome(match.getHome());
                fm.setGuest(match.getGuest());

                fm.setMatchTime(match.getMatchTime());
                fm.setMatchDateStr(match.getMatchDateStr());
                fm.setBfHalf(match.getBfHalf());
                fm.setBfWhole(match.getBfWhole());
                fm.setOddId(match.getOddId());
                footballDataService.storeMatchByOddsId(fm);
            } catch (Exception e) {
                LogUtil.error(e);
            }
        }
    }

    /**
     * 竞彩足球赛事抓取
     * @throws Exception
     */
    @Scheduled(cron = "0 0/3 * * * ?")//每隔三分钟处理一次
    public void getFootBallMatch() throws Exception {
        LogUtil.info("----------竞彩足球自动维护线程抓取新赛事开始-----------");
        List<SportteryFootballMatch2> matchList = new ArrayList<SportteryFootballMatch2>();
        String s = HttpUtil.sendGet(Constants.MATCH_URL,
                "i_format=json&i_callback=getData&poolcode[]=had" +
                        "&poolcode[]=hhad&poolcode[]=crs&poolcode[]=ttg&poolcode[]=hafu&_=");
        s = Ascii2NativeUtil.ascii2Native(s);
        JSONObject list = JsonUtil.getDate(s);
        Iterator it = list.keys();
        //得到抓取的数据
        while(it.hasNext()){
            String key = it.next().toString();
            JSONObject item = list.getJSONObject(key);
            String numberStr = item.get("num").toString().trim();
            String lineId = numberStr.substring(2, numberStr.length());
            String date = item.get("date").toString().trim();
            String time = item.get("time").toString().trim();
            String gameColor = item.get("l_background_color").toString().trim();
            String intTime = item.get("b_date").toString().trim().replaceAll("-", "");
            String status = item.get("status").toString().trim();
            String gameName = item.get("l_cn_abbr").toString().trim();
            String homeTeam = item.get("h_cn_abbr").toString().trim();
            String guestTeam = item.get("a_cn_abbr").toString().trim();
            List<MatchShowStatusFb> statusList = MatchShowStatusTextFb.getShowStatsuFbOrderList();

            //胜平负
            if(item.containsKey("had")){
                String jsonHad =  item.get("had").toString().trim();
                JSONObject jsonObj = JSONObject.fromObject(jsonHad);
                String pStatus = jsonObj.get("p_status").toString().trim();
                if("Selling".equals(pStatus)) {
                    String single = jsonObj.get("single").toString().trim();
                    if("0".equals(single)) {
                        statusList.remove(MatchShowStatusFb.SPFSINGLE);
                    }
                } else {
                    statusList.remove(MatchShowStatusFb.SPF);
                    statusList.remove(MatchShowStatusFb.SPFSINGLE);
                }
            } else {
                statusList.remove(MatchShowStatusFb.SPF);
                statusList.remove(MatchShowStatusFb.SPFSINGLE);
            }

            //hhad	让球
            String  concede = "0";
            if(item.containsKey("hhad")){//如果没有，则不开
                String jsonHad =  item.get("hhad").toString().trim();
                JSONObject jsonObj = JSONObject.fromObject(jsonHad);
                concede = jsonObj.get("fixedodds").toString().trim();
                String pStatus = jsonObj.get("p_status").toString().trim();
                if("Selling".equals(pStatus)) {
                    String single = jsonObj.get("single").toString().trim();
                    if("0".equals(single)) {
                        statusList.remove(MatchShowStatusFb.RQSPFSINGLE);
                    }
                } else {
                    statusList.remove(MatchShowStatusFb.RQSPF);
                    statusList.remove(MatchShowStatusFb.RQSPFSINGLE);
                }
            } else {
                statusList.remove(MatchShowStatusFb.RQSPF);
                statusList.remove(MatchShowStatusFb.RQSPFSINGLE);
            }

            //比分
            if(item.containsKey("crs")){	//如果没有，则不开
                String jsonHad =  item.get("crs").toString().trim();
                JSONObject jsonObj = JSONObject.fromObject(jsonHad);
                String pStatus = jsonObj.get("p_status").toString().trim();
                if("Selling".equals(pStatus)) {
                    String single = jsonObj.get("single").toString().trim();
                    if("0".equals(single)) {
                        statusList.remove(MatchShowStatusFb.BFSINGLE);
                    }
                } else {
                    statusList.remove(MatchShowStatusFb.BF);
                    statusList.remove(MatchShowStatusFb.BFSINGLE);
                }
            } else {
                statusList.remove(MatchShowStatusFb.BF);
                statusList.remove(MatchShowStatusFb.BFSINGLE);
            }

            //总进球
            if(item.containsKey("ttg")){	//如果没有，则不开
                String jsonHad =  item.get("ttg").toString().trim();
                JSONObject jsonObj = JSONObject.fromObject(jsonHad);
                String pStatus = jsonObj.get("p_status").toString().trim();
                if("Selling".equals(pStatus)) {
                    String single = jsonObj.get("single").toString().trim();
                    if("0".equals(single)) {
                        statusList.remove(MatchShowStatusFb.JQSSINGLE);
                    }
                } else {
                    statusList.remove(MatchShowStatusFb.JQS);
                    statusList.remove(MatchShowStatusFb.JQSSINGLE);
                }
            } else {
                statusList.remove(MatchShowStatusFb.JQS);
                statusList.remove(MatchShowStatusFb.JQSSINGLE);
            }

            //半全场
            if(item.containsKey("hafu")){	//如果没有，则不开
                String jsonHad =  item.get("hafu").toString().trim();
                JSONObject jsonObj = JSONObject.fromObject(jsonHad);
                String pStatus = jsonObj.get("p_status").toString().trim();
                if("Selling".equals(pStatus)) {
                    String single = jsonObj.get("single").toString().trim();
                    if("0".equals(single)) {
                        statusList.remove(MatchShowStatusFb.BQCSINGLE);
                    }
                } else {
                    statusList.remove(MatchShowStatusFb.BQC);
                    statusList.remove(MatchShowStatusFb.BQCSINGLE);
                }
            } else {
                statusList.remove(MatchShowStatusFb.BQC);
                statusList.remove(MatchShowStatusFb.BQCSINGLE);
            }

            Date matchTime = DateTools.StringToDate_YYYY_MM_DD_HH_MM_SS(date+" "+time);
            SportteryFootballMatch2 fbMatch = new SportteryFootballMatch2();
            fbMatch.setConcede(Integer.parseInt(concede));
            fbMatch.setInttime(Integer.parseInt(intTime));
            fbMatch.setLineid(Integer.parseInt(lineId));
            fbMatch.setMatchtime(matchTime);
            fbMatch.setGamecolor("#"+gameColor);
            fbMatch.setGamename(gameName);
            fbMatch.setHometeam(homeTeam);
            fbMatch.setGuestteam(guestTeam);
            //0:在售1:截止2:取消
            if("Selling".equals(status)) {
                fbMatch.setStatus(0);
            } else {
                fbMatch.setStatus(2);
            }

            int show=0;
            for (MatchShowStatusFb fb : statusList) {
                show |= 1 << fb.getValue();
            }
            fbMatch.setShownum(show);
            matchList.add(fbMatch);
        }
        Set<Integer> intTimeSet =new HashSet<Integer>();
        for (SportteryFootballMatch2 ms : matchList) {
            intTimeSet.add(ms.getInttime());
        }
        //根据抓取到的intTimeSet查数据库中的数据
        List<SportteryFootballMatch2> dbMatchs = sportteryFootballMatch2Service.getMatchListByIntTime(intTimeSet);
        Map<String, SportteryFootballMatch2> dbMap = new HashMap<String, SportteryFootballMatch2>();
        dbMap = arrangeListToMap(dbMatchs);
        //数据库不存在.把抓取到的放入数据库map
        for (SportteryFootballMatch2 ms : matchList) {
            String msKey=ms.getMapKey();
            if (dbMap.containsKey(msKey)) {
                if(dbMap.get(msKey).getStatus() == 0) {//对阵为正常销售情况下，才更新状态
                    dbMap.get(msKey).setShownum(ms.getShownum());
                }
            }else{
                dbMap.put(msKey, ms);
            }
        }
    }

    private Map<String, SportteryFootballMatch2> arrangeListToMap(List<SportteryFootballMatch2> arrangeList) {
        Map<String, SportteryFootballMatch2> arrangeMap = new LinkedHashMap<String, SportteryFootballMatch2>();
        for (SportteryFootballMatch2 b : arrangeList) {
            arrangeMap.put(b.getMapKey(), b);
        }
        return arrangeMap;
    }

//    public static void main(String[] args) {
//    }
}
