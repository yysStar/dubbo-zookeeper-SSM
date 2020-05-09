package com.qiyun.util;

import com.qiyun.httpUtil.HttpUtil;
import com.qiyun.model.FootballMatchBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.qiyun.tools.DateTools;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.LinkRegexFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.SimpleNodeIterator;

public class FbDcArrangeUtil {

	public static final String wbwOutIdUrl = "http://live.500.com/?expect=";
	//五百万单场开奖结果页面
	public static final String wbwDcMatchPrizeUrl="http://zx.500.com/zqdc/kaijiang.php?&expect=";
	public static final String wbwDcSfggMatchPrizeUrl="http://zx.500.com/zqdc/kaijiang.php?playid=6&expect=";
	public static final String dcPmUrl ="http://live.500.com/zqdc.php?e=";
	public static final String dcSfggPmUrl500 ="http://trade.500.com/bjdcsf/?expect=";
	public static final String dcSfggPmUrlCk ="http://www.310win.com/buy/DanChangSF.aspx?TypeID=11&issueNum=";
	public static final String jcPmUrl ="http://live.500.com/";
	public static final String sfcPmUrl ="http://live.500.com/zucai.php?e=";
	public static final String bqcPmUrl ="http://live.500.com/6chang.php?e=";
	public static final String jqsPmUrl ="http://live.500.com/4chang.php?e=";
	public static final String bqcOddsUrl = "http://odds.cailele.com/index.php?controller=bqodds&action=index&tp=4&qh=";
	public static final String dyjOutIdUrL = "http://odds.cailele.com/index.php?controller=bdodds&action=index&tp=5&qh=";
	public static final String outIdUrlFull = "http://live.500.com/2h1.php";
	public static final String outIdUrlAfter = "http://live.500.com/weekfixture.php";
	public static final String wbwDcBetInfoUrl= "http://zx.500.com/zqdc/touzhu.php?playid=1&&expect=";
	public static final String wbwDcBetRateUrl="http://odds.500.com/fenxi/shuju.php?show=2&r=1&id=";
	public static final String wbwJcBetInfoUrl= "http://zx.500.com/jczq/touzhu.php?d=";
	public static final String wbwSfcBetRateUrl="http://odds.500.com/fenxi/shuju.php?show=1&id=";
	public static final String taobaoDcBetInfoUrl= "http://caipiao.taobao.com/lottery/order/lottery_dcspf.htm";
	public static final String taobaoJcBetInfoUrl= "http://caipiao.taobao.com/lottery/order/lottery_jczq_spf.htm";
	public static final String aiCaipiaoDcLiveScoreUrl = "http://live.2caipiao.com/jsbf/timelyscore!dynamicMatchDataForBjdc.jhtml";
	public static final String aiCaipiaoJcLiveScoreUrl = "http://live.2caipiao.com/jsbf/timelyscore!dynamicMatchDataForJczq.jhtml";
	//大赢家单场地址需+期号.js
	public static final String daYingJiaDcLiveScoreUrl="http://live.cpdyj.com/cache/livebdjs";
	public static final String daYingJiaJcLiveScoreUrl="http://live.cpdyj.com/cache/livejcjs/";
	
	public static final String dcZsOpUrl = "http://www.zs310.com/bdmanage.do?method=olddata&param=";//单场抓取智胜网欧赔指数连接
	public static final String dcXywUrl = "http://www.gooooal.com/live/data/bd_match/bdspf.js?";//单场抓取雪缘网数据
	public static final String jcXywUrl = "http://caipiao.gooooal.com/issue/jzspf.lt?";//竞彩抓取雪缘网数据
	public static final String dc500wSpfUrl = "http://zc.trade.500.com/bjdc/?expect=";//500w单场胜平负连接
	public static final String jc500wSpfUrl = "http://zc.trade.500.com/jczq/?date=";//500w竞彩胜平负连接
	public static final String spf500wUrl = "http://live.500.com/zucai.php?e=";//500w胜平负连接
	
	public static final String LC_JCZQ ="http://live.wish.com/api/getzcxml?lotyid=6";
	public static final String LC_SFC ="http://live.wish.com/api/getzcxml?lotyid=1&qh=";//qh期号 空默认当前期
	public static final String LC_4JQS ="http://live.wish.com/api/getzcxml?lotyid=3&qh=";//qh期号
	public static final String LC_6BQC ="http://live.wish.com/api/getzcxml?lotyid=4&qh=";//qh期号
	
