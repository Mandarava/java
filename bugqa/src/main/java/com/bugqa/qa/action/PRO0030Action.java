package com.bugqa.qa.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bugqa.qa.interceptor.BusinessException;
import com.bugqa.qa.model.dto.PRO0030ArgValue;
import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.form.PRO0030Form;
import com.bugqa.qa.service.PRO0030Service;
import com.bugqa.qa.utils.BaseConstants;
import com.bugqa.qa.utils.PageUtils;
import com.bugqa.qa.utils.RequestParameterManager;
import com.bugqa.qa.utils.SessionUtil;

public class PRO0030Action extends BaseAction<PRO0030Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(PRO0030Action.class);

	@Resource
	private PRO0030Service pro0030Service;

	private File fileField;

	public File getFileField() {
		return fileField;
	}

	public void setFileField(File fileField) {
		this.fileField = fileField;
	}

	/**
	 * 取得项目信息
	 */
	public String projectList() {

		try {
			model.setProjectList(this.pro0030Service
					.projectList(ServletActionContext.getRequest().getParameter("projectId")));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;

	}

	/**
	 * 初始化状態下拉框 取得汎用信息(プロジェクト状態)
	 * 
	 * @return
	 */
	public String proStage() {
		try {
			model.setProStage(this.pro0030Service.proStage());
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
			model.setCustomerMsg(this.pro0030Service
					.customerMsg(ServletActionContext.getRequest().getParameter("companyFlg")));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;

	}

	/**
	 * 取得项目成员信息
	 */
	public String projectMemberList() {

		try {
			PRO0030ArgValue arg = new PRO0030ArgValue();
			arg = (PRO0030ArgValue) RequestParameterManager.getArgValue(arg);
			Page page = PageUtils.initPage();
			model.setProjectMemberList(pro0030Service.projectMemberList(arg, page));
			model.setTotal(page.getTotal());
			model.setCurrentPage(page.getCurrentPage());

		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;

	}

	/**
	 * 取得项目经理信息
	 */
	public String projectManagerMsg() {
		try {
			model.setProjectManagerMsg(this.pro0030Service.projectManagerMsg(
					ServletActionContext.getRequest().getParameter("projectId")));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 删除项目成员
	 */
	public String deleteProjectMember() {

		try {
			HashMap<String, String> map = new HashMap<>();
			map.put("userId", ServletActionContext.getRequest().getParameter("userId"));
			map.put("projectId", ServletActionContext.getRequest().getParameter("projectId"));
			pro0030Service.deleteMember(map);

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

		String chargeIdBefore = ServletActionContext.getRequest().getParameter("chargeIdBefore");
		String chargeNameBefore = ServletActionContext.getRequest()
				.getParameter("chargeNameBefore");
		String chargeIdReturn = ServletActionContext.getRequest().getParameter("chargeIdReturn");
		String chargeNameReturn = ServletActionContext.getRequest()
				.getParameter("chargeNameReturn");
		String managerIdBefore = ServletActionContext.getRequest().getParameter("managerIdBefore");
		String managerNameBefore = ServletActionContext.getRequest()
				.getParameter("managerNameBefore");
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
		session.put("chargeIdBefore", chargeIdBefore);
		session.put("chargeNameBefore", chargeNameBefore);
		session.put("chargeIdReturn", chargeIdReturn);
		session.put("chargeNameReturn", chargeNameReturn);
		session.put("managerIdBefore", managerIdBefore);
		session.put("managerNameBefore", managerNameBefore);
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
			map.put("chargeIdBefore", session.get("chargeIdBefore"));
			map.put("chargeNameBefore", session.get("chargeNameBefore"));
			map.put("chargeIdReturn", session.get("chargeIdReturn"));
			map.put("chargeNameReturn", session.get("chargeNameReturn"));
			map.put("managerIdBefore", session.get("managerIdBefore"));
			map.put("managerNameBefore", session.get("managerNameBefore"));
			map.put("managerIdReturn", session.get("managerIdReturn"));
			map.put("managerNameReturn", session.get("managerNameReturn"));

			model.setBeforeMsgReturn(map);

		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 更新项目信息
	 */
	public String updateProjectMsg() {

		try {

			PRO0030ArgValue arg = new PRO0030ArgValue();
			arg = (PRO0030ArgValue) RequestParameterManager.getArgValue(arg);
			arg.setUpdaterId(SessionUtil.getUser().getUserId());
			pro0030Service.updateProjectMsg(arg);

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

	/**
	 * modulemessage
	 */
	public String moduleMsg() {

		try {
			model.setModuleMsg(this.pro0030Service
					.moduleMsg(ServletActionContext.getRequest().getParameter("projectId")));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;

	}

	/**
	 * 创建模板
	 */
	public String exportCsv() {
		// TODO
		return JSON;
	}

	/**
	 * 模板导入
	 */
	public String importCsv() {
		// TODO
		return JSON;
	}
}
