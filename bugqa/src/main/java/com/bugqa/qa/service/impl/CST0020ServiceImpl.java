package com.bugqa.qa.service.impl;

import org.springframework.stereotype.Service;

import com.bugqa.qa.interceptor.BusinessException;
import com.bugqa.qa.model.po.CustomerMaster;
import com.bugqa.qa.service.BaseService;
import com.bugqa.qa.service.CST0020Service;
import com.bugqa.qa.utils.BaseConstants;
import com.bugqa.qa.utils.Checker;
import com.bugqa.qa.utils.SessionUtil;

@Service
public class CST0020ServiceImpl extends BaseService implements CST0020Service {

	/**
	 * 新建客户存在性check
	 * 
	 * userId 客户编号
	 */
	@Override
	public int customerCodeCheckService(String userId) {
		return customerDao.customerCodeCheck(userId);
	}

	/**
	 * 新建客户
	 * 
	 * customer 客户信息
	 * 
	 * @throws Exception
	 */
	@Override
	public void newCustomerService(CustomerMaster customer) throws Exception {
		// 输入检测
		inputCheck(customer);
		customer.setUpdaterId(SessionUtil.getUser().getUserId());
		customerDao.newCustomer(customer);
	}

	/**
	 * 输入检测
	 * 
	 * @param customer
	 *            客户信息
	 * @throws BusinessException
	 */
	private void inputCheck(CustomerMaster customer) throws BusinessException {
		// 客户编号
		Checker.checkNull(customer.getCustomerCode());
		Checker.checkHalf(customer.getCustomerCode());
		// 客户名称
		Checker.checkNull(customer.getCustomerName());
		// 客户昵称
		Checker.checkNull(customer.getCustomerNameSum());
		// 邮政编号
		Checker.checkNull(customer.getZipCode());
		// 住所
		Checker.checkNull(customer.getAddress());
		Checker.checkMaxLength(customer.getAddress(), BaseConstants.INT_5000);
		// 电话号码
		Checker.checkNull(customer.getPhone());
		Checker.chechIsNumber(customer.getPhone());
		// 传真
		Checker.checkNull(customer.getFax());
		Checker.checkNull(customer.getFax());
		// 评论
		Checker.checkMaxLength(customer.getComment(), BaseConstants.INT_5000);
	}

}
