package error;

import javax.management.RuntimeErrorException;

/**
 * 关于捕捉异常
 * @author Black
 *
 */
public class CatchSomething {

	public static void main(String[] args) {
		catchThrowable();
		catchDulThrowable();
	}
	
	/**
	 * 捕捉异常和处理异常
	 */
	static void catchThrowable(){
		
		try {
			
		} catch (Exception e) {
			new Throwable();//报错的根目录类
			new Error();//严重错误无法回复
			new Exception();//可以被处理的异常,如:文件找不到等
		}
		
		Integer i=null;
		try {//将可能发生异常的代码用try包起来
			int i1=1;
			System.out.println("aaa");//try发生异常后.后续的代码将不会执行
			
		} catch (NullPointerException e) {
			/*
			 * catch抓住异常
			 * NullPointerException为要抓住(catch)的异常类型
			 * e为这个异常对象
			 */
			
			//当发生被抓住的异常(如NullPointerException)那么就执行
			System.out.println("i不能为null");
			//如果不发生就不会执行
		}
		System.out.println("bbb");//try之后catch完成后,外部部分将继续执行
	}
	
	/**
	 * 多个异常
	 */
	static void catchDulThrowable(){
		Integer i=null;
		try {//将可能发生异常的代码用try包起来
			int i1=1;
			System.out.println("aaa");//try发生异常后.后续的代码将不会执行
			int[] nums={3,5,6};
			System.out.println(nums[5]);
		} catch (NullPointerException e) {
			/*
			 * catch抓住异常
			 * NullPointerException为要抓住(catch)的异常类型
			 * e为这个异常对象
			 */
			
			//当发生被抓住的异常(如NullPointerException)那么就执行
			System.out.println("i不能为null");
			//如果不发生就不会执行
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("数组范围超过大小!");
		}catch (Exception e) {
			/**
			 * 只要发生异常,所有的Exception的子类都会被catch住
			 */
			System.out.println("发生错误");//强烈不建议这么错,程序要清楚的知道catch的异常是什么
		}
		/*
		 * 1.7以后的方法,也不建议使用
		catch (NullPointerException|ArrayIndexOutOfBoundsException e) {
		}
		*/
		
		
		try {
			if (true) {
				throw new RuntimeException("HeHe");
			}
		} catch (RuntimeException e)  {
			System.out.println("出错了"+e.getMessage());//控制台打印出错误信息
			e.printStackTrace();//将异常堆栈打印在控制台,只是提示出错而没有进行异常的处理
			/**
			 * 一连串的catch,如果先catch的异常的父类,后续就不能catch其子类异常
			 */
//		}catch (NullPointerException e) {
			
//		}catch (ArrayIndexOutOfBoundsException e) {
			
		}
		
		//正确的异常处理是程序的稳定性
		
		//在出现异常最好按不同类别进行处理,除了真的不需要处理的异常
		
	}

	
	
	
}
