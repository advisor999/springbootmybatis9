package com.xja.springbootmybatis9.controller;

import com.xja.springbootmybatis9.domain.User;
import com.xja.springbootmybatis9.service.UserService;
import com.xja.springbootmybatis9.util.JsonUtils;
import com.xja.springbootmybatis9.util.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 本类使用代码实现redis作为MyBatis缓存
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Map<String,Object> params = new HashMap<>();

    @Autowired
    private UserService userService;

    @Autowired
    private RedisClient redis;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public RedisClient getRedis() {
        return redis;
    }

    public void setRedis(RedisClient redis) {
        this.redis = redis;
    }

    @RequestMapping("/by_id")
    @ResponseBody
    public Object queryById(Integer id){
        params.clear();
        User user = userService.getById(id);
        params.put("user",user);
        return params;
    }

    @RequestMapping("/add")
    public String add(User user){
        userService.add(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/list")
    public String list(ModelMap map){
        List<User> list = userService.queryAllUser();
        map.put("list",list);
        return "/user/list.html";
    }

    @RequestMapping("/pre_add")
    public String preAdd(){
        return "/user/add.html";
    }

    @RequestMapping(path = "/remove/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable Integer id ) {
        userService.remove(id);
        return "redirect:/user/list";
    }

}
