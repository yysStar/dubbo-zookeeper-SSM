package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.mapper2.WinPromotion2Mapper;
import com.qiyun.model2.WinPromotion2;
import com.qiyun.model2.WinPromotion2Query;
import com.qiyun.service.WinPromotionService;
import com.qiyun.util.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WinPromotionServiceImpl implements WinPromotionService {

    @Resource
    private WinPromotion2Mapper winPromotion2Mapper;

    public Map<String, Object> addWinPromotion(WinPromotion2 winPromotion2) {
        winPromotion2Mapper.insertSelective(winPromotion2);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> updateWinPromotionStatus(WinPromotion2 winPromotion2) {
        winPromotion2Mapper.updateByPrimaryKeySelective(winPromotion2);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> getWinPromotion(Integer status,int page,int pageSize) {
        WinPromotion2Query winPromotion2Query = new WinPromotion2Query();
        WinPromotion2Query.Criteria criteria = winPromotion2Query.createCriteria();
        if (status!=null){
            criteria.andStatusEqualTo(status);
        }
        winPromotion2Query.setOrderByClause("create_time desc");
        PageHelper.startPage(page,pageSize);
        List<WinPromotion2> winPromotion2s = winPromotion2Mapper.selectByExampleWithBLOBs(winPromotion2Query);
        PageInfo<WinPromotion2> pageInfo = new PageInfo<WinPromotion2>(winPromotion2s);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,pageInfo);
        return map;
    }
}
