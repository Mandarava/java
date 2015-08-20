/**
 * MemberInfoSelDetailDatabean.java
 * 
 * 分類　　:memberSel-dataBean dataBean
 * 名称　　:员工数据的dataBean
 * 説明　　：员工详细信息的dataBean
 * 備考　　：
 * 作成　　：[日付] 2015/08/17 [氏名] S1507112
 * 履歴：
 * [NO]	[日付]		[Ver]	[更新者]		[内容]
 *	1	2015/08/17	V10L1	S1507112	 初版。　 
 */
package databean;

/**
 * searchDataDatabean
 * 
 * @author S1507112
 * @version 1.0
 */
public class MemberInfoSelDetailDatabean {
	/** 工号 */
	private String membercode;
	/** 姓名 */
	private String Name;
	/** 职务 */
	private String job_level;
	/** 年收入 */
	private String annual_income;
	/** 所属部门code */
	private String deptcode;
	/** 所属部门名称 */
	private String deptnm;

	/**
	 * 工号 的取得
	 * 
	 * @return 工号
	 */
	public String getMembercode() {
		return membercode;
	}

	/**
	 * 工号 的设定
	 * 
	 * @param membercode
	 *            工号
	 */
	public void setMembercode(String membercode) {
		this.membercode = membercode;
	}

	/**
	 * 姓名 的取得
	 * 
	 * @return 姓名
	 */
	public String getName() {
		return Name;
	}

	/**
	 * 姓名 的设定
	 * 
	 * @param name
	 *            姓名
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * 职务 的取得
	 * 
	 * @return 职务
	 */
	public String getJob_level() {
		return job_level;
	}

	/**
	 * 职务 的设定
	 * 
	 * @param job_level
	 *            职务
	 */
	public void setJob_level(String job_level) {
		this.job_level = job_level;
	}

	/**
	 * 年收入 的取得
	 * 
	 * @return 年收入
	 */
	public String getAnnual_income() {
		return annual_income;
	}

	/**
	 * 年收入 的设定
	 * 
	 * @param annual_income
	 *            年收入
	 */
	public void setAnnual_income(String annual_income) {
		this.annual_income = annual_income;
	}

	/**
	 * 所属部门code 的取得
	 * 
	 * @return 所属部门code
	 */
	public String getDeptcode() {
		return deptcode;
	}

	/**
	 * 所属部门code 的设定
	 * 
	 * @param deptcode
	 *            所属部门code
	 */
	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}

	/**
	 * 所属部门名称 的取得
	 * 
	 * @return the 所属部门名称
	 */
	public String getDeptnm() {
		return deptnm;
	}

	/**
	 * 所属部门名称 的设定
	 * 
	 * @param deptnm
	 *            所属部门名称
	 */
	public void setDeptnm(String deptnm) {
		this.deptnm = deptnm;
	}

}
