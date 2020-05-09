package com.qiyun.util;

import java.util.Random;

public class StringUtils {
    private static Random randGenNumber = null;
    private static Object initLockNumber = new Object();
    private static char[] numbersAndLettersNumber = null;

    /**
     *  判断字符串是否空或null
     */
    public static boolean isNullOrBlank(String s) {
        if (s == null || s.trim().length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 随机生成用户名
     * @param length
     * @return
     */
    public static final String randomNumberString(int length) {

        if (length < 1) {
            return null;
        }
        if (randGenNumber == null) {
            synchronized (initLockNumber) {
                if (randGenNumber == null) {
                    randGenNumber = new Random();
                    numbersAndLettersNumber = ("0123456789").toCharArray();
                }
            }
        }
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numbersAndLettersNumber[randGenNumber.nextInt(10)];
        }
        return new String(randBuffer);
    }

}
