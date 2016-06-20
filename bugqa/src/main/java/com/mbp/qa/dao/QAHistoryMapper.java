package com.mbp.qa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mbp.qa.model.dto.QA0010ArgValue;
import com.mbp.qa.model.dto.QA0030ArgValue;
import com.mbp.qa.model.dto.QAHistoryDTO;

public interface QAHistoryMapper {

	/**
	 * ＱＡ情報履歴の連番
	 * 
	 * @param projectId
	 *            プロジェクトＩＤ
	 * @param QANo
	 *            QA番号
	 * @return ＱＡ情報履歴の連番
	 */
	String getHistorySerialNO(@Param("projectId") String projectId, @Param("QANo") String QANo);

	/**
	 * ＱＡ履歴情報を追加
	 * 
	 * @param serialNum
	 *            ＱＡ情報履歴の連番
	 * @param projectId
	 *            画面．プロジェクトＩＤ
	 * @param qaNo
	 *            起動引数．Q&A番号
	 */
	void insertQAHistory(@Param("serialNum") String serialNum, @Param("projectId") String projectId,
			@Param("qaNo") String qaNo);

	/**
	 * Q&A情報履歴登陆
	 * 
	 * @param arg
	 * 
	 */
	void addQAHistory(QA0010ArgValue arg);

	/**
	 * QA历史记录获得
	 * 
	 * @param arg
	 * @return QA历史记录
	 */
	List<QAHistoryDTO> getQAHistoryByPage(QA0030ArgValue arg);

}