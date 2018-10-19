package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertSQL {
	static String type="com.mysql.cj.jdbc.Driver";
	//localhost/[数据库名]?useUnicode=[是否使用编码格式]&characterEncoding=[编码格式]&useSSL=[是否使用SSL协议]&serverTimezone=[设置时区]
	static String driver="jdbc:mysql://localhost/study1?useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=Asia/Shanghai";
	
	public static void main(String[] args) {
		insert();
	}
	
	private static void insert() {
		try {
			Class.forName(type);//加载JDBC驱动
		} catch (ClassNotFoundException e) {
			System.out.println("mysql 加载JDBC驱动失败,"+e.getMessage());
		}
		
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=DriverManager.getConnection(driver,"root","123asd123");
			//准备执行数据库语句,返回PreparedStatement对象
			//ID作为PRIMARY KEY ,不允许重复
			stmt = conn.prepareStatement("INSERT INTO t_students(ID,Name,Gander,Hobies)VALUES(2,'王梅梅',0,'唱歌')");
			int lines=stmt .executeUpdate();//返回受影响行数
			System.out.println("执行成功,影响了"+lines+"条数据");
		} catch (SQLException e) {
			System.out.println("操作mysql失败"+e.getMessage());
		}
		finally {
			/*
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					//do nothing
				}
			}
			
			if (conn!=null) {
				try {
					conn.close();//关闭数据库连接,进行回收
				} catch (SQLException e) {
					//do nothing
				}
			}
			*/
			
			//对方法进行封装
			JDBCUtils.closeQuietly(stmt);
			JDBCUtils.closeQuietly(conn);
		}
		
	}

}
