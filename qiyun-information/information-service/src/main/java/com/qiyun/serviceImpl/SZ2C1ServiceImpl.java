package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.qiyun.common.Result;
import com.qiyun.dto.SZ2C12DTO;
import com.qiyun.mapper2.SZ2C12Mapper;
import com.qiyun.model2.SZ2C12;
import com.qiyun.model2.SZ2C12Query;
import com.qiyun.service.SZ2C1Service;
import com.qiyun.util.Constants;
import com.qiyun.util.CopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SZ2C1ServiceImpl implements SZ2C1Service {

    private static Logger logger = LoggerFactory.getLogger(SZ2C1ServiceImpl.class);

    @Autowired
    private SZ2C12Mapper sz2C12Mapper;
//    @Resource
//    private SZ2C12Mapper sz2C1Mapper;


    public Map<String, Object> createSZ2C11(String matchId1, String homeTeam1, String guestTeam1, String recommend1, String matchId2, String homeTeam2, String guestTeam2, String recommend2, Integer multiple, Double amount, String bonus, String author) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(matchId1.equals("")){
            matchId1=null;
        }
        if(homeTeam1.equals("")){
            homeTeam1=null;
        }
        if(guestTeam1.equals("")){
            guestTeam1=null;
        }
        if(recommend1.equals("")){
            recommend1=null;
        }
        if(matchId2.equals("")){
            matchId2=null;
        }
        if(homeTeam2.equals("")){
            homeTeam2=null;
        }
        if(guestTeam2.equals("")){
            guestTeam2=null;
        }
        if(recommend2.equals("")){
            recommend2=null;
        }
        if(multiple==null){
            multiple=0;
        }
        if(amount==null){
            amount=(double)0;
        }
        if(bonus.equals("")){
            bonus=null;
        }
        if(author.equals("")){
            author=null;
        }
        SZ2C12 sz2C12 = SZ2C12.builder().matchId1(matchId1).matchId2(matchId2).homeTeam1(homeTeam1).homeTeam2(homeTeam2)
                .guestTeam1(guestTeam1).guestTeam2(guestTeam2).recommend1(recommend1).recommend2(recommend2).multiple(multiple)
                .amount(amount).bonus(bonus).result(0).author(author).number(1).createDate(new Date()).status(1).build();
        int insert = sz2C12Mapper.insert(sz2C12);
        if(insert==1){
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        }else {
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "新增实战二串一(一)失败");
            return map;
        }
    }

    public Map<String, Object> createSZ2C12(String matchId1, String homeTeam1, String guestTeam1, String recommend1, String matchId2, String homeTeam2, String guestTeam2, String recommend2, Integer multiple, Double amount, String bonus, String author) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(matchId1.equals("")){
            matchId1=null;
        }
        if(homeTeam1.equals("")){
            homeTeam1=null;
        }
        if(guestTeam1.equals("")){
            guestTeam1=null;
        }
        if(recommend1.equals("")){
            recommend1=null;
        }
        if(matchId2.equals("")){
            matchId2=null;
        }
        if(homeTeam2.equals("")){
            homeTeam2=null;
        }
        if(guestTeam2.equals("")){
            guestTeam2=null;
        }
        if(recommend2.equals("")){
            recommend2=null;
        }
        if(multiple==null){
            multiple=0;
        }
        if(amount==null){
            amount=(double)0;
        }
        if(bonus.equals("")){
            bonus=null;
        }
        if(author.equals("")){
            author=null;
        }
        SZ2C12 sz2C12 = SZ2C12.builder().matchId1(matchId1).matchId2(matchId2).homeTeam1(homeTeam1).homeTeam2(homeTeam2)
                .guestTeam1(guestTeam1).guestTeam2(guestTeam2).recommend1(recommend1).recommend2(recommend2).multiple(multiple)
                .amount(amount).bonus(bonus).result(0).author(author).number(2).createDate(new Date()).status(1).build();
        int insert = sz2C12Mapper.insert(sz2C12);
        if(insert==1){
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        }else {
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "新增实战二串一(二)失败");
            return map;
        }
    }

    public Map<String, Object> shSZ2C1(String sid) {
        Map<String, Object> map = new HashMap<String, Object>();
        String[] split = sid.split(",");
        int i = 0 ;
        for (String str:split) {
            int id = Integer.parseInt(str);
            SZ2C12 sz2C12 = new SZ2C12();
            sz2C12.setId(id);
            sz2C12.setStatus(2);
            int i1 = sz2C12Mapper.updateByPrimaryKeySelective(sz2C12);
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

    public Map<String, Object> bhSZ2C1(String sid) {
        Map<String, Object> map = new HashMap<String, Object>();
        String[] split = sid.split(",");
        int i = 0 ;
        for (String str:split) {
            int id = Integer.parseInt(str);
            SZ2C12 sz2C12 = new SZ2C12();
            sz2C12.setId(id);
            sz2C12.setStatus(3);
            int i1 = sz2C12Mapper.updateByPrimaryKeySelective(sz2C12);
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

    public Result getSZ2C1ByNumber(int number) {
        try {
            Result result = new Result();
            SZ2C12Query sz2C12Query = new SZ2C12Query();
            SZ2C12Query.Criteria criteria = sz2C12Query.createCriteria();
            criteria.andNumberEqualTo(number);
            sz2C12Query.setOrderByClause("create_date desc");
            PageHelper.startPage(1,1);
            List<SZ2C12> sz2C12s = sz2C12Mapper.selectByExample(sz2C12Query);
            if (sz2C12s==null || sz2C12s.size()<=0){
                result.setSuccess(true);
                return result;
            }
            SZ2C12DTO sz2C12DTO = new SZ2C12DTO();
            CopyUtils.Copy(sz2C12DTO,sz2C12s.get(0),true);
            result.setData(sz2C12DTO);
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            logger.error("获取实战2串1出错",e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("获取实战2串1出错");
            return result;
        }
    }
}
