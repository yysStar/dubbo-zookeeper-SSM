package com.qiyun.service.biz;

import com.qiyun.api.InformationManageApi;
import com.qiyun.mapper2.MailMapper;
import com.qiyun.model2.Mail;
import com.qiyun.model2.MailExample;
import com.qiyun.service.*;
import com.qiyun.serviceImpl.FootballSpServiceImpl;
import com.qiyun.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("informationManageApi")
public class InformationManageBiz implements InformationManageApi {

    @Autowired
    private DayOneDanService dayOneDanService;

    @Autowired
    private SZ2C1Service sz2C1Service;

    @Autowired
    private CmsNewsTypeService cmsNewsTypeService;

    @Autowired
    private CmsService cmsService;

    @Autowired
    private LotteryTermService lotteryTermService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private FootballSpServiceImpl footballSpService;

    @Autowired
    private MailMapper mailMapper;


    public Map<String, Object> getSpSourse() {
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            int spSourse = footballSpService.getSpSourse();
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,spSourse);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取SP抓取源失败");
            return map;
        }
    }

    public Map<String, Object> reviseSpSourse(int Sourse) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if(Sourse!=1&&Sourse!=2){
                map.put(Constants.CODE, Constants.ERROR_CODE_626);
                map.put(Constants.MSG, Constants.ERROR_MSG_626);
                return map;
            }
            int n = footballSpService.reviseSpSourse(Sourse);
            if(n == 1){
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                return map;
            }else {
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "修改SP抓取源失败");
                return map;
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "修改SP抓取源失败");
            return map;
        }
    }

    public Map<String, Object> getMailList(int type, int status) {
        Map<String, Object> map = new HashMap<String, Object>();
        MailExample mailExample = new MailExample();
        MailExample.Criteria criteria = mailExample.createCriteria();
        if(type!=-1){
            criteria.andTypeEqualTo(type);
        }
        if(status!=-1){
            criteria.andStatusEqualTo(status);
        }
        List<Mail> mails = mailMapper.selectByExampleWithBLOBs(mailExample);
        for (Mail mail:mails
             ) {
            Date createDate = mail.getCreateDate();
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timestamp = format2.format(createDate);
            mail.setCreateTime(timestamp);
        }
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA,mails);
        return map;
    }

    public Map<String, Object> getUnreviewedWinCommentList(int offset, int pageSize, int id, int type) {
        return commentService.getUnreviewedWinCommentList(offset,pageSize,id,type);
    }

    public Map<String, Object> shWinComment(String cid,Integer type) {
        return commentService.shWinComment(cid,type);
    }

    /**
     * 获取未审核评论列表
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> getUnreviewedCommentList(int offset, int pageSize,int id,int type){
        return commentService.getUnreviewedCommentList(offset,pageSize,id,type);
    }

    /**
     * 审核评论
     *
     * @param cid@return
     */
    public Map<String, Object> shComment(String cid,Integer type) {
        return commentService.shComment(cid,type);
    }

    /**
     * 审核实战二串一
     *
     * @param sid
     * @return
     */
    public Map<String, Object> shSZ2C1(String sid) {
        return sz2C1Service.shSZ2C1(sid);
    }

    /**
     * 驳回实战二串一
     *
     * @param sid@return
     */
    public Map<String, Object> bhSZ2C1(String sid) {
        return sz2C1Service.bhSZ2C1(sid);
    }

    /**
     * 审核每日俩单
     *
     * @param sid
     * @return
     */
    public Map<String, Object> shDOD(String sid) {
        return dayOneDanService.shDOD(sid);
    }

    /**
     * 驳回每日俩单
     *
     * @param sid@return
     */
    public Map<String, Object> bhDOD(String sid) {
        return dayOneDanService.bhDOD(sid);
    }

    /**
     * 手动修改排列三、排列五开奖结果
     *
     * @param type
     * @param result
     * @return
     */
    public Map<String, Object> setPL(int type, String result,String term) {
        return lotteryTermService.setPL(type,result,term);
    }

    /**
     * 获取分类或标签列表
     *
     * @param type
     * @return
     */
    public Map<String, Object> getTypes(int type) {
        return cmsService.getTypes(type);
    }

    /**
     * 根据id获取指定的资讯
     *
     * @param id
     * @return
     */
    public Map<String, Object> getNew(int id) {
        return cmsService.getNew(id);
    }

    /**
     * 获取资讯列表
     * @param offset
     * @param pageSize
     * @return
     */
    public Map<String, Object> getNewsList(int offset, int pageSize,String type,String label,String startTime,String endTime,String title) {
        return cmsService.getNewsList(offset,pageSize,type,label,startTime,endTime,title);
    }

    /**
     * 为新闻设置封面图片
     *
     * @param s
     * @return
     */
    public Map<String, Object> setNewsPicetur(String s,int id) {
        return cmsService.setNewsPicetur(s,id);
    }


    /**
     * 发布和修改资讯
     *
     * @param type
     * @param click
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
     * @param cz
     * @param id
     * @return
     */
    public Map<String, Object> createNews(String type, Integer click, Integer isShow, String title, String shortTitle, String keyword, Integer contentType, String link, String content, Integer sort, String summary, String label, String editor, Integer cz, String id,String picture) {
        return cmsService.createNews(type,click,isShow,title,shortTitle,keyword,contentType,link,content,sort,summary,label,editor,cz,id,picture);
    }

    public Map<String, Object> updateShow(Integer id,Integer type){
        return cmsService.updateShow(id,type);
    }


    /**
     * 新增实战二串一（一）
     *
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
    public Map<String, Object> createSZ2C11(String matchId1, String homeTeam1, String guestTeam1, String recommend1, String matchId2, String homeTeam2, String guestTeam2, String recommend2, Integer multiple, Double amount, String bonus, String author) {

        return sz2C1Service.createSZ2C11(matchId1,homeTeam1,guestTeam1,recommend1,matchId2,
                homeTeam2,guestTeam2,recommend2,multiple,amount,bonus,author);
    }

    /**
     * 新增实战二串一（二）
     *
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
    public Map<String, Object> createSZ2C12(String matchId1, String homeTeam1, String guestTeam1, String recommend1, String matchId2, String homeTeam2, String guestTeam2, String recommend2, Integer multiple, Double amount, String bonus, String author) {
        return sz2C1Service.createSZ2C12(matchId1,homeTeam1,guestTeam1,recommend1,matchId2,
                homeTeam2,guestTeam2,recommend2,multiple,amount,bonus,author);
    }

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
     * @param author
     * @return
     */
    public Map<String, Object> createDayOneDan1(String playType, String matchId, String homeTeam, String guestTeam, String recommend, Double sp, String analyze, String author) {
        return dayOneDanService.createDayOneDan1(playType,matchId,homeTeam,guestTeam,recommend,sp,analyze,author);
    }

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
     * @param author
     * @return
     */
    public Map<String, Object> createDayOneDan2(String playType, String matchId, String homeTeam, String guestTeam, String recommend, Double sp, String analyze, String author) {
        return dayOneDanService.createDayOneDan2(playType,matchId,homeTeam,guestTeam,recommend,sp,analyze,author);
    }
}
