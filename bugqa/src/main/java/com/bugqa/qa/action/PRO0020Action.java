package com.bugqa.qa.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bugqa.qa.interceptor.BusinessException;
import com.bugqa.qa.model.dto.PRO0020ArgValue;
import com.bugqa.qa.model.form.PRO0020Form;
import com.bugqa.qa.service.PRO0020Service;
import com.bugqa.qa.utils.BaseConstants;
import com.bugqa.qa.utils.RequestParameterManager;
import com.bugqa.qa.utils.SessionUtil;

public class PRO0020Action extends BaseAction<PRO0020Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(USE0020Action.class);

	@Resource
	private PRO0020Service pro0020Service;

	/**
	 * 初始化状態下拉框 取得汎用信息(プロジェクト状態)
	 * 
	 * @return
	 */
	public String proStage() {
		try {
			model.setProStage(this.pro0020Service.proStage());
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;

	}

	/**
	 * 初始化会社名下拉框 取得本会社信息 初始化得意先下拉框 取得得意先信息
	 * 
	 * @return
	 */
	public String customerMsg() {
		try {
			model.setCustomerMsg(this.pro0020Service
					.customerMsg(ServletActionContext.getRequest().getParameter("companyFlg")));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;

	}

	/**
	 * プロジェクト相关信息的登录
	 */
	public String addProjectMsg() {
		try {
			PRO0020ArgValue arg = new PRO0020ArgValue();
			arg = (PRO0020ArgValue) RequestParameterManager.getArgValue(arg);
			arg.setUpdaterId(SessionUtil.getUser().getUserId());
			String exit = pro0020Service.addProjectMsg(arg);
			model.setExitFlg(exit);
		} catch (BusinessException e) {
			logger.error(e.getMessage());
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(super.getMessage(e.getMessage()));
			return JSON;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 页面值放入session
	 * 
	 * @return
	 */
	public String beforeMsg() {

		// 取值
		String projectId = ServletActionContext.getRequest().getParameter("projectId");
		String projectName = ServletActionContext.getRequest().getParameter("projectName");
		String companyInCode = ServletActionContext.getRequest().getParameter("companyInCode");
		String companOutCode = ServletActionContext.getRequest().getParameter("companOutCode");
		String stateFlg = ServletActionContext.getRequest().getParameter("stateFlg");
		String startDate = ServletActionContext.getRequest().getParameter("startDate");
		String endDate = ServletActionContext.getRequest().getParameter("endDate");
		String chkEndDate = ServletActionContext.getRequest().getParameter("chkEndDate");
		String chargeIdReturn = ServletActionContext.getRequest().getParameter("chargeIdReturn");
		String chargeNameReturn = ServletActionContext.getRequest()
				.getParameter("chargeNameReturn");
		String managerIdReturn = ServletActionContext.getRequest().getParameter("managerIdReturn");
		String managerNameReturn = ServletActionContext.getRequest()
				.getParameter("managerNameReturn");

		// 插入session
		session.put("projectIds", projectId);
		session.put("projectName", projectName);
		session.put("companyInCode", companyInCode);
		session.put("companOutCode", companOutCode);
		session.put("startDate", startDate);
		session.put("endDate", endDate);
		session.put("chkEndDate", chkEndDate);
		session.put("stateFlg", stateFlg);
		session.put("chargeIdReturn", chargeIdReturn);
		session.put("chargeNameReturn", chargeNameReturn);
		session.put("managerIdReturn", managerIdReturn);
		session.put("managerNameReturn", managerNameReturn);

		return SUCCESS;
	}

	/**
	 * 取出缓存数据
	 * 
	 * @return
	 */
	public String beforeMsgReturn() {
		try {
			Map<String, Object> map = RequestParameterManager.requestToMap();

			map.put("projectId", session.get("projectIds"));
			map.put("projectName", session.get("projectName"));
			map.put("companyInCode", session.get("companyInCode"));
			map.put("companOutCode", session.get("companOutCode"));
			map.put("stateFlg", session.get("stateFlg"));
			map.put("startDate", session.get("startDate"));
			map.put("endDate", session.get("endDate"));
			map.put("chkEndDate", session.get("chkEndDate"));

			map.put("chargeIdReturn", session.get("chargeIdReturn"));
			map.put("chargeNameReturn", session.get("chargeNameReturn"));
			map.put("managerIdReturn", session.get("managerIdReturn"));
			map.put("managerNameReturn", session.get("managerNameReturn"));

			model.setBeforeMsgReturn(map);

		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}

}
