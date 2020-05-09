package com.qiyun.util;

/**
 * 编码转换工具类
 */
public class Ascii2NativeUtil {
    /**
     * prefix of ascii string of native character
     */
    private static String PREFIX = "\\u";

    /**
     * Native to ascii string. It's same as execut native2ascii.exe.
     * @param str native string
     * @return ascii string
     */
    public static String native2Ascii(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(char2Ascii(chars[i]));
        }
        return sb.toString();
    }

    /**
     * Native character to ascii string.
     * @param c native character
     * @return ascii string
     */
    private static String char2Ascii(char c) {
        if (c > 255) {
            StringBuilder sb = new StringBuilder();
            sb.append(PREFIX);
            int code = (c >> 8);
            String tmp = Integer.toHexString(code);
            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);
            code = (c & 0xFF);
            tmp = Integer.toHexString(code);
            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);
            return sb.toString();
        } else {
            return Character.toString(c);
        }
    }

    /**
     * Ascii to native string. It's same as execut native2ascii.exe -reverse.
     * @param str ascii string
     * @return native string
     */
    public static String ascii2Native(String str) {
        StringBuilder sb = new StringBuilder();
        int begin = 0;
        int index = str.indexOf(PREFIX);
        while (index != -1) {
            sb.append(str.substring(begin, index));
            sb.append(ascii2Char(str.substring(index, index + 6)));
            begin = index + 6;
            index = str.indexOf(PREFIX, begin);
        }
        sb.append(str.substring(begin));
        return sb.toString();
    }

    /**
     * Ascii to native character.
     * @param str ascii string
     * @return native character
     */
    private static char ascii2Char(String str) {
        if (str.length() != 6) {
            throw new IllegalArgumentException(
                    "Ascii string of a native character must be 6 character.");
        }
        if (!PREFIX.equals(str.substring(0, 2))) {
            throw new IllegalArgumentException(
                    "Ascii string of a native character must start with \"\\u\".");
        }
        String tmp = str.substring(2, 4);
        int code = Integer.parseInt(tmp, 16) << 8;
        tmp = str.substring(4, 6);
        code += Integer.parseInt(tmp, 16);
        return (char) code;
    }

