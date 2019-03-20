package com.qiyun.service.impl;

import com.qiyun.common.Result;
import com.qiyun.mapper2.AdminUser2Mapper;
import com.qiyun.model2.AdminUser2;
import com.qiyun.model2.AdminUser2Query;
import com.qiyun.service.AdminUserService;
import com.qiyun.util.MD5;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUser2Mapper adminUser2Mapper;

    public Result adminLogin(String username, String password) {
        Result result = new Result();
        AdminUser2Query adminUser2Query = new AdminUser2Query();
        AdminUser2Query.Criteria criteria = adminUser2Query.createCriteria();
        criteria.andAccountEqualTo(username);
        List<AdminUser2> adminUser2s = adminUser2Mapper.selectByExample(adminUser2Query);
        if (adminUser2s==null || adminUser2s.size()<=0){
            result.setSuccess(false);
            result.setMsg("用户名或密码错误");
            return result;
        }
        AdminUser2 adminUser2 = adminUser2s.get(0);
        if (MD5.encode(password).equals(adminUser2.getPassword())){
            result.setSuccess(true);
            result.setData(adminUser2);
            return result;
        }else{
            result.setSuccess(false);
            result.setMsg("用户名或密码错误");
            return result;
        }
    }
}
