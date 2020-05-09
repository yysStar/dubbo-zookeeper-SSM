package com.qiyun.controller;

import com.qiyun.api.PayApi;
import com.qiyun.common.Result;
import com.qiyun.config.SwiftpassConfig;
import com.qiyun.controller.base.BaseController;
import com.qiyun.dto.Member2DTO;
import com.qiyun.dto.PayOrderDTO;
import com.qiyun.type.WalletTransType;
import com.qiyun.util.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
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
@RequestMapping("/xingYe")
public class WXWapController extends BaseController {

    private static final long serialVersionUID = 1L;

    private static Logger log = Logger.getLogger(WXWapController.class);

    public static Map<String,String> orderResult; //用来存储订单的交易状态(key:订单号，value:状态(0:未支付，1：已支付))  ---- 这里可以根据需要存储在数据库中
    public static int orderStatus=0;

    @Resource
    private PayApi payApi;

    private String service = "pay.weixin.wappay";
    private String mch_id = "";
    private String out_trade_no = "";  //订单号
    private String body = "";      //商品描述
    private String total_fee;   //总金额(分为单位)
    private String mch_create_ip = "";   //终端ip
    private String notify_url = "";     //异步通知地址
    private String callback_url = "";     //同步通知地址
    private String device_info = "";     //应用类型
    private String mch_app_name = "";     //应用名
    private String nonce_str = "";     //随机字符串

    static String realmName;
    static String mch_app_id;

