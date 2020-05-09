package com.qiyun.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSErrorCode;
import com.qiyun.api.UserApi;
import com.qiyun.common.Result;
import com.qiyun.controller.base.BaseController;
import com.qiyun.dto.*;
import com.qiyun.httpUtil.RedisUtil;
import com.qiyun.model2.Permission;
import com.qiyun.tools.DateTools;
import com.qiyun.util.*;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.htmlparser.tags.Bullet;
import org.omg.CORBA.INTERNAL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import redis.clients.jedis.Jedis;
import sun.awt.geom.AreaOp;
import sun.security.krb5.internal.PAData;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    //阿里云API的内或外网域名
    private static String ENDPOINT;
    //阿里云API的密钥Access Key ID
    private static String ACCESS_KEY_ID;
    //阿里云API的密钥Access Key Secret
    private static String ACCESS_KEY_SECRET;
    //阿里云API的bucket名称
    private static String BACKET_NAME;
    //阿里云API的文件夹名称
    private static String FOLDER;

    //初始化属性
    static {
        ENDPOINT = OSSClientConstants.ENDPOINT;
        ACCESS_KEY_ID = OSSClientConstants.ACCESS_KEY_ID;
        ACCESS_KEY_SECRET = OSSClientConstants.ACCESS_KEY_SECRET;
        BACKET_NAME = OSSClientConstants.BACKET_NAME;
        FOLDER = OSSClientConstants.FOLDER;
    }

    @Resource
    private UserApi userApi;

    /**
     * 发单名人
     * @return
     */
    @RequestMapping(value = "/addCelebrity", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> addCelebrity(String[] accounts){
        return userApi.addCelebrity(accounts);
    }

    /**
     * 获取白名单身份证号
     * @return
     */
    @RequestMapping(value = "/getWhiteCert", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getWhiteCert(){
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        return userApi.getWhiteCert(page,pageSize);
    }

    /**
     * 添加/删除身份证白名单
     * @return
     */
    @RequestMapping(value = "/addWhiteCert", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> addWhiteCert(){
        Map<String,Object> map = new HashMap<String,Object>();
        String certNo = request.getParameter("certNo");
        int status = getInt("status", 1);
        return userApi.addWhiteCert(certNo,status);
    }

    /**
     * 设置/取消重点客户
     * @return
     */
    @RequestMapping(value = "/setKeyClient", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> setKeyClient(){
        Map<String,Object> map = new HashMap<String,Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_401);
            map.put(Constants.MSG,Constants.ERROR_MSG_401);
            return map;
        }
        String account = request.getParameter("account");
        int status = getInt("status", 1);
        return userApi.setKeyClient(member2DTO,account,status);
    }

    /**
     * 修改会员出票
     * @return
     */
    @RequestMapping(value = "/updateMemberTicket", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> updateMemberTicket(){
        String account = request.getParameter("account");
        int isProviderTicket = getInt("isProviderTicket");
        return userApi.updateMemberTicket(account,isProviderTicket);
    }

    /**.
     * 获取返点
     * @return
     */
    @RequestMapping(value = "/getMemberRate", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getMemberRate(){
        String account = request.getParameter("account");
        return userApi.getMemberRate(account);
    }

    /**.
     * 设置返点
     * @return
     */
    @RequestMapping(value = "/setMemberRate", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> setMemberRate(){
        Map<String,Object> map = new HashMap<String,Object>();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_401);
            map.put(Constants.MSG,Constants.ERROR_MSG_401);
            return map;
        }
        int lotteryType = getInt("lotteryType");
        String account = request.getParameter("account");
        String rate = request.getParameter("rate");
        return userApi.setMemberRate(member2DTO,account,Double.parseDouble(rate),lotteryType);
    }

    /**.
     * 获取有效代理列表
     * @return
     */
    @RequestMapping(value = "/getAgentList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAgentList(){
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        return userApi.getAgentList(page,pageSize);
    }

    /**
     * 解绑银行卡
     * @return
     */
    @RequestMapping(value = "/relieveBind", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> relieveBind(){
        String account = request.getParameter("account");
        return  userApi.relieveBind(account);
    }

    /**
     * 获取当前版本号
     * @return
     */
    @RequestMapping(value = "/getVersion", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> getVersion(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("version","1.0");
        return map;
    }

    /**
     * 获取短信验证码
     * @return
     */
    @RequestMapping(value = "/getSmsCode", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSmsCode() {
        String mobile = request.getParameter("mobile");
        Map<String,Object> map = userApi.getSmsCode(mobile);

        return map;
    }

    /**
     * 后台重置密码
     *
     * @return
     */
    @RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> resetPassword() {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Map<String,Object> map = userApi.updatePwd(account,password);

        return map;
    }

    /**
     * 超级大神
     *
     * @return
     */
    @RequestMapping(value = "/getSuperMan", method = RequestMethod.GET)
    @ResponseBody
    public Result getSuperMan() {
        Result result = new Result();
        result = userApi.getSuperMan();
        return result;
    }

    /**
     * 后台登录
     *
     * @return
     */
    @RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
    @ResponseBody
    public Result adminLogin() {
        Result result = new Result();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        result = userApi.adminLogin(username, password);
        return result;
    }

    /**
     * 条件查询会员
     *
     * @return
     */
    @RequestMapping(value = "/getMember", method = RequestMethod.GET)
    @ResponseBody
    public Result getMember() {
        Result result = new Result();
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        String account = request.getParameter("account");
        String username = request.getParameter("username");
        String mobile = request.getParameter("mobile");
        String type = request.getParameter("type");
        result = userApi.getMember(account, username, mobile, type, page, pageSize);
        return result;
    }

    /**
     * 设置为彩研人员
     *
     * @return
     */
    @RequestMapping(value = "/toCaiYan", method = RequestMethod.GET)
    @ResponseBody
    public Result toCaiYan() {
        Result result = new Result();
        String account = request.getParameter("account");
        int multiple = getInt("multiple", 1);
        if (StringUtils.isNullOrBlank(account)) {
            result.setSuccess(false);
            result.setMsg("用户名不能为空");
            return result;
        }
        result = userApi.toCaiYan(account, multiple);
        return result;
    }

    /**
     * 获取站内信
     *
     * @return
     */
    @RequestMapping(value = "/getMail", method = RequestMethod.GET)
    @ResponseBody
    public Result getMail() {
        Result result = new Result();
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        }
        result = userApi.getMail(member2DTO, page, pageSize);
        return result;
    }

    /**
     * 获取代理
     *
     * @return
     */
    @RequestMapping(value = "/getCreditMember", method = RequestMethod.GET)
    @ResponseBody
    public Result getCreditMember() {
        Result result = new Result();
        String account = request.getParameter("account");
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        String loginAccount = request.getParameter("loginAccount");
        result = userApi.getCreditMember(account, page, pageSize,loginAccount);
        return result;

    }

    /**
     * 获取代理名下会员
     *
     * @return
     */
    @RequestMapping(value = "/getMembersByAgent", method = RequestMethod.GET)
    @ResponseBody
    public Result getMembersByAgent() {
        Result result = new Result();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        }
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        String username = request.getParameter("username");
        result = userApi.getMembersByAgent(member2DTO.getId(), username, page, pageSize);
        return result;
    }

    /**
     * 获取代理信息
     *
     * @return
     */
    @RequestMapping(value = "/getMemberAgent", method = RequestMethod.GET)
    @ResponseBody
    public Result getMemberAgent() {
        Result result = new Result();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        }
        result = userApi.getMemberAgent(member2DTO.getId());
        return result;
    }

    /**
     * 修改用户头像
     *
     * @return
     */
    @RequestMapping(value = "/updateMemberPicture", method = RequestMethod.POST)
    @ResponseBody
    public Result updateMemberPicture(MultipartFile QRCode) {
        Result result = new Result();

        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        }
        if (QRCode == null) {
            result.setSuccess(false);
            result.setMsg("数据错误");
            return result;
        }
        //判断是不是第一次上传头像
        if (!member2DTO.getPicture().startsWith("avatar")){
            result.setSuccess(false);
            result.setMsg("头像已经上传,不能再次上传");
            return result;
        }
        //初始化OSSClient
        OSSClient ossClient = AliyunOSSClientUtil.getOSSClient();
        CommonsMultipartFile cf = (CommonsMultipartFile) QRCode;
        //这个myfile是MultipartFile的
        DiskFileItem fi = (DiskFileItem) cf.getFileItem();
        File file = fi.getStoreLocation();
        String fileName = fi.getName();

        if (file != null && !"".equals(file)) {
            int lastIndexOf = fileName.lastIndexOf(".");
            String houzhui = fileName.substring(lastIndexOf);
            String imgFileName = DateTools.getNowDateYYYYMMDDHHMMSSSS();

            if ("avatar0.png".equals(member2DTO.getPicture()) || "avatar1.png".equals(member2DTO.getPicture()) || "avatar2.png".equals(member2DTO.getPicture())
                    || "avatar3.png".equals(member2DTO.getPicture()) || "avatar4.png".equals(member2DTO.getPicture()) || "avatar5.png".equals(member2DTO.getPicture())
                    || "avatar6.png".equals(member2DTO.getPicture()) || "avatar7.png".equals(member2DTO.getPicture()) || "avatar8.png".equals(member2DTO.getPicture())) {

            } else {
                AliyunOSSClientUtil.deleteFile(ossClient, BACKET_NAME, FOLDER, member2DTO.getPicture());
            }


            AliyunOSSClientUtil.uploadObject2OSS(ossClient, file, imgFileName + houzhui, BACKET_NAME, FOLDER);
            member2DTO.setPicture(imgFileName + houzhui);
            result = userApi.updateMemberPicture(member2DTO);
        }

        return result;
    }

    /**
     * 资金明细
     *
     * @return
     */
    @RequestMapping(value = "/getWalletLine", method = RequestMethod.GET)
    @ResponseBody
    public Result getWalletLine() {
        Result result = new Result();
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        String type = request.getParameter("type");
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        }
        result = userApi.getWalletLine(member2DTO, page, pageSize, type);
        return result;
    }

    /**
     * 修改手机号
     *
     * @return
     */
    @RequestMapping(value = "/updateMobile", method = RequestMethod.GET)
    @ResponseBody
    public Result updateMobile() {
        Result result = new Result();
        String mobile = request.getParameter("mobile");
        String oldMobile = request.getParameter("oldMobile");
        String msgCode = request.getParameter("msgCode");

        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        }
        Jedis jedis = RedisUtil.getJedis();
        String code = jedis.get(Constants.SMS_AUTH_CODE + mobile);
        if (code == null) {
           result.setSuccess(false);
           result.setMsg("验证码已失效,请重新获取!");
           return result;
        }
        //校验短信验证码
        if (msgCode == null) {
            result.setSuccess(false);
            result.setMsg("验证码不能为空!");
            return result;
        } else if (!msgCode.equals(code)) {
            result.setSuccess(false);
            result.setMsg("输入验证码有误!");
            return result;
        }
        jedis.close();
        result = userApi.updateMobile(member2DTO,oldMobile,mobile);
        return result;
    }

    /**
     * 忘记密码
     *
     * @return
     */
    @RequestMapping(value = "/updatePwdByMobile", method = RequestMethod.GET)
    @ResponseBody
    public Result updatePwdByMobile() {
        Result result = new Result();
        String mobile = request.getParameter("mobile");
        String msgCode = request.getParameter("msgCode");
        String password = request.getParameter("password");
       /* String codeInSession = (String) session.getAttribute(Constants.SMS_AUTH_CODE);
        if (!msgCode.equals(codeInSession)) {
            result.setSuccess(false);
            result.setMsg("验证码错误");
            return result;
        }*/
        Jedis jedis = RedisUtil.getJedis();
        String code = jedis.get(Constants.SMS_AUTH_CODE + mobile);
//                    (String) session.getAttribute(Constants.SMS_AUTH_CODE);
        if (code == null) {
            result.setMsg("验证码已失效,请重新获取!");
            result.setSuccess(false);
            return result;
        }
        //校验短信验证码
        if (msgCode == null) {
            result.setMsg("验证码不能为空!");
            result.setSuccess(false);
            return result;
        } else if (!msgCode.equals(code)) {
            result.setMsg("输入验证码有误!");
            result.setSuccess(false);
            return result;
        }
        jedis.close();
        result = userApi.updatePwdByMobile(mobile, MD5.encode(password));
        return result;
    }

    /**
     * 修改昵称
     *
     * @return
     */
    @RequestMapping(value = "/updateUsername", method = RequestMethod.GET)
    @ResponseBody
    public Result updateUsername() {
        Result result = new Result();
        Member2DTO member2DTO = checkLogin();
        String username = request.getParameter("username");
        LogUtil.info("username:"+username);
        // 判断用户名长度是否合法
        if (StringUtils.length(username) < 4 || StringUtils.length(username) > 12) {
            result.setSuccess(false);
            result.setMsg("用户名格式有误!");
            return result;
        }
        // 判断用户名是否包含特殊字符
        if (StringUtils.isConSpeCharacters(username)) {
            result.setSuccess(false);
            result.setMsg("用户名格式有误!");
            return result;
        }

        String substring = username.substring(0, 2);
        if ("sj".equals(substring)) {
            result.setSuccess(false);
            result.setMsg("用户名不能以sj开头");
            return result;
        }
        boolean flag = username.matches("[0-9]+");
        if (flag) {
            result.setSuccess(false);
            result.setMsg("用户名不能为纯数字");
            return result;
        }
        if (member2DTO == null) {
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        }
        member2DTO.setUsername(username);
        result = userApi.updateMemberUsername(member2DTO);
        return result;
    }

    /**
     * 获取用户安全信息
     *
     * @return
     */
    @RequestMapping(value = "/getMemberInfo", method = RequestMethod.GET)
    @ResponseBody
    public Result getMemberInfo() {
        Result result = new Result();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        }
        result = userApi.getMemberInfo(member2DTO.getAccount());
        return result;
    }

    /**
     * 更新密码
     *
     * @return
     */
    @RequestMapping(value = "/updatePwdSave", method = RequestMethod.GET)
    @ResponseBody
    public Result updatePwdSave() {
        Result result = new Result();
        String oldPwd = request.getParameter("oldPwd");
        String password = request.getParameter("password");
        String passwordConfirm = request.getParameter("passwordConfirm");


        if (StringUtils.isNullOrBlank(oldPwd)) {
            result.setMsg("服务中断!");
            result.setSuccess(false);
            return result;
        }

        if (StringUtils.isNullOrBlank(password) || password.length() < 6 || password.length() > 15) {
            result.setMsg("服务中断!");
            result.setSuccess(false);
            return result;
        }

        if (!password.equals(passwordConfirm)) {
            result.setMsg("服务中断!");
            result.setSuccess(false);
            return result;
        }

        if (!password.equals(passwordConfirm)) {
            result.setMsg("两次密码输入不匹配");
            result.setSuccess(false);
            return result;
        }

        Member2DTO memberInSession = checkLogin();
        if (memberInSession == null) {
            result.setMsg("您还没有登录");
            result.setSuccess(false);
            return result;
        }
        Member2DTO memberInDb = userApi.getMemberByAccount(memberInSession.getAccount());

        if (!memberInDb.getPassword().equals(MD5.encode(oldPwd))) {
            result.setMsg("原密码错误!");
            result.setSuccess(false);
            return result;
        }

        memberInDb.setPassword(MD5.encode(password));
        result = userApi.updateMember(memberInDb);

        return result;
    }


    /**
     * 绑定银行卡
     * 1 为前台 0为后台
     * @return
     */
    @RequestMapping(value = "/bind", method = RequestMethod.GET)
    @ResponseBody
    public Result bind(@RequestParam(defaultValue = "1") String is_back) {
        Result result = new Result();
        Member2DTO member2DTO=null;
        String account =null;
        if (!is_back.equals("0")) {
           member2DTO = checkLogin();
            if (member2DTO == null) {
                result.setMsg("您还没有登录");
                result.setSuccess(false);
                return result;
            }
            account = member2DTO.getAccount();
        }else {
            account =request.getParameter("account");
        }
        member2DTO = userApi.getMember2ByAccount(account);
        MemberInfoDTO memberInfoDTO = userApi.getMemberInfoByAccount(member2DTO.getAccount());
        String[] filedNameArr = new String[]{};
        String province = request.getParameter("province");
        String city = request.getParameter("city");
        String realName = request.getParameter("realName");
        String zfbAccount = request.getParameter("zfbAccount");
        String bank = request.getParameter("bank");
        String bankPart = request.getParameter("bankPart");
        String bank_type = request.getParameter("bank_type");
        String bankCard = request.getParameter("bankCard");
        String certNo = request.getParameter("certNo");
        if (member2DTO.getCertNo() == null) {
            result.setMsg("您尚未绑定身份证信息，请先绑定身份证!");
            result.setSuccess(false);
            return result;
        }

        if (memberInfoDTO != null) {
            if (memberInfoDTO.getBankCard() != null && memberInfoDTO.getBankCard().length() > 0) {
                result.setMsg("您已经绑定过银行卡，要更改绑定卡号请联系在线客服!");
                result.setSuccess(false);
                return result;
            }
        }

        if (bank_type == null || "".equals(bank_type)) {
            result.setMsg("数据不能为空");
            result.setSuccess(false);
            return result;
        }
        if (bank == null || "".equals(bank)) {
            bankCard = null;
            result.setMsg("数据不能为空");
            result.setSuccess(false);
            return result;
        }
        if (bankCard == null || "".equals(bankCard)) {
            result.setMsg("数据不能为空");
            result.setSuccess(false);
            return result;
        }

        if ("其他银行".equals(bank)) {
            if (bankPart == null || "".equals(bankPart)) {
                bankCard = null;
                result.setMsg("数据不能为空");
                result.setSuccess(false);
                return result;
            }
        }

        if (!member2DTO.getName().equals(realName)) {
            result.setMsg("真实姓名错误!");
            result.setSuccess(false);
            return result;
        }

        if (!member2DTO.getCertNo().equals(certNo)) {
            result.setMsg("身份证号码错误!");
            result.setSuccess(false);
            return result;
        }

		/*
		boolean ret = this.memberService.login(memberInSession.getAccount(), password);
		if (!ret) {
			bankCard = null;
			super.errorMessage = "密码错误!";
			return INPUT;
		}
		//*/

        memberInfoDTO.setBank(bank);
        memberInfoDTO.setBankCard(bankCard);
        memberInfoDTO.setBankPart(province + "|" + city + "|" + bankPart);// province+"|"+city+"|"+bankPart
        result = userApi.updateMemberInfo(memberInfoDTO);

        return result;
    }


    /**
     * 绑定身份证信息
     *
     * @return
     */
    @RequestMapping(value = "/bindCertNoSave", method = RequestMethod.GET)
    @ResponseBody
    public Result bindCertNoSave() {
        Result result = new Result();
        String certNo = request.getParameter("certNo");
        String realName = request.getParameter("realName");

        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        }
        //去黑名单查看这个身份证是否在里面
        int i = userApi.checkCertNo(certNo);
        if (i>0){
            result.setSuccess(false);
            result.setMsg("绑定失败");
            return result;

        }
        if (certNo == null || !(certNo.length() == 15 || certNo.length() == 18)) {
            result.setSuccess(false);
            result.setMsg("错误的请求!");
            return result;
        }

        //身份证>18岁验证
        boolean isRightCertNo = CertNoUtil.isIdentityId(certNo);
        if (!isRightCertNo) {
            result.setSuccess(false);
            result.setMsg("身份证验证错误!");
            return result;
        }
        String birthDateStr = CertNoUtil.getBirthDate(certNo);
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateTools.stringToDate(birthDateStr, "yyyy-MM-dd"));
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + 18);
        if (new Date().before(cal.getTime())) {
            result.setSuccess(false);
            result.setMsg("年龄小于18岁!");
            return result;
        }
        result = userApi.bindCertNoSave(certNo, realName, member2DTO);
        return result;
    }

    /**
     * 退出
     *
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public Result logout() {
        Result result = new Result();
        Jedis jedis = RedisUtil.getJedis();

        String token = request.getParameter("token");
        jedis.del(token);
        jedis.close();
        result.setSuccess(true);
        result.setMsg("已退出");
        return result;
    }


    /**
     * 获取钱包信息
     *
     * @return
     */
    @RequestMapping(path = "/getMemberWallet", method = RequestMethod.GET)
    @ResponseBody
    public Result getMemberWallet() {
        Result result = new Result();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            result.setSuccess(false);
            result.setMsg("您还没有登录");
        } else {
            result = userApi.getMemberWallet(member2DTO.getId());
        }
        return result;
    }

    /**
     * 获取钱包信息
     *
     * @return
     */
    @RequestMapping(path = "/getMemberWalletByMemberId", method = RequestMethod.GET)
    @ResponseBody
    public Result getMemberWalletByMemberId(Integer memberId) {
        Result result ;

            result = userApi.getMemberWallet(memberId);

        return result;
    }

    /**
     * 获取登录信息
     *
     * @return
     */
    /*@RequestMapping(path = "/checkLogin", method = RequestMethod.GET)
    @ResponseBody
    public Result getLoginMessage() {
        Result result = new Result();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO == null) {
            result.setSuccess(false);
            result.setMsg("您还没有登录");
        } else {
            result.setSuccess(true);
            result.setData(member2DTO);
        }
        return result;
    }*/

    /**
     * 登录
     *
     * @return
     */
   /* @RequestMapping(path = "/login", method = RequestMethod.GET)*/
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Result login() {
        Jedis jedis = RedisUtil.getJedis();
        String account = request.getParameter("username");
        String password = request.getParameter("password");
        String authCode = request.getParameter("authCode");
        String isSaveUserName = request.getParameter("isSaveUserName");
        String needAuthCode = request.getParameter("needAuthCode");
        Result result = new Result();
        if (StringUtils.isNullOrBlank(account)) {
            result.setSuccess(false);
            result.setMsg("用户名不能为空");
            return result;
        }
        if (StringUtils.isNullOrBlank(password)) {
            result.setSuccess(false);
            result.setMsg("密码不能为空");
            return result;
        }

        Object verCode = session.getAttribute("verCode");

        if ("1".equals(needAuthCode)) {
            if (verCode == null) {
                result.setSuccess(false);
                result.setMsg("请生成验证码");
                return result;
            }
            if (!verCode.toString().equals(authCode)) {
                result.setSuccess(false);
                result.setMsg("验证码错误");
                return result;
            }
        }

        logger.info("----登录:account:"+account+",password:"+password);

        //登录
        result = userApi.login(account, password);
        if (!result.isSuccess()) {
            return result;
        }
        logger.info("----account:"+account+"登录成功");
        //将token写入cookie
        String token = UUID.randomUUID().toString().replace("-", "");
        result.setToken(token);
        try {
            CookieUtils.addCookie(request, response, Constants.TOKEN, token, 60 * 60 * 24 * 7);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

        }
        //将信息存入redis
        String json = JSON.toJSONString(result.getData());
        jedis.setex(token, 604800, json);
        jedis.close();

        if ("1".equals(isSaveUserName)) {
            //自动保存用户名
            try {
                CookieUtils.addCookie(request, response, Constants.USER_NAME, account, 60 * 60 * 24 * 7);
            } catch (UnsupportedEncodingException e) {
                logger.info("用户名:" + account + " 记住用户名发生错误");
            }
        } else {
            CookieUtils.deleteCookie(request, response, Constants.USER_NAME);
        }

        result.setSuccess(true);
        result.setMsg("登录成功");
        return result;

    }

    /**
     * 修改用户信息（暂时只支持白名单修改）
     *
     * @return
     */
    @RequestMapping(path = "/updateUser", method = RequestMethod.GET)
    public Map<String, Object> updateUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        int isWhitelist = getInt("isWhitelist", 0);
        String userName = request.getParameter("userName");
        if (userName == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_1);
            map.put(Constants.MSG, Constants.ERROR_MSG_1_6);
            return map;
        }
        if (isWhitelist != 0) {
            reqMap.put("isWhitelist", isWhitelist);
            reqMap.put("userName", userName);
            map = userApi.updateUser(reqMap);
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        return map;
    }

    /**
     * 修改用户白名单时间
     * userName为表中的account字段
     *
     * @return
     */
    @RequestMapping(path = "/updateUserToWriteTime", method = RequestMethod.GET)
    public Map<String, Object> updateUserToWriteTime() {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        Date tobeWriteTime = new Date();
        String userName = request.getParameter("userName");
        if (userName == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_1);
            map.put(Constants.MSG, Constants.ERROR_MSG_1_6);
            return map;
        }
        if (tobeWriteTime != null) {
            reqMap.put("tobeWriteTime", tobeWriteTime);
            reqMap.put("userName", userName);
            map = userApi.updateUserToWrite(reqMap);
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        return map;
    }

    /**
     * 校验手机号，用户名是否可用
     *
     * @return
     */
    @RequestMapping(path = "/checkNum", method = RequestMethod.GET)
    public Map<String, Object> checkNum() {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        String userName = request.getParameter("userName");
        String mobile = request.getParameter("mobile");
        if (StringUtils.isNullOrBlank(mobile) && StringUtils.isNullOrBlank(userName)) {
            map.put(Constants.CODE, Constants.ERROR_CODE_1);
            map.put(Constants.MSG, Constants.ERROR_MSG_1_4);
            return map;
        }
        map = checkUserName(userName);
        if (Constants.SUCCESS_CODE != Integer.parseInt(map.get(Constants.CODE).toString())) {
            return map;
        }
        if (!StringUtils.isNullOrBlank(mobile) && !StringUtils.checkCellphone(mobile)) {
            map.put(Constants.CODE, Constants.ERROR_CODE_1);
            map.put(Constants.MSG, Constants.ERROR_MSG_1_1);
            return map;
        }
        reqMap.put("userName", userName);
        reqMap.put("mobile", mobile);
        map = userApi.checkNum(reqMap);
        return map;
    }

    /**
     * 生成图形验证码
     *
     * @return
     */
    @RequestMapping(value = "/generateCheckCode", method = RequestMethod.GET)
    public Map<String, Object> generateCheckCode() {
//        response.setHeader("Pragma", "No-cache");
//        response.setHeader("Cache-Control", "no-cache");
//        response.setDateHeader("Expires", 0);
//        response.setContentType("image/jpeg");
        Map<String,Object> map = new HashMap<String, Object>();
        int w = getInt("w",70);
        int h = getInt("h",30);
        int i = getInt("i", 0);

        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
//        if (BizConstants.isOpenCache()) {
//            String verifyCodeKey = RedisKeyUtils.genCouponVerifyCode(getLoginUser().getUserId());
//            RedisUtil.set(verifyCodeKey, verifyCode,90);//90秒 1分半钟
//
//        }else{
        //删除以前的
        session.removeAttribute(Constants.VER_CODE);
        session.setAttribute(Constants.VER_CODE, verifyCode.toLowerCase());
//        }
        //生成图片
        try {
//            VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
            String imageString = VerifyCodeUtils.outputBASE64(w, h, verifyCode);
            map.put("imageString", imageString);
        } catch (IOException e) {
            logger.error("生成图片验证码失败", e);
            map.put(Constants.CODE, Constants.ERROR_CODE_1);
            map.put(Constants.MSG, Constants.ERROR_MSG_3_4);
            return map;
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        if(i != 0){
            map.put("verifyCode", verifyCode);
        }
        return map;
    }

    /**
     * 获取短信验证码
     *
     * @return
     */
    @RequestMapping(value = "/getMsgCode", method = RequestMethod.GET)
    public Map<String,Object> getMsgCode() {
        session = request.getSession(false);
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> reqMap = new HashMap<String, Object>();
//        String code = getStr("code");
        String mobile = getStr("mobile");
        // 操作类型 2用户注册，13忘记密码
        int type = getInt("type", 2);
        //间隔时间默认为60秒
        int sendInterval = getInt("sendInterval", 60);
        if (mobile == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_1);
            map.put(Constants.MSG, Constants.ERROR_MSG_1_5);
            return map;
        }
//        if (code == null) {
//            map.put(Constants.CODE, Constants.ERROR_CODE_1);
//            map.put(Constants.MSG, Constants.ERROR_MSG_3_1);
//            return map;
//        }
//        if (session.getAttribute(Constants.VER_CODE) == null) {
//            map.put(Constants.CODE, Constants.ERROR_CODE_3);
//            map.put(Constants.MSG, Constants.ERROR_MSG_3_2);
//            return map;
//        }
        // 去掉图片验证
//        if (!code.toLowerCase().equals(session.getAttribute(Constants.VER_CODE))) {
//            map.put(Constants.CODE, Constants.ERROR_CODE_3);
//            map.put(Constants.MSG, Constants.ERROR_MSG_3_3);
//            return map;
//        }
        Map<String, Long> lastSendTimeMap =
                (HashMap<String, Long>) session.getAttribute("lastSendTime");
        Long lastSendTime = null;

        if (lastSendTimeMap != null) {
            lastSendTime = lastSendTimeMap.get(type + "");
        } else {
            lastSendTimeMap = new HashMap<String, Long>();
        }
        if (lastSendTime != null &&
                System.currentTimeMillis() - lastSendTime.longValue() < sendInterval * 1000) {
            map.put(Constants.CODE, Constants.SMS_ERROR_CODE);
            map.put(Constants.MSG, Constants.SMS_ERROR_CODE_1);
            return map;
        }
        reqMap.put("mobile", mobile);
        reqMap.put("type", type);
        map = userApi.getSmsNotify(reqMap);
        if (Integer.parseInt(map.get(Constants.CODE).toString()) == Constants.SUCCESS_CODE) {
            String sRand = (String) map.get("sRand");
            Map<String,Object> map2 = userApi.saveSmsCode(mobile,sRand);
//            session.setAttribute(Constants.SMS_AUTH_CODE, sRand);
            Jedis jedis = RedisUtil.getJedis();
            jedis.set(Constants.SMS_AUTH_CODE + mobile, sRand);
            jedis.close();
            //删除图片验证码信息
//            session.removeAttribute("verCode");
//            session.setAttribute("verCode", null);
//            lastSendTimeMap.put(type + "", new Long(System.currentTimeMillis()));
//            session.setAttribute("lastSendTime", lastSendTimeMap);
        }
        return map;
    }

    /**
     * 注册接口
     *
     * @return
     */
    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public Map<String, Object> register() {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        String mobile = getStr("mobile");
        String password = getStr("password");
        String passwordConfirm = getStr("passwordConfirm");
        String msgCode = getStr("msgCode");
        String activeCode = getStr("activeCode");
        String name = request.getParameter("name");
        String certNo = request.getParameter("certNo");
        int isTest = getInt("isTest", 0);
        String account = request.getParameter("account");

        try {
            int age = IDCardUtil.getAge(certNo);
            if (age<18){
                map.put(Constants.CODE, Constants.ERROR_CODE_432);
                map.put(Constants.MSG, Constants.ERROR_MSG_432);
                return map;
            }
            boolean b = IDCardUtil.VerifyIDCard(certNo);
            if (!b){
                map.put(Constants.CODE, Constants.ERROR_CODE_433);
                map.put(Constants.MSG, Constants.ERROR_MSG_433);
                return map;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //判断该手机号是否存在黑名单
        int  i = userApi.checkMobile(mobile);
        if (i>0){
            map.put(Constants.CODE,Constants.ERROR_CODE_1);
            map.put(Constants.MSG,"注册失败");
            return  map;
        }
        if (StringUtils.isNullOrBlank(mobile) || !StringUtils.checkCellphone(mobile)) {
            map.put(Constants.CODE, Constants.ERROR_CODE_1);
            map.put(Constants.MSG, Constants.ERROR_MSG_1_1);
            return map;
        }

        Jedis jedis = RedisUtil.getJedis();
        if (isTest == 0) {
            String code = jedis.get(Constants.SMS_AUTH_CODE + mobile);
//                    (String) session.getAttribute(Constants.SMS_AUTH_CODE);
            if (code == null) {
                map.put(Constants.CODE, Constants.ERROR_CODE_4);
                map.put(Constants.MSG, Constants.ERROR_MSG_4_3);
                return map;
            }
            //校验短信验证码
            if (msgCode == null) {
                map.put(Constants.CODE, Constants.ERROR_CODE_4);
                map.put(Constants.MSG, Constants.ERROR_MSG_4_1);
                return map;
            } else if (!msgCode.equals(code)) {
                map.put(Constants.CODE, Constants.ERROR_CODE_4);
                map.put(Constants.MSG, Constants.ERROR_MSG_4_2);
                return map;
            }
        }
        jedis.close();
        //判断密码是否合法
        if (StringUtils.isNullOrBlank(password) || password.length() < 6
                || password.length() > 15) {
            map.put(Constants.CODE, Constants.ERROR_CODE_1);
            map.put(Constants.MSG, Constants.ERROR_MSG_1_3);
            return map;
        }
        if (!password.equals(passwordConfirm)) {
            map.put(Constants.CODE, Constants.ERROR_CODE_1);
            map.put(Constants.MSG, Constants.ERROR_MSG_1_3);
            return map;
        }

        reqMap.put("password", password);
        reqMap.put("mobile", mobile);
        reqMap.put("sign", this.getTerminalID());
        reqMap.put("activeCode", activeCode);
        reqMap.put("certNo", certNo);
        reqMap.put("name", name);
        reqMap.put("account", account);
        map = userApi.register(reqMap);
        if (Integer.parseInt(map.get(Constants.CODE).toString()) == Constants.SUCCESS_CODE) {
            //设置验证码过期
            session.setAttribute(Constants.SMS_AUTH_CODE, null);
        }
        return map;
    }

    /**
     * 校验用户名是否合法
     *
     * @param userName
     * @return
     */
    private Map<String, Object> checkUserName(String userName) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (!StringUtils.isNullOrBlank(userName)) {
            // 判断用户名长度是否合法
            if (StringUtils.length(userName) < 4 || StringUtils.length(userName) > 12) {
                map.put(Constants.CODE, Constants.ERROR_CODE_1);
                map.put(Constants.MSG, Constants.ERROR_MSG_1_2);
                return map;
            }
            // 判断用户名是否包含特殊字符
            if (StringUtils.isConSpeCharacters(userName)) {
                map.put(Constants.CODE, Constants.ERROR_CODE_1);
                map.put(Constants.MSG, Constants.ERROR_MSG_1_2);
                return map;
            }
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        return map;
    }

    /**
     * 获取app首页显示数量
     *
     * @param agentId 代理的id
     * @return
     */
    @RequestMapping(value = "/getIndexNumInfo", method = RequestMethod.GET)
    public Map getIndexNumInfo(@RequestParam String agentId) {

        Map<String, Object> indexNumInfo = userApi.getIndexNumInfo(agentId);

        return indexNumInfo;
    }

    /**
     * 获取 分享的code
     *
     * @param account
     * @return
     */
    @RequestMapping(value = "/getAgentCode", method = RequestMethod.GET)
    public Map getAgentCode(@RequestParam String account) {

        Map<String, Object> agentCode = userApi.getAgentCode(account);

        return agentCode;
    }

    /**
     * 修改会员备注信息
     *
     * @param {member_id:value,memeber_tel:value,member_zxb:value,member_zxb:value,note:value}
     * @return
     */
    @RequestMapping(value = "/updateMemberNote", method = RequestMethod.GET)
    public Map updateMemberInfo(@RequestParam String member_id,@RequestParam String memeber_tel,@RequestParam String member_zxb,@RequestParam String member_wx,@RequestParam String note) {
       Map  maps = new HashMap();
       maps.put("member_id",member_id);
       maps.put("memeber_tel",memeber_tel);
       maps.put("member_zxb",member_zxb);
       maps.put("member_wx",member_wx);
       maps.put("note",note);
        Map<String, Object> map = userApi.updateMemberNote(maps);
        return map;
    }

    /**
     * @param account  代理账号
     * @param isMonth  是否查询当月 1查询 0不查询 获取三天内销售总汇
     * @return
     */
    @RequestMapping(value = "/findSalesMoneyInfo", method = RequestMethod.GET)

    public Map findSalesMoneyInfo(@RequestParam String account, @RequestParam Integer isMonth) {

        Map salesMoneyInfo = userApi.findSalesMoneyInfo(account, isMonth);

        return salesMoneyInfo;
    }

    /**
     *  开户墙
     * @param page
     * @param pageSize
     * @param minCount  数量限制
     * @return
     */
    @RequestMapping(value = "/findAccountWall", method = RequestMethod.GET)
    public Map findAccountWall(@RequestParam Integer page,@RequestParam Integer pageSize,String minCount) {
        Map accountWall = userApi.findAccountWall(page, pageSize,minCount);
        return accountWall;
    }

    /**
     *充值墙 和消费墙页面显示
     * @param account 代理account 如果为 空则查询所有
     * @param page
     *  @param isConsumer 是否消费 0显示消费墙 1显示充值墙
     * @param pageSize
     * @param minCount 金额限制
     * @param username 会员名字 用于搜索
     * @return
     */
    @RequestMapping(value = "/findRechargeWall", method = RequestMethod.GET)
    public Map findRechargeWall(@RequestParam Integer isConsumer, @RequestParam String account,@RequestParam Integer page,@RequestParam Integer pageSize,String minCount,String username) {
        Map accountWall = userApi.findRechargeWall(account,page, pageSize,minCount,username,isConsumer);
        return accountWall;
    }

    /**
     * 客户关联代理
     * @param memberName 客户昵称
     * @param agentName 代理昵称
     * @param note 备注
     *
     * @return
     */
    @RequestMapping(value = "/memberToAgent" ,method = RequestMethod.GET)
    public Map memberToAgent(@RequestParam String memberName,@RequestParam String agentName,String note,@RequestParam String newAgent){
        Map map = userApi.memberToAgent(memberName, agentName, note,newAgent);
        return map;
    }

    /**
     * 绑定转移记录
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/memberMoveLogs",method = RequestMethod.GET)
    public Map memberMoveLogs(@RequestParam  Integer page,@RequestParam Integer pageSize){
        Map map = userApi.memberMoveLogs(page,pageSize);
        return map;

    }

    /**
     * 查找最近两天会员方案
     * @param page
     * @param pageSize
     * @param member 会员账号或者昵称
     * @return
     */
    @RequestMapping(value = "/findMemberPlan",method = RequestMethod.GET)
    public Map findMemberPlan(@RequestParam  Integer page, @RequestParam Integer pageSize, @RequestParam String member,String agentAccout){

        Map map = userApi.findMemberPlan(page,pageSize,member,agentAccout);
        return map;
    }

    /**
     * 后台查询代理本月或者七天手下会员数据
     * @param account 代理账号
     * @oaram isMonth 0 查当月,1查7天
     * @returns
     */
/*
    @RequestMapping(value="/findAgentInfoByAccountBac",method = RequestMethod.GET)

    public Map findAgentInfoByAccountBac(@RequestParam String account,@RequestParam Integer isMonth){

        Map map = userApi.findAgentInfoByAccountBac(account,isMonth);
        return map;
    }

*/

    @RequestMapping(value="/findAgentInfoByAccount",method = RequestMethod.GET)

    public Map findAgentInfoByAccount(@RequestParam String account,@RequestParam Integer isMonth){

        Map map = userApi.findAgentInfoByAccount(account,isMonth);
        return map;
    }

    /**
     * 查询客户关联申请
     *
     */
    @RequestMapping(value =  "/findMemberAssociation",method = RequestMethod.GET)


    public Map findMemberAssociation(@RequestParam String agentName,@RequestParam String startDate,@RequestParam String endDate, @RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "20") Integer pageSize){

        Map map = userApi.findMemberAssociation(agentName,startDate,endDate,page,pageSize);

        return  map;

    }

    /**
     *
     * @param agentName 代理名字
     * @param memeberName 客户姓名
     * @param is_erview 是否通过 2不通过 1通过
     * @return
     */
    @RequestMapping(value =  "/MemberAudit",method = RequestMethod.GET)

    public Map MemberAudit(@RequestParam String agentName, @RequestParam String memeberName, @RequestParam Integer is_erview){
            Map map = new HashMap();
            map.put("agentName",agentName);
            map.put("memeberName",memeberName);
            map.put("is_erview",is_erview);
        Map resMap = userApi.MemberAudit(map);
        return  resMap;
    }

    /**
     * 查询客户转移申请
     */
    @RequestMapping(value =  "/findMemberMove",method = RequestMethod.GET)

    public Map findMemberMove(@RequestParam String agentName,@RequestParam String startDate,@RequestParam String endDate,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "20") Integer pageSize){

        Map map = userApi.findMemberMove(agentName,startDate,endDate,page,pageSize);
        return  map;
    }

    /**
     *  转移审核
     * @param agentName 代理名字
     * @param memeberName 客户名嘴
     * @param is_erview 是否通过 2不通过 1通过
     * @param moveAgent 转移代理名字
     * @return
     */
    @RequestMapping(value =  "/MemberMoveAudit",method = RequestMethod.GET)
    public Map MemberMoveAudit(@RequestParam String agentName, @RequestParam String memeberName, @RequestParam Integer is_erview,@RequestParam String moveAgent){
        Map map = new HashMap();
        map.put("agentName",agentName);
        map.put("memeberName",memeberName);
        map.put("is_erview",is_erview);
        map.put("moveAgent",moveAgent);
        Map resMap = userApi.MemberMoveAudit(map);
        return  resMap;
    }
    /**
     * 查询授信加款流水
     */
    @RequestMapping(value="/findMemberWalletLine",method = RequestMethod.GET)
    public Map findMemberWalletLine(@RequestParam String agentAccount,@RequestParam String startDate,@RequestParam String endDate,String loginAccount){
        Map map = userApi.findMemberWalletLine(agentAccount,startDate,endDate,loginAccount);
        return  map;

    }

