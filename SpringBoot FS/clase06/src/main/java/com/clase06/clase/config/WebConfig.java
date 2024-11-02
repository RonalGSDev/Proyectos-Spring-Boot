package com.clase06.clase.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.clase06.clase.Interceptor.MyInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }
}
