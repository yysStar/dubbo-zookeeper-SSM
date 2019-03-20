package com.qiyun.model;

import com.qiyun.commonModel.Platform;

import java.util.HashMap;
import java.util.Map;

public class PlatformConstant {
	final public static int AMOUNT_NOT_CODE = 101006;
	final public static String AMOUNT_NOT_TEXT = "对不起，您的余额不足!";
	final public static int EXCEPTION_ERROR_CODE = 400044;
	final public static String EXCEPTION_ERROR_TEXT = "请求出现异常!";
	final public static String PASE_ERROR_TEXT = "方案已过期!";
	final public static int PASE_ERROR_CODE = 400045;
	// 用户未登录!
	final public static int NO_LOGIN_ERROR_CODE = 400000;
	final public static String NO_LOGIN_ERROR_TEXT = "请登录!";
	// 如果加载用户信息为空则返回null
	final public static String NULL = "";
	// 加载用户信息!
	final public static String LOAD_INFO = "load_info";
	// 用户身份证号!
	final public static String CERT_NO = "cert_no";
	// 用户真实姓名!
	final public static String ALIPAY = "alipay";// 是否用支付定提款
	
	final public static String CLLFORIOS = "cllforIOS";
	final public static String CLLFORIOS2 = "cllforIOS2";
	final public static String CLL_FOR_ANDROID2 = "cllforAndroid2";
	final public static String AWARD_LIST = "award_list";
	final public static String SCORE_EXCHANGE_SERVICE = "score_exchange_service";
	final public static String NOT_PAY_COUNT = "not_pay_count";
	final public static String AD_LIST = "ad_list";
	final public static String REAL_NAME = "real_name";
	final public static String MESSAGE_HEAD = "message_head";
	final public static String MESSAGE_BODY = "message_body";
	final public static String MESSAGE_RESULT = "message_result";
	final public static String RESPONSE_MSG = "response_msg";
	final public static String RESPONSE_CODE = "response_code";
	final public static String MESSAGE_ID = "message_id";
	final public static String AGENT_ID = "agent_id";
	final public static String DIGEST = "digest";
	final public static String ABLE_SOCRE = "able_socre";
	final public static String IN_PAY = "in_pay";
	final public static String FREEZE_BALANCE = "freeze_balance";
	final public static String ABLE_BALANCE = "able_balance";// 用户可提款金额
	final public static String BANK_CARDNO_TEXT_ZFB = "支付宝账号无效!";
	final public static String ABLE_BALANCE_USE = "able_balance_user";// 可以用金额
	final public static String ALIPAY_EASY = "alipay_easy";
	final public static String ALIPAY_APP_ID = "alipay_app_id";
	final public static String ALIPAY_PARTNER_ID = "alipay_easy_partner_id";
	final public static String SUCCESS = "success";
	final public static String USER_STATUS = "user_status";
	final public static String USER_NAME = "user_name";
	final public static String UNION_CODE = "union_code";
	final public static String REGISTER_USER_NAME = "register_user_name";
	final public static String ALIPAY_USER_ID = "alipay_user_id";
	final public static String QQ_OPEN_ID = "qq_open_id";
	final public static String APP_ID = "app_id";
	final public static String ALIPAY_AUTH_CODE = "alipay_auth_code";
	final public static String REGISTER = "register";
	final public static String LOGIN_ID = "login_id";
	final public static String TOKEN = "token";
	final public static String JOIN_LOGIN_ERROR = "join_login_error";
	final public static String JOIN_LOGIN = "join_login";// 是否是联合登录
	final public static String COMPLETE_INFO = "complete_info";// 用户信息是否完整
	final public static String COMPLETE_INFO_HINT = "complete_info_hint";// 用户信息是否完整时提示
	final public static String IS_ALIPAY_USER = "is_alipay_user";//	是否为支付宝用户	
	final public static String ALIPAY_ACCOUNT = "alipay_account";//支付宝帐号
	final public static String ACCESS_TOKEN = "access_token";
	final public static String NICK_NAME = "nick_name";//QQ昵称
	final public static String NICKNAME = "nickname";//QQ昵称
	final public static String MOBILE_ACTIVE = "mobile_active";// 手机激活
	final public static String EMAIL_ACTIVE = "email_active";// 邮件激活
	
	final public static String LOT_MGR = "lot_mgr";// O2O业务
	final public static String LOT_MGR_LOGIN = "lot_mgr_login";// O2O登录业务
	final public static String REGISTER_URL = "register_url";//app注册地址
	final public static String MENU_LIST = "menu_list";//app菜单列表
	final public static String SCORE_BET = "score_bet";//积分投注资源
	/**
	 * 获取实际到账金额和手续费提示信息
	 */
	final public static String CHECK_MONEY = "check_money";
	
	final public static String JOIN_PASSWORD_ISEMPTY = "join_password_isempty";// 联合登录用户密码是否为空
	final public static String PASSWORD = "password";
	final public static String AUTNCODE = "authcode"; //验证码
	final public static String OLD_PASSWORD = "old_password";
	final public static String TIME = "time";// 系统时间
	// 记录登录错误的时间
	final public static String PLAN_CONTENT = "plan_content";
	final public static String ALIPAY_PUBLIC = "alipay_public";
	final public static String REQUEST_URL = "request_url";
	final public static String START_TIME = "start_time";
	final public static String CREATE_DATE_TIME = "create_date_time";
	final public static String END_TIME = "end_time";
	final public static String OPEN_TIME = "open_time";
	final public static String ABLE = "able";
	final public static String RG_AMOUNT = "rg_amount";
	final public static String BAO_DE_AMOUNT = "bao_de_amount";
	final public static String PAGE_INDEX = "page_index";
	final public static String PRIZE_LIST = "prize_list";
	final public static String LOGIN_ERROR_DATE = "login_error_date";
	final public static String SHOW_VALIDATE = "show_validate";
	final public static String CHECK_ERROR = "check_error";
	final public static String REGISTER_ERROR_DATE = "register_error_date";
	final public static String REMEBER_MOBILE = "remeber_mobile";
	final public static String ACCOUNT = "account";
	final public static String AMOUNT = "amount";
	final public static String DRAW_FEE = "draw_fee";	
	final public static String ARRIVE_BANK_AMOUNT = "arrive_bank_amount";	
	
