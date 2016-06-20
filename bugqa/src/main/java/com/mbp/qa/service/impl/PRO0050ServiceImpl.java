package com.mbp.qa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mbp.qa.model.dto.PRO0050ArgValue;
import com.mbp.qa.model.dto.Page;
import com.mbp.qa.model.po.ClassMaster;
import com.mbp.qa.model.po.CustomerMaster;
import com.mbp.qa.model.po.DepartmentMaster;
import com.mbp.qa.model.po.GeneralMaster;
import com.mbp.qa.model.po.UserMaster;
import com.mbp.qa.service.BaseService;
import com.mbp.qa.service.PRO0050Service;

@Service
public class PRO0050ServiceImpl extends BaseService implements PRO0050Service {

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
	 * 所有担当类型的取得 取得汎用信息(担当类型)
	 * 
	 * @return
	 */
	@Override
	public List<GeneralMaster> workTypeMsg() {
		return super.generalDao.getKbn02();
	}

	/**
	 * 初始化リスト部 取得ユーザー信息
	 */
	@Override
	public List<UserMaster> listUserMsg(PRO0050ArgValue arg, Page page) {
		return super.userDao.listUserMsgByPage(arg, page);
	}

	/**
	 * 当前用户所属会社
	 */
	@Override
	public List<UserMaster> userCustomerCode(String userId) {
		return super.userDao.userCustomerCode(userId);
	}

	/**
	 * ユーザー信息插入メンバーマスター
	 */
	@Override
	public void insertUserMsg(Map<String, Object> map) {
		super.projectMemberDao.insertUserMsg(map);

	}

}
