package com.bugqa.qa.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.form.CST0010Form;
import com.bugqa.qa.model.po.CustomerMaster;
import com.bugqa.qa.service.CST0010Service;
import com.bugqa.qa.utils.BaseConstants;
import com.bugqa.qa.utils.MessageConstants;
import com.bugqa.qa.utils.PageUtils;

public class CST0010Action extends BaseAction<CST0010Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(CST0010Action.class);

	@Resource
	private CST0010Service cst0010Service;

	/**
	 * CST0010查询所有客户
	 * 
	 * @return
	 */
	public String queryCustomer() {
		try {
			Page page = PageUtils.initPage();
			List<CustomerMaster> customer = cst0010Service.queryCustomer(page);
			model.setCurrentPage(page.getCurrentPage());
			model.setTotal(page.getTotal());
			model.setCustomer(customer);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}
		return JSON;
	}

	/**
	 * CST0010删除客户
	 * 
	 * @return
	 */
	public String deleteCustomer() {
		try {
			String customerCode = ServletActionContext.getRequest().getParameter("customerCode");
			cst0010Service.deleteCustomer(customerCode);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}
		return JSON;
	}

	public String serch() {
		try {
			// 取得检索条件
			String serchKey = ServletActionContext.getRequest().getParameter("serchKey");
			String serchFlg = ServletActionContext.getRequest().getParameter("serchFlg");
			Page page = PageUtils.initPage();
			List<CustomerMaster> customer = cst0010Service.serchCuster(serchKey, serchFlg, page);
			if (customer.size() == 0) {
				// 设置操作失败状态
				model.setStatus(BaseConstants.STATUSFAILURE);
				// 检索结果为0
				model.setMessage(super.getMessage(MessageConstants.NODATA));
			}
			model.setCurrentPage(page.getCurrentPage());
			model.setTotal(page.getTotal());
			model.setCustomer(customer);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}
		return JSON;
	}

}
