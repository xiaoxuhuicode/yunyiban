package com.xxh.server.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxh.server.config.component.JwtTokenUtil;
import com.xxh.server.mapper.AdminMapper;
import com.xxh.server.mapper.RoleMapper;
import com.xxh.server.pojo.Admin;
import com.xxh.server.pojo.RespBean;
import com.xxh.server.pojo.Role;
import com.xxh.server.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xxh
 * @since 2022-03-13
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * 登录成功返回token
     * @param username
     * @param password
     * @param request
     * @return
     */
    @Override
    public RespBean login(String username, String password, String code,HttpServletRequest request) {
        String captcha =(String) request.getSession().getAttribute("captcha");
        if(StringUtils.isEmpty(code)||!captcha.equalsIgnoreCase(code)){
            return RespBean.error("验证码输入错误，请重新输入！");
        }
        //登录
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(null==userDetails||passwordEncoder.matches(password,userDetails.getPassword())){
            return RespBean.error("用户名或者密码不正确！");
        }
        if(!userDetails.isEnabled()){
            return RespBean.error("账号被禁用，请联系管理员！");
        }
        //更新security登录用户对象
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        //生成token
        String token = jwtTokenUtil.generateToken(userDetails);
        HashMap<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return RespBean.success("登录成功",tokenMap);
    }

    /**
     * 根据用户名获取用户
     * @param userName
     * @return
     */
    @Override
    public Admin getAdminByUserName(String userName) {
        return adminMapper.selectOne(new QueryWrapper<Admin>()
                .eq("username",userName)
                .eq("enabled",true));
    }

    /**
     * 根据用户id查询对应的角色列表
     * @param adminId
     * @return
     */
    @Override
    public List<Role> getRoles(Integer adminId) {
        return roleMapper.getRoles(adminId);
    }
}
