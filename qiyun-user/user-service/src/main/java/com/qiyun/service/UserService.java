package com.qiyun.service;

import com.github.pagehelper.PageInfo;
import com.qiyun.common.MyPageInfo;
import com.qiyun.common.Result;
import com.qiyun.dto.Member2DTO;
import com.qiyun.dto.MemberAgentDTO;
import com.qiyun.exception.ServiceException;
import com.qiyun.model.Member;
import com.qiyun.model2.Member2;
import com.qiyun.model2.MemberAgent2;
import com.qiyun.model2.MemberWalletLine2;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    Member2 getMemberByAccount(String account);

    Member getMemberByAccount2(String account);

//    Member2 getMemberByAccount2(String account);

    Member2 getMemberByMobile(String mobile);

//    Member2 getMemberByMobile2(String mobile);

    int register(Member2 member) throws ServiceException;

    Member2 getMember2ByAccount(String account);

    void updateMember2(Member2 member2);

    void updateMember(Member member);

    Result login(String account, String password);

    Result bindCertNoSave(String certNo, String realName, Member2DTO member2DTO);

    MemberAgentDTO getMemberAgentByActiveCode(String activeCode);

    Result getMemberInfo(String account);

    int  updateUserToWrite(String userName, Date tobeWriteTime);

    Map getIndexNumInfo(String account);

    String getAgentCode(String account);

   int updateMemberNote(Map<String,Object> map);

    List<Map> findSalesMoneyInfo(Map account);

    List<Map> findAccountWall( String minCount);

    List<Map> findRechargeWall(String account, String minCount, String username, Integer isConsumer);

    int checkCertNo(String certNo);

    int checkMobile(String mobile);

    Map<String,Object> memberToAgent(String memberAccount, String agentAccount, String note, String newAgent);

    List<Map> memberMoveLogs();

    PageInfo findMemberPlan(String member,Integer page,Integer pageSize);

    List<Map> findAgentInfoByAccount(List<String> account, Integer isMonth);

    List<Map> findMemberAssociation(String agentName, String startDate, String endDate, Integer page, Integer pageSize);

    List<Map> findMemberMove(String agentName, String startDate, String endDate);

    List<Map> findMemberWalletLine(List<String> agentAccount, String startDate, String endDate);

    List<Map> findRechargeLine(Map<String, String> mapParam);

    List<Map> findRechargeUnderLine(Map<String, String> mapParam);

    List<Map> findFinancialCashInfo(Integer isMonth);

    PageInfo findSaleInfo(String agentName, String start_time, String end_time, Integer page, Integer pageSzie, String loginAccount);
    MyPageInfo findQDSaleInfo(String qdName, String start_time, String end_date, Integer page, Integer pageSize);

    List<Map> findFinancialMoneyInfo(Integer isMonth);

    List<Map> findRechargeAndWitdrawlInfo(String account);

    Map findRoleByAccount(String account);

    List<Map<String, Object>> findAllParentModel(Integer id);


    List<Map<String, Object>> findChildModel(Map map);

    int addUser(Map<String,Object> map);

    List<Map> findAllRole(Map<String, Object> map);

    List<Map> findAllUserAndRole(Integer id);


    int addPermission(Map<String,Object> map);

    int addParentModel(Map<String,Object> map);


    int addRole(Map<String,Object> map);

    int updatePermission(Map<String,Object> map);

    void updateChildPermission(Map map1);

    String findModelName(String s);

    Map findChildModelName(Integer childs, Object id);

    int MemberAudit(Map map);

    int MemberMoveAudit(Map map);

    int updateUserInfo(Map<String,Object> map);

    int updateChildModelInfo(Map<String,Object> map);

    List<Map> findChildModelByParent(Integer parentModelId);

    int delUser(Integer user_id);

    int updateMemberToQD(Integer member_id, String account, String provider, Integer transType, Integer sourceId, String active_code);

    List<Map> findAllMember(String start_time, String end_time, String username, String account, String mobile,String realName,String identifyId,String email) throws ParseException;

    List<Map> findAllAgentAndQD(String account);

    void addAgentToQD(Map<String,Object> Object);

    PageInfo findMemberWalletLineByAccount(Map<String,Object> map);

    boolean findMemberInfo(String agentAccount,String member);


    MemberAgent2 findAgetInfo(String account);

    void upgradeAgentToQD(String account);

    List<MemberWalletLine2> findRobotConsume();

    Map findchildRole(Map map1);

    void updateChild(Map<String,Object> map);

    Map findAdminUser(Map<String,Object> map);

    int updateParentModel(Map<String,Object> map);

    void setOrUpdateQDtoUser(Map map);

    List<String> findMemberByAccount(String  agentAccount);
    List<Map> findMemberPlanByMember(List account);

    void updateMemberInfoBack(Map<String,Object> paramMap);
}
