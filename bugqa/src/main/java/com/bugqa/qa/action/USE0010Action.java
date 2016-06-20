package com.bugqa.qa.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.dto.USE0010ArgValue;
import com.bugqa.qa.model.form.USE0010Form;
import com.bugqa.qa.service.USE0010Service;
import com.bugqa.qa.utils.BaseConstants;
import com.bugqa.qa.utils.PageUtils;
import com.bugqa.qa.utils.RequestParameterManager;

public class USE0010Action extends BaseAction<USE0010Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(USE0010Action.class);

	@Resource
	private USE0010Service use0010Service;

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public String queryUser() {

		try {
			USE0010ArgValue arg = new USE0010ArgValue();
			arg = (USE0010ArgValue) RequestParameterManager.getArgValue(arg);

			Page page = PageUtils.initPage();
			model.setQueryUserList(use0010Service.queryUser(arg, page));
			model.setTotal(page.getTotal());
			model.setCurrentPage(page.getCurrentPage());

		} catch (Exception e) {
			logger.error(e.getMessage());
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(BaseConstants.ERRORINFO);
		}

		return JSON;

	}

	/**
	 * 删除用户
	 */
	public String deleteUser() {
		try {
			use0010Service.deleteUser(ServletActionContext.getRequest().getParameter("userId"));
		} catch (Exception e) {
			logger.error(e.getMessage());
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(BaseConstants.ERRORINFO);
		}

		return JSON;
	}
}
