package com.xxh.server.service;

import  com.xxh.server.pojo.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxh.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xxh
 * @since 2022-03-13
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
