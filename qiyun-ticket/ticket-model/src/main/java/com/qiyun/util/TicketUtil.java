package com.qiyun.util;

import com.qiyun.DTO.MatchTicketDTO;
import com.qiyun.DTO.NumberGameDTO;
import com.qiyun.DTO.TicketForNumberGameDTO;
import com.qiyun.DTO.UserProfileDTO;
import com.qiyun.httpUtil.JsonUtil;
import com.qiyun.httpUtil.ZipHttpUtil;
import com.qiyun.tools.StringTools;
import com.qiyun.tools.TicketTools;
import net.sf.json.JSON;
import net.sf.json.JsonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
public class TicketUtil {
    private static Logger logger = LoggerFactory.getLogger(TicketUtil.class);
    //通彩易麦票务接口配置
    private static String tcymUrl; //接口地址
    private static String tcymVersion; //接口版本
    private static String tcymAgentID; //用户名
    private static String tcymAgentPwd; //密码

    public void setTcymUrl(String tcymUrl) {
        TicketUtil.tcymUrl = tcymUrl;
    }

    public void setTcymVersion(String tcymVersion) {
        TicketUtil.tcymVersion = tcymVersion;
    }

    public void setTcymAgentID(String tcymAgentID) {
        TicketUtil.tcymAgentID = tcymAgentID;
    }

    public void setTcymAgentPwd(String tcymAgentPwd) {
        TicketUtil.tcymAgentPwd = tcymAgentPwd;
    }

    public static String getTcymAgentID(){
        return tcymAgentID;
    }

    public static String getTcymAgentPwd() {
        return tcymAgentPwd;
    }


    public static String getYnjmTicketId(){
        SimpleDateFormat dateFm = new SimpleDateFormat("yyyyMMddHHmmss"); //格式化当前系统日期
        String orderid = dateFm.format(new Date());
        for(int i=0;i<6;i++) {
            orderid += new Random().nextInt(10);
        }
        return orderid;
    }


    public static String getYnjmOption(int lotteryType,String value){
        switch (lotteryType){
            case 30 : //篮球胜负
                if (value.equals("3")){
                    return "1";
                }else if (value.equals("0")){
                    return "0";
                }
                return null;
            case 31 : //篮球让分胜负
                if (value.equals("3")){
                    return "1";
                }else if (value.equals("0")){
                    return "0";
                }
                return null;
            case 32 : //篮球胜分差
                if (value.equals("6")){
                    return "01";
                }else if (value.equals("7")){
                    return "02";
                }else if (value.equals("8")){
                    return "03";
                }else if (value.equals("9")){
                    return "04";
                }else if (value.equals("10")){
                    return "05";
                }else if (value.equals("11")){
                    return "06";
                }else if (value.equals("0")){
                    return "51";
                }else if (value.equals("1")){
                    return "52";
                }else if (value.equals("2")){
                    return "53";
                }else if (value.equals("3")){
                    return "54";
                }else if (value.equals("4")){
                    return "55";
                }else if (value.equals("5")){
                    return "56";
                }
                return null;
            case 33 : //篮球大小分
                if (value.equals("3")){
                    return "1";
                }else if (value.equals("0")){
                    return "2";
                }
                return null;
            case 41 : //足球胜平负
                return value;
            case 35 : //足球比分
                if (value.equals("WW")){ //胜其他
                    return "4:3";
                }else if (value.equals("LL")){ //负其他
                    return "3:4";
                }else if (value.equals("DD")){ //平其他
                    return "4:4";
                }else{
                    String zhu = value.substring(0, 1);
                    String ke = value.substring(1, value.length());
                    return zhu + ":" + ke;
                }
            case 36 : //足球总进球
                return value;
            case 37 : //足球半全场
                String zhu = value.substring(0, 1);
                String ke = value.substring(1, value.length());
                return zhu + "_" + ke;
            case 34 : //足球让球胜平负
                return value;
        }
        return null;
    }

    public static int getYnjmLotteryID(int lotteryType){
        switch (lotteryType){
            case 30 : //篮球胜负
                return 21;
            case 31 : //篮球让分胜负
                return 22;
            case 32 : //篮球胜分差
                return 23;
            case 33 : //篮球大小分
                return 24;
            case 43 : //篮球混合
                return 25;
            case 41 : //足球胜平负
                return 11;
            case 35 : //足球比分
                return 12;
            case 36 : //足球总进球
                return 13;
            case 37 : //足球半全场
                return 14;
            case 34 : //足球让球胜平负
                return 15;
            case 42 : //足球混合
                return 16;
        }
        return 0;
    }

