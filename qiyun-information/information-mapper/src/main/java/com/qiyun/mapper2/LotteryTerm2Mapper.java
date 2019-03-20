package com.qiyun.mapper2;

import com.qiyun.model2.*;

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

    /**
     * 获取所有数字彩最新一期的开奖信息
     * @return
     */
    List<LotteryTerm2> getDigitalColor();


    /**
     * 获取所有高频彩最新一期的开奖信息
     * @return
     */
    List<LotteryTerm2> getFrequencyColor();

    /**
     * 获取某个特定彩种的最新十条开奖信息
     * @param type
     * @return
     */
    List<LotteryTerm2> getOneDigitalColor(int type);

    /**
     * 获取某个特定彩种的某个彩期的开奖信息
     * @param type
     * @return
     */
    LotteryTerm2 getOneDigitalColor2(@Param("type")int type,@Param("term")String term);

    SportteryBasketMatch getOneBasketBall();

    SportteryFootballMatch getOneFootBall();

    List<Integer> getTenLQ(int date);

    List<Integer> getTenZQ(int date);

    LotteryTerm2 findLastByLotteryType();

    Integer setPL3(@Param("result")String result,@Param("term")String term);

    Integer setPL5(@Param("result")String result,@Param("term")String term);
}