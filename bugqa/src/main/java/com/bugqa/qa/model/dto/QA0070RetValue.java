package com.bugqa.qa.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bugqa.qa.model.po.ModuleMaster;
import com.bugqa.qa.model.po.UserMaster;

/**
 * table导出QA情报DTO
 * 
 * @author zt c.
 *
 */
public final class QA0070RetValue implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ExcelQADTO> excelQAList = new ArrayList<>();

	private List<ModuleMaster> moduleList = new ArrayList<>();

	private List<UserMaster> userList = new ArrayList<>();

	ExcelProjectDTO project = new ExcelProjectDTO();

	public List<ExcelQADTO> getExcelQAList() {
		return excelQAList;
	}

	public void setExcelQAList(List<ExcelQADTO> excelQAList) {
		this.excelQAList = excelQAList;
	}

	public List<ModuleMaster> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<ModuleMaster> moduleList) {
		this.moduleList = moduleList;
	}

	public List<UserMaster> getUserList() {
		return userList;
	}

	public void setUserList(List<UserMaster> userList) {
		this.userList = userList;
	}

	public ExcelProjectDTO getProject() {
		return project;
	}

	public void setProject(ExcelProjectDTO project) {
		this.project = project;
	}

}
