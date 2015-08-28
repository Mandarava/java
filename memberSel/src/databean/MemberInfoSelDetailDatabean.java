/**
 * MemberInfoSelDetailDatabean.java
 * 
 * 分類　　:memberSel-dataBean dataBean
 * 名称　　:员工数据的dataBean
 * 説明　　：员工详细信息的dataBean 
 */
package databean;

/**
 * 员工信息的dataBean
 * 
 * @version 1.0
 */
public class MemberInfoSelDetailDatabean {
	/** 工号 */
	private String memberCode;
	/** 姓名 */
	private String name;
	/** 职务 */
	private String jobLevel;
	/** 年收入 */
	private String annualIncome;
	/** 所属部门code */
	private String deptCode;
	/** 所属部门名称 */
	private String deptNm;

	/**
	 * 工号 的取得
	 * 
	 * @return 工号
	 */
	public String getMemberCode() {
		return memberCode;
	}

	/**
	 * 工号 的设定
	 * 
	 * @param memberCode
	 *            工号
	 */
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	/**
	 * 姓名 的取得
	 * 
	 * @return 姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 姓名 的设定
	 * 
	 * @param name
	 *            姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 职务 的取得
	 * 
	 * @return 职务
	 */
	public String getJobLevel() {
		return jobLevel;
	}

	/**
	 * 职务 的设定
	 * 
	 * @param jobLevel
	 *            职务
	 */
	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}

	/**
	 * 所属部门code 的取得
	 * 
	 * @return 所属部门code
	 */
	public String getDeptCode() {
		return deptCode;
	}

	/**
	 * 年收入 的取得
	 * 
	 * @return 年收入
	 */
	public String getAnnualIncome() {
		return annualIncome;
	}

	/**
	 * 年收入 的设定
	 * 
	 * @param annualIncome
	 *            年收入
	 */
	public void setAnnualIncome(String annualIncome) {
		this.annualIncome = annualIncome;
	}

	/**
	 * 所属部门code 的设定
	 * 
	 * @param deptCode
	 *            所属部门code
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	/**
	 * 所属部门名称 的取得
	 * 
	 * @return the 所属部门名称
	 */
	public String getDeptNm() {
		return deptNm;
	}

	/**
	 * 所属部门名称 的设定
	 * 
	 * @param deptNm
	 *            所属部门名称
	 */
	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}

}
