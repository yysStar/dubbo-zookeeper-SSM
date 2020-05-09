package com.qiyun.model;

public class FootBallIsShow {
    private static boolean selectStatus[] = new boolean[10];

    public static boolean[] getSelectStatus(int showNum) {
        MatchShowStatusFb status[] = MatchShowStatusFb.values();
        for (int i = 0; i < status.length; i++) {
            // 把1向左移动N位
            int value = 1 << status[i].getValue();
            // 按位与运算(运算结果要么是0要么是1,1代表已存在)
            if ((showNum & value) > 0) {
                selectStatus[i] = true;
            } else {
                selectStatus[i] = false;
            }
        }
        return selectStatus;
    }

    /**
     * 玩法是否在售
     *
     * @param fb
     * @return true 开售/false停售
     */
    public static boolean getStatusIsSale(MatchShowStatusFb fb,int showNum) {
        MatchShowStatusFb status[] = MatchShowStatusFb.values();
        boolean[] selectStatus = getSelectStatus(showNum);
        boolean flag = false;
        for (int i = 0; i < status.length; i++) {
            if (status[i] == fb) {
                flag = selectStatus[i];
                break;
            }
        }
        return flag;
    }

}
