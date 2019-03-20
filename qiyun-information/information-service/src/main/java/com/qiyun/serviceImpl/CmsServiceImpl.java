package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import com.qiyun.common.Result;
import com.qiyun.dto.CmsNews2DTO;
import com.qiyun.dto.CmsNews2WithBLOBsDTO;

import com.qiyun.httpUtil.RedisUtil;
import com.qiyun.mapper2.CmsNews2Mapper;
import com.qiyun.mapper2.NewsMapper;
import com.qiyun.model2.*;
import com.qiyun.model2.CmsNews2Query.Criteria;
import com.qiyun.service.CmsService;
import com.qiyun.util.Constants;
import com.qiyun.util.CopyUtils;
import com.qiyun.util.DateUtil;
import com.qiyun.util.StringUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;


import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class CmsServiceImpl implements CmsService {

    private static Logger logger = LoggerFactory.getLogger(CmsServiceImpl.class);

    @Resource
    private CmsNews2Mapper cmsNews2Mapper;

    @Autowired
    private NewsMapper newsMapper;


    @Test
    public void delHtml(){
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式
        String html = "<table width=98% align=center><tr><td width=8%>14</td><td width=15%>后卫</td><td width=77% style='text-align:left;'> T.R.普拉蒂</td></tr><tr><td width=8%>23</td><td width=15%>后卫</td><td width=77% style='text-align:left;'> 包华丝</td></tr><tr><td width=8%>21</td><td width=15%>后卫</td><td width=77% style='text-align:left;'> 夏坚斯</td></tr><tr><td width=8%>32</td><td width=15%>后卫</td><td width=77% style='text-align:left;'> 莎杜莉</td></tr><tr><td width=8%>25</td><td width=15%>前锋</td><td width=77% style='text-align:left;'> 居莉</td></tr><tr><td width=8%>2</td><td width=15%>前锋</td><td width=77% style='text-align:left;'> 马尔莎艾伦</td></tr><tr><td width=8%>34</td><td width=15%>中锋</td><td width=77% style='text-align:left;'> 基斯杜汤马士</td></tr></table>";
        String str2="";
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(html);
        html=m_html.replaceAll(" "); //过滤html标签
        System.out.println(html);
        String[] split = html.split("    ");
        for (String str:split
                ) {
            String replace = str.replace("  ", ",");
            str2 = str2+replace+";";
        }
        System.out.println(str2);

    }


    public Map<String, Object> getInformation() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            NewsExample newsExample = new NewsExample();
            NewsExample.Criteria criteria = newsExample.createCriteria();
            newsExample.setOrderByClause("create_date_time DESC");
            criteria.andIsShowEqualTo(1);
            PageHelper.startPage(1, 5);
            List<News> news = newsMapper.selectByExampleWithBLOBs(newsExample);
            if(news==null||news.size()==0){
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, "暂无新闻资讯");
                return map;
            }else {
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put(Constants.DATA, news);
                return map;
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "获取新闻资讯出错");
            return map;
        }

    }

    public Map<String, Object> getNew(int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        News aNew = newsMapper.getNew(id);
//        News aNew = newsMapper.selectByPrimaryKey(id);
        if(aNew==null){
            map.put(Constants.CODE, Constants.ERROR_CODE_626);
            map.put(Constants.MSG, Constants.ERROR_MSG_626);
            return map;
        }
        Integer click = aNew.getClick();
        Integer click2 = click + 1;
        aNew.setClick(click2);
        newsMapper.updateByPrimaryKeySelective(aNew);
        map.put(Constants.CODE, Constants.SUCCESS_CODE);
        map.put(Constants.MSG, Constants.SUCCESS_MSG);
        map.put(Constants.DATA, aNew);
        return map;
    }

    public Map<String, Object> getTypes(int type) {
        Map<String, Object> map = new HashMap<String, Object>();
        Jedis jedis = RedisUtil.getJedis();
        if (type == 1) {    //类别列表
            Boolean exists = jedis.exists("type"); //判断这个集合是否存在
            if (exists) {
                Set<String> type1 = jedis.smembers("type");
                jedis.close();
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put(Constants.DATA, type1);
                return map;
            } else {
                List<String> types = newsMapper.getTypes();
                for (String type1 : types) {
                    jedis.sadd("type", type1);
                }
                Set<String> type1 = jedis.smembers("type");
                jedis.close();
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put(Constants.DATA, type1);
                return map;
            }
        } else if (type == 2) {  //标签列表
            Boolean exists = jedis.exists("label"); //判断这个集合是否是第一次创建
            if (exists) {
                Set<String> labels = jedis.smembers("label");
                jedis.close();
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put(Constants.DATA, labels);
                return map;
            } else {
                List<String> labels = newsMapper.getLabels();
                for (String label2 : labels) {
                    for (String str : label2.split(",")) {
                        jedis.sadd("label", str);
                    }
                }
                Set<String> labels2 = jedis.smembers("label");
                jedis.close();
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                map.put(Constants.DATA, labels2);
                return map;
            }
        } else {
            map.put(Constants.CODE, Constants.ERROR_CODE_626);
            map.put(Constants.MSG, Constants.ERROR_MSG_626);
            return map;
        }
    }

    public Map<String, Object> getNewsList(int offset, int pageSize, String type, String label, String startTime, String endTime, String title) {
        PageHelper.startPage(offset, pageSize);
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<News> newsList = newsMapper.getNewsList(type, label, startTime, endTime, title);
            for (News ne:newsList) {
                Date createDateTime = ne.getCreateDateTime();
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timestamp = format2.format(createDateTime);
                ne.setCreateTime(timestamp);
            }
            PageInfo<News> newsPageInfo = new PageInfo<News>(newsList);
            map.put(Constants.CODE, Constants.SUCCESS_CODE);
            map.put(Constants.MSG, Constants.SUCCESS_MSG);
            map.put(Constants.DATA, newsPageInfo);
            return map;
        } catch (Exception e) {
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, Constants.ERROR_MSG_5_2);
            return map;
        }
    }

    public Map<String, Object> setNewsPicetur(String s, int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            News news1 = newsMapper.selectByPrimaryKey(id);
            if (news1 == null) {
                map.put(Constants.CODE, Constants.ERROR_CODE_633);
                map.put(Constants.MSG, Constants.ERROR_MSG_633);
                return map;
            } else {
                News news = News.builder().id(id).picture(s).build();
                int i = newsMapper.updateByPrimaryKeySelective(news);
                if (i == 1) {
                    map.put(Constants.CODE, Constants.SUCCESS_CODE);
                    map.put(Constants.MSG, Constants.SUCCESS_MSG);
                    return map;
                } else {
                    map.put(Constants.CODE, Constants.ERROR_CODE_619);
                    map.put(Constants.MSG, "图片设置失败");
                    return map;
                }
            }
        } catch (Exception e) {
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "图片设置失败");
            return map;
        }
    }

    public Map<String, Object> createNews(String type, Integer click, Integer isShow, String title, String shortTitle, String keyword, Integer contentType, String link, String content, Integer sort, String summary, String label, String editor, Integer cz, String id, String picture) {
        Map<String, Object> map = new HashMap<String, Object>();
        Jedis jedis = RedisUtil.getJedis();
        Date showDateTime = null;
        if (cz == 1) {
            News news = News.builder().picture(picture).type(type).click(click).createDateTime(new Date()).showDateTime(showDateTime).isShow(isShow).title(title).shortTitle(shortTitle).keyword(keyword).contentType(contentType).link(link).content(content).sort(sort).summary(summary).label(label).editor(editor).build();
            int insert = newsMapper.insertSelective(news);
            Boolean exists = jedis.exists("type"); //判断类型集合是否存在
            if (exists) {
                jedis.sadd("type", type);
            } else {
                List<String> types = newsMapper.getTypes();
                for (String type1 : types) {
                    jedis.sadd("type", type1);
                }
            }
            Boolean exists2 = jedis.exists("label"); //判断类型集合是否存在
            if (exists2) {
                for (String str : label.split(",")) {
                    jedis.sadd("label", str);
                }
            } else {
                List<String> labels = newsMapper.getLabels();
                for (String label2 : labels) {
                    for (String str : label2.split(",")) {
                        jedis.sadd("label", str);
                    }
                }
            }
            jedis.close();
            if (insert == 1) {
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);

                return map;
            } else {
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "发布资讯不成功");
                return map;
            }
        } else if (cz == 2) {
            News news2 = News.builder().picture(picture).id(StringUtil.String2Integer(id)).type(type).click(click).createDateTime(new Date()).showDateTime(showDateTime).isShow(isShow).title(title).shortTitle(shortTitle).keyword(keyword).contentType(contentType).link(link).content(content).sort(sort).summary(summary).label(label).editor(editor).build();
            int update = newsMapper.updateByPrimaryKeySelective(news2);
            Boolean exists = jedis.exists("type"); //判断类型集合是否存在
            if (exists) {
                jedis.sadd("type", type);
            } else {
                List<String> types = newsMapper.getTypes();
                for (String type1 : types) {
                    jedis.sadd("type", type1);
                }
            }
            Boolean exists2 = jedis.exists("label"); //判断类型集合是否存在
            if (exists2) {
                for (String str : label.split(",")) {
                    jedis.sadd("label", str);
                }
            } else {
                List<String> labels = newsMapper.getLabels();
                for (String label2 : labels) {
                    for (String str : label2.split(",")) {
                        jedis.sadd("label", str);
                    }
                }
            }
            jedis.close();
            if (update == 1) {
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                return map;
            } else {
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "修改资讯不成功");
                return map;
            }
        } else {
            map.put(Constants.CODE, Constants.ERROR_CODE_626);
            map.put(Constants.MSG, Constants.ERROR_MSG_626);
            return map;
        }


    }

    public Map<String, Object> updateShow(Integer id,Integer type){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            News news = News.builder().id(id).isShow(type).build();
            int i = newsMapper.updateByPrimaryKeySelective(news);
            if(i>0){
                map.put(Constants.CODE, Constants.SUCCESS_CODE);
                map.put(Constants.MSG, Constants.SUCCESS_MSG);
                return map;
            }else {
                map.put(Constants.CODE, Constants.ERROR_CODE_619);
                map.put(Constants.MSG, "更改资讯状态失败");
                return map;
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put(Constants.CODE, Constants.ERROR_CODE_619);
            map.put(Constants.MSG, "更改资讯状态失败");
            return map;
        }

    }

    public Result getNewsDetailById(String id) {

        try {
            Result result = new Result();

            CmsNews2Query cmsNews2Query = new CmsNews2Query();
            Criteria criteria = cmsNews2Query.createCriteria();
            criteria.andIdEqualTo(Integer.parseInt(id));
            List<CmsNews2> cmsNews2s = cmsNews2Mapper.selectByExample(cmsNews2Query);
            List<CmsNews2WithBLOBs> cmsNews2WithBLOBs = cmsNews2Mapper.selectByExampleWithBLOBs(cmsNews2Query);
            if (cmsNews2s == null || cmsNews2WithBLOBs == null) {
                result.setSuccess(true);
                return result;
            }
            if (cmsNews2s != null && cmsNews2s.size() == 1) {
                CmsNews2DTO cmsNews2DTO = new CmsNews2DTO();
                CopyUtils.Copy(cmsNews2DTO, cmsNews2s.get(0), true);
                result.setData(cmsNews2DTO);
            }
            if (cmsNews2WithBLOBs != null && cmsNews2WithBLOBs.size() == 1) {
                CmsNews2WithBLOBsDTO cmsNews2WithBLOBsDTO = new CmsNews2WithBLOBsDTO();
                CopyUtils.Copy(cmsNews2WithBLOBsDTO, cmsNews2WithBLOBs.get(0), true);
                result.setContent(cmsNews2WithBLOBsDTO);
            }
            result.setSuccess(true);
            return result;
        } catch (Exception e) {

            logger.error("获取资讯详情出错", e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("获取资讯详情出错");
            return result;
        }
    }

    public Result getLatestNews() {
        try {
            Result result = new Result();

            CmsNews2Query cmsNews2Query = new CmsNews2Query();
            Criteria criteria = cmsNews2Query.createCriteria();
            criteria.andTypeIdEqualTo(1);
            cmsNews2Query.setOrderByClause("create_date_time DESC");
            PageHelper.startPage(1, 6);
            List<CmsNews2> cmsNews2s = cmsNews2Mapper.selectByExample(cmsNews2Query);

            List<CmsNews2DTO> cmsNews2DTOs = new ArrayList<CmsNews2DTO>();
            if (cmsNews2s == null) {
                result.setSuccess(true);
                return result;
            }
            for (CmsNews2 cmsNews2 : cmsNews2s) {
                CmsNews2DTO cmsNews2DTO = new CmsNews2DTO();
                CopyUtils.Copy(cmsNews2DTO, cmsNews2, true);
                cmsNews2DTOs.add(cmsNews2DTO);
            }

            result.setData(cmsNews2DTOs);
            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            logger.error("获取最新公告出错", e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("获取最新公告出错");
            return result;
        }
    }

    public Result getBasketBallAndFootBallNews() {
        try {
            Result result = new Result();

            //篮球
            CmsNews2Query cmsNews2Query = new CmsNews2Query();
            Criteria criteria = cmsNews2Query.createCriteria();
            criteria.andTypeIdEqualTo(10002332);
            cmsNews2Query.setOrderByClause("create_date_time DESC");
            PageHelper.startPage(1, 2);
            List<CmsNews2WithBLOBs> cmsNews2WithBLOBs = cmsNews2Mapper.selectByExampleWithBLOBs(cmsNews2Query);

            if (cmsNews2WithBLOBs == null) {
                result.setSuccess(true);
                return result;
            }

            List<CmsNews2WithBLOBsDTO> cmsNews2WithBLOBsDTOS = new ArrayList<CmsNews2WithBLOBsDTO>();
            for (CmsNews2WithBLOBs cmsNews2WithBLOB : cmsNews2WithBLOBs) {
                CmsNews2WithBLOBsDTO cmsNews2WithBLOBsDTO = new CmsNews2WithBLOBsDTO();
                cmsNews2WithBLOBsDTO.setId(cmsNews2WithBLOB.getId());
                cmsNews2WithBLOBsDTO.setTypeId(cmsNews2WithBLOB.getTypeId());
                cmsNews2WithBLOBsDTO.setTitle(cmsNews2WithBLOB.getTitle());
                cmsNews2WithBLOBsDTO.setShortTitle(cmsNews2WithBLOB.getShortTitle());
                cmsNews2WithBLOBsDTO.setHtmlDescription(cmsNews2WithBLOB.getHtmlDescription());
                cmsNews2WithBLOBsDTO.setKeyword(cmsNews2WithBLOB.getKeyword());
                cmsNews2WithBLOBsDTO.setEditor(cmsNews2WithBLOB.getEditor());
                cmsNews2WithBLOBsDTO.setIsHead(cmsNews2WithBLOB.getIsHead());
                cmsNews2WithBLOBsDTO.setStatus(cmsNews2WithBLOB.getStatus());
                cmsNews2WithBLOBsDTO.setIsFirstHead(cmsNews2WithBLOB.getIsFirstHead());
                cmsNews2WithBLOBsDTO.setCreateDateTime(cmsNews2WithBLOB.getCreateDateTime());
                cmsNews2WithBLOBsDTO.setHtmlKeyword(cmsNews2WithBLOB.getHtmlKeyword());
                cmsNews2WithBLOBsDTO.setNewsSource(cmsNews2WithBLOB.getNewsSource());
                cmsNews2WithBLOBsDTO.setShowDateTime(cmsNews2WithBLOB.getShowDateTime());
                cmsNews2WithBLOBsDTO.setHotspotTitle(cmsNews2WithBLOB.getHotspotTitle());
                cmsNews2WithBLOBsDTO.setContent(cmsNews2WithBLOB.getContent());
                cmsNews2WithBLOBsDTO.setCommendContent(cmsNews2WithBLOB.getCommendContent());
                cmsNews2WithBLOBsDTO.setClick(cmsNews2WithBLOB.getClick());
                cmsNews2WithBLOBsDTO.setContentType(cmsNews2WithBLOB.getContentType());
                cmsNews2WithBLOBsDTO.setProvince(cmsNews2WithBLOB.getProvince());
                cmsNews2WithBLOBsDTO.setLotteryType(cmsNews2WithBLOB.getLotteryType());
                cmsNews2WithBLOBsDTO.setColor(cmsNews2WithBLOB.getColor());
                cmsNews2WithBLOBsDTO.setDigs(cmsNews2WithBLOB.getDigs());
                cmsNews2WithBLOBsDTO.setUndigs(cmsNews2WithBLOB.getUndigs());
                cmsNews2WithBLOBsDTO.setIsShow(cmsNews2WithBLOB.getIsShow());

                cmsNews2WithBLOBsDTOS.add(cmsNews2WithBLOBsDTO);
            }

            //足球
            CmsNews2Query cmsNews2Query2 = new CmsNews2Query();
            Criteria criteria2 = cmsNews2Query2.createCriteria();
            criteria2.andTypeIdEqualTo(88);
            cmsNews2Query2.setOrderByClause("create_date_time DESC");
            PageHelper.startPage(1, 3);
            List<CmsNews2WithBLOBs> cmsNews2WithBLOBs2 = cmsNews2Mapper.selectByExampleWithBLOBs(cmsNews2Query2);

            for (CmsNews2WithBLOBs cmsNews2WithBLOB : cmsNews2WithBLOBs2) {
                CmsNews2WithBLOBsDTO cmsNews2WithBLOBsDTO = new CmsNews2WithBLOBsDTO();
                cmsNews2WithBLOBsDTO.setId(cmsNews2WithBLOB.getId());
                cmsNews2WithBLOBsDTO.setTypeId(cmsNews2WithBLOB.getTypeId());
                cmsNews2WithBLOBsDTO.setTitle(cmsNews2WithBLOB.getTitle());
                cmsNews2WithBLOBsDTO.setShortTitle(cmsNews2WithBLOB.getShortTitle());
                cmsNews2WithBLOBsDTO.setHtmlDescription(cmsNews2WithBLOB.getHtmlDescription());
                cmsNews2WithBLOBsDTO.setKeyword(cmsNews2WithBLOB.getKeyword());
                cmsNews2WithBLOBsDTO.setEditor(cmsNews2WithBLOB.getEditor());
                cmsNews2WithBLOBsDTO.setIsHead(cmsNews2WithBLOB.getIsHead());
                cmsNews2WithBLOBsDTO.setStatus(cmsNews2WithBLOB.getStatus());
                cmsNews2WithBLOBsDTO.setIsFirstHead(cmsNews2WithBLOB.getIsFirstHead());
                cmsNews2WithBLOBsDTO.setCreateDateTime(cmsNews2WithBLOB.getCreateDateTime());
                cmsNews2WithBLOBsDTO.setHtmlKeyword(cmsNews2WithBLOB.getHtmlKeyword());
                cmsNews2WithBLOBsDTO.setNewsSource(cmsNews2WithBLOB.getNewsSource());
                cmsNews2WithBLOBsDTO.setShowDateTime(cmsNews2WithBLOB.getShowDateTime());
                cmsNews2WithBLOBsDTO.setHotspotTitle(cmsNews2WithBLOB.getHotspotTitle());
                cmsNews2WithBLOBsDTO.setContent(cmsNews2WithBLOB.getContent());
                cmsNews2WithBLOBsDTO.setCommendContent(cmsNews2WithBLOB.getCommendContent());
                cmsNews2WithBLOBsDTOS.add(cmsNews2WithBLOBsDTO);
            }

            result.setData(cmsNews2WithBLOBsDTOS);
            result.setSuccess(true);
            return result;
        } catch (Exception e) {
            logger.error("获取足球篮球资讯出错", e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("获取足球篮球资讯出错");
            return result;
        }
    }

    public Result getNewsByTypeId(int typeId, int pageSize) {
        try {
            Result result = new Result();
            CmsNews2Query cmsNews2Query = new CmsNews2Query();
            Criteria criteria = cmsNews2Query.createCriteria();
            criteria.andTypeIdEqualTo(typeId);
            PageHelper.startPage(1, pageSize);
            cmsNews2Query.setOrderByClause("create_date_time DESC");
            List<CmsNews2> cmsNews2s = cmsNews2Mapper.selectByExample(cmsNews2Query);
            List<CmsNews2DTO> cmsNews2DTOs = new ArrayList<CmsNews2DTO>();
            if (cmsNews2s != null && cmsNews2s.size() > 0) {
                for (CmsNews2 cmsNews2 : cmsNews2s) {
                    CmsNews2DTO cmsNews2DTO = new CmsNews2DTO();
                    CopyUtils.Copy(cmsNews2DTO, cmsNews2, true);
                    cmsNews2DTOs.add(cmsNews2DTO);
                }
            }
            result.setData(cmsNews2DTOs);
            return result;
        } catch (Exception e) {
            logger.error("根据typeId获取资讯出错", e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("根据typeId获取资讯出错");
            return result;
        }
    }

    public int addMail(String title, String content, int type, String target, String author, int status) {
        Map<String, Object> map = new HashMap<String, Object>();
        Date date = new Date();
        map.put("title", title);
        map.put("content", content);
        map.put("type", type);
        map.put("target", target);
        map.put("author", author);
        map.put("status", status);
        map.put("create_date", date);
        return cmsNews2Mapper.addMail(map);
    }



}
