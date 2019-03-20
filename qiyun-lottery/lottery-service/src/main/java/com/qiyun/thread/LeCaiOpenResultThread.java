package com.qiyun.thread;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.qiyun.builder.AnalysisBuilderFactory;
import com.qiyun.builder.IndexInfoBuilder;
import com.qiyun.builder.TermInfoBuilder;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.lotteryterm.OpenCodeSnatcher_500w;
import com.qiyun.model.LotteryTerm;
import com.qiyun.model.LotteryTermStatus;
import com.qiyun.service.LotteryTermService;
import com.qiyun.tools.DateTools;
import com.qiyun.util.HttpUtil;
import com.qiyun.util.LogUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 抓取乐和彩网站的低频开奖号码进行预开,方便尽早在首页的最新开奖显示,但方案的开奖需要等到出票商提供的号码进行开奖
 * @author sxh
 *
 */
public class LeCaiOpenResultThread implements Runnable {
	@Autowired
	private LotteryTermService lotteryTermService;
	private TermInfoBuilder termInfoBuilder;
	private LotteryTerm openningTerm;
	private LotteryType lotteryType;
	private IndexInfoBuilder indexInfoBuilder;
	private AnalysisBuilderFactory analysisBuilderFactory;
	private static Map<Integer, String> leCaiType = new HashMap<Integer, String>();

	static {
		leCaiType.put(LotteryType.PL3.getValue(), "3");// 排3
		leCaiType.put(LotteryType.SSQ.getValue(), "50");// 双色球
		leCaiType.put(LotteryType.DLT.getValue(), "1");// 大乐透
		leCaiType.put(LotteryType.PL5.getValue(), "4");// 排列5
		leCaiType.put(LotteryType.QXC.getValue(), "2");// 七星彩
		leCaiType.put(LotteryType.FC3D.getValue(), "52");// 3D
		leCaiType.put(LotteryType.QLC.getValue(), "51");// 七乐彩
	}
	
	public void run() {
		long startTime = System.currentTimeMillis();
		Map<String, String> resultMap = new HashMap<String, String>();		
		LogUtil.info(openningTerm.getLotteryType().getName() + ":" + openningTerm.getTerm() + "开始抓取乐彩>>>");
		while (true) {
			lotteryType = openningTerm.getLotteryType();
			OpenCodeSnatcher_500w sn = new OpenCodeSnatcher_500w();
			openningTerm = sn.mainGetResult(openningTerm);
			if(openningTerm!=null && openningTerm.getResult()!=null && openningTerm.getResult()!="")
				resultMap.put("openResult", openningTerm.getResult());
			//getOpenResult(openningTerm, resultMap);
			if (resultMap.containsKey("openResult") && !strIsEmpty(resultMap.get("openResult"))) {

				// 取到开奖结果进行下列更新
				// 1. 更新后台数据
				updateLotteryTerm(openningTerm, resultMap);
//				try {
//					// 2.彩期信息静态化
//					buildTermStaticInfo(lotteryType);
//				} catch (Exception e) {}
//				// 4.更新首页 最新开奖公告
//				try {
//					indexInfoBuilder.make(lotteryType);
//				} catch (Exception e) {}
//				// 5.更新分析数据
//				try {
//					builderHistory(openningTerm);
//				} catch (Exception e) {}
				LogUtil.info("更新完成:" + DateTools.dateToString(new Date()));
				break;
			}
			
			if(openningTerm != null) {
				LogUtil.info(openningTerm.getLotteryType().getName() + ":" + openningTerm.getTerm()
						+ "-----乐彩开奖结果为空");
			}
			
			try {
				Thread.sleep(1000 * 60 * 5);//5分钟取一次
			} catch (InterruptedException e) {
				LogUtil.error(e);
			}
			if (System.currentTimeMillis() - startTime > 1000 * 60 * 60 * 2) {// 二小时还没取到退出线程
				LogUtil.info("线程抓取失败退出");
				break;
			}
		}
	}

	private void builderHistory(LotteryTerm term) {
		// 生成分析数据(需放在追号处理之前，有些彩种需要根据分析数据来判断是否追号),具体哪些彩种生成由配置决定
		try {
			LogUtil.info(term.getLotteryType().getName() + " 第" + term.getTerm() + "期 ，开始生成分析数据...");
			analysisBuilderFactory.builder(term.getLotteryType().getValue(), term.getTerm());
			LogUtil.info(term.getLotteryType().getName() + " 第" + term.getTerm() + "期 ，生成分析完成");
		} catch (Exception e) {
			LogUtil.error(term.getLotteryType().getName() + " 第" + term.getTerm() + "期 生成开奖期的分析数据失败!",e);
		}
	}

	private void updateLotteryTerm(LotteryTerm openningTerm, Map<String, String> mapDetail) {
		LotteryTerm lotteryTerm = lotteryTermService.findByLotteryTypeAndTerm(
				openningTerm.getLotteryType(),openningTerm.getTerm());
		if(lotteryTerm == null) {
			LogUtil.info("抓取乐和彩的开奖号码更新时,未找到对应的期数! lotteryType=" + openningTerm.getLotteryType()
					+ " term=" + openningTerm.getTerm());
		} else {
			lotteryTerm.setStatus(LotteryTermStatus.OPEN_PRIZE);
			lotteryTerm.setResult(mapDetail.get("openResult"));
			lotteryTermService.attachDirty(lotteryTerm);
		}
	}

