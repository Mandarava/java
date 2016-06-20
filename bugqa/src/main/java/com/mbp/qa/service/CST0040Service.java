package com.mbp.qa.service;

import java.util.List;

import com.mbp.qa.interceptor.BusinessException;
import com.mbp.qa.model.dto.Page;
import com.mbp.qa.model.po.DepartmentMaster;

public interface CST0040Service {

	/**
	 * CST0040取得部门信息
	 * 
	 * @param customerCode
	 *            客户编号
	 * @param page
	 * @return List<DepartmentMaster> 部门信息
	 */
	List<DepartmentMaster> getDepartmentInfoService(String customerCode, Page page);

	/**
	 * CST0040删除部门
	 * 
	 * @param customerCode
	 *            客户编号
	 * 
	 */
	void deleteDept(String customerCode, String departmentId);

	/**
	 * CST0040追加部门时的部门ID存在性check
	 * 
	 * @param departmentId
	 *            部门ID
	 * @return int 判断的结果
	 */
	int departmentIdCheck(String customerCode, String departmentId);

	/**
	 * 追加部门
	 * 
	 * @param departmentMasterpo
	 *            部门信息
	 * @throws BusinessException
	 * 
	 */
	void addDepartment(DepartmentMaster departmentMasterpo) throws BusinessException;

	/**
	 * 保存部门
	 * 
	 * @param departmentMasterpo
	 *            部门信息
	 * @throws BusinessException
	 * 
	 */
	void saveDepartment(DepartmentMaster departmentMasterpo) throws BusinessException;

}
