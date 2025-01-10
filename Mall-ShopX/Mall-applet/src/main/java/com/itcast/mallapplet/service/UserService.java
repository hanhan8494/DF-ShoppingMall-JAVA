package com.itcast.mallapplet.service;

import com.itcast.admin.entity.User;
import com.itcast.applet.dto.UserLoginDTO;

public interface UserService {

    //微信登录
    User wxLogin(UserLoginDTO userLoginDTO);
}
