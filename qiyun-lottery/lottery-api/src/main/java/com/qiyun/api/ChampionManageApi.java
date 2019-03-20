package com.qiyun.api;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 后台管理接口
 */
public interface ChampionManageApi {
    /**
     * 手动维护失败队伍
     * @param teamIdList
     * @return
     */
    Map<String, Object> putFailTeam(List<Integer> teamIdList);

    /**
     * 手动维护中奖队伍
     * @param teamId
     * @return
     */
    Map<String, Object> putSuccessTeam(Integer teamId, Integer type);

    /**
     * 修改冠亚军投注状态
     * @param type
     * @return
     */
    Map<String, Object> openAndClose(Integer type);

    /**
     * 冠亚军订单列表
     * @param account
     * @param offset
     * @param pageSize
     * @param startTime
     * @param endTime
     * @param planId
     * @return
     */
    Map<String, Object> getPlanList(String account, int offset, int pageSize, Date startTime, Date endTime,
                                    Integer planId);

}
