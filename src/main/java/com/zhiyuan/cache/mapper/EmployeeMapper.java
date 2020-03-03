package com.zhiyuan.cache.mapper;

import com.zhiyuan.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {
    @Select("SELECT * FROM employee WHERE id=#{id}")
    public Employee getEmpById(Integer id);
@Update("UPDATE employee SET lastname=#{lastname},email=#{email},gender= #{gender},did=#{did} WHERE id=#{id}")
    public void updateEmployee(Employee employee);
@Delete("DELETE FROM employee WHERE id=#{id} ")
public void deleteEmp(Integer id);
@Insert("INSERT INTO employee (lastname,email,gender,did) VALUES (#{lastname},#{email},#{gender},#(did))  ")
public void insertEmp(Employee employee);
    @Select("SELECT * FROM employee WHERE lastname=#{lastname}")
    public Employee getEmpByName(String lastname);
}
