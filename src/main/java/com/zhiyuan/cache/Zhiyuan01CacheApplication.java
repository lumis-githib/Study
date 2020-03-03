package com.zhiyuan.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.zhiyuan.cache")
@SpringBootApplication
@EnableCaching
public class Zhiyuan01CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Zhiyuan01CacheApplication.class, args);
    }

}