	public static final String LC_BJDC ="http://live.wish.com/api/getzcxml?lotyid=5&qh=";

	public static List<FootballMatchBean> get500wMatch(String url){
		return get500wMatch(url,null);
	}
	public static List<FootballMatchBean> get500wMatch(String url, String term){
		List<FootballMatchBean> list = new ArrayList<FootballMatchBean>();

		try{
			String content = HttpUtil.getUrl(url);
			Parser parser =Parser.createParser(content, "gbk");
			NodeFilter termSelectNodefilter = new HasAttributeFilter("value", term);
			NodeList terms= parser.extractAllNodesThatMatch(termSelectNodefilter);
			TagNode termNode=(TagNode)terms.elementAt(0);
			if(term!=null){
				if(termNode==null){
					return list;
				}else if("".equals(term.trim())&&!term.equals(termNode.getAttribute("value"))){
					return list;
				}
			}

			parser =Parser.createParser(content, "gbk");
			NodeFilter filter = new HasAttributeFilter("id", "table_match");
			NodeFilter trFilter=new TagNameFilter("tr");
			parser =Parser.createParser(content, "gbk");
			Node table=parser.extractAllNodesThatMatch(filter).elementAt(0);
			NodeFilter filterA = new TagNameFilter("A");
			if(table != null){
				NodeList nl = table.getChildren().extractAllNodesThatMatch(trFilter);
				for (int j = 1; j < nl.size(); j++) {
					FootballMatchBean fb = new FootballMatchBean();

					/************OddId************/
					NodeList str = nl.elementAt(j).getChildren();

					// 得到所有过滤后，想要的节点
					str = str.extractAllNodesThatMatch(filterA, true);
					if(str != null && !"".equals(str.toString().trim())){
//						NodeFilter filterXi=new LinkStringFilter("http://odds.500.com/fenxi/shuju");
						// 亚链接地址
//						String xiHref = ((Tag)nl).getAttribute("fid");
//						String outId = "";
//						Pattern pattern = Pattern.compile("(?:^|&|\\?|/)shuju-(\\d+)(?:&|$|-|.)");
//						Matcher matcher = pattern.matcher(xiHref);
//						if(matcher.find()){
//							outId = matcher.group(1);
//						}
						String outId=((Tag)nl.elementAt(j)).getAttribute("fid");
						/********MatchName********/
						NodeList nl1 = new NodeList();
						nl.elementAt(j).collectInto(nl1, new TagNameFilter("a"));

						String name = nl1.elementAt(0).toPlainTextString();
						name = name.replaceAll("(\\s)", "");
						/**********Home and guest************/
						NodeList nl2 = new NodeList();
						nl.elementAt(j).collectInto(nl2, new TagNameFilter("td"));
						String homeName = nl1.elementAt(1).toPlainTextString();
						String guestName = nl1.elementAt(5).toPlainTextString();

						/** ********MatchTime and MatchTimeStr*********** */
						String[] dateTimes = nl2.elementAt(3).toPlainTextString().split("&nbsp;| ");
						String date = "";
						String time = "";
						if(dateTimes != null && dateTimes.length>0){
							date = dateTimes[0];
							time = dateTimes[1];
						}
						String dateTime =  date +" "+ time;
						Date matchDate= DateTools.strToDateDafueYear(dateTime);
						dateTime=DateTools.dateToString(matchDate,"yyyy-MM-dd HH:mm");
						/** ****************status******************* */
						String status=nl2.elementAt(4).toPlainTextString();
						String matchKey=nl2.elementAt(0).toPlainTextString();
						/** ****************BfWhole******************* */
						String bf_Whole = "";
						if(!nl1.elementAt(2).toPlainTextString().equals("") || !nl1.elementAt(4).toPlainTextString().equals("")){
							bf_Whole = nl1.elementAt(2).toPlainTextString()+":"+nl1.elementAt(4).toPlainTextString();
						}


						/** ****************BfHalf******************* */
						String bf_Half = "";
						String[] bf_Halfs = nl2.elementAt(8).toPlainTextString().split("-");
						if(!bf_Halfs[0].trim().equals("") && !bf_Halfs[1].trim().equals("")){
							bf_Half = bf_Halfs[0].trim()+ ":" +bf_Halfs[1].trim();
						}

						/** ****************gameColor******************* */
						NodeList nl3 = new NodeList();

						nl.elementAt(j).collectInto(nl3, new AndFilter(new TagNameFilter("td"),
								new HasAttributeFilter("bgcolor")));
						String gameColor =((TableColumn) nl3.elementAt(0)).getAttribute("bgcolor");


						/** ****************homePm and guestPm******************* */
						NodeList nl4 = new NodeList();
						nl.elementAt(j).collectInto(nl4, new TagNameFilter("td"));

						NodeList nl5 = new NodeList();

						nl.elementAt(j).collectInto(nl5, new AndFilter(new TagNameFilter("span"),
								new HasAttributeFilter("class", "gray")));


						String homePm = nl5.elementAt(0).toPlainTextString();
						String guestPm = nl5.elementAt(1).toPlainTextString();


						if(homePm!=null && !homePm.equals("")){
							homePm = homePm.replace("[", "").replace("]", "");
						}

						if(guestPm!=null && !guestPm.equals("")){
							guestPm = guestPm.replace("[", "").replace("]", "");
						}
						if("-1".equals(guestPm)||"-1".equals(homePm)){
							continue;
						}

						/**********HomeId and guestId************/
						NodeList nl6 = new NodeList();
						nl.elementAt(j).collectInto(nl6, new TagNameFilter("a"));
						String homeNameHref = ((LinkTag) str.elementAt(1)).getAttribute("href");
						String guestNameHref = ((LinkTag) str.elementAt(5)).getAttribute("href");

						String homeNameId = "";
						homeNameId = homeNameHref.replaceAll("500\\.com|\\D", "");
						String guestNameId = "";
						guestNameId = guestNameHref.replaceAll("500\\.com|\\D", "");


						fb.setGuestId(guestNameId != null && !guestNameId.equals("") ? Integer.valueOf(guestNameId) : null);
						fb.setHomeId(homeNameId != null && !homeNameId.equals("") ? Integer.valueOf(homeNameId) : null);
						fb.setMatchName(name);
						fb.setOddId(outId);
						fb.setHome(homeName);
						fb.setGuest(guestName);
						fb.setMatchTime(DateTools.StringToDateShort(dateTime));
						fb.setMatchDateStr(DateTools.dateToString(matchDate,"yyyy-MM-dd"));
						fb.setBfHalf(bf_Half.trim());
						fb.setBfWhole(bf_Whole);
						fb.setGameColor(gameColor);
						fb.setHomePm(!homePm.equals("") ? String.valueOf(homePm) : null);
						fb.setGuestPm(!guestPm.equals("") ? String.valueOf(guestPm) : null);
						fb.setStatus(status);
						fb.setMatchKey(matchKey);

						list.add(fb);
					}
				}
			}
		}catch (Exception e) {
			LogUtil.error(e);
		}
		return list;
	}
	/**
	 * 获取500的足球oddsID
	 * @param url
	 * @return
	 */
	public static List<FootballMatchBean> getDcSfggMatchBy500(String url){
		List<FootballMatchBean> list=new ArrayList<FootballMatchBean>();
		String content = HttpUtil.getUrl(url);
		Parser parser =Parser.createParser(content, "gbk");
		String regex="(?:^|&|\\?|/)shuju-(\\d+)(?:&|$|-|.)";
		NodeFilter filter = new LinkRegexFilter(regex);
		NodeFilter tdFilter=new TagNameFilter("td");
		try {
			NodeList linkList=parser.extractAllNodesThatMatch(filter);
			for (SimpleNodeIterator iterator = linkList.elements(); iterator.hasMoreNodes();) {
				Node node=iterator.nextNode();
				Node trNode=node.getParent().getParent();
				NodeList nodeList=trNode.getChildren().extractAllNodesThatMatch(tdFilter);
				if(nodeList.size()!=0){
					FootballMatchBean bean=new FootballMatchBean();
					String matchKey=nodeList.elementAt(0).toPlainTextString().trim();
					String projectName=nodeList.elementAt(1).toPlainTextString().trim();
					if(!"足球".equals(projectName)){
						continue;
					}
					Tag tag=(Tag) node;
					String href=tag.getAttribute("href");
					String outId = "";
					Pattern pattern = Pattern.compile(regex);
					Matcher matcher = pattern.matcher(href);
					if(matcher.find()){
						outId = matcher.group(1);
					}
					bean.setMatchKey(matchKey);
					bean.setOddId(outId);
					list.add(bean);
				}
			}
		} catch (ParserException e) {
			LogUtil.error(e);
		}
		return list;
	}

}
