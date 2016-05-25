package com.ppdai.riches.adminanalysis.entity;

/**
 * 建议词Bean
 * @author liufl / 2014年4月28日
 */
public class Suggestion {

	private Long sid; // 记录ID
	private String keyword; // 关键词

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
	 * 取出关键词
	 * @return
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * 设置关键词
	 * @param keyword
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
