package com.qiyun.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.qiyun.httpUtil.HttpUtil;
import com.qiyun.model.FootballMatch;
import com.qiyun.model.FootballMatchBean;
import com.qiyun.tools.DateTools;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.CssSelectorNodeFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.SelectTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.visitors.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FootballDataUtil {
	private static String team_name_baseUrl = "http://odds.500.com/fenxi/yazhi.php?id=";
	private static String game_name_baseUrl = "http://liansai.500.com/seasonindex-seasonid-";
	private static String sporttery_footBall_match="http://info.sporttery.cn/football/match_interim.php";//官网受注赛程地址
	private static String sporttery_basketball_match="http://info.sporttery.cn/basketball/match_interim.php";//官网受注赛程地址

	public static FootballMatch getWuBaiWanFootballMatch(Integer oddId) {
		if (oddId != null && oddId != 0) {
			return getWuBaiWanFootballMatch(team_name_baseUrl + oddId);
		}
		return null;
	}
	/**
	 * 返回抓取到的联赛名和缩写
	 * @param gameId
	 * @return index=0-全称,1-缩写
	 */
	public static List<String> getWuBaiWanFootballGame(Integer gameId) {
		List<String> nameList=null;
		if (gameId != null && gameId != 0) {
			String htmlContent = HttpUtil.getUrl(game_name_baseUrl + gameId);
			nameList=getWuBaiWanFootballGame(htmlContent);
		}
		return nameList;
	}
	
	

	public static List<String> getWuBaiWanFootballGame(String htmlContent) {
		List<String> resultList=new ArrayList<String>();
		try {
			Parser parser = Parser.createParser(htmlContent, "GBK");
			HtmlPage vistor = new HtmlPage(parser);
			parser.visitAllNodesWith(vistor);
			NodeList body = vistor.getBody();
			
			NodeFilter gameFilter = new HasAttributeFilter("id","season_name");
			NodeList season_name = body.extractAllNodesThatMatch(gameFilter, true);
			String matchName=season_name.elementAt(0).toPlainTextString().trim();
			Pattern pattern = Pattern.compile("[\\d|/]+");
			Matcher matcher = pattern.matcher(matchName);
			matchName=matcher.replaceFirst("").trim();
			
			NodeFilter shortNameFilter=new HasAttributeFilter("class","butt1");
			NodeFilter selectFilter=new NodeClassFilter(SelectTag.class);
			NodeFilter optionFilter=new CssSelectorNodeFilter("option[selected]");
			NodeList list=body.extractAllNodesThatMatch(shortNameFilter,true).extractAllNodesThatMatch(selectFilter,true).extractAllNodesThatMatch(optionFilter,true);
			String shortMatchName=list.elementAt(0).toPlainTextString().substring(1).trim();
			resultList.add(matchName);
			resultList.add(shortMatchName);
		} catch (Exception e) {
			
		}
		return resultList;
	}

	public static FootballMatch getWuBaiWanFootballMatch(String url) {
		FootballMatch match = null;
		try {
			Document doc = Jsoup.connect(url).timeout(10*1000).get();
			Element homeTeamInfo=doc.select(".against_a").select("a").get(1);
			Element guestTeamInfo=doc.select(".against_b").select("a").get(1);
			Element gameInfo=doc.select(".against_m").select("a").first();
			if (homeTeamInfo != null && guestTeamInfo != null) {
				match = new FootballMatch();
				match.setHome(homeTeamInfo.text());
				match.setGuest(guestTeamInfo.text());
				String gameId=gameInfo.attr("href").replaceAll("500\\.com|\\D", "");
				if(gameId!=null){
					List<String> nameList = getWuBaiWanFootballGame(Integer.parseInt(gameId));
					if(nameList!=null && nameList.size()==2){
						match.setMatchName(nameList.get(0));
						match.setShortMatchName(nameList.get(1));
					}
				}
			}
		} catch (Exception e) {
			LogUtil.error(e);
		}
		return match;
	}

	public static Map<String, String> getSporrteryFootballOutId(Date matchDate) {
		Map<String, String> footballOutId = new HashMap<String, String>();
		
		return null;
	}
	
	/**
	 * 官方竞彩足球受注赛程
	 * 只有matchName,homeTeam,guestTeam,matchTime
	 * @return
	 */
	public static List<FootballMatchBean> getJCFBGZMatch(){
		return getGZMatch(sporttery_footBall_match);
	}
	/**
	 * 官方竞彩篮球受注赛程
	 * 只有matchName,homeTeam,guestTeam,matchTime
	 * @return
	 */
	public static List<FootballMatchBean> getBBGZMatch(){
		return getGZMatch(sporttery_basketball_match);
	}
	
	/**
	 * 官方受注赛程
	 * 只有matchName,homeTeam,guestTeam,matchTime
	 * @return
	 */
	private static List<FootballMatchBean> getGZMatch(String url){
		List<FootballMatchBean> beanList=new ArrayList<FootballMatchBean>();
		try{
			String html=HttpUtil.getUrl(url);
			if(!html.equals("")){
				Document doc = Jsoup.parse(html);
				Element tableEle = doc.select("#headerTr").first().nextElementSibling().child(0);//竞彩TABLE
				Elements trs=tableEle.child(0).children();
				for (Element tr : trs) {
					Elements tds=tr.children();
					if(tds.size()>1){
						List<List<Element>> tdList=new ArrayList<List<Element>>();
						tdList.add(tds.subList(0, 3));
						tdList.add(tds.subList(tds.size()-3, tds.size()));
						for (List<Element> list : tdList) {
							String matchName=list.get(0).text().trim();
							String[] teamArr=list.get(1).text().trim().split("vs|VS");
							String matchTime=list.get(2).text().trim();
							if(teamArr.length==2){
								FootballMatchBean bean=new FootballMatchBean();
								bean.setMatchName(matchName);
								bean.setHome(teamArr[0].trim());
								bean.setGuest(teamArr[1].trim());
								bean.setMatchTime(DateTools.StringToDate_YYYY_MM_DD_HH_MM(matchTime));
								beanList.add(bean);
							}
						}
					}
				}
			}
		}catch (Exception e) {
//			SystemErrorManager.addError(ErrorType.数据, LotteryType.JC_ZQ, "201001", "", null, null, "数据抓取错误,地址"+url, null);
		}
		return beanList;
	}
}
