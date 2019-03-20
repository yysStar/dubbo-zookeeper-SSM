package com.qiyun.service;

import com.qiyun.model2.FocusMatchBb2;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface FocusMatchBbService {
    void insert(FocusMatchBb2 focusMatchBb2);

    Map<String,Object> updateBbFocusMatchStatus(Integer id);
}
