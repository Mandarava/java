package com.bugqa.qa.service;

import java.util.HashMap;
import java.util.List;

import com.bugqa.qa.model.dto.USE0031ArgValue;
import com.bugqa.qa.model.po.ClassMaster;
import com.bugqa.qa.model.po.CustomerMaster;
import com.bugqa.qa.model.po.DepartmentMaster;
import com.bugqa.qa.model.po.GeneralMaster;
import com.bugqa.qa.model.po.UserMaster;

public interface USE0031Service {

	/**
	 * 判断ユーザー是否管理员
	 * 
	 * @param userId
	 * @return
	 */
	boolean userPrevlCheck(String userId);

	/**
	 * 初始化ユーザー権限下拉框 取得汎用信息(ユーザー権限)
	 * 
	 * @return
	 */
	List<GeneralMaster> userPrevl();

	/**
	 * 取得当前ユーザー信息
	 * 
	 * @param userId
	 * @return
	 */
	List<UserMaster> userMsg(String userId);

	/**
	 * 初始化得意先下拉框 取得得意先信息 会社フラグ变换 取得会社信息
	 * 
	 * @param companyFlg
	 * @return
	 */
	List<CustomerMaster> customerMsg(String companyFlg);

	/**
	 * 初始化部門下拉框 取得当前ユーザー所在的会社的所有部門信息 得意先变换 取得当前选中的得意先的所有部门信息
	 * 
	 * @param customerCode
	 * @return
	 */
	List<DepartmentMaster> departmentMsg(String customerCode);

	/**
	 * 更新ユーザー信息
	 * 
	 * @param arg
	 * @return
	 */

	void updateUser(USE0031ArgValue arg) throws Exception;

	/**
	 * 初始化课下拉框 取得当前ユーザー所在的部門的所有課信息 部门变换 取得当前部门的所有课信息
	 * 
	 * @param map
	 * @return
	 */
	List<ClassMaster> classMsg(HashMap<String, String> map);

}
