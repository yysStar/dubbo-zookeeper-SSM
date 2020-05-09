package com.qiyun.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Draw {

    public static int draw (List< Double > giftProbList) {

        List<Double> sortRateList = new ArrayList<Double>();

        // 计算概率总和
        Double sumRate = 0D;
        for (Double prob : giftProbList) {
            sumRate += prob;
        }
        if (sumRate != 0) {
            double rate = 0D;   //概率所占比例
            for (Double prob : giftProbList) {
                rate += prob;
                // 构建一个比例区段组成的集合(避免概率和不为1)
                sortRateList.add(rate / sumRate);
            }
            // 随机生成一个随机数，并排序
            double random = Math.random();
            sortRateList.add(random);
            Collections.sort(sortRateList);
            // 返回该随机数在比例集合中的索引
            int i =  sortRateList.indexOf(random);
            return i;
        }
        return -1;
    }
}
