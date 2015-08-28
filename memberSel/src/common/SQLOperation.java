/**
 * SQLOperation.java
 * 
 * 分類　　:memberSel-common SQLOperation 
 * 名称　　:获得数据库操作
 * 説明　　：用于对数据库的常用操作
 * 備考　　：
 * 作成　　：[日付] 2015/08/20 [氏名] S1507112
 * 履歴：
 * [NO]	[日付]		[Ver]	[更新者]		[内容]
 *	1	2015/08/20	V10L1	S1507112	 初版。　 
 */
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
 * @author S1507112
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
		System.out.println(111111111);
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
