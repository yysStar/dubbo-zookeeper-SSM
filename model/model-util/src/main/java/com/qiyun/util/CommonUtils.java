package com.qiyun.util;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.item.*;
import com.qiyun.model.basketball.BasketBallMatch;
import com.qiyun.model.football.FootBallMatch;
import com.qiyun.sporttery.SportteryBetContentModel;
import com.qiyun.sporttery.SportteryOption;
import com.qiyun.sporttery.SportteryTicketModel;
import com.qiyun.tools.NumberTools;
import com.qiyun.type.SportteryPassType;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.*;

public class CommonUtils {

    public static final String beginIntTimeKey = "btk";
    public static final String endIntTimeKey = "etk";
    public static final String homeScoreKey = "hsk";
    public static final String guestScoreKey = "gsk";
    public static final String handicapKey = "hck";
    public static final String bigSmallKey = "bsk";
    public static final String resultSFKey = "rsfk";
    public static final String resultRFSFKey = "rfsfk";
    public static final String resultSFCKey = "rsfck";
    public static final String resultDXFKey = "rdxfk";
    public static final String CONCEDEKEY = "concede";
    public static final String resultHalfHomeScore = "halfHomeScore";
    public static final String resultHalfGuestScore = "halfGuestScore";
    public static final String resultRQSPFKey = "rqspfk";
    public static final String resultSPFKey = "spfk";
    public static final String resultBFKey = "bfk";
    public static final String resultJQSKey = "jqsk";
    public static final String resultBQCKey = "bqck";

    public static String genMatchKey(Integer intTime, Integer lineId) {
        return intTime + "_" + lineId;
    }

    public static OptionItem getResultOptionItem(String type, Map<String, String> resultMap) {// 只是用于单关，过关不需要
        String tempHomeScore = resultMap.get(homeScoreKey);
        String tempGuestScore = resultMap.get(guestScoreKey);
        String temphandicap = resultMap.get(handicapKey);
        String tempbigOrSmallbase = resultMap.get(bigSmallKey);
        Integer homeScore = Integer.valueOf(tempHomeScore);// 主队分数:为0表示赛事取消
        Integer guestScore = Integer.valueOf(tempGuestScore);// 客队分数:为0表示赛事取消
        Double handicap = Double.valueOf(temphandicap);// 让分
        Double bigOrSamllBase = Double.valueOf(tempbigOrSmallbase);// 大小分基数
        switch (Integer.valueOf(type)) {
            case 30: {
                if (homeScore > guestScore)
                    return OptionItemSF.WIN;// 主胜
                else
                    return OptionItemSF.LOSE;// 主负
            }
            case 31: {
                if (homeScore + handicap.doubleValue() > guestScore)
                    return OptionItemRFSF.WIN;// 主胜
                else
                    return OptionItemRFSF.LOSE;// 主负
            }
            case 32: {
                if (1 <= (homeScore - guestScore) && (homeScore - guestScore) <= 5)
                    return OptionItemSFC.HW1TO5;
                else if (6 <= (homeScore - guestScore) && (homeScore - guestScore) <= 10)
                    return OptionItemSFC.HW6TO10;
                else if (11 <= (homeScore - guestScore) && (homeScore - guestScore) <= 15)
                    return OptionItemSFC.HW11TO15;
                else if (16 <= (homeScore - guestScore) && (homeScore - guestScore) <= 20)
                    return OptionItemSFC.HW16TO20;
                else if (21 <= (homeScore - guestScore) && (homeScore - guestScore) <= 25)
                    return OptionItemSFC.HW21TO25;
                else if (26 <= (homeScore - guestScore))
                    return OptionItemSFC.HW26;
                else if (1 <= (guestScore - homeScore) && (guestScore - homeScore) <= 5)
                    return OptionItemSFC.GW1TO5;
                else if (6 <= (guestScore - homeScore) && (guestScore - homeScore) <= 10)
                    return OptionItemSFC.GW6TO10;
                else if (11 <= (guestScore - homeScore) && (guestScore - homeScore) <= 15)
                    return OptionItemSFC.GW11TO15;
                else if (16 <= (guestScore - homeScore) && (guestScore - homeScore) <= 20)
                    return OptionItemSFC.GW16TO20;
                else if (21 <= (guestScore - homeScore) && (guestScore - homeScore) <= 25)
                    return OptionItemSFC.GW21TO25;
                else if (26 <= (guestScore - homeScore))
                    return OptionItemSFC.GW26;
            }
            case 33: {
                if (homeScore + guestScore > bigOrSamllBase.doubleValue())
                    return OptionItemDXF.BIG;// 主胜
                else
                    return OptionItemDXF.SMALL;// 主负
            }case 43:{
                return null;
            }
            default:
                throw new RuntimeException("玩法传递错误");
        }
    }


