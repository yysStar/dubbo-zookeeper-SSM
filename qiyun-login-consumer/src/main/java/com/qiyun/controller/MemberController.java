package com.qiyun.controller;

import base.BaseController;
import com.alibaba.fastjson.JSON;
import com.qiyun.api.UserApi;
import com.qiyun.common.Result;
import com.qiyun.dto.Member2DTO;
import com.qiyun.httpUtil.RedisUtil;
import com.qiyun.util.Constants;
import com.qiyun.util.CookieUtils;
import com.qiyun.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/member")
public class MemberController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Resource
    private UserApi userApi;

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
        result = userApi.getMemberAgent(member2DTO.getId());
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
     * 获取登录信息
     *
     * @return
     */
    @RequestMapping(path = "/checkLogin", method = RequestMethod.GET)
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
    }

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Result login() {
        Jedis jedis = RedisUtil.getJedis();
        String account = request.getParameter("username");
        String password = request.getParameter("password");
        String isSaveUserName = request.getParameter("isSaveUserName");
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
//        jedis.set(token, json);
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
}
