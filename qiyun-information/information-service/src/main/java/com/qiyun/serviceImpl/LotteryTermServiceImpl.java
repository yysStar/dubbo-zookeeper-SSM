package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.qiyun.common.Result;
import com.qiyun.dto.BasketBallMatch2DTO;
import com.qiyun.dto.FootBallMatch2DTO;
import com.qiyun.dto.LotteryTerm2DTO;
import com.qiyun.mapper2.LotteryTerm2Mapper;
import com.qiyun.model2.*;
import com.qiyun.model2.LotteryTerm2Query.Criteria;
import com.qiyun.service.LotteryTermService;
import com.qiyun.util.Constants;
import com.qiyun.util.CopyUtils;
import com.qiyun.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class LotteryTermServiceImpl implements LotteryTermService {

    private static Logger logger = LoggerFactory.getLogger(LotteryTermServiceImpl.class);

    @Resource
    private LotteryTerm2Mapper lotteryTerm2Mapper;

    public Result getOpenResult() {
        try {
            Result result = new Result();
            int t = 30 ; //默认的取开奖号时间跨度

            //计算开始结束时间 , 优化查询范围，只查找最近t天的已开奖彩期
            Calendar ca = Calendar.getInstance();
            ca.add(Calendar.HOUR, 12);
            Date endTime = ca.getTime();
            ca.add(Calendar.DAY_OF_MONTH, -t);
            Date startTime = ca.getTime();

            Integer[] array = {100,1,3,4};
            List<LotteryTerm2DTO> lotteryTerm2DTOs = new ArrayList<LotteryTerm2DTO>();

            for (int i = 0; i < array.length; i++) {
                LotteryTerm2Query lotteryTerm2Query = new LotteryTerm2Query();
                Criteria criteria = lotteryTerm2Query.createCriteria();
                criteria.andLotteryTypeEqualTo(array[i]);
                criteria.andStatusGreaterThanOrEqualTo(4);
                criteria.andOpenDateTimeGreaterThan(startTime);
                criteria.andOpenDateTimeLessThan(endTime);
                lotteryTerm2Query.setOrderByClause("term DESC");

                PageHelper.startPage(1,1);
                List<LotteryTerm2> lotteryTerm2s = lotteryTerm2Mapper.selectByExample(lotteryTerm2Query);

                if (lotteryTerm2s==null){
                    result.setSuccess(true);
                    return result;
                }

                if (lotteryTerm2s!=null && lotteryTerm2s.size()>0){
                    for (LotteryTerm2 lotteryTerm2 : lotteryTerm2s) {
                        LotteryTerm2DTO lotteryTerm2DTO = new LotteryTerm2DTO();
                        CopyUtils.Copy(lotteryTerm2DTO,lotteryTerm2,true);
                        lotteryTerm2DTO.setLotteryTypeStr(LotteryType.getItem(lotteryTerm2.getLotteryType()).getName());
                        lotteryTerm2DTOs.add(lotteryTerm2DTO);
                    }
                }
            }


            result.setData(lotteryTerm2DTOs);
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            logger.error("获取彩期最新开奖出错",e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("获取彩期最新开奖出错");
            return result;
        }
    }

    /**
     * 获取数字彩开奖信息
     * @param type
     * @return
     */
    public Map<String, Object> getDigitalColor(int type) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<LotteryTerm2DTO> lotteryTerm2DTOs = new ArrayList<LotteryTerm2DTO>();
            if(type==0){
                List<LotteryTerm2> all = lotteryTerm2Mapper.getDigitalColor();
                if (all!=null && all.size()>0){
                    for (LotteryTerm2 lotteryTerm2 : all) {
                        LotteryTerm2DTO lotteryTerm2DTO = new LotteryTerm2DTO();
                        CopyUtils.Copy(lotteryTerm2DTO,lotteryTerm2,true);
                        lotteryTerm2DTO.setLotteryTypeStr(LotteryType.getItem(lotteryTerm2.getLotteryType()).getName());
                        lotteryTerm2DTOs.add(lotteryTerm2DTO);
                    }
                }
            }else {
                List<LotteryTerm2> list = lotteryTerm2Mapper.getOneDigitalColor(type);
                if (list!=null && list.size()>0){
                    for (LotteryTerm2 lotteryTerm3 : list) {
                        LotteryTerm2DTO lotteryTerm2DTO = new LotteryTerm2DTO();
                        CopyUtils.Copy(lotteryTerm2DTO,lotteryTerm3,true);
                        lotteryTerm2DTO.setLotteryTypeStr(LotteryType.getItem(lotteryTerm3.getLotteryType()).getName());
                        lotteryTerm2DTOs.add(lotteryTerm2DTO);
                    }
                }
            }
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA, lotteryTerm2DTOs);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE, Constants.ERROR_CODE_607);
            map.put(Constants.MSG, Constants.ERROR_MSG_607);
            return map;
        }
    }

    /**
     * 获取某个类型某个特定彩期的开奖
     * @param type
     * @param term
     * @return
     */
    public Map<String, Object> getOneDigitalColor(int type,String term){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            LotteryTerm2 lotteryTerm2=lotteryTerm2Mapper.getOneDigitalColor2(type,term);
            if(lotteryTerm2==null){
                map.put(Constants.CODE, Constants.ERROR_CODE_614);
                map.put(Constants.MSG, Constants.ERROR_MSG_614);
                return map;
            }
            LotteryTerm2DTO lotteryTerm2DTO = new LotteryTerm2DTO();
            CopyUtils.Copy(lotteryTerm2DTO,lotteryTerm2,true);
            lotteryTerm2DTO.setLotteryTypeStr(LotteryType.getItem(lotteryTerm2.getLotteryType()).getName());
            String resultDetail = lotteryTerm2DTO.getResultDetail();
            if(type==1){
                String[]strr = {"一等奖","追加一等奖","二等奖","追加二等奖","三等奖","追加三等奖","四等奖","追加四等奖","五等奖","追加五等奖","六等奖"};
                String result = resultDetail;
                String[] split = result.split("#");
                if(split.length==11){
                    for (int m = 0;m<split.length;m++) {
                        StringBuffer strBuffer = new StringBuffer();
                        String s = split[m];
                        String[] split1 = s.split("\\^");
                        strBuffer.append(strr[m]).append("^").append(split1[1]).append("^").append(split1[2]);
                        split[m] = strBuffer.toString();
                    }
                }
                StringBuffer resultBuffer = new StringBuffer();
                for (String s:split) {
                    resultBuffer.append("#").append(s);
                }
                lotteryTerm2DTO.setResultDetail(resultBuffer.substring(1));
            }
            if(type==2){
                String[]strr = {"一等奖","二等奖","三等奖","四等奖","五等奖","六等奖"};
                String result = resultDetail;
                String[] split = result.split("#");
                if(split.length==6){
                    for (int m = 0;m<split.length;m++) {
                        StringBuffer strBuffer = new StringBuffer();
                        String s = split[m];
                        String[] split1 = s.split("\\^");
                        strBuffer.append(strr[m]).append("^").append(split1[1]).append("^").append(split1[2]);
                        split[m] = strBuffer.toString();
                    }
                }
                StringBuffer resultBuffer = new StringBuffer();
                for (String s:split) {
                    resultBuffer.append("#").append(s);
                }
                lotteryTerm2DTO.setResultDetail(resultBuffer.substring(1));
            }
            if(type==3) {
                String[] strr = {"直选奖", "组选3奖", "组选6奖"};
                String[] strr2 = {"1,040", "346", "173"};
                if (resultDetail == null || resultDetail == "") {
                    StringBuffer strBuffer = new StringBuffer();
                    strBuffer.append("——").append("^").append("——").append("^").append("——");
                    lotteryTerm2DTO.setResultDetail(strBuffer.toString());
                } else {
                    String result = resultDetail.substring(1);
                    String[] split = result.split("#");
                    if (split.length == 3) {
                        for (int m = 0; m < split.length; m++) {
                            StringBuffer strBuffer = new StringBuffer();
                            String s = split[m];
                            String[] split1 = s.split("\\^");
                            strBuffer.append(strr[m]).append("^").append(split1[1]).append("^").append(strr2[m]);
                            split[m] = strBuffer.toString();
                        }
                    }
                    StringBuffer resultBuffer = new StringBuffer();
                    for (String s : split) {
                        resultBuffer.append("#").append(s);
                    }
                    lotteryTerm2DTO.setResultDetail(resultBuffer.substring(1));
                }
            }
            if(type==4){
                String[]strr = {"直选奖"};
                String[]strr2 = {"100,000"};
                String result = resultDetail;
                if (result == null || result == "") {
                    StringBuffer strBuffer = new StringBuffer();
                    strBuffer.append("——").append("^").append("——").append("^").append("——");
                    lotteryTerm2DTO.setResultDetail(strBuffer.toString());
                } else {
                    String[] split = result.split("\\^");
                    StringBuffer strBuffer = new StringBuffer();
                    strBuffer.append(strr[0]).append("^").append(split[1]).append("^").append(strr2[0]);
                    lotteryTerm2DTO.setResultDetail(strBuffer.toString());
                }
            }
            if(type==50||type==53){
                String[]strr = {"前一","任选二","任选三","任选四","任选五","任选六","任选七","任选八","前二"," 前二组选","前三","前三组选"};
                String result = resultDetail;
                String[] split = result.split("#");
                if(split.length==12){
                    for (int m = 0;m<split.length;m++) {
                        StringBuffer strBuffer = new StringBuffer();
                        String s = split[m];
                        String[] split1 = s.split("\\^");
//                        strBuffer.append(strr[m]).append("^").append(split1[1]).append("^").append(split1[2]);
                        strBuffer.append(strr[m]).append("^").append(split1[2]);
                        split[m] = strBuffer.toString();
                    }
                }
                StringBuffer resultBuffer = new StringBuffer();
                for (String s:split) {
                    resultBuffer.append("#").append(s);
                }
                lotteryTerm2DTO.setResultDetail(resultBuffer.substring(1));
            }
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA, lotteryTerm2DTO);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE, Constants.ERROR_CODE_607);
            map.put(Constants.MSG, Constants.ERROR_MSG_607);
            return map;
        }
    }

    public Map<String, Object> setPL(int type, String result,String term) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(type==1){    //排列3
            if(result.split(",").length!=3){
                map.put(Constants.CODE, Constants.ERROR_CODE_626);
                map.put(Constants.MSG, Constants.ERROR_MSG_626);
                return map;
            }
            Integer integer = lotteryTerm2Mapper.setPL3(result,term);
            if(integer==1){
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                return map;
            }else {
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "修改排列三开奖结果出错");
                return map;
            }
        }else if(type==2){  //排列5
            if(result.split(",").length!=5){
                map.put(Constants.CODE, Constants.ERROR_CODE_626);
                map.put(Constants.MSG, Constants.ERROR_MSG_626);
                return map;
            }
            Integer integer = lotteryTerm2Mapper.setPL5(result,term);
            if(integer==1){
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                return map;
            }else {
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "修改排列五开奖结果出错");
                return map;
            }
        }else{
            map.put(Constants.CODE, Constants.ERROR_CODE_626);
            map.put(Constants.MSG, Constants.ERROR_MSG_626);
            return map;
        }
    }

    /**
     * 获取高频彩开奖信息
     * @param type
     * @return
     */
    public Map<String, Object> getFrequencyColor(int type) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<LotteryTerm2DTO> lotteryTerm2DTOs = new ArrayList<LotteryTerm2DTO>();
            if(type==0){
                List<LotteryTerm2> all = lotteryTerm2Mapper.getFrequencyColor();
                if (all!=null && all.size()>0){
                    for (LotteryTerm2 lotteryTerm2 : all) {
                        LotteryTerm2DTO lotteryTerm2DTO = new LotteryTerm2DTO();
                        CopyUtils.Copy(lotteryTerm2DTO,lotteryTerm2,true);
                        lotteryTerm2DTO.setLotteryTypeStr(LotteryType.getItem(lotteryTerm2.getLotteryType()).getName());
                        lotteryTerm2DTOs.add(lotteryTerm2DTO);
                    }
                }
            }else {
                List<LotteryTerm2> list = lotteryTerm2Mapper.getOneDigitalColor(type);
                if (list!=null && list.size()>0){
                    for (LotteryTerm2 lotteryTerm3 : list) {
                        LotteryTerm2DTO lotteryTerm2DTO = new LotteryTerm2DTO();
                        CopyUtils.Copy(lotteryTerm2DTO,lotteryTerm3,true);
                        lotteryTerm2DTO.setLotteryTypeStr(LotteryType.getItem(lotteryTerm3.getLotteryType()).getName());
                        lotteryTerm2DTOs.add(lotteryTerm2DTO);
                    }
                }
            }
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA, lotteryTerm2DTOs);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE, Constants.ERROR_CODE_607);
            map.put(Constants.MSG, Constants.ERROR_MSG_607);
            return map;
        }
    }

    /**
     * 获取竞技彩开奖信息
     * @return
     */
    public Map<String, Object> getSportsColor(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            SportteryBasketMatch BB = lotteryTerm2Mapper.getOneBasketBall();
            Integer ZF = BB.getHomescore();
            Integer KF = BB.getGuestscore();
            Double DXF = BB.getBasebigorsmall();
            Double RF = BB.getHandicap();
            boolean ZS =true; //标记：默认主胜
            boolean IS =false; //是否有数据
            Integer FC = 0; //分差
            String XQ = BB.getInttime()+"";
            if(ZF!=null&&KF!=null){
                IS = true;
                if(ZF>KF){
                    BB.setSF("主胜");
                }else if(ZF<KF){
                    BB.setSF("客胜");
                    ZS = false;
                }
            }
            if(ZF!=null&&KF!=null&&DXF!=null){
                if(ZF+KF>DXF){
                    BB.setDXF("大分");
                }else{
                    BB.setDXF("小分");
                }
                if(ZF+RF>KF){
                    BB.setRFSF("让分主胜");
                }else{
                    BB.setRFSF("让分客胜");
                }
            }
            if(IS){
                if(ZS){
                    FC = ZF-KF;
                    if(FC>=1&&FC<=5){
                        BB.setSFC("主胜1-5");
                    }else if(FC>=6&&FC<=10){
                        BB.setSFC("主胜6-10");
                    }else if(FC>=11&&FC<=15){
                        BB.setSFC("主胜11-15");
                    }else if(FC>=16&&FC<=20){
                        BB.setSFC("主胜16-20");
                    }else if(FC>=21&&FC<=25){
                        BB.setSFC("主胜21-25");
                    }else if(FC>=26){
                        BB.setSFC("主胜26+");
                    }
                }else{
                    FC = KF-ZF;
                    if(FC>=1&&FC<=5){
                        BB.setSFC("客胜1-5");
                    }else if(FC>=6&&FC<=10){
                        BB.setSFC("客胜6-10");
                    }else if(FC>=11&&FC<=15){
                        BB.setSFC("客胜11-15");
                    }else if(FC>=16&&FC<=20){
                        BB.setSFC("客胜16-20");
                    }else if(FC>=21&&FC<=25){
                        BB.setSFC("客胜21-25");
                    }else if(FC>=26){
                        BB.setSFC("客胜26+");
                    }
                }
            }

            Date date1 = DateUtil.StringToDate(XQ);
            int weekOfDate = DateUtil.getWeekOfDate(date1);
            switch (weekOfDate){
                case 1:
                    BB.setXQ("周一");
                    break;
                case 2:
                    BB.setXQ("周二");
                    break;
                case 3:
                    BB.setXQ("周三");
                    break;
                case 4:
                    BB.setXQ("周四");
                    break;
                case 5:
                    BB.setXQ("周五");
                    break;
                case 6:
                    BB.setXQ("周六");
                    break;
                case 7:
                    BB.setXQ("周日");
                    break;
            }
            SportteryFootballMatch FB = lotteryTerm2Mapper.getOneFootBall();
            String mark2 = "";
            String hmark2 = "";
            String XQ2 ="";
            Integer ZF2 = FB.getHomescore(); //主队分数
            Integer KF2 = FB.getGuestscore(); //客队分数
            Integer hZF2 = FB.getHalfhomescore(); //半场主队分数
            Integer hKF2 = FB.getHalfguestscore(); //半场客队分数
            Integer RQ2 = FB.getConcede(); //让球数
            mark2 = "";
            hmark2 = "";
            XQ2 = FB.getInttime()+"";
            if(ZF2!=null&&KF2!=null){
                if(ZF2>KF2){
                    FB.setSPF("主胜");
                    mark2="胜";
                    if(ZF2>=5||KF2>=3) {
                        FB.setBF("胜其他");
                    }else
                        FB.setBF(ZF2+":"+KF2);
                }else if(ZF2==KF2){
                    FB.setSPF("平");
                    mark2="平";
                    if(ZF2>=3) {
                        FB.setBF("平其他");
                    }else
                        FB.setBF(ZF2+":"+KF2);
                }else if(ZF2<KF2){
                    FB.setSPF("客胜");
                    mark2="负";
                    if(KF2>=5||ZF2>=3) {
                        FB.setBF("负其他");
                    } else
                        FB.setBF(ZF2+":"+KF2);
                }
            }

            if(ZF2!=null&&RQ2!=null&&KF2!=null){
                if(ZF2+RQ2>KF2){
                    FB.setRQSPF("主胜");
                }else if(ZF2+RQ2==KF2){
                    FB.setRQSPF("平");
                }else if(ZF2+RQ2<KF2){
                    FB.setRQSPF("客胜");
                }
                FB.setZJQ(ZF2+KF2+"球");
            }
            if(hZF2!=null&&hKF2!=null){
                if(hZF2>hKF2){
                    hmark2="胜";
                }else if(hZF2==hKF2){
                    hmark2="平";
                }else if(hZF2<hKF2){
                    hmark2="负";
                }
                FB.setBQC(mark2+"-"+hmark2);
            }
            if(XQ2!=null){
                Date date2 = DateUtil.StringToDate(XQ2);
                int weekOfDate2 = DateUtil.getWeekOfDate(date2);
                switch (weekOfDate2){
                    case 1:
                        FB.setXQ("周一");
                        break;
                    case 2:
                        FB.setXQ("周二");
                        break;
                    case 3:
                        FB.setXQ("周三");
                        break;
                    case 4:
                        FB.setXQ("周四");
                        break;
                    case 5:
                        FB.setXQ("周五");
                        break;
                    case 6:
                        FB.setXQ("周六");
                        break;
                    case 7:
                        FB.setXQ("周日");
                        break;
                    default:
                        FB.setXQ("未知");
                }
            }

            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put("BasketBall", BB);
            map.put("FootBallBall", FB);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE, Constants.ERROR_CODE_608);
            map.put(Constants.MSG, Constants.ERROR_MSG_608);
            return map;
        }
    }

    /**
     * 获取最新的10个彩期
     * @param type
     * @return
     */
    public Map<String, Object> getTen(int type){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            int date = DateUtil.getIntTime();
            if(type==1){
                List<Integer> LQS = lotteryTerm2Mapper.getTenLQ(date);
                map.put(Constants.DATA, LQS);
            }else if(type==2){
                List<Integer> ZQS = lotteryTerm2Mapper.getTenZQ(date);
                map.put(Constants.DATA, ZQS);
            }
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取彩期出错");
            return map;
        }
    }
}
