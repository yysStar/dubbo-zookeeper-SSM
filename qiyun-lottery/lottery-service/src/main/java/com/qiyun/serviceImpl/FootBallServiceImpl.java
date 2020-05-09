package com.qiyun.serviceImpl;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.grabber.model.AwardListEnum;
import com.qiyun.mapper2.*;
import com.qiyun.model.PassMode;
import com.qiyun.model.football.*;
import com.qiyun.model2.*;
import com.qiyun.service.FootBallService;
import com.qiyun.utils.MatchUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("footBallService")
public class FootBallServiceImpl implements FootBallService {
    @Resource
    private SportteryFootballMatch2Mapper sportteryFootballMatch2Mapper;
    @Resource
    private SportteryFootballBfaward2Mapper sportteryFootballBfaward2Mapper;
    @Resource
    private SportteryFootballBqcaward2Mapper sportteryFootballBqcaward2Mapper;
    @Resource
    private SportteryFootballRqspfaward2Mapper sportteryFootballRqspfaward2Mapper;
    @Resource
    private SportteryFootballSpfaward2Mapper sportteryFootballSpfaward2Mapper;
    @Resource
    private SportteryFootballJqsaward2Mapper sportteryFootballJqsaward2Mapper;
    @Autowired
    private ConfigMapper configMapper;

    private static int i = 0;

    public Config getConfigById(int id) {
        return configMapper.selectByPrimaryKey(id);
    }

    public List<FootBallMatch> findMatchByStatus(int status) {
        List<SportteryFootballMatch2> list = sportteryFootballMatch2Mapper.findMatchByStatus(status);
        List<FootBallMatch> matches = new ArrayList<FootBallMatch>();
        for(SportteryFootballMatch2 match2 : list){
            matches.add(changeFootBallMatch(match2));
        }
        return matches;
    }

    /**
     * 2 To match
     * @param match2
     * @return
     */
    private FootBallMatch changeFootBallMatch(SportteryFootballMatch2 match2) {
        FootBallMatch footBallMatch = new FootBallMatch();
        if(match2.getPrizeType() != null) {
            footBallMatch.setAddPrizeType(FootBallAddPrizeType.getItem(match2.getPrizeType()));
        }
        footBallMatch.setBfShowNum(match2.getBfShownum());
        footBallMatch.setBqcShowNum(match2.getBqcShownum());
        footBallMatch.setConcede(match2.getConcede());
        footBallMatch.setEndTime(match2.getMatchtime());;
//        footBallMatch.setFootballInfo();
        footBallMatch.setHalfGuestScore(match2.getHalfguestscore());
        footBallMatch.setHalfHomeScore(match2.getHalfhomescore());
        footBallMatch.setHomeScore(match2.getHomescore());
        footBallMatch.setJqsShowNum(match2.getJqsShownum());
        footBallMatch.setOutId(match2.getOutid());
        footBallMatch.setResultAwardOfHfTotoPass(match2.getResultawardofhftotopass());
        footBallMatch.setResultAwardOfScorePass(match2.getResultawardofscorepass());
        footBallMatch.setResultAwardOfSingleScore(match2.getResultawardofsinglescore());
        footBallMatch.setResultAwardOfTotoPass(match2.getResultawardoftotopass());
        footBallMatch.setResultOfRule(match2.getResultOfRule());
        footBallMatch.setResultRQAwardOfTotoPass(match2.getResultrqawardoftotopass());
        footBallMatch.setRqspfShowNum(match2.getRqspfShownum());
        footBallMatch.setShortGameName(match2.getGameShortName());
        footBallMatch.setShortGuestTeam(match2.getGuestteam());
        footBallMatch.setShortHomeTeam(match2.getHometeam());
        footBallMatch.setShowNum(match2.getShownum());
        footBallMatch.setSpfShowNum(match2.getSpfShownum());
        footBallMatch.setWorldScene(match2.getWorldscene());
        footBallMatch.setGameColor(match2.getGamecolor());
        footBallMatch.setGameId(match2.getGameId());
        footBallMatch.setGameName(match2.getGamename());
        footBallMatch.setGuestScore(match2.getGuestscore());
        footBallMatch.setGuestTeam(match2.getGuestteam());
        footBallMatch.setHasDelay(match2.getHasDelay());
        footBallMatch.setHomeTeam(match2.getHometeam());
        footBallMatch.setIntTime(match2.getInttime());
        footBallMatch.setLineId(match2.getLineid());
        footBallMatch.setMatchTime(match2.getMatchtime());
        footBallMatch.setStatus(match2.getStatus());
        footBallMatch.setVersion(match2.getVersion());
        footBallMatch.setId(match2.getId());
        return footBallMatch;
    }

