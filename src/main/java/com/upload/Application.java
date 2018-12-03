package com.upload;

import com.upload.config.WebConfig;
import org.apache.coyote.AbstractProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(WebConfig.class)
public class Application {

    @Value("${maxPostSize}")
    private Integer maxPostSize;

    @Value("${maxSavePostSize}")
    private Integer maxSavePostSize;

    @Bean
    public EmbeddedServletContainerFactory servletContainerFactory() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();

        factory.addConnectorCustomizers(connector -> {
                ((AbstractProtocol) connector.getProtocolHandler()).setConnectionTimeout(120000);
//                // 设置最大上传100M
//                connector.setMaxPostSize(maxPostSize);
//                connector.setMaxSavePostSize(maxSavePostSize);
        });

        // configure some more properties

        return factory;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}