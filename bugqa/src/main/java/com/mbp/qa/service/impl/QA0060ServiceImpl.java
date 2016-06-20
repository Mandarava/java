package com.mbp.qa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mbp.qa.model.dto.BaseQADTO;
import com.mbp.qa.model.dto.QA0060ArgValue;
import com.mbp.qa.model.dto.QA0060RetValue;
import com.mbp.qa.service.BaseService;
import com.mbp.qa.service.QA0060Service;
import com.mbp.qa.utils.BaseConstants;

/**
 * QA0060 预定义Q&A情报取得service
 * 
 * @author zt c.
 *
 */
@Service
public class QA0060ServiceImpl extends BaseService implements QA0060Service {

	private static Logger logger = LoggerFactory.getLogger(QA0060ServiceImpl.class);

	/**
	 * 定義済み検索
	 * 
	 * @param user
	 *            用户信息
	 * @param searchCond
	 *            检索条件
	 */
	@Override
	public QA0060RetValue baseQASearch(QA0060ArgValue arg) {

		List<BaseQADTO> result = new ArrayList<>();
		// 检索标志
		String flg = arg.getFlg();
		// 検索フラグ='1'の場合
		if (BaseConstants.STR_1.equals(flg)) {
			// 定義済み検索：私が提出したQ&A
			result = super.qaDao.baseQASearchflg1ByPage(arg);
		} else if (BaseConstants.STR_2.equals(flg)) {
			// 定義済み検索：私が回答するQ&A
			result = super.qaDao.baseQASearchflg2ByPage(arg);
		} else if (BaseConstants.STR_3.equals(flg)) {
			// 定義済み検索：全て未回答のQ&A
			result = super.qaDao.baseQASearchflg3ByPage(arg);
		} else if (BaseConstants.STR_4.equals(flg)) {
			// 定義済み検索：全て未承認のQ&A
			result = super.qaDao.baseQASearchflg4ByPage(arg);
		} else if (BaseConstants.STR_5.equals(flg)) {
			// 定義済み検索：全てのQ&A
			result = super.qaDao.baseQASearchflg5ByPage(arg);
		} else if (BaseConstants.STR_6.equals(flg)) {
			// 定義済み検索：項目によって
			result = super.qaDao.baseQASearchflg6ByPage(arg);
		} else {
			result = null;
		}

		// HTML转义
		for (BaseQADTO dto : result) {
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
			// 回答者状态
			dto.setQaAState(escapeHTML(dto.getQaAState()));
			// QA番号
			dto.setQaNo(escapeHTML(dto.getQaNo()));
			// 提问者状态
			dto.setQaQState(escapeHTML(dto.getQaQState()));
			// 标题
			dto.setQaTitle(escapeHTML(dto.getQaTitle()));
			// 提问日
			dto.setQuestionDate(escapeHTML(dto.getQuestionDate()));
			// 回答者
			dto.setQuestioner(escapeHTML(dto.getQuestioner()));
		}

		logger.info("baseQASearch result size ： " + result.size());

		QA0060RetValue ret = new QA0060RetValue();
		ret.setBaseQAList(result);

		return ret;
	}

}
