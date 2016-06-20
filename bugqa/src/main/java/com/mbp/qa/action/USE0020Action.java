package com.mbp.qa.action;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mbp.qa.interceptor.BusinessException;
import com.mbp.qa.model.dto.USE0020ArgValue;
import com.mbp.qa.model.form.USE0020Form;
import com.mbp.qa.service.USE0020Service;
import com.mbp.qa.utils.BaseConstants;
import com.mbp.qa.utils.RequestParameterManager;
import com.mbp.qa.utils.SessionUtil;

public class USE0020Action extends BaseAction<USE0020Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(USE0020Action.class);

	@Resource
	private USE0020Service use0020Service;

	/**
	 * 初始化ユーザー権限下拉框 取得汎用信息(ユーザー権限)
	 * 
	 * @return
	 */
	public String userPrevl() {

		try {
			model.setUserPrevlList(this.use0020Service.userPrevl());

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
	public String selCustCode() {

		try {
			model.setSelCustCodeList(this.use0020Service.selCustCode());

		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 会社フラグ变换 取得会社信息
	 * 
	 * @return
	 */
	public String customerMsg() {

		try {
			model.setCustomerMsg(this.use0020Service
					.customerMsg(ServletActionContext.getRequest().getParameter("companyFlg")));

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
			model.setDepartmentMsg(this.use0020Service
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
			model.setClassMsg(this.use0020Service.classMsg(map));

		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 插入ユーサー信息
	 * 
	 * @return
	 */
	public String addUserMsg() {

		try {
			USE0020ArgValue arg = new USE0020ArgValue();
			arg = (USE0020ArgValue) RequestParameterManager.getArgValue(arg);
			arg.setUpdaterId(SessionUtil.getUser().getUserId());
			String exit = use0020Service.addUserMsg(arg);
			model.setExitFlg(exit);
		} catch (BusinessException e) {
			logger.error(e.getMessage());
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(super.getMessage(e.getMessage()));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}
}