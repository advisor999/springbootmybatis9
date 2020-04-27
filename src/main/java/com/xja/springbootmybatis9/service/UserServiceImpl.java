package com.xja.springbootmybatis9.service;


import com.xja.springbootmybatis9.domain.User;
import com.xja.springbootmybatis9.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    @CachePut(value = "user_details", key = "#user.id")
    public User add(User user) {
        userMapper.add(user);  // MyBatis修改了insert返回主键
        System.out.println(user);
        return user;
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.findAll();
    }

    @Override
    @Cacheable(value = "user_details", key = "#id")
    public User getById(Integer id) {
        System.out.println("UserServiceImpl.getById:"+id);
        return userMapper.getById(id);
    }

    @Override
    public int getRecordCount() {
        return userMapper.getRecordCount();
    }

    @Override
    public List<User> searchByPage(Integer from, Integer pageSize) {
        return userMapper.search(from, pageSize);
    }

    @Override
    @CacheEvict(value = "user_details", key = "#id")
    public int remove(int id) {
        return userMapper.delete(id);
    }

    @Override
    @CachePut(value = "user_details", key = "#user.id")
    public User update(User user) {
        if(userMapper.update(user)>0){
            user = userMapper.getById(user.getId());
            return user;
        }
        return null;
    }


}
