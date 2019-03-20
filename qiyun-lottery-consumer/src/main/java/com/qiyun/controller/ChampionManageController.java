package com.qiyun.controller;

import com.qiyun.api.ChampionManageApi;
import com.qiyun.controller.base.BaseController;
import com.qiyun.util.DateUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/champion")
public class ChampionManageController extends BaseController {
    @Resource
    private ChampionManageApi championManageApi;

    @RequestMapping(value = "/putFailTeam",method = RequestMethod.GET)
    public Map<String, Object> putFailTeam(Integer[] matchIdList){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Integer> list = Arrays.asList(matchIdList);
        map = championManageApi.putFailTeam(list);
        return map;
    }

    @RequestMapping(value = "/putSuccessTeam",method = RequestMethod.GET)
    public Map<String, Object> putSuccessTeam(){
        Map<String, Object> map = new HashMap<String, Object>();
        int teamId = getInt("teamId");
        int type = getInt("type");
        map = championManageApi.putSuccessTeam(teamId, type);
        return map;
    }

    @RequestMapping(value = "/openAndClose",method = RequestMethod.GET)
    public Map<String, Object> openAndClose(){
        Map<String, Object> map = new HashMap<String, Object>();
        int type = getInt("type");
        map = championManageApi.openAndClose(type);
        return map;
    }

    @RequestMapping(value = "/getAllPlanList",method = RequestMethod.GET)
    public Map<String, Object> getAllPlanList(){
        Map<String, Object> map = new HashMap<String, Object>();
        int offset = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        String account = request.getParameter("account");
        Integer planId = getInt("planId");
        String startTime = getStr("startTime");
        String endTime = getStr("endTime");
        //按时间查询
        Date staet = null;
        Date end = null;
        if(startTime != null && endTime != null){
            staet = DateUtil.StringToDate2(startTime);
            end = DateUtil.StringToDate2(endTime);
        }
        map = championManageApi.getPlanList(account, offset, pageSize, staet, end, planId);
        return map;
    }
}
