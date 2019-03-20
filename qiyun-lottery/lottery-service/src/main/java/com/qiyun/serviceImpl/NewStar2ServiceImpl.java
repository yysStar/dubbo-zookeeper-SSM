package com.qiyun.serviceImpl;

import com.qiyun.mapper2.Member2Mapper;
import com.qiyun.mapper2.NewStar2Mapper;
import com.qiyun.model2.Member2;
import com.qiyun.model2.NewStar2;
import com.qiyun.model2.NewStar2Query;
import com.qiyun.service.NewStar2Service;
import com.qiyun.util.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("newStar2Service")
public class NewStar2ServiceImpl implements NewStar2Service {

    @Resource
    private NewStar2Mapper newStar2Mapper;

    @Resource
    private Member2Mapper member2Mapper;

    public Map<String, Object> addNewStar(String[] accounts) {
        NewStar2Query newStar2Query = new NewStar2Query();
        newStar2Mapper.deleteByExample(newStar2Query);

        if (accounts!=null && accounts.length>0){
            for (String account : accounts) {
                NewStar2 newStar2 =new NewStar2();
                newStar2.setAccount(account);
                newStar2Mapper.insertSelective(newStar2);
            }
        }

        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);

        return map;

    }

    public Map<String, Object> getNewStar(int dan) {
        Map<String,Object> map = new HashMap<String,Object>();
        NewStar2Query newStar2Query = new NewStar2Query();
        List<NewStar2> newStar2s = newStar2Mapper.selectByExample(newStar2Query);
        if (newStar2s==null || newStar2s.size()<=0){
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            map.put(Constants.DATA,null);
            return map;
        }
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for (NewStar2 newStar2 : newStar2s) {
            Map<String,Object> map1 = new HashMap<String,Object>();
            Integer JZCount = newStar2Mapper.getZJCount(dan,newStar2.getAccount());
            Integer TZCount = newStar2Mapper.getTZCount(dan,newStar2.getAccount());
            Member2 member2 = member2Mapper.selectByAccount(newStar2.getAccount());
            map1.put("account",member2.getAccount());
            map1.put("username",member2.getUsername());
            map1.put("pictureUrl",member2.getPictureUrl());
            map1.put("winRate",TZCount+"中"+JZCount);
            list.add(map1);
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,list);
        return map;
    }
}
