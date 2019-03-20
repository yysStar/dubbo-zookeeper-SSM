package com.qiyun.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class PayUtils {


    public static String getPayId(){
        SimpleDateFormat dateFm = new SimpleDateFormat("yyyyMMddHHmmss"); //格式化当前系统日期
        String orderid = dateFm.format(new Date());
        for(int i=0;i<6;i++) {
            orderid += new Random().nextInt(10);
        }
        return orderid;
    }
}
