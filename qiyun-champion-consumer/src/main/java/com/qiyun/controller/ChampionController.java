package com.qiyun.controller;

import com.qiyun.api.ChampionApi;
import com.qiyun.controller.base.BaseController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/champion")
public class ChampionController extends BaseController{

    @Resource
    private ChampionApi championApi;

    @RequestMapping(value = "/getMatchList",method = RequestMethod.GET)
    public Map<String, Object> getMatchList(){
        Map<String, Object> map = new HashMap<String, Object>();
        map = championApi.getMatchList();
        return map;
    }

    @RequestMapping(value = "/getMatchUpList",method = RequestMethod.GET)
    public Map<String, Object> getMatchUpList(){
        Map<String, Object> map = new HashMap<String, Object>();
        map = championApi.getMatchUpList();
        return map;
    }

    public Map<String, Object> betChampion(){
        Map<String, Object> map = new HashMap<String, Object>();
        return map;
    }
}
