package com.ppdai.riches.adminanalysis.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 排序分类Bean
 * @author liufl / 2014年6月10日
 */
public class Category implements Comparable<Category> {

	private Long sid; // 分类ID
	private String name; // 分类名
	private Long weight; // 排序权重

	private List<Category> children = new ArrayList<Category>(); // 子分类列表

	/**
	 * 取出分类ID
	 * @return
	 */
	public Long getSid() {
		return sid;
	}

	/**
	 * 设置分类ID
	 * @param sid
	 */
	public void setSid(Long sid) {
		this.sid = sid;
	}

	/**
	 * 取出分类名
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置分类名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 取出排序权重
	 * @return
	 */
	public Long getWeight() {
		return weight;
	}

	/**
	 * 设置排序权重
	 * @param weight
	 */
	public void setWeight(Long weight) {
		this.weight = weight;
	}

	/**
	 * 取出子分类列表
	 * @return
	 */
	public List<Category> getChildren() {
		return children;
	}

	@Override
	public int compareTo(Category o) {
		// 倒序排序
		return (int) (o.weight - this.weight);
	}

}
