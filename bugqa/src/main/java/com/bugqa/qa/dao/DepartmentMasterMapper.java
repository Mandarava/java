package com.bugqa.qa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bugqa.qa.model.dto.DeptInfo;
import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.po.DepartmentMaster;

public interface DepartmentMasterMapper {

	List<DepartmentMaster> getDepartmentMsg(String departmentId);

	/**
	 * 得意先变换 取得当前选中的得意先的所有部门信息
	 */
	List<DepartmentMaster> departmentMsg(String customerCode);

	/**
	 * CST0030客户编辑（取得部门信息）
	 * 
	 * @param customerMaster
	 * 
	 * @return
	 */
	List<DeptInfo> getCustomerDeptInfo(String customerCode);

	/**
	 * CST0040取得部门信息
	 * 
	 * @param customerMaster
	 * 
	 * @return
	 */
	List<DepartmentMaster> getDepartmentInfoByPage(@Param("customerCode") String customerCode,
			@Param("page") Page page);

	/**
	 * CST0040追加部门时的部门ID存在性check
	 * 
	 * @param customerMaster
	 * 
	 * @return
	 */
	int departmentIdCheck(@Param("customerCode") String customerCode,
			@Param("departmentId") String departmentId);

	/**
	 * CST0040追加部门
	 * 
	 * @param departmentMasterpo
	 */
	void addDepartment(DepartmentMaster departmentMasterpo);

	/**
	 * CST0040删除部门信息
	 * 
	 * @param customerMaster
	 * 
	 * @return
	 */
	void deleteDept(@Param("customerCode") String customerCode,
			@Param("departmentId") String departmentId);

	/**
	 * CST0040保存部门
	 * 
	 * @param departmentMasterpo
	 */
	void saveDepartment(DepartmentMaster departmentMasterpo);
}