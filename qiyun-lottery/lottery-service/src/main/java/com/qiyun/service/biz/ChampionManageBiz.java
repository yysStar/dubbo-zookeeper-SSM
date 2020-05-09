package com.qiyun.service.biz;

import com.qiyun.api.ChampionManageApi;
import com.qiyun.dto.ChampionPlanDetailsDTO;
import com.qiyun.httpUtil.RedisUtil;
import com.qiyun.model2.ChampionPlanMatch;
import com.qiyun.service.ChampionPlanMatchService;
import com.qiyun.service.ChampionPlanService;
import com.qiyun.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("championManageApi")
public class ChampionManageBiz implements ChampionManageApi {
    @Autowired
    private ChampionPlanMatchService championPlanMatchService;
    @Autowired
    private ChampionPlanService championPlanService;

    /**
     * 手动维护失败开奖
     * @param teamIdList
     * @return
     */
    public Map<String, Object> putFailTeam(List<Integer> teamIdList) {
        Map<String, Object> map = new HashMap<String, Object>();
        for(int teamId : teamIdList){
            List<ChampionPlanMatch> planMatches = championPlanMatchService.getByTeamId(teamId);
            for(ChampionPlanMatch planMatch : planMatches){
                planMatch.setStatus(2);
                championPlanMatchService.update(planMatch);
                championPlanService.updateFailByTeamId(planMatch.getPlanId());
            }
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 手动维护成功开奖
     * @param teamId
     * @return
     */
    public Map<String, Object> putSuccessTeam(Integer teamId, Integer type) {
        Map<String, Object> map = new HashMap<String, Object>();
        //只要方案中选了该比赛的都为成功
        List<ChampionPlanMatch> planMatches = championPlanMatchService.getByTeamId(teamId);
        for(ChampionPlanMatch planMatch : planMatches){
            planMatch.setStatus(1);
            championPlanMatchService.update(planMatch);
            championPlanService.updateSuccessByTeamId(planMatch);
        }
        //把剩余未开奖的都置为失败
        List<ChampionPlanMatch> planMatcheList = championPlanMatchService.getAll(type);
        for(ChampionPlanMatch planMatch : planMatcheList){
            planMatch.setStatus(2);
            championPlanMatchService.update(planMatch);
            championPlanService.updateFailByTeamId(planMatch.getPlanId());
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 停售开关
     * @param type
     * @return
     */
    public Map<String, Object> openAndClose(Integer type) {
        Map<String, Object> map = new HashMap<String, Object>();
        Jedis jedis = RedisUtil.getJedis();
        jedis.set(Constants.CHAMPION, type + "");
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        jedis.close();
        return map;
    }

    /**
     * 获取冠亚军订单
     * @param account
     * @param offset
     * @param pageSize
     * @param startTime
     * @param endTime
     * @param planId
     * @return
     */
    public Map<String, Object> getPlanList(String account, int offset, int pageSize, Date startTime, Date endTime,
                     Integer planId){
        Map<String, Object> map = new HashMap<String, Object>();
        List<ChampionPlanDetailsDTO> list = championPlanService.getAllList(offset, pageSize,
                account, planId, startTime, endTime);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, list);
        return map;
    }
}
