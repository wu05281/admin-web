package com.ppdai.riches.adminanalysis.entity;

import java.io.Serializable;

/**
 * 用户角色Bean
 * @author liufl / 2014年4月22日
 */
public class UserRole implements Serializable {

	private static final long serialVersionUID = -717155768911427750L;

	private Long sid; // 记录ID
	private String username; // 用户名
	private Long roleSid; // 角色ID

	private boolean enable; // 启用
	private String rolename; // 角色名

	/**
	 * 取出记录ID
	 * @return
	 */
	public Long getSid() {
		return sid;
	}

	/**
	 * 设置记录ID
	 * @param sid
	 */
	public void setSid(Long sid) {
		this.sid = sid;
	}

	/**
	 * 取出用户名
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置记录名
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 取出角色ID
	 * @return
	 */
	public Long getRoleSid() {
		return roleSid;
	}

	/**
	 * 设置角色ID
	 * @param roleSid
	 */
	public void setRoleSid(Long roleSid) {
		this.roleSid = roleSid;
	}

	/**
	 * 是否启用
	 * @return
	 */
	public boolean isEnable() {
		return enable;
	}

	/**
	 * 设置是否启用
	 * @param enable
	 */
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	/**
	 * 取出角色名
	 * @return
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * 设置角色名
	 * @param rolename
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
