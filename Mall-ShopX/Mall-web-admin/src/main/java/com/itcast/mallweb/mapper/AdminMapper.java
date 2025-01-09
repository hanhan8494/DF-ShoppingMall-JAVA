package com.itcast.mallweb.mapper;

import com.itcast.admin.entity.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {

    //根据账号查询数据库
    @Select("select * from admin where account = #{account}")
    Admin getByAccount(String account);

    //新增管理员
    @Insert("insert into admin (adminName, account, password, status, create_time, sorct) " +
            "values (#{adminName},#{account},#{password},#{status},#{createTime},#{sorct})") //TODO 优化公共字段
    void addAdmin(Admin admin);

    //删除管理员
    void deteleAdmin(List<Long> ids);

    //查询单个管理员
    @Select("select * from admin where id = #{id}")
    Admin getById(Long id);

    //查询全部管理员
    @Select("select * from admin")
    List<Admin> getAdmin();
}
