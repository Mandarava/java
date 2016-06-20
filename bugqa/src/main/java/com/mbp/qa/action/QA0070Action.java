package com.mbp.qa.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mbp.qa.model.dto.QA0050ArgValue;
import com.mbp.qa.model.dto.QA0060ArgValue;
import com.mbp.qa.model.dto.QA0070ArgValue;
import com.mbp.qa.model.dto.QA0070RetValue;
import com.mbp.qa.model.form.QA0070Form;
import com.mbp.qa.service.QA0070Service;
import com.mbp.qa.utils.BaseConstants;
import com.mbp.qa.utils.CommonUtils;
import com.mbp.qa.utils.RequestParameterManager;

/**
 * Q&A台帳導出(QA0070) Action
 * 
 * @author zt
 *
 */
public class QA0070Action extends BaseAction<QA0070Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(QA0070Action.class);

	@Resource
	private QA0070Service qa0070Service;

	public String downloadExcel() {
		try {
			QA0070ArgValue arg = new QA0070ArgValue();

			arg = (QA0070ArgValue) RequestParameterManager.getArgValue(arg);
			// QA0050检索条件
			arg.setQa0050Arg((QA0050ArgValue) session.get("QA0050InputValue"));
			// QA0060检索条件
			arg.setQa0060Arg((QA0060ArgValue) session.get("QA0060InputValue"));

			QA0070RetValue result = qa0070Service.getExportData(arg);

			Map<String, Object> beanParams = new HashMap<>();
			// QA信息
			beanParams.put("QAINFO", result.getExcelQAList());
			// 项目成员信息
			beanParams.put("MEMBER", result.getUserList());
			// module
			beanParams.put("MODULE", result.getModuleList());
			// 项目信息
			beanParams.put("PROJECT", result.getProject());

			// 保存默认文件名：画面．プロジェクトＩＤ<プロジェクトＩＤ中的"."替换成"_"> + "_" + "QA" + "_" +
			// "年月日"+"．xls"
			fileName = arg.getProjectId().replace('.', '_') + "_QA_" + CommonUtils.getTime()
					+ BaseConstants.XLS;

			generateExcel(beanParams, BaseConstants.QAEXPORTTEMPLATE);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return EXCEL;

	}
}
