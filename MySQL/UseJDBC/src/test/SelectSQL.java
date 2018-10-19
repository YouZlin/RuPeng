package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectSQL {

	public static void main(String[] args) {
		query();
	}

	private static void query(){
		try {
			Class.forName(JDBCParameter.getType());//加载JDBC驱动
		} catch (ClassNotFoundException e) {
			System.out.println("mysql 加载JDBC驱动失败,"+e.getMessage());
		}
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			conn=DriverManager.getConnection(JDBCParameter.getDriver(),"root","123asd123");
			stmt = conn.prepareStatement("SELECT * FROM t_students");
			rs=stmt.executeQuery();
			while (rs.next()) {
				int id=rs.getInt("ID");
				String Name=rs.getString("Name");
				boolean gender=rs.getBoolean("Gander");
				System.out.println("编号:"+id+",姓名:"+Name+",性别:"+(gender?"男":"女"));
			}
		} catch (SQLException e) {
			System.out.println("操作mysql失败"+e.getMessage());
		}
		finally {
			//对方法进行封装
			JDBCUtils.closeQuietly(rs);
			JDBCUtils.closeQuietly(stmt);
			JDBCUtils.closeQuietly(conn);
		}
	}
}
