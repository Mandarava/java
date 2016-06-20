package com.bugqa.qa.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bugqa.qa.interceptor.BusinessException;
import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.form.CST0040Form;
import com.bugqa.qa.model.po.DepartmentMaster;
import com.bugqa.qa.service.CST0040Service;
import com.bugqa.qa.utils.BaseConstants;
import com.bugqa.qa.utils.MessageConstants;
import com.bugqa.qa.utils.PageUtils;
import com.bugqa.qa.utils.RequestParameterManager;
import com.bugqa.qa.utils.SessionUtil;

public class CST0040Action extends BaseAction<CST0040Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(CST0040Action.class);

	@Resource
	private CST0040Service cst0040Service;

	private DepartmentMaster departmentpo = new DepartmentMaster();

	/**
	 * CST0040取得部门信息list
	 * 
	 * @return json
	 */
	public String getDepartmentInfo() {
		try {
			// 取得客户编号
			String customerCode = (String) ServletActionContext.getRequest().getSession()
					.getAttribute("customerCode");
			Page page = PageUtils.initPage();
			// 调用Service
			List<DepartmentMaster> departmentpo = cst0040Service
					.getDepartmentInfoService(customerCode, page);
			// 把客户编号存在session
			ServletActionContext.getRequest().getSession().setAttribute("customerCode",
					customerCode);
			// 把部门Id放进session
			for (int i = 0; i < departmentpo.size(); i++) {
				ServletActionContext.getRequest().getSession().setAttribute("departmentId",
						departmentpo.get(i).getDepartmentId());
			}
			// 把部门名称放进session
			for (int i = 0; i < departmentpo.size(); i++) {
				ServletActionContext.getRequest().getSession().setAttribute("departmentName",
						departmentpo.get(i).getDepartmentName());
			}
			model.setCurrentPage(page.getCurrentPage());
			model.setTotal(page.getTotal());
			model.setDepartmentpo(departmentpo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * CST0040保存部门信息
	 * 
	 * @return success
	 */
	public String saveDept() {
		try {
			// 取得JS传来的客户编号
			String customerCode = ServletActionContext.getRequest().getParameter("customerCode");
			// 取得页面表单上的信息
			Map<String, Object> inputField = RequestParameterManager.requestToMap();
			// 将表单上的信息赋给departmentpo
			BeanUtils.populate(departmentpo, inputField);
			// 将JS传来的客户编号赋给departmentpo
			departmentpo.setCustomerCode(customerCode);
			// 取得登陆者帐号
			departmentpo.setUpdaterId(SessionUtil.getUser().getUserId());
			// 调用存在性check
			if (cst0040Service.departmentIdCheck(customerCode,
					departmentpo.getDepartmentId()) > 0) {
				model.setStatus(BaseConstants.STATUSFAILURE);
				model.setMessage(super.getMessage(MessageConstants.USE0005,
						new String[] { super.getMessage(MessageConstants.USE0005DEPTID) }));

			} else {
				// 调用保存部门Service
				cst0040Service.saveDepartment(departmentpo);
			}
		} catch (BusinessException e) {
			logger.error(e.getMessage());
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage("upload file failed!");
			return JSON;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * CST0040追加部门
	 * 
	 * @return success
	 */
	public String addDept() {
		try {
			// 取得客户编号
			String customerCode = ServletActionContext.getRequest().getParameter("customerCode");
			// 取得页面表单上的信息
			Map<String, Object> inputField = RequestParameterManager.requestToMap();
			// 将表单上的信息赋给departmentpo
			BeanUtils.populate(departmentpo, inputField);
			// 将客户编号赋给departmentpo
			departmentpo.setCustomerCode(customerCode);
			// 取得登陆者帐号
			departmentpo.setUpdaterId(SessionUtil.getUser().getUserId());
			// 调用存在性check
			if (cst0040Service.departmentIdCheck(customerCode,
					departmentpo.getDepartmentId()) > 0) {
				model.setStatus(BaseConstants.STATUSFAILURE);
				model.setMessage(super.getMessage(MessageConstants.USE0005,
						new String[] { super.getMessage(MessageConstants.USE0005DEPTID) }));

			} else {
				// 调用追加部门Service
				cst0040Service.addDepartment(departmentpo);
			}
		} catch (BusinessException e) {
			logger.error(e.getMessage());
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage("Add failed!");
			return JSON;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * CST0040删除部门信息
	 * 
	 * @return success
	 */
	public String deleteDept() {
		try {
			// 取得客户编号
			String customerCode = ServletActionContext.getRequest().getParameter("customerCode");
			// 取得部门Id
			String departmentId = ServletActionContext.getRequest().getParameter("departmentId");
			// 调用删除方法
			cst0040Service.deleteDept(customerCode, departmentId);
			model.setMessage(super.getMessage(MessageConstants.COM0003));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}
		return JSON;
	}
}
