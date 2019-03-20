package com.qiyun.controller;

import com.qiyun.api.LotteryTermApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/lottery")
public class LotteryTermController {
    @Autowired
    private LotteryTermApi lotteryTermApi;

    @RequestMapping("/addTerm")
    @ResponseBody
    public Map addTerm(@RequestParam Integer lotteryTypeValue, @RequestParam(defaultValue = "1") Integer buildCount) {
        Map<String, Object> map;
        map = lotteryTermApi.findByLotteryTypeAndTerm(lotteryTypeValue, buildCount);
        return map;
    }

    /**
     *
     * @param lotteryTypeValue 彩种
     * @param page
     * @param pageSize
     * @param term 彩期
     * @return
     */
    @RequestMapping("/findTerm")
    @ResponseBody
    public Map findTerm(@RequestParam Integer lotteryTypeValue, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer pageSize,@RequestParam String term) {
            Map<String, Object> map = lotteryTermApi.findTerm(lotteryTypeValue, page, pageSize,term);
        return map;
    }

    /**
     * 修改彩期
     * @param lotteryTypeValue 彩种
     * @param term 彩期
     * @param isAble 0是 1否 是否可用
     * @param status "已取消", 0 "未开启", 1 "已开启", 2 "关闭", 3 "已开奖", 4 "已派奖", 5    "已完结", 6
     * @return
     */
    @RequestMapping("/updateTerm")
    @ResponseBody
    public Map updateTerm(@RequestParam Integer lotteryTypeValue, @RequestParam String term ,@RequestParam  Integer isAble,@RequestParam Integer status) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("lotteryType",lotteryTypeValue);
        map.put("term",term);
        map.put("isAble",isAble);
        map.put("status",status);
        Map<String, Object> resMap= lotteryTermApi.updateTerm(map);
        return resMap;
    }

}
