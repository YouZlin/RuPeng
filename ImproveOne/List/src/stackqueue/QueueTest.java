package stackqueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		test();
	}
	
	/*
	 * Interface Queue:First in First out
	 */
	private static void test() {
		Queue<String>queue=new LinkedList<>();
		//添加进队列
		queue.offer("aaa");
		queue.offer("bbb");
		queue.offer("ccc");
		queue.offer("ddd");
		
		//从队列中取出元素
		String value_1=queue.poll();
		System.out.println(value_1);

		String value_2=queue.poll();
		System.out.println(value_2);

		String value_3=queue.poll();
		System.out.println(value_3);

		String value_4=queue.poll();
		System.out.println(value_4);

		String value_5=queue.poll();
		System.out.println(value_5);//为NULL,队列中以无元素
		
	}
}
