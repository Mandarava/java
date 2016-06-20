package com.bugqa.qa.service;

import com.bugqa.qa.model.po.CustomerMaster;

/**
 * 新建用户interface
 * 
 */
public interface CST0020Service {

	int customerCodeCheckService(String id);

	void newCustomerService(CustomerMaster customer) throws Exception;

}