/**类别可选 没有字段
 * 充值状态  钱包流水只显示成功流水 失败事务回滚
 * 线上充值流水
 * 是否充值补单 没有字段
 *
 *
 */
@RequestMapping(value = "/findRechargeOnLine",method = RequestMethod.GET)

    public Map findRechargeLine(@RequestParam String agentName, String startTime, String endTime){
    Map<String,String> mapParam = new HashMap<String, String>();
    mapParam.put("agentName",agentName);
    mapParam.put("startDate",startTime);
    mapParam.put("endDate",endTime);
    Map map = userApi.findRechargeLine(mapParam);
    return  map;
}
/**
 *
 *类别可选 ? 没做
 * 线下加款流水
 */

@RequestMapping(value = "/findRechargeUnderLine",method = RequestMethod.GET)

public Map findRechargeUnderLine(@RequestParam String agentName, String startTime, String endTime,@RequestParam String loginAccount){
    Map<String,String> mapParam = new HashMap<String, String>();
    mapParam.put("agentName",agentName);
    mapParam.put("startTime",startTime);
    mapParam.put("endTime",endTime);
    Map map = userApi.findRechargeUnderLine(mapParam);
    return  map;
}
/**
 * 财务后台现金明细
 * 只获取线下授信加款 其他写死数据
 */
