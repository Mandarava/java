package com.bugqa.qa.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bugqa.qa.interceptor.BusinessException;
import com.bugqa.qa.model.dto.QA0020ArgValue;
import com.bugqa.qa.model.dto.QA0020RetValue;
import com.bugqa.qa.model.dto.QADetailDTO;
import com.bugqa.qa.model.po.GeneralMaster;
import com.bugqa.qa.model.po.GroupMaster;
import com.bugqa.qa.model.po.ModuleMaster;
import com.bugqa.qa.model.po.ProjectMaster;
import com.bugqa.qa.model.po.ProjectMemberMaster;
import com.bugqa.qa.model.po.UserMaster;
import com.bugqa.qa.service.BaseService;
import com.bugqa.qa.service.QA0020Service;
import com.bugqa.qa.utils.BaseConstants;
import com.bugqa.qa.utils.Checker;
import com.bugqa.qa.utils.CommonUtils;
import com.bugqa.qa.utils.FileUtil;
import com.bugqa.qa.utils.MessageConstants;

/**
 * Q&A详细、修正（QA0020）ServiceImpl
 * 
 * @author s1507112
 *
 */
@Service
public class QA0020ServiceImpl extends BaseService implements QA0020Service {

	private static Logger logger = LoggerFactory.getLogger(QA0020ServiceImpl.class);

	/**
	 * 初始化数据
	 */
	@Override
	public QA0020RetValue getInitData(QA0020ArgValue arg) {

		QA0020RetValue result = new QA0020RetValue();

		String projectId = arg.getProjectId();

		// 系统名获得
		result.setProject(this.getProjectById(projectId));
		// 原因区分
		result.setCauseDivList(this.getCauseDiv());
		// 質問区分
		result.setQuestionDivList(this.getQuestionDiv());
		// 摘出作業
		result.setStageList(this.getStage());
		// 発生機能
		List<GroupMaster> groupList = this.getGroupList(projectId);
		result.setGroupList(groupList);
		// 発生機能内容存在场合
		if (groupList != null && groupList.size() > 0) {
			// 発生個所
			result.setModuleList(this.getModuleList(projectId, groupList.get(0).getGroupId()));
		}
		// 提出者
		result.setQuestionerList(this.getQuestionerList(projectId));
		// 登陆用户在QA所在项目中担当角色情报
		ProjectMemberMaster projectMember = this.getUserWorkType(arg.getUser().getUserId(), projectId); 
		String workType = projectMember.getWorkType();
		// 予定回答者
		result.setAnswererList(
				this.getAnswerList(projectId, workType, arg.getUser().getCompanyFlg()));
		// 界面初始化QA情报
		result.setQaInfo(this.getQAInfo(projectId, arg.getQaNo(), arg.getSerialNum()));

		return result;
	}

	/**
	 * 発生機能选择初始化数据取得
	 * 
	 * @param arg
	 */
	@Override
	public QA0020RetValue getGroupChangeData(QA0020ArgValue arg) {

		QA0020RetValue result = new QA0020RetValue();

		// 発生個所
		result.setModuleList(this.getModuleList(arg.getProjectId(), arg.getGroupId()));

		return result;
	}

	/**
	 * QA情报を取得します。
	 * 
	 * @param projectId
	 *            项目ID
	 * @param qaNo
	 *            QA番号
	 * @param serialNUm
	 *            履历连番
	 * 
	 * @return QA情报
	 */
	private QADetailDTO getQAInfo(String projectId, String qaNo, String serialNum) {

		QADetailDTO result = super.qaDao.getQAInfo(projectId, qaNo, serialNum);
		// 去null
		CommonUtils.convertNullToEmptyString(result);

		logger.info("getQAInfo success");

		return result;
	}

