package com.qiyun.tools;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.commonModel.PlayType;

public class BallCodeConverter {

	public static String convert(int lt, int pt, String code) {
		String label = code;
		// 江西时时彩
		if (lt == LotteryType.JXSSC.getValue()) {
			if (pt == PlayType.JXSSC_DSDXDS.getValue() || pt == PlayType.JXSSC_DSDXFS.getValue()) {
				label = code.replaceAll("2", "大").replaceAll("1", "小").replaceAll("5", "单").replaceAll("4", "双");
			}
		}
		// 重庆时时彩
		else if (lt == LotteryType.SSC.getValue()) {
			if (pt == PlayType.DSDXDS.getValue() || pt == PlayType.DSDXFS.getValue()) {
				label = code.replaceAll("2", "大").replaceAll("1", "小").replaceAll("5", "单").replaceAll("4", "双");
			}
		}
		else if(lt==LotteryType.POKER3.getValue()){
			if (pt >= PlayType.R1_BZ.getValue() && pt <= PlayType.R6_BZ.getValue() ) {//任1-任6单式
				label = replacePoker3(label);
			
			}else if (pt >= PlayType.R1_FS.getValue() && pt <= PlayType.R6_FS.getValue() ) {//任1-任6复式
				label = replacePoker3(label);
			
			}else if (pt >= PlayType.R2_DT.getValue() && pt <= PlayType.R6_DT.getValue() ) {//任1-任6胆拖
				label = replacePoker3(label);
			
			} else if(pt == PlayType.POKER_THDX.getValue() || pt == PlayType.POKER_THDX_FS.getValue() ||
					  pt == PlayType.POKER_THSDX.getValue() || pt == PlayType.POKER_THSDX_FS.getValue() || 
					  pt == PlayType.POKER_THBX.getValue() || pt == PlayType.POKER_THSBX.getValue() ||
					  pt == PlayType.POKER_THTZ.getValue() || pt == PlayType.POKER_THSTZ.getValue()) {//票:同花单选和复选,同花顺单选和复选,同花包选,同花顺子包选 方案:同花投注,同花顺投注
				label = label.replaceAll("1", "黑桃").replaceAll("2", "红桃").replaceAll("3", "梅花").replaceAll("4", "方块");
				
				String thbx = PlayType.POKER_BX_MAP.get(PlayType.POKER_THTZ.getValue());
				label = label.replaceAll(thbx, "同花包选");
				
				String thsbx = PlayType.POKER_BX_MAP.get(PlayType.POKER_THSTZ.getValue());
				label = label.replaceAll(thsbx, "同花顺包选");
				
			} else if (pt == PlayType.POKER_SZDX.getValue() || pt == PlayType.POKER_SZDX_FS.getValue() || 
					   pt == PlayType.POKER_SZBX.getValue() || 
					   pt == PlayType.POKER_SZTZ.getValue()) {//票:顺子单选和复选 顺子包选 方案:顺子投注
				label = replacePoker3(label);
				
				String szbx = PlayType.POKER_BX_MAP.get(PlayType.POKER_SZTZ.getValue());
				label = label.replaceAll(szbx, "顺子包选");
				
			} else if (pt == PlayType.POKER_DZDX.getValue() || pt == PlayType.POKER_DZDX_FS.getValue() ||
					   pt == PlayType.POKER_BZDX.getValue() || pt == PlayType.POKER_BZDX_FS.getValue() ||
					   pt == PlayType.POKER_DZBX.getValue() || pt == PlayType.POKER_BZBX.getValue() ||
					   pt == PlayType.POKER_THAOTZ.getValue()) {//票:对子单选和复选,豹子单选和复选,对子包选，豹子包选  方案:同号投注
				label = replacePoker3(label);
				
				String dzbx = PlayType.POKER_BX_MAP.get(PlayType.POKER_DZBX.getValue());
				label = label.replaceAll(dzbx, "对子包选");
				
				String bzbx = PlayType.POKER_BX_MAP.get(PlayType.POKER_BZBX.getValue());
				label = label.replaceAll(bzbx, "豹子包选");
			}
		}else if(lt == LotteryType.FC3D.getValue()){
			if(pt == PlayType.DX.getValue()){
				label = label.replaceAll("1", "小").replaceAll("2", "大");
			}else if(pt == PlayType.JO.getValue()){
				label = label.replaceAll("4", "偶").replaceAll("5", "奇");
			}else if(pt == PlayType.C3T.getValue()){
				label = label.replaceAll("C3T", "猜三同");
			}else if(pt == PlayType.TLJ.getValue()){
				label = label.replaceAll("TLJ", "拖拉机");
			}
		}

		return label;
	}

	private static String replacePoker3(String label) {
		label = label.replaceAll("11", "J").replaceAll("12", "Q").replaceAll("13", "K")
		             .replaceAll("01", "A").replaceAll("02", "2").replaceAll("03", "3").replaceAll("04", "4").replaceAll("05", "5")
					 .replaceAll("06", "6").replaceAll("07", "7").replaceAll("08", "8").replaceAll("09", "9");
		return label;
	}
}
