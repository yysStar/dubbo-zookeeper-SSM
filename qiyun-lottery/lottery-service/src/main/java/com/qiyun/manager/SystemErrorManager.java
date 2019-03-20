package com.qiyun.manager;

import com.qiyun.commonModel.ErrorStatus;
import com.qiyun.commonModel.ErrorType;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.error.SystemError;
import com.qiyun.model.ErrorGrade;

import java.util.Calendar;
import java.util.Date;

/**
 * 系统错误管理
 *
 * @author ysh
 *
 */
public class SystemErrorManager {

//	private SystemErrorService systemErrorService;
//	private static SystemErrorManager systemErrorManager;
//
//	public void setSystemErrorService(SystemErrorService systemErrorService) {
//		this.systemErrorService = systemErrorService;
//	}
//
//	/**
//	 * 初始化方法，spring实例化本类实体时被调用
//	 */
//	public final void init() {
//		systemErrorManager = this;
//	}

	/**
	 * 添加异常记录  zf 2012-8-5
	 *
	 * @param referNo
	 *            编号 (可以是:plan_no、ticket_no、batch_no、term_no、member_no)
	 * @param lotteryType
	 *            彩种
	 * @param errorType
	 *            异常类型
	 * @param content
	 *            异常明细
	 * @param e
	 *            代码异常对象
	 */
	public static void addError(ErrorType errorType, LotteryType lotteryType, String term, String referNo, String account, Double amount, String msg, Exception e) {

		// 填写默认信息
		SystemError systemError = generateBaseError(lotteryType, errorType, msg);
		// 根据不同的类型，生成关键字，级别
		if(errorType == ErrorType.彩期守护){

			systemError.setKeyWords("" + lotteryType + term ); //重复消息判断关键字
			systemError.setInterval(30);     	//重复消息查找时段 单位min
			systemError.setGrade( ErrorGrade.URGENT);

		}else if(errorType == ErrorType.拆票){

			systemError.setKeyWords("" + referNo ); //重复消息判断关键字
			systemError.setInterval(30);     	//重复消息查找时段 单位min
			systemError.setGrade( ErrorGrade.URGENT);


		}else if(errorType == ErrorType.送票){

			systemError.setKeyWords( "" + lotteryType + term  ); //重复消息判断关键字
			systemError.setInterval(30);     	//重复消息查找时段 单位min
			systemError.setGrade( ErrorGrade.URGENT);

		}else if(errorType == ErrorType.查票){

			systemError.setKeyWords( "" + lotteryType + term  ); //重复消息判断关键字
			systemError.setInterval(30);     	//重复消息查找时段 单位min
			systemError.setGrade( ErrorGrade.URGENT);


		}else if(errorType == ErrorType.检票){

			systemError.setKeyWords("" + referNo ); //重复消息判断关键字
			systemError.setInterval(30);     	//重复消息查找时段 单位min
			systemError.setGrade( ErrorGrade.URGENT);

		}else if(errorType == ErrorType.彩果抓取){

			systemError.setKeyWords("" + lotteryType + term ); //重复消息判断关键字
			systemError.setInterval(30);     	//重复消息查找时段 单位min
			systemError.setGrade( ErrorGrade.URGENT);

		}else if(errorType == ErrorType.对帐){
			systemError.setKeyWords("" + lotteryType + term +  referNo ); //重复消息判断关键字
			systemError.setInterval(30);     	//重复消息查找时段 单位min
			systemError.setGrade( ErrorGrade.URGENT);
		}else if(errorType == ErrorType.开奖){
			systemError.setKeyWords("" + lotteryType + term +  referNo ); //重复消息判断关键字
			systemError.setInterval(30);     	//重复消息查找时段 单位min
			systemError.setGrade( ErrorGrade.URGENT);
		}else if(errorType == ErrorType.派奖){

			systemError.setKeyWords("" + lotteryType + term +  referNo ); //重复消息判断关键字
			systemError.setInterval(30);     	//重复消息查找时段 单位min
			systemError.setGrade( ErrorGrade.URGENT);


		}else if(errorType == ErrorType.注册){

			//TODO:

		}else if(errorType == ErrorType.充值){

			systemError.setKeyWords("" + account +  referNo ); //重复消息判断关键字
			systemError.setInterval(30);     	//重复消息查找时段 单位min

			if(amount < 5000 ){ // 5k以下，普通 ,暂时不需要记录
				systemError.setGrade(  null );
			}else if( amount < 20000){ // 2w以下，警告
				systemError.setGrade( ErrorGrade.IMPORTANT);
			}else { // 2w以上，紧急
				systemError.setGrade( ErrorGrade.URGENT);
			}

		}else if(errorType == ErrorType.购彩){

			systemError.setKeyWords("" + account +  referNo ); //重复消息判断关键字
			systemError.setInterval(30);     	//重复消息查找时段 单位min

			if(amount < 5000 ){ // 5k以下，普通 ,暂时不需要记录
				systemError.setGrade(  null );
			}else if( amount < 20000){ // 2w以下，警告
				systemError.setGrade( ErrorGrade.IMPORTANT);
			}else { // 2w以上，紧急
				systemError.setGrade( ErrorGrade.URGENT);
			}

		}else if(errorType == ErrorType.提现){

			systemError.setKeyWords("" + account +  referNo ); //重复消息判断关键字
			systemError.setInterval(30);     	//重复消息查找时段 单位min
			amount=Math.abs(amount);
			if(amount < 3000 ){ // 3k以下，普通用户 ,暂时不记录
				systemError.setGrade(  null );
			}else if( amount < 20000){ // 2w以下，警告
				systemError.setGrade( ErrorGrade.IMPORTANT);
			}else { // 2w以上，紧急
				systemError.setGrade( ErrorGrade.URGENT);
			}
		}else if(errorType == ErrorType.VIP提现){
			systemError.setKeyWords("" + account +  referNo ); //重复消息判断关键字
			systemError.setInterval(30);     	//重复消息查找时段 单位min
			amount=Math.abs(amount);
			systemError.setGrade( ErrorGrade.IMPORTANT);
		}else if(errorType == ErrorType.方案出票){
			systemError.setKeyWords("" + account +  referNo ); //重复消息判断关键字
			systemError.setInterval(30);     	//重复消息查找时段 单位min
			amount=Math.abs(amount);
			systemError.setGrade( ErrorGrade.URGENT);
		}else if(errorType == ErrorType.数据){
			systemError.setKeyWords(referNo); //重复消息判断关键字
			systemError.setInterval(30);     	//重复消息查找时段 单位min
			systemError.setGrade( ErrorGrade.URGENT);
		}

		// 异常级别为null不记录
		if (systemError.getGrade() != null) {
			// 对于普通的错误记录默认为已经处理
			if (systemError.getGrade().getValue() == ErrorGrade.GENERAL.getValue()) {
				systemError.setStatus(ErrorStatus.TREATED);
			}
		} else {
			systemError = null;
		}


//		if (saveStrategy(systemError)) {
//			systemErrorManager.systemErrorService.save(systemError);
//		}
	}
//
	/**
	 * 生成基本错误实体
	 *
	 * @param lotteryType
	 * @param errorType
	 * @param content
	 * @return
	 */
	public static SystemError generateBaseError(LotteryType lotteryType, ErrorType errorType, String content) {
		SystemError systemError = new SystemError();
		if(lotteryType==null){
			lotteryType=LotteryType.NENO;
		}
		systemError.setLotteryType(lotteryType);
		systemError.setContent(content);
		systemError.setType(errorType);
		systemError.setCreateDateTime(new Date());
		systemError.setCreateBy("system");// 默认系统
		systemError.setStatus(ErrorStatus.UNTREAT);// 默认未处理
		systemError.setRemark(null);
		return systemError;
	}

//	/**
//	 * 异常保存策略
//	 *
//	 * @param systemError
//	 * @return
//	 */
//	public static boolean saveStrategy(SystemError systemError) {
//		if (systemError != null) {
//
//			// 计算时间段的开始时间
//			Calendar cal = Calendar.getInstance();
//			cal.add(Calendar.MINUTE, - systemError.getInterval());
//
//			//填充查找类
//			SystemErrorSearch search = new SystemErrorSearch();
//			search.setType(systemError.getType());   //警告类型
//			search.setStatus(ErrorStatus.UNTREAT);   //警告处理状态
//			search.setKeyWords(systemError.getKeyWords()); //警告关键字
//			search.setCreateStartDate(cal.getTime());//间隔时间
//
//
//			Integer count = systemErrorManager.systemErrorService.countBySearch(search);
//			if (count == 0) {
//				return true;
//			}
//		}
//
//		return false;
//	}

//	/**
//	 * 异常关键字策略
//	 *
//	 * @param systemError
//	 * @param content
//	 * @return
//	 */
//	public static String keyWordsStrategy(SystemError systemError, String content) {
//
//		return content;
//	}
//
//	/**
//	 * 异常等级策略
//	 *
//	 * @param systemError
//	 * @param content
//	 * @return
//	 */
//	public static ErrorGrade gradeStrategy(SystemError systemError, String content) {
//		// 此处加入等级判断策略 默认为普通
//		if (systemError.getType().getValue() == ErrorType.对帐.getValue()) {
//			// 高频彩开奖异常可能导致追号不成功，需立刻清查异常
//			if (LotteryType.gpMap.containsKey(systemError.getLotteryType().getValue())) {
//				return ErrorGrade.URGENT;
//			}
//			return null;
//		} else if (systemError.getType().getValue() == ErrorType.送票.getValue()) {
//			// 送票异常造成的影响大，需马上检查
//			return ErrorGrade.URGENT;
//		} else if (systemError.getType().getValue() == ErrorType.彩果抓取.getValue()) {
//			// 足彩抓取赛果异常可能导致不执行开奖操作追号失败，所以定为紧急
//			return ErrorGrade.URGENT;
//		} else {
//			return ErrorGrade.GENERAL;
//		}
//	}
//
//	public static void main(String[] args) {
//
//	}
}
