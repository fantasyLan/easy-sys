/**
 * fantasy
 */
package com.fantasy.easy.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author fantasy
 *2020年2月9日 下午2:52:25
 */
@TableName("sys_i18n")
public class SysI18nEntity extends BaseEntity {

	@TableId(type= IdType.AUTO)
	private Long i18nId;
	private String i18nKey;
	private String i18nContent;
	private String i18nLang;
	private String i18nRmk;
	/**
	 * @return the i18nId
	 */
	public Long getI18nId() {
		return i18nId;
	}
	/**
	 * @param i18nId the i18nId to set
	 */
	public void setI18nId(Long i18nId) {
		this.i18nId = i18nId;
	}
	/**
	 * @return the i18nKey
	 */
	public String getI18nKey() {
		return i18nKey;
	}
	/**
	 * @param i18nKey the i18nKey to set
	 */
	public void setI18nKey(String i18nKey) {
		this.i18nKey = i18nKey;
	}
	/**
	 * @return the i18nContent
	 */
	public String getI18nContent() {
		return i18nContent;
	}
	/**
	 * @param i18nContent the i18nContent to set
	 */
	public void setI18nContent(String i18nContent) {
		this.i18nContent = i18nContent;
	}
	/**
	 * @return the i18nLang
	 */
	public String getI18nLang() {
		return i18nLang;
	}
	/**
	 * @param i18nLang the i18nLang to set
	 */
	public void setI18nLang(String i18nLang) {
		this.i18nLang = i18nLang;
	}
	/**
	 * @return the i18nRmk
	 */
	public String getI18nRmk() {
		return i18nRmk;
	}
	/**
	 * @param i18nRmk the i18nRmk to set
	 */
	public void setI18nRmk(String i18nRmk) {
		this.i18nRmk = i18nRmk;
	}
	
}
