package com.qiyun.commonModel;

import com.qiyun.hibernate.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

public class ChargeType extends IntegerBeanLabelItem {

    private static final long serialVersionUID = -1410849485815957495L;


    protected ChargeType(String name, int value) {
        super(ChargeType.class.getName(), name, value);
    }



    public static ChargeType getItem(int value) {
        return (ChargeType) ChargeType.getResult(ChargeType.class.getName(), value);
    }

    public static final ChargeType ALL = new ChargeType("全部类型", 0);
    //	public static final ChargeType WSZF = new ChargeType("易宝", 1);
//	public static final ChargeType DZHK = new ChargeType("电子汇款", 2);
    public static final ChargeType ZFB = new ChargeType("支付宝", 3);
    //	public static final ChargeType CFT = new ChargeType("财付通", 4);
//	public static final ChargeType DNAPAY = new ChargeType("银联手机支付", 5);
//	public static final ChargeType KFT = new ChargeType("快付通",6);
//	public static final ChargeType UPOP = new ChargeType("银联无卡支付", 7);
//	public static final ChargeType UMPAY = new ChargeType("联动优势支付",8);
    public static final ChargeType ZFB_WIRELESS_PAY  = new ChargeType("支付宝无线支付", 9);
    //public static final ChargeType ZFB_TWO_CODY_PAY  = new ChargeType("支付宝二维码支付", 10);
//	public static final ChargeType ABC_BANK_PAGE_PAY  = new ChargeType("农行页面支付", 11);
//	public static final ChargeType ABC_BANK_MOBILE_PAY  = new ChargeType("农行手机web支付", 12);
//	public static final ChargeType BOC_PAGE_PAY  = new ChargeType("中行页面支付", 13);
//	public static final ChargeType BOC_MOBILE_PAY  = new ChargeType("中行安全支付", 14);
//	public static final ChargeType CHINA_PAY  = new ChargeType("银联web支付", 15);
//	public static final ChargeType LIANLIANPAY = new ChargeType("连连支付",16);
//	public static final ChargeType LIANLIAN_WIRELESS_PAY = new ChargeType("连连无线支付",17);
//	public static final ChargeType SINA_PAY = new ChargeType("新浪支付",18);
//	public static final ChargeType SINA_PAY_WIRELESS_PAY = new ChargeType("新浪无线支付",19);
//	public static final ChargeType WEIXIN_WIRELESS_PAY = new ChargeType("微信无线支付",20);
//	public static final ChargeType BOC_WAP_PAY  = new ChargeType("中行3G支付", 21);
//	public static final ChargeType SHENG_PAY  = new ChargeType("盛大支付", 22);
//	public static final ChargeType LIANLIAN_WAP_PAY = new ChargeType("连连WAP支付",23);
//	public static final ChargeType UMPAY_WAP = new ChargeType("联动优势WAP支付",24);
//	public static final ChargeType MBZF = new ChargeType("摩宝", 25);




    public static final List<ChargeType> list = new ArrayList<ChargeType>();


    static {

        list.add(ALL);
        //list.add(WSZF);
        list.add(ZFB);
        //list.add(CFT);
        //list.add(DNAPAY);
        //list.add(KFT);
        //list.add(UPOP);
        //list.add(UMPAY);
        list.add(ZFB_WIRELESS_PAY);
        //	list.add(ZFB_TWO_CODY_PAY);
        //list.add(ABC_BANK_PAGE_PAY);
        //list.add(ABC_BANK_MOBILE_PAY);
        //list.add(BOC_PAGE_PAY);
        //list.add(BOC_MOBILE_PAY);
        //list.add(CHINA_PAY);
        //list.add(LIANLIANPAY);
        //list.add(LIANLIAN_WIRELESS_PAY);
        //	list.add(SINA_PAY);
        //list.add(SINA_PAY_WIRELESS_PAY);
        //list.add(WEIXIN_WIRELESS_PAY);
        //	list.add(BOC_WAP_PAY);
        //list.add(SHENG_PAY);
        //	list.add(LIANLIAN_WAP_PAY);
        //	list.add(UMPAY_WAP);
        //	list.add(MBZF);
    }
}
