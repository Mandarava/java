package com.mbp.qa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mbp.qa.interceptor.BusinessException;
import com.mbp.qa.model.dto.PRO0020ArgValue;
import com.mbp.qa.model.po.CustomerMaster;
import com.mbp.qa.model.po.GeneralMaster;
import com.mbp.qa.service.BaseService;
import com.mbp.qa.service.PRO0020Service;
import com.mbp.qa.utils.BaseConstants;
import com.mbp.qa.utils.Checker;

@Service
public class PRO0020ServiceImpl extends BaseService implements PRO0020Service {

	/**
	 * 初始化状態下拉框 取得汎用信息(プロジェクト状態)
	 */
	@Override
	public List<GeneralMaster> proStage() {
		return super.generalDao.getKbn03();
	}

	/**
	 * 初始化会社名下拉框 取得本会社信息 初始化得意先下拉框 取得得意先信息
	 */
	@Override
	public List<CustomerMaster> customerMsg(String companyFlg) {
		return super.customerDao.customerMsg(companyFlg);
	}

	/**
	 * 登录项目相关信息
	 */
	@Override
	@Transaction
	public String addProjectMsg(PRO0020ArgValue arg) throws Exception {

		// 输入检测
		inputCheck(arg);
		String exit = "";
		// 检查项目ID是否存在
		String projectIdCheck = super.projectDao.projectIdCheck(arg.getProjectId());

		if (projectIdCheck.equals("0")) { // id不存在
			// 数组
			String[] stageName = new String[] { "null", "SRS", "HLD", "LLD", "UT", "IT", "ST" };

			// 登录プロジェクト表
			super.projectDao.addProject(arg);

			// 登录メンバーマスター表 マネージャー或责任者有入力の場合
			// マネージャー登录
			if (arg.getManagerId() != null) {
				arg.setUserId(arg.getManagerId());
				super.projectMemberDao.addMember(arg);
			}
			// 责任者登录
			if (arg.getChargeId() != null) {
				arg.setUserId(arg.getChargeId());
				super.projectMemberDao.addMember(arg);
			}

			// 登录采番マスター表
			// BUG采番表(本会社6条)的登录
			for (int i = 1; i <= 6; i++) {
				String stage = String.valueOf(i);
				arg.setStage(stage);
				arg.setStageName(stageName[i]);
				arg.setCompanyFlg("0");
				super.idDao.addBug(arg);
			}
			// BUG采番表(得意先6条)的登录
			for (int i = 1; i <= 6; i++) {
				String stage = String.valueOf(i);
				arg.setStage(stage);
				arg.setStageName(stageName[i]);
				arg.setCompanyFlg("1");
				super.idDao.addBug(arg);
			}
			// QA采番表的登录
			String customernamesum = super.customerDao.getCustomerNameSum(arg.getCompanyInCode());
			arg.setCompanyName(customernamesum);
			super.qaIdDao.addQA(arg);
			exit = "notExit";
		} else {
			exit = "exit";
		}

		return exit;

	}

	/**
	 * 输入检测
	 * 
	 * @param arg
	 * @throws BusinessException
	 */
	private void inputCheck(PRO0020ArgValue arg) throws BusinessException {

		// 项目ID
		Checker.checkNull(arg.getProjectId());
		// 长度
		Checker.checkMaxLength(arg.getProjectId(), BaseConstants.INT_5000);
		// 半角英数字
		Checker.checkHalf(arg.getProjectId());
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

}
