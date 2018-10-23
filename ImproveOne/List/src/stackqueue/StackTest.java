package stackqueue;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		test();
	}
	
	/**
	 * Stack:Fisrt in Last out
	 */
	private static void test() {
		Stack<Integer>stack=new Stack<>();
		stack.push(3);
		stack.pop();//将数据取出
		stack.peek();//只获取数据
		stack.empty();//判断是否为空
		for (int i = 0; i < stack.size(); i++) {
			System.out.println(stack.peek());
			System.out.println(stack.pop());
		}
	}

}
