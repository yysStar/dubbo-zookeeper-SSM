package com.qiyun.controller;

import com.qiyun.api.SuperGodApi;
import com.qiyun.controller.base.BaseController;
import com.qiyun.dto.Member2DTO;
import com.qiyun.util.Constants;
import com.qiyun.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/superGod")
public class SuperGodController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(SuperGodController.class);

    @Resource
    private SuperGodApi superGodApi;

    /**
     * 获取超级大神个人中心
     * @return
     */
    @RequestMapping(value = "/getSuperGod",method = RequestMethod.GET)
    public Map<String, Object> getSuperGod(){
        Map<String,Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        Member2DTO member2DTO = checkLogin();
        if(member2DTO == null){
            map.put(Constants.CODE, Constants.ERROR_CODE_2);
            map.put(Constants.MSG, Constants.ERROR_MSG_2_4);
            return map;
        }
        if(StringUtils.isNullOrBlank(account)){
            map.put(Constants.CODE,Constants.ERROR_CODE_1);
            map.put(Constants.MSG,Constants.ERROR_MSG_1_6);
            return map;
        }
        map = superGodApi.getSuperGod(account, member2DTO.getAccount());
        return map;
    }

    /**
     * 关注
     * @return
     */
    @RequestMapping(value = "/followMember",method = RequestMethod.GET)
    public Map<String, Object> followMember(){
        Map<String,Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        if(StringUtils.isNullOrBlank(account)){
            map.put(Constants.CODE,Constants.ERROR_CODE_1);
            map.put(Constants.MSG,Constants.ERROR_MSG_1_6);
            return map;
        }
        Member2DTO member2DTO = checkLogin();
        if(member2DTO == null){
            map.put(Constants.CODE,Constants.ERROR_CODE_2);
            map.put(Constants.MSG,Constants.ERROR_MSG_2_4);
            return map;
        }
        if(account.equals(member2DTO.getAccount())){
            map.put(Constants.CODE,Constants.ERROR_CODE_8);
            map.put(Constants.MSG,Constants.ERROR_MSG_8_4);
            return map;
        }
        map = superGodApi.followMember(account, member2DTO.getAccount());
        return map;
    }

    /**
     * 取消关注
     * @return
     */
    @RequestMapping(value = "/cancelFollow",method = RequestMethod.GET)
    public Map<String, Object> cancelFollow(){
        Map<String,Object> map = new HashMap<String, Object>();
        String account = request.getParameter("account");
        if(StringUtils.isNullOrBlank(account)){
            map.put(Constants.CODE,Constants.ERROR_CODE_1);
            map.put(Constants.MSG,Constants.ERROR_MSG_1_6);
            return map;
        }
        Member2DTO member2DTO = checkLogin();
        if(member2DTO == null){
            map.put(Constants.CODE,Constants.ERROR_CODE_2);
            map.put(Constants.MSG,Constants.ERROR_MSG_2_4);
            return map;
        }
        map = superGodApi.cancelFollow(account, member2DTO.getAccount());
        return map;
    }

    /**
     * 关注列表
     * @return
     */
    @RequestMapping(value = "/getFollowList",method = RequestMethod.GET)
    public Map<String, Object> getFollowList(){
        Map<String,Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if(member2DTO == null){
            map.put(Constants.CODE,Constants.ERROR_CODE_2);
            map.put(Constants.MSG,Constants.ERROR_MSG_2_4);
            return map;
        }
        int page = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        map = superGodApi.followList(member2DTO.getAccount(), page, pageSize);
        return map;
    }

    /**
     * 粉丝列表
     * @return
     */
    @RequestMapping(value = "/getFansList",method = RequestMethod.GET)
    public Map<String, Object> getFansList(){
        Map<String,Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        if(member2DTO == null){
            map.put(Constants.CODE,Constants.ERROR_CODE_2);
            map.put(Constants.MSG,Constants.ERROR_MSG_2_4);
            return map;
        }
        int page = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        map = superGodApi.fansList(member2DTO.getAccount(), page, pageSize);
        return map;
    }

    /**
     * 订单列表
     * @return
     */
    @RequestMapping(value = "/getPlanList",method = RequestMethod.GET)
    public Map<String, Object> getPlanList(){
        Map<String,Object> map = new HashMap<String, Object>();
        Member2DTO member2DTO = checkLogin();
        boolean isSelf = false;
        String account = request.getParameter("account");
        if(StringUtils.isNullOrBlank(account)){
            map.put(Constants.CODE,Constants.ERROR_CODE_1);
            map.put(Constants.MSG,Constants.ERROR_MSG_1_6);
            return map;
        }
        int type = getInt("type");
        if(member2DTO != null){
            if(account.equals(member2DTO.getAccount())) {
                isSelf = true;
            }
        }
        int page = getInt("offset",1);
        int pageSize = getInt("pageSize",10);
        map = superGodApi.planList(account, isSelf, type, page, pageSize);
        return map;
    }
}
