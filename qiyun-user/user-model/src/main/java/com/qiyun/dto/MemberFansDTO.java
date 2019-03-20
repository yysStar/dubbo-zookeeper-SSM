package com.qiyun.dto;

import lombok.*;

import java.io.Serializable;

@Setter
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberFansDTO implements Serializable {
    /**
     * 账户名
     */
    private String account;

    /**
     * 头像图片
     */
    private String picture;

    /**
     * 用户昵称
     */
    private String userName;
}
