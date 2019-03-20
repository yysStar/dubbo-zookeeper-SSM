package com.qiyun.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class MemberDTO implements Serializable {
    /**
     * 账户名
     */
    private String account;
    /**
     * 昵称
     */
    private String userName;
    /**
     * 头像
     */
    private String picture;
}
