package com.qiyun.controller;


import com.github.pagehelper.Page;
import com.qiyun.api.PayApi;
import com.qiyun.api.UserApi;
import com.qiyun.common.Result;
import com.qiyun.controller.base.BaseController;
import com.qiyun.dto.*;
import com.qiyun.util.*;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/pay")
public class PayController extends BaseController {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(PayController.class);
    private final BigDecimal MIN_DRAW_MONEY = BigDecimal.valueOf(10);
    @Resource
    private PayApi payApi;

    @Autowired
    private UserApi userApi;
    private int id;

    /**
     * 获取订单详情
     *
     * @return
     */
    @RequestMapping(value = "/getPayOrder", method = RequestMethod.GET)
    @ResponseBody
    public Result getPayOrder() {
        String id = getStr("id");
        Result result = payApi.getPayOrder(id);
        return result;
    }

    /**
     * 线下提款 生成订单
     */

    @RequestMapping(value = "/createWithdrawalOrder", method = RequestMethod.GET)
    @ResponseBody
    public Map CreateWithdrawalOrder(@RequestParam String token, @RequestParam String bankName, @RequestParam String bankArea,
                                     @RequestParam String bankCard, @RequestParam String realName, @RequestParam String withDrawalMoney, HttpServletRequest request) {
        Map mapInfo = new HashMap();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {

            mapInfo.put(Constants.CODE, Constants.ERROR_CODE_400);
            mapInfo.put(Constants.MSG, "请先登录再进行操作");
            return mapInfo;
        }
        log.info("realName:"+realName);
        log.info("dbName:"+member2DTO.getName());
        //判断填写的 真实姓名 与数据库真实姓名是否一致
        if (!member2DTO.getName().equals(realName)) {
            mapInfo.put(Constants.CODE, Constants.ERROR_CODE_400);
            mapInfo.put(Constants.MSG, "请填写正确的真实姓名,或者进行实名认证");
            return mapInfo;
        }
        //判断银行卡信息
        //1.查找银行卡信息
        MemberInfoDTO memberInfo = userApi.getMemberInfoByAccount(member2DTO.getAccount());

        System.out.println((memberInfo.getBankCard().equals(bankCard)));
        if ((!memberInfo.getBankCard().equals(bankCard)) || bankCard.length() < 15) {
            mapInfo.put(Constants.CODE, Constants.ERROR_CODE_400);
            mapInfo.put(Constants.MSG, "请填写正确的银行卡信息,或者账户未绑定银行卡");
            return mapInfo;
        }
        //判断提款金额
        //获取钱包信息
        MemberWallet2DTO memberWallet = payApi.getMemberWalletByAccount(member2DTO.getAccount());
        BigDecimal bigDecimal = new BigDecimal(withDrawalMoney);

        if (BigDecimal.valueOf(memberWallet.getAbleBalance()).longValue() < bigDecimal.longValue()) {
            mapInfo.put(Constants.CODE, Constants.ERROR_CODE_400);
            mapInfo.put(Constants.MSG, "余额不足,请输入正确的提款金额");
            return mapInfo;
        }
        if (BigDecimal.valueOf(memberWallet.getTakeCashQuota()).longValue() < bigDecimal.longValue()) {

            mapInfo.put(Constants.CODE, Constants.ERROR_CODE_400);
            mapInfo.put(Constants.MSG, "提款金额不能超过可提现金额");
            return mapInfo;
        }
        //判断提款金额是否小于最少提款金额
        if (bigDecimal.longValue() < MIN_DRAW_MONEY.longValue()) {
            mapInfo.put(Constants.CODE, Constants.ERROR_CODE_400);
            mapInfo.put(Constants.MSG, "提款金额不能小于10元");
            return mapInfo;
        }
        //判断当日的提款金额上限
        List<MemberDrawing> list = payApi.findMemberDrawingByAccount(member2DTO.getAccount());
        if (list.size() >= 3) {
            mapInfo.put(Constants.CODE, Constants.ERROR_CODE_400);
            mapInfo.put(Constants.MSG, "当日提款次数已达上限！(每日3次)");
            return mapInfo;
        }
        MemberDrawing drawing = new MemberDrawing();
        drawing.setAccount(member2DTO.getAccount());
        drawing.setAmount(Float.valueOf(NumberTools.round(Double.valueOf(withDrawalMoney), 2) + ""));
        drawing.setBank(bankName);
        drawing.setPartBank(bankArea);
        drawing.setBankCard(bankCard);
        drawing.setId(DateUtil.getNowDateYYYYMMDDHHMMSSSS());
        drawing.setCreateDateTime(new Date());
        drawing.setShowDrawingFee((float) 0);//显示手续费(用户支付)
        drawing.setPrivilegeDrawingFee((float) 0);//优惠手续费(公司负担)
        drawing.setFeePayerBelong(0);
        drawing.setDrawingFee((float) 0);
        //"提款", 0
        drawing.setDrawingType(0);
        //状态为财务待审核
        drawing.setStatus(7);
        //来源 1为web
        drawing.setPlatform(1);
        //保存 请求信息
        MemberOperTrack requestInfo = getRequestInfo(request);
        requestInfo.setAccount(member2DTO.getAccount());
        requestInfo.setOperType(15);
        requestInfo.setCreateDateTime(new Date());

        int operaNumId = payApi.addMemberOperTrack(requestInfo);
        requestInfo.setOPER_LINE_NO(operaNumId);
        if (operaNumId == 0) {
            mapInfo.put(Constants.CODE, Constants.ERROR_CODE_400);
            mapInfo.put(Constants.MSG, "生成流水信息失败,请联系管理员");
            return mapInfo;
        }
        //保存订单信息
        mapInfo = payApi.addWithdrawalOrder(drawing, memberWallet, member2DTO, requestInfo);

        return mapInfo;
    }

