package com.qiyun.util;

import com.qiyun.httpUtil.WebConstants;

public class Constants {
    public final static Integer SUB_TASK_ID=0;

    public static final String pathFlt = WebConstants.getWebPath() + "masterplate/sporttery/basketball/";
    public static final String pathFlt_3g = WebConstants.getWebPath() + "masterplate/3gweb/sporttery/basketball/";
    public static final String pathHtml = WebConstants.getWebPath() + "static/sporttery/basketball/";
    public static final String pathHtml_3g = WebConstants.getWebPath() + "static/3gweb/sporttery/basketball/";
    public static final String PREFIX_A = "A"; // 如果是map<Integer,> 页面无法使用map[key]
    // 转换成String使用
    public static final String PREFIX_S = "S";
    public static final String PREFIX_OP = "OP";
    public static final String PREFIX_YP = "YP";
    public static final String PREFIX_R = "R";
    public static final String PREFIX_DXF = "DXF";

    /**
     * 抓取之后几天的比赛
     */
    public static final int dateOffsetLimit = 3;

    /**
     * 冠亚军URL
     */
    public static final String CHAMPION_URL = "http://i.sporttery.cn/rank_calculator/get_list";

    /**
     * 竞彩赛事及sp值URL
     */
    public static final String MATCH_URL = "http://i.sporttery.cn/odds_calculator/get_odds";

    /**
     * 冠亚军开关
     */
    public static final String CHAMPION = "CHAMPION";

    public static final String NOTIFY = "NOTIFY";

    /**
     * 积分比例(1元:200积分)
     */
    public static final int SCORE_RATIO = 200;

    final static public int CONSUME_PRESENT_RATE = 10; // 消费赠送比率

    //机器人名称
    public static final String ROBOT_NAME = "麒云机器人";
    //头像前缀
    public static final String PORTRAIT_PREFIX ="qyun88.oss-cn-hangzhou.aliyuncs.com/member/";
    //头像后缀
    public static final String PORTRAIT_POSTFIX =".png";
    //用户名
    public static final String USER_NAME = "user_name";
    //token
    public static final String TOKEN = "token";
    //错误编码
    public static final String CODE = "error_code";
    //错误信息
    public static final String MSG = "message";
    //返回内容
    public static final String DATA = "data";
    //成功code返回200
    public static final int SUCCESS_CODE = 200;
    //成功
    public static final String SUCCESS_MSG = "成功";
    //总条数
    public static final String TOTAL_COUNT = "totalCount";
    //连红榜
    public static final String EVEN_RED = "evenRed";
    //祥云大厅
    public static final String XYHALL = "xyHall";
    //足球赛事赛程
    public static final String FOOTBALL_MATCH = "footBallMatch";
    //足球焦点赛事
    public static final String FOOTBALL_MATCH_FOCUS = "footBallMatchFocus";
    //篮球赛事赛程
    public static final String BASKETBALL_MATCH = "basketBallMatch";
    //篮球焦点赛事
    public static final String BASKETBALL_MATCH_FOCUS = "basketBallMatchFocus";
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
    //已注册或已被使用
    public static final int ERROR_CODE_2 = 302;
    //用户名已被使用
    public static final String ERROR_MSG_2_1 = "该用户名已被使用!";
    //该手机号已被使用
    public static final String ERROR_MSG_2_2 = "该手机号已被使用!";
    //该昵称已被使用
    public static final String ERROR_MSG_2_5 = "该昵称已被使用!";
    //未找到该用户
    public static final String ERROR_MSG_2_3 = "未找到该用户!";
    //未登录或登录超时
    public static final String ERROR_MSG_2_4 = "未登录或登录超时，请重新登录!";
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
    //已注册或已被使用
    public static final int ERROR_CODE_5 = 305;
    //用户名已被使用
    public static final String ERROR_MSG_5_1 = "用户注册异常!";
    //查询数据库失败
    public static final String ERROR_MSG_5_2 = "查询数据库失败!";
    //未找到该方案
    public static final String ERROR_MSG_5_3 = "未找到该方案!";

