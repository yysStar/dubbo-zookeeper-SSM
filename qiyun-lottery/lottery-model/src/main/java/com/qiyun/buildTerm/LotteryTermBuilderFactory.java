package com.qiyun.buildTerm;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class LotteryTermBuilderFactory {

    private static HashMap<String, LotteryTermBuider> builderMap;

    public static List getNextTermList(int lotteryType, String oldTerm, Date oldOpenDateTime, int buildCount) {
        LotteryTermBuider builder = builderMap.get(lotteryType+"");
        if (builder != null) {
            return builder.build(oldTerm, oldOpenDateTime, buildCount);
        } else {
            return new ArrayList();
        }
    }

    /**
     * @param builderMap
     */
    public void setBuilderMap(HashMap<String, LotteryTermBuider> builderMap) {
        this.builderMap = builderMap;
    }

}