@RequestMapping(value = "/findFinancialCashInfo",method = RequestMethod.GET)

public Map findFinancialCashInfo(@RequestParam Integer isMonth){

    Map map = userApi.findFinancialCashInfo(isMonth);

    return  map;
}
/**
 * 当日所有人员的销量详情
 *
 */
@RequestMapping(value = "/findSaleInfo")

public Map findSaleInfo( String agentName,String start_time,String end_date,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "20") Integer pageSize,@RequestParam String loginAccount){

    Map map = userApi.findSaleInfo(agentName,start_time,end_date,page
            ,pageSize,loginAccount);

    return  map;
}

/**
 * 查找渠道的销量
 */
@RequestMapping(value = "findQDSaleInfo")
public Map findQDSaleInfo( String qdName,String start_time,String end_date,@RequestParam Integer page,@RequestParam Integer pageSize){

    Map map = userApi.findQDSaleInfo(qdName,start_time,end_date,page,pageSize);

    return  map;
}
    /**
 * 财务后台资金明细
 *
 */
@RequestMapping(value = "/findFinancialMoneyInfo",method = RequestMethod.GET)
public Map findFinancialMoneyInfo(@RequestParam Integer isMonth){

    Map map = userApi.findFinancialMoneyInfo(isMonth);

    return  map;
}
/**
 * 客户充值提款记录
 * 0 :网上充值,2058 :线下充值,1000 现金充值,-1000 冲正,36 提款
 */
