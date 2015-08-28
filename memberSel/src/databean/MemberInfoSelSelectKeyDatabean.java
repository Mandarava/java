/**
 * MemberInfoSelSelectKeyDatabean.java
 * 
 * 分類　　:memberSel-dataBean 检索条件dataBean
 * 名称　　:查找条件的dataBean
 * 説明　　：包含查找条件的dataBean 
 */
package databean;

/**
 * 检索条件dataBean
 * 
 * @version 1.0
 */
public class MemberInfoSelSelectKeyDatabean {
	/** 输入的工号检索条件 */
	private String memberCodeInput;
	/** 输入的姓名检索条件 */
	private String nameInput;
	/** 选中的radio的value */
	private String deptName;
	/** 报错信息 */
	private String msg;

	/**
	 * 报错信息 的取得
	 * 
	 * @return 报错信息
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 报错信息 的设定
	 * 
	 * @param 报错信息
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 输入的工号检索条件 的取得
	 * 
	 * @return 输入的工号检索条件
	 */
	public String getMemberCodeInput() {
		return memberCodeInput;
	}

	/**
	 * 输入的工号检索条件 的设定
	 * 
	 * @param memberCodeInput
	 *            输入的工号检索条件
	 */
	public void setMemberCodeInput(String memberCodeInput) {
		this.memberCodeInput = memberCodeInput;
	}

	/**
	 * 输入的姓名检索条件 的取得
	 * 
	 * @return 输入的工号检索条件
	 */
	public String getNameInput() {
		return nameInput;
	}

	/**
	 * 输入的姓名检索条件 的设定
	 * 
	 * @param nameInput
	 *            输入的姓名检索条件
	 */
	public void setNameInput(String nameInput) {
		this.nameInput = nameInput;
	}

	/**
	 * 选中的radio的value 的取得
	 * 
	 * @return 选中的radio的value
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * 选中的radio的value 的设定
	 * 
	 * @param deptName
	 *            选中的radio的value
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
