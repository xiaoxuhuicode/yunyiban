package com.xxh.server.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxh.server.mapper.MenuMapper;
import com.xxh.server.pojo.Admin;
import com.xxh.server.pojo.Menu;
import com.xxh.server.pojo.Role;
import com.xxh.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RedisTemplate<String ,Object > redisTemplate;

    /**
     * 通过用户id查询菜单列表
     * @return
     */
    @Override
    public List<Menu> getMenusByAdminId() {
        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        //从redis中获取菜单数据
        List<Menu> menus = (List<Menu>) valueOperations.get("menu" + adminId);
        //如果为空，就从数据库获取
        if(CollectionUtils.isEmpty(menus)){
            menus= menuMapper.getMenusByAdminId(adminId);
            //将数据设置到redis中
            valueOperations.set("menu"+adminId,menus);
        }
        return menus;
    }

    /**
     * 通过角色列表查询菜单列表
     * @return
     */
    @Override
    public List<Menu> getMenusWithRole() {
        return menuMapper.getMenusWithRole();
    }
}
