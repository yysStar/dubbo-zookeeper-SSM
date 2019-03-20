package com.qiyun.controller.base;

import com.qiyun.util.RedisUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@Controller
public class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    private int marketSourceId = 0; // 推广渠道编号，默认为0：直接输入网址
    private Long terminalID=0L;

    /**
     * 获取推广渠道号
     * */
    public int getMarketSourceId() {
        return marketSourceId;
    }
    /**
     * 获取终端ID
     * */
    public long getTerminalID(){
        return this.terminalID;
    }

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        //设置返回参数编码
        response.setHeader("Content-Type", "text/html;charset=utf-8");
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        logger.info("入参requestURL-----：" + request.getRequestURL() + request.getQueryString());
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    protected static Map<String, Object> resMap(Map<String, Object> map){
        logger.info("出参map------:" + JSONObject.fromObject(map).toString());
        return map;
    }

    /**
     * 判断客户端是否要求进行gzip压缩处理
     *
     * @return
     */
    protected static boolean isGzipSupport(HttpServletRequest request) {
        String contentType = request.getHeader("Content-Type");
        String contentEncoding = request.getHeader("Content-Encoding");
        return ((contentType != null && (contentType.indexOf("gzip") != -1)) ||
                (contentEncoding != null && (contentEncoding.indexOf("gzip") != -1)) );
    }

    /**
     * 校验登录
     * @return
     */
    public String checkLogin(){
        Jedis jedis = RedisUtil.getJedis();
        String token = getStr("token");
        String json = jedis.get(token);
        jedis.close();
        return json;
    }

    public String getStr(String key){
        String s = request.getParameter(key);
        return s;
    }

    public <T> T request2Bean(HttpServletRequest request,   //返回值为随意的类型   传入参数为request 和该随意类型
                                     Class<T> beanClass) {
        try {
            T bean = beanClass.newInstance();   //实例化随意类型
            Enumeration en = request.getParameterNames();   //获得参数的一个列举
            while (en.hasMoreElements()) {         //遍历列举来获取所有的参数
                String name = (String) en.nextElement();
                String value = request.getParameter(name);
                BeanUtils.setProperty(bean, name, value);   //注意这里导入的是
                // import org.apache.commons.beanutils.BeanUtils;
            }
            return bean;
        } catch (Exception e) {
            logger.info("------------入参转换失败");
            throw new RuntimeException(e);  //如果错误 则向上抛运行时异常
        }
    }

    public int getInt(String key){
        int i = -100;
        try {
           i  = Integer.parseInt(request.getParameter(key));
        } catch (Exception e){
            return i;
        }
        return i;
    }

    public int getInt(String key, int n){
        String s = request.getParameter(key);
        int i;
        if(s == null || "".equals(s)) {
            i = n;
        } else {
            i = Integer.parseInt(s);
        }
        return i;
    }

    public double getDouble(String key){
        String s = request.getParameter(key);
        double d;
        if(s == null || "".equals(s)) {
            d = 0;
        } else {
            d = Double.parseDouble(s);
        }
        return d;
    }

    public Map getMap(){
        Map map = request.getParameterMap();
        return map;
    }

    /**
     * 获取请求完整路径
     * @param request
     * @return
     */
    public String getUrl(HttpServletRequest request){
        String url = request.getRequestURI();
        String params = "";
        if(request.getQueryString()!=null){
            params = request.getQueryString().toString();
        }
        if(!"".equals(params)){
            url = url+"?"+params;
        }
        return url;
    }

//    /**
//     * 获取登录用户信息
//     * @return
//     */
//    public SessionUser getSessionUser(){
//        Object session = request.getSession().getAttribute(Constants.KEY_SESSION_USER);
//        return session == null ? null : (SessionUser) session;
//    }

}