    public static Map<String, String> getResultInfo(BasketBallMatch match) {
        Map<String, String> resultInfoMap = new HashMap<String, String>();
        resultInfoMap.put(homeScoreKey, match.getHomeScore() + "");
        resultInfoMap.put(guestScoreKey, match.getGuestScore() + "");
        resultInfoMap.put(handicapKey, match.getHandicap() + "");
        resultInfoMap.put(bigSmallKey, match.getBaseBigOrSmall() + "");
        return resultInfoMap;
    }

    public static <T extends SportteryBetContentModel<X>, X extends MatchItem> T Object4Json(String content, Class<T> modelClass,
                                                                                             Class<X> matchitemClass) {
        JSONObject json = JSONObject.fromObject(content);
        if(!json.containsKey("passTypes")){//把passType组建passTypes[]
            String str = json.getString("passType");
            JSONArray arr=new JSONArray();
            arr.add(str);
            json.put("passTypes", arr);
            json.remove("passType");
        }
        T contentObj = (T) JSONObject.toBean(json, modelClass);
        String matchItemStr = json.getString("matchItems");
        Map classMap = new HashMap<String, Class>();
        classMap.put("options", SportteryOption.class);
        List<X> matchItem = CommonUtils.getList4Json(matchItemStr, matchitemClass, classMap);
        contentObj.setMatchItems(matchItem);
        List<SportteryPassType> type = new ArrayList<SportteryPassType>();
        JSONArray arr = json.getJSONArray("passTypes");
        for (int i = 0; i < arr.size(); i++) {
            SportteryPassType t = SportteryPassType.valueOf(arr.get(i).toString());
            type.add(t);
        }
        contentObj.setPassTypes(type);
        return contentObj;
    }
    public static <T> List<T> getList4Json(String jsonString, Class<T> pojoClass, Map classMap) {
        JSONArray jsonArray = JSONArray.fromObject(jsonString);
        JSONObject jsonObject;
        T pojoValue;
        List<T> list = new ArrayList<T>();
        for (int i = 0; i < jsonArray.size(); i++) {
            jsonObject = jsonArray.getJSONObject(i);
            if (classMap != null) {
                pojoValue = (T) JSONObject.toBean(jsonObject, pojoClass, classMap);
            } else {
                pojoValue = (T) JSONObject.toBean(jsonObject, pojoClass);
            }
            list.add(pojoValue);
        }
        return list;
    }

    public static Map<String, Integer> getBgTimeAndEdTime(int dayLength) {
        Map<String, Integer> timeMap = new HashMap<String, Integer>();
        Calendar d = Calendar.getInstance();//
        String dateformat = "yyyyMMdd";
        SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
        String endDateIntTimeStr = sdf.format(d.getTime());
        Integer endDateIntTime = Integer.valueOf(endDateIntTimeStr);
        timeMap.put(endIntTimeKey, endDateIntTime);
        d.add(Calendar.DAY_OF_MONTH, -dayLength);
        String beginDateIntTimeStr = sdf.format(d.getTime());
        Integer beginDateIntTime = Integer.valueOf(beginDateIntTimeStr);
        timeMap.put(beginIntTimeKey, beginDateIntTime);
        return timeMap;
    }