    public <A extends AbstractAward> List<A> getAwardListByIntTimeListAndPlayType(Set<Integer> intTime,
                                                                                  LotteryType type) {
        if (intTime == null || intTime.isEmpty()) {
            throw new RuntimeException("intTime参数为空");
        }
        AwardListEnum enuma = AwardListEnum.enumOfAwardByLotteryType(type);
        if (enuma == null) {
            throw new RuntimeException("玩法类型传递错误");
        }
        List<A> awardList = new ArrayList<A>();
        int i = MatchUtils.getForClass(AwardListEnum.classNameOfAward(enuma.ordinal()));
        if(i == 0){
            throw new RuntimeException("玩法类型传递错误");
        }
        switch (i) {
            case 3: //足球比分
                if (intTime.size() == 1) {
                    List<MatchAwardOfBF> bfAwardList = sportteryFootballBfaward2Mapper
                            .selectByIntTime(intTime.iterator().next());
                    awardList = (List<A>) bfAwardList;
                } else {
                    List<MatchAwardOfBF> bfAwardList = sportteryFootballBfaward2Mapper
                            .selectByIntTimes(new ArrayList<Integer>(intTime));
                    awardList = (List<A>) bfAwardList;
                }
                return awardList;
            case 4: //足球半全场
                if (intTime.size() == 1) {
                    List<MatchAwardOfBQC> bqcAwardList = sportteryFootballBqcaward2Mapper
                            .selectByIntTime(intTime.iterator().next());
                    awardList = (List<A>) bqcAwardList;
                } else {
                    List<MatchAwardOfBQC> bqcAwardList = sportteryFootballBqcaward2Mapper
                            .selectByIntTimes(new ArrayList<Integer>(intTime));
                    awardList = (List<A>) bqcAwardList;
                }
                return awardList;
            case 5: // 进球数
                if (intTime.size() == 1) {
                    List<MatchAwardOfJQS> jqsAwardList = sportteryFootballJqsaward2Mapper
                            .selectByIntTime(intTime.iterator().next());
                    awardList = (List<A>) jqsAwardList;
                } else {
                    List<MatchAwardOfJQS> jqsAwardList = sportteryFootballJqsaward2Mapper
                            .selectByIntTimes(new ArrayList<Integer>(intTime));
                    awardList = (List<A>) jqsAwardList;
                }
                return awardList;
            case 6: // 胜平负
                if (intTime.size() == 1) {
                    List<MatchAwardOfSPF> spfAwardList = sportteryFootballSpfaward2Mapper
                            .selectByIntTime(intTime.iterator().next());
                    awardList = (List<A>) spfAwardList;
                } else {
                    List<MatchAwardOfSPF> spfAwardList = sportteryFootballSpfaward2Mapper
                            .selectByIntTimes(new ArrayList<Integer>(intTime));
                    awardList = (List<A>) spfAwardList;
                }
                return awardList;
            case 7: // 让球胜平负
                if (intTime.size() == 1) {
                    List<MatchAwardOfRQSPF> rqspfAwardList = sportteryFootballRqspfaward2Mapper
                            .selectByIntTime(intTime.iterator().next());
                    awardList = (List<A>) rqspfAwardList;
                } else {
                    List<MatchAwardOfRQSPF> rqspfAwardList = sportteryFootballRqspfaward2Mapper
                            .selectByIntTimes(new ArrayList<Integer>(intTime));
                    awardList = (List<A>) rqspfAwardList;
                }
                return awardList;
        }
        return null;
    }

