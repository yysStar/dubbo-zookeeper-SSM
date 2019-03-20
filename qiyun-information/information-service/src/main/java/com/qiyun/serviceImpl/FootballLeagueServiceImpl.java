package com.qiyun.serviceImpl;

import com.qiyun.mapper2.*;
import com.qiyun.model2.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballLeagueServiceImpl {

    @Autowired
    private FootballLeagueMapper footballLeagueMapper;

    @Autowired
    private MatchBetMappingMapper matchBetMappingMapper;

    @Autowired
    private FootballEventMapper footballEventMapper;

    @Autowired
    private FootballTechnicMapper footballTechnicMapper;

    @Autowired
    private BasketballLineupMapper basketballLineupMapper;

    public FootballLeague getById(int id) {
        return footballLeagueMapper.selectByPrimaryKey(id);
    }

    public int insert(FootballLeague footballTeam2) {
        return footballLeagueMapper.insertSelective(footballTeam2);
    }

    public int update(FootballLeague scoreliveFootballNowday) {
        return footballLeagueMapper.updateByPrimaryKeySelective(scoreliveFootballNowday);
    }

    /**
     * 彩票赛事与球探网关联表
     * @param id
     * @return
     */
    public MatchBetMapping getById2(String id) {
        return matchBetMappingMapper.selectByPrimaryKey(id);
    }

    public int insert2(MatchBetMapping footballTeam2) {
        return matchBetMappingMapper.insertSelective(footballTeam2);
    }

    public int update2(MatchBetMapping scoreliveFootballNowday) {
        return matchBetMappingMapper.updateByPrimaryKeySelective(scoreliveFootballNowday);
    }

    /**
     * 足球比赛事件表
     * @param id
     * @return
     */
    public List<FootballEvent> getById3(int id) {
        return footballEventMapper.selectById(id);
    }

    public List<FootballEvent> getById33(String id) {
        return footballEventMapper.selectById2(id);
    }

    public int insert3(FootballEvent footballTeam2) {
        return footballEventMapper.insertSelective(footballTeam2);
    }

//    public int update3(FootballEvent scoreliveFootballNowday) {
//        return footballEventMapper.updateByPrimaryKeySelective(scoreliveFootballNowday);
//    }

    public int getMaxVersion(Integer id){
        return footballEventMapper.getMaxVersion(id);
    }

    public int getMaxVersionCount(Integer id,Integer version){
        return footballEventMapper.getMaxVersionCount(id,version);
    }

    /**
     * 足球赛事技术统计表
     * @param id
     * @return
     */
    public FootballTechnic getById4(int id) {
        return footballTechnicMapper.selectByPrimaryKey(id);
    }

    public int insert4(FootballTechnic footballTeam2) {
        return footballTechnicMapper.insertSelective(footballTeam2);
    }

    public int update4(FootballTechnic scoreliveFootballNowday) {
        return footballTechnicMapper.updateByPrimaryKeySelective(scoreliveFootballNowday);
    }

}
