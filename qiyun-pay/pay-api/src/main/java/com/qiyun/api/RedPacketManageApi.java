package com.qiyun.api;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface RedPacketManageApi {

    /**
     * 平台发布红包
     * @param money
     * @param name
     * @param type
     * @param number
     * @return
     */
    public Map<String, Object> addRedRacketForPlatform(List<Integer> robotIdList, Date date,
                               BigDecimal money, String name, int type, int number, BigDecimal robotMoney);

    /**
     * 抢红包记录列表
     * @param offset
     * @param pageSize
     * @return
     */
    Map<String, Object> grabRedRacketList(int offset,int pageSize,String account,String startTime,String endTime);

    /**
     * 发红包记录列表
     * @param offset
     * @param pageSize
     * @return
     */
    Map<String, Object> putRedRacketList(int offset,int pageSize,String account,String startTime,String endTime);
}
