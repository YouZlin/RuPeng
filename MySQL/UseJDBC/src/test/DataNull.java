package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataNull {

	public static void main(String[] args) {
		getData();
	}
	
	private static void getData(){
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
				/*
				String s1=null;//String 允许为null,获得null可以直接显示
				int i1=null;//int 不能为null,所以返回0
				booleazn b1;//boolean 不能为nulll,所以返回false
				*/
				/*
				int id=rs.getInt("ID");
				String Name=rs.getString("Name");
				boolean gender=rs.getBoolean("Gander");
				String hobies=rs.getString("Hobies");
				*/
				
				/*
				 * 将int 转成Integer
				 * boolean 转为Boolean
				 * 可以通过getObject强制类型转换成需要的类显示null值
				 */
				int id=rs.getInt("ID");
				String Name=rs.getString("Name");
				Boolean gander=(Boolean)rs.getObject("Gander");
				String hobies=rs.getString("Hobies");
				if (gander==null) {
					System.out.println("性别不知道");
				}else {
					System.out.println("编号:"+id+",姓名:"+Name+",性别:"+(gander?"男":"女")+",爱好:"+hobies);	
				}
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
