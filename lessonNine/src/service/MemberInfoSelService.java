/**
 * MemberInfoSelService.java
 * 
 * 分類　　:classNine-service service
 * 名称　　:service 
 * 説明　　：从ACTION得到dataBean，同时创建connection，以事务处理的方式调用DAO的方法，
 * 		将connection和ACTION传来的的dataBean传给DAO，从DAO得到dataBean，
 * 		执行commit或rollBack，将结果返回给ACTION
 * 備考　　：This is a demo
 * 作成　　：[日付] 2015/08/17 [氏名] S1507112
 * 履歴：
 * [NO]	[日付]		[Ver]	[更新者]		[内容]
 *	1	2015/08/17	V10L1	S1507112	 初版。　 
 */
package service;

import java.sql.Connection;
import java.util.List;

import dao.MemberInfoSelDao;
import databean.MemberInfoSelDetailDatabean;
import databean.MemberInfoSelDatabean;

/**
 * search page service
 * 
 * @see java.sql.Connection
 * @see java.util.List
 * @see dao.MemberInfoSelDao
 * @see databean.MemberInfoSelDetailDatabean
 * @see databean.MemberInfoSelDatabean
 * @author S1507112
 * @version 1.0
 */

public class MemberInfoSelService {
	/**
	 * the search service
	 * 
	 * @param searchDatabean
	 * @return 查找到的一览数据集
	 */

	public List<MemberInfoSelDetailDatabean> searchDataService(MemberInfoSelDatabean searchDatabean) {
		System.out.println("start service.searchDataService");
		/** the SQL connection */
		Connection connection = null;
		return new MemberInfoSelDao().searchDataDao(connection, searchDatabean);
		// connection.close();
	}
}
