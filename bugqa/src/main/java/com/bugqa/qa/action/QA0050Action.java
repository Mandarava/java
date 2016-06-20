package com.bugqa.qa.action;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.bugqa.qa.model.dto.QA0050ArgValue;
import com.bugqa.qa.model.dto.QA0050RetValue;
import com.bugqa.qa.model.form.QA0050Form;
import com.bugqa.qa.service.QA0050Service;
import com.bugqa.qa.utils.RequestParameterManager;

/**
 * 検索オプション（QA0050) Action
 * 
 * @author zt c.
 *
 */
public class QA0050Action extends BaseAction<QA0050Form> {

	private static final long serialVersionUID = 1L;

	private static Logger logger = LoggerFactory.getLogger(QA0050Action.class);

	@Resource
	private QA0050Service qa0050Service;

	/**
	 * 初始化下拉框数据取得
	 * 
	 * @return
	 */
	public String init() {
		try {
			QA0050ArgValue arg = new QA0050ArgValue();

			// 初始化下拉框数据
			QA0050RetValue result = qa0050Service.initSelectOptionData(arg.getUser().getUserId());

			BeanUtils.copyProperties(result, model);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * グループ名内容
	 * 
	 * @return
	 */
	public String getGroupId() {
		try {
			QA0050ArgValue arg = new QA0050ArgValue();

			arg = (QA0050ArgValue) RequestParameterManager.getArgValue(arg);
			// グループ
			QA0050RetValue result = qa0050Service.getGroupID(arg.getProjectId());

			model.setGroupIdList(result.getGroupIdList());

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * モジュール名内容
	 * 
	 * @return
	 */
	public String getModuleName() {

		try {
			QA0050ArgValue arg = new QA0050ArgValue();
			arg = (QA0050ArgValue) RequestParameterManager.getArgValue(arg);
			// モジュール
			QA0050RetValue result = qa0050Service.getModuleName(arg.getProjectId(),
					arg.getGroupId());

			model.setModuleNameList(result.getModuleNameList());

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}

		return JSON;
	}

	/**
	 * 自定义QA信息检索
	 * 
	 * @return
	 */
	public String customQASearch() {
		try {
			// 引数
			QA0050ArgValue arg = new QA0050ArgValue();
			arg = (QA0050ArgValue) RequestParameterManager.getArgValue(arg);
			// 把查询条件放入session供excel导出用
			session.put("QA0050InputValue", arg);
			// 画面QA信息
			QA0050RetValue result = this.qa0050Service.customQASearchByPage(arg);
			model.setCustomQAList(result.getCustomQAList());
			// 当前页
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
