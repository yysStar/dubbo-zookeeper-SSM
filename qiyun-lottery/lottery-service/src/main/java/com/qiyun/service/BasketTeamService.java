package com.qiyun.service;

import com.qiyun.model.basketball.BasketBallTeam;
import org.springframework.stereotype.Service;

@Service
public interface BasketTeamService {
    BasketBallTeam getTeamInfoByFullName(String home);

    void saveIfChange(BasketBallTeam homeTeam);
}
