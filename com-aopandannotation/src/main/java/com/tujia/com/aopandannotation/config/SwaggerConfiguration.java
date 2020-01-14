package com.tujia.com.aopandannotation.config;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.collect.Lists;
import com.tujia.com.aopandannotation.ComAopandannotationApplication;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.UnsupportedEncodingException;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

/**
 * @author zhouheng-os
 * @Date 2019/10/15
 * @Description swagger配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Autowired
    private Environment env;

    @Autowired
    private TypeResolver typeResolver;

    @Bean
    public Docket test_api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("test_api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tujia.com.aopandannotation.controller.test"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .genericModelSubstitutes(ResponseEntity.class)
                .alternateTypeRules(newRule(typeResolver.resolve(DeferredResult.class, typeResolver.resolve(ResponseEntity.class, WildcardType.class)), typeResolver.resolve(WildcardType.class)))
//                .enableUrlTemplating(true)
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
//                .host("")
                .apiInfo(apiInfo("test_api","文档中可以查询及测试接口调用参数和结果","4.4"));
//                .securitySchemes(Lists.newArrayList(apiKey()))
//                .securityContexts(Lists.newArrayList(securityContext()));
    }

    @Bean
    public Docket h5_api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("h5-api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tujia.com.aopandannotation.controller.h5"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .genericModelSubstitutes(ResponseEntity.class)
                .alternateTypeRules(newRule(typeResolver.resolve(DeferredResult.class, typeResolver.resolve(ResponseEntity.class, WildcardType.class)), typeResolver.resolve(WildcardType.class)))
//                .enableUrlTemplating(true)
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .host("127.0.0.3")
                .apiInfo(apiInfo("h5_api","文档中可以查询及测试接口调用参数和结果","4.4"));
//                .securitySchemes(Lists.newArrayList(apiKey()))
//                .securityContexts(Lists.newArrayList(securityContext()));
    }

    private ApiInfo apiInfo(String title,String description,String version){
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .build();

    }
}