    //票务错误
    public static final int ERROR_CODE_6 = 306;
    public static final String ERROR_MSG_6_1 = "彩票id不能为空";
    public static final String ERROR_MSG_6_2 = "出票商id不能为空";
    public static final String ERROR_MSG_6_6 = "赛事编号不能为空";

    public static final String ERROR_MSG_6_3 = "彩票id有误，未找到该彩票!";
    public static final String ERROR_MSG_6_4 = "获取赛事列表失败，请稍后再试!";
    public static final String ERROR_MSG_6_5 = "该方案已出票!";
    public static final String ERROR_MSG_6_7 = "未满足条件不出票!";
    public static final String ERROR_MSG_6_8 = "寻票驳回，不符合寻票要求!";
    public static final String ERROR_MSG_6_9 = "该方案已寻票!";
    public static final String ERROR_MSG_6_10 = "该玩法暂不出票!";
    public static final String ERROR_MSG_6_11 = "机器人暂不出票!";

    public static final String ERROR_MSG_6_12 = "你不能处理其他代理的客户信息!";

    public static final String ERROR_MSG_6_13 = "所选赛事不能为空";

    //激活码错误
    public static final int ERROR_CODE_7 = 307;
    public static final String ERROR_MSG_7_1 = "激活码无效!";

    //超级大神相关
    public static final int ERROR_CODE_8 = 308;
    public static final String ERROR_MSG_8_1 = "您已关注，不能再次关注!";
    public static final String ERROR_MSG_8_2 = "您未关注，不能取消关注!";
    public static final String ERROR_MSG_8_3 = "您已取消关注，不能再次取消!";
    public static final String ERROR_MSG_8_4 = "不能关注自己!";

    //红包错误
    public static final int ERROR_CODE_9 = 309;
    public static final String ERROR_MSG_9_1 = "您的账户余额不足，不能发起此红包!";
    public static final String ERROR_MSG_9_2 = "单个红包金额不得小于0.01元，请重新设置红包!";
    public static final String ERROR_MSG_9_3 = "该红包已被抢完!";
    public static final String ERROR_MSG_9_4 = "该红包已过期!";
    public static final String ERROR_MSG_9_5 = "未找到该红包!";
    public static final String ERROR_MSG_9_6 = "当前红包只对已关注用户开放!";
    public static final String ERROR_MSG_9_7 = "您不能领取自己的红包!";
    public static final String ERROR_MSG_9_8 = "您已经领过该红包了，不能再次领取!";
    public static final String ERROR_MSG_9_9 = "红包开始时间必须大于当前时间!";
    public static final String ERROR_MSG_910 = "该用户没有发过红包！";


    //竞彩大师
    public static final int ERROR_CODE_10 = 310;
    public static final String ERROR_MSG_10_1 = "该用户已是认证名人，不能继续添加!";
    public static final String ERROR_MSG_10_2 = "该用户已是实战大神，不能继续添加!";
    public static final String ERROR_MSG_10_3 = "未找到该用户!";
    public static final String ERROR_MSG_10_4 = "该用户不是认证名人或实战大神!";
    public static final String ERROR_MSG_10_5 = "所选赛事不能为空!";
    public static final String ERROR_MSG_10_6 = "为了确保您的胜率当前只支持2串1或单场!";
    public static final String ERROR_MSG_10_7 = "很抱歉，您无权限发布推荐信息，请到个人中心申请!";
    public static final String ERROR_MSG_10_8 = "您未创建本期任务，本周不能发布推荐!";
    public static final String ERROR_MSG_10_9 = "您已完成本期任务，本周不能再发推荐!";
    public static final String ERROR_MSG_10_10 = "未找到推荐信息!";
    public static final String ERROR_MSG_10_11 = "该推荐为免费推荐，无需付费!";
    public static final String ERROR_MSG_10_12 = "您已购买此推荐，无需再次购买!";
    public static final String ERROR_MSG_10_13 = "您的云朵余额不足，请充值!";
    public static final String ERROR_MSG_10_14 = "您不能购买自己的推荐!";
    public static final String ERROR_MSG_10_15 = "您当前可提现云朵数不足，不可提现!";

