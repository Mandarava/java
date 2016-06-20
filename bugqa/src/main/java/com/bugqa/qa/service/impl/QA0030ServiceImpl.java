package com.bugqa.qa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bugqa.qa.model.dto.QA0030ArgValue;
import com.bugqa.qa.model.dto.QA0030RetValue;
import com.bugqa.qa.model.dto.QAHistoryDTO;
import com.bugqa.qa.service.BaseService;
import com.bugqa.qa.service.QA0030Service;

/**
 * QA历史记录Service
 * 
 * @author zt c.
 *
 */
@Service
public class QA0030ServiceImpl extends BaseService implements QA0030Service {

	private static Logger logger = LoggerFactory.getLogger(QA0030ServiceImpl.class);

	/**
	 * QA历史记录获得
	 * 
	 * @param arg
	 * 
	 * @return QA历史记录
	 */
	@Override
	public QA0030RetValue QAHistorySerach(QA0030ArgValue arg) {

		List<QAHistoryDTO> result = new ArrayList<>();
		result = super.qaHistoryDao.getQAHistoryByPage(arg);
		// HTML转义
		for (QAHistoryDTO dto : result) {
			// 回答日
			dto.setAnswerDate(escapeHTML(dto.getAnswerDate()));
			// 回答者
			dto.setAnswerer(escapeHTML(dto.getAnswerer()));
			// 期望日
			dto.setExpDate(escapeHTML(dto.getExpDate()));
			// group名
			dto.setGroupName(escapeHTML(dto.getGroupName()));
			// module名
			dto.setModuleName(escapeHTML(dto.getModuleName()));
			// 项目ID
			dto.setProjectId(escapeHTML(dto.getProjectId()));
			// 项目名
			dto.setProjectName(escapeHTML(dto.getProjectName()));
			// 回答方状态
			dto.setQaAState(escapeHTML(dto.getQaAState()));
			// QA番号
			dto.setQaNo(escapeHTML(dto.getQaNo()));
			// 提问方状态
			dto.setQaQState(escapeHTML(dto.getQaQState()));
			// 提问日
			dto.setQuestionDate(escapeHTML(dto.getQuestionDate()));
			// 提问者
			dto.setQuestioner(escapeHTML(dto.getQuestioner()));
			// 连番
			dto.setSerialNum(escapeHTML(dto.getSerialNum()));
			// 更新者名字
			dto.setUpdaterName(escapeHTML(dto.getUpdaterName()));
			// 更新时间
			dto.setUpdateTime(escapeHTML(dto.getUpdateTime()));
		}

		logger.info("QAHistorySerach result size ： " + result.size());

		QA0030RetValue ret = new QA0030RetValue();
		ret.setQaHistoryList(result);
		return ret;
	}
}
