package com.bugqa.qa.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bugqa.qa.model.dto.MOD0040ArgValue;
import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.po.ModuleMaster;

public interface ModuleMasterMapper {

	/**
	 * 模块名取得
	 * 
	 * @param projectId
	 *            画面上选择的项目ID
	 * @param groupId
	 *            画面上选择的组名
	 * @return
	 */
	List<ModuleMaster> getModule(@Param("projectId") String projectId,
			@Param("groupId") String groupId);

	/**
	 * QA0070 モジュールの取得
	 * 
	 * @param projectId
	 *            项目ID
	 * @return モジュール
	 */
	List<ModuleMaster> getModInfo(String projectId);

	/**
	 * module信息
	 * 
	 * @param projectId
	 * @return
	 */
	List<ModuleMaster> moduleMsg(String projectId);

	/**
	 * 检索module信息
	 * 
	 * @param map
	 * @return
	 */
	List<ModuleMaster> moduleListByPage(@Param("arg") MOD0040ArgValue arg,
			@Param("page") Page page);

	/**
	 * 添加模块信息
	 * 
	 * @param map
	 */
	void addModule(HashMap<String, String> map);

	/**
	 * 删除模块信息
	 * 
	 * @param map
	 */
	void deleteModule(HashMap<String, String> map);

}