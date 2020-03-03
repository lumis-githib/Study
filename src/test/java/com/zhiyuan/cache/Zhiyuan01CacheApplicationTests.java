package com.zhiyuan.cache;

import com.zhiyuan.cache.bean.Employee;
import com.zhiyuan.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
class Zhiyuan01CacheApplicationTests {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作字符串
    @Autowired
        RedisTemplate redisTemplate;//操作对象
        @Autowired
        RedisTemplate<Object, Employee> employeeRedisTemplate;
    /**
     * redis 常见的5大数据类型
     * String 字符串，List列表，set集合，hash散列，zset有序集合
     * 如果默认保存对象，要将序列化后的数据保存在redis中否则将保存为字节码。
     * 1、数据以json数据保存。
     *      1）自己通过json 工具转为json，然后存到redis中
     *      2）通过redistemplate默认的序列化存入redis ，eg：myredisconfig.java
     */
    @Test
    void test01(){
       Employee employee=employeeMapper.getEmpById(1);
//        stringRedisTemplate.opsForValue().append("001","helloword");
//        System.out.println(stringRedisTemplate.opsForValue().get("001"));
        employeeRedisTemplate.opsForValue().set("002",employee);
    }

    @Test
    void contextLoads() {
        System.out.println(employeeMapper.getEmpById(1));
    }
    @Test
    void setEmployee(){
        Employee info = new Employee();
        info.setDid(3);
        setEmployeeEmail(info);
        System.out.println(info);
    }
    void setEmployeeEmail(Employee employee){
        employee.setEmail("11@qq.com");
    }

}
