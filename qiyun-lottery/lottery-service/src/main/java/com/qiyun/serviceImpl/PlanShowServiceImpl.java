package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.qiyun.commonModel.PlayType;
import com.qiyun.dto.Member2DTO;
import com.qiyun.dto.PlanShow2DTO;
import com.qiyun.httpUtil.RedisUtil;
import com.qiyun.mapper2.LotteryPlan2Mapper;
import com.qiyun.mapper2.LotteryPlanOrder2Mapper;
import com.qiyun.mapper2.Member2Mapper;
import com.qiyun.mapper2.PlanShow2Mapper;
import com.qiyun.model2.*;
import com.qiyun.service.PlanShowService;
import com.qiyun.util.Constants;
import com.qiyun.utils.CopyUtils;
import com.qiyun.utils.StringUtils;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.*;

@Service
public class PlanShowServiceImpl implements PlanShowService {

    @Resource
    private PlanShow2Mapper planShow2Mapper;

    @Resource
    private Member2Mapper member2Mapper;

    @Resource
    private LotteryPlan2Mapper lotteryPlan2Mapper;

    @Resource
    private LotteryPlanOrder2Mapper lotteryPlanOrder2Mapper;

    public Map<String,Object> showPlan(int planNo, String title, Member2DTO member2DTO) {
        PlanShow2 planShow2 = new PlanShow2();
        planShow2.setPlanNo(planNo);
        planShow2.setAccount(member2DTO.getAccount());
        planShow2.setTitle(title);
        planShow2.setType(0);
        planShow2.setStatus(1);
        planShow2.setGoodCount(0);
        planShow2.setCreateDateTime(new Date());
        planShow2Mapper.insertSelective(planShow2);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public List<PlanShow2> getByPlanNoAndType(int planNo,int type) {
        PlanShow2Query planShow2Query = new PlanShow2Query();
        PlanShow2Query.Criteria criteria = planShow2Query.createCriteria();
        criteria.andPlanNoEqualTo(planNo);
        criteria.andTypeEqualTo(type);
        List<PlanShow2> planShow2s = planShow2Mapper.selectByExample(planShow2Query);
        return planShow2s;
    }

    public Map<String, Object> passShowPlanApply(int id, int type) {
        Map<String,Object> map = new HashMap<String,Object>();

        PlanShow2 planShow2 = planShow2Mapper.selectByPrimaryKey(id);
        if (planShow2==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,Constants.ERROR_MSG_400);
            return map;
        }
        if (planShow2.getType()!=0){
            map.put(Constants.CODE,Constants.ERROR_CODE_404);
            map.put(Constants.MSG,Constants.ERROR_MSG_404);
            return map;
        }
        planShow2.setType(type);
        planShow2Mapper.updateByPrimaryKeySelective(planShow2);

        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> updatePlanShowStatus(int id, int status) {
        Map<String,Object> map = new HashMap<String,Object>();

        PlanShow2 planShow2 = planShow2Mapper.selectByPrimaryKey(id);
        if (planShow2==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,Constants.ERROR_MSG_400);
            return map;
        }

        planShow2.setStatus(status);
        planShow2Mapper.updateByPrimaryKeySelective(planShow2);

        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> getPlanShow(String account, Integer planNo, Integer type, Integer status, int page, int pageSize) {
        Map<String,Object> map = new HashMap<String,Object>();
        PlanShow2Query planShow2Query = new PlanShow2Query();
        PlanShow2Query.Criteria criteria = planShow2Query.createCriteria();
        if (!StringUtils.isNullOrBlank(account)){
            criteria.andAccountEqualTo(account);
        }
        if (planNo!=null){
            criteria.andPlanNoEqualTo(planNo);
        }
        if (type!=null){
            criteria.andTypeEqualTo(type);
        }
        if (status!=null){
            criteria.andStatusEqualTo(status);
        }
        planShow2Query.setOrderByClause("create_date_time desc");
        PageHelper.startPage(page,pageSize);
        List<PlanShow2> planShow2s = planShow2Mapper.selectByExample(planShow2Query);
        int totalCount = planShow2Mapper.countByExample(planShow2Query);

        if (planShow2s==null){
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            return map;
        }
        List<PlanShow2DTO> list = new ArrayList<PlanShow2DTO>();
        for (PlanShow2 planShow2 : planShow2s) {
            PlanShow2DTO planShow2DTO = new PlanShow2DTO();
            CopyUtils.Copy(planShow2DTO,planShow2,true);
            list.add(planShow2DTO);
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,list);
        map.put(Constants.TOTAL_COUNT,totalCount);
        return map;
    }

    public Map<String, Object> getPlanShow2(int page, int pageSize,String account) {
        Map<String,Object> map = new HashMap<String,Object>();

        PlanShow2Query planShow2Query = new PlanShow2Query();
        PlanShow2Query.Criteria criteria = planShow2Query.createCriteria();
        criteria.andTypeEqualTo(1);
        criteria.andStatusEqualTo(1);
        planShow2Query.setOrderByClause("create_date_time desc");
        PageHelper.startPage(page,pageSize);
        List<PlanShow2> planShow2s = planShow2Mapper.selectByExample(planShow2Query);
        int totalCount = planShow2Mapper.countByExample(planShow2Query);

        if (planShow2s==null || planShow2s.size()<=0){
            map.put(Constants.CODE,Constants.SUCCESS_CODE);
            map.put(Constants.MSG,Constants.SUCCESS_MSG);
            map.put(Constants.DATA,planShow2s);
            map.put(Constants.TOTAL_COUNT,totalCount);
            return map;
        }
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        Jedis jedis = RedisUtil.getJedis();
        for (PlanShow2 planShow2 : planShow2s) {
            Map<String,Object> map2 = new HashMap<String,Object>();
            Member2 member2 = member2Mapper.selectByAccount(planShow2.getAccount());
            if (member2==null){
                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                return map;
            }
            LotteryPlan2WithBLOBs lotteryPlan2WithBLOBs = lotteryPlan2Mapper.selectByPlanNo(planShow2.getPlanNo());
            if (lotteryPlan2WithBLOBs==null){
                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                return map;
            }
            LotteryPlanOrder2 byPlanNo = lotteryPlanOrder2Mapper.getByPlanNo(planShow2.getPlanNo());
            if (byPlanNo==null){
                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                return map;
            }
            map2.put("account",planShow2.getAccount());
            map2.put("pictureUrl",member2.getPictureUrl());
            if (member2.getType()==1) {
                map2.put("amount",lotteryPlan2WithBLOBs.getAmount()*member2.getMultiple());
            }else{
                map2.put("amount",lotteryPlan2WithBLOBs.getAmount());
            }
            map2.put("username", member2.getUsername());
            map2.put("title",planShow2.getTitle());
            map2.put("id",planShow2.getId());
            map2.put("playType", PlayType.getItem(lotteryPlan2WithBLOBs.getPlayType()).getName());
            map2.put("haploidAmount",lotteryPlan2WithBLOBs.getAmount()/lotteryPlan2WithBLOBs.getMultiple());
            map2.put("bookCount",lotteryPlan2WithBLOBs.getBookCount()==null?0:lotteryPlan2WithBLOBs.getBookCount());
            double bonus;
            if (member2.getType()==1) {
                if (lotteryPlan2WithBLOBs.getIsSuperMan() == 1) {
                    bonus = byPlanNo.getPosttaxPrize()*member2.getMultiple() + (byPlanNo.getSumGold() == null ? 0 : byPlanNo.getSumGold());
                } else {
                    bonus = byPlanNo.getPosttaxPrize()*member2.getMultiple() - (byPlanNo.getGold() == null ? 0 : byPlanNo.getGold()*member2.getMultiple());
                }
            }else{
                if (lotteryPlan2WithBLOBs.getIsSuperMan() == 1) {
                    bonus = byPlanNo.getPosttaxPrize() + (byPlanNo.getSumGold() == null ? 0 : byPlanNo.getSumGold());
                } else {
                    bonus = byPlanNo.getPosttaxPrize() - (byPlanNo.getGold() == null ? 0 : byPlanNo.getGold());
                }
            }
            bonus += (lotteryPlan2WithBLOBs.getAddPrize()==null?0:lotteryPlan2WithBLOBs.getAddPrize());
            map2.put("bonus",bonus);
            //查询晒单点赞详情

            Integer id = planShow2.getId();
            String sid = id+"";
            Boolean exists = jedis.exists(sid); //判断这个集合是否已经存在
            Boolean like = false;
            if(!exists){
                map2.put("like",like);
                map2.put("sum",0);
            }else{  //集合存在
                long scard = jedis.scard(sid);
                if(account==null){  //未登录
                    map2.put("like",like);
                    map2.put("sum",scard);
                }else{  //登录
                    like = jedis.sismember(sid, account);
                    map2.put("like",like);
                    map2.put("sum",scard);
                }
            }
            mapList.add(map2);
        }
        jedis.close();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,mapList);
        map.put(Constants.TOTAL_COUNT,totalCount);
        return map;
    }
}
