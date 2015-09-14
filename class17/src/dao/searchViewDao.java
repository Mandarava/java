package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.ConfigUtils;
import common.EscapeInput;
import common.JDBCTools;

import databean.SearchViewDeptInfoDatabean;
import databean.SearchViewKeyDatabean;


public class searchViewDao {
	/** 创建PreparedStatement */
	private PreparedStatement pstmt = null;
	/** 查找到的数据的结果集 */
	private List<SearchViewDeptInfoDatabean> searchResultList = new ArrayList<SearchViewDeptInfoDatabean>();
	/** 字符串转义 */
	private EscapeInput escapeInput = new EscapeInput();
	/** 转义字符 */
	private String escape = ConfigUtils.getInstance().getValue("escape");
	/** 数据库工具 */
	JDBCTools jdbcTools = new JDBCTools();

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
	public List<SearchViewDeptInfoDatabean> commonSearch(Connection con,
			SearchViewKeyDatabean searchDatabean) throws SQLException {
		// 转义后的部门号
		String escapedDeptCode = escapeInput.sqlEscape(searchDatabean
				.getDeptCodeInput());
		// 转义后的部门名
		String escapedDeptName = escapeInput.sqlEscape(searchDatabean
				.getDeptNameInput().trim());
		// 转义后的姓名
		String escapedName = escapeInput.sqlEscape(searchDatabean
				.getNameInput());
		String strSQL = "";
		strSQL = "SELECT MDM.DEPTCODE ";
		strSQL = strSQL + "      ,MD.DEPTNAME";
		strSQL = strSQL + "      ,MD.DEPTNM";
		strSQL = strSQL + "      ,MDM.MEMBERNO";
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
			SearchViewDeptInfoDatabean db = new SearchViewDeptInfoDatabean();
			// 设置工号
			db.setMemberNO(rst.getString("MEMBERNO"));
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

	public void deleteCheckedData(Connection con, String deptCode,
			String memberNO) throws SQLException {
		String strSQL = "";
		strSQL = strSQL + "UPDATE M_DEPT_MEMBER";
		strSQL = strSQL + "   SET DELETEFLG = 1";
		strSQL = strSQL + " WHERE MEMBERNO = ?";
		strSQL = strSQL + "   AND DEPTCODE = ?";
		pstmt = con.prepareStatement(strSQL);
		jdbcTools.update(strSQL, memberNO, deptCode);
	}
}
