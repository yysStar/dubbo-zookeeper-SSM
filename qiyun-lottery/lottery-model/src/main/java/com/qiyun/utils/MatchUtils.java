package com.qiyun.utils;

import com.qiyun.model.basketball.SFAward;
import com.qiyun.model.basketball.SFCAward;
import com.qiyun.model.football.*;

public class MatchUtils {

    /**
     * 判断SP所属类型
     *
     * @param aClass
     * @return
     */
    public static int getForClass(Class aClass) {
        if(aClass == SFAward.class){
            return 1; //篮球胜负
        } else if(aClass == SFCAward.class){
            return 2; //篮球胜分差
        } else if(aClass == MatchAwardOfBF.class){
            return 3; //足球比分
        } else if(aClass == MatchAwardOfBQC.class){
            return 4; //足球半全场
        } else if(aClass == MatchAwardOfJQS.class){
            return 5; //足球进球数
        } else if(aClass == MatchAwardOfRQSPF.class){
            return 6; //足球让球胜平负
        } else if(aClass == MatchAwardOfSPF.class){
            return 7; //足球胜平负
        } else{
            return 0;
        }
    }
}
