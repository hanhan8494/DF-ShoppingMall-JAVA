package com.itcast.mallweb.controller;


import com.itcast.admin.entity.Admin;
import com.itcast.admin.entity.Sort;
import com.itcast.admin.entity.User;
import com.itcast.mallweb.service.SortService;
import com.itcast.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/sort")
@Slf4j
@Api(tags = "web-分类相关接口")
public class SortController {
    @Autowired
    private SortService sortService;

    //接口已通过-OK
    @PostMapping("/add")
    @ApiOperation("新增分类")
    public Result addSort(@RequestBody Sort sort) {
        log.info("新增分类的信息为：{}", sort);
        sortService.addSort(sort);
        return Result.success();
    }
    //接口已通过-OK
    @GetMapping("/query")
    @ApiOperation("查询单个分类")
    public Result<Sort> querySort(Integer id) {
        log.info("查询单个分类的id为：{}", id);
        Sort sort = sortService.querySort(id);
        return Result.success(sort);
    }
    //接口已通过-OK
    @GetMapping("/queryAll")
    @ApiOperation("查询全部分类")
    public Result<List<Sort>> querySortAll() {
        log.info("查询全部分类");
        List<Sort> sort = sortService.querySortAll();
        return Result.success(sort);
    }
    //接口已通过-OK
    @PostMapping("/amend")
    @ApiOperation("修改分类")
    public Result amendSort(@RequestBody Sort sort) {
        log.info("修改分类的信息：{}",sort);
        sortService.amendSort(sort);
        return Result.success();
    }
    //接口已通过-OK
    @PostMapping("/delete")
    @ApiOperation("批量删除分类")
    public Result deleteSort(@RequestBody List<Integer> ids) {
        log.info("批量删除分类的id为：{}",ids);
        sortService.deleteSort(ids);
        return Result.success();
    }

}
