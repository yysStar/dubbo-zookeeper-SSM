package com.qiyun.service.biz;

import com.qiyun.DTO.TicketOperationLineSearch;
import com.qiyun.DTO.TicketPrintSearch;
import com.qiyun.api.TicketSystemApi;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.commonModel.PlayType;
import com.qiyun.model2.*;
import com.qiyun.service.*;
import com.qiyun.type.TicketUserTransType;
import com.qiyun.type.WalletTransType;
import com.qiyun.util.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.Ticket;

import java.math.BigDecimal;
import java.util.*;

@Service("ticketSystemApi")
public class TicketSystemBiz implements TicketSystemApi {

    @Autowired
    private TicketUserService ticketUserService;
    @Autowired
    private TicketOperationLineService ticketOperationLineService;
    @Autowired
    private TicketApparatusService ticketApparatusService;
    @Autowired
    private TicketPrintService ticketPrintService;
    @Autowired
    private LotteryPlanService lotteryPlanService;
    @Autowired
    private ConfigService configService;



    public Map<String, Object> addTicketUser(String account) {
        Map<String,Object> map = new HashMap<String,Object>();
        TicketUser ticketUser = ticketUserService.getByAccount(account);
        if (ticketUser!=null){
            map.put(Constants.CODE,Constants.ERROR_CODE_2);
            map.put(Constants.MSG,Constants.ERROR_MSG_2_1);
            return map;
        }
        TicketUser user = new TicketUser();
        user.setAccount(account);
        ticketUserService.add(user);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> updateUserType(String account, int type,double amount,double bonus,String apparatusId) {
        Map<String,Object> map = new HashMap<String,Object>();
        TicketUser ticketUser = ticketUserService.getByAccount(account);
        if (ticketUser==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,"登录超时,请重新登录!");
            return map;
        }
        Integer oldType = ticketUser.getType();
        String remark = "";

        TicketApparatus ticketApparatus = ticketApparatusService.getById(apparatusId);
        if (ticketApparatus==null || ticketApparatus.getStatus()!=1){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,"机器号输入错误!");
            return map;
        }
        if (type==2){
            if (oldType==1){
                //上线到休息
                ticketUser.setType(2);
                remark = "休息";
            }else if (oldType==2){
                //休息到上线
                ticketUser.setType(1);
                remark = "上线";
            }else{
                map.put(Constants.CODE,Constants.ERROR_CODE_425);
                map.put(Constants.MSG,"您还没上线!");
                return map;
            }
        }else{
            if (type==1){
                remark = "上线";
                ticketUser.setTicketApparatusId(apparatusId);
            }else{
                if (ticketUser.getTicketId()!=0){
                    map.put(Constants.CODE,Constants.ERROR_CODE_400);
                    map.put(Constants.MSG,"请先结束打票再下线!");
                    return map;
                }
                remark = "下线";
                ticketUser.setTicketApparatusId("");
            }
            if (oldType==type){
                map.put(Constants.CODE,Constants.ERROR_CODE_425);
                map.put(Constants.MSG,"您已"+remark+",请不要重复操作!");
                return map;
            }
            ticketUser.setType(type);
            //修改机器金额
            ticketApparatus.setAbleBalance(BigDecimalUtil.round(amount));
            ticketApparatus.setBonus(BigDecimalUtil.round(bonus));
            ticketApparatusService.updateByPrimaryKeySelective(ticketApparatus);
        }
        //修改人员你状态
        ticketUserService.updateByPrimaryKeySelective(ticketUser);
        //添加流水
        ticketOperationLineService.add(account, TicketUserTransType.ONOFF, BigDecimalUtil.round(0),0,apparatusId,ticketApparatus.getAbleBalance(),remark+",机器号:"+apparatusId+",金额:"+amount+",奖金:"+bonus,0);

        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> receivingOrder(String account) {
        Map<String,Object> map = new HashMap<String,Object>();

        TicketUser user = ticketUserService.getByAccount(account);
        if (user==null || user.getStatus()!=1){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,"登录超时!");
            return map;
        }
        if (user.getType()!=1){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,"请先上线!");
            return map;
        }
        if (user.getTicketId()!=0){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,"请不要重复接单!");
            return map;
        }

        TicketPrint ticket = ticketPrintService.orderReceiving();
        if (ticket==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,"当前没有待打票!");
            return map;
        }
        TicketApparatus apparatus = ticketApparatusService.getById(user.getTicketApparatusId());
        if (apparatus==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,"找不到当前打票机");
            return map;
        }
        String remark = "接收票:"+ticket.getId()+",金额:"+ticket.getAmount()+",张数:"+ticket.getCount();
        //更新操作人员状态
        user.setTicketId(ticket.getId());
        user.setPushCount(user.getPushCount()+ticket.getResidueCount());
        user.setPushAmount(BigDecimalUtil.add(user.getPushAmount(),ticket.getAmount()));
        ticketUserService.updateByPrimaryKeySelective(user);

        //更新票状态
        ticket.setStatus(2);
        ticket.setPushTime(new Date());
        ticket.setPrintId(user.getTicketApparatusId());
        ticket.setPrintAccount(user.getAccount());
        ticketPrintService.updateByPrimaryKeySelective(ticket);

        //添加流水
        ticketOperationLineService.add(account,TicketUserTransType.RECEIVE_ORDER,BigDecimalUtil.round((double)ticket.getAmount()),ticket.getId(),user.getTicketApparatusId(),apparatus.getAbleBalance(),remark,ticket.getResidueCount());

        Map<String, Object> ticketDetail = getTicketDetail(ticket.getId());

        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,ticketDetail);
        return map;
    }

    public Map<String, Object> finishOrder(String account,int residueCount) {
        Map<String,Object> map = new HashMap<String,Object>();
        TicketUser user = ticketUserService.getByAccount(account);
        if (user==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,"登录超时!");
            return map;
        }
        Integer ticketId = user.getTicketId();
        TicketPrint ticket = ticketPrintService.getById(ticketId);
        if (ticket==null || ticket.getStatus()!=2){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,"找不到当前票");
            return map;
        }
        if (residueCount>ticket.getCount()){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,"请检查剩余张数!");
            return map;
        }
        TicketApparatus apparatus = ticketApparatusService.getById(user.getTicketApparatusId());
        if (apparatus==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,"找不到当前打票机");
            return map;
        }
        int count = ticket.getCount()-residueCount; //处理张数
        int unitAmount = ticket.getAmount() / ticket.getCount(); //单张金额
        double unitBonus = ticket.getBonus().doubleValue() / ticket.getCount();//单张预测奖金
        String remark = "完成打票:"+ticket.getId()+",已打"+count+"张("+count*unitAmount+"元)";
        if (residueCount>0){
            //更新原包
            ticket.setAmount(unitAmount*count);
            ticket.setBonus(BigDecimalUtil.round(unitBonus*count));
            ticket.setCount(count);
            ticket.setResidueCount(0);
            ticket.setStatus(1);
            ticket.setFinishTime(new Date());
            //添加新包
            TicketPrint newTicket = new TicketPrint();
            newTicket.setAccount(ticket.getAccount());
            newTicket.setPlanNo(ticket.getPlanNo());
            newTicket.setContent(ticket.getContent());
            newTicket.setPasstype(ticket.getPasstype());
            newTicket.setAmount(unitAmount*residueCount);
            newTicket.setMultiple(ticket.getMultiple());
            newTicket.setCount(residueCount);
            newTicket.setBonus(BigDecimalUtil.round(unitBonus*residueCount));
            newTicket.setStatus(0);
            newTicket.setResidueCount(residueCount);
            newTicket.setCreateTime(new Date());
            newTicket.setDealTime(ticket.getDealTime());
            newTicket.setWeight(1);
            newTicket.setDlAccount(ticket.getDlAccount());
            newTicket.setQdAccount(ticket.getQdAccount());
            newTicket.setLotteryType(ticket.getLotteryType());
            ticketPrintService.insert(newTicket);
            remark += "剩余:"+residueCount+"张("+newTicket.getAmount()+"元),新包id:"+newTicket.getId();
        }else{
            ticket.setResidueCount(residueCount);
            ticket.setFinishTime(new Date());
            ticket.setStatus(1);
        }
        ticketPrintService.updateByPrimaryKeySelective(ticket);

        //更新打票人员状态
        user.setDisposeCount(user.getDisposeCount()+count);
        user.setDisposeAmount(BigDecimalUtil.round(user.getDisposeAmount().doubleValue()+count*unitAmount));
        user.setTicketId(0);
        ticketUserService.updateByPrimaryKeySelective(user);

        //更新打票机余额
