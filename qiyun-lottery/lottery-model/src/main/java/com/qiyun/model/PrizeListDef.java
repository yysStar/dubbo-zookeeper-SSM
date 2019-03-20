package com.qiyun.model;

import java.util.HashMap;
import java.util.Map;

import com.qiyun.commonModel.LotteryType;

public class PrizeListDef {

	private static HashMap<Integer, Map<String, String>> prizeHashMap;
	public static Map<String, String> get(Integer v){
		if(prizeHashMap==null){
			prizeHashMap = new HashMap<Integer, Map<String, String>>();
			// prizeNameHashMap = new HashMap<Integer,List<String>>();

			Map<String, String> ssqMap = new HashMap<String, String>();
			ssqMap.put("prize1", "一等奖");
			ssqMap.put("prize2", "二等奖");
			ssqMap.put("prize3", "三等奖");
			ssqMap.put("prize4", "四等奖");
			ssqMap.put("prize5", "五等奖");
			ssqMap.put("prize6", "六等奖");
			ssqMap.put("prize7", "幸运二等奖");
			
			prizeHashMap.put(LotteryType.SSQ.getValue(), ssqMap);

			Map<String, String> pl5Map = new HashMap<String, String>();
			pl5Map.put("prize1", "直选");// 排五直选奖金
			prizeHashMap.put(LotteryType.PL5.getValue(), pl5Map);

			Map<String, String> pl3Map = new HashMap<String, String>();
			pl3Map.put("prize1", "直选");// 排三直选奖金
			pl3Map.put("prize2", "组选3");// 组选3奖金
			pl3Map.put("prize3", "组选6");// 组选6奖金
			prizeHashMap.put(LotteryType.PL3.getValue(), pl3Map);

			Map<String, String> fc3dMap = new HashMap<String, String>();
			fc3dMap.put("prize1", "直选");// 3D直选奖金
			fc3dMap.put("prize2", "组选3");// 3D组选3奖金
			fc3dMap.put("prize3", "组选6");// 3D组选6奖金	
			fc3dMap.put("prize4","1D投注");	//1D投注
			fc3dMap.put("prize5","2D投注");	//2D投注
			fc3dMap.put("prize6","猜1D猜中1");		//猜1D猜中1 2**、*2*、**2
			fc3dMap.put("prize7","猜1D猜中2");	//猜1D猜中2 22*、2*2、*22
			fc3dMap.put("prize8","猜1D猜中3");	//猜1D猜中3 222
			fc3dMap.put("prize9","猜2D两同号");	//猜2D两同号22
			fc3dMap.put("prize10","猜2D两不同号");	//猜2D两不同号
			fc3dMap.put("prize11","通选全中");	//通选1 数字按顺序全部相同
			fc3dMap.put("prize12","通选中二");	//通选2 数字按顺序中2
			fc3dMap.put("prize13","包三（三顺中）");	//包三（三顺中）
			fc3dMap.put("prize14","包三（三组中）");	//包三（三组中）
			fc3dMap.put("prize15","包六（六顺中）");	//包六（六顺中）
			fc3dMap.put("prize16","包六（六组中）");	//包六（六组中）
			fc3dMap.put("prize17","猜大小");		//猜大小
			fc3dMap.put("prize18","猜三同");	    //猜三同
			fc3dMap.put("prize19","拖拉机");	    //拖拉机
			fc3dMap.put("prize20","猜奇偶");		//猜奇偶
			
			fc3dMap.put("prize21","和值 0,27");	
			fc3dMap.put("prize22","和值 1,26");	
			fc3dMap.put("prize23","和值 2,25");	
			fc3dMap.put("prize24","和值 3,24");	
			fc3dMap.put("prize25","和值 4,23");	
			fc3dMap.put("prize26","和值 5,22");	
			fc3dMap.put("prize27","和值 6,21");	
			fc3dMap.put("prize28","和值 7,20");	
			fc3dMap.put("prize29","和值 8,19");	
			fc3dMap.put("prize30","和值 9,18");	
			fc3dMap.put("prize31","和值 10,17");	
			fc3dMap.put("prize32","和值 11,16");	
			fc3dMap.put("prize33","和值 12,15");	
			fc3dMap.put("prize34","和值 13,14");
			prizeHashMap.put(LotteryType.FC3D.getValue(), fc3dMap);

			Map<String, String> sscMap = new HashMap<String, String>();
			sscMap.put("prize1", "五星奖");
			sscMap.put("prize2", "三星奖");
			sscMap.put("prize3", "二星奖");
			sscMap.put("prize4", "一星奖");
			sscMap.put("prize5", "大小单双奖");
			sscMap.put("prize6", "二星组选奖");
			sscMap.put("prize7", "五星通选一等奖");
			sscMap.put("prize8", "五星通选二等奖");
			sscMap.put("prize9", "五星通选三等奖");
			sscMap.put("prize10", "组三奖");
			sscMap.put("prize11", "组六奖");
			prizeHashMap.put(LotteryType.SSC.getValue(), sscMap);

			Map<String, String> jxsscMap = new HashMap<String, String>();
			jxsscMap.put("prize1", "五星奖");
			jxsscMap.put("prize2", "三星奖");
			jxsscMap.put("prize3", "二星奖");
			jxsscMap.put("prize4", "一星奖");
			jxsscMap.put("prize5", "大小单双奖");
			jxsscMap.put("prize6", "二星组选奖");
			jxsscMap.put("prize7", "五星通选一等奖");
			jxsscMap.put("prize8", "五星通选二等奖");
			jxsscMap.put("prize9", "五星通选三等奖");
			jxsscMap.put("prize10", "组三奖");
			jxsscMap.put("prize11", "组六奖");
			jxsscMap.put("prize12", "四星奖");
			jxsscMap.put("prize13", "四星二等奖");
			//新增
			jxsscMap.put("prize14", "任选1奖");
			jxsscMap.put("prize15", "任选2奖");


			prizeHashMap.put(LotteryType.JXSSC.getValue(), jxsscMap);

			Map<String, String> qlcMap = new HashMap<String, String>();
			qlcMap.put("prize1", "一等奖");
			qlcMap.put("prize2", "二等奖");
			qlcMap.put("prize3", "三等奖");
			qlcMap.put("prize4", "四等奖");
			qlcMap.put("prize5", "五等奖");
			qlcMap.put("prize6", "六等奖");
			qlcMap.put("prize7", "七等奖");
			qlcMap.put("prize8", "特别奖");
			prizeHashMap.put(LotteryType.QLC.getValue(), qlcMap);


			Map<String, String> dltMap = new HashMap<String, String>();
			dltMap.put("prize1", "一等奖");
			dltMap.put("prize2", "一等奖追加");
			dltMap.put("prize3", "二等奖");
			dltMap.put("prize4", "二等奖追加");
			dltMap.put("prize5", "三等奖");
			dltMap.put("prize6", "三等奖追加");
			dltMap.put("prize7", "四等奖");
			dltMap.put("prize8", "五等奖");
			dltMap.put("prize9", "六等奖");
			dltMap.put("prize10", "七等奖");
			dltMap.put("prize11", "八等奖");
			dltMap.put("prize12", "幸运奖");
			dltMap.put("prize13", "四等奖追加");
			dltMap.put("prize14", "五等奖追加");
			dltMap.put("prize15", "六等奖追加");
			dltMap.put("prize16", "七等奖追加");
			
			dltMap.put("prize17", "宝石一等奖");
			dltMap.put("prize18", "宝石二等奖");
			dltMap.put("prize19", "宝石三等奖");
			dltMap.put("prize20", "宝石四等奖");
			
			dltMap.put("prize21", "钻石一等奖");
			dltMap.put("prize22", "钻石二等奖");
			dltMap.put("prize23", "钻石三等奖");
			dltMap.put("prize24", "钻石四等奖");
			
			prizeHashMap.put(LotteryType.DLT.getValue(), dltMap);


			Map<String, String> qxcMap = new HashMap<String, String>();
			qxcMap.put("prize1", "一等奖");
			qxcMap.put("prize2", "二等奖");
			qxcMap.put("prize3", "三等奖");
			qxcMap.put("prize4", "四等奖");
			qxcMap.put("prize5", "五等奖");
			qxcMap.put("prize6", "六等奖");
			prizeHashMap.put(LotteryType.QXC.getValue(), qxcMap);


			Map<String, String> sslMap = new HashMap<String, String>();
			sslMap.put("prize1", "直选奖金");
			sslMap.put("prize2", "组选3奖金");
			sslMap.put("prize3", "组选6奖金");
			sslMap.put("prize4", "前二奖金");
			sslMap.put("prize5", "后二奖金");
			sslMap.put("prize6", "前一奖金");
			sslMap.put("prize7", "后一奖金");
			prizeHashMap.put(LotteryType.SSL.getValue(), sslMap);

			/*
			 * Map t22x5Map = new HashMap<String,String>(); t22x5Map.put("prize1",
			 * "一等奖"); t22x5Map.put("prize2", "二等奖"); t22x5Map.put("prize3", "三等奖");
			 * prizeHashMap.put(LotteryType.T22X5.getValue(), t22x5Map);
			 */

			Map<String, String> kl123Map = new HashMap<String, String>();
			kl123Map.put("prize1", "任选一中1");
			kl123Map.put("prize2", "任选二中2");
			kl123Map.put("prize3", "任选三中3");
			kl123Map.put("prize4", "任选三中2");
			kl123Map.put("prize5", "任选四中3");
			kl123Map.put("prize6", "任选四中2");
			kl123Map.put("prize7", "任选五中3");
			kl123Map.put("prize8", "任选五中2");
			kl123Map.put("prize9", "任选六中3");
			kl123Map.put("prize10", "任选六中2");
			kl123Map.put("prize11", "任选七中3");
			kl123Map.put("prize12", "任选七中2");
			kl123Map.put("prize13", "任选八中3");
			kl123Map.put("prize14", "任选九中3");
			kl123Map.put("prize15", "任选十中3");
			prizeHashMap.put(LotteryType.KL123.getValue(), kl123Map);

			Map<String, String> klsfMap = new HashMap<String, String>();
			klsfMap.put("prize1", "选二任选");
			klsfMap.put("prize2", "选三任选");
			klsfMap.put("prize3", "选四任选");
			klsfMap.put("prize4", "选五任选");
			klsfMap.put("prize5", "选一数投");
			klsfMap.put("prize6", "选一红投");
			klsfMap.put("prize7", "选二连直");
			klsfMap.put("prize8", "选三前直");
			klsfMap.put("prize9", "选二连组");
			klsfMap.put("prize10", "选三前组");

			prizeHashMap.put(LotteryType.KLSF.getValue(), klsfMap);
			prizeHashMap.put(LotteryType.HN_KLSF.getValue(), klsfMap);
			
			Map<String, String> gxklsfMap = new HashMap<String, String>();
			gxklsfMap.put("prize1", "直选好运特");
			gxklsfMap.put("prize2", "直选好运一");
			gxklsfMap.put("prize3", "直选好运二");
			gxklsfMap.put("prize4", "直选好运三");
			gxklsfMap.put("prize5", "直选好运四");
			gxklsfMap.put("prize6", "直选好运五");
			gxklsfMap.put("prize7", "通选三中三");
			gxklsfMap.put("prize8", "通选三中二");
			gxklsfMap.put("prize9", "通选四中四");
			gxklsfMap.put("prize10", "通选四中三");
			gxklsfMap.put("prize11", "通选四中二");
			gxklsfMap.put("prize12", "通选五中五");
			gxklsfMap.put("prize13", "通选五中四");
			gxklsfMap.put("prize14", "通选五中三");
			prizeHashMap.put(LotteryType.GXKLSF.getValue(), gxklsfMap);


			Map<String, String> sd11x5Map = new HashMap<String, String>();
			sd11x5Map.put("prize1", "任选一奖");
			sd11x5Map.put("prize2", "任选二奖");
			sd11x5Map.put("prize3", "任选三奖");
			sd11x5Map.put("prize4", "任选四奖");
			sd11x5Map.put("prize5", "任选五奖");
			sd11x5Map.put("prize6", "任选六奖");
			sd11x5Map.put("prize7", "任选七奖");
			sd11x5Map.put("prize8", "任选八奖");
			sd11x5Map.put("prize9", "前二直选奖");
			sd11x5Map.put("prize10", "前二组选奖");
			sd11x5Map.put("prize11", "前三直选奖");
			sd11x5Map.put("prize12", "前三组选奖");
			prizeHashMap.put(LotteryType.SYYDJ.getValue(), sd11x5Map);
			prizeHashMap.put(LotteryType.JXDLC.getValue(), sd11x5Map);
			prizeHashMap.put(LotteryType.GD11X5.getValue(), sd11x5Map);
			prizeHashMap.put(LotteryType.LN11X5.getValue(), sd11x5Map);
			prizeHashMap.put(LotteryType.SH11X5.getValue(), sd11x5Map);
			prizeHashMap.put(LotteryType.HLJ11X5.getValue(), sd11x5Map);
			prizeHashMap.put(LotteryType.JS11X5.getValue(), sd11x5Map);
			
			Map<String, String> cq11x5Map = sd11x5Map;
			cq11x5Map.put("prize13", "派送奖");
			prizeHashMap.put(LotteryType.CQ11X5.getValue(), cq11x5Map);

			Map<String, String> sdQyhMap = new HashMap<String, String>();
			sdQyhMap.put("prize1", "顺五奖");
			sdQyhMap.put("prize2", "顺四奖");
			sdQyhMap.put("prize3", "顺三奖");
			sdQyhMap.put("prize4", "顺二奖");
			sdQyhMap.put("prize5", "顺一奖");
			sdQyhMap.put("prize6", "围五奖");
			sdQyhMap.put("prize7", "围四奖");
			sdQyhMap.put("prize8", "围三奖");
			sdQyhMap.put("prize9", "围二奖");
			sdQyhMap.put("prize10", "围一奖");
			sdQyhMap.put("prize11", "任一中一奖");
			sdQyhMap.put("prize12", "任二中二奖");
			sdQyhMap.put("prize13", "任三中三奖");
			sdQyhMap.put("prize14", "任三中二奖");
			sdQyhMap.put("prize15", "任四中四奖");
			sdQyhMap.put("prize16", "任四中三奖");
			sdQyhMap.put("prize17", "任五中五奖");
			sdQyhMap.put("prize18", "任五中四奖");
			sdQyhMap.put("prize19", "任五中三奖");
			sdQyhMap.put("prize20", "任六中五奖");
			sdQyhMap.put("prize21", "任七中五奖");
			sdQyhMap.put("prize22", "任八中五奖");
			sdQyhMap.put("prize23", "任九中五奖");
			sdQyhMap.put("prize24", "任十中五奖");

			prizeHashMap.put(LotteryType.SDQYH.getValue(), sdQyhMap);
			
			
			Map<String, String> newSdQyhMap = new HashMap<String, String>();
			newSdQyhMap.put("prize1", "顺五奖");
			newSdQyhMap.put("prize2", "顺四奖");
			newSdQyhMap.put("prize3", "顺选三中三");
			newSdQyhMap.put("prize4", "顺选二中二");
			newSdQyhMap.put("prize5", "顺一奖");
			newSdQyhMap.put("prize6", "围选五中五");
			newSdQyhMap.put("prize7", "围选四中四");
			newSdQyhMap.put("prize8", "围选三中三");
			newSdQyhMap.put("prize9", "围选二中二");
			newSdQyhMap.put("prize10", "围一奖");
			newSdQyhMap.put("prize11", "任一中一奖");
			newSdQyhMap.put("prize12", "任二中二奖");
			newSdQyhMap.put("prize13", "任三中三奖");
			newSdQyhMap.put("prize14", "任三中二奖");
			newSdQyhMap.put("prize15", "任四中四奖");
			newSdQyhMap.put("prize16", "任四中三奖");
			newSdQyhMap.put("prize17", "任五中五奖");
			newSdQyhMap.put("prize18", "任五中四奖");
			newSdQyhMap.put("prize19", "任五中三奖");
			newSdQyhMap.put("prize20", "任六中五奖");
			newSdQyhMap.put("prize21", "任七中五奖");
			newSdQyhMap.put("prize22", "任八中五奖");
			newSdQyhMap.put("prize23", "任九中五奖");
			newSdQyhMap.put("prize24", "任十中五奖");
			newSdQyhMap.put("prize25", "顺选三中二");
			newSdQyhMap.put("prize26", "顺选二中一");
			newSdQyhMap.put("prize27", "围选五中四");
			newSdQyhMap.put("prize28", "围选五中三");
			newSdQyhMap.put("prize29", "围选四中三");
			newSdQyhMap.put("prize30", "围选三中二");
			newSdQyhMap.put("prize31", "围选二中一");

			prizeHashMap.put(LotteryType.SDQYH_NEW.getValue(), newSdQyhMap);

			Map<String, String> KL8Map = new HashMap<String, String>();
			KL8Map.put("prize1", "任1中1");

			KL8Map.put("prize2", "任2中2");

			KL8Map.put("prize3", "任3中3");
			KL8Map.put("prize4", "任3中2");

			KL8Map.put("prize5", "任4中4");
			KL8Map.put("prize6", "任4中3");
			KL8Map.put("prize7", "任4中2");

			KL8Map.put("prize8", "任5中5");
			KL8Map.put("prize9", "任5中4");
			KL8Map.put("prize10", "任5中3");

			KL8Map.put("prize11", "任6中6");
			KL8Map.put("prize12", "任6中5");
			KL8Map.put("prize13", "任6中4");
			KL8Map.put("prize14", "任6中3");

			KL8Map.put("prize15", "任7中7");
			KL8Map.put("prize16", "任7中6");
			KL8Map.put("prize17", "任7中5");
			KL8Map.put("prize18", "任7中4");
			KL8Map.put("prize19", "任7中0");

			KL8Map.put("prize20", "任8中8");
			KL8Map.put("prize21", "任8中7");
			KL8Map.put("prize22", "任8中6");
			KL8Map.put("prize23", "任8中5");
			KL8Map.put("prize24", "任8中4");
			KL8Map.put("prize25", "任8中0");

			KL8Map.put("prize26", "任9中9");
			KL8Map.put("prize27", "任9中8");
			KL8Map.put("prize28", "任9中7");
			KL8Map.put("prize29", "任9中6");
			KL8Map.put("prize30", "任9中5");
			KL8Map.put("prize31", "任9中0");

			KL8Map.put("prize32", "任10中10");
			KL8Map.put("prize33", "任10中0");

			prizeHashMap.put(LotteryType.KL8.getValue(), KL8Map);

			Map<String, String> JCMap = new HashMap<String, String>();
			JCMap.put("prize0", "自由过关");
			JCMap.put("prize1", "单关");
			JCMap.put("prize2", "2串1");
			JCMap.put("prize3", "3串1");
			JCMap.put("prize4", "4串1");
			JCMap.put("prize5", "5串1");
			JCMap.put("prize6", "6串1");
			JCMap.put("prize7", "7串1");
			JCMap.put("prize8", "8串1");
			prizeHashMap.put(LotteryType.JC_LQ_DXF.getValue(), JCMap);
			prizeHashMap.put(LotteryType.JC_LQ_RFSF.getValue(), JCMap);
			prizeHashMap.put(LotteryType.JC_LQ_SF.getValue(), JCMap);
			prizeHashMap.put(LotteryType.JC_LQ_SFC.getValue(), JCMap);
			prizeHashMap.put(LotteryType.JC_LQ_HT.getValue(), JCMap);
			prizeHashMap.put(LotteryType.JC_ZQ_BF.getValue(), JCMap);
			prizeHashMap.put(LotteryType.JC_ZQ_BQC.getValue(), JCMap);
			prizeHashMap.put(LotteryType.JC_ZQ_JQS.getValue(), JCMap);
			prizeHashMap.put(LotteryType.JC_ZQ_RQSPF.getValue(), JCMap);
			prizeHashMap.put(LotteryType.JC_ZQ_SPF.getValue(), JCMap);
			prizeHashMap.put(LotteryType.JC_ZQ_HT.getValue(), JCMap);
			prizeHashMap.put(LotteryType.JC_ZQ_SPFHT.getValue(), JCMap);
			prizeHashMap.put(LotteryType.JC_ZQ_DGTZ.getValue(), JCMap);
			prizeHashMap.put(LotteryType.JC_ZQ_ALTERNATIVE.getValue(), JCMap);
			
			Map<String, String> k3Map = new HashMap<String, String>();
			k3Map.put("prize1", "和值6或15");
			k3Map.put("prize2", "和值4或17");
			k3Map.put("prize3", "和值5或16");
			k3Map.put("prize4", "和值7或14");
			k3Map.put("prize5", "和值8或13");
			k3Map.put("prize6", "和值9或12");
			k3Map.put("prize7", "和值10或11");
			k3Map.put("prize8", "三同号通选");
			k3Map.put("prize9", "三同号单选");
			k3Map.put("prize10", "二同号复选");
			k3Map.put("prize11", "二同号单选");
			k3Map.put("prize12", "三不同号");
			k3Map.put("prize13", "二不同号");
			k3Map.put("prize14", "三连号通选");
			
			prizeHashMap.put(LotteryType.K3.getValue(), k3Map);
			prizeHashMap.put(LotteryType.JL_K3.getValue(), k3Map);
			prizeHashMap.put(LotteryType.HB_K3.getValue(), k3Map);
			prizeHashMap.put(LotteryType.AH_K3.getValue(), k3Map);
			prizeHashMap.put(LotteryType.JX_K3.getValue(), k3Map);
			
			Map<String, String> cqklsfMap = new HashMap<String, String>();
			cqklsfMap.put("prize1", "选二任选");
			cqklsfMap.put("prize2", "选三任选");
			cqklsfMap.put("prize3", "选四任选");
			cqklsfMap.put("prize4", "选五任选");
			cqklsfMap.put("prize5", "选一数投");
			cqklsfMap.put("prize6", "选一红投");
			cqklsfMap.put("prize7", "选二连直");
			cqklsfMap.put("prize8", "选二连组");

			prizeHashMap.put(LotteryType.CQ_KLSF.getValue(), cqklsfMap);
			
			Map<String, String> pokerK3Map = new HashMap<String, String>();
			pokerK3Map.put("prize1", "任选一奖");
			pokerK3Map.put("prize2", "任选二奖");
			pokerK3Map.put("prize3", "任选三奖");
			pokerK3Map.put("prize4", "任选四奖");
			pokerK3Map.put("prize5", "任选五奖");
			pokerK3Map.put("prize6", "任选六奖");
			pokerK3Map.put("prize7", "同花包选奖");
			pokerK3Map.put("prize8", "同花单选奖");
			pokerK3Map.put("prize9", "同花顺包选奖");
			pokerK3Map.put("prize10", "同花顺单选奖");
			pokerK3Map.put("prize11", "顺子包选奖");
			pokerK3Map.put("prize12", "顺子单选奖");
			pokerK3Map.put("prize13", "豹子包选奖");
			pokerK3Map.put("prize14", "豹子单选奖");
			pokerK3Map.put("prize15", "对子包选奖");
			pokerK3Map.put("prize16", "对子单选奖");
			
			prizeHashMap.put(LotteryType.POKER3.getValue(), pokerK3Map);
			
			Map<String, String> gyjMap = new HashMap<String, String>();
			gyjMap.put("prize1","单关");
			prizeHashMap.put(LotteryType.JC_ZQ_GJ_OG.getValue(), gyjMap);
			prizeHashMap.put(LotteryType.JC_ZQ_GJ_WORLD.getValue(), gyjMap);
			prizeHashMap.put(LotteryType.JC_ZQ_GYJ_WORLD.getValue(), gyjMap);
			prizeHashMap.put(LotteryType.JC_ZQ_GYJ_UEFA.getValue(), gyjMap);
			prizeHashMap.put(LotteryType.JC_ZQ_GJ_UEFA.getValue(), gyjMap);
			/*
			 * List<String> ssqList = new ArrayList<String>(); ssqList.add("一等奖");
			 * ssqList.add("二等奖"); ssqList.add("三等奖"); ssqList.add("四等奖");
			 * ssqList.add("五等奖"); ssqList.add("六等奖");
			 * prizeNameHashMap.put(LotteryType.SSQ.getValue(), ssqList);
			 * 
			 * 
			 * 
			 * 
			 * List<String> qlcList = new ArrayList<String>(); qlcList.add("一等奖");
			 * qlcList.add("二等奖"); qlcList.add("三等奖"); qlcList.add("四等奖");
			 * qlcList.add("五等奖"); qlcList.add("六等奖"); qlcList.add("七等奖");
			 * prizeNameHashMap.put(LotteryType.QLC.getValue(), qlcList);
			 * 
			 * List<String> sscList = new ArrayList<String>(); sscList.add("五星奖");
			 * sscList.add("三星奖"); sscList.add("二星奖"); sscList.add("一星奖");
			 * sscList.add("大小单双奖"); sscList.add("二星组选奖"); sscList.add("五星通选一等奖");
			 * sscList.add("五星通选二等奖"); sscList.add("五星通选三等奖"); sscList.add("组三奖");
			 * sscList.add("组六奖"); prizeNameHashMap.put(LotteryType.SSC.getValue(),
			 * sscList);
			 * 
			 * List<String> jxsscList = new ArrayList<String>();
			 * jxsscList.add("五星奖"); jxsscList.add("四星奖"); jxsscList.add("四星二等奖");
			 * jxsscList.add("三星奖"); jxsscList.add("二星奖"); jxsscList.add("一星奖");
			 * jxsscList.add("大小单双奖"); jxsscList.add("二星组选奖");
			 * jxsscList.add("五星通选一等奖"); jxsscList.add("五星通选二等奖");
			 * jxsscList.add("五星通选三等奖"); jxsscList.add("组三奖"); jxsscList.add("组六奖");
			 * prizeNameHashMap.put(LotteryType.JXSSC.getValue(), jxsscList);
			 * 
			 * 
			 * List<String> pl5List = new ArrayList<String>();
			 * pl5List.add("排五直选奖");
			 * prizeNameHashMap.put(LotteryType.PL5.getValue(), pl5List);
			 * 
			 * 
			 * List<String> pl3List = new ArrayList<String>();
			 * pl3List.add("排三直选奖"); pl3List.add("排三组3奖"); pl3List.add("排三组6奖");
			 * prizeNameHashMap.put(LotteryType.PL3.getValue(), pl3List);
			 * 
			 * List<String> fc3dList = new ArrayList<String>();
			 * pl3List.add("排三直选奖"); pl3List.add("排三组3奖"); pl3List.add("排三组6奖");
			 * prizeNameHashMap.put(LotteryType.FC3D.getValue(), fc3dList);
			 * 
			 * List<String> fc20x5List = new ArrayList<String>();
			 * fc20x5List.add("一等奖"); fc20x5List.add("二等奖"); fc20x5List.add("三等奖");
			 * prizeNameHashMap.put(LotteryType.F20X5.getValue(), fc20x5List);
			 * 
			 * List<String> dltList = new ArrayList<String>(); dltList.add("一等奖");
			 * dltList.add("一等奖追加"); dltList.add("二等奖"); dltList.add("二等奖追加");
			 * dltList.add("三等奖"); dltList.add("三等奖追加"); dltList.add("四等奖");
			 * dltList.add("五等奖"); dltList.add("六等奖"); dltList.add("七等奖");
			 * dltList.add("八等奖"); dltList.add("幸运奖");
			 * prizeNameHashMap.put(LotteryType.DLT.getValue(), dltList);
			 * 
			 * List<String> f15x5List = new ArrayList<String>();
			 * f15x5List.add("特等奖"); f15x5List.add("一等奖"); f15x5List.add("二等奖");
			 * f15x5List.add("派送奖");
			 * prizeNameHashMap.put(LotteryType.F15X5.getValue(), f15x5List);
			 * 
			 * List<String> qxcList = new ArrayList<String>(); qxcList.add("特等奖");
			 * qxcList.add("一等奖"); qxcList.add("二等奖"); qxcList.add("三等奖");
			 * qxcList.add("四等奖"); qxcList.add("五等奖");
			 * prizeNameHashMap.put(LotteryType.QXC.getValue(), qxcList);
			 * 
			 * List<String> df6j1List = new ArrayList<String>();
			 * df6j1List.add("一等奖"); df6j1List.add("二等奖"); df6j1List.add("三等奖");
			 * df6j1List.add("四等奖"); df6j1List.add("五等奖"); df6j1List.add("六等奖");
			 * prizeNameHashMap.put(LotteryType.DF6J1.getValue(), df6j1List);
			 * 
			 * 
			 * List<String> sslList = new ArrayList<String>();
			 * sslList.add("直选奖金"); sslList.add("组选3奖金"); sslList.add("组选6奖金");
			 * sslList.add("前一奖金"); sslList.add("后一奖金"); sslList.add("前二奖金");
			 * sslList.add("后二奖金"); prizeNameHashMap.put(LotteryType.SSL.getValue(),
			 * sslList);
			 * 
			 * List<String> sfcList = new ArrayList<String>(); sfcList.add("一等奖");
			 * sfcList.add("二等奖"); sfcList.add("任选九场一等奖");
			 * prizeNameHashMap.put(LotteryType.SFC.getValue(), sfcList);
			 * 
			 * List<String> sfcr9List = new ArrayList<String>();
			 * sfcr9List.add("一等奖");
			 * prizeNameHashMap.put(LotteryType.SFR9.getValue(), sfcr9List);
			 * 
			 * 
			 * List<String> bqcList = new ArrayList<String>(); bqcList.add("一等奖");
			 * prizeNameHashMap.put(LotteryType.BQC.getValue(), bqcList);
			 * 
			 * List<String> jqcList = new ArrayList<String>(); jqcList.add("一等奖");
			 * prizeNameHashMap.put(LotteryType.JQC.getValue(), jqcList);
			 * 
			 * List<String> t36x7List = new ArrayList<String>();
			 * t36x7List.add("一等奖"); t36x7List.add("二等奖"); t36x7List.add("三等奖");
			 * t36x7List.add("四等奖"); t36x7List.add("五等奖"); t36x7List.add("六等奖");
			 * prizeNameHashMap.put(LotteryType.T36x7.getValue(), t36x7List);
			 * 
			 * List<String> t22x5List = new ArrayList<String>();
			 * t22x5List.add("一等奖"); t22x5List.add("二等奖"); t22x5List.add("三等奖");
			 * prizeNameHashMap.put(LotteryType.T22X5.getValue(), t22x5List);
			 * 
			 * List<String> szfcList = new ArrayList<String>();
			 * szfcList.add("一等奖"); szfcList.add("二等奖"); szfcList.add("三等奖");
			 * szfcList.add("四等奖"); szfcList.add("五等奖"); szfcList.add("六等奖");
			 * szfcList.add("七等奖"); szfcList.add("八等奖");
			 * prizeNameHashMap.put(LotteryType.SZFC.getValue(), szfcList);
			 * 
			 * List<String> dcList = new ArrayList<String>(); dcList.add("单关");
			 * dcList.add("2串1"); dcList.add("3串1"); dcList.add("4串1");
			 * dcList.add("5串1"); dcList.add("6串1"); dcList.add("7串1");
			 * dcList.add("8串1"); dcList.add("9串1"); dcList.add("10串1");
			 * dcList.add("11串1"); dcList.add("12串1"); dcList.add("13串1");
			 * dcList.add("14串1"); dcList.add("15串1");
			 * prizeNameHashMap.put(LotteryType.DC_SFP.getValue(), dcList);
			 * prizeNameHashMap.put(LotteryType.DC_BF.getValue(), dcList);
			 * prizeNameHashMap.put(LotteryType.DC_BCSFP.getValue(), dcList);
			 * prizeNameHashMap.put(LotteryType.DC_JQS.getValue(), dcList);
			 * prizeNameHashMap.put(LotteryType.DC_SXDS.getValue(), dcList);
			 * 
			 * 
			 * 
			 * 
			 * List<String> kl123List = new ArrayList<String>();
			 * kl123List.add("任选一中1"); kl123List.add("任选二中2");
			 * kl123List.add("任选三中3"); kl123List.add("任选三中2");
			 * kl123List.add("任选四中3"); kl123List.add("任选四中2");
			 * kl123List.add("任选五中3"); kl123List.add("任选五中2");
			 * kl123List.add("任选六中3"); kl123List.add("任选六中2");
			 * kl123List.add("任选七中3"); kl123List.add("任选七中2");
			 * kl123List.add("任选八中3"); kl123List.add("任选九中3");
			 * kl123List.add("任选十中3");
			 * prizeNameHashMap.put(LotteryType.KL123.getValue(), kl123List);
			 * 
			 * 
			 * List<String> klsfList = new ArrayList<String>(); klsfList.add(
			 * "选二任选"); klsfList.add( "选二任选"); klsfList.add( "选二任选"); klsfList.add(
			 * "选二任选"); klsfList.add( "选一数投"); klsfList.add( "选一红投"); klsfList.add(
			 * "选二连直"); klsfList.add( "选三前直"); klsfList.add( "选二连组"); klsfList.add(
			 * "选三前组");
			 * 
			 * prizeNameHashMap.put(LotteryType.KLSF.getValue(), klsfList);
			 * 
			 * List<String> gxklsfList = new ArrayList<String>();
			 * gxklsfList.add("直选好运特"); gxklsfList.add("直选好运一");
			 * gxklsfList.add("直选好运二"); gxklsfList.add("直选好运三");
			 * gxklsfList.add("直选好运四"); gxklsfList.add("直选好运五");
			 * gxklsfList.add("通选三中三"); gxklsfList.add("通选三中二");
			 * gxklsfList.add("通选四中四"); gxklsfList.add("通选四中三");
			 * gxklsfList.add("通选四中二"); gxklsfList.add("通选五中五");
			 * gxklsfList.add("通选五中四"); gxklsfList.add("通选五中三");
			 * prizeNameHashMap.put(LotteryType.GXKLSF.getValue(), gxklsfList);
			 * 
			 * 
			 * List<String> hc1List = new ArrayList<String>();
			 * hc1List.add("好彩一(数字)"); hc1List.add("十二生肖"); hc1List.add("季节");
			 * hc1List.add("方位"); prizeNameHashMap.put(LotteryType.HC1.getValue(),
			 * hc1List);
			 * 
			 * List<String> sd11x5List = new ArrayList<String>();
			 * sd11x5List.add("任选一奖"); sd11x5List.add("任选二奖");
			 * sd11x5List.add("任选三奖"); sd11x5List.add("任选四奖");
			 * sd11x5List.add("任选五奖"); sd11x5List.add("任选六奖");
			 * sd11x5List.add("任选七奖"); sd11x5List.add("任选八奖");
			 * sd11x5List.add("前二直选奖"); sd11x5List.add("前二组选奖");
			 * sd11x5List.add("前三直选奖"); sd11x5List.add("前三组选奖");
			 * prizeNameHashMap.put(LotteryType.SYYDJ.getValue(), sd11x5List);
			 * 
			 * List<String> sdQyhList = new ArrayList<String>();
			 * sdQyhList.add("顺五奖"); sdQyhList.add("顺四奖"); sdQyhList.add("顺三奖");
			 * sdQyhList.add("顺二奖"); sdQyhList.add("顺一奖"); sdQyhList.add("围五奖");
			 * sdQyhList.add("围四奖"); sdQyhList.add("围三奖"); sdQyhList.add("围二奖");
			 * sdQyhList.add("围一奖"); sdQyhList.add("任一中一奖"); sdQyhList.add("任二中二奖");
			 * sdQyhList.add("任三中三奖"); sdQyhList.add("任三中二奖");
			 * sdQyhList.add("任四中四奖"); sdQyhList.add("任四中三奖");
			 * sdQyhList.add("任五中五奖"); sdQyhList.add("任五中四奖");
			 * sdQyhList.add("任五中三奖"); sdQyhList.add("任六中五奖");
			 * sdQyhList.add("任七中五奖"); sdQyhList.add("任八中五奖");
			 * sdQyhList.add("任九中五奖"); sdQyhList.add("任十中五奖");
			 * prizeNameHashMap.put(LotteryType.SDQYH.getValue(), sdQyhList);
			 *  //
			 */
		}
		return prizeHashMap.get(v);
	}

}