    public static String getTcymRes(JSONObject reqJo, int apiType){
        String type;
        String id;
        String valueType;
        String message = "";
        JSONObject jo = new JSONObject();
        switch (apiType){
            case TicketTools.match:
                type = reqJo.getString("type");
                jo = getHeadRequest(apiType);
                message = getMatchRequest(type, jo, apiType);
                break;
            case TicketTools.matchResult:
                type = reqJo.getString("type");
                id = reqJo.getString("id");
                jo = getHeadRequest(apiType);
                message = getMatchResultRequest(type, id, jo, apiType);
                break;
            case TicketTools.matchLossRatio:
                type = reqJo.getString("type");
                id = reqJo.getString("id");
                valueType = reqJo.getString("valueType");
                jo = getHeadRequest(apiType);
                message = getMatchLossRatioRequest(type, id, valueType, jo, apiType);
                break;
            case TicketTools.matchWinfile:
                type = reqJo.getString("type");
                id = reqJo.getString("id");
                jo = getHeadRequest(apiType);
                message = getMatchWinfileRequest(type, id, jo, apiType);
                break;
            case TicketTools.matchTicket:
                String matchTicketList = reqJo.getString("matchTicketList");
                JSONArray arr = JSONArray.fromObject(matchTicketList);
                List<MatchTicketDTO> matchTicketDTOS = JSONArray.toList(arr, new MatchTicketDTO(), new JsonConfig());
                jo = getHeadRequest(apiType);
                message = getMatchTicketRequest(matchTicketDTOS, jo, apiType);
                break;
            case TicketTools.matchTicketResult:
                String orderIdList = reqJo.getString("orderIdList");
                jo = getHeadRequest(apiType);
                List<String> list = StringTools.StringToList(orderIdList);
                message = getMatchTicketResultRequest(list, jo, apiType);
                break;
            case TicketTools.ticket:
                JSONObject lotteryRequest = (JSONObject) reqJo.get("lotteryRequest");
                jo = getHeadRequest(apiType);
                NumberGameDTO numberGameDTO = (NumberGameDTO) JSONObject.toBean(lotteryRequest, NumberGameDTO.class);
                message = getTicketRequest(numberGameDTO, jo, apiType);
                break;
        }
        String res = ZipHttpUtil.sendZipHttp(tcymUrl, message);
        String s = "";
        if(!StringTools.isNullOrBlank(res)) {
            s  = res.substring(res.indexOf("{"), res.lastIndexOf("}") + 1);
        }
        return s;
    }

    private static String getTicketRequest(NumberGameDTO numberGameDTO, JSONObject jo, int apiType) {
        JSONObject body = new JSONObject();
        JSONObject issue = new JSONObject();
        JSONArray tickets = new JSONArray();

        JSONObject lotteryRequest = new JSONObject();

        issue.put("@number",numberGameDTO.getIssue().getNumber());
        issue.put("@LotId",numberGameDTO.getIssue().getLotId());
        TicketForNumberGameDTO[] reqTicket = numberGameDTO.getTicket();
        for (TicketForNumberGameDTO ticketForNumberGameDTO : reqTicket) {
            JSONObject ticket = new JSONObject();
            ticket.put("@OrderId",ticketForNumberGameDTO.getOrderID());
            ticket.put("@playType",ticketForNumberGameDTO.getPlayType());
            ticket.put("@LotMoney",ticketForNumberGameDTO.getLotMoney());
            ticket.put("@LotMulti",ticketForNumberGameDTO.getLotMulti());
            ticket.put("anteCode",ticketForNumberGameDTO.getAuthCode());

            JSONObject userProfile = new JSONObject();
            userProfile.put("@userName",ticketForNumberGameDTO.getUserProfile().getUserName());
            userProfile.put("@cardType",ticketForNumberGameDTO.getUserProfile().getCardType());
            userProfile.put("@mail",ticketForNumberGameDTO.getUserProfile().getMail());
            userProfile.put("@cardNumber",ticketForNumberGameDTO.getUserProfile().getCardNumber());
            userProfile.put("@mobile",ticketForNumberGameDTO.getUserProfile().getMobile());
            userProfile.put("@realName",ticketForNumberGameDTO.getUserProfile().getRealName());
            userProfile.put("@bonusPhone",ticketForNumberGameDTO.getUserProfile().getBonusPhone());

            ticket.put("userProfile",userProfile);
            tickets.add(ticket);
        }
        lotteryRequest.put("issue",issue);
        lotteryRequest.put("tickets",tickets);

        body.put("lotteryRequest", lotteryRequest);
        JSONObject header = jo.getJSONObject("header");
        String timestamp = header.getString("timestamp");
        String wSign = MD5.encode(jo.getString("@wMsgID") + timestamp
                + tcymAgentPwd + body.toString());
        header.put("wSign", wSign);
        jo.put("body", body);
        logger.info("----------------通彩易麦请求参数：" + jo.toString());
        String message = "wAction=" + apiType + "&wMessage=" + jo.toString();
        return message;
    }


