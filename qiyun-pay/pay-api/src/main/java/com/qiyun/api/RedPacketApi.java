package com.qiyun.api;

import java.math.BigDecimal;
import java.util.Map;

public interface RedPacketApi {


    /**
     * 红包留言
     * @param id
     * @param account
     * @param content
     * @return
     */
    Map<String, Object> lyRedPackage(String id,String account,String content);

    /**
     * 判断是否有新的红包
     * @param account
     * @return
     */
    Map<String, Object> isRedPacket(String account);

    /**
     * 发红包时查询是否有进行中的单或红单
     * @param account
     * @return
     */
    Map<String, Object> search(String account);

    /**
     * 新建红包
     * @param account
     * @return
     */
    Map<String, Object> addRedRacket(String account, BigDecimal money,
            String name, int type, int number, int apply,int mark);

    /**
     * 红包列表
     * @param offset
     * @param pageSize
     * @return
     */
    Map<String, Object> redRacketList(int offset,int pageSize,String account);

    /**
     * 红包校验
     * @param id
     * @param account
     * @return
     */
    Map<String, Object> checkRedRacket(int id, String account);

    /**
     * 获取抢红包跳转的页面
     * @param id
     * @return
     */
    Map<String, Object> getJump(int id);

    /**
     * 抢红包
     * @param id
     * @param account
     * @return
     */
    Map<String, Object> grabRedRacket(int id, String account);

    /**
     * 抢红包记录列表
     * @param offset
     * @param pageSize
     * @return
     */
    Map<String, Object> grabRedRacketList(int offset,int pageSize);

    /**
     * 红包详情
     * @param redPacketId
     * @return
     */
    Map<String,Object> getRedPacketDetails(String account, int redPacketId);

    /**
     * 我抢到的红包列表
     * @param account
     * @return
     */
    Map<String,Object> MygrabRedRacketList(String account, int offset, int pageSize);

    /**
     * 发出的红包列表
     * @param account
     * @return
     */
    Map<String,Object> awardRedPacketList(String account, int offset, int pageSize);

    /**
     * 获取用户当前红包
     * @param account
     * @return
     */
    Map<String,Object> getRedPacketNow(String account);
}
