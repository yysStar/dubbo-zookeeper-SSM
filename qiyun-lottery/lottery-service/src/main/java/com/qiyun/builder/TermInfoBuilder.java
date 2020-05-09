package com.qiyun.builder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model.LotteryTerm;
import com.qiyun.model.LotteryTypeProps;
import com.qiyun.service.LotteryTermService;
import com.qiyun.service.LotteryTypePropsService;
import com.qiyun.tools.DateTools;
import com.qiyun.utils.FileTools;
import com.qiyun.utils.StringTools;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;

/**
 * 数字彩期数信息静态化
 * 
 * @author sxh 2011-11-14
 * 
 */
public class TermInfoBuilder implements StaticsBuilder, ServletContextAware {

	private ServletContext servletContext;
	private String filePath;
	@Autowired
	private LotteryTermService lotteryTermService;
	@Autowired
	private LotteryTypePropsService lotteryTypePropsService;

	public String make(HashMap<String, Object> map) throws Exception, JSONException {
		LotteryType lotteryType = LotteryType.getItem(Integer.valueOf((String) map.get(LOTTERY_TYPE)));
		
		//简单的彩期信息
		FileTools.setFileContent(getJson(lotteryType,false), servletContext.getRealPath(filePath + lotteryType.getValue() + ".txt"));
		
		//超大的彩期信息
		FileTools.setFileContent(getJson(lotteryType,true), servletContext.getRealPath(filePath + "P" + lotteryType.getValue() + ".txt"));
		
		return "0";
	}

	private String getJson(LotteryType lotteryType,boolean isLarge) throws Exception, JSONException {
		LotteryTerm currentTerm = lotteryTermService.findCurrentTermByLotteryType(lotteryType);
		LotteryTerm openTerm = lotteryTermService.findOpenResultByLotteryType(lotteryType);
		LotteryTerm openningTerm = lotteryTermService.findOpenningTermByLotteryType(lotteryType);

		if (openningTerm == null)
			openningTerm = openTerm;

		// currentTerm 当前期
		// currentTermEndDT 当前期截止时间-字符型
		// currentTermEndDTByLong 当前期截止时间-数字型
		// currentTermIsAble 当前期是否可用 (0:是 1:否)
		// openTerm 最后开奖期数
		// openResult 最后开奖结果
		// awardPool 奖池
		// openTermDT 下次开奖时间-字符型
		// openTermDTByLong 下次开奖时间-数字型
		// openningTerm 正在开奖期数
		/**
		 * 新增内容
		 */
		// awardAdd 是否加奖
		// openToday 是否今日开奖
		// lotteryText 小标语
		JSONObject retJson = new JSONObject();

		retJson.put("currentTerm", currentTerm.getTerm());
		retJson.put("currentTermEndDT", DateTools.dateToString(currentTerm.getEndDateTime(), "yyyy-MM-dd HH:mm"));
		retJson.put("currentTermEndDTByLong", currentTerm.getEndDateTime().getTime() + "");
		retJson.put("currentTermIsAble", currentTerm.getIsAble().getValue() + "");
		retJson.put("currentTermLotMgrIsAble", currentTerm.getLotMgrIsAble().getValue() + "");
		retJson.put("openTerm", openTerm.getTerm());
		retJson.put("openResult", openTerm.getResult());
		retJson.put("awardPool", openTerm.getAwardPool());
		retJson.put("operResultTime", DateTools.dateToString(openTerm.getOpenDateTime(), "yyyy-MM-dd HH:mm"));// 新增上期开奖时间
		retJson.put("openTermDT", DateTools.dateToString(openningTerm.getOpenDateTime(), "yyyy-MM-dd HH:mm"));
		retJson.put("openTermDTByLong", openningTerm.getOpenDateTime().getTime() + "");
		retJson.put("openningTerm", openningTerm.getTerm());
		
		//是否生成试机号
		if (lotteryType.getValue() == LotteryType.FC3D.getValue() || lotteryType.getValue() == LotteryType.PL3.getValue()) {
			retJson.put("currentTermSjh", currentTerm.getTestMachineCode());//当前期试机号
			retJson.put("openTermSjh", openTerm.getTestMachineCode());//开奖期试机号
		}
		
		// 为是否加奖,小标语设值
		isAwardAdd(openningTerm, retJson, lotteryType);

		if (lotteryType.getValue() == LotteryType.SSC.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 3, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", String.valueOf(120 - Integer.parseInt(openCount)));

		}
		
		if (lotteryType.getValue() == LotteryType.JXSSC.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", String.valueOf(84 - Integer.parseInt(openCount)));
		}

		if (lotteryType.getValue() == LotteryType.KL8.getValue()) {
			int biaoZhun = 414666;// 某一天的最后一期，以它为标准进行取除计算
			int now = Integer.parseInt(openTerm.getTerm());
			int openCount = (now - biaoZhun) % 179;
			if (openCount == 0)
				openCount = 179;

			retJson.put("openCount", openCount);
			retJson.put("waitCount", String.valueOf(179 - openCount));
		}

		if (lotteryType.getValue() == LotteryType.SSL.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 23 - Integer.parseInt(openCount));
		}

