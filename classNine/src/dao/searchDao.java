/**
 * searchDao.java
 * 
 * 分類　　:classNine-search dao
 * 名称　　:search DAO
 * 説明　　：This is search page dao
 * 備考　　：This is a demo
 * 作成　　：[日付] 2015/08/17 [氏名] S1507112
 * 履歴：
 * [NO]  [日付]　  	[Ver]　   	 [更新者]　  		[内容]
 *　1   2015/08/17  	V10L1 	 S1507112		   初版。　 
 */
package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import databean.searchDatabean;

/**
 * search dao
 * 
 * @author peixun
 * 
 */
public class searchDao {
	/**
	 * 
	 * @param searchDatabean receive the databean 
	 * @param conn	receive the sqlconnection
	 * @return List<searchDatabean>
	 */
	public List<searchDatabean> searchDataDao(searchDatabean searchDatabean,
			Connection conn) {

		List<searchDatabean> modelList = new ArrayList<searchDatabean>();
		for (int i = 0; i < 10; i++) {
			searchDatabean model = new searchDatabean();
			model.setMembercode("S131293" + i);
			model.setName("员工名" + i);
			model.setJob_level("实习" + i);
			model.setAnnual_income("1,200.00");
			model.setDeptcode("1111" + i);
			model.setDeptnm("实习部");
			modelList.add(model);
		}
		return modelList;
	}
}
