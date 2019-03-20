package com.qiyun.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RedPacketListDTO implements Serializable {

    private Integer walletLineNo;   //钱包流水id

    private Integer id; //红包id

    private String qbAccount; //抢包人账户

    private String fbAccount; //发包人账户

    private Double money;   //红包总金额

    private Double amount; //抢红包或发红包的金额

    private Double ableBalance; //抢完或发完红包后的可用余额

    private Date time;  //时间

    private Integer number; //红包数量

    private Integer status; //红包状态

    private Double surplusMoney;   //剩余可抢金额

    private Integer surplusNumber; //剩余可抢数量

    private Integer apply;  //红包适用人群 1为粉丝  2为全部

}
