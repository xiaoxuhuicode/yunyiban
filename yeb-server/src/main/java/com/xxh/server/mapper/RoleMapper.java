package com.xxh.server.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户id查询对应的角色列表
     * @return
     */
    List<Role> getRoles(Integer adminId);
}
