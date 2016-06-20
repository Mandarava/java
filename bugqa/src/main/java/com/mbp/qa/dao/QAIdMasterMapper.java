package com.mbp.qa.dao;

import org.apache.ibatis.annotations.Param;

import com.mbp.qa.model.dto.PRO0020ArgValue;
import com.mbp.qa.model.po.QAIdMaster;

public interface QAIdMasterMapper {

	/**
	 * 获得QA連番
	 * 
	 * @param projectId
	 *            项目ID
	 * @return
	 */
	QAIdMaster getQASerialNO(String projectId);

	/**
	 * 更新连番
	 * 
	 * @param qaSerialNo
	 *            连番
	 * @param projectId
	 *            项目ID
	 * @param userId
	 *            用户ID
	 */
	void updateQASerialNo(@Param("projectId") String projectId, @Param("userId") String userId);

	/**
	 * QA采番表登录
	 * 
	 * @param arg
	 */
	void addQA(PRO0020ArgValue arg);

}