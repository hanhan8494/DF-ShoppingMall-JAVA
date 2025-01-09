package com.itcast.mallweb.mapper;

import com.itcast.admin.entity.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommodityMapper {

    //新增商品
    void dityAdd(Commodity commodity);

    //存储新增商品的图片
    void dityUrl(List<DityUrl> list);

    //查询单个商品
    @Select("select c.*,d.avatar from commodity c left join dity_url d ON c.id = dity_id where c.id = #{id};")
    List<DityAll> dityQuery(Integer id);

    //查询全部商品
    @Select("select c.*,d.avatar,d.dity_id from commodity c left join dity_url d ON c.id = dity_id ")
    List<DityAlls> dityAllQuery();

    //批量删除商品
    void dityDetele(List<Integer> ids);

    //批量删除商品图片
    void dityUrlDetele(List<Integer> ids);

    //修改商品信息
    void dityAmend(Commodity commodity);

    //根据id删除图片
    @Delete("DELETE FROM dity_url WHERE dity_id = #{id};")
    void dityUrlAmendDetele(Long id);

}
