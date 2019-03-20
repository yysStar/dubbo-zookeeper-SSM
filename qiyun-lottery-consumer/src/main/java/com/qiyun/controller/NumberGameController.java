package com.qiyun.controller;

import com.qiyun.api.LotteryApi;
import com.qiyun.controller.base.BaseController;
import com.qiyun.dto.Member2DTO;
import com.qiyun.util.Constants;
import com.qiyun.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/lottery")
public class NumberGameController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(NumberGameController.class);

    @Resource
    private LotteryApi lotteryApi;



    /**
     * 大乐透代购
     * @return
     */
    @RequestMapping(path = "/getNumberTerm", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getNumberTerm(){
        return lotteryApi.getNumberTerm();
    }

    /**
     * 大乐透代购
     * @return
     */
    @RequestMapping(path = "/superLottoDG", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> superLottoDG(){
        Map<String,Object> reqMap = new HashMap<String,Object>();
        String content = request.getParameter("content");
        int publicStatus = getInt("publicStatus", 3);
        Member2DTO member2DTO = checkLogin();
        if (member2DTO==null){
            reqMap.put(Constants.CODE,Constants.ERROR_CODE_2);
            reqMap.put(Constants.MSG,Constants.ERROR_MSG_2_4);
            return reqMap;
        }
        //获得彩金卡信息
        Integer cardId = getInt("card_id",0);//彩金卡id 没有彩金卡传0
        String card_money=request.getParameter("card_money");
        if (StringUtils.isNullOrBlank(card_money)){
            card_money="0";
        }
        reqMap.put("content",content);
        reqMap.put("member2DTO",member2DTO);
        reqMap.put("publicStatus",publicStatus);
        reqMap.put("cardId",cardId);
        reqMap.put("cardMoney",card_money);
        return lotteryApi.superLottoDG(reqMap);
    }

}
