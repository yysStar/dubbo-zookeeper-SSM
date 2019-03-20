package com.qiyun.api;

import java.util.Map;

public interface SuperGodApi {
    /**
     * 获取超级大神个人中心
     * @param account
     * @return
     */
    Map<String,Object> getSuperGod(String account, String fansAccount);

    /**
     * 添加关注
     * @param account
     * @param fansAccount
     * @return
     */
    Map<String,Object> followMember(String account, String fansAccount);

    /**
     * 取消关注
     * @param account
     * @param fansAccount
     * @return
     */
    Map<String,Object> cancelFollow(String account, String fansAccount);

    /**
     * 关注列表
     * @param fansAccount
     * @return
     */
    Map<String,Object> followList(String fansAccount, int offset, int pageSize);

    /**
     * 粉丝列表
     * @param account
     * @return
     */
    Map<String,Object> fansList(String account, int offset, int pageSize);

    /**
     * 本人方案列表
     * @param account
     * @return
     */
    Map<String,Object> planList(String account, boolean isSelf, int type, int offset, int pageSize);
}
