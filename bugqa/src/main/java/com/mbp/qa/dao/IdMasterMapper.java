package com.mbp.qa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mbp.qa.model.dto.PRO0020ArgValue;
import com.mbp.qa.model.po.IdMaster;

public interface IdMasterMapper {
	/**
	 * 获得BUG連番
	 * 
	 * @param projectId
	 *            项目ID
	 * @param projectId
	 *            作业
	 * @param projectId
	 *            社内flg
	 * @return
	 */
	List<IdMaster> getBUGSerialNO(@Param("projectId") String projectId,
			@Param("stage") String stage);

	/**
	 * 更新连番
	 * 
	 * @param bugSerialNo
	 *            连番
	 * @param projectId
	 *            项目ID
	 * @param userId
	 *            用户ID
	 */
	void updateBUGSerialNo(@Param("bugSerialNo") String bugSerialNo,
			@Param("projectId") String projectId, @Param("userId") String userId);

	void addBug(PRO0020ArgValue arg);// BUG采番表的登录

}