package com.qiyun.service;

import com.qiyun.model2.Celebrity2;

import java.util.List;

public interface CelebrityService {
    List<Celebrity2> getCeleBrity();

    void delete();

    void add(Celebrity2 celebrity2);
}
