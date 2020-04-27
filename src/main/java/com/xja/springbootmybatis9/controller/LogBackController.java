package com.xja.springbootmybatis9.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/back/logback")
public class LogBackController{
	
	private Logger logger =
			LoggerFactory.getLogger(this.getClass());   //slf4j
	
	
	@GetMapping("/test_logger")
	public Object testLogger() {
		logger.debug("debug logger");
		logger.info("info logger");
		logger.warn("warn logger");
		logger.error("error logger");
		return null;
	}
}
