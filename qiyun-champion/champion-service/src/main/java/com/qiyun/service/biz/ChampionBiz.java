package com.qiyun.service.biz;

import com.qiyun.api.ChampionApi;
import com.qiyun.model2.ChampionMatch;
import com.qiyun.model2.ChampionMatchUp;
import com.qiyun.service.ChampionMatchService;
import com.qiyun.service.ChampionMatchUpService;
import com.qiyun.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("championApi")
public class ChampionBiz implements ChampionApi {
    @Autowired
    private ChampionMatchService championMatchService;
    @Autowired
    private ChampionMatchUpService championMatchUpService;

    /**
     * 冠军赛事列表
     * @return
     */
    public Map<String, Object> getMatchList() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<ChampionMatch> list = championMatchService.getAll();
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, list);
        return map;
    }

    /**
     * 冠亚军赛事列表
     * @return
     */
    public Map<String, Object> getMatchUpList() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<ChampionMatchUp> list = championMatchUpService.getAll();
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, list);
        return map;
    }


}
