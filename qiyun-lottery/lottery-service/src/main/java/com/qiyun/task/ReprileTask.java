package com.qiyun.task;

import com.qiyun.httpUtil.RedisUtil;
import com.qiyun.httpUtil.ReptileUtil;
import com.qiyun.tools.CLSmsSend;
import com.qiyun.util.Constants;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

@Component
@Lazy(value=false)
public class ReprileTask {
    private static final String url = "http://info.sporttery.cn/iframe/lottery_notice.php";

    /**
     * 竞彩足球SP任务触发器
     */
    @Scheduled(cron = "0 0/5 * * * ?")//每隔三分钟处理一次
    private void updateAward() {
        String html = ReptileUtil.getHtml(url);
        String s = ReptileUtil.parseHtml(html);
        int i = s.indexOf("&nbsp;");
        String match = s.substring(0,i);
        String time = s.substring(i+6, s.length()).trim();
        try {
            Jedis jedis = RedisUtil.getJedis();
            String matchNotify = jedis.get(Constants.NOTIFY);
            String content = match + ",中国竞彩网更新时间" + time;
            if(matchNotify == null){
                jedis.set(Constants.NOTIFY, match + time);
            } else if(!matchNotify.equals(match + time)){
                CLSmsSend.send("15267185000", content);
                CLSmsSend.send("18758094999", content);
                CLSmsSend.send("18258136501", content);
                CLSmsSend.send("18858114412", content);
                jedis.set(Constants.NOTIFY, match + time);
            }
//            else{
//                CLSmsSend.send("15869133169", content);
//            }
            jedis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        ReprileTask task = new ReprileTask();
//        task.updateAward();
//    }
}
