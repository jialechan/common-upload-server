package com.upload.controller;

import com.alibaba.fastjson.JSON;
import com.upload.model.UploadFileObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class UploadFileController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${host}")
    private String host;

    @Value("${basePath}")
    private String basePath;

    @Value("#{'${extList}'.split(',')}")
    private List<String> extList;

    @ResponseBody
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String uploadFile(UploadFileObject uploadFileObject) throws IOException {

        Date now = new Date();

        String dateStr = FastDateFormat.getInstance("yyyy/MM/dd").format(now);

        String dirPathStr = basePath + "/" + dateStr;

        File dir = new File(dirPathStr);

        if(!dir.isDirectory()) {
            dir.mkdirs();
        }

        String ext = FilenameUtils.getExtension(uploadFileObject.getFile().getOriginalFilename());

        if(!extList.contains(ext)) {
            return "{\"code\":-3, \"detail\":\"不支持的文件格式\"}";
        }

        String fileName = UUID.randomUUID().toString() + "." +  ext;

        File file = new File(dirPathStr + "/" + fileName);
        FileUtils.copyInputStreamToFile(uploadFileObject.getFile().getInputStream(), file);

        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("url", "/" + dateStr + "/" + fileName);
        result.put("host", host);

        return JSON.toJSONString(result);
    }

}
