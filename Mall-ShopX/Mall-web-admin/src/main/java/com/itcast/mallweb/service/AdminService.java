package com.itcast.mallweb.service;

import com.itcast.admin.dto.AdminDTO;
import com.itcast.admin.entity.Admin;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public interface AdminService {
    //登录管理员
    Admin login(AdminDTO adminDTO) throws AccountNotFoundException;

    //新增管理员
    void addAdmin(Admin admin);

    //删除管理员
    void deteleAdmin(List<Long> ids);

    //查询单个管理员
    Admin getById(Long id);

    //查询全部管理员
    List<Admin> getAdmin();
}
