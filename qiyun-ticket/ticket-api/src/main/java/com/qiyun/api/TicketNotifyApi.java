package com.qiyun.api;

import java.util.Map;

public interface TicketNotifyApi {

    /**
     * 出票通知接口
     * @param reqMap
     * @return
     */
    public Map<String,Object> matchTicketNotify(Map<String,Object> reqMap);
}