    //短信错误
    public static final int SMS_ERROR_CODE = 500;
    //图片验证码session的key
    public static final String VER_CODE = "verCode";
    //短信验证码session的key
    public static final String SMS_AUTH_CODE = "SmsAuthCode";
    //短信发送间隔验证
    public static final String SMS_ERROR_CODE_1 = "发送间隔太短，请稍后再试！";
    //短信发送失败
    public static final String SMS_ERROR_CODE_2 = "发送失败，请稍后再试！";

    public static final int ERROR_CODE_400 = 400;
    public static final String ERROR_MSG_400 = "找不到数据!";

    public static final int ERROR_CODE_401 = 401;
    public static final String ERROR_MSG_401 = "您还没有登录!";

    public static final int ERROR_CODE_402 = 402;
    public static final String ERROR_MSG_402 = "请不要重复晒单!";

    public static final int ERROR_CODE_403 = 403;
    public static final String ERROR_MSG_403 = "未中奖的单不能进行晒单!";

    public static final int ERROR_CODE_404 = 404;
    public static final String ERROR_MSG_404 = "该晒单已经审核或驳回!";

    public static final int ERROR_CODE_405 = 405;
    public static final String ERROR_MSG_405 = "虚拟账户个数不足!";

    public static final int ERROR_CODE_406 = 406;
    public static final String ERROR_MSG_406 = "只能跟彩研账户的单!";

    //打赏错误
    public static final int ERROR_CODE_601 = 601;
    public static final String ERROR_MSG_601 = "您的账户余额不足!";
    public static final int ERROR_CODE_602 = 602;
    public static final String ERROR_MSG_602 = "打赏的金额不符合规范!";
    public static final int ERROR_CODE_610 = 610;
    public static final String ERROR_MSG_610 = "您不能打赏自己!";