	final public static String CHARGE_TYPE= "charge_type";
	final public static String AMOUNT_ABLE = "amount_able";
	final public static String TRADE_TYPE = "trad_type";
	final public static String TICKET_ID = "ticket_id";//票id
	
	/**
	 * 提示信息
	 */
	public final static String MESSAGE = "message";
	
	/**
	 * 错误码
	 */
	public static String ERROR_CODE = "error_code";
	
	/**
	 * 提款检测
	 */
	public final static String CHECK_DRAWING = "check_drawing";
	
	final public static String UPDATE = "update";
	final public static String BANK_NAMES = "bank_names";
	final public static String BIND_BANK_NAMES = "bind_bank_names";
	final public static String CHARGE_BANK_NAMES = "charge_bank_names";
	final public static String BANK_NAME = "bank_name";
	final public static String BANK_CODE = "bank_code";
	final public static String BANK_SHORT_NAME = "bank_short_name";
	final public static String BANK_SHORT_EN = "bank_short_en";
	final public static String LAST_FOUR_CARD_NO = "last_four_card_no";
	
	final public static String CARD_LAST_FOUR_NO = "card_last_four_no";
	final public static String PAY_TYPE = "pay_type";
	
	final public static String TEXT = "text";
	final public static String API_CODE = "api_code";
	final public static String LOGO_URL = "logo_url";
	final public static String ID = "id";
	final public static String BANK_CARD = "bank_card";
	final public static String NEW_BAN_CARD = "new_bank_card";
	final public static String BANK_PART = "bank_pack";
	final public static String BANK_PART_PROVINCE = "bank_pack_province";
	final public static String BANK_PART_CITY = "bank_pack_city";
	final public static String EMAIL = "email";
	final public static String CARD = "card";
	final public static String CARD_NO = "card_no";
	final public static String IS_ONE_KEY_PAY = "is_one_key_pay";
	final public static String OLD_EMAIL = "old_email";
	final public static String MOBILE = "mobile";
	final public static String PROVINCE_VALUE = "province_value";
	final public static String OLD_MOBILE = "old_mobile";
	final public static String DETAIL = "detail";
	final public static String COUNT = "count";// 总期数
	final public static String TOTAL_SALES = "total_sales";// 开奖号码
	final public static String LOTTERY_NUMBER = "lottery_number";// 开奖号码
	final public static String POEN_DATE_TIME = "open_date_time";// 开奖时间
	final public static String RECORD_DETAIL = "record_detail";// 查询集合
	final public static String PLAN_NO = "plan_no";// 单据号
	final public static String CODE = "code";// 代号
	final public static String BELONG_ACCOUNT = "belong_account";// 发起人
	final public static String TERM = "term";// 彩期 ""
	final public static String JC_TERM = "201001";// 
	final public static String GAME = "game";// 玩法
	final public static String TOTAL_PART = "total_part"; // 认购金额
	final public static String MORE_BINGO="moreBingo";//是否有盈利空间
	final public static String PLAN_SAVED="plan_saved";//是否是方案保存

	final public static String PLAN_TYPE = "plan_type"; // 区分代购与合买
	final public static String BET_COUNT = "bet_count"; // 投注注数

	final public static String PLAN_TYPE_NAME = "plan_type_name"; // 区分代购与合买
	final public static String PLAY_TYPE = "play_type"; // 子玩法
	final public static String PLAY_CONTENT = "play_content"; // 子玩法内容	
	final public static String BET_CONTENT = "bet_content"; // 
	

	final public static String WIN_STATUS = "win_status"; // 中奖况态
	final public static String INT_TIME = "int_time"; // ""
	final public static String LINE_ID = "line_id"; //
	final public static String OPEN_STATUS = "open_status";// 开奖状态
	final public static String OPEN_PRIZE = "open_prize";// 开奖金额
	final public static String OPEN_RESULT = "open_result";// 开奖金额planOrderStatus
	final public static String ONLY_PLAY = "only_play";
	final public static String PICTURE = "head_picture";// 用户头相

	final public static String MATCH = "match";// 赛事
	final public static String OPTIONS = "options";
	final public static String EVENT = "event";// 主队
	final public static String HOME = "home";// 主队
	final public static String GUEST = "guest";// 各队
	final public static String DATE = "date";// 星期
	final public static String WED = "wed";// 星期
	final public static String SCORE = "score";// 比数
	final public static String TOTAL_BALL = "total_ball";// 总进球数
	final public static String CONCEDE = "concede";// 上球concede;// 让球
	final public static String AWARD = "award";// 开奖sp"shedan":false passAward
	final public static String PASS_AWARD = "pass_award";//
	final public static String PASS_MODE = "pass_mode";
	final public static String PASS_TYPE = "pass_type";
	final public static String MATCH_ITEMS = "match_items";
	final public static String SELL_END_TIME = "sell_end_time";
	final public static String MATCH_ANME_ARR = "match_name_arr";
	final public static String SHEDAN = "shedan";
	final public static String LINEDID = "lineId";
	final public static String CONTENT = "content";// 主队

	final public static String AWARD_POOL = "award_pool";// 
	final public static String WIN_STATUS_VALUE = "win_status_value";// 中奖状态
	final public static String PRIZE_MONEY = "prize_money";

