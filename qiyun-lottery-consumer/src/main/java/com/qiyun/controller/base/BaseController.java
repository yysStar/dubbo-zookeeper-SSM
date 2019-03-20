package com.qiyun.controller.base;

import com.alibaba.fastjson.JSON;
import com.qiyun.dto.Member2DTO;
import com.qiyun.httpUtil.RedisUtil;
import com.qiyun.utils.Constants;
import com.qiyun.utils.CookieUtils;
import com.qiyun.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
public class BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    private int marketSourceId = 0; // 推广渠道编号，默认为0：直接输入网址
    private Long terminalID=0L;

    public Member2DTO checkLogin(){
        Jedis jedis = RedisUtil.getJedis();
        String token = getStr("token");
        System.out.println(token);
        if (StringUtils.isNullOrBlank(token)){
            return null;
        }
        String json = jedis.get(token);
        if (StringUtils.isNullOrBlank(json)){
            return null;
        }
        jedis.setex(token,604800,json);
        jedis.close();
        return JSON.parseObject(json,Member2DTO.class);
    }

    public Member2DTO getLogin(){
        Jedis jedis = RedisUtil.getJedis();
        Cookie cookie = CookieUtils.getCookieByName(request, Constants.TOKEN);
        if (cookie==null){
            return null;
        }
        String json = jedis.get(cookie.getValue());
        if (StringUtils.isNullOrBlank(json)){
            return null;
        }
        jedis.setex(cookie.getValue(),86400,json);
        jedis.close();
        return JSON.parseObject(json,Member2DTO.class);
    }

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

    public String getStr(String key){
        String s = request.getParameter(key);
        return s;
    }

    public Integer getInt(String key){
        String parameter = request.getParameter(key);
        if (StringUtils.isNullOrBlank(parameter)){
            return null;
        }
        int i = Integer.parseInt(parameter);
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

    public Double getDouble(String key){
        String parameter = request.getParameter(key);
        if (StringUtils.isNullOrBlank(parameter)){
            return null;
        }
        double i = Double.parseDouble(parameter);
        return i;
    }

    public Double getDouble(String key, int n){
        String s = request.getParameter(key);
        double i;
        if(s == null || "".equals(s)) {
            i = n;
        } else {
            i = Double.parseDouble(s);
        }
        return i;
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
