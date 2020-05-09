package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.qiyun.dto.DayOneDan2DTO;
//import com.qiyun.httpUtil.RedisUtil;
import com.qiyun.httpUtil.RedisUtil;
import com.qiyun.mapper2.DayOneDan2Mapper;
import com.qiyun.mapper2.SZ2C12Mapper;
import com.qiyun.model2.DayOneDan2;
import com.qiyun.model2.DayOneDan2Query;
import com.qiyun.model2.SZ2C12;
import com.qiyun.service.DayOneDanService;
import com.qiyun.util.Constants;
import com.qiyun.util.CopyUtils;
import com.qiyun.util.JedisAdapter;
import com.qiyun.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class  DayOneDanServiceImpl implements DayOneDanService {

    private static Logger logger = LoggerFactory.getLogger(DayOneDanServiceImpl.class);


//    @Resource
//    private DayOneDanMapper dayOneDanMapper;

    @Autowired
    private DayOneDan2Mapper dayOneDan2Mapper;

    @Autowired
    private SZ2C12Mapper sz2C12Mapper;

    @Autowired
    private JedisAdapter jedisAdapter;

    public Map<String, Object> createDayOneDan1(String playType, String matchId, String homeTeam, String guestTeam, String recommend, Double sp, String analyze, String author){
        Map<String, Object> map = new HashMap<String, Object>();
        if(playType.equals("")){
            playType=null;
        }
        if(matchId.equals("")){
            matchId=null;
        }
        if(homeTeam.equals("")){
            homeTeam=null;
        }
        if(guestTeam.equals("")){
            guestTeam=null;
        }
        if(recommend.equals("")){
            recommend=null;
        }
        if(sp.equals("")||sp==null){
            sp=0.0;
        }
        if(analyze.equals("")){
            analyze=null;
        }
        if(author.equals("")){
            author=null;
        }
        DayOneDan2 dayOneDan2 = DayOneDan2.builder().playType(playType).matchId(matchId).homeTeam(homeTeam)
                .guestTeam(guestTeam).recommend(recommend).sp(sp).analyze(analyze).author(author).createDate(new Date())
                .result(0).number(1).status(1).build();
        int insert = dayOneDan2Mapper.insert(dayOneDan2);
        if(insert == 1){
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        }else {
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "新增每日俩单(一)失败");
            return map;
        }
    }

    public Map<String, Object> createDayOneDan2(String playType, String matchId, String homeTeam, String guestTeam, String recommend, Double sp, String analyze, String author) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(playType.equals("")){
            playType=null;
        }
        if(matchId.equals("")){
            matchId=null;
        }
        if(homeTeam.equals("")){
            homeTeam=null;
        }
        if(guestTeam.equals("")){
            guestTeam=null;
        }
        if(recommend.equals("")){
            recommend=null;
        }
        if(sp.equals("")||sp==null){
            sp=0.0;
        }
        if(analyze.equals("")){
            analyze=null;
        }
        if(author.equals("")){
            author=null;
        }
        DayOneDan2 dayOneDan2 = DayOneDan2.builder().playType(playType).matchId(matchId).homeTeam(homeTeam)
                .guestTeam(guestTeam).recommend(recommend).sp(sp).analyze(analyze).author(author).createDate(new Date())
                .result(0).number(2).status(1).build();
        int insert = dayOneDan2Mapper.insert(dayOneDan2);
        if(insert == 1){
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        }else {
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "新增每日俩单(二)失败");
            return map;
        }
    }

    public Map<String, Object> shDOD(String sid) {
        Map<String, Object> map = new HashMap<String, Object>();
        String[] split = sid.split(",");
        int i = 0 ;
        for (String str:split) {
            int id = Integer.parseInt(str);
            DayOneDan2 dayOneDan2 = new DayOneDan2();
            dayOneDan2.setId(id);
            dayOneDan2.setStatus(2);
            int i1 = dayOneDan2Mapper.updateByPrimaryKeySelective(dayOneDan2);
            i = i + i1;
        }
        if(i>=1){
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        }else {
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "审核失败，请联系技术人员");
            return map;
        }
    }

    public Map<String, Object> bhDOD(String sid) {
        Map<String, Object> map = new HashMap<String, Object>();
        String[] split = sid.split(",");
        int i = 0 ;
        for (String str:split) {
            int id = Integer.parseInt(str);
            DayOneDan2 dayOneDan2 = new DayOneDan2();
            dayOneDan2.setId(id);
            dayOneDan2.setStatus(3);
            int i1 = dayOneDan2Mapper.updateByPrimaryKeySelective(dayOneDan2);
            i = i + i1;
        }
        if(i>=1){
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        }else {
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "审核失败，请联系技术人员");
            return map;
        }
    }

    public Map<String, Object> bhDOD(int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        DayOneDan2 dayOneDan2 = new DayOneDan2();
        dayOneDan2.setId(id);
        dayOneDan2.setStatus(3);
        int i = dayOneDan2Mapper.updateByPrimaryKeySelective(dayOneDan2);
        if(i==1){
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        }else {
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "审核失败，请联系技术人员");
            return map;
        }
    }

    public Map<String, Object> getDayOneDanByNumber(int number) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            switch (number){
                case 0:
                    DayOneDan2 dayOneDan1 = dayOneDan2Mapper.selectOne();
                    DayOneDan2 dayOneDan2 = dayOneDan2Mapper.selectTwo();
                    DayOneDan2DTO dayOneDanDTO1 = new DayOneDan2DTO();
                    DayOneDan2DTO dayOneDanDTO2 = new DayOneDan2DTO();
                    CopyUtils.Copy(dayOneDanDTO1,dayOneDan1,true);
                    CopyUtils.Copy(dayOneDanDTO2,dayOneDan2,true);
                    map.put("ONE", dayOneDanDTO1);
                    map.put("TWO", dayOneDanDTO2);
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    return map;
                case 1:
                    DayOneDan2 dayOneDan3 = dayOneDan2Mapper.selectOne();
                    DayOneDan2DTO dayOneDanDTO3 = new DayOneDan2DTO();
                    CopyUtils.Copy(dayOneDanDTO3,dayOneDan3,true);
                    map.put("DATA", dayOneDanDTO3);
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    return map;
                case 2:
                    DayOneDan2 dayOneDan4 = dayOneDan2Mapper.selectTwo();
                    DayOneDan2DTO dayOneDanDTO4 = new DayOneDan2DTO();
                    CopyUtils.Copy(dayOneDanDTO4,dayOneDan4,true);
                    map.put("DATA", dayOneDanDTO4);
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    return map;
                default:
                    map.put(Constants.CODE, Constants.ERROR_CODE_626);
                    map.put(Constants.MSG, Constants.ERROR_MSG_626);
                    return map;
            }

        }catch (Exception e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取每日两单出错");
            return map;
        }
    }

    /**
     * 点赞
     * @param hostHolder
     * @param account
     * @return
     */
    public Map<String, Object> like(String hostHolder, String account) {
        Map<String, Object> map = new HashMap<String, Object>();
        Jedis jedis = RedisUtil.getJedis();
//        Boolean exists = jedis.exists(hostHolder); //判断这个集合是否存在
        long sadd = jedis.sadd(hostHolder, account);
//        if(!exists){    //如果集合是第一次创建
            jedis.expire(hostHolder,604800);  //设置这个集合的过期时间为一周
//        }
//        long sadd = jedisAdapter.sadd(hostHolder, account);
        jedis.close();
        if(sadd==1){
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
        }
//        else if(sadd==0){
//            map.put(Constants.CODE, Constants.ERROR_CODE_619);
//            map.put(Constants.MSG, "不可重复点赞");
//        }
        else{
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "点赞错误");
        }
        return map;
    }

    /**
     * 取消点赞
     * @param hostHolder
     * @param account
     * @return
     */
    public Map<String, Object> disLike(String hostHolder, String account) {
        Map<String, Object> map = new HashMap<String, Object>();
        Jedis jedis = RedisUtil.getJedis();
//        long srem = jedisAdapter.srem(hostHolder, account);
        long srem = jedis.srem(hostHolder, account);
        jedis.close();
        if(srem==1){
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
        } else{
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "取消点赞错误");
        }
        return map;
    }

    /**
     * 获取点赞状态和总数
     * @param hostHolder
     * @param account
     * @return
     */
    public Map<String, Object> getIsLike(String hostHolder, String account) {
        Map<String, Object> map = new HashMap<String, Object>();
        Jedis jedis = RedisUtil.getJedis();
        try {
            boolean sismember =false;
            Boolean exists = jedis.exists(hostHolder); //判断这个集合是否已经存在
            if(!exists){
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put("is",sismember);
                map.put("sum",0);
                return map;
            }
            if(!StringUtils.isNullOrBlank(account)){ //如果登录
                //是否已经点赞，true为已点赞，false为未点赞
//                sismember = jedisAdapter.sismember(hostHolder, account);
                sismember = jedis.sismember(hostHolder, account);
            }
            //点赞的总数
//            long scard = jedisAdapter.scard(hostHolder);
            long scard = jedis.scard(hostHolder);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put("is",sismember);
            map.put("sum",scard);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取点赞状态和总数错误");
            return map;
        }finally {
            jedis.close();
        }
    }
}