	// final public static String PAGE_SIZE = "page_size";// 订单状态
	final public static String ORDER_STATUS = "order_status";// 订单状态
	final public static String ORDER_STATUS_VALUE = "order_status_value";// 订单状态
	final public static String TRANS_TYPE = "trans_type";// 交易类型
	final public static String TRANS_TYPE_VALUE = "trans_type_value";// 交易类型
	final public static String TRANS_TIME = "trans_time";// 交易时间
	final public static String LINE_NO = "line_no";// 交易流水
	final public static String IN_COME = "in_come";// 收入payremark
	final public static String SCORE_TYPE = "score_type";// 收入payremark
	final public static String SCORE_TYPE_VALUE = "score_type_value";// 收入payremark
	final public static String PAY = "pay";// 支出
	final public static String LOTTERY_AMOUNT = "lottery_amount";//
	final public static String REMARK = "remark";// 支出
	final public static String BONUS_DETAIL = "bonus_detail";// 交易细节"score_detail"
	final public static String SCORE_DETAIL = "score_detail";// 交易细节scoreLineNo
	final public static String SCORE_LINE_NO = "score_line_no";// 订单号
	final public static String LIST = "list";// 交易细节
	final public static String PAGE_SIZE = "page_size";//
	final public static String PAGE = "page";//
	final public static String DEAL_DATE_TIME = "deal_date_time";// 载止时间
	final public static String SEND_DATE_TIME = "send_date_time";// 客服审核时间
	final public static String FINANCE_DEAL_DATE_TIME = "finance_deal_date_time";//财务审核时间
	final public static String CONFIRM_DATE_TIME = "confirm_date_time";//交易到账时间
	final public static String FAILED_DATE_TIME = "failed_date_time";//交易失败时间
	
	
	final public static String MULTIPLE = "multiple";// 倍数planDesc
	final public static String PRINT_DATE_TIME = "print_date_time";//打票时间
	final public static String TICKET_NO = "ticket_no";//打票时间
	
	final public static String PLAN_DESC = "plan_desc"; // 合买描述
	final public static String FOUNDER_PART = "founder_part"; // 发起人购买份数
	final public static String RESERVER_PART = "reserve_part"; // 保底
	final public static String SCHEDULE = "schedule"; // 进度

	final public static String AWARD_BEFOR = "award_befor";// 方案奖金(税前)
	final public static String AWARD_AFTER = "award_after";// 方案奖金(税后)
	final public static String AWARD_ADD = "award_add";// 加奖金额
	final public static String AWARD_SELF = "award_self";// 当前用户中奖金额

	final public static String PLAN_RETURN = "plan_return";// 方案回报率

	final public static String TOTAL_AMOUNT = "total_amount";// 总金额
	final public static String JOIN_PART = "join_part";// -1未登录 0未参与 其它值为具体参与份数
	final public static String COMMISION = "commision";// 提成
	final public static String PLAN_STATUS = "plan_status";// 方案状态
	
	final public static String PLAN_STATUS_VALUE = "plan_status_value";// 方案状态值	
	final public static String PLAN_STATUS_LIST = "plan_status_list";// 方案状态列表值	
	
	final public static String PLAN_TICKET_STATUS = "ticket_status";// 方案状态值
	final public static String PLAN_TICKET_STATUS_VALUE = "ticket_status_value";// 方案状态值
	final public static String PLAN_STATUS_PROGRESS="plan_status_progress";//方案状态的进度
	final public static String OTHER_AMOUNT = "other_amount";// 剩余
	final public static String PUBLIC_STATUS = "public_status";// 
	final public static String BAO_DI_AMOUNT = "bao_di_amount";
	final public static String HM_OTHER = "hm_other";
	final public static String PUBLIC_TEXT = "public_text";// hm_amount
	final public static String HM_AMOUNT = "hm_amount";//
	final public static String FILE_PATH = "file_path";// TYPE
	final public static String TYPE = "type";
	final public static String TYPE_TEXT = "type_text";
	final public static String SELECT_CONTENT = "select_content";
	final public static String BANKS = "banks";
	final public static String HINT = "hint";
	final public static String URL = "url";
	final public static String NAME = "name";
	final public static String ACTIVITY = "activity";	
	final public static String STATUS = "status";
	final public static String SHOW_TICKET = "show_ticket";
	final public static String PLAN_FINISH = "plan_finish";
	final public static String PAY_STATUS = "pay_status";// 支付况态
	final public static String STATUS_VALUE = "status_value";
	final public static String IN_PEOPLE = "in_people";
	final public static String FORWARD_URL = "forward_url";
	final public static String FIRST_USE_UMPAY = "first_use_umpay";
	
	final public static String LOTTERY_TYPE = "lottery_type";
	final public static String LOTTERY_TYPE_NAME = "lottery_type_name";
	final public static String CHASE_STATUS = "chase_status";
	final public static String CHASE_STATUS_NAME = "chase_status_name";
	final public static String START_DATE = "start_date";
	final public static String END_DATE = "end_date";
	final public static String CHASE_NO = "chase_no";
	final public static String CHASE_TYPE = "chase_type";
	final public static String CHASE_TYPE_NAME = "chase_type_name";
	final public static String CHASE_COUNT = "chase_count";
	final public static String TOTAL_PRIZE = "total_prize";
	final public static String SUCCESS_COUNT = "success_count";
	final public static String CHASE_TERM_STATUS = "chase_term_status";
	final public static String CHASE_TERM_STATUS_NAME = "chase_term_status_name";
	
