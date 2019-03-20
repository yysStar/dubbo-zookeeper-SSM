package com.qiyun.service.impl;

import com.qiyun.dto.SmsCode2DTO;
import com.qiyun.mapper2.SmsCode2Mapper;
import com.qiyun.model2.SmsCode2;
import com.qiyun.model2.SmsCode2Query;
import com.qiyun.service.SmsCodeService;
import com.qiyun.util.Constants;
import com.qiyun.util.CopyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SmsCodeServiceImpl implements SmsCodeService {

    @Resource
    private SmsCode2Mapper smsCode2Mapper;

    public Map<String, Object> saveSmsCode(String mobile, String sRand) {
        SmsCode2 smsCode2 = new SmsCode2();
        smsCode2.setMobile(mobile);
        smsCode2.setCode(sRand);
        smsCode2.setLastSendTime(new Date());
        smsCode2Mapper.insertSelective(smsCode2);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> getSmsCode(String mobile) {
        Map<String,Object> map = new HashMap<String,Object>();
        SmsCode2Query smsCode2Query = new SmsCode2Query();
        SmsCode2Query.Criteria criteria = smsCode2Query.createCriteria();
        criteria.andMobileEqualTo(mobile);
        smsCode2Query.setOrderByClause("last_send_time desc");
        List<SmsCode2> smsCode2s = smsCode2Mapper.selectByExample(smsCode2Query);
        if (smsCode2s==null || smsCode2s.size()<=0){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,Constants.ERROR_MSG_400);
            return map;
        }
        SmsCode2DTO smsCode2DTO = new SmsCode2DTO();
        CopyUtils.Copy(smsCode2DTO,smsCode2s.get(0),true);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,smsCode2DTO);

        return map;
    }
}
