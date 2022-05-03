package com.xxh.server.service;

import  com.xxh.server.pojo.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxh.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xxh
 * @since 2022-03-13
 */
public interface IDepartmentService extends IService<Department> {

    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments();

    /**
     * 添加部门
     * @param department
     * @return
     */
    RespBean addDepartment(Department department);

    /**
     * 删除部门
     * @param id
     * @return
     */
    RespBean deleteDepartment(Integer id);
}
