package com.itcast.mallweb.service.impl;

import com.itcast.admin.dto.AdminDTO;
import com.itcast.admin.dto.UserDTO;
import com.itcast.admin.entity.Admin;

import com.itcast.admin.entity.User;
import com.itcast.constant.MessageConstant;
import com.itcast.exception.PasswordErrorException;
import com.itcast.mallweb.mapper.UserMapper;
import com.itcast.mallweb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.security.auth.login.AccountNotFoundException;
import java.time.LocalDateTime;
import java.util.List;


@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    //新增用户
    public void addUser(UserDTO userDTO) {
        User build = User.builder()
                .createTime(LocalDateTime.now())
                .build();
        BeanUtils.copyProperties(userDTO, build);
        userMapper.addUser(build);
    }

    //查询单个用户
    public User queryUser(Integer id) {
        return userMapper.queryUser(id);
    }

    //查询全部用户
    public List<User> queryUserAll() {
        return userMapper.queryUserAll();
    }

    //批量删除用户
    public void deleteUser(List<Integer> ids) {
        userMapper.deleteUser(ids);
    }

    //修改用户
    public void amendUser(UserDTO userDTO) {
        userMapper.amendUser(userDTO);
    }


}