@RequestMapping(value = "/findRechargeAndWitdrawlInfo",method = RequestMethod.GET)
    public Map findRechargeAndWitdrawlInfo(@RequestParam String account){

    Map map = userApi.findRechargeAndWitdrawlInfo(account);
    return map;
}
/**
 * 导出 excle
 */
@RequestMapping(value = "/exportExcle")
public Map exportExcle(@RequestParam String listParams,@RequestParam String title ,HttpServletResponse response) throws Exception{
    List<Map> list = new ArrayList<Map>();
    List jsonList = JSONObject.parseObject(listParams,List.class);
    for (Object obj: jsonList
         ) {
        if (obj instanceof Map){
            Map map = (Map)obj;
            list.add(map);
        }
    }
    ExportExcle.exportExcle(list,title,response);
    return null;
}
    /**
 * 用户登录查询菜单信息
 */

@RequestMapping(value = "/findRoleAndPermission")
    @ResponseBody
    public Map findRoleAndPermission(@RequestParam String account){

    Map map = userApi.findRoleAndPermission(account);
    return map;

}

/**
 * 返回所有的角色
 */
@RequestMapping(value = "/findAllRole")
@ResponseBody
public Map findAllRole(Integer role_id){
    Map<String,Object> map = new HashMap();
    map.put("role_id",role_id);
    Map resMap = userApi. findAllRole(map);
    return resMap;
}
/**
 * 返回所有 用户
 */