	/**
	 * 保存QA
	 * 
	 * @throws Exception
	 */
	@Override
	@Transaction
	public void saveQA(QA0020ArgValue arg) throws Exception {

		// 输入检测
		inputCheck(arg);

		if (arg.getQuestioner().equals(BaseConstants.SHANAIFLG)
				&& arg.getAnswerer().equals(BaseConstants.SHAGAIFLG)) {
			// 社内（提出者和予定回答者都是社内用户时）
			arg.setCompanyFlg(BaseConstants.SHANAIFLG);
		} else {
			// 社外（提出者或予定回答者有社外用户时）
			arg.setCompanyFlg(BaseConstants.SHAGAIFLG);
		}

		// 有質問添付資料或回答添付資料的场合、添付資料ファイル名前を取得。
		String afileName = arg.getAattachedInfo();
		if (null != arg.getAUploadFile()) {
			// "A"
			arg.setAattachedInfo("A" + CommonUtils.newUploadFileName(arg.getQaNo(), afileName));
		}

		// 質問添付資料
		String qfileName = arg.getQattachedInfo();
		if (null != arg.getQUploadFile()) {
			// "Q" 区分提问者和回答者文件 ，否则同时上传时会导致根据时间生成的文件名相同而覆盖。
			arg.setQattachedInfo("Q" + CommonUtils.newUploadFileName(arg.getQaNo(), qfileName));
		}

		// 数据加锁处理
		Date updateTime = super.qaDao.getQANoLock(arg);
		arg.setUpdateTime(updateTime);

		// Q&A情報登陆
		int affectedRows = super.qaDao.saveQA(arg);
		if (affectedRows == 0) {
			throw new BusinessException(MessageConstants.QA0004);
		}

		// Q&A情報履歴登陆
		insertQAHistory(arg.getProjectId(), arg.getQaNo());

		// 上传文件
		// 質問添付資料
		if (null != arg.getAUploadFile()) {
			FileUtil.saveFile(arg.getAUploadFile(), arg.getAattachedInfo());
		}
		// 回答添付資料
		if (null != arg.getQUploadFile()) {
			FileUtil.saveFile(arg.getQUploadFile(), arg.getQattachedInfo());
		}

		logger.info("saveQA success");
	}

	/**
	 * Q&A情報履歴登陆
	 * 
	 * @param serialNum
	 *            连番
	 * @param projectId
	 *            项目ID
	 * @param qaNo
	 *            qa番号
	 */
	@Transaction
	public void insertQAHistory(String projectId, String qaNo) {
		// 连番
		String serialNum = super.qaHistoryDao.getHistorySerialNO(projectId, qaNo);
		int historyNo = Integer.valueOf(serialNum) + 1;
		serialNum = String.format("%05d", historyNo);
		super.qaHistoryDao.insertQAHistory(serialNum, projectId, qaNo);
		logger.info("insertQAHistory success");
	}

	/**
	 * 更改QA状态処理
	 * 
	 * @throws Exception
	 */
	@Override
	@Transaction
	public void changeQAState(QA0020ArgValue arg) throws Exception {
		Date updateTime = super.qaDao.getQANoLock(arg);
		arg.setUpdateTime(updateTime);
		// Q&A情報登陆
		int affectedRows = super.qaDao.changeQAState(arg);
		if (affectedRows == 0) {
			throw new BusinessException(MessageConstants.QA0004);
		}

		// Q&A情報履歴登陆
		insertQAHistory(arg.getProjectId(), arg.getQaNo());

		// QA承认关联QA番号存在的场合
		if (!StringUtils.isEmpty(arg.getRelationQaNo())) {
			arg.setQaNo(arg.getRelationQaNo());
			acceptRelationQA(arg);
		}

		logger.info("changeQAState success");

	}

	/**
	 * 承認関連Q&A情報
	 */
	@Transaction
	public void acceptRelationQA(QA0020ArgValue arg) throws Exception {

		Map<String, Object> result = super.qaDao.getRelationQANo(arg);

		// 关联QA番号
		String relationQANo = null;

		if (result != null) {
			// 更新时间
			arg.setUpdateTime((Date) result.get("UPDATETIME"));
			// 关联QA番号
			relationQANo = (String) result.get("RELATIONQANO");

			// Q&A情報登陆
			int affectedRows = super.qaDao.acceptRelationQA(arg);
			// 更新失败的场合
			if (affectedRows == 0) {
				throw new BusinessException(MessageConstants.QA0004);
			}

			// Q&A情報履歴登陆
			insertQAHistory(arg.getProjectId(), arg.getQaNo());

			// do again
			if (!StringUtils.isEmpty(relationQANo)) {
				arg.setQaNo(relationQANo);
				acceptRelationQA(arg);
			}
		}

		logger.info("acceptRelationQA success");

	}

