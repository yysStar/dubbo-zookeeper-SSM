package com.qiyun.builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.httpUtil.WebConstants;
import com.qiyun.lottery.LotteryPlan;
import com.qiyun.model.FreeMarker;
import com.qiyun.model.LotteryTerm;
import com.qiyun.model.basketball.BasketBallMatch;
import com.qiyun.model.football.FootBallMatch;
import com.qiyun.service.*;
import com.qiyun.status.PublicStatus;
import com.qiyun.tools.DateTools;
import com.qiyun.tools.StringTools;
import com.qiyun.util.LogUtil;
import com.qiyun.utils.FileTools;
import net.sf.json.JSONException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;

public class IndexInfoBuilder{
	
	private List<String> xmlList = null;
	
	private List<String> xmlListV4 = null;
	@Autowired
	private LotteryTermService lotteryTermService;
	@Autowired
	private LotteryPlanService lotteryPlanService;
	@Autowired
	private FootBallService footBallService;
//	@Autowired
//	private BasketBetService basketService;
	@Autowired
	private BasketBallMatchService basketBallMatchService;
	
	public void make(LotteryType lotteryType){
		try {
			LogUtil.info("*********首页所有最新开奖统计更新开始****************");
			StringBuffer sb = new StringBuffer();
			StringBuffer sbNew = new StringBuffer();
			StringBuffer sbszbkj=new StringBuffer();//数字彩报
			StringBuffer strHm=new StringBuffer();
			//StringBuffer sbP5Award=new StringBuffer();//排列五加奖开奖信息
			StringBuffer sbV4 = new StringBuffer(); // 新版最新开奖
			
			List list = getXmlList();
			System.out.println(list);
			if(getXmlList() != null && getXmlList().contains(lotteryType.getValue()+"")) {
				for(String type: xmlList){
					LotteryType lotType = LotteryType.getItem(Integer.parseInt(type));
					LotteryTerm lotteryTerm = lotteryTermService.findOpenResultByLotteryType(lotType);
					
					sb.append(buildHtml(lotType,lotteryTerm,"1"));
					strHm.append(buildHtml(lotType,lotteryTerm,"2"));
					
					sbNew.append(buildHtmlNew(lotType,lotteryTerm,"1")); //新版
					sbszbkj.append(buildHtmlSzcb(lotType,lotteryTerm,"1")); //数字彩报
//					sbP5Award.append(buildHtmlP5Award(lotType,lotteryTerm));
				}
				
				FileTools.setFileContent(sb.toString(), WebConstants.getWebPath() + "/static/indexhome/indexAllOpenResultDiv.shtml" );
				FileTools.setFileContent(strHm.toString(), WebConstants.getWebPath() + "/static/indexhome/indexAllOpenResultDivHm.shtml" );
				
				FileTools.setFileContent(sbNew.toString(), WebConstants.getWebPath() + "/static/indexhome/indexAllOpenResultDivNew.shtml" );//新版
				FileTools.setFileContent(sbszbkj.toString(), WebConstants.getWebPath() + "/static/indexhome/indexAllOpenResultDivNewDigital.shtml" );//数字彩报
				//FileTools.setFileContent(sbP5Award.toString(), WebConstants.getWebPath() + "/static/indexhome/indexAllOpenResultDivNewP5Award.shtml" );//排列五加奖开奖信息
			}
			
			// 新版最新开奖
			if (getXmlListV4() != null && getXmlListV4().contains(lotteryType.getValue()+"")) {
				
			}
			
			xmlListV4.add("4");
			for(String type : xmlListV4) {
				LotteryType lotType = LotteryType.getItem(Integer.parseInt(type));
				LotteryTerm lotteryTerm = lotteryTermService.findOpenResultByLotteryType(lotType);
				sbV4.append(buildHtmlV4(lotType, lotteryTerm));
			}
			FileTools.setFileContent(sbV4.toString(), WebConstants.getWebPath() + "/static/indexhome/indexAllOpenResultDiv_v4.shtml");
			
			// 足球开奖
			if (LotteryType.JCZQList.contains(lotteryType)) {
				// 生成竞彩足球最新开奖静态页面
				buildFbNewlyPrizeHtml();
			}

			LogUtil.info("*********首页所有最新开奖统计更新结束*********");
		} catch (Exception e) {
			LogUtil.error("*********首页所有最新开奖统计更新发送错误*********",e);
		}
	}
	
	
	
