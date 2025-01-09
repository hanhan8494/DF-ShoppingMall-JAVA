package com.itcast.mallweb.service;

import com.itcast.admin.dto.CommodityDTO;
import com.itcast.admin.vo.DityVO;
import com.itcast.result.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CommodityService {
    //新增商品
    Result<String> dityAdd(CommodityDTO commodityDTO, MultipartFile[] files);

    //查询单个商品
    DityVO dityQuery(Integer id);

    //查询全部商品
    List<DityVO> dityAllQuery();

    //批量删除商品
    void dityDetele(List<Integer> ids);
}
