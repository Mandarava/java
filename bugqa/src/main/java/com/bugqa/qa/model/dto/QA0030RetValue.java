package com.bugqa.qa.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class QA0030RetValue implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<QAHistoryDTO> qaHistoryList = new ArrayList<>();

	public List<QAHistoryDTO> getQaHistoryList() {
		return qaHistoryList;
	}

	public void setQaHistoryList(List<QAHistoryDTO> qaHistoryList) {
		this.qaHistoryList = qaHistoryList;
	}

}
