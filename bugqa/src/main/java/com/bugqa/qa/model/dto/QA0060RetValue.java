package com.bugqa.qa.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 预定义QA检索信息
 * 
 * @author zt
 *
 */
public final class QA0060RetValue implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 预定义QA检索
	 */
	private List<BaseQADTO> baseQAList = new ArrayList<>();

	public List<BaseQADTO> getBaseQAList() {
		return baseQAList;
	}

	public void setBaseQAList(List<BaseQADTO> baseQAList) {
		this.baseQAList = baseQAList;
	}

}
