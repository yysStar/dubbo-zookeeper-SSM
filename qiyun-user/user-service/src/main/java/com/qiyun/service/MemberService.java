package com.qiyun.service;

import com.qiyun.common.GoldCard2;
import com.qiyun.common.Result;
import com.qiyun.commonModel.MemberChargeLine;
import com.qiyun.dto.Member2DTO;
import com.qiyun.dto.SuperGodDTO;
import com.qiyun.model2.Member2;
import com.qiyun.model2.MemberRate2;

import java.util.List;
import java.util.Map;

public interface MemberService {

    Map<String, Object> getHistoryClient(int offset, int pageSize);

    Result updateMemberUsername(Member2DTO member2DTO);

    Result updateMember(Member2DTO member2DTO);

    Result updatePwdByMobile(String mobile, String password);

    Result updateMobile(Member2DTO member2DTO, String oldMobile, String mobile);

    Result updateMemberPicture(Member2DTO memberDTO);

    Result getMembersByAgent(int id, String username, int page, int pageSize);

    Result toCaiYan(String account, int multiple);

    Result getMember(String account, String username, String mobile, String type, int page, int pageSize);

    SuperGodDTO getSuperGod(String account);

    SuperGodDTO getSuperGodN(String account);


    Member2DTO getByAccount(String celebrityName);

    Map<String, Object> updatePwd(String account, String password);

    /**
     * 获取随机用户名
     *
     * @param sj
     * @return
     */
    String genRandomAccount(String sj);

    /**
     * 生成机器人
     *
     * @param member
     */
    int addRobot(Member2 member);

    /**
     * 获取机器人列表
     *
     * @param offset
     * @param pageSize
     * @return
     */
    List<Member2> getRobotList(int offset, int pageSize);

    Member2 getByUserName(String userName);

    Member2 getByMobile(String mobile);

    Member2 getByPlanNo(int planNo);

    int findDrawsNums(String account);

    int updateDrawsNum(String account);

    int addGoldCard(GoldCard2 goldCard2);

    List<GoldCard2> findGoldCard(String s, String startTime, String account);

    int addActivity(Map<String, Object> mapParams);

    int updateActivity(Map<String, Object> mapParams);

    List<Map> findAllActivity();

    int resetDrawsNum();

    int updateGoldCard(GoldCard2 goldCard2);

    int incrementDrawsNum(int i, String account);

    List<Member2> countByExample(String account);

    int presentes(String params, String username);

    List<Member2> getSubordinateMember(Integer memberId);

    Member2 getByCertNo(String certNo);

    void updateMemberSourceId(String provider, int i, Integer memberId);

    int memberToWrite(String account);

    int memberToNoWrite(String account);
}
