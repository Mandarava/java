package com.bugqa.qa.model.dto;

import java.io.Serializable;

public class PRO0010ArgValue extends BaseArgValue implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 检索条件
	 */
	private String searchKey;
	
	
	/**
	 * 删除状态
	 */
	private String deleteFlg;
	
	public String getSearchKey(){
		return searchKey;
	}
	
	public void setSearchKey(String searchKey){
		this.searchKey  = searchKey;
	}
	
	public String getDeleteFlg(){
		return deleteFlg;
	}
	
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg = deleteFlg;
	}
}