	private String buildHtmlSzcb(LotteryType lotteryType, LotteryTerm openTerm,String type) throws JSONException {
		//type 1主站 2合作网站
		//参数 开奖历史记录，由主站跟全作网站的区别
		StringBuffer sb = new StringBuffer();
		if(lotteryType.getValue() == LotteryType.SSQ.getValue() && openTerm !=null){
			String[] result = openTerm.getResult().split(",");
			String html = "<i>";
			
			for (int i = 0; i < 6; i++) {
				html += result[i]+"&nbsp; ";
			}
			html += "</i><em>&nbsp; "+result[6]+"</em>";
			if(result.length > 7){
				html += "</i><em>&nbsp; "+result[7]+"</em>";
			}
			double aa=Double.parseDouble(openTerm.getAwardPool());
			BigDecimal beichushu=new BigDecimal(aa);
			BigDecimal chushu=new BigDecimal(100000000);
			BigDecimal awardPool=beichushu.divide(chushu);//MathConText(4)
			awardPool=awardPool.setScale(2, BigDecimal.ROUND_HALF_UP);
			sb.append("<li class='bg'>"+
                    	"<table>"+
                        	"<colgroup>"+
                            	"<col width='30%' />"+
                                "<col width='30%' />"+
                                "<col width='40%' />"+
                            "</colgroup>"+
                        	"<tr><td>双色球</td><td>" + openTerm.getTerm() + "期</td><td style='text-align:right'>"+DateTools.dateToString(openTerm.getOpenDateTime(), "MM/dd") +""+DateTools.getWeekStr2(openTerm.getOpenDateTime(),DateTools.week)+"</td></tr>"+
                            "<tr><td colspan='2'>"+html+"</td><td style='text-align:right'><b>奖池：</b>"+awardPool+"亿元</td></tr>"+
                        "</table>"+
                    "</li>");
		}else if(lotteryType.getValue() == LotteryType.DLT.getValue() && openTerm !=null){
			String[] result = openTerm.getResult().split(",");
			String html = "<i>";
			for (int i = 0; i < 5; i++) {
				html += result[i]+"&nbsp; ";
			}
			html += "</i><em>&nbsp; "+result[5];
			html += "&nbsp; "+result[6]+"</em>";
			
			double aa=Double.parseDouble(openTerm.getAwardPool());
			BigDecimal beichushu=new BigDecimal(aa);
			BigDecimal chushu=new BigDecimal(100000000);
			BigDecimal awardPool=beichushu.divide(chushu);//MathConText(4)
			awardPool=awardPool.setScale(2, BigDecimal.ROUND_HALF_UP);
			sb.append("<li class='bg'>"+
                	"<table>"+
                    	"<colgroup>"+
                        	"<col width='30%' />"+
                            "<col width='30%' />"+
                            "<col width='40%' />"+
                        "</colgroup>"+
                    	"<tr><td>大乐透</td><td>" + openTerm.getTerm() + "期</td><td style='text-align:right'>"+DateTools.dateToString(openTerm.getOpenDateTime(), "MM/dd") +""+DateTools.getWeekStr2(openTerm.getOpenDateTime(),DateTools.week)+"</td></tr>"+
                        "<tr><td colspan='2'>"+html+"</td><td style='text-align:right'><b>奖池：</b>"+awardPool+"亿元</td></tr>"+
                    "</table>"+
                "</li>");
			
		}else if(lotteryType.getValue() == LotteryType.FC3D.getValue() && openTerm !=null){
			String[] result = openTerm.getResult().split(",");
			String html = "<i>";
			for (int i = 0; i < result.length; i++) {
				html += result[i]+"&nbsp;";
			}
			html +="</i>";
			sb.append("<li>"+
                    "<table>"+
                       	"<colgroup>"+
                           	"<col width='30%' />"+
                               "<col width='30%' />"+
                               "<col width='40%' />"+
                           "</colgroup>"+
                       	"<tr><td>福彩3D</td><td>"+ openTerm.getTerm() +"期</td><td style='text-align:right'>"+DateTools.dateToString(openTerm.getOpenDateTime(), "MM/dd") +""+DateTools.getWeekStr2(openTerm.getOpenDateTime(),DateTools.week)+"</td></tr>"+
                           "<tr><td colspan='2'>"+html+"<span><b><a href='http://kjh.wish.com/kj_3d_sjh.shtml' class='tryNum' style='color: #000;' target='_blank'>试机号:</a></b><div style='display: inline;' id='openfcsjh' style='color: #000;'><b></b></div></span></td><td style='text-align:right'></td></tr>"+
                       "</table>"+
                  "</li>");
			
		}else if(lotteryType.getValue() == LotteryType.PL5.getValue() && openTerm !=null){
			String[] result = openTerm.getResult().split(",");
			String html = "<i>";
			for (int i = 0; i < 3; i++) {
				html += result[i]+"&nbsp";
			}
			html += "</i><em>&nbsp"+result[3]+"&nbsp";
			html += result[4]+"</em>";
			sb.append("<li>"+
                    "<table>"+
                       	"<colgroup>"+
                           	"<col width='30%' />"+
                               "<col width='30%' />"+
                               "<col width='40%' />"+
                           "</colgroup>"+
                       	"<tr><td>排列三/五</td><td>"+ openTerm.getTerm() +"期</td><td style='text-align:right'>"+DateTools.dateToString(openTerm.getOpenDateTime(), "MM/dd") +""+DateTools.getWeekStr2(openTerm.getOpenDateTime(),DateTools.week)+"</td></tr>"+
                           "<tr><td colspan='2'>"+html+"<span><b><a href='http://kjh.wish.com/kj_p3_sjh.shtml' class='tryNum' style='color: #000;' target='_blank'>试机号:</a></b><div style='display: inline;' id='openp3sjh' style='color: #000;'><b></b></div></span></td><td style='text-align:right'></td></tr>"+
                       "</table>"+
                  "</li>");
		}
		return sb.toString();
	}
	
