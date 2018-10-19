package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginTest {

	public static void main(String[] args) {
//		login();
		login1();
	}
	
	/*
	 * 执行简单的登录方式
	 */
	public static void login(){
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入用户名");
		String userName=sc.nextLine();
		System.out.println("请输入密码");
		String password=sc.nextLine();
		sc.close();
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
			String sql="SELECT COUNT(*) c FROM t_user WHERE UserName='"+userName+"' AND Password= '"+password+"'";
			/*
			 * 简单的注入漏洞例子
			 * 输入密码:    a' OR 'a'='a 
			 * 获得数据库语句,条件为真
			 * SELECT COUNT(*) c FROM t_user WHERE UserName='abc' AND Password= 'a' OR 'a'='a'
			 * 
			 */
			System.out.println(sql);
			stmt = conn.prepareStatement(sql);
			
			rs=stmt.executeQuery();
			
			rs.next();
			int c=rs.getInt("c");
			System.out.println("数据行数:"+c);
			if (c>0) {
				System.out.println("用户登陆成功");
			}else {
				System.out.println("用户登陆失败");
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
	
	/**
	 * 避免注入式漏洞登录
	 */
	private static void login1(){
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入用户名");
		String userName=sc.nextLine();
		System.out.println("请输入密码");
		String password=sc.nextLine();
		sc.close();
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
			
			/**
			 * 执行参数化查询,避免注入式漏洞
			 */
			String sql="SELECT COUNT(*) c FROM t_user WHERE UserName = ? AND Password = ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, userName);//添加参数从1开始
			stmt.setString(2, password);//只能是数据内容才允许使用?表示参数
			rs=stmt.executeQuery();
			
			rs.next();
			int c=rs.getInt("c");
			System.out.println("数据行数:"+c);
			if (c>0) {
				System.out.println("用户登陆成功");
			}else {
				System.out.println("用户登陆失败");
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
