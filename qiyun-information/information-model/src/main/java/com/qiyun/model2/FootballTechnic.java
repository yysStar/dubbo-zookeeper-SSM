package com.qiyun.model2;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FootballTechnic implements Serializable {

    //比赛ID
    private Integer id;

    private String connect;
    /**
     * 【技术统计类型,主队技术统计,客队技术统计】以分号分隔，三项一组，分别为：类型(从0开始编号)，主队技术统计，客队技术统计；
     * 例：“3,15,4”表示的是“射门次数，主队15次，客队4次”。
     * 0.先开球
     * 1.第一个角球
     * 2.第一张黄牌
     * 3.射门次数
     * 4.射正次数
     * 5.犯规次数
     * 6.角球次数
     * 7.角球次数(加时)
     * 8.任意球次数
     * 9.越位次数
     * 10.乌龙球数
     * 11.黄牌数
     * 12.黄牌数(加时)
     * 13.红牌数
     * 14.控球时间
     * 15.头球
     * 16.救球
     * 17.守门员出击
     * 18.丟球
     * 19.成功抢断
     * 20.阻截
     * 21.长传
     * 22.短传
     * 23.助攻
     * 24.成功传中
     * 25.第一个换人
     * 26.最后换人
     * 27.第一个越位
     * 28.最后越位
     * 29.换人数
     * 30.最后角球
     * 31.最后黄牌
     * 32.换人数(加时)
     * 33.越位次数(加时)
     * 34.射门不中
     * 35.中柱
     * 36.头球成功次数
     * 37.射门被挡
     * 38.铲球
     * 39.过人次数
     * 40.界外球
     * 41.传球次数
     * 42.传球成功率
     * 43.进攻次数
     * 44.危险进攻次数
     * 45.半场角球
     * 46.半场控球
     */
}