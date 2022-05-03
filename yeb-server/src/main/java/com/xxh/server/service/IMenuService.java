package com.xxh.server.service;

import  com.xxh.server.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxh.server.pojo.Role;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xxh
 * @since 2022-03-13
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 通过用户id查询菜单列表
     * @return
     */
    List<Menu> getMenusByAdminId();

    /**
     * 通过角色列表查询菜单列表
     * @return
     */
    List<Menu> getMenusWithRole();

    /**
     * 查询所有菜单
     * @return
     */
    List<Menu> getAllMenus();
}
