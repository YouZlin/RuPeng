package test;

import java.net.Inet4Address;

public class Test1 {

	public static void main(String[] args) {
		
		test("4556");
		test(3);//在jdk1.4以下不支持
		//int是一个关键字,3不是从Object中继承的
		
		IntWrapper i1=new IntWrapper(3);//把int 3,同Object合并成一个类型,再提取需要的类型
		test(i1);
		
		sysInnerClass();
	}
	
	static void test(Object obj){
		
		
		if (obj instanceof IntWrapper) {//判断obj变量指向的对象是否是IntWrapper类型的
			IntWrapper iw=(IntWrapper) obj;
			System.out.println(iw.getValue());
		}
	}
	
	/**
	 * 系统内置的包装类:<br>
	 * 如:byte->Byte<br>
	 * short->Short<br>
	 * int->Integer<br>
	 * long->Long<br>
	 * float->Float<br>
	 * double->Double<br>
	 * char->Character<br>
	 * boolean->Boolean<br>
	 */
	private static void sysInnerClass() {
		Integer i1=new Integer(3);
		test2(i1);
		
		Integer i2=null;
		int i3=i2;
//		System.out.println(i3);//会报错
		i2=4;
		if (i2!=null) {
			i3=i2;
			System.out.println(i3);
		}
	}
	
	static void test2(Object obj){
		if (obj instanceof Integer) {
			Integer i=(Integer) obj;
			System.out.println(i.intValue());
		}
	}
	
	
	
}
class IntWrapper{
	private int value;
	public IntWrapper(int value) {
		this.value=value;
	}
	public int getValue() {
		return this.value;
	}
}