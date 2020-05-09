package com.qiyun.controller;

import com.aliyun.oss.OSSClient;
import com.qiyun.api.PayApi;
import com.qiyun.common.Result;
import com.qiyun.controller.base.BaseController;
import com.qiyun.dto.*;
import com.qiyun.util.AliyunOSSClientUtil;
import com.qiyun.util.DateTools;
import com.qiyun.util.OSSClientConstants;
import com.qiyun.util.StringUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/xxPay")
public class XxPayController extends BaseController{

    @Resource
    private PayApi payApi;

    private int id;

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
    static{
        ENDPOINT = OSSClientConstants.ENDPOINT;
        ACCESS_KEY_ID = OSSClientConstants.ACCESS_KEY_ID;
        ACCESS_KEY_SECRET = OSSClientConstants.ACCESS_KEY_SECRET;
        BACKET_NAME = OSSClientConstants.BACKET_NAME;
        FOLDER = OSSClientConstants.FOLDER;
    }


    /**
     * 获取代理给客户充值记录
     * @return
     */
    @RequestMapping(value = "/getAgentChargeLine",method = RequestMethod.GET)
    @ResponseBody
    public Result getAgentChargeLine(){
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        String account = request.getParameter("account");
        String loginAccount = request.getParameter("loginAccount");
        String memberAccount = request.getParameter("memberAccount");
        String start_time = request.getParameter("start_time");
        String end_time = request.getParameter("end_time");
        if (loginAccount==null||loginAccount.equals("")){
            loginAccount="manager";
        }
        Result result = payApi.getAgentChargeLine(account,page,pageSize,loginAccount,memberAccount,start_time,end_time);
        return result;
    }

    /**
     * 获取代理还款申请
     *      * @return
     */
    @RequestMapping(value = "/getCreditRefund",method = RequestMethod.GET)
    @ResponseBody
    public Result getCreditRefund( String operator,String startTime,String endTime){
        Result result = new Result();
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize",10);
        String account = request.getParameter("account");
        int status = getInt("status",3);
        String loginAccount = request.getParameter("loginAccount");

        if (loginAccount==null||loginAccount.equals("")){
            loginAccount="manager";
        }
        if (operator==null||operator.equals("")){
            operator=null;
        }
        if (startTime==null||startTime.equals("")){
            startTime=null;
        }
        if (endTime==null||endTime.equals("")){
            endTime=null;
        }
        result = payApi.getCreditRefund(page,pageSize,account,status,loginAccount,operator,startTime,endTime);

        return result;
    }


    /**
     * 获取授信记录
     * @return
     */
    @RequestMapping(value = "/getCreditLimitLine",method = RequestMethod.GET)
    @ResponseBody
    public Result getCreditLimitLine(){
        Result result = new Result();
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize",10);
        String account = request.getParameter("account");
        String loginAccount = request.getParameter("loginAccount");
        result = payApi.getCreditLimitLine(page,pageSize,account,loginAccount);
        return result;
    }

    /**
     * 驳回代理还款申请
     * @return
     */
    @RequestMapping(value = "/refuseCreditRefundApply",method = RequestMethod.GET)
    @ResponseBody
    public Result refuseCreditRefundApply(){
        Result result = new Result();
        String account = request.getParameter("account");
        int id = getInt("id");

        result = payApi.refuseCreditRefundApply(account,id);

        return result;
    }

    /**
     * 通过代理还款申请
     * @return
     */
    @RequestMapping(value = "/passCreditRefundApply",method = RequestMethod.GET)
    @ResponseBody
    public Result passCreditRefundApply(){
        Result result = new Result();
        String account = request.getParameter("account");
        int id = getInt("id");

        result = payApi.passCreditRefundApply(account,id);

        return result;
    }

    /**
     * 代理发起还款申请
     * @return
     */
    @RequestMapping(value = "/creditRefundApply",method = RequestMethod.GET)
    @ResponseBody
    public Result creditRefundApply(){
        Result result = new Result();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        }
        String amountStr = request.getParameter("amount");
        double amount = Double.parseDouble(amountStr);

        result = payApi.creditRefundApply(member2DTO.getAccount(),amount);

