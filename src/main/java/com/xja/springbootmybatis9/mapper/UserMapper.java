package com.xja.springbootmybatis9.mapper;

import com.xja.springbootmybatis9.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户接口
 */
public interface UserMapper {
    public List<User> findAll();

    public int getRecordCount();

    public List<User> search(
            @Param("from") Integer from, @Param("pageSize") Integer pageSize);

    public User getById(Integer id);

    public int add(User user);

    public int delete(int id);

    public int update(User user);
}
