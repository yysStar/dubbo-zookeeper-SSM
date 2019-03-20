package com.qiyun.serviceImpl;

import com.qiyun.intface.SwapFileCallBack;
import com.qiyun.mapper2.FootballGameNameMapper;
import com.qiyun.mapper2.FootballMatch2Mapper;
import com.qiyun.mapper2.FootballTeam2Mapper;
import com.qiyun.model.FootballGame;
import com.qiyun.model.FootballMatch;
import com.qiyun.model.FootballTeam;
import com.qiyun.model.football.SportteryFootBallBetInfo;
import com.qiyun.model2.FootballGameName;
import com.qiyun.model2.FootballMatch2;
import com.qiyun.model2.FootballTeam2;
import com.qiyun.service.FootballDataService;
import com.qiyun.tools.BeanTools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("footballDataService")
public class FootballDataServiceImpl implements FootballDataService {
    @Resource
    private FootballGameNameMapper footballGameNameMapper;
    @Resource
    private FootballTeam2Mapper footballTeam2Mapper;
    @Resource
    private FootballMatch2Mapper footballMatch2Mapper;

    public FootballGame findGameByStandardName(String name) {
        List<FootballGame> list = footballGameNameMapper.findByStandardName(name);
        if(list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    public FootballTeam findByStandardName(String name) {
        List<FootballTeam> list = footballTeam2Mapper.findByStandardName(name);
        if(list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    public void attachDirty(FootballGame game) {
        FootballGameName gameName = changeGameName(game);
        if(game.getId() == null) {
            footballGameNameMapper.insertSelective(gameName);
        }else{
            footballGameNameMapper.updateByPrimaryKeyWithBLOBs(gameName);
        }
    }

    /**
     * Game bean转换
     * @param game
     * @return
     */
    private FootballGameName changeGameName(FootballGame game) {
        FootballGameName gameName = FootballGameName.builder().dcName(game.getDc()).gameColor(game.getGameColor())
                .icon(game.getIcon()).id(game.getId()).jcName(game.getJc()).mark(game.getMark())
                .shortName(game.getShortName()).standardName(game.getShortName()).build();
        return gameName;
    }

    public void attachDirty(FootballTeam instance) {
        FootballTeam2 team = changeTeam(instance);
        if(instance.getId() == null) {
            footballTeam2Mapper.insertSelective(team);
        }else{
            footballTeam2Mapper.updateByPrimaryKeySelective(team);
        }
    }

    public void attachDirty(Collection<FootballMatch> match) {
        for(FootballMatch footballMatch : match){
            FootballMatch2 team = changeMatch(footballMatch);
            if(footballMatch.getId() == null) {
                footballMatch2Mapper.insertSelective(team);
            }else{
                footballMatch2Mapper.updateByPrimaryKeySelective(team);
            }
        }
    }

    public void attachDirty(SportteryFootBallBetInfo betInfo) {

    }

    /**
     * Team bean转换
     * @param instance
     * @return
     */
    private FootballTeam2 changeTeam(FootballTeam instance) {
        FootballTeam2 footballTeam2 = FootballTeam2.builder().dc(instance.getDc()).dyj(instance.getDyj())
                .fb(instance.getFb()).id(instance.getId()).jc(instance.getJc()).pm(instance.getPm())
                .standardName(instance.getStandardName()).build();
        return footballTeam2;
    }

    public FootballMatch storeMatchByOddsId(FootballMatch fm) {
        List<FootballMatch> list = footballMatch2Mapper.findByOddId(fm.getOddId());
        if (list.size() > 0) {
            FootballMatch tmp = list.get(0);
            // 500万指数ID变动更新指数id 曾经延期比赛更新比赛时间
            boolean isChange= BeanTools.compareBean(tmp, fm,
                    new String[] {"gameId", "homeId","guestId","matchTime","matchDateStr","oddId"
                            ,"analysisId","homePm","guestPm","xyyHomeId","xyyGuestId"}, new SwapFileCallBack());
            if (isChange) {
                FootballMatch2 match = changeMatch(tmp);
                footballMatch2Mapper.updateByPrimaryKeySelective(match);
            }
            return tmp;
        } else {
            FootballMatch2 match = changeMatch(fm);
            footballMatch2Mapper.insertSelective(match);
            fm.setId(match.getId());
            return fm;
        }
    }

    public List<SportteryFootBallBetInfo> findTzbByMatchId(Integer id) {
        return null;
    }

    public Map<Integer, SportteryFootBallBetInfo> findFootballBetInfoByMatchIds(List<Integer> matchIds) {
        return null;
    }

    public Map<Integer, FootballMatch> findFootballMatchIdByIntTimes(Set<Integer> intTimeSet) {
        if (intTimeSet == null || intTimeSet.isEmpty()) {
            throw new RuntimeException("intTime参数为空");
        }
        Map<Integer, FootballMatch> resultMap = new HashMap<Integer, FootballMatch>();
        List<FootballMatch> matchList =
                footballMatch2Mapper.findFootballMatchIdByIntTimes(new ArrayList<Integer>(intTimeSet));
        for (FootballMatch match : matchList) {
            if (match == null) {
                continue;
            }
            resultMap.put(match.getId(), match);
        }
        return resultMap;
    }

    /**
     * Match bean转换
     * @param fm
     * @return
     */
    private FootballMatch2 changeMatch(FootballMatch fm) {
        FootballMatch2 match = FootballMatch2.builder().analysisId(fm.getAnalysisId()).bfHalf(fm.getBfHalf())
                .bfLevel(fm.getBfLevel()).bfWhole(fm.getBfWhole()).finalGuestScore(fm.getFinalGuestScore())
                .finalHomeScore(fm.getFinalHomeScore()).gameId(fm.getGameId()).guest(fm.getGuest())
                .guestId(fm.getGuestId()).guestPm(fm.getGuestPm()).home(fm.getHome()).homeId(fm.getHomeId())
                .homePm(fm.getHomePm()).id(fm.getId()).matchDateStr(fm.getMatchDateStr()).matchName(fm.getMatchName())
                .matchTime(fm.getMatchTime()).oddId(fm.getOddId()).outAnalysisId(fm.getOutAnalysisId())
                .resultOfMatch(fm.getResultOfMatch()).xyyGuestId(fm.getXyyGuestId()).xyyHomeId(fm.getXyyHomeId())
                .build();
        return match;
    }
}
