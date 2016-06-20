package com.mbp.qa.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mbp.qa.model.dto.GRO0040ArgValue;
import com.mbp.qa.model.dto.Page;
import com.mbp.qa.model.po.GroupMaster;

public interface GroupMasterMapper {

	/**
	 * グループ名内容的取得
	 * 
	 * @param projectId
	 *            项目ID
	 * @return グループ名
	 */
	List<GroupMaster> getGroupID(String projectId);

	/**
	 * 检索group信息
	 * 
	 * @param projectId
	 * @return
	 */
	List<GroupMaster> groupListByPage(@Param("arg") GRO0040ArgValue arg, @Param("page") Page page);

	/**
	 * 添加小组成员
	 * 
	 * @param map
	 */
	void addGroupMember(HashMap<String, String> map);

	/**
	 * 删除小组成员
	 * 
	 * @param map
	 */
	void deleteGroupMember(HashMap<String, String> map);

	/**
	 * 修改小组名
	 * 
	 * @param mapt
	 */
	void updateGroupName(Map<String, String> mapt);

	/**
	 * 小组ID存在性检查
	 * 
	 * @param mapt
	 * @return
	 */
	String groupIdCheck(Map<String, String> mapt);

}