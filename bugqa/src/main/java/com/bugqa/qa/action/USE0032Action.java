package com.bugqa.qa.action;

import java.io.IOException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bugqa.qa.interceptor.BusinessException;
import com.bugqa.qa.model.dto.USE0032ArgValue;
import com.bugqa.qa.model.form.USE0032Form;
import com.bugqa.qa.service.USE0032Service;
import com.bugqa.qa.utils.BaseConstants;
import com.bugqa.qa.utils.RequestParameterManager;
import com.bugqa.qa.utils.SessionUtil;

public class USE0032Action extends BaseAction<USE0032Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(USE0032Action.class);

	@Resource
	private USE0032Service use0032Service;

	/**
	 * 用户信息
	 * 
	 * @return
	 */
	public String userMsg() {

		try {

			model.setUserMsgCom(this.use0032Service.userMsgCom(SessionUtil.getUser().getUserId()));

		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 修改ユーサー信息
	 * 
	 * @return
	 */
	public String updateUser() {

		try {
			USE0032ArgValue arg = new USE0032ArgValue();
			arg = (USE0032ArgValue) RequestParameterManager.getArgValue(arg);
			arg.setUpdaterId(SessionUtil.getUser().getUserId());
			use0032Service.updateUser(arg);

		} catch (BusinessException e) {
			logger.error(e.getMessage());
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(super.getMessage(e.getMessage()));
		} catch (IOException e) {
			logger.error(e.getMessage());
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage("upload file failed!");
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ERROR;
		}

		return JSON;
	}

}
