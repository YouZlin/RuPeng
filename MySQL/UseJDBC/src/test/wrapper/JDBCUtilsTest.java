package test.wrapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtilsTest {

	public static void main(String[] args) {
		/*
		try {
			JDBCUtils.executeUpdate("INSERT into t_students(Name,Gander,Hobies)VALUES(?,?,?)", "王强",true,"跑步");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
//		test1();
		
		test2();
	}
	
	static void test1(){
		long start=System.currentTimeMillis();
		Connection conn=null;
		try {
			conn=JDBCUtils.createConnection();
			for (int i = 0; i < 100; i++) {
				JDBCUtils.executeUpdate("INSERT into t_students(Name,Gander,Hobies)VALUES(?,?,?)", "王强",true,"跑步");
			}
			long end=System.currentTimeMillis();
			System.out.println("总耗时:"+(end-start)+"ms");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	
	static void test2(){
		Connection conn=null;
		ResultSet rs=null;
		try {
			conn=JDBCUtils.createConnection();
			rs=JDBCUtils.executeQuery(conn, "SELECT * FROM t_students");
			while(rs.next()){
				String name=rs.getString("Name");
				System.out.println(name);
			}
		} catch (SQLException e) {
		}finally {
			/*
			JDBCUtils.closeResultSetAndStatement(rs);
			JDBCUtils.close(conn);
			*/
			JDBCUtils.closeAll(rs);
		}
		
	}
}
