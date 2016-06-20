package com.mbp.qa.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mbp.qa.model.dto.PRO0041ArgValue;
import com.mbp.qa.model.dto.Page;
import com.mbp.qa.model.po.ClassMaster;
import com.mbp.qa.model.po.CustomerMaster;
import com.mbp.qa.model.po.DepartmentMaster;
import com.mbp.qa.model.po.ProjectMemberMaster;
import com.mbp.qa.model.po.UserMaster;
import com.mbp.qa.service.BaseService;
import com.mbp.qa.service.PRO0041Service;

@Service
public class PRO0041ServiceImpl extends BaseService implements PRO0041Service {

	/**
	 * 初始化得意先下拉框 取得得意先信息(会社フラグ='0')
	 */
	@Override
	public List<CustomerMaster> customerMsg() {
		return super.customerDao.selCustCode();
	}

	/**
	 * 初始化部门下拉框 取得部门信息
	 */
	@Override
	public List<DepartmentMaster> departmentMsg(String customerCode) {
		return super.departmentDao.departmentMsg(customerCode);
	}

	/**
	 * 初始化课下拉框 取得课信息
	 */
	@Override
	public List<ClassMaster> classMsg(HashMap<String, String> map) {
		return super.classDao.classMsg(map);
	}

	/**
	 * 初始化リスト部 取得ユーザー信息
	 */
	@Override
	public List<UserMaster> userMsgSelect(PRO0041ArgValue arg, Page page) {
		return super.userDao.userMsgSelectByPage(arg, page);
	}

	/**
	 * 当前用户所属会社
	 */
	@Override
	public List<UserMaster> userCustomerCode(String userId) {
		return super.userDao.userCustomerCode(userId);
	}

	/**
	 * 当前用户（登陆者）项目信息
	 */
	@Override
	public List<ProjectMemberMaster> userProjectMsg(String userId) {
		return super.projectMemberDao.userProjectMsg(userId);
	}

}
