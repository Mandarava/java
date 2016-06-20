package com.bugqa.qa.service;

import java.util.HashMap;
import java.util.List;

import com.bugqa.qa.model.dto.PRO0041ArgValue;
import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.po.ClassMaster;
import com.bugqa.qa.model.po.CustomerMaster;
import com.bugqa.qa.model.po.DepartmentMaster;
import com.bugqa.qa.model.po.ProjectMemberMaster;
import com.bugqa.qa.model.po.UserMaster;

public interface PRO0041Service {

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
	 * 初始化リスト部 取得ユーザー信息
	 * 
	 * @param map
	 * @return
	 */
	List<UserMaster> userMsgSelect(PRO0041ArgValue arg, Page page);

	/**
	 * 当前用户所属会社
	 * 
	 * @param userId
	 * @return
	 */
	List<UserMaster> userCustomerCode(String userId);

	/**
	 * 当前用户（登陆者）项目信息
	 * 
	 * @param userId
	 * @return
	 */
	List<ProjectMemberMaster> userProjectMsg(String userId);

}
