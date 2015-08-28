/**
 * MemberInfoSelAction.java
 * 
 * 分類　　:memberSel-search action
 * 名称　　:查找员工信息的ACTION
 * 説明　　：负责从前台取得值，有时需做check后以dataBean的方式传给service,传结果给前台
 * 備考　　：
 * 作成　　：[日付] 2015/08/17 [氏名] S1507112
 * 履歴：
 * [NO]	[日付]		[Ver]		[更新者]		[内容]
 *	1	2015/08/17	V10L1		S1507112	 初版。　
 *	2	2015/08/20	V10L1.01 	S1507112	修改前台数据显示方式
 *	3	2015/08/28	V10L1.02	S1507112	HTML转义
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
 * @author S1507112
 * @version 1.02
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
