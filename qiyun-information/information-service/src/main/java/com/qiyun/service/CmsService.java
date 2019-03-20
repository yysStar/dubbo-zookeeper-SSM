package com.qiyun.service;

import com.qiyun.common.Result;
import org.springframework.web.multipart.MultipartFile;


import java.util.Date;

import java.util.Map;

public interface CmsService {
    Result getNewsDetailById(String id);

    Result getLatestNews();

    Result getBasketBallAndFootBallNews();

    Result getNewsByTypeId(int typeId, int pageSize);

    Map<String, Object> setNewsPicetur(String s,int id);

    Map<String, Object> createNews(String type, Integer click, Integer isShow, String title, String shortTitle, String keyword, Integer contentType, String link, String content, Integer sort, String summary, String label, String editor, Integer cz, String id,String picture);

    Map<String, Object> updateShow(Integer id,Integer type);

    Map<String, Object> getNewsList(int offset, int pageSize,String type,String label,String startTime,String endTime,String title);

    Map<String, Object> getNew(int id);

    Map<String, Object> getTypes(int type);

    int addMail(String title,String content,int type,String target,String author,int status);

    Map<String, Object> getInformation();

}
