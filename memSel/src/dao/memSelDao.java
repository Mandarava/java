
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.ConfigUtils;
import common.EscapeInput;

import databean.MemSelDeptInfoDatabean;
import databean.MemSelKeyDatabean;

/**
 * 数据库查找数据
 * 
 * @see java.sql.Connection
 * @see java.sql.PreparedStatement
 * @see java.sql.ResultSet
 * @see java.sql.SQLException
 * @see java.util.ArrayList
 * @see java.util.List
 * @see common.ConfigUtils
 * @see common.EscapeInput
 * @see databean.MemSelDeptInfoDatabean
 * @see databean.MemSelKeyDatabean
 * @version 1.0
 */
public class memSelDao {
	/** 创建PreparedStatement */
	private PreparedStatement pstmt = null;
	/** 查找到的数据的结果集 */
	private List<MemSelDeptInfoDatabean> searchResultList = new ArrayList<MemSelDeptInfoDatabean>();
	/** 字符串转义 */
	private EscapeInput escapeInput = new EscapeInput();
	/** 转义字符 */
	private String escape = ConfigUtils.getInstance().getValue("escape");
	/** 最大值或者最小值 */
	private static boolean isMax = true;

	/**
	 * 普通检索
	 * 
	 * @param con
	 *            数据库连接
	 * @param searchDatabean
	 *            查找条件dataBean
	 * @return 检索结果
	 * @throws SQLException
	 */
	public List<MemSelDeptInfoDatabean> commonSearch(Connection con,
			MemSelKeyDatabean searchDatabean) throws SQLException {
		// 转义后的部门号
		String escapedDeptCode = escapeInput.sqlEscape(searchDatabean
				.getDeptCodeInput().trim());
		// 转义后的部门名
		String escapedDeptName = escapeInput.sqlEscape(searchDatabean
				.getDeptNameInput().trim());
		// 转义后的姓名
		String escapedName = escapeInput.sqlEscape(searchDatabean
				.getNameInput().trim());
		String strSQL = "";
		strSQL = "SELECT MDM.DEPTCODE ";
		strSQL = strSQL + "      ,MD.DEPTNAME";
		strSQL = strSQL + "      ,MD.DEPTNM";
		strSQL = strSQL + "      ,MDM.JOB_LEVEL";
		strSQL = strSQL + "      ,MDM.MEMBERFIRSTNAME";
		strSQL = strSQL + "      ,MDM.MEMBERLASTNAME";
		strSQL = strSQL + "      ,MDM.ANNUAL_INCOME";
		strSQL = strSQL + "  FROM M_DEPT MD";
		strSQL = strSQL + "      ,M_DEPT_MEMBER MDM ";
		strSQL = strSQL + " WHERE MD.DEPTCODE(+) = MDM.DEPTCODE";
		strSQL = strSQL + "   AND MDM.DEPTCODE LIKE ? ESCAPE '" + escape + "'";
		strSQL = strSQL + "   AND (NVL(MD.DEPTNAME, ' ') LIKE ? ESCAPE '"
				+ escape + "'";
		strSQL = strSQL + "	   OR NVL(MD.DEPTNM, ' ') LIKE ? ESCAPE '" + escape
				+ "')";
		strSQL = strSQL
				+ "AND MDM.MEMBERFIRSTNAME || MDM.MEMBERLASTNAME LIKE ? ESCAPE '"
				+ escape + "'";
		strSQL = strSQL + "   AND MDM.DELETEFLG = 0";
		strSQL = strSQL + "   AND MDM.DELETEFLG = MD.DELETEFLG(+)";
		strSQL = strSQL + " ORDER BY MDM.DEPTCODE";
		strSQL = strSQL + "         ,MDM.JOB_LEVEL";
		strSQL = strSQL + "         ,MDM.MEMBERFIRSTNAME";
		strSQL = strSQL + "         ,MDM.MEMBERLASTNAME";
		strSQL = strSQL + "         ,MDM.ANNUAL_INCOME";
		pstmt = con.prepareStatement(strSQL);
		pstmt.setString(1, escapedDeptCode + "%");
		pstmt.setString(2, "%" + escapedDeptName + "%");
		pstmt.setString(3, "%" + escapedDeptName + "%");
		pstmt.setString(4, "%" + escapedName + "%");
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) {
			MemSelDeptInfoDatabean db = new MemSelDeptInfoDatabean();
			// 设置部门号
			db.setDeptCode(rst.getString("DEPTCODE"));
			// 设置部门全名
			db.setDeptFullName(rst.getString("DEPTNAME"));
			// 设置部门简称
			db.setDeptName(rst.getString("DEPTNM"));
			// 设置姓
			db.setFirstName(rst.getString("MEMBERFIRSTNAME"));
			// 设置名
			db.setLastName(rst.getString("MEMBERLASTNAME"));
			// 设置职务
			db.setJobLevel(rst.getString("JOB_LEVEL"));
			// 设置金额
			db.setPersonCount(rst.getString("ANNUAL_INCOME"));
			searchResultList.add(db);
		}
		return searchResultList;
	}

	/**
	 * 部门别人数
	 * 
	 * @param con
	 *            数据库连接
	 * @param searchDatabean
	 *            查找条件dataBean
	 * @return 查找结果
	 * @throws SQLException
	 */
	public List<MemSelDeptInfoDatabean> personCountSearch(Connection con,
			MemSelKeyDatabean searchDatabean) throws SQLException {
		// 转义后的部门号
		String escapedDeptCode = escapeInput.sqlEscape(searchDatabean
				.getDeptCodeInput().trim());
		// 转义后的部门名
		String escapedDeptName = escapeInput.sqlEscape(searchDatabean
				.getDeptNameInput().trim());
		// 转义后的姓名
		String escapedName = escapeInput.sqlEscape(searchDatabean
				.getNameInput().trim());
		String strSQL = "";
		strSQL = "SELECT MDM.DEPTCODE ";
		strSQL = strSQL + "      ,MD.DEPTNAME AS DEPTNAME ";
		strSQL = strSQL + "      ,MD.DEPTNM AS DEPTNM ";
		strSQL = strSQL + "      ,COUNT(MDM.DEPTCODE) AS PERSONCOUNT";
		strSQL = strSQL + "  FROM M_DEPT MD";
		strSQL = strSQL + "      ,M_DEPT_MEMBER MDM ";
		strSQL = strSQL + " WHERE MD.DEPTCODE(+) = MDM.DEPTCODE";
		strSQL = strSQL + "   AND MDM.DELETEFLG = 0";
		strSQL = strSQL + "   AND MDM.DELETEFLG = MD.DELETEFLG(+)";
		strSQL = strSQL + "   AND MDM.DEPTCODE LIKE ? ESCAPE '" + escape + "'";
		strSQL = strSQL + "   AND (NVL(MD.DEPTNAME, ' ') LIKE ? ESCAPE '"
				+ escape + "'";
		strSQL = strSQL + "	   OR NVL(MD.DEPTNM, ' ') LIKE ? ESCAPE '" + escape
				+ "')";
		strSQL = strSQL
				+ "AND MDM.MEMBERFIRSTNAME || MDM.MEMBERLASTNAME LIKE ? ESCAPE '"
				+ escape + "'";
		strSQL = strSQL + " GROUP BY MDM.DEPTCODE";
		strSQL = strSQL + "         ,MD.DEPTNAME";
		strSQL = strSQL + "         ,MD.DEPTNM";
		strSQL = strSQL + " ORDER BY MDM.DEPTCODE";
		pstmt = con.prepareStatement(strSQL);
		pstmt = con.prepareStatement(strSQL);
		pstmt.setString(1, escapedDeptCode + "%");
		pstmt.setString(2, "%" + escapedDeptName + "%");
		pstmt.setString(3, "%" + escapedDeptName + "%");
		pstmt.setString(4, "%" + escapedName + "%");
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) {
			MemSelDeptInfoDatabean db = new MemSelDeptInfoDatabean();
			// 设置部门号
			db.setDeptCode(rst.getString("DEPTCODE"));
			// 设置部门全名
			db.setDeptFullName(rst.getString("DEPTNAME"));
			// 设置部门简称
			db.setDeptName(rst.getString("DEPTNM"));
			// 设置姓
			db.setFirstName("-");
			// 设置名
			db.setLastName("-");
			// 设置职务
			db.setJobLevel("-");
			// 设置总人数
			db.setPersonCount(rst.getString("PERSONCOUNT"));
			// 加入结果集
			searchResultList.add(db);
		}
		return searchResultList;

	}

	/**
	 * 部门别 年收最大/最小
	 * 
	 * @param con
	 *            数据库连接
	 * @param searchDatabean
	 *            查找条件dataBean
	 * @return 查找到的结果
	 * @throws SQLException
	 */
	public List<MemSelDeptInfoDatabean> annualIncomeSearch(Connection con,
			MemSelKeyDatabean searchDatabean) throws SQLException {
		// 转义后的部门号
		String escapedDeptCode = escapeInput.sqlEscape(searchDatabean
				.getDeptCodeInput().trim());
		// 转义后的部门名
		String escapedDeptName = escapeInput.sqlEscape(searchDatabean
				.getDeptNameInput().trim());
		// 转义后的姓名
		String escapedName = escapeInput.sqlEscape(searchDatabean
				.getNameInput().trim());
		String strSQL = "";
		strSQL = "SELECT MDM.DEPTCODE ";
		strSQL = strSQL + "      ,MD.DEPTNAME DEPTNAME";
		strSQL = strSQL + "      ,MD.DEPTNM DEPTNM";
		strSQL = strSQL + "      ,MDM.MEMBERFIRSTNAME";
		strSQL = strSQL + "      ,MDM.MEMBERLASTNAME";
		strSQL = strSQL + "      ,MDM.JOB_LEVEL";
		strSQL = strSQL + "      ,MDM.ANNUAL_INCOME";
		strSQL = strSQL + "  FROM M_DEPT MD";
		strSQL = strSQL + "      ,M_DEPT_MEMBER MDM";
		strSQL = strSQL + "      ,(";
		strSQL = strSQL + "SELECT MDM.DEPTCODE";
		if (isMax) {
			strSQL = strSQL + "      ,MAX(MDM.ANNUAL_INCOME) MAXINCOME";
		} else {
			strSQL = strSQL + "      ,MIN(MDM.ANNUAL_INCOME) MAXINCOME";
		}
		// flag反转
		isMax = !isMax;
		strSQL = strSQL + "  FROM M_DEPT_MEMBER MDM";
		strSQL = strSQL + " WHERE MDM.DELETEFLG = 0";
		strSQL = strSQL
				+ "   AND MDM.MEMBERFIRSTNAME || MDM.MEMBERLASTNAME LIKE ?ESCAPE '/'";
		strSQL = strSQL + " GROUP BY MDM.DEPTCODE) MAXANNUALINCOME";
		strSQL = strSQL + " WHERE 1 = 1";
		strSQL = strSQL + "   AND MAXANNUALINCOME.DEPTCODE = MDM.DEPTCODE";
		strSQL = strSQL + "   AND MDM.DELETEFLG = 0";
		strSQL = strSQL + "   AND MD.DEPTCODE(+) = MDM.DEPTCODE";
		strSQL = strSQL + "   AND MD.DELETEFLG(+) = MDM.DELETEFLG";
		strSQL = strSQL
				+ "   AND MDM.ANNUAL_INCOME IN MAXANNUALINCOME.MAXINCOME";
		strSQL = strSQL + "   AND MDM.DEPTCODE LIKE ? ESCAPE '" + escape + "'";
		strSQL = strSQL + "   AND (NVL(MD.DEPTNAME , ' ') LIKE ? ESCAPE '"
				+ escape + "'";
		strSQL = strSQL + "	   OR NVL(MD.DEPTNM , ' ') LIKE ? ESCAPE '"
				+ escape + "')";
		strSQL = strSQL
				+ "AND MDM.MEMBERFIRSTNAME || MDM.MEMBERLASTNAME LIKE ? ESCAPE '"
				+ escape + "'";
		strSQL = strSQL + " ORDER BY MDM.DEPTCODE ";
		System.out.println(strSQL);
		pstmt = con.prepareStatement(strSQL);
		pstmt.setString(1, "%" + escapedName + "%");
		pstmt.setString(2, escapedDeptCode + "%");
		pstmt.setString(3, "%" + escapedDeptName + "%");
		pstmt.setString(4, "%" + escapedDeptName + "%");
		pstmt.setString(5, "%" + escapedName + "%");
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) {
			MemSelDeptInfoDatabean db = new MemSelDeptInfoDatabean();
			// 设置部门号
			db.setDeptCode(rst.getString("DEPTCODE"));
			// 设置部门全名
			db.setDeptFullName(rst.getString("DEPTNAME"));
			// 设置部门简称
			db.setDeptName(rst.getString("DEPTNM"));
			// 设置姓
			db.setFirstName(rst.getString("MEMBERFIRSTNAME"));
			// 设置名
			db.setLastName(rst.getString("MEMBERLASTNAME"));
			// 设置职务
			db.setJobLevel(rst.getString("JOB_LEVEL"));
			// 设置总金额
			db.setPersonCount(rst.getString("ANNUAL_INCOME"));
			// 加入结果集
			searchResultList.add(db);
		}
		return searchResultList;
	}

	/**
	 * 部门别+职务级别别 年收合计
	 * 
	 * @param con
	 *            数据库连接
	 * @param searchDatabean
	 *            查找条件dataBean
	 * @return 查找到的结果
	 * @throws SQLException
	 */
	public List<MemSelDeptInfoDatabean> jobLevelSearch(Connection con,
			MemSelKeyDatabean searchDatabean) throws SQLException {
		// 转义后的部门号
		String escapedDeptCode = escapeInput.sqlEscape(searchDatabean
				.getDeptCodeInput().trim());
		// 转义后的部门名
		String escapedDeptName = escapeInput.sqlEscape(searchDatabean
				.getDeptNameInput().trim());
		// 转义后的姓名
		String escapedName = escapeInput.sqlEscape(searchDatabean
				.getNameInput().trim());
		String strSQL = "";
		strSQL = "SELECT MDM.DEPTCODE ";
		strSQL = strSQL + "      ,MDM.JOB_LEVEL";
		strSQL = strSQL + "      ,MD.DEPTNAME AS DEPTNAME ";
		strSQL = strSQL + "      ,MD.DEPTNM AS DEPTNM ";
		strSQL = strSQL + "      ,SUM(MDM.ANNUAL_INCOME) AS SUMINCOME";
		strSQL = strSQL + "  FROM M_DEPT MD";
		strSQL = strSQL + "      ,M_DEPT_MEMBER MDM ";
		strSQL = strSQL + " WHERE MD.DEPTCODE(+) = MDM.DEPTCODE";
		strSQL = strSQL + "   AND MDM.DELETEFLG = 0";
		strSQL = strSQL + "   AND MDM.DELETEFLG = MD.DELETEFLG(+)";
		strSQL = strSQL + "   AND MDM.DEPTCODE LIKE ? ESCAPE '" + escape + "'";
		strSQL = strSQL + "   AND (NVL(MD.DEPTNAME , ' ') LIKE ? ESCAPE '"
				+ escape + "'";
		strSQL = strSQL + "	   OR NVL(MD.DEPTNM , ' ') LIKE ? ESCAPE '"
				+ escape + "')";
		strSQL = strSQL
				+ "AND MDM.MEMBERFIRSTNAME || MDM.MEMBERLASTNAME LIKE ? ESCAPE '"
				+ escape + "'";
		strSQL = strSQL + " GROUP BY MDM.DEPTCODE";
		strSQL = strSQL + "         ,MDM.JOB_LEVEL";
		strSQL = strSQL + "         ,MD.DEPTNAME";
		strSQL = strSQL + "         ,MD.DEPTNM";
		strSQL = strSQL + " ORDER BY MDM.DEPTCODE";
		pstmt = con.prepareStatement(strSQL);
		pstmt.setString(1, escapedDeptCode + "%");
		pstmt.setString(2, "%" + escapedDeptName + "%");
		pstmt.setString(3, "%" + escapedDeptName + "%");
		pstmt.setString(4, "%" + escapedName + "%");
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) {
			MemSelDeptInfoDatabean db = new MemSelDeptInfoDatabean();
			// 设置部门号
			db.setDeptCode(rst.getString("DEPTCODE"));
			// 设置部门全名
			db.setDeptFullName(rst.getString("DEPTNAME"));
			// 设置部门简称
			db.setDeptName(rst.getString("DEPTNM"));
			// 设置姓
			db.setFirstName("-");
			// 设置名
			db.setLastName("-");
			// 设置职务
			db.setJobLevel(rst.getString("JOB_LEVEL"));
			// 设置金额
			db.setPersonCount(rst.getString("SUMINCOME"));
			// 加入结果集
			searchResultList.add(db);
		}
		return searchResultList;
	}
}