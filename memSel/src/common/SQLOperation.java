
package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库操作
 * 
 * @see java.sql.Connection
 * @see java.sql.DriverManager
 * @see java.sql.SQLException
 * @version 1.0
 */
public class SQLOperation {
	/** 数据库连接 */
	private Connection con = null;

	/**
	 * 获得数据库连接
	 * 
	 * @return 数据库连接
	 * @throws Exception
	 *             数据库连接失败
	 */
	public Connection getConnection() throws Exception {
		// DriverManager生成数据库连接
		String url = ConfigUtils.getInstance().getValue("url");
		// 数据库登录用户名
		String userID = ConfigUtils.getInstance().getValue("userID");
		// 数据库登录密码
		String password = ConfigUtils.getInstance().getValue("password");
		// 装载数据库驱动
		Class.forName(ConfigUtils.getInstance().getValue("driver"));
		con = DriverManager.getConnection(url, userID, password);
		return con;
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param con
	 *            数据库连接
	 * @throws SQLException
	 *             关闭数据库异常
	 */
	public void closeConnection(Connection con) throws SQLException {
		if (!con.isClosed()) {
			con.close();
		}
	}
}
