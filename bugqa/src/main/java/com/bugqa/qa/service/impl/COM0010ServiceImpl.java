package com.bugqa.qa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bugqa.qa.interceptor.BusinessException;
import com.bugqa.qa.model.dto.COM0010ArgValue;
import com.bugqa.qa.model.po.GeneralMaster;
import com.bugqa.qa.service.BaseService;
import com.bugqa.qa.service.COM0010Service;
import com.bugqa.qa.utils.BaseConstants;
import com.bugqa.qa.utils.Checker;
import com.bugqa.qa.utils.CommonUtils;

@Service
public class COM0010ServiceImpl extends BaseService implements COM0010Service {
	
	
	/**
	 * 通用信息(检索)
	 * @throws BusinessException 
	 */
	@Override
	public List<GeneralMaster> generalMsg(COM0010ArgValue arg) {
		// 检索条件
		if(arg.getSearchKey() !=null){
			try {
				inputCheck(arg);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		} 
		List<GeneralMaster> result = super.generalDao.generalMsgByPage(arg);
		CommonUtils.convertNullToEmptyString(result);
		return result;
	}
	
	/**
	 * 输入检测
	 * @param arg
	 * @throws BusinessException
	 */
	private void inputCheck(COM0010ArgValue arg) throws BusinessException {
		
		// 检索条件
		Checker.checkMaxLength(arg.getSearchKey(),  BaseConstants.INT_8);
	}

}
