package com.spring.demo.biz.dto;

import java.io.Serializable;

/**
 * 系统用户.
 * <p>
 * 客户可以通过扩展该对象实现更多功能.
 * 
 * @author cissalc    liuxiangfei
 */
public class User implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = -7553414561589719526L;
	/**
	 * 登录账号
	 */
	protected String userId;

	/**
	 * 账号对应的中文名字
	 */
	protected String userName;

	/**
	 * 密码, 有可能是SHA散列后的形式.
	 */
	protected String password;

	/**
	 * 是否有效.<br>
	 * 1 - 有效; 0 - 失效.
	 */
	protected String enabled;

	/**
	 * 移动电话
	 */
	protected String mobilePhone;
	
	/*
	 * 入职时间
	 */
	private String entryDate;

	/*
	 * 离职时间
	 */
	private String leaveDate;

	/*
	 * 创建时间
	 */
	private String createdBy;

	/*
	 * 创建人
	 */
	private String createdDate;

	/*
	 * 更新时间
	 */
	private String updatedBy;

	/*
	 * 更新人
	 */
	private String updatedDate;

	/**
	 * 电邮地址
	 */
	protected String email;
	/**
	 * 所在部门编号
	 */
	protected String deptCode;
	
	/**
	 * 所在部门名称
	 */
	protected String deptName;	

	
	
	////页面展示使用字段
	/**
	 * 新密码，重设密码时使用
	 */
	protected String newPassword;

	/**
	 * 所属岗位编号
	 */
	protected String posCode;
	
	/**
	 * 所属岗位名称
	 */
	protected String posName;
	

	public String getEnabled() {
		return enabled;
	}
	
	public boolean getIsEnabled() {
		return "1".equals(enabled);
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	/**
	 * @param userId
	 * @param userName
	 */
	public User() {
	}
	/**
	 * @param userId
	 * @param userName
	 */
	public User(String userId, String userName) {
		this.userId = userId;
		this.userName = userName;
		this.enabled = "1";
	}

	/**
	 * @param userId
	 * @param userName
	 * @param password
	 */
	public User(String userId, String userName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.enabled = "1";
	}


	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName
	 *            the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return the posCode
	 */
	public String getPosCode() {
		return posCode;
	}

	/**
	 * @param posCode
	 *            the posCode to set
	 */
	public void setPosCode(String posCode) {
		this.posCode = posCode;
	}

	/**
	 * @return the posName
	 */
	public String getPosName() {
		return posName;
	}

	/**
	 * @param posName
	 *            the posName to set
	 */
	public void setPosName(String posName) {
		this.posName = posName;
	}

	/**
	 * @return the mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @param mobilePhone
	 *            the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", password=" + password + ", enabled=" + enabled
				+ ", mobilePhone=" + mobilePhone + ", entryDate=" + entryDate
				+ ", leaveDate=" + leaveDate + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + ", email=" + email
				+ ", newPassword=" + newPassword + ", deptCode=" + deptCode
				+ ", deptName=" + deptName + ", posCode=" + posCode
				+ ", posName=" + posName + "]";
	}

}
