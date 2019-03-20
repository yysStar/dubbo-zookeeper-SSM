package com.qiyun.service;

import com.qiyun.dto.Member2DTO;
import com.qiyun.dto.MemberDTO;
import com.qiyun.model2.MemberMasterMapping;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface MasterService {

    Map<String, Object> getSgMatch(String date);

    List<MemberDTO> Search(String keywords ,int offset, int pageSize);

    List<MemberDTO> getMasterList(int offset, int pageSize);

    List<MemberDTO> getHighGradeList(int offset, int pageSize);

    Map<String,Object> findIndexInfo(Member2DTO member2DTO);

    Map<String,Object> celebrityBeginTask(Member2DTO member2DTO);

}
