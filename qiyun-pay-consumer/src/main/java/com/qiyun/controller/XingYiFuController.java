package com.qiyun.controller;


import com.google.common.collect.Maps;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.qiyun.api.PayApi;
import com.qiyun.common.Result;
import com.qiyun.controller.base.BaseController;
import com.qiyun.dto.Member2DTO;
import com.qiyun.dto.PayOrderDTO;
import com.qiyun.type.WalletTransType;
import com.qiyun.util.*;
import com.qiyun.xingYiFuUtils.Map2FormUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/xingYiFu")
public class XingYiFuController extends BaseController {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(XingYiFuController.class);

    @Resource
    private PayApi payApi;


    @RequestMapping(value = "/zfbWapPay",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> zfbWapPay(){
        Map<String,Object> map = new HashMap<String,Object>();

        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_2);
            map.put(Constants.MSG,Constants.ERROR_MSG_2_4);
            return map;
        }
        int order_amt = getInt("order_amt");
        String rate = getStr("rate");
        int type = getInt("type", 1); //1余额充值  2云朵
        TreeMap<String, String> paramMap = Maps.newTreeMap();
        String merchant_id = "207507139541995520";
        String order_id = PayUtils.getPayId();
        String biz_code = "1004";
        String return_url;
        if (type==1){
            return_url = "https://m.qyun88.com/recharge";
//            return_url = "https://m.qiyun88.cn/recharge";
        }else{
            return_url = "https://m.qyun88.com/cloudRecharge";
//            return_url = "https://m.qiyun88.cn/cloudRecharge";
        }
        String bg_url = "https://pay.api.qyun88.com/xingYiFu/zfbWapAccept";
//        String bg_url = "https://pay.api.qiyun88.cn/xingYiFu/zfbWapAccept";
        paramMap.put("order_amt", order_amt+"");
        paramMap.put("return_url", return_url);
        paramMap.put("bg_url", bg_url);
        paramMap.put("biz_code", biz_code);
        paramMap.put("order_id", order_id);
        paramMap.put("merchant_id", merchant_id);
        String sign = SignUtils.createSign(paramMap, "8ccb796af71967dc81234531168233d8");
        paramMap.put("sign", sign);