	private void buildTermStaticInfo(LotteryType lotteryType) {
		try {
			LogUtil.info(lotteryType.getName() + " 第" + openningTerm.getTerm() + "期 ，开始生成彩期信息静态化数据");
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put(TermInfoBuilder.LOTTERY_TYPE, lotteryType.getValue() + "");
			termInfoBuilder.make(map);
			LogUtil.info(lotteryType.getName() + " 第" + openningTerm.getTerm() + "期 ，已经完成彩期信息静态化数据");
		} catch (Exception e) {
			String message = lotteryType.getName() + " 第" + openningTerm.getTerm() + "期生成彩期信息静态化异常";
			LogUtil.error(message,e);
		}
	}

	/**
	 * 用来读取乐彩当前彩种的当前期号的开奖数据，
	 * 
	 * @param lotteryTerm
	 *            乐彩彩种ID
	 * @return openResult 开奖号码
	 * @throws Exception
	 */
	public void getOpenResult(LotteryTerm lotteryTerm, Map<String, String> result) {
		String id = leCaiType.get(lotteryTerm.getLotteryType().getValue());
		String url = "http://www.lecai.com/lottery/draw/ajax_get_detail.php?lottery_type="+ id +"&phase=" + lotteryTerm.getTerm() ;
		String doc = null;
		try {
			LogUtil.info("抓取乐彩url:" + url);
			doc = HttpUtil.getUrl(url);
			LogUtil.info("抓取乐彩内容:" + doc);
		} catch (Exception e) {
			LogUtil.error("抓取乐彩数据失败!失败链接-->" + url,e);
		}

		getOpenDetail(lotteryTerm, result, doc, id);
	}

	/**
	 * 获取开奖数据并保存到Map中
	 * 
	 * @param lotteryTerm
	 * @param result
	 * @param strDom
	 * @param urlid
	 */
	private void getOpenDetail(LotteryTerm lotteryTerm, Map<String, String> result, String strDom, String urlid) {
		try {
			JSONObject obj = JSONObject.fromObject(strDom);
			JSONObject termOpenResult = null;
			termOpenResult = obj.getJSONObject("data");
			getOpenDetail(termOpenResult, result, lotteryTerm);
			printMap(result);
		} catch (Exception e) {
			LogUtil.error("抓取乐彩--" + lotteryTerm.getLotteryType().getName() + " 第 " + lotteryTerm.getTerm() + "期失败!",e);
		}

	}

	private void getOpenDetail(JSONObject termOpenResult, Map<String, String> result, LotteryTerm term) {
		String openNumred = "";
		JSONArray resultArray = (JSONArray)termOpenResult.getJSONObject("result").getJSONArray("result");
		for (int i = 0; i < resultArray.size(); i++) {
			JSONObject jo = (JSONObject) resultArray.get(i);
			openNumred += jo.getString("data").replace("\"", "").replace("[", "").replace("]", "")+",";
		}
		if(openNumred.endsWith(",")) {
			openNumred = openNumred.substring(0,openNumred.length()-1);
		}
		result.put("openResult", openNumred);
		return;
	}

	private boolean strIsEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}

	public void printMap(Map<String, String> map) {
		for (Map.Entry<String, String> enty : map.entrySet()) {
			LogUtil.info(enty.getKey() + ":" + enty.getValue());
		}
	}

	public void setLotteryTermService(LotteryTermService lotteryTermService) {
		this.lotteryTermService = lotteryTermService;
	}

	public TermInfoBuilder getTermInfoBuilder() {
		return termInfoBuilder;
	}

	public void setTermInfoBuilder(TermInfoBuilder termInfoBuilder) {
		this.termInfoBuilder = termInfoBuilder;
	}

	public static Map<Integer, String> getleCaiType() {
		return leCaiType;
	}

	public static void setleCaiType(Map<Integer, String> leCaiType) {
		LeCaiOpenResultThread.leCaiType = leCaiType;
	}

	public LotteryTermService getLotteryTermService() {
		return lotteryTermService;
	}

	public IndexInfoBuilder getIndexInfoBuilder() {
		return indexInfoBuilder;
	}

	public void setIndexInfoBuilder(IndexInfoBuilder indexInfoBuilder) {
		this.indexInfoBuilder = indexInfoBuilder;
	}


	public AnalysisBuilderFactory getAnalysisBuilderFactory() {
		return analysisBuilderFactory;
	}

	public void setAnalysisBuilderFactory(AnalysisBuilderFactory analysisBuilderFactory) {
		this.analysisBuilderFactory = analysisBuilderFactory;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public LotteryTerm getOpenningTerm() {
		return openningTerm;
	}

	public void setOpenningTerm(LotteryTerm openningTerm) {
		this.openningTerm = openningTerm;
	}

}
