package com.qiyun.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RedPacketDetailsDTO extends RedPacketDTO {
    private boolean isFollow;

    private List<GrabRedRacketDTO> logList;
}