    /**
     * 出票状态查询接口
     * @param list
     * @param jo
     * @param apiType
     * @return
     */
    private static String getMatchTicketResultRequest(List<String> list, JSONObject jo, int apiType) {
        JSONObject body = new JSONObject();
        JSONObject matchTicketQuery = new JSONObject();
        JSONArray ticket = new JSONArray();
        for(String orderId : list){
            JSONObject obj = new JSONObject();
            obj.put("@OrderID", orderId);
            ticket.add(obj);
        }
        matchTicketQuery.put("ticket", ticket);
        body.put("matchTicketQuery", matchTicketQuery);
        JSONObject header = jo.getJSONObject("header");
        String timestamp = header.getString("timestamp");
        String wSign = MD5.encode(jo.getString("@wMsgID") + timestamp
                + tcymAgentPwd + body.toString());
        header.put("wSign", wSign);
        jo.put("body", body);
        logger.info("----------------通彩易麦请求参数：" + jo.toString());
        String message = "wAction=" + apiType + "&wMessage=" + jo.toString();
        return message;
    }

    /**
     * 竞彩中奖文件查询
     * @param type
     * @param id
     * @param jo
     * @param apiType
     * @return
     */
    private static String getMatchWinfileRequest(String type, String id, JSONObject jo, int apiType) {
        JSONObject body = new JSONObject();
        JSONObject matchWinFileQuery = new JSONObject();
        JSONObject matchWinfile = new JSONObject();
        matchWinfile.put("@type", type);
        matchWinfile.put("@id", id);
        matchWinFileQuery.put("matchWinfile", matchWinfile);
        body.put("matchWinFileQuery", matchWinFileQuery);
        JSONObject header = jo.getJSONObject("header");
        String timestamp = header.getString("timestamp");
        String wSign = MD5.encode(jo.getString("@wMsgID") + timestamp
                + tcymAgentPwd + body.toString());
        header.put("wSign", wSign);
        jo.put("body", body);
        logger.info("----------------通彩易麦请求参数：" + jo.toString());
        String message = "wAction=" + apiType + "&wMessage=" + jo.toString();
        return message;
    }

    /**
     * 竞彩投注请求
     *
     * @param matchTicketList
     * @param jo
     * @param apiType
     * @return
     */
    private static String getMatchTicketRequest(List<MatchTicketDTO> matchTicketList, JSONObject jo, int apiType) {
        JSONObject body = new JSONObject();
        JSONObject matchTicketRequest = new JSONObject();
        JSONArray ticket = new JSONArray();
        for(MatchTicketDTO matchTicket : matchTicketList) {
            JSONObject obj = new JSONObject();
            JSONObject userProfile = new JSONObject();
            UserProfileDTO userProfileDTO = matchTicket.getUserProfilel();
            userProfile.put("@userName", userProfileDTO.getUserName());
            userProfile.put("@cardType", userProfileDTO.getCardType());
            userProfile.put("@mail", userProfileDTO.getMail());
            userProfile.put("@cardNumber", userProfileDTO.getCardNumber());
            userProfile.put("@mobile", userProfileDTO.getMobile());
            userProfile.put("@realName", userProfileDTO.getRealName());
            userProfile.put("@bonusPhone", userProfileDTO.getBonusPhone());
            obj.put("anteCode", matchTicket.getAnteCode());
            obj.put("userProfile", userProfile);
            obj.put("@OrderID", matchTicket.getOrderId());
            obj.put("@LotId", matchTicket.getLotId());
            obj.put("@playType", matchTicket.getPlayType());
            obj.put("@LotMoney", matchTicket.getLotMoney());
            obj.put("@LotMulti", matchTicket.getLotMulti());
            ticket.add(obj);
        }
        matchTicketRequest.put("ticket", ticket);
        body.put("matchTicketRequest", matchTicketRequest);
        JSONObject header = jo.getJSONObject("header");
        String timestamp = header.getString("timestamp");
        String wSign = MD5.encode(jo.getString("@wMsgID") + timestamp
                + tcymAgentPwd + body.toString());
        header.put("wSign", wSign);
        jo.put("body", body);
        logger.info("----------------通彩易麦请求参数：" + jo.toString());
        String message = "wAction=" + apiType + "&wMessage=" + jo.toString();
        return message;
    }

