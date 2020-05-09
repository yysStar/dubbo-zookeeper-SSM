package com.qiyun.tools;

import com.qiyun.DTO.IssueForNumberGameDTO;
import com.qiyun.DTO.MatchTicketDTO;
import com.qiyun.DTO.NumberGameDTO;
import com.qiyun.DTO.TicketForNumberGameDTO;
import com.qiyun.httpUtil.JsonUtil;
import com.qiyun.model2.Ticket2WithBLOBs;
import com.qiyun.util.DateUtil;
import com.qiyun.util.TicketUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TicketTools {
    //竞彩赛事列表
    public static final int match = 151;

    //竞彩赛果查询
    public static final int matchResult = 153;

    //竞彩赔率查询
    public static final int matchLossRatio = 157;

    //竞彩中奖文件查询
    public static final int matchWinfile = 158;

    //竞彩票投注请求
    public static final int matchTicket = 174;

    //竞彩票状态查询
    public static final int matchTicketResult = 176;

    //竞彩赛果通知
    public static final int matchResultNotify = 152;

    //竞彩票结果通知
    public static final int matchTicketNotify = 175;

    //投注请求
    public static final int ticket = 103;
    /**
     * 拆票转为需要的参数
     * @param ticket
     * @param lotId
     * @return
     */
    public static MatchTicketDTO ticketToBusiness(Ticket2WithBLOBs ticket, String lotId, int amount){
        String content = ticket.getContent();
        MatchTicketDTO matchTicketDTO = new MatchTicketDTO();
        StringBuffer sbf = new StringBuffer();
        if(!StringTools.isNullOrBlank(content)) {
            JSONObject obj = JSONObject.fromObject(content);
            String p = obj.optString("passType");
            JSONArray matchItems = obj.getJSONArray("matchItems");
            String playType = StringTools.getPlayTypeByPassType(p);
            for(Object o : matchItems){
                JSONObject matchItem = (JSONObject) o;
                String date = matchItem.optString("intTime");
                sbf.append(date + "*");
                sbf.append(DateUtil.getWeekOfDate(DateUtil.StringToDate(date)) + "*");
                sbf.append(JsonUtil.getmatchId(matchItem.optString("lineId")) + "*");
                JSONArray options = matchItem.optJSONArray("options");
                int i = 1;
                for(Object option : options) {
                    JSONObject joption = (JSONObject) option;
                    String alotId = getLotIdByLotteryType(joption.optInt("type"));
                    if("FT005".equals(alotId) || "BSK005".equals(alotId)){
                        sbf.append(alotId + "*");
                    }
                    String value = "";
                    if("BSK004".equals(alotId)){
                        switch (joption.optInt("value")){
                            case 3:
                                value = "1";
                                break;
                            case 0:
                                value = "2";
                                break;
                        }
                    } else if("BSK003".equals(alotId)) {
                        switch (joption.optInt("value")){
                            case 0:
                                value = "01";
                                break;
                            case 1:
                                value = "02";
                                break;
                            case 2:
                                value = "03";
                                break;
                            case 3:
                                value = "04";
                                break;
                            case 4:
                                value = "05";
                                break;
                            case 5:
                                value = "06";
                                break;
                            case 6:
                                value = "11";
                                break;
                            case 7:
                                value = "12";
                                break;
                            case 8:
                                value = "13";
                                break;
                            case 9:
                                value = "14";
                                break;
                            case 10:
                                value = "15";
                                break;
                            case 11:
                                value = "16";
                                break;
                        }
                    } else {
                        value = joption.optString("value");
                        if("WW".equals(value)){
                            value = "90";
                        } else if("DD".equals(value)){
                            value = "99";
                        } else if("LL".equals(value)){
                            value = "09";
                        }
                    }
                    if (options.size() == i) {
                        sbf.append(value);
                    } else {
                        sbf.append(value + ",");
                        i++;
                    }
                }
                sbf.append("^");
                matchTicketDTO.setLotMoney(amount + "");
            }
            matchTicketDTO.setPlayType(playType);
            matchTicketDTO.setLotMulti(obj.optString("multiple"));
        }
        matchTicketDTO.setAnteCode(sbf.toString());
        matchTicketDTO.setLotId(lotId);
        return matchTicketDTO;
    }

    /**
     * 玩法转换
     * @param lotteryType
     * @return
     */
    public static String getLotIdByLotteryType(int lotteryType){
        String lotId = "";
        switch (lotteryType){
            case 41: //竞彩足球胜平负
                lotId = "FT001";
                break;
            case 35: //竞彩足球比分
                lotId = "FT002";
                break;
            case 36: //竞彩足球进球数
                lotId = "FT003";
                break;
            case 37: //竞彩足球半全场
                lotId = "FT004";
                break;
            case 42: //竞彩足球混合过关
                lotId = "FT005";
                break;
            case 49: //竞彩足球胜平负/让球---混合过关
                lotId = "FT005";
                break;
            case 34: //竞彩足球让球胜平负
                lotId = "FT006";
                break;
            case 30: //竞彩篮球胜负
                lotId = "BSK001";
                break;
            case 31: //竞彩篮球让分胜负
                lotId = "BSK002";
                break;
            case 32: //竞彩篮球胜分差
                lotId = "BSK003";
                break;
            case 33: //竞彩篮球大小分
                lotId = "BSK004";
                break;
            case 43: //竞彩篮球混合串关玩法
                lotId = "BSK005";
                break;
            case 1: //大乐透
                lotId = "dlt";
                break;
        }
        return lotId;
    }

    public static TicketForNumberGameDTO getTicketForNumberGame(Ticket2WithBLOBs ticket, String lotId) {


        String playType;
        String[] split = ticket.getContent().split("-");
        if (split[0].length()>=6 && split[1].length()>=3){
            //基本复式
            playType = "102";
        }else{
            //基本单式
            playType = "101";
        }
        String replace = ticket.getContent().replace("-", "#").replace(" ", ",");
        TicketForNumberGameDTO ticketForNumberGameDTO = new TicketForNumberGameDTO();
        String a = TicketUtil.getTcymAgentID();
        String b = JsonUtil.OrderID;
        String orderId = JsonUtil.getTcymId(a, b);
        ticketForNumberGameDTO.setOrderID(orderId);
        ticketForNumberGameDTO.setPlayType(playType);
        ticketForNumberGameDTO.setLotMoney(ticket.getAmount()+"");
        ticketForNumberGameDTO.setLotMulti(ticket.getMultiple()+"");
        ticketForNumberGameDTO.setAuthCode(new String[]{replace});

        return ticketForNumberGameDTO;
    }
}
