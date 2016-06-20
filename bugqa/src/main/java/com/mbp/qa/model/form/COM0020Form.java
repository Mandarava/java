package com.mbp.qa.model.form;

import java.io.Serializable;
import java.util.List;

import com.mbp.qa.model.po.GeneralMaster;

public final class COM0020Form extends BaseForm implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<GeneralMaster> updateGeneralMsg;
	
	public List<GeneralMaster> getUpdateGeneralMsg() {
		return updateGeneralMsg;
	}

	public void setUpdateGeneralMsg(List<GeneralMaster> updateGeneralMsg) {
		this.updateGeneralMsg = updateGeneralMsg;
	}
	
}
