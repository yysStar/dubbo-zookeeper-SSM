package com.qiyun.model2;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Ticket2 implements Serializable {
    private Integer id;     //票号

    private Integer planNo;     //方案编号

    private String term;        //彩期

    private Integer lotteryType;    //彩种

    private Integer amount;     //出票金额

    private Date createDateTime;    //生成票日期

    private Date sendDateTime;      //送票日期

    private Date printDateTime;     //打票日期

    private Date dealDateTime;

    private Integer multiple;   //倍数

    private Integer playType;       //玩法

    private Integer isBingo;        //中奖状态

    private Double bingoAmount;     //中奖金额

    private Integer status;         //出票状态

    private String addAttribute;

    private String account;

    private String outId;

    private Integer noInBatch;

    private String batchNo;

    private Integer isConvert;

    private Date convertDateTime;

    private String serialNo;

    private Integer provider;       //提供商

    private Integer errorCode;

    private Integer winStatus;

    private Date openResultTime;

    private Date returnPrizeTime;

    private String fhPlayType;
}