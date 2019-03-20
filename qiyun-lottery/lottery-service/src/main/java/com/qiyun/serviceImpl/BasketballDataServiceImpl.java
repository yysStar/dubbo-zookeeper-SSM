package com.qiyun.serviceImpl;

import com.qiyun.mapper2.*;
import com.qiyun.model.BasketBallBase;
import com.qiyun.model.basketball.BasketBallGame;
import com.qiyun.model.basketball.BasketballDxp;
import com.qiyun.model.basketball.BasketballOp;
import com.qiyun.model.basketball.BasketballYp;
import com.qiyun.model2.BasketballBase2;
import com.qiyun.model2.BasketballBase2Example;
import com.qiyun.model2.BasketballGameName2;
import com.qiyun.service.BasketballDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("basketballDataService")
public class BasketballDataServiceImpl implements BasketballDataService {
    @Resource
    private BasketballBase2Mapper basketballBase2Mapper;
    @Resource
    private SportteryBasketballYp2Mapper sportteryBasketballYp2Mapper;
    @Resource
    private SportteryBasketballOp2Mapper sportteryBasketballOp2Mapper;
    @Resource
    private SportteryBasketballDxp2Mapper sportteryBasketballDxp2Mapper;
    @Resource
    private BasketballGameName2Mapper basketballGameName2Mapper;

    public List<BasketBallBase> findByIds(List<Integer> oddIdList) {
        List<BasketBallBase> basketBallBases = new ArrayList<BasketBallBase>();
        BasketballBase2Example basketballBase2Example = new BasketballBase2Example();
        BasketballBase2Example.Criteria criteria = basketballBase2Example.createCriteria();
        criteria.andIdIn(oddIdList);
        List<BasketballBase2> basketBallBase2s = basketballBase2Mapper.selectByExample(basketballBase2Example);
        for(BasketballBase2 basketballBase2 : basketBallBase2s){
            basketBallBases.add(changeBasketBallBase(basketballBase2));
        }
        return basketBallBases;
    }

    /**
     * basketballBase转换
     * @param basketballBase2
     * @return
     */
    private BasketBallBase changeBasketBallBase(BasketballBase2 basketballBase2) {
        BasketBallBase basketBallBase = new BasketBallBase();
        basketBallBase.setAddSection(basketballBase2.getAddSection());
        basketBallBase.setFirstSection(basketballBase2.getFirstSection());
        basketBallBase.setFourthSection(basketballBase2.getFourthSection());
        basketBallBase.setIntTime(basketballBase2.getInttime());
        basketBallBase.setLineId(basketballBase2.getLineid());
        basketBallBase.setSecondSection(basketballBase2.getSecondSection());
        //标记赛事名称
        basketBallBase.setShortMatchName(basketballBase2.getMatchName());
        basketBallBase.setAnalysisId(basketballBase2.getAnalysisId());
        basketBallBase.setBfWhole(basketballBase2.getBfWhole());
        basketBallBase.setFinalGuestScore(basketballBase2.getFinalGuestScore());
        basketBallBase.setFinalHomeScore(basketballBase2.getFinalHomeScore());
        basketBallBase.setGameId(basketballBase2.getGameId());
        basketBallBase.setGuest(basketballBase2.getGuest());
        basketBallBase.setGuestId(basketballBase2.getGuestId());
        basketBallBase.setGuestPm(basketballBase2.getGuestPm());
        basketBallBase.setHome(basketballBase2.getHome());
        basketBallBase.setHomeId(basketballBase2.getHomeId());
        basketBallBase.setHomePm(basketballBase2.getHomePm());
        basketBallBase.setId(basketballBase2.getId());
        basketBallBase.setMatchDateStr(basketballBase2.getMatchDateStr());
        basketBallBase.setMatchName(basketballBase2.getMatchName());
        basketBallBase.setMatchTime(basketballBase2.getMatchTime());
        basketBallBase.setOddId(basketballBase2.getOddId());
        return basketBallBase;
    }

    public List<BasketballYp> getYpListByintTimes(String intTimes) {
        String[] intTimesArr = intTimes.split(",");
        List<String> intTimeList = Arrays.asList(intTimesArr);
        List<BasketballYp> basketballYps = sportteryBasketballYp2Mapper.selectByIntTimes(intTimeList);
        return basketballYps;
    }

    public List<BasketballOp> getOpListByintTimes(List<String> intTimeList, String company) {
        return sportteryBasketballOp2Mapper.selectByIntTimes(intTimeList, company);
    }

    public List<BasketballDxp> getDxpListByintTimes(String intTimes) {
        String[] intTimesArr = intTimes.split(",");
        List<String> intTimeList = Arrays.asList(intTimesArr);
        return sportteryBasketballDxp2Mapper.selectByIntTimes(intTimeList);
    }

    public BasketBallGame findGameByStandardName(String matchName) {
        return basketballGameName2Mapper.selectByStandardName(matchName);
    }

    public void attachDirty(BasketBallGame game) {
        BasketballGameName2 gameName = BasketballGameName2.builder().gameColor(game.getGameColor())
                .icon(game.getIcon()).mark(game.getMark()).shortName(game.getShortName())
                .standardName(game.getStandardName()).build();
        if(game.getId() == null){
            basketballGameName2Mapper.insertSelective(gameName);
        }else{
            gameName.setId(game.getId());
            basketballGameName2Mapper.updateByPrimaryKeyWithBLOBs(gameName);
        }
    }

    //创建或更新
    public void saveIfChange(BasketBallBase base) {
        BasketBallBase dbBase= basketballBase2Mapper.selectByIntTimeLindId(base.getIntTime(), base.getLineId());
        BasketballBase2 base2 = BasketballBase2.builder().addSection(base.getAddSection())
                .analysisId(base.getAnalysisId()).bfWhole(base.getBfWhole()).finalGuestScore(base.getFinalGuestScore())
                .finalHomeScore(base.getFinalHomeScore()).firstSection(base.getFirstSection())
                .fourthSection(base.getFourthSection()).gameId(base.getGameId()).guest(base.getGuest())
                .guestId(base.getGuestId()).guestPm(base.getGuestPm()).home(base.getHome()).homeId(base.getHomeId())
                .homePm(base.getHomePm()).inttime(base.getIntTime()).lineid(base.getLineId()).oddId(base.getOddId())
                .matchDateStr(base.getMatchDateStr()).matchName(base.getMatchName()).matchTime(base.getMatchTime())
                .secondSection(base.getSecondSection()).thirdSection(base.getThirdSection()).build();
        if(dbBase == null){
            basketballBase2Mapper.insertSelective(base2);
        } else {
            base2.setId(dbBase.getId());
            basketballBase2Mapper.updateByPrimaryKeySelective(base2);
        }
    }
}
