
package databean;

/**
 * 检索结果databean
 * 
 * @version 1.0
 * 
 */
public class MemSelDeptInfoDatabean {
	/** 部门号 */
	private String deptCode;
	/** 部门全名 */
	private String deptFullName;
	/** 部门简称 */
	private String deptName;
	/** 职务 */
	private String jobLevel;
	/** 姓 */
	private String firstName;
	/** 名 */
	private String lastName;
	/** 合计 */
	private String personCount;

	/**
	 * 部门号 的取得
	 * 
	 * @return 部门号
	 */
	public String getDeptCode() {
		return deptCode;
	}

	/**
	 * 部门号 的设定
	 * 
	 * @param deptCode
	 *            部门号
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	/**
	 * 部门全名 的取得
	 * 
	 * @return 部门全名
	 */
	public String getDeptFullName() {
		return deptFullName;
	}

	/**
	 * 部门全名 的设定
	 * 
	 * @param deptFullName
	 *            部门全名
	 */
	public void setDeptFullName(String deptFullName) {
		this.deptFullName = deptFullName;
	}

	/**
	 * 部门简称 的取得
	 * 
	 * @return 部门简称
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * 部门简称 的设定
	 * 
	 * @param deptName
	 *            部门简称
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
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
	 * 姓 的取得
	 * 
	 * @return 姓
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 姓 的设定
	 * 
	 * @param firstName
	 *            姓
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 名 的取得
	 * 
	 * @return 名
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 名 的设定
	 * 
	 * @param lastName
	 *            名
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 合计 的取得
	 * 
	 * @return 合计
	 */
	public String getPersonCount() {
		return personCount;
	}

	/**
	 * 合计 的设定
	 * 
	 * @param personCount
	 *            合计
	 */
	public void setPersonCount(String personCount) {
		this.personCount = personCount;
	}

}
