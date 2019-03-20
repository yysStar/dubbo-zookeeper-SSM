package com.qiyun.service;

import com.qiyun.model2.TicketLottreyMapping2;

public interface TicketLotteryMappingService {
    TicketLottreyMapping2 getByLotteryType(int lotteryType);
}
