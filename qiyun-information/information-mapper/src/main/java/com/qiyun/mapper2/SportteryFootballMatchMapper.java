package com.qiyun.mapper2;

import com.qiyun.dto.FootballMatchDetailsDTO;
import com.qiyun.dto.SportteryMatchDTO;
import com.qiyun.model2.SportteryFootballMatch;
import com.qiyun.model2.SportteryFootballMatchExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SportteryFootballMatchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportteryFootballMatch record);

    int insertSelective(SportteryFootballMatch record);

    List<SportteryFootballMatch> selectByExample(SportteryFootballMatchExample example);

    SportteryFootballMatch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportteryFootballMatch record);

    int updateByPrimaryKey(SportteryFootballMatch record);

    List<SportteryMatchDTO> selectMatchList(int date);

    FootballMatchDetailsDTO selectMatchDetails(Integer matchId);

    List<SportteryFootballMatch> getOneFootBallColor(int date);

    List<SportteryFootballMatch> getOneFootBallColor2(int date);

    SportteryFootballMatch getMatchByTime(@Param("intTime") Date intTime, @Param("lineId") int lineId);
    //修改比赛场次让球数
    int setConcede(@Param("id")Integer id,@Param("concede")Integer concede);
}