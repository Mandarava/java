package com.bugqa.qa.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bugqa.qa.model.form.CST0020Form;
import com.bugqa.qa.model.po.CustomerMaster;
import com.bugqa.qa.service.CST0020Service;
import com.bugqa.qa.utils.BaseConstants;
import com.bugqa.qa.utils.MessageConstants;
import com.bugqa.qa.utils.RequestParameterManager;

public class CST0020Action extends BaseAction<CST0020Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(CST0020Action.class);

	@Resource
	private CST0020Service cst0020Service;

	/**
	 * 用户新建的保存按钮
	 * 
	 * @return
	 */
	public String newCustomer() {
		try {
			CustomerMaster customer = new CustomerMaster();
			// 取得页面上表单的信息
			Map<String, Object> inputField = RequestParameterManager.requestToMap();

			// 把页面上的表单输入数据赋给customer
			BeanUtils.populate(customer, inputField);
			// 如果客户编号已经存在
			if (cst0020Service.customerCodeCheckService(customer.getCustomerCode()) > 0) {
				// 设置操作失败状态
				model.setStatus(BaseConstants.STATUSFAILURE);
				// 客户编号已存在
				model.setMessage(super.getMessage(MessageConstants.USE0005,
						new String[] { super.getMessage(MessageConstants.USE0005CSTCODE) }));
			} else {
				// 新建客户
				cst0020Service.newCustomerService(customer);
				// 新建成功提示
				model.setMessage(super.getMessage(MessageConstants.COM0001));
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}
		return JSON;
	}
}