    public <A extends AbstractAward> A saveAward(A award, AwardListEnum playType) {
        if (playType == null) {
            throw new RuntimeException("玩法类型传递错误");
        }
        int i = getForPlayType(playType.name());
        if(i == 0){
            throw new RuntimeException("玩法类型传递错误");
        }
        int id = 0;
        switch (i){
            case 1: //足球比分
                MatchAwardOfBF awardOfBF = (MatchAwardOfBF) award;
                id = sportteryFootballBfaward2Mapper.insertSelective(getAwardByBf(awardOfBF));
                break;
            case 2: //足球半全场
                MatchAwardOfBQC awardOfBQC = (MatchAwardOfBQC) award;
                id = sportteryFootballBqcaward2Mapper.insertSelective(getAwardByBqc(awardOfBQC));
                break;
            case 3: //足球进球数
                MatchAwardOfJQS awardOfJQS = (MatchAwardOfJQS) award;
                id = sportteryFootballJqsaward2Mapper.insertSelective(getAwardByJqs(awardOfJQS));
                break;
            case 4: //足球胜平负
                MatchAwardOfSPF awardOfSPF = (MatchAwardOfSPF) award;
                id = sportteryFootballSpfaward2Mapper.insertSelective(getAwardBySpf(awardOfSPF));
                break;
            case 5: //足球让球胜平负
                MatchAwardOfRQSPF awardOfRQSPF = (MatchAwardOfRQSPF) award;
                id = sportteryFootballRqspfaward2Mapper.insertSelective(getAwardByRqspf(awardOfRQSPF));
                break;
        }
        if(id == 0){
            throw new RuntimeException("篮球SP插入失败");
        }
        award.setId(id);
        return award;
    }

    /**
     * 让球胜平负SP
     * @param awardOfRQSPF
     * @return
     */
    private SportteryFootballRqspfaward2 getAwardByRqspf(MatchAwardOfRQSPF awardOfRQSPF) {
        SportteryFootballRqspfaward2 rqspfaward2 = SportteryFootballRqspfaward2.builder()
                .createDate(awardOfRQSPF.getCreateDate()).inttime(awardOfRQSPF.getIntTime())
                .lastupdatetime(awardOfRQSPF.getLastUpdateTime()).lineid(awardOfRQSPF.getLineId())
                .matchid(awardOfRQSPF.getMatchId()).matchtime(awardOfRQSPF.getMatchTime())
                .passmode(awardOfRQSPF.getPassMode()).drawaward(awardOfRQSPF.getDrawAward())
                .drawchange(awardOfRQSPF.getDrawChange()).drawRate(awardOfRQSPF.getDrawRate())
                .guestchange(awardOfRQSPF.getGuestChange()).guestRate(awardOfRQSPF.getGuestRate())
                .guestwinaward(awardOfRQSPF.getGuestWinAward()).homechange(awardOfRQSPF.getHomeChange())
                .homeRate(awardOfRQSPF.getHomeRate()).homewinaward(awardOfRQSPF.getHomeWinAward()).build();
        return rqspfaward2;
    }

    /**
     * 胜平负SP
     * @param awardOfSPF
     * @return
     */
    private SportteryFootballSpfaward2 getAwardBySpf(MatchAwardOfSPF awardOfSPF) {
        SportteryFootballSpfaward2 spfaward2 = SportteryFootballSpfaward2.builder()
                .createDate(awardOfSPF.getCreateDate()).inttime(awardOfSPF.getIntTime())
                .lastupdatetime(awardOfSPF.getLastUpdateTime()).lineid(awardOfSPF.getLineId())
                .matchid(awardOfSPF.getMatchId()).matchtime(awardOfSPF.getMatchTime())
                .passmode(awardOfSPF.getPassMode()).drawaward(awardOfSPF.getDrawAward())
                .drawchange(awardOfSPF.getDrawChange()).drawRate(awardOfSPF.getDrawRate())
                .guestchange(awardOfSPF.getGuestChange()).guestRate(awardOfSPF.getGuestRate())
                .guestwinaward(awardOfSPF.getGuestWinAward()).homechange(awardOfSPF.getHomeChange())
                .homeRate(awardOfSPF.getHomeRate()).homewinaward(awardOfSPF.getHomeWinAward()).build();
        return spfaward2;
    }

    /**
     * 进球数SP
     * @param awardOfJQS
     * @return
     */
    private SportteryFootballJqsaward2 getAwardByJqs(MatchAwardOfJQS awardOfJQS) {
        SportteryFootballJqsaward2 jqsaward2 = SportteryFootballJqsaward2.builder()
                .createDate(awardOfJQS.getCreateDate()).inttime(awardOfJQS.getIntTime())
                .lastupdatetime(awardOfJQS.getLastUpdateTime()).lineid(awardOfJQS.getLineId())
                .matchid(awardOfJQS.getMatchId()).matchtime(awardOfJQS.getMatchTime())
                .passmode(awardOfJQS.getPassMode()).s0Award(awardOfJQS.getS0Award()).s1Award(awardOfJQS.getS1Award())
                .s2Award(awardOfJQS.getS2Award()).s3Award(awardOfJQS.getS3Award()).s4Award(awardOfJQS.getS4Award())
                .s5Award(awardOfJQS.getS5Award()).s6Award(awardOfJQS.getS6Award()).s7Award(awardOfJQS.getS7Award())
                .build();
        return jqsaward2;
    }

