package com.mbp.qa.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mbp.qa.interceptor.BusinessException;
import com.mbp.qa.model.dto.USE0020ArgValue;
import com.mbp.qa.model.po.ClassMaster;
import com.mbp.qa.model.po.CustomerMaster;
import com.mbp.qa.model.po.DepartmentMaster;
import com.mbp.qa.model.po.GeneralMaster;
import com.mbp.qa.service.BaseService;
import com.mbp.qa.service.USE0020Service;
import com.mbp.qa.utils.BaseConstants;
import com.mbp.qa.utils.Checker;
import com.mbp.qa.utils.EncryptUtil;

@Service
public class USE0020ServiceImpl extends BaseService implements USE0020Service {

	/**
	 * 判断ユーサー信息是否管理员
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
	 * 初始化ユーザー権限下拉框 取得汎用信息(ユーザー権限)
	 */
	@Override
	public List<GeneralMaster> userPrevl() {
		return super.generalDao.getKbnUp();
	}

	/**
	 * 初始化得意先下拉框 取得得意先信息(会社フラグ='0')
	 */
	@Override
	public List<CustomerMaster> selCustCode() {
		return super.customerDao.selCustCode();
	}

	/**
	 * 会社フラグ变换 取得会社信息
	 */

	public List<CustomerMaster> customerMsg(String companyFlg) {
		return super.customerDao.customerMsg(companyFlg);
	}

	/**
	 * 得意先变换 取得当前选中的得意先的所有部门信息
	 */
	@Override
	public List<DepartmentMaster> departmentMsg(String customerCode) {
		return super.departmentDao.departmentMsg(customerCode);
	}

	/**
	 * 部门变换 取得当前部门的所有课信息
	 */
	@Override
	public List<ClassMaster> classMsg(HashMap<String, String> map) {
		return super.classDao.classMsg(map);
	}

	/**
	 * 用户新规事物
	 */
	@Override
	@Transaction
	public String addUserMsg(USE0020ArgValue arg) throws Exception {
		// 输入检测
		inputCheck(arg);
		String exit = "";
		// 检查用户ID是否存在
		String userIdCheck = super.userDao.userIdCheck(arg.getUserId());
		if (userIdCheck.equals("0")) {// id不存在
			exit = "notExit";
			String password = arg.getPassword();
			// 加密
			arg.setPassword(EncryptUtil.getSHA1(password));
			// 用户新规
			super.userDao.newUser(arg);
		} else {
			exit = "exit";
		}
		return exit;
	}

	/**
	 * check
	 */
	private void inputCheck(USE0020ArgValue arg) throws BusinessException {

		// 用户ID
		Checker.checkNull(arg.getUserId());
		// 长度
		Checker.checkMaxLength(arg.getUserId(), BaseConstants.INT_16);
		// 半角英数字
		Checker.checkHalf(arg.getUserId());
		// 用户名
		Checker.checkNull(arg.getUserName());
		// 长度
		Checker.checkMaxLength(arg.getUserName(), BaseConstants.INT_20);
		// 密码
		Checker.checkNull(arg.getPassword());
		// 长度
		Checker.checkMaxLength(arg.getPassword(), BaseConstants.INT_18);
		// 半角英数字
		Checker.checkHalf(arg.getPassword());
		// 确认密码
		Checker.checkNull(arg.getRepassword());
		// 密码相等
		Checker.checkPassword(arg.getPassword(), arg.getRepassword());
		// 得意先
		Checker.checkNull(arg.getCustomerCode());
		// 部门
		Checker.checkNull(arg.getDepartmentId());
		// mail
		Checker.checkNull(arg.getMailAddress());
		// 长度
		Checker.checkMaxLength(arg.getMailAddress(), BaseConstants.INT_40);
		// 格式
		Checker.checkMail(arg.getMailAddress());
	}

}
