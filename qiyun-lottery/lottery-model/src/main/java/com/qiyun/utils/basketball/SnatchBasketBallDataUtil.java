package com.qiyun.utils.basketball;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qiyun.model.basketball.BasketBallMatch;
import com.qiyun.model.bean.BasketBallBaseBean;
import com.qiyun.tools.DateTools;
import com.qiyun.util.HttpUtil;
import com.qiyun.util.LogUtil;
import com.qiyun.util.NumberTools;
import net.sf.json.JSONArray;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.SimpleNodeIterator;
import org.jdom.input.SAXBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.InputSource;

public class SnatchBasketBallDataUtil {
	private static final String Scheduled_match_url = "http://info.sporttery.cn/basketball/match_interim.php";

	public static final String jclqUrl = "http://www.310win.com/info/match/nba_date.aspx";// 彩客网完场比分
	public static final String OK_JCLQ_OPENURL = "http://www.okooo.com/jingcailanqiu/kaijiang/";
	public static final String JCLQ_PM_URL = "http://live.500.com/lq.php?c=jc&e="; // 竞彩篮球即时比分
	public static final String GAME_NAME_URL = "http://liansai.500.com/lq/";


	public static StringBuffer getScheduledMatch() {
		StringBuffer sb = new StringBuffer("");
		String htmlContent = HttpUtil.getUrl(Scheduled_match_url);
		try {
			if(!htmlContent.equals("")){
				Document doc = Jsoup.parse(htmlContent);
				Element tableEle = doc.select("#headerTr").first().nextElementSibling().child(0);//竞彩TABLE
				String html="<tr class='trh'><th width=\"111\">联赛</th><th width=\"269\">主队vs客队</th><th width=\"116\">比赛开始时间</th>"
							+"<th width=\"111\">联赛</th><th width=\"269\">主队vs客队</th>"
							+"<th width=\"116\">比赛开始时间</th>"
							+"</tr>";
				Element tr=tableEle.child(0).child(0);
				tr.addClass("trh2");
				tr.before(html);
				sb.append(tableEle.outerHtml());
			}
		} catch (Exception e) {
			LogUtil.error(e);
		}
		return sb;
	}

	public static List<BasketBallMatch> getCkJclqMatch(String url) {
		List<BasketBallMatch> list = new ArrayList<BasketBallMatch>();
		try {
			String xmlStr = HttpUtil.getWebInfo(url);

			StringReader read = new StringReader(xmlStr);
			InputSource source = new InputSource(read);
			SAXBuilder sb = new SAXBuilder();
			org.jdom.Document doc = sb.build(source);
			org.jdom.Element root = doc.getRootElement().getChild("m");
			List child = root.getChildren("h");
			if (null != child && child.size() > 0) {
				for (int i = 0; i < child.size(); i++) {
					BasketBallMatch bbm = new BasketBallMatch();
					org.jdom.Element e = (org.jdom.Element) child.get(i);
					String[] baseStr = e.getText().split("\\^");
					if (!"".equals(baseStr[11]) && !"".equals(baseStr[12])) {
						bbm.setOutId(baseStr[0]);
						bbm.setHomeScore(Integer.valueOf(baseStr[11]));
						bbm.setGuestScore(Integer.valueOf(baseStr[12]));
						list.add(bbm);
					}
				}
			}

		} catch (Exception e) {
			LogUtil.error(e);
		}
		return list;
	}

	/**
	 * 抓取澳客的赛果
	 * 
	 * @param startDate
	 *            实际比赛开始时间 00:00:00
	 * @param endDate
	 *            实际比赛结束时间 23:59:59
	 * @return
	 */
	public static List<BasketBallMatch> getOkoooJclqMatch(Date startDate, Date endDate) {
		String start = DateTools.dateToString(startDate, "yyyy-MM-dd");
		String end = DateTools.dateToString(endDate, "yyyy-MM-dd");
		String url = OK_JCLQ_OPENURL + "?txtStartDate=" + start + "&txtEndDate=" + end;
		String html = HttpUtil.getUrl(url);
		List<BasketBallMatch> list = new ArrayList<BasketBallMatch>();
		Parser parser = Parser.createParser(html, "Gbk");
		NodeFilter trFilter1 = new HasAttributeFilter("class", "WhiteBg BlackWords trClass");
		NodeFilter trFilter2 = new HasAttributeFilter("class", "ContentLight BlackWords trClass");
		NodeFilter trFilter = new OrFilter(trFilter1, trFilter2);
		NodeFilter tdFilter = new NodeClassFilter(TableColumn.class);
		try {
			NodeList trNodeList = parser.extractAllNodesThatMatch(trFilter);
			SimpleNodeIterator trNodeIterator = trNodeList.elements();

			NodeList tdNodeList = null;
			Node tdNode = null;
			String lineId = "";
			Integer homeScore;
			Integer guestScore;
			String matchKey = "";
			String week = "";
			while (trNodeIterator.hasMoreNodes()) {
				tdNodeList = trNodeIterator.nextNode().getChildren().extractAllNodesThatMatch(tdFilter);
				tdNode = tdNodeList.elementAt(0);
				matchKey = tdNode.toPlainTextString().trim();
				lineId = matchKey.substring(matchKey.length() - 3);
				week = matchKey.substring(0, 2);
				tdNode = tdNodeList.elementAt(2);
				String matchDateText = tdNode.toPlainTextString().trim();
				String[] dateNumbers = matchDateText.split("\\D");
				matchDateText = dateNumbers[0] + "-" + dateNumbers[1] + " " + dateNumbers[2] + ":" + dateNumbers[3];
				Date matchDate = DateTools.strToDateDafueYear(matchDateText);
				Integer intTime = DateTools.handleIntTime(matchDate, week);

				String[] tmpSocre = tdNodeList.elementAt(5).toPlainTextString().trim().split("\\-");
				if (tmpSocre.length != 0) {
					homeScore = Integer.parseInt(tmpSocre[1]);
					guestScore = Integer.parseInt(tmpSocre[0]);
					BasketBallMatch match = new BasketBallMatch();
					match.setMatchTime(matchDate);
					match.setIntTime(intTime);
					match.setLineId(Integer.parseInt(lineId));
					match.setHomeScore(homeScore);
					match.setGuestScore(guestScore);
					list.add(match);
				}
			}

		} catch (ParserException e) {
			LogUtil.error(e);
		}
		return list;
	}