        PayOrderDTO payOrderDTO = new PayOrderDTO();
        payOrderDTO.setMemberId(member2DTO.getId());
        payOrderDTO.setId(order_id);
        payOrderDTO.setAmount(order_amt);
        payOrderDTO.setPayTime(new Date());
        payOrderDTO.setStatus("00");
        payOrderDTO.setType(type);
        payOrderDTO.setProvider("星驿付支付宝wap");
        payOrderDTO.setRate(Double.parseDouble(StringUtils.isNullOrBlank(rate) ? "1" : rate));
        payApi.insert(payOrderDTO);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA,paramMap);
        return map;
    }

    @RequestMapping(value = "/zfbWapAccept",method = RequestMethod.POST)
    @ResponseBody
    public void zfbWapAccept(){
        Enumeration e = request.getParameterNames();
        SortedMap<String, String> map = new TreeMap<String, String>();
        while (e.hasMoreElements()) {
            String param = (String) e.nextElement();
            map.put(param, request.getParameter(param));
        }
        log.info("星驿付支付宝wap map:"+map.toString());
        try {
            if (map.get("state").equals("0")){
                boolean flag = payApi.callBackForPay(map.get("order_id"), map.get("up_order_id"), Integer.parseInt(map.get("order_amt")), WalletTransType.XYF_ZFB.getValue(), "支付宝充值");
                if (flag) {
                    response.getWriter().write("success");
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @RequestMapping(value = "/wxScanPay",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> wxScanPay(){
        Map<String,Object> map = new HashMap<String,Object>();

        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_2);
            map.put(Constants.MSG,Constants.ERROR_MSG_2_4);
            return map;
        }

        int order_amt = getInt("order_amt");
        String rate = getStr("rate");
        int type = getInt("type", 1); //1余额充值  2云朵
        TreeMap<String, String> paramMap = Maps.newTreeMap();
        String merchant_id = "207507139541995520";
        String order_id = PayUtils.getPayId();
        String biz_code = "1001";
        String return_url;
        if (type==1){
            return_url = "https://m.qyun88.com/recharge";
//            return_url = "https://m.qiyun88.cn/recharge";
        }else{
            return_url = "https://m.qyun88.com/cloudRecharge";
//            return_url = "https://m.qiyun88.cn/cloudRecharge";
        }
        String bg_url = "https://pay.api.qyun88.com/xingYiFu/wxScanAccept";
//        String bg_url = "https://pay.api.qiyun88.cn/xingYiFu/wxScanAccept";
        paramMap.put("order_amt", order_amt+"");
        paramMap.put("return_url", return_url);
        paramMap.put("bg_url", bg_url);
        paramMap.put("biz_code", biz_code);
        paramMap.put("order_id", order_id);
        paramMap.put("merchant_id", merchant_id);
        String sign = SignUtils.createSign(paramMap, "8ccb796af71967dc81234531168233d8");
        paramMap.put("sign", sign);
        String url = "http://118.89.46.160/zhitong-api/services/mainScan/pay";

        System.out.println("req=="+ JSONObject.fromObject(paramMap));
        String result = Sender.sendHttpReq(url, JSONObject.fromObject(paramMap), "utf-8");
        System.out.println("rsp=="+result);

        log.info("星驿付微信扫码用户:"+member2DTO.getId()+"金额:"+order_amt+"分");
        JSONObject jsonObject = JSONObject.fromObject(result);
        String rsp_code = jsonObject.optString("rsp_code");
        String pay_url = jsonObject.optString("pay_url");
        String rsp_msg = jsonObject.optString("rsp_msg");
        String state = jsonObject.optString("state");
        if (rsp_code.equals("00") && state.equals("0")) {
            //插入支付订单表
            PayOrderDTO payOrderDTO = new PayOrderDTO();
            payOrderDTO.setMemberId(member2DTO.getId());
            payOrderDTO.setId(order_id);
            payOrderDTO.setAmount(order_amt);
            payOrderDTO.setPayTime(new Date());
            payOrderDTO.setStatus("00");
            payOrderDTO.setType(type);
            payOrderDTO.setProvider("星驿付微信扫码");
            payOrderDTO.setRate(Double.parseDouble(StringUtils.isNullOrBlank(rate) ? "1" : rate));
            payApi.insert(payOrderDTO);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA, pay_url);
        }else {
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,rsp_msg);
        }

        return map;
    }


    @RequestMapping(value = "/wxScanAccept",method = RequestMethod.POST)
    @ResponseBody
    public void wxScanAccept(){
        Enumeration e = request.getParameterNames();
        SortedMap<String, String> map = new TreeMap<String, String>();
        while (e.hasMoreElements()) {
            String param = (String) e.nextElement();
            map.put(param, request.getParameter(param));
        }
        log.info("星驿付微信扫码map:"+map.toString());
        try {
            if (map.get("state").equals("0")){
                boolean flag = payApi.callBackForPay(map.get("order_id"), map.get("up_order_id"), Integer.parseInt(map.get("order_amt")), WalletTransType.XYF_WX.getValue(), "微信充值");
                if (flag) {
                    response.getWriter().write("success");
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @RequestMapping(value = "/zfbScanPay",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> zfbScanPay(){
        Map<String,Object> map = new HashMap<String,Object>();

        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_2);
            map.put(Constants.MSG,Constants.ERROR_MSG_2_4);
            return map;
        }

        int order_amt = getInt("order_amt");
        String rate = getStr("rate");
        int type = getInt("type", 1); //1余额充值  2云朵
        TreeMap<String, String> paramMap = Maps.newTreeMap();
        String merchant_id = "207507139541995520";
        String order_id = PayUtils.getPayId();
        String biz_code = "1002";
        String return_url;
        if (type==1){
            return_url = "https://m.qyun88.com/recharge";
//            return_url = "https://m.qiyun88.cn/recharge";
        }else{
            return_url = "https://m.qyun88.com/cloudRecharge";
//            return_url = "https://m.qiyun88.cn/cloudRecharge";
        }
        String bg_url = "https://pay.api.qyun88.com/xingYiFu/zfbScanAccept";
//        String bg_url = "https://pay.api.qiyun88.cn/xingYiFu/zfbScanAccept";
        paramMap.put("order_amt", order_amt+"");
        paramMap.put("return_url", return_url);
        paramMap.put("bg_url", bg_url);
        paramMap.put("biz_code", biz_code);
        paramMap.put("order_id", order_id);
        paramMap.put("merchant_id", merchant_id);
        String sign = SignUtils.createSign(paramMap, "8ccb796af71967dc81234531168233d8");
        paramMap.put("sign", sign);
        String url = "http://118.89.46.160/zhitong-api/services/mainScan/pay";

        System.out.println("req=="+ JSONObject.fromObject(paramMap));
        String result = Sender.sendHttpReq(url, JSONObject.fromObject(paramMap), "utf-8");
        System.out.println("rsp=="+result);

        log.info("星驿付支付宝扫码用户:"+member2DTO.getId()+"金额:"+order_amt+"分");
        JSONObject jsonObject = JSONObject.fromObject(result);
        String rsp_code = jsonObject.optString("rsp_code");
        String pay_url = jsonObject.optString("pay_url");
        String rsp_msg = jsonObject.optString("rsp_msg");
        String state = jsonObject.optString("state");
        if (rsp_code.equals("00") && state.equals("0")) {
            //插入支付订单表
            PayOrderDTO payOrderDTO = new PayOrderDTO();
            payOrderDTO.setMemberId(member2DTO.getId());
            payOrderDTO.setId(order_id);
            payOrderDTO.setAmount(order_amt);
            payOrderDTO.setPayTime(new Date());
            payOrderDTO.setStatus("00");
            payOrderDTO.setType(type);
            payOrderDTO.setProvider("星驿付支付宝扫码");
            payOrderDTO.setRate(Double.parseDouble(StringUtils.isNullOrBlank(rate) ? "1" : rate));
            payApi.insert(payOrderDTO);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA, pay_url);
        }else {
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,rsp_msg);
        }

        return map;
    }


    @RequestMapping(value = "/zfbScanAccept",method = RequestMethod.POST)
    @ResponseBody
    public void zfbScanAccept(){
        Enumeration e = request.getParameterNames();
        SortedMap<String, String> map = new TreeMap<String, String>();
        while (e.hasMoreElements()) {
            String param = (String) e.nextElement();
            map.put(param, request.getParameter(param));
        }
        log.info("星驿付支付宝扫码map:"+map.toString());
        try {
            if (map.get("state").equals("0")){
                boolean flag = payApi.callBackForPay(map.get("order_id"), map.get("up_order_id"), Integer.parseInt(map.get("order_amt")), WalletTransType.XYF_ZFB.getValue(), "支付宝充值");
                if (flag) {
                    response.getWriter().write("success");
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /*@RequestMapping(value = "/onLineBankPay",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> onLineBankPay(){
        Map<String,Object> map = new HashMap<String,Object>();

        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_2);
            map.put(Constants.MSG,Constants.ERROR_MSG_2_4);
            return map;
        }

        String rate = getStr("rate");
        TreeMap<String, String> paramMap = Maps.newTreeMap();
        int type = getInt("type", 1);
        String order_id = PayUtils.getPayId();;
        String merchant_id = "195118106673287168";
        String order_amt = getInt("order_amt")+"";
        String return_url;
        if (type==1){
            return_url = "https://m.qyun88.com/recharge";
//            return_url = "http://m.qiyun88.cn/recharge";
        }else{
            return_url = "https://m.qyun88.com/cloudRecharge";
//            return_url = "http://m.qiyun88.cn/cloudRecharge";
        }
        String bg_url = "https://pay.api.qyun88.com/yinFu/onLineBankAccept";
//        String bg_url = "https://pay.api.qiyun88.cn/yinFu/onLineBankAccept";
        String bank_code = request.getParameter("bankCode");
        String card_type = request.getParameter("cardType");


        paramMap.put("order_id", order_id);
        paramMap.put("merchant_id", merchant_id);
        paramMap.put("order_amt", order_amt);
        paramMap.put("return_url", return_url);
        paramMap.put("bg_url", bg_url);
        paramMap.put("bank_code", bank_code);
        paramMap.put("card_type", card_type);
        String sign = SignUtils.createSign(paramMap, "18ca684f6b62ccf8257c735a7b7ccb7c");
        paramMap.put("sign", sign);
        String url = "http://118.89.46.160/zhitong-api/services/onlineBank/onlineBank_v2";
        System.out.println("req=="+JSONObject.fromObject(paramMap));
        String result = Sender.sendHttpReq(url, JSONObject.fromObject(paramMap), "utf-8");
        System.out.println("rsp=="+result);
        JSONObject jsonObject = JSONObject.fromObject(result);
        String rsp_code = jsonObject.optString("rsp_code");
        String pay_url = jsonObject.optString("pay_url");
        String rsp_msg = jsonObject.optString("rsp_msg");
        String state = jsonObject.optString("state");
        if (rsp_code.equals("00") && state.equals("0")) {
            //插入支付订单表
            PayOrderDTO payOrderDTO = new PayOrderDTO();
            payOrderDTO.setMemberId(member2DTO.getId());
            payOrderDTO.setId(order_id);
            payOrderDTO.setAmount(Integer.parseInt(order_amt));
            payOrderDTO.setPayTime(new Date());
            payOrderDTO.setStatus("00");
            payOrderDTO.setType(type);
            payOrderDTO.setProvider("引付网银");
            payOrderDTO.setRate(Double.parseDouble(StringUtils.isNullOrBlank(rate) ? "1" : rate));
            payApi.insert(payOrderDTO);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA, pay_url);
        }else {
            map.put(Constants.CODE,Constants.ERROR_CODE_425);
            map.put(Constants.MSG,rsp_msg);
        }
        return map;
    }

    @RequestMapping(value = "/onLineBankAccept",method = RequestMethod.POST)
    @ResponseBody
    public void onLineBankAccept(){
        Enumeration e = request.getParameterNames();
        SortedMap<String, String> map = new TreeMap<String, String>();
        while (e.hasMoreElements()) {
            String param = (String) e.nextElement();
            map.put(param, request.getParameter(param));
        }

        try {
            Result result = payApi.callBack10(map);
            if (result.isSuccess()) {
                response.getWriter().write("success");
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }*/
}
