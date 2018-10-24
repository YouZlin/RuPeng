package arrays1;

import java.util.Arrays;

public class ArraysTest {

	public static void main(String[] args) {
		int[]values= {1,4,3,7,3,6,8,4,3,6,7};
		test(values);
		Arrays.sort(values);;
		test(values);
	}
	
	private static void test(int[]values) {
		String str=Arrays.toString(values);
		System.out.println(str);
	}
	
	
	
}
