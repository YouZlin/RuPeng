package object1;

import list1.Person;

public class Object1Test {

	public static void main(String[] args) {
		test();
	}
	
	private static void test() {
		Person person=new Person();
		System.out.println(person.toString());//没有Override,打印出来会是类型@hashcode
		
		
		Person person2=new Person();
		person2.setName("zzz");
		person2.setAge(10);
		person2.setPhone("123123123");
		
		Person person3=new Person();
		person3.setName("zzz");
		person3.setAge(10);
		person3.setPhone("123123123");
		
		System.out.println(person2==person3);//false
		System.out.println(person2.equals(person3));//false
		//复写equals,判断内容相等才可以判断为真,如果进行复写,hashcode要一直
	}

}
