package com.xxh.server.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxh.server.pojo.AdminRole;
import com.xxh.server.pojo.RespBean;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xxh
 * @since 2022-03-13
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    /**
     * 更新操作角色
     * @param adminId
     * @param rids
     * @return
     */
    Integer updateAdminRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}
