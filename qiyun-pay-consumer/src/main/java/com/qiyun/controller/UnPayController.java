package com.qiyun.controller;

import com.qiyun.api.PayApi;
import com.qiyun.common.Result;
import com.qiyun.controller.base.BaseController;
import com.qiyun.dto.Member2DTO;
import com.qiyun.dto.PayOrderDTO;
import com.qiyun.type.WalletTransType;
import com.qiyun.util.Constants;
import com.qiyun.util.MD5Utils;
import com.qiyun.util.NumberTools;
import com.qiyun.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/unPay")
public class UnPayController extends BaseController {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(UnPayController.class);

    @Resource
    private PayApi payApi;

    static String realmName;
    static String mch_app_id;

    static{
        Properties prop=new Properties();
        try {
            prop.load(UnPayController.class.getClassLoader().getResourceAsStream("config/pay.properties"));
            realmName = prop.getProperty("realmName");
            mch_app_id = prop.getProperty("mch_app_id");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 支付宝
     * @return
     */
    @RequestMapping(value = "/zfbWapPay",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> zfbPay(){
        Map<String,Object> map = new HashMap<String,Object>();
        String cardno = getInt("cardno",44)+"";  //44 支付宝WAP    12 app

        String customerid="301639"; //商户在网关系统上的商户号
        String sdcustomno="";//订单在商户系统中的流水号
        String orderAmount="";//金额,单位分
        String noticeurl=realmName+"/unPay/acceptZfbWapPay";//异步通知地址,不能带任何参数,否则异步通知不会成功
        int type = getInt("type", 1);

        String backurl;//付款成功,同步跳转（不带参数）
        if (type==1) {
            backurl = mch_app_id+"/recharge"; //付款成功,同步跳转（不带参数）
        }else{
            backurl = mch_app_id+"/cloudRecharge"; //付款成功,同步跳转（不带参数）
        }
        String key="2056D8C1DEC3D12CBCE646B348D189D1";//key值请联系商务人员获取
        String mark="qyun88";//数字+字母 不能存在中文 例如：test123
        String remarks="麒云88";//简短的中文说明,为空时,取mark
        String zftype="1";//返回类型 1:直接跳转 2:返回xml 3:返回json

        SimpleDateFormat dateFm = new SimpleDateFormat("yyyyMMddHHmmss"); //格式化当前系统日期
        sdcustomno = dateFm.format(new Date());
        for(int i=0;i<6;i++){
            sdcustomno+=new Random().nextInt(10);
        }


        String rate = getStr("rate");
        orderAmount = request.getParameter("orderAmount");

        String Md5str= "customerid=" + customerid + "&sdcustomno=" + sdcustomno + "&orderAmount=" + orderAmount + "&cardno=" + cardno + "&noticeurl=" + noticeurl + "&backurl=" + backurl + key;
        String sign= MD5Utils.MD5Encode(Md5str,"UTF-8",true);
        String parameter = "customerid=" + customerid + "&sdcustomno=" + sdcustomno + "&orderAmount=" + orderAmount + "&cardno=" + cardno + "&noticeurl=" + noticeurl + "&backurl=" + backurl + "&mark=" + mark +"&remarks=" +remarks + "&zftype=" + zftype;

        Result result = new Result();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_401);
            map.put(Constants.MSG,Constants.ERROR_MSG_401);
            return map;
        }

        //插入支付订单表
        PayOrderDTO payOrderDTO = new PayOrderDTO();
        payOrderDTO.setMemberId(member2DTO.getId());
        payOrderDTO.setId(sdcustomno);
        payOrderDTO.setAmount(Integer.parseInt(orderAmount));
        payOrderDTO.setPayTime(new Date());
        payOrderDTO.setStatus("00");
        payOrderDTO.setType(type);
        payOrderDTO.setProvider("unPay支付宝");
        payOrderDTO.setRate(Double.parseDouble(StringUtils.isNullOrBlank(rate)?"1":rate));
        double a = payOrderDTO.getAmount();
        log.info("unPay支付宝-----------用户id:"+member2DTO.getId()+",金额:"+ NumberTools.round( a/100,2)+"------------");
        payApi.insert(payOrderDTO);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,"http://api.unpay.com/PayMegerHandler.ashx?"+parameter+"&sign="+sign);
        return map;
    }


