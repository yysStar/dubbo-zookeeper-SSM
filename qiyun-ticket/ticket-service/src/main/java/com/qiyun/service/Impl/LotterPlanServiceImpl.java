package com.qiyun.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qiyun.mapper.LotteryTypeMapper;
import com.qiyun.mapper2.LotteryPlanMapper;
import com.qiyun.mapper2.LotteryType2Mapper;
import com.qiyun.mapper2.SportteryBasketMatch2Mapper;
import com.qiyun.mapper2.SportteryFootballMatch2Mapper;
import com.qiyun.model2.*;
import com.qiyun.service.LotteryPlanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("lotteryPlanService")
public class LotterPlanServiceImpl implements LotteryPlanService {

    @Resource
    private SportteryBasketMatch2Mapper sportteryBasketMatch2Mapper;
    @Resource
    private SportteryFootballMatch2Mapper sportteryFootballMatch2Mapper;

    @Resource
    private LotteryType2Mapper lotteryType2Mapper;

    @Resource
    private LotteryPlanMapper lotteryPlanMapper;

    public LotteryPlanWithBLOBs getByPlanNo(int planNo) {
        return lotteryPlanMapper.selectByPrimaryKey(planNo);
    }

    public int updatePlanTicketStatus(LotteryPlanWithBLOBs lotteryPlan) {
        return lotteryPlanMapper.updateByPrimaryKeySelective(lotteryPlan);
    }

    public Map<String, Object> getSporttery(int planNo) {
        String content = sportteryFootballMatch2Mapper.getContent(planNo);
        int type = lotteryType2Mapper.getTypeByPlanNo(planNo);
        if (content != null) {
            JSONObject jsonObject = JSON.parseObject(content);
            if (jsonObject != null) {
                JSONArray matchItems = jsonObject.getJSONArray("matchItems");
                if (matchItems != null) {
                    List<Object> list = new ArrayList();
                    for (Object matchItem : matchItems) {
                        JSONObject match = (JSONObject) matchItem;
                        Integer lineId = match.getInteger("lineId");
                        Integer intTime = match.getInteger("intTime");
                        Object sporttery = null;
                        if (type == 38) {
                            SportteryFootballMatch2Query sportteryFootballMatch2Query = new SportteryFootballMatch2Query();
                            SportteryFootballMatch2Query.Criteria criteria = sportteryFootballMatch2Query.createCriteria();
                            criteria.andLineidEqualTo(lineId);
                            criteria.andInttimeEqualTo(intTime);
                            sporttery = sportteryFootballMatch2Mapper.selectByExample(sportteryFootballMatch2Query);

                        } else if (type == 39) {
                            SportteryBasketMatch2Query sportteryBasketMatch2Query = new SportteryBasketMatch2Query();
                            SportteryBasketMatch2Query.Criteria criteria = sportteryBasketMatch2Query.createCriteria();
                            criteria.andLineidEqualTo(lineId);
                            criteria.andInttimeEqualTo(intTime);
                            sporttery = sportteryBasketMatch2Mapper.selectByExample(sportteryBasketMatch2Query);
                        }
                        if (sporttery != null) {
                            list.add(sporttery);
                        }
                    }
                    Map<String, Object> map = new HashMap<String, Object>();
//                    map.put("content", content);
                    map.put("sportteryList", list);
                    return map;
                }
            }
        }
        throw new RuntimeException("json串有误");
    }

    public LotteryPlanWithBLOBs selectByPrimaryKey(int planNo) {
        return lotteryPlanMapper.selectByPrimaryKey(planNo);
    }

    public List<LotteryPlan> selectLotteryPlans(int value, int i, String term) {
        LotteryPlanExample lotteryPlanExample = new LotteryPlanExample();
        LotteryPlanExample.Criteria criteria = lotteryPlanExample.createCriteria();
        criteria.andLotteryTypeEqualTo(value);
        criteria.andPlanTicketStatusEqualTo(i);
        criteria.andTermEqualTo(term);
        return lotteryPlanMapper.selectByExample(lotteryPlanExample);
    }

    public void updateLotteryPlan(LotteryPlan lotteryPlan) {
        lotteryPlanMapper.updateByPrimaryKey(lotteryPlan);
    }



    public void update(LotteryPlanWithBLOBs byPlanNo) {
        lotteryPlanMapper.updateByPrimaryKeySelective(byPlanNo);
    }

}