	private String buildHtml(LotteryType lotteryType, LotteryTerm openTerm, String type) throws JSONException{
		//type 1主站 2合作网站
		//参数 开奖历史记录，由主站跟全作网站的区别
		String ssqDetail="http://kjh.wish.com/history_ssq.aspx";
		String dltDetail="http://kjh.wish.com/history_dlt.aspx";
		String p3Detail="http://kjh.wish.com/history_p3.aspx";
		String sfcDetail="http://kjh.wish.com/kj_sports.aspx";
		String qxcDetail="http://kjh.wish.com/history_qxc.aspx";
		String p5Detail="http://kjh.wish.com/history_p5.aspx";
		String qlcDetail="http://kjh.wish.com/history_qlc.aspx";
		String x155Detail="http://kjh.wish.com/history_x155.aspx";
		String hc1Detail="http://kjh.wish.com/history_hc1.aspx";
		String sdDetail="http://kjh.wish.com/history_sd.aspx";
		if("2".equals(type)){
		   ssqDetail="/lottery/opendraw/sceqdetail.shtml";
		   dltDetail="/lottery/opendraw/dltdetail.shtml";
		   p3Detail="/lottery/opendraw/p3detail.shtml";
		   p5Detail="/lottery/opendraw/p5detail.shtml";
		   qxcDetail="/lottery/opendraw/qxcdetail.shtml";
		   qlcDetail="/lottery/opendraw/qlcdetail.shtml";
		   hc1Detail="/lottery/opendraw/hc1detail.shtml";
		   x155Detail="/lottery/opendraw/11x5detail.shtml";
		   sfcDetail="/lottery/fbsfc/fbsfcdehistory.shtml";
		   sdDetail="/lottery/opendraw/3ddetail.shtml";
		}
			   
		StringBuffer sb = new StringBuffer();
		
		if(lotteryType.getValue() == LotteryType.SSQ.getValue() && openTerm !=null){
			String[] result = openTerm.getResult().split(",");
			String html = "";

			for (int i = 0; i < 6; i++) {
				html += "<b class='red'>"+result[i]+"</b>";
			}
			html += "<b class='blue'>"+result[6]+"</b>";
			
			sb.append("<li onmouseover=\"this.className='hover'\" onmouseout=\"this.className=''\"><span><label class='l'>" +
					"双色球 <b id='ssqTermInfo'><b>" + openTerm.getTerm() + "</b></b>期</label><label id='ssqOpenTime'>" +
							""+"\u5f00\u5956:"+DateTools.dateToString(openTerm.getOpenDateTime(), "yyyy-MM-dd HH:mm:ss").substring(5, 16)+" " + 
							DateTools.getWeekStr2(openTerm.getOpenDateTime(),DateTools.week2)+"</label></span><span>" +
					"<label class='num'>"+ html +"</label><label>" +
					"<a target='_blank' class='orangeBuyBtn' href='/lottery/ssq/' title='点击购买'>购买</a><a href='"+ssqDetail+"'" +
					" target='_blank' class='history' title='查看历史开奖结果'>历史</a></label></span></li>");
		}else if(lotteryType.getValue() == LotteryType.DLT.getValue() && openTerm !=null){
			String[] result = openTerm.getResult().split(",");
			String html = "";

			for (int i = 0; i < 5; i++) {
				html += "<b class='red'>"+result[i]+"</b>";
			}
			html += "<b class='blue'>"+result[5]+"</b>";
			html += "<b class='blue'>"+result[6]+"</b>";
			sb.append("<li onmouseover=\"this.className='hover'\" onmouseout=\"this.className=''\"><span><label class='l'>" +
					"大乐透 <b id='dltTermInfo'><b>"+ openTerm.getTerm() +"</b></b>期</label><label id='dltOpenTime'>" +
							""+"\u5f00\u5956:"+DateTools.dateToString(openTerm.getOpenDateTime(), "yyyy-MM-dd HH:mm:ss").substring(5, 16)+" " + 
							DateTools.getWeekStr2(openTerm.getOpenDateTime(),DateTools.week2)+"</label></span><span>" +
					"<label class='num'>"+ html +"</label><label>" +
					"<a target='_blank' class='orangeBuyBtn' href='/lottery/dlt/' title='点击购买'>购买</a><a href='"+dltDetail+"'" +
					" target='_blank' class='history' title='查看历史开奖结果'>历史</a></label></span></li>");
		}else if(lotteryType.getValue() == LotteryType.FC3D.getValue() && openTerm !=null){
			String[] result = openTerm.getResult().split(",");
			String html = "";

			for (int i = 0; i < result.length; i++) {
				html += "<b>"+result[i]+"</b>";
			}
			
			sb.append("<li onmouseover=\"this.className='hover'\" onmouseout=\"this.className=''\"><span><label class='l'>" +
					"福彩3D <b id='sdTermInfo'><b>"+ openTerm.getTerm() +"</b></b>期</label><label id='sdOpenTime'>" +
							""+"\u5f00\u5956:"+DateTools.dateToString(openTerm.getOpenDateTime(), "yyyy-MM-dd HH:mm:ss").substring(5, 16)+" " + 
							DateTools.getWeekStr2(openTerm.getOpenDateTime(),DateTools.week2)+"</label></span><span><label class='num'>");
			
			if("1".equals(type)){
				sb.append("<a href='http://kjh.wish.com/kj_3d_sjh.shtml' class='tryNum' target='_blank'>试机号</a>");
			}
					
			sb.append(html +"</label><label><a target='_blank' class='orangeBuyBtn' href='/lottery/3d/' title='点击购买'>购买</a><a href='"+sdDetail+"'" +
					" target='_blank' class='history' title='查看历史开奖结果'>历史</a></label></span></li>");
			
		}else if(lotteryType.getValue() == LotteryType.PL3.getValue() && openTerm !=null){
			String[] result = openTerm.getResult().split(",");
			String html = "";

			for (int i = 0; i < result.length; i++) {
				html += "<b>"+result[i]+"</b>";
			}
			
			sb.append("<li onmouseover=\"this.className='hover'\" onmouseout=\"this.className=''\"><span><label class='l'>" +
					"排列三 <b id='psTermInfo'><b>"+ openTerm.getTerm() +"</b></b>期</label><label id='psOpenTime'>" +
							""+"\u5f00\u5956:"+DateTools.dateToString(openTerm.getOpenDateTime(), "yyyy-MM-dd HH:mm:ss").substring(5, 16)+" " + 
							DateTools.getWeekStr2(openTerm.getOpenDateTime(),DateTools.week2)+"</label></span><span><label class='num'>");
			
			if("1".equals(type)){
				sb.append("<a href='http://kjh.wish.com/kj_p3_sjh.shtml' class='tryNum' target='_blank'>试机号</a>");
			}
			
			sb.append(html +"</label><label><a target='_blank' class='orangeBuyBtn' href='/lottery/p3/' title='点击购买'>购买</a><a href='"+p3Detail+"'" +
					" target='_blank' class='history' title='查看历史开奖结果'>历史</a></label></span></li>");

		}else if(lotteryType.getValue() == LotteryType.QXC.getValue() && openTerm !=null){
			String[] result = openTerm.getResult().split(",");
			String html = "";

			for (int i = 0; i < result.length; i++) {
				html += "<b>"+result[i]+"</b>";
			}
			
			sb.append("<li onmouseover=\"this.className='hover'\" onmouseout=\"this.className=''\"><span><label class='l'>" +
					"七星彩 <b id='qxcTermInfo'><b>"+ openTerm.getTerm() +"</b></b>期</label><label id='qxcOpenTime'>" +
							""+"\u5f00\u5956:"+DateTools.dateToString(openTerm.getOpenDateTime(), "yyyy-MM-dd HH:mm:ss").substring(5, 16)+" " + 
							DateTools.getWeekStr2(openTerm.getOpenDateTime(),DateTools.week2)+"</label></span><span>" +
					"<label class='num'>"+ html +"</label><label>" +
					"<a target='_blank' class='orangeBuyBtn' href='/lottery/qxc/' title='点击购买'>购买</a><a href='"+qxcDetail+"'" +
					" target='_blank' class='history' title='查看历史开奖结果'>历史</a></label></span></li>");
			
		}else if(lotteryType.getValue() == LotteryType.PL5.getValue() && openTerm !=null){
			String[] result = openTerm.getResult().split(",");
			String html = "";

			for (int i = 0; i < result.length; i++) {
				html += "<b>"+result[i]+"</b>";
			}
			
			sb.append("<li onmouseover=\"this.className='hover'\" onmouseout=\"this.className=''\"><span><label class='l'>" +
					"排列五 <b id='pwTermInfo'><b>"+ openTerm.getTerm() +"</b></b>期</label><label id='pwOpenTime'>" +
							""+"\u5f00\u5956:"+DateTools.dateToString(openTerm.getOpenDateTime(), "yyyy-MM-dd HH:mm:ss").substring(5, 16)+" " + 
							DateTools.getWeekStr2(openTerm.getOpenDateTime(),DateTools.week2)+"</label></span><span>" +
					"<label class='num'>"+ html +"</label><label>" +
					"<a target='_blank' class='orangeBuyBtn' href='/lottery/p5/' title='点击购买'>购买</a><a href='"+p5Detail+"'" +
					" target='_blank' class='history' title='查看历史开奖结果'>历史</a></label></span></li>");
			
		}else if(lotteryType.getValue() == LotteryType.QLC.getValue() && openTerm !=null){
			String[] result = openTerm.getResult().split(",");
			String html = "";

			for (int i = 0; i < 7; i++) {
				html += "<b>"+result[i]+"</b>";
			}
			html += "<b class='blue'>"+result[7]+"</b>";
			
			sb.append("<li onmouseover=\"this.className='hover'\" onmouseout=\"this.className=''\"><span><label class='l'>" +
					"七乐彩 <b id='qlcTermInfo'><b>"+ openTerm.getTerm() +"</b></b>期</label><label id='qlcOpenTime'>" +
							""+"\u5f00\u5956:"+DateTools.dateToString(openTerm.getOpenDateTime(), "yyyy-MM-dd HH:mm:ss").substring(5, 16)+" " + 
							DateTools.getWeekStr2(openTerm.getOpenDateTime(),DateTools.week2)+"</label></span><span>" +
					"<label class='num'>"+ html +"</label><label>" +
					"<a target='_blank' class='orangeBuyBtn' href='/lottery/qlc/' title='点击购买'>购买</a><a href='"+qlcDetail+"'" +
					" target='_blank' class='history' title='查看历史开奖结果'>历史</a></label></span></li>");
			
		}
		
		return sb.toString();
	}
	
