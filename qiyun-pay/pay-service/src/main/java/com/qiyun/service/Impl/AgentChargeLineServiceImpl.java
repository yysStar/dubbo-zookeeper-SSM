package com.qiyun.service.Impl;

import com.github.pagehelper.PageHelper;
import com.qiyun.common.Result;
import com.qiyun.dto.AgentChargeLine2DTO;
import com.qiyun.mapper.AgentChargeLineMapper;
import com.qiyun.mapper2.AgentChargeLine2Mapper;
import com.qiyun.mapper2.Member2Mapper;
import com.qiyun.model2.AgentChargeLine2;
import com.qiyun.service.AgentChargeLineService;
import com.qiyun.util.CopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgentChargeLineServiceImpl implements AgentChargeLineService {

    private static Logger logger = LoggerFactory.getLogger(AgentChargeLineServiceImpl.class);

    @Resource
    private AgentChargeLineMapper agentChargeLineMapper;

    @Resource
    private AgentChargeLine2Mapper agentChargeLine2Mapper;

    @Resource
    private Member2Mapper member2Mapper;
    public Result insert(AgentChargeLine2DTO agentChargeLine2DTO) {
        Result result = new Result();
        try {
            AgentChargeLine2 agentChargeLine2 = new AgentChargeLine2();
            CopyUtils.Copy(agentChargeLine2,agentChargeLine2DTO,true);

            agentChargeLine2Mapper.insertSelective(agentChargeLine2);

            result.setSuccess(true);
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("添加代理充值出错",e);
            result.setSuccess(false);
            result.setMsg("添加代理充值出错");
            return result;
        }
    }

    public Result getAgentChargeLine(String account, int page, int pageSize, String loginAccount, String memberAccount, String start_time, String end_time) {
        Result result = new Result();
        List<String> qdList  = member2Mapper.findQDByLoginAccount(loginAccount);
        if (qdList.size()==0){
            result.setSuccess(false);
            result.setMsg("没有权限进行操作");
            return result;
        }
        //查询渠道下面的代理
        List<String> dlList = member2Mapper.findDLByQD(qdList);
        //条件查询
        if(account!=null&&!"".equals(account)){
            dlList.addAll(qdList);
            //判断传入这个代理有没有权限
            if (!dlList.contains(account)){
                result.setSuccess(false);
                result.setMsg("没有权限对这个代理进行操作");
                return result;
            }
            dlList = new ArrayList<String>();
            dlList.add(account);
        }

            PageHelper.startPage(page, pageSize);
            List<AgentChargeLine2> agentChargeLine2s = agentChargeLine2Mapper.selectByAccounts(dlList,memberAccount,start_time,end_time);

            List<AgentChargeLine2DTO> list = new ArrayList<AgentChargeLine2DTO>();
            for (AgentChargeLine2 agentChargeLine2 : agentChargeLine2s) {
                AgentChargeLine2DTO agentChargeLine2DTO = new AgentChargeLine2DTO();
                CopyUtils.Copy(agentChargeLine2DTO, agentChargeLine2, true);
                list.add(agentChargeLine2DTO);
            }

        result.setSuccess(true);
        result.setData(list);
        return result;
    }
}
