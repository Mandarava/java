package com.bugqa.qa.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bugqa.qa.model.dto.PRO0050ArgValue;
import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.form.PRO0050Form;
import com.bugqa.qa.service.PRO0050Service;
import com.bugqa.qa.utils.PageUtils;
import com.bugqa.qa.utils.RequestParameterManager;
import com.bugqa.qa.utils.SessionUtil;

public class PRO0050Action extends BaseAction<PRO0050Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(PRO0050Action.class);

	@Resource
	private PRO0050Service pro0050Service;

	/**
	 * 所有担当类型的取得 取得汎用信息(担当类型)
	 * 
	 * @return
	 */
	public String workTypeMsg() {
		try {
			model.setWorkTypeMsg(this.pro0050Service.workTypeMsg());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 初始化得意先下拉框 取得得意先信息(会社フラグ='0')
	 * 
	 * @return
	 */
	public String customerMsg() {

		try {
			model.setCustomerMsg(this.pro0050Service.customerMsg());
			model.setUserCustomerCode(
					this.pro0050Service.userCustomerCode(SessionUtil.getUser().getUserId()));
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
			model.setDepartmentMsg(this.pro0050Service
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
			model.setClassMsg(this.pro0050Service.classMsg(map));
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
	public String listUserMsg() {
		try {

			PRO0050ArgValue arg = new PRO0050ArgValue();
			arg = (PRO0050ArgValue) RequestParameterManager.getArgValue(arg);
			Page page = PageUtils.initPage();
			model.setListUserMsg(this.pro0050Service.listUserMsg(arg, page));
			model.setTotal(page.getTotal());
			model.setCurrentPage(page.getCurrentPage());

		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 插入メンバーマスター
	 * 
	 */
	public String insertUserMsg() {
		try {
			Map<String, Object> map = RequestParameterManager.requestToMap();
			map.put("projectId", ServletActionContext.getRequest().getParameter("projectId"));
			map.put("workType", ServletActionContext.getRequest().getParameter("workType"));
			map.put("userId", ServletActionContext.getRequest().getParameter("userId"));
			map.put("updaterId", SessionUtil.getUser().getUserId());
			pro0050Service.insertUserMsg(map);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}
}
