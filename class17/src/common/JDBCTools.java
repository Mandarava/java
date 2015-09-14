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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库操作
 * 
 * @see java.sql.Connection
 * @see java.sql.DriverManager
 * @see java.sql.SQLException
 * @author S1507112
 * @version 1.0
 */
public class JDBCTools {
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

	/**
	 * 释放数据库资源的方法
	 * 
	 * @param resultSet
	 * @param statement
	 * @param connection
	 */
	public static void releaseDB(ResultSet resultSet, Statement statement,
			Connection connection) {

		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 执行 SQL 语句, 使用 PreparedStatement
	 * 
	 * @param sql
	 * @param args
	 *            填写 SQL 占位符的可变参数
	 */
	public void update(String sql, Object... args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = this.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(null, preparedStatement, connection);
		}
	}
}
