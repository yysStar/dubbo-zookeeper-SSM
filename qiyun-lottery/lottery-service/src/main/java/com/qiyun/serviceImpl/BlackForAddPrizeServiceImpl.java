package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.mapper2.BlackForAddPrize2Mapper;
import com.qiyun.mapper2.Member2Mapper;
import com.qiyun.model2.BlackForAddPrize2;
import com.qiyun.model2.BlackForAddPrize2Query;
import com.qiyun.model2.Member2;
import com.qiyun.model2.Member2Query;
import com.qiyun.service.BlackForAddPrizeService;
import com.qiyun.util.Constants;
import com.qiyun.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("blackForAddPrizeService")
public class BlackForAddPrizeServiceImpl implements BlackForAddPrizeService {

    @Resource
    private Member2Mapper member2Mapper;

    @Resource
    private BlackForAddPrize2Mapper blackForAddPrize2Mapper;

    public Map<String,Object> setAddPrizeBlackOrWhite(Integer[] ids, Integer type) {
        Map<String,Object> map = new HashMap<String,Object>();
        if (ids==null || ids.length<=0) {
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        }
        Integer status = null;
        for (Integer memberId : ids) {
            if (type==1 || type==2) {
                status = 1;
            }else if (type==3 || type==4) {
                status = 0;
            }
            //代理黑名单/白名单
            Member2 member2 = member2Mapper.selectByPrimaryKey(memberId);
            if (member2==null){
                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                return map;
            }
            setBlackForAddPrize(member2,status);
            //代理底下会员黑名单/白名单
            if (type==2 || type==4){
                Member2Query member2Query = new Member2Query();
                Member2Query.Criteria criteria = member2Query.createCriteria();
                criteria.andSourceIdEqualTo(memberId);
                List<Member2> member2s = member2Mapper.selectByExample(member2Query);
                if (member2s!=null && member2s.size()>0){
                    for (Member2 member : member2s) {
                        setBlackForAddPrize(member,status);
                    }
                }
            }
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String, Object> getAddPrizeBlack(String account, int page, int pageSize) {
        Map<String,Object> reqMap = new HashMap<String,Object>();

        if (!StringUtils.isNullOrBlank(account)){
            reqMap.put("account",account);
        }
        PageHelper.startPage(page,pageSize);
        List<Map> list = blackForAddPrize2Mapper.getAddPrizeBlack(reqMap);
        PageInfo<Map> pageInfo = new PageInfo<Map>(list);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,pageInfo);
        return map;
    }

    public void setBlackForAddPrize(Member2 member2,int status){
        BlackForAddPrize2 blackForAddPrize2 = blackForAddPrize2Mapper.selectByPrimaryKey(member2.getId());
        if (blackForAddPrize2==null){
            blackForAddPrize2 = new BlackForAddPrize2();
            blackForAddPrize2.setMemberId(member2.getId());
            blackForAddPrize2.setAccount(member2.getAccount());
            blackForAddPrize2.setStatus(status);
            blackForAddPrize2Mapper.insertSelective(blackForAddPrize2);
        }else {
            if (blackForAddPrize2.getStatus()!=status){
                blackForAddPrize2.setStatus(status);
                blackForAddPrize2Mapper.updateByPrimaryKeySelective(blackForAddPrize2);
            }
        }
    }
}
