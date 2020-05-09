package com.qiyun.service.impl;

import com.github.pagehelper.PageHelper;
import com.qiyun.common.Result;
import com.qiyun.dto.Member2DTO;
import com.qiyun.dto.MemberWalletLineDTO;
import com.qiyun.mapper.MemberWalletLineMapper;
import com.qiyun.mapper2.MemberWalletLine2Mapper;
import com.qiyun.model.LotteryType;
import com.qiyun.model2.MemberWalletLine2;
import com.qiyun.model2.MemberWalletLine2Query;
import com.qiyun.service.MemberWalletLineService;
import com.qiyun.type.WalletTransType;
import com.qiyun.type.WalletType;

import com.qiyun.util.CopyUtils;
import com.qiyun.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberWalletLineServiceImpl implements MemberWalletLineService {

    private static Logger logger = LoggerFactory.getLogger(MemberWalletLineServiceImpl.class);

    @Resource
    private MemberWalletLineMapper memberWalletLineMapper;

    @Resource
    private MemberWalletLine2Mapper memberWalletLine2Mapper;


    public Result getWalletLine(Member2DTO member2DTO, int page, int pageSize, String type) {
        try {
            Result result = new Result();

            List<MemberWalletLineDTO> list = new ArrayList<MemberWalletLineDTO>();
            /*for (MemberWalletLine2 memberWalletLine2 : memberWalletLine2s) {
                if (StringUtils.isNullOrBlank(type)) {
                    MemberWalletLineDTO memberWalletLineDTO = new MemberWalletLineDTO();
                    CopyUtils.Copy(memberWalletLineDTO, memberWalletLine2, true);
                    memberWalletLineDTO.setLotteryTypeStr(LotteryType.getItem(memberWalletLineDTO.getLotteryType()).getName());
//                    memberWalletLineDTO.setWalletTypeStr(WalletType.getItem(memberWalletLineDTO.getWalletType()).getName());
                    memberWalletLineDTO.setTransTypeStr(WalletTransType.getItem(memberWalletLineDTO.getTransType()).getName());
                    if (WalletTransType.outTypeList.contains(WalletTransType.getItem(memberWalletLineDTO.getTransType()))) {
                        memberWalletLineDTO.setAmount(-memberWalletLineDTO.getAmount());
                    }
                    list.add(memberWalletLineDTO);
                }else{
                    if ("jj".equals(type)){
                        MemberWalletLineDTO memberWalletLineDTO = new MemberWalletLineDTO();
                        if (WalletTransType.prizeTypeList.contains(WalletTransType.getItem(memberWalletLine2.getTransType()))) {
                            CopyUtils.Copy(memberWalletLineDTO, memberWalletLine2, true);
                            memberWalletLineDTO.setLotteryTypeStr(LotteryType.getItem(memberWalletLineDTO.getLotteryType()).getName());
//                            memberWalletLineDTO.setWalletTypeStr(WalletType.getItem(memberWalletLineDTO.getWalletType()).getName());
                            memberWalletLineDTO.setTransTypeStr(WalletTransType.getItem(memberWalletLineDTO.getTransType()).getName());
                            if (WalletTransType.outTypeList.contains(WalletTransType.getItem(memberWalletLineDTO.getTransType()))) {
                                memberWalletLineDTO.setAmount(-memberWalletLineDTO.getAmount());
                            }
                            list.add(memberWalletLineDTO);
                        }
                    }else if ("xf".equals(type)){
                        MemberWalletLineDTO memberWalletLineDTO = new MemberWalletLineDTO();
                        if (WalletTransType.consumeTypeList.contains(WalletTransType.getItem(memberWalletLine2.getTransType()))) {
                            CopyUtils.Copy(memberWalletLineDTO, memberWalletLine2, true);
                            memberWalletLineDTO.setLotteryTypeStr(LotteryType.getItem(memberWalletLineDTO.getLotteryType()).getName());
//                            memberWalletLineDTO.setWalletTypeStr(WalletType.getItem(memberWalletLineDTO.getWalletType()).getName());
                            memberWalletLineDTO.setTransTypeStr(WalletTransType.getItem(memberWalletLineDTO.getTransType()).getName());
                            if (WalletTransType.outTypeList.contains(WalletTransType.getItem(memberWalletLineDTO.getTransType()))) {
                                memberWalletLineDTO.setAmount(-memberWalletLineDTO.getAmount());
                            }
                            list.add(memberWalletLineDTO);
                        }
                    }
                }
            }
            List<MemberWalletLineDTO> list2 = new ArrayList<MemberWalletLineDTO>();
            for (int i = (page-1)*pageSize; i < page*pageSize; i++) {
                 if (i<list.size()){
                     list2.add(list.get(i));
                 }

            }*/
            List<MemberWalletLine2> memberWalletLine2s=null;
            MemberWalletLine2Query memberWalletLine2Query = new MemberWalletLine2Query();
            MemberWalletLine2Query.Criteria criteria = memberWalletLine2Query.createCriteria();
            criteria.andAccountEqualTo(member2DTO.getAccount());
            memberWalletLine2Query.setOrderByClause("CREATE_DATE_TIME DESC");
            PageHelper.startPage(page,pageSize);
            if (StringUtils.isNullOrBlank(type)) {

            }else if ("jj".equals(type)){
                List<Integer> arr = new ArrayList<Integer>();
                arr.add(35);
                arr.add(1018);
                criteria.andTransTypeIn(arr);
            }else if ("xf".equals(type)){
                List<Integer> arr = new ArrayList<Integer>();
                arr.add(30);
                arr.add(2061);
                criteria.andTransTypeIn(arr);
            }
            memberWalletLine2s = memberWalletLine2Mapper.selectByExampleWithBLOBs(memberWalletLine2Query);
            int totalCount = memberWalletLine2Mapper.countByExample(memberWalletLine2Query);
            if (memberWalletLine2s==null || memberWalletLine2s.size()<=0){
                result.setSuccess(true);
                result.setTotalCount(0);
                return result;
            }
            for (MemberWalletLine2 memberWalletLine2 : memberWalletLine2s) {
                MemberWalletLineDTO memberWalletLineDTO = new MemberWalletLineDTO();
                CopyUtils.Copy(memberWalletLineDTO, memberWalletLine2, true);
                memberWalletLineDTO.setLotteryTypeStr(LotteryType.getItem(memberWalletLineDTO.getLotteryType()).getName());
//                    memberWalletLineDTO.setWalletTypeStr(WalletType.getItem(memberWalletLineDTO.getWalletType()).getName());
                memberWalletLineDTO.setTransTypeStr(WalletTransType.getItem(memberWalletLineDTO.getTransType()).getName());
                if (WalletTransType.outTypeList.contains(WalletTransType.getItem(memberWalletLineDTO.getTransType()))) {
                    memberWalletLineDTO.setAmount(-memberWalletLineDTO.getAmount());
                }
                list.add(memberWalletLineDTO);
            }
            result.setSuccess(true);
            result.setTotalCount(totalCount);
            result.setData(list);
            return result;
        }catch (Exception e){
            logger.error("获取会员钱包流水出错",e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("获取会员钱包流水出错");
            return result;
        }
    }
}
