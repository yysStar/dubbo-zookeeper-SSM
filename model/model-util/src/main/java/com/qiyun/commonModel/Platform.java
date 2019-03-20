package com.qiyun.commonModel;

import com.qiyun.hibernate.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

public class Platform extends IntegerBeanLabelItem {
    private static final long serialVersionUID = -8621003869402167415L;

    protected Platform(String name, int value) {
        super(Platform.class.getName(), name, value);
    }

    public static Platform getItem(int value) {
        try{
            return (Platform) Platform.getResult(Platform.class.getName(), value);
        }catch(Exception e){
            return Platform.WWW;
        }
    }

    public static final Platform ALL = new Platform("全部", -1);
    public static final Platform WWW = new Platform("web", 1);
    public static final Platform G3 = new Platform("3g", 2);
    public static final Platform ANDROID = new Platform("android", 3);
    public static final Platform IOS = new Platform("ios", 4);
    public static final Platform UNKNOWN = new Platform("unknown", 5);
    public static final Platform WIN = new Platform("中奖王", 6);
    public static final Platform WX = new Platform("微信", 7);
    public static final Platform LOT_MGR_ANDROID = new Platform("彩票大管家android", 8);
    public static final Platform LOT_MGR_IOS = new Platform("彩票大管家ios", 9);
    public static final Platform SYSTEM = new Platform("后台系统", 10);
    public static List<Platform> list = new ArrayList<Platform>();
    public static List<Platform> mobileList=new ArrayList<Platform>(); //移动端集合


    /**
     * 彩票管家集合
     */
    public static List<Platform> lotMgrList = new ArrayList<Platform>();

    /**
     * 是否是 o2o平台
     */
    public static boolean isO2O(Platform platform){
        return lotMgrList.contains(platform);
    }

    static {
        list.add(ALL);
        list.add(WWW);
        list.add(G3);
        list.add(ANDROID);
        list.add(IOS);
        list.add(UNKNOWN);
        list.add(WIN);
        list.add(WX);
        list.add(LOT_MGR_ANDROID);
        list.add(LOT_MGR_IOS);

        mobileList.add(G3);
        mobileList.add(ANDROID);
        mobileList.add(IOS);
        mobileList.add(WX);
        mobileList.add(LOT_MGR_ANDROID);
        mobileList.add(LOT_MGR_IOS);

        lotMgrList.add(LOT_MGR_ANDROID);
        lotMgrList.add(LOT_MGR_IOS);
    }

}
