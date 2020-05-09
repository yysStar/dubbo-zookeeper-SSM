package com.qiyun.buildTerm;

import com.qiyun.commonModel.LotteryTerm;
import com.qiyun.model2.LotteryTerm2;

import java.util.Date;
import java.util.List;

public interface LotteryTermBuider {

    public List<LotteryTerm2> build(String oldTerm, Date oldOpenDateTime, int buildCount);

}

