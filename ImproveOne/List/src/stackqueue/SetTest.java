package stackqueue;

import java.awt.List;
import java.util.HashSet;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		test();
	}
	/**
	 * Set:元素不会重复
	 */
	private static void test() {
//		Set<String> set=new HashSet<String>();
		HashSet<String> hashset=new HashSet<String>();
		hashset.add("aaa");
		hashset.add("ddd");
		hashset.add("bbb");
		hashset.add("aaa");
		hashset.add("ccc");
		
		Object []arr1=hashset.toArray();
		System.out.println(arr1.length);///打印出4,"aaa"重复,只保留一个
		for (int i = 0; i < arr1.length; i++) {
			//输出顺序和输入没有关系
			System.out.println(arr1[i]);
		}
	}

}
