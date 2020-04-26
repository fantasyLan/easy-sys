/**
 * SysMenuService.java
 * @author Fantasy Lan
 */
package com.fantasy.easy.sys.role.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fantasy.easy.core.util.ShiroUtils;
import com.fantasy.easy.sys.role.SysRoleEntity;
import com.fantasy.easy.sys.role.mapper.SysRoleMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
/**
 * @author Fantasy Lan
 * @since 2019年12月19日 : 下午11:58:01
 */
@RestController
@RequestMapping("role")
public class SysRoleService {
	
	@Autowired
	private SysRoleMapper sysRoleMapper;

	@RequestMapping("list")
	public IPage<SysRoleEntity> list(SysRoleEntity menuEntity, Page<SysRoleEntity> p){
		QueryWrapper<SysRoleEntity> queryWrapper = new QueryWrapper<>();
		queryWrapper.setEntity(menuEntity);
		return sysRoleMapper.selectPage(p, queryWrapper);
	}

	@PostMapping("saveRoleAuth")
	public int saveRoleAuth(SysRoleEntity sysRoleEntity){
		sysRoleMapper.deleteRoleAuthByRoleId(sysRoleEntity.getRoleId());
		if(sysRoleEntity.getAuths() != null && sysRoleEntity.getAuths().size() > 0){
			sysRoleMapper.insertRoleAuthByRole(sysRoleEntity);
		}
		return 1;
	}

	@PostMapping("addRoleUser")
	public int addRoleUser(SysRoleEntity sysRoleEntity){
		if(sysRoleEntity.getUserIds() != null && sysRoleEntity.getUserIds().size() > 0){
			return sysRoleMapper.insertRoleUserByRole(sysRoleEntity);
		}
		return 0;
	}

	@PostMapping("deleteRoleUserByRole")
	public int deleteRoleUserByRole(SysRoleEntity sysRoleEntity) {
		if(sysRoleEntity.getUserIds() != null && sysRoleEntity.getUserIds().size() > 0) {
			return sysRoleMapper.deleteRoleUserByRole(sysRoleEntity);
		}
		return 0;
	}

	@PostMapping("save")
	public int save(SysRoleEntity menuEntity){
		if(menuEntity.getRoleId() != null && menuEntity.getRoleId() != 0){
			menuEntity.setUpdateBy(ShiroUtils.getUserId());
			menuEntity.setUpdateTime(new Date());
			return sysRoleMapper.updateById(menuEntity);
		}
		menuEntity.setCreateBy(ShiroUtils.getUserId());
		menuEntity.setCreateTime(new Date());
		return sysRoleMapper.insert(menuEntity);
	}

	@PostMapping("delete")
	public int delete(SysRoleEntity menuEntity) throws Exception{
		if(menuEntity.getRoleId() != null && menuEntity.getRoleId() != 0){
			return sysRoleMapper.deleteById(menuEntity.getRoleId());
		}
		throw new Exception("删除的角色ID不能为空");
	}

}
