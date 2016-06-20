package com.bugqa.qa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bugqa.qa.interceptor.BusinessException;
import com.bugqa.qa.model.dto.PRO0010ArgValue;
import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.po.ProjectMaster;
import com.bugqa.qa.service.BaseService;
import com.bugqa.qa.service.PRO0010Service;
import com.bugqa.qa.utils.BaseConstants;
import com.bugqa.qa.utils.Checker;
import com.bugqa.qa.utils.CommonUtils;

@Service
public class PRO0010ServiceImpl extends BaseService implements PRO0010Service {

	/**
	 * 检索项目信息
	 */
	@Override
	public List<ProjectMaster> queryProject(PRO0010ArgValue arg, Page page) {
		// 检索条件
		if (arg.getSearchKey() != null) {
			try {
				inputCheck(arg);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}
		List<ProjectMaster> result = super.projectDao.queryProjectByPage(arg, page);
		CommonUtils.convertNullToEmptyString(result);
		return result;
	}

	/**
	 * 删除项目
	 */
	@Override
	public void deleteProject(String projectId) {
		super.projectDao.deleteProject(projectId);
	}

	/**
	 * 输入检测
	 * 
	 * @param arg
	 * @throws BusinessException
	 */
	private void inputCheck(PRO0010ArgValue arg) throws BusinessException {

		// 检索条件
		Checker.checkMaxLength(arg.getSearchKey(), BaseConstants.INT_20);

	}

}
