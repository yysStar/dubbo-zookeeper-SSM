package com.qiyun.sporttery;

import com.qiyun.aenum.SubTypeEnum;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.item.*;

import java.io.Serializable;

/**
 * 竞彩选项值
 * 
 * @author Zhou
 * 
 */
public class SportteryOption implements Serializable {

	private static final long serialVersionUID = 7249892069132454534L;

	/** 选项值 */
	private String value;

	/** 奖金值 */
	private Double award;
	
	/** 彩种 */
	private String type;
	
	/** 让球数 */
	private Integer rqs;
	
	private String subType = SubTypeEnum.COMMON.name();//主要用于区分是否亚盘投注
	
	private  Integer betMoney=2;
	
	private Integer each=2;// 每注多少钱/每注多少积分
	
	private Double rf;
	private Double dxf;
	/**
	 * @return the {@link #value}
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the {@link #value} to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the {@link #award}
	 */
	public Double getAward() {
		return award;
	}

	/**
	 * @param award
	 *            the {@link #award} to set
	 */
	public void setAward(Double award) {
		this.award = award;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getTypeValueStr(){
		if(getType() != null && !"".equals(getType())){
			return getByPlayType(LotteryType.getItem(Integer.valueOf(getType())), this).getText();
		}
		return "";
	}

	public static OptionItem getByPlayType(LotteryType type, SportteryOption option) {
		String value = option.getValue();
		String itemType = option.getType();
		itemType = itemType == null ? "-1" : itemType;
		itemType = itemType.equals("") ? "-1" : itemType;
		return getByPlayType(type, value, Integer.parseInt(itemType));
	}

	/**
	 *
	 * @param type
	 *            彩种
	 * @param value
	 *            玩法的值
	 * @param itemType
	 *            玩法的类型.只用于混投.其他玩法忽略itemType
	 * @return
	 */
	public static OptionItem getByPlayType(LotteryType type, String value, int itemType) {
		switch (type.getValue()) {
			case 20:
				return OptionItemDCRQSPF.getItemByValue(value);
			case 21:
				return OptionItemDCSXDS.getItemByValue(value);
			case 22:
				return OptionItemDCJQS.getItemByValue(value);
			case 23:
				return OptionItemDCBF.getItemByValue(value);
			case 24:
				return OptionItemDCBQC.getItemByValue(value);
			case 25:
				return OptionItemDCRQSPF.getItemByValue(value);
			case 30:
				return OptionItemSF.getItemByValue(value);
			case 31:
				return OptionItemRFSF.getItemByValue(value);
			case 32:
				return OptionItemSFC.getItemByValue(value);
			case 33:
				return OptionItemDXF.getItemByValue(value);
			case 41:
				return OptionItemSPF.getItemByValue(value);
			case 34:
				return OptionItemRQSPF.getItemByValue(value);
			case 35:
				return OptionItemBF.getItemByValue(value);
			case 36:
				return OptionItemJQS.getItemByValue(value);
			case 37:
				return OptionItemBQC.getItemByValue(value);
			case 42:
				return OptionItemHT.getItemByValue(itemType + "", value);
			case 43:
				return OptionItemHT.getItemByValue(itemType + "", value);
			case 304:
				return OptionItemHT.getItemByValue(itemType + "", value);
			case 44:
				return OptionItemHT2C1.getItemByValue(itemType + "", value);
			case 45:
				return OptionItemGYJ.getItemByValue(value);
			case 46:
				return OptionItemGYJ.getItemByValue(value);
			case 47:
				return OptionItemGYJ.getItemByValue(value);
			case 305:
				return OptionItemGYJ.getItemByValue(value);
			case 306:
				return OptionItemGYJ.getItemByValue(value);
			case 49:
				return OptionItemHT.getItemByValue(itemType + "", value);
			case 303:
				return OptionItemHT.getItemByValue(itemType + "", value);
			default:
				throw new RuntimeException("玩法类型不存在");
		}
	}

	public void setTypeValueStr(String str){}

	public Integer getRqs() {
		return rqs;
	}

	public void setRqs(Integer rqs) {
		this.rqs = rqs;
	}

	public Double getRf() {
		return rf;
	}
	public Double getRF(){
		return rf;
	}

	public void setRf(Double rf) {
		this.rf = rf;
	}
	public void setRF(Double rf) {
		this.rf = rf;
	}

	public Double getDxf() {
		return dxf;
	}
	public Double getDXF(){
		return dxf;
	}

	public void setDxf(Double dxf) {
		this.dxf = dxf;
	}
	public void setDXF(Double dxf){
		this.dxf=dxf;
	}

	public Integer getBetMoney() {
		return betMoney;
	}

	public void setBetMoney(Integer betMoney) {
		this.betMoney = betMoney;
	}

	public String getSubType() {
		return this.subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public Integer getEach() {
		each=each==null?2:each;
		return each;
	}

	public void setEach(Integer each) {
		this.each = each;
	}

	
}
