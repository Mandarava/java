package com.mbp.qa.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mbp.qa.interceptor.BusinessException;
import com.mbp.qa.model.dto.USE0031ArgValue;
import com.mbp.qa.model.po.ClassMaster;
import com.mbp.qa.model.po.CustomerMaster;
import com.mbp.qa.model.po.DepartmentMaster;
import com.mbp.qa.model.po.GeneralMaster;
import com.mbp.qa.model.po.UserMaster;
import com.mbp.qa.service.BaseService;
import com.mbp.qa.service.USE0031Service;
import com.mbp.qa.utils.BaseConstants;
import com.mbp.qa.utils.Checker;
import com.mbp.qa.utils.CommonUtils;
import com.mbp.qa.utils.EncryptUtil;

@Service
public class USE0031ServiceImpl extends BaseService implements USE0031Service {

	/**
	 * 判断ユーザー是否管理员
	 */
	@Override
	public boolean userPrevlCheck(String userId) {

		String userPrevl = super.userDao.userPrevlCheck(userId);
		if (userPrevl.equals("0")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 取得当前ユーザー信息
	 */
	@Override
	public List<UserMaster> userMsg(String userId) {
		List<UserMaster> result = super.userDao.userMsg(userId);
		CommonUtils.convertNullToEmptyString(result);
		return result;

	}

	/**
	 * 初始化ユーザー権限下拉框 取得汎用信息(ユーザー権限)
	 */
	@Override
	public List<GeneralMaster> userPrevl() {
		return super.generalDao.getKbnUp();
	}

	/**
	 * 初始化得意先下拉框 取得得意先信息 会社フラグ变换 取得会社信息
	 */
	@Override
	public List<CustomerMaster> customerMsg(String companyFlg) {
		return super.customerDao.customerMsg(companyFlg);
	}

	/**
	 * 初始化部門下拉框 取得当前ユーザー所在的会社的所有部門信息 得意先变换 取得当前选中的得意先的所有部门信息
	 */
	@Override
	public List<DepartmentMaster> departmentMsg(String customerCode) {
		return super.departmentDao.departmentMsg(customerCode);
	}

	/**
	 * 初始化课下拉框 取得当前ユーザー所在的部門的所有課信息 部门变换 取得当前部门的所有课信息
	 */
	@Override
	public List<ClassMaster> classMsg(HashMap<String, String> map) {
		return super.classDao.classMsg(map);
	}

	/**
	 * 更新ユーザー信息
	 * 
	 * @return
	 */
	@Override
	@Transaction
	public void updateUser(USE0031ArgValue arg) throws Exception {
		// 输入检测
		inputCheck(arg);
		if (null != arg.getPassword()) {
			String password = arg.getPassword();
			// 加密
			arg.setPassword(EncryptUtil.getSHA1(password));
		}
		super.userDao.updateUser(arg);

	}

	/**
	 * check
	 */
	private void inputCheck(USE0031ArgValue arg) throws BusinessException {

		// 用户名
		Checker.checkNull(arg.getUserName());
		Checker.checkMaxLength(arg.getUserName(), BaseConstants.INT_20);
		// 得意先
		Checker.checkNull(arg.getCustomerCode());
		// 部门
		Checker.checkNull(arg.getDepartmentId());
		// mail
		Checker.checkNull(arg.getMailAddress());
		Checker.checkMaxLength(arg.getMailAddress(), BaseConstants.INT_40);
		// 格式
		Checker.checkMail(arg.getMailAddress());

	}

}
