package com.fenbi.mvctest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

//@RestController注解能够使项目支持Rest
@RestController
@SpringBootApplication
//表示该controller类下所有的方法都公用的一级上下文根
@RequestMapping(value = "/springboot")
public class UserController {
	private static final Logger logger =LoggerFactory.getLogger(UserController.class);
	@RequestMapping("hello") 
	public String hello() throws JsonProcessingException { 
		logger.info("hello world"); 
		return "hello world"; 
		}

}

