package com.qianli.ilink.cloud_platform.commons.core.config;

import com.qianli.ilink.cloud_platform.commons.core.util.SwaggerUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Config {

    @Bean
    public Docket createSwagger2(){
        return SwaggerUtils.createSwagger2("com.qianli.ilink.cloud_platform.commons.web");
    }
}
