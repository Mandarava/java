package com.mbp.qa.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mbp.qa.model.dto.PRO0020ArgValue;
import com.mbp.qa.model.dto.PRO0030ArgValue;
import com.mbp.qa.model.dto.Page;
import com.mbp.qa.model.po.ProjectMemberMaster;

public interface ProjectMemberMasterMapper {

	/**
	 * 取得WorkType
	 * 
	 * @param userId
	 * @param projectId
	 * @return
	 */
	ProjectMemberMaster getWorkType(@Param("userId") String userId,
			@Param("projectId") String projectId);

	/**
	 * 添加项目经理
	 * 
	 * @param map
	 */
	void newManager(Map map);

	/**
	 * マネージャー登录 责任者登录
	 * 
	 * @param map
	 */
	void addMember(PRO0020ArgValue arg);

	/**
	 * ユーザー信息插入メンバーマスター
	 * 
	 * @param map
	 */
	void insertUserMsg(Map<String, Object> map);

	/**
	 * 项目成员信息
	 * 
	 * @param projectId
	 * @return
	 */
	List<ProjectMemberMaster> projectMemberListByPage(@Param("arg") PRO0030ArgValue arg,
			@Param("page") Page page);

	/**
	 * 删除项目成员
	 * 
	 * @param arg
	 */
	void deleteMember(PRO0030ArgValue arg);

	/**
	 * 当前用户（登陆者）项目信息
	 * 
	 * @param userId
	 * @return
	 */
	List<ProjectMemberMaster> userProjectMsg(String userId);

	/**
	 * 更新项目经理
	 * 
	 * @param arg
	 */
	void updManager(PRO0030ArgValue arg);

	/**
	 * 验证原项目经理是否存在
	 * 
	 * @param arg
	 * @return
	 */
	String userIdCheck(PRO0030ArgValue arg);

	/**
	 * 添加项目经理
	 * 
	 * @param arg
	 */
	void addManagerId(PRO0030ArgValue arg);

	void deleteMembers(HashMap<String, String> map);

}