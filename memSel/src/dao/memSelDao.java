package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import common.EscapeInput;
import databean.MemSelDeptInfoDatabean;
import databean.MemSelKeyDatabean;

public class memSelDao {

	private PreparedStatement pstmt = null;

	private List<MemSelDeptInfoDatabean> searchResultList = new ArrayList<MemSelDeptInfoDatabean>();

	private EscapeInput escapeInput = new EscapeInput();

	public List<MemSelDeptInfoDatabean> DBSelect(Connection con, MemSelKeyDatabean searchDatabean) {
		for (int i = 0; i < 10; i++) {
			MemSelDeptInfoDatabean db = new MemSelDeptInfoDatabean();
			db.setDeptCode("" + i);
			db.setDeptFullName("" + i);
			db.setDeptName("" + i);
			db.setFirstName("" + i);
			db.setLastName("" + i);
			db.setJobLevel("" + i);
			db.setPersonCount(i);
			searchResultList.add(db);
		}
		return searchResultList;
	}
}
