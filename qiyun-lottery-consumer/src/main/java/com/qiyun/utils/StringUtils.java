package com.qiyun.utils;

public class StringUtils {
    private static final String s1 = "麒云";
    private static final String s2 = "奇云";
    private static final String s3 = "qiyun";

    // 判断字符串是否空或null
    public static boolean isNullOrBlank(String s) {
        if (s == null || s.trim().length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 验证手机号码
     *
     * 移动号码段:139、138、137、136、135、134、150、151、152、157、158、159、182、183、187、188、147
     * 联通号码段:130、131、132、136、185、186、145
     * 电信号码段:133、153、180、189
     *
     * @param cellphone
     * @return
     */
    public static boolean checkCellphone(String cellphone) {
        String regex = "^1\\d{10}$";
        return cellphone.matches(regex);
    }

    /** 计算字符串的长度，中文算二个
     * @param value=计算字符
     * @return 字符串的长度
     */
    public static int length(String value) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        for (int i = 0; i < value.length(); i++) {
            /* 获取一个字符 */
            String temp = value.substring(i, i + 1);
            /* 判断是否为中文字符 */
            if (temp.matches(chinese)) {
                /* 中文字符长度为2 */
                valueLength += 2;
            } else {
                /* 其他字符长度为1 */
                valueLength += 1;
            }
        }
        return valueLength;
    }

    /**
     * <p>判断字符串是否包含特殊字符</p>
     * @param str String
     * @return boolean
     */
    public static boolean isConSpeCharacters(String str) {
        String tempStr = str.replaceAll("[\u4e00-\u9fa5]*[a-z]*[A-Z]*\\d*-*_*", "");

        if(str.indexOf(s1) == -1 || str.indexOf(s2) == -1 || str.indexOf(s3) == -1){
            return false;
        }

        if (tempStr.length() == 0) {
            return false;
        }

        return true;
    }
}