	private String buildHtmlNew(LotteryType lotteryType, LotteryTerm openTerm,String type) throws JSONException{
		//type 1主站 2合作网站
		//参数 开奖历史记录，由主站跟全作网站的区别
		String ssqDetail="http://kjh.wish.com/history_ssq.aspx";
		String dltDetail="http://kjh.wish.com/history_dlt.aspx";
		String p3Detail="http://kjh.wish.com/history_p3.aspx";
		String sfcDetail="http://kjh.wish.com/kj_sports.aspx";
		String qxcDetail="http://kjh.wish.com/history_qxc.aspx";
		String p5Detail="http://kjh.wish.com/history_p5.aspx";
		String qlcDetail="http://kjh.wish.com/history_qlc.aspx";
		String x155Detail="http://kjh.wish.com/history_x155.aspx";
		String hc1Detail="http://kjh.wish.com/history_hc1.aspx";
		String sdDetail="http://kjh.wish.com/history_sd.aspx";
		if("2".equals(type)){
		   ssqDetail="/lottery/opendraw/sceqdetail.shtml";
		   dltDetail="/lottery/opendraw/dltdetail.shtml";
		   p3Detail="/lottery/opendraw/p3detail.shtml";
		   p5Detail="/lottery/opendraw/p5detail.shtml";
		   qxcDetail="/lottery/opendraw/qxcdetail.shtml";
		   qlcDetail="/lottery/opendraw/qlcdetail.shtml";
		   hc1Detail="/lottery/opendraw/hc1detail.shtml";
		   x155Detail="/lottery/opendraw/11x5detail.shtml";
		   sfcDetail="/lottery/fbsfc/fbsfcdehistory.shtml";
		   sdDetail="/lottery/opendraw/3ddetail.shtml";
		}
			   
		StringBuffer sb = new StringBuffer();
		
		if(lotteryType.getValue() == LotteryType.SSQ.getValue() && openTerm !=null){
			String[] result = openTerm.getResult().split(",");
			String html = "";

			for (int i = 0; i < 6; i++) {
				html += "<b class='red'>"+result[i]+"</b>";
			}
			html += "<b class='blue'>"+result[6]+"</b>";
			if(result.length > 7){
				html += "<b class='blue'>"+result[7]+"</b>";
			}
			sb.append("<li><span><label class='l'>" +
					"双色球 <b id='ssqTermInfo'><b>" + openTerm.getTerm() + "</b></b>期</label><label id='ssqOpenTime'>" +
							DateTools.dateToString(openTerm.getOpenDateTime(), "MM/dd") +" " + 
							DateTools.getWeekStr2(openTerm.getOpenDateTime(),DateTools.week)+"</label></span><span>" +
					"<label class='num'>"+ html +"</label><label>" +
					"<a target='_blank' class='orangeBuyBtn' href='/lottery/ssq/' title='点击购买'>购买</a><a href='"+ssqDetail+"'" +
					" target='_blank' class='history' title='查看历史开奖结果'>历史</a></label></span></li>");
		}else if(lotteryType.getValue() == LotteryType.DLT.getValue() && openTerm !=null){
			String[] result = openTerm.getResult().split(",");
			String html = "";

			for (int i = 0; i < 5; i++) {
				html += "<b class='red'>"+result[i]+"</b>";
			}
			html += "<b class='blue'>"+result[5]+"</b>";
			html += "<b class='blue'>"+result[6]+"</b>";
			
			sb.append("<li><span><label class='l'>" +
					"大乐透 <b id='dltTermInfo'><b>"+ openTerm.getTerm() +"</b></b>期</label><label id='dltOpenTime'>" +
							DateTools.dateToString(openTerm.getOpenDateTime(), "MM/dd") +" " + 
							DateTools.getWeekStr2(openTerm.getOpenDateTime(),DateTools.week)+"</label></span><span>" +
					"<label class='num'>"+ html +"</label><label>" +
					"<a target='_blank' class='orangeBuyBtn' href='/lottery/dlt/' title='点击购买'>购买</a><a href='"+dltDetail+"'" +
					" target='_blank' class='history' title='查看历史开奖结果'>历史</a></label></span></li>");
		}else if(lotteryType.getValue() == LotteryType.FC3D.getValue() && openTerm !=null){
			String[] result = openTerm.getResult().split(",");
			String html = "";

			for (int i = 0; i < result.length; i++) {
				html += "<b>"+result[i]+"</b>";
			}
			
			sb.append("<li><span><label class='l'>" +
					"福彩3D <b id='sdTermInfo'><b>"+ openTerm.getTerm() +"</b></b>期</label><label id='sdOpenTime'>" +
							DateTools.dateToString(openTerm.getOpenDateTime(), "MM/dd") +" " + 
							DateTools.getWeekStr2(openTerm.getOpenDateTime(),DateTools.week)+"</label></span><span><label class='num'>");
			
			if("1".equals(type)){
				sb.append("<a href='http://kjh.wish.com/kj_3d_sjh.shtml' class='tryNum' target='_blank'>试机号</a>");
			}
					
			sb.append(html +"</label><label><a target='_blank' class='orangeBuyBtn' href='/lottery/3d/' title='点击购买'>购买</a><a href='"+sdDetail+"'" +
					" target='_blank' class='history' title='查看历史开奖结果'>历史</a></label></span></li>");
			
		}else if(lotteryType.getValue() == LotteryType.PL3.getValue() && openTerm !=null){
			String[] result = openTerm.getResult().split(",");
			String html = "";

			for (int i = 0; i < result.length; i++) {
				html += "<b>"+result[i]+"</b>";
			}
			
			sb.append("<li><span><label class='l'>" +
					"排列三 <b id='psTermInfo'><b>"+ openTerm.getTerm() +"</b></b>期</label><label id='psOpenTime'>" +
							DateTools.dateToString(openTerm.getOpenDateTime(), "MM/dd") +" " + 
							DateTools.getWeekStr2(openTerm.getOpenDateTime(),DateTools.week)+"</label></span><span><label class='num'>");
			
			if("1".equals(type)){
				sb.append("<a href='http://kjh.wish.com/kj_p3_sjh.shtml' class='tryNum' target='_blank'>试机号</a>");
			}
			
			sb.append(html +"</label><label><a target='_blank' class='orangeBuyBtn' href='/lottery/p3/' title='点击购买'>购买</a><a href='"+p3Detail+"'" +
					" target='_blank' class='history' title='查看历史开奖结果'>历史</a></label></span></li>");

		}else if(lotteryType.getValue() == LotteryType.QXC.getValue() && openTerm !=null){
			String[] result = openTerm.getResult().split(",");
			String html = "";

			for (int i = 0; i < result.length; i++) {
				html += "<b>"+result[i]+"</b>";
			}
			
			sb.append("<li><span><label class='l'>" +
					"七星彩 <b id='qxcTermInfo'><b>"+ openTerm.getTerm() +"</b></b>期</label><label id='qxcOpenTime'>" +
							DateTools.dateToString(openTerm.getOpenDateTime(), "MM/dd") +" " + 
							DateTools.getWeekStr2(openTerm.getOpenDateTime(),DateTools.week)+"</label></span><span>" +
					"<label class='num'>"+ html +"</label><label>" +
					"<a target='_blank' class='orangeBuyBtn' href='/lottery/qxc/' title='点击购买'>购买</a><a href='"+qxcDetail+"'" +
					" target='_blank' class='history' title='查看历史开奖结果'>历史</a></label></span></li>");
			
		}else if(lotteryType.getValue() == LotteryType.PL5.getValue() && openTerm !=null){
			String[] result = openTerm.getResult().split(",");
			String html = "";

			for (int i = 0; i < result.length; i++) {
				html += "<b>"+result[i]+"</b>";
			}
			
			sb.append("<li><span><label class='l'>" +
					"排列五 <b id='pwTermInfo'><b>"+ openTerm.getTerm() +"</b></b>期</label><label id='pwOpenTime'>" +
							DateTools.dateToString(openTerm.getOpenDateTime(), "MM/dd") +" " + 
							DateTools.getWeekStr2(openTerm.getOpenDateTime(),DateTools.week)+"</label></span><span>" +
					"<label class='num'>"+ html +"</label><label>" +
					"<a target='_blank' class='orangeBuyBtn' href='/lottery/p5/' title='点击购买'>购买</a><a href='"+p5Detail+"'" +
					" target='_blank' class='history' title='查看历史开奖结果'>历史</a></label></span></li>");
			
		}else if(lotteryType.getValue() == LotteryType.QLC.getValue() && openTerm !=null){
			String[] result = openTerm.getResult().split(",");
			String html = "";

			for (int i = 0; i < 7; i++) {
				html += "<b>"+result[i]+"</b>";
			}
			html += "<b class='blue'>"+result[7]+"</b>";
			
			sb.append("<li><span><label class='l'>" +
					"七乐彩 <b id='qlcTermInfo'><b>"+ openTerm.getTerm() +"</b></b>期</label><label id='qlcOpenTime'>" +
							DateTools.dateToString(openTerm.getOpenDateTime(), "MM/dd") +" " + 
							DateTools.getWeekStr2(openTerm.getOpenDateTime(),DateTools.week)+"</label></span><span>" +
					"<label class='num'>"+ html +"</label><label>" +
					"<a target='_blank' class='orangeBuyBtn' href='/lottery/qlc/' title='点击购买'>购买</a><a href='"+qlcDetail+"'" +
					" target='_blank' class='history' title='查看历史开奖结果'>历史</a></label></span></li>");
			
		}
		
		return sb.toString();
	}
	
