package com.qiyun.api;

import com.qiyun.common.Result;
import com.qiyun.dto.Member2DTO;
import com.qiyun.dto.MemberInfoDTO;

import java.util.Map;

public interface UserApi {
    /**
     * 校验手机号，用户名是否可用
     *
     * @param reqMap
     * @return
     */
    Map<String, Object> checkNum(Map<String, Object> reqMap);

    /**
     * 注册
     *
     * @param reqMap
     * @return
     */
    Map<String, Object> register(Map<String, Object> reqMap);

    /**
     * 获取短信验证码
     *
     * @param reqMap
     * @return
     */
    Map<String, Object> getSmsNotify(Map<String, Object> reqMap);

    /**
     * 修改会员
     *
     * @param
     * @return
     */
    Map<String, Object> updateUser(Map<String, Object> reqMap);

    /**
     * 修改为白名单
     * 增加修改时间
     */
    Map<String, Object> updateUserToWrite(Map<String, Object> reqMap);

    /**
     * 根据用户名获取用户信息
     *
     * @param account
     * @return
     */
    Member2DTO getMember2ByAccount(String account);


    /**
     * 根据用户名获取用户信息
     *
     * @param account
     * @return
     */
    Member2DTO getMemberByAccount(String account);

    /**
     * 登录
     *
     * @param account
     * @param password
     * @return
     */
    Result login(String account, String password);

    /**
     * 绑定身份证和真实姓名
     *
     * @param certNo
     * @param realName
     * @param member2DTO
     * @return
     */
    Result bindCertNoSave(String certNo, String realName, Member2DTO member2DTO);

    /**
     * 根据用户名获取memberinfo
     *
     * @param account
     * @return
     */
    MemberInfoDTO getMemberInfoByAccount(String account);

    /**
     * 修改memberinfo
     *
     * @param memberInfoDTO
     * @return
     */
    Result updateMemberInfo(MemberInfoDTO memberInfoDTO);

    /**
     * 修改用户名
     *
     * @param member2DTO
     * @return
     */
    Result updateMemberUsername(Member2DTO member2DTO);

    /**
     * 获取安全信息
     *
     * @param account
     * @return
     */
    Result getMemberInfo(String account);

    Result updateMember(Member2DTO memberInDb);

    Result getMemberWallet(Integer id);

    Result updatePwdByMobile(String mobile, String encode);

    Result updateMobile(Member2DTO member2DTO, String oldMobile, String mobile);

    Result getWalletLine(Member2DTO member2DTO, int page, int pageSize, String type);

    Result updateMemberPicture(Member2DTO memberDTO);

    Result getMemberAgent(Integer id);

    Result getMembersByAgent(int id, String username, int page, int pageSize);

    Result getCreditMember(String account, int page, int pageSize, String loginAccount);

    Result getMail(Member2DTO member2DTO, int page, int pageSize);

    Result toCaiYan(String account, int multiple);

    Result getMember(String account, String username, String mobile, String type, int page, int pageSize);


    /**
     * app首页显示今日开户等数量
     */
    Map<String, Object> getIndexNumInfo(String account);


    Result adminLogin(String username, String password);

    Result getSuperMan();

    /**
     * 获取代理的code
     *
     * @param account
     * @return
     */
    Map<String, Object> getAgentCode(String account);

    /**
     * 修改账户备注
     *
     * @param memInfo
     * @return
     */
    Map<String, Object> updateMemberNote(Map memInfo);

    /**
     * 代理查看销售总量
     */
    Map findSalesMoneyInfo(String account, Integer isMonth);

    /**
     * 开户墙
     */
    Map findAccountWall(Integer page, Integer pageSize, String minCount);

    /**
     * 充值墙
     */
    Map findRechargeWall(String account, Integer page, Integer pageSize, String minCount, String username, Integer isConsumer);

