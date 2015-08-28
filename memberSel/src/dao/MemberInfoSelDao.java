/**
 * MemberInfoSelDao.java
 * 
 * 分類　　:memberSel-search DAO
 * 名称　　:查找员工信息的DAO
 * 説明　　：从SERVICE取得dataBean及connection，拼接并执行SQL语句，
 * 		取得结果后对结果进行各种处理，然后将结果返回给SERVICE。
 * 備考　　：
 * 作成　　：[日付] 2015/08/17 [氏名] S1507112
 * 履歴：
 * [NO]	[日付]		[Ver]		[更新者]		[内容]
 *	1	2015/08/17	V10L1		S1507112	 初版。　 
 *	2	2015/08/19	V10L1.01	S1507112	更改注释
 *	3	2015/08/20	V10L1.02	S1507112	增加数据库查询操作
 *	4	2015/08/25	V10L1.03	S1507112	字符串转义
 *	5	2015/08/26	V10L1.04	S1507112	修改数据库查询缺数据问题
 *	6	2015/08/27	V10L1.05	S1507112	调整代码结构
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import common.ConfigUtils;
import common.EscapeInput;

import databean.MemberInfoSelDetailDatabean;
import databean.MemberInfoSelSelectKeyDatabean;

/**
 * 数据库查找数据
 * 
 * @see java.sql.Connection
 * @see java.sql.PreparedStatement
 * @see java.sql.ResultSet
 * @see java.sql.SQLException
 * @see java.util.ArrayList
 * @see java.util.HashMap
 * @see java.util.List
 * @see common.ConfigUtils
 * @see common.EscapeInput
 * @see databean.MemberInfoSelDetailDatabean
 * @see databean.MemberInfoSelSelectKeyDatabean
 * @author S1507112
 * @version 1.05
 */
public class MemberInfoSelDao {
	/** 创建PreparedStatement */
	private PreparedStatement pstmt = null;
	/** 查找到的员工数据的结果集 */
	private List<MemberInfoSelDetailDatabean> searchResultList = new ArrayList<MemberInfoSelDetailDatabean>();
	/** 字符串转义 */
	private EscapeInput escapeInput = new EscapeInput();

