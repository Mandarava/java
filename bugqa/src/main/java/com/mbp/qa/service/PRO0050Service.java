package com.mbp.qa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mbp.qa.model.dto.PRO0050ArgValue;
import com.mbp.qa.model.dto.Page;
import com.mbp.qa.model.po.ClassMaster;
import com.mbp.qa.model.po.CustomerMaster;
import com.mbp.qa.model.po.DepartmentMaster;
import com.mbp.qa.model.po.GeneralMaster;
import com.mbp.qa.model.po.UserMaster;

public interface PRO0050Service {

	/**
	 * 初始化得意先下拉框 取得得意先信息(会社フラグ='0')
	 * 
	 * @return
	 */
	List<CustomerMaster> customerMsg();

	/**
	 * 初始化部門下拉框 取得部門信息
	 * 
	 * @param customerCode
	 * @return
	 */
	List<DepartmentMaster> departmentMsg(String customerCode);

	/**
	 * 初始化课下拉框 取得课信息
	 * 
	 * @param map
	 * @return
	 */
	List<ClassMaster> classMsg(HashMap<String, String> map);

	/**
	 * 所有担当类型的取得 取得汎用信息(担当类型)
	 * 
	 * @return
	 */
	List<GeneralMaster> workTypeMsg();

	/**
	 * 初始化リスト部 取得ユーザー信息
	 * 
	 * @param map
	 * @return
	 */
	List<UserMaster> listUserMsg(PRO0050ArgValue arg, Page page);

	/**
	 * 当前用户所属会社
	 * 
	 * @param userId
	 * @return
	 */
	List<UserMaster> userCustomerCode(String userId);

	/**
	 * ユーザー信息插入メンバーマスター
	 * 
	 * @param map
	 */
	void insertUserMsg(Map<String, Object> map);

}