    //快速审核失败
    public static final int ERROR_CODE_605 = 605;
    public static final String ERROR_MSG_605 = "您不具有快速审核的权限!";
    //搜索结果为空
    public static final int ERROR_CODE_603 = 603;
    public static final String ERROR_MSG_603 = "暂无此大师,请重新输入!";
    public static final int ERROR_CODE_604 = 604;
    public static final String ERROR_MSG_604 = "已加载到最后一页";
    //点赞错误
    public static final int ERROR_CODE_606 = 606;
    public static final String ERROR_MSG_606 = "方案ID不能为空";
    //获取开奖信息出错
    public static final int ERROR_CODE_607 = 607;
    public static final String ERROR_MSG_607 = "获取数字彩开奖信息出错";
    public static final int ERROR_CODE_608 = 608;
    public static final String ERROR_MSG_608 = "获取竞技彩开奖信息出错";
    public static final int ERROR_CODE_611 = 611;
    public static final String ERROR_MSG_611 = "日期不能为空";
    public static final int ERROR_CODE_612 = 612;
    public static final String ERROR_MSG_612 = "传入类型不能为空";
    public static final int ERROR_CODE_613 = 613;
    public static final String ERROR_MSG_613 = "传入彩期不能为空";
    public static final int ERROR_CODE_614 = 614;
    public static final String ERROR_MSG_614 = "当前彩期未获取到开奖信息";
    public static final int ERROR_CODE_615 = 615;
    public static final String ERROR_MSG_615 = "充值记录为空";
    public static final int ERROR_CODE_616 = 616;
    public static final String ERROR_MSG_616 = "提款记录为空";
    public static final int ERROR_CODE_617 = 617;
    public static final String ERROR_MSG_617 = "购买推荐记录为空";
    public static final int ERROR_CODE_618 = 618;
    public static final String ERROR_MSG_618 = "推荐退款记录为空";
    public static final int ERROR_CODE_620 = 620;
    public static final String ERROR_MSG_620 = "打赏记录为空";
    public static final int ERROR_CODE_621 = 621;
    public static final String ERROR_MSG_621 = "被购加款记录为空";
    public static final int ERROR_CODE_622 = 622;
    public static final String ERROR_MSG_622 = "打赏收入记录为空";
    public static final int ERROR_CODE_623 = 623;
    public static final String ERROR_MSG_623 = "快速审核扣款记录为空";
    public static final int ERROR_CODE_624 = 624;
    public static final String ERROR_MSG_624 = "必传参数不能为空";
    public static final int ERROR_CODE_625 = 625;
    public static final String ERROR_MSG_625 = "修改资讯必须传入id";
    public static final int ERROR_CODE_626 = 626;
    public static final String ERROR_MSG_626 = "请传入正确的参数";
    public static final int ERROR_CODE_627 = 627;
    public static final String ERROR_MSG_627 = "近期消费未达最低水平，不能评论";
    public static final int ERROR_CODE_628 = 628;
    public static final String ERROR_MSG_628 = "传入方案号错误";
    public static final int ERROR_CODE_629 = 629;
    public static final String ERROR_MSG_629 = "此方案暂无评论";
    public static final int ERROR_CODE_630 = 630;
    public static final String ERROR_MSG_630 = "没有此评论";
    public static final int ERROR_CODE_631 = 631;
    public static final String ERROR_MSG_631 = "只有作者本人才可以回复此评论";
    public static final int ERROR_CODE_632 = 632;
    public static final String ERROR_MSG_632 = "同一条评论只可回复一次";
    public static final int ERROR_CODE_633 = 633;
    public static final String ERROR_MSG_633 = "没有此新闻";
    public static final int ERROR_CODE_634 = 634;
    public static final String ERROR_MSG_634 = "第三方数据有误";
    public static final int ERROR_CODE_635 = 635;
    public static final String ERROR_MSG_635 = "红包只有抢包本人可以留言";
    public static final int ERROR_CODE_636 = 636;
    public static final String ERROR_MSG_636 = "只能留言一次";
    public static final int ERROR_CODE_637 = 637;
    public static final String ERROR_MSG_637 = "SP未变化";
    public static final int ERROR_CODE_638 = 638;
    public static final String ERROR_MSG_638 = "场次不存在";
    public static final int ERROR_CODE_609 = 609;   //未知错误
    public static final int ERROR_CODE_619 = 619;

    //很晚了，注意休息
    public static final int ERROR_CODE_407 = 407;
    public static final String ERROR_MSG_407 = "很晚了，注意休息!";

    public static final int ERROR_CODE_408 = 408;
    public static final String ERROR_MSG_408 = "注数计算结果异常，请检查!";

    public static final int ERROR_CODE_409 = 409;
    public static final String ERROR_MSG_409 = "本次操作被中止:暂停销售!";

    public static final int ERROR_CODE_410 = 410;
    public static final String ERROR_MSG_410 = "本次操作被中止:金额错误!";

    public static final int ERROR_CODE_411 = 411;
    public static final String ERROR_MSG_411 = "本次操作被中止:彩期销售截止了!";

    public static final int ERROR_CODE_412 = 412;
    public static final String ERROR_MSG_412 = "本次操作被中止:";

    public static final int ERROR_CODE_413 = 413;
    public static final String ERROR_MSG_413 = "您购买的方案过期了!";

    public static final int ERROR_CODE_414 = 414;
    public static final String ERROR_MSG_414 = "投注异常!";

    public static final int ERROR_CODE_415 = 415;
    public static final String ERROR_MSG_415 = "您还不是白名单用户!";

    public static final int ERROR_CODE_416 = 416;
    public static final String ERROR_MSG_416 = "没有该会员!";

    public static final int ERROR_CODE_417 = 417;
    public static final String ERROR_MSG_417 = "余额不足!";

