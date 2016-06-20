package com.bugqa.qa.action;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bugqa.qa.interceptor.BusinessException;
import com.bugqa.qa.model.dto.COM0020ArgValue;
import com.bugqa.qa.model.form.COM0020Form;
import com.bugqa.qa.service.COM0020Service;
import com.bugqa.qa.utils.BaseConstants;
import com.bugqa.qa.utils.RequestParameterManager;

public class COM0020Action extends BaseAction<COM0020Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(COM0020Action.class);

	@Resource
	private COM0020Service com0020Service;

	/**
	 * 修改通用信息
	 * 
	 */
	public String updateGeneralMsg() {
		try {
			COM0020ArgValue arg = new COM0020ArgValue();
			arg = (COM0020ArgValue) RequestParameterManager.getArgValue(arg);
			model.setUpdateGeneralMsg(this.com0020Service.updateGeneralMsg(arg));
		} catch (BusinessException e) {
			logger.error(e.getMessage());
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(super.getMessage(e.getMessage()));
		} catch (Exception e) {
			logger.error(e.getMessage());
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(BaseConstants.ERRORINFO);
		}

		return JSON;
	}
}