	/**
	 * <p>新版最新开奖</p>
	 * @param lotteryType LotteryType
	 * @param openTerm LotteryTerm
	 * @return String
	 * @throws JSONException
	 */
	private String buildHtmlV4(LotteryType lotteryType, LotteryTerm openTerm) throws JSONException {
		// 详情
		String ssqDetail = "/announcement/digitalLottery.php?lotteryType=100";
		String dltDetail = "/announcement/digitalLottery.php?lotteryType=1";
		String sdDetail = "/announcement/digitalLottery.php?lotteryType=102";
		String p3Detail = "/announcement/digitalLottery.php?lotteryType=3";
		String p5Detail = "/announcement/digitalLottery.php?lotteryType=4";
	    
		StringBuffer sb = new StringBuffer();
		/** 双色球 **/
		if (lotteryType.getValue() == LotteryType.SSQ.getValue() && openTerm != null) {
			String[] result = openTerm.getResult().split(",");
			String html = "";

			for (int i = 0; i < 6; i++) {
				html += "<div class='red'><em class='num'>" + result[i] + "</em></div>";
			}
			html += "<div class='blue'><em class='num'>" + result[6] + "</em></div>";
			if(result.length > 7){
				html += "<div class='blue'><em class='num'>" + result[7] + "</em></div>";
			}
			
			sb.append("<li><div class='lotinfo'><span class='l'><em class='type'>双色球</em>" +
					"<em id='ssqTermInfo' class='period'>" + openTerm.getTerm() + "</em></span></div><div class='lotresult'>" +
					"<div class='lotresult-left'>"+ html +"</div>" +
					"<a href='" + ssqDetail + "' target='_blank' class='lotresult-detail'><img src='/images/index/detail_btn.png' width='100%'></a></div></li>");
			/** 大乐透 **/
		} else if (lotteryType.getValue() == LotteryType.DLT.getValue() && openTerm != null) {
			String[] result = openTerm.getResult().split(",");
			String html = "";
            
			for (int i = 0; i < 5; i++) {
				html += "<div class='red'><em class='num'>" + result[i] + "</em></div>";
			}
			html += "<div class='blue'><em class='num'>" + result[5] + "</em></div>";
			html += "<div class='blue'><em class='num'>" + result[6] + "</em></div>";
			
			sb.append("<li><div class='lotinfo'><span class='l'><em class='type'>大乐透</em>" +
					"<em id='dltTermInfo' class='period'>" + openTerm.getTerm() + "</em></span></div><div class='lotresult'>" +
					"<div class='lotresult-left'>"+ html +"</div>" +
					"<a href='" + dltDetail + "' target='_blank' class='lotresult-detail'><img src='/images/index/detail_btn.png' width='100%'></a></div></li>");
			/** 3D **/
		} else if (lotteryType.getValue() == LotteryType.FC3D.getValue() && openTerm != null) {
			String[] result = openTerm.getResult().split(",");
			String html = "";

			for (int i = 0; i < result.length; i++) {
				html += "<div class='red'><em class='num'>" + result[i] + "</em></div>";
			}
			
			sb.append("<li><div class='lotinfo'><span class='l'><em class='type'>福彩3D</em>" +
					"<em id='sdTermInfo' class='period'>" + openTerm.getTerm() + "</em></span></div><div class='lotresult'>");
			
			sb.append("<div class='lotresult-left'>"+ html +"</div>");
			sb.append("<a href='" + sdDetail + "' target='_blank' class='lotresult-detail'><img src='/images/index/detail_btn.png' width='100%'></a></div></li>");
		/*排列三*/
		} else if (lotteryType.getValue() == LotteryType.PL3.getValue() && openTerm != null) {
			String[] result = openTerm.getResult().split(",");
			String html = "";
            
			for (int i = 0; i < result.length; i++) {
				html += "<div class='red'><em class='num'>" + result[i] + "</em></div>";
			}
			
			sb.append("<li><div class='lotinfo'><span class='l'><em class='type'>排列三</em>" +
					"<em id='psTermInfo' class='period'>" + openTerm.getTerm() + "</em></span></div><div class='lotresult'>");
			
			sb.append("<div class='lotresult-left'>"+ html +"</div>");
			sb.append("<a href='" + p3Detail + "' target='_blank' class='lotresult-detail'><img src='/images/index/detail_btn.png' width='100%'></a></div></li>");
			/* 排列五 */
		}  else if (lotteryType.getValue() == LotteryType.PL5.getValue() && openTerm != null) {
			String[] result = openTerm.getResult().split(",");
			String html = "";
            
			for (int i = 0; i < result.length; i++) {
				html += "<div class='red'><em class='num'>" + result[i] + "</em></div>";
			}
			
			sb.append("<li><div class='lotinfo'><span class='l'><em class='type'>排列五</em>" +
					"<em id='psTermInfo' class='period'>" + openTerm.getTerm() + "</em></span></div><div class='lotresult'>");
			
			sb.append("<div class='lotresult-left'>"+ html +"</div>");
			sb.append("<a href='" + p5Detail + "' target='_blank' class='lotresult-detail'><img src='/images/index/detail_btn.png' width='100%'></a></div></li>");
		}
		
		return sb.toString();
	}
	
