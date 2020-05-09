package com.qiyun.controller;

import com.qiyun.api.TicketApi;
import com.qiyun.api.TicketNotifyApi;
import com.qiyun.controller.base.BaseController;
import com.qiyun.model.TicketNotify;
import com.qiyun.tools.TicketTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ticket")
public class TicketNotifyController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(TicketNotifyController.class);

    @Resource
    private TicketNotifyApi ticketNotifyApi;

    @RequestMapping(path = "/ticketNotify", method = RequestMethod.POST)
    public void getTicketNotify() throws IOException {
        Map<String,Object> map = new HashMap<String, Object>();
        StringBuffer respStr = new StringBuffer();
        if(super.isGzipSupport(request)){
            InputStream in = request.getInputStream();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new GZIPInputStream(in), "GBK"));
            String line = null;
            while ((line = br.readLine()) != null) {
                respStr.append(line);
            }
        }
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Content-Encoding", "gzip");
        response.setContentType("text/html;charset=GBK");
        OutputStream os = response.getOutputStream();
        GZIPOutputStream gs = new GZIPOutputStream(os);
        String req = respStr.toString();
        String[] s = req.split("=");
        int wAction = Integer.parseInt(s[1].substring(0,s[1].indexOf("&")));
        String wMessage = s[2];
        String str = "";
        if (wAction == -100 || wMessage == null) {
            str = "入参有误，wAction=" + null + ",wMessage=" + wMessage;
            gs.write(str.getBytes("GBK"));// 解决中文乱码问题
            gs.finish();
            gs.close();
            os.close();
        }
        Map<String,Object> reqMap = new HashMap<String, Object>();
        switch (wAction){
            case TicketTools.matchResultNotify:
                reqMap.put("wMessage",wMessage);
                break;
            case TicketTools.matchTicketNotify:
                reqMap.put("wMessage", wMessage);
                map = ticketNotifyApi.matchTicketNotify(reqMap);
                break;
        }
        str = "wAction=575&wMessage=" + map.get("res");
        gs.write(str.getBytes("GBK"));// 解决中文乱码问题
        gs.finish();
        gs.close();
        os.close();
    }

}
