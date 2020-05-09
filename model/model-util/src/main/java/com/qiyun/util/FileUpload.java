package com.qiyun.util;

import com.aliyun.oss.OSSClient;
import com.qiyun.tools.DateTools;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileUpload {
    public  static  String upLoad(MultipartFile file,String folder){
//初始化OSSClient
        OSSClient ossClient = AliyunOSSClientUtil.getOSSClient();
        //这个myfile是MultipartFile的
        CommonsMultipartFile file1 =(CommonsMultipartFile)file;
        DiskFileItem fi = (DiskFileItem) file1.getFileItem();
        File files = fi.getStoreLocation();
        String fileName = fi.getName();

        int lastIndexOf = fileName.lastIndexOf(".");
        String houzhui = fileName.substring(lastIndexOf);
        String imgFileName = DateTools.getNowDateYYYYMMDDHHMMSSSS();
        String s = AliyunOSSClientUtil.uploadObject2OSS(ossClient, files, imgFileName + houzhui, OSSClientConstants.BACKET_NAME, folder);
        System.out.println(s);
        return imgFileName+houzhui;
    }
    //删除图片
    public  static Map delPic(String  fileName){
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            OSSClient ossClient = AliyunOSSClientUtil.getOSSClient();
            AliyunOSSClientUtil.deleteFile(ossClient, OSSClientConstants.BACKET_NAME, OSSClientConstants.FOLDER, fileName);
        }catch (Exception ex){
            map.put(Constants.ERROR_MSG_400, "400");
            map.put(Constants.SUCCESS_MSG,"删除失败");
            return map;
        }
        return null;
    }
}
