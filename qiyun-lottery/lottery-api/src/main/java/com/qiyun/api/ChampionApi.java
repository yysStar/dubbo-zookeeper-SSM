package com.qiyun.api;

import java.util.List;
import java.util.Map;

public interface ChampionApi {
    /**
     * 冠军赛事列表
     * @return
     */
    Map<String, Object> getMatchList();

    /**
     * 冠亚军赛事列表
     * @return
     */
    Map<String, Object> getMatchUpList();

    /**
     * 冠亚军投注
     * @return
     */
    Map<String, Object> betChampion(String account, int type, List<Integer> matchList, int multiple);

    /**
     * 我的冠亚军
     * @param account
     * @param offset
     * @param pageSize
     * @return
     */
    Map<String, Object> planList(String account, int offset, int pageSize);

    /**
     * 获取中奖订单列表
     * @param account
     * @param offset
     * @param pageSize
     * @return
     */
    Map<String, Object> planBingoList(String account, int offset, int pageSize);

    /**
     * 冠亚军订单详情
     * @param id
     * @return
     */
    Map<String, Object> planDetails(int id);
}
