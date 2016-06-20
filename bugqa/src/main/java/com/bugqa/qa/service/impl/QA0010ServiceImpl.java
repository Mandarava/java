package com.bugqa.qa.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bugqa.qa.interceptor.BusinessException;
import com.bugqa.qa.model.dto.QA0010ArgValue;
import com.bugqa.qa.model.dto.QA0010RetValue;
import com.bugqa.qa.model.po.GeneralMaster;
import com.bugqa.qa.model.po.GroupMaster;
import com.bugqa.qa.model.po.ModuleMaster;
import com.bugqa.qa.model.po.ProjectMaster;
import com.bugqa.qa.model.po.ProjectMemberMaster;
import com.bugqa.qa.model.po.QAIdMaster;
import com.bugqa.qa.model.po.UserMaster;
import com.bugqa.qa.service.BaseService;
import com.bugqa.qa.service.QA0010Service;
import com.bugqa.qa.utils.BaseConstants;
import com.bugqa.qa.utils.Checker;
import com.bugqa.qa.utils.CommonUtils;
import com.bugqa.qa.utils.FileUtil;
import com.bugqa.qa.utils.MessageConstants;

/**
 * QA新规 serviceImpl
 * 
 * @author s1507112
 *
 */
@Service
public class QA0010ServiceImpl extends BaseService implements QA0010Service {

	private static Logger logger = LoggerFactory.getLogger(QA0010ServiceImpl.class);

	/**
	 * QA0010初始化下拉框数据
	 * 
	 * @param arg
	 */
	@Override
	public QA0010RetValue getInitData(QA0010ArgValue arg) {

		QA0010RetValue result = new QA0010RetValue();

		// 系统名
		List<ProjectMaster> projectList = this.getProjectNameByID(arg.getUser().getUserId());
		result.setProjectList(projectList);
		// 质问区分
		result.setQuestionDivList(this.getQuestionDiv());
		// 摘出作业
		result.setStageList(this.getStage01Name());
		// 项目存在场合
		if (projectList != null && projectList.size() > 0) {
			String projectId = null;
			if (!StringUtils.isEmpty(arg.getProjectId())) {
				// 再QA场合
				projectId = arg.getProjectId();
			} else {
				// 新规的场合默认选择第一个
				projectId = projectList.get(0).getProjectId();
			}
			// 发生机能
			result.setGroupList(this.getGroupName(projectId));
			// 提问者
			result.setDetectorList(this.getDetector(projectId));
			// 回答者
			result.setAnswererList(this.getAnswerer(projectId, arg.getUser().getUserId(),
					arg.getUser().getCompanyFlg()));
		}

		return result;
	}

	/**
	 * 系统名变化初始化下拉框数据
	 */
	@Override
	public QA0010RetValue getProjectChangeData(QA0010ArgValue arg) {

		QA0010RetValue result = new QA0010RetValue();

		// 发生机能
		result.setGroupList(this.getGroupName(arg.getProjectId()));
		// 提出者情報
		result.setDetectorList(this.getDetector(arg.getProjectId()));
		// 回答者情报
		result.setAnswererList(this.getAnswerer(arg.getProjectId(), arg.getUser().getUserId(),
				arg.getUser().getCompanyFlg()));

		return result;
	}

	/**
	 * 发生个所变化初始化下拉框数据
	 */
	@Override
	public QA0010RetValue getGroupChangeData(QA0010ArgValue arg) {

		QA0010RetValue result = new QA0010RetValue();

		// 発生個所
		result.setModuleList(this.getModule(arg.getProjectId(), arg.getGroupId()));

		return result;
	}