//        apparatus.setAbleBalance(BigDecimalUtil.round(apparatus.getAbleBalance().doubleValue()-unitAmount*count));
//        ticketApparatusService.updateByPrimaryKeySelective(apparatus);

        //添加流水
        ticketOperationLineService.add(account,TicketUserTransType.FINISH_ORDER,BigDecimalUtil.round(unitAmount*count),ticketId,user.getTicketApparatusId(),apparatus.getAbleBalance(),remark,count);

        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> revocationOrder(String account, int residueCount) {
        Map<String,Object> map = new HashMap<String,Object>();
        TicketUser user = ticketUserService.getByAccount(account);
        if (user==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,"登录超时!");
            return map;
        }
        Integer ticketId = user.getTicketId();
        TicketPrint ticket = ticketPrintService.getById(ticketId);
        if (ticket==null || ticket.getStatus()!=2){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,"找不到当前票");
            return map;
        }
        if (residueCount>ticket.getCount()){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,"请检查剩余张数!");
            return map;
        }
        TicketApparatus apparatus = ticketApparatusService.getById(user.getTicketApparatusId());
        if (apparatus==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,"找不到当前打票机");
            return map;
        }
        int count = ticket.getCount()-residueCount; //处理张数
        int unitAmount = ticket.getAmount() / ticket.getCount(); //单张金额
        double unitBonus = ticket.getBonus().doubleValue() / ticket.getCount();//单张预测奖金
        String remark = "撤销票:"+ticket.getId()+",撤销:"+residueCount+"张,已打:"+unitAmount*count+"元";
        //更新票状态
        ticket.setStatus(3);
        ticket.setResidueCount(residueCount);
        ticket.setFinishTime(new Date());
        ticketPrintService.updateByPrimaryKeySelective(ticket);
        //更新打票人员状态
        user.setRevocationCount(user.getRevocationCount()+residueCount);
        user.setDisposeCount(user.getDisposeCount()+count);
        user.setRevocationAmount(BigDecimalUtil.round(user.getRevocationAmount().doubleValue()+unitAmount*residueCount));
        user.setDisposeAmount(BigDecimalUtil.round(user.getDisposeAmount().doubleValue()+count*unitAmount));
        user.setTicketId(0);
        ticketUserService.updateByPrimaryKeySelective(user);
        //更新打票机余额
