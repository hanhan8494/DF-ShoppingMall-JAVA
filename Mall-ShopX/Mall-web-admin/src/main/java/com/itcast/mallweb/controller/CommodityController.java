package com.itcast.mallweb.controller;

import com.itcast.admin.dto.AdminDTO;
import com.itcast.admin.dto.CommodityDTO;
import com.itcast.admin.entity.Admin;
import com.itcast.admin.vo.AdminLoginVO;
import com.itcast.admin.vo.DityVO;
import com.itcast.constant.JwtClaimsConstant;
import com.itcast.constant.MessageConstant;
import com.itcast.mallweb.service.CommodityService;
import com.itcast.result.Result;
import com.itcast.utils.AliOssUtil;
import com.itcast.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.login.AccountNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/dity")
@Slf4j
@Api(tags = "web-商品相关接口")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;


    @PostMapping("/add")
    @ApiOperation("新增商品接口")
    public Result<String> dityAdd(CommodityDTO commodityDTO, @RequestParam("image") MultipartFile[] files) {
        log.info("新增的商品信息为：{}", commodityDTO);
        log.info("文件上传信息：{}", files);
        commodityService.dityAdd(commodityDTO, files);
        return Result.success();
    }

    @GetMapping("/query")
    @ApiModelProperty("查询单个商品")
    public Result<DityVO> dityQuery(@RequestParam Integer id) {
        log.info("查询单个商品的id为：{}", id);
        DityVO dityVO = commodityService.dityQuery(id);
        return Result.success(dityVO);
    }

    @GetMapping("/queryAll")
    @ApiModelProperty("查询全部商品")
    public Result<List<DityVO>> dityAllQuery() {
        log.info("查询全部商品");
        List<DityVO> dityVOlist = commodityService.dityAllQuery();
        return Result.success(dityVOlist);
    }

    @PostMapping("/detele")
    @ApiModelProperty("批量删除商品")
    public Result dityDetele(@RequestBody List<Integer> ids) {
        log.info("删除商品的id为：{}",ids);
        commodityService.dityDetele(ids);
        return Result.success();
    }





}
