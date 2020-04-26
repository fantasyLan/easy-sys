/**
 * SysMenuService.java
 * @author Fantasy Lan
 */
package com.fantasy.easy.sys.menu.service;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fantasy.easy.core.exception.EasyApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantasy.easy.core.entity.SysMenuEntity;
import com.fantasy.easy.core.util.ShiroUtils;
import com.fantasy.easy.sys.menu.mapper.SysMenuMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fantasy Lan
 * @since 2019年12月19日 : 下午11:58:01
 */
@RestController
@RequestMapping("menu")
public class SysMenuService {
	
	@Autowired
	private SysMenuMapper sysMenuMapper;

	@RequestMapping("list")
	public IPage<SysMenuEntity> list(SysMenuEntity menuEntity, Page<SysMenuEntity> p){
		QueryWrapper<SysMenuEntity> queryWrapper = new QueryWrapper<>();
		queryWrapper.setEntity(menuEntity);
		return sysMenuMapper.selectPage(p, queryWrapper);
	}

	@RequestMapping("all")
	public List<SysMenuEntity> all(){
		return getMenuChildByParentId(sysMenuMapper.selectList(), 0L);
	}

	@PostMapping("save")
	public int save(SysMenuEntity menuEntity){
		if(menuEntity.getMenuId() != null && menuEntity.getMenuId() != 0){
			return sysMenuMapper.updateById(menuEntity);
		}
		return sysMenuMapper.insert(menuEntity);
	}

	@PostMapping("getRoleMenu")
	public List<SysMenuEntity> getRoleMenu(Long roleId) throws EasyApplicationException {
		if(roleId == null){
			throw new EasyApplicationException("请输入角色Id");
		}
		return sysMenuMapper.queryMenuByRoleId(roleId);
	}

	public List<SysMenuEntity> getUserMenu() {
		List<SysMenuEntity> menus = null;
		if(ShiroUtils.isLogin()) {
			menus = sysMenuMapper.queryMenuByUserId(ShiroUtils.getUserEntity());
		}else {
			menus = sysMenuMapper.queryMenuNoAuth();
		}
		List<SysMenuEntity> res = getMenuChildByParentId(menus, 0L);
		return res;
	}
	
	public List<SysMenuEntity> queryMenuNoAuth() {
		List<SysMenuEntity> menus = null;
		menus = sysMenuMapper.queryMenuNoAuth();
		List<SysMenuEntity> res = getMenuChildByParentId(menus, 0L);
		return res;
	}
	
	private List<SysMenuEntity> getMenuChildByParentId(List<SysMenuEntity> list, Long parentId){
		List<SysMenuEntity> res = new ArrayList<>();
		for (SysMenuEntity sysMenuEntity : list) {
			if(sysMenuEntity.getMenuParentId() != null && sysMenuEntity.getMenuParentId() == parentId) {
				res.add(sysMenuEntity);
				sysMenuEntity.setChildren(getMenuChildByParentId(list, sysMenuEntity.getMenuId()));
			}
		}
		return res;
	}
}
