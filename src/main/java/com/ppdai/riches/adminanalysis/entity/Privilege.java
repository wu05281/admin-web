package com.ppdai.riches.adminanalysis.entity;

import java.io.Serializable;

/**
 * 权限Bean
 * @author liufl / 2014年4月22日
 */
public class Privilege implements Serializable {

	private static final long serialVersionUID = -1514905883366318398L;

	private Long sid; // 记录ID
	private String name; // 权限名
	private String code; // 权限编码

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
	 * 取出权限名
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置权限名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 取出权限编码
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置权限编码
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
