package com.qiyun.service;

import com.qiyun.model2.FocusMatchFb2;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface FocusMatchFbService {
    void insert(FocusMatchFb2 focusMatchFb2);

    Map<String,Object> updateFbFocusMatchStatus(Integer id);
}
