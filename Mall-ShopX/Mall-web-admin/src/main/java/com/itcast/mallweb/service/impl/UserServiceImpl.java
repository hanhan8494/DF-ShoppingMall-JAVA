package com.itcast.mallweb.service.impl;

import com.itcast.admin.dto.AdminDTO;
import com.itcast.admin.entity.Admin;

import com.itcast.constant.MessageConstant;
import com.itcast.exception.PasswordErrorException;
import com.itcast.mallweb.mapper.UserMapper;
import com.itcast.mallweb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import javax.security.auth.login.AccountNotFoundException;



@Service
@Slf4j
public class UserServiceImpl implements UserService {


}

