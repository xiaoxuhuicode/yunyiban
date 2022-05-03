package com.xxh.server.service;

import com.xxh.server.pojo.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxh.server.pojo.RespPageBean;

import java.time.LocalDate;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xxh
 * @since 2022-03-13
 */
public interface IEmployeeService extends IService<Employee> {

    /**
     * 分页查询所有员工
     * @param currentPage
     * @param size
     * @param employee
     * @param beginDateScope
     * @return
     */
    RespPageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope);
}
