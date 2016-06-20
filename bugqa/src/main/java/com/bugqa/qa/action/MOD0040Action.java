package com.bugqa.qa.action;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bugqa.qa.model.dto.MOD0040ArgValue;
import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.form.MOD0040Form;
import com.bugqa.qa.service.MOD0040Service;
import com.bugqa.qa.utils.PageUtils;
import com.bugqa.qa.utils.RequestParameterManager;
import com.bugqa.qa.utils.SessionUtil;

public class MOD0040Action extends BaseAction<MOD0040Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(MOD0040Action.class);

	@Resource
	private MOD0040Service mod0040Service;

	/**
	 * 检索模块信息
	 * 
	 * @return
	 */
	public String moduleList() {

		try {
			MOD0040ArgValue arg = new MOD0040ArgValue();
			arg = (MOD0040ArgValue) RequestParameterManager.getArgValue(arg);
			Page page = PageUtils.initPage();
			model.setModuleList(this.mod0040Service.moduleList(arg, page));
			model.setTotal(page.getTotal());
			model.setCurrentPage(page.getCurrentPage());

		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 添加模块信息
	 */
	public String addModule() {
		try {
			HashMap<String, String> map = new HashMap<>();
			map.put("projectId", ServletActionContext.getRequest().getParameter("projectId"));
			map.put("groupId", ServletActionContext.getRequest().getParameter("groupId"));
			map.put("moduleId", ServletActionContext.getRequest().getParameter("moduleId"));
			map.put("moduleName", ServletActionContext.getRequest().getParameter("moduleName"));
			map.put("updaterId", SessionUtil.getUser().getUserId());
			this.mod0040Service.addModule(map);

		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 删除模块信息
	 */
	public String deleteModule() {

		try {
			HashMap<String, String> map = new HashMap<>();
			map.put("projectId", ServletActionContext.getRequest().getParameter("projectId"));
			map.put("groupId", ServletActionContext.getRequest().getParameter("groupId"));
			map.put("moduleId", ServletActionContext.getRequest().getParameter("moduleId"));
			this.mod0040Service.deleteModule(map);

		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;

	}

}
