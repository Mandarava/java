/**
 * MemberInfoSelAction.java
 * 
 * 分類　　:classNine-search action
 * 名称　　:select worker information
 * 説明　　：负责从前台取得值，有时需做check后以dataBean的方式传给service,传结果给前台
 * 備考　　：This is a demo
 * 作成　　：[日付] 2015/08/17 [氏名] S1507112
 * 履歴：
 * [NO]	[日付]		[Ver]	[更新者]		[内容]
 *	1	2015/08/17	V10L1	S1507112	 初版。　 
 */
package action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import databean.MemberInfoSelDetailDatabean;
import databean.MemberInfoSelDatabean;
import service.MemberInfoSelService;

/**
 * doSearch action
 * 
 * @see java.util.List
 * @see service.MemberInfoSelService
 * @see com.opensymphony.xwork2.ActionSupport
 * @see org.apache.struts2.ServletActionContext
 * @see databean.MemberInfoSelDatabean
 * @see databean.MemberInfoSelDetailDatabean
 * @author S1507112
 * @version 1.0
 */

public class MemberInfoSelAction extends ActionSupport {

	/**
	 * 查找一览数据
	 * 
	 * @return selectKey 总的dataBean
	 */
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
	 * 查找一览数据
	 * 
	 * @param modelList
	 *            一览信息的数据
	 * @return success
	 */
	public String doSelect() {
		System.out.println("start action.doSelect");
		/** 保存查找到的一览数据 结果集 */
		List<MemberInfoSelDetailDatabean> modelList = new MemberInfoSelService().searchDataService(pageBean);
		// pageBean.setModelList(new SearchService()
		// .searchDataService(pageBean));
		ServletActionContext.getRequest().setAttribute("modelList", modelList);
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
		pageBean.getSearchKey().setMembercodeInput("");
		pageBean.getSearchKey().setNameInput("");
		ServletActionContext.getRequest().setAttribute("errorMsg", "");
		ServletActionContext.getRequest().setAttribute("modelList", "");
		return "success";
	}
}
