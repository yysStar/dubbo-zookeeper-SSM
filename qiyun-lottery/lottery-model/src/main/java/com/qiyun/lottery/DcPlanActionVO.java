package com.qiyun.lottery;

import com.qiyun.check.*;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.commonModel.PlayType;
import com.qiyun.grabber.football.AbstractDcArrange;
import com.qiyun.httpUtil.WebConstants;
import com.qiyun.model.football.DcSfArrange;
import com.qiyun.tools.FbResult;
import com.qiyun.type.SelectType;
import com.qiyun.utils.FileTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DcPlanActionVO {
	private String intTime;//
	
	private String boutIndex;// 场次

	private String homeTeam;// 主队

	private String concede;// 让球

	private String awaryTeam;// 客队

	private boolean haveDan;// 是否设胆

	private String wholeScore;// 比分
	private String halfScore;// 比分

	private String prizeMoney;// 奖金

	private String passModel;// 过关方式

	private String passMoney;// 过关金额

	private String selects;// 选择
	
	private String projectName;//胜负过关项目

	private String result;// 结果
	private String sp;
	private String[] selectList;// 选择--list版;

	public static <T extends AbstractDcArrange> List<DcPlanActionVO> parsePlan(
			LotteryPlan lotteryPlan, DcArrangeService dcArrangeService, int lotteryTypeValue) {
		List<DcPlanActionVO> hmVOList = new ArrayList<DcPlanActionVO>();
		String content = lotteryPlan.getContent();
		String prizeContent = lotteryPlan.getPrizeContent();
		String[] prize = null;
		try {
			if (prizeContent != null && !"".equals(prizeContent)) {
				prize = prizeContent.split("%")[0].split("#");
			}
			if (lotteryPlan.getSelectType().getValue() == SelectType.UPLOAD.getValue()) {
				if (content == null) { // 发起预头方案
					hmVOList = null;
				} else {
					String[] boutArr = content.split("#")[1].split(";")[0].split(",");
					String playTypeCompose = content.split("#")[0].split("!")[1];
					String[] playTypes = playTypeCompose.split("\\^");
					String filePath = content.substring(content.indexOf("_") + 1, content.lastIndexOf("%"));
//					CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
					List<T> dbMatchList = dcArrangeService.findByTerm(lotteryPlan.getTerm());
					Map<String, T> boutMap = new HashMap<String, T>();
					for (T dc : dbMatchList) {
						boutMap.put(dc.getBoutIndex(), dc);
					}
					int i = 0;
					String projectName="";
					for (String bout : boutArr) {
						T dc = boutMap.get(bout);
						if(LotteryType.DC_SFGG.getValue() == lotteryTypeValue){
							DcSfArrange dcSf = (DcSfArrange) dc;
							projectName = dcSf.getProjectName();
						}
						if (dc != null) {
							DcPlanActionVO vo = new DcPlanActionVO();
							if (i < playTypes.length) {
								vo.setPassModel(PlayType.getItem(Integer.valueOf(playTypes[i])).getName());
							}
							i++;
							if (dc.getWholeScore() != null) {
								String tempScore = dc.getWholeScore() == null ? "" : dc.getWholeScore();
								String spValue = "";
								if (LotteryType.DC_SFP.getValue() == lotteryTypeValue) {
									spValue = dc.getSpSfp();
								} else if (LotteryType.DC_SXDS.getValue() == lotteryTypeValue) {
									spValue = dc.getSpSxds();
								} else if (LotteryType.DC_JQS.getValue() == lotteryTypeValue) {
									spValue = dc.getSpJqs();
								} else if (LotteryType.DC_BF.getValue() == lotteryTypeValue) {
									spValue = dc.getSpBf();
								} else if (LotteryType.DC_BCSFP.getValue() == lotteryTypeValue) {
									spValue = dc.getSpBcsfp();
								}else if (LotteryType.DC_SFGG.getValue() == lotteryTypeValue) {
									spValue = dc.getSfggSp();
								}
								//spValue = FbDcArrangeUtil.changeToDouble(spValue, 2);
								vo.setSp(spValue);
								vo.setWholeScore(tempScore);
								vo.setHalfScore(dc.getHalfScore() == null ? "" : dc.getHalfScore());
							} else {
								vo.setWholeScore("");
								vo.setHalfScore("");
								vo.setSp("");
							}
							vo.setIntTime(dc.getIntTime());
							vo.setHomeTeam(dc.getHomeTeam());
							vo.setBoutIndex(dc.getBoutIndex());
							vo.setConcede(dc.getComConcede() + "");
							vo.setAwaryTeam(dc.getAwaryTeam());
							vo.setProjectName(projectName);
							String result = getResultSelect(dc.getWholeScore(), dc.getHalfScore(), lotteryTypeValue, dc.getComConcede() + "");
							vo.setResult(result);
							hmVOList.add(vo);
						}
					}
					
					if (!filePath.equals("")&&!hmVOList.isEmpty()) {//读取上传文件,组装内容
						content = FileTools.getFileContent(WebConstants.getWebPath() + filePath);
						String[] oneMatch = content.split("\n");
						String key="";
						String type=lotteryTypeValue+"";
						String option="";
						Map<String, List<String>> map=new HashMap<String, List<String>>(); 
						for (int ii = 0; ii < oneMatch.length; ii++) {
							String optStr = oneMatch[ii].split(":")[0];// [#1##1,3###1]
							char[] optArr = optStr.toCharArray();// [#,1,#,#,1]每个字符位置对应对阵位置
							for (int j = 0; j < optArr.length; j++) {
								if (!"#".equals(optArr[j]+"")) {// 不等于#说明有投注内容
									T dc = boutMap.get(boutArr[j]);
									key =dc.getIntTime()+"\1\1"+dc.getBoutIndex() + "\1\1" + type;
									option=optArr[j]+"";
									if (LotteryType.DC_SFP.getValue() == lotteryTypeValue) {
										option = getSPFSelectName(option, lotteryTypeValue);
									} else if (LotteryType.DC_SXDS.getValue() == lotteryTypeValue) {
										option = getSXDSSelectName(option, lotteryTypeValue);
									} else if (LotteryType.DC_JQS.getValue() == lotteryTypeValue) {
										option = getJQSSelectName(option, lotteryTypeValue);
									} else if (LotteryType.DC_BF.getValue() == lotteryTypeValue) {
										option = getBFSelectName(option, lotteryTypeValue);
									} else if (LotteryType.DC_BCSFP.getValue() == lotteryTypeValue) {
										option = getBQCSelectName(option, lotteryTypeValue);
									}else if (LotteryType.DC_SFGG.getValue() == lotteryTypeValue) {
										option = getSPFSelectName(option, lotteryTypeValue);
									}
									List<String> selectList=map.get(key);
									selectList=selectList==null?new ArrayList<String>():selectList;
									if(!selectList.contains(option)){
										selectList.add(option);
									}
									map.put(key, selectList);
								}
							}
						}//
						StringBuilder sb=new StringBuilder();
						for (DcPlanActionVO vo : hmVOList) {
							sb.delete(0, sb.length());
							key=vo.getIntTime()+"\1\1"+vo.getBoutIndex()+"\1\1"+type;
							if(map.containsKey(key)){
								String[] selectList=map.get(key).toArray(new String[0]);
								vo.setSelectList(selectList);
								for (int j = 0; j < selectList.length; j++) {
									sb.append(","+selectList[j]);
								}
								vo.setSelects(sb.delete(0, 1).toString());
							}
						}
					}
				}

			} else {
				String codeCompose = content.split("!")[1].split("#")[1].split("%")[0];
				String playTypeCompose = content.split("#")[0].split("!")[1];
				int num = Integer.valueOf(content.split("%")[1]);
				String[] playTypes = playTypeCompose.split("\\^");
				String[] codes = codeCompose.split(";");
				String bout = "";
				String projectName="";
				for (int i = 0; i < codes.length; i++) {
					DcPlanActionVO dcHmVO = new DcPlanActionVO();
					String selects = "";
					String result = "";

					if (codes[i].indexOf('(') == 0) {
						dcHmVO.setHaveDan(true);
						bout = codes[i].split("\\(")[1];
						dcHmVO.setBoutIndex(bout);
						selects = codes[i].split("\\(")[2];
						selects = selects.substring(0, selects.length() - 2);
					} else {
						dcHmVO.setHaveDan(false);
						bout = codes[i].split("\\(")[0];
						dcHmVO.setBoutIndex(bout);
						selects = codes[i].split("\\(")[1];
						selects = selects.substring(0, selects.length() - 1);
					}
//					CustomerContextHolder.setCustomerType(DataSourceMap.SLAVE);
					T dc = (T) dcArrangeService.findByBoutIndexAndTerm(Integer.parseInt(bout) + "",
							lotteryPlan.getTerm()).get(0);
					if(LotteryType.DC_SFGG.getValue() == lotteryTypeValue){
						DcSfArrange dcSf=(DcSfArrange) dc;
						projectName=dcSf.getProjectName();
					}
					dcHmVO.setIntTime(dc.getIntTime());
					dcHmVO.setAwaryTeam(dc.getAwaryTeam());
					dcHmVO.setConcede(dc.getComConcede() + "");
					dcHmVO.setHomeTeam(dc.getHomeTeam());
					dcHmVO.setProjectName(projectName);
					if (dc.getWholeScore() != null) {
						String tempScore = dc.getWholeScore() == null ? "" : dc.getWholeScore();
						String spValue = "";
						if (LotteryType.DC_SFP.getValue() == lotteryTypeValue) {
							spValue = dc.getSpSfp();
						} else if (LotteryType.DC_SXDS.getValue() == lotteryTypeValue) {
							spValue = dc.getSpSxds();
						} else if (LotteryType.DC_JQS.getValue() == lotteryTypeValue) {
							spValue = dc.getSpJqs();
						} else if (LotteryType.DC_BF.getValue() == lotteryTypeValue) {
							spValue = dc.getSpBf();
						} else if (LotteryType.DC_BCSFP.getValue() == lotteryTypeValue) {
							spValue = dc.getSpBcsfp();
						}else if (LotteryType.DC_SFGG.getValue() == lotteryTypeValue) {
							spValue = dc.getSfggSp();
						}
						//spValue = FbDcArrangeUtil.changeToDouble(spValue, 2);
						dcHmVO.setSp(spValue);
						dcHmVO.setWholeScore(tempScore);
						dcHmVO.setHalfScore(dc.getHalfScore() == null ? "" : dc.getHalfScore());
					} else {
						dcHmVO.setWholeScore("");
						dcHmVO.setSp("");
						dcHmVO.setHalfScore("");
					}

					result = getResultSelect(dc.getWholeScore(), dc.getHalfScore(), lotteryTypeValue, dc.getComConcede() + "");
					dcHmVO.setResult(result);

					if (i < playTypes.length) {
						int temp = Integer.valueOf(playTypes[i]) - 100;
						String prizeName = PlayType.getItem(Integer.valueOf(playTypes[i])).getName();
						dcHmVO.setPassModel(prizeName);
						dcHmVO.setPassMoney((1 * num * 2) + "");
						if (prize != null) {
							dcHmVO.setPrizeMoney(prize[temp - 1].split("\\^")[2]);
						} else {
							dcHmVO.setPrizeMoney("");
						}
						int betCount = combineTotalCount(codes, codes.length, temp);
						dcHmVO.setPassMoney((betCount * 2 * num) + "");
					}
					if (LotteryType.DC_SFP.getValue() == lotteryTypeValue) {
						selects = getSPFSelectName(selects, lotteryTypeValue);
					} else if (LotteryType.DC_SXDS.getValue() == lotteryTypeValue) {
						selects = getSXDSSelectName(selects, lotteryTypeValue);
					} else if (LotteryType.DC_JQS.getValue() == lotteryTypeValue) {
						selects = getJQSSelectName(selects, lotteryTypeValue);
					} else if (LotteryType.DC_BF.getValue() == lotteryTypeValue) {
						selects = getBFSelectName(selects, lotteryTypeValue);
					} else if (LotteryType.DC_BCSFP.getValue() == lotteryTypeValue) {
						selects = getBQCSelectName(selects, lotteryTypeValue);
					}else if (LotteryType.DC_SFGG.getValue() == lotteryTypeValue) {
						selects = getSPFSelectName(selects, lotteryTypeValue);
					}
					dcHmVO.setSelects(selects);
					dcHmVO.setSelectList(selects.split(","));
					hmVOList.add(dcHmVO);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hmVOList;
	}

	public String getBoutIndex() {
		return boutIndex;
	}

	public void setBoutIndex(String boutIndex) {
		this.boutIndex = boutIndex;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getConcede() {
		return concede;
	}

	public void setConcede(String concede) {
		this.concede = concede;
	}

	public String getAwaryTeam() {
		return awaryTeam;
	}

	public void setAwaryTeam(String awaryTeam) {
		this.awaryTeam = awaryTeam;
	}

	public boolean isHaveDan() {
		return haveDan;
	}

	public void setHaveDan(boolean haveDan) {
		this.haveDan = haveDan;
	}

	public String getWholeScore() {
		return wholeScore;
	}

	public void setWholeScore(String wholeScore) {
		this.wholeScore = wholeScore;
	}

	public String getPrizeMoney() {
		return prizeMoney;
	}

	public void setPrizeMoney(String prizeMoney) {
		this.prizeMoney = prizeMoney;
	}

	public String getPassMoney() {
		return passMoney;
	}

	public void setPassMoney(String passMoney) {
		this.passMoney = passMoney;
	}

	public String getPassModel() {
		return passModel;
	}

	public void setPassModel(String passModel) {
		this.passModel = passModel;
	}

	public String getSelects() {
		return selects;
	}

	public void setSelects(String selects) {
		this.selects = selects;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public static String getResultSelect(String wholeScore, String halfScore, int lotteryTypeValue, String concede) {
		String result = "";
		int index = 0;
		if ("*".equals(halfScore) || "*".equals(wholeScore)) {
			return "*";
		}
		try {

			if (LotteryType.DC_SFP.getValue() == lotteryTypeValue) {
				index = DcSfpBingoCheck.getResultByBF(halfScore, wholeScore, concede);
			} else if (LotteryType.DC_SXDS.getValue() == lotteryTypeValue) {
				index = DcSxdsBingoCheck.getResultByBF(wholeScore);
			} else if (LotteryType.DC_JQS.getValue() == lotteryTypeValue) {
				index = DcJqsBingoCheck.getResultByBF(halfScore, wholeScore);
			} else if (LotteryType.DC_BF.getValue() == lotteryTypeValue) {
				index = DcBfBingoCheck.getResultByBF(wholeScore);
			} else if (LotteryType.DC_BCSFP.getValue() == lotteryTypeValue) {
				index = DcBqcBingoCheck.getResultByBF(halfScore, wholeScore, concede);
			}else if (LotteryType.DC_SFGG.getValue() == lotteryTypeValue) {
				index = DcSfggBingoCheck.getResultByBF(halfScore, wholeScore, concede);
			}
			result = parseDcSelect(index, lotteryTypeValue);
		} catch (Exception e) {
			result = "";
		}
		return result;
	}

	public static String getSPFSelectName(String selects, int lotteryTypeValue) {
		String[] selectsArr = selects.split(",");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < selectsArr.length; i++) {
			if (selectsArr[i] == null || "".equals(selectsArr[i])) {
				continue;
			}
			int select = Integer.valueOf(selectsArr[i]);
			String tempResult = parseDcSelect(select, lotteryTypeValue);
			if (!"".equals(tempResult)) {
				sb.append(tempResult + ",");
			}
		}
		if (sb.length() < 1) {
			return "";
		}
		String result = sb.substring(0, sb.length() - 1);
		return result;
	}

	// 半全场
	public static String getBQCSelectName(String selects, int lotteryTypeValue) {// (1,2,3)
		String[] selectsArr = selects.split(",");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < selectsArr.length; i++) {
			if (selectsArr[i] == null || "".equals(selectsArr[i])) {
				continue;
			}
			int select = Integer.valueOf(selectsArr[i]);
			String resultTemp = parseDcSelect(select, lotteryTypeValue);
			if (!"".equals(resultTemp)) {
				sb.append(resultTemp + ",");
			}
		}
		if (sb.length() < 1) {
			return "";
		}
		String result = sb.substring(0, sb.length() - 1);
		return result;
	}

	// 进球数
	public static String getJQSSelectName(String selects, int lotteryTypeValue) {
		String[] selectsArr = selects.split(",");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < selectsArr.length; i++) {
			if (selectsArr[i] == null || "".equals(selectsArr[i])) {
				continue;
			}
			int select = Integer.valueOf(selectsArr[i]);
			String tempResult = parseDcSelect(select, lotteryTypeValue);
			if (!"".equals(tempResult)) {
				sb.append(tempResult + ",");
			}
		}
		if (sb.length() < 1) {
			return "";
		}
		String result = sb.substring(0, sb.length() - 1);
		return result;
	}

	public static String getSXDSSelectName(String selects, int lotteryTypeValue) {
		String[] selectsArr = selects.split(",");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < selectsArr.length; i++) {
			if (selectsArr[i] == null || "".equals(selectsArr[i])) {
				continue;
			}
			int select = Integer.valueOf(selectsArr[i]);
			String resultTemp = parseDcSelect(select, lotteryTypeValue);
			if (!"".equals(resultTemp)) {
				sb.append(resultTemp + ",");
			}
		}
		if (sb.length() < 1) {
			return "";
		}
		String result = sb.substring(0, sb.length() - 1);
		return result;
	}

	public static String getBFSelectName(String selects, int lotteryTypeValue) {
		String[] selectsArr = selects.split(",");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < selectsArr.length; i++) {
			if (selectsArr[i] == null || "".equals(selectsArr[i])) {
				continue;
			}
			int select = Integer.valueOf(selectsArr[i]);
			String tempResult = parseDcSelect(select, lotteryTypeValue);
			if (!"".equals(tempResult)) {
				sb.append(tempResult + ",");
			}
		}
		if (sb.length() < 1) {
			return "";
		}
		String result = sb.substring(0, sb.length() - 1);
		return result;
	}

	public static int combineTotalCount(String[] codes, int n, int m) {
		int danTotalCount = 1;
		for (int i = 0; i < codes.length; i++) {
			if (codes[i].split("\\(").length > 2) {
				danTotalCount *= codes[i].split(",").length;
				m--;
				n--;
			}
		}
		int[] codesLength = new int[codes.length];
		int index = 0;
		for (int i = 0; i < codes.length; i++) {
			if (codes[i].split("\\(").length < 3) {
				codesLength[index] = codes[i].split(",").length;
				index++;
			}
		}
		m = m > n ? n : m;
		int ret = 0;
		int[] order = new int[m + 1];
		for (int i = 0; i <= m; i++) {
			order[i] = i - 1; // 注意这里order[0]=-1用来作为循环判断标识
		}
		int count = 0;
		int k = m;
		boolean flag = true; // 标志找到一个有效组合
		while (order[0] == -1) {
			if (flag) // 输出符合要求的组合
			{
				int sumCount = 1;
				for (int j = 1; j <= m; j++) {
					count++;
					sumCount *= codesLength[order[j]];
					System.out.println(codesLength[order[j]]);
				}
				flag = false;
				ret += sumCount * danTotalCount;
			}
			order[k]++; // 在当前位置选择新的数字
			if (order[k] == n) // 当前位置已无数字可选，回溯
			{
				order[k--] = 0;
				continue;
			}
			if (k < m) // 更新当前位置的下一位置的数字
			{
				order[++k] = order[k - 1];
				continue;
			}
			if (k == m) {
				flag = true;
			}
		}
		return ret;
	}

	public static String parseDcSelect(int select, int lotteryTypeValue) {
		String result = "";
		if (LotteryType.DC_SFP.getValue() == lotteryTypeValue) {
			result = FbResult.spfResult[select] + "";
		} else if (LotteryType.DC_SXDS.getValue() == lotteryTypeValue) {
			result = FbResult.sxdsResult[select] + "";
		} else if (LotteryType.DC_JQS.getValue() == lotteryTypeValue) {
			result = FbResult.jqsResult[select] + "";
		} else if (LotteryType.DC_BF.getValue() == lotteryTypeValue) {
			result = FbResult.bfResult[select] + "";
		} else if (LotteryType.DC_BCSFP.getValue() == lotteryTypeValue) {
			result = FbResult.bqcResult[select] + "";
		}else if (LotteryType.DC_SFGG.getValue() == lotteryTypeValue) {
			result = FbResult.sfggResult[select] + "";
		}
		return result;
	}

	public static void main(String[] args) {
		String[] codes = new String[] { "(1(1,2))", "2(2,3)", "4(1,2)" };

		System.out.println(combineTotalCount(codes, 2, 3) * 2);
	}

	public String[] getSelectList() {
		return selectList;
	}

	public void setSelectList(String[] selectList) {
		this.selectList = selectList;
	}

	public String getSp() {
		return sp;
	}

	public void setSp(String sp) {
		this.sp = sp;
	}

	public String getHalfScore() {
		return halfScore;
	}

	public void setHalfScore(String halfScore) {
		this.halfScore = halfScore;
	}

	public String getIntTime() {
		return intTime;
	}

	public void setIntTime(String intTime) {
		this.intTime = intTime;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


}
