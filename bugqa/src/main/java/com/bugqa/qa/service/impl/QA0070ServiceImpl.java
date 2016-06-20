package com.bugqa.qa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bugqa.qa.model.dto.ExcelProjectDTO;
import com.bugqa.qa.model.dto.ExcelQADTO;
import com.bugqa.qa.model.dto.QA0070ArgValue;
import com.bugqa.qa.model.dto.QA0070RetValue;
import com.bugqa.qa.model.po.ModuleMaster;
import com.bugqa.qa.model.po.UserMaster;
import com.bugqa.qa.service.BaseService;
import com.bugqa.qa.service.QA0070Service;
import com.bugqa.qa.utils.CommonUtils;

/**
 * QA0070 Excelファイル導出 Service
 * 
 * @author zt c.
 *
 */
@Service
public class QA0070ServiceImpl extends BaseService implements QA0070Service {

	private static Logger logger = LoggerFactory.getLogger(QA0070ServiceImpl.class);

	/**
	 * QAデータの取得
	 */
	@Override
	public QA0070RetValue getExportData(QA0070ArgValue arg) {

		String projectId = arg.getProjectId();

		QA0070RetValue ret = new QA0070RetValue();
		// QA信息
		ret.setExcelQAList(this.getQAInfo(arg));
		// モジュール
		ret.setModuleList(this.getModInfo(projectId));
		// プロジェクトデータ
		ret.setProject(this.getProInfo(projectId));
		// メンバー
		ret.setUserList(this.getMemberInfo(projectId));

		return ret;
	}

	/**
	 * 获得QA信息
	 * 
	 * @param pageDiff
	 *            页面区分
	 * @return
	 */
	private List<ExcelQADTO> getQAInfo(QA0070ArgValue arg) {

		// QA信息
		List<ExcelQADTO> result = new ArrayList<>();

		String pageDiff = arg.getPageDiff();

		// 判断导出的是哪个页面的
		if (pageDiff.equals("QA0060")) {
			// QA0060
			result = super.qaDao.excelExportQA0060(arg.getQa0060Arg());
		} else if (pageDiff.equals("QA0050")) {
			// QA0050
			result = super.qaDao.excelExportQA0050(arg.getQa0050Arg());
		}

		// 去null
		CommonUtils.convertNullToEmptyString(result);

		logger.info("getQAInfo result size ： " + result.size());

		return result;
	}

	/**
	 * プロジェクトデータの取得
	 * 
	 * @param projectId
	 *            项目ID
	 * @return プロジェクトデータ
	 */
	private ExcelProjectDTO getProInfo(String projectId) {
		// プロジェクトデータ
		ExcelProjectDTO result = super.projectDao.getProInfo(projectId);

		return result;
	}

	/**
	 * モジュールの取得
	 * 
	 * @param projectId
	 *            项目ID
	 * @return モジュール
	 */
	private List<ModuleMaster> getModInfo(String projectId) {
		// モジュール
		List<ModuleMaster> result = super.moduleDao.getModInfo(projectId);

		return result;
	}

	/**
	 * メンバーの取得
	 * 
	 * @param projectId
	 *            项目ID
	 * @return メンバー
	 */
	private List<UserMaster> getMemberInfo(String projectId) {
		// メンバー
		List<UserMaster> result = super.userDao.getMemberInfo(projectId);

		return result;
	}

}