    /**
     * 省份证黑名单验证
     *
     * @param certNo
     * @return
     */
    int checkCertNo(String certNo);

    /**
     * 电话黑名单验证
     *
     * @param mobile
     * @return
     */
    int checkMobile(String mobile);

    /**
     * 会员关联代理
     */
    Map memberToAgent(String memberAccount, String agentAccount, String note, String newAgent);

    Map memberMoveLogs(Integer page, Integer pageSize);

    Map findMemberPlan(Integer page, Integer pageSize, String member, String agentAccount);

    Map<String, Object> updatePwd(String account, String password);


    Map<String, Object> saveSmsCode(String mobile, String sRand);

    Map<String, Object> getSmsCode(String mobile);


    Map findAgentInfoByAccount(String account, Integer isMonth);

   /* Map findAgentInfoByAccountBac(String account, Integer isMonth);*/

    Map findMemberAssociation(String agentName, String startDate, String endDate, Integer page, Integer pageSize);

    Map findMemberMove(String agentName, String startDate, String endDate, Integer page, Integer pageSize);

    Map findMemberWalletLine(String agentAccount, String startDate, String endDate,String loginAccount);

    Map findRechargeLine(Map<String, String> mapParam);

    Map findRechargeUnderLine(Map<String, String> mapParam);

    Map findFinancialCashInfo(Integer isMonth);

    Map findFinancialMoneyInfo(Integer isMonth);

    Map findSaleInfo(String agentName, String start_time, String end_time, Integer page, Integer pageSzie, String loginAccount);

    Map<String, Object> relieveBind(String account);

    Map findRechargeAndWitdrawlInfo(String account);

    Map findRoleAndPermission(String account);

    Map addUser(Map<String, Object> map);

    Map findAllRole(Map<String, Object> map);

    Map findAllUserAndRole(Integer integer, Integer page, Integer pageSize);

    Map findAllParentModel(Integer id);

    Map findAllChildModel(Map<String, Object> map, Integer page, Integer pageSize);

    Map addPermission(Map<String, Object> map);

    Map addParentModel(Map<String, Object> map);

    Map addRole(Map<String, Object> map);

    Map addRoleBondPermission(Map<String, Object> map);

    Map MemberAudit(Map map);

    Map MemberMoveAudit(Map map);

    Map<String, Object> getAgentList(int page, int pageSize);

    Map updateUserInfo(Map<String, Object> map);

    Map updateChildModelInfo(Map<String, Object> map);

    Map findChildModelByParent(Integer parentModelId);

    Map delUser(Integer user_id);

    Map<String, Object> setMemberRate(Member2DTO member2DTO, String account, double rate, Integer lotteryType);

    Map<String, Object> getMemberRate(String account);

    Map updateMemberToQD(Integer member_id, String account);

    Map findAllMember(Integer page, Integer pageSize, String start_time, String end_time, String username, String account, String mobile,String realName,String identifyId,String email);

    Map findAllAgentAndQD(Integer page, Integer pageSize, String account);

    Map addAgentToQD(Map<String, Object> map);

    Map<String, Object> updateMemberTicket(String account, int isProviderTicket);

    Map findMemberWalletLineByAccount(Map<String, Object> map);

    Map upgradeAgentToQD(String account);

    Map<String, Object> setKeyClient(Member2DTO member2DTO, String account, int status);

    Map<String, Object> addWhiteCert(String certNo, int status);

    Map<String, Object> getWhiteCert(int page, int pageSize);

    Map findRobotConsume(Integer page, Integer pageSzie);

    Map setAgentPassword(Map params);

    Map updateParentModel(Map<String, Object> map);

    Map setOrUpdateQDtoUser(Map params);

    Map findQDSaleInfo(String qdName, String start_time, String end_date, Integer page, Integer pageSize);

    Map<String,Object> addCelebrity(String[] accounts);

    Map updateMemberInfoBack(Map<String,Object> paramMap);
}
