package com.qiyun.controller;

import com.qiyun.api.TicketManageApi;
import com.qiyun.controller.base.BaseController;
import com.qiyun.util.Constants;
import com.qiyun.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ticket")
public class TicketManageController  extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(TicketManageController.class);

    @Resource
    private TicketManageApi ticketManageApi;



    @RequestMapping(path = "/getPlanTicketDetail", method = RequestMethod.GET)
    public Map<String,Object> getPlanTicketDetail() {
        int planNo = getInt("planNo");
        return ticketManageApi.getPlanTicketDetail(planNo);
    }

    /**
     * 票查询
     * @return
     */
    @RequestMapping(path = "/searchTicket", method = RequestMethod.GET)
    public Map<String,Object> searchTicket() {
        Map<String,Object> map = new HashMap<String, Object>();
        Integer type = getInt("type");   //查询的类型  -1或null为全部
        Integer provider = getInt("provider");   //查询的提供商 -1或null为全部
        String term = getStr("term");   //查询的彩期，null为全部
        String startTerm = getStr("startTerm"); //查询的彩期开始期数，null为没有起始限制
        String endTerm = getStr("endTerm"); //查询的彩期结束期数，null为没有结束限制
        Integer id = getInt("id");  //查询的票号  -1或null为查询全部
        Integer planNo = getInt("planNo");  //查询的方案编号   -1或null为查询全部
        Integer playType = getInt("playType");  //查询的玩法 -1或null为全部
        Integer isBingo = getInt("isBingo");    //查询的中奖状态   -1全部  0中奖  1未中奖
        Integer status = getInt("status");    //查询的出票状态   -1全部  1未送票  3未确认   4出票成功   5出票失败
        String createDateTimeStart = getStr("createDateTimeStart");//生成票开始时间，null为没有起始限制
        String createDateTimeEnd = getStr("createDateTimeEnd");//生成票结束时间，null为没有结束限制
        String printDateTimeStart = getStr("printDateTimeStart");//打印票开始时间，null为没有起始限制
        String printDateTimeEnd = getStr("printDateTimeEnd");//打印票结束时间，null为没有结束限制
        String sendTicketDateTimeStart = getStr("sendTicketDateTimeStart");//送票开始时间，null为没有起始限制
        String sendTicketDateTimeEnd = getStr("sendTicketDateTimeEnd");//送票结束时间，null为没有结束限制
        Integer offset = getInt("offset",1);
        Integer pagesize = getInt("pagesize",20);
//        map.put("type",type); map.put("provider",provider); map.put("term",term);map.put("startTerm",startTerm);map.put("endTerm",endTerm);
//        map.put("id",id);map.put("planNo",planNo);map.put("playType",playType);map.put("isBingo",isBingo);map.put("status",status);map.put("createDateTimeStart",createDateTimeStart);
//        map.put("createDateTimeEnd",createDateTimeEnd);map.put("printDateTimeStart",printDateTimeStart);map.put("printDateTimeEnd",printDateTimeEnd);
//        map.put("sendTicketDateTimeStart",sendTicketDateTimeStart);map.put("sendTicketDateTimeEnd",sendTicketDateTimeEnd);map.put("offset",offset);map.put("pagesize",pagesize);
        return ticketManageApi.searchTicket(type,provider,term,startTerm,endTerm,id,planNo,playType,isBingo,status,createDateTimeStart,createDateTimeEnd,printDateTimeStart,printDateTimeEnd,sendTicketDateTimeStart,sendTicketDateTimeEnd,offset,pagesize);
    }

    /**
     * 寻票列表（新）
     * @return
     */
    @RequestMapping(path = "/findTicketList2", method = RequestMethod.GET)
    public Map<String,Object> findTicketList2(){
        int type = getInt("type", 1);  //类型  1代理列表  2后台列表
        String account = request.getParameter("account");
        int planNo = getInt("planNo",0);
        int page = getInt("page", 1);
        int pageSize = getInt("pageSize", 10);

        return ticketManageApi.findTicketList2(type,account,planNo,page,pageSize);
    }

    /**
     * 寻票（新）
     * @return
     */
    @RequestMapping(path = "/findTicke2", method = RequestMethod.GET)
    public Map<String,Object> findTicket2(){
        Map<String, Object> map = new HashMap<String, Object>();
        int planNo = getInt("planNo");
        String account = getStr("account");
        int type = getInt("type", 1);

        map = ticketManageApi.findTicket(planNo, account, type);

        return map;
    }

    /**
     * 获取出票检验
     * @return
     */
    @RequestMapping(path = "/getTicketConfig", method = RequestMethod.GET)
    public Map<String,Object> getTicketConfig(){
        int isSuper = getInt("isSuper",1);
        return ticketManageApi.getTicketConfig(isSuper);
    }

    /**
     * 修改出票检验
     * @return
     */
    @RequestMapping(path = "/updateTicketConfig", method = RequestMethod.GET)
    public Map<String,Object> updateTicketConfig(){
        String amount = request.getParameter("amount");
        String bonus = request.getParameter("bonus");
        int isSuper = getInt("isSuper");
        int status = getInt("status");
        if (StringUtils.isNullOrBlank(amount)){
            amount="0";
        }
        if (StringUtils.isNullOrBlank(bonus)){
            bonus="0";
        }
        return ticketManageApi.addTicketConfig(Double.parseDouble(amount),Double.parseDouble(bonus),isSuper,status);
    }

    /**
     * 票务管理首页
     * @return
     */
    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public Map<String,Object> getIndexList(){
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> reqMap = new HashMap<String, Object>();
        int offset = getInt("offset",0);
        int pageSize = getInt("pageSize",20);
        reqMap.put("offset", offset);
        reqMap.put("pageSize", pageSize);
        map = ticketManageApi.getList(reqMap);
        if(Constants.SUCCESS_CODE != Integer.parseInt(map.get(Constants.CODE).toString())){
            return map;
        }
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return super.resMap(map);
    }

    /**
     * 修改票务商
     * @return
     */
    @RequestMapping(path = "/updateBusiness", method = RequestMethod.GET)
    public Map<String,Object> updateBusiness(){
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> reqMap = new HashMap<String, Object>();
        int typeId = getInt("typeId");
        if(typeId == -100){
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG,Constants.ERROR_MSG_6_1);
            return map;
        }
        int businessId = getInt("businessId");
        if(businessId == -100){
            map.put(Constants.CODE, Constants.ERROR_CODE_6);
            map.put(Constants.MSG, Constants.ERROR_MSG_6_2);
            return map;
        }
        reqMap.put("typeId", typeId);
        reqMap.put("businessId", businessId);
        map = ticketManageApi.updateBusiness(reqMap);
        if(Constants.SUCCESS_CODE != Integer.parseInt(map.get(Constants.CODE).toString())){
            return map;
        }
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 获取出票校验参数
     * @return
     */
    @RequestMapping(path = "/getRestrict", method = RequestMethod.GET)
    public Map<String,Object> getRestrict(){
        Map<String, Object> map = new HashMap<String, Object>();
        map = ticketManageApi.getRestrict();
        if(Constants.SUCCESS_CODE != Integer.parseInt(map.get(Constants.CODE).toString())){
            return map;
        }
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 修改出票校验参数
     * @return
     */
    @RequestMapping(path = "/updateRestrict", method = RequestMethod.GET)
    public Map<String,Object> updateRestrict(){
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        String lotIds = getStr("lotIds");
        String credit = getStr("credit");
        String sp = getStr("sp");
        int id = getInt("id");
        if(id == -100){
            map.put(Constants.CODE, Constants.ERROR_CODE_1);
            map.put(Constants.MSG, Constants.ERROR_MSG_1);
            return map;
        }
        reqMap.put("id", id);
        reqMap.put("lotIds", lotIds);
        reqMap.put("credit", credit);
        reqMap.put("sp", sp);
        map = ticketManageApi.updateRestrict(reqMap);
        if(Constants.SUCCESS_CODE != Integer.parseInt(map.get(Constants.CODE).toString())){
            return map;
        }
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    @RequestMapping(path = "/findTicket", method = RequestMethod.GET)
    public Map<String,Object> findTicket(){
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        int planNo = getInt("planNo");
        String account = getStr("account");
        if(planNo == -100){
            map.put(Constants.CODE, Constants.ERROR_CODE_1);
            map.put(Constants.MSG, Constants.ERROR_MSG_1);
            return map;
        }
        reqMap.put("planNo", planNo);
        map = ticketManageApi.putMatchTicketBySys(planNo, account);
        if(Constants.SUCCESS_CODE != Integer.parseInt(map.get(Constants.CODE).toString())){
            return map;
        }
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 寻票列表
     * @return
     */
    @RequestMapping(path = "/findTicketList", method = RequestMethod.GET)
    public Map<String,Object> findTicketList(){
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        int offset = getInt("offset",1);
        int pageSize = getInt("pageSize",20);
        reqMap.put("offset", offset);
        reqMap.put("pageSize", pageSize);
        map = ticketManageApi.findTicketList(reqMap);
        if(Constants.SUCCESS_CODE != Integer.parseInt(map.get(Constants.CODE).toString())){
            return map;
        }
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 送票
     * @return
     */
    @RequestMapping(path = "/deliverTicket", method = RequestMethod.GET)
    public Map<String,Object> deliverTicket(){
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> reqMap = new HashMap<String, Object>();
        int planNo = getInt("planNo");
        if(planNo == -100){
            map.put(Constants.CODE, Constants.ERROR_CODE_1);
            map.put(Constants.MSG, Constants.ERROR_MSG_1);
            return map;
        }
        reqMap.put("planNo", planNo);
        map = ticketManageApi.deliverTicket(reqMap);
        if(Constants.SUCCESS_CODE != Integer.parseInt(map.get(Constants.CODE).toString())){
            return map;
        }
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 修改票务状态
     * @return
     */
    @RequestMapping(path = "/updateStatus", method = RequestMethod.GET)
    public Map<String,Object> updatePlanTicketStatus(){
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> reqMap = new HashMap<String, Object>();
        int planNo = getInt("planNo");
        reqMap.put("planNo", planNo);
        return map;
    }

    /**
     * 查询票务出票情况
     * @return
     */
    @RequestMapping(path = "/getTicketResultByPlanNo", method = RequestMethod.GET)
    public Map<String,Object> getTicketResultByPlanNo(){
        Map<String, Object> map = new HashMap<String, Object>();
        int planNo = getInt("planNo");
        int businessType = getInt("businessType",0);
        if(planNo == -100){
            map.put(Constants.CODE, Constants.ERROR_CODE_1);
            map.put(Constants.MSG, Constants.ERROR_MSG_1);
            return map;
        }
        map = ticketManageApi.getTicketResultByPlanNo(planNo, businessType);
        if(Constants.SUCCESS_CODE != Integer.parseInt(map.get(Constants.CODE).toString())){
            return map;
        }
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        return map;
    }

    /**
     * 修改方案下票为出票状态
     * @return
     */
    @RequestMapping(path = "/updateTicketStatus", method = RequestMethod.GET)
    public Map<String,Object> updateTicketStatus(){
        Map<String, Object> map = new HashMap<String, Object>();
        int planNo = getInt("planNo");
        if(planNo == -100){
            map.put(Constants.CODE, Constants.ERROR_CODE_1);
            map.put(Constants.MSG, Constants.ERROR_MSG_1);
            return map;
        }
        map = ticketManageApi.updateTicketStatus(planNo);
        return map;
    }
}
