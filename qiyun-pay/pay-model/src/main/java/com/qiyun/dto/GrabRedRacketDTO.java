package com.qiyun.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 抢包记录
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class GrabRedRacketDTO implements Serializable {
    //抢包流水id
    private int id;
    //发包人账号昵称
    private String account;
    private String name;
    //抢包人账号昵称
    private String grabAccount;
    private String grabName;
    private String picture;
    //抢包金额
    private BigDecimal grabMoney;
    //抢包时间
    private Date createDatetime;
    //留言内容
    private String lyContent;
    //是否自己
    private int isSelf;
}
