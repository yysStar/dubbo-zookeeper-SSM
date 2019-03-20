package com.qiyun.controller;

import com.qiyun.api.ChampionApi;
import com.qiyun.controller.base.BaseController;
import com.qiyun.dto.Member2DTO;
import com.qiyun.httpUtil.RedisUtil;
import com.qiyun.util.Constants;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/champion")
public class ChampionController extends BaseController {

    @Resource
    private ChampionApi championApi;

    /**
     * 冠军赛事列表
     * @return
     */
    @RequestMapping(value = "/getMatchList",method = RequestMethod.GET)
    public Map<String, Object> getMatchList(){
        Jedis jedis = RedisUtil.getJedis();
        Map<String, Object> map = new HashMap<String, Object>();
        map = championApi.getMatchList();
        map.put("isOpen", jedis.get(Constants.CHAMPION));
        jedis.close();
        return map;
    }

    /**
     * 冠亚军赛事列表
     * @return
     */
    @RequestMapping(value = "/getMatchUpList",method = RequestMethod.GET)
    public Map<String, Object> getMatchUpList(){
        Jedis jedis = RedisUtil.getJedis();
        Map<String, Object> map = new HashMap<String, Object>();
        map = championApi.getMatchUpList();
        map.put("isOpen", jedis.get(Constants.CHAMPION));
        jedis.close();
        return map;
    }

    /**
     * 冠亚军投注
     * @param matchIdList
     * @return
     */
    @RequestMapping(value = "/betChampion",method = RequestMethod.GET)
    public Map<String, Object> betChampion(Integer[] matchIdList){
        Map<String, Object> map = new HashMap<String, Object>();
        int type = getInt("type",1);
        int multiple = getInt("multiple", 1);
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        List<Integer> list = Arrays.asList(matchIdList);
        map = championApi.betChampion(member2DTO.getAccount(), type, list, multiple);
        return map;
    }

    /**
     * 我的冠亚军
     * @return
     */
    @RequestMapping(value = "/getPlanList",method = RequestMethod.GET)
    public Map<String, Object> getPlanList(){
        Map<String, Object> map = new HashMap<String, Object>();
        int offset = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        map = championApi.planList(member2DTO.getAccount(), offset, pageSize);
        return map;
    }

    /**
     * 获取中奖订单列表
     * @return
     */
    @RequestMapping(value = "/getPlanBingoList",method = RequestMethod.GET)
    public Map<String, Object> getPlanBingoList(){
        Map<String, Object> map = new HashMap<String, Object>();
        int offset = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        map = championApi.planBingoList(member2DTO.getAccount(), offset, pageSize);
        return map;
    }

    /**
     * 冠亚军详情
     * @return
     */
    @RequestMapping(value = "/getPlanDetails",method = RequestMethod.GET)
    public Map<String, Object> getPlanDetails(){
        Map<String, Object> map = new HashMap<String, Object>();
        int id = getInt("id",1);
        map = championApi.planDetails(id);
        return map;
    }
}
