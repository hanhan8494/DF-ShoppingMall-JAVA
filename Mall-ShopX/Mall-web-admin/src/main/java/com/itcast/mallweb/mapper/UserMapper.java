package com.itcast.mallweb.mapper;


import com.itcast.admin.dto.UserDTO;
import com.itcast.admin.entity.Admin;
import com.itcast.admin.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper {

    //新增用户
    @Insert("insert into user(openid, name, phone, sex, avatar, create_time) " +
            "values (#{openid},#{name},#{phone},#{sex},#{avatar},#{createTime})")
    void addUser(User build);

    //查询单个用户
    @Select("select * from user where id = #{id}")
    User queryUser(Integer id);

    //查询全部用户
    @Select("select * from user")
    List<User> queryUserAll();

    //批量删除用户
    void deleteUser(List<Integer> ids);

    //修改用户
    void amendUser(UserDTO userDTO);
}
