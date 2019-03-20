package com.qiyun.service;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model.LotteryTerm;
import com.qiyun.model2.LotteryTerm2;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface LotteryTermService {
    LotteryTerm2 getByLotteryAndTerm(int lotteryType, String term);

    LotteryTerm2 getNumberTerm(int i);

    LotteryTerm findOpenResultByLotteryType(LotteryType lotType);

    List<LotteryTerm> findOpennendTermByLotteryType(LotteryType pl5, int i, int i1);

    LotteryTerm findCurrentTermByLotteryType(LotteryType type);
	
    LotteryTerm2 findCurrentTermByLotteryType(int type);

    List<LotteryTerm2> getFootBallTerm();

    List<LotteryTerm2> getBasketTerm();

    LotteryTerm findOpenningTermByLotteryType(LotteryType lotteryType);

    LotteryTerm findByLotteryTypeAndTerm(LotteryType lotteryType, String term);

    void attachDirty(LotteryTerm lotteryTerm);

    LotteryTerm findById(Integer id);

    void initCurrentFlag(LotteryType lotteryType);

    LotteryTerm findCurrentTermByDate(LotteryType lotteryType, Date time);

    List<LotteryTerm> findOverdueByDateAndUnReturnPrizeTerm(LotteryType lotteryType);

    List findAfterByLotteryTypeAndTerm(LotteryType lotteryType, String term, int chaseCount);

    LotteryTerm findNextByLotteryTypeAndTerm(LotteryType lotteryType, String term);
	
    LotteryTerm2 findByLotteryTypeAndTerm(LotteryType lotterTypeIn, Integer buildCount);

    void buildTerm(Integer lotteryTypeValue, int num);

    List<LotteryTerm2> findTerm(Integer lotteryTypeValue, String term);

    int updateTerm(LotteryTerm2 lotteryTerm2);

    void updateTermIsAbleForFootBall(int status);

    void updateTermIsAbleForBasketBall(Integer status);

}
