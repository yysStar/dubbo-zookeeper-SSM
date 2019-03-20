package com.qiyun.service.biz;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.api.LotteryTermApi;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryTerm2;
import com.qiyun.service.LotteryTermService;
import com.qiyun.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("lotteryTermApi")
public class LotteryTermBiz implements LotteryTermApi {
    @Autowired
    private LotteryTermService lotteryTermService;

    public Map<String, Object> findByLotteryTypeAndTerm(Integer lotteryTypeValue, Integer buildCount) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if (lotteryTypeValue == 25 || lotteryTypeValue == 20 || lotteryTypeValue == 8 || lotteryTypeValue == 7 || lotteryTypeValue == 5) {
                LotteryType lotterTypeIn = LotteryType.getItem(lotteryTypeValue);
                LotteryTerm2 lotteryTerm = this.lotteryTermService.findByLotteryTypeAndTerm(lotterTypeIn, buildCount);
                if (lotteryTerm != null) {
                    if (lotteryTerm.getTerm().equals(buildCount)) {
                        map.put(Constants.CODE, Constants.ERROR_CODE_400);
                        map.put(Constants.MSG, "彩期错误，出现相同彩期!");
                        return map;
                    }
                }
            }
            int num = Integer.valueOf(buildCount);
            this.lotteryTermService.buildTerm(lotteryTypeValue, num);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        } catch (Exception ex) {
            map.put(Constants.CODE, Constants.ERROR_CODE_400);
            map.put(Constants.MSG, "数据库查询失败");
            return map;
        }

    }

    public Map<String, Object> findTerm(Integer lotteryTypeValue, Integer page, Integer pageSize, String term) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {

            PageHelper.startPage(page, pageSize);
            List<LotteryTerm2> list = lotteryTermService.findTerm(lotteryTypeValue, term);
            PageInfo pageInfo = new PageInfo(list);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA, pageInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_400);
            map.put(Constants.MSG, "数据库查询失败");
        }
        return map;
    }

    public Map<String, Object> updateTerm(Map<String, Object> map) {
        Map<String, Object> reMap = new HashMap<String, Object>();
        try {
            //查询是否存在这个彩期
            List<LotteryTerm2> list = lotteryTermService.findTerm(Integer.parseInt(map.get("lotteryType") + ""), map.get("term") + "");
            if (list.size() < 1) {
                reMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                reMap.put(Constants.MSG, "未查询到数据");
                return reMap;
            }
            LotteryTerm2 lotteryTerm2 = list.get(0);
            if (!"".equals(map.get("isAble"))) {
                lotteryTerm2.setIsAble(Integer.parseInt(map.get("isAble") + ""));
            }
            if (!"".equals(map.get("status"))) {
                lotteryTerm2.setStatus(Integer.parseInt(map.get("status") + ""));
            }

            int i = lotteryTermService.updateTerm(lotteryTerm2);
            if (i > 0) {
                reMap.put(Constants.CODE, Constants.SUCCESS_CODE);
                reMap.put(Constants.MSG, Constants.SUCCESS_MSG);
            }else {
                reMap.put(Constants.CODE, Constants.ERROR_CODE_400);
                reMap.put(Constants.MSG, "数据修改失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            reMap.put(Constants.CODE, Constants.ERROR_CODE_400);
            reMap.put(Constants.MSG, "数据库查询失败");
        }
        return reMap;
    }
}