	//排列五加奖活动的开奖信息生成
	private  String buildHtmlP5Award(LotteryType lotteryType,LotteryTerm openTerm){
		StringBuffer sb=new StringBuffer();
		if(lotteryType.getValue()==LotteryType.PL5.getValue()){
			// 开奖描述 奖级^中奖注数^每注奖金
			List<LotteryTerm> termList=lotteryTermService.findOpennendTermByLotteryType(LotteryType.PL5,0,10);
			for(LotteryTerm lotteryTerm:termList){
				String [] resultDetail=lotteryTerm.getResultDetail().split("\\^");
				sb.append("<tr>" +
						"<td>"+lotteryTerm.getTerm()+"</td>" +
						"<td>"+DateTools.dateToString(lotteryTerm.getOpenDateTime(), "MM/dd HH:mm")+"</td>" +
						"<td>"+lotteryTerm.getResult()+"</td>" +
						"<td>"+resultDetail[2]+"元</td>" +
						"</tr>");
			}
		}
		return sb.toString();
	}
	
	/**
	 * <p>生成竞彩足球最新开奖静态页面</p>
	 * @throws Exception
	 */
	private void buildFbNewlyPrizeHtml() throws Exception {
		
		// 查询最新开奖赛事
		List<FootBallMatch> footBallMatchList = footBallService.findNewlyPrizeMatchList(3);
		List<BasketBallMatch> basketBallMatchList = basketBallMatchService.getBasketBallMatchList(3);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
    	map.put("footBallMatchList", footBallMatchList);
    	map.put("basketBallMatchList", basketBallMatchList);
    	map.put("currDate", new Date());
    	
    	FreeMarker.init(WebConstants.getWebPath() + "masterplate/sporttery/football");
		FreeMarker.process(map, "newlyPrize.ftl", WebConstants.getWebPath() + "static/indexhome/fbNewlyPrize.shtml");
		
	}
	
