package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.qiyun.dto.MemberDTO;
import com.qiyun.mapper2.MasterMapper;
import com.qiyun.mapper2.MemberMasterMappingMapper;
import com.qiyun.model2.MemberMasterMapping;
import com.qiyun.dto.Member2DTO;
import com.qiyun.mapper2.MasterMapper;
import com.qiyun.service.MasterService;
import com.qiyun.util.Constants;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("masterService")
public class MasterServiceImpl implements MasterService {
    @Resource
    private MemberMasterMappingMapper memberMasterMappingMapper;
    @Resource
    private MasterMapper masterMapper;


    public Map<String, Object> getSgMatch(String date) {
        //处理日期

        //用日期查询直播表已结束的比赛
        return null;
    }

    public List<MemberDTO> Search(String keywords ,int offset, int pageSize) {
        PageHelper.startPage(offset, pageSize);
        return memberMasterMappingMapper.selectSearchList(keywords);
    }

    public List<MemberDTO> getMasterList(int offset, int pageSize) {
        PageHelper.startPage(offset, pageSize);
        return memberMasterMappingMapper.selectMasterList();
    }

    public List<MemberDTO> getHighGradeList(int offset, int pageSize) {
        PageHelper.startPage(offset, pageSize);
        return memberMasterMappingMapper.selectHighGradeList();
	}

    public Map<String, Object> findIndexInfo(Member2DTO member2DTO) {
        Map<String, Object> map = new HashMap<String, Object>();
        //查询云朵数量
        String num = masterMapper.findClouds(member2DTO);

        if (num==null){
            num="0";
        }
        map.put("cloudsNum", num);
        //查看这个会员是否是名人或者优质用户
        Map celebrityMap = masterMapper.findIsCelebrity(member2DTO);
        //如果不为空进行内容判断
        if (celebrityMap!=null&&celebrityMap.size() > 0) {
            if ((Boolean)celebrityMap.get("is_master")){
                map.put("IsCelebrity", 1);
            }else if((Boolean) celebrityMap.get("is_highgrade")){
                map.put("IsCelebrity", 1);
            } else {
                map.put("IsCelebrity", 0);
            }

        }
        //如果为空则是普通用户
        else {
            map.put("IsCelebrity",0);
        }
        return map;
    }

    public Map<String, Object> celebrityBeginTask(Member2DTO member2DTO) {
        Map resultMap = new HashMap();
        //判断当前时间是否大于周一的六点 （改为本周发布本周的任务）
        //获取当前时间
        try {
        Date start_time =null;
        Date end_time =null;
        Date currDate = new Date();
        //获取每周一的时间
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        //设置为周一的六点
//        cal.set(Calendar.HOUR_OF_DAY, 18);
        //改为本周一0点
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
//        Date time = cal.getTime();
        start_time = cal.getTime();
        cal.setTime(start_time);
        cal.add(Calendar.DATE, 7);
        end_time = cal.getTime();

        Map map = new HashMap();
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
//        //判断是否重复发布任务
//        //获取任务发布的最大时间
//        //获取 下下周一
//        cal.setTime(time);
//        cal.add(Calendar.DATE, 7);
//        cal.set(Calendar.HOUR_OF_DAY, 0);
//        cal.set(Calendar.MINUTE, 0);
//        cal.set(Calendar.SECOND, 0);
//        start_time = cal.getTime();
//            cal.setTime(start_time);
//            cal.add(Calendar.DATE, 7);
//            end_time = cal.getTime();
//        if (currDate.getTime()> time.getTime()) {
//            System.out.println("开始下周任务");
//
//            //获取下周一时间
//            cal.setTime(time);
//            cal.add(Calendar.DATE, 7);
//            cal.set(Calendar.HOUR_OF_DAY, 0);
//            cal.set(Calendar.MINUTE, 0);
//            cal.set(Calendar.SECOND, 0);
//            start_time = cal.getTime();
//            //获取下下周时间
//            cal.setTime(start_time);
//            cal.add(Calendar.DATE, 7);
//            end_time = cal.getTime();
//
//        }
//        //小于六点发布本周任务
//        else {
//            //获取本周一时间
//            System.out.println("开始本周任务");
//            cal.setTime(time);
//            cal.set(Calendar.HOUR_OF_DAY, 0);
//            cal.set(Calendar.MINUTE, 0);
//            cal.set(Calendar.SECOND, 0);
//            start_time = cal.getTime();
//            //下周一时间
//            cal.setTime(start_time);
//
//            cal.add(Calendar.DATE, 7);
//            end_time = cal.getTime();
//
//        }
        map.put("start_time",start_time );
        map.put("end_time",end_time );
        map.put("create_date",new Date());
        map.put("account",member2DTO.getAccount());

        //存入数据库
        //查询上期期数
       int num =  masterMapper.getPeriodsNnum(map);
       map.put("periods_num",num+1);
            Date date = masterMapper.getMaxTime(member2DTO);
            if (date!=null) {
                System.out.println(sim.format(end_time));
                System.out.println(sim.format(date));
//                if (end_time.getTime()<=date.getTime()) {
                if ((end_time.getTime() - 10000) <=date.getTime()||date.getTime()>=(start_time.getTime()-10000)) {
                    Map resMap = new HashMap();
                    resMap.put(Constants.CODE, Constants.ERROR_CODE_10);
                    resMap.put(Constants.MSG, "不能重复发布任务");
                    return resMap;
                }
            }
        masterMapper.celebrityBeginTask(map);
        }catch (Exception ex){
            ex.printStackTrace();
            resultMap.put(Constants.CODE,"500");
            resultMap.put(Constants.MSG,"服务器内部错误");
        }
        return resultMap;
    }

}
