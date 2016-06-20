package com.bugqa.qa.action;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bugqa.qa.model.dto.QA0030ArgValue;
import com.bugqa.qa.model.dto.QA0030RetValue;
import com.bugqa.qa.model.form.QA0030Form;
import com.bugqa.qa.service.QA0030Service;
import com.bugqa.qa.utils.RequestParameterManager;

/**
 * Q&A履歴一覧(QA0030) Action
 * 
 * @author zt c.
 *
 */
public class QA0030Action extends BaseAction<QA0030Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(QA0030Action.class);

	@Resource
	private QA0030Service qa0030Service;

	public String QAHistorySearch() {

		try {
			QA0030ArgValue arg = new QA0030ArgValue();
			arg = (QA0030ArgValue) RequestParameterManager.getArgValue(arg);

			QA0030RetValue result = this.qa0030Service.QAHistorySerach(arg);
			// 查询结果
			model.setQaHistoryList(result.getQaHistoryList());
			// 总数据条数
			model.setTotal(arg.getPage().getTotal());
			// 当前页
			model.setCurrentPage(arg.getPage().getCurrentPage());

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

}
