package com.bugqa.qa.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bugqa.qa.model.dto.PRO0010ArgValue;
import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.form.PRO0010Form;
import com.bugqa.qa.service.PRO0010Service;
import com.bugqa.qa.utils.PageUtils;
import com.bugqa.qa.utils.RequestParameterManager;

public class PRO0010Action extends BaseAction<PRO0010Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(USE0010Action.class);

	@Resource
	private PRO0010Service pro0010Service;

	/**
	 * 检索项目信息
	 * 
	 * @return
	 */
	public String queryProject() {
		try {
			PRO0010ArgValue arg = new PRO0010ArgValue();
			arg = (PRO0010ArgValue) RequestParameterManager.getArgValue(arg);
			Page page = PageUtils.initPage();
			model.setQueryProject(pro0010Service.queryProject(arg, page));
			model.setTotal(page.getTotal());
			model.setCurrentPage(page.getCurrentPage());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;

	}

	/**
	 * 删除项目
	 */
	public String deleteProject() {
		try {
			pro0010Service
					.deleteProject(ServletActionContext.getRequest().getParameter("projectId"));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}
}
