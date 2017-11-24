package com.upload.model;

import com.alibaba.fastjson.JSON;
import org.springframework.web.multipart.MultipartFile;

public class UploadFileObject {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
