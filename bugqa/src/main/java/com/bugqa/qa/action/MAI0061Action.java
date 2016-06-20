package com.bugqa.qa.action;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bugqa.qa.model.dto.MAI0061ArgValue;
import com.bugqa.qa.model.dto.MAI0061RetValue;
import com.bugqa.qa.model.form.MAI0061Form;
import com.bugqa.qa.service.MAI0061Service;

/**
 * Q&Aホームページ(MAI0060) Action
 * 
 * @author zt c.
 *
 */
public class MAI0061Action extends BaseAction<MAI0061Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(MAI0061Action.class);

	@Resource
	private MAI0061Service mai0061Service;

	/**
	 * 我的工作JSON取得
	 * 
	 * @return 我的工作JSON
	 */
	public String getQAMyWork() {
		try {
			MAI0061ArgValue arg = new MAI0061ArgValue();
			// 我的工作QA情报
			MAI0061RetValue qaWork = this.mai0061Service.getQAMyWork(arg);
			// QA信息
			model.setQaMyWorkList(qaWork.getQaMyWorkList());
			// 当前页数
			model.setCurrentPage(arg.getPage().getCurrentPage());
			// 总页数
			model.setTotal(arg.getPage().getTotal());

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;

	}

	/**
	 * 我的关注JSON取得
	 * 
	 * @return 我的关注JSON
	 */
	public String getQAMyNotice() {
		try {
			MAI0061ArgValue arg = new MAI0061ArgValue();
			// 我的关注QA情报
			MAI0061RetValue qaNotice = this.mai0061Service.getQAMyNotice(arg);
			// QA信息
			model.setQaMyNoticeList(qaNotice.getQaMyNoticeList());
			// 当前页数
			model.setCurrentPage(arg.getPage().getCurrentPage());
			// 总页数
			model.setTotal(arg.getPage().getTotal());

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

}
