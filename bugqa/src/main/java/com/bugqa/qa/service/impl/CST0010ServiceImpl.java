package com.bugqa.qa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.po.CustomerMaster;
import com.bugqa.qa.service.BaseService;
import com.bugqa.qa.service.CST0010Service;

@Service
public class CST0010ServiceImpl extends BaseService implements CST0010Service {

	/**
	 * 客户一览
	 */
	@Override
	public List<CustomerMaster> queryCustomer(Page page) {
		return super.customerDao.queryCustomerByPage(page);
	}

	/**
	 * 删除客户
	 */
	@Override
	public int deleteCustomer(String customerCode) {
		customerDao.deleteCustomer(customerCode);
		return 0;
	}

	/**
	 * 检索客户
	 */
	@Override
	public List<CustomerMaster> serchCuster(String serchKey, String serchFlg, Page page) {
		List<CustomerMaster> customerMasters = customerDao.serchcustomerByPage(serchKey, serchFlg,
				page);
		return customerMasters;
	}

}
