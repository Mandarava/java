package com.bugqa.qa.model.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bugqa.qa.model.dto.QAMyNoticeDTO;
import com.bugqa.qa.model.dto.QAMyWorkDTO;

public final class MAI0061Form extends BaseForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<QAMyWorkDTO> qaMyWorkList = new ArrayList<>();

	private List<QAMyNoticeDTO> qaMyNoticeList = new ArrayList<>();

	public List<QAMyWorkDTO> getQaMyWorkList() {
		return qaMyWorkList;
	}

	public void setQaMyWorkList(List<QAMyWorkDTO> qaMyWorkList) {
		this.qaMyWorkList = qaMyWorkList;
	}

	public List<QAMyNoticeDTO> getQaMyNoticeList() {
		return qaMyNoticeList;
	}

	public void setQaMyNoticeList(List<QAMyNoticeDTO> qaMyNoticeList) {
		this.qaMyNoticeList = qaMyNoticeList;
	}

}