@RequestMapping(value = "/findAllUserAndRole")
@ResponseBody
public Map findAllUserAndRole(@RequestParam Integer page,@RequestParam Integer pageSize,Integer id){
    Map resMap = userApi. findAllUserAndRole(page,pageSize,id);
    return resMap;
}
/**
 * 查找所有模块
 */
@RequestMapping(value = "/findAllParentModel")
@ResponseBody
public Map findAllParentModel(Integer id){
    Map resMap = userApi.findAllParentModel(id);
    return resMap;
}
/**
 * 查找所有子mokuai
 */
@RequestMapping(value = "/findAllChildModel")
@ResponseBody
public Map findAllChildModel(Integer id,@RequestParam Integer page , @RequestParam Integer pageSize){
   Map<String,Object> map = new HashMap<String, Object>();
    map.put("id",id);
    Map resMap = userApi.findAllChildModel(map,page,pageSize);
    return resMap;
}


/**
 * 添加账号
 *
 */
@RequestMapping(value = "/addUser")
@ResponseBody
public Map addUser(@RequestParam String account,@RequestParam String password,@RequestParam String name,@RequestParam Integer status,@RequestParam Integer role_id){
    Map<String,Object> map = new HashMap<String, Object>();
    map.put("account",account);
    map.put("password",MD5.encode(password));
    map.put("name",name);
    map.put("status",status);
    map.put("role_id",role_id);
    Map resMap = userApi.addUser(map);
    return resMap;
}
    /**
 * 添加角色
 *
 */
