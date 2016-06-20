package com.mbp.qa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mbp.qa.interceptor.BusinessException;
import com.mbp.qa.model.dto.PRO0030ArgValue;
import com.mbp.qa.model.dto.Page;
import com.mbp.qa.model.po.CustomerMaster;
import com.mbp.qa.model.po.GeneralMaster;
import com.mbp.qa.model.po.ModuleMaster;
import com.mbp.qa.model.po.ProjectMaster;
import com.mbp.qa.model.po.ProjectMemberMaster;
import com.mbp.qa.model.po.UserMaster;
import com.mbp.qa.service.BaseService;
import com.mbp.qa.service.PRO0030Service;
import com.mbp.qa.utils.BaseConstants;
import com.mbp.qa.utils.Checker;

@Service
public class PRO0030ServiceImpl extends BaseService implements PRO0030Service {

	/**
	 * 项目信息
	 */
	@Override
	public List<ProjectMaster> projectList(String projectId) {
		return super.projectDao.projectList(projectId);
	}

	/**
	 * 取得项目成员信息
	 */
	@Override
	public List<ProjectMemberMaster> projectMemberList(PRO0030ArgValue arg, Page page) {
		return super.projectMemberDao.projectMemberListByPage(arg, page);
	}

	/**
	 * 删除项目成员
	 */
	@Override
	public void deleteMember(HashMap<String, String> map) {
		super.projectMemberDao.deleteMembers(map);

	}

	/**
	 * 更新项目信息
	 */
	@Override
	@Transaction
	public void updateProjectMsg(PRO0030ArgValue arg) throws Exception {
		// 输入检测
		inputCheck(arg);
		// 更新projectMaster表
		arg.setChargeId(arg.getChargeIdReturn());
		super.projectDao.updateProjectMsg(arg);
		// 更新项目经理
		// 如果原先的项目经理存在，则删除掉原先的项目经理
		// 如果原先的项目经理不存在，新添加的项目经理存在于原项目中，更新项目经理
		// 如果原先的项目经理不存在，新添加的项目经理也不存在与原项目中，新建项目经理
		if (arg.getManagerIdBefore() != null) {
			arg.setUserId(arg.getManagerIdBefore());
			super.projectMemberDao.deleteMember(arg);
		}

		arg.setUserId(arg.getManagerIdReturn());
		String exitFlg = super.projectMemberDao.userIdCheck(arg);

		if (exitFlg.equals("0")) {// 不存在
			arg.setUserId(arg.getManagerIdReturn());
			super.projectMemberDao.addManagerId(arg);

		}
		if (exitFlg.equals("1")) {
			arg.setUserId(arg.getManagerIdReturn());
			// super.projectMemberDao.deleteMember(arg);
			super.projectMemberDao.updManager(arg);
		}

	}

	/**
	 * module viewtree信息
	 */
	@Override
	public List<ModuleMaster> moduleMsg(String projectId) {
		return super.moduleDao.moduleMsg(projectId);
	}

	/**
	 * 项目经理信息
	 */
	@Override
	public List<UserMaster> projectManagerMsg(String projectId) {
		return super.userDao.projectManagerMsg(projectId);
	}

	/**
	 * 更新项目经理
	 */
	@Override
	public void updManager(HashMap<String, String> map) {
		String userId = map.get("");
		// super.projectMemberDao.updManager(map);

	}

	/**
	 * 添加模块信息
	 */
	@Override
	public void newModule(Map<String, String> mapt) {
		try {
			super.moduleDao.addModule((HashMap<String, String>) mapt);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 检查groupID是否已经存在
	 */
	@Override
	public boolean groupIdCheck(Map<String, String> mapt) {
		String groupIdCheck = super.groupDao.groupIdCheck(mapt);
		if (groupIdCheck.equals("0")) {
			return false;// id不存在
		} else {
			return true;// 存在
		}
	}

	/**
	 * 修改小组名
	 */
	@Override
	public void updateGroupName(Map<String, String> mapt) {
		super.groupDao.updateGroupName(mapt);

	}

	/**
	 * 添加小组
	 */
	@Override
	public void addGroupId(Map<String, String> mapt) {
		super.groupDao.addGroupMember((HashMap<String, String>) mapt);

	}

	/**
	 * 输入检测
	 * 
	 * @param arg
	 * @throws BusinessException
	 */
	private void inputCheck(PRO0030ArgValue arg) throws BusinessException {

		// 项目名
		Checker.checkNull(arg.getProjectName());
		Checker.checkMaxLength(arg.getProjectName(), BaseConstants.INT_5000);
		// 会社名
		Checker.checkNull(arg.getCompanyInCode());
		// 得意先名
		Checker.checkNull(arg.getCompanOutCode());
		// 状态
		Checker.checkNull(arg.getStateFlg());
		// 开始日付
		Checker.checkNull(arg.getStartDate());
		// 终了日付
		Checker.checkNull(arg.getEndDate());
		// 开始日付>种了日付
		Checker.compareDate(arg.getStartDate(), arg.getEndDate());
		// 对应种了日付
		Checker.checkNull(arg.getChkEndDate());
		// 种了日付>对应终了日付
		Checker.compareDate(arg.getEndDate(), arg.getChkEndDate());
	}

	/**
	 * 初始化状态下拉框
	 */
	@Override
	public List<GeneralMaster> proStage() {
		return super.generalDao.getKbn03();
	}

	/**
	 * 初始化得意先，会社名下拉框
	 */
	@Override
	public List<CustomerMaster> customerMsg(String companyFlg) {
		return super.customerDao.customerMsg(companyFlg);
	}

}
