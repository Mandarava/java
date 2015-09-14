/**
 * SearchViewDatabean.java
 * 
 * 分類　　:class17-databean	
 * 名称　　:
 * 説明　　：
 * 備考　　：
 * 作成　　：[日付] 2015/09/07 [氏名] S1507112
 * 履歴：
 * [NO]	[日付]		[Ver]	[更新者]		[内容]
 *	1	2015/09/07	V10L1	S1507112	 初版。　 
 */
package databean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author peixun
 * 
 */
public class SearchViewDatabean {
	/** 检索结果的dataBean */
	private List<SearchViewDeptInfoDatabean> memDeptInfoList = new ArrayList<SearchViewDeptInfoDatabean>();
	/** 检索条件的databean */
	private SearchViewKeyDatabean searchKey = new SearchViewKeyDatabean();

	/**
	 * memDeptInfoList 的取得
	 * 
	 * @return the memDeptInfoList
	 */
	public List<SearchViewDeptInfoDatabean> getMemDeptInfoList() {
		return memDeptInfoList;
	}

	/**
	 * memDeptInfoList 的设定
	 * 
	 * @param memDeptInfoList
	 *            the memDeptInfoList to set
	 */
	public void setMemDeptInfoList(
			List<SearchViewDeptInfoDatabean> memDeptInfoList) {
		this.memDeptInfoList = memDeptInfoList;
	}

	/**
	 * searchKey 的取得
	 * 
	 * @return the searchKey
	 */
	public SearchViewKeyDatabean getSearchKey() {
		return searchKey;
	}

	/**
	 * searchKey 的设定
	 * 
	 * @param searchKey
	 *            the searchKey to set
	 */
	public void setSearchKey(SearchViewKeyDatabean searchKey) {
		this.searchKey = searchKey;
	}

}
