/**
 * 
 */
package com.songo.angular.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * <p>decription:</p>
 * <p>date:2014年7月9日 下午4:27:09</p>
 * @author gsu·napoleon
 */
public class BaseModel implements Serializable {

	/**
	 * <p>attribute:</p>
	 */
	private static final long serialVersionUID = -5479824001409279705L;
	
	private String creator;
	private String updator;
	private Timestamp createTime;
	private Timestamp updateTime;
	private boolean isvisible = true;// 默认可见
	
	/**
	 * @return the createTime
	 */
	public Timestamp getCreateTime() {
		return createTime == null ? new Timestamp(System.currentTimeMillis()) : createTime;
	}
	
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * @return the updateTime
	 */
	public Timestamp getUpdateTime() {
		return updateTime == null ? new Timestamp(System.currentTimeMillis()) : updateTime;
	}
	
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	/**
	 * @return the isvisible
	 */
	public boolean isIsvisible() {
		return isvisible;
	}
	
	/**
	 * @param isvisible the isvisible to set
	 */
	public void setIsvisible(boolean isvisible) {
		this.isvisible = isvisible;
	}

	/**
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * @param creator the creator to set
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * @return the updator
	 */
	public String getUpdator() {
		return updator;
	}

	/**
	 * @param updator the updator to set
	 */
	public void setUpdator(String updator) {
		this.updator = updator;
	}
	
}
