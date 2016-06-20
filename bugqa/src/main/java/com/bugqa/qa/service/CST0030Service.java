package com.bugqa.qa.service;

import java.util.List;

import com.bugqa.qa.interceptor.BusinessException;
import com.bugqa.qa.model.dto.DeptInfo;
import com.bugqa.qa.model.po.CustomerMaster;

/**
 * 编辑用户interface
 * 
 */
public interface CST0030Service {

	/**
	 * CST0030 取得客户信息
	 * 
	 * @param customerCode
	 */
	CustomerMaster getCustomerInfoService(String customerCode);

	/**
	 * CST0030 取得客户部门信息
	 * 
	 * @param customerCode
	 */
	List<DeptInfo> getCustomerDeptInfoService(String customerCode);

	/**
	 * CST0030 编辑客户
	 * 
	 * @param customerCode
	 * @throws BusinessException
	 * @throws Exception
	 */
	CustomerMaster editCustomerService(CustomerMaster customerpo)
			throws BusinessException, Exception;

}