    public static OptionItem getZQResultOptionItem(String type, Map<String, String> resultMap) {// 只是用于单关，过关不需要
        String tempHomeScore = resultMap.get(homeScoreKey);
        String tempGuestScore = resultMap.get(guestScoreKey);
        String tempconcede = resultMap.get(CONCEDEKEY);
        String halfHomeScoreStr = resultMap.get(resultHalfHomeScore);
        String halfGuestScoreStr = resultMap.get(resultHalfGuestScore);

        Integer homeScore = Integer.valueOf(tempHomeScore);// 主队分数:为-1表示赛事取消
        Integer guestScore = Integer.valueOf(tempGuestScore);// 客队分数:为-1表示赛事取消
        Integer concede = Integer.valueOf(tempconcede);// 让分
        Integer halfHomeScore = Integer.valueOf(halfHomeScoreStr);
        Integer halfGuestScore = Integer.valueOf(halfGuestScoreStr);

        switch (Integer.valueOf(type)) {
            case 34: {
                if (homeScore + concede > guestScore)
                    return OptionItemRQSPF.WIN;// 主胜
                else if (homeScore + concede < guestScore)
                    return OptionItemRQSPF.LOSE;// 主负
                else
                    return OptionItemRQSPF.DRAW;// 主平
            }
            case 35: {
                if (homeScore == 1 & guestScore == 0) {
                    return OptionItemBF.WIN10;// 1:0
                } else if (homeScore == 2 & guestScore == 0) {
                    return OptionItemBF.WIN20;// 2:0
                } else if (homeScore == 2 & guestScore == 1) {
                    return OptionItemBF.WIN21;// 2:1
                } else if (homeScore == 3 & guestScore == 0) {
                    return OptionItemBF.WIN30;// 3:0
                } else if (homeScore == 3 & guestScore == 1) {
                    return OptionItemBF.WIN31;// 1:3
                } else if (homeScore == 3 & guestScore == 2) {
                    return OptionItemBF.WIN32;// 2:3
                } else if (homeScore == 4 & guestScore == 0) {
                    return OptionItemBF.WIN40;// 0:4
                } else if (homeScore == 4 & guestScore == 1) {
                    return OptionItemBF.WIN41;// 1:4
                } else if (homeScore == 4 & guestScore == 2) {
                    return OptionItemBF.WIN42;// 2:4
                } else if (homeScore == 5 & guestScore == 0) {
                    return OptionItemBF.WIN50;// 0:5
                } else if (homeScore == 5 & guestScore == 1) {
                    return OptionItemBF.WIN51;// 1:5
                } else if (homeScore == 5 & guestScore == 2) {
                    return OptionItemBF.WIN52;// 2:5
                }

                else if (homeScore == 0 & guestScore == 0) {
                    return OptionItemBF.DRAW00;// 0:0
                } else if (homeScore == 1 & guestScore == 1) {
                    return OptionItemBF.DRAW11;// 1:1
                } else if (homeScore == 2 & guestScore == 2) {
                    return OptionItemBF.DRAW22;// 2:2
                } else if (homeScore == 3 & guestScore == 3) {
                    return OptionItemBF.DRAW33;// 3:3
                }

                else if (homeScore == 0 & guestScore == 1) {
                    return OptionItemBF.LOSE01;// 0:1
                } else if (homeScore == 0 & guestScore == 2) {
                    return OptionItemBF.LOSE02;// 0:2
                } else if (homeScore == 1 & guestScore == 2) {
                    return OptionItemBF.LOSE12;// 1:2
                } else if (homeScore == 0 & guestScore == 3) {
                    return OptionItemBF.LOSE03;// 0:3
                } else if (homeScore == 1 & guestScore == 3) {
                    return OptionItemBF.LOSE13;// 1:3
                } else if (homeScore == 2 & guestScore == 3) {
                    return OptionItemBF.LOSE23;// 2:3
                } else if (homeScore == 0 & guestScore == 4) {
                    return OptionItemBF.LOSE04;// 0:4
                } else if (homeScore == 1 & guestScore == 4) {
                    return OptionItemBF.LOSE14;// 1:4
                } else if (homeScore == 2 & guestScore == 4) {
                    return OptionItemBF.LOSE24;// 2:4
                } else if (homeScore == 0 & guestScore == 5) {
                    return OptionItemBF.LOSE05;// 0:5
                } else if (homeScore == 1 & guestScore == 5) {
                    return OptionItemBF.LOSE15;// 1:5
                } else if (homeScore == 2 & guestScore == 5) {
                    return OptionItemBF.LOSE25;// 2:5
                } else if (homeScore > guestScore) {
                    return OptionItemBF.WIN_OTHER;//
                } else if (homeScore == guestScore) {
                    return OptionItemBF.DRAW_OTHER;//
                } else if (homeScore < guestScore) {
                    return OptionItemBF.LOSE_OTHER;//
                }

            }
            case 36: {
                if ((homeScore + guestScore) == 0)
                    return OptionItemJQS.S0;
                else if ((homeScore + guestScore) == 1)
                    return OptionItemJQS.S1;
                else if ((homeScore + guestScore) == 2)
                    return OptionItemJQS.S2;
                else if ((homeScore + guestScore) == 3)
                    return OptionItemJQS.S3;
                else if ((homeScore + guestScore) == 4)
                    return OptionItemJQS.S4;
                else if ((homeScore + guestScore) == 5)
                    return OptionItemJQS.S5;
                else if ((homeScore + guestScore) == 6)
                    return OptionItemJQS.S6;
                else
                    return OptionItemJQS.S7;
            }
            case 37: {
                if (halfHomeScore > halfGuestScore && homeScore > guestScore)
                    return OptionItemBQC.WIN_WIN;// 胜胜
                else if (halfHomeScore > halfGuestScore && homeScore.equals(guestScore))
                    return OptionItemBQC.WIN_DRAW;// 胜平
                else if (halfHomeScore > halfGuestScore && homeScore < guestScore)
                    return OptionItemBQC.WIN_LOSE;// 胜负
                else if (halfHomeScore.equals(halfGuestScore) && homeScore > guestScore)
                    return OptionItemBQC.DRAW_WIN;// 平胜
                else if (halfHomeScore.equals(halfGuestScore) && homeScore.equals(guestScore))
                    return OptionItemBQC.DRAW_DRAW;// 平平
                else if (halfHomeScore.equals(halfGuestScore) && homeScore < guestScore)
                    return OptionItemBQC.DRAW_LOSE;// 平负
                else if (halfHomeScore < halfGuestScore && homeScore > guestScore)
                    return OptionItemBQC.LOSE_WIN;// 负胜
                else if (halfHomeScore < halfGuestScore && homeScore.equals(guestScore))
                    return OptionItemBQC.LOSE_DRAW;// 负平
                else if (halfHomeScore < halfGuestScore && homeScore < guestScore)
                    return OptionItemBQC.LOSE_LOSE;// 负负
            }
            case 41: {
                if (homeScore > guestScore)
                    return OptionItemSPF.WIN;// 主胜
                else if (homeScore < guestScore)
                    return OptionItemSPF.LOSE;// 主负
                else
                    return OptionItemSPF.DRAW;// 主平
            }case 44: {
                if(concede==-1){ //主胜WIN-客不败LOSE_RQ
                    if (homeScore + concede>= guestScore){
                        return OptionItemHT2C1.WIN;
                    }else if(homeScore + concede < guestScore){
                        return OptionItemHT2C1.LOSE_RQ;
                    }
                }else if(concede==1){//客胜LOSE-主不败WIN_RQ
                    if (homeScore + concede> guestScore){
                        return OptionItemHT2C1.WIN_RQ;
                    }else if(homeScore + concede <= guestScore){
                        return OptionItemHT2C1.LOSE;
                    }
                }else{
                    throw new RuntimeException("玩法传递错误");
                }
            }
            default:
                throw new RuntimeException("玩法传递错误");
        }
    }
	