	final public static String LOTTERY_INFO = "lottery_info";
	final public static String ADD_ATTRIBUTE = "add_attribute";
	final public static String EVERY_AMOUNT = "every_amount";
	final public static String START_CONDITION = "start_condition";
	final public static String STOP_CONDITION = "stop_condition";
	final public static String OFFSET = "offset";
	final public static String FIELD = "field";// 排序的字段
	final public static String SORT = "sort";// 排序的字段 option_text
	final public static String OPTION_TEXT = "option_text";// 
	final public static String IS_AVAILABLE = "is_available";
	final public static String VERSION_CODE = "version_code";
	final public static String VERSION_INDEX = "version_index";
	final public static String VERSION_URL = "version_url";// 排序的字段
	final public static String VERSION_TEST = "version_test";// 排序的字段
	final public static String VERSION_DESC = "version_desc";// 排序的字段is_available
	final public static String HAS_BOUT = "has_bout";
	final public static String XML_CONFIG_PAHT = "/config/mobile/";//手机配置文件路径（手机版本与银行列表）
	final public static String GEN_TYPE = "gen_type";
	final public static String GEN_TYPE_VALUE = "gen_type_value";
	// 版本信息
	final public static String VERSION = "version";// 排序的字段
	final public static String VERSION_NAME = "version_name";
	final public static String VERSION_NO = "version_no";//
	// 请输入您的账号信息!
	final public static int NO_USERNAME_CODE = 400001;
	final public static String NO_USERNAME_TEXT = "请输入您的账号信息!";

	// 请输入您的登录密码!
	final public static int NO_PASSWROD_CODE = 400002;
	final public static String NO_PASSWROD_TEXT = "请输入您的登录密码!";

	// 账号或密码错误!
	final public static int ACCOUNT_ERROR_CODE = 400003;
	final public static String ACCOUNT_ERROR_TEXT = "账号或密码错误!";

	// 请输入验证码
	final public static int NO_VALIDATE_CODE = 400004;
	final public static String NO_VALIDATE_TEXT = "请输入验证码!";

	// 验证码错误
	final public static int VALIDATE_ERROR_CODE = 400005;
	final public static String VALIDATE_ERROR_TEXT = "验证码错误!";
	
	// 绑定帐号提示
	final public static int ACCOUNT_BIND_CODE = 400100;

	// 连续登录错误
	final public static int LOGIN_MORE_ERROR_CODE = 400006;

	// 帐号因操作失误被锁定,系统会在30分钟后解锁!
	final public static int LOGIN_LOCK_CODE = 400007;
	final public static String LOGIN_LOCK_TEXT = "帐号因操作失误被锁定,系统会在30分钟后解锁!";

	//
	// Assembling data
	final public static int ASSEMBLING_DATA_ERROR_CODE = 400008;
	final public static String ASSEMBLING_DATA_ERROR_TEXT = "数据组装出错!";
	
	final public static int ASSEMBLING_ISWHITE_ERROR_CODE = 400009;
	final public static String ASSEMBLING_ISWHITE_ERROR_TEXT = "您没有登录权限，请致电400 6166 111";
	
	
	final public static String CHANNEL = "channel";//来源
	final public static String CLL_FOR_ANDROID_ABC = "cllforAndroid_abc";
	final public static String CLL_FOR_ANDROID_BOC = "cllforAndroid_boc";
	final public static String CLL_FOR_ANDROID_XILE = "cllforAndroid_xile";
	final public static String CLL_FOR_IOS_BOC = "cllforIOS_boc";
	final public static String CLL_FOR_IOS_ABC = "cllforIOS_abc";
	final public static String CLL_FOR_IOS_XILE = "cllforIOS_xile";
	// 处理成功
	final public static int OK = 999;
	final public static String OK_TEXT = "处理成功!";
	final public static String SIGNING = "signing";
	final public static String CHARGE = "charge";
	// member属性
	// 注册处理异常!
	final public static int REGISTER_ERROR_CODE = 401001;
	final public static String REGISTER_ERROR_TEXT = "数据加载出错!";
	// 用户名已注册!
	final public static int USERNAME_EXISTS_ERROR_CODE = 401002;
	final public static String USERNAME_EXISTS_ERROR_TEXT = "用户名已注册!";
		
	final public static int USERNAME_EMAPY_ERROR_CODE = 401007;
	final public static String USERNAME_EMAPY_ERROR_TEXT = "请求参数中用户名为空";
	// 用户名至少4-12位!
	final public static int USERNAME_LENGTH_ERROR_CODE = 401003;
	final public static String USERNAME_LENGTH_ERROR_TEXT = "用户名至少4-12位!";
	// 密码不能为空!
	final public static int PASSWORD_ISNULL_ERROR_CODE = 401004;
	final public static String PASSWORD_ISNULL_ERROR_TEXT = "密码不能为空!";
	// 密码不正确
	final public static int PASSWORD_ERROR_CODE = 401005;
	final public static String PASSWORD_ERROR_TEXT = "密码不正确!";

	// 密码长度不对!
	final public static int PASSWORD_LENGTH_ERROR_CODE = 401006;
	final public static String PASSWORD_LENGTH_ERROR_TEXT = "密码长度不对!";
	
	final public static int USERNAME_EMPTY_ERROR_CODE = 401008;
	final public static String USERNAME_EMPTY_ERROR_TEXT = "用户名不能包含特殊字符!";

	// 旧密码不能为空
	final public static int OLD_PASSWORD_ERROR_CODE = 400201;
	final public static String OLD_PASSWORD_ERROR_TEXT = "旧密码错误!";
	// 新密码不能为空
	final public static int NEW_PASSWORD_ERROR_CODE = 400202;
	final public static String NEW_PASSWORD_ERROR_TEXT = "密码不能为空!";
	// 旧密码输入错误
	final public static int OLD_IN_ERROR_CODE = 400203;
	final public static String OLD_IN_ERROR_TEXT = "旧密码不匹配!";
	// 旧email不能为空
	final public static int OLD_EMAIL_ERROR_CODE = 400601;
	final public static String OLD_EMAIL_ERROR_TEXT = "旧邮箱不能为空!";
	// 新email不能为空
	final public static int NEW_EMAIL_ERROR_CODE = 400602;
	final public static String NEW_EMAIL_ERROR_TEXT = "新邮箱不能为空!";
	// 新email格式错误
	final public static int NEW_EMAIL_FORMATE_CODE = 400603;
	final public static String NEW_EMAIL_FORMATE_TEXT = "新邮箱格式错误!";
	// 旧email格式错误
	final public static int OLD_EMAIL_FORMATE_CODE = 400604;
	final public static String OLD_EMAIL_FORMATE_TEXT = "旧邮箱格式错误!";

