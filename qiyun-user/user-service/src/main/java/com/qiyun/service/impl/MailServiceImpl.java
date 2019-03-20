package com.qiyun.service.impl;

import com.qiyun.common.Result;
import com.qiyun.dto.Mail2DTO;
import com.qiyun.dto.Member2DTO;
import com.qiyun.httpUtil.RedisUtil;
import com.qiyun.mapper2.Mail2Mapper;
import com.qiyun.model2.Mail2;
import com.qiyun.model2.Mail2Query;
import com.qiyun.service.MailService;
import com.qiyun.util.CopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MailServiceImpl implements MailService {

    private static Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);


    @Resource
    private Mail2Mapper mail2Mapper;

    public Result getMail(Member2DTO member2DTO, int page, int pageSize) {
        Result result = new Result();
        Jedis jedis = RedisUtil.getJedis();
        try {
            String acc = member2DTO.getAccount();
            List<Mail2DTO> list = new ArrayList<Mail2DTO>();
            Mail2Query mail2Query = new Mail2Query();
            Mail2Query.Criteria criteria = mail2Query.createCriteria();
            criteria.andStatusEqualTo(1);
            mail2Query.setOrderByClause("create_date desc");
            List<Mail2> mail2s = mail2Mapper.selectByExampleWithBLOBs(mail2Query);
//            Boolean m1 = false;
//            Boolean m2 = false;
//            Boolean m3 = false;
            for (Mail2 mail2 : mail2s) {
                if (mail2.getType()==1) {
//                    m1 =true;
                    Mail2DTO mail2DTO = new Mail2DTO();
                    CopyUtils.Copy(mail2DTO, mail2, true);
                    list.add(mail2DTO);
                    Long newmail1 = jedis.sadd("newmail1", acc);
                }else if(mail2.getType()==2){
                    if (member2DTO.getIsWhitelist()==0){
//                        m2 = true;
                        Mail2DTO mail2DTO = new Mail2DTO();
                        CopyUtils.Copy(mail2DTO, mail2, true);
                        list.add(mail2DTO);
                        Long newmail2 = jedis.sadd("newmail2", acc);
                    }
                }else if(mail2.getType()==3){
                    String[] accounts = mail2.getTarget().split(",");
                    if (accounts!=null && accounts.length>0) {
                        for (String account : accounts) {
                            if (account.equals(member2DTO.getAccount())) {
//                                m3 = true;
                                Mail2DTO mail2DTO = new Mail2DTO();
                                CopyUtils.Copy(mail2DTO, mail2, true);
                                list.add(mail2DTO);
                                Long newmail3 = jedis.srem("newmail3", acc);
                            }
                        }
                    }
                }
            }
//            if(m1){
//                Long newmail1 = jedis.sadd("newmail1", acc);
//            }
//            if(m2){
//                Long newmail2 = jedis.sadd("newmail2", acc);
//            }
//            if(m3){
//                Long newmail3 = jedis.srem("newmail3", acc);
//            }
            jedis.close();
            List<Mail2DTO> list2 = new ArrayList<Mail2DTO>();
            for (int i = (page-1)*pageSize; i < (page-1)*pageSize+pageSize; i++) {
                if (i>list.size()-1){
                    break;
                }
                list2.add(list.get(i));
            }
            result.setSuccess(true);
            result.setData(list2);
            result.setTotalCount(list.size());
            return result;
        }catch (Exception e){
            jedis.close();
            logger.error("获取站内信出错",e);
            result.setSuccess(false);
            result.setMsg("获取站内信出错");
            return result;
        }
    }

}
