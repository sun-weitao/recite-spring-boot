package com.sun.recite.interceptor;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootConfiguration
public class MWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ValidInterceptor());
    }
}
