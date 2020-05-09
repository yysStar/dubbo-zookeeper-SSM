package com.qiyun.lottery;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.tools.StringTools;
import com.qiyun.type.StartConditionType;
import com.qiyun.util.LogUtil;

import java.util.HashMap;

/**
 * 解析追号开始条件 前端调用显示
 * 
 * @author sxh 2011-5-26
 */
public class StartConditionParser {

	private static HashMap<String, String> featureMap = null;
	static {
		featureMap = new HashMap<String, String>();
		featureMap.put("dd", "大大");
		featureMap.put("dx", "大小");
		featureMap.put("xd", "小大");
		featureMap.put("xx", "小小");
		featureMap.put("jj", "单单");
		featureMap.put("jo", "单双");
		featureMap.put("oj", "双单");
		featureMap.put("oo", "双双");
	}

	public static String getStartConditionShow(LotteryType lotteryType, String startCondition, Integer totalTerm) {
		if (StringTools.isNullOrBlank(startCondition)) {
			return "";
		}

		String info = startCondition;

		try {
			String[] conditions = startCondition.split("\\:");// 条件类别:条件内容
			int type = Integer.parseInt(conditions[0]);
			String[] contents = conditions[1].split("\\#");// 条件特征+遗漏
			String v = "";
			
			if(lotteryType.getValue() == LotteryType.SSC.getValue()) {
				v = featureMap.get(contents[0]);
			} else if(lotteryType.getValue() == LotteryType.GD11X5.getValue()) {
				v = contents[0];
			} else if(lotteryType.getValue() == LotteryType.SYYDJ.getValue()) {
				v = contents[0];
			} else if(lotteryType.getValue() == LotteryType.JXDLC.getValue()) {
				v = contents[0];
			} else if(lotteryType.getValue() == LotteryType.CQ11X5.getValue()) {
				v = contents[0];
			} else if(lotteryType.getValue() == LotteryType.LN11X5.getValue()) {
				v = contents[0];
			} else if(lotteryType.getValue() == LotteryType.SH11X5.getValue()) {
				v = contents[0];
			} else if(lotteryType.getValue() == LotteryType.HLJ11X5.getValue()) {
				v = contents[0];
			} else if(lotteryType.getValue() == LotteryType.JS11X5.getValue()) {
				v = contents[0];
			}

			if (type == StartConditionType.BY_MISS.getValue()) {// 按遗漏
				info = "按遗漏启动追号<font color='red'>"+totalTerm+"</font>期,当<font color='red'>[" + v + "]</font>遗漏<font color='red'>" + contents[1] + "</font>期开始追";
			}

			if (type == StartConditionType.BY_FLOW.getValue()) {// 按跟随
				info = "按追随启动追号<font color='red'>"+totalTerm+"</font>期,当<font color='red'>[" + v + "]</font>号码出现后开始追";
			}
		} catch (Exception e) {
			LogUtil.info("解析追号开始条件发生错误");
		}

		return info;
	}
}