    /**
     * @param loginAccount    后台登录账号
     * @param account         账号
     * @param start_time
     * @param end_time
     * @param flow_num        流水号
     * @param is_drawing_time 0 申请时间,1汇款时间
     * @return 提款申请处理
     */
    @RequestMapping("/findMemberDrawingList")
    @ResponseBody
    public Result findMemberDrawingList(@RequestParam String loginAccount, @RequestParam String account, @RequestParam String start_time,
                                        @RequestParam String end_time, @RequestParam String flow_num, @RequestParam(defaultValue = "0") String is_drawing_time, @RequestParam(defaultValue = "0") Integer status,
                                        @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        Result map = payApi.findMemberDrawingList(loginAccount, account, start_time, end_time, flow_num, is_drawing_time, page, pageSize, status);
        return map;
    }

    //设置操作流水
    public MemberOperTrack getRequestInfo(HttpServletRequest request) {
        MemberOperTrack memberOperTrack = new MemberOperTrack();
        //请求路径
        StringBuffer requestURL = request.getRequestURL();
        memberOperTrack.setReferer(requestURL.toString());
        //请求方法
        String requestURI = request.getRequestURI();
        memberOperTrack.setUrl(requestURI);
        //请求ip
        String ipAddress = IpAdrressUtil.getIpAddress(request);
        memberOperTrack.setIp(ipAddress);

        return memberOperTrack;
    }

    /**
     * 提款申请通过
     * status 0 不通过 1通过
     */
    @RequestMapping("/memberDrawingReview")
    @ResponseBody
    public Map memberDrawingReview(@RequestParam String drawingId, @RequestParam Integer status,@RequestParam String account,@RequestParam String remark,@RequestParam Integer returnRemark) {
        Map paramMap  = new HashMap();
        paramMap.put("drawingId",drawingId);
        paramMap.put("status",status);
        paramMap.put("account",account);
        paramMap.put("remark",remark);
        paramMap.put("returnRemark",returnRemark);
        Map result = payApi.memberDrawingReview(paramMap);

        return result;
    }

    /**
     * 充值补单
     *
     * @param chargeNo
     * @param memberId
     * @param amount
     * @return
     */
    @RequestMapping(value = "/chargeFix")
    @ResponseBody
    public Map chargeFix(@RequestParam String chargeNo, @RequestParam String amount, @RequestParam String memberId) {
        Map paramsMap = new HashMap();
        paramsMap.put("amount", amount);
        paramsMap.put("payedNo", chargeNo);
        paramsMap.put("memberId", memberId);
        Map<String, Object> map = payApi.chargeFix(paramsMap);
        return map;
    }

    /**
     * 查询出所有
     */
    @RequestMapping(value = "/getAllFailPayOrder")
    @ResponseBody
    public Map getAllFailPayOrder(@RequestParam String account, @RequestParam String startTime, @RequestParam String endTime, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        Map paramsMap = new HashMap();
        paramsMap.put("account", account);
        paramsMap.put("startTime", startTime);
        paramsMap.put("endTime", endTime);
        Map<String, Object> map = payApi.getAllFailPayOrder(paramsMap, page, pageSize);
        return map;
    }

    /**
     * 冲正功能
     */

    @RequestMapping(value = "/chargeRight")
    @ResponseBody
    public Map chargeRight(@RequestParam String account, @RequestParam double amount, @RequestParam String des) {
        Map paramsMap = new HashMap();
        paramsMap.put("account", account);
        paramsMap.put("amount", amount);
        paramsMap.put("desc", des);
        Map<String, Object> map = payApi.chargeRight(paramsMap);
        return map;
    }
}
