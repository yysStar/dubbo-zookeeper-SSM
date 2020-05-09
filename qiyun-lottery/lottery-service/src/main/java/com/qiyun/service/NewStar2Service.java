package com.qiyun.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface NewStar2Service {
    Map<String,Object> addNewStar(String[] accounts);

    Map<String,Object> getNewStar(int dan);
}
