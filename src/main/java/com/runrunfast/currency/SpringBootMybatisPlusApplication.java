package com.runrunfast.currency;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @version 1.0
 * @Author: james
 * @Description: This is description
 * @Date: created in 14:46 2018/9/4
 **/
@SpringBootApplication
@EnableCaching
@MapperScan("com.runrunfast.currency.mapper")
public class SpringBootMybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisPlusApplication.class, args);
    }
}
