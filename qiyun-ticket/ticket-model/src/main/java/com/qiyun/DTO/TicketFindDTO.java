package com.qiyun.DTO;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TicketFindDTO implements Serializable {
    /**
     * 寻票id
     */
    private Integer id;
    /**
     * 方案号编号
     */
    private Integer planNo;
    /**
     * 寻票时间
     */
    private Date findTime;
    /**
     * 寻票驳回标记
     */
    private Boolean isFind;
    /**
     * 是否还可送票
     */
    private Boolean isDeliver;
    /**
     * 用户名
     */
    private String account;
    /**
     * 方案状态
     */
    private Integer planStatus;
    /**
     * 方案创建时间
     */
    private Date createDateTime;
}
