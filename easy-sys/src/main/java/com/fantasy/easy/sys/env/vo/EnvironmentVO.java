/**
 * fantasy
 */
package com.fantasy.easy.sys.env.vo;

import java.util.List;
import java.util.Map;

import com.fantasy.easy.core.entity.SysI18nEntity;
import com.fantasy.easy.core.entity.SysMenuEntity;

/**
 * @author fantasy
 *2020年2月9日 下午3:09:14
 */
public class EnvironmentVO {

	/**
	 * 各个语言对应的国际化
	 * */
	private Map<String, List<SysI18nEntity>> i18n;
	
	/**
	 * 不需要权限可以访问的路径
	 * */
	private List<SysMenuEntity> noAuthMenu;
	
	/**
	 * 
	 * 语言列表
	 * */
	private List<String> langList;
	

	/**
	 * @return the langList
	 */
	public List<String> getLangList() {
		return langList;
	}

	/**
	 * @param langList the langList to set
	 */
	public void setLangList(List<String> langList) {
		this.langList = langList;
	}

	/**
	 * @return the i18n
	 */
	public Map<String, List<SysI18nEntity>> getI18n() {
		return i18n;
	}

	/**
	 * @param i18n the i18n to set
	 */
	public void setI18n(Map<String, List<SysI18nEntity>> i18n) {
		this.i18n = i18n;
	}

	/**
	 * @return the noAuthMenu
	 */
	public List<SysMenuEntity> getNoAuthMenu() {
		return noAuthMenu;
	}

	/**
	 * @param noAuthMenu the noAuthMenu to set
	 */
	public void setNoAuthMenu(List<SysMenuEntity> noAuthMenu) {
		this.noAuthMenu = noAuthMenu;
	}
	
	
}
