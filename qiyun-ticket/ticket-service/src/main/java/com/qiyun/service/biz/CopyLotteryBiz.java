package com.qiyun.service.biz;

import com.github.pagehelper.PageInfo;
import com.qiyun.api.CopyLotteryApi;
import com.qiyun.model2.CopyLotteryPlan;
import com.qiyun.service.CopyLotteryService;
import com.qiyun.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("copyLotteryApi")
public class CopyLotteryBiz implements CopyLotteryApi {

    @Autowired
    private CopyLotteryService copyLotteryService;

    public Map<String, Object> getList(Map<String, Object> reqMap) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            int offset = Integer.parseInt(reqMap.get("offset").toString());
            int pageSize = Integer.parseInt(reqMap.get("pageSize").toString());

            // 调用mapper分页查询出结果
//            CopyLotteryPlanExample copyLotteryPlanExample = new CopyLotteryPlanExample();
//            CopyLotteryPlanExample.Criteria criteria = copyLotteryPlanExample.createCriteria();
//            criteria.andCopyLotteryplanNoEqualTo(Integer.parseInt(reqMap.get("id").toString()));
            int planNo = Integer.parseInt(reqMap.get("planNo").toString());
//            PageHelper.startPage(offset, pageSize);
            PageInfo<CopyLotteryPlan> list = copyLotteryService.getPageCopyLotterPlanList(offset, pageSize, planNo);
//            List<CopyLotteryPlan> list = copyLotteryPlanMapper.selectByExample(copyLotteryPlanExample);
            // 将结果封装到map中返回
            resultMap.put("copyLotteryList", list);
//                resultMap.put("totalCount",pageResult.getTotal());
            resultMap.put(Constants.CODE, Constants.SUCCESS_CODE);

        } catch (Exception e) {
            // ------------查询失败--------------
            e.printStackTrace();
            resultMap.put(Constants.CODE, Constants.ERROR_CODE_5);
            resultMap.put(Constants.MSG, Constants.ERROR_MSG_5_2);
        }

        return resultMap;
    }

}
