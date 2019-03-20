package com.qiyun.bonus;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.util.ArithUtil;

import java.util.*;

public class JclqAwardDetailYc extends AwardDetailYc {

	public static List<ValidOption> sfcList; // 循环这个
	public static Map<String, Map<String, Integer>> checkMapBySfc;
	static {
		sfcList = new ArrayList<ValidOption>();
		checkMapBySfc = new HashMap<String, Map<String, Integer>>();

		int z = 0;
		for (int i = 0; i < 2; i++) {// 胜=0 负=1
			int win = i == 1 ? 0 : 3;
			for (int j = 0; j < 6; j++) {
				int diff = j * 5 + 1;
				String name = z + "";
				z++;
				ValidOption option = new ValidOption(name, diff, win);
				sfcList.add(option);
			}
		}

		for (int i = 0; i < sfcList.size(); i++) {
			ValidOption opt = sfcList.get(i);
			Map<String, Integer> item = new HashMap<String, Integer>();
			item.put(LotteryType.JC_LQ_SFC.getValue() + "-" + opt.getName(), 1);
			item.put(LotteryType.JC_LQ_SF.getValue() + "-" + opt.getWin(), 1);
			item.put(LotteryType.JC_LQ_DXF.getValue() + "-3", 1);
			item.put(LotteryType.JC_LQ_DXF.getValue() + "-0", 1);
			checkMapBySfc.put(opt.getName(), item);
		}
	}


	/**
	 * 通过这个计算偏移量
	 * 
	 * @return
	 */
	protected int getPtOffset() {
		return 116;
	}

	public List<SportteryOption3G> sortByDesc(List<SportteryOption3G> list) {
		Collections.sort(list, new Comparator<SportteryOption3G>() {
			public int compare(SportteryOption3G o1, SportteryOption3G o2) {
				return o2.getAward().compareTo(o1.getAward());
			}
		});
		return list;
	}

	/**
	 * 过滤无效的选项,得到共存的选项
	 * 
	 * @param allowOptList
	 * @param opt
	 * @return
	 */
	private List<List<SportteryOption3G>> filterInvalidOpts(Map<String,List<SportteryOption3G>> map, ValidOption opt) {
		Map<String, Integer> filterMap = checkMapBySfc.get(opt.getName());
		List<List<SportteryOption3G>> resultList =new ArrayList<List<SportteryOption3G>>();
		
		for (Map.Entry<String, List<SportteryOption3G>> entry : map.entrySet()) {
			List<SportteryOption3G> tmpList=entry.getValue();
			List<SportteryOption3G> tmpResultList = new ArrayList<SportteryOption3G>();
			for (int i = 0; i < tmpList.size(); i++) {
				SportteryOption3G option3G = tmpList.get(i);
				int lotType = Integer.parseInt(option3G.getType());
				if (lotType == LotteryType.JC_LQ_RFSF.getValue()) {
					boolean result = testRfSfBySfc(option3G, opt);
					if (result) {
						tmpResultList.add(option3G);
					}
				} else {
					String key = lotType + "-" + option3G.getValue();
					if (filterMap.containsKey(key)) {
						tmpResultList.add(option3G);
					}
				}
			}
			if(!tmpResultList.isEmpty()){
				resultList.add(tmpResultList);
			}
			
		}
		
		return resultList;
	}

	private boolean testRfSfBySfc(SportteryOption3G option3G, ValidOption opt) {
		int rf = option3G.getRf().intValue();
		boolean isRfsfWin = option3G.getValue().equals("3");// 让分胜
		boolean result = false;
		if (opt.getWin() == 3) { // 胜分差主胜
			result =(rf + opt.getDiff()  < 0) ? !isRfsfWin : isRfsfWin;
			if (!result) { // 如果false 判断另一个区间 所以要+4
				result = (rf + opt.getDiff() + 4 < 0) ? !isRfsfWin : isRfsfWin;
			}
		} else {
			result = (rf - opt.getDiff() > 0) ? isRfsfWin : !isRfsfWin ;
			if(!result){
				result = (rf - opt.getDiff() + 4 > 0) ? isRfsfWin : !isRfsfWin;
			}
		}
		return result;
	}

	/**
	 * 过滤出每场次的 最大/最小值
	 * 
	 * @param matchItem
	 * @return
	 */
	protected List<AwardOptionComineVo> getMinAndMaxVo(Sporttery3GMatchItem matchItem) {
		AwardOptionComineVo maxVo = new AwardOptionComineVo();
		AwardOptionComineVo minVo = new AwardOptionComineVo();
		minVo.setSumSp(-1.0);
		List<SportteryOption3G> itemOptionList =matchItem.getOptions3G();
		
		Map<String,List<SportteryOption3G>> map=new HashMap<String, List<SportteryOption3G>>();
		
		for (int i = 0; i < itemOptionList.size(); i++) {
			SportteryOption3G tmpOpt=itemOptionList.get(i);
			String key=tmpOpt.getType();
			List<SportteryOption3G> tmpList=null;
			if(map.containsKey(key)){
				tmpList=map.get(key);
			}else{
				tmpList=new ArrayList<SportteryOption3G>();
			}
			tmpList.add(tmpOpt);
			map.put(key, tmpList);
		}
		
		

		// 循环每种赛果(sfcList),根据玩法过滤符合赛果的选项组成组合.
		// 过滤出每个玩法允许出现的选项, 然后获取最大/最小sp
		for (int i = 0; i < sfcList.size(); i++) {
			ValidOption opt = sfcList.get(i);
			List<List<SportteryOption3G>> allowOptList = filterInvalidOpts(map, opt);
			List<List> tmpList=new ArrayList();
			tmpList.addAll(allowOptList);
			
			
			//对allowOptList 进行笛卡尔积
			List<List> resultList = DescartesUtil.cross(tmpList);// 笛卡尔积之后的数据
			
			for (int j = 0; j < resultList.size(); j++) {
				List allowList=resultList.get(j);
				if (allowOptList.size() > 0) {
					Double sum = 0.0;
					for (int k = 0; k < allowList.size(); k++) {
						SportteryOption3G option=(SportteryOption3G) allowList.get(k);
						sum = ArithUtil.add(sum, option.getAward());
					}
					if (maxVo.getSumSp() < sum) {
						maxVo.setOptionList(allowList);
						maxVo.setSumSp(sum);
					}
					if (minVo.getSumSp() == -1 || minVo.getSumSp() > sum) {
						minVo.setOptionList(allowList);
						minVo.setSumSp(sum);
					}
				}
			}
		}
		List<AwardOptionComineVo> list = new ArrayList<AwardOptionComineVo>();
		list.add(maxVo);
		list.add(minVo);
		return list;
	}

}

class ValidOption {
	private int diff;
	private String name;
	private int win;

	ValidOption(String name, int diff, int win) {
		this.diff = diff;
		this.name = name;
		this.win = win;
	}

	public int getDiff() {
		return diff;
	}

	public void setDiff(int diff) {
		this.diff = diff;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

}