	// 原邮箱地址错误，请重新输入!
	final public static int EMAIL_ERROR_CODE = 400605;
	final public static String EMAIL_ERROR_TEXT = "原邮箱地址错误，请重新输入!";
	// 邮箱格式错误
	final public static int EMAIL_FORMAT_CODE = 400606;
	final public static String EMAIL_FORMAT_TEXT = "邮箱号为空或输入错误!";

	// 邮箱未绑定错误
	final public static int EMAIL_NOTBIND_CODE = 400607;
	final public static String EMAIL_NOTBIND_TEXT = "邮箱未绑定错误!";
	// 邮箱已经绑定错误
	final public static int EMAIL_HASBIND_CODE = 400607;
	final public static String EMAIL_HASBIND_TEXT = "邮箱已经绑定!";

	// mobile格式错误
	final public static int MOBILE_FORMATE_CODE = 400501;
	final public static String MOBILE_FORMATE_TEXT = "手机号不对!";
	// 旧mobile不能为空
	final public static int OLD_MOBILE_ERROR_CODE = 400501;
	final public static String OLD_MOBILE_ERROR_TEXT = "旧手机号不能为空!";
	// 旧mobile格式错误
	final public static int OLD_MOBILE_FORMATE_CODE = 400502;
	final public static String OLD_MOBILE_FORMATE_TEXT = "旧手机号格式错误!";
	// 新mobile不能为空
	final public static int NEW_MOBILE_ERROR_CODE = 400503;
	final public static String NEW_MOBILE_ERROR_TEXT = "新手机号不能为空!";
	// 新mobile格式错误
	final public static int NEW_MOBILE_FORMAT_CODE = 400504;
	final public static String NEW_MOBILE_FORMAT_TEXT = "手机号码错误!";
	// 原mobile错误，请重新输入!MOBILE_HASBIND_CODE
	final public static int MOBILE_ERROR_CODE = 400506;
	final public static String MOBILE_ERROR_TEXT = "手机号为空或输入错误!";
	final public static String OLD_MOBILE_INPUT_ERROR_TEXT = "输入的旧手机号不匹配!";

	final public static int MOBILE_HASBIND_CODE = 400507;
	final public static String MOBILE_HASBIND_TEXT = "手机号已被其它账号绑定使用!";
	
	final public static String MOBILE_NOT_BIND_TEXT = "手机号未经绑定!";

	// 身份证不符合要求
	final public static int CRET_NO_ERROR_CODE = 400301;
	final public static String CRET_NO_ERROR_TEXT = "身份证号码为空或有误!";
	final public static String CRET_NO_ERROR_TEXT_EXIST = "身份证号码已被其它账号使用!";
	// 真实昵称不符合要求
	final public static int REAL_NAME_ERROR_CODE = 400302;
	final public static String REAL_NAME_ERROR_TEXT = "真实姓名为空或有误!";
	// 个人身份证已经绑定
	final public static int CRET_NO_HASBIND_CODE = 400303;
	final public static String CRET_NO_HASBIND_TEXT = "个人身份证已经绑定!";
	// 个人身份未绑定
	final public static int CRET_NO_NOTBIND_CODE = 400304;
	final public static String CRET_NO_NOTBIND_TEXT = "个人身份证未绑定!";

	// 真实姓名未绑定
	final public static int REAL_NAME_NOTBIND_CODE = 400305;
	final public static String REAL_NAME_NOTBIND_TEXT = "真实姓名未绑定!";

	// 银行卡已经绑定错误
	final public static int CARD_HASBIND_CODE = 400404;
	final public static String CARD_HASBIND_TEXT = "银行卡已经绑定!";

	// 银行卡未绑定错误
	final public static int CARD_NOTBIND_CODE = 400405;
	final public static String CARD_NOTBIND_TEXT = "银行卡未绑定!";

	// 银行名称输入错误
	final public static int BINK_NAME_CODE = 400401;
	final public static String BINK_NAME_TEXT = "银行名称输入错误!";

	// 分行名称输入错误
	final public static int BINK_PARK_CODE = 400402;
	final public static String BINK_PARK_TEXT = "分行名称输入错误!";

	// 分行名称输入错误
	final public static int BINK_CODE = 400407;
	final public static String BINK_TEXT = "银行卡匹不配!";

	// 银行卡输入错误
	final public static int BINK_CARD_CODE = 400403;
	final public static String BINK_CARD_TEXT = "银行卡输入错误!";
	/** 充值 */
	// 不支持该银行卡
	final public static int NOSUPPORT_BANK_CODE = 400710;
	final public static String NOSUPPORT_BANK_TEXT = "暂末开通该银行提款通道!";
	// 银行卡输入错误amount
	final public static int AMOUNT_CHARGE_CODE = 400712;
	final public static String AMOUNT_CHARGE_TEXT = "充值金额须2元以上!";

	final public static int BANK_CARDNO_CODE = 400713;
	final public static String BANK_CARDNO_TEXT = "银行卡无效!";

