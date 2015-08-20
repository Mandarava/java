/**
 * MemberInfoSelSelectKeyDatabean.java
 * 
 * 分類　　:memberSel-dataBean dataBean
 * 名称　　:查找条件的dataBean
 * 説明　　：包含查找条件的dataBean
 * 備考　　：
 * 作成　　：[日付] 2015/08/17 [氏名] S1507112
 * 履歴：
 * [NO]	[日付]		[Ver]	[更新者]		[内容]
 *	1	2015/08/17	V10L1	S1507112	 初版。　 
 */
package databean;

/**
 * select key dataBean
 * 
 * @author S1507112
 * @version 1.0
 */
public class MemberInfoSelSelectKeyDatabean {
	/** 输入的工号检索条件 */
	private String membercodeInput;
	/** 输入的姓名检索条件 */
	private String nameInput;
	/** 选中的radio的value */
	private String deptName;

	/**
	 * 输入的工号检索条件 的取得
	 * 
	 * @return 输入的工号检索条件
	 */
	public String getMembercodeInput() {
		return membercodeInput;
	}

	/**
	 * 输入的工号检索条件 的设定
	 * 
	 * @param membercodeInput
	 *            输入的工号检索条件
	 */
	public void setMembercodeInput(String membercodeInput) {
		this.membercodeInput = membercodeInput;
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
