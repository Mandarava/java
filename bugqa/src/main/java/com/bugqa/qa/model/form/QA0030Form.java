package com.bugqa.qa.model.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bugqa.qa.model.dto.QAHistoryDTO;

public final class QA0030Form extends BaseForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<QAHistoryDTO> qaHistoryList = new ArrayList<>();

	public List<QAHistoryDTO> getQaHistoryList() {
		return qaHistoryList;
	}

	public void setQaHistoryList(List<QAHistoryDTO> qaHistoryList) {
		this.qaHistoryList = qaHistoryList;
	}

}
