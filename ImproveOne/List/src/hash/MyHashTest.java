package hash;

import java.util.HashMap;

public class MyHashTest {

	public static void main(String[] args) {
//		test();
		test1();
	}
	
	/**
	 * hashCode可以获得存储地址
	 */
	private static void test(){
		Object obj1=new Object();
		System.out.println(obj1.hashCode());
		

		Object obj2=new Object();
		System.out.println(obj2.hashCode());
		
		String str1="abc";
		System.out.println(str1.hashCode());
		
		Person person=new Person();
		System.out.println(person.hashCode());
	}

	
	/**
	 * use HashMap<br>>
	 * "键值对(Key-Value Pair)"类型数据的集合,内部使用哈希算法进行数据的存储和查询<br>>
	 * 键不能重复,值可以重复;<br>>
	 * 特点:数据存储略慢,但查询速度快,理论上查询速度和数据量无关
	 */
	private static void test1(){
		HashMap<String, Object> hashMap=new HashMap<>();
		hashMap.put("广东", "广州");
		hashMap.put("江西", "南昌");
		hashMap.put("山东", "济南");
		System.out.println(hashMap.get("山东"));

		System.out.println(hashMap.get("四川"));
		
		HashMap<String, Object> map2=new HashMap<>();
		map2.put("Tom", 60);
		map2.put("Jerry", 90);
		map2.put("Clerk", 100);
		map2.put("Mike", 80);
		System.out.println(map2.get("Tom"));
		map2.put("Tom", 66);//重复会覆盖原有的值
		System.out.println(map2.get("Tom"));
		map2.remove("Tom");
		System.out.println(map2.get("Tom"));
		
	}

	
	
	
	static class Person{
		private int age;
		private String name;
		private int height;
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		
		
		@Override
		public int hashCode() {
			/*
			 * 同一个对象状态没有改变,hashCode不能改变;
			 * 但不要求两个不同对象的hashCode不能重复,尽量避免两个不同的对象获得同一个hashCode
			 */
//			return super.hashCode();
//			return 3333;
			String  str=age+name+height;
			return str.hashCode();
		}
	}
}
