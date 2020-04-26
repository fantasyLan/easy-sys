package com.fantasy.easy.core.entity;

import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 菜单管理
 */
@TableName("sys_menu")
public class SysMenuEntity extends BaseEntity {

	@TableId(type= IdType.AUTO)
	private Long menuId;

	private Long menuParentId;

	@TableField(exist = false)
	private String menuParentName;

	private String menuName;

	private String menuUrl;
	
	private String menuPath;

	private String menuAuth;

	private Integer menuType;

	private String menuIcon;

	private Integer menuOrder;

	@TableField(exist = false)
	private List<SysMenuEntity> children;

	@TableField(exist = false)
	private Boolean open;

	/**
	 * @return the menuPath
	 */
	public String getMenuPath() {
		return menuPath;
	}

	/**
	 * @param menuPath the menuPath to set
	 */
	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}

	/**
	 * @return the menuId
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId
	 *            the menuId to set
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the menuParentId
	 */
	public Long getMenuParentId() {
		return menuParentId;
	}

	/**
	 * @param menuParentId
	 *            the menuParentId to set
	 */
	public void setMenuParentId(Long menuParentId) {
		this.menuParentId = menuParentId;
	}

	/**
	 * @return the menuParentName
	 */
	public String getMenuParentName() {
		return menuParentName;
	}

	/**
	 * @param menuParentName
	 *            the menuParentName to set
	 */
	public void setMenuParentName(String menuParentName) {
		this.menuParentName = menuParentName;
	}

	/**
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * @param menuName
	 *            the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * @return the menuUrl
	 */
	public String getMenuUrl() {
		return menuUrl;
	}

	/**
	 * @param menuUrl
	 *            the menuUrl to set
	 */
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	/**
	 * @return the menuAuth
	 */
	public String getMenuAuth() {
		return menuAuth;
	}

	/**
	 * @param menuAuth
	 *            the menuAuth to set
	 */
	public void setMenuAuth(String menuAuth) {
		this.menuAuth = menuAuth;
	}

	/**
	 * @return the menuType
	 */
	public Integer getMenuType() {
		return menuType;
	}

	/**
	 * @param menuType
	 *            the menuType to set
	 */
	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}

	/**
	 * @return the menuIcon
	 */
	public String getMenuIcon() {
		return menuIcon;
	}

	/**
	 * @param menuIcon
	 *            the menuIcon to set
	 */
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	/**
	 * @return the menuOrder
	 */
	public Integer getMenuOrder() {
		return menuOrder;
	}

	/**
	 * @param menuOrder
	 *            the menuOrder to set
	 */
	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}

	/**
	 * @return the open
	 */
	public Boolean getOpen() {
		return open;
	}

	/**
	 * @param open
	 *            the open to set
	 */
	public void setOpen(Boolean open) {
		this.open = open;
	}

	/**
	 * @return the children
	 */
	public List<SysMenuEntity> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<SysMenuEntity> children) {
		this.children = children;
	}

}