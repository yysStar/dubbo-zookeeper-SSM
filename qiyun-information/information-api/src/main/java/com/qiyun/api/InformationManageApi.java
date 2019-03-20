package com.qiyun.api;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Map;


public interface InformationManageApi {

    Map<String, Object> getSpSourse();

    Map<String, Object> reviseSpSourse(int Sourse);

    Map<String, Object> getMailList(int type,int status);

    Map<String, Object> getUnreviewedWinCommentList(int offset, int pageSize,int id,int type);

    Map<String, Object> shWinComment(String cid,Integer type);

    Map<String, Object> getUnreviewedCommentList(int offset, int pageSize,int id,int type);

    /**
     * 审核评论
     * @return
     */
    Map<String, Object> shComment(String cid,Integer type);

    /**
     * 审核实战二串一
     * @param sid
     * @return
     */
    Map<String, Object> shSZ2C1(String sid);

    /**
     * 驳回实战二串一
     * @param sid
     * @return
     */
    Map<String, Object> bhSZ2C1(String sid);

    /**
     * 审核每日俩单
     * @param sid
     * @return
     */
    Map<String, Object> shDOD(String sid);

    /**
     * 驳回每日俩单
     * @param sid
     * @return
     */
    Map<String, Object> bhDOD(String sid);

    /**
     * 手动修改排列三、排列五开奖结果
     * @param type
     * @param result
     * @return
     */
    Map<String, Object> setPL(int type,String result,String term);

    /**
     * 获取分类或标签列表
     * @param type
     * @return
     */
    Map<String, Object> getTypes(int type);

    /**
     * 根据id获取指定的资讯
     * @param id
     * @return
     */
    Map<String, Object> getNew(int id);

    /**
     * 获取资讯列表
     * @param offset
     * @param pageSize
     * @return
     */
    Map<String, Object> getNewsList(int offset, int pageSize,String type,String label,String startTime,String endTime,String title);


    /**
     * 为新闻设置封面图片
     * @param file
     * @return
     */
    Map<String, Object> setNewsPicetur(String s,int id);

    /**
     * 发布和修改资讯
     * @param type
     * @param click
     * @param createDateTime
     * @param showDateTime
     * @param isShow
     * @param title
     * @param shortTitle
     * @param keyword
     * @param contentType
     * @param link
     * @param content
     * @param sort
     * @param summary
     * @param label
     * @param editor
     *
     * @return
     */
    Map<String, Object> createNews(String type,Integer click,Integer isShow,String title,String shortTitle,String keyword,Integer contentType,String link,String content,Integer sort,String summary,String label,String editor,Integer cz,String id,String picture);


    Map<String, Object> updateShow(Integer id,Integer type);

    /**
     * 新增实战二串一（一）
     * @param matchId1
     * @param homeTeam1
     * @param guestTeam1
     * @param recommend1
     * @param matchId2
     * @param homeTeam2
     * @param guestTeam2
     * @param recommend2
     * @param multiple
     * @param amount
     * @param bonus
     * @param author
     * @return
     */
    Map<String, Object> createSZ2C11(String matchId1, String homeTeam1, String guestTeam1, String recommend1, String matchId2,
                                     String homeTeam2, String guestTeam2, String recommend2, Integer multiple, Double amount, String bonus, String author);


    /**
     * 新增实战二串一（二）
     * @param matchId1
     * @param homeTeam1
     * @param guestTeam1
     * @param recommend1
     * @param matchId2
     * @param homeTeam2
     * @param guestTeam2
     * @param recommend2
     * @param multiple
     * @param amount
     * @param bonus
     * @param author
     * @return
     */
    Map<String, Object> createSZ2C12(String matchId1, String homeTeam1, String guestTeam1, String recommend1, String matchId2,
                                     String homeTeam2, String guestTeam2, String recommend2, Integer multiple, Double amount, String bonus, String author);

    /**
     * 新增每日俩单1
     *
     * @param playType
     * @param matchId
     * @param homeTeam
     * @param guestTeam
     * @param recommend
     * @param sp
     * @param analyze
     * @return
     */
    Map<String, Object> createDayOneDan1(String playType, String matchId, String homeTeam,
                                         String guestTeam, String recommend, Double sp, String analyze, String author);

    /**
     * 新增每日俩单2
     *
     * @param playType
     * @param matchId
     * @param homeTeam
     * @param guestTeam
     * @param recommend
     * @param sp
     * @param analyze
     * @return
     */
    Map<String, Object> createDayOneDan2(String playType, String matchId, String homeTeam,
                                         String guestTeam, String recommend, Double sp, String analyze, String author);


}
