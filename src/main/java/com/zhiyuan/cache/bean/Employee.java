package com.zhiyuan.cache.bean;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @ClassName Employee
 * @Description Todo
 * @Author ming.lu
 * @Date 2020/3/1 16:27
 */
@Data
@EntityScan
public class Employee {
    private Integer id;
    private String lastname;
    private String email;
    private String gender;
    private Integer did;

}
