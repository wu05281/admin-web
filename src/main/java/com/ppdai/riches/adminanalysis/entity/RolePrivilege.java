package com.ppdai.riches.adminanalysis.entity;

import java.io.Serializable;

/**
 * 角色权限Bean
 * @author liufl / 2014年4月22日
 */
public class RolePrivilege implements Serializable {

	private static final long serialVersionUID = 3419768526893806079L;

	private Long sid; // 记录ID
	private Long roleSid; // 角色ID
	private Long privilegeSid; // 权限ID

	private String privilegeName; // 权限名
	private String privalegeCode; // 权限编码
	private boolean enable; // 是否启用

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
	 * 取出权限ID
	 * @return
	 */
	public Long getPrivilegeSid() {
		return privilegeSid;
	}

	/**
	 * 设置权限ID
	 * @param privilegeSid
	 */
	public void setPrivilegeSid(Long privilegeSid) {
		this.privilegeSid = privilegeSid;
	}

	/**
	 * 取出权限名
	 * @return
	 */
	public String getPrivilegeName() {
		return privilegeName;
	}

	/**
	 * 设置权限名
	 * @param privilegeName
	 */
	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	/**
	 * 取出权限编码
	 * @return
	 */
	public String getPrivalegeCode() {
		return privalegeCode;
	}

	/**
	 * 设置权限编码
	 * @param privalegeCode
	 */
	public void setPrivalegeCode(String privalegeCode) {
		this.privalegeCode = privalegeCode;
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

}
