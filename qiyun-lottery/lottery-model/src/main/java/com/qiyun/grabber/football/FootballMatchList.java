package com.qiyun.grabber.football;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.qiyun.model.MatchShowStatusFb;
import com.qiyun.model.MatchShowStatusTextFb;
import com.qiyun.model.football.FootBallMatch;
import com.qiyun.model.inter.MatchInterface;
import com.qiyun.tools.DateTools;
import com.qiyun.util.HttpUtil;
import com.qiyun.util.LogUtil;
import com.qiyun.util.NumberTools;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.http.conn.HttpHostConnectException;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.CssSelectorNodeFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.SimpleNodeIterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FootballMatchList implements MatchInterface<FootBallMatch> {
	
	public List<FootBallMatch> getMatchList(String html,String statusHtml) {
		List<FootBallMatch> matchList = new ArrayList<FootBallMatch>();
		if(html == null) {
			return matchList;
		}
		
		try {
			html = html.substring(8, html.length()-2);
			JSONObject  o = JSONObject.fromObject(html);
			JSONObject list = o.getJSONObject("data");
			Iterator it = list.keys();
			while(it.hasNext()){
				String key = it.next().toString();
				JSONObject item = list.getJSONObject(key);
				String numberStr = item.get("num").toString().trim();
				String lineId = numberStr.substring(2, numberStr.length());
				String date = item.get("date").toString().trim();
				String time = item.get("time").toString().trim();
				String gameColor = item.get("l_background_color").toString().trim();
				String intTime = item.get("b_date").toString().trim().replaceAll("-", "");
				String status = item.get("status").toString().trim();
				String gameName = item.get("l_cn_abbr").toString().trim();
				String homeTeam = item.get("h_cn_abbr").toString().trim();
				String guestTeam = item.get("a_cn_abbr").toString().trim();
				List<MatchShowStatusFb> statusList = MatchShowStatusTextFb.getShowStatsuFbOrderList();
				
				//胜平负
				if(item.containsKey("had")){
					String jsonHad =  item.get("had").toString().trim();
					JSONObject jsonObj = JSONObject.fromObject(jsonHad);
					String pStatus = jsonObj.get("p_status").toString().trim();
					if("Selling".equals(pStatus)) {
						String single = jsonObj.get("single").toString().trim();
						if("0".equals(single)) {
							statusList.remove(MatchShowStatusFb.SPFSINGLE);
						}
					} else {
						statusList.remove(MatchShowStatusFb.SPF);
						statusList.remove(MatchShowStatusFb.SPFSINGLE);
					}
				} else {
					statusList.remove(MatchShowStatusFb.SPF);
					statusList.remove(MatchShowStatusFb.SPFSINGLE);
				}

				//hhad	让球
				String  concede = "0";
				if(item.containsKey("hhad")){//如果没有，则不开
					String jsonHad =  item.get("hhad").toString().trim();
					JSONObject jsonObj = JSONObject.fromObject(jsonHad);
					concede = jsonObj.get("fixedodds").toString().trim();
					String pStatus = jsonObj.get("p_status").toString().trim();
					if("Selling".equals(pStatus)) {
						String single = jsonObj.get("single").toString().trim();
						if("0".equals(single)) {
							statusList.remove(MatchShowStatusFb.RQSPFSINGLE);
						}
					} else {
						statusList.remove(MatchShowStatusFb.RQSPF);
						statusList.remove(MatchShowStatusFb.RQSPFSINGLE);
					}
				} else {
					statusList.remove(MatchShowStatusFb.RQSPF);
					statusList.remove(MatchShowStatusFb.RQSPFSINGLE);
				}
				
				//比分
				if(item.containsKey("crs")){	//如果没有，则不开
					String jsonHad =  item.get("crs").toString().trim();
					JSONObject jsonObj = JSONObject.fromObject(jsonHad);
					String pStatus = jsonObj.get("p_status").toString().trim();
					if("Selling".equals(pStatus)) {
						String single = jsonObj.get("single").toString().trim();
						if("0".equals(single)) {
							statusList.remove(MatchShowStatusFb.BFSINGLE);
						}
					} else {
						statusList.remove(MatchShowStatusFb.BF);
						statusList.remove(MatchShowStatusFb.BFSINGLE);
					}
				} else {
					statusList.remove(MatchShowStatusFb.BF);
					statusList.remove(MatchShowStatusFb.BFSINGLE);
				}
				
				//总进球
				if(item.containsKey("ttg")){	//如果没有，则不开
					String jsonHad =  item.get("ttg").toString().trim();
					JSONObject jsonObj = JSONObject.fromObject(jsonHad);
					String pStatus = jsonObj.get("p_status").toString().trim();
					if("Selling".equals(pStatus)) {
						String single = jsonObj.get("single").toString().trim();
						if("0".equals(single)) {
							statusList.remove(MatchShowStatusFb.JQSSINGLE);
						}
					} else {
						statusList.remove(MatchShowStatusFb.JQS);
						statusList.remove(MatchShowStatusFb.JQSSINGLE);
					}
				} else {
					statusList.remove(MatchShowStatusFb.JQS);
					statusList.remove(MatchShowStatusFb.JQSSINGLE);
				}
				
				//半全场
				if(item.containsKey("hafu")){	//如果没有，则不开
					String jsonHad =  item.get("hafu").toString().trim();
					JSONObject jsonObj = JSONObject.fromObject(jsonHad);
					String pStatus = jsonObj.get("p_status").toString().trim();
					if("Selling".equals(pStatus)) {
						String single = jsonObj.get("single").toString().trim();
						if("0".equals(single)) {
							statusList.remove(MatchShowStatusFb.BQCSINGLE);
						}
					} else {
						statusList.remove(MatchShowStatusFb.BQC);
						statusList.remove(MatchShowStatusFb.BQCSINGLE);
					}
				} else {
					statusList.remove(MatchShowStatusFb.BQC);
					statusList.remove(MatchShowStatusFb.BQCSINGLE);
				}
				
				Date matchTime = DateTools.StringToDate_YYYY_MM_DD_HH_MM_SS(date+" "+time);
				FootBallMatch fbMatch = new FootBallMatch();
				fbMatch.setConcede(Integer.parseInt(concede));
				fbMatch.setIntTime(Integer.parseInt(intTime));
				fbMatch.setLineId(Integer.parseInt(lineId));
				fbMatch.setMatchTime(matchTime);
				fbMatch.setGameColor("#"+gameColor);
				fbMatch.setGameName(gameName);
				fbMatch.setHomeTeam(homeTeam);
				fbMatch.setGuestTeam(guestTeam);
				//0:在售1:截止2:取消
				if("Selling".equals(status)) {
					fbMatch.setStatus(0);
				} else {
					fbMatch.setStatus(2);
				}
				
				int show=0;
				for (MatchShowStatusFb fb : statusList) {
					show |= 1 << fb.getValue();
				}
				fbMatch.setShowNum(show);
				matchList.add(fbMatch);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return matchList;
		
//		List<FootBallMatch> matchList = new ArrayList<FootBallMatch>();
//		try {
//			Map<String,Integer> statusMap=new HashMap<String, Integer>();
//			statusMap=getStatusMap(statusHtml);
//			Parser parser = Parser.createParser(html, "GBK");
//			NodeFilter trFilter=new CssSelectorNodeFilter("tr[zid]");
//			NodeList trNodeList = parser.extractAllNodesThatMatch(trFilter);
//			NodeFilter linkFilter= new TagNameFilter("A");
//			NodeFilter matchTimeFilter= new CssSelectorNodeFilter("span.match_time");
//			NodeFilter concedeFilter= new TagNameFilter("p");
//			SimpleNodeIterator trNodeIterator = trNodeList.elements();
//			Tag tag=null;
//			while (trNodeIterator.hasMoreNodes()) {
//				String gameName = null, guestTeam = null, homeTeam = null, matchTime = null, gameColor = null,endTime=null;
//				Integer lineId = null, concede = null,intTime=null;
//				Node trNode = trNodeIterator.nextNode();
//				NodeList tdNodeList = trNode.getChildren();
//				try {
//					if(trNode instanceof Tag){
//						tag=(Tag)trNode;
//						endTime = tag.getAttribute("pdate").trim();
//						endTime=endTime.replace("-","");//开赛时间
//						intTime=Integer.parseInt(endTime);
//					}
//					if (tdNodeList == null)
//						continue;
//					String numberStr = tdNodeList.elementAt(1).toPlainTextString().trim();
//					lineId = Integer.parseInt(numberStr);//LINEID
//					Node node=tdNodeList.elementAt(3).getChildren().elementAt(0);
//					if(node instanceof Tag ){
//						tag=(Tag)node;
//						gameColor = tag.getAttribute("style").trim().replace("background:", "");
//					}
//					gameName =node.toPlainTextString(); //赛事名称
//					node=tdNodeList.elementAt(7).getChildren().extractAllNodesThatMatch(linkFilter).elementAt(0);
//					if(node instanceof Tag){
//						tag=(Tag)node;
//						homeTeam = tag.getAttribute("title").trim();//主队
//					}
//					node=tdNodeList.elementAt(11).getChildren().extractAllNodesThatMatch(linkFilter).elementAt(0);
//					if(node instanceof Tag){
//						tag=(Tag)node;
//						guestTeam = tag.getAttribute("title").trim();///客队
//					}
//					node =tdNodeList.elementAt(5).getChildren().extractAllNodesThatMatch(matchTimeFilter).elementAt(0);
//					if(node instanceof Tag){
//						tag=(Tag)node;
//						matchTime = tag.getAttribute("title").trim();
//						matchTime=matchTime.substring(10);//开赛时间
//					}
//					String concedeStr=tdNodeList.elementAt(13).getChildren().extractAllNodesThatMatch(concedeFilter).elementAt(1).toPlainTextString().trim();
//					concedeStr=concedeStr.replace("+", "");
//					concede=Integer.parseInt(concedeStr);//让球
//					
//				} catch (Exception e) {
//					continue;
//				}
//				FootBallMatch match = new FootBallMatch();
//				match.setLineId(lineId);//
//				Date resultDate = DateTools.strToDateDafueYear(matchTime);
//				match.setMatchTime(resultDate);//
//				match.setIntTime(intTime);//
//				match.setGameName(gameName);//
//				match.setHomeTeam(homeTeam);//
//				match.setGuestTeam(guestTeam);//
//				match.setConcede(concede);//
//				match.setGameColor(gameColor);//
//				if(!statusMap.isEmpty()&&statusMap.containsKey(intTime+"\1\1"+lineId)){
//					match.setShowNum(statusMap.get(intTime+"\1\1"+lineId));
//				}else{
//					match.setShowNum(match.getShowStatusNumAll());
//				 }
//				 matchList.add(match);
//			}
//		} catch (Exception e) {
//			LogUtil.error(e);
//		}
//		return matchList;
	}

	public Map<String,Integer> getStatusMap(String html) throws Exception{
		Map<String,Integer> statusMap=new HashMap<String,Integer>();
		if(StringUtils.isEmpty(html)){
			return statusMap;
		}
		Document doc = Jsoup.parse(html);
		Element eles = doc.select("#headerTr").first();
		
		Element table=eles.nextElementSibling().child(0);
		Elements trs=table.child(0).children();
		
		Iterator<Element> iterator= trs.iterator();
		while (iterator.hasNext()) {
			Element trEle =iterator.next();
			List<Element> tdList=trEle.children();
			if(tdList.size()==1){
				continue;
			}
			
			String status= tdList.get(5).text().trim();
			if(!"已开售".equals(status)){
				continue;
			}
			
			List<MatchShowStatusTextFb> stopPlayList=new ArrayList<MatchShowStatusTextFb>();
			
			
			//SPF
			Element statusEle=tdList.get(6);
			if(statusEle.children().size()==0){
				continue;
			}
			String cssClass=statusEle.select("div").attr("class");
			if(cssClass.equals("closed1")){ //未开售
				stopPlayList.add(MatchShowStatusTextFb.SPF);
				stopPlayList.add(MatchShowStatusTextFb.SPFSINGLE);
			}else if(cssClass.equals("dan1")){//单关过关都开售
				
			}else if(cssClass.equals("kong1")){//过关开售
				stopPlayList.add(MatchShowStatusTextFb.SPFSINGLE);
			}
			
			//rqspf
			statusEle=tdList.get(7);
			if(statusEle.children().size()==0){
				continue;
			}
			cssClass=statusEle.select("div").attr("class");
			if(cssClass.equals("closed1")){ //未开售
				stopPlayList.add(MatchShowStatusTextFb.RQSPF);
				stopPlayList.add(MatchShowStatusTextFb.RQSPFSINGLE);
			}else if(cssClass.equals("dan1")){//单关过关都开售
				
			}else if(cssClass.equals("kong1")){//过关开售
				stopPlayList.add(MatchShowStatusTextFb.RQSPFSINGLE);
			}
			
			//bf
			statusEle=tdList.get(8);
			if(statusEle.children().size()==0){
				continue;
			}
			cssClass=statusEle.select("div").attr("class");
			if(cssClass.equals("closed1")){ //未开售
				stopPlayList.add(MatchShowStatusTextFb.BF);
				stopPlayList.add(MatchShowStatusTextFb.BFSINGLE);
			}else if(cssClass.equals("dan1")){//单关过关都开售
				
			}else if(cssClass.equals("kong1")){//过关开售
				stopPlayList.add(MatchShowStatusTextFb.BFSINGLE);
			}
			//JQS
			statusEle=tdList.get(9);
			if(statusEle.children().size()==0){
				continue;
			}
			cssClass=statusEle.select("div").attr("class");
			if(cssClass.equals("closed1")){ //未开售
				stopPlayList.add(MatchShowStatusTextFb.JQS);
				stopPlayList.add(MatchShowStatusTextFb.JQSSINGLE);
			}else if(cssClass.equals("dan1")){//单关过关都开售
				
			}else if(cssClass.equals("kong1")){//过关开售
				stopPlayList.add(MatchShowStatusTextFb.JQSSINGLE);
			}
			//BQC
			statusEle=tdList.get(10);
			if(statusEle.children().size()==0){
				continue;
			}
			cssClass=statusEle.select("div").attr("class");
			if(cssClass.equals("closed1")){ //未开售
				stopPlayList.add(MatchShowStatusTextFb.BQC);
				stopPlayList.add(MatchShowStatusTextFb.BQCSINGLE);
			}else if(cssClass.equals("dan1")){//单关过关都开售
				
			}else if(cssClass.equals("kong1")){//过关开售
				stopPlayList.add(MatchShowStatusTextFb.BQCSINGLE);
			}
			String numberStr=tdList.get(0).text().trim();
			String	matchTime=tdList.get(3).text().trim();
			matchTime=matchTime.substring(5);
			Date resultDate = DateTools.strToDateDafueYear(matchTime);
			String weekStr = numberStr.substring(0, 2);
			int intTime=DateTools.handleIntTime(resultDate, weekStr);
			String key=intTime+"\1\1"+Integer.parseInt(numberStr.substring(2));

			List<MatchShowStatusFb> statusList=MatchShowStatusTextFb.getShowStatsuFbOrderList();
			for (int i = 0; i < stopPlayList.size(); i++) {
				for(MatchShowStatusTextFb fb :MatchShowStatusTextFb.values()){
					if(fb.getText().equals(stopPlayList.get(i).getText())){
						statusList.remove(fb.getMatchShowStatusFb());
					}
				}
			}
			int show=0;
			for (MatchShowStatusFb fb : statusList) {
				show |= 1 << fb.getValue();
			}
			statusMap.put(key,show);
		}
		return statusMap;
	}
	/*
	 * 获得单关奖金值
	 */
	public FootBallMatch getSingleAward(String html) {
		String awardHtml = HttpUtil.getUrl(html);
		FootBallMatch match = new FootBallMatch();
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
						if (arrangeList2.size() >= 4 && "胜平负".equals(sfStr)) {
							String resultOfSF = arrangeList2.elementAt(3).toPlainTextString().trim();
							if (!"".equals(resultOfSF) && !isChinese(resultOfSF)) {
								match.setResultRQAwardOfTotoPass(Double.parseDouble(resultOfSF));
							}
						} else if (arrangeList2.size() >= 4 && "比分".equals(sfStr)) {
							String resultAwardOfSingleScore = arrangeList2.elementAt(3).toPlainTextString().trim();
							if (!"".equals(resultAwardOfSingleScore) && !isChinese(resultAwardOfSingleScore)&&!"&nbsp;".equals(resultAwardOfSingleScore)) {
								match.setResultAwardOfSingleScore(Double.parseDouble(resultAwardOfSingleScore));
							}
						} else if (arrangeList2.size() >= 4 && "总进球数".equals(sfStr)) {
							String resultAwardOfScorePass = arrangeList2.elementAt(3).toPlainTextString().trim();
							if (!"".equals(resultAwardOfScorePass) && !isChinese(resultAwardOfScorePass)) {
								match.setResultAwardOfScorePass(Double.parseDouble(resultAwardOfScorePass));
							}
						} else if (arrangeList2.size() >= 4 && "半全场胜平负".equals(sfStr)) {
							String resultAwardOfHfTotoPass = arrangeList2.elementAt(3).toPlainTextString().trim();
							if (!"".equals(resultAwardOfHfTotoPass) && !isChinese(resultAwardOfHfTotoPass)) {
								match.setResultAwardOfHfTotoPass(Double.parseDouble(resultAwardOfHfTotoPass));
							}
						}
					}

				}
			} catch (ParserException e) {
				LogUtil.error(e);
			}
		}

		return match;
	}

	/*
	 * 获取比赛结果，奖金值
	 */
	public List<FootBallMatch> getMatchResultList(String html) {
		List<FootBallMatch> resultList = new ArrayList<FootBallMatch>();
		try {
			Document doc=Jsoup.parse(html);
//			Element ele=doc.select("#headerTr").first();
			Element tableEle=doc.select(".match_list").last();
			
			Elements trList=tableEle.child(0).child(0).children();
			//trList.remove(0);//去头
			if(trList.size()>0){trList.remove(trList.size()-1);}//去尾
			//if(trList.size()>0){trList.remove(trList.size()-1);}//去第二个尾
			Iterator<Element> trIt=trList.iterator();
			
			while(trIt.hasNext()){
				Element trEle=trIt.next();
				Elements tdList=trEle.children();
				
				String matchTime = tdList.get(0).text().trim();
				String numberStr = tdList.get(1).text().trim();
				String weekStr = numberStr.substring(0, 2);
				Integer lineId = Integer.parseInt(numberStr.substring(2));
				Date mTime = DateTools.stringToDate(matchTime, "yyyy-MM-dd");
				Integer intTime = DateTools.handleIntTime(mTime, weekStr);
				
				String halfScore =tdList.get(4).text().trim();
				String wholeScore =tdList.get(5).text().trim();
				if (!halfScore.matches("^\\d+:\\d+$")||!wholeScore.matches("^\\d+:\\d+$")) {
					continue;
				}
				String[] halfArr=halfScore.split(":");
				String[] wholeArr=wholeScore.split(":");
				
				Integer halfHomeScore = Integer.parseInt(halfArr[0]);
				Integer halfGuestScore = Integer.parseInt(halfArr[1]);
				Integer homeScore = Integer.parseInt(wholeArr[0]);
				Integer guestScore = Integer.parseInt(wholeArr[1]);

				FootBallMatch match = new FootBallMatch();
				match.setIntTime(intTime);
				match.setLineId(lineId);
				match.setHalfHomeScore(halfHomeScore);
				match.setHalfGuestScore(halfGuestScore);
				match.setHomeScore(homeScore);
				match.setGuestScore(guestScore);
				resultList.add(match);
				
			}
			
		} catch (Exception e) {
			LogUtil.error(e);
		}
		return resultList;
	}

	/*
	 * 获得分页值
	 */
	public Integer getResultPage(String html) {
		Integer paging = 1;
		try {
			Document doc=Jsoup.parse(html);
			Element pageEle=doc.select(".m-page").first();
			Elements resultEle=pageEle.getElementsByTag("li");
			if(resultEle!=null && resultEle.size()>3){
				paging=resultEle.size()-3;
			}
		} catch (Exception e) {
			LogUtil.error(e);
		}
		return paging;
	}

	public static Integer getPage(String url) throws HttpHostConnectException {
		try {
			String html = HttpUtil.getUrl(url);
			if (html != null) {
				Parser parser = Parser.createParser(html, "GBK");
				// Parser parser = HttpUtil.getWebContent(html);
				NodeFilter filter = new HasAttributeFilter("style", "text-align:center");
				NodeList nl = parser.extractAllNodesThatMatch(filter);

				if (null != nl && nl.size() > 0) {
					NodeList str = nl.elementAt(0).getChildren();
					String page = str.elementAt(0).getLastChild().toPlainTextString().trim();
					if (!"".equals(page) && page != null) {
						page = page.substring(page.indexOf(":")).split("/")[1];
					} else {
						page = "1";
					}
					Integer pageNum = Integer.parseInt(page);
					return pageNum;
				}
			}
		} catch (ParserException e) {
			LogUtil.error(e);
		}
		return null;
	}
	public List<FootBallMatch> getSingleResultAward(String html) {
		List<FootBallMatch> resultList = new ArrayList<FootBallMatch>();
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
				FootBallMatch match=new FootBallMatch();
				String matchKey=matchCellList.elementAt(0).toPlainTextString().trim();
				String matchDateText = matchKey.substring(5);
				matchKey = matchKey.substring(0, 5);
				String week=matchKey.substring(0,2);
				Date matchDate=DateTools.strToDateDafueYear(matchDateText);
				Integer intTime=DateTools.handleIntTime(matchDate, week);
				match.setIntTime(intTime);
				match.setLineId(Integer.valueOf(matchKey.substring(2)));
				//RQSPF
				NodeList singleNodeList=matchCellList.elementAt(6).getChildren().extractAllNodesThatMatch(linkFilter);
				if(singleNodeList.size()!=0){
					String rqspfAward=singleNodeList.elementAt(0).toPlainTextString().trim();
					if(NumberTools.isNum(rqspfAward)){
						match.setResultRQAwardOfTotoPass(Double.valueOf(rqspfAward));
					}
				}
				
				//SPF
				singleNodeList = matchCellList.elementAt(7).getChildren().extractAllNodesThatMatch(linkFilter);
				if(singleNodeList.size()!=0){
					String spfAward=singleNodeList.elementAt(0).toPlainTextString().trim();
					if(NumberTools.isNum(spfAward)){
						match.setResultAwardOfTotoPass(Double.valueOf(spfAward));
					}
				}
				
				//BF
				singleNodeList=matchCellList.elementAt(8).getChildren().extractAllNodesThatMatch(linkFilter);
				if(singleNodeList.size()!=0){
					String bfAward=singleNodeList.elementAt(0).toPlainTextString().trim();
					if(NumberTools.isNum(bfAward)){
						match.setResultAwardOfSingleScore(Double.valueOf(bfAward));
					}
				}
				
				//JQS
				singleNodeList=matchCellList.elementAt(9).getChildren().extractAllNodesThatMatch(linkFilter);
				if(singleNodeList.size()!=0){
					String jqsAward=singleNodeList.elementAt(0).toPlainTextString().trim();
					if(NumberTools.isNum(jqsAward)){
						match.setResultAwardOfScorePass(Double.valueOf(jqsAward));
					}
				}
				
				//BQC
				singleNodeList=matchCellList.elementAt(10).getChildren().extractAllNodesThatMatch(linkFilter);
				if(singleNodeList.size()!=0){
					String bqcAward=singleNodeList.elementAt(0).toPlainTextString().trim();
					if(NumberTools.isNum(bqcAward)){
						match.setResultAwardOfHfTotoPass(Double.valueOf(bqcAward));
					}
				}
				resultList.add(match);
			}
			return resultList;
		}catch (Exception e) {
			LogUtil.error(e);
		}
		return null;
		
