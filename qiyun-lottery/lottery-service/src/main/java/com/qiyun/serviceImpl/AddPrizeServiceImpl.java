package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.commonModel.PlayType;
import com.qiyun.mapper2.AddPrize2Mapper;
import com.qiyun.model2.AddPrize2;
import com.qiyun.model2.AddPrize2Query;
import com.qiyun.service.AddPrizeService;
import com.qiyun.util.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("addPrizeService")
public class AddPrizeServiceImpl implements AddPrizeService {

    @Resource
    private AddPrize2Mapper addPrize2Mapper;

    public Map<String, Object> addOrUpdate(AddPrize2 addPrize2) {
        Map<String,Object> map = new HashMap<String,Object>();
        AddPrize2 addPrize21 = addPrize2Mapper.selectByPrimaryKey(addPrize2.getLotteryType());
        if (addPrize21==null){
            addPrize2Mapper.insertSelective(addPrize2);
        }else{
            addPrize2Mapper.updateByPrimaryKey(addPrize2);
        }
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }

    public Map<String,Object> getAddPirzeConfigList(int page, int pageSize) {
        Map<String,Object> map = new HashMap<String,Object>();
        PageHelper.startPage(page,pageSize);
        List<AddPrize2> addPrize2s = addPrize2Mapper.selectByExample(new AddPrize2Query());
        int totalCount = addPrize2Mapper.countByExample(new AddPrize2Query());
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        if (addPrize2s!=null && addPrize2s.size()>0){
            for (AddPrize2 addPrize2 : addPrize2s) {
                Map<String,Object> respMap = new HashMap<String,Object>();
                respMap.put("lotteryType", LotteryType.getItem(addPrize2.getLotteryType()).getName());
                respMap.put("rate", addPrize2.getRate());
                respMap.put("minAmount",addPrize2.getMinAmount());
                if (addPrize2.getPlayTypes()!=null && addPrize2.getPlayTypes().length()>0){
                    String[] split = addPrize2.getPlayTypes().split(",");
                    String playType = "";
                    for (int i = 0; i < split.length; i++) {
                        playType += PlayType.getItem(Integer.parseInt(split[i])).getName();
                        if (i!=split.length-1){
                            playType += ",";
                        }
                    }
                    respMap.put("playType",playType);
                }
                list.add(respMap);
            }
        }

        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,list);
        map.put(Constants.TOTAL_COUNT,totalCount);
        return map;
    }

    public Map<String, Object> updateAddPirzeConfig(Integer lotteryType, double rate, double minAmount, int[] playTypes) {
        Map<String,Object> map = new HashMap<String,Object>();
        AddPrize2 addPrize2 = addPrize2Mapper.selectByPrimaryKey(lotteryType);
        if (addPrize2==null){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,Constants.ERROR_MSG_400);
            return map;
        }
        addPrize2.setRate(rate);
        addPrize2.setMinAmount(minAmount);
        String playType = "";
        for (int i = 0; i < playTypes.length; i++) {
            playType += playTypes[i];
            if (i!=playTypes.length-1){
                playType+=",";
            }

        }
        addPrize2.setPlayTypes(playType);
        addPrize2Mapper.updateByPrimaryKeySelective(addPrize2);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }


}
