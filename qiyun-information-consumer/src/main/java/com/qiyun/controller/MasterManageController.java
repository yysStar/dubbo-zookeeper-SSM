package com.qiyun.controller;

import com.qiyun.api.MasterManageApi;
import com.qiyun.controller.base.BaseController;
import com.qiyun.util.Constants;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/master")
public class MasterManageController extends BaseController{

    @Resource
    private MasterManageApi masterManageApi;

    /**
     * 获取云朵汇总列表
     * @return
     */
    @RequestMapping(value = "/getCloundSummaryList",method = RequestMethod.GET)
    public Map<String, Object> getCloundSummaryList(){
        Map<String, Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        String startTime = getStr("startTime");
        String endTime = getStr("endTime");
        Integer offset = getInt("offset",1);
        Integer pagesize = getInt("pagesize",10);
        map = masterManageApi.getCloundSummaryList(account,startTime,endTime,offset,pagesize);
        return map;
    }

    /**
     * 获取快速审核扣款列表
     * @return
     */
    @RequestMapping(value = "/getQuickReviwList",method = RequestMethod.GET)
    public Map<String, Object> getQuickReviwList(){
        Map<String, Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        String startTime = getStr("startTime");
        String endTime = getStr("endTime");
        Integer offset = getInt("offset",1);
        Integer pagesize = getInt("pagesize",10);
        map = masterManageApi.getQuickReviwList(account,startTime,endTime,offset,pagesize);
        return map;
    }

    /**
     * 获取打赏收入列表
     * @return
     */
    @RequestMapping(value = "/getRewardIncomeList",method = RequestMethod.GET)
    public Map<String, Object> getRewardIncomeList(){
        Map<String, Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        String startTime = getStr("startTime");
        String endTime = getStr("endTime");
        Integer offset = getInt("offset",1);
        Integer pagesize = getInt("pagesize",10);
        map = masterManageApi.getRewardIncomeList(account,startTime,endTime,offset,pagesize);
        return map;
    }

    /**
     * 获取推荐收入列表
     * @return
     */
    @RequestMapping(value = "/getRecommendIncomeList",method = RequestMethod.GET)
    public Map<String, Object> getRecommendIncomeList(){
        Map<String, Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        String startTime = getStr("startTime");
        String endTime = getStr("endTime");
        Integer offset = getInt("offset",1);
        Integer pagesize = getInt("pagesize",10);
        map = masterManageApi.getRecommendIncomeList(account,startTime,endTime,offset,pagesize);
        return map;
    }

    /**
     * 查看打赏流水记录
     * @return
     */
    @RequestMapping(value = "/getRewardList",method = RequestMethod.GET)
    public Map<String, Object> getRewardList(){
        Map<String, Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        String startTime = getStr("startTime");
        String endTime = getStr("endTime");
        Integer offset = getInt("offset",1);
        Integer pagesize = getInt("pagesize",10);
        map = masterManageApi.getRewardList(account,startTime,endTime,offset,pagesize);
        return map;
    }

    /**
     * 查看推荐退款记录
     * @return
     */
    @RequestMapping(value = "/getRecommendRefundList",method = RequestMethod.GET)
    public Map<String, Object> getRecommendRefundList(){
        Map<String, Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        String startTime = getStr("startTime");
        String endTime = getStr("endTime");
        Integer offset = getInt("offset",1);
        Integer pagesize = getInt("pagesize",10);
        map = masterManageApi.getRecommendRefundList(account,startTime,endTime,offset,pagesize);
        return map;
    }

    /**
     * 查看购买推荐记录
     * @return
     */
    @RequestMapping(value = "/getBuyRecommendList",method = RequestMethod.GET)
    public Map<String, Object> getBuyRecommendList(){
        Map<String, Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        String startTime = getStr("startTime");
        String endTime = getStr("endTime");
        Integer offset = getInt("offset",1);
        Integer pagesize = getInt("pagesize",10);
        map = masterManageApi.getBuyRecommendList(account,startTime,endTime,offset,pagesize);
        return map;
    }

