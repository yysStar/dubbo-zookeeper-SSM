package com.qiyun.mapper2;

import com.qiyun.dto.BasketballMatchDetailsDTO;
import com.qiyun.dto.SportteryMatchDTO;
import com.qiyun.model2.SportteryBasketMatch;
import com.qiyun.model2.SportteryBasketMatchExample;
import com.qiyun.model2.SportteryFootballMatch;

import java.util.List;

public interface SportteryBasketMatchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportteryBasketMatch record);

    int insertSelective(SportteryBasketMatch record);

    List<SportteryBasketMatch> selectByExample(SportteryBasketMatchExample example);

    SportteryBasketMatch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportteryBasketMatch record);

    int updateByPrimaryKey(SportteryBasketMatch record);

    List<SportteryMatchDTO> selectMatchList(int date);

    BasketballMatchDetailsDTO selectMatchDetails(Integer matchId);

    List<SportteryBasketMatch> getOneBasketBallColor(int date);

    List<SportteryBasketMatch> getOneBasketBallColor2(int date);
}