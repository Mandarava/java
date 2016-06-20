package com.bugqa.qa.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.po.ClassMaster;

public interface ClassMasterMapper {

	/**
	 * 部门变换 取得当前部门的所有课信息
	 */
	List<ClassMaster> classMsg(HashMap<String, String> map);

	/**
	 * CST0050取得当前部门的课信息列表
	 * 
	 * @param customerCode
	 *            客户编号
	 * @param departmentId
	 *            部门Id
	 */
	List<ClassMaster> getClassInfoByPage(@Param("customerCode") String customerCode,
			@Param("departmentId") String departmentId, @Param("page") Page page);

	/**
	 * CST0050保存课室
	 * 
	 * @param classpo
	 *            课室信息
	 */
	void saveClass(ClassMaster classpo);

	/**
	 * CST0050课室Id存在性check
	 * 
	 * @param classId
	 *            课室Id
	 */
	int classIdCheck(@Param("customerCode") String customerCode,
			@Param("departmentId") String departmentId, @Param("classId") String classId);

	/**
	 * CST0050追加课室
	 * 
	 * @param classpo
	 *            课室信息
	 */
	void addClass(ClassMaster classpo);

	/**
	 * CST0050删除课室列表
	 * 
	 * @param classId
	 *            课室Id
	 */
	void deleteClassList(@Param("customerCode") String customerCode,
			@Param("departmentId") String departmentId, @Param("classId") String classId);
}