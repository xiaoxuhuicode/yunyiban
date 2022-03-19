package com.xxh.server.controller;

import com.xxh.server.pojo.AdminLoginParam;
import com.xxh.server.pojo.RespBean;
import com.xxh.server.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xxh
 * @since 2022/3/19 15:33
 */
@RestController
@Api(tags = "LoginController")
public class LoginController {

    @Autowired
   private IAdminService adminService;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public RespBean login(AdminLoginParam adminLoginParam, HttpServletRequest request){
        return adminService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword(),request);
    }
}
