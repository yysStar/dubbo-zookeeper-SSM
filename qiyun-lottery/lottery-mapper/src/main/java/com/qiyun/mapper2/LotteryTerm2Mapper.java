package com.qiyun.mapper2;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryTerm2;
import com.qiyun.model2.LotteryTerm2Query;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LotteryTerm2Mapper {
    int countByExample(LotteryTerm2Query example);

    int deleteByExample(LotteryTerm2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(LotteryTerm2 record);

    int insertSelective(LotteryTerm2 record);

    List<LotteryTerm2> selectByExampleWithBLOBs(LotteryTerm2Query example);

    List<LotteryTerm2> selectByExample(LotteryTerm2Query example);

    LotteryTerm2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LotteryTerm2 record, @Param("example") LotteryTerm2Query example);

    int updateByExampleWithBLOBs(@Param("record") LotteryTerm2 record, @Param("example") LotteryTerm2Query example);

    int updateByExample(@Param("record") LotteryTerm2 record, @Param("example") LotteryTerm2Query example);

    int updateByPrimaryKeySelective(LotteryTerm2 record);

    int updateByPrimaryKeyWithBLOBs(LotteryTerm2 record);

    int updateByPrimaryKey(LotteryTerm2 record);

    List<LotteryTerm2> getFootBallTerm();

    List<LotteryTerm2> getBasketTerm();

    LotteryTerm2 selectByLotteryTypeAndTerm(@Param("lotteryType") Integer lotteryType, @Param("term") String term);

    List<LotteryTerm2> selectByLotteryTypeAndDate(@Param("lotteryType") Integer lotteryType, @Param("time") Date time);

    List<LotteryTerm2> selectOverdueByDate(@Param("startTime") Date startTime,@Param("endTime") Date endTime,
                                           @Param("lotteryType") Integer lotteryType);

    void updateTermIsAbleForFootBall(int status);

    void updateTermIsAbleForBasketBall(Integer status);
}