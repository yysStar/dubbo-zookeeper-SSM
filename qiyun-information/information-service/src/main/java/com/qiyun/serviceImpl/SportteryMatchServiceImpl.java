package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.qiyun.dto.BasketballMatchDetailsDTO;
import com.qiyun.dto.FootballMatchDetailsDTO;
import com.qiyun.dto.SportteryMatchDTO;
import com.qiyun.mapper2.SportteryBasketMatchMapper;
import com.qiyun.mapper2.SportteryFootballMatchMapper;
import com.qiyun.model2.SportteryBasketMatch;
import com.qiyun.model2.SportteryFootballMatch;
import com.qiyun.service.SportteryMatchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("sportteryMatchService")
public class SportteryMatchServiceImpl implements SportteryMatchService {
    @Resource
    private SportteryFootballMatchMapper sportteryFootballMatchMapper;
    @Resource
    private SportteryBasketMatchMapper sportteryBasketMatchMapper;

    public List<SportteryMatchDTO> getMatchList(int date, int type, int offset, int pageSize) {
        List<SportteryMatchDTO> matchDTOList = new ArrayList<SportteryMatchDTO>();
        PageHelper.startPage(offset, pageSize);
        if(type == 1){ //足球
            matchDTOList = sportteryFootballMatchMapper.selectMatchList(date);
        } else { //篮球
            matchDTOList = sportteryBasketMatchMapper.selectMatchList(date);
        }
        return matchDTOList;
    }

    public List<BasketballMatchDetailsDTO> getBasketballMatchDetails(List<Integer> matchIds) {
        List<BasketballMatchDetailsDTO> list = new ArrayList<BasketballMatchDetailsDTO>();
        for(Integer matchId : matchIds){
            BasketballMatchDetailsDTO basketballMatchDetails =
                    sportteryBasketMatchMapper.selectMatchDetails(matchId);
            list.add(basketballMatchDetails);
        }
        return list;
    }

    public List<FootballMatchDetailsDTO> getFootballMatchDetails(List<Integer> matchIds) {
        List<FootballMatchDetailsDTO> list = new ArrayList<FootballMatchDetailsDTO>();
        for(Integer matchId : matchIds){
            FootballMatchDetailsDTO footballMatchDetails = sportteryFootballMatchMapper.selectMatchDetails(matchId);
            list.add(footballMatchDetails);
        }
        return list;
    }

    public SportteryFootballMatch getFootballMatchById(Integer matchId) {
        return sportteryFootballMatchMapper.selectByPrimaryKey(matchId);
    }

    public SportteryBasketMatch getBasketballMatchById(Integer matchId) {
        return sportteryBasketMatchMapper.selectByPrimaryKey(matchId);
    }
}