        return result;
    }

    /**
     * 代理给名下用户充值
     * @return
     */
    @RequestMapping(value = "/agentCharge",method = RequestMethod.GET)
    @ResponseBody
    public Result agentCharge(){
        Result result = new Result();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        }
        String account = request.getParameter("account");
        String amountStr = request.getParameter("amount");
        String pay_pass = request.getParameter("pay_pass");
        if (StringUtils.isNullOrBlank(amountStr)){
            result.setSuccess(false);
            result.setMsg("请输入正确金额");
            return result;
        }
        double amount = Double.parseDouble(amountStr);
        if (amount<=0){
            result.setSuccess(false);
            result.setMsg("请输入正确金额");
            return result;
        }
        MemberWallet2DTO memberWalletByAccount = payApi.getMemberWalletByAccount(member2DTO.getAccount());
        if (memberWalletByAccount==null){
            result.setSuccess(false);
            result.setMsg("找不到会员钱包");
            return result;
        }
        if (memberWalletByAccount.getAbleCreditBalance()<amount){
            result.setSuccess(false);
            result.setMsg("授信额度不够");
            return result;
        }
        result = payApi.agentCharge(account,amount,member2DTO.getAccount(),member2DTO.getUsername(),pay_pass);
        return result;
    }

    /**
     * 授信
     * @return
     */
    @RequestMapping(value = "/credit",method = RequestMethod.GET)
    @ResponseBody
    public Result credit(){
        Result result = new Result();
        String operater = request.getParameter("operater");
        String account = request.getParameter("account");
        String creditLimit = request.getParameter("creditLimit");
        if (StringUtils.isNullOrBlank(operater) || StringUtils.isNullOrBlank(account) || StringUtils.isNullOrBlank(creditLimit)){
            result.setSuccess(false);
            result.setMsg("数据错误");
            return result;
        }
        if (Double.parseDouble(creditLimit)>50000){
            result.setSuccess(false);
            result.setMsg("授信金额不能大于20000");
            return result;
        }
        result = payApi.credit(Double.parseDouble(creditLimit),account,operater);

        return result;
    }

    /**
     * 获取线下充值记录
     * @return
     */
    @RequestMapping(value = "/getMemberWalletLineByXx",method = RequestMethod.GET)
    @ResponseBody
    public Result getMemberWalletLineByXx(){
        Result result = new Result();
        String account = request.getParameter("account");

        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        result = payApi.getMemberWalletLineByXx(account,page,pageSize);
        return result;
    }

    /**
     * 线下充值
     * @param amount
     * @return
     */
    @RequestMapping(value = "/xxCharge",method = RequestMethod.GET)
    @ResponseBody
    public Result xxCharge(Double amount){
        Result result = new Result();
        if (amount<=0){
            result.setSuccess(false);
            result.setMsg("请输入正确金额");
            return result;
        }
        String account = request.getParameter("account");
        if (StringUtils.isNullOrBlank(account) || amount==null || amount==0){
            result.setSuccess(false);
            result.setMsg("数据错误");
            return result;
        }
        result = payApi.xxCharge(account,amount);
        return result;
    }

    /**
     * 根据用户名获取钱包信息
     * @return
     */
    @RequestMapping(value = "/getMemberWalletByAccount",method = RequestMethod.GET)
    @ResponseBody
    public Result getMemberWalletByAccount(){
        Result result = new Result();
        String account = request.getParameter("account");
        if (StringUtils.isNullOrBlank(account)){
            result.setSuccess(false);
            result.setMsg("数据错误");
            return result;
        }
        MemberWallet2DTO memberWallet2DTO = payApi.getMemberWalletByAccount(account);
        result.setData(memberWallet2DTO);
        return result;
    }

    /**
     * 驳回申请
     * @return
     */
    @RequestMapping(value = "/refuseApply",method = RequestMethod.GET)
    @ResponseBody
    public Result refuseApply(){
        Result result = new Result();
        Integer id = getInt("id");
        if (id==null || id ==0){
            result.setSuccess(false);
            result.setMsg("数据错误");
            return result;
        }
        result = payApi.refuseApply(id);
        return result;
    }


    /**
     * 通过审核
     * @return
     */
    @RequestMapping(value = "/passPayApply",method = RequestMethod.GET)
    @ResponseBody
    public Result passPayApply(Integer id){
        Result result = new Result();
        if (id==null || id ==0){
            result.setSuccess(false);
            result.setMsg("数据错误");
            return result;
        }
        result = payApi.passPayApply(id);
        return result;
    }

    /**
     * 获取支付申请列表
     * @return
     */
    @RequestMapping(value = "/getPayApplyList",method = RequestMethod.GET)
    @ResponseBody
    public Result getPayApplyList(){
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 20);
        Result result = payApi.getPayApplyList(page,pageSize);
        return result;
    }

    /**
     * 用户发起线下支付申请
     * @return
     */
    @RequestMapping(value = "/payApply",method = RequestMethod.GET)
    @ResponseBody
    public Result payApply(double amount){
        Result result = new Result();
        Member2DTO memberSession = checkLogin();
        if (memberSession == null) {
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        } else {
            String remark = request.getParameter("remark");
            String payAccount = request.getParameter("payAccount");
            String type = getStr("type");
            if (!"wx".equals(type) || !"zfb".equals(type)){
                result.setSuccess(false);
                result.setMsg("数据错误");
                return result;
            }
            XxPayApplyDTO xxPayApply = new XxPayApplyDTO();
            xxPayApply.setAccount(memberSession.getAccount());
            xxPayApply.setAmount(amount);
            xxPayApply.setPayAccount(payAccount);
            xxPayApply.setCreateDate(new Date());
            xxPayApply.setRemark(remark);
            xxPayApply.setStatus(0);
            xxPayApply.setType(type);

            result = payApi.addXxPayApply(xxPayApply);
        }
        return result;
    }

    /**
     * 修改用户支付渠道
     * @return
     */
    @RequestMapping(value = "/updateMemberPayWays",method = RequestMethod.GET)
    @ResponseBody
    public Result updateMemberPayWays(String[] ids){
        int id = getInt("id");
        String payWays = "";
        if (ids!=null && ids.length>0) {
            for (int i = 0; i < ids.length; i++) {
                if (i == 0) {
                    payWays += ids[i];
                } else {
                    payWays += ",";
                    payWays += ids[i];
                }
            }
        }
        Result result = payApi.updateMemberPayWays(id,payWays);
        return result;
    }

    /**
     * 查询单个会员
     * @return
     */
    @RequestMapping(value = "/getPayMemberByAccount",method = RequestMethod.GET)
    @ResponseBody
    public Result getPayMemberByAccount(){
        Result result = new Result();
        String account = getStr("account");
        if (StringUtils.isNullOrBlank(account)){
            result.setSuccess(false);
            result.setMsg("数据错误");
            return result;
        }
        result = payApi.getPayMember(account);
        return result;
    }

    /**
     * 获取支付配置列表
     * @return
     */
    @RequestMapping(value = "/getPayMember",method = RequestMethod.GET)
    @ResponseBody
    public Result getPayMember(){
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);
        Result result = payApi.getPayMember(page,pageSize);
        return result;
    }

    /**
     * 前台获取线下支付二维码
     * @return
     */
    @RequestMapping(value = "/getPayChannelPicture",method = RequestMethod.GET)
    @ResponseBody
    public Result getPayChannelPicture(){
        Result result = new Result();
        String type = getStr("type");
        Member2DTO memberSession = checkLogin();
        if (!"zfb".equals(type) && !"wx".equals(type)){
            result.setSuccess(false);
            result.setMsg("数据错误");
            return result;
        }
        if(memberSession == null){
            result.setMsg("您还没有登录");
            result.setSuccess(false);
            return result;
        }

        result = getPicutre(type,memberSession.getId());
        return result;
    }


    public Result getPicutre(String type,int id){
        Result result = new Result();
        if ("zfb".equals(type)||"wx".equals(type)) {
            List<String> list = new ArrayList<String>();
            Member2DTO member2ById = payApi.getMemberById(id);
            if (member2ById!=null) {
                String payWays = member2ById.getPayWays();
                if (StringUtils.isNullOrBlank(payWays)) {
                    Member2DTO member2ById2 = payApi.getMemberById(member2ById.getSourceId());
                    if (member2ById2!=null) {
                        id = member2ById2.getId();
                        return getPicutre(type, id);
                    }else{
                        result.setSuccess(true);
                        return result;
                    }
                }else {
                    String[] split = payWays.split(",");
                    for (int i = 0; i < split.length; i++) {
                        XxPay2DTO xxPay2DTO = payApi.getPayChannelByIdAndIsOnLineAndType(Integer.parseInt(split[i]), 0, type);
                        if (xxPay2DTO!=null) {
                            if (xxPay2DTO.getStatus()==1) {
                                result.setSuccess(true);
                                String pictureUrl = xxPay2DTO.getPictureUrl();
                                list.add(pictureUrl);
                            }
                        }
                    }
                    result.setSuccess(true);
                    result.setData(list);
                    return result;
                }
            }
        }else {
            result.setSuccess(false);
            result.setMsg("类型错误");
        }
        return result;
    }

    /**
     * 删除支付渠道
     * @return
     */
    @RequestMapping(value = "/deletePayChannel",method = RequestMethod.POST)
    @ResponseBody
    public Result deletePayChannel(){
        Result result = new Result();
        Integer id = getInt("id");
        if (id==null || id ==0){
            result.setSuccess(false);
            result.setMsg("数据错误");
            return result;
        }
        XxPay2DTO xxPay2DTO = payApi.getPayChannelById(id);
        if (xxPay2DTO!=null && !StringUtils.isNullOrBlank(xxPay2DTO.getPicture())){
            //初始化OSSClient
            OSSClient ossClient=AliyunOSSClientUtil.getOSSClient();
            AliyunOSSClientUtil.deleteFile(ossClient,BACKET_NAME,FOLDER,xxPay2DTO.getPicture());
        }
        result = payApi.deletePayChannel(id);
        return result;
    }

    /**
     * 修改支付渠道
     * @param QRCode
     * @return
     */
    @RequestMapping(value = "/updatePayChannel",method = RequestMethod.POST)
    @ResponseBody
    public Result updatePayChannel(MultipartFile QRCode){
        Result result = new Result();
        Integer id = getInt("id");
        String name = getStr("name");
        String type = getStr("type");
        if (id==null || id ==0){
            result.setSuccess(false);
            result.setMsg("数据错误");
            return result;
        }
        if (StringUtils.isNullOrBlank(name)){
            result.setSuccess(false);
            result.setMsg("姓名不能为空");
            return result;
        }
        if (StringUtils.isNullOrBlank(type)||(!"zfb".equals(type) && !"wx".equals(type))){
            result.setSuccess(false);
            result.setMsg("类型错误");
            return result;
        }

        XxPay2DTO xxPay2DTO = new XxPay2DTO();
        xxPay2DTO.setId(id);
        xxPay2DTO.setName(name);
        xxPay2DTO.setType(type);

        //初始化OSSClient
        OSSClient ossClient=AliyunOSSClientUtil.getOSSClient();
        CommonsMultipartFile cf = (CommonsMultipartFile)QRCode;
        //这个myfile是MultipartFile的
        DiskFileItem fi = (DiskFileItem) cf.getFileItem();
        File file = fi.getStoreLocation();
        String fileName = fi.getName();

        if(file != null && !"".equals(file)){

            XxPay2DTO xxPay22DTO = payApi.getPayChannelById(id);
            AliyunOSSClientUtil.deleteFile(ossClient,BACKET_NAME, FOLDER,xxPay22DTO.getPicture());

            int lastIndexOf = fileName.lastIndexOf( "." );
            String houzhui = fileName.substring(lastIndexOf);
            String imgFileName = DateTools.getNowDateYYYYMMDDHHMMSSSS();
            AliyunOSSClientUtil.uploadObject2OSS(ossClient, file,imgFileName+houzhui, BACKET_NAME, FOLDER);
            xxPay2DTO.setPicture(imgFileName+houzhui);
        }
        result = payApi.updatePayChannel(xxPay2DTO);

        return result;
    }

    /**
     * 修改支付渠道状态
     * @return
     */
    @RequestMapping(value = "/updateStatus",method = RequestMethod.GET)
    @ResponseBody
    public Result updateStatus(){
        Result result = new Result();
        Integer status = getInt("status");
        Integer id = getInt("id");
        if (id==null || id ==0 || status==null){
            result.setSuccess(false);
            result.setMsg("数据错误");
            return result;
        }
        if (status==1){
            status=0;
        }else  if (status==0){
            status=1;
        }
        result = payApi.updateStatus(id,status);
        return result;
    }

    /**
     * 获取支付渠道列表
     * @return
     */
    @RequestMapping(value = "/getPayChannelList",method = RequestMethod.GET)
    @ResponseBody
    public Result getPayChannelList(){
        Result result = new Result();
        int page  = getInt("page",1);
        int pageSize  = getInt("pageSize",10);
        result = payApi.getPayChannelList(page,pageSize);
        return result;
    }

    /**
     * 添加线下支付
     * @param QRCode
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result add(MultipartFile QRCode){
        Result result = new Result();

        String name = request.getParameter("name");
        String type = getStr("type");
        if (StringUtils.isNullOrBlank(name)){
            result.setSuccess(false);
            result.setMsg("姓名不能为空");
            return result;
        }
        if (StringUtils.isNullOrBlank(type)||(!"zfb".equals(type) && !"wx".equals(type))){
            result.setSuccess(false);
            result.setMsg("类型错误");
            return result;
        }

        PayChannelDTO payChannelDTO = new PayChannelDTO();
        payChannelDTO.setIsOnline(0);
        payChannelDTO.setName(name);
        payChannelDTO.setStatus(1);
        payChannelDTO.setType(type);

        //初始化OSSClient
        OSSClient ossClient=AliyunOSSClientUtil.getOSSClient();
        CommonsMultipartFile cf = (CommonsMultipartFile)QRCode;
        //这个myfile是MultipartFile的
        DiskFileItem fi = (DiskFileItem) cf.getFileItem();
        File file = fi.getStoreLocation();
        String fileName = fi.getName();

        if(file != null && !"".equals(file)){
            int lastIndexOf = fileName.lastIndexOf( "." );
            String houzhui = fileName.substring(lastIndexOf);
            String imgFileName = DateTools.getNowDateYYYYMMDDHHMMSSSS();
            AliyunOSSClientUtil.uploadObject2OSS(ossClient, file,imgFileName+houzhui, BACKET_NAME, FOLDER);
            payChannelDTO.setPicture(imgFileName+houzhui);
            result = payApi.addPayChannel(payChannelDTO);
        }

        return result;
    }

}
