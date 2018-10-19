package test.wrapper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import com.mysql.cj.jdbc.JdbcPropertySet;

public class JDBCUtils {

	private static final String drivername;
	private static final String dburl;
	private static final String dbusername;
	private static final String dbpassword;
	
	static {
		InputStream in=null;
		try {
			in=JdbcPropertySet.class.getClassLoader().getResourceAsStream("test/wrapper/conn.properties");//根路径
			Properties prop=new Properties();
			prop.load(in);
			drivername=prop.getProperty("drivername");
			dburl=prop.getProperty("dburl");
			dbusername=prop.getProperty("dbusername");
			dbpassword=prop.getProperty("dbpassword");
		} catch (IOException e) {
			//static中不能抛出checkedException<非RuntimeException>
			throw new RuntimeException("加载数据流失败",e);
		}finally {
			if (in!=null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
		try {
			Class.forName(drivername);//加载jdbc驱动,只需要一次
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("加载mysql JDBC驱动失败",e);
		}
	}
	
	
	public static Connection createConnection()throws SQLException{
		return DriverManager.getConnection(dburl,dbusername,dbpassword);
	}
	

	public static int executeUpdate(String sql,Object...params) throws SQLException{
		Connection conn=null;
		try {
				conn=createConnection();
				return executeUpdate(conn, sql, params);
		}
		finally{
			close(conn);
		}
	}
	
	/**
	 * 执行更新
	 * @param conn 数据库连接
	 * @param sql	数据库语句
	 * @param params	查询参数
	 * @return
	 * @throws SQLException
	 */
	public static int executeUpdate(Connection conn,String sql,Object...params) throws SQLException{
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);//循环添加参数
			}
			return ps.executeUpdate();//后续还是会执行finally
//		} catch (SQLException e) {
//			System.out.println("执行出错");//只打印异常,不算处理,这里不知道如何处理,只好抛出
		}finally {
			close(ps);
			//conn可能还有用,这里不进行关闭
		}
	}
	
	
	public static ResultSet executeQuery(String sql,Object...params) throws SQLException{
		Connection conn=createConnection();
		return executeQuery(conn, sql, params);
	}
	
	/**
	 * 执行数据库查询
	 * @param conn 数据库连接
	 * @param sql	数据库语句
	 * @param params	查询参数
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet executeQuery(Connection conn,String sql,Object...params) throws SQLException{
		PreparedStatement ps=null;
		ps=conn.prepareStatement(sql);
		for (int i = 0; i < params.length; i++) {
			ps.setObject(i+1, params[i]);//循环添加参数
		}
		return ps.executeQuery();
		//此处不finally关闭,因为ResultSet需要在外部调用,关闭资源将无法进行访问到ResultSet
	}
	
	
	public static void closeResultSetAndStatement(ResultSet rs){

		Statement stmt=null;
		try {
			stmt=rs.getStatement();
		} catch (SQLException e) {
		}finally {
			close(rs);
			close(stmt);
		}
	}
	
	/**
	 * 关闭数据库结果集
	 * @param rs
	 */
	public static void close(ResultSet rs){
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
	}
	
	/**
	 * 关闭数据库查询过程
	 * @param statement
	 */
	public static void close(Statement statement){
		if (statement!=null) {
			try {
				statement.close();
			} catch (SQLException e) {
			}
		}
	}
	
	/**
	 * 关闭数据库连接
	 * @param conn
	 */
	public static void close(Connection conn){
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	
	public static void closeAll(ResultSet rs){
		Statement stmt=null;
		Connection conn=null;
		try {
			stmt=rs.getStatement();
			conn=stmt.getConnection();
		} catch (SQLException e) {
		}finally {
			close(rs);
			close(stmt);
			close(conn);
		}
		
		
	}
	
}
