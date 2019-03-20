package com.qiyun.serviceImpl;

import com.qiyun.api.LotteryApi;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.grabber.model.AwardListEnum;
import com.qiyun.mapper2.SportteryBasketMatch2Mapper;
import com.qiyun.mapper2.SportteryBasketballAward2Mapper;
import com.qiyun.mapper2.SportteryBasketballFcaward2Mapper;
import com.qiyun.model.PassMode;
import com.qiyun.model.basketball.BasketBallMatch;
import com.qiyun.model.basketball.SFAward;
import com.qiyun.model.basketball.SFCAward;
import com.qiyun.model2.SportteryBasketMatch2;
import com.qiyun.model2.SportteryBasketballAward2;
import com.qiyun.model2.SportteryBasketballFcaward2;
import com.qiyun.service.BasketBallService;
import com.qiyun.utils.MatchUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service("basketBallService")
public class BasketBallServiceImpl implements BasketBallService {
    @Resource
    private SportteryBasketMatch2Mapper sportteryBasketMatch2Mapper;
    @Resource
    private SportteryBasketballAward2Mapper sportteryBasketballAward2Mapper;
    @Resource
    private SportteryBasketballFcaward2Mapper sportteryBasketballFcaward2Mapper;
    @Autowired
    private LotteryApi lotteryApi;

    private static int i = 0;

    public List<BasketBallMatch> findMatchByStatus(int ordinal) {
        List<SportteryBasketMatch2> list = sportteryBasketMatch2Mapper.findMatchByStatus(ordinal);
        List<BasketBallMatch> matches = new ArrayList<BasketBallMatch>();
        for(SportteryBasketMatch2 match2 : list){
            matches.add(changeBasketMatch(match2));
        }
        return matches;
    }

    /**
     * match BEAN转换
     * @param match2
     * @return
     */
    private BasketBallMatch changeBasketMatch(SportteryBasketMatch2 match2) {
        BasketBallMatch basketBallMatch = new BasketBallMatch();
        basketBallMatch.setAnalysisId(match2.getAnalysisId());
        basketBallMatch.setBaseBigOrSmall(match2.getBasebigorsmall());
        basketBallMatch.setResultOfDXF(match2.getResultofdxf());
        basketBallMatch.setDxfQ2Scene(match2.getDxfQ2Scene());
        basketBallMatch.setDxfShowNum(match2.getDxfShownum());
        basketBallMatch.setFourthSection(match2.getFourthsection());
        basketBallMatch.setFristSection(match2.getFristsection());
        basketBallMatch.setHandicap(match2.getHandicap());
        basketBallMatch.setOutId(match2.getOutid());
        basketBallMatch.setResultOfRFSF(match2.getResultofrfsf());
        basketBallMatch.setResultOfSF(match2.getResultofsf());
        basketBallMatch.setResultOfSFC(match2.getResultofsfc());
        basketBallMatch.setRfsfShowNum(match2.getRfsfShownum());
        basketBallMatch.setSecondSection(match2.getSecondsection());
        basketBallMatch.setSfcShowNum(match2.getSfcShownum());
        basketBallMatch.setShortGameName(match2.getGameShortName());
        basketBallMatch.setSfShowNum(match2.getSfShownum());
        basketBallMatch.setShowNum(match2.getShownum());
        basketBallMatch.setSingle_baseBigOrSmall(match2.getSingleBasebigorsmall());
        basketBallMatch.setSingle_handicap(match2.getSingleHandicap());
        basketBallMatch.setThirdSection(match2.getThirdsection());
        basketBallMatch.setGameColor(match2.getGamecolor());
        basketBallMatch.setGameId(match2.getGameId());
        basketBallMatch.setGameName(match2.getGamename());
        basketBallMatch.setGuestScore(match2.getGuestscore());
        basketBallMatch.setGuestTeam(match2.getGuestname());
        basketBallMatch.setHasDelay(match2.getHasDelay());
        basketBallMatch.setHomeScore(match2.getHomescore());
        basketBallMatch.setHomeTeam(match2.getHomename());
        basketBallMatch.setIntTime(match2.getInttime());
        basketBallMatch.setLineId(match2.getLineid());
        basketBallMatch.setMatchTime(match2.getMatchtime());
        basketBallMatch.setStatus(match2.getStatus());
        basketBallMatch.setVersion(match2.getVersion());
        basketBallMatch.setId(match2.getId());
        return basketBallMatch;
    }

