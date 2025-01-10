package com.itcast.mallapplet.mapper;

import com.itcast.admin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    //根据openid来查询用户
    @Select("select * from user where openid = #{openid}")
    User getUserById(String openid);

    //插入数据并返回主键id
    void insert(User user);
}
