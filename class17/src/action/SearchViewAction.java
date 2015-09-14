package action;

import org.apache.commons.lang.xwork.StringEscapeUtils;

import service.searchViewService;

import common.ConfigUtils;

import databean.SearchViewDatabean;


public class SearchViewAction {
	/** 总的databean */
	private SearchViewDatabean deptInfo = new SearchViewDatabean();

	/**
	 * 总的dataBean 的取得
	 * 
	 * @return 总的dataBean
	 */
	public SearchViewDatabean getDeptInfo() {
		return deptInfo;
	}

	/**
	 * 总的dataBean 的设定
	 * 
	 * @param deptInfo
	 *            总的dataBean
	 */
	public void setDeptInfo(SearchViewDatabean deptInfo) {
		this.deptInfo = deptInfo;
	}

	public String doSelect() {
		deptInfo.setMemDeptInfoList(new searchViewService().getData(deptInfo
				.getSearchKey()));
		// 部门号输入栏HTML转义
		deptInfo.getSearchKey().setDeptCodeInput(
				StringEscapeUtils.escapeHtml(deptInfo.getSearchKey()
						.getDeptCodeInput()));
		// 部门名输入栏HTML转义
		deptInfo.getSearchKey().setDeptNameInput(
				StringEscapeUtils.escapeHtml(deptInfo.getSearchKey()
						.getDeptNameInput()));
		// 姓名输入栏HTML转义
		deptInfo.getSearchKey().setNameInput(
				StringEscapeUtils.escapeHtml(deptInfo.getSearchKey()
						.getNameInput()));
		return "success";
	}

	public String deleteInfo() {
		if (deptInfo.getSearchKey().getCheckIndex().equals("")) {
			String errorMsg = ConfigUtils.getInstance().getValue("E001");
			deptInfo.getSearchKey().setErrorMsg(errorMsg);
		} else {
			new searchViewService().deleteData(deptInfo.getSearchKey());
		}
		return "success";
	}

}