@RequestMapping(value = "/addRole")
@ResponseBody
public Map addRole(@RequestParam String role_name,@RequestParam String role_desc){
    Map<String,Object> map = new HashMap<String, Object>();
    map.put("role_name",role_name);
    map.put("role_desc",role_desc);
    Map resMap = userApi.addRole(map);
    return resMap;
}
/**
     * 给角色配置权限
     * 1#1#2#3#4#5@2#6#7#8#9@3#10#11@4#12#13#14#15@5#16#17#18@6#19#20#21@7#22#23#24#25#26
     {"role_id":value,"permissions":"父模块id#子模块id@parent_model_id#child_model_id","child_premission":[{"child_model_id":"子模块id","child_permission":value,value},{"child_model_id":子权限}]}
     */
@RequestMapping(value = "/addRoleBondPermission",method = RequestMethod.POST)
@ResponseBody
public Map addRoleBondPermission(@RequestBody Permission params){
    System.out.println(params);
    Map<String,Object> map = new HashMap<String, Object>();
    map.put("role_id",params.getRole_id());
    map.put("permissions",params.getPermissions());
    map.put("child_premission",params.getChild_premission());
    map.put("role_name",params.getRole_name());
    map.put("role_desc",params.getRole_desc());
    Map resMap = userApi.addRoleBondPermission(map);
    return resMap;
}
    /**
 * 添加权限
 */
