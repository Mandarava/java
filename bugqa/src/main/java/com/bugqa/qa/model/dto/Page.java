package com.bugqa.qa.model.dto;

import java.io.Serializable;

public class Page implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 当前第几页
	 */
	private int currentPage;
	/**
	 * 数据库中limit的参数，从第几条开始取
	 */
	private int offset;
	/**
	 * 数据库中limit的参数，一共取多少条
	 */
	private int limit;

	/**
	 * 总件数
	 */
	private int total;

	/**
	 * 排序语句
	 */
	private String sortKey;

	public String getSortKey() {
		return sortKey;
	}

	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
