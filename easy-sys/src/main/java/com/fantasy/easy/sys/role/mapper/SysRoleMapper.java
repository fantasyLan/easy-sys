package com.fantasy.easy.sys.role.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fantasy.easy.sys.role.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRoleEntity> {

    int deleteRoleAuthByRoleId(Long roleId);
    int insertRoleAuthByRole(SysRoleEntity sysRoleEntity);

    int insertRoleUserByRole(SysRoleEntity sysRoleEntity);

    int deleteRoleUserByRole(SysRoleEntity sysRoleEntity);
}