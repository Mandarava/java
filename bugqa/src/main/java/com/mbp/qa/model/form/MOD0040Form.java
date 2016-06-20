package com.mbp.qa.model.form;

import java.io.Serializable;
import java.util.List;

import com.mbp.qa.model.po.ModuleMaster;

public final class MOD0040Form extends BaseForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 模块信息
	 */
	private List<ModuleMaster> moduleList;
	
	public List<ModuleMaster> getModuleList() {
		return moduleList;
	}
	
	public void setModuleList(List<ModuleMaster> moduleList){
		this.moduleList = moduleList;
	}

}