//        apparatus.setAbleBalance(BigDecimalUtil.round(apparatus.getAbleBalance().doubleValue()-unitAmount*count));
//        ticketApparatusService.updateByPrimaryKeySelective(apparatus);
        //添加流水
        ticketOperationLineService.add(account,TicketUserTransType.REVOCATION_ORDER,BigDecimalUtil.round(unitAmount*residueCount),ticketId,user.getTicketApparatusId(),apparatus.getAbleBalance(),remark,residueCount);

        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> getNowOrder(String account) {
        Map<String,Object> map = new HashMap<String,Object>();
        TicketUser user = ticketUserService.getByAccount(account);
        if (user==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,"登录超时!");
            return map;
        }
        Integer ticketId = user.getTicketId();
        if (ticketId==0){
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,"当前没有待打票");
            return map;
        }
        TicketPrint ticket = ticketPrintService.getById(ticketId);
        if (ticket==null || ticket.getStatus()!=2){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,"找不到当前票");
            return map;
        }
        if (ticket.getStatus()!=2){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,"系统错误:当前票状态错误");
            return map;
        }
        Map<String, Object> ticketDetail = getTicketDetail(ticketId);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,ticketDetail);
        return map;
    }

    public Map<String,Object> getTicketDetail(int id) {
        Map<String,Object> map = new HashMap<String,Object>();
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        TicketPrint ticket = ticketPrintService.getById(id);
        if (ticket==null){
            return null;
        }
        LotteryPlanWithBLOBs plan = lotteryPlanService.getByPlanNo(ticket.getPlanNo());
        if (plan==null){
            return null;
        }
        JSONArray content = JSONArray.fromObject(ticket.getContent());
        for (Object o : content) {
            JSONObject option = JSONObject.fromObject(o);
            Map<String,Object> optionMap = new HashMap<String,Object>();
            optionMap.put("intTime",option.optString("intTime"));
            optionMap.put("lineId", LotteryUtils.getLineId(option.optInt("lineId")));
            optionMap.put("type", LotteryType.getItem(option.optInt("type")).getName());
            optionMap.put("typeValueStr",option.optString("typeValueStr"));
            optionMap.put("award",option.optString("award"));
            list.add(optionMap);
        }
        map.put("option",list);
        map.put("account",ticket.getAccount());
        map.put("planNo",ticket.getPlanNo());
        map.put("passType",LotteryUtils.getPassType(ticket.getPasstype()));
        map.put("amount",ticket.getAmount());
        map.put("multiple",ticket.getMultiple());
        map.put("residueCount",ticket.getResidueCount());
        map.put("dealTime",ticket.getDealTime());
        map.put("status",ticket.getStatus());
        map.put("id",ticket.getId());
        map.put("lotteryType",LotteryType.getItem(ticket.getLotteryType()).getName());
        map.put("dlAccount",ticket.getDlAccount());
        map.put("qdAccount",ticket.getQdAccount());
        map.put("printAccount",ticket.getPrintAccount());
        map.put("printId",ticket.getPrintId());
        map.put("createTime",ticket.getCreateTime());
        map.put("dealTime",ticket.getDealTime());
        map.put("pushTime",ticket.getPushTime());
        map.put("finishTime",ticket.getFinishTime());
        return map;
    }

    public Map<String,Object> addMoney(String account, double money, double bonus) {
        Map<String,Object> map = new HashMap<String,Object>();
        TicketUser user = ticketUserService.getByAccount(account);
        if (user==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,"登录超时!");
            return map;
        }
        TicketApparatus apparatus = ticketApparatusService.getById(user.getTicketApparatusId());
        if (apparatus==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,"找不到当前打票机");
            return map;
        }
        apparatus.setAbleBalance(BigDecimalUtil.round(apparatus.getAbleBalance().doubleValue()+money));
        apparatus.setBonus(BigDecimalUtil.round(apparatus.getBonus().doubleValue()+bonus));
        apparatus.setHeapAddBalance(BigDecimalUtil.round(apparatus.getHeapAddBalance().doubleValue()+money));
        ticketApparatusService.updateByPrimaryKeySelective(apparatus);

        if (money>0) {
            ticketOperationLineService.add(account, TicketUserTransType.CHARGE, BigDecimalUtil.round(money), 0, apparatus.getId(), apparatus.getAbleBalance(), "机器号:"+apparatus.getId()+",加款"+money+"元",0);
        }
        if (bonus>0){
            ticketOperationLineService.add(account, TicketUserTransType.CHARGE_BONUS, BigDecimalUtil.round(bonus), 0, apparatus.getId(), apparatus.getAbleBalance(), "机器号:"+apparatus.getId()+",加奖金"+bonus+"元",0);
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> getNowUserInfos(String account) {
        Map<String,Object> map = new HashMap<String,Object>();
        TicketUser user = ticketUserService.getByAccount(account);
        if (user==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,"登录超时!");
            return map;
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,user);
        return map;
    }

    public Map<String, Object> getUserCountStatistics(String account, String startTimeStr, String endTimeStr) {
        Map<String,Object> map = new HashMap<String,Object>();
        List<String> betweenDate = DateUtil.getBetweenDate(startTimeStr, endTimeStr);
        Collections.reverse(betweenDate);
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        List<Map> pushCountList = ticketOperationLineService.getSumTicketCountByTypeAndDateAndAccountGroupByDate(startTimeStr,endTimeStr,account,TicketUserTransType.RECEIVE_ORDER.getValue());
        List<Map> finishCountList = ticketOperationLineService.getSumTicketCountByTypeAndDateAndAccountGroupByDate(startTimeStr,endTimeStr,account,TicketUserTransType.FINISH_ORDER.getValue());
        List<Map> revocationCountList = ticketOperationLineService.getSumTicketCountByTypeAndDateAndAccountGroupByDate(startTimeStr,endTimeStr,account,TicketUserTransType.REVOCATION_ORDER.getValue());
        List<Map> amountList = ticketOperationLineService.getSumAmountByTypeAndDateAndAccountGroupByDate(startTimeStr,endTimeStr,account,TicketUserTransType.CHARGE.getValue());
        List<Map<String,Object>> resp = new LinkedList<Map<String, Object>>();
        Map<String,Object> pushCountMap = new HashMap<String,Object>();
        for (Map map1 : pushCountList) {
            pushCountMap.put(map1.get("date").toString(),map1.get("ticketCount"));
        }
        Map<String,Object> finishCountMap = new HashMap<String,Object>();
        for (Map map1 : finishCountList) {
            finishCountMap.put(map1.get("date").toString(),map1.get("ticketCount"));
        }
        Map<String,Object> revocationCountMap = new HashMap<String,Object>();
        for (Map map1 : revocationCountList) {
            revocationCountMap.put(map1.get("date").toString(),map1.get("ticketCount"));
        }
        Map<String,Object> sumAmountMap = new HashMap<String,Object>();
        for (Map map1 : amountList) {
            sumAmountMap.put(map1.get("date").toString(),map1.get("sumAmount"));
        }
        for (String date : betweenDate) {
            Map<String,Object> respMap = new HashMap<String,Object>();
            Map<String,Object> resp2Map = new HashMap<String,Object>();
            resp2Map.put("pushCount",pushCountMap.get(date)==null?0:pushCountMap.get(date));
            resp2Map.put("finishCount",finishCountMap.get(date)==null?0:finishCountMap.get(date));
            resp2Map.put("revocationCount",revocationCountMap.get(date)==null?0:revocationCountMap.get(date));
            resp2Map.put("sumAmount",sumAmountMap.get(date)==null?0:sumAmountMap.get(date));
            respMap.put(date,resp2Map);
            list.add(respMap);
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,list);
        return map;
    }

    public Map<String, Object> getUserAmountStatistics(String account, String startTimeStr, String endTimeStr) {
        Map<String,Object> map = new HashMap<String,Object>();
        List<String> betweenDate = DateUtil.getBetweenDate(startTimeStr, endTimeStr);
        Collections.reverse(betweenDate);
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        List<Map> pushAmountList = ticketOperationLineService.getSumAmountByTypeAndDateAndAccountGroupByDate(startTimeStr,endTimeStr,account,TicketUserTransType.RECEIVE_ORDER.getValue());
        List<Map> finishAmountList = ticketOperationLineService.getSumAmountByTypeAndDateAndAccountGroupByDate(startTimeStr,endTimeStr,account,TicketUserTransType.FINISH_ORDER.getValue());
        List<Map> revocationAmountList = ticketOperationLineService.getSumAmountByTypeAndDateAndAccountGroupByDate(startTimeStr,endTimeStr,account,TicketUserTransType.REVOCATION_ORDER.getValue());
        List<Map> amountList = ticketOperationLineService.getSumAmountByTypeAndDateAndAccountGroupByDate(startTimeStr,endTimeStr,account,TicketUserTransType.CHARGE_BONUS.getValue());
        Map<String,Object> pushAmountMap = new HashMap<String,Object>();
        for (Map map1 : pushAmountList) {
            pushAmountMap.put(map1.get("date").toString(),map1.get("sumAmount"));
        }
        Map<String,Object> finishAmountMap = new HashMap<String,Object>();
        for (Map map1 : finishAmountList) {
            finishAmountMap.put(map1.get("date").toString(),map1.get("sumAmount"));
        }
        Map<String,Object> revocationAmountMap = new HashMap<String,Object>();
        for (Map map1 : revocationAmountList) {
            revocationAmountMap.put(map1.get("date").toString(),map1.get("sumAmount"));
        }
        Map<String,Object> sumAmountMap = new HashMap<String,Object>();
        for (Map map1 : amountList) {
            sumAmountMap.put(map1.get("date").toString(),map1.get("sumAmount"));
        }
        for (String date : betweenDate) {
            Map<String,Object> respMap = new HashMap<String,Object>();
            Map<String,Object> resp2Map = new HashMap<String,Object>();
            resp2Map.put("pushAmount",pushAmountMap.get(date)==null?0:pushAmountMap.get(date));
            resp2Map.put("finishAmount",finishAmountMap.get(date)==null?0:finishAmountMap.get(date));
            resp2Map.put("revocationAmount",revocationAmountMap.get(date)==null?0:revocationAmountMap.get(date));
            resp2Map.put("sumAmount",sumAmountMap.get(date)==null?0:sumAmountMap.get(date));
            respMap.put(date,resp2Map);
            list.add(respMap);
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,list);
        return map;
    }

    public Map<String, Object> runDateForTime(String startTimeStr, String endTimeStr) {
        Map<String,Object> map = new HashMap<String,Object>();
        List<String> betweenDate = DateUtil.getBetweenDate(startTimeStr, endTimeStr);
        Collections.reverse(betweenDate);
        List<Map> pushAmountList = ticketOperationLineService.getSumAmountByTypeAndDateGroupByDate(startTimeStr,endTimeStr,TicketUserTransType.RECEIVE_ORDER.getValue());
        List<Map> finishAmountList = ticketOperationLineService.getSumAmountByTypeAndDateGroupByDate(startTimeStr,endTimeStr,TicketUserTransType.FINISH_ORDER.getValue());
        List<Map> revocationAmountList = ticketOperationLineService.getSumAmountByTypeAndDateGroupByDate(startTimeStr,endTimeStr,TicketUserTransType.REVOCATION_ORDER.getValue());
        List<Map> bonusAmountList = ticketOperationLineService.getSumAmountByTypeAndDateGroupByDate(startTimeStr,endTimeStr,TicketUserTransType.CHARGE_BONUS.getValue());
        List<Map> pushCountList = ticketOperationLineService.getSumTicketCountByTypeAndDateGroupByDate(startTimeStr,endTimeStr,TicketUserTransType.RECEIVE_ORDER.getValue());
        List<Map> finishCountList = ticketOperationLineService.getSumTicketCountByTypeAndDateGroupByDate(startTimeStr,endTimeStr,TicketUserTransType.FINISH_ORDER.getValue());
        List<Map> revocationCountList = ticketOperationLineService.getSumTicketCountByTypeAndDateGroupByDate(startTimeStr,endTimeStr,TicketUserTransType.REVOCATION_ORDER.getValue());
        List<Map> amountList = ticketOperationLineService.getSumAmountByTypeAndDateGroupByDate(startTimeStr,endTimeStr,TicketUserTransType.CHARGE.getValue());
        Map<String,Object> pushAmountMap = new HashMap<String,Object>();
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for (Map map1 : pushAmountList) {
            pushAmountMap.put(map1.get("date").toString(),map1.get("sumAmount"));
        }
        Map<String,Object> finishAmountMap = new HashMap<String,Object>();
        for (Map map1 : finishAmountList) {
            finishAmountMap.put(map1.get("date").toString(),map1.get("sumAmount"));
        }
        Map<String,Object> revocationAmountMap = new HashMap<String,Object>();
        for (Map map1 : revocationAmountList) {
            revocationAmountMap.put(map1.get("date").toString(),map1.get("sumAmount"));
        }
        Map<String,Object> sumAmountMap = new HashMap<String,Object>();
        for (Map map1 : amountList) {
            sumAmountMap.put(map1.get("date").toString(),map1.get("sumAmount"));
        }
        Map<String,Object> pushCountMap = new HashMap<String,Object>();
        for (Map map1 : pushCountList) {
            pushCountMap.put(map1.get("date").toString(),map1.get("ticketCount"));
        }
        Map<String,Object> finishCountMap = new HashMap<String,Object>();
        for (Map map1 : finishCountList) {
            finishCountMap.put(map1.get("date").toString(),map1.get("ticketCount"));
        }
        Map<String,Object> revocationCountMap = new HashMap<String,Object>();
        for (Map map1 : revocationCountList) {
            revocationCountMap.put(map1.get("date").toString(),map1.get("ticketCount"));
        }
        Map<String,Object> sumBonusAmountMap = new HashMap<String,Object>();
        for (Map map1 : bonusAmountList) {
            sumBonusAmountMap.put(map1.get("date").toString(),map1.get("sumAmount"));
        }

        for (String date : betweenDate) {
            Map<String,Object> respMap = new HashMap<String,Object>();
            Map<String,Object> resp2Map = new HashMap<String,Object>();
            resp2Map.put("pushAmount",pushAmountMap.get(date)==null?0:pushAmountMap.get(date));
            resp2Map.put("finishAmount",finishAmountMap.get(date)==null?0:finishAmountMap.get(date));
            resp2Map.put("revocationAmount",revocationAmountMap.get(date)==null?0:revocationAmountMap.get(date));
            resp2Map.put("sumAmount",sumAmountMap.get(date)==null?0:sumAmountMap.get(date));
            resp2Map.put("pushCount",pushCountMap.get(date)==null?0:pushCountMap.get(date));
            resp2Map.put("finishCount",finishCountMap.get(date)==null?0:finishCountMap.get(date));
            resp2Map.put("revocationCount",revocationCountMap.get(date)==null?0:revocationCountMap.get(date));
            resp2Map.put("sumBonusAmount",sumBonusAmountMap.get(date)==null?0:sumBonusAmountMap.get(date));
            respMap.put(date,resp2Map);
            list.add(respMap);
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,list);
        return map;
    }

    public Map<String, Object> runDateForAccount(String startTimeStr, String endTimeStr) {
        Map<String,Object> map = new HashMap<String,Object>();
        List<TicketUser> users = ticketUserService.getByStatus(1);
        if (users==null || users.size()<=0){
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            map.put(Constants.DATA,null);
            return map;
        }
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for (TicketUser user : users) {
            Map<String,Object> respMap = new HashMap<String,Object>();
            BigDecimal pushAmount = ticketOperationLineService.getSumAmountByTypeAndDate(startTimeStr,endTimeStr,TicketUserTransType.RECEIVE_ORDER.getValue(),user.getAccount());
            BigDecimal finishAmount = ticketOperationLineService.getSumAmountByTypeAndDate(startTimeStr,endTimeStr,TicketUserTransType.FINISH_ORDER.getValue(),user.getAccount());
            BigDecimal revocationAmount = ticketOperationLineService.getSumAmountByTypeAndDate(startTimeStr,endTimeStr,TicketUserTransType.REVOCATION_ORDER.getValue(),user.getAccount());
            BigDecimal bonusAmount = ticketOperationLineService.getSumAmountByTypeAndDate(startTimeStr,endTimeStr,TicketUserTransType.CHARGE_BONUS.getValue(),user.getAccount());
            Integer pushCount = ticketOperationLineService.getSumTicketCountByTypeAndDate(startTimeStr,endTimeStr,TicketUserTransType.RECEIVE_ORDER.getValue(),user.getAccount());
            Integer finishCount = ticketOperationLineService.getSumTicketCountByTypeAndDate(startTimeStr,endTimeStr,TicketUserTransType.FINISH_ORDER.getValue(),user.getAccount());
            Integer revocationCount = ticketOperationLineService.getSumTicketCountByTypeAndDate(startTimeStr,endTimeStr,TicketUserTransType.REVOCATION_ORDER.getValue(),user.getAccount());
            BigDecimal amount = ticketOperationLineService.getSumAmountByTypeAndDate(startTimeStr,endTimeStr,TicketUserTransType.CHARGE.getValue(),user.getAccount());
            respMap.put("account",user.getAccount());
            respMap.put("pushAmount",pushAmount);
            respMap.put("finishAmount",finishAmount);
            respMap.put("revocationAmount",revocationAmount);
            respMap.put("bonusAmount",bonusAmount);
            respMap.put("pushCount",pushCount);
            respMap.put("finishCount",finishCount);
            respMap.put("revocationCount",revocationCount);
            respMap.put("amount",amount);
            list.add(respMap);
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,list);
        return map;
    }

    public Map<String, Object> ticketPrintSearch(TicketPrintSearch ticketPrintSearch) {
        Map<String,Object> map = new HashMap<String,Object>();
        List<TicketPrint> ticketPrintList = ticketPrintService.ticketPrintSearch(ticketPrintSearch);
        if (ticketPrintList==null || ticketPrintList.size()<=0){
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            map.put(Constants.DATA,null);
            map.put(Constants.TOTAL_COUNT,0);
            return map;
        }
        int count = ticketPrintService.countTicketPrintSearch(ticketPrintSearch);
        List<Map<String,Object>> list = new LinkedList<Map<String, Object>>();
        for (TicketPrint ticketPrint : ticketPrintList) {
            Map<String,Object> respMap = new HashMap<String,Object>();
            respMap.put("id",ticketPrint.getId());
            respMap.put("planNo",ticketPrint.getPlanNo());
            respMap.put("createTime",ticketPrint.getCreateTime());
            respMap.put("lotteryType",LotteryType.getItem(ticketPrint.getLotteryType()).getName());
            respMap.put("passType",LotteryUtils.getPassType(ticketPrint.getPasstype()));
            respMap.put("amount",ticketPrint.getAmount());
            respMap.put("bonus",ticketPrint.getBonus());
            respMap.put("dealTime",ticketPrint.getDealTime());
            respMap.put("status",ticketPrint.getStatus());
            respMap.put("printAccount",ticketPrint.getPrintAccount());
            respMap.put("printId",ticketPrint.getPrintId());
            respMap.put("finishTime",ticketPrint.getFinishTime());
            respMap.put("pushTime",ticketPrint.getPushTime());
            respMap.put("count",ticketPrint.getCount());
            respMap.put("residueCount",ticketPrint.getResidueCount());
            respMap.put("dlAccount",ticketPrint.getDlAccount());
            respMap.put("qdAccount",ticketPrint.getQdAccount());
            respMap.put("multiple",ticketPrint.getMultiple());
            list.add(respMap);
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,list);
        map.put(Constants.TOTAL_COUNT,count);
        return map;
    }

    public Map<String, Object> firstPush(String[] ids) {
        Map<String,Object> map = new HashMap<String,Object>();
        for (String id : ids) {
            TicketPrint ticket = ticketPrintService.getById(Integer.parseInt(id));
            if (ticket==null){
                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                map.put(Constants.MSG,"找不到票:"+id);
                return map;
            }
            ticket.setWeight(1);
            ticketPrintService.updateByPrimaryKeySelective(ticket);
        }

        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    @Override
    public Map<String, Object> updateTicketStatus(int id, int status) {
        Map<String,Object> map = new HashMap<String,Object>();
        TicketPrint ticket = ticketPrintService.getById(id);
        if (ticket==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,Constants.ERROR_MSG_400);
            return map;
        }
        if (ticket.getStatus()!=0){
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,"只有待打票才能设置!");
            return map;
        }
        ticket.setStatus(status);
        ticketPrintService.updateByPrimaryKeySelective(ticket);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    @Override
    public Map<String, Object> ticketPrintDetail(int id) {
        Map<String,Object> map = new HashMap<String,Object>();
        Map<String,Object> map2 = new HashMap<String,Object>();
        TicketPrint ticket = ticketPrintService.getById(id);
        if (ticket==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,Constants.ERROR_MSG_400);
            return map;
        }
        LotteryPlanWithBLOBs plan = lotteryPlanService.getByPlanNo(ticket.getPlanNo());
        if (plan==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,Constants.ERROR_MSG_400);
            return map;
        }
        Map<String,Object> planDetail = getPlanDetail(plan);
        Map<String,Object> ticketDetail = getTicketDetail(id);
        map2.put("planDetail",planDetail);
        map2.put("ticketDetail",ticketDetail);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,map2);
        return map;
    }

    public Map<String, Object> ticketOperationLineSearch(TicketOperationLineSearch ticketOperationLineSearch) {
        List<TicketOperationLine> ticketOperationLines = ticketOperationLineService.ticketOperationLineSearch(ticketOperationLineSearch);
        Integer count = ticketOperationLineService.ticketOperationLineSearchCount(ticketOperationLineSearch);
        Map<String,Object> map = new HashMap<String,Object>();
        if (ticketOperationLines==null || ticketOperationLines.size()<=0){
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            map.put(Constants.DATA,null);
            map.put(Constants.TOTAL_COUNT,0);
            return map;
        }
        List<Map<String,Object>> list = new LinkedList<Map<String, Object>>();
        for (TicketOperationLine line : ticketOperationLines) {
            Map<String,Object> respMap = new HashMap<String,Object>();
            respMap.put("id",line.getId());
            respMap.put("account",line.getAccount());
            respMap.put("transType",TicketUserTransType.getItem(line.getTransType()).getName());
            respMap.put("ticketApparatusId",line.getTicketApparatusId());
            respMap.put("amount",line.getAmount());
            respMap.put("ticketId",line.getTicketId());
            respMap.put("createTime",line.getCreateTime());
            respMap.put("remark",line.getRemark());
            list.add(respMap);
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,list);
        map.put(Constants.TOTAL_COUNT,count);
        return map;
    }

    @Override
    public Map<String, Object> ticketUserLine(String account, int page, int pageSize) {
        Map<String,Object> map = new HashMap<String,Object>();
        List<TicketPrint> ticketPrints = ticketPrintService.getByPrintAccount(account,page,pageSize);
        if (ticketPrints==null || ticketPrints.size()<=0) {
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA, null);
            map.put(Constants.TOTAL_COUNT, 0);
            return map;
        }
        Integer count = ticketPrintService.countByPrintAccount(account);
        List<Map<String,Object>> list = new LinkedList<Map<String, Object>>();
        for (TicketPrint ticketPrint : ticketPrints) {
            Map<String,Object> respMap = new HashMap<String,Object>();
            respMap.put("id",ticketPrint.getId());
            respMap.put("amount",ticketPrint.getAmount());
            respMap.put("status",ticketPrint.getStatus());
            respMap.put("printId",ticketPrint.getPrintId());
            respMap.put("pushTime",ticketPrint.getPushTime());
            respMap.put("finishTime",ticketPrint.getFinishTime());
            list.add(respMap);
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, list);
        map.put(Constants.TOTAL_COUNT, count);
        return map;
    }

    public Map<String, Object> getUserStatus(int page, int pageSize) {
        Map<String,Object> map = new HashMap<String,Object>();
        List<TicketUser> users = ticketUserService.getByStatusAndPage(1,page,pageSize);
        Integer count = ticketUserService.getCountByStatus(1);
        if (users==null || users.size()<=0){
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            map.put(Constants.DATA,null);
            map.put(Constants.TOTAL_COUNT,0);
            return map;
        }
        List<Map<String,Object>> list = new LinkedList<Map<String, Object>>();
        for (TicketUser user : users) {
            Map<String,Object> respMap = new HashMap<String,Object>();
            respMap.put("account",user.getAccount());
            respMap.put("type",user.getType());
            respMap.put("ticketApparatusId",user.getTicketApparatusId());
            list.add(respMap);
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,list);
        map.put(Constants.TOTAL_COUNT,count);
        return map;
    }

    @Override
    public Map<String, Object> ticketManagerByDealTime() {
        Map<String,Object> map = new HashMap<String,Object>();
        List<Map> total = ticketPrintService.getTotalCountGroupByDealTime();
        if (total==null || total.size()<=0){
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            map.put(Constants.DATA,null);
            return map;
        }
        List<Map> noPrints = ticketPrintService.getCountByStatusGroupByDealTime(0); //待打
        List<Map> printeds = ticketPrintService.getCountByStatusGroupByDealTime(1); //已完成
        List<Map> printings = ticketPrintService.getCountByStatusGroupByDealTime(2); //正在打
        List<Map> revocationPrintings = ticketPrintService.getCountByStatusGroupByDealTime(3); //撤销
        List<Map<String,Object>> list = new LinkedList<Map<String, Object>>();

        Map<String,Object> totalMap = new HashMap<String,Object>();
        List<String> dealTimes = new LinkedList<String>();
        for (Map map1 : total) {
            totalMap.put(map1.get("date").toString(),map1.get("count"));
            dealTimes.add(map1.get("date").toString());
        }
        Map<String,Object> noPrintsMap = new HashMap<String,Object>();
        for (Map map1 : noPrints) {
            noPrintsMap.put(map1.get("date").toString(),map1.get("count"));
        }
        Map<String,Object> printedsMap = new HashMap<String,Object>();
        for (Map map1 : printeds) {
            printedsMap.put(map1.get("date").toString(),map1.get("count"));
        }
        Map<String,Object> printingsMap = new HashMap<String,Object>();
        for (Map map1 : printings) {
            printingsMap.put(map1.get("date").toString(),map1.get("count"));
        }
        Map<String,Object> revocationPrintingsMap = new HashMap<String,Object>();
        for (Map map1 : revocationPrintings) {
            revocationPrintingsMap.put(map1.get("date").toString(),map1.get("count"));
        }
        for (String dealTime : dealTimes) {
            Map<String,Object> timeMap = new HashMap<String,Object>();
            Map<String,Object> countMap = new HashMap<String,Object>();
            countMap.put("total",totalMap.get(dealTime)==null?0:totalMap.get(dealTime));
            countMap.put("noPrints",noPrintsMap.get(dealTime)==null?0:noPrintsMap.get(dealTime));
            countMap.put("printeds",printedsMap.get(dealTime)==null?0:printedsMap.get(dealTime));
            countMap.put("printings",printingsMap.get(dealTime)==null?0:printingsMap.get(dealTime));
            countMap.put("revocationPrintings",revocationPrintingsMap.get(dealTime)==null?0:revocationPrintingsMap.get(dealTime));
            timeMap.put(dealTime,countMap);
            list.add(timeMap);
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,list);
        return map;
    }

    @Override
    public Map<String, Object> getChaiPiaoCount() {
        Map<String,Object> map = new HashMap<String,Object>();
        Integer count = configService.getChaiPiaoCount();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,count);
        return map;
    }

    @Override
    public Map<String, Object> updateChaiPiaoCount(int count) {
        Map<String,Object> map = new HashMap<String,Object>();
        configService.updateChaiPiaoCount(count);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    private Map<String,Object> getPlanDetail(LotteryPlanWithBLOBs plan) {
        Map<String,Object> map = new HashMap<String,Object>();
        JSONObject content = JSONObject.fromObject(plan.getContent());
        JSONArray matchItems = content.optJSONArray("matchItems");
        List<Map<String,Object>> list = new LinkedList<Map<String, Object>>();
        for (Object matchItemObj : matchItems) {
            Map<String,Object> matchItemMap = new HashMap<String,Object>();
            JSONObject matchItem = JSONObject.fromObject(matchItemObj);
            String intTime = matchItem.optString("intTime");
            String week = DateUtil.getWeekForDateByIntTime(intTime);
            String lineId = LotteryUtils.getLineId(Integer.parseInt(matchItem.optString("lineId")));
            JSONArray options = matchItem.optJSONArray("options");
            List<Map<String,Object>> optionsMap = new LinkedList<Map<String, Object>>();
            for (Object optionObj : options) {
                Map<String,Object> optionMap = new HashMap<String,Object>();
                JSONObject option = JSONObject.fromObject(optionObj);
                String lotteryType = LotteryType.getItem(Integer.parseInt(option.optString("type"))).getName();
                String typeValueStr = option.optString("typeValueStr");
                String award = option.optString("award");
                optionMap.put("lotteryType",lotteryType);
                optionMap.put("typeValueStr",typeValueStr);
                optionMap.put("award",award);
                optionsMap.add(optionMap);
            }
            matchItemMap.put("intTime",intTime);
            matchItemMap.put("lineId",lineId);
            matchItemMap.put("week",week);
            matchItemMap.put("option",optionsMap);
            list.add(matchItemMap);
        }
        map.put("createDateTime",plan.getCreateDateTime());
        map.put("dealDateTime",plan.getDealDateTime());
        map.put("amount",plan.getAmount());
        map.put("planNo",plan.getPlanNo());
        map.put("passType", PlayType.getItem(plan.getPlayType()).getName());
        List<TicketPrint> tickets = ticketPrintService.getByPlanNo(plan.getPlanNo());
        int count = 0;
        for (TicketPrint ticket : tickets) {
            count += ticket.getCount();
        }
        map.put("ticketCount",tickets.size());
        map.put("count",count);
        map.put("matchItem",list);
        return map;
    }
}
