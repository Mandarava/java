/**
 * SearchDatabean.java
 * 
 * 分類　　:classNine-dataBean	dataBean
 * 名称　　:总的dataBean
 * 説明　　：dataBean
 * 備考　　：This is a demo
 * 作成　　：[日付] 2015/08/17 [氏名] S1507112
 * 履歴：
 * [NO]	[日付]		[Ver]		[更新者]		[内容]
 *	1	2015/08/17	V10L1		S1507112	 初版。　
 *	2	2015/08/19	V10L1.01	S1507112	change to list
 */
package databean;

import java.util.ArrayList;
import java.util.List;

/**
 * searchDatabean include all the dataBean
 * 
 * @see java.util.ArrayList
 * @see java.util.List
 * @author S1507112
 * @version 1.0
 */
public class SearchDatabean {
	/** 一览数据的dataBean */
	private List<SearchDataDatabean> modelList = new ArrayList<SearchDataDatabean>();
	/** 查找条件的dataBean */
	private SearchSelectKeyDatabean searchKey = new SearchSelectKeyDatabean();

	/**
	 * 一览数据 的取得
	 * 
	 * @return 一览数据
	 */
	public List<SearchDataDatabean> getModelList() {
		return modelList;
	}

	/**
	 * 一览数据 的设定
	 * 
	 * @param modelList
	 *            一览数据
	 */
	public void setModelList(List<SearchDataDatabean> modelList) {
		this.modelList = modelList;
	}

	/**
	 * 查找条件 的取得
	 * 
	 * @return 查找条件
	 */
	public SearchSelectKeyDatabean getSearchKey() {
		return searchKey;
	}

	/**
	 * 查找条件 的设定
	 * 
	 * @param searchKey
	 *            查找条件
	 */
	public void setSearchKey(SearchSelectKeyDatabean searchKey) {
		this.searchKey = searchKey;
	}

}
