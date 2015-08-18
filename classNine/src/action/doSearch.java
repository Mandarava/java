/**
 * doSearch.java
 * 
 * 分類　　:classNine-search action
 * 名称　　:select worker information
 * 説明　　：Search page content action
 * 備考　　：This is a demo
 * 作成　　：[日付] 2015/08/17 [氏名] S1507112
 * 履歴：
 * [NO]  [日付]　  	[Ver]　   	 [更新者]　  		[内容]
 *　1   2015/08/17  	V10L1 	 S1507112		   初版。　 
 */
package action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import service.searchService;

import com.opensymphony.xwork2.ActionSupport;

import databean.searchDatabean;

/**
 * doSearch action
 * 
 * @author S1507112
 * 
 */
public class doSearch extends ActionSupport {

	/**
	 * do search
	 * 
	 * @return
	 */
	private static final long serialVersionUID = 1L;

	private searchDatabean selectKey;

	public searchDatabean getSelectKey() {
		return selectKey;
	}

	public void setSelectKey(searchDatabean selectKey) {
		this.selectKey = selectKey;
	}

	/**
	 * select the detail
	 * 
	 * @return
	 */
	public String doSelect() {
		System.out.println("start action.doSelect");
		List<searchDatabean> modelList = new ArrayList<searchDatabean>();
		modelList = new searchService().searchDataService(selectKey);
		ServletActionContext.getRequest().setAttribute("modelList", modelList);
		selectKey.setNameInput(selectKey.getNameInput());
		return "success";
	}

	/**
	 * clean the view
	 * 
	 * @return
	 */
	public String doViewClear() {
		System.out.println("start action.doViewClear");
		selectKey.setNameInput("");
		selectKey.setMembercodeInput("");
		selectKey.setDeptName("0");
		ServletActionContext.getRequest().setAttribute("errorMsg", "");
		ServletActionContext.getRequest().setAttribute("modelList", "");
		return "success";
	}
}
