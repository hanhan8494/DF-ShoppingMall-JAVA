package com.itcast.mallweb.service;

import com.itcast.admin.dto.UserDTO;
import com.itcast.admin.entity.User;

import java.util.List;

public interface UserService {

    //新增用户
    void addUser(UserDTO userDTO);

    //查询单个用户
    User queryUser(Integer id);

    //查询全部用户
    List<User> queryUserAll();

    //批量删除用户
    void deleteUser(List<Integer> ids);

    //修改用户
    void amendUser(UserDTO userDTO);
}
