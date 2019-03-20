package com.qiyun.mapper2;

import com.qiyun.model2.AgentChargeLine2;
import com.qiyun.model2.AgentChargeLine2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface AgentChargeLine2Mapper {
    int countByExample(AgentChargeLine2Query example);

    int deleteByExample(AgentChargeLine2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(AgentChargeLine2 record);

    int insertSelective(AgentChargeLine2 record);

    List<AgentChargeLine2> selectByExample(AgentChargeLine2Query example);

    AgentChargeLine2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AgentChargeLine2 record, @Param("example") AgentChargeLine2Query example);

    int updateByExample(@Param("record") AgentChargeLine2 record, @Param("example") AgentChargeLine2Query example);

    int updateByPrimaryKeySelective(AgentChargeLine2 record);

    int updateByPrimaryKey(AgentChargeLine2 record);

    List<AgentChargeLine2> selectByAccounts(@Param("list") List<String> dlList ,@Param("memberAccount") String memberAccount, @Param("end_time") String end_time, @Param("start_time") String start_time);
}