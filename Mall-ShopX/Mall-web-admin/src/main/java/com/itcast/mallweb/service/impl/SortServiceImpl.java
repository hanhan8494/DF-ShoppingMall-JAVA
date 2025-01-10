package com.itcast.mallweb.service.impl;

import com.itcast.admin.entity.Sort;
import com.itcast.mallweb.mapper.SortMapper;
import com.itcast.mallweb.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SortServiceImpl implements SortService {
    @Autowired
    private SortMapper sortMapper;

    //新增分类
    public void addSort(Sort sort) {
        sort.setCreateTime(LocalDateTime.now());
        sortMapper.addSort(sort);
    }

    //查询单个分类
    public Sort querySort(Integer id) {
        Sort sort = sortMapper.querySort(id);
        return sort;
    }

    //查询全部分类
    public List<Sort> querySortAll() {
        return sortMapper.querySortAll();
    }

    //修改分类
    public void amendSort(Sort sort) {
        sortMapper.amendSort(sort);
    }

    //批量删除分类
    public void deleteSort(List<Integer> ids) {
        sortMapper.deleteSort(ids);
    }
}