    public static Map<String, String> getZQResultInfo(FootBallMatch match) {
        Map<String, String> resultInfoMap = new HashMap<String, String>();
        resultInfoMap.put(homeScoreKey, match.getHomeScore() + "");
        resultInfoMap.put(guestScoreKey, match.getGuestScore() + "");
        resultInfoMap.put(resultHalfHomeScore, match.getHalfHomeScore() + "");
        resultInfoMap.put(resultHalfGuestScore, match.getHalfGuestScore() + "");
        resultInfoMap.put(CONCEDEKEY, match.getConcede() + "");
        return resultInfoMap;
    }

    /**
     * SP类型转换
     * @param award
     * @return
     */
    public static Double getAward(String award) {
        double wAward = 0.0;
        if (!"".equals(award) && NumberTools.isNum(award)) {
            wAward = Double.parseDouble(award);
        }
        return wAward;
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

//    @SuppressWarnings("unchecked")
//    public static <T extends SportteryTicketModel<X>, X extends MatchItem> T Object4TikectJson(
//            String content, Class<T> modelClass, Class<X> matchitemClass) {
//        JSONObject json = JSONObject.fromObject(content);
//        T contentObj = (T) JSONObject.toBean(json, modelClass);
//        String matchItemStr = json.getString("matchItems");
//        Map classMap = new HashMap<String, Class>();
//        classMap.put("options", SportteryOption.class);
//        List<X> matchItem = CommonUtils.getList4Json(matchItemStr, matchitemClass, classMap);
//        contentObj.setMatchItems(matchItem);
//        return contentObj;
//    }

    @SuppressWarnings("unchecked")
    public static <T extends SportteryTicketModel<X>, X extends MatchItem> T Object4TikectJson(
            String content, Class<T> modelClass, Class<X> matchitemClass) {
        JSONObject json = JSONObject.fromObject(content);
        T contentObj = (T) JSONObject.toBean(json, modelClass);
        String matchItemStr = json.getString("matchItems");
        Map classMap = new HashMap<String, Class>();
        classMap.put("options", SportteryOption.class);
        List<X> matchItem = CommonUtils.getList4Json(matchItemStr, matchitemClass, classMap);
        contentObj.setMatchItems(matchItem);
        return contentObj;
    }
	
    public static String getResultForBasketBall(int type, Integer homeScore, Integer guestScore, double rf, double dxf) {
        String result = null;
        switch (type) {
            case 30: {
                //胜负
                if (homeScore > guestScore) {
                    return "主胜";
                } else {
                    return "客胜";
                }
            }
            case 31: {
                //让分胜负
                if (homeScore + rf > guestScore) {
                    return "让分主胜";
                } else{
                    return "让分客胜";
                }
            }
            case 32: {
                if (1 <= (homeScore - guestScore) && (homeScore - guestScore) <= 5)
                    return "主胜1-5";
                else if (6 <= (homeScore - guestScore) && (homeScore - guestScore) <= 10)
                    return "主胜6-10";
                else if (11 <= (homeScore - guestScore) && (homeScore - guestScore) <= 15)
                    return "主胜11-15";
                else if (16 <= (homeScore - guestScore) && (homeScore - guestScore) <= 20)
                    return "主胜16-20";
                else if (21 <= (homeScore - guestScore) && (homeScore - guestScore) <= 25)
                    return "主胜21-25";
                else if (26 <= (homeScore - guestScore))
                    return "主胜26+";
                else if (1 <= (guestScore - homeScore) && (guestScore - homeScore) <= 5)
                    return "客胜1-5";
                else if (6 <= (guestScore - homeScore) && (guestScore - homeScore) <= 10)
                    return "客胜6-10";
                else if (11 <= (guestScore - homeScore) && (guestScore - homeScore) <= 15)
                    return "客胜11-15";
                else if (16 <= (guestScore - homeScore) && (guestScore - homeScore) <= 20)
                    return "客胜16-20";
                else if (21 <= (guestScore - homeScore) && (guestScore - homeScore) <= 25)
                    return "客胜21-25";
                else if (26 <= (guestScore - homeScore))
                    return "客胜26+";
            }
            case 33: {
                if (homeScore + guestScore > dxf)
                    return "大";
                else
                    return "小";
            }
        }
        return result;
    }

    public static String getResultForFootBall(int type, Integer homeScore, Integer guestScore, Integer halfHomeScore, Integer halfGuestScore, int concede) {
        String result = null;
        switch (type) {
            case 34: {
                //让球胜平负
                if (homeScore + concede > guestScore)
                    return  "("+concede+")胜";
                else if (homeScore + concede < guestScore)
                    return "("+concede+")负";
                else
                    return "("+concede+")平";
            }
            case 35: {
                //比分
                if (homeScore == 1 & guestScore == 0) {
                    return "1:0";
                } else if (homeScore == 2 & guestScore == 0) {
                    return "2:0";
                } else if (homeScore == 2 & guestScore == 1) {
                    return "2:1";
                } else if (homeScore == 3 & guestScore == 0) {
                    return "3:0";
                } else if (homeScore == 3 & guestScore == 1) {
                    return "3:1";
                } else if (homeScore == 3 & guestScore == 2) {
                    return "3:2";
                } else if (homeScore == 4 & guestScore == 1) {
                    return "4:1";
                } else if (homeScore == 4 & guestScore == 2) {
                    return "4:2";
                } else if (homeScore == 5 & guestScore == 0) {
                    return "5:0";
                } else if (homeScore == 5 & guestScore == 1) {
                    return "5:1";
                } else if (homeScore == 5 & guestScore == 2) {
                    return "5:2";
                } else if (homeScore == 0 & guestScore == 0) {
                    return "0:0";
                } else if (homeScore == 1 & guestScore == 1) {
                    return "1:1";
                } else if (homeScore == 2 & guestScore == 2) {
                    return "2:2";
                } else if (homeScore == 3 & guestScore == 3) {
                    return "3:3";
                } else if (homeScore == 0 & guestScore == 1) {
                    return "0:1";
                } else if (homeScore == 0 & guestScore == 2) {
                    return "0:2";
                } else if (homeScore == 1 & guestScore == 2) {
                    return "1:2";
                } else if (homeScore == 0 & guestScore == 3) {
                    return "0:3";
                } else if (homeScore == 1 & guestScore == 3) {
                    return "1:3";
                } else if (homeScore == 2 & guestScore == 3) {
                    return "2:3";
                } else if (homeScore == 0 & guestScore == 4) {
                    return "0:4";
                } else if (homeScore == 1 & guestScore == 4) {
                    return "1:4";
                } else if (homeScore == 2 & guestScore == 4) {
                    return "2:4";
                } else if (homeScore == 0 & guestScore == 5) {
                    return "0:5";
                } else if (homeScore == 1 & guestScore == 5) {
                    return "1:5";
                } else if (homeScore == 2 & guestScore == 5) {
                    return "2:5";
                } else if (homeScore > guestScore) {
                    return "胜其他";
                } else if (homeScore == guestScore) {
                    return "平其他";
                } else if (homeScore < guestScore) {
                    return "负其他";
                }

            }
            case 36: {
                if ((homeScore + guestScore) == 0)
                    return "0";
                else if ((homeScore + guestScore) == 1)
                    return "1";
                else if ((homeScore + guestScore) == 2)
                    return "2";
                else if ((homeScore + guestScore) == 3)
                    return "3";
                else if ((homeScore + guestScore) == 4)
                    return "4";
                else if ((homeScore + guestScore) == 5)
                    return "5";
                else if ((homeScore + guestScore) == 6)
                    return "6";
                else
                    return "7+";
            }
            case 37: {
                //半全场
                if (halfHomeScore > halfGuestScore && homeScore > guestScore)
                    return "胜胜";
                else if (halfHomeScore > halfGuestScore && homeScore.equals(guestScore))
                    return "胜平";
                else if (halfHomeScore > halfGuestScore && homeScore < guestScore)
                    return "胜负";
                else if (halfHomeScore.equals(halfGuestScore) && homeScore > guestScore)
                    return "平胜";
                else if (halfHomeScore.equals(halfGuestScore) && homeScore.equals(guestScore))
                    return "平平";
                else if (halfHomeScore.equals(halfGuestScore) && homeScore < guestScore)
                    return "平负";
                else if (halfHomeScore < halfGuestScore && homeScore > guestScore)
                    return "负胜";
                else if (halfHomeScore < halfGuestScore && homeScore.equals(guestScore))
                    return "负平";
                else if (halfHomeScore < halfGuestScore && homeScore < guestScore)
                    return "负负";
            }
            case 41: {
                //胜平负
                if (homeScore > guestScore)
                    return "胜";
                else if (homeScore < guestScore)
                    return "负";
                else
                    return "平";
            }
        }
        return result;
    }
}
