package com.mbp.qa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mbp.qa.interceptor.BusinessException;
import com.mbp.qa.model.dto.DeptInfo;
import com.mbp.qa.model.po.CustomerMaster;
import com.mbp.qa.service.BaseService;
import com.mbp.qa.service.CST0030Service;
import com.mbp.qa.utils.BaseConstants;
import com.mbp.qa.utils.Checker;
import com.mbp.qa.utils.CommonUtils;

@Service
public class CST0030ServiceImpl extends BaseService implements CST0030Service {

	/**
	 * CST0030取得客户信息
	 */
	@Override
	public CustomerMaster getCustomerInfoService(String customerCode) {
		CustomerMaster customerMasterpo = customerDao.getCustomerInfo(customerCode);
		CommonUtils.convertNullToEmptyString(customerMasterpo);
		return customerMasterpo;
	}

	/**
	 * CST0030取得客户部门信息
	 */
	@Override
	public List<DeptInfo> getCustomerDeptInfoService(String customerCode) {
		List<DeptInfo> departmentMasterpo = departmentDao.getCustomerDeptInfo(customerCode);
		return departmentMasterpo;
	}

	/**
	 * CST0030确认客户编辑
	 * 
	 * @throws BusinessException
	 */
	@Override
	public CustomerMaster editCustomerService(CustomerMaster customerMaster) throws Exception {
		// 输入检测
		inputCheck(customerMaster);
		CustomerMaster customerMasterpo = customerDao.editCustomer(customerMaster);
		return customerMasterpo;
	}

	/**
	 * 输入检测
	 * 
	 * @param customerMaster
	 * @throws BusinessException
	 */
	public void inputCheck(CustomerMaster customerMaster) throws BusinessException {
		// 客户编号
		Checker.checkNull(customerMaster.getCustomerCode());
		Checker.checkHalf(customerMaster.getCustomerCode());
		// 客户名称
		Checker.checkNull(customerMaster.getCustomerName());
		// 客户昵称
		Checker.checkNull(customerMaster.getCustomerNameSum());
		// 邮政编号
		Checker.checkNull(customerMaster.getZipCode());
		// 住所
		Checker.checkNull(customerMaster.getAddress());
		Checker.checkMaxLength(customerMaster.getAddress(), BaseConstants.INT_5000);
		// 电话号码
		Checker.checkNull(customerMaster.getPhone());
		Checker.chechIsNumber(customerMaster.getPhone());
		// 传真
		Checker.checkNull(customerMaster.getFax());
		Checker.checkNull(customerMaster.getFax());
		// 备注
		Checker.checkMaxLength(customerMaster.getComment(), BaseConstants.INT_5000);

	}
}
