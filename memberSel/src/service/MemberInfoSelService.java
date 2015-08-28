/**
 * MemberInfoSelService.java
 * 
 * 分類　　:memberSel-service service
 * 名称　　:service 
 * 説明　　：从ACTION得到dataBean，同时创建connection，以事务处理的方式调用DAO的方法，
 * 		将connection和ACTION传来的的dataBean传给DAO，从DAO得到dataBean，
 * 		执行commit或rollBack，将结果返回给ACTION
 */
package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.apache.commons.lang.xwork.StringEscapeUtils;

import common.ConfigUtils;
import common.SQLOperation;

import dao.MemberInfoSelDao;
import databean.MemberInfoSelDetailDatabean;
import databean.MemberInfoSelSelectKeyDatabean;

/**
 * search page service
 * 
 * @see java.sql.Connection
 * @see java.sql.SQLException
 * @see java.text.DecimalFormat
 * @see java.text.NumberFormat
 * @see java.util.List
 * @see org.apache.commons.lang.xwork.StringEscapeUtils
 * @see common.ConfigUtils
 * @see common.SQLOperation
 * @see dao.MemberInfoSelDao
 * @see databean.MemberInfoSelDetailDatabean
 * @see databean.MemberInfoSelSelectKeyDatabean
 * @version 1.0
 */
public class MemberInfoSelService {
	/** 数据库连接 */
	private Connection con = null;
	/** 数据库操作类 */
	private SQLOperation sqlOperation = new SQLOperation();

	/**
	 * 搜索到service，向DAO传递数据库连接和检索条件dataBean
	 * 
	 * @param searchDatabean
	 *            检索条件的dataBean
	 * @return 查找到的员工数据集
	 */
	public List<MemberInfoSelDetailDatabean> getData(
			MemberInfoSelSelectKeyDatabean searchDatabean) {
		System.out.println("start service.searchDataService");
		MemberInfoSelDao memberInfoSelDao = new MemberInfoSelDao();
		// 查找到的结果
		List<MemberInfoSelDetailDatabean> searchResultList = null;
		try {
			con = sqlOperation.getConnection();
			// 当工号有输入时 ,检索工号是否存在,是否删除
			if (searchDatabean.getMemberCodeInput().length() != 0) {
				// 判断工号是否存在
				if (memberInfoSelDao.isWorkerIDExist(con, searchDatabean) == false) {
					searchDatabean.setMsg(StringEscapeUtils
							.unescapeJava(ConfigUtils.getInstance().getValue(
									"E001")));
					return searchResultList;
				}
				// 如果工号已经被删除了的
				if (memberInfoSelDao.isWorkerIDDeleted(con, searchDatabean) == false) {
					searchDatabean.setMsg(StringEscapeUtils
							.unescapeJava(ConfigUtils.getInstance().getValue(
									"E002")));
					return searchResultList;
				}
			}
			// 员工数据存在且未被删除,检索员工数据
			searchResultList = memberInfoSelDao.searchData(con, searchDatabean);
			// 如果检索结果总件数=0，处理终止、出MSG3
			if (searchResultList.isEmpty()) {
				searchDatabean.setMsg(StringEscapeUtils
						.unescapeJava(ConfigUtils.getInstance()
								.getValue("E003")));
				return searchResultList;
			}
			// 格式化年收入，带两个小数点
			DecimalFormat incomeFormat = (DecimalFormat) NumberFormat
					.getInstance();
			incomeFormat.applyPattern("0.00");
			for (int i = 0; i < searchResultList.size(); i++) {
				searchResultList.get(i).setAnnualIncome(
						incomeFormat.format(Double.valueOf(searchResultList
								.get(i).getAnnualIncome())));
				searchResultList.get(i).setDeptNm(
						StringEscapeUtils.escapeHtml(searchResultList.get(i)
								.getDeptNm()));
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
