package com.primeton.chengjianyun.demo.config;

import com.primeton.chengjianyun.demo.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 登录拦截
 * @author cjy
 * @date 2018/11/5 10:34
 */
public class WebConfig implements WebMvcConfigurer {

    /**
     * 用于登录拦截页面
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new MyInterceptor());
        registration.addPathPatterns("/api/users/**");
        registration.addPathPatterns("/api/users/**");
        registration.excludePathPatterns("/api/users/actions/login");
    }
}
