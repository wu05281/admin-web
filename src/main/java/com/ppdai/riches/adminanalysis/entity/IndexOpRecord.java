package com.ppdai.riches.adminanalysis.entity;

import java.util.Date;

/**
 * 操作记录
 * @author liufl / 2014年4月29日
 */
public class IndexOpRecord {

	private Long sid; // 记录ID
	private String action; // URI或操作
	private String param; // 参数
	private String caller; // 调用者
	private Date starttime; // 操作开始时间
	private Date endtime; // 操作结束时间
	private Integer status; // 操作状态
	private String memo; // 备注

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
	 * 取出URI或操作
	 * @return
	 */
	public String getAction() {
		return action;
	}

	/**
	 * 设置URI或操作
	 * @param action
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * 取出参数
	 * @return
	 */
	public String getParam() {
		return param;
	}

	/**
	 * 设置参数
	 * @param param
	 */
	public void setParam(String param) {
		this.param = param;
	}

	/**
	 * 取出调用者
	 * @return
	 */
	public String getCaller() {
		return caller;
	}

	/**
	 * 设置调用者
	 * @param caller
	 */
	public void setCaller(String caller) {
		this.caller = caller;
	}

	/**
	 * 取出操作开始时间
	 * @return
	 */
	public Date getStarttime() {
		return starttime;
	}

	/**
	 * 设置操作开始时间
	 * @param starttime
	 */
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	/**
	 * 取出操作结束时间
	 * @return
	 */
	public Date getEndtime() {
		return endtime;
	}

	/**
	 * 设置操作结束时间
	 * @param endtime
	 */
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	/**
	 * 取出操作状态
	 * @return
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置操作状态
	 * @param status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 取出备注
	 * @return
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * 设置备注
	 * @param memo
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

}