//    public static void main(String[] args) {
//        String s = "cphData({\"data\":[{\"data\":\"1-\\u5df4\\u897f-\\u5f00\\u552e-2.95-0%-19.27%-4671301-equal-467130-1-417-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/417.png|2-\\u5fb7\\u56fd-\\u5f00\\u552e-3.50-0%-16.24%-4671302-equal-467130-2-377-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/377.png|3-\\u897f\\u73ed\\u7259-\\u5f00\\u552e-4.10-0%-13.86%-4671303-equal-467130-3-23-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/23.png|4-\\u963f\\u6839\\u5ef7-\\u5f00\\u552e-4.50-0%-12.63%-4671304-equal-467130-4-413-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/413.png|5-\\u6cd5\\u56fd-\\u5f00\\u552e-5.00-0%-11.37%-4671305-equal-467130-5-375-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/375.png|6-\\u6bd4\\u5229\\u65f6-\\u5f00\\u552e-10.00-0%-5.68%-4671306-equal-467130-6-363-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/363.png|7-\\u8461\\u8404\\u7259-\\u5f00\\u552e-15.00-0%-3.79%-4671307-equal-467130-7-1044-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/1044.png|8-\\u82f1\\u683c\\u5170-\\u5f00\\u552e-14.00-0%-4.06%-4671308-equal-467130-8-370-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/370.png|9-\\u4e4c\\u62c9\\u572d-\\u5f00\\u552e-22.00-0%-2.58%-4671309-equal-467130-9-414-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/414.png|10-\\u54e5\\u4f26\\u6bd4\\u4e9a-\\u5f00\\u552e-25.00-0%-2.27%-46713010-equal-467130-10-410-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/410.png|11-\\u514b\\u7f57\\u5730\\u4e9a-\\u5f00\\u552e-35.00-0%-1.62%-46713011-equal-467130-11-366-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/366.png|12-\\u4fc4\\u7f57\\u65af-\\u5f00\\u552e-55.00-0%-1.03%-46713012-equal-467130-12-396-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/396.png|13-\\u58a8\\u897f\\u54e5-\\u5f00\\u552e-70.00-0%-0.81%-46713013-equal-467130-13-416-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/416.png|14-\\u6ce2\\u5170-\\u5f00\\u552e-65.00-0%-0.87%-46713014-equal-467130-14-392-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/392.png|15-\\u745e\\u58eb-\\u5f00\\u552e-110.0-0%-0.52%-46713015-equal-467130-15-403-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/403.png|16-\\u4e39\\u9ea6-\\u5f00\\u552e-100.0-0%-0.57%-46713016-equal-467130-16-369-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/369.png|17-\\u585e\\u5c14\\u7ef4\\u4e9a-\\u5f00\\u552e-175.0-0%-0.32%-46713017-equal-467130-17-399-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/399.png|18-\\u745e\\u5178-\\u5f00\\u552e-200.0-0%-0.28%-46713018-equal-467130-18-402-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/402.png|19-\\u79d8\\u9c81-\\u5f00\\u552e-200.0-0%-0.28%-46713019-equal-467130-19-409-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/409.png|20-\\u65e5\\u672c-\\u5f00\\u552e-250.0-0%-0.23%-46713020-equal-467130-20-438-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/438.png|21-\\u5c3c\\u65e5\\u5229\\u4e9a-\\u5f00\\u552e-250.0-0%-0.23%-46713021-equal-467130-21-773-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/773.png|22-\\u585e\\u5185\\u52a0\\u5c14-\\u5f00\\u552e-200.0-0%-0.28%-46713022-equal-467130-22-774-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/774.png|23-\\u57c3\\u53ca-\\u5f00\\u552e-250.0-0%-0.23%-46713023-equal-467130-23-543-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/543.png|24-\\u51b0\\u5c9b-\\u5f00\\u552e-250.0-0%-0.23%-46713024-equal-467130-24-380-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/380.png|25-\\u7a81\\u5c3c\\u65af-\\u5f00\\u552e-700.0-0%-0.08%-46713025-equal-467130-25-425-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/425.png|26-\\u6fb3\\u5927\\u5229\\u4e9a-\\u5f00\\u552e-600.0-0%-0.09%-46713026-equal-467130-26-421-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/421.png|27-\\u6469\\u6d1b\\u54e5-\\u5f00\\u552e-500.0-0%-0.11%-46713027-equal-467130-27-424-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/424.png|28-\\u97e9\\u56fd-\\u5f00\\u552e-600.0-0%-0.09%-46713028-equal-467130-28-430-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/430.png|29-\\u4f0a\\u6717-\\u5f00\\u552e-600.0-0%-0.09%-46713029-equal-467130-29-440-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/440.png|30-\\u54e5\\u65af\\u8fbe\\u9ece\\u52a0-\\u5f00\\u552e-500.0-0%-0.11%-46713030-equal-467130-30-420-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/420.png|31-\\u5df4\\u62ff\\u9a6c-\\u5f00\\u552e-800.0-0%-0.07%-46713031-equal-467130-31-524-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/524.png|32-\\u6c99\\u7279-\\u5f00\\u552e-1000-0%-0.06%-46713032-equal-467130-32-434-http:\\/\\/static.sporttery.cn\\/sinaimg\\/football\\/wcp2018\\/434.png\",\"id\":\"104895\",\"p_id\":\"467130\",\"name\":\"2018\\u4e16\\u754c\\u676f\",\"odds_type\":\"CHP\"}]})";
//        System.out.println(Ascii2NativeUtil.ascii2Native(s));
//    }
}
