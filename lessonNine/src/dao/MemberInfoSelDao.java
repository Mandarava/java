/**
 * MemberInfoSelDao.java
 * 
 * 分類　　:classNine-search DAO
 * 名称　　:search DAO
 * 説明　　：从SERVICE取得dataBean及connection，拼接并执行SQL语句，
 * 		取得结果后对结果进行各种处理，然后将结果返回给SERVICE。
 * 備考　　：This is a demo
 * 作成　　：[日付] 2015/08/17 [氏名] S1507112
 * 履歴：
 * [NO]	[日付]		[Ver]		[更新者]		[内容]
 *	1	2015/08/17	V10L1		S1507112	 初版。　 
 *	2	2015/08/19	V10L1.01	S1507112	更改注释
 */
package dao;

import java.sql.Connection;
import java.util.List;

import databean.MemberInfoSelDetailDatabean;
import databean.MemberInfoSelDatabean;

/**
 * search DAO
 * 
 * @author S1507112
 * @version 1.0
 */

public class MemberInfoSelDao {
	/**
	 * 
	 * @param searchDatabean
	 *            the dataBean
	 * @param conn
	 *            数据库连接
	 * @return 查找到的一览数据
	 */

	public List<MemberInfoSelDetailDatabean> searchDataDao(Connection conn, MemberInfoSelDatabean searchDatabean) {
		System.out.println("start dao.searchDataDao");
		/** 查找到的一览数据的结果集 */
		List<MemberInfoSelDetailDatabean> searchResult = searchDatabean.getModelList();
		for (int i = 0; i < 10; i++) {
			/** 一览数据的dataBean */
			MemberInfoSelDetailDatabean model = new MemberInfoSelDetailDatabean();
			model.setMembercode("S131293" + i);
			model.setName("员工名" + i);
			model.setJob_level("实习" + i);
			model.setAnnual_income("1,200.00");
			model.setDeptcode("1111" + i);
			model.setDeptnm("实习部");
			searchResult.add(model);
		}
		return searchResult;
	}
}
