package com.qiyun.DTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PlayType extends IntegerBeanLabelItem {

    protected PlayType(String name, int value) {
        super(PlayType.class.getName(), name, value);
    }

    public static PlayType getItem(int value) {
        return (PlayType) PlayType.getResult(PlayType.class.getName(), value);
    }

    public static final PlayType ALL = new PlayType("全部", -1);
    public static final PlayType HT = new PlayType("混投", 0);
    public static final PlayType DS = new PlayType("单式", 1);
    public static final PlayType FS = new PlayType("标准", 2);
    public static final PlayType DT = new PlayType("胆拖", 3);

    // start cqssc
    public static final PlayType WXDS = new PlayType("五星单式", 4);
    public static final PlayType WXFS = new PlayType("五星直选", 5);

    public static final PlayType SXDS = new PlayType("三星单式", 6);
    public static final PlayType SXFS = new PlayType("三星直选", 7);

    public static final PlayType LXDS = new PlayType("两星单式", 8);
    public static final PlayType LXFS = new PlayType("两星直选", 9);

    public static final PlayType YXDS = new PlayType("一星单式", 10);
    public static final PlayType YXFS = new PlayType("一星复式", 11);

    public static final PlayType Z3DS = new PlayType("组三单式", 12);
    public static final PlayType Z3BH = new PlayType("组三包号", 13);
    public static final PlayType Z3HZ = new PlayType("组三和值", 14);
    public static final PlayType Z6DS = new PlayType("组六单式", 15);
    public static final PlayType Z6BH = new PlayType("组六包号", 16);
    public static final PlayType Z6HZ = new PlayType("组六和值", 17);
    public static final PlayType Z6DT = new PlayType("组六胆拖", 18);

    public static final PlayType EXHZ = new PlayType("二星和值", 19);
    public static final PlayType EXBHDS = new PlayType("二星包号单式", 20);
    public static final PlayType EXBHFS = new PlayType("二星包号复式", 21);
    public static final PlayType SXZHUXHZ = new PlayType("三星组选和值", 22);

    public static final PlayType WXTXDS = new PlayType("五星通选单式", 23);
    public static final PlayType WXTXFS = new PlayType("五星通选复式", 24);
    public static final PlayType DSDXDS = new PlayType("大小单双单式", 25);
    public static final PlayType DSDXFS = new PlayType("大小单双复式", 26);
    public static final PlayType EXBHHZ = new PlayType("二星组选和值", 27);

    public static final PlayType EXZHDT = new PlayType("二星组选胆拖", 15028);
    public static final PlayType SXZ6DT = new PlayType("三星组六胆拖", 15029);

    public static final PlayType SXZUX = new PlayType("三星组选", 15030);
    public static final PlayType LXZUX = new PlayType("二星组选", 15031);

    public static final PlayType SXZHIXHZ = new PlayType("三星直选和值", 15037);
    public static final PlayType SXZHIXDT = new PlayType("三星直选胆拖", 15038);
    public static final PlayType SXZHIXKD = new PlayType("三星直选跨度", 15039);
    // */ //end cqssc

    // 江西时时彩
    public static final PlayType JXSSC_WXDS = new PlayType("五星单式", 15350);
    public static final PlayType JXSSC_WXFS = new PlayType("五星直选", 15351);
    public static final PlayType JXSSC_WXFX = new PlayType("五星复选", 15352);
    public static final PlayType JXSSC_WXTXDS = new PlayType("五星通选单式", 15353);
    public static final PlayType JXSSC_WXTXFS = new PlayType("五星通选复式", 15354);

    public static final PlayType JXSSC_SIXDS = new PlayType("四星单式", 15340);
    public static final PlayType JXSSC_SIXFS = new PlayType("四星直选", 15341);
    public static final PlayType JXSSC_SIXFX = new PlayType("四星复选", 15342);

    public static final PlayType JXSSC_SXDS = new PlayType("三星单式", 15380);
    public static final PlayType JXSSC_SXFS = new PlayType("三星直选", 15331);
    public static final PlayType JXSSC_SXFX = new PlayType("三星复选", 15332);
    public static final PlayType JXSSC_Z3DS = new PlayType("三星组三单式", 15333);
    public static final PlayType JXSSC_Z3BH = new PlayType("三星组三包号", 15334);
    public static final PlayType JXSSC_Z6DS = new PlayType("三星组六单式", 15335);
    public static final PlayType JXSSC_Z6BH = new PlayType("三星组六包号", 15336);

    public static final PlayType JXSSC_LXDS = new PlayType("两星单式", 15320);
    public static final PlayType JXSSC_LXFS = new PlayType("两星直选", 15321);
    public static final PlayType JXSSC_LXFX = new PlayType("两星复选", 15322);
    public static final PlayType JXSSC_EXBHDS = new PlayType("二星包号单式", 15323);
    public static final PlayType JXSSC_EXBHFS = new PlayType("二星包号复式", 15324);
    public static final PlayType JXSSC_EXBHHZ = new PlayType("二星组选和值", 15325);

    public static final PlayType JXSSC_YXDS = new PlayType("一星单式", 15310);
    public static final PlayType JXSSC_YXFS = new PlayType("一星复式", 15311);

    public static final PlayType JXSSC_DSDXDS = new PlayType("大小单双单式", 15361);
    public static final PlayType JXSSC_DSDXFS = new PlayType("大小单双复式", 15362);

    public static final PlayType JXSSC_R1_BZ = new PlayType("任选一", 15371);
    public static final PlayType JXSSC_R2_BZ = new PlayType("任选二", 15372);

    public static final PlayType JXSSC_EXZHDT = new PlayType("二星组选胆拖", 15328);
    public static final PlayType JXSSC_SXZ6DT = new PlayType("三星组六胆拖", 15329);

    public static final PlayType JXSSC_SXZUX = new PlayType("三星组选", 15330);

    public static final PlayType JXSSC_SXZHIXHZ = new PlayType("三星直选和值", 15337);
    public static final PlayType JXSSC_SXZHIXDT = new PlayType("三星直选胆拖", 15338);
    public static final PlayType JXSSC_SXZHIXKD = new PlayType("三星直选跨度", 15339);

    public static final PlayType JXSSC_EXZUX = new PlayType("二星组选", 15326);
    // */end jxssc

    public static final PlayType ZX = new PlayType("直选", 28);
    public static final PlayType ZS = new PlayType("组三包号", 29);
    public static final PlayType ZSBZ = new PlayType("组三标准", 29001);
    public static final PlayType ZL = new PlayType("组六包号", 30);
    public static final PlayType ZXHZ = new PlayType("直选和值", 31);
    public static final PlayType ZSHZ = new PlayType("组三和值", 32);
    public static final PlayType ZLHZ = new PlayType("组六和值", 33);
    public static final PlayType QY = new PlayType("前一", 34);
    public static final PlayType HY = new PlayType("后一", 35);
    public static final PlayType QE = new PlayType("前二", 36);
    public static final PlayType HE = new PlayType("后二", 37);
    public static final PlayType ZLDT = new PlayType("组六胆拖", 38);
    public static final PlayType ZXDT = new PlayType("直选胆拖", 29002);
    public static final PlayType ZXKD = new PlayType("直选跨度", 29003);
    public static final PlayType ZXBH = new PlayType("直选包号", 29004);
    public static final PlayType ZLBZ = new PlayType("组六标准", 29005);
    public static final PlayType D1 = new PlayType("1D", 29008);
    public static final PlayType D2 = new PlayType("2D", 29009);
    public static final PlayType C1D = new PlayType("猜1D", 29010);
    public static final PlayType C2D = new PlayType("猜2D", 29011);
    public static final PlayType TX = new PlayType("通选", 29012);
    public static final PlayType HS = new PlayType("和数", 29013);
    public static final PlayType BX3 = new PlayType("包选三", 29014);
    public static final PlayType BX6 = new PlayType("包选六", 29015);
    public static final PlayType DX = new PlayType("大小", 29016);
    public static final PlayType JO = new PlayType("奇偶", 29017);
    public static final PlayType C3T = new PlayType("猜三同", 29018);
    public static final PlayType TLJ = new PlayType("拖拉机", 29019);

    public static final PlayType ZHIXUANDS = new PlayType("直选单式上传", 29006);
    public static final PlayType ZUXUANDS = new PlayType("组选单式上传", 29007);

    // 票才有
    public static final PlayType ZXFS = new PlayType("直选复式", 39);
    public static final PlayType ZHUXUAN = new PlayType("组选", 40);
    public static final PlayType QYFS = new PlayType("前一复式", 41);
    public static final PlayType HYFS = new PlayType("后一复式", 42);
    public static final PlayType QEFS = new PlayType("前二复式", 43);
    public static final PlayType HEFS = new PlayType("后二复式", 44);

    public static final PlayType SXL_DS = new PlayType("生肖乐单式", 45);
    public static final PlayType SXL_FS = new PlayType("生肖乐复式", 46);

    public static final PlayType ZYGG = new PlayType("自由过关", 100);
    public static final PlayType DC_1 = new PlayType("单关", 101);
    public static final PlayType DC_2_1 = new PlayType("2串1", 102);
    public static final PlayType DC_3_1 = new PlayType("3串1", 103);
    public static final PlayType DC_4_1 = new PlayType("4串1", 104);
    public static final PlayType DC_5_1 = new PlayType("5串1", 105);
    public static final PlayType DC_6_1 = new PlayType("6串1", 106);
    public static final PlayType DC_7_1 = new PlayType("7串1", 107);
    public static final PlayType DC_8_1 = new PlayType("8串1", 108);
    public static final PlayType DC_9_1 = new PlayType("9串1", 109);
    public static final PlayType DC_10_1 = new PlayType("10串1", 110);

    public static final PlayType DC_11_1 = new PlayType("11串1", 111);
    public static final PlayType DC_12_1 = new PlayType("12串1", 112);
    public static final PlayType DC_13_1 = new PlayType("13串1", 113);
    public static final PlayType DC_14_1 = new PlayType("14串1", 114);
    public static final PlayType DC_15_1 = new PlayType("15串1", 115);

    public static final PlayType JC_ZYGG = new PlayType("自由过关", 116);
    public static final PlayType JC_1 = new PlayType("单关", 117);
    public static final PlayType JC_2_1 = new PlayType("2串1", 118);
    public static final PlayType JC_3_1 = new PlayType("3串1", 119);
    public static final PlayType JC_4_1 = new PlayType("4串1", 120);
    public static final PlayType JC_5_1 = new PlayType("5串1", 121);
    public static final PlayType JC_6_1 = new PlayType("6串1", 122);
    public static final PlayType JC_7_1 = new PlayType("7串1", 123);
    public static final PlayType JC_8_1 = new PlayType("8串1", 124);
    public static final PlayType JC_Q2_2_1 = new PlayType("前二2串1", 125);
    public static final PlayType JC_WCUP_2_1 = new PlayType("单挑王", 126);

    public static final PlayType R1_BZ = new PlayType("任选1标准", 50);
    public static final PlayType R2_BZ = new PlayType("任选2标准", 51);
    public static final PlayType R3_BZ = new PlayType("任选3标准", 52);
    public static final PlayType R4_BZ = new PlayType("任选4标准", 53);
    public static final PlayType R5_BZ = new PlayType("任选5标准", 54);
    public static final PlayType R6_BZ = new PlayType("任选6标准", 55);
    public static final PlayType R7_BZ = new PlayType("任选7标准", 56);
    public static final PlayType R8_BZ = new PlayType("任选8标准", 57);
    public static final PlayType R2_DT = new PlayType("任选2胆拖", 5022);
    public static final PlayType R3_DT = new PlayType("任选3胆拖", 5023);
    public static final PlayType R4_DT = new PlayType("任选4胆拖", 5024);
    public static final PlayType R5_DT = new PlayType("任选5胆拖", 5025);
    public static final PlayType R6_DT = new PlayType("任选6胆拖", 5026);
    public static final PlayType R7_DT = new PlayType("任选7胆拖", 5027);
    public static final PlayType R8_DT = new PlayType("任选8胆拖", 5028);
    public static final PlayType QE_ZHUX_DT = new PlayType("前二组选胆拖", 5029);
    public static final PlayType QS_ZHUX_DT = new PlayType("前三组选胆拖", 5030);
    public static final PlayType QE_ZX_DT = new PlayType("前二直选胆拖", 5031);
    public static final PlayType QS_ZX_DT = new PlayType("前三直选胆拖", 5032);
    public static final PlayType QE_ZX = new PlayType("前二直选标准", 58);
    public static final PlayType QE_ZHUX = new PlayType("前二组选标准", 59);
    public static final PlayType QS_ZX = new PlayType("前三直选标准", 60);
    public static final PlayType QS_ZHUX = new PlayType("前三组选标准", 73);

    // 票才有
    public static final PlayType R1_FS = new PlayType("任选1复式", 61);
    public static final PlayType R2_FS = new PlayType("任选2复式", 62);
    public static final PlayType R3_FS = new PlayType("任选3复式", 63);
    public static final PlayType R4_FS = new PlayType("任选4复式", 64);
    public static final PlayType R5_FS = new PlayType("任选5复式", 65);
    public static final PlayType R6_FS = new PlayType("任选6复式", 66);
    public static final PlayType R7_FS = new PlayType("任选7复式", 67);
    public static final PlayType R8_FS = new PlayType("任选8复式", 68);
    public static final PlayType QE_ZHUX_FS = new PlayType("前二组选复式", 69);
    public static final PlayType QS_ZHUX_FS = new PlayType("前三组选复式", 70);
    public static final PlayType QE_ZX_FS = new PlayType("前二直选复式", 71);
    public static final PlayType QS_ZX_FS = new PlayType("前三直选复式", 72);

    // 快乐123
    public static final PlayType KL123_R1_BZ = new PlayType("任选1标准", 5101);
    public static final PlayType KL123_R2_BZ = new PlayType("任选2标准", 5102);
    public static final PlayType KL123_R3_BZ = new PlayType("任选3标准", 5103);
    public static final PlayType KL123_R4_BZ = new PlayType("任选4标准", 5104);
    public static final PlayType KL123_R5_BZ = new PlayType("任选5标准", 5105);
    public static final PlayType KL123_R6_BZ = new PlayType("任选6标准", 5106);
    public static final PlayType KL123_R7_BZ = new PlayType("任选7标准", 5107);
    public static final PlayType KL123_R8_BZ = new PlayType("任选8标准", 5108);
    public static final PlayType KL123_R9_BZ = new PlayType("任选9标准", 5109);
    public static final PlayType KL123_R10_BZ = new PlayType("任选10标准", 5110);
    // 票-复式的
    public static final PlayType KL123_R1_FS = new PlayType("任选1复式", 5121);
    public static final PlayType KL123_R2_FS = new PlayType("任选2复式", 5122);
    public static final PlayType KL123_R3_FS = new PlayType("任选3复式", 5123);
    public static final PlayType KL123_R4_FS = new PlayType("任选4复式", 5124);
    public static final PlayType KL123_R5_FS = new PlayType("任选5复式", 5125);
    public static final PlayType KL123_R6_FS = new PlayType("任选6复式", 5126);
    public static final PlayType KL123_R7_FS = new PlayType("任选7复式", 5127);
    public static final PlayType KL123_R8_FS = new PlayType("任选8复式", 5128);
    public static final PlayType KL123_R9_FS = new PlayType("任选9复式", 5129);
    public static final PlayType KL123_R10_FS = new PlayType("任选10复式", 5130);

    // 好彩1
    public static final PlayType HC1_SZ_BZ = new PlayType("数字标准", 10601);
    public static final PlayType HC1_SX_BZ = new PlayType("生肖标准", 10602);
    public static final PlayType HC1_FW_BZ = new PlayType("方位标准", 10603);
    public static final PlayType HC1_SJ_BZ = new PlayType("四季标准", 10604);
    // 票-复式的
    public static final PlayType HC1_SZ_FS = new PlayType("数字标准", 10611);
    public static final PlayType HC1_SX_FS = new PlayType("生肖标准", 10612);
    public static final PlayType HC1_FW_FS = new PlayType("方位标准", 10613);
    public static final PlayType HC1_SJ_FS = new PlayType("四季标准", 10614);
    // 快乐十分 票-标准的
    public static final PlayType KLSF_R2_BZ = new PlayType("任选2标准", 15201);
    public static final PlayType KLSF_R3_BZ = new PlayType("任选3标准", 15202);
    public static final PlayType KLSF_R4_BZ = new PlayType("任选4标准", 15203);
    public static final PlayType KLSF_R5_BZ = new PlayType("任选5标准", 15204);
    public static final PlayType KLSF_Q1ST_BZ = new PlayType("前一数投标准", 15205);
    public static final PlayType KLSF_Q1HT_BZ = new PlayType("前一红投", 15206);
    public static final PlayType KLSF_X2LZH_BZ = new PlayType("选二连直标准", 15207);
    public static final PlayType KLSF_X3QZH_BZ = new PlayType("选三前直标准", 15208);
    public static final PlayType KLSF_X2LZ_BZ = new PlayType("选二连组标准", 15209);
    public static final PlayType KLSF_X3QZ_BZ = new PlayType("选三前组标准", 15210);

    // 快乐十分 票-复式的
    public static final PlayType KLSF_R2_FS = new PlayType("任选2复式", 15211);
    public static final PlayType KLSF_R3_FS = new PlayType("任选3复式", 15212);
    public static final PlayType KLSF_R4_FS = new PlayType("任选4复式", 15213);
    public static final PlayType KLSF_R5_FS = new PlayType("任选5复式", 15214);
    public static final PlayType KLSF_Q1ST_FS = new PlayType("前一数投复式", 15215);
    public static final PlayType KLSF_X2LZH_FS = new PlayType("选二连直复式", 15217);
    public static final PlayType KLSF_X3QZH_FS = new PlayType("选三前直复式", 15218);
    public static final PlayType KLSF_X2LZ_FS = new PlayType("选二连组复式", 15219);
    public static final PlayType KLSF_X3QZ_FS = new PlayType("选三前组复式", 15220);

    public static final PlayType KLSF_R2_DT = new PlayType("任2胆拖", 15221);
    public static final PlayType KLSF_R3_DT = new PlayType("任3胆拖", 15222);
    public static final PlayType KLSF_R4_DT = new PlayType("任4胆拖", 15223);
    public static final PlayType KLSF_R5_DT = new PlayType("任5胆拖", 15224);

    public static final PlayType KLSF_X2LZ_DT = new PlayType("选二连组胆拖", 15225);
    public static final PlayType KLSF_X3QZ_DT = new PlayType("选三前组胆拖", 15226);

    public static final PlayType KLSF_X1ST_BZ = new PlayType("选一数投", 15227);
    public static final PlayType KLSF_X1HT_BZ = new PlayType("选一红投", 15228);

    // 广西快乐十分
    public static final PlayType GXKLSF_HYT_BZ = new PlayType("好运特标准", 15001);

    public static final PlayType GXKLSF_HY1_BZ = new PlayType("好运一标准", 15002);
    public static final PlayType GXKLSF_HY1_FS = new PlayType("好运一复式", 15003);

    public static final PlayType GXKLSF_HY2_BZ = new PlayType("好运二标准", 15004);
    public static final PlayType GXKLSF_HY2_FS = new PlayType("好运二复式", 15005);
    public static final PlayType GXKLSF_HY2_DT = new PlayType("好运二胆拖", 15006);

    public static final PlayType GXKLSF_HY3_BZ = new PlayType("好运三标准", 15007);
    public static final PlayType GXKLSF_HY3_FS = new PlayType("好运三复式", 15008);
    public static final PlayType GXKLSF_HY3_DT = new PlayType("好运三胆拖", 15009);

    public static final PlayType GXKLSF_HY4_BZ = new PlayType("好运四标准", 15010);
    public static final PlayType GXKLSF_HY4_FS = new PlayType("好运四复式", 15011);
    public static final PlayType GXKLSF_HY4_DT = new PlayType("好运四胆拖", 15012);

    public static final PlayType GXKLSF_HY5_BZ = new PlayType("好运五标准", 15013);
    public static final PlayType GXKLSF_HY5_FS = new PlayType("好运五复式", 15014);
    public static final PlayType GXKLSF_HY5_DT = new PlayType("好运五胆拖", 15015);

    public static final PlayType GXKLSF_HYTX3_BZ = new PlayType("好运通选三标准", 15016);
    public static final PlayType GXKLSF_HYTX3_FS = new PlayType("好运通选三复式", 15017);

    public static final PlayType GXKLSF_HYTX4_BZ = new PlayType("好运通选四标准", 15018);
    public static final PlayType GXKLSF_HYTX4_FS = new PlayType("好运通选四复式", 15019);

    public static final PlayType GXKLSF_HYTX5_BZ = new PlayType("好运通选五标准", 15020);
    public static final PlayType GXKLSF_HYTX5_FS = new PlayType("好运通选五复式", 15021);
    // 群英会
    public static final PlayType QYH_R1_BZ = new PlayType("任1标准", 15401);
    public static final PlayType QYH_R2_BZ = new PlayType("任2标准", 15402);
    public static final PlayType QYH_R3_BZ = new PlayType("任3标准", 15403);
    public static final PlayType QYH_R4_BZ = new PlayType("任4标准", 15404);
    public static final PlayType QYH_R5_BZ = new PlayType("任5标准", 15405);
    public static final PlayType QYH_R6_BZ = new PlayType("任6标准", 15406);
    public static final PlayType QYH_R7_BZ = new PlayType("任7标准", 15407);
    public static final PlayType QYH_R8_BZ = new PlayType("任8标准", 15408);
    public static final PlayType QYH_R9_BZ = new PlayType("任9标准", 15409);
    public static final PlayType QYH_R10_BZ = new PlayType("任10标准", 15410);

    public static final PlayType QYH_R2_DT = new PlayType("任2胆拖", 15482);
    public static final PlayType QYH_R3_DT = new PlayType("任3胆拖", 15483);
    public static final PlayType QYH_R4_DT = new PlayType("任4胆拖", 15484);
    public static final PlayType QYH_R5_DT = new PlayType("任5胆拖", 15485);
    public static final PlayType QYH_R6_DT = new PlayType("任6胆拖", 15486);
    public static final PlayType QYH_R7_DT = new PlayType("任7胆拖", 15487);
    public static final PlayType QYH_R8_DT = new PlayType("任8胆拖", 15488);
    public static final PlayType QYH_R9_DT = new PlayType("任9胆拖", 15489);
    public static final PlayType QYH_R10_DT = new PlayType("任10胆拖", 15490);

    public static final PlayType QYH_W1_BZ = new PlayType("围1标准", 15411);
    public static final PlayType QYH_W2_BZ = new PlayType("围2标准", 15412);
    public static final PlayType QYH_W3_BZ = new PlayType("围3标准", 15413);
    public static final PlayType QYH_W4_BZ = new PlayType("围4标准", 15414);
    public static final PlayType QYH_W5_BZ = new PlayType("围5标准", 15419);

    public static final PlayType QYH_WEI2_DT = new PlayType("围2胆拖", 15415);
    public static final PlayType QYH_WEI3_DT = new PlayType("围3胆拖", 15416);
    public static final PlayType QYH_WEI4_DT = new PlayType("围4胆拖", 15417);
    public static final PlayType QYH_WEI5_DT = new PlayType("围5胆拖", 15418);

    public static final PlayType QYH_S1_BZ = new PlayType("顺1标准", 15421);
    public static final PlayType QYH_S2_BZ = new PlayType("顺2标准", 15422);
    public static final PlayType QYH_S3_BZ = new PlayType("顺3标准", 15423);

    // 群英会 票-复式的
    public static final PlayType QYH_R1_FS = new PlayType("任1复式", 15451);
    public static final PlayType QYH_R2_FS = new PlayType("任2复式", 15452);
    public static final PlayType QYH_R3_FS = new PlayType("任3复式", 15453);
    public static final PlayType QYH_R4_FS = new PlayType("任4复式", 15454);
    public static final PlayType QYH_R5_FS = new PlayType("任5复式", 15455);
    public static final PlayType QYH_R6_FS = new PlayType("任6复式", 15456);
    public static final PlayType QYH_R7_FS = new PlayType("任7复式", 15457);
    public static final PlayType QYH_R8_FS = new PlayType("任8复式", 15458);
    public static final PlayType QYH_R9_FS = new PlayType("任9复式", 15459);
    public static final PlayType QYH_R10_FS = new PlayType("任10复式", 15460);

    public static final PlayType QYH_W1_FS = new PlayType("围1复式", 15461);
    public static final PlayType QYH_W2_FS = new PlayType("围2复式", 15462);
    public static final PlayType QYH_W3_FS = new PlayType("围3复式", 15463);
    public static final PlayType QYH_W4_FS = new PlayType("围4复式", 15464);
    public static final PlayType QYH_W5_FS = new PlayType("围5复式", 15465);

    public static final PlayType QYH_S1_FS = new PlayType("顺1复式", 15471);
    public static final PlayType QYH_S2_FS = new PlayType("顺2复式", 15472);
    public static final PlayType QYH_S3_FS = new PlayType("顺3复式", 15473);

    // 快乐8单式
    public static final PlayType KL8_R1_BZ = new PlayType("任1标准", 156001);
    public static final PlayType KL8_R2_BZ = new PlayType("任2标准", 156002);
    public static final PlayType KL8_R3_BZ = new PlayType("任3标准", 156003);
    public static final PlayType KL8_R4_BZ = new PlayType("任4标准", 156004);
    public static final PlayType KL8_R5_BZ = new PlayType("任5标准", 156005);
    public static final PlayType KL8_R6_BZ = new PlayType("任6标准", 156006);
    public static final PlayType KL8_R7_BZ = new PlayType("任7标准", 156007);
    public static final PlayType KL8_R8_BZ = new PlayType("任8标准", 156008);
    public static final PlayType KL8_R9_BZ = new PlayType("任9标准", 156009);
    public static final PlayType KL8_R10_BZ = new PlayType("任10标准", 156010);

    // 快乐8复式
    // public static final PlayType KL8_R1_FS =new PlayType("任1复式",15611);
    // public static final PlayType KL8_R2_FS =new PlayType("任2复式",15612);
    // public static final PlayType KL8_R3_FS =new PlayType("任3复式",15613);
    // public static final PlayType KL8_R4_FS =new PlayType("任4复式",15614);
    // public static final PlayType KL8_R5_FS =new PlayType("任5复式",15615);
    // public static final PlayType KL8_R6_FS =new PlayType("任6复式",15616);
    // public static final PlayType KL8_R7_FS =new PlayType("任7复式",15617);
    // public static final PlayType KL8_R8_FS =new PlayType("任8复式",15618);
    // public static final PlayType KL8_R9_FS =new PlayType("任9复式",15619);
    // public static final PlayType KL8_R10_FS =new PlayType("任10复式",15620);

    // 快乐8单式飞盘
    public static final PlayType KL8_R1_BZ_FP = new PlayType("任1标准飞盘", 156101);
    public static final PlayType KL8_R2_BZ_FP = new PlayType("任2标准飞盘", 156102);
    public static final PlayType KL8_R3_BZ_FP = new PlayType("任3标准飞盘", 156103);
    public static final PlayType KL8_R4_BZ_FP = new PlayType("任4标准飞盘", 156104);
    public static final PlayType KL8_R5_BZ_FP = new PlayType("任5标准飞盘", 156105);
    public static final PlayType KL8_R6_BZ_FP = new PlayType("任6标准飞盘", 156106);
    public static final PlayType KL8_R7_BZ_FP = new PlayType("任7标准飞盘", 156107);
    public static final PlayType KL8_R8_BZ_FP = new PlayType("任8标准飞盘", 156108);
    public static final PlayType KL8_R9_BZ_FP = new PlayType("任9标准飞盘", 156109);
    public static final PlayType KL8_R10_BZ_FP = new PlayType("任10标准飞盘", 156110);

    // 快乐8复式飞盘
    // public static final PlayType KL8_R1_FS_FP =new PlayType("任1复式飞盘",15631);
    // public static final PlayType KL8_R2_FS_FP =new PlayType("任2复式飞盘",15632);
    // public static final PlayType KL8_R3_FS_FP =new PlayType("任3复式飞盘",15633);
    // public static final PlayType KL8_R4_FS_FP =new PlayType("任4复式飞盘",15634);
    // public static final PlayType KL8_R5_FS_FP =new PlayType("任5复式飞盘",15635);
    // public static final PlayType KL8_R6_FS_FP =new PlayType("任6复式飞盘",15636);
    // public static final PlayType KL8_R7_FS_FP =new PlayType("任7复式飞盘",15637);
    // public static final PlayType KL8_R8_FS_FP =new PlayType("任8复式飞盘",15638);
    // public static final PlayType KL8_R9_FS_FP =new PlayType("任9复式飞盘",15639);
    // public static final PlayType KL8_R10_FS_FP =new
    // PlayType("任10复式飞盘",15640);

    //旋转矩阵
    public static final PlayType XZJZ_Z6B5 = new PlayType("旋转矩阵(中6保5)", 1111);
    public static final PlayType XZJZ_Z6B4 = new PlayType("旋转矩阵(中6保4)", 1112);
    public static final PlayType XZJZ_Z5B5 = new PlayType("旋转矩阵(中5保5)", 1113);

    public static final PlayType XZJZ_Z5B4 = new PlayType("旋转矩阵(中5保4)", 1114);
    public static final PlayType XZJZ_Z5B3 = new PlayType("旋转矩阵(中5保3)", 1115);
    public static final PlayType XZJZ_Z4B4 = new PlayType("旋转矩阵(中4保4)", 1116);

    //定胆杀号机选
    public static final PlayType DDSHJX = new PlayType("定胆杀号机选", 1117);

    //快3
    public static final PlayType K3_HZ = new PlayType("和值", 3001);
    public static final PlayType K3_STHTX = new PlayType("三同号通选", 3002);
    public static final PlayType K3_STHDX = new PlayType("三同号单选", 3003);
    public static final PlayType K3_ETHFX = new PlayType("二同号复选", 3004);
    public static final PlayType K3_SLHTX = new PlayType("三连号通选", 3005);
    public static final PlayType K3_ETHDX = new PlayType("二同号单选", 3006);
    public static final PlayType K3_SBTH = new PlayType("三不同号", 3007);
    public static final PlayType K3_EBTH = new PlayType("二不同号", 3008);
    public static final PlayType K3_SBTHDT = new PlayType("三不同号胆拖", 3009);
    public static final PlayType K3_EBTHDT = new PlayType("二不同号胆拖", 3010);

    //
    public static final PlayType POKER_THBX = new PlayType("同花包选", 4001);
    public static final PlayType POKER_THDX = new PlayType("同花单选", 4002);
    public static final PlayType POKER_THSBX = new PlayType("同花顺包选", 4003);
    public static final PlayType POKER_THSDX = new PlayType("同花顺单选", 4004);
    public static final PlayType POKER_SZDX = new PlayType("顺子单选", 4005);
    public static final PlayType POKER_SZBX = new PlayType("顺子包选", 4006);
    public static final PlayType POKER_BZDX = new PlayType("豹子单选", 4007);
    public static final PlayType POKER_BZBX = new PlayType("豹子包选", 4008);
    public static final PlayType POKER_DZDX = new PlayType("对子单选", 4009);
    public static final PlayType POKER_DZBX = new PlayType("对子包选", 4010);
    public static final PlayType POKER_THDX_FS = new PlayType("同花单选复式", 4011);
    public static final PlayType POKER_THSDX_FS = new PlayType("同花顺单选复式", 4012);
    public static final PlayType POKER_DZDX_FS = new PlayType("对子单选复式", 4014);
    public static final PlayType POKER_BZDX_FS = new PlayType("豹子单选复式", 4015);
    public static final PlayType POKER_SZDX_FS = new PlayType("顺子单选复式", 4016);

    //包含单式,复式
    public static final PlayType POKER_THTZ=new PlayType("同花投注",5001);
    public static final PlayType POKER_THSTZ=new PlayType("同花顺投注",5002);
    public static final PlayType POKER_SZTZ=new PlayType("顺子投注",5003);
    public static final PlayType POKER_THAOTZ=new PlayType("同号投注",5004);

    public static final Map<String,String> POKER_REPLACE_MAP=new HashMap<String, String>();
    public static final Map<Integer,String> POKER_BX_MAP=new HashMap<Integer, String>();



    public static List list = new ArrayList();
    public static Map SsqMap =new HashMap();  //手机投注
    public static Map DltMap =new HashMap();  //手机投注
    public static Map SDMap =new HashMap();  //手机投注
    public static Map GD11X5Map =new HashMap();  //手机投注
    public static Map JxsscMap=new HashMap(); //手机投注
    public static Map pokerK3Map=new HashMap();
    static {
        POKER_BX_MAP.put(POKER_THTZ.getValue(),"THBX" );
        POKER_BX_MAP.put(POKER_THSTZ.getValue(),"THSBX" );
        POKER_BX_MAP.put(POKER_SZTZ.getValue(),"SZBX" );
        POKER_BX_MAP.put(POKER_BZBX.getValue(),"BZBX" );
        POKER_BX_MAP.put(POKER_DZBX.getValue(),"DZBX" );

        POKER_REPLACE_MAP.put("01", "A");
        POKER_REPLACE_MAP.put("02", "2");
        POKER_REPLACE_MAP.put("03", "3");
        POKER_REPLACE_MAP.put("04", "4");
        POKER_REPLACE_MAP.put("05", "5");
        POKER_REPLACE_MAP.put("06", "6");
        POKER_REPLACE_MAP.put("07", "7");
        POKER_REPLACE_MAP.put("08", "8");
        POKER_REPLACE_MAP.put("09", "9");
        POKER_REPLACE_MAP.put("10", "10");
        POKER_REPLACE_MAP.put("11", "J");
        POKER_REPLACE_MAP.put("12", "Q");
        POKER_REPLACE_MAP.put("13", "K");
        POKER_REPLACE_MAP.put("THBX", "同花包选");
        POKER_REPLACE_MAP.put("THSBX", "同花顺包选");
        POKER_REPLACE_MAP.put("SZBX", "顺子包选");
        POKER_REPLACE_MAP.put("BZBX", "豹子包选");
        POKER_REPLACE_MAP.put("DZBX", "对子包选");
        POKER_REPLACE_MAP.put("1", "黑桃");
        POKER_REPLACE_MAP.put("2", "红桃");
        POKER_REPLACE_MAP.put("3", "梅花");
        POKER_REPLACE_MAP.put("4", "方块");
        list.add(ALL);
        list.add(DS);
        list.add(FS);
        list.add(DT);
        list.add(JC_Q2_2_1);
        list.add(JC_WCUP_2_1);
        /*
         * list.add(DSHZ); list.add(DSTX); list.add(DSZX); list.add(DSZH);
         * list.add(DSDXDS); list.add(FSHZ); list.add(FSTX); list.add(FSZX);
         * list.add(FSZH); list.add(FSDXDS);
         */
        // list.add(WXDS);
        // list.add(WXFS);
        // list.add(SXDS);
        // list.add(SXFS);
        // list.add(LXDS);
        // list.add(LXFS);
        // list.add(YXDS);
        // list.add(YXFS);
        // list.add(Z3DS);
        // list.add(Z3BH);
        // list.add(Z3HZ);
        // list.add(Z6DS);
        // list.add(Z6BH);
        // list.add(Z6HZ);
        // list.add(Z6DT);
        /*
         * list.add(XYC_DS); list.add(XYC_FS); list.add(XYC_DT);
         */
        // list.add(EXHZ);
        // list.add(EXBHDS);
        // list.add(EXBHFS);
        // list.add(SXZHUXHZ);
        // list.add(WXTXDS);
        // list.add(WXTXFS);
        SsqMap.put(DS.getValue(), DS);
        SsqMap.put(FS.getValue(), FS);
        SsqMap.put(DT.getValue(), DT);
        SsqMap.put(XZJZ_Z6B5.getValue(), XZJZ_Z6B5);
        SsqMap.put(XZJZ_Z6B4.getValue(), XZJZ_Z6B4);
        SsqMap.put(XZJZ_Z5B5.getValue(), XZJZ_Z5B5);
        SsqMap.put(DDSHJX.getValue(), DDSHJX);

        DltMap.put(DS.getValue(), DS);
        DltMap.put(FS.getValue(), FS);
        DltMap.put(DT.getValue(), DT);
        DltMap.put(SXL_DS.getValue(), SXL_DS);
        DltMap.put(SXL_FS.getValue(), SXL_FS);
        DltMap.put(XZJZ_Z5B4.getValue(), XZJZ_Z5B4);
        DltMap.put(XZJZ_Z5B3.getValue(), XZJZ_Z5B3);
        DltMap.put(XZJZ_Z4B4.getValue(), XZJZ_Z4B4);
        DltMap.put(DDSHJX.getValue(), DDSHJX);

        SDMap.put(ZX.getValue(), ZX);
        SDMap.put(ZXHZ.getValue(),ZXHZ);
        SDMap.put(ZXDT.getValue(), ZXDT);
        SDMap.put(ZSBZ.getValue(), ZSBZ);
        SDMap.put(ZSHZ.getValue(), ZSHZ);
        SDMap.put(ZS.getValue(), ZS);
        SDMap.put(ZL.getValue(), ZL);
        SDMap.put(ZLHZ.getValue(), ZLHZ);
        SDMap.put(ZLDT.getValue(),ZLDT);
        SDMap.put(ZHUXUAN.getValue(), ZHUXUAN);
        SDMap.put(ZXKD.getValue(), ZXKD);
        SDMap.put(ZXBH.getValue(), ZXBH);
        SDMap.put(ZHIXUANDS.getValue(), ZHIXUANDS);
        SDMap.put(D1.getValue(), D1);
        SDMap.put(D2.getValue(), D2);
        SDMap.put(C1D.getValue(), C1D);
        SDMap.put(C2D.getValue(), C1D);
        SDMap.put(TX.getValue(), TX);
        SDMap.put(HS.getValue(), HS);
        SDMap.put(BX3.getValue(), BX3);
        SDMap.put(BX6.getValue(), BX6);
        SDMap.put(DX.getValue(), DX);
        SDMap.put(JO.getValue(), JO);
        SDMap.put(C3T.getValue(), C3T);
        SDMap.put(TLJ.getValue(), TLJ);

        GD11X5Map.put(R1_BZ.getValue(), R1_BZ);
        GD11X5Map.put(R2_BZ.getValue(), R2_BZ);
        GD11X5Map.put(R3_BZ.getValue(), R3_BZ);
        GD11X5Map.put(R4_BZ.getValue(), R4_BZ);
        GD11X5Map.put(R5_BZ.getValue(), R5_BZ);
        GD11X5Map.put(R6_BZ.getValue(), R6_BZ);
        GD11X5Map.put(R7_BZ.getValue(), R7_BZ);
        GD11X5Map.put(R8_BZ.getValue(), R8_BZ);
        GD11X5Map.put(R2_DT.getValue(), R2_DT);
        GD11X5Map.put(R3_DT.getValue(), R3_DT);
        GD11X5Map.put(R4_DT.getValue(), R4_DT);
        GD11X5Map.put(R5_DT.getValue(), R5_DT);
        GD11X5Map.put(R6_DT.getValue(), R6_DT);
        GD11X5Map.put(R7_DT.getValue(), R7_DT);
        GD11X5Map.put(R8_DT.getValue(), R8_DT);
        GD11X5Map.put(QE_ZX.getValue(), QE_ZX);
        GD11X5Map.put(QE_ZHUX.getValue(), QE_ZHUX);
        GD11X5Map.put(QE_ZHUX_DT.getValue(), QE_ZHUX_DT);
        GD11X5Map.put(QS_ZX.getValue(), QS_ZX);
        GD11X5Map.put(QS_ZHUX.getValue(), QS_ZHUX);
        GD11X5Map.put(QS_ZHUX_DT.getValue(),QS_ZHUX_DT);
        GD11X5Map.put(QE_ZX_DT.getValue(), QE_ZX_DT);
        GD11X5Map.put(QS_ZX_DT.getValue(), QS_ZX_DT);

        JxsscMap.put(JXSSC_YXFS.getValue(), JXSSC_YXFS);
        JxsscMap.put(JXSSC_LXFS.getValue(), JXSSC_LXFS);
        JxsscMap.put(JXSSC_EXBHFS.getValue(), JXSSC_EXBHFS);
        JxsscMap.put(JXSSC_EXBHHZ.getValue(),JXSSC_EXBHHZ);
        JxsscMap.put(JXSSC_EXZHDT.getValue(), JXSSC_EXZHDT);
        JxsscMap.put(JXSSC_SXFS.getValue(),JXSSC_SXFS);
        JxsscMap.put(JXSSC_SXZHIXHZ.getValue(), JXSSC_SXZHIXHZ);
        JxsscMap.put(JXSSC_SXZHIXDT.getValue(), JXSSC_SXZHIXDT);
        JxsscMap.put(JXSSC_SXZHIXKD.getValue(), JXSSC_SXZHIXKD);
        JxsscMap.put(ZSBZ.getValue(), ZSBZ);
        JxsscMap.put(JXSSC_Z3BH.getValue(), JXSSC_Z3BH);
        JxsscMap.put(JXSSC_Z6BH.getValue(), JXSSC_Z6BH);
        JxsscMap.put(JXSSC_SXZ6DT.getValue(),JXSSC_SXZ6DT);
        JxsscMap.put(JXSSC_SIXFS.getValue(), JXSSC_SIXFS);
        JxsscMap.put(JXSSC_WXFS.getValue(), JXSSC_WXFS);
        JxsscMap.put(JXSSC_WXTXFS.getValue(), JXSSC_WXTXFS);
        JxsscMap.put(JXSSC_DSDXFS.getValue(),JXSSC_DSDXFS);
        JxsscMap.put(JXSSC_R1_BZ.getValue(), JXSSC_R1_BZ);
        JxsscMap.put(JXSSC_R2_BZ.getValue(), JXSSC_R2_BZ);
        JxsscMap.put(JXSSC_WXFX.getValue(), JXSSC_WXFX);
        JxsscMap.put(JXSSC_SIXFX.getValue(),JXSSC_SIXFX);
        JxsscMap.put(JXSSC_SXFX.getValue(),JXSSC_SXFX);
        JxsscMap.put(JXSSC_LXFX.getValue(), JXSSC_LXFX);
        JxsscMap.put(JXSSC_EXBHDS.getValue(), JXSSC_EXBHDS);
        JxsscMap.put(JXSSC_SXZUX.getValue(), JXSSC_SXZUX);
        JxsscMap.put(JXSSC_EXZUX.getValue(),JXSSC_EXZUX);
        JxsscMap.put(Z3HZ.getValue(), Z3HZ);
        JxsscMap.put(Z6HZ.getValue(), Z6HZ);

        pokerK3Map.put(R1_BZ.getValue(), R1_BZ);
        pokerK3Map.put(R2_BZ.getValue(), R2_BZ);
        pokerK3Map.put(R3_BZ.getValue(), R3_BZ);
        pokerK3Map.put(R4_BZ.getValue(), R4_BZ);
        pokerK3Map.put(R5_BZ.getValue(), R5_BZ);
        pokerK3Map.put(R6_BZ.getValue(), R6_BZ);
        pokerK3Map.put(R2_DT.getValue(), R2_DT);
        pokerK3Map.put(R3_DT.getValue(), R3_DT);
        pokerK3Map.put(R4_DT.getValue(), R4_DT);
        pokerK3Map.put(R5_DT.getValue(), R5_DT);
        pokerK3Map.put(R6_DT.getValue(), R6_DT);
        pokerK3Map.put(POKER_THBX.getValue(), POKER_THBX);
        pokerK3Map.put(POKER_THDX.getValue(), POKER_THDX);
        pokerK3Map.put(POKER_THSBX.getValue(), POKER_THSBX);
        pokerK3Map.put(POKER_THSDX.getValue(), POKER_THSDX);
        pokerK3Map.put(POKER_SZBX.getValue(), POKER_SZBX);
        pokerK3Map.put(POKER_SZDX.getValue(), POKER_SZDX);
        pokerK3Map.put(POKER_BZBX.getValue(), POKER_BZBX);
        pokerK3Map.put(POKER_BZDX.getValue(), POKER_BZDX);
        pokerK3Map.put(POKER_DZBX.getValue(), POKER_DZBX);
        pokerK3Map.put(POKER_DZDX.getValue(), POKER_DZDX);
        pokerK3Map.put(POKER_THDX_FS.getValue(), POKER_THDX_FS);
        pokerK3Map.put(POKER_THSDX_FS.getValue(), POKER_THSDX_FS);
        pokerK3Map.put(POKER_DZDX_FS.getValue(), POKER_DZDX_FS);
        pokerK3Map.put(POKER_THTZ.getValue(), POKER_THTZ);
        pokerK3Map.put(POKER_THSTZ.getValue(), POKER_THSTZ);
        pokerK3Map.put(POKER_SZTZ.getValue(), POKER_SZTZ);
        pokerK3Map.put(POKER_THAOTZ.getValue(), POKER_THAOTZ);
        pokerK3Map.put(POKER_SZDX_FS.getValue(), POKER_SZDX_FS);
        pokerK3Map.put(POKER_BZDX_FS.getValue(), POKER_BZDX_FS);
    }

}
