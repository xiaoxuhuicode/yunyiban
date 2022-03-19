package com.xxh.server.service;

import  com.xxh.server.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxh.server.pojo.RespBean;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xxh
 * @since 2022-03-13
 */
public interface IAdminService extends IService<Admin> {
    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param request
     * @return
     */
    RespBean login(String username, String password, HttpServletRequest request);

    /**
     * 根据用户名获取用户
     * @param userName
     * @return
     */
    Admin getAdminByUserName(String userName);
}