	/**
	 * 回答完了処理
	 */
	@Override
	@Transaction
	public void answerQA(QA0020ArgValue arg) throws Exception {

		// 入力チェック。
		Checker.checkNull(arg.getAnswerInfo());
		Checker.checkMaxLength(arg.getAnswerInfo(), BaseConstants.INT_5000);
		Checker.checkNull(arg.getAnswerDate());

		// 有回答添付資料或回答添付資料的场合、添付資料ファイル名前を取得。
		String afileName = arg.getAattachedInfo();
		if (null != arg.getAUploadFile()) {
			arg.setAattachedInfo(CommonUtils.newUploadFileName(arg.getQaNo(), afileName));
		}

		// 質問添付資料
		String qfileName = arg.getQattachedInfo();
		if (null != arg.getQUploadFile()) {
			arg.setQattachedInfo(CommonUtils.newUploadFileName(arg.getQaNo(), qfileName));
		}

		// QA回答状态 回答済み
		arg.setQaAState(BaseConstants.QAASTATEANSWERED);

		Date updateTime = super.qaDao.getQANoLock(arg);
		arg.setUpdateTime(updateTime);

		// Q&A情報登陆
		int affectedRows = super.qaDao.changeQAState(arg);
		if (affectedRows == 0) {
			throw new BusinessException(MessageConstants.QA0004);
		}

		// Q&A情報履歴登陆
		insertQAHistory(arg.getProjectId(), arg.getQaNo());

		// 上传文件
		// 質問添付資料
		if (null != arg.getAUploadFile()) {
			FileUtil.saveFile(arg.getAUploadFile(), arg.getAattachedInfo());
		}
		// 回答添付資料
		if (null != arg.getQUploadFile()) {
			FileUtil.saveFile(arg.getQUploadFile(), arg.getQattachedInfo());
		}

		logger.info("answerQA success");

	}

	/**
	 * 登陆用户在QA所在项目中担当角色情报を取得します。
	 * 
	 * @param userId
	 *            用户ID
	 * @param projectId
	 *            项目ID
	 * 
	 * @return 登陆用户在QA所在项目中担当角色情报
	 */
	@Override
	public ProjectMemberMaster getUserWorkType(String userId, String projectId) {
		ProjectMemberMaster result = super.projectMemberDao.getWorkType(userId, projectId);

		logger.info("getUserWorkType " + userId + " workType : " + result.getWorkType());

		return super.projectMemberDao.getWorkType(userId, projectId);
	}

	/**
	 * システム名情報を取得します。
	 * 
	 * @param projectId
	 *            项目ID
	 * @return システム名情報
	 */
	private ProjectMaster getProjectById(String projectId) {
		return super.projectDao.getProjectById(projectId);
	}

	/**
	 * 摘出作業情報を取得します。
	 * 
	 * @return 摘出作業情報
	 */
	private List<GeneralMaster> getStage() {
		return super.generalDao.getKbn01();
	}

	/**
	 * 原因区分情報を取得します。
	 * 
	 * @return 原因区分情報
	 */
	private List<GeneralMaster> getCauseDiv() {
		return super.generalDao.getKbnRQ();
	}

	/**
	 * 質問区分情報の取得
	 */
	private List<GeneralMaster> getQuestionDiv() {
		return super.generalDao.getKbnQD();
	}

	/**
	 * 発生機能のリスト情報を取得します。
	 * 
	 * @param projectId
	 *            项目ID
	 * 
	 * @return 発生機能のリスト情報
	 */
	private List<GroupMaster> getGroupList(String projectId) {
		return super.groupDao.getGroupID(projectId);
	}

	/**
	 * 発生個所のリスト情報を取得します。
	 * 
	 * @param projectId
	 *            项目ID
	 * @param groupId
	 *            発生個所ＩＤ
	 * 
	 * @return 発生個所のリスト情報
	 */
	private List<ModuleMaster> getModuleList(String projectId, String groupId) {
		return super.moduleDao.getModule(projectId, groupId);
	}

	/**
	 * 提出者情報を取得します。
	 * 
	 * @param projectId
	 *            项目ID
	 * @return 提出者情報
	 */
	private List<UserMaster> getQuestionerList(String projectId) {
		return super.userDao.getQuestioner(projectId);
	}

	/**
	 * 予定回答者情報を取得します。
	 * 
	 * @param projectId
	 *            项目ID
	 * @param workType
	 *            登陆用户在QA所在项目中担当角色
	 * @param companyFlg
	 *            社内外区分
	 * 
	 * @return 予定回答者情報
	 */
	private List<UserMaster> getAnswerList(String projectId, String workType, String companyFlg) {
		return super.userDao.getAnswerer(projectId, workType, companyFlg);
	}

	private void inputCheck(QA0020ArgValue arg) throws BusinessException {

		// // システム名
		// checkNull(arg.getProjectId());
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
		// 提出者
		Checker.checkNull(arg.getQuestioner());
		// 予定回答者
		Checker.checkNull(arg.getAnswerer());
		// 希望回答日
		Checker.checkNull(arg.getExpDate());
		// 提出日>希望回答日
		Checker.compareDate(arg.getQuestionDate(), arg.getExpDate());
		// 回答内容
		Checker.checkMaxLength(arg.getAnswerInfo(), BaseConstants.INT_5000);
	}

}
