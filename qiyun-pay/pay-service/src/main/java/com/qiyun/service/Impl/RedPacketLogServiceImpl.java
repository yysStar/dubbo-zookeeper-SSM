package com.qiyun.service.Impl;

import com.github.pagehelper.PageHelper;
import com.qiyun.dto.GrabRedRacketDTO;
import com.qiyun.dto.MyTotalRedRacketDTO;
import com.qiyun.mapper2.RedPacketLogMapper;
import com.qiyun.mapper2.RedPacketLyMapper;
import com.qiyun.model2.RedPacketLog;
import com.qiyun.model2.RedPacketLy;
import com.qiyun.model2.RedPacketLyExample;
import com.qiyun.service.RedPacketLogService;
import com.qiyun.util.Constants;
import com.qiyun.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("redPacketLogService")
public class RedPacketLogServiceImpl implements RedPacketLogService {
    @Resource
    private RedPacketLogMapper redPacketLogMapper;

    @Autowired
    private RedPacketLyMapper redPacketLyMapper;

    public RedPacketLog getByPacketId(int redpacketId, String account) {
        return redPacketLogMapper.selectByPacketId(redpacketId, account);
    }

    public int insertSelective(RedPacketLog record) {
        redPacketLogMapper.insertSelective(record);
        return record.getId();
    }

    public List<GrabRedRacketDTO> getAllList(int offset, int pageSize) {
        PageHelper.startPage(offset, pageSize);
        return redPacketLogMapper.selectAll();
    }

    public List<GrabRedRacketDTO> getMyList(String account, int offset, int pageSize) {
        PageHelper.startPage(offset, pageSize);
        return redPacketLogMapper.selectMyList(account);
    }

    public MyTotalRedRacketDTO getTotalMoney(String account) {
        return redPacketLogMapper.selectTotalMoney(account);
    }

    public String getLyById(int id) {
        return redPacketLyMapper.getLyById(id);
    }

    public Map<String, Object> lyRedPackage(String id, String account, String content) {
        Map<String,Object> map = new HashMap<String, Object>();
        RedPacketLog redPacketLog = redPacketLogMapper.selectByPrimaryKey(StringUtil.String2Integer(id));
        if(redPacketLog == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_626);
            map.put(Constants.MSG, Constants.ERROR_MSG_626);
            return map;
        }
        String account1 = redPacketLog.getAccount();
        if(!account1.equals(account)){
            map.put(Constants.CODE, Constants.ERROR_CODE_635);
            map.put(Constants.MSG, Constants.ERROR_MSG_635);
            return map;
        }
        RedPacketLyExample redPacketLyExample = new RedPacketLyExample();
        redPacketLyExample.createCriteria().andLogIdEqualTo(StringUtil.String2Integer(id));
        List<RedPacketLy> redPacketLIES = redPacketLyMapper.selectByExample(redPacketLyExample);
        if(redPacketLIES.size()>0){
            map.put(Constants.CODE, Constants.ERROR_CODE_636);
            map.put(Constants.MSG, Constants.ERROR_MSG_636);
            return map;
        }
        RedPacketLy redPacketLy = RedPacketLy.builder().logId(StringUtil.String2Integer(id)).content(content).lyTime(new Date()).build();
        int insert = redPacketLyMapper.insert(redPacketLy);
        if(insert == 1){
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        }else {
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "红包留言失败，请联系客服");
            return map;
        }
    }
}
