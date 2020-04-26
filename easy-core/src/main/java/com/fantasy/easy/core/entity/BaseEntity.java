/**
 * BaseVO.java
 * @author Fantasy Lan
 */
package com.fantasy.easy.core.entity;

import java.util.Date;

import com.fantasy.easy.core.util.ShiroUtils;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Fantasy Lan
 * @since 2019年12月19日 : 下午11:32:19
 */
public class BaseEntity {

	private Long createBy;
	private Long updateBy;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/**
	 * @return the createBy
	 */
	public Long getCreateBy() {
		return createBy;
	}
	/**
	 * @param createBy the createBy to set
	 */
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	/**
	 * @return the updateBy
	 */
	public Long getUpdateBy() {
		return updateBy;
	}
	/**
	 * @param updateBy the updateBy to set
	 */
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Long getCurrentUserId() {
		return ShiroUtils.getUserId();
	}
	
}
