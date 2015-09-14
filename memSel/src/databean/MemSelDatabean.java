
package databean;

import java.util.ArrayList;
import java.util.List;

/**
 * 总的databean
 * 
 * @see java.util.ArrayList
 * @see java.util.List
 * @version 1.0
 * 
 */
public class MemSelDatabean {
	/** 检索结果的dataBean */
	private List<MemSelDeptInfoDatabean> memDeptInfoList = new ArrayList<MemSelDeptInfoDatabean>();
	/** 检索条件的databean */
	private MemSelKeyDatabean memSelKey = new MemSelKeyDatabean();

	/**
	 * 检索结果 的取得
	 * 
	 * @return 检索结果
	 */
	public List<MemSelDeptInfoDatabean> getMemDeptInfoList() {
		return memDeptInfoList;
	}

	/**
	 * 检索结果 的设定
	 * 
	 * @param memDeptInfoList
	 *            检索结果
	 */
	public void setMemDeptInfoList(List<MemSelDeptInfoDatabean> memDeptInfoList) {
		this.memDeptInfoList = memDeptInfoList;
	}

	/**
	 * 检索条件 的取得
	 * 
	 * @return 检索条件
	 */
	public MemSelKeyDatabean getMemSelKey() {
		return memSelKey;
	}

	/**
	 * 检索条件 的设定
	 * 
	 * @param memSelKey
	 *            检索条件
	 */
	public void setMemSelKey(MemSelKeyDatabean memSelKey) {
		this.memSelKey = memSelKey;
	}

}
