package com.qiyun.support;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model.BbLimitOptionItem;
import com.qiyun.model.football.FbLimitOptionItem;
import com.qiyun.tools.StringTools;
import com.qiyun.util.LogUtil;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * SportteryRecommend entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class SportteryRecommend extends AbstractSportteryRecommend implements java.io.Serializable {

	// Constructors
	private Integer intTime;
	private String lineIdText;
	private Integer jcType;
	private Map<Object, String> itemsMap;
	private List<Integer> starLevelList;
	private String desc;
	private String gameName;
	
	public void setTitleStr(String titleStr){
		String encode = "UTF-8";
		try {
			if (titleStr != null) {
				setTitle(java.net.URLDecoder.decode(titleStr, encode));
			}
		} catch (UnsupportedEncodingException e) {
			LogUtil.error(e);
		}
		
	}

	public void setDesc(String desc) {
		String encode = "UTF-8";
		try {
			if (desc != null) {
				setDescription(java.net.URLDecoder.decode(desc, encode));
			}
		} catch (UnsupportedEncodingException e) {
			LogUtil.error(e);
		}
	}

	public Integer getJcType() {
		LotteryType type = null;
		if (LotteryType.JCZQList.contains(getLotteryType())) {
			type = LotteryType.JC_ZQ;
		} else {
			type = LotteryType.JC_LQ;
		}
		this.jcType = type.getValue();
		return jcType;
	}

	/** default constructor */
	public SportteryRecommend() {
	}

	/** minimal constructor */
	public SportteryRecommend(AdminExpert adminExpert, String matchKey, LotteryType lotteryType, String optionItem, String term) {
		super(adminExpert, matchKey, lotteryType, optionItem, term);
	}

	/** full constructor */
	public SportteryRecommend(AdminExpert adminExpert, String matchKey, LotteryType lotteryType, Integer passMode, String optionItem,
			String description, String danType, Date endTime, Integer seq, SportteryRecommendStatus recommendStatus, Date createDate,
			String createAccount, Integer starLevel, String term, Integer delay, String matchName, Integer buyType, Integer buyConsume,
			Integer buyFree, Integer buyNum, String title) {
		super(adminExpert, matchKey, lotteryType, passMode, optionItem, description, danType, endTime, seq, recommendStatus, createDate,
				createAccount, starLevel, term, delay, matchName, buyType, buyConsume, buyFree, buyNum, title);
	}

	public Integer getIntTime() {
		String matchKey = getMatchKey();
		if (!StringTools.isNullOrBlank(matchKey)) {
			String[] arr = matchKey.split("_");
			if (arr.length == 2) {
				intTime = Integer.parseInt(arr[0]);
			}
		}
		return intTime;
	}

	public String getLineIdText() {
		String matchKey = getMatchKey();
		if (!StringTools.isNullOrBlank(matchKey)) {
			String[] arr = matchKey.split("_");
			if (arr.length == 2) {
				String tmpId = arr[1];
				for (int i = tmpId.length(); i < 3; i++) {
					tmpId = "0" + tmpId;
				}
				lineIdText = tmpId;
			}
		}
		return lineIdText;
	}

	public Map<Object, String> getItemsMap() {
		Map<Object, String> map = new LinkedHashMap<Object, String>();
		boolean isFb = getJcType() == LotteryType.JC_ZQ.getValue();
		if (!StringTools.isNullOrBlank(getOptionItem())) {
			String[] arr = getOptionItem().split(",");
			for (String str : arr) {
				String[] tmps = str.split("@");
				String opt = tmps[0];
				String sp = "";
				if (tmps.length == 2) {
					sp = "@" + tmps[1];
				}
				if (isFb) {
					FbLimitOptionItem item = FbLimitOptionItem.valueOf(opt);
					map.put(item, sp);
				} else {
					BbLimitOptionItem item = BbLimitOptionItem.valueOf(opt);
					map.put(item, sp);
				}
			}
		}
		itemsMap = map;
		return itemsMap;
	}

	public Map<String, String> getOptMap() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		boolean isFb = getJcType() == LotteryType.JC_ZQ.getValue();
		if (!StringTools.isNullOrBlank(getOptionItem())) {
			String[] arr = getOptionItem().split(",");
			for (String str : arr) {
				String[] tmps = str.split("@");
				String opt = tmps[0];
				String sp = "";
				if (tmps.length == 2) {
					sp = "@" + tmps[1];
				}
				if (isFb) {
					FbLimitOptionItem item = FbLimitOptionItem.valueOf(opt);
					map.put(item.getText(), sp);
				} else {
					BbLimitOptionItem item = BbLimitOptionItem.valueOf(opt);
					map.put(item.getText(), sp);
				}
			}
		}
		return map;
	}

	public List<Integer> getStarLevelList() {
		List<Integer> list = new ArrayList<Integer>();
		int maxLevel = 5;// 最大五星
		for (int i = 1; i <= maxLevel; i++) {
			if (i <= getStarLevel()) {
				list.add(1);
			} else {
				list.add(0);
			}
		}
		starLevelList = list;
		return starLevelList;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		String encode = "UTF-8";
		try {
			if (gameName != null) {
				setMatchName(java.net.URLDecoder.decode(gameName, encode));
			}
		} catch (UnsupportedEncodingException e) {
			LogUtil.error(e);
		}
	}
	
	public String getDesc() {
		desc=getDescription();
		if(desc.length()>=55){
			desc=desc.substring(0,55)+"...";
		}
		return desc;
	}

}
