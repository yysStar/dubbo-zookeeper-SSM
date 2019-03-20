package com.qiyun.controller;

import com.qiyun.api.CopyLotteryApi;
import com.qiyun.controller.base.BaseController;
import com.qiyun.util.Constants;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/copyLotteryPlan")
public class CopyLotteryPlanController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(CopyLotteryPlanController.class);

    @Resource
    private CopyLotteryApi copyLotteryApi;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public Map<String,Object> getIndexList(){
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> reqMap = new HashMap<String, Object>();
        int offset = getInt("offset",0);
        int pageSize = getInt("pageSize",20);
        String planNo = request.getParameter("planNo");
        reqMap.put("offset", offset);
        reqMap.put("pageSize", pageSize);
        reqMap.put("planNo", planNo);
        map=copyLotteryApi.getList(reqMap);
        if(Constants.SUCCESS_CODE != Integer.parseInt(map.get(Constants.CODE).toString())){
            return map;
        }
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

}
