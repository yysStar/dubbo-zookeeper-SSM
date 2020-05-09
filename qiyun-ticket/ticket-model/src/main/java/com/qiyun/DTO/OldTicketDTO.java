package com.qiyun.DTO;

import lombok.*;

/**
 * 老项目拆票之后传入需要的参数
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OldTicketDTO {
    /**
     * 老项目票id
     */
    private int ticketId;
    /**
     * 老项目玩法id
     */
    private int lotteryType;
}
