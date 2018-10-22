package te;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 泛型
 */
public class TETest {

	public static void main(String[] args) {
		test();
		test1();
		test2();
		test3();
	}
	
	private static void test() {
		ArrayList list1=new ArrayList();
		list1.add(5);
		list1.add(10);
//		list1.add("8");//会导致运行,类型不符合条件,编译确实成功的
		int s=sum(list1);
		System.out.println(s);
		
		
		ArrayList<Integer>list2=new ArrayList<>();//通过泛型限定传入参数,避免处理过程中复杂的类型转换和排除错误
		list2.add(3);
		list2.add(7);
//		list2.add("6");//此处报错,限制数据类型
		System.out.println(sum(list2));
		
	}
	private static int sum(ArrayList list){
		int result=0;
		for (int i = 0; i < list.size(); i++) {
//			result=(int) list.get(i);//错误的
//			result=(Integer) list.get(i);//对的
			//等价于
			Integer i1=(Integer) list.get(i);
			int value=i1;
		}
		return result;
	}
	
	private static void test1(){
		HashMap map1=new HashMap();
		map1.put("test", 123);
		map1.put("tset", "456");
		
		HashMap<String, Integer> map2=new HashMap<>();
		map2.put("test1", 123);
//		map2.put("test2", "456");//此处报错,不符合需要传入的类型
		map2.get("test1");
		
		HashMap<Integer, Double>map3=new HashMap<>();
		map3.put(3, 3.14);
//		map3.put("aaa", 5.0);//此处报错
		map3.get(3);
		
		MyClass1<String, Integer>m1=new MyClass1<>();
		m1.hello("me", 2333);
//		m1.hello("you", "gogogogo");//此处报错,传入参数类型不符合定义类型
		
		m1.m2(10);
//		m1.m2("abc");//此处报错,传入参数类型不符合定义类型
		
		m1.hi(33, "test1", "test2");
		
	}
	
	
	private static void test2(){
		LinkedList<String >list1=new LinkedList<>();
		list1.add("aaa");
		list1.add("bbb");
//		LinkedList<Object >list2=list1;//错误方式,类型不相同,不能够直接相等,即使是父子类关系
		
		ArrayList list3=new ArrayList<Integer>();
		list3.add(333);
		list3.add(544);
		list3.add("acd");//list对象类型未限定
		
		ArrayList<Integer> list4=new ArrayList();
		list4.add(333);
		list4.add(544);
//		list4.add("acd");//错误,无法进行类型转换,已限定Integer
		
		//HashMap同理
		
	}
	
	private static void test3(){
		ArrayList list1=new ArrayList<Integer>();//new ArrayList<Integer>()在编译后被擦除,只留下new ArrayList<>(),根本没有类型
		list1.add("aaaa");
		list1.add(2333);
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i));
		}
		
		ArrayList<Integer>list2=list1;
		list2.add(666);
//		list2.add("7777");
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}
		
		boolean b1=list2 instanceof ArrayList;
		System.out.println(b1);
//		boolean b2=list2 instanceof ArrayList<Integer>;//instanceof不可以添加泛型参数,编译会出错
	}
	
	
	/**
	 * 进行重载
	 * @param list
	 */
	private void method1(Integer list){
		
	}
	
	/**
	 * 进行重载
	 * @param list
	 */
	private void method1(ArrayList<Integer>list){
		
	}
	//泛型在编译中被擦除,导致两个方法是相同的,重载不能够进行,报错
//	private void method1(ArrayList<String>list){
//		
//	}
	
	/**
	 * 用K和V代替之前的Object<br>
	 * KV可以写一个或者多个,一般是大写表示,但小写不会报错
	 * @param <K> 对于不确定的类型的定义,外部自定义使用的类型<br>
	 * @param <V> 对于不确定的类型的定义,外部自定义使用的类型<br>
	 * 
	 */
	private static class MyClass1<K,V>{
		public void add(K obj){
			
		}
		//Object obj1,Object obj2
		public void hello(K obj1,V obj2){
			
		}
		
		public void m2(V v){
			
		}
		
		public void hi(V v,K k1,K k2){
			
		}
	}

}
