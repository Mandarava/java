package com.mbp.qa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mbp.qa.interceptor.BusinessException;
import com.mbp.qa.model.dto.Page;
import com.mbp.qa.model.po.DepartmentMaster;
import com.mbp.qa.service.BaseService;
import com.mbp.qa.service.CST0040Service;
import com.mbp.qa.utils.Checker;

@Service
public class CST0040ServiceImpl extends BaseService implements CST0040Service {

	/**
	 * CST040取得部门列表
	 * 
	 * @param customerCode
	 *            客户编号
	 */
	@Override
	public List<DepartmentMaster> getDepartmentInfoService(String customerCode, Page page) {
		List<DepartmentMaster> departmentMasterpo = departmentDao
				.getDepartmentInfoByPage(customerCode, page);

		return departmentMasterpo;
	}

	/**
	 * CST040删除部门列表
	 * 
	 * @param departmentId
	 *            部门Id
	 */
	@Override
	public void deleteDept(String customerCode, String departmentId) {
		departmentDao.deleteDept(customerCode, departmentId);

	}

	/**
	 * CST040追加部门check
	 * 
	 * @param departmentId
	 *            部门Id
	 */
	@Override
	public int departmentIdCheck(String customerCode, String departmentId) {
		return departmentDao.departmentIdCheck(customerCode, departmentId);

	}

	/**
	 * CST04追加部门
	 * 
	 * @param departmentMasterpo
	 *            部门信息
	 * @throws BusinessException
	 */
	@Override
	public void addDepartment(DepartmentMaster departmentMasterpo) throws BusinessException {
		// 输入检测
		inputCheck(departmentMasterpo);
		departmentDao.addDepartment(departmentMasterpo);

	}

	/**
	 * CST04保存部门
	 * 
	 * @param departmentMasterpo
	 *            部门信息
	 * @throws BusinessException
	 */
	@Override
	public void saveDepartment(DepartmentMaster departmentMasterpo) throws BusinessException {
		// 输入检测
		inputCheck(departmentMasterpo);
		departmentDao.saveDepartment(departmentMasterpo);

	}

	/**
	 * 输入检测
	 * 
	 * @param departmentMasterpo
	 * @throws BusinessException
	 */
	public void inputCheck(DepartmentMaster departmentMasterpo) throws BusinessException {
		// 部门Id
		Checker.checkNull(departmentMasterpo.getDepartmentId());
		Checker.checkHalf(departmentMasterpo.getDepartmentId());
		// 部门名称
		Checker.checkNull(departmentMasterpo.getDepartmentName());

	}

}
