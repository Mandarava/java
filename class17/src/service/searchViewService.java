/**
 * searchViewService.java
 * 
 * 分類　　:class17-service	
 * 名称　　:
 * 説明　　：
 * 備考　　：
 * 作成　　：[日付] 2015/09/07 [氏名] S1507112
 * 履歴：
 * [NO]	[日付]		[Ver]	[更新者]		[内容]
 *	1	2015/09/07	V10L1	S1507112	 初版。　 
 */
package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.apache.commons.lang.xwork.StringEscapeUtils;

import common.JDBCTools;

import dao.searchViewDao;
import databean.SearchViewDeptInfoDatabean;
import databean.SearchViewKeyDatabean;

/**
 * @author peixun
 * 
 */
public class searchViewService {
	/** 数据库连接 */
	private Connection con = null;
	/** 数据库操作类 */
	private JDBCTools sqlOperation = new JDBCTools();

	/**
	 * 搜索service，向DAO传递数据库连接和检索条件dataBean
	 * 
	 * @param searchDatabean
	 *            检索条件databean
	 * @return 查询结果
	 */
	public List<SearchViewDeptInfoDatabean> getData(
			SearchViewKeyDatabean searchDatabean) {
		searchViewDao searchViewDao = new searchViewDao();
		List<SearchViewDeptInfoDatabean> searchResultList = null;
		try {
			con = sqlOperation.getConnection();
			searchResultList = searchViewDao.commonSearch(con, searchDatabean);
			// 格式化年收入，带两个小数点
			DecimalFormat incomeFormat = (DecimalFormat) NumberFormat
					.getInstance();
			incomeFormat.applyPattern("0.00");
			for (int i = 0; i < searchResultList.size(); i++) {
				searchResultList.get(i).setPersonCount(
						incomeFormat.format(Double.valueOf(searchResultList
								.get(i).getPersonCount())));
				searchResultList.get(i).setDeptFullName(
						StringEscapeUtils.escapeHtml(searchResultList.get(i)
								.getDeptFullName()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				sqlOperation.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return searchResultList;
	}

	public void deleteData(SearchViewKeyDatabean searchDatabean) {
		searchViewDao searchViewDao = new searchViewDao();
		String deleteFlag[] = searchDatabean.getCheckIndex().split(" ");
		String deptCode[] = new String[deleteFlag.length / 2];
		String memberNO[] = new String[deleteFlag.length / 2];
		for (int i = 0, j = 0; i < deleteFlag.length / 2; i++, j = j + 2) {
			deptCode[i] = deleteFlag[j];
			memberNO[i] = deleteFlag[j + 1];
		}
		try {
			con = sqlOperation.getConnection();
			con.setAutoCommit(false);
			for (int i = 0; i < deptCode.length; i++) {
				searchViewDao.deleteCheckedData(con, deptCode[i], memberNO[i]);
			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		} finally {
			try {
				sqlOperation.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
