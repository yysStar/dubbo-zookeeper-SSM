package com.qiyun.utils;

import java.util.Map;

public class ContentUtils {


    public static String getFootBallAward(String play, Map spf,Map rqspf,Map bqc,Map bf,Map jqs,String option){
        if ("胜平负".equals(play)){
            if ("胜".equals(option)){
                return spf.get("homeWinAward").toString();
            }else if ("平".equals(option)){
                return spf.get("drawAward").toString();
            }else if ("负".equals(option)){
                return spf.get("guestWinAward").toString();
            }
        }else if ("让球胜平负".equals(play)){
            if ("胜".equals(option)){
                return rqspf.get("homeWinAward").toString();
            }else if ("平".equals(option)){
                return rqspf.get("drawAward").toString();
            }else if ("负".equals(option)){
                return rqspf.get("guestWinAward").toString();
            }
        }else if ("半全场".equals(play)){
            if ("胜胜".equals(option)){
                return bqc.get("win_win_award").toString();
            }else if ("胜平".equals(option)){
                return bqc.get("win_draw_award").toString();
            }else if ("胜负".equals(option)){
                return bqc.get("win_lose_award").toString();
            }else if ("平胜".equals(option)){
                return bqc.get("draw_win_award").toString();
            }else if ("平平".equals(option)){
                return bqc.get("draw_draw_award").toString();
            }else if ("平负".equals(option)){
                return bqc.get("draw_lose_award").toString();
            }else if ("负胜".equals(option)){
                return bqc.get("lose_win_award").toString();
            }else if ("负平".equals(option)){
                return bqc.get("lose_draw_award").toString();
            }else if ("负负".equals(option)){
                return bqc.get("lose_lose_award").toString();
            }
        }else if ("比分".equals(play)){
            if ("1:0".equals(option)){
                return bf.get("s10award").toString();
            }else if ("2:0".equals(option)){
                return bf.get("s20award").toString();
            }else if ("2:1".equals(option)){
                return bf.get("s21award").toString();
            }else if ("3:0".equals(option)){
                return bf.get("s30award").toString();
            }else if ("3:1".equals(option)){
                return bf.get("s31award").toString();
            }else if ("3:2".equals(option)){
                return bf.get("s32award").toString();
            }else if ("4:0".equals(option)){
                return bf.get("s40award").toString();
            }else if ("4:1".equals(option)){
                return bf.get("s41award").toString();
            }else if ("4:2".equals(option)){
                return bf.get("s42award").toString();
            }else if ("5:0".equals(option)){
                return bf.get("s50award").toString();
            }else if ("5:1".equals(option)){
                return bf.get("s51award").toString();
            }else if ("5:2".equals(option)){
                return bf.get("s52award").toString();
            }else if ("胜其它".equals(option)){
                return bf.get("s_win_award").toString();
            }else if ("0:0".equals(option)){
                return bf.get("s00award").toString();
            }else if ("1:1".equals(option)){
                return bf.get("s11award").toString();
            }else if ("2:2".equals(option)){
                return bf.get("s22award").toString();
            }else if ("3:3".equals(option)){
                return bf.get("s33award").toString();
            }else if ("平其它".equals(option)){
                return bf.get("s_draw_award").toString();
            }else if ("0:1".equals(option)){
                return bf.get("s01award").toString();
            }else if ("0:2".equals(option)){
                return bf.get("s02award").toString();
            }else if ("1:2".equals(option)){
                return bf.get("s12award").toString();
            }else if ("0:3".equals(option)){
                return bf.get("s03award").toString();
            }else if ("1:3".equals(option)){
                return bf.get("s13award").toString();
            }else if ("2:3".equals(option)){
                return bf.get("s23award").toString();
            }else if ("0:4".equals(option)){
                return bf.get("s04award").toString();
            }else if ("1:4".equals(option)){
                return bf.get("s14award").toString();
            }else if ("2:4".equals(option)){
                return bf.get("s24award").toString();
            }else if ("0:5".equals(option)){
                return bf.get("s05award").toString();
            }else if ("1:5".equals(option)){
                return bf.get("s15award").toString();
            }else if ("2:5".equals(option)){
                return bf.get("s25award").toString();
            }else if ("负其它".equals(option)){
                return bf.get("s_lose_award").toString();
            }
        }else if ("进球数".equals(play)){
            if ("0".equals(option)){
                return jqs.get("s0_award").toString();
            }else if ("1".equals(option)){
                return jqs.get("s1_award").toString();
            }else if ("2".equals(option)){
                return jqs.get("s2_award").toString();
            }else if ("3".equals(option)){
                return jqs.get("s3_award").toString();
            }else if ("4".equals(option)){
                return jqs.get("s4_award").toString();
            }else if ("5".equals(option)){
                return jqs.get("s5_award").toString();
            }else if ("6".equals(option)){
                return jqs.get("s6_award").toString();
            }else if ("7+".equals(option)){
                return jqs.get("s7_award").toString();
            }
        }
        return null;
    }

    public static String getBasketAward(String play, Map sfc,Map dxf,Map rf,Map sf){
        if ("主胜".equals(play)){
           return sf.get("awardOfWinOrBig").toString();
        }else if ("客胜".equals(play)){
            return sf.get("awardOfLoseOrSmall").toString();
        }else if ("让分主胜".equals(play)){
            return rf.get("awardOfWinOrBig").toString();
        }else if ("让分客胜".equals(play)){
            return rf.get("awardOfLoseOrSmall").toString();
        }else if ("大".equals(play)){
            return dxf.get("awardOfWinOrBig").toString();
        }else if ("小".equals(play)){
            return dxf.get("awardOfLoseOrSmall").toString();
        }else if ("主胜1-5".equals(play)){
            return sfc.get("HWawardOf1to5").toString();
        }else if ("主胜6-10".equals(play)){
            return sfc.get("HWawardOf6TO10").toString();
        }else if ("主胜11-15".equals(play)){
            return sfc.get("HWawardOf11TO15").toString();
        }else if ("主胜16-20".equals(play)){
            return sfc.get("HWawardOf16TO20").toString();
        }else if ("主胜21-25".equals(play)){
            return sfc.get("HWawardOf21TO25").toString();
        }else if ("主胜26+".equals(play)){
            return sfc.get("HWawardOf26").toString();
        }else if ("客胜1-5".equals(play)){
            return sfc.get("GWawardOf1to5").toString();
        }else if ("客胜6-10".equals(play)){
            return sfc.get("GWawardOf6TO10").toString();
        }else if ("客胜11-15".equals(play)){
            return sfc.get("GWawardOf11TO15").toString();
        }else if ("客胜16-20".equals(play)){
            return sfc.get("GWawardOf16TO20").toString();
        }else if ("客胜21-25".equals(play)){
            return sfc.get("GWawardOf21TO25").toString();
        }else if ("客胜26+".equals(play)){
            return sfc.get("GWawardOf26").toString();
        }
        return null;
    }


    public static String getPlay(String type1) {
        if (type1.equals("41")){
            return "胜平负";
        }else if (type1.equals("34")){
            return "让球胜平负";
        }else if (type1.equals("35")){
            return "比分";
        }else if (type1.equals("36")){
            return "进球数";
        }else if (type1.equals("37")){
            return "半全场";
        }
        return null;
    }
}
