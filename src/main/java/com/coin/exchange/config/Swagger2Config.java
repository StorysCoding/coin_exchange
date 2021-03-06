/**
 * @(#) Swagger2Config.java
 *
 * Copyright (c) 2018, Credan(上海)-版权所有
 */
package com.coin.exchange.config;

import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

/**
 *
 * @author storys.zhang@gmail.com
 *
 * Created at 2018/9/25 by Storys.Zhang in coin_exchange
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket petApi() {
        final ApiInfo apiInfo = new ApiInfo("rest API接口文档","desc", "v0.0.1", null,new Contact("", "", "'"), "license", "licenseUrl", Lists.newArrayList());
        return new Docket(DocumentationType.SWAGGER_2)
            .forCodeGeneration(true)
            .apiInfo(apiInfo)
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
            .paths(PathSelectors.any())
            .build()
            .pathMapping("/")
            .directModelSubstitute(LocalDate.class, String.class)
            .genericModelSubstitutes(ResponseEntity.class)
           // .alternateTypeRules(null)
            .useDefaultResponseMessages(false)
/*            .globalResponseMessage(
                RequestMethod.GET,
               Lists.newArrayList(new ResponseMessageBuilder().code(500).message("500 message")
                    .responseModel(new ModelRef("Error")).build()))*/
            ;
    }
}