@RequestMapping(value = "/addPermission")
@ResponseBody
public Map addPermission(@RequestParam String  modelName,@RequestParam String modelUrl,@RequestParam Integer modeParentId,@RequestParam String desc){
    Map<String,Object> map = new HashMap<String, Object>();
    map.put("modelName",modelName);
    map.put("modelUrl",modelUrl);
    map.put("modeParentId",modeParentId);
    map.put("desc",desc);
    Map resMap = userApi.addPermission(map);
    return resMap;
}
/**
 * 添加模块
 */
@RequestMapping(value = "/addParentModel")
@ResponseBody
public Map addParentModel(@RequestParam String  modelName,@RequestParam String desc){
    Map<String,Object> map = new HashMap<String, Object>();
    map.put("modelName",modelName);
    map.put("desc",desc);
    Map resMap = userApi.addParentModel(map);
    return resMap;
}
    @RequestMapping(value = "/updateParentModel")
    @ResponseBody
    public Map updateParentModel(@RequestParam String  modelName,@RequestParam String desc,@RequestParam Integer model_id){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("modelName",modelName);
        map.put("desc",desc);
        map.put("model_id",model_id);
        Map resMap = userApi.updateParentModel(map);
        return resMap;
    }

    /**
     *修改user
     * @param account 账号
     * @param name 用户名
     * @param role_id 角色id
     * @param status 是否可用 1 可用 0不可用
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/updateUserInfo")
@ResponseBody
public Map updateUserInfo(@RequestParam String account,@RequestParam String name,@RequestParam Integer role_id,@RequestParam Integer status,String password){
    Map<String,Object> map = new HashMap<String, Object>();
    map.put("account",account);
    map.put("name",name);
    map.put("role_id",role_id);
    map.put("status",status);
    if (password!=null){
        password = MD5.encode(password);
    }
    map.put("password",password);
    Map resMap = userApi.updateUserInfo(map);
    return resMap;
}

    /**
     *修改子模块
     * @param child_id
     * @param model_name
     * @param model_url
     * @param model_parent
     * @param desciption
     * @return
     */
    @RequestMapping(value = "/updateChildModelInfo")
    @ResponseBody
    public Map updateChildModelInfo(@RequestParam Integer child_id,@RequestParam String model_name,@RequestParam String model_url,@RequestParam Integer model_parent,@RequestParam String desciption){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("model_name",model_name);
        map.put("model_url",model_url);
        map.put("model_parent",model_parent);
        map.put("desciption",desciption);
        map.put("id",child_id);
        Map resMap = userApi.updateChildModelInfo(map);
        return resMap;
    }
    /**
     *
     */
    @RequestMapping(value = "/findChildModelByParent")
    @ResponseBody
    public Map findChildModelByParent(@RequestParam Integer parentModelId) {
        Map resMap = userApi.findChildModelByParent(parentModelId);
        return resMap;
    }
    /**
     * 删除账号
     */
    @RequestMapping(value = "/delUser")
    @ResponseBody
    public Map delUser(@RequestParam Integer user_id) {
        Map resMap = userApi.delUser(user_id);
        return resMap;
    }
    /**
     * 将会员变成渠道
     */
    @RequestMapping(value = "/updateMemberToQD")
    @ResponseBody
    public Map updateMemberToQD(@RequestParam Integer member_id,@RequestParam String account) {
        Map resMap = userApi.updateMemberToQD(member_id,account);
        return resMap;
    }
    /**
     * 页面返回所有会员
     *
     */
    @RequestMapping(value = "/findAllMember")
    @ResponseBody
    public Map findAllMember(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer pageSize, String  start_time,

                              String  end_time, String username, String account,String mobile,String realName,String identifyId,String email) {
        start_time =DateUtil.ifNull(start_time);
        end_time = DateUtil.ifNull(end_time);
        username =DateUtil.ifNull(username);
        account = DateUtil.ifNull(account);
        mobile = DateUtil.ifNull(mobile);
        realName = DateUtil.ifNull(realName);
        identifyId = DateUtil.ifNull(identifyId);
        email = DateUtil.ifNull(email);
        Map resMap = userApi.findAllMember(page,pageSize,start_time,end_time,username,account,mobile,realName,identifyId,email);
        return resMap;
    }

    /**
     * 修改会员信息
     */
    @RequestMapping(value = "/updateMemberInfoBack")
    @ResponseBody
    public Map updateMemberInfo(@RequestParam String  account,@RequestParam String realName,@RequestParam String email,
                                @RequestParam String tel,@RequestParam String identifyId,@RequestParam String upAccount){
            Map<String,Object> paramMap = new HashMap<String, Object>();
            paramMap.put("realName",realName);
        paramMap.put("email",email);
        paramMap.put("tel",tel);
        paramMap.put("identifyId",identifyId);
        paramMap.put("upAccount",upAccount);
        paramMap.put("account",account);
            Map resMap = userApi.updateMemberInfoBack(paramMap);
        return resMap;
    }
    /**
 * 查询所有的代理和渠道
 */
