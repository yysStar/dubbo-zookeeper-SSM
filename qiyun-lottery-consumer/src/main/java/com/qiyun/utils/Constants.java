package com.qiyun.utils;

public class Constants {
    //用户名
    public static final String USER_NAME = "user_name";
    //token
    public static final String TOKEN = "token";
    //错误编码
    public static final String CODE = "code";
    //错误信息
    public static final String MSG = "message";
    //成功code返回200
    public static final int SUCCESS_CODE = 200;
    //成功
    public static final String SUCCESS_MSG = "成功";
    // 请求参数非法
    public static final int ERROR_CODE_1 = 301;
    // 请求参数非法
    public static final String ERROR_MSG_1 = "非法请求!";
    public static final String ERROR_MSG_1_1 = "手机号格式有误!";
    public static final String ERROR_MSG_1_2 = "用户名格式有误!";
    public static final String ERROR_MSG_1_3 = "密码格式有误!";
    public static final String ERROR_MSG_1_4 = "手机号及用户名不能同时为空!";
    public static final String ERROR_MSG_1_5 = "手机号不能为空!";
    public static final String ERROR_MSG_1_6 = "用户名不能为空!";
    public static final String ERROR_MSG_1_7 = "密码不能为空!";
    //参数错误
    public static final int ERROR_CODE_2 = 302;
    //参数错误
    public static final String ERROR_MSG_2 = "用户名或密码错误!";
    public static final String ERROR_MSG_3 = "验证码错误!";
    //图片验证码
    public static final int ERROR_CODE_3 = 303;
    //图片验证码错误提示
    public static final String ERROR_MSG_3_1 = "图片验证码不能为空!";
    public static final String ERROR_MSG_3_2 = "该图片验证码已失效!";
    public static final String ERROR_MSG_3_3 = "输入的图片验证码有误!";
    public static final String ERROR_MSG_3_4 = "生成图片验证码失败!";

    //短信验证码
    public static final int ERROR_CODE_4 = 304;
    public static final String ERROR_MSG_4_1 = "验证码不能为空!";
    public static final String ERROR_MSG_4_2 = "输入验证码有误!";
    public static final String ERROR_MSG_4_3 = "验证码已失效,请重新获取!";

    //短信错误
    public static final int SMS_ERROR_CODE = 500;
    //图片验证码session的key
    public static final String VER_CODE = "verCode";
    //短信验证码session的key
    public static final String SMS_AUTH_CODE = "SmsAuthCode";
    //短信发送间隔验证
    public static final String SMS_ERROR_CODE_1 = "发送间隔太短，请稍后再试！";

}
