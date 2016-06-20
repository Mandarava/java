package com.bugqa.qa.action;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.bugqa.qa.interceptor.BusinessException;
import com.bugqa.qa.model.dto.QA0020ArgValue;
import com.bugqa.qa.model.dto.QA0020RetValue;
import com.bugqa.qa.model.form.QA0020Form;
import com.bugqa.qa.model.po.ProjectMemberMaster;
import com.bugqa.qa.service.QA0020Service;
import com.bugqa.qa.utils.BaseConstants;
import com.bugqa.qa.utils.FileUtil;
import com.bugqa.qa.utils.RequestParameterManager;

/**
 * Q&A详细、修正（QA0020）Action
 * 
 * @author zt c.
 *
 */
public class QA0020Action extends BaseAction<QA0020Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(QA0020Action.class);

	@Resource
	private QA0020Service qa0020Service;

	/**
	 * 界面初始化
	 * 
	 * @return
	 */
	public String init() {
		try {
			QA0020ArgValue arg = new QA0020ArgValue();
			arg = (QA0020ArgValue) RequestParameterManager.getArgValue(arg);

			QA0020RetValue result = new QA0020RetValue();
			// 初始化数据
			result = this.qa0020Service.getInitData(arg);

			BeanUtils.copyProperties(result, model);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 発生機能选择処理
	 * 
	 * @return 発生個所のドロップダウンリスト情報
	 */
	public String getModuleList() {
		try {
			// 引数
			QA0020ArgValue arg = new QA0020ArgValue();
			arg = (QA0020ArgValue) RequestParameterManager.getArgValue(arg);

			QA0020RetValue result = new QA0020RetValue();
			result = this.qa0020Service.getGroupChangeData(arg);
			BeanUtils.copyProperties(result, model);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * QA保存処理
	 * 
	 * @return
	 */
	public String saveQA() {
		try {
			QA0020ArgValue arg = new QA0020ArgValue();
			arg = (QA0020ArgValue) RequestParameterManager.getArgValue(arg);
			// 回答添附资料
			arg.setAUploadFile(model.getAUploadFile());
			// 提问添附资料
			arg.setQUploadFile(model.getQUploadFile());
			// 保存QA
			qa0020Service.saveQA(arg);

		} catch (BusinessException e) {
			logger.error(e.getMessage(), e);
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(super.getMessage(e.getMessage()));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 削除処理
	 * 
	 * @return
	 */
	public String deleteQA() {
		try {
			QA0020ArgValue arg = new QA0020ArgValue();
			arg = (QA0020ArgValue) RequestParameterManager.getArgValue(arg);
			// Q&A状態 キャンセル
			arg.setQaQState(BaseConstants.QAQSTATECANCEL);
			this.qa0020Service.changeQAState(arg);

		} catch (BusinessException e) {
			logger.error(e.getMessage(), e);
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(super.getMessage(e.getMessage()));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 受付処理
	 * 
	 * @return
	 */
	public String receiveQA() {
		try {
			QA0020ArgValue arg = new QA0020ArgValue();
			arg = (QA0020ArgValue) RequestParameterManager.getArgValue(arg);
			// Q&A状態受付
			arg.setQaAState(BaseConstants.QAASTATERECEIVE);
			this.qa0020Service.changeQAState(arg);

		} catch (BusinessException e) {
			logger.error(e.getMessage(), e);
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(super.getMessage(e.getMessage()));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 移管処理
	 * 
	 * @return
	 */
	public String moveQA() {
		try {
			QA0020ArgValue arg = new QA0020ArgValue();
			arg = (QA0020ArgValue) RequestParameterManager.getArgValue(arg);
			// Q&A状態移管
			arg.setQaAState(BaseConstants.QAASTATEMOVE);
			this.qa0020Service.changeQAState(arg);

		} catch (BusinessException e) {
			logger.error(e.getMessage(), e);
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(super.getMessage(e.getMessage()));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 他部署对应処理
	 * 
	 * @return
	 */
	public String otherQA() {
		try {
			QA0020ArgValue arg = new QA0020ArgValue();
			arg = (QA0020ArgValue) RequestParameterManager.getArgValue(arg);
			// Q&A状態他部署对应
			arg.setQaAState(BaseConstants.QAASTATEOTHER);
			this.qa0020Service.changeQAState(arg);

		} catch (BusinessException e) {
			logger.error(e.getMessage(), e);
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(super.getMessage(e.getMessage()));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 保留処理
	 * 
	 * @return
	 */
	public String reserveQA() {
		try {
			QA0020ArgValue arg = new QA0020ArgValue();
			arg = (QA0020ArgValue) RequestParameterManager.getArgValue(arg);
			// Q&A状態 保留
			arg.setQaAState(BaseConstants.QAASTATERESERVE);
			this.qa0020Service.changeQAState(arg);

		} catch (BusinessException e) {
			logger.error(e.getMessage(), e);
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(super.getMessage(e.getMessage()));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 保留取消処理
	 * 
	 * @return
	 */
	public String cancelReserveQA() {
		try {
			QA0020ArgValue arg = new QA0020ArgValue();
			arg = (QA0020ArgValue) RequestParameterManager.getArgValue(arg);
			// Q&A状態 発行
			arg.setQaAState(BaseConstants.QAASTATERECEIVE);
			// 到底是谁的状态，不明
			// arg.setQaQState(BaseConstants.QAQSTATEISSUE);
			this.qa0020Service.changeQAState(arg);

		} catch (BusinessException e) {
			logger.error(e.getMessage(), e);
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(super.getMessage(e.getMessage()));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 承认完了処理
	 * 
	 * @return
	 */
	public String admitQA() {
		try {
			QA0020ArgValue arg = new QA0020ArgValue();
			arg = (QA0020ArgValue) RequestParameterManager.getArgValue(arg);
			// Q&A状態 承认完了
			arg.setQaQState(BaseConstants.QAQSTATEADMITTED);

			this.qa0020Service.changeQAState(arg);

		} catch (BusinessException e) {
			logger.error(e.getMessage(), e);
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(super.getMessage(e.getMessage()));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 回答完了処理
	 * 
	 * @return
	 */
	public String answerQA() {
		try {
			QA0020ArgValue arg = new QA0020ArgValue();
			arg = (QA0020ArgValue) RequestParameterManager.getArgValue(arg);
			// 回答者添附资料
			arg.setAUploadFile(model.getAUploadFile());
			// 提问者添附资料
			arg.setQUploadFile(model.getQUploadFile());
			this.qa0020Service.answerQA(arg);

		} catch (BusinessException e) {
			logger.error(e.getMessage(), e);
			model.setStatus(BaseConstants.STATUSFAILURE);
			model.setMessage(super.getMessage(e.getMessage()));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 下载附件
	 * 
	 * @return
	 */
	public String downloadExcel() {
		try {
			QA0020ArgValue arg = new QA0020ArgValue();
			arg = (QA0020ArgValue) RequestParameterManager.getArgValue(arg);
			if (!StringUtils.isEmpty(arg.getQattachedInfo())) {
				// 设置下载文件名
				fileName = arg.getQattachedInfo();
				// 文件流
				inputStream = FileUtil.readFile(arg.getQattachedInfo());
			} else if (!StringUtils.isEmpty(arg.getAattachedInfo())) {
				// 设置 下载文件名
				fileName = arg.getAattachedInfo();
				// 文件流
				inputStream = FileUtil.readFile(arg.getAattachedInfo());
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return EXCEL;
	}

	/**
	 * 获得项目成员权限
	 * 
	 * @return
	 */
	public String getMemberWorkType() {
		try {
			QA0020ArgValue arg = new QA0020ArgValue();
			arg = (QA0020ArgValue) RequestParameterManager.getArgValue(arg);
			// 项目成员信息
			ProjectMemberMaster memberInfo = qa0020Service
					.getUserWorkType(arg.getUser().getUserId(), arg.getProjectId());
			model.setMemberInfo(memberInfo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

}
