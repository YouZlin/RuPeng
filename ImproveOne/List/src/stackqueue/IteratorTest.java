package stackqueue;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {

	public static void main(String[] args) {
		test();
	}

	
	private static void test() {
		ArrayList<Integer> list=new ArrayList<>();
		list.add(3);
		list.add(7);
		list.add(5);
		
		//一个个元素遍历,一般不建议这么写
		Iterable<Integer>it1=list;
		Iterator<Integer>itor1=it1.iterator();
		while (itor1.hasNext()) {
			Integer v=itor1.next();
			System.out.println(v);
		}
		
		//遍历list中的每一个元素,v代表每次遍历的元素值
		for (Integer v : list) {
			//一般在遍历中不要进行该数组的增删
			System.out.println(v);
		}
	}
}
