package com.xja.springbootmybatis9;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@MapperScan("com.xja.springbootmybatis9.mapper")    // Mapper.xml文件路径
@EnableCaching    // 启用redis作为mybatis的缓存
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 300)    // 设置缓存时间,单位秒
@EnableScheduling   // 定时任务
public class Springbootmybatis9Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootmybatis9Application.class, args);
    }

}
