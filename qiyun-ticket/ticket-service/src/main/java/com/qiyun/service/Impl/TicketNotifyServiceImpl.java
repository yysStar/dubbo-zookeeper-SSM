package com.qiyun.service.Impl;

import com.qiyun.httpUtil.JsonUtil;
import com.qiyun.mapper2.TicketNotifyMapper;
import com.qiyun.mapper2.TicketNotifySpMapper;
import com.qiyun.model.TicketNotify;
import com.qiyun.model.TicketNotifySp;
import com.qiyun.service.TicketNotifyService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service("ticketNotifyService")
public class TicketNotifyServiceImpl implements TicketNotifyService {
    @Resource
    private TicketNotifyMapper ticketNotifyMapper;
    @Resource
    private TicketNotifySpMapper ticketNotifySpMapper;

    public int insertSelective(TicketNotify ticketNotify) {
        return ticketNotifyMapper.insertSelective(ticketNotify);
    }

    public TicketNotify getByOrderId(String orderId) {
        return ticketNotifyMapper.selectByOrderId(orderId);
    }

    /**
     * 插入通知表
     * @param resJo
     */
    public void builderNotify(JSONObject resJo) {
        JSONObject body = resJo.optJSONObject("body");
        JSONObject ActionResult = body.optJSONObject("ActionResult");
        if("0000".equals(ActionResult.optString("@wCode"))){
            JSONObject matchTicketQueryResult =
                    ActionResult.optJSONObject("matchTicketQueryResult");
            JSONArray tickets = matchTicketQueryResult.optJSONArray("ticket");
            for(Object object : tickets) {
                JSONObject ticket = (JSONObject) object;
                String orderId = ticket.optString("@OrderID");
                JSONObject codeLossRatio = ticket.optJSONObject("codeLossRatio");
                if(codeLossRatio == null){
                    return;
                }
                TicketNotify ticketNotify = ticketNotifyMapper.selectByOrderId(orderId);
                if(ticketNotify == null) {
                    ticketNotify = TicketNotify.builder().lotId(ticket.optString("@LotId"))
                            .orderId(orderId).ticketSerialNo(ticket.optString("@ticketSerialNo"))
                            .printSerialNo(ticket.optString("@printSerialNo"))
                            .stationId(ticket.optString("@stationId"))
                            .fixedBonus(new BigDecimal(codeLossRatio.optString("@fixedBonus"))).build();
                    ticketNotifyMapper.insertSelective(ticketNotify);
                }
                JSONArray matchLossRatio = codeLossRatio.optJSONArray("matchLossRatio");
                List<TicketNotifySp> list = ticketNotifySpMapper.selectByOrderId(orderId);
                if(list.size() == 0) {
                    for (Object oj : matchLossRatio) {
                        JSONObject jo = (JSONObject) oj;
                        List<String> keys = JsonUtil.getKey(jo);
                        String vsType = keys.get(1);
                        //获取投注类型
                        JSONObject vs = jo.optJSONObject(vsType);
                        String sp = "0";
                        String key = "";
                        String letPoint = "";
                        List<String> vsKeys = JsonUtil.getKey(vs);
                        if("@letPoint".equals(vsKeys.get(0))){
                            letPoint = vs.optString("@letPoint");
                            key = vsKeys.get(1);
                            sp = vs.optString(key);
                        } else if("@basePoint".equals(vsKeys.get(0))){
                            letPoint = vs.optString("@basePoint") + "b";
                            key = vsKeys.get(1);
                            sp = vs.optString(key);
                        } else {
                            key = vsKeys.get(0);
                            sp = vs.optString(key);
                        }
                        TicketNotifySp ticketNotifySp = TicketNotifySp.builder().matchId(jo.optString("@id"))
                                .score(key).sp(new BigDecimal(sp)).orderId(orderId).vsType(vsType)
                                .letPoint(letPoint).build();
                        ticketNotifySpMapper.insertSelective(ticketNotifySp);
                    }
                }
            }
        }
    }
}
