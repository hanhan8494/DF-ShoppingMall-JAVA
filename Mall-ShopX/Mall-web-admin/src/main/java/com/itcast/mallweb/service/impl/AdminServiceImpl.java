package com.itcast.mallweb.service.impl;

import com.itcast.admin.dto.AdminDTO;
import com.itcast.admin.entity.Admin;
import com.itcast.constant.MessageConstant;
import com.itcast.exception.PasswordErrorException;
import com.itcast.mallweb.mapper.AdminMapper;
import com.itcast.mallweb.mapper.UserMapper;
import com.itcast.mallweb.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    //登录管理员
    public Admin login(AdminDTO adminDTO) throws AccountNotFoundException {

        String account = adminDTO.getAccount();
        String password = adminDTO.getPassword();
        //1、根据用户名查询数据库中的数据
        Admin admin = adminMapper.getByAccount(account);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (admin == null) {
            //账号不存在抛出异常
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        //密码比对
        if (!password.equals(admin.getPassword())) {
            //密码错误抛出异常
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }
        //3、返回实体对象
        return admin;
    }

    //新增管理员
    public void addAdmin(Admin admin) {
        admin.setCreateTime(LocalDateTime.now());
        adminMapper.addAdmin(admin);
    }

    //删除管理员
    public void deteleAdmin(List<Long> ids) {
        adminMapper.deteleAdmin(ids);
    }

    //查询单个管理员
    public Admin getById(Long id) {
        Admin admin = adminMapper.getById(id);
        return admin;
    }

    //查询全部管理员
    public List<Admin> getAdmin() {
        List<Admin> list = adminMapper.getAdmin();
        return list;
    }
}