	/**
	 * 查找员工信息
	 * 
	 * @param searchDatabean
	 *            检索条件的dataBean
	 * @param conn
	 *            数据库连接
	 * @return 包含查找到的员工数据
	 * @throws SQLException
	 */
	public List<MemberInfoSelDetailDatabean> searchData(Connection con,
			MemberInfoSelSelectKeyDatabean searchDatabean) throws SQLException {
		System.out.println("start dao.searchDataDao");
		// 保存prepareStatement中setString的字符串
		HashMap<Integer, String> pstmtToSet = new HashMap<Integer, String>();
		// 保存prepareStatement中?的inedx
		int index = 1;
		// 输入的工号
		String memberCodeInput = searchDatabean.getMemberCodeInput();
		// 输入的名称
		String nameInput = searchDatabean.getNameInput();
		String strSQL = "";
		strSQL = "SELECT MDM.MEMBERNO";
		strSQL += "      ,MDM.MEMBERFIRSTNAME||MDM.MEMBERLASTNAME AS MEMBERFULLNAME";
		strSQL += "      ,MDM.JOB_LEVEL";
		strSQL += "      ,MDM.ANNUAL_INCOME";
		strSQL += "      ,MDM.DEPTCODE";
		strSQL += "      ,NVL(MD.DEPTNAME, ' ') AS DEPTNAME ";
		strSQL += "  FROM M_DEPT_MEMBER MDM";
		strSQL += "      ,M_DEPT MD";
		strSQL += " WHERE MDM.DEPTCODE = MD.DEPTCODE(+)";
		strSQL += "   AND MDM.DELETEFLG = MD.DELETEFLG(+)";
		strSQL += "   AND MDM.DELETEFLG = '0' ";
		// 如果工号有输入
		if (memberCodeInput.length() != 0) {
			strSQL += "   AND MDM.MEMBERNO = ?";
			pstmtToSet.put(index++, memberCodeInput);
		}
		// 如果第二栏检索条件有输入
		if (nameInput.length() != 0) {
			// 如果选中的是部门名按钮
			if (searchDatabean.getDeptName().equals("0")) {
				strSQL += "   AND MD.DEPTNAME LIKE ? ESCAPE '"
						+ ConfigUtils.getInstance().getValue("escape") + "'";
				// 如果选中的是员工姓名按钮
			} else {
				strSQL += "   AND MDM.MEMBERFIRSTNAME || MDM.MEMBERLASTNAME LIKE ? ESCAPE '"
						+ ConfigUtils.getInstance().getValue("escape") + "'";
			}
			pstmtToSet.put(index++, "%" + escapeInput.sqlEscape(nameInput)
					+ "%");
		}
		strSQL += " ORDER BY MDM.MEMBERNO";
		strSQL += "         ,MDM.DEPTCODE";
		pstmt = con.prepareStatement(strSQL);
		for (int i = 1; i <= pstmtToSet.size(); i++) {
			pstmt.setString(i, pstmtToSet.get(i));
		}
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) {
			// 员工数据的dataBean
			MemberInfoSelDetailDatabean model = new MemberInfoSelDetailDatabean();
			// 设置工号
			model.setMemberCode(rst.getString("MEMBERNO"));
			// 设置名字
			model.setName(rst.getString("MEMBERFULLNAME"));
			// 设置职务
			model.setJobLevel(rst.getString("JOB_LEVEL"));
			// 设置年收入
			model.setAnnualIncome(rst.getString("ANNUAL_INCOME"));
			// 设置部门编号
			model.setDeptCode(rst.getString("DEPTCODE"));
			// 设置部门名字
			model.setDeptNm(rst.getString("DEPTNAME"));
			// 加入结果集
			searchResultList.add(model);
		}
		pstmt.close();
		return searchResultList;
	}

	/**
	 * 工号存在性检测
	 * 
	 * @param con
	 *            数据库连接
	 * @param searchDatabean
	 *            检索条件的dataBean
	 * @return 工号不存在返回false,工号存在返回true
	 * @throws SQLException
	 */
	public boolean isWorkerIDExist(Connection con,
			MemberInfoSelSelectKeyDatabean searchDatabean) throws SQLException {
		System.out.println("start dao.isWorkerIDExist");
		String strSQL = "";
		strSQL += "SELECT COUNT(MDM.MEMBERNO) AS COUNT";
		strSQL += "  FROM M_DEPT_MEMBER MDM";
		strSQL += " WHERE MDM.MEMBERNO = ? ";
		pstmt = con.prepareStatement(strSQL);
		pstmt.setString(1, searchDatabean.getMemberCodeInput());
		ResultSet rst = pstmt.executeQuery();
		rst.next();
		int count = rst.getInt("COUNT");
		return count == 0 ? false : true;
	}

	/**
	 * 判断数据工号是否已经删除
	 * 
	 * @param con
	 *            数据库连接
	 * @param searchDatabean
	 *            检索条件的dataBean
	 * @return 如工号全部为已经删除的则返回false,否则返回true
	 * @throws SQLException
	 */
	public boolean isWorkerIDDeleted(Connection con,
			MemberInfoSelSelectKeyDatabean searchDatabean) throws SQLException {
		System.out.println("start dao.isWorkerIDDeleted");
		String strSQL = "";
		strSQL += "SELECT COUNT(MDM.MEMBERNO) AS COUNT";
		strSQL += "  FROM M_DEPT_MEMBER MDM";
		strSQL += " WHERE MDM.MEMBERNO = ?";
		strSQL += "   AND MDM.DELETEFLG = '0' ";
		pstmt = con.prepareStatement(strSQL);
		pstmt.setString(1, searchDatabean.getMemberCodeInput());
		ResultSet rst = pstmt.executeQuery();
		rst.next();
		int count = rst.getInt("COUNT");
		return count == 0 ? false : true;
	}
}
