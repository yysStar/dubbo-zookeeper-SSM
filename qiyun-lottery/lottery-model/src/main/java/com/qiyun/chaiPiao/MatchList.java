package com.qiyun.chaiPiao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.qiyun.model.MatchShowStatus;
import com.qiyun.model.basketball.BasketBallMatch;
import com.qiyun.tools.DateTools;
import com.qiyun.util.DateUtil;
import com.qiyun.util.HttpUtil;
import com.qiyun.util.LogUtil;
import com.qiyun.utils.NumberTools;
import com.qiyun.utils.StringTools;
import net.sf.json.JSONObject;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.CssSelectorNodeFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.filters.StringFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.SimpleNodeIterator;
import org.htmlparser.visitors.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MatchList implements MatchInterface<BasketBallMatch> {
	
	public static Map<String, String> MATCH_MAP = new HashMap<String, String>(); //  抓取来的name  替换的name
	public static Map<String, String> MATCH_MAP_GAMENAME = new HashMap<String, String>(); //  抓取来的name  替换的name
	static {
		MATCH_MAP.put("纽约尼克斯","尼克斯");
		MATCH_MAP.put("布鲁克林篮网","篮网");
		MATCH_MAP.put("波士顿凯尔特人","凯尔特人");
		MATCH_MAP.put("多伦多猛龙","猛龙");
		MATCH_MAP.put("费城76人","76人");
		MATCH_MAP.put("底特律活塞","活塞");
		MATCH_MAP.put("印第安那步行者","步行者");
		MATCH_MAP.put("克利夫兰骑士","骑士");
		MATCH_MAP.put("密尔沃基雄鹿","雄鹿");
		MATCH_MAP.put("芝加哥公牛","公牛");
		MATCH_MAP.put("迈阿密热火","热火");
		MATCH_MAP.put("奥兰多魔术","魔术");
		MATCH_MAP.put("华盛顿奇才","奇才");
		MATCH_MAP.put("亚特兰大老鹰","老鹰");
		MATCH_MAP.put("新奥尔良鹈鹕","鹈鹕");
		MATCH_MAP.put("明尼苏达森林狼","森林狼");
		MATCH_MAP.put("丹佛掘金","掘金");
		MATCH_MAP.put("犹他爵士","爵士");
		MATCH_MAP.put("波特兰开拓者","开拓者");
		MATCH_MAP.put("俄克拉荷马城雷霆","雷霆");
		MATCH_MAP.put("萨克拉门托国王","国王");
		MATCH_MAP.put("洛杉矶湖人","湖人");
		MATCH_MAP.put("菲尼克斯太阳","太阳");
		MATCH_MAP.put("金州勇士","勇士");
		MATCH_MAP.put("洛杉矶快船","快船");
		MATCH_MAP.put("圣安东尼奥马刺","马刺");
		MATCH_MAP.put("休斯敦火箭","火箭");
		MATCH_MAP.put("达拉斯小牛","小牛");
		MATCH_MAP.put("孟菲斯灰熊","灰熊");
		MATCH_MAP.put("夏洛特黄蜂","黄蜂");
		
		MATCH_MAP_GAMENAME.put("欧篮联", "EURO");
		MATCH_MAP_GAMENAME.put("美职篮", "NBA");

	}
	
	@SuppressWarnings("unchecked")
	/*
	 * 获得对阵信息
	 */
	public List<BasketBallMatch> getMatchList(String html,String statusHtml) {
		List<BasketBallMatch> matchList = new ArrayList<BasketBallMatch>();
		if(html == null) {
			return matchList;
		}
		
		try {
			html = html.substring(8, html.length()-2);
			JSONObject o = JSONObject.fromObject(html);
			JSONObject list = o.getJSONObject("data");
			Iterator it = list.keys();
			
			while(it.hasNext()){
				String key = it.next().toString();
				JSONObject item = list.getJSONObject(key);
				String numberStr = item.get("num").toString().trim();
				String weekStr = numberStr.substring(0, 2);
				String lineId = numberStr.substring(2, numberStr.length());
				String date = item.get("date").toString().trim();
				String time = item.get("time").toString().trim();
				String color = item.get("l_background_color").toString().trim();
				String intTime = item.get("b_date").toString().trim().replaceAll("-", "");
				String gameName = item.get("l_cn_abbr").toString().trim();
				String homeTeam = item.get("h_cn_abbr").toString().trim();
				String guestTeam = item.get("a_cn_abbr").toString().trim();
				String status = item.get("status").toString().trim();
				List<MatchShowStatus> statusList = MatchShowStatus.getShowStatsuOrderList();
				
				//胜负
				if(item.containsKey("mnl")){
					String jsonHad =  item.get("mnl").toString().trim();
					JSONObject json = JSONObject.fromObject(jsonHad);
					String pStatus = json.get("p_status").toString().trim();
					if("Selling".equals(pStatus)) {
						String single = json.get("single").toString().trim();
						if("0".equals(single)) {
							statusList.remove(MatchShowStatus.SFSINGLE);
						}
					} else {
						statusList.remove(MatchShowStatus.SFPASS);
						statusList.remove(MatchShowStatus.SFSINGLE);
					}
				} else {
					statusList.remove(MatchShowStatus.SFPASS);
					statusList.remove(MatchShowStatus.SFSINGLE);
				}
				
				//让分胜负
				String  rf = "0";
				if(item.containsKey("hdc")){
					String jsonHad =  item.get("hdc").toString().trim();
					JSONObject json = JSONObject.fromObject(jsonHad);
					rf = json.get("fixedodds").toString().trim();
					String pStatus = json.get("p_status").toString().trim();
					if("Selling".equals(pStatus)) {
						String single = json.get("single").toString().trim();
						if("0".equals(single)) {
							statusList.remove(MatchShowStatus.RFSFSINGLE);
						}
					} else {
						statusList.remove(MatchShowStatus.RFSFPASS);
						statusList.remove(MatchShowStatus.RFSFSINGLE);
					}
				} else {
					statusList.remove(MatchShowStatus.RFSFPASS);
					statusList.remove(MatchShowStatus.RFSFSINGLE);
				}
				
				//大小分
				String  yszf = "0";
				if(item.containsKey("hilo")){
					String jsonHad =  item.get("hilo").toString().trim();
					JSONObject json = JSONObject.fromObject(jsonHad);
					yszf = json.get("fixedodds").toString().trim();
					String pStatus = json.get("p_status").toString().trim();
					if("Selling".equals(pStatus)) {
						String single = json.get("single").toString().trim();
						if("0".equals(single)) {
							statusList.remove(MatchShowStatus.DXFSINGLE);
						}
					} else {
						statusList.remove(MatchShowStatus.DXFPASS);
						statusList.remove(MatchShowStatus.DXFSINGLE);
					}
				} else {
					statusList.remove(MatchShowStatus.DXFPASS);
					statusList.remove(MatchShowStatus.DXFSINGLE);
				}
				
				//胜分差
				if(item.containsKey("wnm")){
					String jsonHad =  item.get("wnm").toString().trim();
					JSONObject json = JSONObject.fromObject(jsonHad);
					String pStatus = json.get("p_status").toString().trim();
					if("Selling".equals(pStatus)) {
						String single = json.get("single").toString().trim();
						if("0".equals(single)) {
							statusList.remove(MatchShowStatus.SFCSINGLE);
						}
					} else {
						statusList.remove(MatchShowStatus.SFCPASS);
						statusList.remove(MatchShowStatus.SFCSINGLE);
					}
				} else {
					statusList.remove(MatchShowStatus.SFCPASS);
					statusList.remove(MatchShowStatus.SFCSINGLE);
				}
				
				BasketBallMatch match = new BasketBallMatch();
				match.setLineId(Integer.parseInt(lineId));
				match.setWeekStr(weekStr);
				Date matchTime = DateTools.StringToDate_YYYY_MM_DD_HH_MM_SS(date+" "+time);
				match.setIntTime(Integer.parseInt(intTime));
				match.setMatchTime(matchTime);
				if(MATCH_MAP_GAMENAME.get(gameName) != null) {
					gameName = MATCH_MAP_GAMENAME.get(gameName);
				}
				match.setGameColor("#"+color);
				match.setGameName(gameName);
				match.setHomeTeam(homeTeam);
				match.setGuestTeam(guestTeam);
				match.setHandicap(Double.valueOf(rf));
				match.setBaseBigOrSmall(Double.valueOf(yszf));
				//0:在售1:截止2:取消
				if("Selling".equals(status)) {
					match.setStatus(0);
				} else {
					match.setStatus(2);
				}
				
				int show=0;
				for (MatchShowStatus fb : statusList) {
					show |= 1 << fb.getValue();
				}
				match.setShowNum(show);
				matchList.add(match);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return matchList;
		
//		List<BasketBallMatch> matchList = new ArrayList<BasketBallMatch>();
//		Parser parser = Parser.createParser(html, "GBK");
//		try {
//			NodeList tableNodeList = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("table[class='tbl']"));
//			NodeList trNodeList = tableNodeList.elementAt(0).getChildren();
//			SimpleNodeIterator trNodeIterator = trNodeList.elements();
//			while (trNodeIterator.hasMoreNodes()) {
//				String weekStr = null, gameName = null, guestTeam = null, homeTeam = null, matchTime = null, excludePlayType = null;
//				Integer lineId = null;
//				Node trNode = trNodeIterator.nextNode();
//				NodeList tdNodeList = trNode.getChildren();
//				try {
//					if (tdNodeList == null)
//						continue;
//					if (!"已开售".equals(tdNodeList.elementAt(4).toPlainTextString().trim()))
//						continue;
//					String numberStr = tdNodeList.elementAt(0).toPlainTextString().trim();
//					gameName = tdNodeList.elementAt(1).toPlainTextString().trim();
//					String termName = tdNodeList.elementAt(2).toPlainTextString().trim();
//					matchTime = tdNodeList.elementAt(3).toPlainTextString().trim();
//					weekStr = numberStr.substring(0, 2);
//					lineId = Integer.parseInt(numberStr.substring(2));
//					gameName = tdNodeList.elementAt(1).toPlainTextString().trim();
//					guestTeam = termName.split("VS")[0].trim();
//					homeTeam = termName.split("VS")[1].trim();
//
//				} catch (Exception e) {
//					continue;
//				}
//				excludePlayType = tdNodeList.elementAt(5).toPlainTextString().trim();
//				BasketBallMatch match = new BasketBallMatch();
//				match.setLineId(lineId);
//				match.setWeekStr(weekStr);
//				Date matchDate = DateTools.StringToDate(matchTime, "yy-MM-dd hh:mm");
//				matchDate = DateUtil.getDateFormat(matchDate);
//				match.setIntTime(DateTools.handleIntTime(matchDate, weekStr));
//				match.setMatchTime(matchDate);
//				match.setGameName(gameName);
//				match.setGuestTeam(guestTeam);
//				match.setHomeTeam(homeTeam);
//
//				List<String> showStatus = new ArrayList<String>();
//				List<MatchShowStatus> statusList = MatchShowStatus.fuzzySearchStatus(excludePlayType, true);
//				int a = 0;
//				for (MatchShowStatus matchShowStatus : statusList) {
//					a |= (1 << matchShowStatus.getValue());
//					showStatus.add(matchShowStatus.getPptext());
//				}
//				match.setShowStatus(showStatus);
//				match.setShowNum(a);
//				matchList.add(match);
//			}
//		} catch (ParserException e) {
//			LogUtil.error(e);
//		}
//		return matchList;
	}

	/*
	 * 获得分页值
	 */
	public Integer getResultPage(String html) {
		Integer paging = 1;
		Parser parser = Parser.createParser(html, "GBK");
		try {
			NodeList nodeList = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("table"));
			if (null != nodeList && nodeList.size() > 0) {
				String opStr = nodeList.elementAt(1).toHtml();
				Parser parser2 = Parser.createParser(opStr, "GBK");
				NodeList arrangeList = parser2.extractAllNodesThatMatch(new TagNameFilter("tr"));

				String arrangeStr = arrangeList.elementAt(0).toHtml();
				Parser parser3 = Parser.createParser(arrangeStr, "GBK");
				NodeList arrangeList2 = parser3.extractAllNodesThatMatch(new TagNameFilter("td"));
				String pageStr = arrangeList2.elementAt(0).toPlainTextString().trim();
				if (!"".equals(pageStr)) {
					paging = Integer.parseInt(StringTools.getNumfromStr(pageStr));
					int pageNum = paging / 50;
					if (paging % 50 != 0 && pageNum != 0) {
						pageNum += 1;
					} else if (paging % 50 == 0 && pageNum != 0) {
						pageNum = paging / 50;
					} else {
						pageNum = 1;
					}
					paging = pageNum;
				}
			}
		} catch (ParserException e) {
			LogUtil.error(e);
		}
		return paging;
	}

	/*
	 * 获取比赛结果
	 */
	public List<BasketBallMatch> getMatchResultList(String html) {
		List<BasketBallMatch> list = new ArrayList<BasketBallMatch>();
		Parser parser=Parser.createParser(html, "GBK");
		NodeFilter trFilter1=new HasAttributeFilter("class","ni");
		NodeFilter trFilter2=new HasAttributeFilter("class","ni2");
		NodeFilter trFilter=new OrFilter(trFilter1,trFilter2);
		NodeFilter tdFilter=new NodeClassFilter(TableColumn.class);
		try {
			NodeList trNodeList=parser.extractAllNodesThatMatch(trFilter);
			SimpleNodeIterator trNodeIterator = trNodeList.elements();
			
			NodeList tdNodeList=null;
			Node tdNode=null;
			String lineId="";
			Integer homeScore;
			Integer guestScore;
			String matchKey="";
			while (trNodeIterator.hasMoreNodes()) {
				tdNodeList=trNodeIterator.nextNode().getChildren().extractAllNodesThatMatch(tdFilter);
				tdNode=tdNodeList.elementAt(0);
				matchKey=tdNode.toPlainTextString().trim();
				lineId=matchKey.substring(matchKey.length()-3);
				String week=matchKey.substring(0,2);
				
				//比赛日期
				tdNode=tdNodeList.elementAt(2);
				String matchDateText=tdNode.toPlainTextString().trim().trim();
				String[] dateNumbers=matchDateText.split("\\D");
				matchDateText=dateNumbers[0]+"-"+dateNumbers[1]+" "+dateNumbers[2]+":"+dateNumbers[3];
				Date matchDate=DateTools.strToDateDafueYear(matchDateText);
				Integer intTime=DateTools.handleIntTime(matchDate, week);
				String wholeScore=tdNodeList.elementAt(4).toPlainTextString().trim();
				if(wholeScore.equals("")||wholeScore.equals("-")||wholeScore.equals(":")||"取消".equals(wholeScore)||"推迟".equals(wholeScore)||"待定".equals(wholeScore)){
					continue;
				}
				String[] tmpSocre=wholeScore.split("\\-");
				homeScore=Integer.parseInt(tmpSocre[0]);
				guestScore=Integer.parseInt(tmpSocre[1]);
				BasketBallMatch match=new BasketBallMatch();
				match.setMatchTime(matchDate);
				match.setIntTime(intTime);
				match.setLineId(Integer.parseInt(lineId));
				match.setHomeScore(homeScore);
				match.setGuestScore(guestScore);
				list.add(match);
			}
			
		} catch (ParserException e) {
			LogUtil.error(e);;
		}
		return list;
	}

	/*
	 * 获得单关奖金值
	 */
	public BasketBallMatch getSingleAward(String html) {
		String awardHtml = HttpUtil.getUrl(html);
		BasketBallMatch match = new BasketBallMatch();
		if (awardHtml != null) {
			Parser parser = Parser.createParser(awardHtml, "GBK");
			try {
				NodeList nodeList = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("table[class='pop_date']"));
				if (null != nodeList && nodeList.size() > 0) {
					String opStr = nodeList.elementAt(0).toHtml();
					Parser parser2 = Parser.createParser(opStr, "GBK");
					NodeList arrangeList = parser2.extractAllNodesThatMatch(new TagNameFilter("tr"));
					for (int i = 2; i < arrangeList.size(); i++) {

						String arrangeStr = arrangeList.elementAt(i).toHtml();
						Parser parser3 = Parser.createParser(arrangeStr, "GBK");
						NodeList arrangeList2 = parser3.extractAllNodesThatMatch(new TagNameFilter("td"));
						String sfStr = arrangeList2.elementAt(0).toPlainTextString().trim();
						if (arrangeList2.size() >= 4 && "胜负".equals(sfStr)) {
							String resultOfSF = arrangeList2.elementAt(3).toPlainTextString().trim();
							if (!"".equals(resultOfSF)) {
								match.setResultOfSF(NumberTools.String2Double(resultOfSF, 0d));
							}
						} else if (arrangeList2.size() >= 4 && "让分胜负".equals(sfStr)) {
							/*
							 * String handStr =
							 * arrangeList2.elementAt(1).toPlainTextString().trim();
							 * if (!"".equals(handStr)) {
							 * match.setHandicap(NumberTools.String2Double(handStr,
							 * 0d)); }
							 */
							String resultOfRFSF = arrangeList2.elementAt(3).toPlainTextString().trim();
							if (!"".equals(resultOfRFSF)) {
								match.setResultOfRFSF(NumberTools.String2Double(resultOfRFSF, 0d));
							}
						} else if (arrangeList2.size() >= 4 && "胜分差".equals(sfStr)) {
							String resultOfSFC = arrangeList2.elementAt(3).toPlainTextString().trim();
							if (!"".equals(resultOfSFC)) {
								match.setResultOfSFC(NumberTools.String2Double(resultOfSFC, 0d));
							}
						} else if (arrangeList2.size() >= 4 && "大小分".equals(sfStr)) {
							/*
							 * String baseStr =
							 * arrangeList2.elementAt(1).toPlainTextString().trim();
							 * if (!"".equals(baseStr)) {
							 * match.setBaseBigOrSmall(NumberTools.String2Double(baseStr,
							 * 0d)); }
							 */
							String resultOfDXF = arrangeList2.elementAt(3).toPlainTextString().trim();
							if (!"".equals(resultOfDXF)) {
								match.setResultOfDXF(NumberTools.String2Double(resultOfDXF, 0d));
							}
						} else if (sfStr.indexOf("让分") != -1 && match.getHandicap() == null) {
							String handStr = arrangeList2.elementAt(0).toPlainTextString().trim();
							if (!"".equals(handStr)) {
								String tempStr = StringTools.getFloatfromStr(handStr);
								handStr = handStr.replace(tempStr, "");
								match.setHandicap(NumberTools.String2Double(handStr, 0d));
							}
						} else if ((sfStr.indexOf("大") != -1 || sfStr.indexOf("小") != -1) && match.getBaseBigOrSmall() == null) {
							String baseStr = arrangeList2.elementAt(0).toPlainTextString().trim();
							if (!"".equals(baseStr)) {
								String tempStr = StringTools.getFloatfromStr(baseStr);
								baseStr = baseStr.replace(tempStr, "");
								match.setBaseBigOrSmall(NumberTools.String2Double(baseStr, 0d));
							}
						}

					}

				}
			} catch (ParserException e) {
				LogUtil.error(e);;
			}
		}

		return match;
	}

	// 获得让分胜负基数
	public List<BasketBallMatch> getRFofSingle(String html) {
		List<BasketBallMatch> matchList = new ArrayList<BasketBallMatch>();

		Parser parser = Parser.createParser(html, "GBK");

		try {
			NodeList nodeList = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("table[class='tbl']"));
			if (null != nodeList && nodeList.size() > 0) {
				String opStr = nodeList.elementAt(0).toHtml();
				Parser parser2 = Parser.createParser(opStr, "GBK");
				NodeList arrangeList = parser2.extractAllNodesThatMatch(new TagNameFilter("tr"));
				for (int i = 1; i < arrangeList.size(); i++) {
					String arrangeStr = arrangeList.elementAt(i).toHtml();
					Parser parser3 = Parser.createParser(arrangeStr, "GBK");
					NodeList arrangeList2 = parser3.extractAllNodesThatMatch(new TagNameFilter("td"));
					String numberStr = arrangeList2.elementAt(0).toPlainTextString().trim();
					String weekStr = numberStr.substring(0, 2);
					Integer lineId = Integer.parseInt(numberStr.substring(2));
					String matchTime = arrangeList2.elementAt(3).toPlainTextString().trim();
					Date mTime = DateTools.StringToDate_YY_MM_DD_HH_MM(matchTime);
					mTime = DateUtil.getDateFormat(mTime);
					Integer intTime = DateTools.handleIntTime(mTime, weekStr);
					String rf = arrangeList2.elementAt(2).toPlainTextString().trim();
					if (rf.indexOf("(") != -1) {
						rf = rf.substring(rf.indexOf("(") + 1, rf.indexOf(")"));
					}
					Double handicap = null;
					if (!"".equals(rf)) {
						handicap = Double.parseDouble(rf);
					}

					BasketBallMatch match = new BasketBallMatch();
					match.setLineId(lineId);
					match.setIntTime(intTime);
					match.setSingle_handicap(handicap);
					matchList.add(match);
				}
			}
		} catch (ParserException e) {
			LogUtil.error(e);;
		}
		return matchList;
	}

	public List<BasketBallMatch> getRFofPass(String html) {
		List<BasketBallMatch> matchList = new ArrayList<BasketBallMatch>();
		Parser parser = Parser.createParser(html, "GBK");

		try {
			NodeList nodeList = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("table[class='tbl']"));
			if (null != nodeList && nodeList.size() > 0) {
				String opStr = nodeList.elementAt(1).toHtml();
				Parser parser2 = Parser.createParser(opStr, "GBK");
				NodeList arrangeList = parser2.extractAllNodesThatMatch(new TagNameFilter("tr"));
				for (int i = 1; i < arrangeList.size(); i++) {
					String arrangeStr = arrangeList.elementAt(i).toHtml();
					Parser parser3 = Parser.createParser(arrangeStr, "GBK");
					NodeList arrangeList2 = parser3.extractAllNodesThatMatch(new TagNameFilter("td"));
					String numberStr = arrangeList2.elementAt(0).toPlainTextString().trim();
					String weekStr = numberStr.substring(0, 2);
					Integer lineId = Integer.parseInt(numberStr.substring(2));
					String matchTime = arrangeList2.elementAt(3).toPlainTextString().trim();
					Date mTime = DateTools.StringToDate_YY_MM_DD_HH_MM(matchTime);
					mTime = DateUtil.getDateFormat(mTime);
					Integer intTime = DateTools.handleIntTime(mTime, weekStr);
					String rf = arrangeList2.elementAt(2).toPlainTextString().trim();
					if (rf.indexOf("(") != -1) {
						rf = rf.substring(rf.indexOf("(") + 1, rf.indexOf(")"));
					}
					Double handicap = null;
					if (!"".equals(rf)) {
						handicap = Double.parseDouble(rf);
					}

					BasketBallMatch match = new BasketBallMatch();
					match.setLineId(lineId);
					match.setIntTime(intTime);
					match.setHandicap(handicap);
					matchList.add(match);
				}
			}
		} catch (ParserException e) {
			LogUtil.error(e);;
		}
		return matchList;
	}

	// 获得大小基数
	public List<BasketBallMatch> getDXbaseofSingle(String html) {
		List<BasketBallMatch> matchList = new ArrayList<BasketBallMatch>();
		Parser parser = Parser.createParser(html, "GBK");

		try {
			NodeList nodeList = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("table[class='tbl']"));
			if (null != nodeList && nodeList.size() > 0) {
				String opStr = nodeList.elementAt(0).toHtml();
				Parser parser2 = Parser.createParser(opStr, "GBK");
				NodeList arrangeList = parser2.extractAllNodesThatMatch(new TagNameFilter("tr"));
				for (int i = 1; i < arrangeList.size(); i++) {
					String arrangeStr = arrangeList.elementAt(i).toHtml();
					Parser parser3 = Parser.createParser(arrangeStr, "GBK");
					NodeList arrangeList2 = parser3.extractAllNodesThatMatch(new TagNameFilter("td"));
					String numberStr = arrangeList2.elementAt(0).toPlainTextString().trim();
					String weekStr = numberStr.substring(0, 2);
					Integer lineId = Integer.parseInt(numberStr.substring(2));
					String matchTime = arrangeList2.elementAt(3).toPlainTextString().trim();
					Date mTime = DateTools.StringToDate_YY_MM_DD_HH_MM(matchTime);
					mTime = DateUtil.getDateFormat(mTime);
					Integer intTime = DateTools.handleIntTime(mTime, weekStr);
					String dxsingleMode = arrangeList2.elementAt(4).toPlainTextString().trim();
					Double baseBigOrSmall = Double.parseDouble(dxsingleMode);

					BasketBallMatch match = new BasketBallMatch();
					match.setLineId(lineId);
					match.setIntTime(intTime);
					match.setSingle_baseBigOrSmall(baseBigOrSmall);
					matchList.add(match);
				}
			}
		} catch (ParserException e) {
			LogUtil.error(e);;
		}
		return matchList;
	}

	public List<BasketBallMatch> getDXbaseofPass(String html) {
		List<BasketBallMatch> matchList = new ArrayList<BasketBallMatch>();
		Parser parser = Parser.createParser(html, "GBK");

		try {
			NodeList nodeList = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("table[class='tbl']"));
			if (null != nodeList && nodeList.size() > 0) {
				String opStr = nodeList.elementAt(1).toHtml();
				Parser parser2 = Parser.createParser(opStr, "GBK");
				NodeList arrangeList = parser2.extractAllNodesThatMatch(new TagNameFilter("tr"));
				for (int i = 1; i < arrangeList.size(); i++) {
					String arrangeStr = arrangeList.elementAt(i).toHtml();
					Parser parser3 = Parser.createParser(arrangeStr, "GBK");
					NodeList arrangeList2 = parser3.extractAllNodesThatMatch(new TagNameFilter("td"));
					String numberStr = arrangeList2.elementAt(0).toPlainTextString().trim();
					String weekStr = numberStr.substring(0, 2);
					Integer lineId = Integer.parseInt(numberStr.substring(2));
					String matchTime = arrangeList2.elementAt(3).toPlainTextString().trim();
					Date mTime = DateTools.StringToDate_YY_MM_DD_HH_MM(matchTime);
					mTime = DateUtil.getDateFormat(mTime);
					Integer intTime = DateTools.handleIntTime(mTime, weekStr);
					String dxpassMode = arrangeList2.elementAt(2).toPlainTextString().trim();
					Double baseBigOrSmall = null;
					if (dxpassMode.indexOf(".") != -1) {
						if (dxpassMode.length() > 6) {
							dxpassMode = dxpassMode.substring(dxpassMode.length() - 6, dxpassMode.length());
						}
						baseBigOrSmall = Double.parseDouble(StringTools.getNumfromStr(dxpassMode));
					}

					BasketBallMatch match = new BasketBallMatch();
					match.setLineId(lineId);
					match.setIntTime(intTime);
					match.setBaseBigOrSmall(baseBigOrSmall);
					matchList.add(match);
				}
			}
		} catch (ParserException e) {
			LogUtil.error(e);;
		}
		return matchList;
	}
	public List<BasketBallMatch> getSingleResultAward(String html) {
		List<BasketBallMatch> resultList = new ArrayList<BasketBallMatch>();
		Parser parser = Parser.createParser(html, "GBK");
		try {
			NodeFilter trFilter1=new HasAttributeFilter("class","ni");
			NodeFilter trFilter2=new HasAttributeFilter("class","ni2");
			NodeFilter trFilter=new OrFilter(trFilter1,trFilter2);
			NodeFilter tdFilter=new NodeClassFilter(TableColumn.class);
			NodeFilter linkFilter=new NodeClassFilter(LinkTag.class);
			NodeList matchRowList=parser.extractAllNodesThatMatch(trFilter);
			SimpleNodeIterator iterator= matchRowList.elements();
			while(iterator.hasMoreNodes()){
				NodeList matchCellList=iterator.nextNode().getChildren().extractAllNodesThatMatch(tdFilter);
				BasketBallMatch match=new BasketBallMatch();
				String matchKey=matchCellList.elementAt(0).toPlainTextString().trim();
				String week=matchKey.substring(0,2);
				String matchDateText=matchCellList.elementAt(2).toPlainTextString().trim();
				String[] dateNumbers=matchDateText.split("\\D");
				matchDateText=dateNumbers[0]+"-"+dateNumbers[1]+" "+dateNumbers[2]+":"+dateNumbers[3];
				Date matchDate=DateTools.strToDateDafueYear(matchDateText);
				Integer intTime=DateTools.handleIntTime(matchDate, week);
				match.setIntTime(intTime);
				match.setLineId(Integer.valueOf(matchKey.substring(2)));
				//SF
				NodeList singleNodeList=matchCellList.elementAt(6).getChildren().extractAllNodesThatMatch(linkFilter);
				if(singleNodeList.size()!=0){
					String sfAward=singleNodeList.elementAt(0).toPlainTextString().trim();
					if(NumberTools.isNum(sfAward)){
						match.setResultOfSF(Double.valueOf(sfAward));
					}
				}
				//RFSF
				String rfBase=matchCellList.elementAt(7).toPlainTextString();
				if(NumberTools.isNum(rfBase)){
					match.setSingle_handicap(Double.valueOf(rfBase));
				}
				//RFSF
				singleNodeList=matchCellList.elementAt(8).getChildren().extractAllNodesThatMatch(linkFilter);
				if(singleNodeList.size()!=0){
					String rfsfAward=singleNodeList.elementAt(0).toPlainTextString().trim();
					if(NumberTools.isNum(rfsfAward)){
						match.setResultOfRFSF(Double.valueOf(rfsfAward));
					}
				}
				//SFC
				singleNodeList=matchCellList.elementAt(9).getChildren().extractAllNodesThatMatch(linkFilter);
				if(singleNodeList.size()!=0){
					String sfcAward=singleNodeList.elementAt(0).toPlainTextString().trim();
					if(NumberTools.isNum(sfcAward)){
						match.setResultOfSFC(Double.valueOf(sfcAward));
					}
				}
				
				//DXF
				String dxfBase=matchCellList.elementAt(10).toPlainTextString().trim();
				if(NumberTools.isNum(dxfBase)){
					match.setSingle_baseBigOrSmall(Double.valueOf(dxfBase));
				}
				singleNodeList=matchCellList.elementAt(11).getChildren().extractAllNodesThatMatch(linkFilter);
				if(singleNodeList.size()!=0){
					String dxfAward=singleNodeList.elementAt(0).toPlainTextString().trim();
					if(NumberTools.isNum(dxfAward)){
						match.setResultOfDXF(Double.valueOf(dxfAward));
					}
				}
				resultList.add(match);
			}
			return resultList;
		}catch (Exception e) {
			LogUtil.error(e);;
		}
		return null;
	}
	// 获得赔率信息
	public static Map<String, String> getInfoJSON(String html) {
		Map<String, String> matchInfoMap = new HashMap<String, String>();
		Parser parser = Parser.createParser(html, "GBK");

		try {
			NodeList nodeList = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("div[class='jc_tablebox']"));
			if (null != nodeList && nodeList.size() > 0) {
				String opStr = nodeList.elementAt(0).toHtml();
				Parser parser2 = Parser.createParser(opStr, "GBK");
				NodeList arrangeList = parser2.extractAllNodesThatMatch(new TagNameFilter("tr"));
				if (arrangeList.size() > 2) {
					for (int i = 2; i < arrangeList.size(); i++) {
						String arrangeStr = arrangeList.elementAt(i).toHtml();
						Parser parser3 = Parser.createParser(arrangeStr, "GBK");
						NodeList arrangeList2 = parser3.extractAllNodesThatMatch(new TagNameFilter("td"));
						if (arrangeList2.size() > 0 && arrangeList2 != null) {
							// String intTime =
							// ((TableColumn)arrangeList2.elementAt(1)).getAttribute("id");
							// intTime = intTime.split("_")[3].replace("-",
							// "_");
							String weekId = arrangeList2.elementAt(1).toPlainTextString().trim();
							String scoreHref = "";
							String opHref = "";
							String yaHref = "";
							String xiHref = ((LinkTag) arrangeList2.elementAt(5).getChildren().elementAt(1)).getAttribute("href");
							if (xiHref.length() < 36) {
								scoreHref = "javascript:void(0)";
								opHref = "javascript:void(0)";
								yaHref = "javascript:void(0)";
							} else {
								String hrefId = xiHref.split("\\?")[1].split("\\&")[0];
								scoreHref = "http://nba.win007.com/odds/OverDown_n.asp?ID=" + hrefId;
								opHref = "http://nba.win007.com/1x2/oddslist/" + hrefId + ".htm";
								yaHref = "http://nba.win007.com/odds/AsianOdds_n.asp?id=" + hrefId;
							}
							String op = arrangeList2.elementAt(7).toPlainTextString().trim();
							int firPoint = op.indexOf(".");
							int secPoint = op.indexOf(".", 3);
							String hostOP = "-";
							String guestOP = "-";
							if (firPoint != -1 && secPoint != -1) {
								if (secPoint - firPoint == 3 || secPoint - firPoint == 4) {
									guestOP = op.substring(0, firPoint + 3);
									hostOP = op.substring(firPoint + 3);
								}
								if (secPoint - firPoint == 2) {
									guestOP = op.substring(0, firPoint + 2);
									hostOP = op.substring(firPoint + 2);
								}
							}
							if (!"".equals(yaHref) && !"javascript:void(0)".equals(yaHref)) {
								String[] yps = MatchList.getYpOrBspArr(yaHref, 4);
								matchInfoMap.put(weekId + "_yh", yps[0]);
								matchInfoMap.put(weekId + "_yp", yps[1]);
								matchInfoMap.put(weekId + "_yg", yps[2]);
							}
							if (!"".equals(scoreHref) && !"javascript:void(0)".equals(yaHref)) {
								String[] bss = MatchList.getYpOrBspArr(scoreHref, 4);
								matchInfoMap.put(weekId + "_sb", bss[0]);
								matchInfoMap.put(weekId + "_sp", bss[1]);
								matchInfoMap.put(weekId + "_ss", bss[2]);
							}
							matchInfoMap.put(weekId + "_xi", xiHref);
							matchInfoMap.put(weekId + "_ts", scoreHref);
							matchInfoMap.put(weekId + "_op", opHref);
							matchInfoMap.put(weekId + "_ya", yaHref);
							matchInfoMap.put(weekId + "_ho", hostOP);
							matchInfoMap.put(weekId + "_go", guestOP);
						}
					}
				}
			}
		} catch (ParserException e) {
			LogUtil.error(e);;
		}
		return matchInfoMap;

	}

	// 获得外部数据连接ID
	public static Map<String, String> getOutId(String html) {
		Map<String, String> outIdMap = new HashMap<String, String>();
		Parser parser = Parser.createParser(html, "GBK");

		try {
			NodeList nodeList = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("div[class='jc_tablebox']"));
			if (null != nodeList && nodeList.size() > 0) {
				String opStr = nodeList.elementAt(0).toHtml();
				Parser parser2 = Parser.createParser(opStr, "GBK");
				NodeList arrangeList = parser2.extractAllNodesThatMatch(new TagNameFilter("tr"));
				if (arrangeList.size() > 2) {
					for (int i = 2; i < arrangeList.size(); i++) {
						String arrangeStr = arrangeList.elementAt(i).toHtml();
						Parser parser3 = Parser.createParser(arrangeStr, "GBK");
						NodeList arrangeList2 = parser3.extractAllNodesThatMatch(new TagNameFilter("td"));
						if (arrangeList2.size() > 1 && arrangeList2 != null) {
							String intTime = ((TableColumn) arrangeList2.elementAt(1)).getAttribute("id");
							if (intTime.split("_").length != 4)
								continue;
							intTime = "20" + intTime.split("_")[3].replace("-", "_");
							String xiHref = ((LinkTag) arrangeList2.elementAt(5).getLastChild()).getAttribute("href");
							String hrefId = null;
							if (xiHref.length() > 36) {
								hrefId = xiHref.substring(31, 36);
							}
							outIdMap.put(intTime, hrefId);
						}
					}
				}
			}
		} catch (ParserException e) {
			LogUtil.error(e);;
		}
		return outIdMap;

	}
	public static List<BasketballYp> snatchBasketBallAsiaOdds(String url){
		List<BasketballYp> ypList=new ArrayList<BasketballYp>();
		try {
			String plHtml = HttpUtil.getUrl(url);
			if (plHtml != null) {
				Parser parser = Parser.createParser(plHtml, "gb2312");
				NodeList nl = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("table[class='font13']"));
				NodeList trNL = nl.elementAt(0).getChildren().extractAllNodesThatMatch(new TagNameFilter("tr"));
				for(int i=2;i<trNL.size();i++){
					NodeList tdList=trNL.elementAt(i).getChildren().extractAllNodesThatMatch(new TagNameFilter("td"));
					String company=tdList.elementAt(0).toPlainTextString().trim();
					BasketballYp yp=new BasketballYp();
					yp.setIsFirst(1);
					yp.setCompany(company);
					/*******************主胜初盘指数********************************/
					String winFirstOdds=tdList.elementAt(1).toPlainTextString();
					if(!NumberTools.isNum(winFirstOdds)){
						continue;
					}
					yp.setHome(Double.valueOf(winFirstOdds));
					/*******************盘口初盘指数**************************/
					String drawFirstOdds=tdList.elementAt(2).toPlainTextString();
					if(!NumberTools.isNum(drawFirstOdds)){
						continue;
					}
					yp.setPankou(Double.valueOf(drawFirstOdds));
					/*******************客胜初盘指数**************************/
					String loseFirstOdds=tdList.elementAt(3).toPlainTextString();
					if(!NumberTools.isNum(loseFirstOdds)){
						continue;
					}
					yp.setGuest(Double.valueOf(loseFirstOdds));
					ypList.add(yp);
					
					
					BasketballYp nowYp=new BasketballYp();
					nowYp.setIsFirst(0);
					nowYp.setCompany(company);
					/*******************主胜即时盘指数**************************/
					String winNowOdds=tdList.elementAt(4).toPlainTextString();
					if(!NumberTools.isNum(winNowOdds)){
						continue;
					}
					nowYp.setHome(Double.valueOf(winNowOdds));
					/*******************盘口即时盘指数**************************/
					String drawNowOdds=tdList.elementAt(5).toPlainTextString();
					if(!NumberTools.isNum(drawNowOdds)){
						continue;
					}
					nowYp.setPankou(Double.valueOf(drawNowOdds));
					/*******************客胜即时盘指数**************************/
					String loseNowOdds=tdList.elementAt(6).toPlainTextString();
					if(!NumberTools.isNum(loseNowOdds)){
						continue;
					}
					nowYp.setGuest(Double.valueOf(loseNowOdds));
					
					String timeText=tdList.elementAt(7).toPlainTextString();
					timeText=timeText.trim().replace("&nbsp;","");
					if(!StringTools.isNullOrBlank(timeText)){
						nowYp.setTime(DateTools.StringToDate(timeText,"yyyy-MM-dd HH:mm"));
					}
					ypList.add(nowYp);
				}
			}
		}catch (Exception e) {
			LogUtil.error(e);;
		}
		return ypList;
	}
	public static List<BasketballDxp> snatchBigSmallOdds(String url){
		List<BasketballDxp> dxpList=new ArrayList<BasketballDxp>();
		try {
			String plHtml = HttpUtil.getUrl(url);
			if (plHtml != null) {
				Parser parser = Parser.createParser(plHtml, "gb2312");
				NodeList nl = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("table[class='font13']"));
				NodeList trNL = nl.elementAt(0).getChildren().extractAllNodesThatMatch(new TagNameFilter("tr"));
				for(int i=2;i<trNL.size();i++){
					NodeList tdList=trNL.elementAt(i).getChildren().extractAllNodesThatMatch(new TagNameFilter("td"));
					String company=tdList.elementAt(0).toPlainTextString().trim();
					BasketballDxp dxp=new BasketballDxp();
					dxp.setIsFirst(1);
					dxp.setCompany(company);
					/*******************大球初盘指数********************************/
					String bigFirstOdds=tdList.elementAt(1).toPlainTextString();
					if(!NumberTools.isNum(bigFirstOdds)){
						continue;
					}
					dxp.setBig(Double.valueOf(bigFirstOdds));
					/*******************盘口初盘指数**************************/
					String panKouFirstOdds=tdList.elementAt(2).toPlainTextString();
					if(!NumberTools.isNum(panKouFirstOdds)){
						continue;
					}
					dxp.setPankou(Double.valueOf(panKouFirstOdds));
					/*******************小球初盘指数**************************/
					String smallFirstOdds=tdList.elementAt(3).toPlainTextString();
					if(!NumberTools.isNum(smallFirstOdds)){
						continue;
					}
					dxp.setSmall(Double.valueOf(smallFirstOdds));
					dxpList.add(dxp);
					
					
					BasketballDxp nowDxp=new BasketballDxp();
					nowDxp.setIsFirst(0);
					nowDxp.setCompany(company);
					/*******************大球即时盘指数**************************/
					String bigNowOdds=tdList.elementAt(4).toPlainTextString();
					if(!NumberTools.isNum(bigNowOdds)){
						continue;
					}
					nowDxp.setBig(Double.valueOf(bigNowOdds));
					/*******************盘口即时盘指数**************************/
					String panKouNowOdds=tdList.elementAt(5).toPlainTextString();
					if(!NumberTools.isNum(panKouNowOdds)){
						continue;
					}
					nowDxp.setPankou(Double.valueOf(panKouNowOdds));
					/*******************小球即时盘指数**************************/
					String smallNowOdds=tdList.elementAt(6).toPlainTextString();
					if(!NumberTools.isNum(smallNowOdds)){
						continue;
					}
					nowDxp.setSmall(Double.valueOf(smallNowOdds));
					
					String timeText=tdList.elementAt(7).toPlainTextString();
					timeText=timeText.trim().replace("&nbsp;","");
					if(!StringTools.isNullOrBlank(timeText)){
						nowDxp.setTime(DateTools.StringToDate(timeText,"yyyy-MM-dd HH:mm"));
					}
					dxpList.add(nowDxp);
				}
			}
		}catch (Exception e) {
			LogUtil.error(e);;
		}
		return dxpList;
	}
	/*
	 * 获取亚盘指数或大小球指数
	 */
	public static String[] getYpOrBspArr(String html, int index) {
		String tempArr[] = new String[3];
		String[] company = { "皇冠", "韦德", "易胜博", "澳门" };

		try {
			String plHtml = HttpUtil.getUrl(html);
			if (plHtml != null) {
				Parser parser = Parser.createParser(plHtml, "gb2312");
				NodeList nl = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("table[class='font13']"));
				String trStr = nl.elementAt(0).toHtml();
				Parser parser2 = Parser.createParser(trStr, "gb2312");
				NodeList trNL = parser2.extractAllNodesThatMatch(new TagNameFilter("tr"));
				if ("".equals(trNL.elementAt(1)) || trNL.elementAt(1) == null) {
					tempArr[0] = "-";
					tempArr[1] = "-";
					tempArr[2] = "-";
				} else {
					for (int j = 0; j < company.length; j++) {
						for (int i = 2; i < trNL.size(); i++) {
							String tdStr = trNL.elementAt(i).toHtml();
							Parser parser3 = Parser.createParser(tdStr, "gb2312");
							NodeList tdNL = parser3.extractAllNodesThatMatch(new TagNameFilter("td"));
							String companyName = tdNL.elementAt(0).toPlainTextString().trim();
							String tempStr = tdNL.elementAt(index).toPlainTextString().trim();
							if (company[j].equals(companyName) && !"".equals(tempStr)) {
								String hob = tdNL.elementAt(index).toPlainTextString().trim();
								String pk = tdNL.elementAt(index + 1).toPlainTextString().trim();
								String gos = tdNL.elementAt(index + 2).toPlainTextString().trim();
								tempArr[0] = hob;
								tempArr[1] = pk;
								tempArr[2] = gos;
								break;
							}
						}
						if (tempArr[0] != null)
							break;
					}
					if (tempArr[0] == null) {
						tempArr[0] = "-";
						tempArr[1] = "-";
						tempArr[2] = "-";
					}
				}
			} else {
				tempArr[0] = "-";
				tempArr[1] = "-";
				tempArr[2] = "-";
			}
		} catch (Exception e) {
			LogUtil.error(e);;
		}

		return tempArr;
	}
	
	public static List<BasketballOp> snatchEuropeOdds(String url){
		List<BasketballOp> opList=new ArrayList<BasketballOp>();
		try {
			String plHtml = HttpUtil.getUrl(url,"utf-8");
			if (plHtml != null) {
				Parser parser = Parser.createParser(plHtml, "utf-8");
				NodeFilter arrFilter=new StringFilter("game=Array(");
				NodeList nodes = parser.extractAllNodesThatMatch(arrFilter);
				String[] scriptDatas= nodes.elementAt(0).toPlainTextString().split("\n");
				String dataText=scriptDatas[scriptDatas.length-1].split("Array\\(")[1].split("\\);")[0];
				String[] datas=dataText.split("\",");
				for(String temp:datas){
					String[] temps=temp.split("\\|");
					String company=temps[16];
					//初盘下标
					BasketballOp firstOp=new BasketballOp();
					firstOp.setCompany(company);
					firstOp.setIsFirst(1);
					/***************主胜初盘指数************************/
					String winFirstOdds=temps[3];
					if(!NumberTools.isNum(winFirstOdds)){
						continue;
					}
					firstOp.setHome(Double.valueOf(winFirstOdds));
					/***************客胜初盘指数************************/
					String loseFirstOdds=temps[4];
					if(!NumberTools.isNum(loseFirstOdds)){
						continue;
					}
					firstOp.setGuest(Double.valueOf(loseFirstOdds));
					opList.add(firstOp);
					
					BasketballOp nowOp=new BasketballOp();
					nowOp.setCompany(company);
					nowOp.setIsFirst(0);
					/***************主胜即时盘指数************************/
					String winOdds=temps[8];
					if(!NumberTools.isNum(winOdds)){
						continue;
					}
					nowOp.setHome(Double.valueOf(winOdds));
					/***************客胜即时盘指数************************/
					String loseOdds=temps[9];
					if(!NumberTools.isNum(loseOdds)){
						continue;
					}
					nowOp.setGuest(Double.valueOf(loseOdds));		
					opList.add(nowOp);
				}
			}
		}catch (Exception e) {
			LogUtil.error(e);;
		}
		return opList;
	}
	/*
	 * 获取欧盘指数
	 */
	public static String[] getOpArr(String html, int index) {
		String tempArr[] = new String[]{"-","-"};
		String[] company = { "即时盘平均值", "初盘平均值" };
		int dataIndex=3;
		if(index==0){
			//抓取即时盘
			dataIndex+=5;
		}
		try {
			String plHtml = HttpUtil.getUrl(html);
			if (plHtml != null) {
				Parser parser = Parser.createParser(plHtml, "gb2312");
				NodeFilter arrFilter=new StringFilter("game=Array(");
				NodeList nodes = parser.extractAllNodesThatMatch(arrFilter);
				String[] scriptDatas= nodes.elementAt(0).toPlainTextString().split("\n");
				String dataText=scriptDatas[scriptDatas.length-1].split("Array\\(")[1].split("\\);")[0];
				String[] datas=dataText.split("\",");
				Double sum1=0d;
				Double sum2=0d;
				int count=0;
				for(String temp:datas){
					String[] temps=temp.split("\\|");
					if(NumberTools.isNum(temps[dataIndex])){
						sum1+=Double.valueOf( temps[dataIndex]);
					}else{
						sum1+=Double.valueOf( temps[dataIndex-5]);
					}
					if(NumberTools.isNum(temps[dataIndex+1])){
						sum2+=Double.valueOf(temps[dataIndex+1]);
					}else{
						sum2+=Double.valueOf(temps[dataIndex-4]);
					}
					count++;
				}
				if(count!=0){
					tempArr[0]=NumberTools.formatDouble(sum1/count,"##.###");
					tempArr[1]=NumberTools.formatDouble(sum2/count,"##.###");
				}
			
			}
		} catch (Exception e) {
			LogUtil.error(e);;
		}
		return tempArr;
	}

	// 获得历史外部数据连接ID
	public static Map<String, String> getOldOutId(String html) {
		Map<String, String> outIdMap = new HashMap<String, String>();
		Parser parser = Parser.createParser(html, "GBK");

		try {
			NodeList nodeList = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("div[class='kjjc_tablebox']"));
			if (null != nodeList && nodeList.size() > 0) {
				String opStr = nodeList.elementAt(0).toHtml();
				Parser parser2 = Parser.createParser(opStr, "GBK");
				NodeList arrangeList = parser2.extractAllNodesThatMatch(new TagNameFilter("tr"));
				if (arrangeList.size() > 2) {
					for (int i = 2; i < arrangeList.size() - 1; i++) {
						String arrangeStr = arrangeList.elementAt(i).toHtml();
						Parser parser3 = Parser.createParser(arrangeStr, "GBK");
						NodeList arrangeList2 = parser3.extractAllNodesThatMatch(new TagNameFilter("td"));
						if (arrangeList2.size() > 0 && arrangeList2 != null) {
							String numberStr = arrangeList2.elementAt(1).toPlainTextString().trim();
							String matchTime = arrangeList2.elementAt(2).toPlainTextString().trim();
							if ("".equals(matchTime))
								continue;
							String weekStr = numberStr.substring(0, 2);
							Integer lineId = Integer.parseInt(numberStr.substring(2));
							Date matchDate = DateTools.StringToDate(matchTime, "yyyy-MM-dd hh:mm");
							matchDate = DateUtil.getDateFormat(matchDate);
							Integer intTime = DateTools.handleIntTime(matchDate, weekStr);
							NodeList tdTagList = arrangeList2.elementAt(12).getChildren();
							if (tdTagList.size() < 2)
								continue;
							String xiHref = ((LinkTag) arrangeList2.elementAt(12).getChildren().elementAt(1)).getAttribute("href");
							String hrefId = null;
							if (xiHref.length() > 36) {
								hrefId = xiHref.substring(31, 36);
							}
							outIdMap.put(intTime + "_" + lineId, hrefId);
						}
					}
				}
			}
		} catch (ParserException e) {
			LogUtil.error(e);;
		}
		return outIdMap;

	}

	// 通过盈彩网抓外部id
	public static Map<String, String> getOutIdByYcw(String html) {
		Map<String, String> outIdMap = new HashMap<String, String>();
		Parser parser = Parser.createParser(html, "GBK");

		try {
			NodeList nodeList = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("table[width='848']"));
			if (null != nodeList && nodeList.size() > 0) {
				String opStr = nodeList.elementAt(0).toHtml();
				Parser parser2 = Parser.createParser(opStr, "GBK");
				NodeList arrangeList = parser2.extractAllNodesThatMatch(new TagNameFilter("tr"));
				if (arrangeList.size() > 1) {
					for (int i = 1; i < arrangeList.size(); i++) {
						String arrangeStr = arrangeList.elementAt(i).toHtml();
						Parser parser3 = Parser.createParser(arrangeStr, "GBK");
						NodeList arrangeList2 = parser3.extractAllNodesThatMatch(new TagNameFilter("td"));
						if (arrangeList2 != null && arrangeList2.size() > 2) {
							String intId = ((TableColumn) arrangeList2.elementAt(0)).getAttribute("id");
							String[] intIdArr = intId.split("_");
							intId = intIdArr[1] + "_" + intIdArr[2];

							NodeList tdTagList = arrangeList2.elementAt(11).getChildren();
							if (tdTagList.size() < 5)
								continue;
							String xiHref = ((LinkTag) tdTagList.elementAt(5)).getAttribute("href");
							String hrefId = null;
							if (xiHref.length() > 36) {
								String reg="^http\\:\\/\\/info\\.betzc\\.com\\/schedule\\/basketball\\/(\\d+).html";
								Pattern pattern = Pattern.compile(reg);
								Matcher matcher = pattern.matcher(xiHref);
								if (matcher.find()) {
									hrefId = matcher.group(1);
								}
								//hrefId = xiHref.substring(42, 47);
							}
							outIdMap.put(intId, hrefId);
						}
					}
				}
			}
		} catch (ParserException e) {
			LogUtil.error(e);;
		}
		return outIdMap;

	}
	// 通过彩客网抓外部id
	public static Map<String, String> getOutIdByCk(String html) {
		Map<String, String> outIdMap = new HashMap<String, String>();
		Parser parser = Parser.createParser(html, "GBK");

		try {
			NodeList nodeList = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("table[id='MatchTable']"));
			if (null != nodeList && nodeList.size() > 0) {
				String opStr = nodeList.elementAt(0).toHtml();
				Parser parser2 = Parser.createParser(opStr, "GBK");
				NodeList arrangeList = parser2.extractAllNodesThatMatch(new TagNameFilter("tr"));
				String intTime = "";
				if (arrangeList.size() > 1) {
					for (int i = 1; i < arrangeList.size(); i++) {
						TagNode trNode=(TagNode) arrangeList.elementAt(i);
						if("niDate".equals(trNode.getAttribute("class"))){
							NodeList nList = trNode.getChildren().extractAllNodesThatMatch(new TagNameFilter("td"));
							String ymd = nList.elementAt(0).toPlainTextString();
							intTime = ymd.split("日")[0].replace("年", "").replace("月", "");
						}
						
						if("true".equals(trNode.getAttribute("cansale"))){
							NodeList arrangeList2 = trNode.getChildren().extractAllNodesThatMatch(new TagNameFilter("td"));
							String intId = intTime + "_" + arrangeList2.elementAt(0).toPlainTextString();
							NodeList tdTagList = arrangeList2.elementAt(10).getChildren();
							String xiHref = ((LinkTag) tdTagList.elementAt(0)).getAttribute("href");
							String hrefId = null;
							String reg="^\\/handicap\\/lanqiu\\/(\\d+).html";
							Pattern pattern = Pattern.compile(reg);
							Matcher matcher = pattern.matcher(xiHref);
							if (matcher.find()) {
								hrefId = matcher.group(1);
							}
							//hrefId = xiHref.substring(42, 47);
							outIdMap.put(intId, hrefId);
						}
					}
				}
			}
		} catch (ParserException e) {
			LogUtil.error(e);;
		}
		return outIdMap;

	}

	// 通过五百万竞彩足球页面指数id
	public static Map<String, String> getFootballOutIdByWbw(String html, String dateText) throws ParserException {
		Map<String, String> outIdMap = new HashMap<String, String>();
		Parser parser = Parser.createParser(html, "GBK");
		HtmlPage vistor = new HtmlPage(parser);
		parser.visitAllNodesWith(vistor);
		NodeList body = vistor.getBody();
		NodeFilter iDFilter = new HasAttributeFilter("id", "d_" + dateText);
		NodeList tableNode = body.extractAllNodesThatMatch(iDFilter, true);
		NodeFilter trFilter = new TagNameFilter("tr");
		NodeList trList = tableNode.extractAllNodesThatMatch(trFilter, true);
		NodeFilter tdFilter = new TagNameFilter("td");
		NodeFilter linkFilter = new TagNameFilter("a");
		for (int i = 0, len = trList.size(); i < len; i++) {
			try {
				NodeList tdList = trList.elementAt(i).getChildren().extractAllNodesThatMatch(tdFilter);
				String key = tdList.elementAt(0).toPlainTextString();
				NodeList linkList = tdList.elementAt(7).getChildren().extractAllNodesThatMatch(linkFilter, true);
				LinkTag link = (LinkTag) linkList.elementAt(0);
				String oddId = link.getAttribute("href").split("\\?")[1].split("\\&")[0].split("=")[1];
				outIdMap.put(dateText+"_"+key, oddId);
			} catch (Exception e) {
				LogUtil.error(e);;
			}
		}
		return outIdMap;
	}

	public static Map<String,String> getAnalysisIdByLC(String html){
		Map<String, String> analysisIdMap = new HashMap<String, String>();
		if(html!=null){
			Document doc = Jsoup.parse(html);
			Elements eles = doc.select("row");  
			for (Element ele : eles) { 
				StringBuilder intId=new StringBuilder("20"+ele.attr("xid"));//20140309301
				intId.insert(8,"_");//20140309_301
				analysisIdMap.put(intId.toString(),  ele.attr("mid"));
			}
		}
		return analysisIdMap;
	} 
	
	
	
	public static Map<String, String> getAwardTzb(String content) {
		Map<String, String> tzbMap = new HashMap<String, String>();
		try {
			Parser parser = Parser.createParser(content, "gbk");
			NodeList divList = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("div[class='block']"));
			CssSelectorNodeFilter filter=new CssSelectorNodeFilter("div[class~='tright']");
			if (divList != null) {
				for (int i = 0; i < divList.size(); i++) {
					try{
						String matchInfo=divList.elementAt(i).getChildren().extractAllNodesThatMatch(new CssSelectorNodeFilter("div[class='blockTit']")).elementAt(0).toPlainTextString();
						String week = matchInfo.substring(0,2);
						String lineId = matchInfo.substring(2,5);
						Date matchDate = DateTools.StringToDate(matchInfo.substring(matchInfo.length()-19), "yyyy-MM-dd");
						String intTime = DateTools.handleIntTime(matchDate, week) + "";
						TableTag table = (TableTag) divList.elementAt(i).getChildren().extractAllNodesThatMatch(new CssSelectorNodeFilter("table[class='blockTab']"),true).elementAt(0);
						TableRow[] rows = table.getRows();
						TableRow tr = rows[rows.length-1];
						NodeList hotInfos = tr.getChildren().extractAllNodesThatMatch(filter,true);
						String hot = hotInfos.elementAt(0).getChildren().elementAt(1).toPlainTextString().trim();
						//客队热度
						tzbMap.put("tzb_" + intTime + "_" + lineId + "_hot_0", hot);
						hot = hotInfos.elementAt(1).getChildren().elementAt(2).toPlainTextString().trim();
						//主队热度
						tzbMap.put("tzb_" + intTime + "_" + lineId + "_hot_1", hot);
						String tzb = hotInfos.elementAt(0).getChildren().elementAt(0).toPlainTextString().trim();
						//客队投注比
						tzbMap.put("tzb_" + intTime + "_" + lineId + "_0", tzb);
						//主队投注比
						tzb = hotInfos.elementAt(1).getChildren().elementAt(0).toPlainTextString().trim();
						tzbMap.put("tzb_" + intTime + "_" + lineId + "_1", tzb);
					}catch (Exception e) {
						LogUtil.error(e);;
					}
				}
			}
		} catch (Exception e) {
			LogUtil.error(e);;
		}

		return tzbMap;
	}
	public static int pageCount(String htmlContent){
		try{
			Parser parser = Parser.createParser(htmlContent, "gbk");
			NodeList pageSize=parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("div[class='pagebox']")).elementAt(0).getChildren().extractAllNodesThatMatch(new TagNameFilter("span"));
			return pageSize.size()-2;
		}catch (Exception e) {
			LogUtil.error(e);;
		}
		return 0;
		
	}

	public static Map<String, String> getFootBallBetInfo(String url) {
		Map<String, String> tzbMap = new HashMap<String, String>();
		try {
			String html = HttpUtil.getUrl(url);
			Parser parser = Parser.createParser(html, "GBK");
			NodeList pageSpans = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("span[class='pagebox_num']"));
			tzbMap.putAll(getFootBallBetInfOnePage(Parser.createParser(html, "GBK")));
			for (int i = 0; i < pageSpans.size(); i++) {
				String pageIndex = pageSpans.elementAt(i).toPlainTextString().trim();
				html = HttpUtil.getUrl(url + "&page=" + pageIndex);
				tzbMap.putAll(getFootBallBetInfOnePage(Parser.createParser(html, "GBK")));
			}
		} catch (Exception e) {
			LogUtil.error(e);;
		}
		return tzbMap;
	}

	public static Map<String, String> getFootBallBetInfOnePage(Parser parser) throws Exception {
		Map<String, String> tzbMap = new HashMap<String, String>();
		NodeList divList = parser.extractAllNodesThatMatch(new CssSelectorNodeFilter("div[class='block']"));
		if (divList != null && divList.size() > 0) {
			for (int i = 0; i < divList.size(); i++) {
				String info = divList.elementAt(i).getChildren().elementAt(1).toPlainTextString().trim();
				String week = info.split(" ")[0].substring(0, 2);
				String lineId = info.split(" ")[0].substring(2);
				Date matchDate = DateTools.StringToDate(info.split(" ")[2], "yyyy-MM-dd");
				String intTime = DateTools.handleIntTime(matchDate, week) + "";

				TableTag table = (TableTag) divList.elementAt(i).getChildren().elementAt(3);
				TableRow[] rows = table.getRows();

				for (int j = 1; j < rows.length; j++) {
					TableRow tr = rows[j];

					TableColumn[] td = tr.getColumns();
					String tzb = td[1].getChildren().elementAt(2).toPlainTextString().trim();
					tzbMap.put("tzb_" + intTime + "_" + lineId + "_" + (j - 1), tzb);
					String hot = td[1].getChildren().elementAt(0).toPlainTextString().trim();
					tzbMap.put("tzb_" + intTime + "_" + lineId + "_hot_" + (j - 1), hot);

				}
			}
		}
		return tzbMap;
	}

	public List<BasketBallMatch> getPassResultPankou(String html) {
		List<BasketBallMatch> resultList = new ArrayList<BasketBallMatch>();
		Parser parser = Parser.createParser(html, "GBK");
			NodeFilter trFilter1=new HasAttributeFilter("class","ni");
			NodeFilter trFilter2=new HasAttributeFilter("class","ni2");
			NodeFilter trFilter=new OrFilter(trFilter1,trFilter2);
			NodeFilter tdFilter=new NodeClassFilter(TableColumn.class);
			try{
				NodeList matchRowList=parser.extractAllNodesThatMatch(trFilter);
				SimpleNodeIterator iterator= matchRowList.elements();
				while(iterator.hasMoreNodes()){
					NodeList matchCellList=iterator.nextNode().getChildren().extractAllNodesThatMatch(tdFilter);
					BasketBallMatch match=new BasketBallMatch();
					String matchKey=matchCellList.elementAt(0).toPlainTextString().trim();
					String week=matchKey.substring(0,2);
					String matchDateText=matchCellList.elementAt(2).toPlainTextString().trim();
					String[] dateNumbers=matchDateText.split("\\D");
					matchDateText=dateNumbers[0]+"-"+dateNumbers[1]+" "+dateNumbers[2]+":"+dateNumbers[3];
					Date matchDate=DateTools.strToDateDafueYear(matchDateText);
					Integer intTime=DateTools.handleIntTime(matchDate, week);
					match.setIntTime(intTime);
					match.setLineId(Integer.valueOf(matchKey.substring(2)));
					//RFSF
					String rfBase=matchCellList.elementAt(7).toPlainTextString();
					if(NumberTools.isNum(rfBase)){
						match.setHandicap(Double.valueOf(rfBase));
					}
					//DXF
					String dxfBase=matchCellList.elementAt(10).toPlainTextString().trim();
					if(NumberTools.isNum(dxfBase)){
						match.setBaseBigOrSmall(Double.valueOf(dxfBase));
					}
					resultList.add(match);
				}
			}catch (Exception e) {
				LogUtil.error(e);;
			}
			return resultList;
	}
}
