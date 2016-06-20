package com.mbp.qa.model.form;

import java.io.Serializable;

import com.mbp.qa.utils.BaseConstants;

public class BaseForm implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 错误信息
	 */
	private String message = BaseConstants.BLANK;

	/**
	 * 状态
	 */
	private String status = BaseConstants.STR_0;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getSortKey() {
		return sortKey;
	}

	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}

}
