package com.mbp.qa.model.dto;

import java.io.Serializable;

public class CST0010ArgValue extends BaseArgValue implements Serializable {

	private static final long serialVersionUID = 1L;
	//检索条件
	private String serchKey;
	//隐藏radio
	private String serchflg;

	/**
	 * 取得检索条件
	 * 
	 * @return
	 */
	public String getSerchKey() {
		return serchKey;
	}
	
	/**
	 * 设置检索条件
	 * @param serchKey
	 */
	public void setSerchKey(String serchKey) {
		this.serchKey = serchKey;
	}
	
	/**
	 * 取得隐藏radio的值
	 * 
	 * @return
	 */
	public String getSerchflg() {
		return serchflg;
	}
	
	/**
	 * 设置隐藏radio
	 * @param rdHidden
	 */
	public void setSerchflg(String serchflg) {
		this.serchflg = serchflg;
	}

	
	
}
