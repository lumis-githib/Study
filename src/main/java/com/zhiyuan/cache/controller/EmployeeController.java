package com.zhiyuan.cache.controller;

import com.zhiyuan.cache.bean.Employee;
import com.zhiyuan.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName EmployeeController
 * @Description Todo
 * @Author ming.lu
 * @Date 2020/3/1 18:25
 */
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/emp/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){

        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/emp")
    public Employee updateEmployee(Employee employee){
        return employeeService.updateEmployee(employee);
    }
    @GetMapping("/delemp/{id}")
    public String delEmployeeById(@PathVariable Integer id){
         employeeService.delEmployeeById(id);
        return "sucess";
    }
    @GetMapping("/empname/{name}")
    public Employee getEmployeeByname(@PathVariable String name){
        return employeeService.getEmpByName(name);
    }
}
