/**
 * fantasy
 */
package com.fantasy.easy.sys.env.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fantasy.easy.core.Const;
import com.fantasy.easy.core.entity.SysI18nEntity;
import com.fantasy.easy.sys.env.vo.EnvironmentVO;
import com.fantasy.easy.sys.i18n.service.SysI18nService;
import com.fantasy.easy.sys.menu.service.SysMenuService;

/**
 * @author fantasy
 *2020年2月9日 下午3:00:54
 */
@RestController
@RequestMapping("env")
public class SysEnvService {

	@Autowired
	private SysI18nService i18nService;
	@Autowired
	private SysMenuService menuService;
	
	@PostMapping("info")
	public EnvironmentVO getEnvInfo() {
		EnvironmentVO envVO = new EnvironmentVO();
		Map<String, List<SysI18nEntity>> i18n = new HashMap<>();
		i18n.put(Const.LANG_CN, i18nService.getAllI18nByLang(Const.LANG_CN));
		i18n.put(Const.LANG_EN, i18nService.getAllI18nByLang(Const.LANG_EN));
		envVO.setI18n(i18n);
		List<String> langList = new ArrayList<>();
		langList.add(Const.LANG_CN);
		langList.add(Const.LANG_EN);
		envVO.setLangList(langList);
		envVO.setNoAuthMenu(menuService.queryMenuNoAuth());
		return envVO;
	}
}
