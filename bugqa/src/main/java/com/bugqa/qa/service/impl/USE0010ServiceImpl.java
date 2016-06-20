package com.bugqa.qa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bugqa.qa.interceptor.BusinessException;
import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.dto.USE0010ArgValue;
import com.bugqa.qa.model.po.UserMaster;
import com.bugqa.qa.service.BaseService;
import com.bugqa.qa.service.USE0010Service;
import com.bugqa.qa.utils.BaseConstants;
import com.bugqa.qa.utils.Checker;
import com.bugqa.qa.utils.CommonUtils;

@Service
public class USE0010ServiceImpl extends BaseService implements USE0010Service {

	/**
	 * 查询所有用户
	 * 
	 * @param deleteFlg
	 *            删除标记
	 */
	@Override
	public List<UserMaster> queryUser(USE0010ArgValue arg, Page page) {

		List<UserMaster> result = new ArrayList<UserMaster>();

		// 检索条件
		if (arg.getSearchKey() != null) {
			try {
				inputCheck(arg);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}
		result = super.userDao.queryUserByPage(arg, page);

		CommonUtils.convertNullToEmptyString(result);
		return result;
	}

	/**
	 * 删除用户
	 */
	@Override
	public void deleteUser(String userId) {
		super.userDao.deleteUser(userId);

	}

	/**
	 * 输入检测
	 * 
	 * @param arg
	 * @throws BusinessException
	 */
	private void inputCheck(USE0010ArgValue arg) throws BusinessException {
		// 检索条件
		Checker.checkMaxLength(arg.getSearchKey(), BaseConstants.INT_20);

	}

}