    /**
     * 竞彩赔率查询
     * @param type
     * @param id
     * @param valueType
     * @param jo
     * @param apiType
     * @return
     */
    private static String getMatchLossRatioRequest(String type, String id, String valueType, JSONObject jo, int apiType) {
        JSONObject body = new JSONObject();
        JSONObject matchLossRatioQuery = new JSONObject();
        JSONObject matchLossRatio = new JSONObject();
        JSONObject codeLossRatio = new JSONObject();
        matchLossRatio.put("@id", id);
        codeLossRatio.put("@type", type);
        codeLossRatio.put("@valueType", valueType);
        codeLossRatio.put("matchLossRatio", matchLossRatio);
        matchLossRatioQuery.put("codeLossRatio", codeLossRatio);
        body.put("matchLossRatioQuery", matchLossRatioQuery);
        JSONObject header = jo.getJSONObject("header");
        String timestamp = header.getString("timestamp");
        String wSign = MD5.encode(jo.getString("@wMsgID") + timestamp
                + tcymAgentPwd + body.toString());
        header.put("wSign", wSign);
        jo.put("body", body);
        logger.info("----------------通彩易麦请求参数：" + jo.toString());
        String message = "wAction=" + apiType + "&wMessage=" + jo.toString();
        return message;
    }

    /**
     * 竞彩赛果查询
     * @param type
     * @param id
     * @param jo
     * @param apiType
     * @return
     */
    private static String getMatchResultRequest(String type, String id, JSONObject jo, int apiType) {
        JSONObject body = new JSONObject();
        JSONObject matchResultQuery = new JSONObject();
        JSONObject matchResult = new JSONObject();
        matchResult.put("@type", type);
        matchResult.put("@id", id);
        matchResultQuery.put("matchResult", matchResult);
        body.put("matchResultQuery", matchResultQuery);
        JSONObject header = jo.getJSONObject("header");
        String timestamp = header.getString("timestamp");
        String wSign = MD5.encode(jo.getString("@wMsgID") + timestamp
                + tcymAgentPwd + body.toString());
        header.put("wSign", wSign);
        jo.put("body", body);
        logger.info("----------------通彩易麦请求参数：" + jo.toString());
        String message = "wAction=" + apiType + "&wMessage=" + jo.toString();
        return message;
    }

    /**
     * 竞彩赛事列表
     * @param type
     * @param jo
     * @param apiType
     * @return
     */
    private static String getMatchRequest(String type, JSONObject jo, int apiType) {
        JSONObject body = new JSONObject();
        JSONObject matchQuery = new JSONObject();
        JSONObject match = new JSONObject();
        match.put("@type", type);
        matchQuery.put("match", match);
        body.put("matchQuery", matchQuery);
        JSONObject header = jo.getJSONObject("header");
        String timestamp = header.getString("timestamp");
        String wSign = MD5.encode(jo.getString("@wMsgID") + timestamp
                + tcymAgentPwd + body.toString());
        header.put("wSign", wSign);
        jo.put("body", body);
        logger.info("----------------通彩易麦请求参数：" + jo.toString());
        String message = "wAction=" + apiType + "&wMessage=" + jo.toString();
        return message;
    }

    /**
     * 生成通彩易麦接口入参头
     * @param apiType
     * @return
     */
    public static JSONObject getHeadRequest(int apiType) {
        JSONObject jo = new JSONObject();
        String timestamp = DateUtil.dateToString(new Date());
        jo.put("@version", tcymVersion);
        jo.put("@wMsgID", JsonUtil.getTcymId(tcymAgentID, JsonUtil.wMsgID));
        JSONObject header = new JSONObject();
        header.put("wAgentID", tcymAgentID);
        header.put("timestamp", timestamp);
        header.put("wActionType", apiType + "");
        jo.put("header", header);
        return jo;
    }

}