    /**
     * 半全场SP
     * @param awardOfBQC
     * @return
     */
    private SportteryFootballBqcaward2 getAwardByBqc(MatchAwardOfBQC awardOfBQC) {
        SportteryFootballBqcaward2 bqcaward2 = SportteryFootballBqcaward2.builder()
                .createDate(awardOfBQC.getCreateDate()).inttime(awardOfBQC.getIntTime())
                .drawDrawAward(awardOfBQC.getDraw_draw_award()).drawLoseAward(awardOfBQC.getDraw_lose_award())
                .drawWinAward(awardOfBQC.getDraw_win_award()).lastupdatetime(awardOfBQC.getLastUpdateTime())
                .lineid(awardOfBQC.getLineId()).loseDrawAward(awardOfBQC.getLose_draw_award())
                .loseLoseAward(awardOfBQC.getLose_lose_award()).loseWinAward(awardOfBQC.getLose_win_award())
                .matchid(awardOfBQC.getMatchId()).matchtime(awardOfBQC.getMatchTime())
                .passmode(awardOfBQC.getPassMode()).winDrawAward(awardOfBQC.getWin_draw_award())
                .winLoseAward(awardOfBQC.getWin_lose_award()).winWinAward(awardOfBQC.getWin_win_award()).build();
        return bqcaward2;
    }

    /**
     * 比分SP
     * @param awardOfBF
     * @return
     */
    private SportteryFootballBfaward2 getAwardByBf(MatchAwardOfBF awardOfBF) {
        SportteryFootballBfaward2 bfaward2 = SportteryFootballBfaward2.builder().createDate(awardOfBF.getCreateDate())
                .inttime(awardOfBF.getIntTime()).lastupdatetime(awardOfBF.getLastUpdateTime())
                .lineid(awardOfBF.getLineId()).matchid(awardOfBF.getMatchId()).matchtime(awardOfBF.getMatchTime())
                .passmode(awardOfBF.getPassMode()).s00award(awardOfBF.getS00award()).s01award(awardOfBF.getS01award())
                .s02award(awardOfBF.getS02award()).s03award(awardOfBF.getS03award()).s04award(awardOfBF.getS04award())
                .s05award(awardOfBF.getS05award()).s10award(awardOfBF.getS10award()).s11award(awardOfBF.getS11award())
                .s12award(awardOfBF.getS12award()).s13award(awardOfBF.getS13award()).s14award(awardOfBF.getS14award())
                .s15award(awardOfBF.getS15award()).s20award(awardOfBF.getS20award()).s21award(awardOfBF.getS21award())
                .s22award(awardOfBF.getS22award()).s23award(awardOfBF.getS23award()).s24award(awardOfBF.getS24award())
                .s25award(awardOfBF.getS25award()).s30award(awardOfBF.getS30award()).s31award(awardOfBF.getS31award())
                .s32award(awardOfBF.getS32award()).s33award(awardOfBF.getS33award()).s40award(awardOfBF.getS40award())
                .s41award(awardOfBF.getS41award()).s42award(awardOfBF.getS42award()).s50award(awardOfBF.getS50award())
                .s51award(awardOfBF.getS51award()).s52award(awardOfBF.getS52award())
                .sWinAward(awardOfBF.getS_win_award()).sDrawAward(awardOfBF.getS_draw_award())
                .sLoseAward(awardOfBF.getS_lose_award()).build();
        return bfaward2;
    }

    private int getForPlayType(String name) {
        if(AwardListEnum.BFAWARD.name().equals(name)){
            return 1; //足球比分
        } else if(AwardListEnum.BQCAWARD.name().equals(name)){
            return 2; //足球半全场
        } else if(AwardListEnum.JQSAWARD.name().equals(name)){
            return 3; //足球进球数
        } else if(AwardListEnum.SPFAWARD.name().equals(name)){
            return 4; //足球胜平负
        } else if(AwardListEnum.RQSPFAWARD.name().equals(name)){
            return 5; //足球让球胜平负
        }
        return 0;
    }

