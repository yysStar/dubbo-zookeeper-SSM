package com.qiyun.buildTerm;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryTerm2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FbSfcTermBuilder extends AbstractLotteryTermBuider {

    public List<LotteryTerm2> build(String oldTerm, Date oldOpenDateTime, int buildCount) {
        List<LotteryTerm2> retList = new ArrayList<LotteryTerm2>();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -5);

        oldTerm = "" + (buildCount);
        Date startDateTime = calendar.getTime();
        Date endDateTime = calendar.getTime();
        Date terminalEndDateTime = calendar.getTime();
        Date openDateTime = calendar.getTime();

        LotteryTerm2 lotteryTerm = createLotteryTerm(LotteryType.SFC,oldTerm,startDateTime,endDateTime,terminalEndDateTime,openDateTime);
        retList.add(lotteryTerm);

        return retList;
    }}
