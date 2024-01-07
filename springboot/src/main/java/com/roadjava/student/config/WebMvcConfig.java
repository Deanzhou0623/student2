package com.roadjava.student.config;/*
 *ClassName:WebMvcConfig
 *Description: define web mvc config
 *@Author:deanzhou
 *@Date:2024-01-06 22:48
 */

import com.roadjava.student.interceptor.AuthrizationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Resource
    private AuthrizationProperties authrizationProperties;

    @Bean
    public AuthrizationInterceptor authrizationInterceptor(){
        return new AuthrizationInterceptor();
    }

    /**
     * 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authrizationInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(authrizationProperties.getIgnoreUrls());
    }

    /**
     * 配置允许跨域
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                // options,get
                .allowedMethods("*")
                .maxAge(3600);
    }
    
}
