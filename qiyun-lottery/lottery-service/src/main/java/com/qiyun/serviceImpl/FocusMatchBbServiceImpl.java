package com.qiyun.serviceImpl;

import com.qiyun.mapper2.FocusMatchBb2Mapper;
import com.qiyun.model2.FocusMatchBb2;
import com.qiyun.model2.FocusMatchBb2Query;
import com.qiyun.service.FocusMatchBbService;
import com.qiyun.util.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("focusMatchBbService")
public class FocusMatchBbServiceImpl implements FocusMatchBbService {

    @Resource
    private FocusMatchBb2Mapper focusMatchBb2Mapper;

    public void insert(FocusMatchBb2 focusMatchBb2) {
        FocusMatchBb2 focusMatchBb21 = focusMatchBb2Mapper.selectByPrimaryKey(focusMatchBb2.getMatchId());
        if (focusMatchBb21==null){
            focusMatchBb2Mapper.insertSelective(focusMatchBb2);
        }else{
            focusMatchBb21.setStatus(1);
            focusMatchBb2Mapper.updateByPrimaryKeySelective(focusMatchBb2);
        }
    }

    public Map<String, Object> updateBbFocusMatchStatus(Integer id) {
        Map<String,Object> map = new HashMap<String,Object>();
        FocusMatchBb2 focusMatchBb2 = focusMatchBb2Mapper.selectByPrimaryKey(id);
        focusMatchBb2.setStatus(0);
        focusMatchBb2Mapper.updateByPrimaryKeySelective(focusMatchBb2);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }
}
