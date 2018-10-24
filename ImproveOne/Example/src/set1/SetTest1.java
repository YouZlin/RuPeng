package set1;

import java.util.HashSet;

public class SetTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[]values= {1,4,3,7,3,6,8,4,3,6,7};
		test(values);
	}
	
	
	/**
	 * get element of no repeat 
	 */
	private static void test(int []values) {
		HashSet<Integer>set =new HashSet<>();
		for (Integer integer : values) {
			set.add(integer);
		}
		for (Integer integer : set) {
			System.out.println("元素有:"+integer);
		}
	}

}
