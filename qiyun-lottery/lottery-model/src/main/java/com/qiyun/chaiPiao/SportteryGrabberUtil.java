package com.qiyun.chaiPiao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstactMatch;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.model.PassMode;
import com.qiyun.model.football.MatchAwardOfRQSPF;
import com.qiyun.model.football.MatchAwardOfSPF;
import com.qiyun.tools.DateTools;
import com.qiyun.util.HttpUtil;
import com.qiyun.util.LogUtil;
import com.qiyun.utils.StringTools;
import org.apache.http.conn.HttpHostConnectException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class SportteryGrabberUtil {

	private static final String bballInfoURL = "http://www.2caipiao.com/dcpage/jclc/index_guding_rfsf.shtml";
	private static final String fballInfoURL = "http://odds.cailele.com/index.php?controller=index&action=index&d=";
	private static final String bbOldOutIdUrl = "http://www.2caipiao.com/lottery/jcReport!lcMatchResult.jhtml?lotteryType=46&";
	private static final String bbOutIdUrlByYcw = "http://buy.betzc.com/jclq/rfsf.html";
	private static final String bbOutIdUrlByCk = "http://www.310win.com/buy/JingCaiBasket.aspx?typeID=112";
	//private static final String bbOutIdUrlByLC = "http://odds.cailele.com/sdata/jclqxml.php"; 
	private static final String bbOutIdUrlByLC = "http://kjh.cailele.com/kj_basketball.shtml";	
	private static final String bbAwardTzbUrl = "http://info.sporttery.cn/basketball/vote/bk_vote.php?";
	private static final String fbAwardTzbUrl = "http://info.sporttery.cn/basketball/vote/fb_vote.php?type=hhad";
	private static final String fbOutIdUrlByWbw = "http://trade.500.com/jczq/?date=";
//	private static final String fbRateUrlBySporrttery = "http://info.sporttery.cn/football/info/fb_match_hhad.php?m=";	// 抓取官网概率地址
	private static final String fbRateUrlBySporrttery = "http://i.sporttery.cn/api/fb_match_info/get_odds?mid=";
	
	@SuppressWarnings("unchecked")
	public static <X extends AbstactMatch> List<X> getMatchList(String platformName) {
		List<X> matchList = new ArrayList<X>();
		PlatformEnum p = PlatformEnum.valueOfName(platformName);
		if (p != null) {
			String url=p.getMatchUrl();
			String html= HttpUtil.getHttpUrl(url+System.currentTimeMillis());
			
//			String statusUrl = p.getStatusUrl();
//			String statusHtml = "";
//			if (!"".equals(statusUrl)) {
//				statusHtml = HttpUtil.getUrl(statusUrl);
//			}
//			if (!StringTools.isNullOrBlank(statusHtml)) {
				matchList = p.getMatchInterface().getMatchList(html, "");
//			}
		}
		return matchList;
	}

	public static Map<String, String> getBballInfo() {
		String html = HttpUtil.getUrl(bballInfoURL);
		Map<String, String> infoMap = MatchList.getInfoJSON(html);
		return infoMap;
	}

	public static Map<String, String> getFballOutId(String dateText) {
		try {
			String html = HttpUtil.getUrl(fbOutIdUrlByWbw + dateText);
			Map<String, String> infoMap = MatchList.getFootballOutIdByWbw(html, dateText);
			return infoMap;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Map<String, String> getBballAnalysisIdFromLC() {
		String html = HttpClientUtil.getRemoteStr(bbOutIdUrlByLC, "GBK");
		Map<String, String> infoMap = MatchList.getAnalysisIdByLC(html);
		return infoMap;
	}

	public static Map<String, String> getBballOutIdFromCk() {
		String html = HttpClientUtil.getRemoteStr(bbOutIdUrlByCk, "GBK");
		Map<String, String> infoMap = MatchList.getOutIdByCk(html);
		return infoMap;
	}

	public static Map<String, String> getBballOutId() {
		String html = HttpClientUtil.getRemoteStr(bbOutIdUrlByYcw, "GBK");
		Map<String, String> infoMap = MatchList.getOutIdByYcw(html);
		return infoMap;
	}

	public static Map<String, String> getBballOldOutId(String dateTime) {

		String date = "startMatchTime=" + dateTime + "&endMatchTime=" + dateTime;
		String html = HttpClientUtil.getRemoteStr(bbOldOutIdUrl + date, "GBK");
		Map<String, String> infoMap = MatchList.getOldOutId(html);
		return infoMap;
	}

	// 获取大赢家链接ID
	public static List<String[]> getAllFblloutId() throws HttpHostConnectException {
		List<String[]> fballInfos = new ArrayList<String[]>();
		Integer page = FootballMatchList.getPage(fballInfoURL + 0);
		if (page != null) {
			for (int i = 0; i < page; i++) {
				List<String[]> fballToday = FootballMatchList.getfballInfo(fballInfoURL + "0&cid=0&c=0&n=0&pgf=1&pg=" + i);
				fballInfos.addAll(fballToday);
			}
		}

		page = FootballMatchList.getPage(fballInfoURL + 11);
		if (page != null) {
			for (int i = 0; i < page; i++) {
				List<String[]> fballTomorrow = FootballMatchList.getfballInfo(fballInfoURL + "11&cid=0&c=0&n=0&pgf=1&pg=" + i);
				fballInfos.addAll(fballTomorrow);
			}
		}
		return fballInfos;
	}


	/**
	 * 获取竞彩足球开奖结果 (来源官网), 篮彩不使用
	 * @param <X>
	 * @param platformName
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public static <X extends AbstactMatch> List<X> getMatchResultList(String platformName, Date startDate, Date endDate) {

		String format = "yyyy-MM-dd";
		String start_date = DateTools.dateToString(startDate, format);
		String end_date = DateTools.dateToString(endDate, format);

		PlatformEnum p = PlatformEnum.valueOfName(platformName);
		String resultUrl = p.getResultUrl();// 结果请求地址
		if (p != null) {
			String html = HttpUtil.getUrl(resultUrl + "?start_date=" + start_date + "&end_date=" + end_date);
			Integer page = p.getMatchInterface().getResultPage(html);
			List<X> matchsList = new ArrayList<X>();
			for (int i = 1; i <= page; i++) {
				try {
					String pageHtml = HttpUtil.getUrl(resultUrl + "?page=" + i + "&start_date=" + start_date + "&end_date=" + end_date);
					List<X> matchList = p.getMatchInterface().getMatchResultList(pageHtml);
					matchsList.addAll(matchList);
				} catch (Exception e) {
					LogUtil.error(e);
				}
			}
			return matchsList;
		}
		return new ArrayList<X>();
	}
	
	/**
	 * 获取篮彩(来源彩客)的开奖结果, 竞彩足球不适用
	 * @param <X>
	 * @param platformName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <X extends AbstactMatch> List<X> getMatchResultList(String platformName) {
		PlatformEnum p = PlatformEnum.valueOfName(platformName);
		String resultUrl = p.getResultUrl();// 结果请求地址
		if (p != null) {
			String html = HttpUtil.getUrl(resultUrl);
			List<X> matchList = p.getMatchInterface().getMatchResultList(html);
			return matchList;
		}
		return new ArrayList<X>();
	}

	@SuppressWarnings("unchecked")
	public static <X extends AbstactMatch> List<X> getMatchResultAwardList(String platformName) {
		PlatformEnum p = PlatformEnum.valueOfName(platformName);
		if (p != null) {
			String resultAwardUrl = p.getResultSingleAwardUrl();// 结果请求地址
			String html = HttpUtil.getUrl(resultAwardUrl);
			List<X> matchList = p.getMatchInterface().getSingleResultAward(html);
			return matchList;
		}
		return new ArrayList<X>();
	}

	/**
	 * 开奖结果过关盘口
	 * 
	 * @param <X>
	 * @param platformName
	 * @return
	 */
	public static <X extends AbstactMatch> List<X> getMatchResultPassPankouList(String platformName) {
		PlatformEnum p = PlatformEnum.valueOfName(platformName);
		if (p != null) {
			String resultAwardUrl = p.getResultPassUrl();// 结果请求地址
			String html = HttpUtil.getUrl(resultAwardUrl);
			List<X> matchList = p.getMatchInterface().getPassResultPankou(html);
			return matchList;
		}
		return new ArrayList<X>();
	}

	@SuppressWarnings("unchecked")
	public static <X extends AbstractAward> List<X> getAwardList(LotteryType type, byte passMode) {
		AwardListEnum ale = AwardListEnum.enumOfAwardByLotteryType(type);
		if (ale != null) {
			AwardInterface<X> awardInterface = ale.getAwardInterface();
			String url = ale.getSingleUrl();
			String html = HttpUtil.getHttpUrl(url+System.currentTimeMillis());
			if (passMode == 0) {// 单关
				return awardInterface.getSingleAwardList(html);
			} else {// 过关
				return awardInterface.getPassAwardList(html);
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <X extends AbstractAward> List<X> getAwardList(String type, byte passMode) {
		AwardListEnum ale = AwardListEnum.valueOfName(type);
		if (ale != null) {
			AwardInterface<X> awardInterface = ale.getAwardInterface();
			if (passMode == 0) {// 单关
				String url = ale.getSingleUrl();
				String html = HttpUtil.getUrl(url);
				return awardInterface.getSingleAwardList(html);
			} else {// 过关
				String url = ale.getPassUrl();
				String html = HttpUtil.getUrl(url);
				return awardInterface.getPassAwardList(html);
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <X extends AbstactMatch> List<X> getRFList(String platformName, byte passMode) {
		PlatformEnum p = PlatformEnum.valueOfName(platformName);
		AwardListEnum ale = AwardListEnum.SFRFAWARD;
		if (p != null) {
			if (passMode == 0) {// 单关
				String url = ale.getSingleUrl();
				String html = HttpUtil.getUrl(url);
				return p.getMatchInterface().getRFofSingle(html);
			} else {// 过关
				String url = ale.getPassUrl();
				String html = HttpUtil.getUrl(url);
				return p.getMatchInterface().getRFofPass(html);
			}

		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <X extends AbstactMatch> List<X> getDXbaseList(String platformName, byte passMode) {
		PlatformEnum p = PlatformEnum.valueOfName(platformName);
		AwardListEnum ale = AwardListEnum.DXF;
		if (p != null) {
			if (passMode == 0) {// 单关
				String url = ale.getSingleUrl();
				String html = HttpUtil.getUrl(url);
				return p.getMatchInterface().getDXbaseofSingle(html);
			} else {// 过关
				String url = ale.getPassUrl();
				String html = HttpUtil.getUrl(url);
				return p.getMatchInterface().getDXbaseofPass(html);
			}

		}
		return null;
	}

	// 篮球投注比
	public static Map<String, String> getAwardTzb(LotteryType lType, String date) {
		String html = bbAwardTzbUrl;
		if (lType == LotteryType.JC_LQ_SF)
			html += "type=mnl&num=" + date;
		if (lType == LotteryType.JC_LQ_RFSF)
			html += "type=hdc&num=" + date;
		if (lType == LotteryType.JC_LQ_DXF)
			html += "type=hilo&num=" + date;
		String htmlContent = HttpUtil.getUrl(html);
		int pageSize = MatchList.pageCount(htmlContent);
		Map<String, String> tzbMap = MatchList.getAwardTzb(htmlContent);
		for (int i = 2; i < pageSize + 1; i++) {
			String tempContent = HttpUtil.getUrl(html + "&pg=" + i);
			tzbMap.putAll(MatchList.getAwardTzb(tempContent));
		}
		return tzbMap;
	}

	// 足球投注比
	public static Map<String, String> getFootBallAwardTzb(String date) {
		String url = fbAwardTzbUrl;
		Map<String, String> tzbMap = MatchList.getFootBallBetInfo(url + "&num=" + date);
		return tzbMap;
	}
	/**
	 * 抓取官网的spf/rqspf的概率和SP
	 * @param <X>
	 * @param mid
	 * @param intTime
	 * @param lineId
	 * @return
	 */
	public static <X extends AbstractAward> Map<String,List<X>> getFbAwardRateList(String mid,Integer intTime,Integer lineId) {
		Map<String,List<X>> map=new HashMap<String, List<X>>();
		String url = fbRateUrlBySporrttery + mid;
		String html = HttpUtil.getHttpUrlJson(url);
		if (StringTools.isNullOrBlank(html)) {
//			SystemErrorManager.addError(ErrorType.数据, LotteryType.JC_ZQ, "201001", intTime+"_"+lineId, null, null, "数据抓取错误,mathcKey:"+intTime+"_"+lineId+"地址"+url, null);
		} else {
			// 解析
//			List<LotteryType> typeList=new ArrayList<LotteryType>();
//			typeList.add(LotteryType.JC_ZQ_SPF);
//			typeList.add(LotteryType.JC_ZQ_RQSPF);

			LotteryType lotteryType = LotteryType.JC_ZQ_SPF;
			JSONObject resultJson = JSONObject.parseObject(html);
			resultJson = resultJson.getJSONObject("result");
			for(String key : resultJson.keySet()) {
				if(!"had".equals(key) && !"hhad".equals(key)) {
					continue;
				}

				List<X> list = new ArrayList<X>();
				JSONObject json = resultJson.getJSONObject(key);
				JSONArray awardList = json.getJSONArray("list");
				for(int i=0; i<awardList.size(); i++) {
					JSONObject awardJson = awardList.getJSONObject(i);
					String homeAward = awardJson.getString("h");// 胜sp
					String drawAward = awardJson.getString("d");// 平sp
					String guestAward = awardJson.getString("a");// 负sp
					String homeRate = awardJson.getString("h_ratio").trim().replace("%", "");// 胜率
					String drawRate = awardJson.getString("d_ratio").trim().replace("%", "");// 平率
					String guestRate = awardJson.getString("a_ratio").trim().replace("%", "");// 负率
					String updateTime = awardJson.getString("date").trim() + " " + awardJson.getString("time").trim();
					X award;
					if("had".equals(key)) {
						lotteryType = lotteryType.JC_ZQ_SPF;
						MatchAwardOfSPF spfAward = new MatchAwardOfSPF();
						spfAward.setLastUpdateTime(DateTools.StringToDate(updateTime, "yyyy-MM-dd HH:mm:ss"));
						spfAward.setHomeRate(Double.parseDouble(homeRate));
						spfAward.setDrawRate(Double.parseDouble(drawRate));
						spfAward.setGuestRate(Double.parseDouble(guestRate));
						award = (X) spfAward;
					} else {
						lotteryType = LotteryType.JC_ZQ_RQSPF;
						MatchAwardOfRQSPF rqspfAward = new MatchAwardOfRQSPF();
						rqspfAward.setLastUpdateTime(DateTools.StringToDate(updateTime, "yyyy-MM-dd HH:mm:ss"));
						rqspfAward.setHomeRate(Double.parseDouble(homeRate));
						rqspfAward.setDrawRate(Double.parseDouble(drawRate));
						rqspfAward.setGuestRate(Double.parseDouble(guestRate));
						award = (X) rqspfAward;

					}
					Double[] awardArr = new Double[3];
					awardArr[0] = Double.parseDouble(homeAward);
					awardArr[1] = Double.parseDouble(drawAward);
					awardArr[2] = Double.parseDouble(guestAward);
					award.setIntTime(intTime);
					award.setLineId(lineId);
					award.setAwardArr(awardArr);
					award.setCreateDate(new Date());
					award.setPassMode(PassMode.PASS.ordinal());
					list.add(award);
					String k = intTime+"_"+lineId+"_"+lotteryType.getValue();
					map.put(k, list);
				}
			}
		}
		return map;
			
//			Document doc = Jsoup.parse(html);
//			Elements tables = doc.getElementsByClass("date6");
//			for(LotteryType lotteryType : typeList){
//				List<X> list = new ArrayList<X>();
//				Element table;
//				if (lotteryType == lotteryType.JC_ZQ_SPF) {
//					table = tables.get(0);
//				} else {
//					table = tables.get(1);
//				}
//				Elements trs = table.select("tr");
//				int j = 0;
//				for (Element tr : trs) {
//					if (j < 2) { // 前2行不需要
//						j++;
//						continue;
//					}
//					j++;
//					Elements tds = tr.children();
//					
//				}
//			}
//		}
	}

	public static void main(String args[]) throws HttpHostConnectException {
	}
}