	/**
	 * 插入QA
	 * 
	 * @throws BusinessException
	 */
	@Override
	@Transaction
	public String addQA(QA0010ArgValue arg) throws Exception {

		// 输入检测
		inputCheck(arg);

		// 采番マスタに采番する
		super.qaIdDao.updateQASerialNo(arg.getProjectId(), arg.getUser().getUserId());

		// QAの番号を取得。
		QAIdMaster qaId = super.qaIdDao.getQASerialNO(arg.getProjectId());
		// QAの番号
		String qaNo = qaId.getCompanyName() + "_" + qaId.getSerialNo();
		arg.setQaNo(qaNo);

		if (arg.getQuestioner().equals(BaseConstants.SHANAIFLG)
				&& arg.getAnswerer().equals(BaseConstants.SHAGAIFLG)) {
			// 社内（提出者和予定回答者都是社内用户时）
			arg.setCompanyFlg(BaseConstants.SHANAIFLG);
		} else {
			// 社外（提出者或予定回答者有社外用户时）
			arg.setCompanyFlg(BaseConstants.SHAGAIFLG);
		}

		// 有添付資料的场合、添付資料ファイル名前を取得
		String fileName = arg.getQattachedInfo();
		if (null != arg.getFile()) {
			arg.setQattachedInfo("Q" + CommonUtils.newUploadFileName(qaNo, fileName));
		}
		// Q&A情報登陆
		super.qaDao.insertQA(arg);
		// Q&A情報履歴登陆
		super.qaHistoryDao.addQAHistory(arg);

		// Q&A情報履歴連番
		String serialNum = super.qaHistoryDao.getHistorySerialNO(arg.getProjectId(), qaNo);
		if (StringUtils.isEmpty(serialNum)) {
			// 新規の場合
			serialNum = "00001";
		} else {
			int historyNo = Integer.valueOf(serialNum) + 1;
			serialNum = String.format("%05d", historyNo);
		}
		arg.setSerialNum(serialNum);

		// 起動引数的関連Q&A番号存在时
		if (!StringUtils.isEmpty(arg.getRelationQaNo())) {
			Date updateTime = super.qaDao.getUpdateTime(arg.getProjectId(), arg.getRelationQaNo());
			arg.setUpdateTime(updateTime);
			// 更改関連Q&A的状态为再QA
			int affectedRows = super.qaDao.updateQAInfo(arg);

			if (affectedRows == 0) {
				throw new BusinessException(MessageConstants.QA0004);
			}

			// ＱＡ履歴情報を追加
			super.qaHistoryDao.insertQAHistory(serialNum, arg.getProjectId(), arg.getQaNo());
		}

		// 上传文件
		if (!StringUtils.isEmpty(arg.getQattachedInfo())) {
			FileUtil.saveFile(arg.getFile(), arg.getQattachedInfo());
		}

		logger.info("addQA success");

		return qaNo;

	}

	/**
	 * 摘出作業情報の取得
	 */
	private List<GeneralMaster> getStage01Name() {

		return super.generalDao.getKbn01();
	}

	/**
	 * 質問区分情報の取得
	 */
	private List<GeneralMaster> getQuestionDiv() {

		return super.generalDao.getKbnQD();
	}

	/**
	 * プロジェクトＩＤによってプロジェクト名を取得
	 * 
	 * @param 登录用户ID
	 */
	private List<ProjectMaster> getProjectNameByID(String userId) {

		return super.projectDao.getProjectNameByID(userId);
	}

	/**
	 * グルプ名を取得
	 */
	private List<GroupMaster> getGroupName(String projectId) {

		return super.groupDao.getGroupID(projectId);
	}

	/**
	 * 提出者を取得
	 */
	private List<UserMaster> getDetector(String projectId) {

		return super.userDao.getQuestioner(projectId);
	}

	/**
	 * 予定回答者を取得
	 */
	private List<UserMaster> getAnswerer(String projectId, String userId, String companyFlg) {

		ProjectMemberMaster project = new ProjectMemberMaster();

		project = super.projectMemberDao.getWorkType(userId, projectId);

		String workType = project.getWorkType();

		logger.info("getAnswerer " + userId + " workType ： " + workType);

		return super.userDao.getAnswerer(projectId, workType, companyFlg);
	}

	/**
	 * 発生個所のドロップダウンリスト情報を取る
	 * 
	 * @param projectId
	 *            画面选择的プロジェクトＩＤ
	 * @param groupId
	 *            画面选择的グループＩＤ
	 */
	private List<ModuleMaster> getModule(String projectId, String groupId) {

		return super.moduleDao.getModule(projectId, groupId);
	}

	private void inputCheck(QA0010ArgValue arg) throws BusinessException {

		// システム名
		Checker.checkNull(arg.getProjectId());
		// 発生個所
		Checker.checkNull(arg.getGroupId());
		// 発生機能
		Checker.checkNull(arg.getModuleId());
		// 提出日
		Checker.checkNull(arg.getQuestionDate());
		// タイトル
		Checker.checkNull(arg.getQaTitle());
		Checker.checkMaxLength(arg.getQaTitle(), BaseConstants.INT_5000);
		// 質問内容
		Checker.checkNull(arg.getQuestionInfo());
		Checker.checkMaxLength(arg.getQuestionInfo(), BaseConstants.INT_5000);
		// 摘出作業
		Checker.checkNull(arg.getStage());
		// 提出者
		Checker.checkNull(arg.getQuestioner());
		// 予定回答者
		Checker.checkNull(arg.getAnswerer());
		// 希望回答日
		Checker.checkNull(arg.getExpDate());
		// 提出日>希望回答日
		Checker.compareDate(arg.getQuestionDate(), arg.getExpDate());
	}

}
