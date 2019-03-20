package com.qiyun.api;

import java.util.Map;

public interface TicketManageApi {

    /**
     * 票查询
     * @param
     * @return
     */
    public Map<String,Object> searchTicket(Integer type,Integer provider,String term,String startTerm,String endTerm,Integer id,Integer planNo,Integer playType,Integer isBingo,Integer status,String createDateTimeStart,String createDateTimeEnd,String printDateTimeStart,String printDateTimeEnd,String sendTicketDateTimeStart,String sendTicketDateTimeEnd,Integer offset,Integer pageSize);

    /**
     * 获取玩法及其票务商列表
     * @param reqMap
     * @return
     */
    public Map<String,Object> getList(Map<String,Object> reqMap);

    /**
     * 修改玩法对应票务商
     * @param reqMap
     * @return
     */
    public Map<String,Object> updateBusiness(Map<String,Object> reqMap);

    /**
     * 获取出票校验参数
     * @return
     */
    public Map<String,Object> getRestrict();

    /**
     * 修改校验参数
     * @param reqMap
     * @return
     */
    public Map<String,Object> updateRestrict(Map<String,Object> reqMap);

    /**
     * 修改订单状态
     * @param reqMap
     * @return
     */
    public Map<String,Object> updatePlanStatus(Map<String,Object> reqMap);

    /**
     * 寻票
     * @param planNo
     * @param account
     * @return
     */
    public Map<String,Object> putMatchTicketBySys(int planNo, String account);

    /**
     * 送票
     * @param reqMap
     * @return
     */
    public Map<String,Object> deliverTicket(Map<String,Object> reqMap);

    /**
     * 查询寻票列表
     * @param reqMap
     * @return
     */
    public Map<String,Object> findTicketList(Map<String,Object> reqMap);

    /**
     * 查询票务出票情况
     * @param planNo
     * @return
     */
    public Map<String,Object> getTicketResultByPlanNo(int planNo, int businessType);

    /**
     * 修改票为出票状态
     * @param planNo
     * @return
     */
    public Map<String,Object> updateTicketStatus(int planNo);

    Map<String,Object> addTicketConfig(double amount, double bonus, int isSuperMan, int status);

    Map<String,Object> getTicketConfig(int isSuperMan);

    Map<String,Object> findTicket(int planNo, String account, int type);

    Map<String,Object> findTicketList2(int type, String account, int planNo,int page,int pageSize);

    Map<String,Object> getPlanTicketDetail(int planNo);
}
