package com.fantasy.easy.sys.menu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fantasy.easy.core.entity.SysMenuEntity;
import com.fantasy.easy.core.entity.SysUserEntity;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {
    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */
    List<SysMenuEntity> queryListParentId(Long parentId);

    /**
     * 查询全部数据
     */
    List<SysMenuEntity> selectList () ;

    /**
     * 获取不包含按钮的菜单列表
     */
    List<SysMenuEntity> queryNotButtonList();
    
    /**
     * 获取不包含按钮的菜单列表
     */
    List<SysMenuEntity> queryMenuByUserId(SysUserEntity user);
    
    /**
     * 获取不需要权限的的菜单列表
     */
    List<SysMenuEntity> queryMenuNoAuth();

    List<SysMenuEntity> queryMenuByRoleId(Long roleId);
}