package com.bugqa.qa.service;

import java.util.List;

import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.po.CustomerMaster;

public interface CST0010Service {

	List<CustomerMaster> queryCustomer(Page page);
	
	int deleteCustomer(String customerCode);
	
	List<CustomerMaster> serchCuster(String serchKey,String serchFlg,Page page);
}
