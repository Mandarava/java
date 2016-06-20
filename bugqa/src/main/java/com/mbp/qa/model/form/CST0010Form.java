package com.mbp.qa.model.form;

import java.io.Serializable;
import java.util.List;

import com.mbp.qa.model.po.CustomerMaster;

public class CST0010Form extends BaseForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<CustomerMaster> customer;

	public List<CustomerMaster> getCustomer() {
		return customer;
	}

	public void setCustomer(List<CustomerMaster> customer) {
		this.customer = customer;
	}

}