    public List<FootBallMatch> getMatchListByIntTime(Set<Integer> intTimeSet) {
        if (intTimeSet == null || intTimeSet.isEmpty()) {
            throw new RuntimeException("intTime参数为空");
        }
        List<FootBallMatch> footBallMatches = sportteryFootballMatch2Mapper
                .selectMatchListByIntTime(new ArrayList<Integer>(intTimeSet));
        return footBallMatches;
    }

    public <A extends AbstractAward> A attachDirty(A newDbAward, AwardListEnum playType) {
        if (playType == null) {
            throw new RuntimeException("玩法类型传递错误");
        }
        int i = getForPlayType(playType.name());
        if(i == 0){
            throw new RuntimeException("玩法类型传递错误");
        }
        Integer id = newDbAward.getId();
        switch (i){
            case 1: //足球比分
                MatchAwardOfBF awardOfBF = (MatchAwardOfBF) newDbAward;
                SportteryFootballBfaward2 bfaward2 = getAwardByBf(awardOfBF);
                if(id == null) {
                    id = sportteryFootballBfaward2Mapper.insertSelective(bfaward2);
                } else {
                    bfaward2.setId(id);
                    sportteryFootballBfaward2Mapper.updateByPrimaryKeySelective(bfaward2);
                }
                break;
            case 2: //足球半全场
                MatchAwardOfBQC awardOfBQC = (MatchAwardOfBQC) newDbAward;
                SportteryFootballBqcaward2 bqcaward2 = getAwardByBqc(awardOfBQC);
                if(id == null) {
                    id = sportteryFootballBqcaward2Mapper.insertSelective(bqcaward2);
                } else {
                    bqcaward2.setId(id);
                    sportteryFootballBqcaward2Mapper.updateByPrimaryKeySelective(bqcaward2);
                }
                break;
            case 3: //足球进球数
                MatchAwardOfJQS awardOfJQS = (MatchAwardOfJQS) newDbAward;
                SportteryFootballJqsaward2 jqsaward2 = getAwardByJqs(awardOfJQS);
                if(id == null) {
                    id = sportteryFootballJqsaward2Mapper.insertSelective(jqsaward2);
                } else {
                    jqsaward2.setId(id);
                    sportteryFootballJqsaward2Mapper.updateByPrimaryKeySelective(jqsaward2);
                }
                break;
            case 4: //足球胜平负
                MatchAwardOfSPF awardOfSPF = (MatchAwardOfSPF) newDbAward;
                SportteryFootballSpfaward2 spfaward2 = getAwardBySpf(awardOfSPF);
                if(id == null) {
                    id = sportteryFootballSpfaward2Mapper.insertSelective(getAwardBySpf(awardOfSPF));
                } else {
                    spfaward2.setId(id);
                    sportteryFootballSpfaward2Mapper.updateByPrimaryKeySelective(spfaward2);
                }
                break;
            case 5: //足球让球胜平负
                MatchAwardOfRQSPF awardOfRQSPF = (MatchAwardOfRQSPF) newDbAward;
                SportteryFootballRqspfaward2 rqspfaward2 = getAwardByRqspf(awardOfRQSPF);
                if(id == null) {
                    id = sportteryFootballRqspfaward2Mapper.insertSelective(rqspfaward2);
                } else {
                    rqspfaward2.setId(id);
                    sportteryFootballRqspfaward2Mapper.updateByPrimaryKeySelective(rqspfaward2);
                }
                break;
        }
        if(id == 0){
            throw new RuntimeException("足球SP插入失败");
        }
        newDbAward.setId(id);
        return newDbAward;
    }

    public void attachDirty(List<FootBallMatch> jcList) {
        for(FootBallMatch match : jcList){
            SportteryFootballMatch2 match2 = getFootMatch2ByMatch(match);
            if(match.getId() == null){
                SportteryFootballMatch2 footballMatch2 =
                        sportteryFootballMatch2Mapper.getByIntTimeAndLineId(match.getIntTime(), match.getLineId());
                if(footballMatch2 == null) {
                    sportteryFootballMatch2Mapper.insertSelective(match2);
                } else {
                    match2.setId(footballMatch2.getId());
                    sportteryFootballMatch2Mapper.updateByPrimaryKeySelective(match2);
                }
            } else {
                match2.setId(match.getId());
                sportteryFootballMatch2Mapper.updateByPrimaryKeySelective(match2);
            }
        }
    }

