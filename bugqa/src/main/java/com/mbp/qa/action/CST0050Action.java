package com.mbp.qa.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mbp.qa.interceptor.BusinessException;
import com.mbp.qa.model.dto.Page;
import com.mbp.qa.model.form.CST0050Form;
import com.mbp.qa.model.po.ClassMaster;
import com.mbp.qa.service.CST0050Service;
import com.mbp.qa.utils.BaseConstants;
import com.mbp.qa.utils.MessageConstants;
import com.mbp.qa.utils.PageUtils;
import com.mbp.qa.utils.RequestParameterManager;
import com.mbp.qa.utils.SessionUtil;

public class CST0050Action extends BaseAction<CST0050Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(CST0050Action.class);

	@Resource
	private CST0050Service cst0050Service;

	private List<ClassMaster> classList = new ArrayList<ClassMaster>();

	private ClassMaster classpo = new ClassMaster();

	/**
	 * CST0040取得课室信息list
	 * 
	 * @return json
	 */
	public String getClassInfo() {
		try {
			// 取得客户编号
			String customerCode = ServletActionContext.getRequest().getParameter("customerCode");
			// 取得部门ID
			String departmentId = ServletActionContext.getRequest().getParameter("departmentId");
			Page page = PageUtils.initPage();
			// 调用Service
			classList = cst0050Service.getClassInfo(customerCode, departmentId, page);
			// 把客户编号放进session
			ServletActionContext.getRequest().getSession().setAttribute("customerCode",
					customerCode);
			// 把部门Id放进session
			ServletActionContext.getRequest().getSession().setAttribute("departmentId",
					departmentId);
			// 把课室Id放进session
			for (int i = 0; i < classList.size(); i++) {
				ServletActionContext.getRequest().getSession().setAttribute("classId",
						classList.get(i).getClassId());
			}
			// 把课室名称放进session
			for (int i = 0; i < classList.size(); i++) {
				ServletActionContext.getRequest().getSession().setAttribute("className",
						classList.get(i).getClassName());
			}
			model.setCurrentPage(page.getCurrentPage());
			model.setTotal(page.getTotal());
			// 返回课室列表
			model.setClassList(classList);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * CST0040保存课室信息
	 * 
	 * @return success
	 */
	public String saveClass() {
		try {
			// 取得JS传来的客户编号
			String customerCode = ServletActionContext.getRequest().getParameter("customerCode");
			// 取得JS传来的部门Id
			String departmentId = ServletActionContext.getRequest().getParameter("departmentId");
			// 取得页面表单上的信息
			Map<String, Object> inputField = RequestParameterManager.requestToMap();
			// 将表单上的信息赋给classpo
			BeanUtils.populate(classpo, inputField);
			// 将JS传来的客户编号赋给classpo
			classpo.setCustomerCode(customerCode);
			// 将JS传来的部门Id赋给classpo
			classpo.setDepartmentId(departmentId);
			// 取得登陆者帐号
			classpo.setUpdaterId(SessionUtil.getUser().getUserId());
			// 调用存在性check
			if (cst0050Service.classIdcheck(customerCode, departmentId, classpo.getClassId()) > 0) {
				// 课室Id存在，操作失败状态
				model.setStatus(BaseConstants.STATUSFAILURE);
				// 设置提示信息
				model.setMessage(super.getMessage(MessageConstants.USE0005,
						new String[] { super.getMessage(MessageConstants.USE0005CLAID) }));
			} else {
				// 保存课室信息
				cst0050Service.saveClass(classpo);
			}
		} catch (BusinessException e) {
			logger.error(e.getMessage(), e);
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(super.getMessage(e.getMessage()));
			return JSON;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}
		return JSON;
	}

	/**
	 * CST0040追加课室
	 * 
	 * @return success
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public String addClass() {
		try {
			// 取得客户编号
			String customerCode = ServletActionContext.getRequest().getParameter("customerCode");
			// 取得部门Id
			String departmentId = ServletActionContext.getRequest().getParameter("departmentId");
			// 取得页面表单上的信息
			Map<String, Object> inputField = RequestParameterManager.requestToMap();
			// 将表单上的信息赋给classpo
			BeanUtils.populate(classpo, inputField);
			// 将客户编号赋给classpo
			classpo.setCustomerCode(customerCode);
			// 将部门Id赋给classpo
			classpo.setDepartmentId(departmentId);
			// 取得登陆者帐号
			classpo.setUpdaterId(SessionUtil.getUser().getUserId());
			// 调用存在性check
			if (cst0050Service.classIdcheck(customerCode, departmentId, classpo.getClassId()) > 0) {
				// 设置操作状态
				model.setStatus(BaseConstants.STATUSFAILURE);
				// 课室Id已存在，给出提示
				model.setMessage(super.getMessage(MessageConstants.USE0005,
						new String[] { super.getMessage(MessageConstants.USE0005CLAID) }));
			} else {
				// 追加课室
				cst0050Service.addClass(classpo);
			}
		} catch (BusinessException e) {
			logger.error(e.getMessage(), e);
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(super.getMessage(e.getMessage()));
			return JSON;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}
		return JSON;
	}

	/**
	 * CST0050删除课室信息
	 * 
	 * @return success
	 */
	public String deleteClass() {
		try {
			// 取得客户编号
			String customerCode = ServletActionContext.getRequest().getParameter("customerCode");
			// 取得部门Id
			String departmentId = ServletActionContext.getRequest().getParameter("departmentId");
			// 取得课室Id
			String classId = ServletActionContext.getRequest().getParameter("classId");
			// 删除课室
			cst0050Service.deleteClassList(customerCode, departmentId, classId);
			model.setMessage(super.getMessage(MessageConstants.COM0003));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}
}
