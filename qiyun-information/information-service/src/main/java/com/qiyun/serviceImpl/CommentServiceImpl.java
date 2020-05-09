package com.qiyun.serviceImpl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.mapper2.*;
import com.qiyun.model2.*;
import com.qiyun.service.CommentService;
import com.qiyun.type.WalletTransType;
import com.qiyun.util.Constants;
import com.qiyun.util.DateUtil;
import com.qiyun.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private LotteryPlanLikeMapper lotteryPlanLikeMapper;

    @Autowired
    private MemberAgentMapper memberAgentMapper;

    @Autowired
    private Member2Mapper member2Mapper;

    @Autowired
    private WinPromotionCommentMapper winPromotionCommentMapper;

    @Autowired
    private CommentLikeMapper commentLikeMapper;

    @Autowired
    private WinPromotionCommentLikeMapper winPromotionCommentLikeMapper;

    @Autowired
    private WinPromotionLikeMapper winPromotionLikeMapper;


    public Map<String, Object> getUnreviewedWinCommentList(int offset, int pageSize,int id,int type) {
        PageHelper.startPage(offset, pageSize);
        Map<String, Object> map = new HashMap<String, Object>();
        WinPromotionCommentExample commentExample = new WinPromotionCommentExample();
        commentExample.setOrderByClause("comment_time DESC");
        WinPromotionCommentExample.Criteria criteria = commentExample.createCriteria();
//        criteria.andStatusEqualTo(0);
        if(type!=-1){
            criteria.andStatusEqualTo(type);
        }
        if(id!=0){
            criteria.andPropagandaIdEqualTo(id);
        }
        List<WinPromotionComment> comments = winPromotionCommentMapper.selectByExampleWithBLOBs(commentExample);
        for (WinPromotionComment winPromotionComment:comments) {
            Date commentTime = winPromotionComment.getCommentTime();
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = format2.format(commentTime);
            winPromotionComment.setTime(format);
        }
        PageInfo pageInfo = new PageInfo(comments);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA,pageInfo);
        return map;
    }

    public Map<String, Object> shWinComment(String cid,Integer type) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (type==1){
            try {
                String[] split = cid.split(",");
                for (String str:split) {
                    WinPromotionComment comment = WinPromotionComment.builder().id(StringUtil.String2Integer(str)).status(1).build();
                    int i = winPromotionCommentMapper.updateByPrimaryKeySelective(comment);
                }
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                return map;
            }catch (Exception e){
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "审核失败");
                return map;
            }
        }else if(type == 2){
            try {
                String[] split = cid.split(",");
                for (String str:split) {
                    WinPromotionComment comment = WinPromotionComment.builder().id(StringUtil.String2Integer(str)).status(2).build();
                    int i = winPromotionCommentMapper.updateByPrimaryKeySelective(comment);
                }
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                return map;
            }catch (Exception e){
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "审核失败");
                return map;
            }
        }else {
            map.put(Constants.CODE, Constants.ERROR_CODE_626);
            map.put(Constants.MSG, Constants.ERROR_MSG_626);
            return map;
        }
    }

    public Map<String, Object> getUnreviewedCommentList(int offset, int pageSize,int id,int type) {
        PageHelper.startPage(offset, pageSize);
        Map<String, Object> map = new HashMap<String, Object>();
        CommentExample commentExample = new CommentExample();
        commentExample.setOrderByClause("comment_date DESC");
        CommentExample.Criteria criteria = commentExample.createCriteria();
//        criteria.andStatusEqualTo(0);
        if(type!=-1){
            criteria.andStatusEqualTo(type);
        }
        if(id!=0){
            criteria.andPlanNoEqualTo(id);
        }
        List<CommentWithBLOBs> comments = commentMapper.selectByExampleWithBLOBs(commentExample);
        for (CommentWithBLOBs winPromotionComment:comments) {
            Date commentTime = winPromotionComment.getCommentTime();
            Date replyTime = winPromotionComment.getReplyTime();
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if(replyTime!=null){
                String formatt = format2.format(replyTime);
                winPromotionComment.setRTime(formatt);
            }
            String format = format2.format(commentTime);
            winPromotionComment.setTime(format);
        }
        PageInfo pageInfo = new PageInfo(comments);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA,pageInfo);
        return map;
    }

    public Map<String, Object> shComment(String cid,Integer type) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (type==1){
            try {
                String[] split = cid.split(",");
                for (String str:split
                        ) {
                    CommentWithBLOBs comment = new CommentWithBLOBs();
                    comment.setId(StringUtil.String2Integer(str));  comment.setStatus(1);
                    commentMapper.updateByPrimaryKeySelective(comment);
                }
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                return map;
            }catch (Exception e){
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "审核失败");
                return map;
            }
        }else if(type == 2){
            try {
                String[] split = cid.split(",");
                for (String str:split
                        ) {
                    CommentWithBLOBs comment = new CommentWithBLOBs();
                    comment.setId(StringUtil.String2Integer(str));  comment.setStatus(2);
                    commentMapper.updateByPrimaryKeySelective(comment);
                }
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                return map;
            }catch (Exception e){
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "审核失败");
                return map;
            }
        }else {
            map.put(Constants.CODE, Constants.ERROR_CODE_626);
            map.put(Constants.MSG, Constants.ERROR_MSG_626);
            return map;
        }
    }

    public Map<String, Object> getPromotionCommentList(Integer planNo, String account, int offset, int pageSize, int sort) {
        PageHelper.startPage(offset, pageSize);
        Map<String, Object> map = new HashMap<String, Object>();
        List<WinPromotionComment>winPromotionComments = new ArrayList<WinPromotionComment>();
        if(sort==1){    //按时间排序
            winPromotionComments = winPromotionCommentMapper.getCommentListByTime(planNo, account);
        }else if(sort==2){  //按点赞数排序
            winPromotionComments = winPromotionCommentMapper.getCommentListByLike(planNo, account);
        }
        if(winPromotionComments==null||winPromotionComments.size()==0){
            map.put(Constants.CODE, Constants.ERROR_CODE_629);
            map.put(Constants.MSG, Constants.ERROR_MSG_629);
            return map;
        }else {
            for (WinPromotionComment commentWithBLOBs:winPromotionComments) {
                Date commentTime = commentWithBLOBs.getCommentTime();   //评论的时间
                String time = "";
                SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
                SimpleDateFormat sf2 = new SimpleDateFormat("昨天 HH:mm");
                SimpleDateFormat sf3 = new SimpleDateFormat("yyyy年MM月dd HH:mm");
                if(DateUtil.isToday4Num(commentTime,0)){ //如果评论时间是今天
                    time = sf.format(commentTime);
                }else if(DateUtil.isToday4Num(commentTime,-1)){
                    time = sf2.format(commentTime);
                }else {
                    time = sf3.format(commentTime);
                }
                commentWithBLOBs.setTime(time);
                WinPromotionCommentLikeExample commentLikeExample = new WinPromotionCommentLikeExample();
                commentLikeExample.createCriteria().andPlanIdEqualTo(planNo).andTypeEqualTo(1).andCommentFloorEqualTo(commentWithBLOBs.getFloor()).andLinkeAccountEqualTo(account);
                List<WinPromotionCommentLike> commentLikes = winPromotionCommentLikeMapper.selectByExample(commentLikeExample);
                if(commentLikes==null||commentLikes.size()==0){
                    commentWithBLOBs.setIsLike("nolike");
                }else{
                    commentWithBLOBs.setIsLike("like");
                }
            }
            PageInfo pageInfo = new PageInfo(winPromotionComments);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,pageInfo);
            return map;
        }
    }

    public Map<String, Object> likePromotionComment(Integer commentId,String account) {
        Map<String, Object> map = new HashMap<String, Object>();
        WinPromotionComment winPromotionComment = winPromotionCommentMapper.selectByPrimaryKey(commentId);
        Integer planNo = winPromotionComment.getPropagandaId();
        Integer floor = winPromotionComment.getFloor();
        WinPromotionCommentLikeExample winPromotionCommentLikeExample = new WinPromotionCommentLikeExample();
        winPromotionCommentLikeExample.createCriteria().andPlanIdEqualTo(planNo).andCommentFloorEqualTo(floor).andLinkeAccountEqualTo(account);
        List<WinPromotionCommentLike> commentLikes = winPromotionCommentLikeMapper.selectByExample(winPromotionCommentLikeExample);
        if(commentLikes==null||commentLikes.size()==0){ //没有点赞过此评论
            int i = winPromotionCommentMapper.likeComment(commentId);
            WinPromotionCommentLike commentLike = WinPromotionCommentLike.builder().commentFloor(floor).planId(planNo).linkeAccount(account).time(new Date()).type(1).build();
            int insert = winPromotionCommentLikeMapper.insert(commentLike);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, "点赞成功");
            return map;
        }else {
            if(commentLikes.get(0).getType()==1){   //点赞过，执行取消点赞
                WinPromotionCommentLike commentLike = WinPromotionCommentLike.builder().id(commentLikes.get(0).getId()).type(2).build();
                winPromotionCommentLikeMapper.updateByPrimaryKeySelective(commentLike);
                int i = winPromotionCommentMapper.nolikeComment(commentId);
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, "取消点赞成功");
                return map;
            }else if(commentLikes.get(0).getType()==2){
                WinPromotionCommentLike commentLike = WinPromotionCommentLike.builder().id(commentLikes.get(0).getId()).type(1).build();
                winPromotionCommentLikeMapper.updateByPrimaryKeySelective(commentLike);
                int i = winPromotionCommentMapper.likeComment(commentId);
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, "点赞成功");
                return map;
            }else {
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "点赞失败");
                return map;
            }
        }
    }

    public Map<String, Object> promotionComment(Integer planNo, String account, String connect) {
        Map<String, Object> map = new HashMap<String, Object>();
        MemberAgentExample memberAgentExample = new MemberAgentExample();
        memberAgentExample.createCriteria().andAccountEqualTo(account);
        List<MemberAgent> memberAgents = memberAgentMapper.selectByExample(memberAgentExample);
        Member2 member2 = member2Mapper.selectByAccount(account);
        if(member2.getType()==0&&memberAgents==null){
            //查询近一个月消费是否够200
            List<WalletTransType> consumeTypeList = WalletTransType.consumeTypeList;    //充值的状态码
            List<Integer> list = new ArrayList<Integer>();
            for (WalletTransType walletTransType : consumeTypeList) {
                list.add(walletTransType.getValue());
            }
            Integer consumptionCount = commentMapper.getConsumptionCount(account, list);
            if (consumptionCount == null || consumptionCount < 200) {   //没有消费记录，或者消费不足200
                map.put(Constants.CODE, Constants.ERROR_CODE_627);
                map.put(Constants.MSG, Constants.ERROR_MSG_627);
                return map;
            }
        }
        Integer floor = 1;
        Integer lc = winPromotionCommentMapper.getFloor(planNo);
        if (lc != null) {
            floor = lc + floor;
        }
        //查询评论人和发单人的头像
        String picture = member2.getPicture(); //评论人的头像
        String username = member2.getUsername();//评论人的Username
        WinPromotionComment winPromotionComment = WinPromotionComment.builder().propagandaId(planNo).account(account).username(username).picture(picture).commentTime(new Date()).status(0).connect(connect).likeCount(0).floor(floor).build();
        int insert = winPromotionCommentMapper.insert(winPromotionComment);
        if (insert == 1) {
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        } else {
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "评论失败，请联系管理员");
            return map;
        }
    }

    /**
     * 获取用户的未读消息个数
     * @param account
     * @return
     */
    public Map<String, Object> getUnread(String account) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            int unread = commentMapper.getUnread(account);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,unread);
            return map;
        }catch (Exception e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取未读消息失败");
            return map;
        }
    }

    public Map<String, Object> getLikeWIinCount(String account,Integer planNo){
        Map<String, Object> map = new HashMap<String, Object>();
        int i = winPromotionLikeMapper.likeCommentCount(planNo);
        if(i == 0){
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put("count",i);
            map.put("isLike","no");
            return map;
        }else {
            WinPromotionLikeExample lotteryPlanLikeExample = new WinPromotionLikeExample();
            lotteryPlanLikeExample.createCriteria().andPlanNoEqualTo(planNo).andStatusEqualTo(1).andAccountEqualTo(account);
            List<WinPromotionLike> lotteryPlanLikes = winPromotionLikeMapper.selectByExample(lotteryPlanLikeExample);
            if(lotteryPlanLikes==null||lotteryPlanLikes.size()==0){
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put("count",i);
                map.put("isLike","no");
                return map;
            }else{
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put("count",i);
                map.put("isLike","yes");
                return map;
            }
        }
    }

    public Map<String, Object> likeWinPromotion(String account, Integer planNo) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            WinPromotionLikeExample winPromotionLikeExample = new WinPromotionLikeExample();
            winPromotionLikeExample.createCriteria().andPlanNoEqualTo(planNo);
            List<WinPromotionLike> lotteryPlanLikes = winPromotionLikeMapper.selectByExample(winPromotionLikeExample);
            if(lotteryPlanLikes==null||lotteryPlanLikes.size()==0){
                WinPromotionLike lotteryPlanLike = WinPromotionLike.builder().status(1).account(account).planNo(planNo).likeTime(new Date()).build();
                int insert = winPromotionLikeMapper.insert(lotteryPlanLike);
                if(insert==1){
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, "点赞成功");
                    return map;
                }else{
                    map.put(Constants.CODE, Constants.ERROR_CODE_619);
                    map.put(Constants.MSG, "点赞失败");
                    return map;
                }
            }else{
                WinPromotionLikeExample lotteryPlanLikeExample1 = new WinPromotionLikeExample();
                lotteryPlanLikeExample1.createCriteria().andPlanNoEqualTo(planNo).andAccountEqualTo(account);
                List<WinPromotionLike> lotteryPlanLikes1 = winPromotionLikeMapper.selectByExample(lotteryPlanLikeExample1);
                if(lotteryPlanLikes1==null||lotteryPlanLikes1.size()==0){
                    WinPromotionLike lotteryPlanLike = WinPromotionLike.builder().status(1).account(account).planNo(planNo).likeTime(new Date()).build();
                    int insert = winPromotionLikeMapper.insert(lotteryPlanLike);
                    if(insert==1){
                        map.put(Constants.CODE, Constants.SUCCESS_CODE);
                        map.put(Constants.MSG, "点赞成功");
                        return map;
                    }else{
                        map.put(Constants.CODE, Constants.ERROR_CODE_619);
                        map.put(Constants.MSG, "点赞失败");
                        return map;
                    }
                }else{
                    if(lotteryPlanLikes1.get(0).getStatus()==1){   //点赞过，执行取消点赞
                        WinPromotionLike lotteryPlanLike = WinPromotionLike.builder().id(lotteryPlanLikes1.get(0).getId()).status(2).likeTime(new Date()).build();
                        int i = winPromotionLikeMapper.updateByPrimaryKeySelective(lotteryPlanLike);
                        map.put(Constants.CODE, Constants.SUCCESS_CODE);
                        map.put(Constants.MSG, "取消点赞成功");
                        return map;
                    }else if(lotteryPlanLikes1.get(0).getStatus()==2){
                        WinPromotionLike lotteryPlanLike = WinPromotionLike.builder().id(lotteryPlanLikes1.get(0).getId()).status(1).likeTime(new Date()).build();
                        int i = winPromotionLikeMapper.updateByPrimaryKeySelective(lotteryPlanLike);
                        map.put(Constants.CODE, Constants.SUCCESS_CODE);
                        map.put(Constants.MSG, "点赞成功");
                        return map;
                    }else {
                        map.put(Constants.CODE, Constants.ERROR_CODE_619);
                        map.put(Constants.MSG, "点赞失败");
                        return map;
                    }
                }
            }
        }catch (Exception e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "点赞失败");
            return map;
        }
    }

    public Map<String, Object> getLikePlanCount(String account,Integer planNo){
        Map<String, Object> map = new HashMap<String, Object>();
        int i = lotteryPlanLikeMapper.likeCommentCount(planNo);
        if(i == 0){
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put("count",i);
            map.put("isLike","no");
            return map;
        }else {
            LotteryPlanLikeExample lotteryPlanLikeExample = new LotteryPlanLikeExample();
            lotteryPlanLikeExample.createCriteria().andPlanNoEqualTo(planNo).andStatusEqualTo(1).andAccountEqualTo(account);
            List<LotteryPlanLike> lotteryPlanLikes = lotteryPlanLikeMapper.selectByExample(lotteryPlanLikeExample);
            if(lotteryPlanLikes==null||lotteryPlanLikes.size()==0){
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put("count",i);
                map.put("isLike","no");
                return map;
            }else{
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put("count",i);
                map.put("isLike","yes");
                return map;
            }
        }
    }

    public Map<String, Object> likeLotteryPlan(String account, Integer planNo) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            LotteryPlanLikeExample lotteryPlanLikeExample = new LotteryPlanLikeExample();
            lotteryPlanLikeExample.createCriteria().andPlanNoEqualTo(planNo);
            List<LotteryPlanLike> lotteryPlanLikes = lotteryPlanLikeMapper.selectByExample(lotteryPlanLikeExample);
            if(lotteryPlanLikes==null||lotteryPlanLikes.size()==0){
                LotteryPlanLike lotteryPlanLike = LotteryPlanLike.builder().status(1).account(account).planNo(planNo).likeTime(new Date()).build();
                int insert = lotteryPlanLikeMapper.insert(lotteryPlanLike);
                if(insert==1){
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, "点赞成功");
                    return map;
                }else{
                    map.put(Constants.CODE, Constants.ERROR_CODE_619);
                    map.put(Constants.MSG, "点赞失败");
                    return map;
                }
            }else{
                LotteryPlanLikeExample lotteryPlanLikeExample1 = new LotteryPlanLikeExample();
                lotteryPlanLikeExample1.createCriteria().andPlanNoEqualTo(planNo).andAccountEqualTo(account);
                List<LotteryPlanLike> lotteryPlanLikes1 = lotteryPlanLikeMapper.selectByExample(lotteryPlanLikeExample1);
                if(lotteryPlanLikes1==null||lotteryPlanLikes1.size()==0){
                    LotteryPlanLike lotteryPlanLike = LotteryPlanLike.builder().status(1).account(account).planNo(planNo).likeTime(new Date()).build();
                    int insert = lotteryPlanLikeMapper.insert(lotteryPlanLike);
                    if(insert==1){
                        map.put(Constants.CODE, Constants.SUCCESS_CODE);
                        map.put(Constants.MSG, "点赞成功");
                        return map;
                    }else{
                        map.put(Constants.CODE, Constants.ERROR_CODE_619);
                        map.put(Constants.MSG, "点赞失败");
                        return map;
                    }
                }else{
                    if(lotteryPlanLikes1.get(0).getStatus()==1){   //点赞过，执行取消点赞
                        LotteryPlanLike commentLike = LotteryPlanLike.builder().id(lotteryPlanLikes1.get(0).getId()).status(2).build();
                        lotteryPlanLikeMapper.updateByPrimaryKeySelective(commentLike);
                        map.put(Constants.CODE, Constants.SUCCESS_CODE);
                        map.put(Constants.MSG, "取消点赞成功");
                        return map;
                    }else if(lotteryPlanLikes1.get(0).getStatus()==2){
                        LotteryPlanLike commentLike = LotteryPlanLike.builder().id(lotteryPlanLikes1.get(0).getId()).status(1).build();
                        lotteryPlanLikeMapper.updateByPrimaryKeySelective(commentLike);
                        map.put(Constants.CODE, Constants.SUCCESS_CODE);
                        map.put(Constants.MSG, "点赞成功");
                        return map;
                    }else {
                        map.put(Constants.CODE, Constants.ERROR_CODE_619);
                        map.put(Constants.MSG, "点赞失败");
                        return map;
                    }
                    }
                }
        }catch (Exception e){
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "点赞失败");
            return map;
        }
    }


    /**
     * 对方案点赞和取消点赞
     * @param account
     * @return
     */
