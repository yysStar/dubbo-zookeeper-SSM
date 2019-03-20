package com.qiyun.ticket;



import com.qiyun.model.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

public class TicketProvider extends IntegerBeanLabelItem {
	private static final long serialVersionUID = 1L;

	protected TicketProvider(String name, int value) {
		super(TicketProvider.class.getName(), name, value);
	}

	public static TicketProvider getItem(int value) {
		return (TicketProvider) TicketProvider.getResult(TicketProvider.class.getName(), value);
	}

	public static final TicketProvider ALL = new TicketProvider("全部", -1);

	public static final TicketProvider NO = new TicketProvider("无", 0);

	public static final TicketProvider HELPER_SH = new TicketProvider("恒朋_上海", 11);
	public static final TicketProvider HELPER_CQ = new TicketProvider("恒朋_重庆", 12);
	public static final TicketProvider HELPER_JX = new TicketProvider("恒朋_江西", 13);

	public static final TicketProvider DYJ = new TicketProvider("星彩", 2);

	public static final TicketProvider WXLT = new TicketProvider("风采博雅", 3);

	public static final TicketProvider ZZY = new TicketProvider("掌中弈", 4);

	public static final TicketProvider CT = new TicketProvider("彩通", 5);

	public static final TicketProvider STTC = new TicketProvider("汕头体彩", 6);

	public static final TicketProvider AB = new TicketProvider("爱波", 7);
	public static final TicketProvider HB = new TicketProvider("鸿博", 8);

	public static final TicketProvider SJZC_NM = new TicketProvider("世纪中彩_内蒙", 9);

	public static final TicketProvider HZ = new TicketProvider("海中", 10);
	public static final TicketProvider RLYG = new TicketProvider("睿朗阳光", 14);
	public static final TicketProvider YW = new TicketProvider("云网", 15);
	public static final TicketProvider YC = new TicketProvider("盈彩网", 16);
	public static final TicketProvider CQWX = new TicketProvider("重庆网讯", 17);
	public static final TicketProvider TW = new TicketProvider("泰网", 18);
	public static final TicketProvider KaiMi = new TicketProvider("凯米科技", 19);
	public static final TicketProvider JiuCheng = new TicketProvider("久诚科技", 20);
	public static final TicketProvider Cailele = new TicketProvider("本站点", 21);
	public static final TicketProvider FengCai = new TicketProvider("南京丰彩new", 22);
	public static final TicketProvider LC = new TicketProvider("量彩", 23);
	public static final TicketProvider LETOU = new TicketProvider("乐透", 24);
	public static final TicketProvider BoSheng = new TicketProvider("博圣", 25);
	
	public static final TicketProvider CaiSheng = new TicketProvider("彩胜天下", 26);
	public static final TicketProvider CaiBo = new TicketProvider("彩博", 27);
	public static final TicketProvider ZCH = new TicketProvider("中彩汇", 28);
	public static final TicketProvider DeCai = new TicketProvider("德彩", 29);
	public static final TicketProvider GaoHong = new TicketProvider("高鸿", 30);
	public static final TicketProvider HongCai = new TicketProvider("山东宏彩", 31);
	
	public static List<TicketProvider> list = new ArrayList<TicketProvider>();

	static {
		list.add(ALL);
		list.add(HELPER_SH);
		list.add(HELPER_CQ);
		list.add(HELPER_JX);

		list.add(DYJ);
		list.add(WXLT);
		list.add(ZZY);
		list.add(CT);
		list.add(AB);
		list.add(HB);

		list.add(STTC);
		list.add(SJZC_NM);
		list.add(HZ);
		list.add(RLYG);
		list.add(YW);
		list.add(YC);
		list.add(CQWX);
		list.add(TW);
		list.add(KaiMi);
		list.add(JiuCheng);
		list.add(Cailele);
		list.add(FengCai);
		list.add(LC);
		list.add(LETOU);
		list.add(BoSheng);
		list.add(CaiSheng);
		list.add(CaiBo);
		list.add(ZCH);
		list.add(DeCai);
		list.add(GaoHong);
		list.add(HongCai);
	}
}
