package com.qiyun.service;

import com.qiyun.common.Result;
import com.qiyun.dto.PayChannelDTO;
import com.qiyun.dto.XxPay2DTO;

public interface PayChannelService {
    Result addPayChannel(PayChannelDTO payChannelDTO);

    Result getPayChannelList(int page, int pageSize);

    Result updateStatus(int id, int status);

    Result updatePayChannel(XxPay2DTO xxPay2DTO);

    XxPay2DTO getPayChannelById(int id);

    Result deletePayChannel(int id);

    XxPay2DTO getPayChannelByIdAndIsOnLineAndType(int id, int isOnLine, String type);

}
