package com.mbp.qa.action;

import java.io.IOException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.mbp.qa.interceptor.BusinessException;
import com.mbp.qa.model.dto.QA0010ArgValue;
import com.mbp.qa.model.dto.QA0010RetValue;
import com.mbp.qa.model.form.QA0010Form;
import com.mbp.qa.service.QA0010Service;
import com.mbp.qa.utils.BaseConstants;
import com.mbp.qa.utils.RequestParameterManager;

/**
 * Q&A新規(QA0010) Action
 * 
 * @author s1507112
 *
 */
public class QA0010Action extends BaseAction<QA0010Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(QA0010Action.class);

	@Resource
	private QA0010Service qa0010Service;

	/**
	 * 初始化数据
	 * 
	 * @return
	 */
	public String init() {
		try {
			// 引数
			QA0010ArgValue arg = new QA0010ArgValue();

			arg = (QA0010ArgValue) RequestParameterManager.getArgValue(arg);
			// 结果
			QA0010RetValue result = this.qa0010Service.getInitData(arg);

			BeanUtils.copyProperties(result, model);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;

	}

	/**
	 * 系统名下拉框变化,发生机能、提出者情報、回答者情报数据取得
	 * 
	 * @return
	 */
	public String projectChange() {
		try {

			QA0010ArgValue arg = new QA0010ArgValue();

			arg = (QA0010ArgValue) RequestParameterManager.getArgValue(arg);
			// 结果
			QA0010RetValue result = this.qa0010Service.getProjectChangeData(arg);

			BeanUtils.copyProperties(result, model);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 発生個所のドロップダウンリスト情報を取る
	 * 
	 * @return
	 */
	public String moduleDropDown() {
		try {

			QA0010ArgValue arg = new QA0010ArgValue();
			arg = (QA0010ArgValue) RequestParameterManager.getArgValue(arg);

			QA0010RetValue result = new QA0010RetValue();
			// 発生個所
			result = this.qa0010Service.getGroupChangeData(arg);

			BeanUtils.copyProperties(result, model);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 插入QA
	 * 
	 * @return
	 */
	public String addQA() {
		try {

			QA0010ArgValue arg = new QA0010ArgValue();

			arg = (QA0010ArgValue) RequestParameterManager.getArgValue(arg);
			arg.setFile(model.getFile());
			// 插入QA并返回插入QA的番号
			String qaNo = qa0010Service.addQA(arg);
			model.setQaNo(qaNo);

		} catch (BusinessException e) {
			logger.error(e.getMessage(), e);
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(super.getMessage(e.getMessage()));
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage("upload file failed!");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

}
