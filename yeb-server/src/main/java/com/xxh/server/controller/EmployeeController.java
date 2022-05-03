package com.xxh.server.controller;


import com.xxh.server.pojo.Employee;
import com.xxh.server.pojo.RespPageBean;
import com.xxh.server.service.IEmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xxh
 * @since 2022-03-13
 */
@RestController
@RequestMapping("/employee/basic")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @ApiOperation(value = "分页查询所有员工")
    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer currentPage,
                                    @RequestParam(defaultValue = "10")Integer size,
                                    Employee employee,
                                    LocalDate[] beginDateScope){
        return employeeService.getEmployeeByPage(currentPage,size,employee,beginDateScope);
    }
}
