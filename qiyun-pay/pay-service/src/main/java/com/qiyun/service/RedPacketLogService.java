package com.qiyun.service;

import com.qiyun.dto.GrabRedRacketDTO;
import com.qiyun.dto.MyTotalRedRacketDTO;
import com.qiyun.model2.RedPacketLog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface RedPacketLogService {
    RedPacketLog getByPacketId(int redpacketId, String account);

    int insertSelective(RedPacketLog record);

    List<GrabRedRacketDTO> getAllList(int offset, int pageSize);

    List<GrabRedRacketDTO> getMyList(String account, int offset, int pageSize);

    MyTotalRedRacketDTO getTotalMoney(String account);

    String getLyById(int id);

    Map<String, Object> lyRedPackage(String id, String account,String content);
}
