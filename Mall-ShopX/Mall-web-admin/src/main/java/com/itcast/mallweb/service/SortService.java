package com.itcast.mallweb.service;

import com.itcast.admin.entity.Sort;

import java.util.List;

public interface SortService {

    //新增分类
    void addSort(Sort sort);

    //查询单个分类
    Sort querySort(Integer id);

    //查询全部分类
    List<Sort> querySortAll();

    //修改分类
    void amendSort(Sort sort);

    //批量删除分类
    void deleteSort(List<Integer> ids);
}
