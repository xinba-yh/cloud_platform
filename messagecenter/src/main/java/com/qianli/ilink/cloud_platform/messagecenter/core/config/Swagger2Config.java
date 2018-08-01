package com.qianli.ilink.cloud_platform.messagecenter.core.config;


import com.qianli.ilink.cloud_platform.commons.core.util.SwaggerUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createSwagger2(){
        return SwaggerUtils.createSwagger2("com.qianli.ilink.cloud_platform.messagecenter.web");
    }

}
