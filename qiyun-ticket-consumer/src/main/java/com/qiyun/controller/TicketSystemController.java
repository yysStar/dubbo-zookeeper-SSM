package com.qiyun.controller;

import com.qiyun.DTO.TicketOperationLineSearch;
import com.qiyun.DTO.TicketPrintSearch;
import com.qiyun.api.TicketApi;
import com.qiyun.api.TicketSystemApi;
import com.qiyun.controller.base.BaseController;
import com.qiyun.util.Constants;
import com.qiyun.util.StringUtil;
import com.qiyun.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.PAData;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ticketSystem")
public class TicketSystemController extends BaseController{

    @Resource
    private TicketSystemApi ticketSystemApi;



    /**
     * 修改包拆票数
     * @return
     */
    @RequestMapping(path = "/updateChaiPiaoCount", method = RequestMethod.GET)
    public Map<String,Object> updateChaiPiaoCount(int count) {
        return ticketSystemApi.updateChaiPiaoCount(count);
    }

    /**
     * 获取包拆票数
     * @return
     */
    @RequestMapping(path = "/getChaiPiaoCount", method = RequestMethod.GET)
    public Map<String,Object> getChaiPiaoCount() {
        return ticketSystemApi.getChaiPiaoCount();
    }

    /**
     * 票统计
     * @return
     */
    @RequestMapping(path = "/ticketManagerByDealTime", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> ticketManagerByDealTime() {
        return ticketSystemApi.ticketManagerByDealTime();
    }

    /**
     * 人员状态表
     * @return
     */
    @RequestMapping(path = "/getUserStatus", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserStatus() {
        int page = getInt("page",1);
        int pageSize = getInt("pageSize",10);
        return ticketSystemApi.getUserStatus(page,pageSize);
    }

    /**
     * 操作人员打票记录
     * @return
     */
    @RequestMapping(path = "/ticketUserLine", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> ticketUserLine(String account) {
        int page = getInt("page",1);
        int pageSize = getInt("pageSize",10);
        return ticketSystemApi.ticketUserLine(account, page,pageSize);
    }

    /**
     * 操作流水
     * @return
     */
    @RequestMapping(path = "/ticketOperationLine", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> ticketOperationLineSearch(@RequestBody TicketOperationLineSearch ticketOperationLineSearch) {
        return ticketSystemApi.ticketOperationLineSearch(ticketOperationLineSearch);
    }

    /**
     * 打票详情
     * @return
     */
    @RequestMapping(path = "/ticketPrintDetail", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> ticketPrintDetail(int id) {
        return ticketSystemApi.ticketPrintDetail(id);
    }

    /**
     * 修改票状态
     * @return
     */
    @RequestMapping(path = "/updateTicketStatus", method = RequestMethod.GET)
    public Map<String,Object> updateTicketStatus() {
        int id = getInt("id");
        int status = getInt("status");
        return ticketSystemApi.updateTicketStatus(id,status);
    }

    /**
     * 优先推送
     * @return
     */
    @RequestMapping(path = "/firstPush", method = RequestMethod.GET)
    public Map<String,Object> firstPush(String[] ids) {
        return ticketSystemApi.firstPush(ids);
    }

    /**
     * 票查询
     * @return
     */
    @RequestMapping(path = "/ticketPrintSearch", method = RequestMethod.POST)
    public Map<String,Object> ticketPrintSearch(@RequestBody TicketPrintSearch ticketPrintSearch) {
        return ticketSystemApi.ticketPrintSearch(ticketPrintSearch);
    }

    /**
     * 运营总数据（人员）
     * @return
     */
    @RequestMapping(path = "/runDateForAccount", method = RequestMethod.GET)
    public Map<String,Object> runDateForAccount() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startTimeStr = request.getParameter("startTime");
        String endTimeStr = request.getParameter("endTime");
        Date startTime = new Date();
        Date endTime = new Date();
        if (StringUtils.isNullOrBlank(endTimeStr)){
            endTime = new Date();
            endTimeStr = simpleDateFormat.format(endTime);
        }
        if (StringUtils.isNullOrBlank(startTimeStr)){
            Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
            ca.setTime(new Date()); // 设置时间为当前时间
            ca.add(Calendar.MONTH, -1);// 月份减1
            startTime = ca.getTime(); // 结果
            startTimeStr = simpleDateFormat.format(startTime);
        }
        return ticketSystemApi.runDateForAccount(startTimeStr,endTimeStr);
    }

    /**
     * 运营总数据（时间）
     * @return
     */
    @RequestMapping(path = "/runDateForTime", method = RequestMethod.GET)
    public Map<String,Object> runDateForTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startTimeStr = request.getParameter("startTime");
        String endTimeStr = request.getParameter("endTime");
        Date startTime = new Date();
        Date endTime = new Date();
        if (StringUtils.isNullOrBlank(endTimeStr)){
            endTime = new Date();
            endTimeStr = simpleDateFormat.format(endTime);
        }
        if (StringUtils.isNullOrBlank(startTimeStr)){
            Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
            ca.setTime(new Date()); // 设置时间为当前时间
            ca.add(Calendar.MONTH, -1);// 月份减1
            startTime = ca.getTime(); // 结果
            startTimeStr = simpleDateFormat.format(startTime);
        }
        return ticketSystemApi.runDateForTime(startTimeStr,endTimeStr);
    }

    /**
     * 获取操作人员金额数据统计
     * @return
     */
    @RequestMapping(path = "/getUserAmountStatistics", method = RequestMethod.GET)
    public Map<String,Object> getUserAmountStatistics() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startTimeStr = request.getParameter("startTime");
        String endTimeStr = request.getParameter("endTime");
        String account = request.getParameter("account");
        Date startTime = new Date();
        Date endTime = new Date();
        if (StringUtils.isNullOrBlank(endTimeStr)){
            endTime = new Date();
            endTimeStr = simpleDateFormat.format(endTime);
        }
        if (StringUtils.isNullOrBlank(startTimeStr)){
            Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
            ca.setTime(new Date()); // 设置时间为当前时间
            ca.add(Calendar.MONTH, -1);// 月份减1
            startTime = ca.getTime(); // 结果
            startTimeStr = simpleDateFormat.format(startTime);
        }

        return ticketSystemApi.getUserAmountStatistics(account,startTimeStr,endTimeStr);
    }

    /**
     * 获取操作人员张数数据统计
     * @return
     */
    @RequestMapping(path = "/getUserCountStatistics", method = RequestMethod.GET)
    public Map<String,Object> getUserCountStatistics() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startTimeStr = request.getParameter("startTime");
        String endTimeStr = request.getParameter("endTime");
        String account = request.getParameter("account");
        Date startTime = new Date();
        Date endTime = new Date();
        if (StringUtils.isNullOrBlank(endTimeStr)){
            endTime = new Date();
            endTimeStr = simpleDateFormat.format(endTime);
        }
        if (StringUtils.isNullOrBlank(startTimeStr)){
            Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
            ca.setTime(new Date()); // 设置时间为当前时间
            ca.add(Calendar.MONTH, -1);// 月份减1
            startTime = ca.getTime(); // 结果
            startTimeStr = simpleDateFormat.format(startTime);
        }

        return ticketSystemApi.getUserCountStatistics(account,startTimeStr,endTimeStr);
    }

    /**
     * 获取当前操作人员信息
     * @return
     */
    @RequestMapping(path = "/getNowUserInfos", method = RequestMethod.GET)
    public Map<String,Object> getNowUserInfos() {
        String account = request.getParameter("account");
        return ticketSystemApi.getNowUserInfos(account);
    }

    /**
     * 加款/奖金
     * @return
     */
    @RequestMapping(path = "/addMoney", method = RequestMethod.GET)
    public Map<String,Object> addMoney() {
        String account = request.getParameter("account");
        double money = getDouble("money");
        double bonus = getDouble("bonus");
        return ticketSystemApi.addMoney(account,money,bonus);
    }

    /**
     * 获取票详情
     * @param id
     * @return
     */
    @RequestMapping(path = "/getTicketDetail", method = RequestMethod.GET)
    public Map<String,Object> getTicketDetail(int id) {
        Map<String,Object> map = new HashMap<String,Object>();
        Map<String,Object> list = ticketSystemApi.getTicketDetail(id);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,list);
        return map;
    }

