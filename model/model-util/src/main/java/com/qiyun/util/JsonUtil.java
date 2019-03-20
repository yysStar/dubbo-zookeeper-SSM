package com.qiyun.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonUtil {

    /**
     * 处理抓取数据
     * 获取返回参数列表
     * @param s
     * @return
     */
    public static List<String> getList(String s) {
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

    public static JSONObject getDate(String s) {
        List<String> list = new ArrayList<String>();
        int i = s.indexOf("(");
        int j = s.indexOf(")");
        s = s.substring(i + 1, j);
        JSONObject obj = JSONObject.fromObject(s);
        JSONObject data = obj.optJSONObject("data");
//        JSONObject status = obj.optJSONObject("status");
        return data;
    }
}
