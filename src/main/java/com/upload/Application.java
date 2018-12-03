package com.upload;

import com.upload.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(WebConfig.class)
public class Application {

//    @Value("${maxPostSize}")
//    private Integer maxPostSize;
//
//    @Value("${maxSavePostSize}")
//    private Integer maxSavePostSize;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}