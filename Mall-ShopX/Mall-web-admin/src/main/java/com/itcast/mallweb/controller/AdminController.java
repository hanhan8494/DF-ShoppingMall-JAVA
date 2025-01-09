package com.itcast.mallweb.controller;


import com.itcast.admin.dto.AdminDTO;
import com.itcast.admin.entity.Admin;
import com.itcast.admin.vo.AdminLoginVO;
import com.itcast.constant.JwtClaimsConstant;
import com.itcast.mallweb.service.AdminService;
import com.itcast.properties.JwtProperties;
import com.itcast.result.Result;
import com.itcast.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@Slf4j
@Api(tags = "web-管理员相关接口")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtProperties jwtProperties;


    @PostMapping("/login")
    @ApiOperation("管理员登录")
    public Result<AdminLoginVO> login(@RequestBody AdminDTO adminDTO) throws AccountNotFoundException {
        log.info("管理员登录信息：{}", adminDTO);
        Admin admin = adminService.login(adminDTO);
        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.ADMIN_ID, admin.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        AdminLoginVO employeeLoginVO = AdminLoginVO.builder()
                .id(admin.getId())
                .adminName(admin.getAdminName())
                .account(admin.getAccount())
                .password(admin.getPassword())
                .token(token)
                .build();

        return Result.success(employeeLoginVO);
    }

    @PostMapping("/add")
    @ApiOperation("新增管理员")
    public Result addAdmin(@RequestBody Admin admin) {
        log.info("新增管理员的信息为：{}", admin);
        adminService.addAdmin(admin);
        return Result.success();
    }

    @PostMapping("/detele")
    @ApiOperation("删除管理员")
    public Result deteleAdmin(@RequestBody List<Long> ids) {
        log.info("批量删除管理员的id为：{}", ids);
        adminService.deteleAdmin(ids);
        return Result.success();
    }

    @GetMapping("/query")
    @ApiOperation("查询单个管理员")
    public Result<Admin> getById(@RequestParam Long id) {
        log.info("管理员的id为：{}", id);
        Admin admin = adminService.getById(id);
        return Result.success(admin);
    }

    @GetMapping("/queryAll")
    @ApiOperation("查询全部管理员")
    public Result<List<Admin>> getAdmin() {
        log.info("查询全部管理员");
        List<Admin> admin = adminService.getAdmin();
        return Result.success(admin);
    }









}