    @RequestMapping(value = "/acceptZfbWapPay",method = RequestMethod.GET)
    @ResponseBody
    public void acceptZfbWapPay(){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        log.info("unPay回调");
        Enumeration e = request.getParameterNames();
        SortedMap<String, String> map = new TreeMap<String, String>();
        while (e.hasMoreElements()) {
            String param = (String) e.nextElement();
            map.put(param, request.getParameter(param));
        }

        boolean b = checkSign(map);
        if (!b){
            log.info("unPay验签失败");
            return;
        }
        try {
            String state = map.get("state");
            if (!StringUtils.isNullOrBlank(state) && "1".equals(state)){
                boolean flag = payApi.callBackForPay(map.get("sdcustomno"), map.get("sd51no"), (int) (Double.parseDouble(map.get("ordermoney"))*100), WalletTransType.UN_ZFB.getValue(), "支付宝充值");
                if (flag){
                    log.info("unPay回调修改数据库成功");
                    response.getWriter().write("<result>1</result>");
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 支付宝
     * @return
     */
    @RequestMapping(value = "/zfbWapPay2",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> zfbPay2(){
        Map<String,Object> map = new HashMap<String,Object>();
        String cardno = getInt("cardno",44)+"";  //44 支付宝WAP    12 app

        String customerid="301683"; //商户在网关系统上的商户号
        String sdcustomno="";//订单在商户系统中的流水号
        String orderAmount="";//金额,单位分
        String noticeurl=realmName+"/unPay/acceptZfbWapPay2";//异步通知地址,不能带任何参数,否则异步通知不会成功
        int type = getInt("type", 1);

        String backurl;//付款成功,同步跳转（不带参数）
        if (type==1) {
            backurl = mch_app_id+"/recharge"; //付款成功,同步跳转（不带参数）
        }else{
            backurl = mch_app_id+"/cloudRecharge"; //付款成功,同步跳转（不带参数）
        }
        String key="9E9ED6D2FC9DBDFDFB8B8E93906D9212";//key值请联系商务人员获取
        String mark="qyun88";//数字+字母 不能存在中文 例如：test123
        String remarks="麒云88";//简短的中文说明,为空时,取mark
        String zftype="1";//返回类型 1:直接跳转 2:返回xml 3:返回json

        SimpleDateFormat dateFm = new SimpleDateFormat("yyyyMMddHHmmss"); //格式化当前系统日期
        sdcustomno = dateFm.format(new Date());
        for(int i=0;i<6;i++){
            sdcustomno+=new Random().nextInt(10);
        }


        String rate = getStr("rate");
        orderAmount = request.getParameter("orderAmount");

        String Md5str= "customerid=" + customerid + "&sdcustomno=" + sdcustomno + "&orderAmount=" + orderAmount + "&cardno=" + cardno + "&noticeurl=" + noticeurl + "&backurl=" + backurl + key;
        String sign= MD5Utils.MD5Encode(Md5str,"UTF-8",true);
        String parameter = "customerid=" + customerid + "&sdcustomno=" + sdcustomno + "&orderAmount=" + orderAmount + "&cardno=" + cardno + "&noticeurl=" + noticeurl + "&backurl=" + backurl + "&mark=" + mark +"&remarks=" +remarks + "&zftype=" + zftype;

        Result result = new Result();
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_401);
            map.put(Constants.MSG,Constants.ERROR_MSG_401);
            return map;
        }

        //插入支付订单表
        PayOrderDTO payOrderDTO = new PayOrderDTO();
        payOrderDTO.setMemberId(member2DTO.getId());
        payOrderDTO.setId(sdcustomno);
        payOrderDTO.setAmount(Integer.parseInt(orderAmount));
        payOrderDTO.setPayTime(new Date());
        payOrderDTO.setStatus("00");
        payOrderDTO.setType(type);
        payOrderDTO.setProvider("unPay支付宝");
        payOrderDTO.setRate(Double.parseDouble(StringUtils.isNullOrBlank(rate)?"1":rate));
        double a = payOrderDTO.getAmount();
        log.info("unPay支付宝-----------用户id:"+member2DTO.getId()+",金额:"+ NumberTools.round( a/100,2)+"------------");
        payApi.insert(payOrderDTO);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,"http://api.unpay.com/PayMegerHandler.ashx?"+parameter+"&sign="+sign);
        return map;
    }


    @RequestMapping(value = "/acceptZfbWapPay2",method = RequestMethod.GET)
    @ResponseBody
    public void acceptZfbWapPay2(){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        log.info("unPay回调");
        Enumeration e = request.getParameterNames();
        SortedMap<String, String> map = new TreeMap<String, String>();
        while (e.hasMoreElements()) {
            String param = (String) e.nextElement();
            map.put(param, request.getParameter(param));
        }

        boolean b = checkSign2(map);
        if (!b){
            log.info("unPay验签失败");
            return;
        }
        try {
            String state = map.get("state");
            if (!StringUtils.isNullOrBlank(state) && "1".equals(state)){
                boolean flag = payApi.callBackForPay(map.get("sdcustomno"), map.get("sd51no"), (int) (Double.parseDouble(map.get("ordermoney"))*100), WalletTransType.UN_ZFB.getValue(), "支付宝充值");
                if (flag){
                    log.info("unPay回调修改数据库成功");
                    response.getWriter().write("<result>1</result>");
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static boolean checkSign(Map<String, String> map) {

        String state = map.get("state");
        String customerid = map.get("customerid");
        String sd51no = map.get("sd51no");
        String sdcustomno = map.get("sdcustomno");
        String ordermoney = map.get("ordermoney");
        String cardno = map.get("cardno");
        String mark = map.get("mark");
        String sign1 = map.get("sign");
        String resign = map.get("resign");
        String des = map.get("des");
        String parameter = "customerid=" + customerid + "&sd51no=" + sd51no + "&sdcustomno=" + sdcustomno + "&mark=" + mark;
        String sign= MD5Utils.MD5Encode(parameter+"&key=2056D8C1DEC3D12CBCE646B348D189D1","UTF-8",true);
        if (sign.equals(sign1)){
            return true;
        }else{
            return false;
        }
    }

    public static boolean checkSign2(Map<String, String> map) {

        String state = map.get("state");
        String customerid = map.get("customerid");
        String sd51no = map.get("sd51no");
        String sdcustomno = map.get("sdcustomno");
        String ordermoney = map.get("ordermoney");
        String cardno = map.get("cardno");
        String mark = map.get("mark");
        String sign1 = map.get("sign");
        String resign = map.get("resign");
        String des = map.get("des");
        String parameter = "customerid=" + customerid + "&sd51no=" + sd51no + "&sdcustomno=" + sdcustomno + "&mark=" + mark;
        String sign= MD5Utils.MD5Encode(parameter+"&key=9E9ED6D2FC9DBDFDFB8B8E93906D9212","UTF-8",true);
        if (sign.equals(sign1)){
            return true;
        }else{
            return false;
        }
    }

    //字符串格式化
    public static String formatStr(String text) {
        return (text == null) ? "" : text.trim();
    }

}