	final public static int MEMBER_SESSION_CODE = 400714;
	final public static String MEMBER_SESSION_TEXT = "充值帐户与登录帐户不相同!";
	final public static String NOT_PLAN_NO = "方案内容不存在!";
	// final public static int CHANGE_OK = 400712; "方案内容不存在!"
	final public static String CHANGE_OK_TEXT = "充值成功!";
	final public static int CHANGE_FAIL_CODE = 400715;
	final public static String CHANGE_FAIL_TEXT = "充值异常:";
	final public static String CHANGE_ERROR_TEXT = "充值失败,请联系客服!";
	final public static String NOT_MEMBERINFO_ERROR_TEXT = "查询为空!";
	final public static int NOT_MEMBERINFO_ERROR_CODE = 400810;

	
	final public static int CHANGE_FAIL_COMPLETE_CODE = 400716;
	final public static String CHANGE_FAIL_COMPLETE_TEXT = "请完善您的个人信息!";
	
	final public static String USER_INFO_COMPLETE = "user_info_complete";
	
	final public static int CHANGE_FAIL_COLD_CARD_CODE = 400717;//彩金额充值失败代号
	final public static String CHANGE_FAIL_COLD_CARD_TEXT = "彩金卡三次输入错误,请30分钟后再试!";//彩金额充值失败代号
	final public static String GLOD_CARD_NO = "glod_card_no";
	final public static String ERROR_DATE = "error_date";
	
	final public static int BANK_ABLEB_CODE = 400811;
	final public static String BANK_ABLEB_TEXT = "提款金额不能小于等于0!";

	final public static int BANK_GDFZ_CODE = 400813;
	final public static String BANK_GDFZ_TEXT = "对不起，广东发展银行单笔提款金额不能超过5万元!";

	final public static String DRAW_OK_TEXT = "提款成功,此次提款金额已被冻结,我们将很快处理,谢谢您的支持";

	final public static int DRAW_FAIL = 400815;
	final public static String DRAW_FAIL_TEXT = "提款失败:";

	final public static int FIND_CODE = 401601;

	final public static int RECORD_CODE = 400900;
	final public static String RECORD_TEXT = "查询异常!";

	final public static String SCORE_TEXT = "积分查询为空!"; //
	final public static String HM_EMPTY_TEXT = "查询为空!";
	final public static String LIST_EMPTY_TEXT = "查询为空!";

	final public static int BANK_NAME_CODE = 400409;
	final public static String BANK_NAME_TEXT = "请选开户银行!";

	final public static int BANK_LIST_CODE = 401501;
	final public static String BANK_LIST_TEXT = "获取列表错误!";

	final public static int LAUNCH_BUY_CODE = 401601;
	final public static String LAUNCH_BUY_TEXT = "合买金额不能为0!";
	
	final public static int TWO_PLAN_BUY_CODE = 401602;
	final public static String TWO_PLAN_BUY_TEXT = "非法加入2元投10注号方案！";
	
	final public static int ACTIVE_PLAN_BUY_CODE = 401603;
	final public static String ACTIVE_PLAN_BUY_TEXT = "您已经超过抢单次数！";
	
	final public static String LAUNCH_BUY_SUCCESS_TEXT = "合买成功!";

	final public static int NOT_LOTTERY_TYPE = 401800;
	final public static String NOT_LOTTERY_TYPE_TEXT = "彩种类型不存在!";

	final public static int NOT_SUPPERT_LOTTERY_TYPE = 401801;
	final public static String NOT_SUPPERT_LOTTERY_TYPE_TEXT = "竞彩不支持开奖历史查询!";

	final public static int LOTTERY_TYPE_EMPRTY = 401900;
	final public static String LOTTERY_TYPE_EMPRTY_TEXT = "彩期为空!";

	final public static int CHASE_CODE = 402000;
	final public static String CHASE_TEXT = "追号期数显示不能超过100期!";

	final public static String OVER_ALL = "购买份数大于剩余份数!";
	final public static String FULL_MEMBER = "已满员";
	final public static String PALN_NOT_ADD = "订单已经不再招募";
	final public static int PLAN_CONTENT_CODE = 402201;
	final public static String PLAN_CONTENT_TEXT = "方案内容不能为空!";
	final public static int AMOUNT_CODE = 402202;
	final public static String AMOUNT_TEXT = "对不起，金额错误!"; // 101004, ""
	
	final public static int HM_AMOUNT_CODE = 402203;
	final public static String HM_AMOUNT_TEXT = "认购加保底金额不能小于方案金额的10%";

	final public static int PALN_AMOUNT_ERROR_CODE = 101004;
	final public static String PALN_AMOUNT_ERROR_TEXT = "方案总金额不能超过2万!";
	final public static String PALN_LESS_AMOUNT_ERROR_TEXT = "方案总金额不能少于100元!";
	final public static String USER_LIMIT = "用户限制登录!";

	final public static int PALN_CONTENT_LENGTH_ERROR_CODE = 101007;
	final public static String PALN_CONTENT_LENGTH_ERROR_TEXT = "文件超过限制大小!";

	final public static int HM_ERROR_CODE = 101005;
	final public static String HM_ERROR_TEXT = "对不起，高频不存在合买!";

	final public static int PLAN_CONTENT_ERROR_CODE = 402203;
	final public static int PLAN_ERROR_CODE = 101010;
	final public static String PLAN_ERROR_TEXT = "上传方案错误";
	final public static int PLAN_AMOUNT_ERROR_CODE = 101009;
	final public static String PLAN_AMOUNT_ERROR_TEXT = "上传方案金额错误";

	final public static int NOT_CONFIG_ERROR = 401401;
	final public static String NOT_CONFIG_TEXT = "没有当前商户的配置文件";

	final public static int REQ_VERSION_ERROR = 401402;
	final public static String REQ_VERSION_TEXT = "请求参数version_no或者version_name为空";

	final public static int REQ_DATA_CODE = 101007;
	final public static String REQ_DATA_ERROR = "请求参数为空";
	final public static int NOT_VERSION_ERRO = 401403;
	final public static String NOT_VERSION_TEXT = "版本号不存在!";

	final public static int BUY_ERROR_CODE = 101005;

