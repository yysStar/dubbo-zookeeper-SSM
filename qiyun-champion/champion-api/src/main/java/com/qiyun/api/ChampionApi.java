package com.qiyun.api;

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
}
