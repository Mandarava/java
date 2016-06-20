package com.bugqa.qa.model.form;

import java.io.Serializable;
import java.util.List;

import com.bugqa.qa.model.po.GeneralMaster;

public final class COM0010Form extends BaseForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<GeneralMaster> generalMsg;
	
	public List<GeneralMaster> getGeneralMsg() {
		return generalMsg;
	}

	public void setGeneralMsg(List<GeneralMaster> generalMsg) {
		this.generalMsg = generalMsg;
	}

}
