package test;

/**
 * 创建数据库连接参数
 * @author Black
 *
 */
public class JDBCParameter {
	//保护属性不被随意修改
	private static String type="com.mysql.cj.jdbc.Driver";
	//localhost/[数据库名]?useUnicode=[是否使用编码格式]&characterEncoding=[编码格式]&useSSL=[是否使用SSL协议]&serverTimezone=[设置时区]
	private static String driver="jdbc:mysql://localhost/study1?useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=Asia/Shanghai";
	
	
	public static String getType() {
		return type;
	}
//	public static void setType(String type) {
//		JDBCParameter.type = type;
//	}
	public static String getDriver() {
		return driver;
	}
//	public static void setDriver(String driver) {
//		JDBCParameter.driver = driver;
//	}
	
}
