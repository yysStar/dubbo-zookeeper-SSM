package com.qiyun.dto;

import com.qiyun.model2.RedPacket;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RedPacketDTO extends RedPacket implements Serializable {
    private String picture;
    private String userName;
}
