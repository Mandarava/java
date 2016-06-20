package com.bugqa.qa.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bugqa.qa.model.dto.ExcelProjectDTO;
import com.bugqa.qa.model.dto.MAI0050ArgValue;
import com.bugqa.qa.model.dto.PRO0010ArgValue;
import com.bugqa.qa.model.dto.PRO0020ArgValue;
import com.bugqa.qa.model.dto.PRO0030ArgValue;
import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.po.ProjectMaster;

public interface ProjectMasterMapper {

	/**
	 * システム名内容的取得
	 * 
	 * @param userId
	 *            登录用户
	 * @return システム名
	 */
	List<ProjectMaster> getProjectName(String userId);

	/**
	 * 根据项目ID取得システム名情報
	 * 
	 * @param projectId
	 *            项目ID
	 * @return
	 */
	ProjectMaster getProjectById(String projectId);

	/**
	 * QA菜单里的项目名取得
	 * 
	 * @param arg
	 *            登录用户
	 * @return 项目
	 */
	List<ProjectMaster> getProject(MAI0050ArgValue arg);

	/**
	 * QA0070 プロジェクトデータの取得
	 * 
	 * @param projectId
	 *            项目ID
	 * @return プロジェクトデータ
	 */
	ExcelProjectDTO getProInfo(String projectId);

	/**
	 * プロジェクトＩＤによってプロジェクト名を取得
	 * 
	 * @param userId
	 *            登陆用户ＩＤ
	 * @return
	 */
	List<ProjectMaster> getProjectNameByID(String userId);

	/**
	 * 项目ID存在性检查
	 * 
	 * @param map
	 * @return
	 */
	int projectIdCheck(HashMap<String, String> map);

	/**
	 * 新建项目
	 * 
	 * @param map
	 */
	void newProject(Map arg);

	/**
	 * プロジェクトID存在性的チェック
	 * 
	 * @param projectId
	 * @return
	 */
	String projectIdCheck(String projectId);

	/**
	 * 分页检索项目信息
	 * 
	 * @param arg
	 * @param page
	 * @return
	 */
	List<ProjectMaster> queryProjectByPage(@Param("arg") PRO0010ArgValue arg,
			@Param("page") Page page);

	/**
	 * 添加项目
	 * 
	 * @param arg
	 */
	void addProject(PRO0020ArgValue arg);

	List<ProjectMaster> getProjectNa(String userId);

	/**
	 * 删除项目
	 * 
	 * @param projectId
	 */
	void deleteProject(String projectId);

	/**
	 * 项目信息
	 */
	List<ProjectMaster> projectList(String projectId);

	/**
	 * 更新项目信息
	 * 
	 * @param arg
	 */
	void updateProjectMsg(PRO0030ArgValue arg);

}