@RequestMapping(value = "/findAllAgentAndQD")
@ResponseBody
public Map findAllAgentAndQD(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "20") Integer pageSize,@RequestParam String account) {
    Map resMap = userApi.findAllAgentAndQD(page,pageSize,account);
    return resMap;
}

    /**
     * 给渠道绑定代理
     * params:{"QD_id":"agent_id,agent_id","QD_id":"agent_id,agent_id"}
     */
    @RequestMapping(value = "/addAgentToQD")
    @ResponseBody
    public Map addAgentToQD(@RequestParam String  params) {
        Map<String,Object> map = JSONObject.parseObject(params,Map.class);
      Map resMap = userApi.addAgentToQD(map);
        return resMap;
    }

    /**
     * 查询客户钱包流水
     * @param account 账号
     * @param start_time
     * @param end_time
     * @param type 0所有  1支出 2充值的类型 3/消费的类型 4//退款的类型 5//奖金的类型 6//赠送的类型 7//提款的 8//提款退单的 9// 其他 10	//可提现的集合
     *             child_type 具体的类型查询
     * @retur
     */
    @RequestMapping(value = "/findMemberWalletLineByAccount")
    @ResponseBody
        public Map findMemberWalletLineByAccount(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer pageSize ,@RequestParam String account,@RequestParam String start_time,@RequestParam String end_time,@RequestParam(defaultValue = "0") Integer type,String loginAccount,String qdAccount,String dlAccount,Integer child_type){
            Map<String,Object> map =new HashMap<String, Object>();
            map.put("account",account);
            map.put("startTime",start_time);
            map.put("endTime",end_time);
            map.put("type",type);
            map.put("loginAccount",loginAccount);
            map.put("qdAccount",qdAccount);
            map.put("dlAccount",dlAccount);
            map.put("child_type",child_type);
            map.put("page",page);
            map.put("pageSize",pageSize);
        Map resMap = userApi.findMemberWalletLineByAccount(map);
        return  resMap;
    }

/**
 * 将代理设置成渠道
 * 手下会员的provider(上级)变为qd
 */
    @RequestMapping("/upgradeAgentToQD")
    @ResponseBody
    public Map upgradeAgentToQD(@RequestParam String account){
        Map resMap = userApi.upgradeAgentToQD(account);
        return  resMap;
    }
/**
 * 机器人跟单统计
 */
@RequestMapping("/findRobotConsume")
@ResponseBody
public Map findRobotConsume(@RequestParam Integer page,Integer pageSize){
    Map resMap = userApi.findRobotConsume(page,pageSize);
    return  resMap;
}

    /**
     *
     * @param account 代理账号
     * @param password 密码
     * @return
     */
    @RequestMapping("/setAgentPassword")
    @ResponseBody
    public Map setAgentPassword(@RequestParam String account, @RequestParam String password) {
        Map params = new HashMap();
        params.put("account", account);
        params.put("password", password);
        Map resMap = userApi.setAgentPassword(params);
        return resMap;
    }

    /**
     *
     * @param user_account 登录账号,渠道账号,渠道账号
     * @param member_account
     * @param is_del 1 增加,0 删除
     * @return
     */

    @RequestMapping("/setOrUpdateQDtoUser")
    @ResponseBody
    public Map setOrUpdateQDtoUser(@RequestParam String user_account, @RequestParam String member_account, @RequestParam Integer is_del) {
        Map params = new HashMap();
        params.put("user_account", user_account);
        params.put("member_account", member_account);
        params.put("is_del", is_del);
        Map resMap = userApi.setOrUpdateQDtoUser(params);
        return resMap;
    }

    }