    /**
     * 获取当前待打单
     * @param account
     * @return
     */
    @RequestMapping(path = "/getNowOrder", method = RequestMethod.GET)
    public Map<String,Object> getNowOrder(String account) {
        return ticketSystemApi.getNowOrder(account);
    }

    /**
     * 撤销订单
     * @param account
     * @return
     */
    @RequestMapping(path = "/revocationOrder", method = RequestMethod.GET)
    public Map<String,Object> revocationOrder(String account) {
        int residueCount = getInt("residueCount", 0);
        return ticketSystemApi.revocationOrder(account,residueCount);
    }

    /**
     * 完成订单
     * @param account
     * @return
     */
    @RequestMapping(path = "/finishOrder", method = RequestMethod.GET)
    public Map<String,Object> finishOrder(String account) {
        int residueCount = getInt("residueCount", 0);
        return ticketSystemApi.finishOrder(account,residueCount);
    }

    /**
     * 接单
     * @param account
     * @return
     */
    @RequestMapping(path = "/receivingOrder", method = RequestMethod.GET)
    public Map<String,Object> receivingOrder(String account) {
        return ticketSystemApi.receivingOrder(account);
    }

    /**
     * 修改打票人员状态
     * @return
     */
    @RequestMapping(path = "/updateUserType", method = RequestMethod.GET)
    public Map<String,Object> updateUserType(String account,int type) {
        double amount = getDouble("amount");
        double bonus = getDouble("bonus");
        String apparatusId = request.getParameter("apparatusId");
        return ticketSystemApi.updateUserType(account,type,amount,bonus,apparatusId); //0下线  1上线  2临时休息
    }

    /**
     * 添加打票人员
     * @return
     */
    @RequestMapping(path = "/addTicketUser", method = RequestMethod.GET)
    public Map<String,Object> addTicketUser(String account) {
        return ticketSystemApi.addTicketUser(account);
    }
}
