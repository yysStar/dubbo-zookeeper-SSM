package com.qiyun.mapper2;

import com.qiyun.common.GoldCard2;
import com.qiyun.dto.MemberWalletLine2DTO;
import com.qiyun.dto.SuperGodDTO;
import com.qiyun.model.MemberWalletLine;
import com.qiyun.model.PayMember;
import com.qiyun.model2.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface Member2Mapper {

    int updateUserToWrite(String userName, Date tobeWriteTime);

    int countByExample(Member2Query example);

    int deleteByExample(Member2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(Member2 record);

    int insertSelective(Member2 record);

    List<Member2> selectByExample(Member2Query example);

    Member2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Member2 record, @Param("example") Member2Query example);

    int updateByExample(@Param("record") Member2 record, @Param("example") Member2Query example);

    int updateByPrimaryKeySelective(Member2 record);

    int updateByPrimaryKey(Member2 record);

    Member2 selectByAccount(String account);

    Member2 selectByMobile(String mobile);

    Member2 selectByMobileOrAccount(String account);

    List<PayMember> getPayMember();


    int findAccountNum(String accountId);

    int findActiveNum(String account);

    Map findPayNum(String account);

    /**
     * 获取超级大神数据
     *
     * @param account
     * @return
     */
    SuperGodDTO getSuperGod(String account);

    SuperGodDTO getSuperGodN(String account);

    String getAgentCode(String account);

    int findMemberNote(Map<String, Object> map);

    int addMemberNote(Map<String, Object> map);

    int updateMemberNote(Map<String, Object> map);

    List<Map> findSalesMoneyInfo(Map account);

    List<Map> findAccountWall(Map minCount);

    List<Map> findRechargeWall(Map<String, Object> map);

    int checkCertNo(String certNo);

    int checkMobile(String mobile);

    int checkName(String memberName);

    int memberToAgent(Map paramMap);

    List<Map> memberMoveLogs();

    List<Map> findMemberPlan(Map map);

    Member2 getByUsername(String account);

    List<Member2> getRobotList();

    List<Map> findSaleDatas(Map<String, Object> map);

    List<Map> findMemberAssociation(Map map);

    List<Map> findMemberMove(Map map);

    List<Map> findMemberWalletLine(Map map);

    List<Map> findRechargeLine(Map<String, String> mapParam);

    List<Map> findRechargeUnderLine(Map<String, String> mapParam);

    List<Map> findFinancialCashInfo(Map map);

    List<Map> findSaleInfo();


    List<Map> findFinancialMoneyInfo(Map isMonth);


    List<Map<String, Object>> getMemberByAgent(Map<String, Object> map);

    

    List<Map> findselfBuy( Map mapParams);

    int findfollowBuy(Map s);

    String findCommision(Map s);

    List<Map> findRechargeAndWitdrawlInfo(String account);

    Map findRoleByAccount(String account);

    List<Map<String, Object>> findAllParentModel(@Param("model_id") Integer id);


    int addUser(Map<String,Object> map);

    List<Map<String,Object>> findChildModel(Map<String,Object> map);

    List<Map> findAllRole(Map<String, Object> map);

    List<Map> findAllUserAndRole(@Param("user_id")Integer id);

    int addPermission(Map<String,Object> map);

    int addParentModel(Map<String,Object> map);

    int addRole(Map<String,Object> map);

    int updatePermission(Map<String,Object> map);

    void updateChildPermission(Map map);

    String findModelName(String s);

    Map findChildModelName(@Param(value = "children") Integer children, @Param(value = "role_id") int role_id);

    int updateStatus(Map map);

    int addMemberToAgent(Map map);
    int memberMoveAudit(Map map);

    int updateUserInfo(Map<String,Object> map);

    int updateChildModelInfo(Map<String,Object> map);


    int findAccountNumBy(Map mapParams);

    int findActiveNumBy(Map mapParams);

    Map findPayNumBy(Map mapParams);

   List<Map> findChildModelByParent(Integer parentModelId);

    Member2 selectByPlanNo(int planNo);

    int delUser(Integer user_id);

    int updateMemberToQD(Integer member_id, String account, Date date, Integer transType, String active_code);

    List findAllAgentAndQD(@Param("account") String account);

    void addAgentToQD(@Param("qd_id") String qd_id, @Param("agent_id") Integer agent_id);

    int findDrawsNums(String account);

    int updateDrawsNum(int i, String account);

    int addGoldCard(GoldCard2 goldCard2);

    List<GoldCard2> findGoldCard(@Param(value = "account") String account,@Param(value = "startTime") String startTime,@Param(value = "endTime") String endTime);

    int addActivity(Map<String,Object> mapParams);

    List<Map> findAllActivity();

    int updateActivity(Map<String,Object> mapParams);

    int resetDrawsNum();

    int updateGoldCard(GoldCard2 goldCard2);

    int incrementDrawsNum(int i, String account);

    List<Map> findMemberWalletLineByAccount(@Param("allInfo")Map account, @Param("listParam")List<Integer> list);


    MemberAgent2 findAgetInfo(String account);

    void upgradeAgentToQD(String account);


    void updateMemberSourceId(@Param(value = "provider") String provider, @Param(value = "memberId") int i,@Param(value = "sourceId") Integer sourceId);

    List<MemberWalletLine2> findRobotConsume();

    Map findchildRole(Map map1);

    void updateChild(Map<String,Object> map);

    Map findAdminUser(Map<String,Object> map);

    int updateParentModel(Map<String,Object> map);

    int insetQDToUser(String user_account, String s);

    int delQDToUser(String user_account, String s);

    List<String> findQDByLoginAccount(String loginAccount);

    int memberToWrite(String account,Date time);

    int memberToNoWrite(String account,Date time);

    List<Map>findAllMemberBy(Map<String,Object> map);

    List<Member2> getBeforeOneMonth(Date date);

    List<String> findMemberByAccount(String agentAccount);

    List<Map> findMemberPlanByMember(List account);

    List<Member2> selectByUserName(String member);


    List<Map> findDlInfoByQD(@Param("qdList") List<String> accounts, @Param("dlAccount") String agentName);

    void updateMemberInfoBack(Map<String,Object> paramMap);
}