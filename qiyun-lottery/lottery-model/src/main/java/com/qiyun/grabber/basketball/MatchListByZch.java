package com.qiyun.grabber.basketball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.qiyun.model.MatchShowStatus;
import com.qiyun.model.basketball.BasketBallMatch;
import com.qiyun.tools.DateTools;
import com.qiyun.util.LogUtil;
import com.qiyun.utils.StringTools;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class MatchListByZch extends MatchList{
	@Override
	public List<BasketBallMatch> getMatchList(String html, String statusHtml) {
		
		Map<String,BasketBallMatch> matchMap=new HashMap<String, BasketBallMatch>();
		List<BasketBallMatch> matchList = new ArrayList<BasketBallMatch>();
		try{
			Map<String, Integer> statusMap = new HashMap<String, Integer>();
			statusMap = getStatusMap(statusHtml);
			
			Document doc = DocumentHelper.parseText(html);
			Element root = doc.getRootElement();
			List<Element> eleList = root.elements();
			String intTime, status, lineId, matchTimeStr, gameColor, gameName, homeTeam, guestTeam, rf,dxp;
			Date matchTime;
			for (Element element : eleList) {
				intTime = element.elementTextTrim("date");
				List<Element> matchEleList = element.elements("match");
				for (Element match : matchEleList) {
					String playCode=match.attributeValue("playCode");
					
//					status = match.attributeValue("operation");// 0:在售1:截止2:取消
					status = "0";// 0:在售1:截止2:取消
					lineId = match.attributeValue("sn");
					matchTimeStr = match.attributeValue("endTime");
					matchTime = DateTools.StringToDate(matchTimeStr,"yy-MM-dd HH:mm");
					rf =noNull(match.attributeValue("letBall"));
					dxp=noNull(match.attributeValue("preCast"));
					gameColor = match.attributeValue("matchColor");
					gameName = match.elementTextTrim("matchName");
					homeTeam = match.elementTextTrim("mainTeam");
					guestTeam = match.elementTextTrim("guestTeam");
					
					
					if(StringTools.isNullOrBlank(gameName) || StringTools.isNullOrBlank(homeTeam) || StringTools.isNullOrBlank(guestTeam) 
							|| StringTools.isNullOrBlank(intTime) ||  StringTools.isNullOrBlank(lineId) ){
						continue;
					}
					
					
					if(playCode.equals("00")){ //过关保存
						BasketBallMatch bbMatch = new BasketBallMatch();
						bbMatch.setBaseBigOrSmall(Double.parseDouble(dxp));
						bbMatch.setHandicap(Double.parseDouble(rf));
						bbMatch.setIntTime(Integer.parseInt(intTime));
						bbMatch.setLineId(Integer.parseInt(lineId));
						bbMatch.setMatchTime(matchTime);
						bbMatch.setGameColor(gameColor);
						bbMatch.setGameName(gameName);
						bbMatch.setHomeTeam(homeTeam);
						bbMatch.setGuestTeam(guestTeam);
						bbMatch.setStatus(Integer.parseInt(status));
						String statusKey = bbMatch.getIntTime() + "\1\1" + bbMatch.getLineId();
						if (!statusMap.isEmpty() && statusMap.containsKey(statusKey)) {
							bbMatch.setShowNum(statusMap.get(statusKey));
							matchMap.put(bbMatch.getMapKey(),bbMatch);
						}
					}else if(playCode.equals("02")||playCode.equals("04")){//让分和大小分单关数据
						String key=intTime+"_"+Integer.parseInt(lineId);
						BasketBallMatch bbMatch =matchMap.get(key);
						if(bbMatch!=null){
							if(playCode.equals("02")){
								bbMatch.setSingle_handicap(Double.parseDouble(rf));
							}else{
								bbMatch.setSingle_baseBigOrSmall(Double.parseDouble(dxp));
							}
						}
					}
				}
			}
			matchList=new ArrayList<BasketBallMatch>(matchMap.values());
			Collections.sort(matchList,new Comparator<BasketBallMatch>(){
				public int compare(BasketBallMatch o1, BasketBallMatch o2) {
					int num=o1.getIntTime()-o2.getIntTime();
					if(num==0){
						num=o1.getLineId()-o2.getLineId();
					}
					return num;
				}
			});
			
		} catch (DocumentException e) {
			LogUtil.error(e);;
		} catch (Exception e) {
			LogUtil.error(e);;
		}
		return matchList;
	}
	public String noNull(String str){
		if(str==null||str.equals("")){
			str="0";
		}else if(!StringTools.isDouble(str)){
			str="0";
		}
		else{
			str=str.replace("+", "");
		}
		return str;
	}
	public  Map<String,Integer> getStatusMap(String html) throws Exception{
		Map<String,Integer> statusMap=new HashMap<String,Integer>();
		if(StringUtils.isEmpty(html)){
			return statusMap;
		}
		org.jsoup.nodes.Document doc = Jsoup.parse(html);
		
		org.jsoup.nodes.Element eles = doc.select("#headerTr").first();
		org.jsoup.nodes.Element table=eles.nextElementSibling().child(0);
		Elements trs=table.child(0).children();
		
		Iterator<org.jsoup.nodes.Element> iterator= trs.iterator();
		while (iterator.hasNext()) {
			org.jsoup.nodes.Element trEle =iterator.next();
			List<org.jsoup.nodes.Element> tdList=trEle.children();
			if(tdList.size()==1){
				continue;
			}
			
			String status= tdList.get(4).text().trim();
			if(!"已开售".equals(status)){
				continue;
			}
			List<MatchShowStatus> stopPlayList=new ArrayList<MatchShowStatus>();
			
			
			//SF
			org.jsoup.nodes.Element statusEle=tdList.get(5);
			if(statusEle.children().size()==0){
				continue;
			}
			String cssClass=statusEle.select("div").attr("class");
			if(cssClass.equals("closed1")){ //未开售
				stopPlayList.add(MatchShowStatus.SFPASS);
				stopPlayList.add(MatchShowStatus.SFSINGLE);
			}else if(cssClass.equals("dan1")){//单关过关都开售
				
			}else if(cssClass.equals("kong1")){//过关开售
				stopPlayList.add(MatchShowStatus.SFSINGLE);
			}
			//RFSF
			
			statusEle=tdList.get(6);
			if(statusEle.children().size()==0){
				continue;
			}
			cssClass=statusEle.select("div").attr("class");
			if(cssClass.equals("closed1")){ //未开售
				stopPlayList.add(MatchShowStatus.RFSFPASS);
				stopPlayList.add(MatchShowStatus.RFSFSINGLE);
			}else if(cssClass.equals("dan1")){//单关过关都开售
				
			}else if(cssClass.equals("kong1")){//过关开售
				stopPlayList.add(MatchShowStatus.RFSFSINGLE);
			}
			
			
			//DXF
			statusEle=tdList.get(7);
			if(statusEle.children().size()==0){
				continue;
			}
			cssClass=statusEle.select("div").attr("class");
			if(cssClass.equals("closed1")){ //未开售
				stopPlayList.add(MatchShowStatus.DXFPASS);
				stopPlayList.add(MatchShowStatus.DXFSINGLE);
			}else if(cssClass.equals("dan1")){//单关过关都开售
				
			}else if(cssClass.equals("kong1")){//过关开售
				stopPlayList.add(MatchShowStatus.DXFSINGLE);
			}
			//SFC
			statusEle=tdList.get(8);
			if(statusEle.children().size()==0){
				continue;
			}
			cssClass=statusEle.select("div").attr("class");
			if(cssClass.equals("closed1")){ //未开售
				stopPlayList.add(MatchShowStatus.SFCPASS);
				stopPlayList.add(MatchShowStatus.SFCSINGLE);
			}else if(cssClass.equals("dan1")){//单关过关都开售
				
			}else if(cssClass.equals("kong1")){//过关开售
				stopPlayList.add(MatchShowStatus.SFCSINGLE);
			}
			
			String numberStr=tdList.get(0).text().trim();
			String	matchTime=tdList.get(3).text().trim();
			matchTime=matchTime.substring(5);
			Date resultDate = DateTools.strToDateDafueYear(matchTime);
			String weekStr = numberStr.substring(0, 2);
			int intTime=DateTools.handleIntTime(resultDate, weekStr);
			String key=intTime+"\1\1"+Integer.parseInt(numberStr.substring(2));
			
			
			List<MatchShowStatus> statusList = MatchShowStatus.getShowStatsuOrderList();
			for (int ii = 0; ii < stopPlayList.size(); ii++) {
				for(MatchShowStatus bb :MatchShowStatus.values()){
					if(bb==stopPlayList.get(ii)){
						statusList.remove(bb);
					}
				}
			}
			int show=0;
			for (MatchShowStatus fb : statusList) {
				show |= 1 << fb.getValue();
			}
			statusMap.put(key,show);
		}
		return statusMap;					
	}

}
