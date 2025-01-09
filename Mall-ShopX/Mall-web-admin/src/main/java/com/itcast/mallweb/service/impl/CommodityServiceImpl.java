package com.itcast.mallweb.service.impl;


import com.itcast.admin.dto.CommodityDTO;
import com.itcast.admin.entity.*;
import com.itcast.admin.vo.DityVO;
import com.itcast.constant.MessageConstant;
import com.itcast.exception.BaseException;
import com.itcast.mallweb.mapper.CommodityMapper;
import com.itcast.mallweb.service.CommodityService;
import com.itcast.result.Result;
import com.itcast.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityMapper commodityMapper;
    @Autowired
    private AliOssUtil aliOssUtil;

    //新增商品
    @Transactional
    public Result<String> dityAdd(CommodityDTO commodityDTO, MultipartFile[] files) {
        Commodity commodity = new Commodity();
        BeanUtils.copyProperties(commodityDTO, commodity);
        Commodity.builder()
                .status(1)
                .createTime(LocalDateTime.now())
                .build();

        List<String> urls = new ArrayList<>();
        //图片路径存储
        for (MultipartFile file : files) {
            try {
                //原始文件名
                String originalFilename = file.getOriginalFilename();
                urls.add(originalFilename);
                //截取原始文件名的后缀 37-57cj.png
                String extension = originalFilename.substring(originalFilename.lastIndexOf("."));//截取最后一个点的后半部分
                //构建新文件名称
                String objectName = UUID.randomUUID().toString() + extension;
                //文件的请求路径
                String upload = aliOssUtil.upload(file.getBytes(), objectName); //把这个返回给前端
                return Result.success(upload);
            } catch (IOException e) {
                log.error("文件上传失败：{}", e);
            }
            return Result.error(MessageConstant.UPLOAD_FAILED);
        }
        //生成一个实体图片存储
        List<DityUrl> dityUrls = new ArrayList<>();
        for (String url : urls) {
            DityUrl build = DityUrl.builder()
                    .dityId(commodity.getId())
                    .avatar(url)
                    .build();

            dityUrls.add(build);
        }
        //前面运行完毕之后新增商品
        commodityMapper.dityAdd(commodity);
        commodityMapper.dityUrl(dityUrls);
        return Result.success();
    }

    //查询单个商品
    public DityVO dityQuery(Integer id) {
        List<DityAll> list = commodityMapper.dityQuery(id);
        if (list == null || list.size() == 0) {
            throw new BaseException("空指针异常");
        }

        DityVO dityVO = new DityVO();
        BeanUtils.copyProperties(list.get(0), dityVO);
        List<String> dityUrls = new ArrayList<>();

        for (DityAll all : list) {
            dityUrls.add(all.getAvatar());
        }
        dityVO.setAvatar(dityUrls);

        return dityVO;
    }

    //查询全部商品
    public List<DityVO> dityAllQuery() {
        //拿到数据库全部商品及其图片
        List<DityAlls> list = commodityMapper.dityAllQuery();
        //非空报错
        if (list == null || list.size() == 0) {
            throw new BaseException("空指针异常");
        }
        //存储全部商品图片及其Id
        List<DityUrls> dityUrls = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            DityUrls build = DityUrls.builder()
                    .dityId(list.get(i).getDityId())
                    .avatar(list.get(i).getAvatar())
                    .build();
            dityUrls.add(build);
        }
        //判断图片对应 TODO 效率需优化，先实现
        List<DityVO> dityVOs = new ArrayList<>();
        HashMap<Commodity, Integer> map = new HashMap<>();
        List<Commodity> commodities = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            DityAlls dityAlls = list.get(i);
            Commodity commodity = new Commodity();
            BeanUtils.copyProperties(dityAlls,commodity);
            commodities.add(commodity);
        }
        for (int i = 0; i < commodities.size(); i++) {
            map.put(commodities.get(i), 1);
        }
        //获取Hash所有键位
        Set<Commodity> keys = map.keySet();
        List<Commodity> dityKeys = new ArrayList<>();
        for (Commodity key : keys) {
            dityKeys.add(key);
        }
        for (int i = 0; i < dityKeys.size(); i++) {
            List<String> dityAvatar = new ArrayList<>();
            for (int j = 0; j < dityUrls.size(); j++) {
                if (dityKeys.get(i).getId() == dityUrls.get(j).getDityId()) {
                    dityAvatar.add(dityUrls.get(j).getAvatar());
                }
            }
            DityVO dityVO = new DityVO();
            BeanUtils.copyProperties(dityKeys.get(i), dityVO);
            dityVO.setAvatar(dityAvatar);
            dityVOs.add(dityVO);
        }
        return dityVOs;
    }

    //批量删除商品
    @Transactional
    public void dityDetele(List<Integer> ids) {
        //删除商品
        commodityMapper.dityDetele(ids);
        //删除商品图片
        commodityMapper.dityUrlDetele(ids);
    }


}