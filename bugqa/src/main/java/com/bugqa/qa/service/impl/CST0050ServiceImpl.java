package com.bugqa.qa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bugqa.qa.interceptor.BusinessException;
import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.po.ClassMaster;
import com.bugqa.qa.service.BaseService;
import com.bugqa.qa.service.CST0050Service;
import com.bugqa.qa.utils.Checker;

@Service
public class CST0050ServiceImpl extends BaseService implements CST0050Service {

	/**
	 * CST0050取得客室信息
	 * 
	 * @param customerCode
	 *            客户编号
	 * @param departmentId
	 *            部门ID
	 * @return classMasterList 课室信息列表
	 */
	@Override
	public List<ClassMaster> getClassInfo(String customerCode, String departmentId, Page page) {
		List<ClassMaster> classMasterList = classDao.getClassInfoByPage(customerCode, departmentId,
				page);
		return classMasterList;
	}

	/**
	 * CST0050删除课室列表
	 * 
	 * @param classId
	 *            课室Id
	 */
	@Override
	public void deleteClassList(String customerCode, String departmentId, String classId) {
		classDao.deleteClassList(customerCode, departmentId, classId);

	}

	/**
	 * CST0050追加课室时的课室Id存在性check
	 * 
	 * @param classId
	 *            课室Id
	 */
	@Override
	public int classIdcheck(String customerCode, String departmentId, String classId) {

		return classDao.classIdCheck(customerCode, departmentId, classId);
	}

	/**
	 * CST0050追加课室
	 * 
	 * @param classpo
	 *            课室信息
	 * @throws BusinessException
	 */
	@Override
	public void addClass(ClassMaster classpo) throws BusinessException {
		// 输入检测
		inputCheck(classpo);
		classDao.addClass(classpo);

	}

	/**
	 * CST0050保存课室
	 * 
	 * @param classpo
	 *            课室信息
	 * @throws BusinessException
	 */
	@Override
	public void saveClass(ClassMaster classpo) throws BusinessException {
		// 输入检测
		inputCheck(classpo);
		classDao.saveClass(classpo);

	}

	/**
	 * 输入检测
	 * 
	 * @param classpo
	 *            课室信息
	 * @throws BusinessException
	 */
	private void inputCheck(ClassMaster classpo) throws BusinessException {
		// 课室Id
		Checker.checkNull(classpo.getClassId());
		Checker.checkHalf(classpo.getClassId());
		// 课室名称
		Checker.checkNull(classpo.getClassName());

	}

}
