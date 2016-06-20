package com.bugqa.qa.model.form;

import java.io.Serializable;
import java.util.List;

import com.bugqa.qa.model.po.CustomerMaster;
public final class CST0020Form extends BaseForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//客户信息
	private List<CustomerMaster> customerMasterList;
	
	
	public List<CustomerMaster> getCustomerMasterList() {
		return customerMasterList;
	}
	
	public void setCustomerMasterList(List<CustomerMaster> customerMasterList) {
		this.customerMasterList = customerMasterList;
	}
	
	
	
}
