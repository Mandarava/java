package com.mbp.qa.service;

import java.util.List;

import com.mbp.qa.model.dto.PRO0010ArgValue;
import com.mbp.qa.model.dto.Page;
import com.mbp.qa.model.po.ProjectMaster;

public interface PRO0010Service {

	/**
	 * 检索项目信息
	 * 
	 * @param arg
	 * @param page
	 * @return
	 */
	List<ProjectMaster> queryProject(PRO0010ArgValue arg, Page page);

	/**
	 * 删除项目
	 * 
	 * @param userId
	 */
	void deleteProject(String projectId);

}
