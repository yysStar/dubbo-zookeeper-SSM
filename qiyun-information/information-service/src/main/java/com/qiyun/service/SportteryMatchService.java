package com.qiyun.service;

import com.qiyun.dto.BasketballMatchDetailsDTO;
import com.qiyun.dto.FootballMatchDetailsDTO;
import com.qiyun.dto.SportteryMatchDTO;
import com.qiyun.model2.SportteryBasketMatch;
import com.qiyun.model2.SportteryFootballMatch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SportteryMatchService {
    List<SportteryMatchDTO> getMatchList(int date, int type, int offset, int pageSize);

    List<BasketballMatchDetailsDTO> getBasketballMatchDetails(List<Integer> matchIds);

    List<FootballMatchDetailsDTO> getFootballMatchDetails(List<Integer> matchIds);

    SportteryFootballMatch getFootballMatchById(Integer matchId);

    SportteryBasketMatch getBasketballMatchById(Integer matchId);
}
