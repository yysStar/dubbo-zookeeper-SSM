package com.qiyun.serviceImpl;

import com.qiyun.mapper2.FocusMatchFb2Mapper;
import com.qiyun.model2.FocusMatchFb2;
import com.qiyun.service.FocusMatchFbService;
import com.qiyun.util.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("focusMatchFbService")
public class FocusMatchFbServiceImpl implements FocusMatchFbService {

    @Resource
    private FocusMatchFb2Mapper focusMatchFb2Mapper;

    public void insert(FocusMatchFb2 focusMatchFb2) {
        FocusMatchFb2 focusMatchBb21 = focusMatchFb2Mapper.selectByPrimaryKey(focusMatchFb2.getMatchId());
        if (focusMatchBb21==null){
            focusMatchFb2Mapper.insertSelective(focusMatchFb2);
        }else{
            focusMatchBb21.setStatus(1);
            focusMatchFb2Mapper.updateByPrimaryKeySelective(focusMatchBb21);
        }
    }

    public Map<String, Object> updateFbFocusMatchStatus(Integer id) {
        Map<String,Object> map = new HashMap<String,Object>();
        FocusMatchFb2 focusMatchBb2 = focusMatchFb2Mapper.selectByPrimaryKey(id);
        focusMatchBb2.setStatus(0);
        focusMatchFb2Mapper.updateByPrimaryKeySelective(focusMatchBb2);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }
}
