package com.xxh.server.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxh.server.pojo.Menu;
import com.xxh.server.pojo.Role;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xxh
 * @since 2022-03-13
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 通过用户id查询菜单列表
     * @param id
     * @return
     */
    List<Menu> getMenusByAdminId(Integer id);

    /**
     * 通过角色列表查询菜单列表
     * @return
     */
    List<Menu> getMenusWithRole();

    /**
     *查询所有菜单
     * @return
     */
    List<Menu> getAllMenus();
}