    public <A extends AbstractAward> List<A> getAwardListByIntTimeListAndPlayType(
            Set<Integer> intTime, LotteryType type) {
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
            case 1:
                if (intTime.size() == 1) {
                    List<SFAward> sfAwardList = sportteryBasketballAward2Mapper
                            .selectByIntTime(intTime.iterator().next());
                    awardList = (List<A>) sfAwardList;
                } else {
                    List<SFAward> sfAwardList = sportteryBasketballAward2Mapper
                            .selectByIntTimes(new ArrayList<Integer>(intTime));
                    awardList = (List<A>) sfAwardList;
                }
                return awardList;
            case 2:
                if(intTime.size() == 1){
                    List<SFCAward> sfcAwardList = sportteryBasketballFcaward2Mapper
                            .selectByIntTime(intTime.iterator().next());
                    awardList = (List<A>) sfcAwardList;
                } else {
                    List<SFCAward> sfcAwardList = sportteryBasketballFcaward2Mapper
                            .selectByIntTimes(new ArrayList<Integer>(intTime));
                    awardList = (List<A>) sfcAwardList;
                }
                return awardList;
        }
        return awardList;
    }

    public <A extends AbstractAward> A saveAward(A award, AwardListEnum playType) {
        if (playType == null) {
            throw new RuntimeException("玩法类型为空");
        }
        int i = getForPlayType(playType.name());
        if (i == 0) {
            throw new RuntimeException("玩法类型不正确");
        }
        int id = 0;
        switch (i){
            case 1:
                SFAward sfAward = (SFAward) award;
                id = sportteryBasketballAward2Mapper.insertSelective(getAwardBySFAward(sfAward));
                break;
            case 2:
                SFCAward sfcAward = (SFCAward) award;
                id = sportteryBasketballFcaward2Mapper.insertSelective(getAwardBySFCAward(sfcAward));
                break;
        }
        if(id == 0){
            throw new RuntimeException("篮球SP插入失败");
        }
        award.setId(id);
        return award;
    }

    private SportteryBasketballFcaward2 getAwardBySFCAward(SFCAward sfcAward) {
        SportteryBasketballFcaward2 fcaward = SportteryBasketballFcaward2.builder()
                .gwawardof1to5(sfcAward.getGWawardOf1TO5()).gwawardof6to10(sfcAward.getGWawardOf6TO10())
                .gwawardof11to15(sfcAward.getGWawardOf11TO15()).gwawardof16to20(sfcAward.getGWawardOf16TO20())
                .gwawardof21to25(sfcAward.getGWawardOf21TO25()).gwawardof26(sfcAward.getGWawardOf26())
                .hwawardof1to5(sfcAward.getHWawardOf1TO5()).hwawardof6to10(sfcAward.getHWawardOf6TO10())
                .hwawardof11to15(sfcAward.getHWawardOf11TO15()).hwawardof16to20(sfcAward.getHWawardOf16TO20())
                .hwawardof21to25(sfcAward.getHWawardOf21TO25()).hwawardof26(sfcAward.getHWawardOf26())
                .inttime(sfcAward.getIntTime()).lastupdatetime(sfcAward.getLastUpdateTime())
                .lineid(sfcAward.getLineId()).matchid(sfcAward.getMatchId()).passmode(sfcAward.getPassMode()).build();
        return fcaward;
    }

    private SportteryBasketballAward2 getAwardBySFAward(SFAward sfAward) {
        SportteryBasketballAward2 award = SportteryBasketballAward2.builder()
                .awardofloseorsmall(sfAward.getLoseOrSmallAward()).awardofwinorbig(sfAward.getWinOrBigAward())
                .basebigorsmall(sfAward.getBaseBigOrSmall()).bsupdatetime(sfAward.getBsUpdateTime())
                .changeBs(sfAward.getBsChange()).changeHandicap(sfAward.getHandicapChange())
                .changeLoseorsmall(sfAward.getLoseOrSmallChange()).changeWinorbig(sfAward.getWinOrBigChange())
                .handicap(sfAward.getHandicap()).handupdatetime(sfAward.getHandUpdateTime())
                .inttime(sfAward.getIntTime()).lastupdatetime(sfAward.getLastUpdateTime()).lineid(sfAward.getLineId())
                .matchid(sfAward.getMatchId()).passmode(sfAward.getPassMode()).playtype(sfAward.getPlayType()).build();
        return award;
    }

    private int getForPlayType(String name) {
        if(AwardListEnum.SFAWARD.name().equals(name) || AwardListEnum.DXF.name().equals(name)
                || AwardListEnum.SFRFAWARD.name().equals(name) || AwardListEnum.BBHTAWARD.name().equals(name)
                || AwardListEnum.BBDGTZAWARD.name().equals(name)){
            return 1; //篮球胜负,大小分，让分胜负，混投，单关
        } else if(AwardListEnum.SFCAWARD.name().equals(name)){
            return 2; //篮球胜分差
        }
        return 0;
    }

    public <A extends AbstractAward> A attachDirty(A award, AwardListEnum playType) {
        if (playType == null) {
            throw new RuntimeException("玩法类型为空");
        }
        int i = getForPlayType(playType.name());
        if (i == 0) {
            throw new RuntimeException("玩法类型不正确");
        }
        Integer id = award.getId();
        switch (i){
            case 1:
                SFAward sfAward = (SFAward) award;
                SportteryBasketballAward2 award2 = getAwardBySFAward(sfAward);
                if(id == null) {
                    id = sportteryBasketballAward2Mapper.insertSelective(award2);
                } else {
                    award2.setId(id);
                    sportteryBasketballAward2Mapper.updateByPrimaryKeySelective(award2);
                }
                break;
            case 2:
                SFCAward sfcAward = (SFCAward) award;
                SportteryBasketballFcaward2 fcaward2 = getAwardBySFCAward(sfcAward);
                if(id == null) {
                    id = sportteryBasketballFcaward2Mapper.insertSelective(fcaward2);
                } else {
                    fcaward2.setId(id);
                    sportteryBasketballFcaward2Mapper.updateByPrimaryKeySelective(fcaward2);
                }
                break;
        }
        if(id == 0){
            throw new RuntimeException("篮球SP插入失败");
        }
        award.setId(id);
        return award;
    }

    /**
     * 保存比赛信息
     * @param match
     */
    public void save(BasketBallMatch match) {
        SportteryBasketMatch2 sportteryBasketMatch2 = getMarch2ByMatch(match);
        if(match.getId() == null) {
            sportteryBasketMatch2Mapper.insertSelective(sportteryBasketMatch2);
        } else {
            sportteryBasketMatch2.setId(match.getId());
            sportteryBasketMatch2Mapper.updateByPrimaryKeySelective(sportteryBasketMatch2);
        }
    }

    /**
     * match BEAN转换
     * @param match
     * @return
     */
    private SportteryBasketMatch2 getMarch2ByMatch(BasketBallMatch match){
        SportteryBasketMatch2 match2 = SportteryBasketMatch2.builder().analysisId(match.getAnalysisId())
                .basebigorsmall(match.getBaseBigOrSmall()).dxfQ2Scene(match.getDxfQ2Scene())
                .dxfShownum(match.getDxfShowNum()).fourthsection(match.getFourthSection())
                .fristsection(match.getFristSection()).gamecolor(match.getGameColor()).gameId(match.getGameId())
                .gamename(match.getGameName()).gameShortName(match.getShortGameName()).guestname(match.getGuestTeam())
                .guestscore(match.getGuestScore()).guestShortName(match.getShortGuestTeam())
                .handicap(match.getHandicap()).hasDelay(match.getHasDelay()).homename(match.getHomeTeam())
                .homescore(match.getHomeScore()).homeShortName(match.getShortHomeTeam()).inttime(match.getIntTime())
                .lineid(match.getLineId()).matchtime(match.getMatchTime()).outid(match.getOutId())
                .resultofdxf(match.getResultOfDXF()).resultofrfsf(match.getResultOfRFSF())
                .resultofsf(match.getResultOfSF()).resultofsfc(match.getResultOfSFC()).sfcShownum(match.getSfcShowNum())
                .rfsfShownum(match.getRfsfShowNum()).secondsection(match.getSecondSection()).status(match.getStatus())
                .sfShownum(match.getSfShowNum()).shownum(match.getShowNum()).singleHandicap(match.getSingle_handicap())
                .singleBasebigorsmall(match.getSingle_baseBigOrSmall()).thirdsection(match.getThirdSection())
                .version(match.getVersion() == null? i+1 : match.getVersion()).build();
        i = i+1;
        return match2;
    }

    public List<BasketBallMatch> getMatchListByIntTime(Set<Integer> intTimeSet) {
        if (intTimeSet == null || intTimeSet.isEmpty()) {
            throw new RuntimeException("intTime参数为空");
        }
        List<BasketBallMatch> basketBallMatches = sportteryBasketMatch2Mapper
                .selectMatchListByIntTime(new ArrayList<Integer>(intTimeSet));
        return basketBallMatches;
    }

    public void attachDirty(List<BasketBallMatch> arrangeList) {
        for(BasketBallMatch basketBallMatch : arrangeList) {
            SportteryBasketMatch2 match2 = getMarch2ByMatch(basketBallMatch);
            if(basketBallMatch.getId() == null) {
                sportteryBasketMatch2Mapper.insertSelective(match2);
            } else {
                match2.setId(basketBallMatch.getId());
                sportteryBasketMatch2Mapper.updateByPrimaryKeySelective(match2);
            }
        }
    }

    public void attachDirty(BasketBallMatch basketBallMatch) {
        SportteryBasketMatch2 match2 = getMarch2ByMatch(basketBallMatch);
        if(basketBallMatch.getId() == null) {
            sportteryBasketMatch2Mapper.insertSelective(match2);
        } else {
            match2.setId(basketBallMatch.getId());
            sportteryBasketMatch2Mapper.updateByPrimaryKeySelective(match2);
        }
    }

    public <A extends AbstractAward> A getAwardSpecial(Integer intTime, Integer lineId,
                                                       PassMode pm, AwardListEnum playType) {
        if (playType == null) {
            throw new RuntimeException("玩法类型为空");
        }
        int i = getForPlayType(playType.name());
        if (i == 0) {
            throw new RuntimeException("玩法类型不正确");
        }
        switch (i){
            case 1:
                List<SFAward> sfAward = sportteryBasketballAward2Mapper.selectByIntTimeAndLineId(intTime, lineId,
                        pm.ordinal(), playType.ordinal());
                if(sfAward.size() >= 1) {
                    A a = (A) sfAward.get(sfAward.size() - 1);
                    return a;
                } else {
                    return null;
                }
            case 2:
                List<SFCAward> sfcAward = sportteryBasketballFcaward2Mapper.selectByIntTimeAndLineId(intTime, lineId,
                        pm.ordinal(), playType.ordinal());
                if(sfcAward.size() >= 1) {
                    A a = (A) sfcAward.get(sfcAward.size() - 1);
                    return a;
                } else {
                    return null;
                }
        }
        return null;
    }
}
