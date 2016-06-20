package com.bugqa.qa.model.dto;

import java.io.Serializable;

public class COM0010ArgValue extends BaseArgValue implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 检索条件
	 */
	private String searchKey;
	
	public String getSearchKey(){
		return searchKey;
	}
	
	public void setSearchKey(String searchKey){
		this.searchKey  = searchKey;
	}
	
}
