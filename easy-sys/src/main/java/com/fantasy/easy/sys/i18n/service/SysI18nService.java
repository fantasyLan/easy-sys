/**
 * fantasy
 */
package com.fantasy.easy.sys.i18n.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fantasy.easy.core.entity.SysI18nEntity;
import com.fantasy.easy.sys.i18n.mapper.SysI18nMapper;

/**
 * @author fantasy
 *2020年2月9日 下午2:58:13
 */
@RestController
@RequestMapping("i18n")
public class SysI18nService {

	@Autowired
	private SysI18nMapper sysI18nMapper;
	
	/***
	 * 查询这个语言下面所有的国际化
	 * 
	 * */
	public List<SysI18nEntity> getAllI18nByLang(String lang){
		QueryWrapper<SysI18nEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("i18n_lang", lang);
		return sysI18nMapper.selectList(queryWrapper);
	}

	@RequestMapping("list")
	public IPage<SysI18nEntity> list(SysI18nEntity menuEntity, Page<SysI18nEntity> p){
		QueryWrapper<SysI18nEntity> queryWrapper = new QueryWrapper<>();
		queryWrapper.setEntity(menuEntity);
		return sysI18nMapper.selectPage(p, queryWrapper);
	}

	@PostMapping("save")
	public int save(SysI18nEntity menuEntity){
		if(menuEntity.getI18nId() != null && menuEntity.getI18nId() != 0){
			return sysI18nMapper.updateById(menuEntity);
		}
		return sysI18nMapper.insert(menuEntity);
	}
}
