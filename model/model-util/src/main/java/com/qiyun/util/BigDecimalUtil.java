package com.qiyun.util;

import java.math.BigDecimal;

public class BigDecimalUtil {

    private static int ROUND_HALF_UP = BigDecimal.ROUND_HALF_UP;//四舍五入

    /**
     * 四舍五入，2位小数
     * @param value
     * @return
     */
    public static BigDecimal round(double value){
        BigDecimal bigDecimal = new BigDecimal(value);
        return bigDecimal.setScale(2, ROUND_HALF_UP);
    }
    /**
     * 提供精确的加法运算。
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static BigDecimal add(BigDecimal v1,BigDecimal v2){
        return round(v1.add(v2).doubleValue());
    }

    public static BigDecimal add(BigDecimal v1,int v2Int){
        BigDecimal v2 = new BigDecimal(v2Int);
        return round(v1.add(v2).doubleValue());
    }


    /**
     * 提供精确的乘法运算。
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }
}
