package com.qiyun.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryType extends IntegerBeanLabelItem {

	private static final long serialVersionUID = 1L;

	protected LotteryType(String name, int value) {
		super(LotteryType.class.getName(), name, value);
	}

	public static LotteryType getItem(int value) {
		return (LotteryType) LotteryType.getResult(LotteryType.class.getName(),value);
		
	}
	@Override
	public boolean equals(Object obj) {
        if (obj instanceof LotteryType) {
        	LotteryType target = (LotteryType) obj;
        	return target.getValue()==this.getValue();
        }
        return false;
    }
	@Override       
    public int hashCode() {
		return this.getValue();            
    }

	public final static LotteryType NENO = new LotteryType("全部", -1);
	// 体彩
	/** 大乐透 **/
	public final static LotteryType DLT = new LotteryType("大乐透", 1);
	/** 七星彩 **/
	public final static LotteryType QXC = new LotteryType("七星彩", 2);
	/** 排列3 **/
	public final static LotteryType PL3 = new LotteryType("排列3", 3);
	/** 排列5 **/
	public final static LotteryType PL5 = new LotteryType("排列5", 4);
	
	public final static LotteryType SFC = new LotteryType("胜负彩14场", 5);
	public final static LotteryType SFR9 = new LotteryType("胜负任9", 6);
	public final static LotteryType JQC = new LotteryType("4场进球", 7);
	public final static LotteryType BQC = new LotteryType("6场半全场", 8);
	
	/** 数字彩 **/
	public final static LotteryType NUM_COLOR = new LotteryType("数字彩", 11);
	/** 高频彩 **/
	public final static LotteryType GP_COLOR = new LotteryType("高频彩", 12);
	/** 竞技彩 **/
	public final static LotteryType JJ_COLOR = new LotteryType("竞技彩", 13);

	// 20-30 单场
	public final static LotteryType DC_SFP = new LotteryType("单场胜平负", 20);
	public final static LotteryType DC_SXDS = new LotteryType("单场上下盘单数", 21);
	public final static LotteryType DC_JQS = new LotteryType("单场总进球数", 22);
	public final static LotteryType DC_BF = new LotteryType("单场正确比分", 23);
	public final static LotteryType DC_BCSFP = new LotteryType("单场半全场胜平负", 24);
	public final static LotteryType DC_SFGG = new LotteryType("单场胜负过关", 25);
	public final static LotteryType DC = new LotteryType("北京单场", 40);
	public final static LotteryType TRADITION = new LotteryType("传统足彩", 10);
	
	// 30-33 竞彩篮球
	/** 竞彩篮球单关投注 **/
	public final static LotteryType JC_LQ_DGTZ = new LotteryType("竞彩篮球单关投注",304);
	/** 竞彩篮球胜负 **/
	public final static LotteryType JC_LQ_SF = new LotteryType("竞彩篮球胜负", 30);
	/** 竞彩篮球让分胜负 **/
	public final static LotteryType JC_LQ_RFSF = new LotteryType("竞彩篮球让分胜负", 31);
	/** 竞彩篮球胜分差 **/
	public final static LotteryType JC_LQ_SFC = new LotteryType("竞彩篮球胜分差", 32);
	/** 竞彩篮球大小分 **/
	public final static LotteryType JC_LQ_DXF = new LotteryType("竞彩篮球大小分", 33);
	/** 竞彩篮球混合过关 **/
	public final static LotteryType JC_LQ_HT = new LotteryType("竞彩篮球混合过关", 43);
	/** 竞彩篮球 **/
	public final static LotteryType JC_LQ = new LotteryType("竞彩篮球", 39);

	// 34-37 41,42,44竞彩足球
	/** 竞彩足球单关投注 **/
	public final static LotteryType JC_ZQ_DGTZ = new LotteryType("竞彩足球单关投注",303);
	/** 竞彩足球混合过关 **/
	public final static LotteryType JC_ZQ_HT = new LotteryType("竞彩足球混合过关", 42);
	/** 竞彩足球胜平负 **/
	public final static LotteryType JC_ZQ_SPF = new LotteryType("竞彩足球胜平负", 41);
	/** 竞彩足球让球胜平负 **/
	public final static LotteryType JC_ZQ_RQSPF = new LotteryType("竞彩足球让球胜平负",34);
	/** 竞彩足球比分 **/
	public final static LotteryType JC_ZQ_BF = new LotteryType("竞彩足球比分", 35);
	/** 竞彩足球进球胜 **/
	public final static LotteryType JC_ZQ_JQS = new LotteryType("竞彩足球进球胜", 36);
	/** 竞彩足球半全场 **/
	public final static LotteryType JC_ZQ_BQC = new LotteryType("竞彩足球半全场", 37);
	/** 竞彩足球亚盘 **/
	public final static LotteryType JC_ZQ_ALTERNATIVE = new LotteryType("竞彩足球亚盘", 44);
	/** 竞彩足球 **/
	public final static LotteryType JC_ZQ = new LotteryType("竞彩足球", 38);
	/** 竞彩足球冠亚军 **/
	public final static LotteryType JC_ZQ_GYJ = new LotteryType("竞彩足球冠亚军", 48);
	/** 欧冠杯冠军 **/
	public final static LotteryType JC_ZQ_GJ_OG = new LotteryType("欧冠杯冠军", 45);
	/** 世界杯冠军 **/
	public final static LotteryType JC_ZQ_GJ_WORLD = new LotteryType("世界杯冠军",46);
	/** 世界杯冠亚军 **/
	public final static LotteryType JC_ZQ_GYJ_WORLD = new LotteryType("世界杯冠亚军",47);
	/** 欧洲杯冠军 **/
	public final static LotteryType JC_ZQ_GJ_UEFA = new LotteryType("欧洲杯冠军",305);
	/** 欧洲杯冠亚军 **/
	public final static LotteryType JC_ZQ_GYJ_UEFA = new LotteryType("欧洲杯冠亚军",306);
	/** 胜平负&让球胜平负合 **/
	public final static LotteryType JC_ZQ_SPFHT = new LotteryType("竞彩足球胜平负/让球",49);

	// 体彩高频
	/** 山东11选5 **/
	public final static LotteryType SYYDJ = new LotteryType("山东11选5", 50);
	/** 快乐123 **/
	public final static LotteryType KL123 = new LotteryType("快乐123", 51);
	/** 江西11选5 **/
	public final static LotteryType JXDLC = new LotteryType("江西11选5", 52);
	/** 广东11选5 **/
	public final static LotteryType GD11X5 = new LotteryType("广东11选5", 53);
	/** 重庆11选5 **/
	public final static LotteryType CQ11X5 = new LotteryType("重庆11选5", 54);
	/** 辽宁11选5 **/
	public final static LotteryType LN11X5 = new LotteryType("辽宁11选5", 55);
	/** 山东快乐扑克3 **/
	public final static LotteryType POKER3 = new LotteryType("山东快乐扑克3", 56);
	/** 上海11选5 **/
	public final static LotteryType SH11X5 = new LotteryType("上海11选5", 57);
	/** 黑龙江11选5 **/
	public final static LotteryType HLJ11X5 = new LotteryType("黑龙江11选5", 58);
	/** 江苏11选5 **/
	public final static LotteryType JS11X5 = new LotteryType("江苏11选5", 59);
	// 11选5抓取系列
	/** 福建11选5 **/
	public final static LotteryType FJ11X5 = new LotteryType("福建11选5", 60);
	/** 浙江11选5 **/
	public final static LotteryType ZJ11X5 = new LotteryType("浙江11选5", 61);
	/** 吉林11选5 **/
	public final static LotteryType JL11X5 = new LotteryType("吉林11选5", 62);
	/** 湖北11选5 **/
	public final static LotteryType HB11X5 = new LotteryType("湖北11选5", 63);
	/** 广西11选5 **/
	public final static LotteryType GX11X5 = new LotteryType("广西11选5", 64);
	/** 天津11选5 **/
	public final static LotteryType TJ11X5 = new LotteryType("天津11选5", 65);
	/** 新疆11选5 **/
	//public final static LotteryType XJ11X5 = new LotteryType("新疆11选5", 66);
	/** 安徽11选5 **/
	public final static LotteryType AH11X5 = new LotteryType("安徽11选5", 67);
	/** 山西11选5 **/
	public final static LotteryType SX11X5 = new LotteryType("山西11选5", 68);
	/** 甘肃11选5 **/
	public final static LotteryType GS11X5 = new LotteryType("甘肃11选5", 69);
	/** 四川11选5 **/
	public final static LotteryType SC11X5 = new LotteryType("四川11选5", 70);
	/** 陕西11选5 **/
	public final static LotteryType SHANX11X5 = new LotteryType("陕西11选5", 71);
	/** 贵州11选5 **/
	public final static LotteryType GZ11X5 = new LotteryType("贵州11选5", 72);
	/** 河南11选5 **/
	public final static LotteryType HEN11X5 = new LotteryType("河南11选5", 73);
	/** 河北11选5 **/
	public final static LotteryType HEB11X5 = new LotteryType("河北11选5", 74);
	/** 北京11选5 **/
	public final static LotteryType BJ11X5 = new LotteryType("北京11选5", 75);
	/** 云南11选5 **/
	public final static LotteryType YN11X5 = new LotteryType("云南11选5", 76);
	/** 内蒙古11选5 **/
	public final static LotteryType NMG11X5 = new LotteryType("内蒙古11选5", 77);

	// 福彩
	/** 双色球 **/
	public final static LotteryType SSQ = new LotteryType("双色球", 100);
	/** 七乐彩 **/
	public final static LotteryType QLC = new LotteryType("七乐彩", 101);
	/** 3D **/
	public final static LotteryType FC3D = new LotteryType("3D", 102);

	// 福彩高频
	/** 重庆时时彩 **/
	public final static LotteryType SSC = new LotteryType("重庆时时彩", 150);
	/** 时时彩 **/
	public final static LotteryType SSL = new LotteryType("时时彩", 151);
	/** 广东快乐十分 **/
	public final static LotteryType KLSF = new LotteryType("广东快乐十分", 152);
	/** 江西时时彩 **/
	public final static LotteryType JXSSC = new LotteryType("江西时时彩", 153);
	/** 山东群英会 **/
	public final static LotteryType SDQYH = new LotteryType("山东群英会", 154);
	/** 广西快乐十分 **/
	public final static LotteryType GXKLSF = new LotteryType("广西快乐十分", 155);
	/** 快乐8 **/
	public final static LotteryType KL8 = new LotteryType("快乐8", 156);

	/** 江苏快3 **/
	public final static LotteryType K3 = new LotteryType("江苏快3", 157);
	/** 重庆快乐十分 **/
	public final static LotteryType CQ_KLSF = new LotteryType("重庆快乐十分", 158);
	/** 吉林快3 **/
	public final static LotteryType JL_K3 = new LotteryType("吉林快3", 159);
	/** 河南快乐十分 **/
	public final static LotteryType HN_KLSF = new LotteryType("快乐十分", 160);
	/** 湖北快3 **/
	public final static LotteryType HB_K3 = new LotteryType("湖北快3", 161);
	/** 新群英会 **/
	public final static LotteryType SDQYH_NEW = new LotteryType("新群英会", 162);
	/** 安徽快3 **/
	public final static LotteryType AH_K3 = new LotteryType("安徽快3", 163);
	/** 江西快3 **/
	public final static LotteryType JX_K3 = new LotteryType("江西快3", 174);
	// 快3抓取系列
	/** 广西快3 **/
	public final static LotteryType GX_K3 = new LotteryType("广西快3", 165);
	/** 河北快3 **/
	public final static LotteryType HEB_K3 = new LotteryType("河北快3", 166);
	/** 福建快3 **/
	public final static LotteryType FJ_K3 = new LotteryType("福建快3", 167);
	/** 上海快3 **/
	public final static LotteryType SH_K3 = new LotteryType("上海快3", 168);
	/** 甘肃快3 **/
	public final static LotteryType GS_K3 = new LotteryType("甘肃快3", 169);

	/** 高频彩种 **/
	public static Map<Integer, LotteryType> gpMap = new HashMap<Integer, LotteryType>();
	/** 小盘玩法 **/
	public static Map<Integer, LotteryType> xpMap = new HashMap<Integer, LotteryType>();
	/** 会限号的 **/
	public static Map<Integer, LotteryType> xianhaoMap = new HashMap<Integer, LotteryType>();

	/** 全部彩种集合 **/
	public static List<LotteryType> list = new ArrayList<LotteryType>();
	/** 篮球竞赛集合 **/
	public static List<LotteryType> JCLQList = new ArrayList<LotteryType>();
	/** 单场集合 **/
	public static List<LotteryType> DCZQList = new ArrayList<LotteryType>();
	/** 传统足彩集合 */
	public static List<LotteryType> CTZQList = new ArrayList<LotteryType>();
	/** 足球竞赛集合 **/
	public static List<LotteryType> JCZQList = new ArrayList<LotteryType>();
	/** 传统数字彩集合 **/
	public static List<LotteryType> CTSZCList = new ArrayList<LotteryType>();
	/** 高频彩集合 **/
	public static List<LotteryType> GPList = new ArrayList<LotteryType>();
	/** 竞技彩集合 **/
	public static List<LotteryType> JJCList = new ArrayList<LotteryType>();
	/** 购彩大厅下拉集合 **/
	public static List<LotteryType> lotteryIndextList = new ArrayList<LotteryType>();
	/** 竞技彩集合 (单场，竞彩足球，篮球) **/
	public static List<LotteryType> JJC_LIST = new ArrayList<LotteryType>();

	/** 冠亚军集合*(欧冠杯,世界杯) **/
	public static List<LotteryType> GYJ_ZQ_LIST = new ArrayList<LotteryType>();
	/** 冠亚军集合*(欧冠杯,世界杯) **/
	public static List<LotteryType> GYJ_LIST = new ArrayList<LotteryType>();
	/** 冠军集合*(欧冠杯,世界杯) **/
	public static List<LotteryType> GJ_LIST = new ArrayList<LotteryType>();

	/** 11选5系列 **/
	public static List<LotteryType> SYXW_LIST = new ArrayList<LotteryType>();
	/** 快三系列 **/
	public static List<LotteryType> K3_LIST = new ArrayList<LotteryType>();
	/** 时时彩系列 **/
	public static List<LotteryType> SSC_LIST = new ArrayList<LotteryType>();
	/** 快乐十分系列 **/
	public static List<LotteryType> KLSF_LIST = new ArrayList<LotteryType>();
	/** 群英会 **/
	public static List<LotteryType> QYH_LIST = new ArrayList<LotteryType>();
	/** 扑克三系列 **/
	public static List<LotteryType> POKER3_LIST = new ArrayList<LotteryType>();
	/** 其他系列(停售的彩种) **/
	public static List<LotteryType> OTHER_LIST = new ArrayList<LotteryType>();
	/** 11选5系列抓取 **/
	public static List<LotteryType> SYXW_SNATCH_LIST = new ArrayList<LotteryType>();
	/** 快三系列抓取 **/
	public static List<LotteryType> K3_SNATCH_LIST = new ArrayList<LotteryType>();
	/** 竞彩混投集合(包括竞彩足球二选一) **/
	public final static List<LotteryType> JC_HT_LIST = new ArrayList<LotteryType>();
	/**  **/
	public final static Map<LotteryType, String> LOTTERY_PATH = new HashMap<LotteryType, String>();
	/**  **/
	public static List<LotteryType> canBuyAgainList = new ArrayList<LotteryType>();
	/**  **/
	public static List<LotteryType> URLList = new ArrayList<LotteryType>();
	/** 停售的彩种列表 **/
	public static List<LotteryType> STOP_LOTTERY_LIST = new ArrayList<LotteryType>();

	/** 胜平负(单场投注选项) **/
	public static final String[] dcSpfOptionsArr = new String[] { "3", "1", "0" };
	/** 胜负(单场投注选项) **/
	public static final String[] dcSfOptionsArr = new String[] { "3", "0" };
	/** 比分(单场投注选项) **/
	public static final String[] dcBfOptionsArr = new String[] { "0", "1", "2",
			"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
			"15", "16", "17", "18", "19", "20", "21", "22", "23", "24" };
	/** 胜胜，胜平，胜负，平胜，平平，平负，负胜，负平，负负(单场投注选项) **/
	public static final String[] dcBqcOptionsArr = new String[] { "0", "1",
			"2", "3", "4", "5", "6", "7", "8" };
	/** 0~7+球(单场投注选项) **/
	public static final String[] dcJqsOptionsArr = new String[] { "0", "1",
			"2", "3", "4", "5", "6", "7" };
	/** 上单，上双，下单，下双(单场投注选项) **/
	public static final String[] dcSxdsOptionsArr = new String[] { "0", "1",
			"2", "3" };
	/** 竞彩BF(单场投注选项) **/
	public static final String[] dcZQBfOptionsArr = new String[] { "10", "20",
			"21", "30", "31", "32", "40", "41", "42", "50", "51", "52", "WW",
			"00", "11", "22", "33", "DD", "01", "02", "12", "03", "13", "23",
			"04", "14", "24", "05", "15", "25", "LL" };
	/** 竞彩bqc(单场投注选项) **/
	public static final String[] dcZQBqcOptionsArr = new String[] { "33", "31",
			"30", "13", "11", "10", "03", "01", "00" };
	/** 竞彩2选1(单场投注选项) **/
	public static final String[] jczq2x1OptionsArr = new String[] { "3", "0" };
	/** 冠亚军(单场投注选项) **/
	public static final String[] jczqGyjOptionsArr = new String[] { "3" };

	/** 让分胜负(篮球) **/
	public static final String[] lqRfsfOptionsArr = new String[] { "3", "0" };
	/** 胜分差(篮球) **/
	public static final String[] lqSfcOptionsArr = new String[] { "0", "1",
			"2", "3", "4", "5", "6", "7", "8", "9", "10", "11" };

	/**  **/
	public static final String[] jcHtOptionsArr = new String[] { "0", "1", "2",
			"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
			"15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "30",
			"31", "32", "33", "40", "41", "42", "50", "51", "52", "WW", "00",
			"11", "DD", "01", "02", "03", "04", "24", "05", "25", "LL" };
	/**  **/
	public static final String[] lqHtOptionsArr = new String[] { "0", "3", "0",
			"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11" };

	static {
		CTZQList.add(LotteryType.SFC);
		CTZQList.add(LotteryType.SFR9);
		CTZQList.add(LotteryType.JQC);
		CTZQList.add(LotteryType.BQC);
		
		DCZQList.add(LotteryType.DC_SFP);
		DCZQList.add(LotteryType.DC_BF);
		DCZQList.add(LotteryType.DC_SXDS);
		DCZQList.add(LotteryType.DC_BCSFP);
		DCZQList.add(LotteryType.DC_JQS);
		DCZQList.add(LotteryType.DC_SFGG);
		
		JCLQList.add(LotteryType.JC_LQ_SF);
		JCLQList.add(LotteryType.JC_LQ_RFSF);
		JCLQList.add(LotteryType.JC_LQ_SFC);
		JCLQList.add(LotteryType.JC_LQ_DXF);
		JCLQList.add(LotteryType.JC_LQ_HT);
		JCLQList.add(LotteryType.JC_LQ_DGTZ);

		JCZQList.add(LotteryType.JC_ZQ_SPF);
		JCZQList.add(LotteryType.JC_ZQ_RQSPF);
		JCZQList.add(LotteryType.JC_ZQ_BQC);
		JCZQList.add(LotteryType.JC_ZQ_BF);
		JCZQList.add(LotteryType.JC_ZQ_JQS);
		JCZQList.add(LotteryType.JC_ZQ_HT);
		JCZQList.add(LotteryType.JC_ZQ_SPFHT);
		JCZQList.add(LotteryType.JC_ZQ_DGTZ);

		CTSZCList.add(LotteryType.DLT);
		CTSZCList.add(LotteryType.PL3);
		CTSZCList.add(LotteryType.PL5);
		CTSZCList.add(LotteryType.QXC);
		CTSZCList.add(LotteryType.SSQ);
		CTSZCList.add(LotteryType.FC3D);
		CTSZCList.add(LotteryType.QLC);

		SYXW_LIST.add(LotteryType.GD11X5);
		SYXW_LIST.add(LotteryType.JXDLC);
		SYXW_LIST.add(LotteryType.SYYDJ);
		SYXW_LIST.add(LotteryType.CQ11X5);
		SYXW_LIST.add(LotteryType.LN11X5);
		SYXW_LIST.add(LotteryType.SH11X5);
		SYXW_LIST.add(LotteryType.HLJ11X5);
		SYXW_LIST.add(LotteryType.JS11X5);

		K3_LIST.add(LotteryType.K3);
		K3_LIST.add(LotteryType.JL_K3);
		K3_LIST.add(LotteryType.HB_K3);
		K3_LIST.add(LotteryType.AH_K3);
		K3_LIST.add(LotteryType.JX_K3);

		SSC_LIST.add(LotteryType.SSC);

		KLSF_LIST.add(LotteryType.KLSF);
		KLSF_LIST.add(LotteryType.CQ_KLSF);

		POKER3_LIST.add(LotteryType.POKER3);

		OTHER_LIST.add(LotteryType.SSL);

		SYXW_SNATCH_LIST.add(GD11X5);
		SYXW_SNATCH_LIST.add(JXDLC);
		SYXW_SNATCH_LIST.add(SYYDJ);
		SYXW_SNATCH_LIST.add(LN11X5);
		SYXW_SNATCH_LIST.add(SH11X5);
		SYXW_SNATCH_LIST.add(HLJ11X5);
		SYXW_SNATCH_LIST.add(JS11X5);

		K3_SNATCH_LIST.add(K3);
		K3_SNATCH_LIST.add(JL_K3);
		K3_SNATCH_LIST.add(HB_K3);
		K3_SNATCH_LIST.add(AH_K3);
		K3_SNATCH_LIST.add(JX_K3);
		
		list.add(NENO);
		list.addAll(DCZQList);
		list.addAll(CTZQList);
		list.addAll(SYXW_SNATCH_LIST);
		list.addAll(SYXW_LIST);
		list.addAll(K3_SNATCH_LIST);
		list.addAll(K3_LIST);
		list.addAll(KLSF_LIST);
		list.addAll(SSC_LIST);
		list.addAll(POKER3_LIST);
		list.addAll(QYH_LIST);
		list.addAll(OTHER_LIST);
		list.addAll(CTSZCList);
		list.addAll(JCZQList);
		list.addAll(JCLQList);
		list.addAll(GYJ_ZQ_LIST);
		
		// 购彩大厅彩种设置
		lotteryIndextList.add(NENO);
		lotteryIndextList.add(JC_LQ);
		lotteryIndextList.add(JC_ZQ);
		lotteryIndextList.add(JC_ZQ_ALTERNATIVE);
		lotteryIndextList.addAll(CTSZCList);
		lotteryIndextList.addAll(SYXW_LIST);
		lotteryIndextList.addAll(SSC_LIST);
		lotteryIndextList.addAll(KLSF_LIST);
		lotteryIndextList.addAll(QYH_LIST);
		lotteryIndextList.addAll(POKER3_LIST);
		lotteryIndextList.addAll(K3_LIST);
		lotteryIndextList.addAll(OTHER_LIST);

		// 再次购买彩种设置
		canBuyAgainList.addAll(CTSZCList);
		canBuyAgainList.addAll(SYXW_LIST);
		canBuyAgainList.addAll(SSC_LIST);
		canBuyAgainList.addAll(KLSF_LIST);
		canBuyAgainList.addAll(QYH_LIST);
		canBuyAgainList.addAll(POKER3_LIST);
		canBuyAgainList.addAll(K3_LIST);
		canBuyAgainList.addAll(OTHER_LIST);
		canBuyAgainList.addAll(SYXW_SNATCH_LIST);
		canBuyAgainList.addAll(K3_SNATCH_LIST);

		// 高频彩种List
		GPList.addAll(SYXW_LIST);
		GPList.addAll(SSC_LIST);
		GPList.addAll(KLSF_LIST);
		GPList.addAll(QYH_LIST);
		GPList.addAll(POKER3_LIST);
		GPList.addAll(K3_LIST);
		GPList.addAll(OTHER_LIST);
		GPList.addAll(SYXW_SNATCH_LIST);
		GPList.addAll(K3_SNATCH_LIST);

		// 高频彩种Map
		for (LotteryType lt : GPList) {
			gpMap.put(lt.getValue(), lt);
		}

		// 小盘固定奖彩种
		xpMap.put(PL3.getValue(), PL3);
		xpMap.put(PL5.getValue(), PL5);
		xpMap.put(FC3D.getValue(), FC3D);

		// 会限号的彩种，用来自动发送限号短信用的
		for (LotteryType lt : GPList) {
			xianhaoMap.put(lt.getValue(), lt);
		}
		xianhaoMap.put(PL3.getValue(), PL3);
		xianhaoMap.put(FC3D.getValue(), FC3D);

		JJCList.add(JC_LQ);
		JJCList.add(JC_ZQ);
		JJCList.add(JC_ZQ_ALTERNATIVE);
		JJCList.add(JC_ZQ_GYJ);
		JJCList.add(JC_ZQ_GJ_OG);
		JJCList.add(JC_ZQ_GJ_WORLD);
		JJCList.add(JC_ZQ_GYJ_WORLD);
		JJCList.add(JC_ZQ_GJ_UEFA);
		JJCList.add(JC_ZQ_GYJ_UEFA);

		JJC_LIST.addAll(JCLQList);
		JJC_LIST.addAll(JCZQList);

		JC_HT_LIST.add(JC_LQ_HT);
		JC_HT_LIST.add(JC_ZQ_HT);
		JC_HT_LIST.add(JC_ZQ_SPFHT);
		JC_HT_LIST.add(JC_ZQ_DGTZ);
		JC_HT_LIST.add(JC_LQ_DGTZ);
		JC_HT_LIST.add(JC_ZQ_ALTERNATIVE);

		// 高频
		LOTTERY_PATH.put(GD11X5, "gd11x5");
		LOTTERY_PATH.put(JXDLC, "jx11x5");
		LOTTERY_PATH.put(SYYDJ, "11yun");
		LOTTERY_PATH.put(CQ11X5, "cq11x5");
		LOTTERY_PATH.put(LN11X5, "ln11x5");
		LOTTERY_PATH.put(SH11X5, "sh11x5");
		LOTTERY_PATH.put(HLJ11X5, "hlj11x5");
		LOTTERY_PATH.put(JS11X5, "js11x5");
		LOTTERY_PATH.put(FJ11X5, "fj11x5");
		LOTTERY_PATH.put(ZJ11X5, "zj11x5");
		LOTTERY_PATH.put(JL11X5, "jl11x5");
		LOTTERY_PATH.put(HB11X5, "hb11x5");
		LOTTERY_PATH.put(GX11X5, "gx11x5");
		LOTTERY_PATH.put(TJ11X5, "tj11x5");
		LOTTERY_PATH.put(AH11X5, "ah11x5");
		LOTTERY_PATH.put(SX11X5, "sx11x5");
		LOTTERY_PATH.put(GS11X5, "gs11x5");
		LOTTERY_PATH.put(SC11X5, "sc11x5");
		LOTTERY_PATH.put(SHANX11X5, "shanx11x5");
		LOTTERY_PATH.put(GZ11X5, "gz11x5");
		LOTTERY_PATH.put(HEN11X5, "hen11x5");
		LOTTERY_PATH.put(HEB11X5, "heb11x5");
		LOTTERY_PATH.put(BJ11X5, "bj11x5");
		LOTTERY_PATH.put(YN11X5, "yn11x5");
		LOTTERY_PATH.put(NMG11X5, "nmg11x5");

		LOTTERY_PATH.put(K3, "k3");
		LOTTERY_PATH.put(JL_K3, "jlk3");
		LOTTERY_PATH.put(HB_K3, "hbk3");
		LOTTERY_PATH.put(AH_K3, "ahk3");
		LOTTERY_PATH.put(JX_K3, "jxk3");


		LOTTERY_PATH.put(SSC, "ssc");
		LOTTERY_PATH.put(JXSSC, "jxssc");

		LOTTERY_PATH.put(KLSF, "klsf");
		LOTTERY_PATH.put(CQ_KLSF, "cqklsf");
		LOTTERY_PATH.put(GXKLSF, "gxklsf");
		LOTTERY_PATH.put(HN_KLSF, "hnklsf");

		LOTTERY_PATH.put(POKER3, "sdklpk3");
		LOTTERY_PATH.put(SSL, "ssl");

		// 福彩
		LOTTERY_PATH.put(SSQ, "ssq");
		LOTTERY_PATH.put(FC3D, "3d");
		LOTTERY_PATH.put(QLC, "qlc");

		// 体彩
		LOTTERY_PATH.put(DLT, "dlt");
		LOTTERY_PATH.put(QXC, "qxc");
		LOTTERY_PATH.put(PL3, "p3");
		LOTTERY_PATH.put(PL5, "p5");

		// LOTTERY_PATH.put(SFC, "fbsfc");//胜负彩14场
		// LOTTERY_PATH.put(SFR9, "fbr9");//胜负任9
		// LOTTERY_PATH.put(JQC, "fbjq4");//4场进球
		// LOTTERY_PATH.put(BQC, "fb6cbq");//6场半全场

		// 竞彩

		// 30-33 竞彩篮球
		LOTTERY_PATH.put(JC_LQ, "basketball");//
		LOTTERY_PATH.put(JC_LQ_SF, "basketball/lqsf.shtml");//
		LOTTERY_PATH.put(JC_LQ_RFSF, "basketball");//
		LOTTERY_PATH.put(JC_LQ_SFC, "basketball/lqsfc.shtml");//
		LOTTERY_PATH.put(JC_LQ_DXF, "basketball/lqdxf.shtml");//
		LOTTERY_PATH.put(JC_LQ_HT, "basketball/lqht.shtml");//
		LOTTERY_PATH.put(JC_LQ_DGTZ, "basketball/dgtz.shtml");

		// 34-37 41,42竞彩足球
		LOTTERY_PATH.put(JC_ZQ, "jingcai");//
		LOTTERY_PATH.put(JC_ZQ_HT, "jingcai/zqht.shtml");//
		LOTTERY_PATH.put(JC_ZQ_SPF, "jingcai/zqspf.shtml");//
		LOTTERY_PATH.put(JC_ZQ_RQSPF, "jingcai/zqrqspf.shtml");//
		LOTTERY_PATH.put(JC_ZQ_BF, "jingcai/zqbf.shtml");//
		LOTTERY_PATH.put(JC_ZQ_JQS, "jingcai/zqjqs.shtml");//
		LOTTERY_PATH.put(JC_ZQ_BQC, "jingcai/zqbqc.shtml");//
		LOTTERY_PATH.put(JC_ZQ_ALTERNATIVE, "jingcai/ht2c1.shtml");// 竞彩足球2选1
		LOTTERY_PATH.put(JC_ZQ_SPFHT, "jingcai");// 竞彩足球2选1
		LOTTERY_PATH.put(JC_ZQ_GJ_OG, "2014cup");
		LOTTERY_PATH.put(JC_ZQ_GJ_WORLD, "2014cup");
		LOTTERY_PATH.put(JC_ZQ_GYJ_WORLD, "2014cup");
		LOTTERY_PATH.put(JC_ZQ_GJ_UEFA, "2016cup");
		LOTTERY_PATH.put(JC_ZQ_GYJ_UEFA, "2016cup");
		LOTTERY_PATH.put(JC_ZQ_DGTZ, "jingcai/dgtz.shtml");

		STOP_LOTTERY_LIST.add(SSL);
		STOP_LOTTERY_LIST.add(KL8);
		STOP_LOTTERY_LIST.add(GXKLSF);
		STOP_LOTTERY_LIST.add(HN_KLSF);
		STOP_LOTTERY_LIST.add(SDQYH);
		STOP_LOTTERY_LIST.add(JXSSC);
		STOP_LOTTERY_LIST.add(SDQYH_NEW);

		STOP_LOTTERY_LIST.add(KL123);
		STOP_LOTTERY_LIST.add(CQ11X5);
		STOP_LOTTERY_LIST.add(FJ11X5);
		STOP_LOTTERY_LIST.add(ZJ11X5);
		STOP_LOTTERY_LIST.add(JL11X5);
		STOP_LOTTERY_LIST.add(HB11X5);
		STOP_LOTTERY_LIST.add(GX11X5);
		STOP_LOTTERY_LIST.add(TJ11X5);
		STOP_LOTTERY_LIST.add(AH11X5);
		STOP_LOTTERY_LIST.add(SX11X5);
		STOP_LOTTERY_LIST.add(GS11X5);
		STOP_LOTTERY_LIST.add(SC11X5);
		STOP_LOTTERY_LIST.add(SHANX11X5);
		STOP_LOTTERY_LIST.add(GZ11X5);
		STOP_LOTTERY_LIST.add(HEN11X5);
		STOP_LOTTERY_LIST.add(HEB11X5);
		STOP_LOTTERY_LIST.add(BJ11X5);
		STOP_LOTTERY_LIST.add(YN11X5);
		STOP_LOTTERY_LIST.add(NMG11X5);

		STOP_LOTTERY_LIST.add(GX_K3);
		STOP_LOTTERY_LIST.add(HEB_K3);
		STOP_LOTTERY_LIST.add(FJ_K3);
		STOP_LOTTERY_LIST.add(SH_K3);
		STOP_LOTTERY_LIST.add(GS_K3);
	}

	public static LotteryType getJCLQType(int type) {
		for (LotteryType t : JCLQList) {
			if (t.getValue() == type)
				return t;
		}
		throw new RuntimeException("非竞彩篮球玩法");
	}

	public static String getURLType(int type) {
		for (LotteryType t : URLList) {
			if (t.getValue() == type)
				return t.getName();
		}
		return "";
	}

	public static LotteryType getJCZQType(int type) {
		for (LotteryType t : JCZQList) {
			if (t.getValue() == type)
				return t;
		}
		throw new RuntimeException("非竞彩足球玩法");
	}

	// 彩种缩写名字 新闻采用
	public static String getShortName(int value) {
		String shortName = "";
		LotteryType lotteryType = getItem(value);
		if (lotteryType != null) {
			if (JCZQList.contains(lotteryType)) {
				shortName = "竞彩";
			} else if (JCLQList.contains(lotteryType)) {
				shortName = "篮彩";
			} else {
				shortName = lotteryType.getName();
			}
		}
		return shortName;
	}

	public static String getTypeValueToString(List<LotteryType> list) {
		String valueStr = "";
		for (LotteryType t : list) {
			valueStr += !valueStr.equals("") ? "," + t.getValue() : t
					.getValue();
		}
		return valueStr;
	}

	

	public static List<LotteryType> getJCLQList() {
		return JCLQList;
	}

	public static List<LotteryType> getJCZQList() {
		return JCZQList;
	}



	public static List<LotteryType> getCTSZCList() {
		return CTSZCList;
	}

	public static List<LotteryType> getGPList() {
		return GPList;
	}

	public static List<LotteryType> getJJC_LIST() {
		return JJC_LIST;
	}

	public static List<LotteryType> getSYXW_LIST() {
		return SYXW_LIST;
	}

	public static List<LotteryType> getK3_LIST() {
		return K3_LIST;
	}

	public static List<Integer> getListForInteger(List<LotteryType> lotList) {
		List<Integer> list = new ArrayList<Integer>();

		for (LotteryType lotType : lotList) {
			list.add(lotType.getValue());
		}

		return list;
	}

	public static List<LotteryType> getGYJ_ZQ_LIST() {
		return GYJ_ZQ_LIST;
	}

	public static List<LotteryType> getGYJ_LIST() {
		return GYJ_LIST;
	}

	public static List<LotteryType> getGJ_LIST() {
		return GJ_LIST;
	}
}
