package com.qiyun.util;

import com.qiyun.common.GoldCard2;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SendGoldCardUtils {

    public static List<GoldCard2> sendGoldCard(Double amount,String account) throws ParseException {

        List<GoldCard2> list = new ArrayList<GoldCard2>();
        Date date = new Date();
        Calendar ca = Calendar.getInstance();
        SimpleDateFormat sfm = new SimpleDateFormat("yyyy-MM-dd");
        String format = sfm.format(date);
        Date parse = sfm.parse(format);
        ca.setTime(parse);
        ca.add(Calendar.DATE,7);
        //1000~4999 赠送36元（28元+8元）
        if (1000<=amount&&4999>=amount){
            GoldCard2 goldCard21 = new GoldCard2(account,"8元彩金卡", BigDecimal.valueOf(1000),1,BigDecimal.valueOf(8),date,ca.getTime(),0,null,"");
            GoldCard2 goldCard22 = new GoldCard2(account,"28元彩金卡" ,BigDecimal.valueOf(3000),1,BigDecimal.valueOf(28),date,ca.getTime(),0,null,"");
            list.add(goldCard21);
            list.add(goldCard22);
        }
        if (5000<=amount&&9999>=amount){
            GoldCard2 goldCard21 = new GoldCard2(account,"68元彩金卡", BigDecimal.valueOf(6000),1,BigDecimal.valueOf(68),date,ca.getTime(),0,null,"");
            GoldCard2 goldCard22 = new GoldCard2(account,"28元彩金卡",BigDecimal.valueOf(3000),1,BigDecimal.valueOf(28),date,ca.getTime(),0,null,"");
            GoldCard2 goldCard23 = new GoldCard2(account,"28元彩金卡",BigDecimal.valueOf(3000),1,BigDecimal.valueOf(28),date,ca.getTime(),0,null,"");
            GoldCard2 goldCard24 = new GoldCard2(account,"8元彩金卡", BigDecimal.valueOf(1000),1,BigDecimal.valueOf(8),date,ca.getTime(),0,null,"");
            GoldCard2 goldCard25 = new GoldCard2(account,"8元彩金卡", BigDecimal.valueOf(1000),1,BigDecimal.valueOf(8),date,ca.getTime(),0,null,"");
            list.add(goldCard22);
            list.add(goldCard23);
            list.add(goldCard21);
            list.add(goldCard24);
            list.add(goldCard25);
        }
        if (10000<=amount&&19999>=amount){
            GoldCard2 goldCard21 = new GoldCard2(account,"68元彩金卡", BigDecimal.valueOf(6000),1,BigDecimal.valueOf(68),date,ca.getTime(),0,null,"");
            GoldCard2 goldCard22 = new GoldCard2(account,"68元彩金卡",BigDecimal.valueOf(6000),1,BigDecimal.valueOf(68),date,ca.getTime(),0,null,"");
            GoldCard2 goldCard23 = new GoldCard2(account,"28元彩金卡",BigDecimal.valueOf(3000),1,BigDecimal.valueOf(28),date,ca.getTime(),0,null,"");
            GoldCard2 goldCard24 = new GoldCard2(account,"28元彩金卡", BigDecimal.valueOf(3000),1,BigDecimal.valueOf(28),date,ca.getTime(),0,null,"");
            GoldCard2 goldCard25 = new GoldCard2(account,"128元彩金卡", BigDecimal.valueOf(10000),1,BigDecimal.valueOf(128),date,ca.getTime(),0,null,"");
            list.add(goldCard22);
            list.add(goldCard23);
            list.add(goldCard21);
            list.add(goldCard24);
            list.add(goldCard25);
        }
        if (20000<=amount&&49999>=amount){
            GoldCard2 goldCard21 = new GoldCard2(account,"68元彩金卡", BigDecimal.valueOf(6000),1,BigDecimal.valueOf(68),date,ca.getTime(),0,null,"");
            GoldCard2 goldCard22 = new GoldCard2(account,"68元彩金卡",BigDecimal.valueOf(6000),1,BigDecimal.valueOf(68),date,ca.getTime(),0,null,"");
            GoldCard2 goldCard23 = new GoldCard2(account,"288元彩金卡", BigDecimal.valueOf(20000),1,BigDecimal.valueOf(288),date,ca.getTime(),0,null,"");
            GoldCard2 goldCard25 = new GoldCard2(account,"128元彩金卡", BigDecimal.valueOf(10000),1,BigDecimal.valueOf(128),date,ca.getTime(),0,null,"");
            GoldCard2 goldCard24 = new GoldCard2(account,"128元彩金卡", BigDecimal.valueOf(10000),1,BigDecimal.valueOf(128),date,ca.getTime(),0,null,"");
            list.add(goldCard22);
            list.add(goldCard23);
            list.add(goldCard21);
            list.add(goldCard24);
            list.add(goldCard25);
        }

        if (amount>=50000){
            GoldCard2 goldCard21 = new GoldCard2(account,"888元彩金卡",BigDecimal.valueOf(50000),1,BigDecimal.valueOf(888),date,ca.getTime(),0,null,"");
            GoldCard2 goldCard22 = new GoldCard2(account,"288元彩金卡", BigDecimal.valueOf(20000),1,BigDecimal.valueOf(288),date,ca.getTime(),0,null,"");
            GoldCard2 goldCard23 = new GoldCard2(account,"288元彩金卡", BigDecimal.valueOf(20000),1,BigDecimal.valueOf(288),date,ca.getTime(),0,null,"");
            GoldCard2 goldCard25 = new GoldCard2(account,"128元彩金卡", BigDecimal.valueOf(10000),1,BigDecimal.valueOf(128),date,ca.getTime(),0,null,"");
            GoldCard2 goldCard24 = new GoldCard2(account,"128元彩金卡", BigDecimal.valueOf(10000),1,BigDecimal.valueOf(128),date,ca.getTime(),0,null,"");
            list.add(goldCard22);
            list.add(goldCard23);
            list.add(goldCard21);
            list.add(goldCard24);
            list.add(goldCard25);
        }
        return list;
    }
}
