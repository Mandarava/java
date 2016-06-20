package com.bugqa.qa.action;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bugqa.qa.model.dto.COM0010ArgValue;
import com.bugqa.qa.model.form.COM0010Form;
import com.bugqa.qa.service.COM0010Service;
import com.bugqa.qa.utils.BaseConstants;
import com.bugqa.qa.utils.RequestParameterManager;

public class COM0010Action extends BaseAction<COM0010Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(COM0010Action.class);

	@Resource
	private COM0010Service com0010Service;

	/**
	 * 通用信息
	 * 
	 */
	public String generalMsg() {
		try {
			COM0010ArgValue arg = new COM0010ArgValue();
			arg = (COM0010ArgValue) RequestParameterManager.getArgValue(arg);
			model.setGeneralMsg(this.com0010Service.generalMsg(arg));
			model.setTotal(arg.getPage().getTotal());
			model.setCurrentPage(arg.getPage().getCurrentPage());

		} catch (Exception e) {
			logger.error(e.getMessage());
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(BaseConstants.ERRORINFO);
		}

		return JSON;
	}
}
