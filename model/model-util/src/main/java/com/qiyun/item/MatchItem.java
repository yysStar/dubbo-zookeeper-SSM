package com.qiyun.item;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstactMatch;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.intface.SelectedCount;
import com.qiyun.model.football.MatchAwardOfRQSPF;
import com.qiyun.model.football.MatchAwardOfSPF;
import com.qiyun.sporttery.SportteryOption;
import com.qiyun.tools.DateTools;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MatchItem implements Serializable, SelectedCount {

	private static final long serialVersionUID = 1L;

	/** 整数日期 */
	private Integer intTime;

	/** 一天赛事里的场次序号 */
	private Integer lineId;
	
	/** 选择的内容 */
	private List<SportteryOption> options = new ArrayList<SportteryOption>();

	private boolean shedan;

	public MatchItem cloneItem() {
		MatchItem item = new MatchItem();
		item.setIntTime(this.getIntTime());
		item.setLineId(this.getLineId());
		List<SportteryOption> tempOptionList = this.getOptions();
		List<SportteryOption> optionList = new ArrayList<SportteryOption>();
		for (SportteryOption option : tempOptionList) {
			optionList.add(option);
		}
		item.setOptions(optionList);
		item.setShedan(this.isShedan());
		return item;
	}
	public List<MatchItem> toDsItems(){
		List<MatchItem> result=new ArrayList<MatchItem>();
		for(SportteryOption option:options){
			MatchItem tempItem=cloneItem();
			List<SportteryOption> options=new ArrayList<SportteryOption>();
			options.add(option);
			tempItem.setOptions(options);
			result.add(tempItem);
		}
		return result;
	}
	public static List<MatchItem> toItem(AbstactMatch match, AbstractAward award, LotteryType lotteryType){
		List<MatchItem> result=new ArrayList<MatchItem>();
		List<SportteryOption> options=new ArrayList<SportteryOption>();
		if(lotteryType.getValue()== LotteryType.JC_ZQ_RQSPF.getValue() || lotteryType.getValue()== LotteryType.JC_ZQ_SPF.getValue()){
			String[] optionsValues=OptionItemSPF.getAllValue();
			for(String optionValue:optionsValues){
				SportteryOption option=new SportteryOption();
				option.setValue(optionValue);
				if(lotteryType.getValue()== LotteryType.JC_ZQ_RQSPF.getValue()){
					MatchAwardOfRQSPF rqspf = (MatchAwardOfRQSPF)award;
					option.setAward(rqspf.getAward(optionValue));
				}else{
					MatchAwardOfSPF spf = (MatchAwardOfSPF)award;
					option.setAward(spf.getAward(optionValue));
				}
				options.add(option);
			}
		}else{
			throw new RuntimeException("暂不支持非胜平负玩法");
		}
		for(SportteryOption option:options){
			MatchItem item= new MatchItem();
			item.setIntTime(match.getIntTime());
			item.setLineId(match.getLineId());
			List<SportteryOption> tempOptions=new ArrayList<SportteryOption>();
			tempOptions.add(option);
			item.setOptions(tempOptions);
			result.add(item);
		}
		return result;
	}
	
	public Map<String, List<String[]>> getFbValueStrMap() {
		
		Map<String, List<String[]>> sportteryOptionMap = new HashMap<String, List<String[]>>();
		try{
		if (options != null) {
			for (SportteryOption op : options) {
				
				if (op.getType() != null && !"".equals(op.getType())) {
					if (sportteryOptionMap.containsKey(getFbTypeStr(op.getType()))) {
						String[] str=new String[2];
						str[0]=op.getTypeValueStr();
						str[1]=op.getAward()+"";
						sportteryOptionMap.get(getFbTypeStr(op.getType())).add(str);
					} else {
						List<String[]> list = new ArrayList<String[]>();
						String[] str=new String[2];
						str[0]=op.getTypeValueStr();
						str[1]=op.getAward()+"";
						list.add(str);
						sportteryOptionMap.put(getFbTypeStr(op.getType()), list);
					}
				}

			}
		}
		}catch (Exception e) {
			return sportteryOptionMap;
		}
		return sportteryOptionMap;
	}
	
	public void setFbValueStrMap(Map<String, List<String>> sportteryOptionMap) {}
	
	public String getFbTypeStr(String type) {
		
		String fbStr = "";
		if (type != null) {
			if (type.equals("34")) {
				fbStr = "让球胜平负";
			} else if (type.equals("41")) {
				fbStr = "胜平负";
			} else if (type.equals("36")) {
				fbStr = "进球数";
			} else if (type.equals("35")) {
				fbStr = "比分";
			} else if (type.equals("37")) {
				fbStr = "半全场";
			}else if (type.equals("45")) {
				fbStr = "欧冠杯冠军";
			}else if (type.equals("46")) {
				fbStr = "世界杯冠军";
			}
		}
		
		return fbStr;
	}
	
	/**
	 * @return the {@link #intTime}
	 */
	public Integer getIntTime() {
		return intTime;
	}

	/**
	 * @param intTime
	 *            the {@link #intTime} to set
	 */
	public void setIntTime(Integer intTime) {
		this.intTime = intTime;
	}

	/**
	 * @return the {@link #lineId}
	 */
	public Integer getLineId() {
		return lineId;
	}

	/**
	 * @param lineId
	 *            the {@link #lineId} to set
	 */
	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	/**
	 * @return the {@link #options}
	 */
	public List<SportteryOption> getOptions() {
		return options;
	}

	/**
	 * @param options
	 *            the {@link #options} to set
	 */
	public void setOptions(List<SportteryOption> options) {
		this.options = options;
	}

	/**
	 * @return the {@link #serialVersionUID}
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int selectedCount() {
		if (options != null)
			return options.size();
		else
			return 0;
	}

	public boolean selected(String value) {
		value = value.trim();
		for (SportteryOption op : this.options) {
			if (op.getValue().equals(value))
				return true;
		}
		return false;
	}

	public boolean selected(OptionItem opItem) {
		for (SportteryOption op : this.options) {
			if (op.getValue().equals(opItem.getValue()))
				return true;
		}
		return false;
	}

	public SportteryOption itemToOption(OptionItem rs) {
		for (SportteryOption op : this.options) {
			if (op!=null&&op.getValue().equals(rs.getValue()))
				return op;
		}
		return null;
	}

	public SportteryOption indexToOption(int optionIndex) {
		return this.options.get(optionIndex);
	}

	public SportteryOption won(OptionItem rs) {
		for (SportteryOption op : this.options) {
			if (op.getValue().equals(rs.getValue()))
				return op;
		}
		return null;
	}
	
	public SportteryOption wons(SportteryOption hunTou,OptionItem rs) {
		if (hunTou.getValue().equals(rs.getValue()))
			return hunTou;
		
		return null;
	}

	public String genMatchKey() {
		return this.getIntTime()+"_"+this.getLineId();
	}
	
	public String genMatchShowKey() {
		String lineIdText = this.getIntTime().toString();
		for (int i = lineIdText.length(); i < 3; i++) {
			lineIdText = "0" + lineIdText;
		}
		String showLineId = lineIdText;
		String showMatchKey = this.getIntTime().toString().substring(2) + showLineId;
		return showMatchKey;
	}
	
	public String show2String(boolean isPass, LotteryType lt) {
		String result = "";
		List<SportteryOption> optionList = this.getOptions();
		String weekStr = DateTools.getWeekStr(DateTools.StringToDate(this.getIntTime() + "", "yyyyMMdd"));
		result += weekStr + this.getLineId() + "(";
		for (int j = 0; j < optionList.size(); j++) {
			SportteryOption option = optionList.get(j);
			OptionItem optionItem = SportteryOption.getByPlayType(lt, option);

			if (!isPass) {// 单关
				result += optionItem.getText() + ",";
			} else {// 过关
				result += optionItem.getText() + option.getAward() + ",";
			}
		}
		result = result.substring(0, result.length() - 1);
		result += ")";
		return result;
	}
	
	public boolean isShedan() {
		return shedan;
	}

	public void setShedan(boolean shedan) {
		this.shedan = shedan;
	}
	
	public boolean getIsSheDan(){//struts2标签 使用
		return shedan;
	}
	
	public void setIsSheDan(boolean shedan){}
}
