package databean;


public class SearchViewKeyDatabean {
	/** 输入的部门号 */
	private String deptCodeInput;
	/** 输入的部门名字 */
	private String deptNameInput;
	/** 输入的姓名 */
	private String nameInput;
	/** 报错信息 */
	private String errorMsg;
	/** 隐藏label 保存选中的checkbox的索引 以逗号分隔 */
	private String checkIndex;

	/**
	 * 选中的checkbox 的取得
	 * 
	 * @return 选中的checkbox
	 */
	public String getCheckIndex() {
		return checkIndex;
	}

	/**
	 * 选中的checkbox 的设定
	 * 
	 * @param checkIndex
	 *            选中的checkbox
	 */
	public void setCheckIndex(String checkIndex) {
		this.checkIndex = checkIndex;
	}

	/**
	 * 报错信息 的取得
	 * 
	 * @return 报错信息
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * 报错信息 的设定
	 * 
	 * @param 报错信息
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

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
}
