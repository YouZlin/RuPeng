package test;

public class AboutStringBuffer {

	public static void main(String[] args) {

		
		example1();
	}
	
	
	private static void example1(){
		String s="111"+"22222"+"33333";
		//在编译后会被优化成 String s="1112222233333";
		String s1="111";
		String s2="22222";
		String s3="33333";
		String s4=s1+s2+s3;
		//在编译后不会被优化,会影响执行时间
		
		StringBuffer sb=new StringBuffer();
		sb.append(s1);
		sb.append(s2);
		sb.append(s3);
		String s5=sb.toString();//最终转换成一个字符串
		System.err.println(s5);
		
		String s6=sb.append(s1).append(s2).append(s3).toString();
		System.out.println(s6);
		
		//StringBuffer的理解
		Person person=new Person();
		person.speak().eat().speak().sleep();//链式编程
	}
	
	private static class Person{
		public Person speak() {
			System.out.println("说话");
			return this;
		}
		public Person sleep(){
			System.out.println("睡觉");
			return this;
		}
		public Person eat(){
			System.out.println("吃饭");
			return this;
		}
	}

	
	private static void example2(){
		/*
		 * JDK 1.5以后使用
		 * 同StringBuffer的区别,线程安全,但效率略低,常在多线程使用
		 * StringBuilder,非线程安全,但效率提高,在单线程中基本不会有影响
		 */
		StringBuilder sb= new StringBuilder();
		//方式同StringBuffer类似
	}
	
}
