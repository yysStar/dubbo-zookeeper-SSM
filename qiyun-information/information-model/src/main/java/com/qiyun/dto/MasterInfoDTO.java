package com.qiyun.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class MasterInfoDTO implements Serializable {
    /**
     * 头像
     */
    private String picture;
    /**
     * 昵称
     */
    private String userName;
    /**
     * 账户
     */
    private String account;
    /**
     * 关注人数
     */
    private int followNum;
    /**
     * 粉丝人数
     */
    private int fansNum;
    /**
     * 战绩（近两周战绩）
     */
    private String militaryExploits;
    /**
     * 中奖率（近两周）
     */
    private BigDecimal rateOfReturn;
    /**
     * 当前任务完成情况
     */
    private MemberTaskBeginDTO memberTaskBeginDTO;
}
