package com.xja.springbootmybatis9.service;

import com.xja.springbootmybatis9.domain.User;

import java.util.List;

public interface UserService {
    public User add(User user);

    public List<User> queryAllUser();

    public User getById(Integer id);

    public int getRecordCount();

    public List<User> searchByPage(Integer from, Integer pageSize);

    public int remove(int id);

    public User update(User user);
}
