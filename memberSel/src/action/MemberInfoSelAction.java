/**
 * MemberInfoSelAction.java
 * 
 * 分類　　:memberSel-search action
 * 名称　　:查找员工信息的ACTION
 * 説明　　：负责从前台取得值，有时需做check后以dataBean的方式传给service,传结果给前台
 */
package action;

import org.apache.commons.lang.xwork.StringEscapeUtils;

import service.MemberInfoSelService;

import com.opensymphony.xwork2.ActionSupport;

import databean.MemberInfoSelDatabean;

/**
 * 查找 action
 * 
 * @see org.apache.commons.lang.xwork.StringEscapeUtils
 * @see service.MemberInfoSelService
 * @see com.opensymphony.xwork2.ActionSupport
 * @see databean.MemberInfoSelDatabean
 * @version 1.0
 */
public class MemberInfoSelAction extends ActionSupport {
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** 总的dataBean */
	private MemberInfoSelDatabean pageBean;

	/**
	 * 总的dataBean 的取得
	 * 
	 * @return 总的dataBean
	 */
	public MemberInfoSelDatabean getPageBean() {
		return pageBean;
	}

	/**
	 * 总的dataBean 的设定
	 * 
	 * @param pageBean
	 *            总的dataBean
	 */
	public void setPageBean(MemberInfoSelDatabean pageBean) {
		this.pageBean = pageBean;
	}

	/**
	 * 查找员工数据
	 * 
	 * @param modelList
	 *            一览信息的数据
	 * @return success
	 */
	public String doSelect() {
		System.out.println("start action.doSelect");
		// 保存查找到的员工数据 结果集
		pageBean.setModelList(new MemberInfoSelService().getData(pageBean
				.getSearchKey()));
		// 工号输入栏HTML转义
		pageBean.getSearchKey().setMemberCodeInput(
				StringEscapeUtils.escapeHtml(pageBean.getSearchKey()
						.getMemberCodeInput()));
		// 名称输入栏HTML转义
		pageBean.getSearchKey().setNameInput(
				StringEscapeUtils.escapeHtml(pageBean.getSearchKey()
						.getNameInput()));
		return "success";
	}

	/**
	 * 清除画面上的所有数据
	 * 
	 * @return success
	 */
	public String doViewClear() {
		System.out.println("start action.doViewClear");
		pageBean.getSearchKey().setDeptName("0");
		pageBean.getSearchKey().setMemberCodeInput("");
		pageBean.getSearchKey().setNameInput("");
		return "success";
	}
}
