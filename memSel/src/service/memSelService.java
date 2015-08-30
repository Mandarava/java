package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import common.SQLOperation;
import dao.memSelDao;
import databean.MemSelDeptInfoDatabean;
import databean.MemSelKeyDatabean;

public class memSelService {

	private Connection con = null;

	private SQLOperation sqlOperation = new SQLOperation();

	public List<MemSelDeptInfoDatabean> getData(MemSelKeyDatabean searchDatabean) {
		memSelDao memSelDao = new memSelDao();
		List<MemSelDeptInfoDatabean> searchResultList = null;
		try {
			// con = sqlOperation.getConnection();
			searchResultList = memSelDao.DBSelect(con, searchDatabean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// try {
			// // sqlOperation.closeConnection(con);
			// } catch (SQLException e) {
			// e.printStackTrace();
			// }
		}
		return searchResultList;
	}
}
