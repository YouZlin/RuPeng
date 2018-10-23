package stackqueue;

import java.util.Hashtable;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {

		test();
		test1();
	}

	private static void test() {
		//性能较低,线程安全,几乎不用
		Vector<String> vector=new Vector<>();
		vector.add("abc");
		//当前已有ArrayList等更多新的类
	}
	
	private static void test1() {
		//性能较低,线程安全,几乎不用
		Hashtable<Object, Object> hashtable=new Hashtable<>();
		//当前已有HashMap等更多新的类
	}
	
}
