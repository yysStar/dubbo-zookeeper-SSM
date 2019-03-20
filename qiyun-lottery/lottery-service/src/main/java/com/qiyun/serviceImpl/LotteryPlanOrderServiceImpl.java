package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.common.Result;
import com.qiyun.dto.EvenTheRedMemberDTO;
import com.qiyun.dto.LotteryPlanOrder2DTO;
import com.qiyun.mapper2.LotteryPlanOrder2Mapper;
import com.qiyun.mapper2.Member2Mapper;
import com.qiyun.model.*;
import com.qiyun.model2.LotteryPlanOrder2;
import com.qiyun.model2.LotteryPlanOrder2Query;
import com.qiyun.model2.Member2;
import com.qiyun.service.LotteryPlanOrderService;
import com.qiyun.util.Constants;
import com.qiyun.utils.CopyUtils;
import com.qiyun.commonModel.LotteryType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LotteryPlanOrderServiceImpl implements LotteryPlanOrderService {

    private static Logger logger = LoggerFactory.getLogger(LotteryPlanOrderServiceImpl.class);

    @Resource
    private LotteryPlanOrder2Mapper lotteryPlanOrder2Mapper;

    @Resource
    private Member2Mapper member2Mapper;

    public Result insert(LotteryPlanOrder2DTO lotteryPlanOrder2DTO) {
        Result result = new Result();
        try {
            if (lotteryPlanOrder2DTO==null){
                result.setSuccess(false);
                return result;
            }
            LotteryPlanOrder2 lotteryPlanOrder2 = new LotteryPlanOrder2();
            CopyUtils.Copy(lotteryPlanOrder2,lotteryPlanOrder2DTO,true);
            lotteryPlanOrder2Mapper.insert(lotteryPlanOrder2);
            result.setSuccess(true);
            result.setData(lotteryPlanOrder2);
            return result;
        }catch (Exception e){
            logger.error("添加方案订单表出错",e);
            result.setSuccess(false);
            result.setMsg("添加方案订单表出错");
            return result;
        }
    }

    public Result getPlanForUserCenter(int planType,Integer lotteryType, Integer planStatus, Integer winStatus, int page, int pageSize,String account) {
        Result result = new Result();
        Map<String,Object> map = new HashMap<String,Object>();
        if (planType!=-1){
            map.put("planType",planType);
        }
        if (lotteryType!=-1){
            map.put("lotteryType",lotteryType);
        }
        if (planStatus!=-1){
            map.put("planStatus",planStatus);
        }
        if (winStatus!=-1){
            map.put("winStatus",winStatus);
        }
        map.put("start",(page - 1) * pageSize);
        map.put("end",pageSize);
        map.put("account",account);
        List<Map<String, Object>> planForUserCenter = lotteryPlanOrder2Mapper.getPlanForUserCenter(map);
        int totalCount = lotteryPlanOrder2Mapper.countPlanForUserCenter(map);
        if (planForUserCenter==null || planForUserCenter.size()<=0){
            result.setSuccess(true);
            return result;
        }
        List<Map<String,Object>> arr = new ArrayList<Map<String, Object>>();
        SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Map<String, Object> resMap : planForUserCenter) {
            Member2 member2 = member2Mapper.selectByAccount(resMap.get("account").toString());
            if (member2==null){
                result.setSuccess(false);
                result.setMsg("找不到会员");
                return result;
            }
            if (member2.getType()==1) {
                Map<String, Object> map2 = new HashMap<String, Object>();
                map2.put("planNo", resMap.get("plan_no"));
                map2.put("lotteryType", LotteryType.getItem((Integer) resMap.get("lottery_type")).getName());
                map2.put("term", resMap.get("term"));
                map2.put("amount", (Integer)resMap.get("amount")*member2.getMultiple());
                map2.put("founderAmount", (Integer)resMap.get("amount")*member2.getMultiple());
                map2.put("planType", PlanType.getItem((Integer)resMap.get("plan_type")).getName());
                map2.put("account", resMap.get("account"));
                map2.put("createDateTime", time.format((Date)resMap.get("create_date_time")));
                if ((Integer)resMap.get("plan_status") == 4) {
                    if ((Integer)resMap.get("win_status") == 3) {
                        map2.put("status", "已中奖");
                    } else if ((Integer)resMap.get("win_status") == 5) {
                        map2.put("status", "部分未中");
                    } else if ((Integer)resMap.get("win_status") == 6) {
                        map2.put("status", "已中奖");
                    } else if ((Integer)resMap.get("win_status") == 4 || (Integer)resMap.get("win_status") == 7) {
                        if ((Double)resMap.get("lp_posttax_prize")>(Double)resMap.get("lpo_posttax_prize")){
                            map2.put("status", "￥" + (Double)resMap.get("lp_posttax_prize")*member2.getMultiple()+"↑");
                        }else {
                            map2.put("status", "￥" + (Double) resMap.get("lp_posttax_prize") * member2.getMultiple());
                        }
                    } else {
                        map2.put("status", WinStatus.getItem((Integer)resMap.get("win_status")).getName());
                    }
                } else if ((Integer)resMap.get("plan_status") == 2) {
                    if ((Integer)resMap.get("sold_part") >= (Integer)resMap.get("amount")) {
                        map2.put("status", "已满员");
                    } else {
                        map2.put("status", "未满员");
                    }
                    if ((Integer)resMap.get("is_upload_content") == 1) {
                        map2.put("status", "等待上传");
                    } else {
                        map2.put("status", "已上传");
                    }
                } else {
                    map2.put("status", PlanStatus.getItem((Integer)resMap.get("plan_status")).getName());
                }
                arr.add(map2);
            }else{
                Map<String, Object> map2 = new HashMap<String, Object>();
                map2.put("planNo", resMap.get("plan_no"));
                map2.put("lotteryType", LotteryType.getItem((Integer) resMap.get("lottery_type")).getName());
                map2.put("term", resMap.get("term"));
                map2.put("amount", (Integer)resMap.get("amount"));
                map2.put("founderAmount", (Integer)resMap.get("amount"));
                map2.put("planType", PlanType.getItem((Integer)resMap.get("plan_type")).getName());
                map2.put("account", resMap.get("account"));
                map2.put("createDateTime", time.format((Date)resMap.get("create_date_time")));
                if ((Integer)resMap.get("plan_status") == 4) {
                    if ((Integer)resMap.get("win_status") == 3) {
                        map2.put("status", "已中奖");
                    } else if ((Integer)resMap.get("win_status") == 5) {
                        map2.put("status", "部分未中");
                    } else if ((Integer)resMap.get("win_status") == 6) {
                        map2.put("status", "已中奖");
                    } else if ((Integer)resMap.get("win_status") == 4 || (Integer)resMap.get("win_status") == 7) {
                        if ((Double)resMap.get("lp_posttax_prize")>(Double)resMap.get("lpo_posttax_prize")){
                            map2.put("status", "￥" + resMap.get("lp_posttax_prize")+"↑");
                        }else {
                            map2.put("status", "￥" + resMap.get("lp_posttax_prize"));
                        }
                    } else {
                        map2.put("status", WinStatus.getItem((Integer)resMap.get("win_status")).getName());
                    }
                } else if ((Integer)resMap.get("plan_status") == 2) {
                    if ((Integer)resMap.get("sold_part") >= (Integer)resMap.get("amount")) {
                        map2.put("status", "已满员");
                    } else {
                        map2.put("status", "未满员");
                    }
                    if ((Integer)resMap.get("is_upload_content") == 1) {
                        map2.put("status", "等待上传");
                    } else {
                        map2.put("status", "已上传");
                    }
                } else {
                    map2.put("status", PlanStatus.getItem((Integer)resMap.get("plan_status")).getName());
                }
                arr.add(map2);
            }
        }
        result.setSuccess(true);
        result.setData(arr);
        result.setTotalCount(totalCount);
        return result;
    }

    public Result getTRAmount(int planType,int lotteryType, int planStatus, int winStatus, String account) {
        Result result = new Result();
        Map<String,Object> map = new HashMap<String,Object>();
        if (planType!=-1){
            map.put("planType",planType);
        }
        if (lotteryType!=-1){
            map.put("lotteryType",lotteryType);
        }
        if (planStatus!=-1){
            map.put("planStatus",planStatus);
        }
        if (winStatus!=-1){
            map.put("winStatus",winStatus);
        }
        map.put("account",account);
        Integer tRAmount = lotteryPlanOrder2Mapper.getTRAmount(map);
        Member2 member2 = member2Mapper.selectByAccount(account);
        if (member2==null){
            result.setSuccess(false);
            result.setMsg("找不到会员");
            return result;
        }
        if (tRAmount==null) {
            result.setData(0);
        }else {
            if (member2.getType() == 1) {
                result.setData(tRAmount * member2.getMultiple());
            } else {
                result.setData(tRAmount);
            }
        }
        result.setSuccess(true);
        return result;
    }

    public Result getZJAmount(int planType,int lotteryType, int planStatus, int winStatus, String account) {
        Result result = new Result();
        Map<String,Object> map = new HashMap<String,Object>();
        if (planType!=-1){
            map.put("planType",planType);
        }
        if (lotteryType!=-1){
            map.put("lotteryType",lotteryType);
        }
        if (planStatus!=-1){
            map.put("planStatus",planStatus);
        }
        if (winStatus!=-1){
            map.put("winStatus",winStatus);
        }
        map.put("account",account);
        Double jZAmount = lotteryPlanOrder2Mapper.getZJAmount(map);
        Member2 member2 = member2Mapper.selectByAccount(account);
        if (member2==null){
            result.setSuccess(false);
            result.setMsg("找不到会员");
            return result;
        }
        if (jZAmount==null) {
            result.setData(0);
        }else {
            if (member2.getType() == 1) {
                result.setData(jZAmount * member2.getMultiple());
            } else {
                result.setData(jZAmount);
            }
        }
        result.setSuccess(true);
        return result;
    }

    public double getZJAmountByAccount(String account) {
        Double zjAmount = lotteryPlanOrder2Mapper.getWinAmount(account);
        return zjAmount;
    }

    public int getZJCountByAccount(String account) {
        int count = lotteryPlanOrder2Mapper.getZJCountByAccount(account);
        return count;
    }

    public int getTZCountByAccount(String account) {
        int count = lotteryPlanOrder2Mapper.getTZCountByAccount(account);
        return count;
    }

    public LotteryPlanOrder2 getByPlanNo(int planNo) {
        LotteryPlanOrder2Query lotteryPlanOrder2Query = new LotteryPlanOrder2Query();
        LotteryPlanOrder2Query.Criteria criteria = lotteryPlanOrder2Query.createCriteria();
        criteria.andPlanNoEqualTo(planNo);
        List<LotteryPlanOrder2> lotteryPlanOrder2s = lotteryPlanOrder2Mapper.selectByExample(lotteryPlanOrder2Query);
        if (lotteryPlanOrder2s==null || lotteryPlanOrder2s.size()<=0){
            return null;
        }
        return lotteryPlanOrder2s.get(0);
    }

    public Map<String, Object> getEvenTheRedList(int page, int pageSize, int day) {
        Calendar cal = Calendar.getInstance();
        Calendar calSmall = Calendar.getInstance();
        calSmall.setTime(cal.getTime());
        calSmall.set(Calendar.DATE,calSmall.get(Calendar.DATE)-day);
        Date time = calSmall.getTime();
        List<String> accounts = lotteryPlanOrder2Mapper.getGroupByAccount(time);

        List<EvenTheRedMemberDTO> list = new ArrayList<EvenTheRedMemberDTO>();
        for (String account : accounts) {
            LotteryPlanOrder2Query lotteryPlanOrder2Query = new LotteryPlanOrder2Query();
            LotteryPlanOrder2Query.Criteria criteria = lotteryPlanOrder2Query.createCriteria();
            criteria.andAccountEqualTo(account);
            criteria.andCreateDateTimeGreaterThan(time);
            criteria.andStatusEqualTo(2);
            List<LotteryPlanOrder2> lotteryPlanOrder2s = lotteryPlanOrder2Mapper.selectByExample(lotteryPlanOrder2Query);
            int count = 0;
            int maxCount = 0;
            for (LotteryPlanOrder2 lotteryPlanOrder2 : lotteryPlanOrder2s) {
                if (lotteryPlanOrder2.getPosttaxPrize()>0){
                    count+=1;
                }else{
                    count=0;
                }
                if (count>maxCount){
                    maxCount=count;
                }
            }
            EvenTheRedMemberDTO evenTheRedMemberDTO = new EvenTheRedMemberDTO();
            evenTheRedMemberDTO.setAccount(account);
            evenTheRedMemberDTO.setCount(maxCount);
            Member2 member2 = member2Mapper.selectByAccount(account);
            evenTheRedMemberDTO.setPicture(member2.getPicture());
            evenTheRedMemberDTO.setUsername(member2.getUsername());
            list.add(evenTheRedMemberDTO);
        }
        Collections.sort(list);
        List<EvenTheRedMemberDTO> list2 = new ArrayList<EvenTheRedMemberDTO>();
        for (int i = (page-1)*pageSize; i < page*pageSize; i++) {
             if (i<=list.size()-1){
                 list2.add(list.get(i));
             }
        }

        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,list2);
        map.put(Constants.TOTAL_COUNT,list.size());

        return map;

    }

    public Map<String, Object> getBetList(int page, int pageSize, int day) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calSmall = Calendar.getInstance();
        calSmall.setTime(cal.getTime());
        calSmall.set(Calendar.DATE,calSmall.get(Calendar.DATE)-day);
        Date time = calSmall.getTime();
        PageHelper.startPage(page,pageSize);
        List<Map> list = lotteryPlanOrder2Mapper.getBetList(time);
        PageInfo<Map> pageInfo = new PageInfo<Map>(list);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,pageInfo);

        return map;
    }

    public Map<String, Object> getAShortRed(int page, int pageSize, int day) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calSmall = Calendar.getInstance();
        calSmall.setTime(cal.getTime());
        calSmall.set(Calendar.DATE,calSmall.get(Calendar.DATE)-day);
        Date time = calSmall.getTime();
        PageHelper.startPage(page,pageSize);
        List<Map> list = lotteryPlanOrder2Mapper.getAShortRed(time);
        PageInfo<Map> pageInfo = new PageInfo<Map>(list);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,pageInfo);

        return map;
    }

    public void update(LotteryPlanOrder2 lotteryPlanOrder) {
        lotteryPlanOrder2Mapper.updateByPrimaryKeySelective(lotteryPlanOrder);
    }

    public Double getTotalAddPrizeByDay(String account) {
        return lotteryPlanOrder2Mapper.getTotalAddPrizeByDay(account);
    }


}
