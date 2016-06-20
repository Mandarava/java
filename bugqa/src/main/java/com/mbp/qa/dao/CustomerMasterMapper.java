package com.mbp.qa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mbp.qa.model.dto.Page;
import com.mbp.qa.model.po.CustomerMaster;

public interface CustomerMasterMapper {

	/**
	 * CST0020新建用户的code存在性check
	 * 
	 * @param userId
	 * 
	 * @return
	 */
	int customerCodeCheck(String userId);

	/**
	 * CST0020新建用户
	 * 
	 * @param customerMaster
	 * 
	 * @return
	 */
	int newCustomer(CustomerMaster customerMaster);

	/**
	 * CST0030客户编辑的信息取得
	 * 
	 * @param customerMaster
	 * 
	 * @return
	 */
	CustomerMaster getCustomerInfo(String customerCode);

	/**
	 * CST0030确认客户编辑
	 * 
	 * @param customerMaster
	 * 
	 * @return
	 */
	CustomerMaster editCustomer(CustomerMaster customerMaster);

	List<CustomerMaster> selCustCode();

	List<CustomerMaster> customerMsg(String companyFlg);

	/**
	 * CST0010查询所有客户信息
	 * 
	 * @param page
	 *            分页信息
	 * @return
	 */
	List<CustomerMaster> queryCustomerByPage(@Param("page") Page page);

	/**
	 * CST0010检索客户
	 * 
	 * @param serchKey
	 *            检索条件
	 * @return
	 */
	List<CustomerMaster> serchcustomerByPage(@Param("serchKey") String serchKey,
			@Param("serchFlg") String serchFlg, @Param("page") Page page);

	/**
	 * CST0010删除客户
	 * 
	 * @param customerCode
	 *            客户编号
	 * @return
	 */
	int deleteCustomer(String customerCode);

	String getCustomerNameSum(@Param("customerCode") String customerCode);

}