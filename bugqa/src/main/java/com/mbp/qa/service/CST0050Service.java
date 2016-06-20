package com.mbp.qa.service;

import java.util.List;

import com.mbp.qa.interceptor.BusinessException;
import com.mbp.qa.model.dto.Page;
import com.mbp.qa.model.po.ClassMaster;
public interface CST0050Service {
	
	/**
	 * CST0050取得课室信息
	 * 
	 * @param customerCode
	 * @param departmentId
	 * @return 
	 */
	List<ClassMaster> getClassInfo(String customerCode,String departmentId,Page page);
	
	/**
	 * CST0050保存课室
	 * 
	 * @param classpo
	 * 			课室信息
	 * @throws BusinessException 
	 */
	void saveClass(ClassMaster classpo) throws BusinessException;
	
	/**
	 * CST0050删除课室列表
	 * 
	 * @param classId
	 * 
	 */
	void deleteClassList(String customerCode,String departmentId,String classId);
	
	/**
	 * CST0050课室Id存在性check
	 * 
	 * @param customerCode
	 * 			客户编号
	 * @param departmentId
	 * 			部门Id
	 */
	int classIdcheck(String customerCode,String departmentId,String classId);
	
	/**
	 * CST0050追加课室
	 * 
	 * @param classpo
	 * 			课室信息
	 * @throws BusinessException 
	 */
	void addClass(ClassMaster classpo) throws BusinessException;
}
