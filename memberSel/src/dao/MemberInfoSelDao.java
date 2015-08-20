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
 */
package dao;

import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import databean.MemberInfoSelDatabean;
import databean.MemberInfoSelDetailDatabean;

/**
 * 数据库查找数据
 * 
 * @see java.sql.Connection
 * @see java.util.List
 * @see databean.MemberInfoSelDetailDatabean
 * @see databean.MemberInfoSelDatabean
 * @see java.text.DecimalFormat
 * @see java.text.NumberFormat
 * @author S1507112
 * @version 1.0
 */
public class MemberInfoSelDao {

	/**
	 * 查找员工信息
	 * 
	 * @param memInfoDatabean
	 *            总的dataBean
	 * @param conn
	 *            数据库连接
	 * @return 包含查找到的员工数据
	 */
	public MemberInfoSelDatabean searchDataDao(Connection conn,
			MemberInfoSelDatabean memInfoDatabean) {
		System.out.println("start dao.searchDataDao");
		/** 查找到的员工数据的结果集 */
		List<MemberInfoSelDetailDatabean> searchResult = memInfoDatabean
				.getModelList();
		/** 格式化年收入，带两个小数点 */
		DecimalFormat incomeFormat = (DecimalFormat) NumberFormat.getInstance();
		incomeFormat.applyPattern("0.00");
		for (int i = 0; i < 10; i++) {
			/** 员工数据的dataBean */
			MemberInfoSelDetailDatabean model = new MemberInfoSelDetailDatabean();
			model.setMembercode("S131293" + i);
			model.setName("员工名" + i);
			model.setJob_level("实习" + i);
			model.setAnnual_income(incomeFormat.format(1200));
			model.setDeptcode("1111" + i);
			model.setDeptnm("实习部");
			searchResult.add(model);
		}
		return memInfoDatabean;
	}
}
