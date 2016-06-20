package com.mbp.qa.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mbp.qa.model.dto.PRO0030ArgValue;
import com.mbp.qa.model.dto.Page;
import com.mbp.qa.model.po.CustomerMaster;
import com.mbp.qa.model.po.GeneralMaster;
import com.mbp.qa.model.po.ModuleMaster;
import com.mbp.qa.model.po.ProjectMaster;
import com.mbp.qa.model.po.ProjectMemberMaster;
import com.mbp.qa.model.po.UserMaster;

public interface PRO0030Service {

	/**
	 * 项目信息
	 * 
	 * @param projectId
	 * @return
	 */
	List<ProjectMaster> projectList(String projectId);

	/**
	 * 取得项目成员信息
	 * 
	 * @param projectId
	 * @return
	 */
	List<ProjectMemberMaster> projectMemberList(PRO0030ArgValue arg, Page page);

	/**
	 * 删除项目成员（删除项目经理）
	 * 
	 * @param map
	 */
	void deleteMember(HashMap<String, String> map);

	/**
	 * 更新项目信息
	 * 
	 * @param arg
	 */
	void updateProjectMsg(PRO0030ArgValue arg) throws Exception;

	/**
	 * module 信息
	 * 
	 * @param parameter
	 * @return
	 */
	List<ModuleMaster> moduleMsg(String projectId);

	/**
	 * 取得项目经理信息
	 * 
	 * @param parameter
	 * @return
	 */
	List<UserMaster> projectManagerMsg(String projectId);

	/**
	 * 更新项目经理
	 * 
	 * @param map
	 */
	void updManager(HashMap<String, String> map);

	/**
	 * 添加模块信息
	 * 
	 * @param mapt
	 */
	void newModule(Map<String, String> mapt);

	/**
	 * 组ID存在性检查
	 * 
	 * @param string
	 * @return
	 */
	boolean groupIdCheck(Map<String, String> mapt);

	/**
	 * 修改groupName
	 * 
	 * @param mapt
	 */
	void updateGroupName(Map<String, String> mapt);

	/**
	 * 添加groupID
	 * 
	 * @param mapt
	 */
	void addGroupId(Map<String, String> mapt);

	/**
	 * 初始化状态信息
	 * 
	 * @return
	 */
	List<GeneralMaster> proStage();

	/**
	 * 初始化得意先，会社名下拉框
	 * 
	 * @param companyFlg
	 * @return
	 */
	List<CustomerMaster> customerMsg(String companyFlg);

}
