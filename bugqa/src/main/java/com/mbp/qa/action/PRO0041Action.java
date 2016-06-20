package com.mbp.qa.action;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mbp.qa.model.dto.PRO0041ArgValue;
import com.mbp.qa.model.dto.Page;
import com.mbp.qa.model.form.PRO0041Form;
import com.mbp.qa.service.PRO0041Service;
import com.mbp.qa.utils.PageUtils;
import com.mbp.qa.utils.RequestParameterManager;
import com.mbp.qa.utils.SessionUtil;

public class PRO0041Action extends BaseAction<PRO0041Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(PRO0041Action.class);

	@Resource
	private PRO0041Service pro0041Service;

	/**
	 * 初始化得意先下拉框 取得得意先信息(会社フラグ='0')
	 * 
	 * @return
	 */
	public String customerMsg() {
		try {
			// 得意先下拉框信息
			model.setCustomerMsg(this.pro0041Service.customerMsg());
			// 当前用户信息
			model.setUserCustomerCode(
					this.pro0041Service.userCustomerCode(SessionUtil.getUser().getUserId()));
			// 当前用户项目id
			model.setUserProjectMsg(
					this.pro0041Service.userProjectMsg(SessionUtil.getUser().getUserId()));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;

	}

	/**
	 * 得意先变换 取得当前选中的得意先的所有部门信息
	 */
	public String departmentMsg() {
		try {
			model.setDepartmentMsg(this.pro0041Service
					.departmentMsg(ServletActionContext.getRequest().getParameter("customerCode")));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;

	}

	/**
	 * 部门变换 取得当前部门的所有课信息
	 * 
	 */
	public String classMsg() {
		try {
			HashMap<String, String> map = new HashMap<>();
			map.put("customerCode", ServletActionContext.getRequest().getParameter("customerCode"));
			map.put("departmentId", ServletActionContext.getRequest().getParameter("departmentId"));
			model.setClassMsg(this.pro0041Service.classMsg(map));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;

	}

	/**
	 * 初始化リスト部 取得ユーザー信息
	 * 
	 */
	public String userMsgSelect() {
		try {
			PRO0041ArgValue arg = new PRO0041ArgValue();
			arg = (PRO0041ArgValue) RequestParameterManager.getArgValue(arg);
			Page page = PageUtils.initPage();
			model.setUserMsgSelect(pro0041Service.userMsgSelect(arg, page));
			model.setTotal(page.getTotal());
			model.setCurrentPage(page.getCurrentPage());

		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;

	}

}
