package com.itcast.mallapplet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //开启注解方式的事务管理
@Slf4j
@EnableCaching//开启缓存注解功能
@ComponentScan(basePackages = "com.itcast") //扫包
public class MallAppletApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAppletApplication.class, args);
    }

}
