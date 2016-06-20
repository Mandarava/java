package com.bugqa.qa.action;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bugqa.qa.model.dto.QA0060ArgValue;
import com.bugqa.qa.model.dto.QA0060RetValue;
import com.bugqa.qa.model.form.QA0060Form;
import com.bugqa.qa.service.QA0060Service;
import com.bugqa.qa.utils.RequestParameterManager;

/**
 * Q&A預定義検索(QA0060) Action
 * 
 * @author zt c.
 *
 */
public class QA0060Action extends BaseAction<QA0060Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(QA0060Action.class);

	@Resource
	private QA0060Service qa0060Service;

	/**
	 * 定義済み検索QA JSON取得
	 * 
	 * @return 定義済み検索QA JSON
	 */
	public String QASearch() {
		try {
			QA0060ArgValue arg = new QA0060ArgValue();
			arg = (QA0060ArgValue) RequestParameterManager.getArgValue(arg);
			// 把查询条件放入session供excel导出用
			session.put("QA0060InputValue", arg);
			// 查询结果
			QA0060RetValue result = this.qa0060Service.baseQASearch(arg);
			// 设置QA信息
			model.setBaseQAList(result.getBaseQAList());
			// 当前页数
			model.setCurrentPage(arg.getPage().getCurrentPage());
			// 总数据条数
			model.setTotal(arg.getPage().getTotal());

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}
}