    public void attachDirty(FootBallMatch footBallMatch) {
        SportteryFootballMatch2 match2 = getFootMatch2ByMatch(footBallMatch);
        if(footBallMatch.getId() == null){
            sportteryFootballMatch2Mapper.insertSelective(match2);
        } else {
            match2.setId(footBallMatch.getId());
            sportteryFootballMatch2Mapper.updateByPrimaryKeySelective(match2);
        }
    }

    /**
     * match To match2
     * @param match
     * @return
     */
    private SportteryFootballMatch2 getFootMatch2ByMatch(FootBallMatch match) {
        SportteryFootballMatch2 match2 = SportteryFootballMatch2.builder().bfShownum(match.getBfShowNum())
                .bqcShownum(match.getBqcShowNum()).concede(match.getConcede()).gamecolor(match.getGameColor())
                .gameId(match.getGameId()).gamename(match.getGameName()).gameShortName(match.getShortGameName())
                .guestscore(match.getGuestScore()).guestteam(match.getGuestTeam())
                .halfguestscore(match.getHalfGuestScore()).halfhomescore(match.getHalfHomeScore())
                .hasDelay(match.getHasDelay()).homescore(match.getHomeScore()).hometeam(match.getHomeTeam())
                .inttime(match.getIntTime()).jqsShownum(match.getJqsShowNum()).lineid(match.getLineId())
                .matchtime(match.getMatchTime()).outid(match.getOutId())
                .prizeType(match.getAddPrizeType() != null ? match.getAddPrizeType().getValue() : null)
                .resultawardofhftotopass(match.getResultAwardOfHfTotoPass())
                .resultawardofscorepass(match.getResultAwardOfScorePass())
                .resultawardofsinglescore(match.getResultAwardOfSingleScore())
                .resultawardoftotopass(match.getResultAwardOfTotoPass())
                .resultOfRule(match.getResultOfRule()).resultrqawardoftotopass(match.getResultRQAwardOfTotoPass())
                .rqspfShownum(match.getRqspfShowNum()).shownum(match.getShowNum()).spfShownum(match.getSpfShowNum())
                .status(match.getStatus()).version(match.getVersion() == null? i+1: match.getVersion())
                .worldscene(match.getWorldScene()).build();
        i = i+1;
        return match2;
    }

    public <A extends AbstractAward> Map<String, List<A>> findAllAward(List<Integer> matchIdList, LotteryType type,
                                                                       PassMode pass) {
        if(type == LotteryType.JC_ZQ_SPF || type == LotteryType.JC_ZQ_RQSPF ){
            AwardListEnum enuma = AwardListEnum.enumOfAwardByLotteryType(type);
            if (enuma == null) {
                throw new RuntimeException("玩法类型传递错误");
            }
            int i = getForPlayType(enuma.name());
            if(i == 0){
                throw new RuntimeException("玩法类型传递错误");
            }
            List<A> dbList = new ArrayList<A>();
            switch (i){
                case 4: //足球胜平负
                    List<MatchAwardOfSPF> spfList = sportteryFootballSpfaward2Mapper.selectAllAwardGroupByMatchId(
                            matchIdList, pass.ordinal());
                    dbList = (List<A>) spfList;
                    break;
                case 5: //足球让球胜平负
                    List<MatchAwardOfRQSPF> rqspfList = sportteryFootballRqspfaward2Mapper
                            .selectAllAwardGroupByMatchId(matchIdList, pass.ordinal());
                    dbList = (List<A>) rqspfList;
                    break;
            }
            Map<String, List<A>> map=new HashMap<String, List<A>>();
            if(dbList!=null && !dbList.isEmpty()){
                for (A award : dbList) {
                    String key=award.getIntTime()+"_"+award.getLineId();
                    List<A> list=null;
                    if(map.containsKey(key)){
                        list=map.get(key);
                    }else{
                        list=new ArrayList<A>();
                        map.put(key, list);
                    }
                    list.add(award);
                }
            }
            return map;
        }else{
            throw new RuntimeException("玩法类型传递错误,支持胜平负和让球胜平负玩法");
        }
    }

    public Map<Integer, AbstractAward> findMatchAwardMap(List<Integer> matchIds, PassMode pass, LotteryType jcZqSpf) {
        return null;
    }

    public List<FootBallMatch> findMatchListBetweenIntTimes(Integer bgintTime, Integer edintTime) {
        return null;
    }

    public List<FootBallMatch> findNewlyPrizeMatchList(int i) {
        return null;
    }
}