    static{
        Properties prop=new Properties();
        try {
            prop.load(WXWapController.class.getClassLoader().getResourceAsStream("config/pay.properties"));
            realmName = prop.getProperty("realmName");
            mch_app_id = prop.getProperty("mch_app_id");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/wxWapPay",method = RequestMethod.POST)
    @ResponseBody
    public Result wxWapPay() throws IOException {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");

        Result result = new Result();

        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        }

        int type = getInt("type", 1);
//        int type = 1;
        String rate = getStr("rate");

        SortedMap<String,String> map = new TreeMap();

        mch_id = SwiftpassConfig.mch_id;
        nonce_str = String.valueOf(new Date().getTime());
        out_trade_no = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        for(int i=0;i<6;i++){
            out_trade_no+=new Random().nextInt(10);
        }
        body = "麒云充值";
        total_fee = request.getParameter("orderAmount");
        mch_create_ip = request.getRemoteAddr();
        notify_url = realmName+"/xingYe/wxWapPayCallBack";
//        notify_url = "https://pay.api.qiyun88.cn/xingYe/wxWapPayCallBack";
        if (type==1){
            //余额
            callback_url = mch_app_id+"/recharge";
        }else{
            //云朵
            callback_url = mch_app_id+"/cloudRecharge";
        }

        mch_app_name = "麒云";

        int device_info_type = getInt("device_info", 1);
        if (device_info_type==1){
            device_info="iOS_SDK";
        }else{
            device_info="AND_SDK";
        }


        map.put("service", service);
        map.put("mch_id", mch_id);
        map.put("out_trade_no", out_trade_no);
        map.put("body", body);
        map.put("total_fee", total_fee);
        map.put("mch_create_ip", mch_create_ip);
        map.put("notify_url",notify_url );
        map.put("callback_url", callback_url);
        map.put("device_info", this.device_info);
        map.put("mch_app_name", mch_app_name);
        map.put("mch_app_id", mch_app_id);
        map.put("nonce_str", nonce_str);
        //重复提交的时候直接查询本地的状态
       /* if(orderResult != null && orderResult.containsKey(map.get("out_trade_no"))){
            String status = "0".equals 0(orderResult.get(map.get("out_trade_no"))) ? "未支付" : "已支付";
            resp.setHeader("Content-type", "text/html;charset=UTF-8");
            resp.getWriter().write(status);
        }else{*/

        Map<String,String> params = SignUtils.paraFilter(map);
        StringBuilder buf = new StringBuilder((params.size() +1) * 10);
        SignUtils.buildPayParams(buf,params,false);
        String preStr = buf.toString();
        String sign = MD5.sign(preStr, "&key=" + SwiftpassConfig.key, "utf-8");
        map.put("sign", sign);

        String reqUrl = SwiftpassConfig.req_url;

        CloseableHttpResponse resp = null;
        CloseableHttpClient client = null;
        String res = null;
        try {
            HttpPost httpPost = new HttpPost(reqUrl);
            StringEntity entityParams = new StringEntity(XmlUtils.parseXML(map),"utf-8");
            httpPost.setEntity(entityParams);
            //httpPost.setHeader("Content-Type", "text/xml;charset=ISO-8859-1");
            client = HttpClients.createDefault();
            resp = client.execute(httpPost);
            if(resp != null && resp.getEntity() != null){
                Map<String,String> resultMap = XmlUtils.toMap(EntityUtils.toByteArray(resp.getEntity()), "utf-8");
                res = XmlUtils.toXml(resultMap);

                if(resultMap.containsKey("sign")){
                    if(!SignUtils.checkParam(resultMap, SwiftpassConfig.key)){
                        res = "验证签名不通过";
                    }else{
                        if("0".equals(resultMap.get("status")) && "0".equals(resultMap.get("result_code"))){
                            if(orderResult == null){
                                orderResult = new HashMap<String,String>();
                            }
                            orderResult.put(map.get("out_trade_no"), "0");//初始状态

                            //插入支付订单表
                            PayOrderDTO payOrderDTO = new PayOrderDTO();
                            payOrderDTO.setMemberId(member2DTO.getId());
                            payOrderDTO.setId(out_trade_no);
                            payOrderDTO.setAmount(Integer.parseInt(map.get("total_fee")));
                            payOrderDTO.setPayTime(new Date());
                            payOrderDTO.setStatus("00");
                            payOrderDTO.setType(type);
                            payOrderDTO.setProvider("兴业微信");
                            payOrderDTO.setRate(Double.parseDouble(StringUtils.isNullOrBlank(rate)?"1":rate));
                            double a = payOrderDTO.getAmount();
                            log.info("兴业微信-----------用户id:"+member2DTO.getId()+",金额:"+ NumberTools.round( a/100,2)+"------------");
                            payApi.insert(payOrderDTO);

                            String pay_info = resultMap.get("pay_info");
                            //System.out.println("code_img_url"+code_img_url);
                            request.setAttribute("pay_info", pay_info);
                            request.setAttribute("out_trade_no", map.get("out_trade_no"));
                            request.setAttribute("total_fee", map.get("total_fee"));
                            request.setAttribute("body", map.get("body"));
                            response.sendRedirect(pay_info);
                        }else{
                            request.setAttribute("result", res);
                        }
                    }
                }
            }else{
                res = "操作失败";
            }
        } catch (Exception e) {
            e.printStackTrace();
            res = "系统异常";
        } finally {
            if(resp != null){
                resp.close();
            }
            if(client != null){
                client.close();
            }
        }
        if(res.startsWith("<")){
            response.setHeader("Content-type", "text/xml;charset=UTF-8");
        }else{
            response.setHeader("Content-type", "text/html;charset=UTF-8");
        }
        response.getWriter().write(res);
        //}

        return null;
    }


    @RequestMapping(value = "/wxWapPayCallBack",method = RequestMethod.POST)
    @ResponseBody
    public void callBack(){
        try {
            log.info("兴业回调");
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            String resString = XmlUtils.parseRequst(request);
            log.info("通知内容:"+resString);
            String respString = "fail";
            if(resString != null && !"".equals(resString)){
                Map<String,String> map = XmlUtils.toMap(resString.getBytes(), "utf-8");
                String res = XmlUtils.toXml(map);
                if(map.containsKey("sign")){
                    if(!SignUtils.checkParam(map, SwiftpassConfig.key)){
                        res = "验证签名不通过";
                        respString = "fail";
                        log.info("验证签名不通过");
                    }else{
                        log.info("验证签名通过");
                        String status = map.get("status");
                        if(status != null && "0".equals(status)){
                            String result_code = map.get("result_code");
                            if(result_code != null && "0".equals(result_code)){
                                if(WXWapController.orderResult == null){
                                    WXWapController.orderResult = new HashMap<String,String>();
                                }
                                String out_trade_no = map.get("out_trade_no");
                                WXWapController.orderResult.put(out_trade_no, "1");
                                //System.out.println(TestPayServlet.orderResult);
                            }
                        }

                        //此处可以在添加相关处理业务，校验通知参数中的商户订单号out_trade_no和金额total_fee是否和商户业务系统的单号和金额是否一致，一致后方可更新数据库表中的记录。
                        String pay_result = map.get("pay_result");
                        if (!StringUtils.isNullOrBlank(pay_result) && "0".equals(pay_result)){
                            boolean flag = payApi.callBackForPay(map.get("out_trade_no"), map.get("out_transaction_id"), (int) (Double.parseDouble(map.get("total_fee"))), WalletTransType.XY_WX.getValue(), "微信充值");
                            if (flag){
                                log.info("兴业回调修改数据库成功");
                                respString = "success";
                            }
                        }
                    }
                }
            }
            response.getWriter().write(respString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
