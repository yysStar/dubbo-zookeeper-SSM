package com.qiyun.xingYiFuUtils;

import java.util.Map;

public class Map2FormUtil {

	/**
     * hashMap 转化成表单字符串
     * @param map
     * @return
     */
    public static String map2Form(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if(map == null) {
            return stringBuilder.toString();
        } else {
            for (Map.Entry<String, String> entry:
                map.entrySet() ) {
                stringBuilder.append(entry.getKey())
                        .append("=")
                        .append(entry.getValue())
                        .append("&");
            }
            return stringBuilder.substring(0, stringBuilder.length() - 1);
        }
    }
}
