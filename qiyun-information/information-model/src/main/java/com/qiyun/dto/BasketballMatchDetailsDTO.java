package com.qiyun.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BasketballMatchDetailsDTO implements Serializable {
    //赛事id
    int matchId;
    //场次id
    int lineId;
    //比赛投注日期
    int intTime;
    //比赛开始时间
    Date matchTime;
    //主队
    private String homeName;
    //客队
    private String guestName;
    //赛事名称
    private String gameName;
    //各玩法sp值
    List<BasketballMatchSpDTO> spDTOList;
}