	public static List<BasketBallBaseBean> get500wMatch(String date) {
		String url = JCLQ_PM_URL + date;
		String html = HttpUtil.getUrl(url);
		Document doc = Jsoup.parse(html);
		Elements tableEle = doc.select("script");
		JSONArray jsonArray = null;
		for (Element e : tableEle) {
			String tmpHtml = e.html();
			if (tmpHtml.contains("matchList")) {
				int index = tmpHtml.indexOf("matchList=");
				tmpHtml = tmpHtml.substring(index + 10);
				index = tmpHtml.indexOf(";");
				tmpHtml = tmpHtml.substring(0, index);
				jsonArray = JSONArray.fromObject(tmpHtml);
				break;
			}
		}
		List<BasketBallBaseBean> beanList = new ArrayList<BasketBallBaseBean>();
		if (jsonArray != null) {
			for (Object obj : jsonArray) {
				BasketBallBaseBean bean = new BasketBallBaseBean();
				JSONArray array = (JSONArray) obj;
				String status=array.getString(0);
				if(status.equals("11")){
					status="已结束";
				}else if(status.equals("12")){
					status="改期";
				}else{
					status="";
				}
				String matchDate = array.getString(3) + " " + array.getString(4)+":00";
				String shortMatchName = array.getString(6);
				String gameColor = array.getString(8);
				Integer gameId = array.getInt(11);
				Integer guestId = array.getInt(12);
				String guest = array.getString(13);
				String guestPm=array.getString(16);
				Integer homeId = array.getInt(17);
				String home = array.getString(18);
				String homePm=array.getString(21);
				String guestBf = array.getString(22);
				String homeBf = array.getString(23);
				String shortGuest = array.getString(28);
				String shortHome = array.getString(29);
				String matchName = "";
				String matchKey = array.getString(26);
				try {
					List<String> list = getGameNameBy500(gameId);
					if (list != null && !list.isEmpty()) {
						matchName = list.get(0);
					}
				} catch (Exception e) {

				}
				Date matchTime = DateTools.StringToDate(matchDate);
				int intTime = DateTools.handleIntTime(matchTime, matchKey.substring(0, 2));
				int lineId = Integer.valueOf(matchKey.substring(2));
				String[] guestBfArr = guestBf.split("-|/");
				String[] homeBfArr = homeBf.split("-|/");
				if (homeBfArr.length >= 4) {
					bean.setFirstSection(homeBfArr[0] + ":" + guestBfArr[0]);
					bean.setSecondSection(homeBfArr[1] + ":" + guestBfArr[1]);
					bean.setThirdSection(homeBfArr[2] + ":" + guestBfArr[2]);
					bean.setFourthSection(homeBfArr[3] + ":" + guestBfArr[3]);
					if (homeBfArr.length == 5) {
						bean.setAddSection(homeBfArr[4] + ":" + guestBfArr[4]);
					}
					int homeWhole=0;
					for (int i = 0; i < homeBfArr.length; i++) {
						if(NumberTools.isNum(homeBfArr[i])) {
							homeWhole+=Integer.parseInt(homeBfArr[i]);
						}
					}
					int guestWhole=0;
					for (int i = 0; i < guestBfArr.length; i++) {
						if(NumberTools.isNum(guestBfArr[i])) {
							guestWhole+=Integer.parseInt(guestBfArr[i]);
						}
					}
					bean.setBfWhole(homeWhole+":"+guestWhole);
				}
				bean.setGameColor(gameColor);
				bean.setGuest(guest);
				bean.setGuestId(guestId);
				bean.setGuestPm(guestPm);
				bean.setHome(home);
				bean.setHomeId(homeId);
				bean.setHomePm(homePm);
				bean.setIntTime(intTime);
				bean.setLineId(lineId);
				bean.setMatchDateStr(matchDate);
				bean.setMatchTime(matchTime);
				bean.setMatchKey(matchKey);
				bean.setMatchName(matchName);
				bean.setShortMatchName(shortMatchName);
				bean.setShortHome(shortHome);
				bean.setShortGuest(shortGuest);
				bean.setStatus(status);
				beanList.add(bean);
			}
		}
		return beanList;

	}

	public static List<String> getGameNameBy500(Integer gameId) {
		String url = GAME_NAME_URL + gameId + "/";
		String htmlContent = HttpUtil.getUrl(url);
		Document doc = Jsoup.parse(htmlContent);
		String fullName = doc.select("#bd").select(".breadcrumb").text();
		fullName = fullName.substring(fullName.lastIndexOf(">") + 1);
		fullName = fullName.replaceFirst("[\\d|/]+", "").trim();

		String shortName = doc.select("#left_season_sel").select("option[selected]").text();
		shortName = shortName.substring(1).trim();

		List<String> list = new ArrayList<String>();
		list.add(fullName);
		list.add(shortName);
		return list;
	}

	public static void main(String[] args) {
		try {
			// getGameNameBy500(243);
			get500wMatch("2015-07-22");
		} catch (Exception e) {
			LogUtil.error(e);
		}

	}
}
