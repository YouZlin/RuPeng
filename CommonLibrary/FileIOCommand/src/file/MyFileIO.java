package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyFileIO {

	public static void main(String[] args) {
		test();
		
	}
	
	private static void test() {
		try {
			FileOutputStream fos=new FileOutputStream("E:\\1.txt");
//			OutputStream f1=new FileOutputStream("");//另一种构建方法
			//建议能满足需求情况使用创建父类对象
			
			byte[]bytes="abc你好!".getBytes();
			/*
			 * 'a'字母,'1'占一个字节byte
			 * '你'占两个字节
			 */
			byte[]bytes_test="a你!".getBytes();
			System.out.println(bytes_test.length);
			
			fos.write(bytes);
			fos.close();//写完成必须关闭,存在上面代码异常没有执行关闭
		} catch (FileNotFoundException e) {//此处继承IOException,所以不能在IOException之后,否则报错编译不通过
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("写入出错");
		}
	}
	
	private static void test1() {
		FileOutputStream fos=null;//fos声明在外面才能被finally访问到,
		//fos=null,如果不写,那么try中的赋值有不被执行的可能
		try {
			fos=new FileOutputStream("E:\\1.txt");
//			OutputStream f1=new FileOutputStream("");//另一种构建方法
			//建议能满足需求情况使用创建父类对象
			
			byte[]bytes="abc你好!".getBytes();
			/*
			 * 'a'字母,'1'占一个字节byte
			 * '你'占两个字节
			 */
			byte[]bytes_test="a你!".getBytes();
			System.out.println(bytes_test.length);
			
			fos.write(bytes);
			fos.close();//写完成必须关闭,存在上面代码异常没有执行关闭
		} catch (FileNotFoundException e) {//此处继承IOException,所以不能在IOException之后,否则报错编译不通过
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("写入出错");
		} finally{
			//万一fos没有被赋值,那么fos就是null
			if (fos!=null) {//局部变量使用前必须要被初始化
				try {
					fos.close();
				} catch (IOException e) {
					//什么也不做 do nothing
				}
			}
		}
		
	}
	
	
}