//		List<FootBallMatch> resultList = new ArrayList<FootBallMatch>();
//		Parser parser = Parser.createParser(html, "GBK");
//		try {
//			NodeList resultTableNode=parser.extractAllNodesThatMatch(new HasAttributeFilter("class","ld_table"));
//			NodeList matchRowList=resultTableNode.elementAt(0).getChildren().extractAllNodesThatMatch(new TagNameFilter("tr"));
//			for(int i=1;i<matchRowList.size();i++){
//				NodeList matchCellList=matchRowList.elementAt(i).getChildren().extractAllNodesThatMatch(new TagNameFilter("td"));
//				FootBallMatch match=new FootBallMatch();
//				String matchKey=matchCellList.elementAt(0).toPlainTextString().trim();
//				String week=matchKey.substring(0,2);
//				String matchDateText=matchCellList.elementAt(2).toPlainTextString();
//				Date matchDate=DateTools.strToDateDafueYear(matchDateText);
//				Integer intTime=DateTools.handleIntTime(matchDate, week);
//				match.setIntTime(intTime);
//				match.setLineId(Integer.valueOf(matchKey.substring(2)));
//				String rqspfAward=matchCellList.elementAt(9).toPlainTextString();
//				if(NumberTools.isNum(rqspfAward)){
//					match.setResultRQAwardOfTotoPass(Double.valueOf(rqspfAward));
//				}
//				String spfAward=matchCellList.elementAt(12).toPlainTextString();
//				if(NumberTools.isNum(spfAward)){
//					match.setResultAwardOfTotoPass(Double.valueOf(spfAward));
//				}
//				String jqsAward=matchCellList.elementAt(15).toPlainTextString();
//				if(NumberTools.isNum(jqsAward)){
//					match.setResultAwardOfScorePass(Double.valueOf(jqsAward));
//				}
//				String bqcAward=matchCellList.elementAt(18).toPlainTextString();
//				if(NumberTools.isNum(bqcAward)){
//					match.setResultAwardOfHfTotoPass(Double.valueOf(bqcAward));
//				}
//				resultList.add(match);
//			}
//			return resultList;
//		}catch (Exception e) {
//			LogUtil.error(e);
//		}
//		return null;
	}

	/*
	 * public static void main(String[] args) throws HttpHostConnectException {
	 * String resultUrl="http://info.sporttery.cn/lotterygame/hhad_list.php";
	 * String result=HttpClientUtil.getRemoteStr(resultUrl,"GBK");
	 * FootballMatchList matchList=new FootballMatchList(); List<FootBallMatch>
	 * resultLit=matchList.getMatchList(result); for(FootBallMatch
	 * match:resultLit){ } }
	 */
	public static List<String[]> getfballInfo(String html) {
		List<String[]> fballList = new ArrayList<String[]>();
		html = HttpUtil.getUrl(html);
		if (html != null) {
			try {
				Parser parser = Parser.createParser(html, "GBK");
				// Parser parser = HttpUtil.getWebContent(html);
				NodeFilter filter = new HasAttributeFilter("class", "trstyle01");
				NodeList nl = parser.extractAllNodesThatMatch(filter);

				if (null != nl && nl.size() > 1) {
					for (int i = 0; i < nl.size() - 1; i++) {
						String[] ballArr = new String[5];
						NodeList str = nl.elementAt(i).getChildren();
						ballArr[0] = str.elementAt(3).toPlainTextString().trim();
						ballArr[1] = str.elementAt(5).toPlainTextString().trim().replace('\n', ' ');
						String arrange = str.elementAt(7).toPlainTextString().trim();
						String[] team = arrange.split("VS");
						if (team.length == 2) {
							ballArr[2] = arrange.split("VS")[0].trim();
							ballArr[3] = arrange.split("VS")[1].trim();
						}

						// 建立一个节点filter用于过滤节点
						NodeFilter filterA = new TagNameFilter("A");
						// 得到所有过滤后，想要的节点
						str = str.extractAllNodesThatMatch(filterA, true);
						// 亚链接地址
						String yaHref = ((LinkTag) str.elementAt(3)).getAttribute("href");
						if (!"".equals(yaHref) || yaHref.length() > 1) {
							String ya = yaHref.substring(yaHref.indexOf("(") + 1, yaHref.indexOf(")"));
							ballArr[4] = ya.split("\\,")[0];
						}
						fballList.add(ballArr);
					}
				}
			} catch (ParserException e) {
				LogUtil.error(e);
			}
		}

		return fballList;
	}

	private Integer analysisConcede(String termName) {
		int index = termName.indexOf("(");
		if (index != -1) {
			int endIndex = termName.indexOf(")");
			String concedeStr = termName.substring(index + 1, endIndex);
			if (concedeStr.indexOf("+") != -1) {
				concedeStr = concedeStr.substring(concedeStr.indexOf("+") + 1);
			}
			return Integer.valueOf(concedeStr);
		} else {
			return 0;
		}
	}

	public String getNumfromStr(String str) {
		Matcher m = Pattern.compile("[\\d.]+").matcher(str);
		m.find();
		String value = m.group();
		return value;
	}

	// 判断字符串是否含有中文
	public Boolean isChinese(String str) {
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		return m.find();
	}

	public static String getTransforPK(String pk) {
		Map<String, String> pkMap = new HashMap<String, String>();
		pkMap.put("平手/半球", "平/半");
		pkMap.put("半球/一球", "半/一");
		pkMap.put("一球/球半", "一/球半");
		pkMap.put("球半/两球", "半/两");
		pkMap.put("两球/两球半", "两/半");
		pkMap.put("受平手/半球", "受平/半");
		pkMap.put("受半球/一球", "受半/一");
		pkMap.put("受一球/球半", "受一/半");
		pkMap.put("受球半/两球", "受半/两");
		pkMap.put("受两球/两球半", "受两/半");

		String transforPK = pkMap.get(pk);
		if (transforPK != null) {
			return transforPK;
		} else {
			return pk;
		}
	}

	public List<FootBallMatch> getRFofPass(String html) {
		throw new RuntimeException("竞彩足球无此方法");
	}

	public List<FootBallMatch> getRFofSingle(String html) {
		throw new RuntimeException("竞彩足球无此方法");
	}

	public List<FootBallMatch> getDXbaseofPass(String html) {
		throw new RuntimeException("竞彩足球无此方法");
	}

	public List<FootBallMatch> getDXbaseofSingle(String html) {
		throw new RuntimeException("竞彩足球无此方法");
	}

	public List<FootBallMatch> getPassResultPankou(String html) {
		return null;
	}
	
}