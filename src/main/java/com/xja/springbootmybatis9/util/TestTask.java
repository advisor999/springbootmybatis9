package com.xja.springbootmybatis9.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Component
public class TestTask {
	@Scheduled(cron="*/5 * * * * ?")
	public void sum() {
		System.out.println("当前时间："+new Date());
	}
}
