package com.qiyun.controller;

import com.qiyun.api.LotteryPlanApi;
import com.qiyun.controller.base.BaseController;
import com.qiyun.util.Constants;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/lotteryPlan")
public class LotterPlanController  extends BaseController {

   @Resource
    private LotteryPlanApi lotteryPlanApi;

    @RequestMapping(path = "/plan", method = RequestMethod.GET)
    public Map<String,Object> getdetailList(){
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> reqMap = new HashMap<String, Object>();
        String planNo = request.getParameter("planNo");
        reqMap.put("planNo", planNo);
        map=lotteryPlanApi.getdetail(reqMap);
        if(Constants.SUCCESS_CODE != Integer.parseInt(map.get(Constants.CODE).toString())){
            return map;
        }
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

}