	final public static String VERSION_NEW_TEXT = "已是最新版本!";
	final public static String VERSION_CANNOT_USER_TEXT = "当前版本不可用!";
	final public static String VERSION_NOT_CONFIG_TEXT = "没有当前版本的配置文件!";

	final public static int NOT_MATCH = 203001;
	final public static String NOT_MATCH_TEXT = "没有当前对阵数据!";
	/**
	 * 竞彩足球，篮球，单场
	 */
	final public static String TIME_FOMRT = "yyyy-MM-dd HH:mm:ss";// 主队赛果
	final public static String MATCH_RESULT = "match_result";// 主队赛果
	final public static String MATCH_KEY = "match_key";
	// final public static String GAME_NAME = "home_name";
	final public static String GAME_SHORT = "game_short";
	final public static String HOME_SHORT = "home_short";
	final public static String GUEST_SHORT = "guest_short";
	final public static String HOME_SCORE = "home_score";// 主队比分
	final public static String GUEST_SCORE = "guest_score";// 客队比分

	final public static String WHOLE_SCORE = "whole_score";// 全场比分
	final public static String HALF_SCORE = "half_score";// 半场比分halfScore

	final public static String HOME_SP = "home_sp";// 主队SP值
	final public static String GUEST_SP = "guest_sp";
	final public static String DRAW_SP = "draw_sp";

	final public static String DXF = "dxf";
	final public static String DXF_ = "DXF";
	final public static String RF = "rf";
	final public static String RF_ = "RF";

	// 半全场
	final public static String WIN_WIN = "win_win";
	final public static String DRAW_WIN = "draw_win";
	final public static String LOST_WIN = "lost_win";

	final public static String WIN_DRAW = "win_draw";
	final public static String DRAW_DRAW = "draw_draw";
	final public static String LOST_DRAW = "lost_draw";

	final public static String WIN_LOST = "win_lost";
	final public static String DRAW_LOST = "draw_lost";
	final public static String LOST_LOST = "lost_lost";

	// 进球数
	final public static int J0 = 0;
	final public static int J1 = 1;
	final public static int J2 = 2;
	final public static int J3 = 3;
	final public static int J4 = 4;
	final public static int J5 = 5;
	final public static int J6 = 6;
	final public static int J7 = 7;

	// 足球比分
	final public static String S10 = "1-0";
	final public static String S20 = "2-0";
	final public static String S30 = "3-0";
	final public static String S40 = "4-0";
	final public static String S50 = "5-0";

	final public static String S21 = "2-1";
	final public static String S31 = "3-1";
	final public static String S41 = "4-1";
	final public static String S51 = "5-1";

	final public static String S32 = "3-2";
	final public static String S42 = "4-2";
	final public static String S52 = "5-2";
	final public static String S_WIN = "win";

	final public static String S00 = "0-0";
	final public static String S11 = "1-1";
	final public static String S22 = "2-2";
	final public static String S33 = "3-3";
	final public static String S_DRAW = "draw";

	final public static String S01 = "0-1";
	final public static String S02 = "0-2";
	final public static String S03 = "0-3";
	final public static String S04 = "0-4";
	final public static String S05 = "0-5";

	final public static String S12 = "1-2";
	final public static String S13 = "1-3";
	final public static String S14 = "1-4";
	final public static String S15 = "1-5";

	final public static String S23 = "2-3";
	final public static String S24 = "2-4";
	final public static String S25 = "2-5";
	final public static String S_LOST = "lost";

	// 上下单双
	final public static String UP_ODD = "up_odd";
	final public static String UP_EVEN = "up_even";
	final public static String DOWN_ODD = "down_odd";
	final public static String DOWN_EVEN = "down_even";
	
	// --------------------------------------竞彩足球混投---------------------------------------------------
	
	final public static String SALE_STATUS = "sale_status";//在售状态
	final public static String BF_STATUS = "bf_sale_status";//在售状态
	final public static String JQS_STATUS = "jqs_sale_status";//在售状态
	final public static String BQC_STATUS = "bqc_sale_status";//在售状态
	final public static String SPF_STATUS = "spf_sale_status";//在售状态
	final public static String RQSPF_STATUS = "sqspf_sale_status";//在售状态
	
	
	final public static String BF_AWARD_ARR = "bf_award_arr";//比分sp数组
	final public static String JQS_AWARD_ARR= "jqs_award_arr";//进求数sp数组
	final public static String BQC_AWARD_ARR= "bqc_arard_arr";//半全场sp数组
	final public static String SPF_AWARD_ARR= "spf_arard_arr";//胜平负sp数组
	final public static String SQSPF_AWARD_ARR= "sqspf_arard_arr";//上球胜平负sp数组
	final public static String HT2C1_AWARD_ARR= "ht2c1_award_arr";//竞彩足球亚盘sp数组
	
	final public static String SXDS_AWARD_ARR= "sxds_arard_arr";//单场上下盘单双
	
	final public static String LOTTERY_TYPE_ERROR_TEXT = "没有当前彩种!";
	final public static int LOTTERY_TYPE_ERROR_CODE = 109001;
	
	
	// --------------------------------------竞彩篮球混投---------------------------------------------------
	
	final public static String SFC_STATUS = "sfc_sale_status";//胜分差在售状态
	final public static String DXF_STATUS = "dxf_sale_status";//大小分在售状态
	final public static String SF_STATUS = "sf_sale_status";//胜负
	final public static String RFSF_STATUS = "rfsf_sale_status";//上分胜负
	
	final public static String SFC_AWARD_ARR = "bf_award_arr";//胜分差sp数组
	final public static String DXF_AWARD_ARR= "jqs_award_arr";//大小分sp数组
	final public static String SF_AWARD_ARR= "bqc_arard_arr";//胜负sp数组
	final public static String RFSF_AWARD_ARR= "spf_arard_arr";//让分胜负sp数组
	
	
	
	
	

