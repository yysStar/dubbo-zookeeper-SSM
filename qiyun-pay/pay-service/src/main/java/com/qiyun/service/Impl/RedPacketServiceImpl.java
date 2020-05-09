package com.qiyun.service.Impl;

import com.github.pagehelper.PageHelper;
import com.qiyun.dto.MyTotalRedRacketDTO;
import com.qiyun.dto.PlanDTO;
import com.qiyun.dto.RedPacketDTO;
import com.qiyun.dto.RedPacketDetailsDTO;
import com.qiyun.httpUtil.RedisUtil;
import com.qiyun.mapper2.RedPacketMapper;
import com.qiyun.model2.RedPacket;
import com.qiyun.service.RedPacketService;
import com.qiyun.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("redPacketService")
public class RedPacketServiceImpl implements RedPacketService {
    @Resource
    RedPacketMapper redPacketMapper;

    public Map<String, Object> isRedPacket(String account) {
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            int New = redPacketMapper.getNew();
            if(New==0){
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put("isNew",0);
                return map;
            }
            Jedis jedis = RedisUtil.getJedis();
            Boolean exists = jedis.exists("newhongbao"); //判断这个集合是否存在
            if(exists){ //有新红包看过的人集合
//                Boolean end = jedis.sismember("newhongbao", "end");    //判断这个人是否看过新红包
                Boolean newhongbao = jedis.sismember("newhongbao", account);    //判断这个人是否看过新红包
                jedis.close();
                if(newhongbao){
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    map.put("isNew",0);
                    return map;
                }else{
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    map.put("isNew",1);
                    return map;
                }
            }else{  //没有新红包看过的人集合，说明没人看过
                jedis.close();
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put("isNew",1);
                return map;
            }
        }catch (Exception e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取新红包出错");
            return map;
        }
    }

    public int insertSelective(RedPacket redPacket) {
        redPacketMapper.insertSelective(redPacket);
        return redPacket.getId();
    }

    public List<RedPacketDTO> getAllList(int offset, int pageSize) {
        PageHelper.startPage(offset, pageSize);
        return redPacketMapper.selectAll();
    }

    public int updateByPrimaryKeySelective(RedPacket redPacket) {
        return redPacketMapper.updateByPrimaryKeySelective(redPacket);
    }

    public RedPacketDetailsDTO getDetails(int redPacketId) {
        return redPacketMapper.selectDetailsByPrimaryKey(redPacketId);
    }

    public List<RedPacketDTO> getMyList(String account, int offset, int pageSize) {
        PageHelper.startPage(offset, pageSize);
        return redPacketMapper.selectByAccount(account);
    }

    public MyTotalRedRacketDTO getTotalMoney(String account) {
        return redPacketMapper.selectTotalMoney(account);
    }

    public RedPacketDTO getNowByAccount(String account) {
        return redPacketMapper.selectNowByAccount(account);
    }

    public Map<String, Object> search(String account) {
        Map<String,Object> map = new HashMap<String, Object>();
        List<PlanDTO> planDTOS1 = redPacketMapper.selectPlayingPlan(account);
        List<PlanDTO> planDTOS2 = redPacketMapper.selectBingoPlan(account);
        if (planDTOS1==null||planDTOS1.size()==0){
            map.put("ing",0);
        }else{
            map.put("ing",planDTOS1);
        }
        if (planDTOS2==null||planDTOS2.size()==0){
            map.put("ing",0);
        }else{
            map.put("ing",planDTOS2);
        }
        return map;
    }

    public RedPacket getById(int id) {
        return redPacketMapper.selectByPrimaryKey(id);
    }

    public int getJump(int id) {
        return redPacketMapper.getJump(id);
    }

    public String getAccount(int id){
        return redPacketMapper.getAccount(id);
    }

    public Integer getFollow(String account){
        return redPacketMapper.getFollow(account);
    }

    public int getAmount(int planNo) {
        return redPacketMapper.getAmount(planNo);
    }

    public int getMultiple(int planNo) {
        return redPacketMapper.getMultiple(planNo);
    }

    public Integer getType(String account){
        return redPacketMapper.getType(account);
    }

    public Integer getCyMultiple(String account){
        return redPacketMapper.getCyMultiple(account);
    }

    public Integer getRed(String account){
        return redPacketMapper.getRed(account);
    }

    public String getUsername(String account){
        return redPacketMapper.getUsername(account);
    }

    public String getPICTURE(String account){
        return redPacketMapper.getPICTURE(account);
    }

    public int getCount(int redPacketId){
        return redPacketMapper.getCount(redPacketId);
    }
}
