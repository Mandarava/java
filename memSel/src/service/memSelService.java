
package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.apache.commons.lang.xwork.StringEscapeUtils;

import common.SQLOperation;
import dao.memSelDao;
import databean.MemSelDeptInfoDatabean;
import databean.MemSelKeyDatabean;

/**
 * 查找service
 * 
 * @see java.sql.Connection
 * @see java.sql.SQLException
 * @see java.text.DecimalFormat
 * @see java.text.NumberFormat
 * @see java.util.List
 * @see org.apache.commons.lang.xwork.StringEscapeUtils
 * @see common.SQLOperation
 * @see dao.memSelDao
 * @see databean.MemSelDeptInfoDatabean
 * @see databean.MemSelKeyDatabean
 * @version 1.0
 */
public class memSelService {
	/** 数据库连接 */
	private Connection con = null;
	/** 数据库操作类 */
	private SQLOperation sqlOperation = new SQLOperation();

	/**
	 * 搜索service，向DAO传递数据库连接和检索条件dataBean
	 * 
	 * @param searchDatabean
	 *            检索条件databean
	 * @return 查询结果
	 */
	public List<MemSelDeptInfoDatabean> getData(MemSelKeyDatabean searchDatabean) {
		memSelDao memSelDao = new memSelDao();
		List<MemSelDeptInfoDatabean> searchResultList = null;
		// 选中的radio
		String searchCondition = searchDatabean.getSearchCondition();
		try {
			con = sqlOperation.getConnection();
			// 如果选中了第一个radio
			if (searchCondition.equals("0")) {
				searchResultList = memSelDao.personCountSearch(con,
						searchDatabean);
				// 如果选中了第二个radio
			} else if (searchCondition.equals("1")) {
				searchResultList = memSelDao.annualIncomeSearch(con,
						searchDatabean);
				// 如果选中了第三个radio
			} else if (searchCondition.equals("2")) {
				searchResultList = memSelDao
						.jobLevelSearch(con, searchDatabean);
				// 如果选中了第四个radio
			} else if (searchCondition.equals("3")) {
				searchResultList = memSelDao.commonSearch(con, searchDatabean);
			}
			// 格式化年收入，带两个小数点
			DecimalFormat incomeFormat = (DecimalFormat) NumberFormat
					.getInstance();
			incomeFormat.applyPattern("0.00");
			for (int i = 0; i < searchResultList.size(); i++) {
				if (!searchCondition.equals("0")) {
					searchResultList.get(i).setPersonCount(
							incomeFormat.format(Double.valueOf(searchResultList
									.get(i).getPersonCount())));
				}
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
}
