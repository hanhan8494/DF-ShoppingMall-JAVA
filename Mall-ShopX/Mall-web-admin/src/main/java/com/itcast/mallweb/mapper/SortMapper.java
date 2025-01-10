package com.itcast.mallweb.mapper;

import com.itcast.admin.entity.Sort;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SortMapper {

    //新增分类
    @Insert("insert into sort(id, name, create_time) values(#{id},#{name},#{createTime})")
    void addSort(Sort sort);

    //查询单个分类
    @Select("select * from sort where id = #{id}")
    Sort querySort(Integer id);

    //查询全部分类
    @Select("select * from sort")
    List<Sort> querySortAll();

    //修改分类
    void amendSort(Sort sort);

    //批量删除接口
    void deleteSort(List<Integer> ids);
}
