package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtils {
	/**
	 * 关闭数据库执行过程
	 * @param stmt 执行过程
	 */
	public static void closeQuietly(PreparedStatement stmt){
		if (stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				//do nothing
			}
		}
	}
	/**
	 * 关闭数据库连接
	 * @param conn 数据库连接
	 */
	public static void closeQuietly(Connection conn){
		if (conn!=null) {
			try {
				conn.close();//关闭数据库连接,进行回收
			} catch (SQLException e) {
				//do nothing
			}
		}
	}
	
	/**
	 * 关闭数据库相关操作
	 * @param close
	 * @since mysql-connection-java-8.0.12
	 */
	public static void closeQuietly(AutoCloseable close){
		if (close!=null) {
			try {
				close.close();//关闭数据库连接,进行回收
			} catch (Exception e) {
				//do nothing
			}
		}
	}

}
