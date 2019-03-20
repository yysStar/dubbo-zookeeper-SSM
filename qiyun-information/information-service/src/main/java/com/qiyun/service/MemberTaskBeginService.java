package com.qiyun.service;

import com.qiyun.dto.MemberTaskBeginDTO;
import com.qiyun.model2.MemberTaskBegin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberTaskBeginService {
    MemberTaskBegin getNowTask(String account);

    int update(MemberTaskBegin memberTaskBegin);

    List<MemberTaskBeginDTO> getAll(String account, int offset, int pageSize);

    MemberTaskBegin getById(Integer taskId);

    MemberTaskBeginDTO getNowTaskAndPlan(String account);

    int  setFast(String phone,String account);

    String getPhone();
}
