package com.bugqa.qa.action;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bugqa.qa.model.dto.GRO0040ArgValue;
import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.form.GRO0040Form;
import com.bugqa.qa.service.GRO0040Service;
import com.bugqa.qa.utils.PageUtils;
import com.bugqa.qa.utils.RequestParameterManager;
import com.bugqa.qa.utils.SessionUtil;

public class GRO0040Action extends BaseAction<GRO0040Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(GRO0040Action.class);

	@Resource
	private GRO0040Service gro0040Service;

	/**
	 * group信息
	 * 
	 * @return
	 */
	public String groupList() {

		try {
			GRO0040ArgValue arg = new GRO0040ArgValue();
			arg = (GRO0040ArgValue) RequestParameterManager.getArgValue(arg);
			Page page = PageUtils.initPage();
			model.setGroupList(this.gro0040Service.groupList(arg, page));
			model.setTotal(page.getTotal());
			model.setCurrentPage(page.getCurrentPage());

		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 添加组成员
	 */
	public String addGroupMember() {
		try {
			HashMap<String, String> map = new HashMap<>();
			map.put("projectId", ServletActionContext.getRequest().getParameter("projectId"));
			map.put("groupId", ServletActionContext.getRequest().getParameter("groupId"));
			map.put("groupName", ServletActionContext.getRequest().getParameter("groupName"));
			map.put("updaterId", SessionUtil.getUser().getUserId());
			this.gro0040Service.addGroupMember(map);

		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 删除小组成员
	 */
	public String deleteGroupMember() {

		try {
			HashMap<String, String> map = new HashMap<>();
			map.put("projectId", ServletActionContext.getRequest().getParameter("projectId"));
			map.put("groupId", ServletActionContext.getRequest().getParameter("groupId"));
			this.gro0040Service.deleteGroupMember(map);

		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;

	}

}
