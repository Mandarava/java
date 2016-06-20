package com.mbp.qa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mbp.qa.interceptor.BusinessException;
import com.mbp.qa.model.dto.COM0020ArgValue;
import com.mbp.qa.model.po.GeneralMaster;
import com.mbp.qa.service.BaseService;
import com.mbp.qa.service.COM0020Service;
import com.mbp.qa.utils.BaseConstants;
import com.mbp.qa.utils.Checker;

@Service
public class COM0020ServiceImpl extends BaseService implements COM0020Service {

	/**
	 * 修改通用信息
	 */
	@Override
	public List<GeneralMaster> updateGeneralMsg(COM0020ArgValue arg) throws Exception {
		// 输入检测
		inputCheck(arg);

		return super.generalDao.updateGeneralMsg(arg);
	}

	/**
	 * 输入检测
	 * 
	 * @param arg
	 * @throws BusinessException
	 */
	private void inputCheck(COM0020ArgValue arg) throws BusinessException {

		Checker.checkNull(arg.getName());
		Checker.checkMaxLength(arg.getName(), BaseConstants.INT_50);
		if (arg.getRemark() != null) {
			Checker.checkMaxLength(arg.getRemark(), BaseConstants.INT_100);
		}
	}

}
