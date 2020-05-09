package com.qiyun.service;

import com.qiyun.common.Result;
import com.qiyun.dto.AgentChargeLine2DTO;

public interface AgentChargeLineService {
    Result insert(AgentChargeLine2DTO agentChargeLine2DTO);

    Result getAgentChargeLine(String account, int page, int pageSize, String loginAccount, String memberAccount, String start_time, String end_time);
}