	/**
	 * <p>获取试机号</p>
	 * @param openTerm LotteryTerm
	 * @return String
	 */
	private String getTestMachineCode(LotteryTerm openTerm) {
		String testMachineCodeHtml = "";
		String testMachineCode = openTerm.getTestMachineCode();
		
		if (!StringTools.isNullOrBlank(testMachineCode)) {
			testMachineCodeHtml = testMachineCode.charAt(0) + " " + testMachineCode.charAt(1) + " " + testMachineCode.charAt(2);
		}
		
		return testMachineCodeHtml;
	}
	
	/**
	 * 方案页面静态化
	 */
	public void buildPlanHtml(LotteryType lotteryType){
		List<LotteryType> list = new ArrayList<LotteryType>();
		list.add(lotteryType);
		buildPlanHtml(list);
	}
	
	/**
	 * 方案页面静态化
	 */
	public void buildPlanHtml(List<LotteryType> lotteryTypeList){
		if(lotteryTypeList==null || lotteryTypeList.size()==0)return;
		List<Integer> ltypeList = new ArrayList<Integer>();
		for(LotteryType lotteryType : lotteryTypeList){
			ltypeList.add(lotteryType.getValue());
		}
		LotteryType lotteryType = lotteryTypeList.get(0);
		Integer ltype=lotteryType.getValue();
		Integer offSetDay;
		if(LotteryType.getGPList().contains(ltype)){
			offSetDay=1;
		}else if(LotteryType.getJJC_LIST().contains(lotteryType) 
			|| LotteryType.FC3D.getValue()==ltype 
			|| LotteryType.PL3.getValue()==ltype 
			|| LotteryType.PL5.getValue()==ltype){
			offSetDay=2;
		}else {
			offSetDay=4;
		}
		Date date = new Date();
		date = DateTools.getDateByOffsetDay(date, -4);
		List<LotteryPlan> list =lotteryPlanService.findMuchTicketList(date,ltypeList);
		for(LotteryPlan lotteryPlan : list){
			Integer planNo= lotteryPlan.getPlanNo();
			String domainWww= WebConstants.getDomainWww();
			Date cdate = new Date();
			cdate = DateTools.getDateByOffsetDay(cdate, -offSetDay);
			Date creatDate =lotteryPlan.getCreateDateTime();
			boolean attime =creatDate.getTime()>cdate.getTime();

			// 方案主页
			String href=domainWww + "/hm/p-"+ planNo +".html?isLive=true&isSelf=true";
			String savePath=PublicStatus.getFilePath("index",lotteryPlan, true);
			boolean result= saveHtmlByHref(attime,href,60*1000,savePath,false);
			if(!result)continue;
			
			// 方案明细1
			href=domainWww + "/hm/ticketDetail.php?isLive=true&planNo="+ planNo+ "&isSelf=true";
			savePath=PublicStatus.getFilePath("ticket",lotteryPlan, true);
			saveHtmlByHref(attime,href,60*1000,savePath,true);

			// 方案明细
			href=domainWww + "/hm/planShowDetail.php?isLive=true&planNo="+ planNo+"&isSelf=true";
			savePath= PublicStatus.getFilePath("show",lotteryPlan, true);
			saveHtmlByHref(attime,href,60*1000,savePath,true);
			
			// 不公开的页面信息
			if(PublicStatus.getIsWithPrivate(lotteryPlan)){
				// 方案主页
				href=domainWww + "/hm/p-"+ planNo +".html?isLive=true";
				savePath=PublicStatus.getFilePath("index",lotteryPlan, false);
				result= saveHtmlByHref(attime,href,60*1000,savePath,false);
				if(!result)continue;
				
				// 方案明细1
				href=domainWww + "/hm/ticketDetail.php?isLive=true&planNo="+ planNo ;
				savePath=PublicStatus.getFilePath("ticket",lotteryPlan, false);
				saveHtmlByHref(attime,href,60*1000,savePath,true);

				// 方案明细
				href=domainWww + "/hm/planShowDetail.php?isLive=true&planNo="+ planNo ;
				savePath = PublicStatus.getFilePath("show",lotteryPlan, false);
				saveHtmlByHref(attime,href,60*1000,savePath,true);
			}
		}
	}

