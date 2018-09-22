package com.fenbi.mvctest.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration 
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter { 
	/**
}
     * 配置静态资源
     */ 
	public void addResourceHandlers(ResourceHandlerRegistry registry) { 
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/"); 
		super.addResourceHandlers(registry); 
		} 
	public void addInterceptors(InterceptorRegistry registry) {
		//addPathPatterns 用于添加拦截规则 
		//excludePathPatterns 用于排除拦截 
//		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**") 
//		.excludePathPatterns("/admin/login.do")
//		.excludePathPatterns("/admin/logout.do"); 
//		registry.addInterceptor(new FunctionInterceptor()).addPathPatterns("/**") 
//		.excludePathPatterns("/admin/login.do")
//		.excludePathPatterns("/admin/logout.do"); 
		super.addInterceptors(registry); 
		} 
	}
	

