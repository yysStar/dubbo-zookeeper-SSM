package com.qiyun.service;

import com.qiyun.dto.MyTotalRedRacketDTO;
import com.qiyun.dto.RedPacketDTO;
import com.qiyun.dto.RedPacketDetailsDTO;
import com.qiyun.model2.RedPacket;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface RedPacketService {

    Map<String, Object> isRedPacket(String account);

    int insertSelective(RedPacket redPacket);

    List<RedPacketDTO> getAllList(int offset, int pageSize);

    int updateByPrimaryKeySelective(RedPacket redPacket);

    RedPacket getById(int id);

    RedPacketDetailsDTO getDetails(int redPacketId);

    List<RedPacketDTO> getMyList(String account, int offset, int pageSize);

    MyTotalRedRacketDTO getTotalMoney(String account);

    RedPacketDTO getNowByAccount(String account);

    Map<String, Object> search(String account);

    int getJump(int id);

    String getAccount(int id);

    Integer getFollow(String account);

    int getAmount(int planNo);

    int getMultiple(int planNo);

    Integer getType(String account);

    Integer getCyMultiple(String account);

    Integer getRed(String account);

    String getUsername(String account);

    String getPICTURE(String account);

    int getCount(int redPacketId);
}
