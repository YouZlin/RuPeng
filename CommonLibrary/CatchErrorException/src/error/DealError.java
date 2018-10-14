package error;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 开始对异常进行处理
 * @author Black
 *
 */
public class DealError {

	public static void main(String[] args) {
		deal();
		catchError();
		mCatchError();
	}
	
	/**
	 * finally介绍
	 */
	static void  deal(){
		try {
			int[]num={1,2,3};
			System.out.println(num[5]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("数组超出范围");
		}
		finally {//一般进行资源的回收
			//无论是否发生异常都会执行此处代码
			System.out.println("进入finally");
//			final声明变量不能被重新赋值,在类上表示不能被继承,方法上不能被子类@Override
			
			//只有一种情况,断电或者jvm死机,finally才可能不执行
		}
	}
	
	
	/**
	 * 检查异常和非检查异常
	 */
	static void catchError(){
//		RuntimeException和其子类作为非检查异常
//		Exception的子类基本为检查异常
		
		if (true) {
			throw new RuntimeException();
		}
		
		try {
			if (true) {
			throw new IOException();
//				throw new Exception();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		//example 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date=sdf.parse("2008-05-03");//parse可能会抛出ParseException的异常
			System.out.println(date);
//			date=sdf.parse("abcd");//parse可能会抛出ParseException的异常
//			System.out.println(date);
			
			FileInputStream fis=new FileInputStream("D:\\1.txt");
		} catch (ParseException e) {
			System.out.println("解析日期出错");
		} catch (FileNotFoundException e) {
			System.out.println("文件没找到");
		}
		
		//不在方法中catch Exception就在方法中声明抛出
			
	}
	
	static void mCatchError(){
		try {
			test(8);
		} catch (MyException2 e) {
			System.out.println("test抛出错误了");
		}
	}
	
	static void test(int i) throws MyException2{
		if (i<10) {
//			throw new IllegalArgumentException("i错误");
//			throw new MyException1("有点错误");
			
			throw new MyException2("有点错误2");//一般自定义异常自己抛出自己处理
			//抛出异常是通知调用者,调用出错了
		}
	}
	

}