	/**
	 * 方案页面静态化
	 *
	public void buildPlanHtml(){
		Integer offSetDay= 1;
		Date date = new Date();
		date = DateTools.getDateByOffsetDay(date, -4);
		List<LotteryPlan> list =lotteryPlanService.findMuchTicketList(date);
		for(LotteryPlan lotteryPlan : list){
			Integer planNo= lotteryPlan.getPlanNo();
			Integer lottery=lotteryPlan.getLotteryType().getValue();
			if(LotteryType.getGPList().contains(lottery)){
				offSetDay=1;
			}else if(LotteryType.getJJC_LIST().contains(lotteryPlan.getLotteryType()) 
				|| LotteryType.FC3D.getValue()==lottery 
				|| LotteryType.PL3.getValue()==lottery 
				|| LotteryType.PL5.getValue()==lottery ){
				offSetDay=2;
			}else {
				offSetDay=4;
			}
			String domainWww= WebConstants.getDomainWww();
			Date cdate = new Date();
			cdate = DateTools.getDateByOffsetDay(cdate, -offSetDay);
			Date creatDate =lotteryPlan.getCreateDateTime();
			boolean attime =creatDate.getTime()>cdate.getTime();

			// 方案主页
			String href=domainWww + "/hm/p-"+ planNo +".html?isLive=true&isSelf=true";
			String savePath=PublicStatus.getFilePath("index",lotteryPlan, true);
			boolean result= saveHtmlByHref(attime,href,60*1000,savePath,false);
			if(!result)continue;
			
			// 方案明细1
			href=domainWww + "/hm/ticketDetail.php?isLive=true&planNo="+ planNo+ "&isSelf=true";
			savePath=PublicStatus.getFilePath("ticket",lotteryPlan, true);
			saveHtmlByHref(attime,href,60*1000,savePath,true);

			// 方案明细
			href=domainWww + "/hm/planShowDetail.php?isLive=true&planNo="+ planNo+"&isSelf=true";
			savePath=PublicStatus.getFilePath("show",lotteryPlan, true);
			saveHtmlByHref(attime,href,60*1000,savePath,true);
			
			// 不公开的页面信息
			if(PublicStatus.getIsWithPrivate(lotteryPlan)){
				// 方案主页
				href=domainWww + "/hm/p-"+ planNo +".html?isLive=true";
				savePath=PublicStatus.getFilePath("index",lotteryPlan, false);
				result= saveHtmlByHref(attime,href,60*1000,savePath,false);
				if(!result)continue;
				
				// 方案明细1
				href=domainWww + "/hm/ticketDetail.php?isLive=true&planNo="+ planNo ;
				savePath=PublicStatus.getFilePath("ticket",lotteryPlan, false);
				saveHtmlByHref(attime,href,60*1000,savePath,true);

				// 方案明细
				href=domainWww + "/hm/planShowDetail.php?isLive=true&planNo="+ planNo ;
				savePath=PublicStatus.getFilePath("show",lotteryPlan, false);
				saveHtmlByHref(attime,href,60*1000,savePath,true);
			}
		}
	}
	
	/**
	 * 竞彩篮球方案页面静态化
	 */
	private boolean saveHtmlByHref(boolean attime,String href,int timeout,String savePath,boolean isPass){
		try{
			boolean exists =FileTools.exists(savePath);
			if(!exists || attime){
				Connection connection = Jsoup
						.connect(href)
						.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36")
						.cookie("auth", "token")
						.header("Content-Type", "text/html;charset=GBK")
						.timeout(timeout);
				
				Document doc=connection.get();
				String html="";
				if(doc!=null) html=doc.html();
				if(html.indexOf("竞彩足球-")>-1 || html.indexOf("竞彩篮球-")>-1 || isPass){
					FileTools.setFileContent(html,savePath,"GBK");
					return true;
				}
			}
		} catch (Exception e) {
			LogUtil.error(e);
		}
		return false;
	}
	
	public void setXmlList(List<String> xmlList) {
		this.xmlList = xmlList;
	}

	public List<String> getXmlList() {
		return xmlList;
	}

	public List<String> getXmlListV4() {
		return xmlListV4;
	}

	public void setXmlListV4(List<String> xmlListV4) {
		this.xmlListV4 = xmlListV4;
	}

}