    /**
     * 查看提现记录
     * @return
     */
    @RequestMapping(value = "/getWithdrawList",method = RequestMethod.GET)
    public Map<String, Object> getWithdrawList(){
        Map<String, Object> map = new HashMap<String, Object>();
        String account = getStr("account");
        String startTime = getStr("startTime");
        String endTime = getStr("endTime");
        Integer offset = getInt("offset",1);
        Integer pagesize = getInt("pagesize",10);
        map = masterManageApi.getWithdrawList(account,startTime,endTime,offset,pagesize);
        return map;
    }

    /**
     * 查看充值云朵记录
     * @return
     */
    @RequestMapping(value = "/getRechargeList",method = RequestMethod.GET)
    public Map<String, Object> getRechargeList(){
        Map<String, Object> map = new HashMap<String, Object>();
        String account = getStr("account");
        String startTime = getStr("startTime");
        String endTime = getStr("endTime");
        Integer offset = getInt("offset",1);
        Integer pagesize = getInt("pagesize",10);
        map = masterManageApi.getRechargeList(account,startTime,endTime,offset,pagesize);
        return map;
    }

    /**
     * 添加认证名人
     * @return
     */
    @RequestMapping(value = "/addMaster",method = RequestMethod.GET)
    public Map<String, Object> addMaster(){
        Map<String, Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        int sort = getInt("sort");
        map = masterManageApi.addMaster(account, sort);
        return map;
    }

    /**
     * 添加实战大神
     * @return
     */
    @RequestMapping(value = "/addHighGrade",method = RequestMethod.GET)
    public Map<String, Object> addHighGrade(){
        Map<String, Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        int sort = getInt("sort");
        map = masterManageApi.addHighGrade(account, sort);
        return map;
    }

    /**
     * 取消认证名人
     * @return
     */
    @RequestMapping(value = "/cancelMaster",method = RequestMethod.GET)
    public Map<String, Object> cancelMaster(){
        Map<String, Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        map = masterManageApi.cancelMaster(account);
        return map;
    }

    /**
     * 取消实战大神
     * @return
     */
    @RequestMapping(value = "/cancelHighGrade",method = RequestMethod.GET)
    public Map<String, Object> cancelHighGrade(){
        Map<String, Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        map = masterManageApi.cancelHighGrade(account);
        return map;
    }

    /**
     * 修改排序权重
     * @return
     */
    @RequestMapping(value = "/changeSort",method = RequestMethod.GET)
    public Map<String, Object> changeSort(){
        Map<String, Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        int sort = getInt("sort");
        map = masterManageApi.changeSort(account, sort);
        return map;
    }

    /**
     * 待审核列表
     * @return
     */
    @RequestMapping(value = "/examineList",method = RequestMethod.GET)
    public Map<String, Object> examineList(){
        Map<String, Object> map = new HashMap<String, Object>();
        int page = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        map = masterManageApi.examineList(page, pageSize);
        return map;
    }

    /**
     * 审核
     * @return
     */
    @RequestMapping(value = "/examine",method = RequestMethod.GET)
    public Map<String, Object> examine(){
        Map<String, Object> map = new HashMap<String, Object>();
        int id = getInt("id");
        int type = getInt("type");
        map = masterManageApi.examine(id, type);
        return map;
    }

    /**
     * 提现列表
     * @return
     */
    @RequestMapping(value = "/withdrawCashList",method = RequestMethod.GET)
    public Map<String, Object> withdrawCashList(){
        Map<String, Object> map = new HashMap<String, Object>();
        int page = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        map = masterManageApi.withdrawCashList(page, pageSize);
        return map;
    }

    /**
     * 提现确认
     * @return
     */
    @RequestMapping(value = "/withdrawCashConfirm",method = RequestMethod.GET)
    public Map<String, Object> withdrawCashConfirm(){
        Map<String, Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        if(account == null){
            map.put(Constants.CODE, Constants.ERROR_MSG_1);
            map.put(Constants.MSG, Constants.ERROR_MSG_1);
            return map;
        }
        map = masterManageApi.withdrawCashConfirm(account);
        return map;
    }
}
