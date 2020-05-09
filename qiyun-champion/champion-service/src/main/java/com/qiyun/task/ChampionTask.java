package com.qiyun.task;

import com.qiyun.httpUtil.HttpUtil;
import com.qiyun.model2.ChampionMatch;
import com.qiyun.model2.ChampionMatchUp;
import com.qiyun.service.ChampionMatchService;
import com.qiyun.service.ChampionMatchUpService;
import com.qiyun.util.Ascii2NativeUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Lazy(value=false)
public class ChampionTask {
    @Autowired
    private ChampionMatchService championMatchService;
    @Autowired
    private ChampionMatchUpService championMatchUpService;

    @Scheduled(cron = "0 */3 * * * ?")//每隔三分钟处理一次
    public void getChampionMatch() throws Exception {
        String s = HttpUtil.sendGet("http://i.sporttery.cn/rank_calculator/get_list",
                "tid[]=104895&pcode[]=chp&i_callback=cphData");
        s = Ascii2NativeUtil.ascii2Native(s);
        List<String> list = getList(s);
        for(String s1 : list){
            boolean isChange = false;
            String[] strings = s1.split("-");
            int id = Integer.parseInt(strings[0]);
            ChampionMatch championMatch = championMatchService.getById(id);
            if(championMatch == null) {
                championMatch = ChampionMatch.builder().id(id).teamName(strings[1])
                        .sellStatus(strings[2]).nationalFlag(strings[11]).sp(new BigDecimal(strings[3]))
                        .teamId(Integer.parseInt(strings[6])).supportRate(strings[5]).build();
                championMatchService.insertSelective(championMatch);
            }
            if(championMatch.getSp().compareTo(new BigDecimal(strings[3])) != 0){
                championMatch.setSp(new BigDecimal(strings[3]));
                isChange = true;
            }
            if(!championMatch.getSellStatus().equals(strings[2])){
                championMatch.setSellStatus(strings[2]);
                isChange = true;
            }
            if(!championMatch.getSupportRate().equals(strings[5])){
                championMatch.setSupportRate(strings[5]);
                isChange = true;
            }
            if(isChange) {
                championMatchService.update(championMatch);
            }
        }
    }

    @Scheduled(cron = "0 */3 * * * ?")//每隔三分钟处理一次
    public void getChampionUpMatch() throws Exception {
        String s = HttpUtil.sendGet("http://i.sporttery.cn/rank_calculator/get_list",
                "tid[]=104895&&pcode[]=fnl&i_callback=getList");
        s = Ascii2NativeUtil.ascii2Native(s);
        List<String> list = getList(s);
        for(String s1 : list){
            boolean isChange = false;
            String[] strings = s1.split("-");
            int id = Integer.parseInt(strings[0]);
            ChampionMatchUp championMatch = championMatchUpService.getById(id);
            if(championMatch == null) {
                championMatch = ChampionMatchUp.builder().id(id).teamName(strings[1])
                        .sellStatus(strings[2]).nationalFlag(strings[11]).sp(new BigDecimal(strings[3]))
                        .teamId(Integer.parseInt(strings[6])).supportRate(strings[5]).build();
                championMatchUpService.insertSelective(championMatch);
            }
            if(championMatch.getSp().compareTo(new BigDecimal(strings[3])) != 0){
                championMatch.setSp(new BigDecimal(strings[3]));
                isChange = true;
            }
            if(!championMatch.getSellStatus().equals(strings[2])){
                championMatch.setSellStatus(strings[2]);
                isChange = true;
            }
            if(!championMatch.getSupportRate().equals(strings[5])){
                championMatch.setSupportRate(strings[5]);
                isChange = true;
            }
            if(isChange) {
                championMatchUpService.update(championMatch);
            }
        }
    }

    /**
     * 处理抓取数据
     * 获取返回参数列表
     * @param s
     * @return
     */
    private List<String> getList(String s) {
        List<String> list = new ArrayList<String>();
        int i = s.indexOf("(");
        int j = s.indexOf(")");
        s = s.substring(i + 1, j);
        JSONObject obj = JSONObject.fromObject(s);
        JSONArray data = obj.optJSONArray("data");
        String d = "";
        for(Object o : data){
            JSONObject jo = (JSONObject) o;
            d = jo.optString("data");
            System.out.println(d);
            int n = d.indexOf("|");
            System.out.println(n);
            String[] str = d.split("\\|");
            list = Arrays.asList(str);
        }
        return list;
    }
}
