
package databean;

/**
 * 检索条件databean
 * 
 * @version 1.0
 * 
 */
public class MemSelKeyDatabean {
	/** 输入的部门号 */
	private String deptCodeInput;
	/** 输入的部门名字 */
	private String deptNameInput;
	/** 输入的姓名 */
	private String nameInput;
	/** 选中的radio */
	private String searchCondition;
	/** 表最后一列名字 */
	private String tableHead;

	/**
	 * 输入的部门号 的取得
	 * 
	 * @return 输入的部门号
	 */
	public String getDeptCodeInput() {
		return deptCodeInput;
	}

	/**
	 * 输入的部门号 的设定
	 * 
	 * @param deptCodeInput
	 *            输入的部门号
	 */
	public void setDeptCodeInput(String deptCodeInput) {
		this.deptCodeInput = deptCodeInput;
	}

	/**
	 * 输入的部门名字 的取得
	 * 
	 * @return 输入的部门名字
	 */
	public String getDeptNameInput() {
		return deptNameInput;
	}

	/**
	 * 输入的部门名字 的设定
	 * 
	 * @param deptNameInput
	 *            输入的部门名字
	 */
	public void setDeptNameInput(String deptNameInput) {
		this.deptNameInput = deptNameInput;
	}

	/**
	 * 姓名 的取得
	 * 
	 * @return 姓名
	 */
	public String getNameInput() {
		return nameInput;
	}

	/**
	 * 姓名 的设定
	 * 
	 * @param nameInput
	 *            姓名
	 */
	public void setNameInput(String nameInput) {
		this.nameInput = nameInput;
	}

	/**
	 * 选中的radio 的取得
	 * 
	 * @return 选中的radio
	 */
	public String getSearchCondition() {
		return searchCondition;
	}

	/**
	 * 选中的radio 的设定
	 * 
	 * @param searchCondition
	 *            选中的radio
	 */
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	/**
	 * 表最后一列名字 的取得
	 * 
	 * @return 表最后一列名字
	 */
	public String getTableHead() {
		return tableHead;
	}

	/**
	 * 表最后一列名字 的设定
	 * 
	 * @param tableHead
	 *            表最后一列名字
	 */
	public void setTableHead(String tableHead) {
		this.tableHead = tableHead;
	}

}
