package com.xja.springbootmybatis9.controller;

import com.xja.springbootmybatis9.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * session使用Redis保存控制器
 */
@RestController
@RequestMapping("/rest/session")
public class RedisSessionController {
    @RequestMapping("/set")
    public Object setSession(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        // session操作和普通操作没有区别
        request.getSession().setAttribute("user",
                new User(1,"jiangtao","13456478963",new Date(),22));
        map.put("request URL:", request.getRequestURL());
        return map;
    }

    @RequestMapping("/get")
    public Object getSession(HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        User user =  (User) request.getSession().getAttribute("user");
        map.put("user", user);
        return map;
    }

}
