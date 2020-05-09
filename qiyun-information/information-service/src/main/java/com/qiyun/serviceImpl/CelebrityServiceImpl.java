package com.qiyun.serviceImpl;

import com.qiyun.common.Result;
import com.qiyun.mapper2.Member2Mapper;
import com.qiyun.model2.Member2;
import com.qiyun.service.CelebrityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("CelebrityService")
public class CelebrityServiceImpl  implements CelebrityService {
    private static Logger logger = LoggerFactory.getLogger(CelebrityServiceImpl.class);

    @Resource
    private Member2Mapper member2Mapper;

    public Result getMemberInfoForCelebrity() {
        try {
            List<Member2> memberList = member2Mapper.getMemberInfoForCelebrity();
            Result result = new Result();
            result.setSuccess(true);
            result.setData(memberList);
            return result;
        } catch (Exception e) {
            logger.error("获取超级大神信息出错",e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("获取超级大神信息出错");
            return result;
        }
    }
}
