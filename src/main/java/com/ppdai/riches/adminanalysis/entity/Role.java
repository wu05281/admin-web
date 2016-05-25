package com.ppdai.riches.adminanalysis.entity;

import java.io.Serializable;

/**
 * 角色Bean
 * @author liufl / 2014年4月22日
 */
public class Role implements Serializable {

	private static final long serialVersionUID = 6824516420864583431L;

	private Long sid; // 记录ID
	private String name; // 角色名

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
	 * 取出角色名
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置角色名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
