/**
 * MemberInfoSelDatabean.java
 * 
 * 分類　　:memberSel-dataBean	dataBean
 * 名称　　:总的dataBean
 * 説明　　：包含所有的数据的dataBean
 */
package databean;

import java.util.ArrayList;
import java.util.List;

/**
 * 总的dataBean
 * 
 * @see java.util.ArrayList
 * @see java.util.List
 * @version 1.0
 */
public class MemberInfoSelDatabean {
	/** 员工数据的dataBean */
	private List<MemberInfoSelDetailDatabean> modelList = new ArrayList<MemberInfoSelDetailDatabean>();
	/** 查找条件的dataBean */
	private MemberInfoSelSelectKeyDatabean searchKey = new MemberInfoSelSelectKeyDatabean();

	/**
	 * 员工数据 的取得
	 * 
	 * @return 员工数据
	 */
	public List<MemberInfoSelDetailDatabean> getModelList() {
		return modelList;
	}

	/**
	 * 员工数据 的设定
	 * 
	 * @param modelList
	 *            员工数据
	 */
	public void setModelList(List<MemberInfoSelDetailDatabean> modelList) {
		this.modelList = modelList;
	}

	/**
	 * 查找条件 的取得
	 * 
	 * @return 查找条件
	 */
	public MemberInfoSelSelectKeyDatabean getSearchKey() {
		return searchKey;
	}

	/**
	 * 查找条件 的设定
	 * 
	 * @param searchKey
	 *            查找条件
	 */
	public void setSearchKey(MemberInfoSelSelectKeyDatabean searchKey) {
		this.searchKey = searchKey;
	}

}
