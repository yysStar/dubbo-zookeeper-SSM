package com.qiyun.service.biz;

import com.qiyun.api.LotteryPlanApi;
import com.qiyun.model2.LotteryPlanWithBLOBs;
import com.qiyun.service.LotteryPlanService;
import com.qiyun.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("lotteryPlanApi")
public class LotteryPlanBiz implements LotteryPlanApi {

    @Autowired
    private LotteryPlanService lotteryPlanService;

    public Map<String,Object> getdetail(Map<String, Object> reqMap){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try{
            int planNo = Integer.parseInt(reqMap.get("planNo").toString());
            Map<String,Object> lotteryPlans = lotteryPlanService.getSporttery(planNo);
            LotteryPlanWithBLOBs lotteryPlanWithBLOBs = lotteryPlanService.selectByPrimaryKey(planNo);
            resultMap.putAll(lotteryPlans);
            resultMap.put("lotteryPlanWithBLOBs",lotteryPlanWithBLOBs);
            resultMap.put(Constants.CODE, Constants.SUCCESS_CODE);

        }catch (Exception e){
            // ------------查询失败--------------
            e.printStackTrace();
            resultMap.put(Constants.CODE, Constants.ERROR_CODE_5);
            resultMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);
        }
        return resultMap;
    }


}