	// 完善个人信息发送手机验证码
	final public static String MOBILE_SEND_VALIDATE_CODE_COMPLETE = "mobile_send_validate_code_complete"; // 手机验证码
	final public static String MOBILE_SEND_MOBILE_COMPLETE = "mobile_send_mobile_complete"; // 接收验证码的手机号码
	final public static String MOBILE_SEND_LASTDATE_COMPLETE = "mobile_send_lastDate_complete"; // 手机接口发送验证码最后时间
	final public static String MOBILE_VALIDATE_ERROR_COUNT_COMPLETE = "mobile_validate_error_count_complete"; // 记录手机验证输入错误次数
	
	// 绑定手机号码发送手机验证码
	final public static String MOBILE_SEND_VALIDATE_CODE_BIND_MOBILE = "mobile_send_validate_code_bind_mobile"; // 手机验证码
	final public static String MOBILE_SEND_MOBILE_BIND_MOBILE = "mobile_send_mobile_bind_mobile"; // 接收验证码的手机号码
	final public static String MOBILE_SEND_LASTDATE_BIND_MOBILE = "mobile_send_lastDate_bind_mobile"; // 手机接口发送验证码最后时间
	final public static String MOBILE_VALIDATE_ERROR_COUNT_BIND_MOBILE = "mobile_validate_error_count_bind_mobile"; // 记录手机验证输入错误次数
	
	// 手机号码激活登录发送手机验证码
	final public static String MOBILE_SEND_VALIDATE_CODE_ACTIVE_MOBILE = "mobile_send_validate_code_active_mobile"; // 手机验证码
	final public static String MOBILE_SEND_MOBILE_ACTIVE_MOBILE = "mobile_send_mobile_active_mobile"; // 接收验证码的手机号码
	final public static String MOBILE_SEND_LASTDATE_ACTIVE_MOBILE = "mobile_send_lastDate_active_mobile"; // 手机接口发送验证码最后时间
	final public static String MOBILE_VALIDATE_ERROR_COUNT_ACTIVE_MOBILE = "mobile_validate_error_count_active_mobile"; // 记录手机验证输入错误次数
	final public static String EMAIL_URL = "email_url";
	final public static String SEND_CODE_TYPE = "send_code_type"; // 发送验证码类型

	final public static int SEND_VALIDATE_CODE_OK_CODE = 50300; // 发送成功
	final public static String SEND_VALIDATE_CODE_OK_TEXT = "发送手机验证码成功!";
	final public static int SEND_VALIDATE_CODE_ERROR_CODE = 50301; // 获取失败
	final public static String SEND_VALIDATE_CODE_ERROR_TEXT = "获取手机验证码失败!";
	final public static String SEND_VALIDATE_CODE_ERROR_TEXT_EXCEPTION = "获取手机验证码出现异常!";
	final public static int SEND_VALIDATE_CODE_ERROR_SHORT_DATE_CODE = 50302; // 获取失败
	final public static String SEND_VALIDATE_CODE_ERROR_SHORT_DATE_TEXT = "发送间隔太短,请稍候再试!"; // 发送间隔太短
	final public static String SEND_VALIDATE_CODE_ERROR_TIMEOUT_TEXT = "验证码已失效,请重新获取!"; // 验证码已失效
	final public static int INPUT_VALIDATE_CODE_ERROR_CODE = 50303; // 输入验证码次数过多
	final public static String INPUT_VALIDATE_CODE_ERROR_TEXT = "验证码错误!"; // 输入验证码次数过多
	final public static String INPUT_VALIDATE_CODE_ERROR_MORE_TEXT = "输入验证码错误次数过多,请重新获取!"; // 输入验证码次数过多
	final public static int SESSION_VALIDATE_CODE_ERROR_CODE = 50304; // session无验证码
	final public static String SESSION_VALIDATE_CODE_ERROR_TEXT = "请获取验证码!"; // session无验证码
	final public static int SESSION_VALIDATE_CODE_MOBILE_ERROR = 50305; // 输入手机号码与接收验证码的手机号码不符
	final public static String SESSION_VALIDATE_CODE_MOBILE_ERROR_TEXT = "输入手机号码与接收验证码的手机号码不符!"; // 输入手机号码与接收验证码的手机号码不符
	
	final public static String OPTIMIZE_URL = DomainConfig.getWap()+"/lottery/jingcai/jcAwardOptimize.php"; //奖金优化正式地址
	
	final public static int OPTIMIZE_CODE_ERROR_CODE=50306;
	final public static String OPTIMIZE_CODE_ERROR_TEXT="奖金优化数据异常";
	final public static String LOT_MGR_IOS = "lot_mgr_ios";
	final public static String LOT_MGR_ANDROID = "lot_mgr_android";
	
	final public static String TICKET_NOT_EXIST_TEXT = "票号不存在!";
	final public static int TICKET_NOT_EXIST_CODE = 50307;
	final public static String IMAGE_URL = "image_url"; 
	final public static String O2O_WEB_PAY = "o2o_web_pay"; 
	final public static String BALANCE_IS_ENOUGH = "balance_is_enough"; 
	
	final public static String ACTIVITY_TYPE = "activity_type";//充值活动类型
	final public static String ACTIVITY_DESC = "activity_desc";
	final public static String VALUE = "value";
	final public static String DESC = "desc";
	final public static String WEEK = "week";
	final public static String PRODUCE_HOST = DomainConfig.getWap();
	public static Map<String, Platform> platformMap = new HashMap<String, Platform>();
	
	static {
		platformMap.put(CLL_FOR_ANDROID2, Platform.ANDROID);
	    platformMap.put(CLLFORIOS2, Platform.IOS);
	    platformMap.put(LOT_MGR_ANDROID, Platform.LOT_MGR_ANDROID);
	    platformMap.put(LOT_MGR_IOS, Platform.LOT_MGR_IOS);
	}
}
