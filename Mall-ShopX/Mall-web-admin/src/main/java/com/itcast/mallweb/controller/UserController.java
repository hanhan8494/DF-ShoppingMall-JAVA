package com.itcast.mallweb.controller;


import com.itcast.admin.dto.UserDTO;
import com.itcast.admin.entity.User;
import com.itcast.mallweb.service.UserService;
import com.itcast.result.Result;
import com.itcast.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/admin/user")
@Slf4j
@Api(tags = "web-用户相关接口")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AliOssUtil aliOssUtil;

    //接口已通过-OK
    @PostMapping("/add")
    @ApiOperation("新增用户")
    public Result addUser(UserDTO userDTO, @RequestParam("image") MultipartFile image) {
        log.info("新增用户的信息为：{}", userDTO);
        log.info("用户头像上传,{}", image.getOriginalFilename());
        try {
            //原始文件名
            String originalFilename = image.getOriginalFilename();
            //截取原始文件名的后缀 37-57cj.png
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));//截取最后一个点的后半部分
            //构建新文件名称
            String objectName = UUID.randomUUID().toString() + extension;
            //文件的请求路径
            String upload = aliOssUtil.upload(image.getBytes(), objectName);
            userDTO.setAvatar(upload);
        } catch (IOException e) {
            log.error("文件上传失败：{}", e);
        }
        userService.addUser(userDTO);
        return Result.success();
    }

    //接口已通过-OK
    @GetMapping("/query")
    @ApiOperation("查询单个用户")
    public Result queryUser(Integer id) {
        log.info("查询用户的id为：{}", id);
        User user = userService.queryUser(id);
        return Result.success(user);
    }

    //接口已通过-OK
    @GetMapping("/queryAll")
    @ApiOperation("查询全部用户")
    public Result<List<User>> queryUserAll() {
        log.info("查询全部用户");
        List<User> user = userService.queryUserAll();
        return Result.success(user);
    }

    //接口已通过-OK
    @PostMapping("/delete")
    @ApiOperation("批量删除用户")
    public Result deleteUser(@RequestBody List<Integer> ids) {
        log.info("批量删除用户的id为：{}", ids);
        userService.deleteUser(ids);
        return Result.success();
    }
    //接口已通过-OK
    @PostMapping("/amend")
    @ApiOperation("修改用户")
    public Result amendUser(UserDTO userDTO, @RequestParam("image") MultipartFile image) {
        log.info("修改用户的信息为:{}", userDTO);
        log.info("用户修改头像上传,{}", image.getOriginalFilename());
        try {
            //原始文件名
            String originalFilename = image.getOriginalFilename();
            //截取原始文件名的后缀 37-57cj.png
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));//截取最后一个点的后半部分
            //构建新文件名称
            String objectName = UUID.randomUUID().toString() + extension;
            //文件的请求路径
            String upload = aliOssUtil.upload(image.getBytes(), objectName);
            userDTO.setAvatar(upload);
        } catch (IOException e) {
            log.error("文件上传失败：{}", e);
        }
        userService.amendUser(userDTO);
        return Result.success();
    }


}
