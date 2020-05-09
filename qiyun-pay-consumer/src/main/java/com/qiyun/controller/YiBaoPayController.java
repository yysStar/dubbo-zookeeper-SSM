package com.qiyun.controller;

import com.qiyun.api.PayApi;
import com.qiyun.common.Result;
import com.qiyun.controller.base.BaseController;
import com.qiyun.dto.DaiFu;
import com.qiyun.dto.Member2DTO;
import com.qiyun.dto.PayOrderDTO;
import com.qiyun.type.WalletTransType;
import com.qiyun.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/yiBao")
public class YiBaoPayController extends BaseController {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(YiBaoPayController.class);

    @Resource
    private PayApi payApi;

    static String realmName;
    static String mch_app_id;

    static{
        Properties prop=new Properties();
        try {
            prop.load(YiBaoPayController.class.getClassLoader().getResourceAsStream("config/pay.properties"));
            realmName = prop.getProperty("realmName");
            mch_app_id = prop.getProperty("mch_app_id");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/quickPay",method = RequestMethod.POST)
    @ResponseBody
    public Result pay(){
        //UTF-8编码
       Result result = new Result();

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            result.setSuccess(false);
            result.setMsg("您还没有登录");
            return result;
        }

        int type2 = getInt("type2", 1);
        String rate = getStr("rate");

        String orderid = "";
        SimpleDateFormat dateFm = new SimpleDateFormat("yyyyMMddHHmmss"); //格式化当前系统日期
        orderid = dateFm.format(new Date());
        for(int i=0;i<6;i++) {
            orderid += new Random().nextInt(10);
        }
        int transtime = (int) (System.currentTimeMillis()/1000);
        int amount = getInt("amount");
        String productcatalog = "8";  //商品类别码
        String productname = "麒云88充值";     //商品名称
        int identitytype = 2;            //用户标志类型
        String identityid = member2DTO.getId()+"";      //用户标志
        int terminaltype = 1;    //终端标志类型
        String terminalid = "44-45-53-54-00-00";      //终端标志id
        String userip = request.getRemoteAddr();
        String callbackurl = realmName+"/yiBao/quickPayAccept";   //后台回调
        String fcallbackurl = "";
        if (type2==1) {
            fcallbackurl = mch_app_id+"/recharge";

        }else if(type2==2){
            fcallbackurl = mch_app_id+"/cloudRecharge";
        }

        if (StringUtils.isNullOrBlank(fcallbackurl)){
            result.setSuccess(false);
            result.setMsg("参数错误");
            return result;
        }

        //使用TreeMap
        TreeMap<String, Object> treeMap	= new TreeMap<String, Object>();

        treeMap.put("orderid", 	orderid);
        treeMap.put("transtime", 		transtime);
        treeMap.put("amount", 		amount);
        treeMap.put("productcatalog", 			productcatalog);
        treeMap.put("productname", 			productname);
		treeMap.put("identitytype", 	identitytype);
        treeMap.put("identityid", 		identityid);
		treeMap.put("terminaltype", 			terminaltype);
        treeMap.put("terminalid", 		terminalid);
        treeMap.put("terminaltype", 		terminaltype);
        treeMap.put("terminalid", 		terminalid);
        treeMap.put("userip", 		userip);
        treeMap.put("callbackurl", 		callbackurl);
        treeMap.put("fcallbackurl", 		fcallbackurl);

        //第一步 生成AESkey及encryptkey
        String AESKey		= PaymobileUtils.buildAESKey();
        String encryptkey	= PaymobileUtils.buildEncyptkey(AESKey);

        //第二步 生成data
        String data			= PaymobileUtils.buildData(treeMap, AESKey);

        //第三步 获取商户编号及请求地址，并组装支付链接
        String merchantaccount	= PaymobileUtils.getMerchantaccount();
        String url				= PaymobileUtils.getRequestUrl(PaymobileUtils.PAYAPI_NAME);
        TreeMap<String, String> responseMap	= PaymobileUtils.httpPost(url, merchantaccount, data, encryptkey);

        System.out.println("url=" + url);
        System.out.println("merchantaccount=" + merchantaccount);
        System.out.println("data=" + data);
        System.out.println("encryptkey=" + encryptkey);

        //第四步 判断请求是否成功
        if(responseMap.containsKey("error_code")) {
            result.setSuccess(false);
            result.setMsg("支付出错");
            return result;
        }

        //第五步 请求成功，则获取data、encryptkey，并将其解密
        String data_response						= responseMap.get("data");
        String encryptkey_response					= responseMap.get("encryptkey");
        TreeMap<String, String> responseDataMap	= PaymobileUtils.decrypt(data_response, encryptkey_response);

        //第六步 sign验签
        if(!PaymobileUtils.checkSign(responseDataMap)) {
            result.setSuccess(false);
            result.setMsg("验签失败");
            return result;
        }

        //第七步 判断请求是否成功
        if(responseDataMap.containsKey("error_code")) {
            result.setSuccess(false);
            result.setMsg("支付出错");
            return result;
        }
        String orderid1 = responseDataMap.get("orderid"); //商户订单号
        String yborderid = responseDataMap.get("yborderid"); //易宝流水号
        String payurl = responseDataMap.get("payurl"); //支付连接
        String imghexstr = responseDataMap.get("imghexstr"); //二维码字符串
        //第八步 进行业务处理
        //插入支付订单表
        PayOrderDTO payOrderDTO = new PayOrderDTO();
        payOrderDTO.setMemberId(member2DTO.getId());
        payOrderDTO.setId(orderid);
        payOrderDTO.setAmount(amount);
        payOrderDTO.setPayTime(new Date());
        payOrderDTO.setStatus("00");
        payOrderDTO.setType(type2);
        payOrderDTO.setProvider("易宝快捷支付");
        payOrderDTO.setRate(Double.parseDouble(StringUtils.isNullOrBlank(rate)?"1":rate));
        double a = payOrderDTO.getAmount();
        log.info("易宝快捷-----------用户id:"+member2DTO.getId()+",金额:"+ NumberTools.round( a/100,2)+"------------");
        result = payApi.insert(payOrderDTO);
        if (result.isSuccess()){
            result.setMsg(payurl);
        }
        return result;
    }


    @RequestMapping(value = "/quickPayAccept",method = RequestMethod.POST)
    @ResponseBody
    public void accept(){
        //UTF-8编码
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        log.info("易宝回调");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out	= null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String data			= formatStr(request.getParameter("data"));
        String encryptkey	= formatStr(request.getParameter("encryptkey"));
//        System.out.println("data1:"+data);
//        System.out.println("encryptkey1:"+encryptkey);
        data = data.replace(" ","+");
        encryptkey = encryptkey.replace(" ","+");
        log.info("data:"+data);
        log.info("encryptkey:"+encryptkey);
//        System.out.println("data :"+data);
//        System.out.println("encryptkey :"+encryptkey);
        //解密data
//        data="4KkalAZQwuMUznFPLtNTpk6JC9C54nmZKttlzRaRoi3/84puyXqnI8U8lDRHywktOXt84xiIKqHsCLNPfcjlX4AH4Y3iN7zRhE/3wdH4yK76a5+JXcROil2ZF6toTsUCG4ES6P7tIRrfaZcyy52wfI9ktPsT1wlyu0dM8/nG43Jz/wj6dCDbXqNvgBGc2GRU0+Iiwn1oOxMOLhkaPpJKC73CRuCZD4spJA0R19VO6okGlN5Fm9dx92s2FJNK2eXaKo1lSEtZBJLJP7iqXr64rEnGKQKvZA1eyijwLsva/oQXYtMPD94i119mGE8ypZBF6KGTTDI/lzeZgTjcv4IBxa+BVz6yQp+7Gl4c5kECKvQN32HQ6IBlemEf+MyxPf3fVoMvG2jKiEPcI5a/L4nRZSYPlMti8t7AeiBXCzNHBdcdBhTOnmgI652jlQwYe1WDBnmCkpvfaCFSl69skiEjGAS5O1B+3CPTMBak8+81puTj4tUgzlD+wRmovJIWDTVs";
//        encryptkey="R4MXWSMkY9BFPvykSUkcElwkVQE9cWcak8Tdo5c+PfbIfY36EX5R+j6yi9aCl7k03HOJsxYJFT7QKN0fvQg8NAKFvFgL+1WVu9cAFC8Fbim8kxlv7nWf/MI3fGz0zu77rB/sUCXyP8Z1tSrcM0FFityCrGJSedlQa+tNiIuRz/Y=";
        TreeMap<String, String>	dataMap	= PaymobileUtils.decrypt(data, encryptkey);


        //sign验签
        if(!PaymobileUtils.checkSign(dataMap)) {
            log.info("易宝回调sign 验签失败！");
            out.println("sign 验签失败！");
            out.println("<br><br>dataMap:" + dataMap);
            return;
        }

        /*
          业务
         */
        String status = dataMap.get("status");
        if (!StringUtils.isNullOrBlank(status) && "1".equals(status)){
            boolean flag = payApi.callBackForPay(dataMap.get("orderid"), dataMap.get("yborderid"), Integer.parseInt(dataMap.get("amount")), WalletTransType.YB_QUICK.getValue(), "快捷支付充值");
            if (flag){
                //回写SUCCESS
                out.println("SUCCESS");
                out.flush();
                out.close();
            }
        }
    }

    public String formatStr(String text) {
        return (text == null) ? "" : text.trim();
    }


}