		if (lotteryType.getValue() == LotteryType.KLSF.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 84 - Integer.parseInt(openCount));
		}

		if (lotteryType.getValue() == LotteryType.CQ_KLSF.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 97 - Integer.parseInt(openCount));
		}

		if (lotteryType.getValue() == LotteryType.SYYDJ.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 87 - Integer.parseInt(openCount));
		}

		if (lotteryType.getValue() == LotteryType.JXDLC.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 84 - Integer.parseInt(openCount));
		}

		if (lotteryType.getValue() == LotteryType.GD11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 84 - Integer.parseInt(openCount));
		}

		if (lotteryType.getValue() == LotteryType.CQ11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 85 - Integer.parseInt(openCount));
		}

		if (lotteryType.getValue() == LotteryType.SH11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 90 - Integer.parseInt(openCount));
		}
		
		if (lotteryType.getValue() == LotteryType.HLJ11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 88 - Integer.parseInt(openCount));
		}
		
		if (lotteryType.getValue() == LotteryType.JS11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 82 - Integer.parseInt(openCount));
		}
		
		if (lotteryType.getValue() == LotteryType.GXKLSF.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 50 - Integer.parseInt(openCount));
		}

		if (lotteryType.getValue() == LotteryType.KL123.getValue()) {
			int biaoZhun = 10004747;// 某一天的最后一期，以它为标准进行取除计算
			int now = Integer.parseInt(openTerm.getTerm());
			int openCount = (now - biaoZhun) % 72;
			if (openCount == 0)
				openCount = 72;
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 72 - openCount);
		}

		if (lotteryType.getValue() == LotteryType.SDQYH.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 52 - Integer.parseInt(openCount));
		}
		
		if (lotteryType.getValue() == LotteryType.SDQYH_NEW.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 78 - Integer.parseInt(openCount));
		}

		if (lotteryType.getValue() == LotteryType.K3.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 3, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 82 - Integer.parseInt(openCount));
		}
		if (lotteryType.getValue() == LotteryType.HB_K3.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 3, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 78 - Integer.parseInt(openCount));
		}
		if (lotteryType.getValue() == LotteryType.JL_K3.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 3, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 87 - Integer.parseInt(openCount));
		}
		if (lotteryType.getValue() == LotteryType.AH_K3.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 3, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 80 - Integer.parseInt(openCount));
		}
		if (lotteryType.getValue() == LotteryType.JX_K3.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 3, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 84 - Integer.parseInt(openCount));
		}

		if (lotteryType.getValue() == LotteryType.LN11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 83 - Integer.parseInt(openCount));
		}

		if (lotteryType.getValue() == LotteryType.HN_KLSF.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 3, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 84 - Integer.parseInt(openCount));
		}

		// 双色球与大大乐透
		if (lotteryType.getValue() == LotteryType.SSQ.getValue() || lotteryType.getValue() == LotteryType.DLT.getValue()) {
			retJson.put("dgEndShow", DateTools.dateToString(currentTerm.getEndDateTime(), "yyyy-MM-dd HH:mm"));
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(currentTerm.getEndDateTime().getTime());
			calendar.add(Calendar.SECOND, -5 * 60);
			retJson.put("hmEndShow", DateTools.dateToString(calendar.getTime(), "yyyy-MM-dd HH:mm"));
		}
		//快乐扑克3
		if (lotteryType.getValue() == LotteryType.POKER3.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 88 - Integer.parseInt(openCount));
		}
		
		//********************************* 快3系列抓取彩种 start ****************************************/
		//广西快3
		if (lotteryType.getValue() == LotteryType.GX_K3.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 3, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 78 - Integer.parseInt(openCount));
		}
		
		//河北快3
		if (lotteryType.getValue() == LotteryType.HEB_K3.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 3, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 81 - Integer.parseInt(openCount));
		}
		
		//福建快3
		if (lotteryType.getValue() == LotteryType.FJ_K3.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 3, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 78 - Integer.parseInt(openCount));
		}
		
		//上海快3
		if (lotteryType.getValue() == LotteryType.SH_K3.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 3, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 82 - Integer.parseInt(openCount));
		}
		
		//甘肃快3
		if (lotteryType.getValue() == LotteryType.GS_K3.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 3, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 72 - Integer.parseInt(openCount));
		}
		

		//江西快3
		if (lotteryType.getValue() == LotteryType.JX_K3.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 3, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 84 - Integer.parseInt(openCount));
		}
		//********************************* 快3系列抓取彩种 end ****************************************/
		
		//********************************* 11选5系列抓取彩种 start ****************************************/
		//福建11选5
		if (lotteryType.getValue() == LotteryType.FJ11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 78 - Integer.parseInt(openCount));
		}
		//浙江11选5
		if (lotteryType.getValue() == LotteryType.ZJ11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 80 - Integer.parseInt(openCount));
		}
		//吉林11选5
		if (lotteryType.getValue() == LotteryType.JL11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 79 - Integer.parseInt(openCount));
		}
		//湖北11选5
		if (lotteryType.getValue() == LotteryType.HB11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 81 - Integer.parseInt(openCount));
		}
		//广西11选5
		if (lotteryType.getValue() == LotteryType.GX11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 79 - Integer.parseInt(openCount));
		}
		//天津11选5
		if (lotteryType.getValue() == LotteryType.TJ11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 90 - Integer.parseInt(openCount));
		}
		//安徽11选5
		if (lotteryType.getValue() == LotteryType.AH11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 81 - Integer.parseInt(openCount));
		}
		//山西11选5
		if (lotteryType.getValue() == LotteryType.SX11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 85 - Integer.parseInt(openCount));
		}
		//甘肃11选5
		if (lotteryType.getValue() == LotteryType.GS11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 72 - Integer.parseInt(openCount));
		}
		//四川11选5
		if (lotteryType.getValue() == LotteryType.SC11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 78 - Integer.parseInt(openCount));
		}
		//陕西11选5
		if (lotteryType.getValue() == LotteryType.SHANX11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 79 - Integer.parseInt(openCount));
		}
		//贵州11选5
		if (lotteryType.getValue() == LotteryType.GZ11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 72 - Integer.parseInt(openCount));
		}
		//河南11选5
		if (lotteryType.getValue() == LotteryType.HEN11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 72 - Integer.parseInt(openCount));
		}
		//河北11选5
		if (lotteryType.getValue() == LotteryType.HEB11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 85 - Integer.parseInt(openCount));
		}
		//北京11选5
		if (lotteryType.getValue() == LotteryType.BJ11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 85 - Integer.parseInt(openCount));
		}
		//云南11选5
		if (lotteryType.getValue() == LotteryType.YN11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 72 - Integer.parseInt(openCount));
		}
		//内蒙古11选5
		if (lotteryType.getValue() == LotteryType.NMG11X5.getValue()) {
			String openCount = openTerm.getTerm().substring(openTerm.getTerm().length() - 2, openTerm.getTerm().length());
			retJson.put("openCount", openCount);
			retJson.put("waitCount", 75 - Integer.parseInt(openCount));
		}
		//********************************* 11选5系列抓取彩种 end ****************************************/
		
		if(isLarge) {
			//获取lotteryTypeProps
			if(LotteryType.SYXW_SNATCH_LIST.contains(lotteryType) || LotteryType.K3_SNATCH_LIST.contains(lotteryType)) {
				//抓取系列彩种暂不生成
			} else  {
				LotteryTypeProps tmpProp=lotteryTypePropsService.findAndCommendByLotType(lotteryType.getValue());
				retJson.put("stopCause",tmpProp.getStopCause());
				List<LotteryTypeProps> cmdList=tmpProp.getCommendList();
				List<String> jsonList=new ArrayList<String>();
				if(cmdList != null){
					for(int i=0;i<cmdList.size();i++){
						LotteryTypeProps cmdProp=cmdList.get(i);
						jsonList.add(cmdProp.getToLotteryType().getName()+","+cmdProp.getBuyLink());
					}
				}
				retJson.put("lotteryName",tmpProp.getToLotteryType().getName());
				retJson.put("cmdLottery",jsonList);
			}
		}
		
		return retJson.toString();
	}

	private void isAwardAdd(LotteryTerm openningTerm, JSONObject retJson, LotteryType lotteryType) {
		try {
			LotteryTypeProps prop = lotteryTypePropsService.findById(lotteryType.getValue());
			if (prop.getPromotion() == null) {
				prop.setPromotion(Long.valueOf(-1));
			}
			long add = prop.getPromotion();
			String text = prop.getDescribe();
			String guideText = prop.getLotteryGuideImg();// 加奖:addward
															// 加奖独家:only2
			if (add == 0) {
				if ("only2".equals(guideText))
					add = 2;
			} else if (add == 1) {
				add = 1;
			} else {
				add = -1;
			}

			retJson.put("awardAdd", add);// 0加奖 1新彩种 2独家加奖 其它为-1
			if (text != null && text.length() > 0) {
				// String textStr= new String(Base64.encode(text.getBytes()));
				String textStr = StringTools.EncodeBase64(text);

				retJson.put("lotteryText", textStr);
			} else {
				retJson.put("lotteryText", "");
			}
		} catch (Exception e) {
		}
	}

	public void setFilePath(String string) {
		this.filePath = string;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
