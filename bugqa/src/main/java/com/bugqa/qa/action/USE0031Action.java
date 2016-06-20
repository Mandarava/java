package com.bugqa.qa.action;

import java.io.IOException;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bugqa.qa.interceptor.BusinessException;
import com.bugqa.qa.model.dto.USE0031ArgValue;
import com.bugqa.qa.model.form.USE0031Form;
import com.bugqa.qa.service.USE0031Service;
import com.bugqa.qa.utils.BaseConstants;
import com.bugqa.qa.utils.RequestParameterManager;
import com.bugqa.qa.utils.SessionUtil;

public class USE0031Action extends BaseAction<USE0031Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(USE0031Action.class);

	@Resource
	private USE0031Service use0031Service;

	/**
	 * 判断ユーザー是否管理员
	 * 
	 * @return
	 */
	public String userPrevlCheck() {
		try {
			boolean userPrevl = this.use0031Service
					.userPrevlCheck(SessionUtil.getUser().getUserId());
			if (userPrevl) {
				model.setFlag(true);
			} else {
				model.setFlag(false);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			model.setStatus(BaseConstants.STATUSFAILURE);
		}

		return JSON;
	}

	/**
	 * 取得当前ユーザー信息
	 * 
	 * @return
	 */
	public String userMsg() {
		try {
			model.setUserMsg(this.use0031Service
					.userMsg(ServletActionContext.getRequest().getParameter("userId")));

		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;

	}

	/**
	 * 初始化ユーザー権限下拉框 取得汎用信息(ユーザー権限)
	 * 
	 * @return
	 */
	public String userPrevlList() {
		try {
			model.setUserPrevlList(this.use0031Service.userPrevl());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 初始化得意先下拉框 取得得意先信息 会社フラグ变换 取得会社信息
	 */
	public String customerMsg() {
		try {
			model.setCustomerMsg(this.use0031Service
					.customerMsg(ServletActionContext.getRequest().getParameter("companyFlg")));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 初始化部門下拉框 取得当前ユーザー所在的会社的所有部門信息 得意先变换 取得当前选中的得意先的所有部门信息
	 * 
	 */
	public String departmentMsg() {
		try {
			model.setDepartmentMsg(this.use0031Service
					.departmentMsg(ServletActionContext.getRequest().getParameter("customerCode")));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 初始化课下拉框 取得当前ユーザー所在的部門的所有課信息 部门变换 取得当前部门的所有课信息
	 */
	public String classMsg() {
		try {
			HashMap<String, String> map = new HashMap<>();
			map.put("customerCode", ServletActionContext.getRequest().getParameter("customerCode"));
			map.put("departmentId", ServletActionContext.getRequest().getParameter("departmentId"));
			model.setClassMsg(this.use0031Service.classMsg(map));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 更新ユーザー信息
	 */
	public String updateUser() {
		try {
			USE0031ArgValue arg = new USE0031ArgValue();
			arg = (USE0031ArgValue) RequestParameterManager.getArgValue(arg);
			arg.setUpdaterId(SessionUtil.getUser().getUserId());
			use0031Service.updateUser(arg);
		} catch (BusinessException e) {
			logger.error(e.getMessage());
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(super.getMessage(e.getMessage()));
		} catch (IOException e) {
			logger.error(e.getMessage());
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage("upload file failed!");
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}

}