//    public Map<String, Object> likeLotteryPlan(String account, Integer planNo,int type) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        try {
//            LotteryPlanLikeExample lotteryPlanLikeExample = new LotteryPlanLikeExample();
//            lotteryPlanLikeExample.createCriteria().andPlanNoEqualTo(planNo);
//            List<LotteryPlanLike> lotteryPlanLikes = lotteryPlanLikeMapper.selectByExample(lotteryPlanLikeExample);
//            if(type==1){    //点赞
//                if(lotteryPlanLikes==null||lotteryPlanLikes.size()<1){//表中不存在点赞数据
//                    LotteryPlanLike lotteryPlanLike = LotteryPlanLike.builder().planNo(planNo).account(account).likeTime(new Date()).status(1).build();
//                    int insert = lotteryPlanLikeMapper.insert(lotteryPlanLike);
//                    if(insert==1){
//                        map.put(Constants.CODE, Constants.SUCCESS_CODE);
//                        map.put(Constants.MSG, Constants.SUCCESS_MSG);
//                        return map;
//                    }else{
//                        map.put(Constants.CODE, Constants.ERROR_CODE_619);
//                        map.put(Constants.MSG, "点赞失败");
//                        return map;
//                    }
//                }else { //表中有点赞数据，只改一下点赞状态
//                    LotteryPlanLike lotteryPlanLike = new LotteryPlanLike();
//                    lotteryPlanLike.setId(lotteryPlanLikes.get(0).getId());
//                    lotteryPlanLike.setStatus(1);
//                    lotteryPlanLikeMapper.updateByPrimaryKeySelective(lotteryPlanLike);
//                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
//                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
//                    return map;
//                }
//            }else if(type==2){  //取消点赞
//                LotteryPlanLike lotteryPlanLike = new LotteryPlanLike();
//                lotteryPlanLike.setId(lotteryPlanLikes.get(0).getId());
//                lotteryPlanLike.setStatus(2);
//                lotteryPlanLikeMapper.updateByPrimaryKeySelective(lotteryPlanLike);
//                map.put(Constants.CODE, Constants.SUCCESS_CODE);
//                map.put(Constants.MSG, Constants.SUCCESS_MSG);
//                return map;
//            }else {
//                map.put(Constants.CODE, Constants.ERROR_CODE_626);
//                map.put(Constants.MSG, Constants.ERROR_MSG_626);
//                return map;
//            }
//        }catch (Exception e){
//            map.put(Constants.CODE, Constants.ERROR_CODE_619);
//            map.put(Constants.MSG, "未知错误");
//            return map;
//        }
//    }

    public Map<String, Object> likeComment(Integer commentId,String account) {
        Map<String, Object> map = new HashMap<String, Object>();
        CommentWithBLOBs commentWithBLOBs = commentMapper.selectByPrimaryKey(commentId);
        Integer planNo = commentWithBLOBs.getPlanNo();
        Integer floor = commentWithBLOBs.getFloor();
        CommentLikeExample commentLikeExample = new CommentLikeExample();
        commentLikeExample.createCriteria().andPlanIdEqualTo(planNo).andCommentFloorEqualTo(floor).andLinkeAccountEqualTo(account);
        List<CommentLike> commentLikes = commentLikeMapper.selectByExample(commentLikeExample);
        if(commentLikes==null||commentLikes.size()==0){ //没有点赞过此评论
            int i = commentMapper.likeComment(commentId);
            CommentLike commentLike = CommentLike.builder().commentFloor(floor).planId(planNo).linkeAccount(account).time(new Date()).type(1).build();
            int insert = commentLikeMapper.insert(commentLike);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, "点赞成功");
            return map;
        }else {
            if(commentLikes.get(0).getType()==1){   //点赞过，执行取消点赞
                CommentLike commentLike = CommentLike.builder().id(commentLikes.get(0).getId()).type(2).build();
                commentLikeMapper.updateByPrimaryKeySelective(commentLike);
                int i = commentMapper.nolikeComment(commentId);
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, "取消点赞成功");
                return map;
            }else if(commentLikes.get(0).getType()==2){
                CommentLike commentLike = CommentLike.builder().id(commentLikes.get(0).getId()).type(1).build();
                commentLikeMapper.updateByPrimaryKeySelective(commentLike);
                int i = commentMapper.likeComment(commentId);
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, "点赞成功");
                return map;
            }else {
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "点赞失败");
                return map;
            }
        }
    }

    public Map<String, Object> replyComment(Integer commentId, String account, String connect) {
        Map<String, Object> map = new HashMap<String, Object>();
        CommentWithBLOBs commentWithBLOBs = commentMapper.selectByPrimaryKey(commentId);
        if(commentWithBLOBs==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_630);
            map.put(Constants.MSG, Constants.ERROR_MSG_630);
            return map;
        }
        if(!(commentWithBLOBs.getPlanAccount().equals(account))){
            map.put(Constants.CODE, Constants.ERROR_CODE_631);
            map.put(Constants.MSG, Constants.ERROR_MSG_631);
            return map;
        }
        if(commentWithBLOBs.getReply()!=null){
            map.put(Constants.CODE, Constants.ERROR_CODE_632);
            map.put(Constants.MSG, Constants.ERROR_MSG_632);
            return map;
        }
        CommentWithBLOBs commentWithBLOBs1 = new CommentWithBLOBs();
        commentWithBLOBs1.setId(commentId);
        commentWithBLOBs1.setReply(connect);
        commentWithBLOBs1.setReplyTime(new Date());
        int i = commentMapper.updateByPrimaryKeySelective(commentWithBLOBs1);
        if(i==1){
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        }else {
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "回复评论失败");
            return map;
        }
    }

    /**
     * 获取方案的评论列表
     * @param planNo
     * @param account
     * @return
     */
    public Map<String, Object> getCommentList(Integer planNo, String account,int offset, int pageSize,int sort) {
        PageHelper.startPage(offset, pageSize);
        Map<String, Object> map = new HashMap<String, Object>();
        List<CommentWithBLOBs> commentList = new ArrayList<CommentWithBLOBs>();
        if(sort==1){    //按时间排序
            commentList = commentMapper.getCommentListByTime(planNo, account);
        }else if(sort==2){  //按点赞数排序
            commentList = commentMapper.getCommentListByLike(planNo, account);
        }
        if(commentList==null||commentList.size()==0){
            map.put(Constants.CODE, Constants.ERROR_CODE_629);
            map.put(Constants.MSG, Constants.ERROR_MSG_629);
            return map;
        }else {
            //将获取的评论设为已读
            for (CommentWithBLOBs commentWithBLOBs:commentList) {
                CommentWithBLOBs commentWithBLOB = new CommentWithBLOBs();
                commentWithBLOB.setId(commentWithBLOBs.getId());
                commentWithBLOB.setIsRead(1);
                commentMapper.updateByPrimaryKeySelective(commentWithBLOB);
                Date commentTime = commentWithBLOBs.getCommentTime();   //评论的时间
                String time = "";
                SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
                SimpleDateFormat sf2 = new SimpleDateFormat("昨天 HH:mm");
                SimpleDateFormat sf3 = new SimpleDateFormat("yyyy年MM月dd HH:mm");
                if(DateUtil.isToday4Num(commentTime,0)){ //如果评论时间是今天
                    time = sf.format(commentTime);
                }else if(DateUtil.isToday4Num(commentTime,-1)){
                    time = sf2.format(commentTime);
                }else {
                    time = sf3.format(commentTime);
                }
                commentWithBLOBs.setTime(time);
                String rtime = "";
                Date replyTime = commentWithBLOBs.getReplyTime();//评论的时间
                if(replyTime!=null){
                    if(DateUtil.isToday4Num(replyTime ,0)){ //如果评论时间是今天
                        rtime = sf.format(commentTime);
                    }else if(DateUtil.isToday4Num(replyTime,-1)){
                        rtime = sf2.format(commentTime);
                    }else {
                        rtime = sf3.format(commentTime);
                    }
                    commentWithBLOBs.setRTime(rtime);
                }

                CommentLikeExample commentLikeExample = new CommentLikeExample();
                commentLikeExample.createCriteria().andPlanIdEqualTo(planNo).andTypeEqualTo(1).andCommentFloorEqualTo(commentWithBLOBs.getFloor()).andLinkeAccountEqualTo(account);
                List<CommentLike> commentLikes = commentLikeMapper.selectByExample(commentLikeExample);
                if(commentLikes==null||commentLikes.size()==0){
                    commentWithBLOBs.setIsLike("nolike");
                }else{
                    commentWithBLOBs.setIsLike("like");
                }
            }
            int count = commentMapper.getLikeCount(planNo);
            PageInfo pageInfo = new PageInfo(commentList);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA,pageInfo);
            map.put("Count",count);
            return map;
        }
    }

    /**
     * 发表评论
     * @param planNo
     * @param account
     * @param connect
     * @return
     */
    public Map<String, Object> comment(Integer planNo, String account, String connect) {
        Map<String, Object> map = new HashMap<String, Object>();
        //查询发单人的account
        String planAccount = commentMapper.getPlanAccount(planNo);
        if (planAccount == null) {
            map.put(Constants.CODE, Constants.ERROR_CODE_628);
            map.put(Constants.MSG, Constants.ERROR_MSG_628);
            return map;
        }
        MemberAgentExample memberAgentExample = new MemberAgentExample();
        memberAgentExample.createCriteria().andAccountEqualTo(account);
        List<MemberAgent> memberAgents = memberAgentMapper.selectByExample(memberAgentExample);
        Member2 member2 = member2Mapper.selectByAccount(account);
        if(member2.getType()==0&&memberAgents==null){
            //查询近一个月消费是否够200
            List<WalletTransType> consumeTypeList = WalletTransType.consumeTypeList;    //充值的状态码
            List<Integer> list = new ArrayList<Integer>();
            for (WalletTransType walletTransType : consumeTypeList) {
                list.add(walletTransType.getValue());
            }
            Integer consumptionCount = commentMapper.getConsumptionCount(account, list);
            if (consumptionCount == null || consumptionCount < 200) {   //没有消费记录，或者消费不足200
                map.put(Constants.CODE, Constants.ERROR_CODE_627);
                map.put(Constants.MSG, Constants.ERROR_MSG_627);
                return map;
            }
        }
        //查询楼层
//        synchronized(this)
//        {
        Integer floor = 1;
        Integer lc = commentMapper.getFloor(planNo);
        if (lc != null) {
            floor = lc + 1;
        }
        //查询评论人和发单人的头像
        String picture = commentMapper.getPicture(account); //评论人的头像
        String planPicture = commentMapper.getPicture(planAccount); //发单人的头像
        String username = member2.getUsername();//评论人的Username
        String planUserName = commentMapper.getUsernameByAccount(planAccount);//发单人的username
//        Comment comment = Comment.builder().planNo(planNo).planAccount(planAccount).planPicture(planPicture).account(account).picture(picture).c.build();
        CommentWithBLOBs commentWithBLOBs = new CommentWithBLOBs();
        commentWithBLOBs.setPlanNo(planNo);
        commentWithBLOBs.setPlanAccount(planAccount);
        commentWithBLOBs.setPlanPicture(planPicture);
        commentWithBLOBs.setAccount(account);
        commentWithBLOBs.setPicture(picture);
        commentWithBLOBs.setConnect(connect);
        commentWithBLOBs.setStatus(0);
        commentWithBLOBs.setFloor(floor);
        commentWithBLOBs.setCommentTime(new Date());
        commentWithBLOBs.setLikeCount(0);
        commentWithBLOBs.setUsername(username);
        commentWithBLOBs.setPlanUsername(planUserName);
        int insert = commentMapper.insert(commentWithBLOBs);
        if (insert == 1) {
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            return map;
        } else {
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "评论失败，请联系管理员");
            return map;
        }
//        }
    }


}
