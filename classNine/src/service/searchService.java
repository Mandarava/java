/**
 * searchService.java
 * 
 * 分類　　:
 * 名称　　:
 * 説明　　：
 * 備考　　：This is a demo
 * 作成　　：[日付] 2015/08/17 [氏名] S1507112
 * 履歴：
 * [NO]  [日付]　  	[Ver]　   	 [更新者]　  		[内容]
 *　1   2015/08/17  	V10L1 	 S1507112		   初版。　 
 */
package service;

import java.sql.Connection;
import java.util.List;

import dao.searchDao;
import databean.searchDatabean;

/**
 * search page service
 * 
 * @author peixun
 * 
 */
public class searchService {
	/**
	 * 
	 * @return List<searchDatabean>
	 */

	public List<searchDatabean> searchDataService(searchDatabean searchDatabean) {
		/* the sql connection */
		Connection connection = null;
		searchDao searchDao = new searchDao();
		return searchDao.searchDataDao(searchDatabean, connection);
		// connection.close();
	}
}