    public static final int ERROR_CODE_418 = 418;
    public static final String ERROR_MSG_418 = "该比赛已截止!";

    public static final int ERROR_CODE_419 = 419;
    public static final String ERROR_MSG_419 = "请先实名认证!";

    public static final int ERROR_CODE_420 = 420;
    public static final String ERROR_MSG_420 = "只能为自己的会员设置返点!";

    public static final int ERROR_CODE_421 = 421;
    public static final String ERROR_MSG_421 = "您还没有该彩种返点!";

    public static final int ERROR_CODE_422 = 422;
    public static final String ERROR_MSG_422 = "设置的返点不能超过自己返点!";

    public static final int ERROR_CODE_423 = 423;
    public static final String ERROR_MSG_423 = "设置返点出错!";

    public static final int ERROR_CODE_424 = 424;
    public static final String ERROR_MSG_424 = "自动出票!";

    public static final int ERROR_CODE_425 = 425;
    public static final String ERROR_MSG_425 = "系统错误!";

    public static final int ERROR_CODE_426 = 426;
    public static final String ERROR_MSG_426 = "该方案不允许抄单!";

    public static final int ERROR_CODE_427 = 427;
    public static final String ERROR_MSG_427 = "请先进行实名认证!";

    public static final int ERROR_CODE_428 = 428;
    public static final String ERROR_MSG_428 = "倍数不能超过20000倍!";

    public static final int ERROR_CODE_429 = 429;
    public static final String ERROR_MSG_429 = "转换时间出错!";

    public static final int ERROR_CODE_430 = 430;
    public static final String ERROR_MSG_430 = "时间设置错误!";

    public static final int ERROR_CODE_431 = 431;
    public static final String ERROR_MSG_431 = "请理性投注!";

    public static final int ERROR_CODE_432 = 432;
    public static final String ERROR_MSG_432 = "未满18周岁!";

    public static final int ERROR_CODE_433 = 433;
    public static final String ERROR_MSG_433 = "身份证错误!";

    public static final int ERROR_CODE_434 = 434;
    public static final String ERROR_MSG_434 = "该方案已支付!";

    public static final int ERROR_CODE_435 = 435;
    public static final String ERROR_MSG_435 = "当前金额小于彩金卡使用额度!";

    public static final int ERROR_CODE_436 = 436;
    public static final String ERROR_MSG_436 = "只能支付自己的方案!";

    public static final int ERROR_CODE_437 = 437;
    public static final String ERROR_MSG_437 = "金额错误!";

    public static final int ERROR_CODE_438 = 438;
    public static final String ERROR_MSG_438 = "只能查看自己的出票详情!";

    public static final int ERROR_CODE_439 = 439;
    public static final String ERROR_MSG_439 = "只能设置自己的客户!";

    public static final int ERROR_CODE_440 = 440;
    public static final String ERROR_MSG_440 = "彩期查询错误!";

    public static final int ERROR_CODE_441 = 441;
    public static final String ERROR_MSG_441 = "该身份证已被注册!";

    public static final int ERROR_CODE_442 = 442;
    public static final String ERROR_MSG_442 = "场次号错误或已截止!";

    public static final int ERROR_CODE_443 = 443;
    public static final String ERROR_MSG_443 = "请查看站内信,有组合已被限售!";

    public static final int ERROR_CODE_444 = 444;
    public static final String ERROR_MSG_444 = "不符合退单条件!";

    public static final int ERROR_CODE_445 = 445;
    public static final String ERROR_MSG_445 = "系统异常!";

    public static final int ERROR_CODE_446 = 446;
    public static final String ERROR_MSG_446 = "未拆票，请稍后再试!";

    public static final int ERROR_CODE_447 = 447;
    public static final String ERROR_MSG_447 = "短信发送失败!";

    public static final int ERROR_CODE_448 = 448;
    public static final String ERROR_MSG_448 = "数据格式有误!";

}
