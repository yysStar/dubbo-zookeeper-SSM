//package com.qiyun.thread.football;
//
//import java.io.Reader;
//import java.io.StringReader;
//import java.util.List;
//
//import com.qiyun.commonModel.LotteryType;
//import com.qiyun.grabber.football.SfpArrange;
//import com.qiyun.httpUtil.WebConstants;
//import com.qiyun.model.FootballMatchBean;
//import com.qiyun.model.LotteryTerm;
//import com.qiyun.service.LotteryTermService;
//import com.qiyun.util.FbDcArrangeUtil;
//import com.qiyun.utils.FileTools;
//import org.jdom.Attribute;
//import org.jdom.Document;
//import org.jdom.Element;
//import org.jdom.input.SAXBuilder;
//import org.jdom.output.Format;
//import org.jdom.output.XMLOutputter;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class SfcArrangeInfoBuildThread extends Thread {
//    @Autowired
//	private LotteryTermService lotteryTermService;
//	private SfpArrangeService sfpArrangeService;
//
//	// 默认为10秒的休息时间
//	private long sleepTime = 180000;
//	private boolean isRun = true;
//
//	public void run() {
//		try {
//			Thread.sleep(5000l);
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//		}
//		while (true) {
//			try {
//				if (isRun) {
//					LotteryTerm term = lotteryTermService.findCurrentTermByLotteryType(LotteryType.SFC);
//					List oldTermList = lotteryTermService.findBeforeTerm(LotteryType.SFC, term.getTerm(), 3);
//					LotteryTerm bookingTerm = lotteryTermService.findBookingAfterSaleTerm(LotteryType.SFC, term.getTerm());
//
//					buildInfo(term.getLotteryType(), term.getTerm());
//					// 重构最近几期的xml
//					if (oldTermList != null) {
//						for (int i = 0; i < oldTermList.size(); i++) {
//							buildInfo(((LotteryTerm) oldTermList.get(i)).getLotteryType(), ((LotteryTerm) oldTermList.get(i)).getTerm());
//						}
//					}
//					if (bookingTerm != null) {
//						buildInfo(bookingTerm.getLotteryType(), bookingTerm.getTerm());
//					}
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			try {
//				Thread.sleep(sleepTime);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	@SuppressWarnings("unchecked")
//	public void buildInfo(LotteryType lotteryType, String term) {
//		List arrangeList = this.sfpArrangeService.findForShow(lotteryType, term);
//		List opList = FbSfpArrangeUtil.getAverageIndex("http://trade.500.com/static/public/sfc/daigou/shtml/" + term + ".shtml");
//		List apList = FbSfpArrangeUtil.getAzpkAverage("http://www.500.com/static/info/odds/xml/lottery/sfc/" + term + "_1.xml");
//
//		//List resultList = FbSfpArrangeUtil.getScore("http://trade.500.com/static/public/sfc/daigou/shtml/" + term + ".shtml");
//		List sfcLlplList = FbSfpArrangeUtil.getLlpl("http://www.500.com/sfc/hz/fx_sfcfs.php", term);
//		List rx9llplList = FbSfpArrangeUtil.getLlpl("http://www.500.com/sfc/hz/fx_rx9fs.php", term);
////		List<String> hrefList = FbSfpArrangeUtil.getOutId("http://odds.cailele.com/index.php?controller=sfcodds&action=index&tp=1&qh=" + term);
//
//		try {
//			//比分历史记录
//			List<FootballMatchBean> resultList = FbDcArrangeUtil.get500wMatch("http://live.500.com/zucai.php?e="+term);
//
//			// 生成返回的xml
//			SAXBuilder sb = new SAXBuilder();
//			Reader reader = new StringReader("<?xml version=\"1.0\" encoding=\"GBK\"?><root></root>");
//			Document returnDoc = sb.build(reader);
//			Element returnRoot = returnDoc.getRootElement();
//			for (int i = 0; i < arrangeList.size(); i++) {
//				SfpArrange bean = (SfpArrange) arrangeList.get(i);
//				FootballMatchBean resulet=(FootballMatchBean)resultList.get(i);
//				Element element = new Element("row");
//				element.setAttribute(new Attribute("matchName", bean.getMatchName()));
//				element.setAttribute(new Attribute("matchDateTime", bean.getMatchDateTime()));
//				element.setAttribute(new Attribute("homeTeam", bean.getHomeTeam()));
//				element.setAttribute(new Attribute("awaryTeam", bean.getAwaryTeam()));
//				if (opList.size() > 0) {
//					element.setAttribute(new Attribute("op", opList.get(i).toString()));
//				} else {
//					element.setAttribute(new Attribute("op", "0^0^0"));
//				}
//				if (apList.size() > 0) {
//					element.setAttribute(new Attribute("ap", apList.get(i).toString()));
//				} else {
//					element.setAttribute(new Attribute("ap", "0^0^0"));
//				}
////				if (hrefList.size() > 0) {
////					element.setAttribute(new Attribute("href", hrefList.get(i).toString()));
////				} else {
//					element.setAttribute(new Attribute("href", "#^#^#"));
////				}
//				if (rx9llplList.size() == 14) {
//					element.setAttribute(new Attribute("rx9Llpl", rx9llplList.get(i).toString()));
//				} else {
//					element.setAttribute(new Attribute("rx9Llpl", "0^0^0"));
//				}
//
//				if (sfcLlplList.size() == 14) {
//					element.setAttribute(new Attribute("llpl", sfcLlplList.get(i).toString()));
//				} else {
//					element.setAttribute(new Attribute("llpl", "0^0^0"));
//				}
//				if(resulet!=null && resulet.getBfWhole()!=null && !"".equals(resulet.getBfWhole())){
//					element.setAttribute(new Attribute("result", resulet.getBfWhole().toString()));
//				}else{
//				    element.setAttribute(new Attribute("result",":"));
//				}
////				if (resultList.size() > 0) {
////					element.setAttribute(new Attribute("result", resultList.get(i).toString()));
////				} else {
////					element.setAttribute(new Attribute("result", ":"));
////				}
//				returnRoot.addContent(element);
//			}
//			returnDoc.setRootElement(returnRoot);
//			XMLOutputter xo = new XMLOutputter();
//			Format format = xo.getFormat();
//			format.setEncoding("GBK");
//			format.setLineSeparator("");
//			xo.setFormat(format);
//			String string = xo.outputString(returnDoc);
//			FileTools.setFileContent(string, WebConstants.getWebPath() + "/static/sfc14/arrange_" + term + ".xml");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//	public static void main(String[] args) {
//		try {
//			List<FootballMatchBean> resultList = FbDcArrangeUtil.get500wMatch("http://live.500.com/zucai.php?e=11096");
//
//			if(resultList!=null &&!resultList.isEmpty()){
//				for(int i=0;i<resultList.size();i++){
//					FootballMatchBean bean=(FootballMatchBean)resultList.get(i);
//					String str=bean.getHome()+" "+bean.getGuest()+" "+bean.getBfWhole();
//					if(bean!=null && bean.getBfWhole()!=null &&!"".equals(bean.getBfWhole())){
//						System.out.println(str);
//					}else
//					System.out.println("no");
//
//
//				}
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//	}
//
//	public void setSleepTime(long sleepTime) {
//		this.sleepTime = sleepTime;
//	}
//
//	public void setRun(boolean isRun) {
//		this.isRun = isRun;
//	}
//
//}
