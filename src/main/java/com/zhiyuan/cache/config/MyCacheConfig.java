package com.zhiyuan.cache.config;


import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName KeyGenerater
 * @Description Todo
 * @Author ming.lu
 * @Date 2020/3/1 19:50
 */
@Configuration
public class MyCacheConfig  {
    @Bean(name = "myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName()+"["+ Arrays.asList(params).toString() +"]";
            }
        };
    }
}
