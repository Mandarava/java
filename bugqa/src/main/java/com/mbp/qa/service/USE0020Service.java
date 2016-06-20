package com.mbp.qa.service;

import java.util.HashMap;
import java.util.List;

import com.mbp.qa.model.dto.USE0020ArgValue;
import com.mbp.qa.model.po.ClassMaster;
import com.mbp.qa.model.po.CustomerMaster;
import com.mbp.qa.model.po.DepartmentMaster;
import com.mbp.qa.model.po.GeneralMaster;

public interface USE0020Service {

	/**
	 * 判断ユーサー信息是否管理员
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
	 * 初始化得意先下拉框 取得得意先信息(会社フラグ='0')
	 * 
	 * @return
	 */
	List<CustomerMaster> selCustCode();

	/**
	 * 会社フラグ变换 取得会社信息
	 * 
	 * @param companyFlg
	 * @return
	 */
	List<CustomerMaster> customerMsg(String companyFlg);

	/**
	 * 得意先变换 取得当前选中的得意先的所有部门信息
	 * 
	 * @param customerCode
	 * @return
	 */
	List<DepartmentMaster> departmentMsg(String customerCode);

	/**
	 * 部门变换 取得当前部门的所有课信息
	 * 
	 * @param map
	 * @return
	 */
	List<ClassMaster> classMsg(HashMap<String, String> map);

	/**
	 * 用户新规事物
	 * 
	 * @param arg
	 * @return
	 */
	String addUserMsg(USE0020ArgValue arg) throws Exception;

}
