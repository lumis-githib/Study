package com.zhiyuan.cache.service;

import com.zhiyuan.cache.bean.Employee;
import com.zhiyuan.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

/**
 * @ClassName EmployeeService
 * @Description Todo
 * @Author ming.lu
 * @Date 2020/3/1 18:22
 */
@Service
/**
 * CacheConfig缓存配置，制定缓存块名称。写在类上方法上就不用写了
 *
 */
@CacheConfig(cacheNames="emp")
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * Cacheable:以后有相同的查询不走数据库，直接取自缓存。
     * 属性：
     * 1、value：制定缓存组，
     * 2、key：制定缓存的主键。eg：#id
     *        也可以用另外一种表达方式 SPEL .eg：#root.args[0]含义是取自当前参数的第一个参数值
     * 3、keyGenerator:主键生成器，可以自己制定key的生成主键id eg:keyGenerator = "myKeyGenerator"
     * 4、cacheManager：缓存管理器。在那个缓存管理器取数据。
     * 5、cacheResolver：缓存解析器，与管理器二选一，功能类似。
     * 6、condition：符合条件才进行缓存。eg：#id>0,,,eg2 :condition = "#id>1 and #root.methodName.equals('getEmployeeById')",
     * 7、unless:满足条件就不缓存。可以取结果值判断是否缓存。eg：“#result==null” eg2:unless = "#a0==2"
     * @param id
     * @return
     */
    @Cacheable(key="#id")
    public Employee getEmployeeById(Integer id){
        System.out.println("查询"+id+"号员工");
       return employeeMapper.getEmpById(id);

    }
    /**
     * CachePut:调用方法也缓存数据
     * 修改了数据库的某个数据，同时更新缓存。
     * 1.调用方法修改
     * 2.缓存修改之后的结果
     * 指定 key:#result.id
     * 也可以用employee.id
     * 测试步骤：先查询，然后再更新。
     * 先
     */
    @CachePut
    public Employee updateEmployee(Employee employee){
        System.out.println("调用了数据库！");
        employeeMapper.updateEmployee(employee);
    return employee;
    }

    /**
     * CacheEvict:缓存清空组件，先清空制定缓存，再操作数据库。
     * key：制定要清空的id
     * allentries=true,删除所有组件。
     * beforeInvocation 缓存的清除是在方法执行前还是执行后。默认false 在方法执行前，true是方法执行后。
     *
     */
    @CacheEvict(key="#id")
    public void delEmployeeById(Integer id){
        System.out.println("删除"+id+"号员工");
//        employeeMapper.deleteEmp(id);

    }
    /**
     * catching是上述三个注解的综合体。
     *
     */
    @Caching(
            cacheable = {
                    @Cacheable(key="#lastname")
            },put = {
                    @CachePut(key="#result.id"),
                    @CachePut(key = "#result.email")
            }

    )
    public Employee getEmpByName(String lastname){
        System.out.println("查询"+lastname+"号员工");
        return employeeMapper.getEmpByName(lastname);
    }
}
