package com.qiyun.mapper2;

import com.qiyun.model.PlanTicketMapping;
import com.qiyun.model.PlanTicketMappingExample;
import java.util.List;

public interface PlanTicketMappingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlanTicketMapping record);

    int insertSelective(PlanTicketMapping record);

    List<PlanTicketMapping> selectByExample(PlanTicketMappingExample example);

    PlanTicketMapping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlanTicketMapping record);

    int updateByPrimaryKey(PlanTicketMapping record);

    /**
     * 通过内部票号查询票状态
     * @param orderId
     * @return
     */
    PlanTicketMapping selectByOrderId(String orderId);

    /**
     * 通过方案号查询
     * @param planNo
     * @return
     */
    List<PlanTicketMapping> selectByPlanNo(int planNo);

    /**
     * 通过老库票id查询新库内部票id
     * @param ticketId
     * @return
     */
    PlanTicketMapping selectByTicketId(int ticketId);

    void updateForStatusByOrderId(String orderID, int status);
}