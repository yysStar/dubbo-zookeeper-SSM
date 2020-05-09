package com.qiyun.service;

import com.qiyun.model2.Commision2;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommisionService {
    void insert(Commision2 commision2);

    List<Commision2> getByPlanNo(Integer planNo);
}
