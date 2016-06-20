package com.mbp.qa.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mbp.qa.model.dto.DeptInfo;
import com.mbp.qa.model.form.CST0030Form;
import com.mbp.qa.model.po.CustomerMaster;
import com.mbp.qa.service.CST0030Service;
import com.mbp.qa.utils.RequestParameterManager;
import com.mbp.qa.utils.SessionUtil;

/**
 * 客户编辑
 * 
 */
public class CST0030Action extends BaseAction<CST0030Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(CST0030Action.class);

	@Resource
	private CST0030Service cst0030Service;

	private CustomerMaster customerpo = new CustomerMaster();

	private List<DeptInfo> deptInfoList = new ArrayList<DeptInfo>();

	/**
	 * 客户编辑(取得客户信息)
	 * 
	 * @return success
	 */
	public String getCustomerInfo() {
		// 取得页面表单上的信息
		Map<String, Object> inputField = RequestParameterManager.requestToMap();
		// 将表单上的信息赋给customerpo
		try {
			BeanUtils.populate(customerpo, inputField);
			customerpo = cst0030Service.getCustomerInfoService(customerpo.getCustomerCode());
			// 调用取得客户部门信息Service
			deptInfoList = cst0030Service.getCustomerDeptInfoService(customerpo.getCustomerCode());
			// 把客户编号存在session
			ServletActionContext.getRequest().getSession().setAttribute("customerCode",
					customerpo.getCustomerCode());
			model.setCustomerpo(customerpo);
			model.setDeptInfoList(deptInfoList);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}
		return JSON;
	}

	/**
	 * 客户编辑(确认按钮)
	 * 
	 * @return success
	 */
	public String editCustomer() {
		// 取得页面上的信息
		Map<String, Object> inputField = RequestParameterManager.requestToMap();
		// 将页面上的信息赋给customerpo
		try {
			BeanUtils.populate(customerpo, inputField);
			// 取得登陆帐户id
			customerpo.setUpdaterId(SessionUtil.getUser().getUserId());
			// 调用编辑的Service
			customerpo = cst0030Service.editCustomerService(customerpo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}
		return JSON;
	}
}
