package com.itcast.mallweb.controller;


import com.itcast.admin.dto.AdminDTO;
import com.itcast.admin.entity.Admin;
import com.itcast.admin.vo.AdminLoginVO;
import com.itcast.mallweb.service.UserService;
import com.itcast.result.Result;
import com.itcast.constant.JwtClaimsConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.itcast.utils.JwtUtil;
import com.itcast.properties.JwtProperties;

import javax.security.auth.login.AccountNotFoundException;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/admin")
@Slf4j
@Api(tags = "web-用户相关接口")
public class UserController {









}
