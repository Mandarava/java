package com.bugqa.qa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bugqa.qa.interceptor.BusinessException;
import com.bugqa.qa.model.dto.USE0032ArgValue;
import com.bugqa.qa.model.po.UserMaster;
import com.bugqa.qa.service.BaseService;
import com.bugqa.qa.service.USE0032Service;
import com.bugqa.qa.utils.BaseConstants;
import com.bugqa.qa.utils.Checker;
import com.bugqa.qa.utils.EncryptUtil;

@Service
public class USE0032ServiceImpl extends BaseService implements USE0032Service {

	/**
	 * 用户信息
	 */
	@Override
	public List<UserMaster> userMsgCom(String userId) {
		return super.userDao.userMsgCom(userId);
	}

	/**
	 * check
	 */
	private void inputCheck(USE0032ArgValue arg) throws BusinessException {

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
		// mail
		Checker.checkNull(arg.getMailAddress());
		Checker.checkMaxLength(arg.getMailAddress(), BaseConstants.INT_40);
		// 格式
		Checker.checkMail(arg.getMailAddress());
	}

	/**
	 * 更新用户信息（普通用户）
	 */
	@Override
	@Transaction
	public void updateUser(USE0032ArgValue arg) throws BusinessException {
		// 输入检测
		inputCheck(arg);
		String password = arg.getPassword();
		// 加密
		arg.setPassword(EncryptUtil.getSHA1(password));
		super.userDao.updateUserpart(arg);

	}

}
